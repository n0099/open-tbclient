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
    private HttpURLConnection BH;
    private e vn;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long BI = 0;
    private long BJ = 0;
    private long vH = 0;
    private long BK = 0;
    private long BL = 0;
    private boolean BM = false;
    private boolean BN = true;
    private TimerTask BO = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.iT();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer BP = new Timer();

    public long iN() {
        return this.BL;
    }

    public long iO() {
        return this.BK;
    }

    public long iP() {
        return this.BI;
    }

    public long iQ() {
        return this.BJ;
    }

    public long iR() {
        return this.vH;
    }

    public boolean iS() {
        return this.BM;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.vn = eVar;
    }

    public void iT() {
        this.vn.jd().Cp = true;
        com.baidu.adp.lib.g.a.f(this.BH);
    }

    private URL a(String str, d dVar) throws Exception {
        a iM;
        URL url = new URL(str);
        if (this.BN && (iM = a.iM()) != null) {
            String aP = iM.aP(str);
            if (!TextUtils.isEmpty(aP)) {
                this.vn.jc().x("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + aP));
                this.BM = true;
                dVar.Cd = aP;
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
        String kU;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.kK()) {
                if (j.kM() && (kU = j.kU()) != null && kU.length() > 0) {
                    if (j.bv(kU) && j.kW()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(kU);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.vn.jc().x("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(kU, j.kV())));
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
        dVar.Cb = -1;
        if (this.vn.jd().Cp) {
            throw new BdHttpCancelException();
        }
        String c = this.vn.jc().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.vn.jd().Cp) {
            throw new BdHttpCancelException();
        }
        dVar.Cb = -2;
        this.BH = c(a);
        dVar.Cb = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.BH == null) {
                throw new SocketException("network not available.");
            }
            this.BH.setRequestMethod("GET");
            this.BH.setConnectTimeout(i2);
            this.BH.setReadTimeout(i);
            this.vn.jc().d(this.BH);
            if (this.vn.jd().Cp) {
                throw new BdHttpCancelException();
            }
            dVar.BY = new Date().getTime() - currentTimeMillis;
            dVar.Cb = -4;
            this.BH.connect();
            if (this.BI <= 0) {
                this.BI = System.currentTimeMillis();
            }
            this.BJ = System.currentTimeMillis();
            dVar.Cb = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.BY;
            if (this.vn.jd().Cp) {
                throw new BdHttpCancelException();
            }
            String contentType = this.BH.getContentType();
            this.vH = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aV(contentType)) {
                this.BH.disconnect();
                this.BH.connect();
                if (this.vn.jd().Cp) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Cb = -8;
            this.vn.jd().e(this.BH);
            if (c.contains("c.tieba.baidu.com") && (map = this.vn.jd().Cr) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.Ce = list.get(0);
                dVar.Cf = list.get(1);
            }
            dVar.Ca = this.vn.jd().responseCode;
            dVar.BU = this.BH.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.BH);
            if (c2 != null) {
                dVar.BU += c2.length;
                this.vn.jd().Cs = c(this.vn.jd().contentEncoding, c2);
            }
            dVar.Cb = -9;
            dVar.BV = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.BH != null) {
                this.BH.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.BL = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.BL == 0) {
            this.BL = System.currentTimeMillis();
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
                while (!this.vn.jd().Cp && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.BK = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.h(inputStream);
                        throw th;
                    }
                }
                if (this.vn.jd().Cp) {
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
        this.BK = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.h(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.Cb = -1;
        try {
            String url = this.vn.jc().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.vn.jd().Cp) {
                throw new BdHttpCancelException();
            }
            dVar.Cb = -2;
            this.BH = c(a);
            dVar.Cb = -3;
            System.currentTimeMillis();
            if (this.BH == null) {
                throw new SocketException("network not available.");
            }
            this.BH.setRequestMethod("POST");
            this.BH.setDoOutput(true);
            this.BH.setDoInput(true);
            this.BH.setConnectTimeout(i2);
            this.BH.setReadTimeout(i);
            this.BH.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.vn.jd().Cp) {
                throw new BdHttpCancelException();
            }
            this.vn.jc().d(this.BH);
            if (this.vn.jd().Cp) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.BY = new Date().getTime() - time;
            dVar.Cb = -4;
            this.BH.connect();
            if (this.BI <= 0) {
                this.BI = System.currentTimeMillis();
            }
            this.BJ = System.currentTimeMillis();
            dVar.Cb = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.BY;
            if (this.vn.jd().Cp) {
                throw new BdHttpCancelException();
            }
            if (this.BP != null) {
                this.BP.schedule(this.BO, 45000L);
            }
            dVar.Cb = -6;
            this.vn.jc().a(this.BH, boundary, dVar);
            dVar.Cb = -7;
            String contentType = this.BH.getContentType();
            this.vH = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aV(contentType)) {
                this.BH.disconnect();
                this.BH.connect();
                if (this.vn.jd().Cp) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.vn.jd().Cp) {
                throw new BdHttpCancelException();
            }
            dVar.Cb = -8;
            this.vn.jd().e(this.BH);
            dVar.Ca = this.vn.jd().responseCode;
            dVar.BU = this.BH.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.BH);
            if (c != null) {
                dVar.BU += c.length;
                this.vn.jd().Ct = c.length;
                this.vn.jd().Cs = c(this.vn.jd().contentEncoding, c);
            }
            dVar.BV = new Date().getTime() - time;
            dVar.Cb = -9;
        } finally {
            if (this.BP != null) {
                this.BP.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.BH);
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
            String url = this.vn.jc().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.BH = a(a, i2, i);
            if (this.vn.jd().Cp) {
                this.BK = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.h(null);
                com.baidu.adp.lib.g.a.f(this.BH);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.bp(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.bn(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.vn.jc().d(this.BH);
                this.BH.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.BH.connect();
                if (this.BI <= 0) {
                    this.BI = System.currentTimeMillis();
                }
                this.BJ = System.currentTimeMillis();
                int responseCode = this.BH.getResponseCode();
                this.vH = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.BH.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.f(this.BH);
                        this.BH = a(new URL(url2.toString()), i2, i);
                        this.vn.jc().d(this.BH);
                        this.BH.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.BH.connect();
                        responseCode = this.BH.getResponseCode();
                    }
                }
                this.vn.jd().responseCode = responseCode;
                if (iU()) {
                    if (this.BH.getContentType() != null && this.BH.getContentType().contains("text/vnd.wap.wml")) {
                        this.BH.disconnect();
                        this.vn.jd().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.BK = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h(null);
                        com.baidu.adp.lib.g.a.f(this.BH);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.BH.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.l(headerField2.substring(indexOf + 1), 0);
                    }
                    int l = (i3 == 0 && this.vn.jd().responseCode == 200 && (headerField = this.BH.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.l(headerField, 0) : i3;
                    this.vn.jd().contentLength = String.valueOf(l);
                    dVar2.BT = url.getBytes().length;
                    dVar2.BU = this.BH.getHeaderFields().toString().getBytes().length;
                    dVar2.BU += l;
                    if (this.vn.jd().responseCode == 416 || this.vn.jd().responseCode == 204) {
                        this.BK = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h(null);
                        com.baidu.adp.lib.g.a.f(this.BH);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (l != 0 && length >= l) {
                        this.BK = System.currentTimeMillis();
                        this.BK = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.h(null);
                        com.baidu.adp.lib.g.a.f(this.BH);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.BH.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = l > 0 ? l / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.o((int) length, l);
                            }
                            while (!this.vn.jd().Cp) {
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
                                this.BK = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.h(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.BH);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.BK = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.h(inputStream);
                            com.baidu.adp.lib.g.a.f(this.BH);
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

    private boolean iU() {
        return this.vn.jd().responseCode == 200 || this.vn.jd().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.Cb = -1;
        try {
            String url = this.vn.jc().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.vn.jd().Cp) {
                throw new BdHttpCancelException();
            }
            dVar.Cb = -2;
            this.BH = c(a);
            dVar.Cb = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.BH == null) {
                throw new SocketException("network not available.");
            }
            this.BH.setRequestMethod("POST");
            this.BH.setDoOutput(true);
            this.BH.setDoInput(true);
            this.BH.setConnectTimeout(i2);
            this.BH.setReadTimeout(i);
            this.BH.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.vn.jd().Cp) {
                throw new BdHttpCancelException();
            }
            this.vn.jc().d(this.BH);
            if (this.vn.jd().Cp) {
                throw new BdHttpCancelException();
            }
            dVar.BY = System.currentTimeMillis() - currentTimeMillis;
            dVar.Cb = -4;
            this.BH.connect();
            if (this.BI <= 0) {
                this.BI = System.currentTimeMillis();
            }
            this.BJ = System.currentTimeMillis();
            dVar.Cb = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.BY;
            if (this.vn.jd().Cp) {
                throw new BdHttpCancelException();
            }
            dVar.Cb = -6;
            this.vn.jc().a(this.BH, dVar);
            dVar.Cb = -7;
            if (this.vn.jd().Cp) {
                throw new BdHttpCancelException();
            }
            String contentType = this.BH.getContentType();
            this.vH = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aV(contentType)) {
                this.BH.disconnect();
                this.BH.connect();
                if (this.vn.jd().Cp) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Cb = -8;
            this.vn.jd().e(this.BH);
            dVar.Ca = this.vn.jd().responseCode;
            dVar.BU = this.BH.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.BH);
            if (c != null) {
                dVar.BU += c.length;
                this.vn.jd().Ct = c.length;
                this.vn.jd().Cs = c(this.vn.jd().contentEncoding, c);
            }
            dVar.BV = new Date().getTime() - currentTimeMillis;
            dVar.Cb = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.BH);
        }
    }
}
