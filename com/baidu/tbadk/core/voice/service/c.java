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
    private ab ahV;
    private a ahW;
    private com.baidu.tbadk.coreExtra.data.d ahX;
    private String ahY;
    private String ahZ;

    public c(String str, String str2) {
        this.ahY = str;
        this.ahZ = str2;
    }

    public com.baidu.tbadk.coreExtra.data.d dT(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.ahV = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.ahY);
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
        com.baidu.tbadk.coreExtra.data.c cQ = com.baidu.tbadk.core.util.e.cQ(f);
        if (cQ == null) {
            cQ = new com.baidu.tbadk.coreExtra.data.c();
            cQ.dW(f);
            cQ.dc(0);
            cQ.G(file.length());
        }
        this.ahW = new a(str, cQ, String.valueOf(TbConfig.SERVER_ADDRESS) + this.ahY, f);
        this.ahX = this.ahW.wq();
        if (this.ahX.isSuccess() && (a2 = a(f, cQ)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cQ.dW(audioInfoData.getVoiceId());
                this.ahX.b(cQ);
            } else {
                this.ahX.setErrorCode(audioInfoData.getErrorCode());
                this.ahX.setErrorString(audioInfoData.getErrorUserMsg());
                this.ahX.ap(false);
            }
        }
        return this.ahX;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.c cVar) {
        this.ahV = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.ahZ);
        this.ahV.o("voice_md5", cVar.wK());
        String tV = this.ahV.tV();
        if (tV == null || !this.ahV.uw().vq().qO()) {
            cVar.dc((int) F(cVar.getTotalLength()));
            com.baidu.tbadk.core.util.e.a(cVar);
            this.ahX.setErrorCode(this.ahV.uA());
            this.ahX.setErrorString(this.ahV.getErrorString());
            this.ahX.ap(false);
            return null;
        }
        com.baidu.tbadk.core.util.e.cP(str);
        return tV;
    }

    private long F(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private ab Ua;
        private com.baidu.tbadk.coreExtra.data.c aia;
        private boolean aib = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.c cVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aia = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aia = cVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.d wq() {
            com.baidu.tbadk.coreExtra.data.d dVar = new com.baidu.tbadk.coreExtra.data.d();
            long totalLength = this.aia.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int wL = this.aia.wL();
            if (wL < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(wL * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < wL * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    dVar.ap(false);
                    randomAccessFile.close();
                    return dVar;
                }
                while (true) {
                    int i = wL;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.Ua = new ab(this.mUrl);
                            this.Ua.d("voice_chunk", bArr);
                            this.Ua.o("chunk_md5", this.aia.wK());
                            this.Ua.o("length", String.valueOf(read));
                            this.Ua.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.Ua.o("total_length", String.valueOf(totalLength));
                            this.Ua.o("chunk_no", String.valueOf(i + 1));
                            this.Ua.o("total_num", String.valueOf(j));
                            this.Ua.o("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.aib) {
                                z = true;
                            } else if (this.Ua.tY() == null || !this.Ua.uw().vq().qO()) {
                                this.aia.dc(i);
                                com.baidu.tbadk.core.util.e.a(this.aia);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                dVar.setErrorCode(this.Ua.uA());
                                dVar.setErrorString(this.Ua.getErrorString());
                                dVar.b(this.aia);
                                dVar.ap(false);
                                return dVar;
                            }
                        }
                        wL = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            dVar.ap(true);
            return dVar;
        }
    }
}
