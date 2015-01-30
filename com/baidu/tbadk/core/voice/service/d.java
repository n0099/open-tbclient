package com.baidu.tbadk.core.voice.service;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
import java.io.File;
import java.io.RandomAccessFile;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d {
    private ad AR;
    private com.baidu.tbadk.coreExtra.data.b OD;
    private boolean OE = false;
    final /* synthetic */ c OF;
    private String mFileName;
    private String mUrl;
    private String mVoiceMd5;

    public d(c cVar, String str, com.baidu.tbadk.coreExtra.data.b bVar, String str2, String str3) {
        this.OF = cVar;
        this.mFileName = null;
        this.mUrl = null;
        this.OD = null;
        this.mVoiceMd5 = null;
        this.mFileName = str;
        this.OD = bVar;
        this.mUrl = str2;
        this.mVoiceMd5 = str3;
    }

    public com.baidu.tbadk.coreExtra.data.c rb() {
        com.baidu.tbadk.coreExtra.data.c cVar = new com.baidu.tbadk.coreExtra.data.c();
        long totalLength = this.OD.getTotalLength();
        long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
        int rH = this.OD.rH();
        if (rH < j) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
            if (randomAccessFile.skipBytes(rH * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < rH * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                cVar.au(false);
                randomAccessFile.close();
                return cVar;
            }
            while (true) {
                int i = rH;
                if (i < j) {
                    int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                    if (i == j - 1) {
                        i2 = (int) (totalLength - (30720 * (j - 1)));
                    }
                    byte[] bArr = new byte[i2];
                    int read = randomAccessFile.read(bArr, 0, i2);
                    if (read != -1) {
                        this.AR = new ad(this.mUrl);
                        this.AR.g("voice_chunk", bArr);
                        this.AR.o("chunk_md5", this.OD.rG());
                        this.AR.o("length", String.valueOf(read));
                        this.AR.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                        this.AR.o("total_length", String.valueOf(totalLength));
                        this.AR.o("chunk_no", String.valueOf(i + 1));
                        this.AR.o("total_num", String.valueOf(j));
                        this.AR.o("voice_md5", this.mVoiceMd5);
                        boolean z = false;
                        if (this.OE) {
                            z = true;
                        } else if (this.AR.oB() == null || !this.AR.oZ().qh().ma()) {
                            this.OD.cz(i);
                            com.baidu.tbadk.core.util.i.a(this.OD);
                            randomAccessFile.close();
                            z = true;
                        }
                        if (z) {
                            cVar.setErrorCode(this.AR.pd());
                            cVar.setErrorString(this.AR.getErrorString());
                            cVar.b(this.OD);
                            cVar.au(false);
                            return cVar;
                        }
                    }
                    rH = i + 1;
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
