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
    private a anO;
    private com.baidu.tbadk.coreExtra.data.h anP;
    private String anQ;
    private String anR;
    private List<b> anS = new ArrayList();
    private z mNetwork;

    public c(String str, String str2) {
        this.anQ = str;
        this.anR = str2;
    }

    public com.baidu.tbadk.coreExtra.data.h ea(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.anQ);
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
        com.baidu.tbadk.coreExtra.data.g cR = com.baidu.tbadk.core.util.c.cR(k);
        if (cR == null) {
            cR = new com.baidu.tbadk.coreExtra.data.g();
            cR.setMd5(k);
            cR.dA(0);
            cR.M(file.length());
        }
        this.anO = new a(str, cR, String.valueOf(TbConfig.SERVER_ADDRESS) + this.anQ, k);
        this.anP = this.anO.xb();
        if (this.anP.isSuccess() && (a2 = a(k, cR)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cR.setMd5(audioInfoData.getVoiceId());
                this.anP.b(cR);
            } else {
                this.anP.setErrorCode(audioInfoData.getErrorCode());
                this.anP.setErrorString(audioInfoData.getErrorUserMsg());
                this.anP.az(false);
            }
        }
        return this.anP;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.g gVar) {
        this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.anR);
        this.mNetwork.n("voice_md5", gVar.getMd5());
        if (x.q(this.anS) != 0) {
            for (b bVar : this.anS) {
                if (bVar != null) {
                    this.mNetwork.n(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String ul = this.mNetwork.ul();
        if (ul == null || !this.mNetwork.uJ().vE().isRequestSuccess()) {
            gVar.dA((int) L(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(gVar);
            this.anP.setErrorCode(this.mNetwork.uN());
            this.anP.setErrorString(this.mNetwork.getErrorString());
            this.anP.az(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.cQ(str);
        return ul;
    }

    private long L(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private com.baidu.tbadk.coreExtra.data.g anT;
        private boolean anU = false;
        private String mFileName;
        private z mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.anT = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.anT = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.h xb() throws IOException {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            long totalLength = this.anT.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xH = this.anT.xH();
            if (xH < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xH * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < xH * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    hVar.az(false);
                    randomAccessFile.close();
                    return hVar;
                }
                while (true) {
                    int i = xH;
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
                            this.mNetWork.n("chunk_md5", this.anT.getMd5());
                            this.mNetWork.n("length", String.valueOf(read));
                            this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.mNetWork.n("total_length", String.valueOf(totalLength));
                            this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                            this.mNetWork.n("total_num", String.valueOf(j));
                            this.mNetWork.n("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.anU) {
                                z = true;
                            } else if (this.mNetWork.uo() == null || !this.mNetWork.uJ().vE().isRequestSuccess()) {
                                this.anT.dA(i);
                                com.baidu.tbadk.core.util.c.a(this.anT);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                hVar.setErrorCode(this.mNetWork.uN());
                                hVar.setErrorString(this.mNetWork.getErrorString());
                                hVar.b(this.anT);
                                hVar.az(false);
                                return hVar;
                            }
                        }
                        xH = i + 1;
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

    public void v(String str, int i) {
        this.anS.add(new b(str, String.valueOf(i)));
    }
}
