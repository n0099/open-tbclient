package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private String aoA;
    private String aoB;
    private List<b> aoC = new ArrayList();
    private a aoy;
    private com.baidu.tbadk.coreExtra.data.h aoz;
    private ab mNetwork;

    public c(String str, String str2) {
        this.aoA = str;
        this.aoB = str2;
    }

    public com.baidu.tbadk.coreExtra.data.h es(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aoA);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.h b(String str, File file) throws IOException {
        String a2;
        String k = t.k(n.q(file));
        if (k != null && k.length() > 0) {
            k = k.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.g dh = com.baidu.tbadk.core.util.c.dh(k);
        if (dh == null) {
            dh = new com.baidu.tbadk.coreExtra.data.g();
            dh.setMd5(k);
            dh.dD(0);
            dh.N(file.length());
        }
        this.aoy = new a(str, dh, String.valueOf(TbConfig.SERVER_ADDRESS) + this.aoA, k);
        this.aoz = this.aoy.xm();
        if (this.aoz.isSuccess() && (a2 = a(k, dh)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                dh.setMd5(audioInfoData.getVoiceId());
                this.aoz.b(dh);
            } else {
                this.aoz.setErrorCode(audioInfoData.getErrorCode());
                this.aoz.setErrorString(audioInfoData.getErrorUserMsg());
                this.aoz.az(false);
            }
        }
        return this.aoz;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.g gVar) {
        this.mNetwork = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aoB);
        this.mNetwork.n("voice_md5", gVar.getMd5());
        if (z.s(this.aoC) != 0) {
            for (b bVar : this.aoC) {
                if (bVar != null) {
                    this.mNetwork.n(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String uy = this.mNetwork.uy();
        if (uy == null || !this.mNetwork.uV().vS().isRequestSuccess()) {
            gVar.dD((int) M(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(gVar);
            this.aoz.setErrorCode(this.mNetwork.uZ());
            this.aoz.setErrorString(this.mNetwork.getErrorString());
            this.aoz.az(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.dg(str);
        return uy;
    }

    private long M(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private com.baidu.tbadk.coreExtra.data.g aoD;
        private boolean aoE = false;
        private String mFileName;
        private ab mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aoD = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aoD = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.h xm() throws IOException {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            long totalLength = this.aoD.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xR = this.aoD.xR();
            if (xR < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xR * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < xR * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    hVar.az(false);
                    randomAccessFile.close();
                    return hVar;
                }
                while (true) {
                    int i = xR;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.mNetWork = new ab(this.mUrl);
                            this.mNetWork.d("voice_chunk", bArr);
                            this.mNetWork.n("chunk_md5", this.aoD.getMd5());
                            this.mNetWork.n("length", String.valueOf(read));
                            this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.mNetWork.n("total_length", String.valueOf(totalLength));
                            this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                            this.mNetWork.n("total_num", String.valueOf(j));
                            this.mNetWork.n("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.aoE) {
                                z = true;
                            } else if (this.mNetWork.uA() == null || !this.mNetWork.uV().vS().isRequestSuccess()) {
                                this.aoD.dD(i);
                                com.baidu.tbadk.core.util.c.a(this.aoD);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                hVar.setErrorCode(this.mNetWork.uZ());
                                hVar.setErrorString(this.mNetWork.getErrorString());
                                hVar.b(this.aoD);
                                hVar.az(false);
                                return hVar;
                            }
                        }
                        xR = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            hVar.az(true);
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
        this.aoC.add(new b(str, String.valueOf(i)));
    }
}
