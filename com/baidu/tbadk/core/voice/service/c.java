package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private a anv;
    private com.baidu.tbadk.coreExtra.data.h anw;
    private String anx;
    private String any;
    private List<b> anz = new ArrayList();
    private z mNetwork;

    public c(String str, String str2) {
        this.anx = str;
        this.any = str2;
    }

    public com.baidu.tbadk.coreExtra.data.h dV(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.anx);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.h b(String str, File file) throws IOException {
        String a2;
        String k = t.k(l.n(file));
        if (k != null && k.length() > 0) {
            k = k.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.g cM = com.baidu.tbadk.core.util.c.cM(k);
        if (cM == null) {
            cM = new com.baidu.tbadk.coreExtra.data.g();
            cM.setMd5(k);
            cM.dz(0);
            cM.L(file.length());
        }
        this.anv = new a(str, cM, String.valueOf(TbConfig.SERVER_ADDRESS) + this.anx, k);
        this.anw = this.anv.xr();
        if (this.anw.isSuccess() && (a2 = a(k, cM)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cM.setMd5(audioInfoData.getVoiceId());
                this.anw.b(cM);
            } else {
                this.anw.setErrorCode(audioInfoData.getErrorCode());
                this.anw.setErrorString(audioInfoData.getErrorUserMsg());
                this.anw.aA(false);
            }
        }
        return this.anw;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.g gVar) {
        this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.any);
        this.mNetwork.n("voice_md5", gVar.getMd5());
        if (x.p(this.anz) != 0) {
            for (b bVar : this.anz) {
                if (bVar != null) {
                    this.mNetwork.n(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String uB = this.mNetwork.uB();
        if (uB == null || !this.mNetwork.uZ().vT().isRequestSuccess()) {
            gVar.dz((int) K(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(gVar);
            this.anw.setErrorCode(this.mNetwork.vd());
            this.anw.setErrorString(this.mNetwork.getErrorString());
            this.anw.aA(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.cL(str);
        return uB;
    }

    private long K(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private com.baidu.tbadk.coreExtra.data.g anA;
        private boolean anB = false;
        private String mFileName;
        private z mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.anA = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.anA = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.h xr() throws IOException {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            long totalLength = this.anA.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xV = this.anA.xV();
            if (xV < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xV * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < xV * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    hVar.aA(false);
                    randomAccessFile.close();
                    return hVar;
                }
                while (true) {
                    int i = xV;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.mNetWork = new z(this.mUrl);
                            this.mNetWork.d("voice_chunk", bArr);
                            this.mNetWork.n("chunk_md5", this.anA.getMd5());
                            this.mNetWork.n("length", String.valueOf(read));
                            this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.mNetWork.n("total_length", String.valueOf(totalLength));
                            this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                            this.mNetWork.n("total_num", String.valueOf(j));
                            this.mNetWork.n("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.anB) {
                                z = true;
                            } else if (this.mNetWork.uE() == null || !this.mNetWork.uZ().vT().isRequestSuccess()) {
                                this.anA.dz(i);
                                com.baidu.tbadk.core.util.c.a(this.anA);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                hVar.setErrorCode(this.mNetWork.vd());
                                hVar.setErrorString(this.mNetWork.getErrorString());
                                hVar.b(this.anA);
                                hVar.aA(false);
                                return hVar;
                            }
                        }
                        xV = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            hVar.aA(true);
            return hVar;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void u(String str, int i) {
        this.anz.add(new b(str, String.valueOf(i)));
    }
}
