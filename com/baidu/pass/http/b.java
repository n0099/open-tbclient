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
    public static final String a = "HttpStack";
    public static final String b = "Set-Cookie";
    public static final char[] c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public static final String d = "User-Agent";
    public static final int e = 15000;
    public String f = "AgzTBLLDxWSdvY0AbyfzsK8KCwpuSV";
    public boolean g = false;

    private void a() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            char[] cArr = c;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.f = sb.toString();
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
            char[] cArr = c;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        byte[] bytes = ("\r\n--" + this.f + "\r\n").getBytes();
        if (!this.g) {
            this.g = true;
            byteArrayOutputStream.write(("--" + this.f + "\r\n").getBytes());
            return;
        }
        byteArrayOutputStream.write(bytes);
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream, String str, String str2) throws IOException {
        a(byteArrayOutputStream);
        byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
        byteArrayOutputStream.write(str2.getBytes());
    }

    private void a(HttpURLConnection httpURLConnection, int i) {
        int i2;
        if (i == 0) {
            i2 = 15000;
        } else {
            i2 = i;
        }
        httpURLConnection.setConnectTimeout(i2);
        if (i == 0) {
            i = 15000;
        }
        httpURLConnection.setReadTimeout(i);
    }

    private void a(HttpURLConnection httpURLConnection, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
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
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    return null;
                }
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
                throw th;
            }
        }
        bufferedOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            bufferedOutputStream.close();
        } catch (IOException e9) {
            e9.printStackTrace();
        }
        try {
            bufferedInputStream.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        try {
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e11) {
            e11.printStackTrace();
            return byteArray;
        }
    }

    private byte[] a(HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) throws IOException {
        HttpHashMap httpHashMap = passHttpParamDTO.paramsMap;
        if (httpHashMap instanceof MultipartHashMap) {
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.f);
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
            a(byteArrayOutputStream, aVar.a, aVar.b, aVar.d, aVar.c);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } else if (httpHashMap instanceof HttpHashMap) {
            return a(httpHashMap).getBytes("UTF-8");
        } else {
            return null;
        }
    }

    private HttpURLConnection b(PassHttpParamDTO passHttpParamDTO) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(passHttpParamDTO.url).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        return httpURLConnection;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
        if (r2 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0081, code lost:
        if (r2 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0083, code lost:
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PassHttpClientRequest passHttpClientRequest) throws IOException, IllegalArgumentException {
        HttpURLConnection a2;
        byte[] bArr;
        HttpResponseHandler httpResponseHandler;
        if (passHttpClientRequest != null && !passHttpClientRequest.cancelRequest) {
            a();
            int i = a.a[passHttpClientRequest.method.ordinal()];
            OutputStream outputStream = null;
            if (i != 1) {
                if (i == 2) {
                    a2 = b(passHttpClientRequest.paramDTO);
                    bArr = a(a2, passHttpClientRequest.paramDTO);
                } else {
                    throw new IllegalArgumentException(passHttpClientRequest.method + " method not support");
                }
            } else {
                a2 = a(passHttpClientRequest.paramDTO);
                bArr = null;
            }
            a(a2, passHttpClientRequest.paramDTO.connectTimeout);
            a(a2, passHttpClientRequest.paramDTO.userAgent);
            a(a2, passHttpClientRequest.paramDTO.headers);
            d.b(passHttpClientRequest.context, a2, passHttpClientRequest.paramDTO);
            if (bArr != null) {
                try {
                    outputStream = a2.getOutputStream();
                    if (outputStream != null) {
                        outputStream.write(bArr);
                        outputStream.flush();
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
            InputStream inputStream = a2.getInputStream();
            int responseCode = a2.getResponseCode();
            HashMap<String, String> a3 = a(a2);
            byte[] a4 = a(inputStream);
            try {
                inputStream.close();
            } catch (Exception unused3) {
            }
            d.a(passHttpClientRequest.context, a2, passHttpClientRequest.paramDTO);
            if (!passHttpClientRequest.cancelRequest && (httpResponseHandler = passHttpClientRequest.responseHandler) != null) {
                httpResponseHandler.b(responseCode, a3, a4);
            }
        }
    }

    public void a(HttpURLConnection httpURLConnection, String str) {
        if (!TextUtils.isEmpty(str)) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
    }
}
