package com.baidu.tbadk.core.voice.service;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
import java.io.File;
import java.io.RandomAccessFile;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d {
    private ad AO;
    private com.baidu.tbadk.coreExtra.data.b OA;
    private boolean OB = false;
    final /* synthetic */ c OC;
    private String mFileName;
    private String mUrl;
    private String mVoiceMd5;

    public d(c cVar, String str, com.baidu.tbadk.coreExtra.data.b bVar, String str2, String str3) {
        this.OC = cVar;
        this.mFileName = null;
        this.mUrl = null;
        this.OA = null;
        this.mVoiceMd5 = null;
        this.mFileName = str;
        this.OA = bVar;
        this.mUrl = str2;
        this.mVoiceMd5 = str3;
    }

    public com.baidu.tbadk.coreExtra.data.c qV() {
        com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
        long totalLength = this.OA.getTotalLength();
        long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
        int rB = this.OA.rB();
        if (rB < j) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
            if (randomAccessFile.skipBytes(rB * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < rB * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                cVar.au(false);
                randomAccessFile.close();
                return cVar;
            }
            while (true) {
                int i = rB;
                if (i < j) {
                    int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                    if (i == j - 1) {
                        i2 = (int) (totalLength - (30720 * (j - 1)));
                    }
                    byte[] bArr = new byte[i2];
                    int read = randomAccessFile.read(bArr, 0, i2);
                    if (read != -1) {
                        this.AO = new ad(this.mUrl);
                        this.AO.g("voice_chunk", bArr);
                        this.AO.o("chunk_md5", this.OA.rA());
                        this.AO.o("length", String.valueOf(read));
                        this.AO.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                        this.AO.o("total_length", String.valueOf(totalLength));
                        this.AO.o("chunk_no", String.valueOf(i + 1));
                        this.AO.o("total_num", String.valueOf(j));
                        this.AO.o("voice_md5", this.mVoiceMd5);
                        boolean z = false;
                        if (this.OB) {
                            z = true;
                        } else if (this.AO.ou() == null || !this.AO.oS().qa().lT()) {
                            this.OA.cz(i);
                            com.baidu.tbadk.core.util.i.a(this.OA);
                            randomAccessFile.close();
                            z = true;
                        }
                        if (z) {
                            cVar.setErrorCode(this.AO.oW());
                            cVar.setErrorString(this.AO.getErrorString());
                            cVar.b(this.OA);
                            cVar.au(false);
                            return cVar;
                        }
                    }
                    rB = i + 1;
                } else {
                    randomAccessFile.close();
                    break;
                }
            }
        }
        cVar.au(true);
        return cVar;
    }
}
