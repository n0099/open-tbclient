package com.baidu.swan.c;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class f {
    public static String j(InputStream inputStream) {
        byte[] k;
        try {
            k = k(inputStream);
        } catch (Exception e) {
        } finally {
            a.b(inputStream);
        }
        if (k != null) {
            String str = new String(k);
            if (str != null && str.startsWith("\ufeff")) {
                str = str.substring(1);
            }
            return str;
        }
        return null;
    }

    public static byte[] k(InputStream inputStream) {
        int i;
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                i = inputStream.read(bArr, 0, bArr.length);
            } catch (IOException e) {
                i = 0;
            }
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (IOException e2) {
                    return byteArray;
                }
            }
        }
    }
}
