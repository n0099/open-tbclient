package com.baidu.browser.core.util;

import java.io.InputStream;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class BdZipInputStream extends ZipInputStream {
    public BdZipInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.util.zip.ZipInputStream, java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        byte[] bArr = new byte[(int) Math.min(j, 2048L)];
        while (j2 != j) {
            long j3 = j - j2;
            if (bArr.length <= j3) {
                j3 = bArr.length;
            }
            int read = read(bArr, 0, (int) j3);
            if (read <= 0) {
                return j2;
            }
            j2 += read;
        }
        return j2;
    }
}
