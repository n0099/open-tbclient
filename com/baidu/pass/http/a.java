package com.baidu.pass.http;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pass.http.MultipartHashMap;
import com.baidu.webkit.internal.ETAG;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class a implements Runnable {
    private static final String a = "PassHttpClientRequest";
    private static final String b = "Set-Cookie";
    private static final char[] c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final String f = "User-Agent";
    private static final int g = 15000;
    private Context h;
    private HttpResponseHandler i;
    private PassHttpParamDTO j;
    private Method k;
    private HttpURLConnection l;
    private Thread m;
    private String d = "AgzTBLLDxWSdvY0AbyfzsK8KCwpuSV";
    private boolean e = false;
    private volatile boolean n = false;
    private volatile boolean o = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Method method, Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        this.k = method;
        this.h = context;
        this.j = passHttpParamDTO;
        this.i = httpResponseHandler;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        this.o = true;
        if (this.m != null) {
            while (this.m.isAlive() && !this.n) {
                this.m.interrupt();
                try {
                    this.m.join(10L);
                } catch (InterruptedException e) {
                }
            }
            this.m = null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.m = Thread.currentThread();
        if (this.i != null) {
            this.i.a();
        }
        try {
            c();
        } catch (Exception e) {
            this.n = true;
            if (!this.o) {
                if (this.i != null) {
                    this.i.a(e, e.getMessage());
                }
            } else {
                return;
            }
        }
        if (this.i != null) {
            this.i.b();
        }
    }

    private void c() throws IOException, InterruptedException, IllegalArgumentException {
        byte[] a2;
        switch (this.k) {
            case GET:
                String a3 = a(this.j.paramsMap);
                if (!TextUtils.isEmpty(a3)) {
                    this.j.url += "?" + a3;
                }
                this.l = (HttpURLConnection) new URL(this.j.url).openConnection();
                this.l.setRequestMethod("GET");
                this.l.setUseCaches(false);
                a2 = null;
                break;
            case POST:
                this.l = (HttpURLConnection) new URL(this.j.url).openConnection();
                this.l.setRequestMethod("POST");
                this.l.setDoOutput(true);
                a2 = a(this.l, this.j);
                break;
            default:
                throw new IllegalArgumentException(this.k + " method not support");
        }
        a(this.l, this.j.connectTimeout);
        a(this.l, this.j.userAgent);
        a(this.l, this.j.headers);
        b.a(this.h, this.l, this.j);
        if (a2 != null) {
            OutputStream outputStream = this.l.getOutputStream();
            outputStream.write(a2);
            outputStream.flush();
            outputStream.close();
        }
        InputStream inputStream = this.l.getInputStream();
        int responseCode = this.l.getResponseCode();
        byte[] a4 = a(inputStream);
        if (a4 != null) {
            c.a(a, "responseBody:" + new String(a4));
        }
        HashMap<String, String> a5 = a(this.l);
        b.b(this.h, this.l, this.j);
        if (this.i != null) {
            this.i.c(responseCode, a5, a4);
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

    private HashMap<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap<String, String> hashMap = new HashMap<>();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            String headerFieldKey = httpURLConnection.getHeaderFieldKey(i);
            String headerField = httpURLConnection.getHeaderField(i);
            if ("Set-Cookie".equals(headerFieldKey) && !TextUtils.isEmpty(headerField) && headerField.contains(ETAG.EQUAL)) {
                headerFieldKey = headerField.substring(0, headerField.indexOf(ETAG.EQUAL));
            }
            hashMap.put(headerFieldKey, headerField);
        }
        return hashMap;
    }

    private void d() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            sb.append(c[random.nextInt(c.length)]);
        }
        this.d = sb.toString();
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            sb.append(c[random.nextInt(c.length)]);
        }
        byte[] bytes = ("\r\n--" + this.d + "\r\n").getBytes();
        if (!this.e) {
            this.e = true;
            byteArrayOutputStream.write(("--" + this.d + "\r\n").getBytes());
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
            } catch (IOException e) {
                throw e;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private String a(HttpHashMap httpHashMap) {
        StringBuilder sb = new StringBuilder();
        if (httpHashMap != null && httpHashMap.getMap() != null) {
            for (Map.Entry entry : httpHashMap.getMap().entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    try {
                        sb.append(URLEncoder.encode((String) entry.getKey(), "UTF-8")).append(ETAG.EQUAL).append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                        sb.append(ETAG.ITEM_SEPARATOR);
                    } catch (UnsupportedEncodingException e) {
                        c.a(e.getMessage());
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
        return this.l;
    }

    public void a(HttpURLConnection httpURLConnection, String str) {
        if (!TextUtils.isEmpty(str)) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
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
        if (passHttpParamDTO.paramsMap instanceof MultipartHashMap) {
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.d);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (passHttpParamDTO.paramsMap != null) {
                for (Map.Entry entry : passHttpParamDTO.paramsMap.getMap().entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                        a(byteArrayOutputStream, URLEncoder.encode((String) entry.getKey(), "UTF-8"), URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                    }
                }
            }
            MultipartHashMap.a aVar = ((MultipartHashMap) passHttpParamDTO.paramsMap).fileWrapper;
            a(byteArrayOutputStream, aVar.a, aVar.b, aVar.d, aVar.c);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } else if (passHttpParamDTO.paramsMap instanceof HttpHashMap) {
            return a(passHttpParamDTO.paramsMap).getBytes("UTF-8");
        } else {
            return null;
        }
    }
}
