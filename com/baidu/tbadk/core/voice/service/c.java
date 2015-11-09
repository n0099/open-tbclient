package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c {
    private w afm;
    private a afn;
    private com.baidu.tbadk.coreExtra.data.c afo;
    private String afp;
    private String afq;

    public c(String str, String str2) {
        this.afp = str;
        this.afq = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c dI(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.afm = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + this.afp);
            return a(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.c a(String str, File file) {
        String a2;
        String e = t.e(n.o(file));
        if (e != null && e.length() > 0) {
            e = e.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.b cF = com.baidu.tbadk.core.util.e.cF(e);
        if (cF == null) {
            cF = new com.baidu.tbadk.coreExtra.data.b();
            cF.dL(e);
            cF.cU(0);
            cF.y(file.length());
        }
        this.afn = new a(str, cF, String.valueOf(TbConfig.SERVER_ADDRESS) + this.afp, e);
        this.afo = this.afn.vQ();
        if (this.afo.isSuccess() && (a2 = a(e, cF)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cF.dL(audioInfoData.getVoiceId());
                this.afo.b(cF);
            } else {
                this.afo.setErrorCode(audioInfoData.getErrorCode());
                this.afo.setErrorString(audioInfoData.getErrorUserMsg());
                this.afo.ap(false);
            }
        }
        return this.afo;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.afm = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + this.afq);
        this.afm.o("voice_md5", bVar.wh());
        String tG = this.afm.tG();
        if (tG == null || !this.afm.uh().va().qT()) {
            bVar.cU((int) x(bVar.getTotalLength()));
            com.baidu.tbadk.core.util.e.a(bVar);
            this.afo.setErrorCode(this.afm.ul());
            this.afo.setErrorString(this.afm.getErrorString());
            this.afo.ap(false);
            return null;
        }
        com.baidu.tbadk.core.util.e.cE(str);
        return tG;
    }

    private long x(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private w Tj;
        private com.baidu.tbadk.coreExtra.data.b afr;
        private boolean afs = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.b bVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.afr = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.afr = bVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.c vQ() {
            com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
            long totalLength = this.afr.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int wi = this.afr.wi();
            if (wi < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(wi * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < wi * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    cVar.ap(false);
                    randomAccessFile.close();
                    return cVar;
                }
                while (true) {
                    int i = wi;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.Tj = new w(this.mUrl);
                            this.Tj.d("voice_chunk", bArr);
                            this.Tj.o("chunk_md5", this.afr.wh());
                            this.Tj.o("length", String.valueOf(read));
                            this.Tj.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.Tj.o("total_length", String.valueOf(totalLength));
                            this.Tj.o("chunk_no", String.valueOf(i + 1));
                            this.Tj.o("total_num", String.valueOf(j));
                            this.Tj.o("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.afs) {
                                z = true;
                            } else if (this.Tj.tJ() == null || !this.Tj.uh().va().qT()) {
                                this.afr.cU(i);
                                com.baidu.tbadk.core.util.e.a(this.afr);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                cVar.setErrorCode(this.Tj.ul());
                                cVar.setErrorString(this.Tj.getErrorString());
                                cVar.b(this.afr);
                                cVar.ap(false);
                                return cVar;
                            }
                        }
                        wi = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            cVar.ap(true);
            return cVar;
        }
    }
}
