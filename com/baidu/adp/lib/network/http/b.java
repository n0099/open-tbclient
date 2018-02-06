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
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private e acr;
    private HttpURLConnection aiT;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long aiU = 0;
    private long aiV = 0;
    private long acL = 0;
    private long aiW = 0;
    private long aiX = 0;
    private boolean aiY = false;
    private boolean aiZ = true;
    private TimerTask aja = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.mS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer ajb = new Timer();

    public long mM() {
        return this.aiX;
    }

    public long mN() {
        return this.aiW;
    }

    public long mO() {
        return this.aiU;
    }

    public long mP() {
        return this.aiV;
    }

    public long mQ() {
        return this.acL;
    }

    public boolean mR() {
        return this.aiY;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.acr = eVar;
    }

    public void mS() {
        this.acr.nc().ajB = true;
        com.baidu.adp.lib.g.a.f(this.aiT);
    }

    private URL a(String str, d dVar) throws Exception {
        a mL;
        URL url = new URL(str);
        if (this.aiZ && (mL = a.mL()) != null) {
            String ao = mL.ao(str);
            if (!TextUtils.isEmpty(ao)) {
                this.acr.nb().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ao));
                this.aiY = true;
                dVar.ajp = ao;
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
        String oT;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.oJ()) {
                if (j.oL() && (oT = j.oT()) != null && oT.length() > 0) {
                    if (j.aS(oT) && j.oV()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(oT);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.acr.nb().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(oT, j.oU())));
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
        dVar.ajn = -1;
        if (this.acr.nc().ajB) {
            throw new BdHttpCancelException();
        }
        String c = this.acr.nb().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.acr.nc().ajB) {
            throw new BdHttpCancelException();
        }
        dVar.ajn = -2;
        this.aiT = c(a);
        dVar.ajn = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.aiT == null) {
                throw new SocketException("network not available.");
            }
            this.aiT.setRequestMethod("GET");
            this.aiT.setConnectTimeout(i2);
            this.aiT.setReadTimeout(i);
            this.acr.nb().d(this.aiT);
            if (this.acr.nc().ajB) {
                throw new BdHttpCancelException();
            }
            dVar.ajk = new Date().getTime() - currentTimeMillis;
            dVar.ajn = -4;
            this.aiT.connect();
            if (this.aiU <= 0) {
                this.aiU = System.currentTimeMillis();
            }
            this.aiV = System.currentTimeMillis();
            dVar.ajn = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.ajk;
            if (this.acr.nc().ajB) {
                throw new BdHttpCancelException();
            }
            String contentType = this.aiT.getContentType();
            this.acL = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.as(contentType)) {
                this.aiT.disconnect();
                this.aiT.connect();
                if (this.acr.nc().ajB) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.ajn = -8;
            this.acr.nc().e(this.aiT);
            if (c.contains("c.tieba.baidu.com") && (map = this.acr.nc().ajD) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.ajq = list.get(0);
                dVar.ajr = list.get(1);
            }
            dVar.ajm = this.acr.nc().responseCode;
            dVar.ajg = this.aiT.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.aiT);
            if (c2 != null) {
                dVar.ajg += c2.length;
                this.acr.nc().ajE = c(this.acr.nc().contentEncoding, c2);
            }
            dVar.ajn = -9;
            dVar.ajh = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.aiT != null) {
                this.aiT.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.c(byteArrayInputStream, byteArrayOutputStream);
            this.aiX = System.currentTimeMillis();
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
                while (!this.acr.nc().ajB && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.aiW = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.acr.nc().ajB) {
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
        this.aiW = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.ajn = -1;
        try {
            String url = this.acr.nb().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.acr.nc().ajB) {
                throw new BdHttpCancelException();
            }
            dVar.ajn = -2;
            this.aiT = c(a);
            dVar.ajn = -3;
            System.currentTimeMillis();
            if (this.aiT == null) {
                throw new SocketException("network not available.");
            }
            this.aiT.setRequestMethod("POST");
            this.aiT.setDoOutput(true);
            this.aiT.setDoInput(true);
            this.aiT.setConnectTimeout(i2);
            this.aiT.setReadTimeout(i);
            this.aiT.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.acr.nc().ajB) {
                throw new BdHttpCancelException();
            }
            this.acr.nb().d(this.aiT);
            if (this.acr.nc().ajB) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.ajk = new Date().getTime() - time;
            dVar.ajn = -4;
            this.aiT.connect();
            if (this.aiU <= 0) {
                this.aiU = System.currentTimeMillis();
            }
            this.aiV = System.currentTimeMillis();
            dVar.ajn = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.ajk;
            if (this.acr.nc().ajB) {
                throw new BdHttpCancelException();
            }
            if (this.ajb != null) {
                this.ajb.schedule(this.aja, 45000L);
            }
            dVar.ajn = -6;
            this.acr.nb().a(this.aiT, boundary, dVar);
            dVar.ajn = -7;
            String contentType = this.aiT.getContentType();
            this.acL = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.as(contentType)) {
                this.aiT.disconnect();
                this.aiT.connect();
                if (this.acr.nc().ajB) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.acr.nc().ajB) {
                throw new BdHttpCancelException();
            }
            dVar.ajn = -8;
            this.acr.nc().e(this.aiT);
            dVar.ajm = this.acr.nc().responseCode;
            dVar.ajg = this.aiT.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.aiT);
            if (c != null) {
                dVar.ajg += c.length;
                this.acr.nc().ajF = c.length;
                this.acr.nc().ajE = c(this.acr.nc().contentEncoding, c);
            }
            dVar.ajh = new Date().getTime() - time;
            dVar.ajn = -9;
        } finally {
            if (this.ajb != null) {
                this.ajb.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.aiT);
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
            String url = this.acr.nb().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.aiT = a(a, i2, i);
            if (this.acr.nc().ajB) {
                this.aiW = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.f(this.aiT);
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
                this.acr.nb().d(this.aiT);
                this.aiT.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.aiT.connect();
                if (this.aiU <= 0) {
                    this.aiU = System.currentTimeMillis();
                }
                this.aiV = System.currentTimeMillis();
                int responseCode = this.aiT.getResponseCode();
                this.acL = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.aiT.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.f(this.aiT);
                        this.aiT = a(new URL(url2.toString()), i2, i);
                        this.acr.nb().d(this.aiT);
                        this.aiT.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.aiT.connect();
                        responseCode = this.aiT.getResponseCode();
                    }
                }
                this.acr.nc().responseCode = responseCode;
                if (mT()) {
                    if (this.aiT.getContentType() != null && this.aiT.getContentType().contains("text/vnd.wap.wml")) {
                        this.aiT.disconnect();
                        this.acr.nc().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.aiW = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiT);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.aiT.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.h(headerField2.substring(indexOf + 1), 0);
                    }
                    int h = (i3 == 0 && this.acr.nc().responseCode == 200 && (headerField = this.aiT.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.h(headerField, 0) : i3;
                    this.acr.nc().contentLength = String.valueOf(h);
                    dVar2.ajf = url.getBytes().length;
                    dVar2.ajg = this.aiT.getHeaderFields().toString().getBytes().length;
                    dVar2.ajg += h;
                    if (this.acr.nc().responseCode == 416 || this.acr.nc().responseCode == 204) {
                        this.aiW = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiT);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (h != 0 && length >= h) {
                        this.aiW = System.currentTimeMillis();
                        this.aiW = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiT);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.aiT.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = h > 0 ? h / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.an((int) length, h);
                            }
                            while (!this.acr.nc().ajB) {
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
                                this.aiW = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.aiT);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.aiW = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.f(this.aiT);
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

    private boolean mT() {
        return this.acr.nc().responseCode == 200 || this.acr.nc().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.ajn = -1;
        try {
            String url = this.acr.nb().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.acr.nc().ajB) {
                throw new BdHttpCancelException();
            }
            dVar.ajn = -2;
            this.aiT = c(a);
            dVar.ajn = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aiT == null) {
                throw new SocketException("network not available.");
            }
            this.aiT.setRequestMethod("POST");
            this.aiT.setDoOutput(true);
            this.aiT.setDoInput(true);
            this.aiT.setConnectTimeout(i2);
            this.aiT.setReadTimeout(i);
            this.aiT.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.acr.nc().ajB) {
                throw new BdHttpCancelException();
            }
            this.acr.nb().d(this.aiT);
            if (this.acr.nc().ajB) {
                throw new BdHttpCancelException();
            }
            dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
            dVar.ajn = -4;
            this.aiT.connect();
            if (this.aiU <= 0) {
                this.aiU = System.currentTimeMillis();
            }
            this.aiV = System.currentTimeMillis();
            dVar.ajn = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.ajk;
            if (this.acr.nc().ajB) {
                throw new BdHttpCancelException();
            }
            dVar.ajn = -6;
            this.acr.nb().a(this.aiT, dVar);
            dVar.ajn = -7;
            if (this.acr.nc().ajB) {
                throw new BdHttpCancelException();
            }
            String contentType = this.aiT.getContentType();
            this.acL = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.as(contentType)) {
                this.aiT.disconnect();
                this.aiT.connect();
                if (this.acr.nc().ajB) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.ajn = -8;
            this.acr.nc().e(this.aiT);
            dVar.ajm = this.acr.nc().responseCode;
            dVar.ajg = this.aiT.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.aiT);
            if (c != null) {
                dVar.ajg += c.length;
                this.acr.nc().ajF = c.length;
                this.acr.nc().ajE = c(this.acr.nc().contentEncoding, c);
            }
            dVar.ajh = new Date().getTime() - currentTimeMillis;
            dVar.ajn = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.aiT);
        }
    }
}
