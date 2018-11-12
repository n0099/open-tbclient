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
    private HttpURLConnection Cs;
    private e wc;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long Ct = 0;
    private long Cu = 0;
    private long wx = 0;
    private long Cv = 0;
    private long Cw = 0;
    private boolean Cx = false;
    private boolean Cy = true;
    private TimerTask Cz = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.jg();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer CA = new Timer();

    public long ja() {
        return this.Cw;
    }

    public long jb() {
        return this.Cv;
    }

    public long jc() {
        return this.Ct;
    }

    public long jd() {
        return this.Cu;
    }

    public long je() {
        return this.wx;
    }

    public boolean jf() {
        return this.Cx;
    }

    static {
        System.setProperty("http.keepAlive", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.wc = eVar;
    }

    public void jg() {
        this.wc.jq().Dd = true;
        com.baidu.adp.lib.g.a.h(this.Cs);
    }

    private URL a(String str, d dVar) throws Exception {
        a iZ;
        URL url = new URL(str);
        if (this.Cy && (iZ = a.iZ()) != null) {
            String aP = iZ.aP(str);
            if (!TextUtils.isEmpty(aP)) {
                this.wc.jp().y("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + aP));
                this.Cx = true;
                dVar.CP = aP;
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
        String lf;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.kV()) {
                if (j.kX() && (lf = j.lf()) != null && lf.length() > 0) {
                    if (j.bu(lf) && j.lh()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(lf);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.wc.jp().y("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(lf, j.lg())));
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
        dVar.CN = -1;
        if (this.wc.jq().Dd) {
            throw new BdHttpCancelException();
        }
        String c = this.wc.jp().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.wc.jq().Dd) {
            throw new BdHttpCancelException();
        }
        dVar.CN = -2;
        this.Cs = c(a);
        dVar.CN = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.Cs == null) {
                throw new SocketException("network not available.");
            }
            this.Cs.setRequestMethod("GET");
            this.Cs.setConnectTimeout(i2);
            this.Cs.setReadTimeout(i);
            this.wc.jp().f(this.Cs);
            if (this.wc.jq().Dd) {
                throw new BdHttpCancelException();
            }
            dVar.CK = new Date().getTime() - currentTimeMillis;
            dVar.CN = -4;
            this.Cs.connect();
            if (this.Ct <= 0) {
                this.Ct = System.currentTimeMillis();
            }
            this.Cu = System.currentTimeMillis();
            dVar.CN = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.CK;
            if (this.wc.jq().Dd) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Cs.getContentType();
            this.wx = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aU(contentType)) {
                this.Cs.disconnect();
                this.Cs.connect();
                if (this.wc.jq().Dd) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.CN = -8;
            this.wc.jq().g(this.Cs);
            if (c.contains("c.tieba.baidu.com") && (map = this.wc.jq().Df) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.CQ = list.get(0);
                dVar.CT = list.get(1);
            }
            dVar.CM = this.wc.jq().responseCode;
            dVar.CG = this.Cs.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Cs);
            if (e != null) {
                dVar.CG += e.length;
                this.wc.jq().Dg = c(this.wc.jq().contentEncoding, e);
            }
            dVar.CN = -9;
            dVar.CH = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.Cs != null) {
                this.Cs.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.Cw = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.Cw == 0) {
            this.Cw = System.currentTimeMillis();
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
                while (!this.wc.jq().Dd && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.Cv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.h(inputStream);
                        throw th;
                    }
                }
                if (this.wc.jq().Dd) {
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
        this.Cv = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.h(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.CN = -1;
        try {
            String url = this.wc.jp().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.wc.jq().Dd) {
                throw new BdHttpCancelException();
            }
            dVar.CN = -2;
            this.Cs = c(a);
            dVar.CN = -3;
            System.currentTimeMillis();
            if (this.Cs == null) {
                throw new SocketException("network not available.");
            }
            this.Cs.setRequestMethod("POST");
            this.Cs.setDoOutput(true);
            this.Cs.setDoInput(true);
            this.Cs.setConnectTimeout(i2);
            this.Cs.setReadTimeout(i);
            this.Cs.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.wc.jq().Dd) {
                throw new BdHttpCancelException();
            }
            this.wc.jp().f(this.Cs);
            if (this.wc.jq().Dd) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.CK = new Date().getTime() - time;
            dVar.CN = -4;
            this.Cs.connect();
            if (this.Ct <= 0) {
                this.Ct = System.currentTimeMillis();
            }
            this.Cu = System.currentTimeMillis();
            dVar.CN = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.CK;
            if (this.wc.jq().Dd) {
                throw new BdHttpCancelException();
            }
            if (this.CA != null) {
                this.CA.schedule(this.Cz, 45000L);
            }
            dVar.CN = -6;
            this.wc.jp().a(this.Cs, boundary, dVar);
            dVar.CN = -7;
            String contentType = this.Cs.getContentType();
            this.wx = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aU(contentType)) {
                this.Cs.disconnect();
                this.Cs.connect();
                if (this.wc.jq().Dd) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.wc.jq().Dd) {
                throw new BdHttpCancelException();
            }
            dVar.CN = -8;
            this.wc.jq().g(this.Cs);
            dVar.CM = this.wc.jq().responseCode;
            dVar.CG = this.Cs.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Cs);
            if (e != null) {
                dVar.CG += e.length;
                this.wc.jq().Dh = e.length;
                this.wc.jq().Dg = c(this.wc.jq().contentEncoding, e);
            }
            dVar.CH = new Date().getTime() - time;
            dVar.CN = -9;
        } finally {
            if (this.CA != null) {
                this.CA.cancel();
            }
            com.baidu.adp.lib.g.a.h(this.Cs);
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
            String url = this.wc.jp().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.Cs = a(a, i2, i);
            if (this.wc.jq().Dd) {
                this.Cv = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.h((InputStream) null);
                com.baidu.adp.lib.g.a.h(this.Cs);
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
                this.wc.jp().f(this.Cs);
                this.Cs.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.Cs.connect();
                if (this.Ct <= 0) {
                    this.Ct = System.currentTimeMillis();
                }
                this.Cu = System.currentTimeMillis();
                int responseCode = this.Cs.getResponseCode();
                this.wx = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.Cs.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.h(this.Cs);
                        this.Cs = a(new URL(url2.toString()), i2, i);
                        this.wc.jp().f(this.Cs);
                        this.Cs.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.Cs.connect();
                        responseCode = this.Cs.getResponseCode();
                    }
                }
                this.wc.jq().responseCode = responseCode;
                if (jh()) {
                    if (this.Cs.getContentType() != null && this.Cs.getContentType().contains("text/vnd.wap.wml")) {
                        this.Cs.disconnect();
                        this.wc.jq().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.Cv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h((InputStream) null);
                        com.baidu.adp.lib.g.a.h(this.Cs);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.Cs.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.l(headerField2.substring(indexOf + 1), 0);
                    }
                    int l = (i3 == 0 && this.wc.jq().responseCode == 200 && (headerField = this.Cs.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.l(headerField, 0) : i3;
                    this.wc.jq().contentLength = String.valueOf(l);
                    dVar2.CF = url.getBytes().length;
                    dVar2.CG = this.Cs.getHeaderFields().toString().getBytes().length;
                    dVar2.CG += l;
                    if (this.wc.jq().responseCode == 416 || this.wc.jq().responseCode == 204) {
                        this.Cv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h((InputStream) null);
                        com.baidu.adp.lib.g.a.h(this.Cs);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (l != 0 && length >= l) {
                        this.Cv = System.currentTimeMillis();
                        this.Cv = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h((InputStream) null);
                        com.baidu.adp.lib.g.a.h(this.Cs);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.Cs.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = l > 0 ? l / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.o((int) length, l);
                            }
                            while (!this.wc.jq().Dd) {
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
                                this.Cv = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.h(inputStream2);
                                com.baidu.adp.lib.g.a.h(this.Cs);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.Cv = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.h(inputStream);
                            com.baidu.adp.lib.g.a.h(this.Cs);
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

    private boolean jh() {
        return this.wc.jq().responseCode == 200 || this.wc.jq().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.CN = -1;
        try {
            String url = this.wc.jp().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.wc.jq().Dd) {
                throw new BdHttpCancelException();
            }
            dVar.CN = -2;
            this.Cs = c(a);
            dVar.CN = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.Cs == null) {
                throw new SocketException("network not available.");
            }
            this.Cs.setRequestMethod("POST");
            this.Cs.setDoOutput(true);
            this.Cs.setDoInput(true);
            this.Cs.setConnectTimeout(i2);
            this.Cs.setReadTimeout(i);
            this.Cs.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.wc.jq().Dd) {
                throw new BdHttpCancelException();
            }
            this.wc.jp().f(this.Cs);
            if (this.wc.jq().Dd) {
                throw new BdHttpCancelException();
            }
            dVar.CK = System.currentTimeMillis() - currentTimeMillis;
            dVar.CN = -4;
            this.Cs.connect();
            if (this.Ct <= 0) {
                this.Ct = System.currentTimeMillis();
            }
            this.Cu = System.currentTimeMillis();
            dVar.CN = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.CK;
            if (this.wc.jq().Dd) {
                throw new BdHttpCancelException();
            }
            dVar.CN = -6;
            this.wc.jp().a(this.Cs, dVar);
            dVar.CN = -7;
            if (this.wc.jq().Dd) {
                throw new BdHttpCancelException();
            }
            String contentType = this.Cs.getContentType();
            this.wx = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aU(contentType)) {
                this.Cs.disconnect();
                this.Cs.connect();
                if (this.wc.jq().Dd) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.CN = -8;
            this.wc.jq().g(this.Cs);
            dVar.CM = this.wc.jq().responseCode;
            dVar.CG = this.Cs.getHeaderFields().toString().getBytes().length;
            byte[] e = e(this.Cs);
            if (e != null) {
                dVar.CG += e.length;
                this.wc.jq().Dh = e.length;
                this.wc.jq().Dg = c(this.wc.jq().contentEncoding, e);
            }
            dVar.CH = new Date().getTime() - currentTimeMillis;
            dVar.CN = -9;
        } finally {
            com.baidu.adp.lib.g.a.h(this.Cs);
        }
    }
}
