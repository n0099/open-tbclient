package com.baidu.searchbox.dns.d.c;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes2.dex */
public abstract class a<T> {
    public int aj = 0;
    public boolean ak = false;
    public int al = w();

    private T O() {
        HttpURLConnection httpURLConnection;
        if (!this.ak) {
            HttpURLConnection httpURLConnection2 = null;
            String url = getUrl();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " sendRequest url:" + url);
            }
            try {
                if (!TextUtils.isEmpty(url)) {
                    try {
                        if (!v()) {
                            httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
                        } else {
                            httpURLConnection = (HttpsURLConnection) new URL(url).openConnection();
                        }
                        httpURLConnection2 = httpURLConnection;
                        httpURLConnection2.setRequestProperty("Charsert", "UTF-8");
                        httpURLConnection2.setConnectTimeout(30000);
                        httpURLConnection2.setReadTimeout(30000);
                        a(httpURLConnection2);
                        httpURLConnection2.connect();
                        b(httpURLConnection2);
                        c(httpURLConnection2);
                        return m(d(httpURLConnection2));
                    } catch (Exception e2) {
                        throw new com.baidu.searchbox.dns.d.c.a.a(e2.getMessage());
                    }
                }
                throw new com.baidu.searchbox.dns.d.c.a.b("url is empty");
            } finally {
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            }
        }
        throw new com.baidu.searchbox.dns.d.c.a.b(10002, "request canceled");
    }

    public String N() {
        StringBuffer stringBuffer = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("1.0");
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str2 = Build.MODEL;
            if (str2.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str2);
            }
        }
        String str3 = Build.ID;
        if (str3.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str3);
        }
        return String.format("Mozilla/5.0 (Linux; Android %s) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30", stringBuffer);
    }

    public abstract void a(Exception exc);

    public void a(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        httpURLConnection.setRequestProperty("User-Agent", N());
    }

    public abstract void b(HttpURLConnection httpURLConnection);

    public String c(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String obj = entry.getValue().toString();
            try {
                sb.append(entry.getKey() + "=" + URLEncoder.encode(obj, "UTF-8"));
                sb.append("&");
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public abstract void c(int i);

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0059 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: java.io.BufferedReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader;
        InputStream inputStream;
        BufferedReader bufferedReader2;
        InputStream inputStream2 = null;
        try {
            String contentEncoding = httpURLConnection.getContentEncoding();
            inputStream = httpURLConnection.getInputStream();
            try {
                try {
                    if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.equals(AsyncHttpClient.ENCODING_GZIP)) {
                        inputStream = new GZIPInputStream(inputStream);
                    }
                    bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = inputStream2;
            }
        } catch (Exception e3) {
            e = e3;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader2.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(new String(readLine.getBytes("utf-8"), "utf-8"));
            }
            String stringBuffer2 = stringBuffer.toString();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            try {
                bufferedReader2.close();
            } catch (IOException e7) {
                e7.printStackTrace();
            }
            return stringBuffer2;
        } catch (Exception e8) {
            e = e8;
            inputStream2 = bufferedReader2;
            throw new com.baidu.searchbox.dns.d.c.a.b(e.getMessage());
        } catch (Throwable th3) {
            th = th3;
            inputStream2 = inputStream;
            bufferedReader = bufferedReader2;
            if (inputStream2 != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    public boolean d(int i) {
        return 403 == i || 404 == i;
    }

    public abstract Map<String, Object> getParameters();

    public abstract String getUrl();

    public abstract T m(String str);

    public boolean v() {
        return false;
    }

    public int w() {
        return 2;
    }

    public T x() {
        this.aj = 0;
        while (this.aj <= this.al) {
            try {
                try {
                    return O();
                } catch (com.baidu.searchbox.dns.d.c.a.a e2) {
                    a(e2);
                }
            } catch (com.baidu.searchbox.dns.d.c.a.b e3) {
                if (e3.P() == 10001) {
                    c(e3.Q());
                    return null;
                }
                a(e3);
                return null;
            }
        }
        return null;
    }

    public void a(com.baidu.searchbox.dns.d.c.a.a aVar) {
        int i = this.aj + 1;
        this.aj = i;
        if (i <= this.al) {
            SystemClock.sleep(5000L);
        } else if (aVar.P() == 10001) {
            throw new com.baidu.searchbox.dns.d.c.a.b(aVar.P(), aVar.Q(), " retry count reach fail ");
        } else {
            throw new com.baidu.searchbox.dns.d.c.a.b(" retry count reach fail ");
        }
    }

    public void c(HttpURLConnection httpURLConnection) {
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                String str = " http response error -> " + responseCode;
                if (d(responseCode)) {
                    throw new com.baidu.searchbox.dns.d.c.a.b(10001, responseCode, str);
                }
                throw new com.baidu.searchbox.dns.d.c.a.a(10001, responseCode, str);
            }
        } catch (IOException e2) {
            throw new com.baidu.searchbox.dns.d.c.a.a(e2.getMessage());
        }
    }
}
