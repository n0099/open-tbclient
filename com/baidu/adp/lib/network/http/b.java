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
    private e acl;
    private HttpURLConnection aiN;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long aiO = 0;
    private long aiP = 0;
    private long acF = 0;
    private long aiQ = 0;
    private long aiR = 0;
    private boolean aiS = false;
    private boolean aiT = true;
    private TimerTask aiU = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.mS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer aiV = new Timer();

    public long mM() {
        return this.aiR;
    }

    public long mN() {
        return this.aiQ;
    }

    public long mO() {
        return this.aiO;
    }

    public long mP() {
        return this.aiP;
    }

    public long mQ() {
        return this.acF;
    }

    public boolean mR() {
        return this.aiS;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.acl = eVar;
    }

    public void mS() {
        this.acl.nc().ajv = true;
        com.baidu.adp.lib.g.a.f(this.aiN);
    }

    private URL a(String str, d dVar) throws Exception {
        a mL;
        URL url = new URL(str);
        if (this.aiT && (mL = a.mL()) != null) {
            String ao = mL.ao(str);
            if (!TextUtils.isEmpty(ao)) {
                this.acl.nb().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ao));
                this.aiS = true;
                dVar.ajj = ao;
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
        String oT;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.oJ()) {
                if (j.oL() && (oT = j.oT()) != null && oT.length() > 0) {
                    if (j.aS(oT) && j.oV()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(oT);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.acl.nb().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(oT, j.oU())));
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
        dVar.ajh = -1;
        if (this.acl.nc().ajv) {
            throw new BdHttpCancelException();
        }
        String c = this.acl.nb().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.acl.nc().ajv) {
            throw new BdHttpCancelException();
        }
        dVar.ajh = -2;
        this.aiN = c(a);
        dVar.ajh = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.aiN == null) {
                throw new SocketException("network not available.");
            }
            this.aiN.setRequestMethod("GET");
            this.aiN.setConnectTimeout(i2);
            this.aiN.setReadTimeout(i);
            this.acl.nb().d(this.aiN);
            if (this.acl.nc().ajv) {
                throw new BdHttpCancelException();
            }
            dVar.aje = new Date().getTime() - currentTimeMillis;
            dVar.ajh = -4;
            this.aiN.connect();
            if (this.aiO <= 0) {
                this.aiO = System.currentTimeMillis();
            }
            this.aiP = System.currentTimeMillis();
            dVar.ajh = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.aje;
            if (this.acl.nc().ajv) {
                throw new BdHttpCancelException();
            }
            String contentType = this.aiN.getContentType();
            this.acF = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.as(contentType)) {
                this.aiN.disconnect();
                this.aiN.connect();
                if (this.acl.nc().ajv) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.ajh = -8;
            this.acl.nc().e(this.aiN);
            if (c.contains("c.tieba.baidu.com") && (map = this.acl.nc().ajx) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.ajk = list.get(0);
                dVar.ajl = list.get(1);
            }
            dVar.ajg = this.acl.nc().responseCode;
            dVar.aja = this.aiN.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.aiN);
            if (c2 != null) {
                dVar.aja += c2.length;
                this.acl.nc().ajy = c(this.acl.nc().contentEncoding, c2);
            }
            dVar.ajh = -9;
            dVar.ajb = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.aiN != null) {
                this.aiN.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.c(byteArrayInputStream, byteArrayOutputStream);
            this.aiR = System.currentTimeMillis();
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
                while (!this.acl.nc().ajv && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.aiQ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.acl.nc().ajv) {
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
        this.aiQ = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.ajh = -1;
        try {
            String url = this.acl.nb().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.acl.nc().ajv) {
                throw new BdHttpCancelException();
            }
            dVar.ajh = -2;
            this.aiN = c(a);
            dVar.ajh = -3;
            System.currentTimeMillis();
            if (this.aiN == null) {
                throw new SocketException("network not available.");
            }
            this.aiN.setRequestMethod("POST");
            this.aiN.setDoOutput(true);
            this.aiN.setDoInput(true);
            this.aiN.setConnectTimeout(i2);
            this.aiN.setReadTimeout(i);
            this.aiN.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            if (this.acl.nc().ajv) {
                throw new BdHttpCancelException();
            }
            this.acl.nb().d(this.aiN);
            if (this.acl.nc().ajv) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.aje = new Date().getTime() - time;
            dVar.ajh = -4;
            this.aiN.connect();
            if (this.aiO <= 0) {
                this.aiO = System.currentTimeMillis();
            }
            this.aiP = System.currentTimeMillis();
            dVar.ajh = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.aje;
            if (this.acl.nc().ajv) {
                throw new BdHttpCancelException();
            }
            if (this.aiV != null) {
                this.aiV.schedule(this.aiU, 45000L);
            }
            dVar.ajh = -6;
            this.acl.nb().a(this.aiN, boundary, dVar);
            dVar.ajh = -7;
            String contentType = this.aiN.getContentType();
            this.acF = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.as(contentType)) {
                this.aiN.disconnect();
                this.aiN.connect();
                if (this.acl.nc().ajv) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.acl.nc().ajv) {
                throw new BdHttpCancelException();
            }
            dVar.ajh = -8;
            this.acl.nc().e(this.aiN);
            dVar.ajg = this.acl.nc().responseCode;
            dVar.aja = this.aiN.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.aiN);
            if (c != null) {
                dVar.aja += c.length;
                this.acl.nc().ajz = c.length;
                this.acl.nc().ajy = c(this.acl.nc().contentEncoding, c);
            }
            dVar.ajb = new Date().getTime() - time;
            dVar.ajh = -9;
        } finally {
            if (this.aiV != null) {
                this.aiV.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.aiN);
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
            String url = this.acl.nb().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.aiN = a(a, i2, i);
            if (this.acl.nc().ajv) {
                this.aiQ = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.f(this.aiN);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aM(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aK(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.acl.nb().d(this.aiN);
                this.aiN.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.aiN.connect();
                if (this.aiO <= 0) {
                    this.aiO = System.currentTimeMillis();
                }
                this.aiP = System.currentTimeMillis();
                int responseCode = this.aiN.getResponseCode();
                this.acF = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.aiN.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.f(this.aiN);
                        this.aiN = a(new URL(url2.toString()), i2, i);
                        this.acl.nb().d(this.aiN);
                        this.aiN.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.aiN.connect();
                        responseCode = this.aiN.getResponseCode();
                    }
                }
                this.acl.nc().responseCode = responseCode;
                if (mT()) {
                    if (this.aiN.getContentType() != null && this.aiN.getContentType().contains("text/vnd.wap.wml")) {
                        this.aiN.disconnect();
                        this.acl.nc().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.aiQ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiN);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.aiN.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.h(headerField2.substring(indexOf + 1), 0);
                    }
                    int h = (i3 == 0 && this.acl.nc().responseCode == 200 && (headerField = this.aiN.getHeaderField(HTTP.CONTENT_LEN)) != null) ? com.baidu.adp.lib.g.b.h(headerField, 0) : i3;
                    this.acl.nc().contentLength = String.valueOf(h);
                    dVar2.aiZ = url.getBytes().length;
                    dVar2.aja = this.aiN.getHeaderFields().toString().getBytes().length;
                    dVar2.aja += h;
                    if (this.acl.nc().responseCode == 416 || this.acl.nc().responseCode == 204) {
                        this.aiQ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiN);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (h != 0 && length >= h) {
                        this.aiQ = System.currentTimeMillis();
                        this.aiQ = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.aiN);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.aiN.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = h > 0 ? h / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.an((int) length, h);
                            }
                            while (!this.acl.nc().ajv) {
                                int read = inputStream2.read(bArr);
                                if (read != -1) {
                                    try {
                                        fileOutputStream2.write(bArr, 0, read);
                                        i4 += read;
                                        i6 += read;
                                        if (hVar != null && (i6 > i5 || i4 == h)) {
                                            i6 = 0;
                                            hVar.an((int) (i4 + length), h);
                                        }
                                    } catch (Exception e) {
                                        throw new FileNotFoundException();
                                    }
                                }
                            }
                            try {
                                fileOutputStream2.flush();
                                boolean z3 = ((long) i4) + length >= ((long) h);
                                this.aiQ = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.aiN);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.aiQ = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.f(this.aiN);
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

    private boolean mT() {
        return this.acl.nc().responseCode == 200 || this.acl.nc().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.ajh = -1;
        try {
            String url = this.acl.nb().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.acl.nc().ajv) {
                throw new BdHttpCancelException();
            }
            dVar.ajh = -2;
            this.aiN = c(a);
            dVar.ajh = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aiN == null) {
                throw new SocketException("network not available.");
            }
            this.aiN.setRequestMethod("POST");
            this.aiN.setDoOutput(true);
            this.aiN.setDoInput(true);
            this.aiN.setConnectTimeout(i2);
            this.aiN.setReadTimeout(i);
            this.aiN.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            if (this.acl.nc().ajv) {
                throw new BdHttpCancelException();
            }
            this.acl.nb().d(this.aiN);
            if (this.acl.nc().ajv) {
                throw new BdHttpCancelException();
            }
            dVar.aje = System.currentTimeMillis() - currentTimeMillis;
            dVar.ajh = -4;
            this.aiN.connect();
            if (this.aiO <= 0) {
                this.aiO = System.currentTimeMillis();
            }
            this.aiP = System.currentTimeMillis();
            dVar.ajh = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.aje;
            if (this.acl.nc().ajv) {
                throw new BdHttpCancelException();
            }
            dVar.ajh = -6;
            this.acl.nb().a(this.aiN, dVar);
            dVar.ajh = -7;
            if (this.acl.nc().ajv) {
                throw new BdHttpCancelException();
            }
            String contentType = this.aiN.getContentType();
            this.acF = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.as(contentType)) {
                this.aiN.disconnect();
                this.aiN.connect();
                if (this.acl.nc().ajv) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.ajh = -8;
            this.acl.nc().e(this.aiN);
            dVar.ajg = this.acl.nc().responseCode;
            dVar.aja = this.aiN.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.aiN);
            if (c != null) {
                dVar.aja += c.length;
                this.acl.nc().ajz = c.length;
                this.acl.nc().ajy = c(this.acl.nc().contentEncoding, c);
            }
            dVar.ajb = new Date().getTime() - currentTimeMillis;
            dVar.ajh = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.aiN);
        }
    }
}
