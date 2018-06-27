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
    private e sU;
    private HttpURLConnection zq;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long zr = 0;
    private long zs = 0;
    private long tr = 0;
    private long zt = 0;
    private long zu = 0;
    private boolean zv = false;
    private boolean zw = true;
    private TimerTask zx = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.hN();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer zy = new Timer();

    public long hH() {
        return this.zu;
    }

    public long hI() {
        return this.zt;
    }

    public long hJ() {
        return this.zr;
    }

    public long hK() {
        return this.zs;
    }

    public long hL() {
        return this.tr;
    }

    public boolean hM() {
        return this.zv;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.sU = eVar;
    }

    public void hN() {
        this.sU.hW().zY = true;
        com.baidu.adp.lib.g.a.f(this.zq);
    }

    private URL a(String str, d dVar) throws Exception {
        a hG;
        URL url = new URL(str);
        if (this.zw && (hG = a.hG()) != null) {
            String ax = hG.ax(str);
            if (!TextUtils.isEmpty(ax)) {
                this.sU.hV().q("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ax));
                this.zv = true;
                dVar.zM = ax;
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
        String jN;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.jD()) {
                if (j.jF() && (jN = j.jN()) != null && jN.length() > 0) {
                    if (j.bd(jN) && j.jP()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(jN);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.sU.hV().q("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(jN, j.jO())));
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
        dVar.zK = -1;
        if (this.sU.hW().zY) {
            throw new BdHttpCancelException();
        }
        String c = this.sU.hV().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.sU.hW().zY) {
            throw new BdHttpCancelException();
        }
        dVar.zK = -2;
        this.zq = c(a);
        dVar.zK = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.zq == null) {
                throw new SocketException("network not available.");
            }
            this.zq.setRequestMethod("GET");
            this.zq.setConnectTimeout(i2);
            this.zq.setReadTimeout(i);
            this.sU.hV().d(this.zq);
            if (this.sU.hW().zY) {
                throw new BdHttpCancelException();
            }
            dVar.zH = new Date().getTime() - currentTimeMillis;
            dVar.zK = -4;
            this.zq.connect();
            if (this.zr <= 0) {
                this.zr = System.currentTimeMillis();
            }
            this.zs = System.currentTimeMillis();
            dVar.zK = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.zH;
            if (this.sU.hW().zY) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zq.getContentType();
            this.tr = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aD(contentType)) {
                this.zq.disconnect();
                this.zq.connect();
                if (this.sU.hW().zY) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.zK = -8;
            this.sU.hW().e(this.zq);
            if (c.contains("c.tieba.baidu.com") && (map = this.sU.hW().Aa) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.zN = list.get(0);
                dVar.zO = list.get(1);
            }
            dVar.zJ = this.sU.hW().responseCode;
            dVar.zD = this.zq.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.zq);
            if (c2 != null) {
                dVar.zD += c2.length;
                this.sU.hW().Ab = c(this.sU.hW().contentEncoding, c2);
            }
            dVar.zK = -9;
            dVar.zE = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.zq != null) {
                this.zq.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.zu = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.zu == 0) {
            this.zu = System.currentTimeMillis();
            return bArr;
        } else {
            return bArr;
        }
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
                while (!this.sU.hW().zY && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.zt = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.f(inputStream);
                        throw th;
                    }
                }
                if (this.sU.hW().zY) {
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
        this.zt = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.f(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.zK = -1;
        try {
            String url = this.sU.hV().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.sU.hW().zY) {
                throw new BdHttpCancelException();
            }
            dVar.zK = -2;
            this.zq = c(a);
            dVar.zK = -3;
            System.currentTimeMillis();
            if (this.zq == null) {
                throw new SocketException("network not available.");
            }
            this.zq.setRequestMethod("POST");
            this.zq.setDoOutput(true);
            this.zq.setDoInput(true);
            this.zq.setConnectTimeout(i2);
            this.zq.setReadTimeout(i);
            this.zq.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.sU.hW().zY) {
                throw new BdHttpCancelException();
            }
            this.sU.hV().d(this.zq);
            if (this.sU.hW().zY) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.zH = new Date().getTime() - time;
            dVar.zK = -4;
            this.zq.connect();
            if (this.zr <= 0) {
                this.zr = System.currentTimeMillis();
            }
            this.zs = System.currentTimeMillis();
            dVar.zK = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.zH;
            if (this.sU.hW().zY) {
                throw new BdHttpCancelException();
            }
            if (this.zy != null) {
                this.zy.schedule(this.zx, 45000L);
            }
            dVar.zK = -6;
            this.sU.hV().a(this.zq, boundary, dVar);
            dVar.zK = -7;
            String contentType = this.zq.getContentType();
            this.tr = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aD(contentType)) {
                this.zq.disconnect();
                this.zq.connect();
                if (this.sU.hW().zY) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.sU.hW().zY) {
                throw new BdHttpCancelException();
            }
            dVar.zK = -8;
            this.sU.hW().e(this.zq);
            dVar.zJ = this.sU.hW().responseCode;
            dVar.zD = this.zq.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zq);
            if (c != null) {
                dVar.zD += c.length;
                this.sU.hW().Ac = c.length;
                this.sU.hW().Ab = c(this.sU.hW().contentEncoding, c);
            }
            dVar.zE = new Date().getTime() - time;
            dVar.zK = -9;
        } finally {
            if (this.zy != null) {
                this.zy.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.zq);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [687=8, 688=6, 689=6, 690=6] */
    public boolean a(String str, h hVar, int i, int i2, boolean z, d dVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        d dVar2 = dVar == null ? new d() : dVar;
        try {
            String url = this.sU.hV().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.zq = a(a, i2, i);
            if (this.sU.hW().zY) {
                this.zt = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.f((InputStream) null);
                com.baidu.adp.lib.g.a.f(this.zq);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aX(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aV(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.sU.hV().d(this.zq);
                this.zq.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.zq.connect();
                if (this.zr <= 0) {
                    this.zr = System.currentTimeMillis();
                }
                this.zs = System.currentTimeMillis();
                int responseCode = this.zq.getResponseCode();
                this.tr = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.zq.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.f(this.zq);
                        this.zq = a(new URL(url2.toString()), i2, i);
                        this.sU.hV().d(this.zq);
                        this.zq.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.zq.connect();
                        responseCode = this.zq.getResponseCode();
                    }
                }
                this.sU.hW().responseCode = responseCode;
                if (hO()) {
                    if (this.zq.getContentType() != null && this.zq.getContentType().contains("text/vnd.wap.wml")) {
                        this.zq.disconnect();
                        this.sU.hW().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.zt = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zq);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.zq.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.sU.hW().responseCode == 200 && (headerField = this.zq.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.sU.hW().contentLength = String.valueOf(g);
                    dVar2.zC = url.getBytes().length;
                    dVar2.zD = this.zq.getHeaderFields().toString().getBytes().length;
                    dVar2.zD += g;
                    if (this.sU.hW().responseCode == 416 || this.sU.hW().responseCode == 204) {
                        this.zt = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zq);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.zt = System.currentTimeMillis();
                        this.zt = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zq);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.zq.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.m((int) length, g);
                            }
                            while (!this.sU.hW().zY) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (hVar != null && (i6 > i5 || i4 == g)) {
                                            i6 = 0;
                                            hVar.m((int) (i4 + length), g);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) g);
                                this.zt = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.f(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.zq);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.zt = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.f(inputStream);
                            com.baidu.adp.lib.g.a.f(this.zq);
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

    private boolean hO() {
        return this.sU.hW().responseCode == 200 || this.sU.hW().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.zK = -1;
        try {
            String url = this.sU.hV().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.sU.hW().zY) {
                throw new BdHttpCancelException();
            }
            dVar.zK = -2;
            this.zq = c(a);
            dVar.zK = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zq == null) {
                throw new SocketException("network not available.");
            }
            this.zq.setRequestMethod("POST");
            this.zq.setDoOutput(true);
            this.zq.setDoInput(true);
            this.zq.setConnectTimeout(i2);
            this.zq.setReadTimeout(i);
            this.zq.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.sU.hW().zY) {
                throw new BdHttpCancelException();
            }
            this.sU.hV().d(this.zq);
            if (this.sU.hW().zY) {
                throw new BdHttpCancelException();
            }
            dVar.zH = System.currentTimeMillis() - currentTimeMillis;
            dVar.zK = -4;
            this.zq.connect();
            if (this.zr <= 0) {
                this.zr = System.currentTimeMillis();
            }
            this.zs = System.currentTimeMillis();
            dVar.zK = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.zH;
            if (this.sU.hW().zY) {
                throw new BdHttpCancelException();
            }
            dVar.zK = -6;
            this.sU.hV().a(this.zq, dVar);
            dVar.zK = -7;
            if (this.sU.hW().zY) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zq.getContentType();
            this.tr = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aD(contentType)) {
                this.zq.disconnect();
                this.zq.connect();
                if (this.sU.hW().zY) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.zK = -8;
            this.sU.hW().e(this.zq);
            dVar.zJ = this.sU.hW().responseCode;
            dVar.zD = this.zq.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zq);
            if (c != null) {
                dVar.zD += c.length;
                this.sU.hW().Ac = c.length;
                this.sU.hW().Ab = c(this.sU.hW().contentEncoding, c);
            }
            dVar.zE = new Date().getTime() - currentTimeMillis;
            dVar.zK = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.zq);
        }
    }
}
