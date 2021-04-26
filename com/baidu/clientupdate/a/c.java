package com.baidu.clientupdate.a;

import com.baidu.util.LogUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f4710a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f4711b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f4712c;

    public c(b bVar, CharSequence charSequence, byte[] bArr) {
        this.f4710a = bVar;
        this.f4712c = null;
        this.f4711b = charSequence;
        this.f4712c = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Exception e2;
        com.baidu.clientupdate.download.a aVar;
        com.baidu.clientupdate.download.a aVar2;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(this.f4711b.toString()).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(this.f4712c.length));
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(this.f4712c, 0, this.f4712c.length);
                    outputStream.close();
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e4) {
            httpURLConnection = null;
            e2 = e4;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            throw th;
        }
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
                aVar2 = this.f4710a.f4709c;
                aVar2.c();
                if (httpURLConnection == null) {
                    return;
                }
                httpURLConnection.disconnect();
            }
            aVar = this.f4710a.f4709c;
        } else {
            LogUtil.logE("LogRequest", "request failed  " + httpURLConnection.getResponseCode());
            aVar = this.f4710a.f4709c;
        }
        aVar.e();
        if (httpURLConnection == null) {
        }
        httpURLConnection.disconnect();
    }
}
