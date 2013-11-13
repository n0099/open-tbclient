package com.baidu.android.pushservice.b;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public class g {
    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }
}
