package com.baidu.location.h;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.apache.http.entity.mime.MIME;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Thread {
    final /* synthetic */ f PV;
    final /* synthetic */ boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar, boolean z) {
        this.PV = fVar;
        this.a = z;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HttpURLConnection httpURLConnection;
        this.PV.h = i.c();
        this.PV.b();
        this.PV.a();
        HttpURLConnection httpURLConnection2 = null;
        int i = this.PV.i;
        while (true) {
            if (i <= 0) {
                break;
            }
            try {
                URL url = new URL(this.PV.h);
                StringBuffer stringBuffer = new StringBuffer();
                for (Map.Entry<String, Object> entry : this.PV.PG.entrySet()) {
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                    stringBuffer.append("&");
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    try {
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setConnectTimeout(b.b);
                        httpURLConnection.setReadTimeout(b.b);
                        httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=utf-8");
                        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                        httpURLConnection.setRequestProperty("Host", "loc.map.baidu.com");
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(stringBuffer.toString().getBytes());
                        outputStream.flush();
                        outputStream.close();
                    } catch (Throwable th) {
                        httpURLConnection2 = httpURLConnection;
                        th = th;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (Error e) {
                    Log.d(b.a, "NetworkCommunicationError!");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    httpURLConnection2 = httpURLConnection;
                    i--;
                } catch (Exception e2) {
                    Log.d(b.a, "NetworkCommunicationException!");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    httpURLConnection2 = httpURLConnection;
                    i--;
                }
            } catch (Error e3) {
                httpURLConnection = httpURLConnection2;
            } catch (Exception e4) {
                httpURLConnection = httpURLConnection2;
            } catch (Throwable th2) {
                th = th2;
            }
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                InputStream gZIPInputStream = (contentEncoding == null || !contentEncoding.contains("gzip")) ? inputStream : new GZIPInputStream(new BufferedInputStream(inputStream));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                this.PV.j = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                if (this.a) {
                    this.PV.m = byteArrayOutputStream.toByteArray();
                }
                this.PV.a(true);
                httpURLConnection.disconnect();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } else {
                httpURLConnection.disconnect();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                httpURLConnection2 = httpURLConnection;
                i--;
            }
        }
        if (i > 0) {
            f.o = 0;
            return;
        }
        f.o++;
        this.PV.j = null;
        this.PV.a(false);
    }
}
