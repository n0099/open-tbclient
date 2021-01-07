package com.baidu.clientupdate.a;

import com.baidu.util.LogUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f1710a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f1711b;
    private byte[] c;

    public c(b bVar, CharSequence charSequence, byte[] bArr) {
        this.f1710a = bVar;
        this.c = null;
        this.f1711b = charSequence;
        this.c = bArr;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Exception e;
        Throwable th;
        HttpURLConnection httpURLConnection;
        com.baidu.clientupdate.download.a aVar;
        com.baidu.clientupdate.download.a aVar2;
        com.baidu.clientupdate.download.a aVar3;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(this.f1711b.toString()).openConnection();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(this.c.length));
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(this.c, 0, this.c.length);
            outputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                StringBuilder sb = new StringBuilder();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read, "utf-8"));
                }
                inputStream.close();
                LogUtil.logE("LogRequest", "**********strResult:" + sb.toString());
                if (new JSONObject(sb.toString()).getString("retcode").equals("1")) {
                    aVar3 = this.f1710a.c;
                    aVar3.c();
                } else {
                    aVar2 = this.f1710a.c;
                    aVar2.e();
                }
            } else {
                LogUtil.logE("LogRequest", "request failed  " + httpURLConnection.getResponseCode());
                aVar = this.f1710a.c;
                aVar.e();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e3) {
            e = e3;
            httpURLConnection2 = httpURLConnection;
            e.printStackTrace();
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }
}
