package com.baidu.mapsdkplatform.comapi.commonutils.a;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes3.dex */
public class d {
    private c d;
    private int b = 1;
    private List<com.baidu.mapsdkplatform.comapi.commonutils.a.b> c = new LinkedList();
    private ExecutorService a = Executors.newCachedThreadPool();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements b {
        private File b;

        private a(File file) {
            this.b = file;
        }

        /* synthetic */ a(d dVar, File file, e eVar) {
            this(file);
        }

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.a.d.b
        public void a(com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar) {
            if (d.this.c == null || d.this.c.size() == 0 || bVar == null || !bVar.a() || d.this.c == null) {
                return;
            }
            d.this.c.remove(bVar);
            if (d.this.c.size() == 0) {
                d.this.d.a(this.b);
            }
        }

        @Override // com.baidu.mapsdkplatform.comapi.commonutils.a.d.b
        public void b(com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar) {
            if (d.this.c == null || d.this.c.size() == 0 || bVar == null) {
                return;
            }
            d.this.c.clear();
            if (d.this.d != null) {
                d.this.d.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar);

        void b(com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void a(File file);
    }

    private HttpURLConnection a(String str) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str);
            if (HttpClient.isHttpsEnable) {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new e(this));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            return httpURLConnection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void a(String str, File file, int i, int i2) {
        if (TextUtils.isEmpty(str) || file == null || i <= 0 || i2 <= 0) {
            return;
        }
        for (int i3 = 0; i3 < this.b; i3++) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a aVar = new com.baidu.mapsdkplatform.comapi.commonutils.a.a(i3, i3 * i, ((i3 + 1) * i) - 1);
            if (i3 == this.b - 1) {
                aVar.a(i2);
            }
            com.baidu.mapsdkplatform.comapi.commonutils.a.b bVar = new com.baidu.mapsdkplatform.comapi.commonutils.a.b(str, file, aVar, new a(this, file, null));
            if (this.c != null) {
                this.c.add(bVar);
            }
            if (this.a != null && !this.a.isShutdown()) {
                this.a.submit(bVar);
            }
        }
    }

    private void a(String str, String str2, String str3) {
        String headerField;
        File file = new File(str2);
        if (file.exists() || file.mkdirs()) {
            HttpURLConnection a2 = a(str);
            if (a2 != null) {
                try {
                    if (a2.getResponseCode() == 200) {
                        int contentLength = a2.getContentLength();
                        if (contentLength <= 0) {
                            throw new RuntimeException("unKnow file length");
                        }
                        if (str3 == null && ((headerField = a2.getHeaderField("Content-Disposition")) == null || headerField.length() == 0 || (str3 = URLDecoder.decode(headerField.substring(headerField.indexOf("filename=") + 9), "UTF-8")) == null || str3.length() == 0)) {
                            return;
                        }
                        File file2 = new File(file, str3);
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                        randomAccessFile.setLength(contentLength);
                        randomAccessFile.close();
                        a2.disconnect();
                        a(str, file2, contentLength % this.b == 0 ? contentLength / this.b : (contentLength / this.b) + 1, contentLength);
                        return;
                    }
                } catch (Exception e) {
                    return;
                }
            }
            throw new RuntimeException("server no response.");
        }
    }

    public void a(String str, String str2, String str3, int i, c cVar) {
        if (i <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        this.b = i;
        this.d = cVar;
        a(str, str2, str3);
    }
}
