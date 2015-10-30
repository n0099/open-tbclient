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
    private w afh;
    private a afi;
    private com.baidu.tbadk.coreExtra.data.c afj;
    private String afk;
    private String afl;

    public c(String str, String str2) {
        this.afk = str;
        this.afl = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c dI(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.afh = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + this.afk);
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
        this.afi = new a(str, cF, String.valueOf(TbConfig.SERVER_ADDRESS) + this.afk, e);
        this.afj = this.afi.vM();
        if (this.afj.isSuccess() && (a2 = a(e, cF)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cF.dL(audioInfoData.getVoiceId());
                this.afj.b(cF);
            } else {
                this.afj.setErrorCode(audioInfoData.getErrorCode());
                this.afj.setErrorString(audioInfoData.getErrorUserMsg());
                this.afj.ap(false);
            }
        }
        return this.afj;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.afh = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + this.afl);
        this.afh.o("voice_md5", bVar.wc());
        String tD = this.afh.tD();
        if (tD == null || !this.afh.ue().uW().qS()) {
            bVar.cU((int) x(bVar.getTotalLength()));
            com.baidu.tbadk.core.util.e.a(bVar);
            this.afj.setErrorCode(this.afh.ui());
            this.afj.setErrorString(this.afh.getErrorString());
            this.afj.ap(false);
            return null;
        }
        com.baidu.tbadk.core.util.e.cE(str);
        return tD;
    }

    private long x(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private w Ti;
        private com.baidu.tbadk.coreExtra.data.b afm;
        private boolean afn = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.b bVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.afm = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.afm = bVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.c vM() {
            com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
            long totalLength = this.afm.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int wd = this.afm.wd();
            if (wd < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(wd * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < wd * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    cVar.ap(false);
                    randomAccessFile.close();
                    return cVar;
                }
                while (true) {
                    int i = wd;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.Ti = new w(this.mUrl);
                            this.Ti.d("voice_chunk", bArr);
                            this.Ti.o("chunk_md5", this.afm.wc());
                            this.Ti.o("length", String.valueOf(read));
                            this.Ti.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.Ti.o("total_length", String.valueOf(totalLength));
                            this.Ti.o("chunk_no", String.valueOf(i + 1));
                            this.Ti.o("total_num", String.valueOf(j));
                            this.Ti.o("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.afn) {
                                z = true;
                            } else if (this.Ti.tG() == null || !this.Ti.ue().uW().qS()) {
                                this.afm.cU(i);
                                com.baidu.tbadk.core.util.e.a(this.afm);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                cVar.setErrorCode(this.Ti.ui());
                                cVar.setErrorString(this.Ti.getErrorString());
                                cVar.b(this.afm);
                                cVar.ap(false);
                                return cVar;
                            }
                        }
                        wd = i + 1;
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
