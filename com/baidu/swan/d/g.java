package com.baidu.swan.d;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class g {
    public static String getStringFromInput(InputStream inputStream) {
        byte[] byteFromInputStream;
        try {
            byteFromInputStream = getByteFromInputStream(inputStream);
        } catch (Exception e) {
        } finally {
            c.closeSafely(inputStream);
        }
        if (byteFromInputStream != null) {
            String str = new String(byteFromInputStream);
            if (str != null && str.startsWith("\ufeff")) {
                str = str.substring(1);
            }
            return str;
        }
        return null;
    }

    public static byte[] getByteFromInputStream(InputStream inputStream) {
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
                c.closeSafely(byteArrayOutputStream);
                return byteArray;
            }
        }
    }
}
