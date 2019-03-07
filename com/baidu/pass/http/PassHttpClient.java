package com.baidu.pass.http;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pass.http.MultipartHashMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class PassHttpClient {
    public static final String HTTP_CLIENT_REQUEST_PROPERTY_COOKIE = "Cookie";
    public static final String HTTP_CLIENT_REQUEST_PROPERTY_USER_AGENT = "User-Agent";
    public static final String TAG = "PassHttpClient";
    private static final int a = 15000;
    private static final char[] b = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    protected static final ThreadPoolExecutor sThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    private String c = "AgzTBLLDxWSdvY0AbyfzsK8KCwpuSV";
    private boolean d = false;
    private List<WeakReference<Future<?>>> e;
    private HttpURLConnection f;
    private PassHttpParamDTO g;

    public PassHttpClient() {
        a();
        this.e = new LinkedList();
    }

    public void cancelRequests(boolean z) {
        if (this.e != null) {
            for (WeakReference<Future<?>> weakReference : this.e) {
                Future<?> future = weakReference.get();
                if (future != null) {
                    future.cancel(z);
                }
            }
        }
    }

    public void get(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        try {
            this.g = passHttpParamDTO;
            a(context, passHttpParamDTO);
            String a2 = a(passHttpParamDTO.paramsMap);
            if (!TextUtils.isEmpty(a2)) {
                passHttpParamDTO.url += "?" + a2;
            }
            this.f = (HttpURLConnection) new URL(passHttpParamDTO.url).openConnection();
            this.f.setRequestMethod("GET");
            this.f.setUseCaches(false);
            a(this.f, passHttpParamDTO.connectTimeout);
            setUserAgent(this.f, passHttpParamDTO.userAgent);
            a(context, this.f, null, httpResponseHandler);
        } catch (Exception e) {
            if (httpResponseHandler != null) {
                httpResponseHandler.b(e, e.getMessage());
            }
        }
    }

    public void post(Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        try {
            this.g = passHttpParamDTO;
            a(context, passHttpParamDTO);
            this.f = (HttpURLConnection) new URL(passHttpParamDTO.url).openConnection();
            this.f.setRequestMethod("POST");
            this.f.setDoOutput(true);
            byte[] a2 = a(this.f, passHttpParamDTO);
            a(this.f, passHttpParamDTO.connectTimeout);
            setUserAgent(this.f, passHttpParamDTO.userAgent);
            a(context, this.f, a2, httpResponseHandler);
        } catch (Exception e) {
            if (httpResponseHandler != null) {
                httpResponseHandler.b(e, e.getMessage());
            }
        }
    }

    public PassHttpParamDTO getHttpParamDTO() {
        return this.g;
    }

    private void a(Context context, PassHttpParamDTO passHttpParamDTO) {
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }
        if (passHttpParamDTO == null || TextUtils.isEmpty(passHttpParamDTO.url)) {
            throw new IllegalArgumentException("paramDTO can't be null or paramDTO.url can't be empty");
        }
    }

    public void setUserAgent(HttpURLConnection httpURLConnection, String str) {
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

    private void a(Context context, HttpURLConnection httpURLConnection, byte[] bArr, HttpResponseHandler httpResponseHandler) {
        Future<?> submit = sThreadPool.submit(new a(context, this, httpURLConnection, bArr, httpResponseHandler));
        if (this.e == null) {
            this.e = new LinkedList();
        }
        this.e.add(new WeakReference<>(submit));
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

    private void a() {
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
                        sb.append(URLEncoder.encode((String) entry.getKey(), HTTP.UTF_8)).append("=").append(URLEncoder.encode((String) entry.getValue(), HTTP.UTF_8));
                        sb.append("&");
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
}
