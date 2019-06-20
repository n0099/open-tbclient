package com.baidu.poly.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes2.dex */
public class d {
    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: java.io.BufferedOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(String str, OutputStream outputStream) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream3 = null;
        try {
            bufferedInputStream = new BufferedInputStream(((HttpURLConnection) new URL(str).openConnection()).getInputStream());
            try {
                bufferedOutputStream = new BufferedOutputStream(outputStream);
            } catch (IOException e) {
                e = e;
                bufferedInputStream2 = null;
                bufferedInputStream3 = bufferedInputStream;
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        com.baidu.poly.util.a.b(bufferedInputStream, bufferedOutputStream);
                        return true;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
            } catch (IOException e2) {
                e = e2;
                bufferedInputStream3 = bufferedInputStream;
                bufferedInputStream2 = bufferedOutputStream;
                try {
                    e.printStackTrace();
                    com.baidu.poly.util.a.b(bufferedInputStream3, bufferedInputStream2);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream3;
                    bufferedInputStream3 = bufferedInputStream2;
                    com.baidu.poly.util.a.b(bufferedInputStream, bufferedInputStream3);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream3 = bufferedOutputStream;
                com.baidu.poly.util.a.b(bufferedInputStream, bufferedInputStream3);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }

    public static Bitmap cK(String str) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(((HttpURLConnection) new URL(str).openConnection()).getInputStream(), 8192);
            try {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream);
                    com.baidu.poly.util.a.b(bufferedInputStream);
                    return decodeStream;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.baidu.poly.util.a.b(bufferedInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
                com.baidu.poly.util.a.b(bufferedInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.poly.util.a.b(bufferedInputStream2);
            throw th;
        }
    }
}
