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
    private e sW;
    private HttpURLConnection zs;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long zt = 0;
    private long zu = 0;
    private long tt = 0;
    private long zv = 0;
    private long zw = 0;
    private boolean zx = false;
    private boolean zy = true;
    private TimerTask zz = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.hN();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer zA = new Timer();

    public long hH() {
        return this.zw;
    }

    public long hI() {
        return this.zv;
    }

    public long hJ() {
        return this.zt;
    }

    public long hK() {
        return this.zu;
    }

    public long hL() {
        return this.tt;
    }

    public boolean hM() {
        return this.zx;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.sW = eVar;
    }

    public void hN() {
        this.sW.hW().Aa = true;
        com.baidu.adp.lib.g.a.f(this.zs);
    }

    private URL a(String str, d dVar) throws Exception {
        a hG;
        URL url = new URL(str);
        if (this.zy && (hG = a.hG()) != null) {
            String ax = hG.ax(str);
            if (!TextUtils.isEmpty(ax)) {
                this.sW.hV().q("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ax));
                this.zx = true;
                dVar.zO = ax;
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
                    if (j.bb(jN) && j.jP()) {
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
                            this.sW.hV().q("X-Online-Host", url.getHost());
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
        dVar.zM = -1;
        if (this.sW.hW().Aa) {
            throw new BdHttpCancelException();
        }
        String c = this.sW.hV().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.sW.hW().Aa) {
            throw new BdHttpCancelException();
        }
        dVar.zM = -2;
        this.zs = c(a);
        dVar.zM = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.zs == null) {
                throw new SocketException("network not available.");
            }
            this.zs.setRequestMethod("GET");
            this.zs.setConnectTimeout(i2);
            this.zs.setReadTimeout(i);
            this.sW.hV().d(this.zs);
            if (this.sW.hW().Aa) {
                throw new BdHttpCancelException();
            }
            dVar.zJ = new Date().getTime() - currentTimeMillis;
            dVar.zM = -4;
            this.zs.connect();
            if (this.zt <= 0) {
                this.zt = System.currentTimeMillis();
            }
            this.zu = System.currentTimeMillis();
            dVar.zM = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.zJ;
            if (this.sW.hW().Aa) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zs.getContentType();
            this.tt = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aB(contentType)) {
                this.zs.disconnect();
                this.zs.connect();
                if (this.sW.hW().Aa) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.zM = -8;
            this.sW.hW().e(this.zs);
            if (c.contains("c.tieba.baidu.com") && (map = this.sW.hW().Ac) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.zP = list.get(0);
                dVar.zQ = list.get(1);
            }
            dVar.zL = this.sW.hW().responseCode;
            dVar.zF = this.zs.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.zs);
            if (c2 != null) {
                dVar.zF += c2.length;
                this.sW.hW().Ae = c(this.sW.hW().contentEncoding, c2);
            }
            dVar.zM = -9;
            dVar.zG = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.zs != null) {
                this.zs.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.zw = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.zw == 0) {
            this.zw = System.currentTimeMillis();
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
                while (!this.sW.hW().Aa && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.zv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.f(inputStream);
                        throw th;
                    }
                }
                if (this.sW.hW().Aa) {
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
        this.zv = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.f(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.zM = -1;
        try {
            String url = this.sW.hV().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.sW.hW().Aa) {
                throw new BdHttpCancelException();
            }
            dVar.zM = -2;
            this.zs = c(a);
            dVar.zM = -3;
            System.currentTimeMillis();
            if (this.zs == null) {
                throw new SocketException("network not available.");
            }
            this.zs.setRequestMethod("POST");
            this.zs.setDoOutput(true);
            this.zs.setDoInput(true);
            this.zs.setConnectTimeout(i2);
            this.zs.setReadTimeout(i);
            this.zs.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.sW.hW().Aa) {
                throw new BdHttpCancelException();
            }
            this.sW.hV().d(this.zs);
            if (this.sW.hW().Aa) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.zJ = new Date().getTime() - time;
            dVar.zM = -4;
            this.zs.connect();
            if (this.zt <= 0) {
                this.zt = System.currentTimeMillis();
            }
            this.zu = System.currentTimeMillis();
            dVar.zM = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.zJ;
            if (this.sW.hW().Aa) {
                throw new BdHttpCancelException();
            }
            if (this.zA != null) {
                this.zA.schedule(this.zz, 45000L);
            }
            dVar.zM = -6;
            this.sW.hV().a(this.zs, boundary, dVar);
            dVar.zM = -7;
            String contentType = this.zs.getContentType();
            this.tt = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aB(contentType)) {
                this.zs.disconnect();
                this.zs.connect();
                if (this.sW.hW().Aa) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.sW.hW().Aa) {
                throw new BdHttpCancelException();
            }
            dVar.zM = -8;
            this.sW.hW().e(this.zs);
            dVar.zL = this.sW.hW().responseCode;
            dVar.zF = this.zs.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zs);
            if (c != null) {
                dVar.zF += c.length;
                this.sW.hW().Af = c.length;
                this.sW.hW().Ae = c(this.sW.hW().contentEncoding, c);
            }
            dVar.zG = new Date().getTime() - time;
            dVar.zM = -9;
        } finally {
            if (this.zA != null) {
                this.zA.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.zs);
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
            String url = this.sW.hV().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.zs = a(a, i2, i);
            if (this.sW.hW().Aa) {
                this.zv = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.f((InputStream) null);
                com.baidu.adp.lib.g.a.f(this.zs);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aV(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aT(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.sW.hV().d(this.zs);
                this.zs.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.zs.connect();
                if (this.zt <= 0) {
                    this.zt = System.currentTimeMillis();
                }
                this.zu = System.currentTimeMillis();
                int responseCode = this.zs.getResponseCode();
                this.tt = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.zs.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.f(this.zs);
                        this.zs = a(new URL(url2.toString()), i2, i);
                        this.sW.hV().d(this.zs);
                        this.zs.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.zs.connect();
                        responseCode = this.zs.getResponseCode();
                    }
                }
                this.sW.hW().responseCode = responseCode;
                if (hO()) {
                    if (this.zs.getContentType() != null && this.zs.getContentType().contains("text/vnd.wap.wml")) {
                        this.zs.disconnect();
                        this.sW.hW().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.zv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zs);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.zs.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.sW.hW().responseCode == 200 && (headerField = this.zs.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.sW.hW().contentLength = String.valueOf(g);
                    dVar2.zE = url.getBytes().length;
                    dVar2.zF = this.zs.getHeaderFields().toString().getBytes().length;
                    dVar2.zF += g;
                    if (this.sW.hW().responseCode == 416 || this.sW.hW().responseCode == 204) {
                        this.zv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zs);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.zv = System.currentTimeMillis();
                        this.zv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zs);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.zs.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.m((int) length, g);
                            }
                            while (!this.sW.hW().Aa) {
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
                                this.zv = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.f(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.zs);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.zv = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.f(inputStream);
                            com.baidu.adp.lib.g.a.f(this.zs);
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
        return this.sW.hW().responseCode == 200 || this.sW.hW().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.zM = -1;
        try {
            String url = this.sW.hV().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.sW.hW().Aa) {
                throw new BdHttpCancelException();
            }
            dVar.zM = -2;
            this.zs = c(a);
            dVar.zM = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zs == null) {
                throw new SocketException("network not available.");
            }
            this.zs.setRequestMethod("POST");
            this.zs.setDoOutput(true);
            this.zs.setDoInput(true);
            this.zs.setConnectTimeout(i2);
            this.zs.setReadTimeout(i);
            this.zs.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.sW.hW().Aa) {
                throw new BdHttpCancelException();
            }
            this.sW.hV().d(this.zs);
            if (this.sW.hW().Aa) {
                throw new BdHttpCancelException();
            }
            dVar.zJ = System.currentTimeMillis() - currentTimeMillis;
            dVar.zM = -4;
            this.zs.connect();
            if (this.zt <= 0) {
                this.zt = System.currentTimeMillis();
            }
            this.zu = System.currentTimeMillis();
            dVar.zM = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.zJ;
            if (this.sW.hW().Aa) {
                throw new BdHttpCancelException();
            }
            dVar.zM = -6;
            this.sW.hV().a(this.zs, dVar);
            dVar.zM = -7;
            if (this.sW.hW().Aa) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zs.getContentType();
            this.tt = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aB(contentType)) {
                this.zs.disconnect();
                this.zs.connect();
                if (this.sW.hW().Aa) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.zM = -8;
            this.sW.hW().e(this.zs);
            dVar.zL = this.sW.hW().responseCode;
            dVar.zF = this.zs.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zs);
            if (c != null) {
                dVar.zF += c.length;
                this.sW.hW().Af = c.length;
                this.sW.hW().Ae = c(this.sW.hW().contentEncoding, c);
            }
            dVar.zG = new Date().getTime() - currentTimeMillis;
            dVar.zM = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.zs);
        }
    }
}
