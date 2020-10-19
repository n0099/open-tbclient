package com.baidu.platform.comapi.walknavi.d.a.d.a;

import com.baidu.platform.comapi.walknavi.d.a.d.a.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes7.dex */
public class b {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [65=4] */
    public static boolean a(String str, File file, c.b bVar) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        r1 = null;
        InputStream inputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                inputStream = httpURLConnection.getInputStream();
            } catch (IOException e) {
            } catch (Throwable th) {
                inputStream = null;
                httpURLConnection2 = httpURLConnection;
                th = th;
            }
            try {
                c.a(inputStream, file, httpURLConnection.getContentLength(), bVar);
                c.a(inputStream);
                a(httpURLConnection);
                return true;
            } catch (IOException e2) {
                inputStream2 = inputStream;
                c.a(inputStream2);
                a(httpURLConnection);
                return false;
            } catch (Throwable th2) {
                httpURLConnection2 = httpURLConnection;
                th = th2;
                c.a(inputStream);
                a(httpURLConnection2);
                throw th;
            }
        } catch (IOException e3) {
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    private static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
