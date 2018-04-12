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
    private e mA;
    private HttpURLConnection tk;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long tl = 0;
    private long tm = 0;
    private long mW = 0;
    private long tp = 0;
    private long tq = 0;
    private boolean tr = false;
    private boolean ts = true;
    private TimerTask tt = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.eW();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer tu = new Timer();

    public long eQ() {
        return this.tq;
    }

    public long eR() {
        return this.tp;
    }

    public long eS() {
        return this.tl;
    }

    public long eT() {
        return this.tm;
    }

    public long eU() {
        return this.mW;
    }

    public boolean eV() {
        return this.tr;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.mA = eVar;
    }

    public void eW() {
        this.mA.ff().tW = true;
        com.baidu.adp.lib.g.a.f(this.tk);
    }

    private URL a(String str, d dVar) throws Exception {
        a eP;
        URL url = new URL(str);
        if (this.ts && (eP = a.eP()) != null) {
            String al = eP.al(str);
            if (!TextUtils.isEmpty(al)) {
                this.mA.fe().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + al));
                this.tr = true;
                dVar.tK = al;
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
        String gZ;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.gP()) {
                if (j.gR() && (gZ = j.gZ()) != null && gZ.length() > 0) {
                    if (j.aP(gZ) && j.hb()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(gZ);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.mA.fe().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(gZ, j.ha())));
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
        dVar.tI = -1;
        if (this.mA.ff().tW) {
            throw new BdHttpCancelException();
        }
        String c = this.mA.fe().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.mA.ff().tW) {
            throw new BdHttpCancelException();
        }
        dVar.tI = -2;
        this.tk = c(a);
        dVar.tI = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.tk == null) {
                throw new SocketException("network not available.");
            }
            this.tk.setRequestMethod("GET");
            this.tk.setConnectTimeout(i2);
            this.tk.setReadTimeout(i);
            this.mA.fe().d(this.tk);
            if (this.mA.ff().tW) {
                throw new BdHttpCancelException();
            }
            dVar.tF = new Date().getTime() - currentTimeMillis;
            dVar.tI = -4;
            this.tk.connect();
            if (this.tl <= 0) {
                this.tl = System.currentTimeMillis();
            }
            this.tm = System.currentTimeMillis();
            dVar.tI = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.tF;
            if (this.mA.ff().tW) {
                throw new BdHttpCancelException();
            }
            String contentType = this.tk.getContentType();
            this.mW = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ap(contentType)) {
                this.tk.disconnect();
                this.tk.connect();
                if (this.mA.ff().tW) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.tI = -8;
            this.mA.ff().e(this.tk);
            if (c.contains("c.tieba.baidu.com") && (map = this.mA.ff().tY) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.tL = list.get(0);
                dVar.tM = list.get(1);
            }
            dVar.tH = this.mA.ff().responseCode;
            dVar.tB = this.tk.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.tk);
            if (c2 != null) {
                dVar.tB += c2.length;
                this.mA.ff().tZ = c(this.mA.ff().contentEncoding, c2);
            }
            dVar.tI = -9;
            dVar.tC = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.tk != null) {
                this.tk.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.tq = System.currentTimeMillis();
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
                while (!this.mA.ff().tW && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.tp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.mA.ff().tW) {
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
        this.tp = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.tI = -1;
        try {
            String url = this.mA.fe().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.mA.ff().tW) {
                throw new BdHttpCancelException();
            }
            dVar.tI = -2;
            this.tk = c(a);
            dVar.tI = -3;
            System.currentTimeMillis();
            if (this.tk == null) {
                throw new SocketException("network not available.");
            }
            this.tk.setRequestMethod("POST");
            this.tk.setDoOutput(true);
            this.tk.setDoInput(true);
            this.tk.setConnectTimeout(i2);
            this.tk.setReadTimeout(i);
            this.tk.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.mA.ff().tW) {
                throw new BdHttpCancelException();
            }
            this.mA.fe().d(this.tk);
            if (this.mA.ff().tW) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.tF = new Date().getTime() - time;
            dVar.tI = -4;
            this.tk.connect();
            if (this.tl <= 0) {
                this.tl = System.currentTimeMillis();
            }
            this.tm = System.currentTimeMillis();
            dVar.tI = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.tF;
            if (this.mA.ff().tW) {
                throw new BdHttpCancelException();
            }
            if (this.tu != null) {
                this.tu.schedule(this.tt, 45000L);
            }
            dVar.tI = -6;
            this.mA.fe().a(this.tk, boundary, dVar);
            dVar.tI = -7;
            String contentType = this.tk.getContentType();
            this.mW = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ap(contentType)) {
                this.tk.disconnect();
                this.tk.connect();
                if (this.mA.ff().tW) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.mA.ff().tW) {
                throw new BdHttpCancelException();
            }
            dVar.tI = -8;
            this.mA.ff().e(this.tk);
            dVar.tH = this.mA.ff().responseCode;
            dVar.tB = this.tk.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.tk);
            if (c != null) {
                dVar.tB += c.length;
                this.mA.ff().ub = c.length;
                this.mA.ff().tZ = c(this.mA.ff().contentEncoding, c);
            }
            dVar.tC = new Date().getTime() - time;
            dVar.tI = -9;
        } finally {
            if (this.tu != null) {
                this.tu.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.tk);
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
            String url = this.mA.fe().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.tk = a(a, i2, i);
            if (this.mA.ff().tW) {
                this.tp = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.f(this.tk);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aJ(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aH(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.mA.fe().d(this.tk);
                this.tk.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.tk.connect();
                if (this.tl <= 0) {
                    this.tl = System.currentTimeMillis();
                }
                this.tm = System.currentTimeMillis();
                int responseCode = this.tk.getResponseCode();
                this.mW = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.tk.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.f(this.tk);
                        this.tk = a(new URL(url2.toString()), i2, i);
                        this.mA.fe().d(this.tk);
                        this.tk.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.tk.connect();
                        responseCode = this.tk.getResponseCode();
                    }
                }
                this.mA.ff().responseCode = responseCode;
                if (eX()) {
                    if (this.tk.getContentType() != null && this.tk.getContentType().contains("text/vnd.wap.wml")) {
                        this.tk.disconnect();
                        this.mA.ff().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.tp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.tk);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.tk.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.mA.ff().responseCode == 200 && (headerField = this.tk.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.mA.ff().contentLength = String.valueOf(g);
                    dVar2.tA = url.getBytes().length;
                    dVar2.tB = this.tk.getHeaderFields().toString().getBytes().length;
                    dVar2.tB += g;
                    if (this.mA.ff().responseCode == 416 || this.mA.ff().responseCode == 204) {
                        this.tp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.tk);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.tp = System.currentTimeMillis();
                        this.tp = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.tk);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.tk.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.m((int) length, g);
                            }
                            while (!this.mA.ff().tW) {
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
                                this.tp = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.tk);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.tp = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.f(this.tk);
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

    private boolean eX() {
        return this.mA.ff().responseCode == 200 || this.mA.ff().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.tI = -1;
        try {
            String url = this.mA.fe().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.mA.ff().tW) {
                throw new BdHttpCancelException();
            }
            dVar.tI = -2;
            this.tk = c(a);
            dVar.tI = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.tk == null) {
                throw new SocketException("network not available.");
            }
            this.tk.setRequestMethod("POST");
            this.tk.setDoOutput(true);
            this.tk.setDoInput(true);
            this.tk.setConnectTimeout(i2);
            this.tk.setReadTimeout(i);
            this.tk.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.mA.ff().tW) {
                throw new BdHttpCancelException();
            }
            this.mA.fe().d(this.tk);
            if (this.mA.ff().tW) {
                throw new BdHttpCancelException();
            }
            dVar.tF = System.currentTimeMillis() - currentTimeMillis;
            dVar.tI = -4;
            this.tk.connect();
            if (this.tl <= 0) {
                this.tl = System.currentTimeMillis();
            }
            this.tm = System.currentTimeMillis();
            dVar.tI = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.tF;
            if (this.mA.ff().tW) {
                throw new BdHttpCancelException();
            }
            dVar.tI = -6;
            this.mA.fe().a(this.tk, dVar);
            dVar.tI = -7;
            if (this.mA.ff().tW) {
                throw new BdHttpCancelException();
            }
            String contentType = this.tk.getContentType();
            this.mW = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ap(contentType)) {
                this.tk.disconnect();
                this.tk.connect();
                if (this.mA.ff().tW) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.tI = -8;
            this.mA.ff().e(this.tk);
            dVar.tH = this.mA.ff().responseCode;
            dVar.tB = this.tk.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.tk);
            if (c != null) {
                dVar.tB += c.length;
                this.mA.ff().ub = c.length;
                this.mA.ff().tZ = c(this.mA.ff().contentEncoding, c);
            }
            dVar.tC = new Date().getTime() - currentTimeMillis;
            dVar.tI = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.tk);
        }
    }
}
