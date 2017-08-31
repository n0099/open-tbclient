package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.lib.util.i;
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
import org.apache.http.entity.mime.MIME;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private e nG;
    private HttpURLConnection uD;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long uE = 0;
    private long uF = 0;
    private long ob = 0;
    private long uG = 0;
    private long uH = 0;
    private boolean uI = false;
    private boolean uJ = true;
    private TimerTask uK = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.fp();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer uL = new Timer();

    public long fj() {
        return this.uH;
    }

    public long fk() {
        return this.uG;
    }

    public long fl() {
        return this.uE;
    }

    public long fm() {
        return this.uF;
    }

    public long fn() {
        return this.ob;
    }

    public boolean fo() {
        return this.uI;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.nG = eVar;
    }

    public void fp() {
        this.nG.fA().vl = true;
        com.baidu.adp.lib.g.a.f(this.uD);
    }

    private URL a(String str, d dVar) throws Exception {
        a fi;
        URL url = new URL(str);
        if (this.uJ && (fi = a.fi()) != null) {
            String ag = fi.ag(str);
            if (!TextUtils.isEmpty(ag)) {
                this.nG.fz().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ag));
                this.uI = true;
                dVar.uZ = ag;
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
        String hs;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (i.hi()) {
                if (i.hk() && (hs = i.hs()) != null && hs.length() > 0) {
                    if (i.aK(hs) && i.hu()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(hs);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.nG.fz().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hs, i.ht())));
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
        dVar.uX = -1;
        if (this.nG.fA().vl) {
            throw new BdHttpCancelException();
        }
        String c = this.nG.fz().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.nG.fA().vl) {
            throw new BdHttpCancelException();
        }
        dVar.uX = -2;
        this.uD = c(a);
        dVar.uX = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.uD == null) {
                throw new SocketException("network not available.");
            }
            this.uD.setRequestMethod("GET");
            this.uD.setConnectTimeout(i2);
            this.uD.setReadTimeout(i);
            this.nG.fz().d(this.uD);
            if (this.nG.fA().vl) {
                throw new BdHttpCancelException();
            }
            dVar.uU = new Date().getTime() - currentTimeMillis;
            dVar.uX = -4;
            this.uD.connect();
            if (this.uE <= 0) {
                this.uE = System.currentTimeMillis();
            }
            this.uF = System.currentTimeMillis();
            dVar.uX = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.uU;
            if (this.nG.fA().vl) {
                throw new BdHttpCancelException();
            }
            String contentType = this.uD.getContentType();
            this.ob = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ak(contentType)) {
                this.uD.disconnect();
                this.uD.connect();
                if (this.nG.fA().vl) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uX = -8;
            this.nG.fA().e(this.uD);
            if (c.contains("c.tieba.baidu.com") && (map = this.nG.fA().vn) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.va = list.get(0);
                dVar.vb = list.get(1);
            }
            dVar.uW = this.nG.fA().responseCode;
            dVar.uQ = this.uD.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.uD);
            if (c2 != null) {
                dVar.uQ += c2.length;
                this.nG.fA().vo = c(this.nG.fA().contentEncoding, c2);
            }
            dVar.uX = -9;
            dVar.uR = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.uD != null) {
                this.uD.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.uH = System.currentTimeMillis();
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
                while (!this.nG.fA().vl && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.uG = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.nG.fA().vl) {
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
        this.uG = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.uX = -1;
        try {
            String url = this.nG.fz().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.nG.fA().vl) {
                throw new BdHttpCancelException();
            }
            dVar.uX = -2;
            this.uD = c(a);
            dVar.uX = -3;
            System.currentTimeMillis();
            if (this.uD == null) {
                throw new SocketException("network not available.");
            }
            this.uD.setRequestMethod("POST");
            this.uD.setDoOutput(true);
            this.uD.setDoInput(true);
            this.uD.setConnectTimeout(i2);
            this.uD.setReadTimeout(i);
            this.uD.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.nG.fA().vl) {
                throw new BdHttpCancelException();
            }
            this.nG.fz().d(this.uD);
            if (this.nG.fA().vl) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.uU = new Date().getTime() - time;
            dVar.uX = -4;
            this.uD.connect();
            if (this.uE <= 0) {
                this.uE = System.currentTimeMillis();
            }
            this.uF = System.currentTimeMillis();
            dVar.uX = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.uU;
            if (this.nG.fA().vl) {
                throw new BdHttpCancelException();
            }
            if (this.uL != null) {
                this.uL.schedule(this.uK, 45000L);
            }
            dVar.uX = -6;
            this.nG.fz().a(this.uD, boundary, dVar);
            dVar.uX = -7;
            String contentType = this.uD.getContentType();
            this.ob = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ak(contentType)) {
                this.uD.disconnect();
                this.uD.connect();
                if (this.nG.fA().vl) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.nG.fA().vl) {
                throw new BdHttpCancelException();
            }
            dVar.uX = -8;
            this.nG.fA().e(this.uD);
            dVar.uW = this.nG.fA().responseCode;
            dVar.uQ = this.uD.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.uD);
            if (c != null) {
                dVar.uQ += c.length;
                this.nG.fA().vp = c.length;
                this.nG.fA().vo = c(this.nG.fA().contentEncoding, c);
            }
            dVar.uR = new Date().getTime() - time;
            dVar.uX = -9;
        } finally {
            if (this.uL != null) {
                this.uL.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.uD);
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
            String url = this.nG.fz().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.uD = a(a, i2, i);
            if (this.nG.fA().vl) {
                this.uG = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.f(this.uD);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.e.aE(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.e.aC(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.nG.fz().d(this.uD);
                this.uD.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.uD.connect();
                if (this.uE <= 0) {
                    this.uE = System.currentTimeMillis();
                }
                this.uF = System.currentTimeMillis();
                int responseCode = this.uD.getResponseCode();
                this.ob = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.uD.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.f(this.uD);
                        this.uD = a(new URL(url2.toString()), i2, i);
                        this.nG.fz().d(this.uD);
                        this.uD.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.uD.connect();
                        responseCode = this.uD.getResponseCode();
                    }
                }
                this.nG.fA().responseCode = responseCode;
                if (fq()) {
                    if (this.uD.getContentType() != null && this.uD.getContentType().contains("text/vnd.wap.wml")) {
                        this.uD.disconnect();
                        this.nG.fA().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.uG = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.uD);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.uD.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.nG.fA().responseCode == 200 && (headerField = this.uD.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.nG.fA().contentLength = String.valueOf(g);
                    dVar2.uP = url.getBytes().length;
                    dVar2.uQ = this.uD.getHeaderFields().toString().getBytes().length;
                    dVar2.uQ += g;
                    if (this.nG.fA().responseCode == 416 || this.nG.fA().responseCode == 204) {
                        this.uG = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.uD);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.uG = System.currentTimeMillis();
                        this.uG = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.uD);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.uD.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.m((int) length, g);
                            }
                            while (!this.nG.fA().vl) {
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
                                this.uG = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.uD);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.uG = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.f(this.uD);
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

    private boolean fq() {
        return this.nG.fA().responseCode == 200 || this.nG.fA().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.uX = -1;
        try {
            String url = this.nG.fz().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.nG.fA().vl) {
                throw new BdHttpCancelException();
            }
            dVar.uX = -2;
            this.uD = c(a);
            dVar.uX = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.uD == null) {
                throw new SocketException("network not available.");
            }
            this.uD.setRequestMethod("POST");
            this.uD.setDoOutput(true);
            this.uD.setDoInput(true);
            this.uD.setConnectTimeout(i2);
            this.uD.setReadTimeout(i);
            this.uD.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.nG.fA().vl) {
                throw new BdHttpCancelException();
            }
            this.nG.fz().d(this.uD);
            if (this.nG.fA().vl) {
                throw new BdHttpCancelException();
            }
            dVar.uU = System.currentTimeMillis() - currentTimeMillis;
            dVar.uX = -4;
            this.uD.connect();
            if (this.uE <= 0) {
                this.uE = System.currentTimeMillis();
            }
            this.uF = System.currentTimeMillis();
            dVar.uX = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.uU;
            if (this.nG.fA().vl) {
                throw new BdHttpCancelException();
            }
            dVar.uX = -6;
            this.nG.fz().a(this.uD, dVar);
            dVar.uX = -7;
            if (this.nG.fA().vl) {
                throw new BdHttpCancelException();
            }
            String contentType = this.uD.getContentType();
            this.ob = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ak(contentType)) {
                this.uD.disconnect();
                this.uD.connect();
                if (this.nG.fA().vl) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uX = -8;
            this.nG.fA().e(this.uD);
            dVar.uW = this.nG.fA().responseCode;
            dVar.uQ = this.uD.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.uD);
            if (c != null) {
                dVar.uQ += c.length;
                this.nG.fA().vp = c.length;
                this.nG.fA().vo = c(this.nG.fA().contentEncoding, c);
            }
            dVar.uR = new Date().getTime() - currentTimeMillis;
            dVar.uX = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.uD);
        }
    }
}
