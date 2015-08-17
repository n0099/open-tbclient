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
    private v afJ;
    private a afK;
    private com.baidu.tbadk.coreExtra.data.c afL;
    private String afM;
    private String afN;

    public c(String str, String str2) {
        this.afM = str;
        this.afN = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c dx(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.afJ = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + this.afM);
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
        com.baidu.tbadk.coreExtra.data.b cy = com.baidu.tbadk.core.util.e.cy(e);
        if (cy == null) {
            cy = new com.baidu.tbadk.coreExtra.data.b();
            cy.dB(e);
            cy.cN(0);
            cy.s(file.length());
        }
        this.afK = new a(str, cy, String.valueOf(TbConfig.SERVER_ADDRESS) + this.afM, e);
        this.afL = this.afK.vR();
        if (this.afL.isSuccess() && (a2 = a(e, cy)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cy.dB(audioInfoData.getVoiceId());
                this.afL.b(cy);
            } else {
                this.afL.setErrorCode(audioInfoData.getErrorCode());
                this.afL.setErrorString(audioInfoData.getErrorUserMsg());
                this.afL.ap(false);
            }
        }
        return this.afL;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.afJ = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + this.afN);
        this.afJ.o("voice_md5", bVar.wo());
        String tD = this.afJ.tD();
        if (tD == null || !this.afJ.ue().uW().rb()) {
            bVar.cN((int) r(bVar.getTotalLength()));
            com.baidu.tbadk.core.util.e.a(bVar);
            this.afL.setErrorCode(this.afJ.ui());
            this.afL.setErrorString(this.afJ.getErrorString());
            this.afL.ap(false);
            return null;
        }
        com.baidu.tbadk.core.util.e.cx(str);
        return tD;
    }

    private long r(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private v Tu;
        private com.baidu.tbadk.coreExtra.data.b afO;
        private boolean afP = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.b bVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.afO = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.afO = bVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.c vR() {
            com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
            long totalLength = this.afO.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int wp = this.afO.wp();
            if (wp < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(wp * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < wp * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    cVar.ap(false);
                    randomAccessFile.close();
                    return cVar;
                }
                while (true) {
                    int i = wp;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.Tu = new v(this.mUrl);
                            this.Tu.d("voice_chunk", bArr);
                            this.Tu.o("chunk_md5", this.afO.wo());
                            this.Tu.o("length", String.valueOf(read));
                            this.Tu.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.Tu.o("total_length", String.valueOf(totalLength));
                            this.Tu.o("chunk_no", String.valueOf(i + 1));
                            this.Tu.o("total_num", String.valueOf(j));
                            this.Tu.o("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.afP) {
                                z = true;
                            } else if (this.Tu.tG() == null || !this.Tu.ue().uW().rb()) {
                                this.afO.cN(i);
                                com.baidu.tbadk.core.util.e.a(this.afO);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                cVar.setErrorCode(this.Tu.ui());
                                cVar.setErrorString(this.Tu.getErrorString());
                                cVar.b(this.afO);
                                cVar.ap(false);
                                return cVar;
                            }
                        }
                        wp = i + 1;
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
