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
    private String anA;
    private String anB;
    private List<b> anC = new ArrayList();
    private a any;
    private com.baidu.tbadk.coreExtra.data.h anz;
    private z mNetwork;

    public c(String str, String str2) {
        this.anA = str;
        this.anB = str2;
    }

    public com.baidu.tbadk.coreExtra.data.h dY(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.anA);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.h b(String str, File file) throws IOException {
        String a2;
        String k = t.k(l.o(file));
        if (k != null && k.length() > 0) {
            k = k.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.g cO = com.baidu.tbadk.core.util.c.cO(k);
        if (cO == null) {
            cO = new com.baidu.tbadk.coreExtra.data.g();
            cO.setMd5(k);
            cO.dB(0);
            cO.M(file.length());
        }
        this.any = new a(str, cO, String.valueOf(TbConfig.SERVER_ADDRESS) + this.anA, k);
        this.anz = this.any.wU();
        if (this.anz.isSuccess() && (a2 = a(k, cO)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cO.setMd5(audioInfoData.getVoiceId());
                this.anz.b(cO);
            } else {
                this.anz.setErrorCode(audioInfoData.getErrorCode());
                this.anz.setErrorString(audioInfoData.getErrorUserMsg());
                this.anz.ay(false);
            }
        }
        return this.anz;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.g gVar) {
        this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.anB);
        this.mNetwork.n("voice_md5", gVar.getMd5());
        if (x.q(this.anC) != 0) {
            for (b bVar : this.anC) {
                if (bVar != null) {
                    this.mNetwork.n(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String ug = this.mNetwork.ug();
        if (ug == null || !this.mNetwork.uF().vB().isRequestSuccess()) {
            gVar.dB((int) L(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(gVar);
            this.anz.setErrorCode(this.mNetwork.uJ());
            this.anz.setErrorString(this.mNetwork.getErrorString());
            this.anz.ay(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.cN(str);
        return ug;
    }

    private long L(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private com.baidu.tbadk.coreExtra.data.g anD;
        private boolean anE = false;
        private String mFileName;
        private z mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.anD = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.anD = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.h wU() throws IOException {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            long totalLength = this.anD.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xA = this.anD.xA();
            if (xA < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xA * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < xA * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    hVar.ay(false);
                    randomAccessFile.close();
                    return hVar;
                }
                while (true) {
                    int i = xA;
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
                            this.mNetWork.n("chunk_md5", this.anD.getMd5());
                            this.mNetWork.n("length", String.valueOf(read));
                            this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.mNetWork.n("total_length", String.valueOf(totalLength));
                            this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                            this.mNetWork.n("total_num", String.valueOf(j));
                            this.mNetWork.n("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.anE) {
                                z = true;
                            } else if (this.mNetWork.uk() == null || !this.mNetWork.uF().vB().isRequestSuccess()) {
                                this.anD.dB(i);
                                com.baidu.tbadk.core.util.c.a(this.anD);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                hVar.setErrorCode(this.mNetWork.uJ());
                                hVar.setErrorString(this.mNetWork.getErrorString());
                                hVar.b(this.anD);
                                hVar.ay(false);
                                return hVar;
                            }
                        }
                        xA = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            hVar.ay(true);
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
        this.anC.add(new b(str, String.valueOf(i)));
    }
}
