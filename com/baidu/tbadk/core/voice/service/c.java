package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c {
    private ab agS;
    private a agT;
    private com.baidu.tbadk.coreExtra.data.d agU;
    private String agV;
    private String agW;

    public c(String str, String str2) {
        this.agV = str;
        this.agW = str2;
    }

    public com.baidu.tbadk.coreExtra.data.d dQ(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.agS = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.agV);
            return a(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.d a(String str, File file) {
        String a2;
        String f = t.f(n.o(file));
        if (f != null && f.length() > 0) {
            f = f.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.c cN = com.baidu.tbadk.core.util.e.cN(f);
        if (cN == null) {
            cN = new com.baidu.tbadk.coreExtra.data.c();
            cN.dT(f);
            cN.dj(0);
            cN.F(file.length());
        }
        this.agT = new a(str, cN, String.valueOf(TbConfig.SERVER_ADDRESS) + this.agV, f);
        this.agU = this.agT.wH();
        if (this.agU.isSuccess() && (a2 = a(f, cN)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cN.dT(audioInfoData.getVoiceId());
                this.agU.b(cN);
            } else {
                this.agU.setErrorCode(audioInfoData.getErrorCode());
                this.agU.setErrorString(audioInfoData.getErrorUserMsg());
                this.agU.as(false);
            }
        }
        return this.agU;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.c cVar) {
        this.agS = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.agW);
        this.agS.o("voice_md5", cVar.xb());
        String ul = this.agS.ul();
        if (ul == null || !this.agS.uM().vG().rf()) {
            cVar.dj((int) E(cVar.getTotalLength()));
            com.baidu.tbadk.core.util.e.a(cVar);
            this.agU.setErrorCode(this.agS.uQ());
            this.agU.setErrorString(this.agS.getErrorString());
            this.agU.as(false);
            return null;
        }
        com.baidu.tbadk.core.util.e.cM(str);
        return ul;
    }

    private long E(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private ab Ty;
        private com.baidu.tbadk.coreExtra.data.c agX;
        private boolean agY = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.c cVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.agX = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.agX = cVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.d wH() {
            com.baidu.tbadk.coreExtra.data.d dVar = new com.baidu.tbadk.coreExtra.data.d();
            long totalLength = this.agX.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xc = this.agX.xc();
            if (xc < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xc * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < xc * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    dVar.as(false);
                    randomAccessFile.close();
                    return dVar;
                }
                while (true) {
                    int i = xc;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.Ty = new ab(this.mUrl);
                            this.Ty.d("voice_chunk", bArr);
                            this.Ty.o("chunk_md5", this.agX.xb());
                            this.Ty.o("length", String.valueOf(read));
                            this.Ty.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.Ty.o("total_length", String.valueOf(totalLength));
                            this.Ty.o("chunk_no", String.valueOf(i + 1));
                            this.Ty.o("total_num", String.valueOf(j));
                            this.Ty.o("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.agY) {
                                z = true;
                            } else if (this.Ty.uo() == null || !this.Ty.uM().vG().rf()) {
                                this.agX.dj(i);
                                com.baidu.tbadk.core.util.e.a(this.agX);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                dVar.setErrorCode(this.Ty.uQ());
                                dVar.setErrorString(this.Ty.getErrorString());
                                dVar.b(this.agX);
                                dVar.as(false);
                                return dVar;
                            }
                        }
                        xc = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            dVar.as(true);
            return dVar;
        }
    }
}
