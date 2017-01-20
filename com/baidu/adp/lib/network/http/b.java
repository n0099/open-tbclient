package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
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
    private f gT;
    private HttpURLConnection nK;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long nL = 0;
    private long nM = 0;
    private long hp = 0;
    private long nN = 0;
    private long nO = 0;
    private boolean nP = false;
    private boolean nQ = true;
    private TimerTask nR = new c(this);
    private Timer nS = new Timer();

    public long dY() {
        return this.nO;
    }

    public long dZ() {
        return this.nN;
    }

    public long ea() {
        return this.nL;
    }

    public long eb() {
        return this.nM;
    }

    public long ec() {
        return this.hp;
    }

    public boolean ed() {
        return this.nP;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.gT = fVar;
    }

    public void ee() {
        this.gT.eo().ox = true;
        com.baidu.adp.lib.g.a.f(this.nK);
    }

    private URL a(String str, e eVar) throws Exception {
        a dX;
        URL url = new URL(str);
        if (this.nQ && (dX = a.dX()) != null) {
            String ad = dX.ad(str);
            if (!TextUtils.isEmpty(ad)) {
                this.gT.en().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ad));
                this.nP = true;
                eVar.oh = ad;
                return url2;
            }
        }
        return url;
    }

    private HttpURLConnection b(URL url, int i, int i2) throws SocketException {
        HttpURLConnection d = d(url);
        if (d != null) {
            d.setConnectTimeout(i);
            d.setReadTimeout(i2);
            return d;
        }
        throw new SocketException();
    }

    private HttpURLConnection d(URL url) {
        HttpURLConnection httpURLConnection;
        Exception e;
        String gu;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.i.gk()) {
                if (com.baidu.adp.lib.util.i.gm() && (gu = com.baidu.adp.lib.util.i.gu()) != null && gu.length() > 0) {
                    if (com.baidu.adp.lib.util.i.aL(gu) && com.baidu.adp.lib.util.i.gw()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(gu);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.gT.en().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(gu, com.baidu.adp.lib.util.i.gv())));
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

    public void a(int i, int i2, e eVar) throws Exception {
        Map<String, List<String>> map;
        List<String> list;
        eVar.of = -1;
        if (this.gT.eo().ox) {
            throw new BdHttpCancelException();
        }
        String c = this.gT.en().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.gT.eo().ox) {
            throw new BdHttpCancelException();
        }
        eVar.of = -2;
        this.nK = d(a);
        eVar.of = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.nK == null) {
                throw new SocketException("network not available.");
            }
            this.nK.setRequestMethod("GET");
            this.nK.setConnectTimeout(i2);
            this.nK.setReadTimeout(i);
            this.gT.en().d(this.nK);
            if (this.gT.eo().ox) {
                throw new BdHttpCancelException();
            }
            eVar.oc = new Date().getTime() - currentTimeMillis;
            eVar.of = -4;
            this.nK.connect();
            if (this.nL <= 0) {
                this.nL = System.currentTimeMillis();
            }
            this.nM = System.currentTimeMillis();
            eVar.of = -5;
            eVar.nY = (new Date().getTime() - currentTimeMillis) - eVar.oc;
            if (this.gT.eo().ox) {
                throw new BdHttpCancelException();
            }
            String contentType = this.nK.getContentType();
            this.hp = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ah(contentType)) {
                this.nK.disconnect();
                this.nK.connect();
                if (this.gT.eo().ox) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.of = -8;
            this.gT.eo().e(this.nK);
            if (c.contains("c.tieba.baidu.com") && (map = this.gT.eo().oz) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                eVar.oi = list.get(0);
                eVar.oj = list.get(1);
            }
            eVar.oe = this.gT.eo().responseCode;
            eVar.nX = this.nK.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.nK);
            if (c2 != null) {
                eVar.nX += c2.length;
                this.gT.eo().oA = c(this.gT.eo().contentEncoding, c2);
            }
            eVar.of = -9;
            eVar.nZ = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.nK != null) {
                this.nK.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.nO = System.currentTimeMillis();
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
                while (!this.gT.eo().ox && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.nN = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.j(inputStream);
                        throw th;
                    }
                }
                if (this.gT.eo().ox) {
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
        this.nN = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.j(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.of = -1;
        try {
            String url = this.gT.en().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gT.eo().ox) {
                throw new BdHttpCancelException();
            }
            eVar.of = -2;
            this.nK = d(a);
            eVar.of = -3;
            System.currentTimeMillis();
            if (this.nK == null) {
                throw new SocketException("network not available.");
            }
            this.nK.setRequestMethod("POST");
            this.nK.setDoOutput(true);
            this.nK.setDoInput(true);
            this.nK.setConnectTimeout(i2);
            this.nK.setReadTimeout(i);
            this.nK.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.gT.eo().ox) {
                throw new BdHttpCancelException();
            }
            this.gT.en().d(this.nK);
            if (this.gT.eo().ox) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.oc = new Date().getTime() - time;
            eVar.of = -4;
            this.nK.connect();
            if (this.nL <= 0) {
                this.nL = System.currentTimeMillis();
            }
            this.nM = System.currentTimeMillis();
            eVar.of = -5;
            eVar.nY = (new Date().getTime() - time) - eVar.oc;
            if (this.gT.eo().ox) {
                throw new BdHttpCancelException();
            }
            if (this.nS != null) {
                this.nS.schedule(this.nR, 45000L);
            }
            eVar.of = -6;
            this.gT.en().a(this.nK, boundary, eVar);
            eVar.of = -7;
            String contentType = this.nK.getContentType();
            this.hp = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ah(contentType)) {
                this.nK.disconnect();
                this.nK.connect();
                if (this.gT.eo().ox) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.gT.eo().ox) {
                throw new BdHttpCancelException();
            }
            eVar.of = -8;
            this.gT.eo().e(this.nK);
            eVar.oe = this.gT.eo().responseCode;
            eVar.nX = this.nK.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.nK);
            if (c != null) {
                eVar.nX += c.length;
                this.gT.eo().oB = c.length;
                this.gT.eo().oA = c(this.gT.eo().contentEncoding, c);
            }
            eVar.nZ = new Date().getTime() - time;
            eVar.of = -9;
        } finally {
            if (this.nS != null) {
                this.nS.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.nK);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [684=6, 685=6, 686=6, 687=6] */
    public boolean a(String str, i iVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.gT.en().getUrl();
            eVar2.url = url;
            URL a = a(url, eVar2);
            this.nK = b(a, i2, i);
            if (this.gT.eo().ox) {
                this.nN = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.j(null);
                com.baidu.adp.lib.g.a.f(this.nK);
                com.baidu.adp.lib.g.a.d(null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.e.delFile(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.e.aE(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.gT.en().d(this.nK);
                this.nK.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.nK.connect();
                if (this.nL <= 0) {
                    this.nL = System.currentTimeMillis();
                }
                this.nM = System.currentTimeMillis();
                int responseCode = this.nK.getResponseCode();
                this.hp = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.nK.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.f(this.nK);
                        this.nK = b(new URL(url2.toString()), i2, i);
                        this.gT.en().d(this.nK);
                        this.nK.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.nK.connect();
                        responseCode = this.nK.getResponseCode();
                    }
                }
                this.gT.eo().responseCode = responseCode;
                if (ef()) {
                    if (this.nK.getContentType() != null && this.nK.getContentType().contains("text/vnd.wap.wml")) {
                        this.nK.disconnect();
                        this.gT.eo().responseCode = 0;
                        boolean a2 = a(str, iVar, i, i2, z, eVar2, z2);
                        this.nN = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.f(this.nK);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.nK.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.gT.eo().responseCode == 200 && (headerField = this.nK.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.gT.eo().contentLength = String.valueOf(g);
                    eVar2.nW = url.getBytes().length;
                    eVar2.nX = this.nK.getHeaderFields().toString().getBytes().length;
                    eVar2.nX += g;
                    if (this.gT.eo().responseCode == 416 || this.gT.eo().responseCode == 204) {
                        this.nN = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.f(this.nK);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.nN = System.currentTimeMillis();
                        this.nN = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.j(null);
                        com.baidu.adp.lib.g.a.f(this.nK);
                        com.baidu.adp.lib.g.a.d(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.nK.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (iVar != null && length > 0) {
                                iVar.f((int) length, g);
                            }
                            while (!this.gT.eo().ox) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (iVar != null && (i6 > i5 || i4 == g)) {
                                            i6 = 0;
                                            iVar.f((int) (i4 + length), g);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) g);
                                this.nN = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.j(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.nK);
                                com.baidu.adp.lib.g.a.d(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.nN = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.j(inputStream);
                            com.baidu.adp.lib.g.a.f(this.nK);
                            com.baidu.adp.lib.g.a.d(fileOutputStream);
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

    private boolean ef() {
        return this.gT.eo().responseCode == 200 || this.gT.eo().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.of = -1;
        try {
            String url = this.gT.en().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.gT.eo().ox) {
                throw new BdHttpCancelException();
            }
            eVar.of = -2;
            this.nK = d(a);
            eVar.of = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.nK == null) {
                throw new SocketException("network not available.");
            }
            this.nK.setRequestMethod("POST");
            this.nK.setDoOutput(true);
            this.nK.setDoInput(true);
            this.nK.setConnectTimeout(i2);
            this.nK.setReadTimeout(i);
            this.nK.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.gT.eo().ox) {
                throw new BdHttpCancelException();
            }
            this.gT.en().d(this.nK);
            if (this.gT.eo().ox) {
                throw new BdHttpCancelException();
            }
            eVar.oc = System.currentTimeMillis() - currentTimeMillis;
            eVar.of = -4;
            this.nK.connect();
            if (this.nL <= 0) {
                this.nL = System.currentTimeMillis();
            }
            this.nM = System.currentTimeMillis();
            eVar.of = -5;
            eVar.nY = (System.currentTimeMillis() - currentTimeMillis) - eVar.oc;
            if (this.gT.eo().ox) {
                throw new BdHttpCancelException();
            }
            eVar.of = -6;
            this.gT.en().a(this.nK, eVar);
            eVar.of = -7;
            if (this.gT.eo().ox) {
                throw new BdHttpCancelException();
            }
            String contentType = this.nK.getContentType();
            this.hp = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ah(contentType)) {
                this.nK.disconnect();
                this.nK.connect();
                if (this.gT.eo().ox) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.of = -8;
            this.gT.eo().e(this.nK);
            eVar.oe = this.gT.eo().responseCode;
            eVar.nX = this.nK.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.nK);
            if (c != null) {
                eVar.nX += c.length;
                this.gT.eo().oB = c.length;
                this.gT.eo().oA = c(this.gT.eo().contentEncoding, c);
            }
            eVar.nZ = new Date().getTime() - currentTimeMillis;
            eVar.of = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.nK);
        }
    }
}
