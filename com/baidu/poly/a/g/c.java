package com.baidu.poly.a.g;

import com.baidu.webkit.internal.ETAG;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes11.dex */
public class c {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [23=4] */
    public void a(com.baidu.poly.a.a.c cVar, com.baidu.poly.a.a.b bVar, com.baidu.poly.a.a.a aVar) {
        DataOutputStream dataOutputStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://etrade.baidu.com/sgw/common/pingd/trace").openConnection();
            for (Map.Entry<String, String> entry : cVar.NT().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry2 : bVar.NT().entrySet()) {
                sb.append(entry2.getKey()).append(ETAG.EQUAL).append(URLEncoder.encode(entry2.getValue(), "utf-8")).append(ETAG.ITEM_SEPARATOR);
            }
            byte[] bytes = sb.toString().getBytes();
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
            httpURLConnection.connect();
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.write(bytes);
                dataOutputStream.flush();
                int responseCode = httpURLConnection.getResponseCode();
                if (aVar != null) {
                    if (responseCode < 200 || responseCode > 299) {
                        aVar.a(null, null);
                    } else {
                        aVar.a(null);
                    }
                }
                com.baidu.poly.util.c.a(dataOutputStream);
            } catch (Throwable th) {
                if (aVar != null) {
                    try {
                        aVar.a(null, null);
                    } catch (Throwable th2) {
                        com.baidu.poly.util.c.a(dataOutputStream);
                        throw th2;
                    }
                }
                com.baidu.poly.util.c.a(dataOutputStream);
            }
        } catch (Throwable th3) {
            dataOutputStream = null;
        }
    }
}
