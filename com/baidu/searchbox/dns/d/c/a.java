package com.baidu.searchbox.dns.d.c;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.ar.util.IoUtils;
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
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public abstract class a<T> {
    protected int S = 0;
    private boolean T = false;
    protected int U = q();

    protected abstract void a(int i);

    protected abstract void a(Exception exc);

    protected abstract void b(HttpURLConnection httpURLConnection);

    protected abstract T g(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Map<String, Object> getParameters();

    protected abstract String getUrl();

    protected int q() {
        return 2;
    }

    protected boolean p() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        httpURLConnection.setRequestProperty(HTTP.USER_AGENT, D());
    }

    protected String D() {
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
    public String a(Map<String, Object> map) {
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

    private T E() {
        if (!this.T) {
            HttpsURLConnection httpsURLConnection = null;
            String url = getUrl();
            if (!TextUtils.isEmpty(url)) {
                try {
                    try {
                        if (!p()) {
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
                        return g(d(httpsURLConnection));
                    } catch (Exception e) {
                        throw new com.baidu.searchbox.dns.d.c.a.a(e.getMessage());
                    }
                } finally {
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                }
            }
            throw new com.baidu.searchbox.dns.d.c.a.b("url is empty");
        }
        throw new com.baidu.searchbox.dns.d.c.a.b(10002, "request canceled");
    }

    protected void a(com.baidu.searchbox.dns.d.c.a.a aVar) {
        this.S++;
        if (this.S <= this.U) {
            SystemClock.sleep(5000L);
        } else if (aVar.G() == 10001) {
            throw new com.baidu.searchbox.dns.d.c.a.b(aVar.G(), aVar.H(), " retry count reach fail ");
        } else {
            throw new com.baidu.searchbox.dns.d.c.a.b(" retry count reach fail ");
        }
    }

    protected void c(HttpURLConnection httpURLConnection) {
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                String str = " http response error -> " + responseCode;
                if (b(responseCode)) {
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
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, IoUtils.UTF_8));
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
                stringBuffer.append(new String(readLine.getBytes(IoUtils.UTF_8), IoUtils.UTF_8));
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

    protected boolean b(int i) {
        return 403 == i || 404 == i;
    }

    public T F() {
        this.S = 0;
        while (this.S <= this.U) {
            try {
                try {
                    return E();
                } catch (com.baidu.searchbox.dns.d.c.a.a e) {
                    a(e);
                }
            } catch (com.baidu.searchbox.dns.d.c.a.b e2) {
                if (e2.G() == 10001) {
                    a(e2.H());
                } else {
                    a(e2);
                }
            }
        }
        return null;
    }
}
