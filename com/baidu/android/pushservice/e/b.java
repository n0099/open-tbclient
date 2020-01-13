package com.baidu.android.pushservice.e;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.http.Headers;
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
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes6.dex */
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
            httpURLConnection = a(str, str2, (String) null);
            a(str2, hashMap, httpURLConnection);
            aVar = a(httpURLConnection);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        return aVar;
    }

    public static a a(String str, String str2, HashMap<String, String> hashMap, String str3) {
        HttpURLConnection httpURLConnection = null;
        a aVar = new a();
        try {
            httpURLConnection = a(str, str2, str3);
            a(str2, hashMap, httpURLConnection);
            aVar = a(httpURLConnection);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        return aVar;
    }

    private static a a(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream = null;
        a aVar = new a();
        int i = 0;
        try {
            i = httpURLConnection.getResponseCode();
            InputStream errorStream = a(i) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
            try {
                inputStream = new BufferedInputStream(errorStream);
                InputStream gZIPInputStream = b(httpURLConnection) ? new GZIPInputStream(inputStream) : inputStream;
                try {
                    inputStream = new ByteArrayInputStream(a(gZIPInputStream));
                } catch (Exception e) {
                    inputStream = gZIPInputStream;
                }
            } catch (Exception e2) {
                inputStream = errorStream;
            }
        } catch (Exception e3) {
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
                stringBuffer.append(ETAG.ITEM_SEPARATOR);
            }
            String key = next.getKey();
            if (!TextUtils.isEmpty(key)) {
                stringBuffer.append(key).append(ETAG.EQUAL);
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
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                if ("POST".equals(str2) || HttpPut.METHOD_NAME.equals(str2)) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                } else if (HttpDelete.METHOD_NAME.equals(str2)) {
                    httpURLConnection.setDoOutput(true);
                } else if ("GET".equals(str2)) {
                    httpURLConnection.setDoOutput(false);
                }
                httpURLConnection.setRequestMethod(str2);
                httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
                httpURLConnection.setRequestProperty(Headers.ACCEPT_ENCODING, "gzip");
                if (!TextUtils.isEmpty(str3)) {
                    httpURLConnection.setRequestProperty("User-Agent", str3);
                }
                if (httpURLConnection instanceof HttpsURLConnection) {
                }
                httpURLConnection.connect();
                return httpURLConnection;
            } catch (Exception e) {
                return httpURLConnection;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    private static void a(String str, HashMap<String, String> hashMap, HttpURLConnection httpURLConnection) throws IOException {
        if (("POST".equals(str) || HttpPut.METHOD_NAME.equals(str) || HttpDelete.METHOD_NAME.equals(str)) && !a(httpURLConnection, hashMap)) {
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
        DataOutputStream dataOutputStream2;
        OutputStream outputStream2 = null;
        boolean z = (hashMap == null || hashMap.isEmpty()) ? false : true;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                dataOutputStream = new DataOutputStream(outputStream);
            } catch (Exception e) {
                dataOutputStream2 = null;
                outputStream2 = outputStream;
            } catch (Throwable th) {
                th = th;
                dataOutputStream = null;
            }
            try {
                dataOutputStream.write(a(hashMap).getBytes("UTF-8"));
                dataOutputStream.flush();
                a(dataOutputStream, outputStream);
                return z;
            } catch (Exception e2) {
                dataOutputStream2 = dataOutputStream;
                outputStream2 = outputStream;
                a(dataOutputStream2, outputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                a(dataOutputStream, outputStream);
                throw th;
            }
        } catch (Exception e3) {
            dataOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            outputStream = null;
        }
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Exception e) {
                a(byteArrayOutputStream, inputStream);
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
