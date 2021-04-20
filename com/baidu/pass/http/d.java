package com.baidu.pass.http;

import android.content.Context;
import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
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
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9314a = "PassHttpClientRequest";

    /* renamed from: b  reason: collision with root package name */
    public static final String f9315b = "Set-Cookie";

    /* renamed from: c  reason: collision with root package name */
    public static final char[] f9316c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: d  reason: collision with root package name */
    public static final String f9317d = "User-Agent";

    /* renamed from: e  reason: collision with root package name */
    public static final int f9318e = 15000;

    /* renamed from: h  reason: collision with root package name */
    public Context f9321h;
    public HttpResponseHandler i;
    public PassHttpParamDTO j;
    public Method k;
    public HttpURLConnection l;
    public Thread m;

    /* renamed from: f  reason: collision with root package name */
    public String f9319f = "AgzTBLLDxWSdvY0AbyfzsK8KCwpuSV";

    /* renamed from: g  reason: collision with root package name */
    public boolean f9320g = false;
    public volatile boolean n = false;
    public volatile boolean o = false;

    public d(Method method, Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        this.k = method;
        this.f9321h = context;
        this.j = passHttpParamDTO;
        this.i = httpResponseHandler;
        c();
    }

    private byte[] a(InputStream inputStream) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
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
                    return null;
                }
            } catch (Throwable th) {
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
                throw th;
            }
        }
        bufferedOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            bufferedOutputStream.close();
        } catch (IOException e7) {
            e7.printStackTrace();
        }
        try {
            bufferedInputStream.close();
            return byteArray;
        } catch (IOException e8) {
            e8.printStackTrace();
            return byteArray;
        }
    }

    private void c() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            char[] cArr = f9316c;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.f9319f = sb.toString();
    }

    private void d() throws IOException, InterruptedException, IllegalArgumentException {
        byte[] bArr;
        int i = c.f9313a[this.k.ordinal()];
        if (i == 1) {
            String a2 = a(this.j.paramsMap);
            if (!TextUtils.isEmpty(a2)) {
                PassHttpParamDTO passHttpParamDTO = this.j;
                passHttpParamDTO.url = this.j.url + "?" + a2;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.j.url).openConnection();
            this.l = httpURLConnection;
            httpURLConnection.setRequestMethod("GET");
            this.l.setUseCaches(false);
            bArr = null;
        } else if (i == 2) {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.j.url).openConnection();
            this.l = httpURLConnection2;
            httpURLConnection2.setRequestMethod("POST");
            this.l.setDoOutput(true);
            bArr = a(this.l, this.j);
        } else {
            throw new IllegalArgumentException(this.k + " method not support");
        }
        a(this.l, this.j.connectTimeout);
        a(this.l, this.j.userAgent);
        a(this.l, this.j.headers);
        e.b(this.f9321h, this.l, this.j);
        if (bArr != null) {
            OutputStream outputStream = this.l.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
        }
        InputStream inputStream = this.l.getInputStream();
        int responseCode = this.l.getResponseCode();
        byte[] a3 = a(inputStream);
        if (a3 != null) {
            f.a(f9314a, "responseBody:" + new String(a3));
        }
        HashMap<String, String> a4 = a(this.l);
        e.a(this.f9321h, this.l, this.j);
        HttpResponseHandler httpResponseHandler = this.i;
        if (httpResponseHandler != null) {
            httpResponseHandler.b(responseCode, a4, a3);
        }
    }

    public synchronized void b() {
        this.o = true;
        if (this.m == null) {
            return;
        }
        while (this.m.isAlive() && !this.n) {
            this.m.interrupt();
            try {
                this.m.join(10L);
            } catch (InterruptedException unused) {
            }
        }
        this.m = null;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.m = Thread.currentThread();
        HttpResponseHandler httpResponseHandler = this.i;
        if (httpResponseHandler != null) {
            httpResponseHandler.b();
        }
        try {
            d();
        } catch (Exception e2) {
            this.n = true;
            if (this.o) {
                return;
            }
            HttpResponseHandler httpResponseHandler2 = this.i;
            if (httpResponseHandler2 != null) {
                httpResponseHandler2.b(e2, e2.getMessage());
            }
        }
        HttpResponseHandler httpResponseHandler3 = this.i;
        if (httpResponseHandler3 != null) {
            httpResponseHandler3.a();
        }
    }

    private HashMap<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap<String, String> hashMap = new HashMap<>();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            String headerFieldKey = httpURLConnection.getHeaderFieldKey(i);
            String headerField = httpURLConnection.getHeaderField(i);
            if ("Set-Cookie".equals(headerFieldKey) && !TextUtils.isEmpty(headerField) && headerField.contains("=")) {
                headerFieldKey = headerField.substring(0, headerField.indexOf("="));
            }
            hashMap.put(headerFieldKey, headerField);
        }
        return hashMap;
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            char[] cArr = f9316c;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        byte[] bytes = ("\r\n--" + this.f9319f + Part.CRLF).getBytes();
        if (!this.f9320g) {
            this.f9320g = true;
            byteArrayOutputStream.write(("--" + this.f9319f + Part.CRLF).getBytes());
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
                StringBuilder sb = new StringBuilder();
                sb.append("Content-Disposition: form-data; name=\"");
                sb.append(str);
                sb.append("\"; filename=\"");
                sb.append(str2);
                sb.append("\"\r\n");
                byteArrayOutputStream.write(sb.toString().getBytes());
                if (str3 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(Part.CONTENT_TYPE);
                    sb2.append(str3);
                    sb2.append("\r\n\r\n");
                    byteArrayOutputStream.write(sb2.toString().getBytes());
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
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return byteArrayOutputStream;
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    private String a(HttpHashMap httpHashMap) {
        StringBuilder sb = new StringBuilder();
        if (httpHashMap != null && httpHashMap.getMap() != null) {
            for (Map.Entry entry : httpHashMap.getMap().entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    try {
                        sb.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                        sb.append("=");
                        sb.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                        sb.append("&");
                    } catch (UnsupportedEncodingException e2) {
                        f.a(e2.getMessage());
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(sb)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public HttpURLConnection a() {
        return this.l;
    }

    public void a(HttpURLConnection httpURLConnection, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        httpURLConnection.setRequestProperty("User-Agent", str);
    }

    private void a(HttpURLConnection httpURLConnection, int i) {
        if (i != 0) {
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i);
            return;
        }
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
    }

    private void a(HttpURLConnection httpURLConnection, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    private byte[] a(HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) throws IOException {
        HttpHashMap httpHashMap = passHttpParamDTO.paramsMap;
        if (httpHashMap instanceof MultipartHashMap) {
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.f9319f);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            HttpHashMap httpHashMap2 = passHttpParamDTO.paramsMap;
            if (httpHashMap2 != null) {
                for (Map.Entry entry : httpHashMap2.getMap().entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                        a(byteArrayOutputStream, URLEncoder.encode((String) entry.getKey(), "UTF-8"), URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                    }
                }
            }
            MultipartHashMap.a aVar = ((MultipartHashMap) passHttpParamDTO.paramsMap).fileWrapper;
            a(byteArrayOutputStream, aVar.f9304a, aVar.f9305b, aVar.f9307d, aVar.f9306c);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } else if (httpHashMap instanceof HttpHashMap) {
            return a(httpHashMap).getBytes("UTF-8");
        } else {
            return null;
        }
    }
}
