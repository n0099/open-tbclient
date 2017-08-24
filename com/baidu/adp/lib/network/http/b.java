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
    private e pZ;
    private HttpURLConnection wN;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long wO = 0;
    private long wP = 0;
    private long qu = 0;
    private long wQ = 0;
    private long wR = 0;
    private boolean wS = false;
    private boolean wT = true;
    private TimerTask wU = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.fA();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer wV = new Timer();

    public long fu() {
        return this.wR;
    }

    public long fv() {
        return this.wQ;
    }

    public long fw() {
        return this.wO;
    }

    public long fx() {
        return this.wP;
    }

    public long fy() {
        return this.qu;
    }

    public boolean fz() {
        return this.wS;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.pZ = eVar;
    }

    public void fA() {
        this.pZ.fK().xu = true;
        com.baidu.adp.lib.g.a.h(this.wN);
    }

    private URL a(String str, d dVar) throws Exception {
        a ft;
        URL url = new URL(str);
        if (this.wT && (ft = a.ft()) != null) {
            String an = ft.an(str);
            if (!TextUtils.isEmpty(an)) {
                this.pZ.fJ().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + an));
                this.wS = true;
                dVar.xi = an;
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
                    if (i.aO(hB) && i.hD()) {
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
                            this.pZ.fJ().o("X-Online-Host", url.getHost());
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
        dVar.xg = -1;
        if (this.pZ.fK().xu) {
            throw new BdHttpCancelException();
        }
        String c = this.pZ.fJ().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.pZ.fK().xu) {
            throw new BdHttpCancelException();
        }
        dVar.xg = -2;
        this.wN = d(a);
        dVar.xg = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.wN == null) {
                throw new SocketException("network not available.");
            }
            this.wN.setRequestMethod("GET");
            this.wN.setConnectTimeout(i2);
            this.wN.setReadTimeout(i);
            this.pZ.fJ().f(this.wN);
            if (this.pZ.fK().xu) {
                throw new BdHttpCancelException();
            }
            dVar.xd = new Date().getTime() - currentTimeMillis;
            dVar.xg = -4;
            this.wN.connect();
            if (this.wO <= 0) {
                this.wO = System.currentTimeMillis();
            }
            this.wP = System.currentTimeMillis();
            dVar.xg = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.xd;
            if (this.pZ.fK().xu) {
                throw new BdHttpCancelException();
            }
            String contentType = this.wN.getContentType();
            this.qu = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aq(contentType)) {
                this.wN.disconnect();
                this.wN.connect();
                if (this.pZ.fK().xu) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.xg = -8;
            this.pZ.fK().g(this.wN);
            if (c.contains("c.tieba.baidu.com") && (map = this.pZ.fK().xw) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.xj = list.get(0);
                dVar.xk = list.get(1);
            }
            dVar.xf = this.pZ.fK().responseCode;
            dVar.xa = this.wN.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.wN);
            if (e != null) {
                dVar.xa += e.length;
                this.pZ.fK().xx = c(this.pZ.fK().contentEncoding, e);
            }
            dVar.xg = -9;
            dVar.xb = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.wN != null) {
                this.wN.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream);
            this.wR = System.currentTimeMillis();
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
                while (!this.pZ.fK().xu && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.wQ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.p(inputStream);
                        throw th;
                    }
                }
                if (this.pZ.fK().xu) {
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
        this.wQ = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
        com.baidu.adp.lib.g.a.p(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.xg = -1;
        try {
            String url = this.pZ.fJ().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.pZ.fK().xu) {
                throw new BdHttpCancelException();
            }
            dVar.xg = -2;
            this.wN = d(a);
            dVar.xg = -3;
            System.currentTimeMillis();
            if (this.wN == null) {
                throw new SocketException("network not available.");
            }
            this.wN.setRequestMethod("POST");
            this.wN.setDoOutput(true);
            this.wN.setDoInput(true);
            this.wN.setConnectTimeout(i2);
            this.wN.setReadTimeout(i);
            this.wN.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.pZ.fK().xu) {
                throw new BdHttpCancelException();
            }
            this.pZ.fJ().f(this.wN);
            if (this.pZ.fK().xu) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.xd = new Date().getTime() - time;
            dVar.xg = -4;
            this.wN.connect();
            if (this.wO <= 0) {
                this.wO = System.currentTimeMillis();
            }
            this.wP = System.currentTimeMillis();
            dVar.xg = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.xd;
            if (this.pZ.fK().xu) {
                throw new BdHttpCancelException();
            }
            if (this.wV != null) {
                this.wV.schedule(this.wU, 45000L);
            }
            dVar.xg = -6;
            this.pZ.fJ().a(this.wN, boundary, dVar);
            dVar.xg = -7;
            String contentType = this.wN.getContentType();
            this.qu = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aq(contentType)) {
                this.wN.disconnect();
                this.wN.connect();
                if (this.pZ.fK().xu) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.pZ.fK().xu) {
                throw new BdHttpCancelException();
            }
            dVar.xg = -8;
            this.pZ.fK().g(this.wN);
            dVar.xf = this.pZ.fK().responseCode;
            dVar.xa = this.wN.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.wN);
            if (e != null) {
                dVar.xa += e.length;
                this.pZ.fK().xy = e.length;
                this.pZ.fK().xx = c(this.pZ.fK().contentEncoding, e);
            }
            dVar.xb = new Date().getTime() - time;
            dVar.xg = -9;
        } finally {
            if (this.wV != null) {
                this.wV.cancel();
            }
            com.baidu.adp.lib.g.a.h(this.wN);
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
            String url = this.pZ.fJ().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.wN = b(a, i2, i);
            if (this.pZ.fK().xu) {
                this.wQ = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.p(null);
                com.baidu.adp.lib.g.a.h(this.wN);
                com.baidu.adp.lib.g.a.e((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.e.delFile(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.e.aH(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.pZ.fJ().f(this.wN);
                this.wN.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.wN.connect();
                if (this.wO <= 0) {
                    this.wO = System.currentTimeMillis();
                }
                this.wP = System.currentTimeMillis();
                int responseCode = this.wN.getResponseCode();
                this.qu = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.wN.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.h(this.wN);
                        this.wN = b(new URL(url2.toString()), i2, i);
                        this.pZ.fJ().f(this.wN);
                        this.wN.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.wN.connect();
                        responseCode = this.wN.getResponseCode();
                    }
                }
                this.pZ.fK().responseCode = responseCode;
                if (fB()) {
                    if (this.wN.getContentType() != null && this.wN.getContentType().contains("text/vnd.wap.wml")) {
                        this.wN.disconnect();
                        this.pZ.fK().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.wQ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.p(null);
                        com.baidu.adp.lib.g.a.h(this.wN);
                        com.baidu.adp.lib.g.a.e(fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.wN.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.pZ.fK().responseCode == 200 && (headerField = this.wN.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.pZ.fK().contentLength = String.valueOf(g);
                    dVar2.wZ = url.getBytes().length;
                    dVar2.xa = this.wN.getHeaderFields().toString().getBytes().length;
                    dVar2.xa += g;
                    if (this.pZ.fK().responseCode == 416 || this.pZ.fK().responseCode == 204) {
                        this.wQ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.p(null);
                        com.baidu.adp.lib.g.a.h(this.wN);
                        com.baidu.adp.lib.g.a.e(fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.wQ = System.currentTimeMillis();
                        this.wQ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.p(null);
                        com.baidu.adp.lib.g.a.h(this.wN);
                        com.baidu.adp.lib.g.a.e(fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.wN.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.n((int) length, g);
                            }
                            while (!this.pZ.fK().xu) {
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
                                this.wQ = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.p(inputStream2);
                                com.baidu.adp.lib.g.a.h(this.wN);
                                com.baidu.adp.lib.g.a.e(fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.wQ = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.p(inputStream);
                            com.baidu.adp.lib.g.a.h(this.wN);
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
        return this.pZ.fK().responseCode == 200 || this.pZ.fK().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.xg = -1;
        try {
            String url = this.pZ.fJ().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.pZ.fK().xu) {
                throw new BdHttpCancelException();
            }
            dVar.xg = -2;
            this.wN = d(a);
            dVar.xg = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.wN == null) {
                throw new SocketException("network not available.");
            }
            this.wN.setRequestMethod("POST");
            this.wN.setDoOutput(true);
            this.wN.setDoInput(true);
            this.wN.setConnectTimeout(i2);
            this.wN.setReadTimeout(i);
            this.wN.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.pZ.fK().xu) {
                throw new BdHttpCancelException();
            }
            this.pZ.fJ().f(this.wN);
            if (this.pZ.fK().xu) {
                throw new BdHttpCancelException();
            }
            dVar.xd = System.currentTimeMillis() - currentTimeMillis;
            dVar.xg = -4;
            this.wN.connect();
            if (this.wO <= 0) {
                this.wO = System.currentTimeMillis();
            }
            this.wP = System.currentTimeMillis();
            dVar.xg = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.xd;
            if (this.pZ.fK().xu) {
                throw new BdHttpCancelException();
            }
            dVar.xg = -6;
            this.pZ.fJ().a(this.wN, dVar);
            dVar.xg = -7;
            if (this.pZ.fK().xu) {
                throw new BdHttpCancelException();
            }
            String contentType = this.wN.getContentType();
            this.qu = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aq(contentType)) {
                this.wN.disconnect();
                this.wN.connect();
                if (this.pZ.fK().xu) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.xg = -8;
            this.pZ.fK().g(this.wN);
            dVar.xf = this.pZ.fK().responseCode;
            dVar.xa = this.wN.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.wN);
            if (e != null) {
                dVar.xa += e.length;
                this.pZ.fK().xy = e.length;
                this.pZ.fK().xx = c(this.pZ.fK().contentEncoding, e);
            }
            dVar.xb = new Date().getTime() - currentTimeMillis;
            dVar.xg = -9;
        } finally {
            com.baidu.adp.lib.g.a.h(this.wN);
        }
    }
}
