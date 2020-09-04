package com.baidu.swan.c;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes8.dex */
public class g {
    public static String getStringFromInput(InputStream inputStream) {
        byte[] byteFromInputStream;
        try {
            byteFromInputStream = getByteFromInputStream(inputStream);
        } catch (Exception e) {
        } finally {
            d.closeSafely(inputStream);
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
                d.closeSafely(byteArrayOutputStream);
                return byteArray;
            }
        }
    }

    public static String dr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
