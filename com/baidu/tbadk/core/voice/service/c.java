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
    private w afg;
    private a afh;
    private com.baidu.tbadk.coreExtra.data.c afi;
    private String afj;
    private String afk;

    public c(String str, String str2) {
        this.afj = str;
        this.afk = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c dI(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.afg = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + this.afj);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.c b(String str, File file) {
        String a2;
        String e = t.e(n.o(file));
        if (e != null && e.length() > 0) {
            e = e.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.b cE = com.baidu.tbadk.core.util.e.cE(e);
        if (cE == null) {
            cE = new com.baidu.tbadk.coreExtra.data.b();
            cE.dL(e);
            cE.cU(0);
            cE.A(file.length());
        }
        this.afh = new a(str, cE, String.valueOf(TbConfig.SERVER_ADDRESS) + this.afj, e);
        this.afi = this.afh.vP();
        if (this.afi.isSuccess() && (a2 = a(e, cE)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cE.dL(audioInfoData.getVoiceId());
                this.afi.b(cE);
            } else {
                this.afi.setErrorCode(audioInfoData.getErrorCode());
                this.afi.setErrorString(audioInfoData.getErrorUserMsg());
                this.afi.ap(false);
            }
        }
        return this.afi;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.afg = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + this.afk);
        this.afg.o("voice_md5", bVar.wf());
        String tG = this.afg.tG();
        if (tG == null || !this.afg.uh().uY().qV()) {
            bVar.cU((int) z(bVar.getTotalLength()));
            com.baidu.tbadk.core.util.e.a(bVar);
            this.afi.setErrorCode(this.afg.ul());
            this.afi.setErrorString(this.afg.getErrorString());
            this.afi.ap(false);
            return null;
        }
        com.baidu.tbadk.core.util.e.cD(str);
        return tG;
    }

    private long z(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private w Th;
        private com.baidu.tbadk.coreExtra.data.b afl;
        private boolean afm = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.b bVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.afl = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.afl = bVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.c vP() {
            com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
            long totalLength = this.afl.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int wg = this.afl.wg();
            if (wg < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(wg * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < wg * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    cVar.ap(false);
                    randomAccessFile.close();
                    return cVar;
                }
                while (true) {
                    int i = wg;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.Th = new w(this.mUrl);
                            this.Th.d("voice_chunk", bArr);
                            this.Th.o("chunk_md5", this.afl.wf());
                            this.Th.o("length", String.valueOf(read));
                            this.Th.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.Th.o("total_length", String.valueOf(totalLength));
                            this.Th.o("chunk_no", String.valueOf(i + 1));
                            this.Th.o("total_num", String.valueOf(j));
                            this.Th.o("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.afm) {
                                z = true;
                            } else if (this.Th.tJ() == null || !this.Th.uh().uY().qV()) {
                                this.afl.cU(i);
                                com.baidu.tbadk.core.util.e.a(this.afl);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                cVar.setErrorCode(this.Th.ul());
                                cVar.setErrorString(this.Th.getErrorString());
                                cVar.b(this.afl);
                                cVar.ap(false);
                                return cVar;
                            }
                        }
                        wg = i + 1;
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
