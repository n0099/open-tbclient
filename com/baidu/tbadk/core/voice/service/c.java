package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class c {
    private v afT;
    private a afU;
    private com.baidu.tbadk.coreExtra.data.c afV;
    private String afW;
    private String afX;

    public c(String str, String str2) {
        this.afW = str;
        this.afX = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c dE(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.afT = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + this.afW);
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
        com.baidu.tbadk.coreExtra.data.b cE = com.baidu.tbadk.core.util.e.cE(e);
        if (cE == null) {
            cE = new com.baidu.tbadk.coreExtra.data.b();
            cE.dI(e);
            cE.cT(0);
            cE.t(file.length());
        }
        this.afU = new a(str, cE, String.valueOf(TbConfig.SERVER_ADDRESS) + this.afW, e);
        this.afV = this.afU.vW();
        if (this.afV.isSuccess() && (a2 = a(e, cE)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cE.dI(audioInfoData.getVoiceId());
                this.afV.b(cE);
            } else {
                this.afV.setErrorCode(audioInfoData.getErrorCode());
                this.afV.setErrorString(audioInfoData.getErrorUserMsg());
                this.afV.ap(false);
            }
        }
        return this.afV;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.afT = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + this.afX);
        this.afT.o("voice_md5", bVar.wu());
        String tI = this.afT.tI();
        if (tI == null || !this.afT.uj().va().qZ()) {
            bVar.cT((int) s(bVar.getTotalLength()));
            com.baidu.tbadk.core.util.e.a(bVar);
            this.afV.setErrorCode(this.afT.un());
            this.afV.setErrorString(this.afT.getErrorString());
            this.afV.ap(false);
            return null;
        }
        com.baidu.tbadk.core.util.e.cD(str);
        return tI;
    }

    private long s(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private v Tv;
        private com.baidu.tbadk.coreExtra.data.b afY;
        private boolean afZ = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.b bVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.afY = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.afY = bVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.c vW() {
            com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
            long totalLength = this.afY.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int wv = this.afY.wv();
            if (wv < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(wv * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < wv * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    cVar.ap(false);
                    randomAccessFile.close();
                    return cVar;
                }
                while (true) {
                    int i = wv;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.Tv = new v(this.mUrl);
                            this.Tv.d("voice_chunk", bArr);
                            this.Tv.o("chunk_md5", this.afY.wu());
                            this.Tv.o("length", String.valueOf(read));
                            this.Tv.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.Tv.o("total_length", String.valueOf(totalLength));
                            this.Tv.o("chunk_no", String.valueOf(i + 1));
                            this.Tv.o("total_num", String.valueOf(j));
                            this.Tv.o("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.afZ) {
                                z = true;
                            } else if (this.Tv.tL() == null || !this.Tv.uj().va().qZ()) {
                                this.afY.cT(i);
                                com.baidu.tbadk.core.util.e.a(this.afY);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                cVar.setErrorCode(this.Tv.un());
                                cVar.setErrorString(this.Tv.getErrorString());
                                cVar.b(this.afY);
                                cVar.ap(false);
                                return cVar;
                            }
                        }
                        wv = i + 1;
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
