package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private e act;
    private HttpURLConnection aiR;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long aiS = 0;
    private long aiT = 0;
    private long acN = 0;
    private long aiU = 0;
    private long aiV = 0;
    private boolean aiW = false;
    private boolean aiX = true;
    private TimerTask aiY = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.mR();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer aiZ = new Timer();

    public long mL() {
        return this.aiV;
    }

    public long mM() {
        return this.aiU;
    }

    public long mN() {
        return this.aiS;
    }

    public long mO() {
        return this.aiT;
    }

    public long mP() {
        return this.acN;
    }

    public boolean mQ() {
        return this.aiW;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.act = eVar;
    }

    public void mR() {
        this.act.nb().ajz = true;
        com.baidu.adp.lib.g.a.f(this.aiR);
    }

    private URL a(String str, d dVar) throws Exception {
        a mK;
        URL url = new URL(str);
        if (this.aiX && (mK = a.mK()) != null) {
            String ao = mK.ao(str);
            if (!TextUtils.isEmpty(ao)) {
                this.act.na().o(HTTP.TARGET_HOST, url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ao));
                this.aiW = true;
                dVar.ajn = ao;
                return url2;
            }
        }
        return url;
    }

    private HttpURLConnection a(URL url, int i, int i2) throws SocketException {
        HttpURLConnection c = c(url);
        if (c != null) {
            c.setConnectTimeout(i);
            c.setReadTimeout(i2);
            return c;
        }
        throw new SocketException();
    }

    private HttpURLConnection c(URL url) {
        HttpURLConnection httpURLConnection;
        Exception e;
        String oS;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.oI()) {
                if (j.oK() && (oS = j.oS()) != null && oS.length() > 0) {
                    if (j.aS(oS) && j.oU()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(oS);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.act.na().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(oS, j.oT())));
                    }
                }
                if (httpURLConnection2 == null) {
                    try {
                        return (HttpURLConnection) url.openConnection();
                    } catch (Exception e3) {
                        httpURLConnection = httpURLConnection2;
                        e = e3;
                        e.printStackTrace();
                        return httpURLConnection;
                    }
                }
                return httpURLConnection2;
            }
            return null;
        } catch (Exception e4) {
            httpURLConnection = null;
            e = e4;
        }
    }

    public void a(int i, int i2, d dVar) throws Exception {
        Map<String, List<String>> map;
        List<String> list;
        dVar.ajl = -1;
        if (this.act.nb().ajz) {
            throw new BdHttpCancelException();
        }
        String c = this.act.na().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.act.nb().ajz) {
            throw new BdHttpCancelException();
        }
        dVar.ajl = -2;
        this.aiR = c(a);
        dVar.ajl = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.aiR == null) {
                throw new SocketException("network not available.");
            }
            this.aiR.setRequestMethod(HttpGet.METHOD_NAME);
            this.aiR.setConnectTimeout(i2);
            this.aiR.setReadTimeout(i);
            this.act.na().d(this.aiR);
            if (this.act.nb().ajz) {
                throw new BdHttpCancelException();
            }
            dVar.aji = new Date().getTime() - currentTimeMillis;
            dVar.ajl = -4;
            this.aiR.connect();
            if (this.aiS <= 0) {
                this.aiS = System.currentTimeMillis();
            }
            this.aiT = System.currentTimeMillis();
            dVar.ajl = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.aji;
            if (this.act.nb().ajz) {
                throw new BdHttpCancelException();
            }
            String contentType = this.aiR.getContentType();
            this.acN = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.as(contentType)) {
                this.aiR.disconnect();
                this.aiR.connect();
                if (this.act.nb().ajz) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.ajl = -8;
            this.act.nb().e(this.aiR);
            if (c.contains("c.tieba.baidu.com") && (map = this.act.nb().ajB) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.ajo = list.get(0);
                dVar.ajp = list.get(1);
            }
            dVar.ajk = this.act.nb().responseCode;
            dVar.aje = this.aiR.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.aiR);
            if (c2 != null) {
                dVar.aje += c2.length;
                this.act.nb().ajC = c(this.act.nb().contentEncoding, c2);
            }
            dVar.ajl = -9;
            dVar.ajf = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.aiR != null) {
                this.aiR.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.c(byteArrayInputStream, byteArrayOutputStream);
            this.aiV = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        return bArr;
    }

    private byte[] c(HttpURLConnection httpURLConnection) throws Exception {
        byte[] bArr;
        InputStream inputStream;
        Throwable th;
        int read;
        InputStream inputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        if (httpURLConnection != null) {
            try {
                byte[] bArr2 = new byte[1024];
                inputStream2 = httpURLConnection.getInputStream();
                while (!this.act.nb().ajz && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.aiU = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.act.nb().ajz) {
                    throw new BdHttpCancelException();
                }
                bArr = byteArrayOutputStream.toByteArray();
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
            }
        } else {
            bArr = null;
        }
        this.aiU = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.ajl = -1;
        try {
            String url = this.act.na().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.act.nb().ajz) {
                throw new BdHttpCancelException();
            }
            dVar.ajl = -2;
            this.aiR = c(a);
            dVar.ajl = -3;
            System.currentTimeMillis();
            if (this.aiR == null) {
                throw new SocketException("network not available.");
            }
            this.aiR.setRequestMethod(HttpPost.METHOD_NAME);
            this.aiR.setDoOutput(true);
            this.aiR.setDoInput(true);
            this.aiR.setConnectTimeout(i2);
            this.aiR.setReadTimeout(i);
            this.aiR.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.act.nb().ajz) {
                throw new BdHttpCancelException();
            }
            this.act.na().d(this.aiR);
            if (this.act.nb().ajz) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.aji = new Date().getTime() - time;
            dVar.ajl = -4;
            this.aiR.connect();
            if (this.aiS <= 0) {
                this.aiS = System.currentTimeMillis();
            }
            this.aiT = System.currentTimeMillis();
            dVar.ajl = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.aji;
            if (this.act.nb().ajz) {
                throw new BdHttpCancelException();
            }
            if (this.aiZ != null) {
                this.aiZ.schedule(this.aiY, 45000L);
            }
            dVar.ajl = -6;
            this.act.na().a(this.aiR, boundary, dVar);
            dVar.ajl = -7;
            String contentType = this.aiR.getContentType();
            this.acN = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.as(contentType)) {
                this.aiR.disconnect();
                this.aiR.connect();
                if (this.act.nb().ajz) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.act.nb().ajz) {
                throw new BdHttpCancelException();
            }
            dVar.ajl = -8;
            this.act.nb().e(this.aiR);
            dVar.ajk = this.act.nb().responseCode;
            dVar.aje = this.aiR.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.aiR);
            if (c != null) {
                dVar.aje += c.length;
                this.act.nb().ajD = c.length;
                this.act.nb().ajC = c(this.act.nb().contentEncoding, c);
            }
            dVar.ajf = new Date().getTime() - time;
            dVar.ajl = -9;
        } finally {
            if (this.aiZ != null) {
                this.aiZ.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.aiR);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [684=8, 685=6, 686=6, 687=6] */
    public boolean a(String str, h hVar, int i, int i2, boolean z, d dVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        d dVar2 = dVar == null ? new d() : dVar;
        try {
            String url = this.act.na().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.aiR = a(a, i2, i);
            if (this.act.nb().ajz) {
                this.aiU = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.f(this.aiR);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aM(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aK(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.act.na().d(this.aiR);
                this.aiR.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.aiR.connect();
                if (this.aiS <= 0) {
                    this.aiS = System.currentTimeMillis();
                }
                this.aiT = System.currentTimeMillis();
                int responseCode = this.aiR.getResponseCode();
                this.acN = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.aiR.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.f(this.aiR);
                        this.aiR = a(new URL(url2.toString()), i2, i);
                        this.act.na().d(this.aiR);
                        this.aiR.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.aiR.connect();
                        responseCode = this.aiR.getResponseCode();
                    }
                }
                this.act.nb().responseCode = responseCode;
                if (mS()) {
                    if (this.aiR.getContentType() != null && this.aiR.getContentType().contains("text/vnd.wap.wml")) {
                        this.aiR.disconnect();
                        this.act.nb().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.aiU = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiR);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.aiR.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.h(headerField2.substring(indexOf + 1), 0);
                    }
                    int h = (i3 == 0 && this.act.nb().responseCode == 200 && (headerField = this.aiR.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.h(headerField, 0) : i3;
                    this.act.nb().contentLength = String.valueOf(h);
                    dVar2.ajd = url.getBytes().length;
                    dVar2.aje = this.aiR.getHeaderFields().toString().getBytes().length;
                    dVar2.aje += h;
                    if (this.act.nb().responseCode == 416 || this.act.nb().responseCode == 204) {
                        this.aiU = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiR);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (h != 0 && length >= h) {
                        this.aiU = System.currentTimeMillis();
                        this.aiU = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiR);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.aiR.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = h > 0 ? h / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.an((int) length, h);
                            }
                            while (!this.act.nb().ajz) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (hVar != null && (i6 > i5 || i4 == h)) {
                                            i6 = 0;
                                            hVar.an((int) (i4 + length), h);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) h);
                                this.aiU = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.aiR);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.aiU = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.f(this.aiR);
                            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                            throw th;
                        }
                    }
                }
                throw new UnsupportedOperationException();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    private boolean mS() {
        return this.act.nb().responseCode == 200 || this.act.nb().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.ajl = -1;
        try {
            String url = this.act.na().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.act.nb().ajz) {
                throw new BdHttpCancelException();
            }
            dVar.ajl = -2;
            this.aiR = c(a);
            dVar.ajl = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aiR == null) {
                throw new SocketException("network not available.");
            }
            this.aiR.setRequestMethod(HttpPost.METHOD_NAME);
            this.aiR.setDoOutput(true);
            this.aiR.setDoInput(true);
            this.aiR.setConnectTimeout(i2);
            this.aiR.setReadTimeout(i);
            this.aiR.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.act.nb().ajz) {
                throw new BdHttpCancelException();
            }
            this.act.na().d(this.aiR);
            if (this.act.nb().ajz) {
                throw new BdHttpCancelException();
            }
            dVar.aji = System.currentTimeMillis() - currentTimeMillis;
            dVar.ajl = -4;
            this.aiR.connect();
            if (this.aiS <= 0) {
                this.aiS = System.currentTimeMillis();
            }
            this.aiT = System.currentTimeMillis();
            dVar.ajl = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.aji;
            if (this.act.nb().ajz) {
                throw new BdHttpCancelException();
            }
            dVar.ajl = -6;
            this.act.na().a(this.aiR, dVar);
            dVar.ajl = -7;
            if (this.act.nb().ajz) {
                throw new BdHttpCancelException();
            }
            String contentType = this.aiR.getContentType();
            this.acN = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.as(contentType)) {
                this.aiR.disconnect();
                this.aiR.connect();
                if (this.act.nb().ajz) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.ajl = -8;
            this.act.nb().e(this.aiR);
            dVar.ajk = this.act.nb().responseCode;
            dVar.aje = this.aiR.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.aiR);
            if (c != null) {
                dVar.aje += c.length;
                this.act.nb().ajD = c.length;
                this.act.nb().ajC = c(this.act.nb().contentEncoding, c);
            }
            dVar.ajf = new Date().getTime() - currentTimeMillis;
            dVar.ajl = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.aiR);
        }
    }
}
