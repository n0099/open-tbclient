package com.baidu.poly.a.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes11.dex */
public class d {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [8=4] */
    public static boolean a(String str, OutputStream outputStream) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(((HttpURLConnection) new URL(str).openConnection()).getInputStream());
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(outputStream);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            com.baidu.poly.util.b.a(bufferedInputStream, bufferedOutputStream2);
                            return true;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                } catch (IOException e) {
                    e = e;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        e.printStackTrace();
                        com.baidu.poly.util.b.a(bufferedInputStream, bufferedOutputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.poly.util.b.a(bufferedInputStream, bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                    com.baidu.poly.util.b.a(bufferedInputStream, bufferedOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }

    public static Bitmap eK(String str) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(((HttpURLConnection) new URL(str).openConnection()).getInputStream(), 8192);
            try {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream);
                    com.baidu.poly.util.b.a(bufferedInputStream);
                    return decodeStream;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.baidu.poly.util.b.a(bufferedInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
                com.baidu.poly.util.b.a(bufferedInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.poly.util.b.a(bufferedInputStream2);
            throw th;
        }
    }
}
