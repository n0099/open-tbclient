package com.baidu.pass.http;

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
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9184a = "HttpStack";

    /* renamed from: b  reason: collision with root package name */
    public static final String f9185b = "Set-Cookie";

    /* renamed from: c  reason: collision with root package name */
    public static final char[] f9186c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: d  reason: collision with root package name */
    public static final String f9187d = "User-Agent";

    /* renamed from: e  reason: collision with root package name */
    public static final int f9188e = 15000;

    /* renamed from: f  reason: collision with root package name */
    public String f9189f = "AgzTBLLDxWSdvY0AbyfzsK8KCwpuSV";

    /* renamed from: g  reason: collision with root package name */
    public boolean f9190g = false;

    private HttpURLConnection b(PassHttpParamDTO passHttpParamDTO) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(passHttpParamDTO.url).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        return httpURLConnection;
    }

    public void a(PassHttpClientRequest passHttpClientRequest) throws IOException, IllegalArgumentException {
        HttpURLConnection a2;
        HttpResponseHandler httpResponseHandler;
        if (passHttpClientRequest == null || passHttpClientRequest.cancelRequest) {
            return;
        }
        a();
        byte[] bArr = null;
        int i2 = a.f9183a[passHttpClientRequest.method.ordinal()];
        if (i2 == 1) {
            a2 = a(passHttpClientRequest.paramDTO);
        } else if (i2 == 2) {
            HttpURLConnection b2 = b(passHttpClientRequest.paramDTO);
            a2 = b2;
            bArr = a(b2, passHttpClientRequest.paramDTO);
        } else {
            throw new IllegalArgumentException(passHttpClientRequest.method + " method not support");
        }
        a(a2, passHttpClientRequest.paramDTO.connectTimeout);
        a(a2, passHttpClientRequest.paramDTO.userAgent);
        a(a2, passHttpClientRequest.paramDTO.headers);
        d.b(passHttpClientRequest.context, a2, passHttpClientRequest.paramDTO);
        if (bArr != null) {
            OutputStream outputStream = a2.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
        }
        InputStream inputStream = a2.getInputStream();
        int responseCode = a2.getResponseCode();
        HashMap<String, String> a3 = a(a2);
        byte[] a4 = a(inputStream);
        d.a(passHttpClientRequest.context, a2, passHttpClientRequest.paramDTO);
        if (passHttpClientRequest.cancelRequest || (httpResponseHandler = passHttpClientRequest.responseHandler) == null) {
            return;
        }
        httpResponseHandler.b(responseCode, a3, a4);
    }

    private void a(HttpURLConnection httpURLConnection, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public void a(HttpURLConnection httpURLConnection, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        httpURLConnection.setRequestProperty("User-Agent", str);
    }

    private void a(HttpURLConnection httpURLConnection, int i2) {
        httpURLConnection.setConnectTimeout(i2 == 0 ? 15000 : i2);
        if (i2 == 0) {
            i2 = 15000;
        }
        httpURLConnection.setReadTimeout(i2);
    }

    private byte[] a(HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) throws IOException {
        HttpHashMap httpHashMap = passHttpParamDTO.paramsMap;
        if (httpHashMap instanceof MultipartHashMap) {
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.f9189f);
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
            a(byteArrayOutputStream, aVar.f9170a, aVar.f9171b, aVar.f9173d, aVar.f9172c);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } else if (httpHashMap instanceof HttpHashMap) {
            return a(httpHashMap).getBytes("UTF-8");
        } else {
            return null;
        }
    }

    private HttpURLConnection a(PassHttpParamDTO passHttpParamDTO) throws IOException {
        String a2 = a(passHttpParamDTO.paramsMap);
        if (!TextUtils.isEmpty(a2)) {
            passHttpParamDTO.url += "?" + a2;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(passHttpParamDTO.url).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
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

    private HashMap<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap<String, String> hashMap = new HashMap<>();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i2 = 0; i2 < size; i2++) {
            String headerFieldKey = httpURLConnection.getHeaderFieldKey(i2);
            String headerField = httpURLConnection.getHeaderField(i2);
            if ("Set-Cookie".equals(headerFieldKey) && !TextUtils.isEmpty(headerField) && headerField.contains("=")) {
                headerFieldKey = headerField.substring(0, headerField.indexOf("="));
            }
            hashMap.put(headerFieldKey, headerField);
        }
        return hashMap;
    }

    private void a() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i2 = 0; i2 < 30; i2++) {
            char[] cArr = f9186c;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.f9189f = sb.toString();
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i2 = 0; i2 < 30; i2++) {
            char[] cArr = f9186c;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        byte[] bytes = ("\r\n--" + this.f9189f + Part.CRLF).getBytes();
        if (!this.f9190g) {
            this.f9190g = true;
            byteArrayOutputStream.write(("--" + this.f9189f + Part.CRLF).getBytes());
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
                        e.a(e2.getMessage());
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
