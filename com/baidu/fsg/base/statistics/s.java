package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.webkit.internal.ETAG;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes3.dex */
class s {
    private static final String a = "logsender";

    /* loaded from: classes3.dex */
    interface a {
        void a();

        void b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [60=4] */
    public void a(String str, Map<String, String> map, a aVar) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            String a2 = a(map);
            httpURLConnection.setFixedLengthStreamingMode(a2.length());
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.connect();
            if (a2.length() > 0) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(a2.getBytes());
                outputStream.flush();
                outputStream.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            httpURLConnection2 = (200 > responseCode || 300 <= responseCode) ? null : 1;
            if (httpURLConnection2 != null) {
                aVar.a();
            } else {
                aVar.b();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e2) {
            httpURLConnection2 = httpURLConnection;
            e = e2;
            e.printStackTrace();
            LogUtil.d(a, e.toString());
            aVar.b();
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(URLEncoder.encode(entry.getKey())).append(ETAG.EQUAL).append(URLEncoder.encode(entry.getValue())).append(ETAG.ITEM_SEPARATOR);
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }
}
