package com.baidu.android.pushservice.f;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes2.dex */
public class b {
    static {
        if (Build.VERSION.SDK_INT <= 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public static a a(String str, String str2, HashMap<String, String> hashMap) {
        HttpURLConnection httpURLConnection = null;
        a aVar = new a();
        try {
            try {
                httpURLConnection = a(str, str2, (String) null);
                a(str2, hashMap, httpURLConnection);
                aVar = a(httpURLConnection);
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.a("HttpUtil", "execRequest>>", e);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
            return aVar;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    public static a a(String str, String str2, HashMap<String, String> hashMap, String str3) {
        HttpURLConnection httpURLConnection = null;
        a aVar = new a();
        try {
            try {
                httpURLConnection = a(str, str2, str3);
                a(str2, hashMap, httpURLConnection);
                aVar = a(httpURLConnection);
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.a("HttpUtil", "execRequest>>", e);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
            return aVar;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    private static a a(HttpURLConnection httpURLConnection) throws Exception {
        int i;
        InputStream inputStream;
        Exception exc;
        a aVar = new a();
        try {
            i = httpURLConnection.getResponseCode();
            try {
                InputStream errorStream = a(i) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                try {
                    InputStream bufferedInputStream = new BufferedInputStream(errorStream);
                    try {
                        if (b(httpURLConnection)) {
                            bufferedInputStream = new GZIPInputStream(bufferedInputStream);
                        }
                        try {
                            inputStream = new ByteArrayInputStream(a(bufferedInputStream));
                        } catch (Exception e) {
                            inputStream = bufferedInputStream;
                            exc = e;
                            com.baidu.android.pushservice.g.a.a("HttpUtil", "readResponseData>>", exc);
                            aVar.a(i);
                            aVar.a(inputStream);
                            return aVar;
                        }
                    } catch (Exception e2) {
                        inputStream = bufferedInputStream;
                        exc = e2;
                    }
                } catch (Exception e3) {
                    exc = e3;
                    inputStream = errorStream;
                }
            } catch (Exception e4) {
                inputStream = null;
                exc = e4;
            }
        } catch (Exception e5) {
            i = 0;
            inputStream = null;
            exc = e5;
        }
        aVar.a(i);
        aVar.a(inputStream);
        return aVar;
    }

    private static String a(HashMap<String, String> hashMap) throws Exception {
        StringBuffer stringBuffer = new StringBuffer("");
        int i = 0;
        Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return stringBuffer.toString();
            }
            Map.Entry<String, String> next = it.next();
            if (i2 != 0) {
                stringBuffer.append("&");
            }
            String key = next.getKey();
            if (!TextUtils.isEmpty(key)) {
                stringBuffer.append(key).append("=");
                String value = next.getValue();
                if (TextUtils.isEmpty(value)) {
                    stringBuffer.append(URLEncoder.encode("", "UTF-8"));
                } else {
                    stringBuffer.append(URLEncoder.encode(value, "UTF-8"));
                }
            }
            i = i2 + 1;
        }
    }

    private static HttpURLConnection a(String str, String str2, String str3) {
        HttpURLConnection httpURLConnection;
        Exception e;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e2) {
            httpURLConnection = null;
            e = e2;
        }
        try {
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            if ("POST".equals(str2) || "PUT".equals(str2)) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
            } else if ("DELETE".equals(str2)) {
                httpURLConnection.setDoOutput(true);
            } else if ("GET".equals(str2)) {
                httpURLConnection.setDoOutput(false);
            }
            httpURLConnection.setRequestMethod(str2);
            httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (!TextUtils.isEmpty(str3)) {
                httpURLConnection.setRequestProperty("User-Agent", str3);
            }
            if (httpURLConnection instanceof HttpsURLConnection) {
                com.baidu.android.pushservice.g.a.b("HttpUtil", "https request, url=" + str);
            }
            httpURLConnection.connect();
        } catch (Exception e3) {
            e = e3;
            com.baidu.android.pushservice.g.a.a("HttpUtil", "initConnSet>>", e);
            return httpURLConnection;
        }
        return httpURLConnection;
    }

    private static void a(String str, HashMap<String, String> hashMap, HttpURLConnection httpURLConnection) throws IOException {
        if (("POST".equals(str) || "PUT".equals(str) || "DELETE".equals(str)) && !a(httpURLConnection, hashMap)) {
            throw new IOException("failed to writeRequestParams");
        }
    }

    public static void a(Closeable... closeableArr) {
        if (closeableArr != null) {
            try {
                if (closeableArr.length > 0) {
                    for (Closeable closeable : closeableArr) {
                        if (closeable != null) {
                            closeable.close();
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.a("HttpUtil", e);
            }
        }
    }

    private static boolean a(int i) {
        int i2 = i / 100;
        return i2 == 4 || i2 == 5 || i2 == 6;
    }

    private static boolean a(HttpURLConnection httpURLConnection, HashMap<String, String> hashMap) {
        DataOutputStream dataOutputStream;
        OutputStream outputStream;
        OutputStream outputStream2 = null;
        boolean z = (hashMap == null || hashMap.isEmpty()) ? false : true;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                dataOutputStream = new DataOutputStream(outputStream);
                try {
                    dataOutputStream.write(a(hashMap).getBytes("UTF-8"));
                    dataOutputStream.flush();
                    a(dataOutputStream, outputStream);
                    return z;
                } catch (Exception e) {
                    e = e;
                    outputStream2 = outputStream;
                    try {
                        com.baidu.android.pushservice.g.a.a("HttpUtil", "writeRequestParams1>>", e);
                        a(dataOutputStream, outputStream2);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        outputStream = outputStream2;
                        a(dataOutputStream, outputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    a(dataOutputStream, outputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                dataOutputStream = null;
                outputStream2 = outputStream;
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            dataOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
            outputStream = null;
        }
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Exception e) {
                    com.baidu.android.pushservice.g.a.a("HttpUtil", e);
                    a(byteArrayOutputStream, inputStream);
                }
            } catch (Throwable th) {
                a(byteArrayOutputStream, inputStream);
                throw th;
            }
        }
        a(byteArrayOutputStream, inputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static boolean b(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Encoding");
        return !TextUtils.isEmpty(headerField) && headerField.contains("zip");
    }
}
