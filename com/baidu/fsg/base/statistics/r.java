package com.baidu.fsg.base.statistics;

import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.webkit.internal.ETAG;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes6.dex */
class r {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2012a = "logsender";

    /* loaded from: classes6.dex */
    interface a {
        void a();

        void b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [60=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0003 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
    public void a(String str, Map<String, String> map, a aVar) {
        Exception e;
        Throwable th;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        boolean z = true;
        int i = 0;
        HttpURLConnection httpURLConnection3 = null;
        try {
            try {
                httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = i;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            httpURLConnection2.setUseCaches(false);
            httpURLConnection2.setDoOutput(true);
            httpURLConnection2.setRequestMethod("POST");
            httpURLConnection2.setRequestProperty("Content-Encoding", "gzip");
            httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            String a2 = a(map);
            httpURLConnection2.setFixedLengthStreamingMode(a2.length());
            httpURLConnection2.setConnectTimeout(30000);
            httpURLConnection2.setReadTimeout(30000);
            httpURLConnection2.connect();
            if (a2.length() > 0) {
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                outputStream.write(a2.getBytes());
                outputStream.flush();
                outputStream.close();
            }
            i = httpURLConnection2.getResponseCode();
            if (200 > i || 300 <= i) {
                z = false;
            }
            if (z) {
                aVar.a();
            } else {
                aVar.b();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (Exception e3) {
            e = e3;
            httpURLConnection3 = httpURLConnection2;
            e.printStackTrace();
            LogUtil.d(f2012a, e.toString());
            aVar.b();
            if (httpURLConnection3 != null) {
                httpURLConnection3.disconnect();
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = httpURLConnection2;
            if (httpURLConnection != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(URLEncoder.encode(entry.getKey())).append("=").append(URLEncoder.encode(entry.getValue())).append(ETAG.ITEM_SEPARATOR);
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }
}
