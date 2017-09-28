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
import org.apache.http.entity.mime.MIME;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private e nH;
    private HttpURLConnection uF;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long uG = 0;
    private long uH = 0;
    private long oc = 0;
    private long uI = 0;
    private long uJ = 0;
    private boolean uK = false;
    private boolean uL = true;
    private TimerTask uM = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.fo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer uN = new Timer();

    public long fi() {
        return this.uJ;
    }

    public long fj() {
        return this.uI;
    }

    public long fk() {
        return this.uG;
    }

    public long fl() {
        return this.uH;
    }

    public long fm() {
        return this.oc;
    }

    public boolean fn() {
        return this.uK;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.nH = eVar;
    }

    public void fo() {
        this.nH.fz().vn = true;
        com.baidu.adp.lib.g.a.f(this.uF);
    }

    private URL a(String str, d dVar) throws Exception {
        a fh;
        URL url = new URL(str);
        if (this.uL && (fh = a.fh()) != null) {
            String ag = fh.ag(str);
            if (!TextUtils.isEmpty(ag)) {
                this.nH.fy().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ag));
                this.uK = true;
                dVar.vb = ag;
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
        String hr;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (j.hh()) {
                if (j.hj() && (hr = j.hr()) != null && hr.length() > 0) {
                    if (j.aK(hr) && j.ht()) {
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(hr);
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        try {
                            this.nH.fy().o("X-Online-Host", url.getHost());
                            httpURLConnection2 = httpURLConnection;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return httpURLConnection;
                        }
                    } else {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hr, j.hs())));
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
        dVar.uZ = -1;
        if (this.nH.fz().vn) {
            throw new BdHttpCancelException();
        }
        String c = this.nH.fy().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.nH.fz().vn) {
            throw new BdHttpCancelException();
        }
        dVar.uZ = -2;
        this.uF = c(a);
        dVar.uZ = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.uF == null) {
                throw new SocketException("network not available.");
            }
            this.uF.setRequestMethod("GET");
            this.uF.setConnectTimeout(i2);
            this.uF.setReadTimeout(i);
            this.nH.fy().d(this.uF);
            if (this.nH.fz().vn) {
                throw new BdHttpCancelException();
            }
            dVar.uW = new Date().getTime() - currentTimeMillis;
            dVar.uZ = -4;
            this.uF.connect();
            if (this.uG <= 0) {
                this.uG = System.currentTimeMillis();
            }
            this.uH = System.currentTimeMillis();
            dVar.uZ = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.uW;
            if (this.nH.fz().vn) {
                throw new BdHttpCancelException();
            }
            String contentType = this.uF.getContentType();
            this.oc = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ak(contentType)) {
                this.uF.disconnect();
                this.uF.connect();
                if (this.nH.fz().vn) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uZ = -8;
            this.nH.fz().e(this.uF);
            if (c.contains("c.tieba.baidu.com") && (map = this.nH.fz().vp) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.vc = list.get(0);
                dVar.vd = list.get(1);
            }
            dVar.uY = this.nH.fz().responseCode;
            dVar.uS = this.uF.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.uF);
            if (c2 != null) {
                dVar.uS += c2.length;
                this.nH.fz().vq = c(this.nH.fz().contentEncoding, c2);
            }
            dVar.uZ = -9;
            dVar.uT = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.uF != null) {
                this.uF.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.c(byteArrayInputStream, byteArrayOutputStream);
            this.uJ = System.currentTimeMillis();
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
                while (!this.nH.fz().vn && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.uI = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.nH.fz().vn) {
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
        this.uI = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.uZ = -1;
        try {
            String url = this.nH.fy().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.nH.fz().vn) {
                throw new BdHttpCancelException();
            }
            dVar.uZ = -2;
            this.uF = c(a);
            dVar.uZ = -3;
            System.currentTimeMillis();
            if (this.uF == null) {
                throw new SocketException("network not available.");
            }
            this.uF.setRequestMethod("POST");
            this.uF.setDoOutput(true);
            this.uF.setDoInput(true);
            this.uF.setConnectTimeout(i2);
            this.uF.setReadTimeout(i);
            this.uF.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.nH.fz().vn) {
                throw new BdHttpCancelException();
            }
            this.nH.fy().d(this.uF);
            if (this.nH.fz().vn) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.uW = new Date().getTime() - time;
            dVar.uZ = -4;
            this.uF.connect();
            if (this.uG <= 0) {
                this.uG = System.currentTimeMillis();
            }
            this.uH = System.currentTimeMillis();
            dVar.uZ = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.uW;
            if (this.nH.fz().vn) {
                throw new BdHttpCancelException();
            }
            if (this.uN != null) {
                this.uN.schedule(this.uM, 45000L);
            }
            dVar.uZ = -6;
            this.nH.fy().a(this.uF, boundary, dVar);
            dVar.uZ = -7;
            String contentType = this.uF.getContentType();
            this.oc = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ak(contentType)) {
                this.uF.disconnect();
                this.uF.connect();
                if (this.nH.fz().vn) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.nH.fz().vn) {
                throw new BdHttpCancelException();
            }
            dVar.uZ = -8;
            this.nH.fz().e(this.uF);
            dVar.uY = this.nH.fz().responseCode;
            dVar.uS = this.uF.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.uF);
            if (c != null) {
                dVar.uS += c.length;
                this.nH.fz().vr = c.length;
                this.nH.fz().vq = c(this.nH.fz().contentEncoding, c);
            }
            dVar.uT = new Date().getTime() - time;
            dVar.uZ = -9;
        } finally {
            if (this.uN != null) {
                this.uN.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.uF);
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
            String url = this.nH.fy().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.uF = a(a, i2, i);
            if (this.nH.fz().vn) {
                this.uI = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.f(this.uF);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            }
            if (z2) {
                com.baidu.adp.lib.util.f.aE(str);
            }
            File file = z ? new File(str) : com.baidu.adp.lib.util.f.aC(str);
            if (file == null) {
                throw new FileNotFoundException();
            }
            long length = file.length();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                this.nH.fy().d(this.uF);
                this.uF.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.uF.connect();
                if (this.uG <= 0) {
                    this.uG = System.currentTimeMillis();
                }
                this.uH = System.currentTimeMillis();
                int responseCode = this.uF.getResponseCode();
                this.oc = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.uF.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.f(this.uF);
                        this.uF = a(new URL(url2.toString()), i2, i);
                        this.nH.fy().d(this.uF);
                        this.uF.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.uF.connect();
                        responseCode = this.uF.getResponseCode();
                    }
                }
                this.nH.fz().responseCode = responseCode;
                if (fp()) {
                    if (this.uF.getContentType() != null && this.uF.getContentType().contains("text/vnd.wap.wml")) {
                        this.uF.disconnect();
                        this.nH.fz().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.uI = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.uF);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.uF.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.nH.fz().responseCode == 200 && (headerField = this.uF.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.nH.fz().contentLength = String.valueOf(g);
                    dVar2.uR = url.getBytes().length;
                    dVar2.uS = this.uF.getHeaderFields().toString().getBytes().length;
                    dVar2.uS += g;
                    if (this.nH.fz().responseCode == 416 || this.nH.fz().responseCode == 204) {
                        this.uI = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.uF);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.uI = System.currentTimeMillis();
                        this.uI = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.uF);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.uF.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.m((int) length, g);
                            }
                            while (!this.nH.fz().vn) {
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
                                this.uI = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.uF);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.uI = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.f(this.uF);
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

    private boolean fp() {
        return this.nH.fz().responseCode == 200 || this.nH.fz().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.uZ = -1;
        try {
            String url = this.nH.fy().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.nH.fz().vn) {
                throw new BdHttpCancelException();
            }
            dVar.uZ = -2;
            this.uF = c(a);
            dVar.uZ = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.uF == null) {
                throw new SocketException("network not available.");
            }
            this.uF.setRequestMethod("POST");
            this.uF.setDoOutput(true);
            this.uF.setDoInput(true);
            this.uF.setConnectTimeout(i2);
            this.uF.setReadTimeout(i);
            this.uF.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.nH.fz().vn) {
                throw new BdHttpCancelException();
            }
            this.nH.fy().d(this.uF);
            if (this.nH.fz().vn) {
                throw new BdHttpCancelException();
            }
            dVar.uW = System.currentTimeMillis() - currentTimeMillis;
            dVar.uZ = -4;
            this.uF.connect();
            if (this.uG <= 0) {
                this.uG = System.currentTimeMillis();
            }
            this.uH = System.currentTimeMillis();
            dVar.uZ = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.uW;
            if (this.nH.fz().vn) {
                throw new BdHttpCancelException();
            }
            dVar.uZ = -6;
            this.nH.fy().a(this.uF, dVar);
            dVar.uZ = -7;
            if (this.nH.fz().vn) {
                throw new BdHttpCancelException();
            }
            String contentType = this.uF.getContentType();
            this.oc = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ak(contentType)) {
                this.uF.disconnect();
                this.uF.connect();
                if (this.nH.fz().vn) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uZ = -8;
            this.nH.fz().e(this.uF);
            dVar.uY = this.nH.fz().responseCode;
            dVar.uS = this.uF.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.uF);
            if (c != null) {
                dVar.uS += c.length;
                this.nH.fz().vr = c.length;
                this.nH.fz().vq = c(this.nH.fz().contentEncoding, c);
            }
            dVar.uT = new Date().getTime() - currentTimeMillis;
            dVar.uZ = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.uF);
        }
    }
}
