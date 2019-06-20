package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
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
    private e tF;
    private HttpURLConnection zZ;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long Aa = 0;
    private long Ab = 0;
    private long tZ = 0;
    private long Ac = 0;
    private long Ae = 0;
    private boolean Af = false;
    private boolean Ag = true;
    private boolean Ah = false;
    private TimerTask Ai = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.ia();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer Aj = new Timer();

    public long hU() {
        return this.Ae;
    }

    public long hV() {
        return this.Ac;
    }

    public long hW() {
        return this.Aa;
    }

    public long hX() {
        return this.Ab;
    }

    public long hY() {
        return this.tZ;
    }

    public boolean hZ() {
        return this.Af;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.tF = eVar;
    }

    public void ia() {
        this.tF.il().AJ = true;
        com.baidu.adp.lib.g.a.f(this.zZ);
    }

    private URL a(String str, d dVar) throws Exception {
        a hT;
        URL url = new URL(str);
        if (this.Ag && (hT = a.hT()) != null) {
            String az = hT.az(str);
            if (!TextUtils.isEmpty(az)) {
                this.tF.ik().q(HTTP.TARGET_HOST, url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + az));
                this.Af = true;
                dVar.Ax = az;
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
        String kb;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.jS()) {
                if (j.jU() && (kb = j.kb()) != null && kb.length() > 0) {
                    if (j.be(kb) && j.kd()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(kb);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.tF.ik().q("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(kb, j.kc())));
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
        dVar.Av = -1;
        if (this.tF.il().AJ) {
            throw new BdHttpCancelException();
        }
        String c = this.tF.ik().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.tF.il().AJ) {
            throw new BdHttpCancelException();
        }
        dVar.Av = -2;
        this.zZ = c(a);
        dVar.Av = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.zZ == null) {
                throw new SocketException("network not available.");
            }
            this.zZ.setRequestMethod("GET");
            this.zZ.setConnectTimeout(i2);
            this.zZ.setReadTimeout(i);
            this.tF.ik().d(this.zZ);
            if (this.tF.il().AJ) {
                throw new BdHttpCancelException();
            }
            dVar.As = new Date().getTime() - currentTimeMillis;
            dVar.Av = -4;
            this.zZ.connect();
            if (this.Aa <= 0) {
                this.Aa = System.currentTimeMillis();
            }
            this.Ab = System.currentTimeMillis();
            dVar.Av = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.As;
            if (this.tF.il().AJ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zZ.getContentType();
            this.tZ = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aF(contentType)) {
                this.zZ.disconnect();
                this.zZ.connect();
                if (this.tF.il().AJ) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Av = -8;
            this.tF.il().e(this.zZ);
            if (c.contains("c.tieba.baidu.com") && (map = this.tF.il().AM) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.Ay = list.get(0);
                dVar.Az = list.get(1);
            }
            dVar.Au = this.tF.il().responseCode;
            dVar.Ao = this.zZ.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.zZ);
            if (c2 != null) {
                dVar.Ao += c2.length;
                this.tF.il().AN = c(this.tF.il().contentEncoding, c2);
            }
            dVar.Av = -9;
            dVar.Ap = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.zZ != null) {
                this.zZ.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.d(byteArrayInputStream, byteArrayOutputStream);
            this.Ae = System.currentTimeMillis();
            return byteArrayOutputStream.toByteArray();
        } else if (this.Ae == 0) {
            this.Ae = System.currentTimeMillis();
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
                while (!this.tF.il().AJ && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.Ac = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.g(inputStream);
                        throw th;
                    }
                }
                if (this.tF.il().AJ) {
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
        this.Ac = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.g(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.Av = -1;
        try {
            String url = this.tF.ik().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.tF.il().AJ) {
                throw new BdHttpCancelException();
            }
            dVar.Av = -2;
            this.zZ = c(a);
            dVar.Av = -3;
            System.currentTimeMillis();
            if (this.zZ == null) {
                throw new SocketException("network not available.");
            }
            this.zZ.setRequestMethod("POST");
            this.zZ.setDoOutput(true);
            this.zZ.setDoInput(true);
            this.zZ.setConnectTimeout(i2);
            this.zZ.setReadTimeout(i);
            this.zZ.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.tF.il().AJ) {
                throw new BdHttpCancelException();
            }
            this.tF.ik().d(this.zZ);
            if (this.tF.il().AJ) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.As = new Date().getTime() - time;
            dVar.Av = -4;
            this.zZ.connect();
            if (this.Aa <= 0) {
                this.Aa = System.currentTimeMillis();
            }
            this.Ab = System.currentTimeMillis();
            dVar.Av = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.As;
            if (this.tF.il().AJ) {
                throw new BdHttpCancelException();
            }
            if (this.Aj != null) {
                this.Aj.schedule(this.Ai, 45000L);
            }
            dVar.Av = -6;
            this.tF.ik().a(this.zZ, boundary, dVar);
            dVar.Av = -7;
            String contentType = this.zZ.getContentType();
            this.tZ = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aF(contentType)) {
                this.zZ.disconnect();
                this.zZ.connect();
                if (this.tF.il().AJ) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.tF.il().AJ) {
                throw new BdHttpCancelException();
            }
            dVar.Av = -8;
            this.tF.il().e(this.zZ);
            dVar.Au = this.tF.il().responseCode;
            dVar.Ao = this.zZ.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zZ);
            if (c != null) {
                dVar.Ao += c.length;
                this.tF.il().AO = c.length;
                this.tF.il().AN = c(this.tF.il().contentEncoding, c);
            }
            dVar.Ap = new Date().getTime() - time;
            dVar.Av = -9;
        } finally {
            if (this.Aj != null) {
                this.Aj.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.zZ);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [708=7, 709=5, 710=5, 711=5] */
    public boolean a(String str, h hVar, int i, int i2, boolean z, d dVar, boolean z2) throws Exception {
        InputStream inputStream;
        int i3;
        URL url;
        boolean z3;
        String headerField;
        int indexOf;
        FileOutputStream fileOutputStream = null;
        d dVar2 = dVar == null ? new d() : dVar;
        try {
            String url2 = this.tF.ik().getUrl();
            dVar2.url = url2;
            URL a = a(url2, dVar2);
            this.zZ = a(a, i2, i);
            if (this.tF.il().AJ) {
                this.Ac = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.g(null);
                com.baidu.adp.lib.g.a.f(this.zZ);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aY(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aX(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.tF.ik().d(this.zZ);
                this.zZ.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.zZ.connect();
                if (this.Aa <= 0) {
                    this.Aa = System.currentTimeMillis();
                }
                this.Ab = System.currentTimeMillis();
                int responseCode = this.zZ.getResponseCode();
                this.tZ = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url3 = this.zZ.getURL();
                    if (TextUtils.equals(url3.getProtocol(), a.getProtocol())) {
                        i3 = responseCode;
                        url = url3;
                        z3 = false;
                    } else {
                        com.baidu.adp.lib.g.a.f(this.zZ);
                        this.zZ = a(new URL(url3.toString()), i2, i);
                        this.tF.ik().d(this.zZ);
                        this.zZ.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.zZ.connect();
                        i3 = this.zZ.getResponseCode();
                        url = url3;
                        z3 = true;
                    }
                } else {
                    i3 = responseCode;
                    url = null;
                    z3 = false;
                }
                this.tF.il().responseCode = i3;
                int i4 = 0;
                String headerField2 = this.zZ.getHeaderField("Content-Range");
                if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                    i4 = com.baidu.adp.lib.g.b.f(headerField2.substring(indexOf + 1), 0);
                }
                int f = (i4 == 0 && this.tF.il().responseCode == 200 && (headerField = this.zZ.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.f(headerField, 0) : i4;
                this.tF.il().contentLength = String.valueOf(f);
                if (!ib()) {
                    String str2 = "";
                    if (i3 == 302) {
                        str2 = (z3 ? "isReConn " : "") + "url=" + a + "-newUrl=" + url;
                    } else if (i3 == 416) {
                        String str3 = "fileLen=" + length + "-contentLen=" + f;
                        if (str != null && str.contains("plugin")) {
                            this.Ah = true;
                            com.baidu.adp.lib.util.f.aY(str);
                            BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), "downloadfile_range_err", "", 1, new Object[0]);
                        }
                        str2 = str3;
                    }
                    throw new UnsupportedOperationException(str2);
                } else if (this.zZ.getContentType() != null && this.zZ.getContentType().contains("text/vnd.wap.wml")) {
                    this.zZ.disconnect();
                    this.tF.il().responseCode = 0;
                    boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                    this.Ac = System.currentTimeMillis();
                    com.baidu.adp.lib.g.a.g(null);
                    com.baidu.adp.lib.g.a.f(this.zZ);
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                    return a2;
                } else {
                    dVar2.An = url2.getBytes().length;
                    dVar2.Ao = this.zZ.getHeaderFields().toString().getBytes().length;
                    dVar2.Ao += f;
                    if (f != 0 && length >= f) {
                        this.Ac = System.currentTimeMillis();
                        this.Ac = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(null);
                        com.baidu.adp.lib.g.a.f(this.zZ);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    }
                    InputStream inputStream2 = this.zZ.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        int i5 = f > 0 ? f / 50 : 0;
                        if (hVar != null && length > 0) {
                            hVar.m((int) length, f);
                        }
                        if (this.Ah) {
                            this.Ah = false;
                            BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), "downloadfile_range_err_ok", "", 1, new Object[0]);
                        }
                        int i6 = 0;
                        int i7 = 0;
                        while (!this.tF.il().AJ) {
                            int read = inputStream2.read(bArr);
                            if (read != -1) {
                                try {
                                    fileOutputStream2.write(bArr, 0, read);
                                    i7 += read;
                                    i6 += read;
                                    if (hVar != null && (i6 > i5 || i7 == f)) {
                                        i6 = 0;
                                        hVar.m((int) (i7 + length), f);
                                    }
                                } catch (Exception e) {
                                    throw new FileNotFoundException();
                                }
                            }
                        }
                        try {
                            fileOutputStream2.flush();
                            boolean z4 = ((long) i7) + length >= ((long) f);
                            this.Ac = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.g(inputStream2);
                            com.baidu.adp.lib.g.a.f(this.zZ);
                            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                            return z4;
                        } catch (Exception e2) {
                            throw new FileNotFoundException();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        inputStream = inputStream2;
                        this.Ac = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.g(inputStream);
                        com.baidu.adp.lib.g.a.f(this.zZ);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                        throw th;
                    }
                }
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

    private boolean ib() {
        return this.tF.il().responseCode == 200 || this.tF.il().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.Av = -1;
        try {
            String url = this.tF.ik().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.tF.il().AJ) {
                throw new BdHttpCancelException();
            }
            dVar.Av = -2;
            this.zZ = c(a);
            dVar.Av = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zZ == null) {
                throw new SocketException("network not available.");
            }
            this.zZ.setRequestMethod("POST");
            this.zZ.setDoOutput(true);
            this.zZ.setDoInput(true);
            this.zZ.setConnectTimeout(i2);
            this.zZ.setReadTimeout(i);
            this.zZ.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.tF.il().AJ) {
                throw new BdHttpCancelException();
            }
            this.tF.ik().d(this.zZ);
            if (this.tF.il().AJ) {
                throw new BdHttpCancelException();
            }
            dVar.As = System.currentTimeMillis() - currentTimeMillis;
            dVar.Av = -4;
            this.zZ.connect();
            if (this.Aa <= 0) {
                this.Aa = System.currentTimeMillis();
            }
            this.Ab = System.currentTimeMillis();
            dVar.Av = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.As;
            if (this.tF.il().AJ) {
                throw new BdHttpCancelException();
            }
            dVar.Av = -6;
            this.tF.ik().a(this.zZ, dVar);
            dVar.Av = -7;
            if (this.tF.il().AJ) {
                throw new BdHttpCancelException();
            }
            String contentType = this.zZ.getContentType();
            this.tZ = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.aF(contentType)) {
                this.zZ.disconnect();
                this.zZ.connect();
                if (this.tF.il().AJ) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.Av = -8;
            this.tF.il().e(this.zZ);
            dVar.Au = this.tF.il().responseCode;
            dVar.Ao = this.zZ.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.zZ);
            if (c != null) {
                dVar.Ao += c.length;
                this.tF.il().AO = c.length;
                this.tF.il().AN = c(this.tF.il().contentEncoding, c);
            }
            dVar.Ap = new Date().getTime() - currentTimeMillis;
            dVar.Av = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.zZ);
        }
    }
}
