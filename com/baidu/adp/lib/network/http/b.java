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
    private e sN;
    private HttpURLConnection zm;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long zn = 0;
    private long zo = 0;
    private long ti = 0;
    private long zp = 0;
    private long zq = 0;
    private boolean zr = false;
    private boolean zs = true;
    private TimerTask zt = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.hN();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer zu = new Timer();

    public long hH() {
        return this.zq;
    }

    public long hI() {
        return this.zp;
    }

    public long hJ() {
        return this.zn;
    }

    public long hK() {
        return this.zo;
    }

    public long hL() {
        return this.ti;
    }

    public boolean hM() {
        return this.zr;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.sN = eVar;
    }

    public void hN() {
        this.sN.hX().zU = true;
        com.baidu.adp.lib.g.a.f(this.zm);
    }

    private URL a(String str, d dVar) throws Exception {
        a hG;
        URL url = new URL(str);
        if (this.zs && (hG = a.hG()) != null) {
            String ay = hG.ay(str);
            if (!TextUtils.isEmpty(ay)) {
                this.sN.hW().p("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ay));
                this.zr = true;
                dVar.zI = ay;
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
        String jO;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.jE()) {
                if (j.jG() && (jO = j.jO()) != null && jO.length() > 0) {
                    if (j.be(jO) && j.jQ()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(jO);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.sN.hW().p("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(jO, j.jP())));
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
        dVar.zG = -1;
        if (this.sN.hX().zU) {
            throw new BdHttpCancelException();
        }
        String c = this.sN.hW().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.sN.hX().zU) {
            throw new BdHttpCancelException();
        }
        dVar.zG = -2;
        this.zm = c(a);
        dVar.zG = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.zm == null) {
                throw new SocketException("network not available.");
            }
            this.zm.setRequestMethod("GET");
            this.zm.setConnectTimeout(i2);
            this.zm.setReadTimeout(i);
            this.sN.hW().d(this.zm);
            if (this.sN.hX().zU) {
                throw new BdHttpCancelException();
            }
            dVar.zD = new Date().getTime() - currentTimeMillis;
            dVar.zG = -4;
            this.zm.connect();
            if (this.zn <= 0) {
                this.zn = System.currentTimeMillis();
            }
            this.zo = System.currentTimeMillis();
            dVar.zG = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.zD;
            if (this.sN.hX().zU) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zm.getContentType();
            this.ti = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aE(contentType)) {
                this.zm.disconnect();
                this.zm.connect();
                if (this.sN.hX().zU) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.zG = -8;
            this.sN.hX().e(this.zm);
            if (c.contains("c.tieba.baidu.com") && (map = this.sN.hX().zW) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.zJ = list.get(0);
                dVar.zK = list.get(1);
            }
            dVar.zF = this.sN.hX().responseCode;
            dVar.zz = this.zm.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.zm);
            if (c2 != null) {
                dVar.zz += c2.length;
                this.sN.hX().zX = c(this.sN.hX().contentEncoding, c2);
            }
            dVar.zG = -9;
            dVar.zA = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.zm != null) {
                this.zm.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.zq = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.zq == 0) {
            this.zq = System.currentTimeMillis();
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
                while (!this.sN.hX().zU && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.zp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.f(inputStream);
                        throw th;
                    }
                }
                if (this.sN.hX().zU) {
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
        this.zp = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.f(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.zG = -1;
        try {
            String url = this.sN.hW().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.sN.hX().zU) {
                throw new BdHttpCancelException();
            }
            dVar.zG = -2;
            this.zm = c(a);
            dVar.zG = -3;
            System.currentTimeMillis();
            if (this.zm == null) {
                throw new SocketException("network not available.");
            }
            this.zm.setRequestMethod("POST");
            this.zm.setDoOutput(true);
            this.zm.setDoInput(true);
            this.zm.setConnectTimeout(i2);
            this.zm.setReadTimeout(i);
            this.zm.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.sN.hX().zU) {
                throw new BdHttpCancelException();
            }
            this.sN.hW().d(this.zm);
            if (this.sN.hX().zU) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.zD = new Date().getTime() - time;
            dVar.zG = -4;
            this.zm.connect();
            if (this.zn <= 0) {
                this.zn = System.currentTimeMillis();
            }
            this.zo = System.currentTimeMillis();
            dVar.zG = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.zD;
            if (this.sN.hX().zU) {
                throw new BdHttpCancelException();
            }
            if (this.zu != null) {
                this.zu.schedule(this.zt, 45000L);
            }
            dVar.zG = -6;
            this.sN.hW().a(this.zm, boundary, dVar);
            dVar.zG = -7;
            String contentType = this.zm.getContentType();
            this.ti = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aE(contentType)) {
                this.zm.disconnect();
                this.zm.connect();
                if (this.sN.hX().zU) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.sN.hX().zU) {
                throw new BdHttpCancelException();
            }
            dVar.zG = -8;
            this.sN.hX().e(this.zm);
            dVar.zF = this.sN.hX().responseCode;
            dVar.zz = this.zm.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zm);
            if (c != null) {
                dVar.zz += c.length;
                this.sN.hX().zY = c.length;
                this.sN.hX().zX = c(this.sN.hX().contentEncoding, c);
            }
            dVar.zA = new Date().getTime() - time;
            dVar.zG = -9;
        } finally {
            if (this.zu != null) {
                this.zu.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.zm);
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
            String url = this.sN.hW().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.zm = a(a, i2, i);
            if (this.sN.hX().zU) {
                this.zp = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.f((InputStream) null);
                com.baidu.adp.lib.g.a.f(this.zm);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aY(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aW(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.sN.hW().d(this.zm);
                this.zm.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.zm.connect();
                if (this.zn <= 0) {
                    this.zn = System.currentTimeMillis();
                }
                this.zo = System.currentTimeMillis();
                int responseCode = this.zm.getResponseCode();
                this.ti = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.zm.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.f(this.zm);
                        this.zm = a(new URL(url2.toString()), i2, i);
                        this.sN.hW().d(this.zm);
                        this.zm.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.zm.connect();
                        responseCode = this.zm.getResponseCode();
                    }
                }
                this.sN.hX().responseCode = responseCode;
                if (hO()) {
                    if (this.zm.getContentType() != null && this.zm.getContentType().contains("text/vnd.wap.wml")) {
                        this.zm.disconnect();
                        this.sN.hX().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.zp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zm);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.zm.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.sN.hX().responseCode == 200 && (headerField = this.zm.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.sN.hX().contentLength = String.valueOf(g);
                    dVar2.zy = url.getBytes().length;
                    dVar2.zz = this.zm.getHeaderFields().toString().getBytes().length;
                    dVar2.zz += g;
                    if (this.sN.hX().responseCode == 416 || this.sN.hX().responseCode == 204) {
                        this.zp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zm);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.zp = System.currentTimeMillis();
                        this.zp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.f((InputStream) null);
                        com.baidu.adp.lib.g.a.f(this.zm);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.zm.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.m((int) length, g);
                            }
                            while (!this.sN.hX().zU) {
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
                                this.zp = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.f(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.zm);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.zp = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.f(inputStream);
                            com.baidu.adp.lib.g.a.f(this.zm);
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
        return this.sN.hX().responseCode == 200 || this.sN.hX().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.zG = -1;
        try {
            String url = this.sN.hW().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.sN.hX().zU) {
                throw new BdHttpCancelException();
            }
            dVar.zG = -2;
            this.zm = c(a);
            dVar.zG = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zm == null) {
                throw new SocketException("network not available.");
            }
            this.zm.setRequestMethod("POST");
            this.zm.setDoOutput(true);
            this.zm.setDoInput(true);
            this.zm.setConnectTimeout(i2);
            this.zm.setReadTimeout(i);
            this.zm.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.sN.hX().zU) {
                throw new BdHttpCancelException();
            }
            this.sN.hW().d(this.zm);
            if (this.sN.hX().zU) {
                throw new BdHttpCancelException();
            }
            dVar.zD = System.currentTimeMillis() - currentTimeMillis;
            dVar.zG = -4;
            this.zm.connect();
            if (this.zn <= 0) {
                this.zn = System.currentTimeMillis();
            }
            this.zo = System.currentTimeMillis();
            dVar.zG = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.zD;
            if (this.sN.hX().zU) {
                throw new BdHttpCancelException();
            }
            dVar.zG = -6;
            this.sN.hW().a(this.zm, dVar);
            dVar.zG = -7;
            if (this.sN.hX().zU) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zm.getContentType();
            this.ti = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aE(contentType)) {
                this.zm.disconnect();
                this.zm.connect();
                if (this.sN.hX().zU) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.zG = -8;
            this.sN.hX().e(this.zm);
            dVar.zF = this.sN.hX().responseCode;
            dVar.zz = this.zm.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zm);
            if (c != null) {
                dVar.zz += c.length;
                this.sN.hX().zY = c.length;
                this.sN.hX().zX = c(this.sN.hX().contentEncoding, c);
            }
            dVar.zA = new Date().getTime() - currentTimeMillis;
            dVar.zG = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.zm);
        }
    }
}
