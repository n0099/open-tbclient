package com.baidu.tbadk.core.voice.service;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import java.io.File;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
class d {
    private aa Ok;
    private com.baidu.tbadk.coreExtra.data.b ZK;
    private boolean ZL = false;
    final /* synthetic */ c ZM;
    private String mFileName;
    private String mUrl;
    private String mVoiceMd5;

    public d(c cVar, String str, com.baidu.tbadk.coreExtra.data.b bVar, String str2, String str3) {
        this.ZM = cVar;
        this.mFileName = null;
        this.mUrl = null;
        this.ZK = null;
        this.mVoiceMd5 = null;
        this.mFileName = str;
        this.ZK = bVar;
        this.mUrl = str2;
        this.mVoiceMd5 = str3;
    }

    public com.baidu.tbadk.coreExtra.data.c ue() {
        com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
        long totalLength = this.ZK.getTotalLength();
        long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
        int uy = this.ZK.uy();
        if (uy < j) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
            if (randomAccessFile.skipBytes(uy * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < uy * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                cVar.af(false);
                randomAccessFile.close();
                return cVar;
            }
            while (true) {
                int i = uy;
                if (i < j) {
                    int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                    if (i == j - 1) {
                        i2 = (int) (totalLength - (30720 * (j - 1)));
                    }
                    byte[] bArr = new byte[i2];
                    int read = randomAccessFile.read(bArr, 0, i2);
                    if (read != -1) {
                        this.Ok = new aa(this.mUrl);
                        this.Ok.g("voice_chunk", bArr);
                        this.Ok.o("chunk_md5", this.ZK.ux());
                        this.Ok.o("length", String.valueOf(read));
                        this.Ok.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                        this.Ok.o("total_length", String.valueOf(totalLength));
                        this.Ok.o("chunk_no", String.valueOf(i + 1));
                        this.Ok.o("total_num", String.valueOf(j));
                        this.Ok.o("voice_md5", this.mVoiceMd5);
                        boolean z = false;
                        if (this.ZL) {
                            z = true;
                        } else if (this.Ok.rR() == null || !this.Ok.sp().tq().pv()) {
                            this.ZK.cy(i);
                            com.baidu.tbadk.core.util.e.a(this.ZK);
                            randomAccessFile.close();
                            z = true;
                        }
                        if (z) {
                            cVar.setErrorCode(this.Ok.st());
                            cVar.setErrorString(this.Ok.getErrorString());
                            cVar.b(this.ZK);
                            cVar.af(false);
                            return cVar;
                        }
                    }
                    uy = i + 1;
                } else {
                    randomAccessFile.close();
                    break;
                }
            }
        }
        cVar.af(true);
        return cVar;
    }
}
