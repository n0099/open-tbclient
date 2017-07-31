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
    private e pW;
    private HttpURLConnection wL;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long wM = 0;
    private long wN = 0;
    private long qr = 0;
    private long wO = 0;
    private long wP = 0;
    private boolean wQ = false;
    private boolean wR = true;
    private TimerTask wS = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.fA();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer wT = new Timer();

    public long fu() {
        return this.wP;
    }

    public long fv() {
        return this.wO;
    }

    public long fw() {
        return this.wM;
    }

    public long fx() {
        return this.wN;
    }

    public long fy() {
        return this.qr;
    }

    public boolean fz() {
        return this.wQ;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.pW = eVar;
    }

    public void fA() {
        this.pW.fK().xs = true;
        com.baidu.adp.lib.g.a.h(this.wL);
    }

    private URL a(String str, d dVar) throws Exception {
        a ft;
        URL url = new URL(str);
        if (this.wR && (ft = a.ft()) != null) {
            String am = ft.am(str);
            if (!TextUtils.isEmpty(am)) {
                this.pW.fJ().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + am));
                this.wQ = true;
                dVar.xg = am;
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
        String hB;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (i.hr()) {
                if (i.ht() && (hB = i.hB()) != null && hB.length() > 0) {
                    if (i.aN(hB) && i.hD()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(hB);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.pW.fJ().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hB, i.hC())));
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
        dVar.xe = -1;
        if (this.pW.fK().xs) {
            throw new BdHttpCancelException();
        }
        String c = this.pW.fJ().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.pW.fK().xs) {
            throw new BdHttpCancelException();
        }
        dVar.xe = -2;
        this.wL = d(a);
        dVar.xe = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.wL == null) {
                throw new SocketException("network not available.");
            }
            this.wL.setRequestMethod("GET");
            this.wL.setConnectTimeout(i2);
            this.wL.setReadTimeout(i);
            this.pW.fJ().f(this.wL);
            if (this.pW.fK().xs) {
                throw new BdHttpCancelException();
            }
            dVar.xb = new Date().getTime() - currentTimeMillis;
            dVar.xe = -4;
            this.wL.connect();
            if (this.wM <= 0) {
                this.wM = System.currentTimeMillis();
            }
            this.wN = System.currentTimeMillis();
            dVar.xe = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.xb;
            if (this.pW.fK().xs) {
                throw new BdHttpCancelException();
            }
            String contentType = this.wL.getContentType();
            this.qr = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ap(contentType)) {
                this.wL.disconnect();
                this.wL.connect();
                if (this.pW.fK().xs) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.xe = -8;
            this.pW.fK().g(this.wL);
            if (c.contains("c.tieba.baidu.com") && (map = this.pW.fK().xu) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.xh = list.get(0);
                dVar.xi = list.get(1);
            }
            dVar.xd = this.pW.fK().responseCode;
            dVar.wY = this.wL.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.wL);
            if (e != null) {
                dVar.wY += e.length;
                this.pW.fK().xv = c(this.pW.fK().contentEncoding, e);
            }
            dVar.xe = -9;
            dVar.wZ = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.wL != null) {
                this.wL.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.wP = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        }
        return bArr;
    }

    private byte[] e(HttpURLConnection httpURLConnection) throws Exception {
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
                while (!this.pW.fK().xs && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.wO = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.p(inputStream);
                        throw th;
                    }
                }
                if (this.pW.fK().xs) {
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
        this.wO = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.p(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.xe = -1;
        try {
            String url = this.pW.fJ().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.pW.fK().xs) {
                throw new BdHttpCancelException();
            }
            dVar.xe = -2;
            this.wL = d(a);
            dVar.xe = -3;
            System.currentTimeMillis();
            if (this.wL == null) {
                throw new SocketException("network not available.");
            }
            this.wL.setRequestMethod("POST");
            this.wL.setDoOutput(true);
            this.wL.setDoInput(true);
            this.wL.setConnectTimeout(i2);
            this.wL.setReadTimeout(i);
            this.wL.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.pW.fK().xs) {
                throw new BdHttpCancelException();
            }
            this.pW.fJ().f(this.wL);
            if (this.pW.fK().xs) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.xb = new Date().getTime() - time;
            dVar.xe = -4;
            this.wL.connect();
            if (this.wM <= 0) {
                this.wM = System.currentTimeMillis();
            }
            this.wN = System.currentTimeMillis();
            dVar.xe = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.xb;
            if (this.pW.fK().xs) {
                throw new BdHttpCancelException();
            }
            if (this.wT != null) {
                this.wT.schedule(this.wS, 45000L);
            }
            dVar.xe = -6;
            this.pW.fJ().a(this.wL, boundary, dVar);
            dVar.xe = -7;
            String contentType = this.wL.getContentType();
            this.qr = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ap(contentType)) {
                this.wL.disconnect();
                this.wL.connect();
                if (this.pW.fK().xs) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.pW.fK().xs) {
                throw new BdHttpCancelException();
            }
            dVar.xe = -8;
            this.pW.fK().g(this.wL);
            dVar.xd = this.pW.fK().responseCode;
            dVar.wY = this.wL.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.wL);
            if (e != null) {
                dVar.wY += e.length;
                this.pW.fK().xw = e.length;
                this.pW.fK().xv = c(this.pW.fK().contentEncoding, e);
            }
            dVar.wZ = new Date().getTime() - time;
            dVar.xe = -9;
        } finally {
            if (this.wT != null) {
                this.wT.cancel();
            }
            com.baidu.adp.lib.g.a.h(this.wL);
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
            String url = this.pW.fJ().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.wL = b(a, i2, i);
            if (this.pW.fK().xs) {
                this.wO = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.p(null);
                com.baidu.adp.lib.g.a.h(this.wL);
                com.baidu.adp.lib.g.a.e((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.e.delFile(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.e.aG(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.pW.fJ().f(this.wL);
                this.wL.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.wL.connect();
                if (this.wM <= 0) {
                    this.wM = System.currentTimeMillis();
                }
                this.wN = System.currentTimeMillis();
                int responseCode = this.wL.getResponseCode();
                this.qr = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.wL.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.h(this.wL);
                        this.wL = b(new URL(url2.toString()), i2, i);
                        this.pW.fJ().f(this.wL);
                        this.wL.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.wL.connect();
                        responseCode = this.wL.getResponseCode();
                    }
                }
                this.pW.fK().responseCode = responseCode;
                if (fB()) {
                    if (this.wL.getContentType() != null && this.wL.getContentType().contains("text/vnd.wap.wml")) {
                        this.wL.disconnect();
                        this.pW.fK().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.wO = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.p(null);
                        com.baidu.adp.lib.g.a.h(this.wL);
                        com.baidu.adp.lib.g.a.e(fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.wL.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.pW.fK().responseCode == 200 && (headerField = this.wL.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.pW.fK().contentLength = String.valueOf(g);
                    dVar2.wX = url.getBytes().length;
                    dVar2.wY = this.wL.getHeaderFields().toString().getBytes().length;
                    dVar2.wY += g;
                    if (this.pW.fK().responseCode == 416 || this.pW.fK().responseCode == 204) {
                        this.wO = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.p(null);
                        com.baidu.adp.lib.g.a.h(this.wL);
                        com.baidu.adp.lib.g.a.e(fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.wO = System.currentTimeMillis();
                        this.wO = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.p(null);
                        com.baidu.adp.lib.g.a.h(this.wL);
                        com.baidu.adp.lib.g.a.e(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.wL.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.n((int) length, g);
                            }
                            while (!this.pW.fK().xs) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (hVar != null && (i6 > i5 || i4 == g)) {
                                            i6 = 0;
                                            hVar.n((int) (i4 + length), g);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) g);
                                this.wO = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.p(inputStream2);
                                com.baidu.adp.lib.g.a.h(this.wL);
                                com.baidu.adp.lib.g.a.e(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.wO = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.p(inputStream);
                            com.baidu.adp.lib.g.a.h(this.wL);
                            com.baidu.adp.lib.g.a.e(fileOutputStream);
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

    private boolean fB() {
        return this.pW.fK().responseCode == 200 || this.pW.fK().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.xe = -1;
        try {
            String url = this.pW.fJ().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.pW.fK().xs) {
                throw new BdHttpCancelException();
            }
            dVar.xe = -2;
            this.wL = d(a);
            dVar.xe = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.wL == null) {
                throw new SocketException("network not available.");
            }
            this.wL.setRequestMethod("POST");
            this.wL.setDoOutput(true);
            this.wL.setDoInput(true);
            this.wL.setConnectTimeout(i2);
            this.wL.setReadTimeout(i);
            this.wL.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.pW.fK().xs) {
                throw new BdHttpCancelException();
            }
            this.pW.fJ().f(this.wL);
            if (this.pW.fK().xs) {
                throw new BdHttpCancelException();
            }
            dVar.xb = System.currentTimeMillis() - currentTimeMillis;
            dVar.xe = -4;
            this.wL.connect();
            if (this.wM <= 0) {
                this.wM = System.currentTimeMillis();
            }
            this.wN = System.currentTimeMillis();
            dVar.xe = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.xb;
            if (this.pW.fK().xs) {
                throw new BdHttpCancelException();
            }
            dVar.xe = -6;
            this.pW.fJ().a(this.wL, dVar);
            dVar.xe = -7;
            if (this.pW.fK().xs) {
                throw new BdHttpCancelException();
            }
            String contentType = this.wL.getContentType();
            this.qr = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ap(contentType)) {
                this.wL.disconnect();
                this.wL.connect();
                if (this.pW.fK().xs) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.xe = -8;
            this.pW.fK().g(this.wL);
            dVar.xd = this.pW.fK().responseCode;
            dVar.wY = this.wL.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.wL);
            if (e != null) {
                dVar.wY += e.length;
                this.pW.fK().xw = e.length;
                this.pW.fK().xv = c(this.pW.fK().contentEncoding, e);
            }
            dVar.wZ = new Date().getTime() - currentTimeMillis;
            dVar.xe = -9;
        } finally {
            com.baidu.adp.lib.g.a.h(this.wL);
        }
    }
}
