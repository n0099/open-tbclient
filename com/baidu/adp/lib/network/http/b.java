package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.webkit.internal.ABTestConstants;
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
    private HttpURLConnection Cp;
    private e wa;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long Cq = 0;
    private long Cr = 0;
    private long wu = 0;
    private long Cs = 0;
    private long Ct = 0;
    private boolean Cu = false;
    private boolean Cv = true;
    private TimerTask Cw = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.ji();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer Cx = new Timer();

    public long jc() {
        return this.Ct;
    }

    public long jd() {
        return this.Cs;
    }

    public long je() {
        return this.Cq;
    }

    public long jf() {
        return this.Cr;
    }

    public long jg() {
        return this.wu;
    }

    public boolean jh() {
        return this.Cu;
    }

    static {
        System.setProperty("http.keepAlive", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.wa = eVar;
    }

    public void ji() {
        this.wa.js().CZ = true;
        com.baidu.adp.lib.g.a.h(this.Cp);
    }

    private URL a(String str, d dVar) throws Exception {
        a jb;
        URL url = new URL(str);
        if (this.Cv && (jb = a.jb()) != null) {
            String aP = jb.aP(str);
            if (!TextUtils.isEmpty(aP)) {
                this.wa.jr().y("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + aP));
                this.Cu = true;
                dVar.CL = aP;
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
        String lh;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.kX()) {
                if (j.kZ() && (lh = j.lh()) != null && lh.length() > 0) {
                    if (j.bu(lh) && j.lj()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(lh);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.wa.jr().y("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(lh, j.li())));
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
        dVar.CJ = -1;
        if (this.wa.js().CZ) {
            throw new BdHttpCancelException();
        }
        String c = this.wa.jr().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.wa.js().CZ) {
            throw new BdHttpCancelException();
        }
        dVar.CJ = -2;
        this.Cp = c(a);
        dVar.CJ = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Cp == null) {
                throw new SocketException("network not available.");
            }
            this.Cp.setRequestMethod("GET");
            this.Cp.setConnectTimeout(i2);
            this.Cp.setReadTimeout(i);
            this.wa.jr().f(this.Cp);
            if (this.wa.js().CZ) {
                throw new BdHttpCancelException();
            }
            dVar.CG = new Date().getTime() - currentTimeMillis;
            dVar.CJ = -4;
            this.Cp.connect();
            if (this.Cq <= 0) {
                this.Cq = System.currentTimeMillis();
            }
            this.Cr = System.currentTimeMillis();
            dVar.CJ = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.CG;
            if (this.wa.js().CZ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Cp.getContentType();
            this.wu = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aU(contentType)) {
                this.Cp.disconnect();
                this.Cp.connect();
                if (this.wa.js().CZ) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.CJ = -8;
            this.wa.js().g(this.Cp);
            if (c.contains("c.tieba.baidu.com") && (map = this.wa.js().Db) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.CM = list.get(0);
                dVar.CN = list.get(1);
            }
            dVar.CI = this.wa.js().responseCode;
            dVar.CC = this.Cp.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Cp);
            if (e != null) {
                dVar.CC += e.length;
                this.wa.js().Dc = c(this.wa.js().contentEncoding, e);
            }
            dVar.CJ = -9;
            dVar.CD = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.Cp != null) {
                this.Cp.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.Ct = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.Ct == 0) {
            this.Ct = System.currentTimeMillis();
            return bArr;
        } else {
            return bArr;
        }
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
                while (!this.wa.js().CZ && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.Cs = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.h(inputStream);
                        throw th;
                    }
                }
                if (this.wa.js().CZ) {
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
        this.Cs = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.h(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.CJ = -1;
        try {
            String url = this.wa.jr().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.wa.js().CZ) {
                throw new BdHttpCancelException();
            }
            dVar.CJ = -2;
            this.Cp = c(a);
            dVar.CJ = -3;
            System.currentTimeMillis();
            if (this.Cp == null) {
                throw new SocketException("network not available.");
            }
            this.Cp.setRequestMethod("POST");
            this.Cp.setDoOutput(true);
            this.Cp.setDoInput(true);
            this.Cp.setConnectTimeout(i2);
            this.Cp.setReadTimeout(i);
            this.Cp.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.wa.js().CZ) {
                throw new BdHttpCancelException();
            }
            this.wa.jr().f(this.Cp);
            if (this.wa.js().CZ) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.CG = new Date().getTime() - time;
            dVar.CJ = -4;
            this.Cp.connect();
            if (this.Cq <= 0) {
                this.Cq = System.currentTimeMillis();
            }
            this.Cr = System.currentTimeMillis();
            dVar.CJ = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.CG;
            if (this.wa.js().CZ) {
                throw new BdHttpCancelException();
            }
            if (this.Cx != null) {
                this.Cx.schedule(this.Cw, 45000L);
            }
            dVar.CJ = -6;
            this.wa.jr().a(this.Cp, boundary, dVar);
            dVar.CJ = -7;
            String contentType = this.Cp.getContentType();
            this.wu = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aU(contentType)) {
                this.Cp.disconnect();
                this.Cp.connect();
                if (this.wa.js().CZ) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.wa.js().CZ) {
                throw new BdHttpCancelException();
            }
            dVar.CJ = -8;
            this.wa.js().g(this.Cp);
            dVar.CI = this.wa.js().responseCode;
            dVar.CC = this.Cp.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Cp);
            if (e != null) {
                dVar.CC += e.length;
                this.wa.js().Dd = e.length;
                this.wa.js().Dc = c(this.wa.js().contentEncoding, e);
            }
            dVar.CD = new Date().getTime() - time;
            dVar.CJ = -9;
        } finally {
            if (this.Cx != null) {
                this.Cx.cancel();
            }
            com.baidu.adp.lib.g.a.h(this.Cp);
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
            String url = this.wa.jr().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.Cp = a(a, i2, i);
            if (this.wa.js().CZ) {
                this.Cs = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.h((InputStream) null);
                com.baidu.adp.lib.g.a.h(this.Cp);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.bo(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.bm(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.wa.jr().f(this.Cp);
                this.Cp.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Cp.connect();
                if (this.Cq <= 0) {
                    this.Cq = System.currentTimeMillis();
                }
                this.Cr = System.currentTimeMillis();
                int responseCode = this.Cp.getResponseCode();
                this.wu = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.Cp.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.h(this.Cp);
                        this.Cp = a(new URL(url2.toString()), i2, i);
                        this.wa.jr().f(this.Cp);
                        this.Cp.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.Cp.connect();
                        responseCode = this.Cp.getResponseCode();
                    }
                }
                this.wa.js().responseCode = responseCode;
                if (jj()) {
                    if (this.Cp.getContentType() != null && this.Cp.getContentType().contains("text/vnd.wap.wml")) {
                        this.Cp.disconnect();
                        this.wa.js().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.Cs = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h((InputStream) null);
                        com.baidu.adp.lib.g.a.h(this.Cp);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.Cp.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.l(headerField2.substring(indexOf + 1), 0);
                    }
                    int l = (i3 == 0 && this.wa.js().responseCode == 200 && (headerField = this.Cp.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.l(headerField, 0) : i3;
                    this.wa.js().contentLength = String.valueOf(l);
                    dVar2.CB = url.getBytes().length;
                    dVar2.CC = this.Cp.getHeaderFields().toString().getBytes().length;
                    dVar2.CC += l;
                    if (this.wa.js().responseCode == 416 || this.wa.js().responseCode == 204) {
                        this.Cs = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h((InputStream) null);
                        com.baidu.adp.lib.g.a.h(this.Cp);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (l != 0 && length >= l) {
                        this.Cs = System.currentTimeMillis();
                        this.Cs = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h((InputStream) null);
                        com.baidu.adp.lib.g.a.h(this.Cp);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.Cp.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = l > 0 ? l / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.o((int) length, l);
                            }
                            while (!this.wa.js().CZ) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (hVar != null && (i6 > i5 || i4 == l)) {
                                            i6 = 0;
                                            hVar.o((int) (i4 + length), l);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) l);
                                this.Cs = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.h(inputStream2);
                                com.baidu.adp.lib.g.a.h(this.Cp);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.Cs = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.h(inputStream);
                            com.baidu.adp.lib.g.a.h(this.Cp);
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

    private boolean jj() {
        return this.wa.js().responseCode == 200 || this.wa.js().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.CJ = -1;
        try {
            String url = this.wa.jr().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.wa.js().CZ) {
                throw new BdHttpCancelException();
            }
            dVar.CJ = -2;
            this.Cp = c(a);
            dVar.CJ = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Cp == null) {
                throw new SocketException("network not available.");
            }
            this.Cp.setRequestMethod("POST");
            this.Cp.setDoOutput(true);
            this.Cp.setDoInput(true);
            this.Cp.setConnectTimeout(i2);
            this.Cp.setReadTimeout(i);
            this.Cp.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.wa.js().CZ) {
                throw new BdHttpCancelException();
            }
            this.wa.jr().f(this.Cp);
            if (this.wa.js().CZ) {
                throw new BdHttpCancelException();
            }
            dVar.CG = System.currentTimeMillis() - currentTimeMillis;
            dVar.CJ = -4;
            this.Cp.connect();
            if (this.Cq <= 0) {
                this.Cq = System.currentTimeMillis();
            }
            this.Cr = System.currentTimeMillis();
            dVar.CJ = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.CG;
            if (this.wa.js().CZ) {
                throw new BdHttpCancelException();
            }
            dVar.CJ = -6;
            this.wa.jr().a(this.Cp, dVar);
            dVar.CJ = -7;
            if (this.wa.js().CZ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Cp.getContentType();
            this.wu = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aU(contentType)) {
                this.Cp.disconnect();
                this.Cp.connect();
                if (this.wa.js().CZ) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.CJ = -8;
            this.wa.js().g(this.Cp);
            dVar.CI = this.wa.js().responseCode;
            dVar.CC = this.Cp.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Cp);
            if (e != null) {
                dVar.CC += e.length;
                this.wa.js().Dd = e.length;
                this.wa.js().Dc = c(this.wa.js().contentEncoding, e);
            }
            dVar.CD = new Date().getTime() - currentTimeMillis;
            dVar.CJ = -9;
        } finally {
            com.baidu.adp.lib.g.a.h(this.Cp);
        }
    }
}
