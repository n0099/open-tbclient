package com.baidu.searchbox.dns.d.c;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.webkit.internal.ETAG;
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
/* loaded from: classes13.dex */
public abstract class a<T> {
    protected int aj = 0;
    private boolean ak = false;
    protected int al = w();

    protected abstract void a(Exception exc);

    protected abstract void b(HttpURLConnection httpURLConnection);

    protected abstract void c(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Map<String, Object> getParameters();

    protected abstract String getUrl();

    protected abstract T m(String str);

    protected int w() {
        return 2;
    }

    protected boolean v() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        httpURLConnection.setRequestProperty("User-Agent", N());
    }

    protected String N() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                sb.append(entry.getKey() + ETAG.EQUAL + URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
                sb.append(ETAG.ITEM_SEPARATOR);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private T O() {
        if (!this.ak) {
            HttpsURLConnection httpsURLConnection = null;
            String url = getUrl();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " sendRequest url:" + url);
            }
            try {
                if (!TextUtils.isEmpty(url)) {
                    try {
                        if (!v()) {
                            httpsURLConnection = (HttpURLConnection) new URL(url).openConnection();
                        } else {
                            httpsURLConnection = (HttpsURLConnection) new URL(url).openConnection();
                        }
                        httpsURLConnection.setRequestProperty("Charsert", "UTF-8");
                        httpsURLConnection.setConnectTimeout(30000);
                        httpsURLConnection.setReadTimeout(30000);
                        a(httpsURLConnection);
                        httpsURLConnection.connect();
                        b(httpsURLConnection);
                        c(httpsURLConnection);
                        return m(d(httpsURLConnection));
                    } catch (Exception e) {
                        throw new com.baidu.searchbox.dns.d.c.a.a(e.getMessage());
                    }
                }
                throw new com.baidu.searchbox.dns.d.c.a.b("url is empty");
            } finally {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            }
        }
        throw new com.baidu.searchbox.dns.d.c.a.b(10002, "request canceled");
    }

    protected void a(com.baidu.searchbox.dns.d.c.a.a aVar) {
        this.aj++;
        if (this.aj <= this.al) {
            SystemClock.sleep(5000L);
        } else if (aVar.P() == 10001) {
            throw new com.baidu.searchbox.dns.d.c.a.b(aVar.P(), aVar.Q(), " retry count reach fail ");
        } else {
            throw new com.baidu.searchbox.dns.d.c.a.b(" retry count reach fail ");
        }
    }

    protected void c(HttpURLConnection httpURLConnection) {
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                String str = " http response error -> " + responseCode;
                if (d(responseCode)) {
                    throw new com.baidu.searchbox.dns.d.c.a.b(10001, responseCode, str);
                }
                throw new com.baidu.searchbox.dns.d.c.a.a(10001, responseCode, str);
            }
        } catch (IOException e) {
            throw new com.baidu.searchbox.dns.d.c.a.a(e.getMessage());
        }
    }

    protected String d(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            String contentEncoding = httpURLConnection.getContentEncoding();
            inputStream = httpURLConnection.getInputStream();
            try {
                try {
                    if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.equals("gzip")) {
                        inputStream = new GZIPInputStream(inputStream);
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(new String(readLine.getBytes("utf-8"), "utf-8"));
            }
            String stringBuffer2 = stringBuffer.toString();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            return stringBuffer2;
        } catch (Exception e5) {
            e = e5;
            bufferedReader2 = bufferedReader;
            throw new com.baidu.searchbox.dns.d.c.a.b(e.getMessage());
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            throw th;
        }
    }

    protected boolean d(int i) {
        return 403 == i || 404 == i;
    }

    public T x() {
        this.aj = 0;
        while (this.aj <= this.al) {
            try {
                try {
                    return O();
                } catch (com.baidu.searchbox.dns.d.c.a.a e) {
                    a(e);
                }
            } catch (com.baidu.searchbox.dns.d.c.a.b e2) {
                if (e2.P() == 10001) {
                    c(e2.Q());
                } else {
                    a(e2);
                }
            }
        }
        return null;
    }
}
