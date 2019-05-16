package com.baidu.pass.http;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements Runnable {
    public static final String a = "PassHttpClientRequest";
    public static final String b = "https://";
    private Context c;
    private PassHttpClient d;
    private HttpURLConnection e;
    private HttpResponseHandler f;
    private byte[] g;

    public a(Context context, PassHttpClient passHttpClient, HttpURLConnection httpURLConnection, byte[] bArr, HttpResponseHandler httpResponseHandler) {
        this.c = context;
        this.d = passHttpClient;
        this.e = httpURLConnection;
        this.g = bArr;
        this.f = httpResponseHandler;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f != null) {
            this.f.a();
        }
        try {
            a();
        } catch (Exception e) {
            this.f.a(e, e.getMessage());
        }
        if (this.f != null) {
            this.f.b();
        }
    }

    private void a() throws IOException, InterruptedException {
        if (!Thread.currentThread().isInterrupted()) {
            b.a(this.c, this.e, this.d.getHttpParamDTO());
            if (this.g != null) {
                OutputStream outputStream = this.e.getOutputStream();
                outputStream.write(this.g);
                outputStream.flush();
                outputStream.close();
            }
            InputStream inputStream = this.e.getInputStream();
            int responseCode = this.e.getResponseCode();
            byte[] a2 = a(inputStream);
            if (a2 != null) {
                c.a(a, "responseBody:" + new String(a2));
            }
            Map<String, List<String>> headerFields = this.e.getHeaderFields();
            b.b(this.c, this.e, this.d.getHttpParamDTO());
            if (!Thread.currentThread().isInterrupted()) {
                if (this.f != null) {
                    this.f.c(responseCode, headerFields, a2);
                    return;
                }
                return;
            }
            throw new InterruptedException("the request has been cancelled");
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    private byte[] a(InputStream inputStream) {
        byte[] bArr = null;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        byte[] bArr2 = new byte[8192];
        while (true) {
            try {
                try {
                    int read = bufferedInputStream.read(bArr2);
                    if (read <= 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr2, 0, read);
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } finally {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
        }
        bufferedOutputStream.flush();
        bArr = byteArrayOutputStream.toByteArray();
        return bArr;
    }

    private String a(HttpURLConnection httpURLConnection) {
        int size = httpURLConnection.getHeaderFields().size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            String headerFieldKey = httpURLConnection.getHeaderFieldKey(i);
            String headerField = httpURLConnection.getHeaderField(i);
            sb.append(headerFieldKey);
            sb.append(":");
            sb.append(headerField);
            sb.append("\n");
        }
        return sb.toString();
    }
}
