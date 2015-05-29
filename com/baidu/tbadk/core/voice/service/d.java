package com.baidu.tbadk.core.voice.service;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
class d {
    private aa OE;
    private com.baidu.tbadk.coreExtra.data.b aaL;
    private boolean aaM = false;
    final /* synthetic */ c aaN;
    private String mFileName;
    private String mUrl;
    private String mVoiceMd5;

    public d(c cVar, String str, com.baidu.tbadk.coreExtra.data.b bVar, String str2, String str3) {
        this.aaN = cVar;
        this.mFileName = null;
        this.mUrl = null;
        this.aaL = null;
        this.mVoiceMd5 = null;
        this.mFileName = str;
        this.aaL = bVar;
        this.mUrl = str2;
        this.mVoiceMd5 = str3;
    }

    public com.baidu.tbadk.coreExtra.data.c uN() {
        com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
        long totalLength = this.aaL.getTotalLength();
        long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
        int vh = this.aaL.vh();
        if (vh < j) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
            if (randomAccessFile.skipBytes(vh * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < vh * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                cVar.al(false);
                randomAccessFile.close();
                return cVar;
            }
            while (true) {
                int i = vh;
                if (i < j) {
                    int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                    if (i == j - 1) {
                        i2 = (int) (totalLength - (30720 * (j - 1)));
                    }
                    byte[] bArr = new byte[i2];
                    int read = randomAccessFile.read(bArr, 0, i2);
                    if (read != -1) {
                        this.OE = new aa(this.mUrl);
                        this.OE.d("voice_chunk", bArr);
                        this.OE.o("chunk_md5", this.aaL.vg());
                        this.OE.o("length", String.valueOf(read));
                        this.OE.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                        this.OE.o("total_length", String.valueOf(totalLength));
                        this.OE.o("chunk_no", String.valueOf(i + 1));
                        this.OE.o("total_num", String.valueOf(j));
                        this.OE.o("voice_md5", this.mVoiceMd5);
                        boolean z = false;
                        if (this.aaM) {
                            z = true;
                        } else if (this.OE.sz() == null || !this.OE.sX().tT().qa()) {
                            this.aaL.cD(i);
                            com.baidu.tbadk.core.util.e.a(this.aaL);
                            randomAccessFile.close();
                            z = true;
                        }
                        if (z) {
                            cVar.setErrorCode(this.OE.tb());
                            cVar.setErrorString(this.OE.getErrorString());
                            cVar.b(this.aaL);
                            cVar.al(false);
                            return cVar;
                        }
                    }
                    vh = i + 1;
                } else {
                    randomAccessFile.close();
                    break;
                }
            }
        }
        cVar.al(true);
        return cVar;
    }
}
