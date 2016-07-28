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
    private f eJ;
    private HttpURLConnection lw;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long lx = 0;
    private long ly = 0;
    private long fe = 0;
    private long lA = 0;
    private long lB = 0;
    private boolean lC = false;
    private boolean lD = true;
    private TimerTask lE = new c(this);
    private Timer lF = new Timer();

    public long df() {
        return this.lB;
    }

    public long dg() {
        return this.lA;
    }

    public long dh() {
        return this.lx;
    }

    public long di() {
        return this.ly;
    }

    public long dj() {
        return this.fe;
    }

    public boolean dk() {
        return this.lC;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(f fVar) {
        if (fVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.eJ = fVar;
    }

    public void dl() {
        this.eJ.dv().mh = true;
        com.baidu.adp.lib.h.a.f(this.lw);
    }

    private URL a(String str, e eVar) throws Exception {
        a de;
        URL url = new URL(str);
        if (this.lD && (de = a.de()) != null) {
            String ac = de.ac(str);
            if (!TextUtils.isEmpty(ac)) {
                this.eJ.du().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ac));
                this.lC = true;
                eVar.lU = ac;
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
        String fA;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (com.baidu.adp.lib.util.i.fq()) {
                if (com.baidu.adp.lib.util.i.fs() && (fA = com.baidu.adp.lib.util.i.fA()) != null && fA.length() > 0) {
                    if (com.baidu.adp.lib.util.i.aL(fA) && com.baidu.adp.lib.util.i.fC()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(fA);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.eJ.du().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(fA, com.baidu.adp.lib.util.i.fB())));
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
        eVar.lS = -1;
        if (this.eJ.dv().mh) {
            throw new BdHttpCancelException();
        }
        String c = this.eJ.du().c(eVar);
        eVar.url = c;
        URL a = a(c, eVar);
        if (this.eJ.dv().mh) {
            throw new BdHttpCancelException();
        }
        eVar.lS = -2;
        this.lw = d(a);
        eVar.lS = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.lw == null) {
                throw new SocketException("network not available.");
            }
            this.lw.setRequestMethod("GET");
            this.lw.setConnectTimeout(i2);
            this.lw.setReadTimeout(i);
            this.eJ.du().d(this.lw);
            if (this.eJ.dv().mh) {
                throw new BdHttpCancelException();
            }
            eVar.lP = new Date().getTime() - currentTimeMillis;
            eVar.lS = -4;
            this.lw.connect();
            if (this.lx <= 0) {
                this.lx = System.currentTimeMillis();
            }
            this.ly = System.currentTimeMillis();
            eVar.lS = -5;
            eVar.lL = (new Date().getTime() - currentTimeMillis) - eVar.lP;
            if (this.eJ.dv().mh) {
                throw new BdHttpCancelException();
            }
            String contentType = this.lw.getContentType();
            this.fe = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ag(contentType)) {
                this.lw.disconnect();
                this.lw.connect();
                if (this.eJ.dv().mh) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.lS = -8;
            this.eJ.dv().e(this.lw);
            if (c.contains("c.tieba.baidu.com") && (map = this.eJ.dv().mj) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null) {
                eVar.lV = list.get(0);
                eVar.lW = list.get(1);
            }
            eVar.lR = this.eJ.dv().responseCode;
            eVar.lK = this.lw.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.lw);
            if (c2 != null) {
                eVar.lK += c2.length;
                this.eJ.dv().mk = c(this.eJ.dv().contentEncoding, c2);
            }
            eVar.lS = -9;
            eVar.lM = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.lw != null) {
                this.lw.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.lB = System.currentTimeMillis();
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
                while (!this.eJ.dv().mh && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.lA = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
                        com.baidu.adp.lib.h.a.j(inputStream);
                        throw th;
                    }
                }
                if (this.eJ.dv().mh) {
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
        this.lA = System.currentTimeMillis();
        com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
        com.baidu.adp.lib.h.a.j(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, e eVar) throws Exception {
        eVar.lS = -1;
        try {
            String url = this.eJ.du().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.eJ.dv().mh) {
                throw new BdHttpCancelException();
            }
            eVar.lS = -2;
            this.lw = d(a);
            eVar.lS = -3;
            System.currentTimeMillis();
            if (this.lw == null) {
                throw new SocketException("network not available.");
            }
            this.lw.setRequestMethod("POST");
            this.lw.setDoOutput(true);
            this.lw.setDoInput(true);
            this.lw.setConnectTimeout(i2);
            this.lw.setReadTimeout(i);
            this.lw.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.eJ.dv().mh) {
                throw new BdHttpCancelException();
            }
            this.eJ.du().d(this.lw);
            if (this.eJ.dv().mh) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            eVar.lP = new Date().getTime() - time;
            eVar.lS = -4;
            this.lw.connect();
            if (this.lx <= 0) {
                this.lx = System.currentTimeMillis();
            }
            this.ly = System.currentTimeMillis();
            eVar.lS = -5;
            eVar.lL = (new Date().getTime() - time) - eVar.lP;
            if (this.eJ.dv().mh) {
                throw new BdHttpCancelException();
            }
            if (this.lF != null) {
                this.lF.schedule(this.lE, 45000L);
            }
            eVar.lS = -6;
            this.eJ.du().a(this.lw, boundary, eVar);
            eVar.lS = -7;
            String contentType = this.lw.getContentType();
            this.fe = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ag(contentType)) {
                this.lw.disconnect();
                this.lw.connect();
                if (this.eJ.dv().mh) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.eJ.dv().mh) {
                throw new BdHttpCancelException();
            }
            eVar.lS = -8;
            this.eJ.dv().e(this.lw);
            eVar.lR = this.eJ.dv().responseCode;
            eVar.lK = this.lw.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.lw);
            if (c != null) {
                eVar.lK += c.length;
                this.eJ.dv().ml = c.length;
                this.eJ.dv().mk = c(this.eJ.dv().contentEncoding, c);
            }
            eVar.lM = new Date().getTime() - time;
            eVar.lS = -9;
        } finally {
            if (this.lF != null) {
                this.lF.cancel();
            }
            com.baidu.adp.lib.h.a.f(this.lw);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [685=6, 686=6, 687=6, 688=6] */
    public boolean a(String str, i iVar, int i, int i2, boolean z, e eVar, boolean z2) throws Exception {
        InputStream inputStream;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        e eVar2 = eVar == null ? new e() : eVar;
        try {
            String url = this.eJ.du().getUrl();
            eVar2.url = url;
            URL a = a(url, eVar2);
            this.lw = b(a, i2, i);
            if (this.eJ.dv().mh) {
                this.lA = System.currentTimeMillis();
                com.baidu.adp.lib.h.a.j(null);
                com.baidu.adp.lib.h.a.f(this.lw);
                com.baidu.adp.lib.h.a.d(null);
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
                this.eJ.du().d(this.lw);
                this.lw.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                this.lw.connect();
                if (this.lx <= 0) {
                    this.lx = System.currentTimeMillis();
                }
                this.ly = System.currentTimeMillis();
                int responseCode = this.lw.getResponseCode();
                this.fe = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.lw.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.h.a.f(this.lw);
                        this.lw = b(new URL(url2.toString()), i2, i);
                        this.eJ.du().d(this.lw);
                        this.lw.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                        this.lw.connect();
                        responseCode = this.lw.getResponseCode();
                    }
                }
                this.eJ.dv().responseCode = responseCode;
                if (dm()) {
                    if (this.lw.getContentType() != null && this.lw.getContentType().contains("text/vnd.wap.wml")) {
                        this.lw.disconnect();
                        this.eJ.dv().responseCode = 0;
                        boolean a2 = a(str, iVar, i, i2, z, eVar2, z2);
                        this.lA = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.j(null);
                        com.baidu.adp.lib.h.a.f(this.lw);
                        com.baidu.adp.lib.h.a.d(fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.lw.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.h.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.eJ.dv().responseCode == 200 && (headerField = this.lw.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.h.b.g(headerField, 0) : i3;
                    this.eJ.dv().contentLength = String.valueOf(g);
                    eVar2.lJ = url.getBytes().length;
                    eVar2.lK = this.lw.getHeaderFields().toString().getBytes().length;
                    eVar2.lK += g;
                    if (this.eJ.dv().responseCode == 416 || this.eJ.dv().responseCode == 204) {
                        this.lA = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.j(null);
                        com.baidu.adp.lib.h.a.f(this.lw);
                        com.baidu.adp.lib.h.a.d(fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.lA = System.currentTimeMillis();
                        this.lA = System.currentTimeMillis();
                        com.baidu.adp.lib.h.a.j(null);
                        com.baidu.adp.lib.h.a.f(this.lw);
                        com.baidu.adp.lib.h.a.d(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.lw.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (iVar != null && length > 0) {
                                iVar.d((int) length, g);
                            }
                            while (!this.eJ.dv().mh) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (iVar != null && (i6 > i5 || i4 == g)) {
                                            i6 = 0;
                                            iVar.d((int) (i4 + length), g);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) g);
                                this.lA = System.currentTimeMillis();
                                com.baidu.adp.lib.h.a.j(inputStream2);
                                com.baidu.adp.lib.h.a.f(this.lw);
                                com.baidu.adp.lib.h.a.d(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.lA = System.currentTimeMillis();
                            com.baidu.adp.lib.h.a.j(inputStream);
                            com.baidu.adp.lib.h.a.f(this.lw);
                            com.baidu.adp.lib.h.a.d(fileOutputStream);
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

    private boolean dm() {
        return this.eJ.dv().responseCode == 200 || this.eJ.dv().responseCode == 206;
    }

    public void c(int i, int i2, e eVar) throws Exception {
        eVar.lS = -1;
        try {
            String url = this.eJ.du().getUrl();
            eVar.url = url;
            URL a = a(url, eVar);
            if (this.eJ.dv().mh) {
                throw new BdHttpCancelException();
            }
            eVar.lS = -2;
            this.lw = d(a);
            eVar.lS = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.lw == null) {
                throw new SocketException("network not available.");
            }
            this.lw.setRequestMethod("POST");
            this.lw.setDoOutput(true);
            this.lw.setDoInput(true);
            this.lw.setConnectTimeout(i2);
            this.lw.setReadTimeout(i);
            this.lw.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.eJ.dv().mh) {
                throw new BdHttpCancelException();
            }
            this.eJ.du().d(this.lw);
            if (this.eJ.dv().mh) {
                throw new BdHttpCancelException();
            }
            eVar.lP = System.currentTimeMillis() - currentTimeMillis;
            eVar.lS = -4;
            this.lw.connect();
            if (this.lx <= 0) {
                this.lx = System.currentTimeMillis();
            }
            this.ly = System.currentTimeMillis();
            eVar.lS = -5;
            eVar.lL = (System.currentTimeMillis() - currentTimeMillis) - eVar.lP;
            if (this.eJ.dv().mh) {
                throw new BdHttpCancelException();
            }
            eVar.lS = -6;
            this.eJ.du().a(this.lw, eVar);
            eVar.lS = -7;
            if (this.eJ.dv().mh) {
                throw new BdHttpCancelException();
            }
            String contentType = this.lw.getContentType();
            this.fe = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ag(contentType)) {
                this.lw.disconnect();
                this.lw.connect();
                if (this.eJ.dv().mh) {
                    throw new BdHttpCancelException();
                }
            }
            eVar.lS = -8;
            this.eJ.dv().e(this.lw);
            eVar.lR = this.eJ.dv().responseCode;
            eVar.lK = this.lw.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.lw);
            if (c != null) {
                eVar.lK += c.length;
                this.eJ.dv().ml = c.length;
                this.eJ.dv().mk = c(this.eJ.dv().contentEncoding, c);
            }
            eVar.lM = new Date().getTime() - currentTimeMillis;
            eVar.lS = -9;
        } finally {
            com.baidu.adp.lib.h.a.f(this.lw);
        }
    }
}
