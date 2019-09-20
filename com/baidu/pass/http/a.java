package com.baidu.pass.http;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pass.http.MultipartHashMap;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.apache.http.protocol.HTTP;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a implements Runnable {
    private static final String a = "PassHttpClientRequest";
    private static final char[] b = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final String e = "User-Agent";
    private static final int f = 15000;
    private Context g;
    private HttpResponseHandler h;
    private PassHttpParamDTO i;
    private Method j;
    private HttpURLConnection k;
    private Thread l;
    private String c = "AgzTBLLDxWSdvY0AbyfzsK8KCwpuSV";
    private boolean d = false;
    private volatile boolean m = false;
    private volatile boolean n = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Method method, Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        this.j = method;
        this.g = context;
        this.i = passHttpParamDTO;
        this.h = httpResponseHandler;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        this.n = true;
        if (this.l != null) {
            while (this.l.isAlive() && !this.m) {
                this.l.interrupt();
                try {
                    this.l.join(10L);
                } catch (InterruptedException e2) {
                }
            }
            this.l = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.l = Thread.currentThread();
        if (this.h != null) {
            this.h.a();
        }
        try {
            c();
        } catch (Exception e2) {
            this.m = true;
            if (!this.n) {
                if (this.h != null) {
                    this.h.a(e2, e2.getMessage());
                }
            } else {
                return;
            }
        }
        if (this.h != null) {
            this.h.b();
        }
    }

    private void c() throws IOException, InterruptedException, IllegalArgumentException {
        byte[] a2;
        switch (this.j) {
            case GET:
                String a3 = a(this.i.paramsMap);
                if (!TextUtils.isEmpty(a3)) {
                    this.i.url += "?" + a3;
                }
                this.k = (HttpURLConnection) new URL(this.i.url).openConnection();
                this.k.setRequestMethod("GET");
                this.k.setUseCaches(false);
                a2 = null;
                break;
            case POST:
                this.k = (HttpURLConnection) new URL(this.i.url).openConnection();
                this.k.setRequestMethod("POST");
                this.k.setDoOutput(true);
                a2 = a(this.k, this.i);
                break;
            default:
                throw new IllegalArgumentException(this.j + " method not support");
        }
        a(this.k, this.i.connectTimeout);
        a(this.k, this.i.userAgent);
        a(this.k, this.i.headers);
        b.a(this.g, this.k, this.i);
        if (a2 != null) {
            OutputStream outputStream = this.k.getOutputStream();
            outputStream.write(a2);
            outputStream.flush();
            outputStream.close();
        }
        InputStream inputStream = this.k.getInputStream();
        int responseCode = this.k.getResponseCode();
        byte[] a4 = a(inputStream);
        if (a4 != null) {
            c.a(a, "responseBody:" + new String(a4));
        }
        HashMap<String, String> a5 = a(this.k);
        b.b(this.g, this.k, this.i);
        if (this.h != null) {
            this.h.c(responseCode, a5, a4);
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
                } catch (IOException e2) {
                    e2.printStackTrace();
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } finally {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
        }
        bufferedOutputStream.flush();
        bArr = byteArrayOutputStream.toByteArray();
        return bArr;
    }

    private HashMap<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap<String, String> hashMap = new HashMap<>();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            hashMap.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return hashMap;
    }

    private void d() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            sb.append(b[random.nextInt(b.length)]);
        }
        this.c = sb.toString();
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            sb.append(b[random.nextInt(b.length)]);
        }
        byte[] bytes = ("\r\n--" + this.c + "\r\n").getBytes();
        if (!this.d) {
            this.d = true;
            byteArrayOutputStream.write(("--" + this.c + "\r\n").getBytes());
            return;
        }
        byteArrayOutputStream.write(bytes);
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream, String str, String str2) throws IOException {
        a(byteArrayOutputStream);
        byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
        byteArrayOutputStream.write(str2.getBytes());
    }

    private ByteArrayOutputStream a(ByteArrayOutputStream byteArrayOutputStream, String str, String str2, InputStream inputStream, String str3) throws IOException {
        try {
            try {
                a(byteArrayOutputStream);
                byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
                if (str3 != null) {
                    byteArrayOutputStream.write(("Content-Type: " + str3 + "\r\n\r\n").getBytes());
                } else {
                    byteArrayOutputStream.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
                }
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            } catch (IOException e2) {
                throw e2;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    private String a(HttpHashMap httpHashMap) {
        StringBuilder sb = new StringBuilder();
        if (httpHashMap != null && httpHashMap.getMap() != null) {
            for (Map.Entry entry : httpHashMap.getMap().entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    try {
                        sb.append(URLEncoder.encode((String) entry.getKey(), HTTP.UTF_8)).append("=").append(URLEncoder.encode((String) entry.getValue(), HTTP.UTF_8));
                        sb.append("&");
                    } catch (UnsupportedEncodingException e2) {
                        c.a(e2.getMessage());
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(sb)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public HttpURLConnection b() {
        return this.k;
    }

    public void a(HttpURLConnection httpURLConnection, String str) {
        if (!TextUtils.isEmpty(str)) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
    }

    private void a(HttpURLConnection httpURLConnection, int i) {
        if (i != 0) {
            httpURLConnection.setConnectTimeout(i);
        } else {
            httpURLConnection.setConnectTimeout(15000);
        }
    }

    private void a(HttpURLConnection httpURLConnection, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    private byte[] a(HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) throws IOException {
        if (passHttpParamDTO.paramsMap instanceof MultipartHashMap) {
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.c);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (passHttpParamDTO.paramsMap != null) {
                for (Map.Entry entry : passHttpParamDTO.paramsMap.getMap().entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                        a(byteArrayOutputStream, URLEncoder.encode((String) entry.getKey(), HTTP.UTF_8), URLEncoder.encode((String) entry.getValue(), HTTP.UTF_8));
                    }
                }
            }
            MultipartHashMap.a aVar = ((MultipartHashMap) passHttpParamDTO.paramsMap).fileWrapper;
            a(byteArrayOutputStream, aVar.a, aVar.b, aVar.d, aVar.c);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } else if (passHttpParamDTO.paramsMap instanceof HttpHashMap) {
            return a(passHttpParamDTO.paramsMap).getBytes(HTTP.UTF_8);
        } else {
            return null;
        }
    }
}
