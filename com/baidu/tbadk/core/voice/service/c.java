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
    private a anJ;
    private com.baidu.tbadk.coreExtra.data.h anK;
    private String anL;
    private String anM;
    private List<b> anN = new ArrayList();
    private z mNetwork;

    public c(String str, String str2) {
        this.anL = str;
        this.anM = str2;
    }

    public com.baidu.tbadk.coreExtra.data.h eb(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.anL);
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
        com.baidu.tbadk.coreExtra.data.g cT = com.baidu.tbadk.core.util.c.cT(k);
        if (cT == null) {
            cT = new com.baidu.tbadk.coreExtra.data.g();
            cT.setMd5(k);
            cT.dC(0);
            cT.L(file.length());
        }
        this.anJ = new a(str, cT, String.valueOf(TbConfig.SERVER_ADDRESS) + this.anL, k);
        this.anK = this.anJ.xN();
        if (this.anK.isSuccess() && (a2 = a(k, cT)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cT.setMd5(audioInfoData.getVoiceId());
                this.anK.b(cT);
            } else {
                this.anK.setErrorCode(audioInfoData.getErrorCode());
                this.anK.setErrorString(audioInfoData.getErrorUserMsg());
                this.anK.aC(false);
            }
        }
        return this.anK;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.g gVar) {
        this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.anM);
        this.mNetwork.n("voice_md5", gVar.getMd5());
        if (x.p(this.anN) != 0) {
            for (b bVar : this.anN) {
                if (bVar != null) {
                    this.mNetwork.n(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String uY = this.mNetwork.uY();
        if (uY == null || !this.mNetwork.vw().wq().isRequestSuccess()) {
            gVar.dC((int) K(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(gVar);
            this.anK.setErrorCode(this.mNetwork.vA());
            this.anK.setErrorString(this.mNetwork.getErrorString());
            this.anK.aC(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.cS(str);
        return uY;
    }

    private long K(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private com.baidu.tbadk.coreExtra.data.g anO;
        private boolean anP = false;
        private String mFileName;
        private z mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.anO = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.anO = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.h xN() throws IOException {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            long totalLength = this.anO.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int yt = this.anO.yt();
            if (yt < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(yt * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < yt * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    hVar.aC(false);
                    randomAccessFile.close();
                    return hVar;
                }
                while (true) {
                    int i = yt;
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
                            this.mNetWork.n("chunk_md5", this.anO.getMd5());
                            this.mNetWork.n("length", String.valueOf(read));
                            this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.mNetWork.n("total_length", String.valueOf(totalLength));
                            this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                            this.mNetWork.n("total_num", String.valueOf(j));
                            this.mNetWork.n("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.anP) {
                                z = true;
                            } else if (this.mNetWork.vb() == null || !this.mNetWork.vw().wq().isRequestSuccess()) {
                                this.anO.dC(i);
                                com.baidu.tbadk.core.util.c.a(this.anO);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                hVar.setErrorCode(this.mNetWork.vA());
                                hVar.setErrorString(this.mNetWork.getErrorString());
                                hVar.b(this.anO);
                                hVar.aC(false);
                                return hVar;
                            }
                        }
                        yt = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            hVar.aC(true);
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

    public void v(String str, int i) {
        this.anN.add(new b(str, String.valueOf(i)));
    }
}
