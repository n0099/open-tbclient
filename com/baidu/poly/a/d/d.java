package com.baidu.poly.a.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes3.dex */
public class d {
    public static boolean a(String str, OutputStream outputStream) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        try {
            bufferedInputStream = new BufferedInputStream(((HttpURLConnection) new URL(str).openConnection()).getInputStream());
        } catch (IOException e) {
            e = e;
            bufferedInputStream = null;
            bufferedOutputStream2 = null;
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
            bufferedOutputStream = null;
        }
        try {
            bufferedOutputStream2 = new BufferedOutputStream(outputStream);
            try {
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            com.baidu.poly.util.c.a(bufferedInputStream, bufferedOutputStream2);
                            return true;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    com.baidu.poly.util.c.a(bufferedInputStream, bufferedOutputStream2);
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                com.baidu.poly.util.c.a(bufferedInputStream, bufferedOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            com.baidu.poly.util.c.a(bufferedInputStream, bufferedOutputStream);
            throw th;
        }
    }

    public static Bitmap jS(String str) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(((HttpURLConnection) new URL(str).openConnection()).getInputStream(), 8192);
            try {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream);
                    com.baidu.poly.util.c.a(bufferedInputStream);
                    return decodeStream;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.baidu.poly.util.c.a(bufferedInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
                com.baidu.poly.util.c.a(bufferedInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.poly.util.c.a(bufferedInputStream2);
            throw th;
        }
    }
}
