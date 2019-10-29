package com.baidu.swan.pms.a;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import okio.BufferedSource;
/* loaded from: classes2.dex */
public abstract class c<T> implements a<T> {
    @Override // com.baidu.swan.pms.a.a
    public void E(T t) {
    }

    @Override // com.baidu.swan.pms.a.a
    public void D(T t) {
    }

    @Override // com.baidu.swan.pms.a.a
    public void P(T t) {
    }

    @Override // com.baidu.swan.pms.a.a
    public void C(T t) {
    }

    @Override // com.baidu.swan.pms.a.a
    public void a(T t, com.baidu.swan.pms.model.a aVar) {
    }

    @Override // com.baidu.swan.pms.a.a
    public void R(T t) {
    }

    @Override // com.baidu.swan.pms.a.a
    public boolean a(T t, BufferedSource bufferedSource, File file, long j) throws IOException {
        InputStream newInputStream = Channels.newInputStream(bufferedSource);
        byte[] bArr = new byte[g.a(this, "swan_pms_buffer").getInt("swan_pms_buffer", 64)];
        int length = bArr.length;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int i = 0;
        int i2 = length;
        long j2 = 0;
        while (i != -1) {
            if (j > 0) {
                if (j2 < j) {
                    if (i2 + j2 > j) {
                        i2 = (int) (j - j2);
                    }
                }
            }
            i = newInputStream.read(bArr, 0, i2);
            if (i > 0) {
                fileOutputStream.write(bArr, 0, i);
                j2 += i;
            }
        }
        try {
            fileOutputStream.close();
        } catch (Exception e) {
        }
        return j2 == j;
    }
}
