package com.baidu.platform.comapi.walknavi.d.a.d.a;

import com.baidu.platform.comapi.walknavi.d.a.d.a.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes6.dex */
public class b {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [65=4] */
    public static boolean a(String str, File file, c.b bVar) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream2;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                inputStream2 = httpURLConnection2.getInputStream();
                try {
                    c.a(inputStream2, file, httpURLConnection2.getContentLength(), bVar);
                    c.a(inputStream2);
                    a(httpURLConnection2);
                    return true;
                } catch (IOException e) {
                    c.a(inputStream2);
                    a(httpURLConnection2);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    inputStream = inputStream2;
                    c.a(inputStream);
                    a(httpURLConnection);
                    throw th;
                }
            } catch (IOException e2) {
                inputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            }
        } catch (IOException e3) {
            httpURLConnection2 = null;
            inputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    private static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
