package com.baidu.location.h;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.entity.mime.MIME;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends Thread {
    final /* synthetic */ f QA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.QA = fVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HttpURLConnection httpURLConnection;
        this.QA.h = i.c();
        this.QA.b();
        this.QA.a();
        HttpURLConnection httpURLConnection2 = null;
        int i = this.QA.i;
        while (true) {
            if (i <= 0) {
                break;
            }
            try {
                httpURLConnection = (HttpURLConnection) new URL(this.QA.h).openConnection();
                try {
                    try {
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setConnectTimeout(b.b);
                        httpURLConnection.setReadTimeout(b.b);
                        httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=utf-8");
                        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                    } catch (Throwable th) {
                        httpURLConnection2 = httpURLConnection;
                        th = th;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e) {
                    Log.d(b.a, "NetworkCommunicationException!");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    i--;
                    httpURLConnection2 = httpURLConnection;
                }
            } catch (Exception e2) {
                httpURLConnection = httpURLConnection2;
            } catch (Throwable th2) {
                th = th2;
            }
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                inputStream.close();
                byteArrayOutputStream.close();
                this.QA.j = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                this.QA.a(true);
                httpURLConnection.disconnect();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } else {
                httpURLConnection.disconnect();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                i--;
                httpURLConnection2 = httpURLConnection;
            }
        }
        if (i > 0) {
            f.o = 0;
            return;
        }
        f.o++;
        this.QA.j = null;
        this.QA.a(false);
    }
}
