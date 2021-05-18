package com.baidu.fsg.base.statistics;

import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.fsg.base.utils.LogUtil;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes2.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5361a = "logsender";

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    public void a(String str, Map<String, String> map, a aVar) {
        HttpURLConnection httpURLConnection;
        boolean z;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                z = false;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
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
            if (200 <= responseCode && 300 > responseCode) {
                z = true;
            }
            if (z) {
                aVar.a();
            } else {
                aVar.b();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e3) {
            e = e3;
            httpURLConnection2 = httpURLConnection;
            e.printStackTrace();
            LogUtil.d("logsender", e.toString());
            aVar.b();
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
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
                String encode = URLEncoder.encode(entry.getKey());
                String encode2 = URLEncoder.encode(entry.getValue());
                sb.append(encode);
                sb.append("=");
                sb.append(encode2);
                sb.append("&");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }
}
