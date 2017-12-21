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
    private e nI;
    private HttpURLConnection uE;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static String boundary = "--------7da3d81520810*";
    private long uF = 0;
    private long uG = 0;
    private long od = 0;
    private long uH = 0;
    private long uI = 0;
    private boolean uJ = false;
    private boolean uK = true;
    private TimerTask uL = new TimerTask() { // from class: com.baidu.adp.lib.network.http.b.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                b.this.fo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Timer uM = new Timer();

    public long fi() {
        return this.uI;
    }

    public long fj() {
        return this.uH;
    }

    public long fk() {
        return this.uF;
    }

    public long fl() {
        return this.uG;
    }

    public long fm() {
        return this.od;
    }

    public boolean fn() {
        return this.uJ;
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    public b(e eVar) {
        if (eVar == null) {
            throw new NullPointerException("init HttpImpl's args context is null");
        }
        this.nI = eVar;
    }

    public void fo() {
        this.nI.fz().vm = true;
        com.baidu.adp.lib.g.a.f(this.uE);
    }

    private URL a(String str, d dVar) throws Exception {
        a fh;
        URL url = new URL(str);
        if (this.uK && (fh = a.fh()) != null) {
            String ag = fh.ag(str);
            if (!TextUtils.isEmpty(ag)) {
                this.nI.fy().o("Host", url.getHost());
                URL url2 = new URL(str.replace("://" + url.getHost(), "://" + ag));
                this.uJ = true;
                dVar.va = ag;
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
                            this.nI.fy().o("X-Online-Host", url.getHost());
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
        dVar.uY = -1;
        if (this.nI.fz().vm) {
            throw new BdHttpCancelException();
        }
        String c = this.nI.fy().c(dVar);
        dVar.url = c;
        URL a = a(c, dVar);
        if (this.nI.fz().vm) {
            throw new BdHttpCancelException();
        }
        dVar.uY = -2;
        this.uE = c(a);
        dVar.uY = -3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.uE == null) {
                throw new SocketException("network not available.");
            }
            this.uE.setRequestMethod("GET");
            this.uE.setConnectTimeout(i2);
            this.uE.setReadTimeout(i);
            this.nI.fy().d(this.uE);
            if (this.nI.fz().vm) {
                throw new BdHttpCancelException();
            }
            dVar.uV = new Date().getTime() - currentTimeMillis;
            dVar.uY = -4;
            this.uE.connect();
            if (this.uF <= 0) {
                this.uF = System.currentTimeMillis();
            }
            this.uG = System.currentTimeMillis();
            dVar.uY = -5;
            dVar.connectTime = (new Date().getTime() - currentTimeMillis) - dVar.uV;
            if (this.nI.fz().vm) {
                throw new BdHttpCancelException();
            }
            String contentType = this.uE.getContentType();
            this.od = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ak(contentType)) {
                this.uE.disconnect();
                this.uE.connect();
                if (this.nI.fz().vm) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uY = -8;
            this.nI.fz().e(this.uE);
            if (c.contains("c.tieba.baidu.com") && (map = this.nI.fz().vo) != null && !map.isEmpty() && (list = map.get("Tracecode")) != null && list.size() > 1) {
                dVar.vb = list.get(0);
                dVar.vc = list.get(1);
            }
            dVar.uX = this.nI.fz().responseCode;
            dVar.uR = this.uE.getHeaderFields().toString().getBytes().length;
            byte[] c2 = c(this.uE);
            if (c2 != null) {
                dVar.uR += c2.length;
                this.nI.fz().vp = c(this.nI.fz().contentEncoding, c2);
            }
            dVar.uY = -9;
            dVar.uS = new Date().getTime() - currentTimeMillis;
        } finally {
            if (this.uE != null) {
                this.uE.disconnect();
            }
        }
    }

    protected final byte[] c(String str, byte[] bArr) throws Exception {
        if (str != null && str.toLowerCase().contains("gzip")) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            com.baidu.adp.lib.util.g.c(byteArrayInputStream, byteArrayOutputStream);
            this.uI = System.currentTimeMillis();
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
                while (!this.nI.fz().vm && (read = inputStream2.read(bArr2)) != -1) {
                    try {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        this.uH = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
                if (this.nI.fz().vm) {
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
        this.uH = System.currentTimeMillis();
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        com.baidu.adp.lib.g.a.d(inputStream2);
        return bArr;
    }

    public void b(int i, int i2, d dVar) throws Exception {
        dVar.uY = -1;
        try {
            String url = this.nI.fy().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.nI.fz().vm) {
                throw new BdHttpCancelException();
            }
            dVar.uY = -2;
            this.uE = c(a);
            dVar.uY = -3;
            System.currentTimeMillis();
            if (this.uE == null) {
                throw new SocketException("network not available.");
            }
            this.uE.setRequestMethod("POST");
            this.uE.setDoOutput(true);
            this.uE.setDoInput(true);
            this.uE.setConnectTimeout(i2);
            this.uE.setReadTimeout(i);
            this.uE.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);
            if (this.nI.fz().vm) {
                throw new BdHttpCancelException();
            }
            this.nI.fy().d(this.uE);
            if (this.nI.fz().vm) {
                throw new BdHttpCancelException();
            }
            long time = new Date().getTime();
            dVar.uV = new Date().getTime() - time;
            dVar.uY = -4;
            this.uE.connect();
            if (this.uF <= 0) {
                this.uF = System.currentTimeMillis();
            }
            this.uG = System.currentTimeMillis();
            dVar.uY = -5;
            dVar.connectTime = (new Date().getTime() - time) - dVar.uV;
            if (this.nI.fz().vm) {
                throw new BdHttpCancelException();
            }
            if (this.uM != null) {
                this.uM.schedule(this.uL, 45000L);
            }
            dVar.uY = -6;
            this.nI.fy().a(this.uE, boundary, dVar);
            dVar.uY = -7;
            String contentType = this.uE.getContentType();
            this.od = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ak(contentType)) {
                this.uE.disconnect();
                this.uE.connect();
                if (this.nI.fz().vm) {
                    throw new BdHttpCancelException();
                }
            }
            if (this.nI.fz().vm) {
                throw new BdHttpCancelException();
            }
            dVar.uY = -8;
            this.nI.fz().e(this.uE);
            dVar.uX = this.nI.fz().responseCode;
            dVar.uR = this.uE.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.uE);
            if (c != null) {
                dVar.uR += c.length;
                this.nI.fz().vq = c.length;
                this.nI.fz().vp = c(this.nI.fz().contentEncoding, c);
            }
            dVar.uS = new Date().getTime() - time;
            dVar.uY = -9;
        } finally {
            if (this.uM != null) {
                this.uM.cancel();
            }
            com.baidu.adp.lib.g.a.f(this.uE);
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
            String url = this.nI.fy().getUrl();
            dVar2.url = url;
            URL a = a(url, dVar2);
            this.uE = a(a, i2, i);
            if (this.nI.fz().vm) {
                this.uH = System.currentTimeMillis();
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.f(this.uE);
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
                this.nI.fy().d(this.uE);
                this.uE.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.uE.connect();
                if (this.uF <= 0) {
                    this.uF = System.currentTimeMillis();
                }
                this.uG = System.currentTimeMillis();
                int responseCode = this.uE.getResponseCode();
                this.od = System.currentTimeMillis();
                if (responseCode == 302) {
                    URL url2 = this.uE.getURL();
                    if (!TextUtils.equals(url2.getProtocol(), a.getProtocol())) {
                        com.baidu.adp.lib.g.a.f(this.uE);
                        this.uE = a(new URL(url2.toString()), i2, i);
                        this.nI.fy().d(this.uE);
                        this.uE.addRequestProperty("Range", "bytes=" + String.valueOf(length) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        this.uE.connect();
                        responseCode = this.uE.getResponseCode();
                    }
                }
                this.nI.fz().responseCode = responseCode;
                if (fp()) {
                    if (this.uE.getContentType() != null && this.uE.getContentType().contains("text/vnd.wap.wml")) {
                        this.uE.disconnect();
                        this.nI.fz().responseCode = 0;
                        boolean a2 = a(str, hVar, i, i2, z, dVar2, z2);
                        this.uH = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.uE);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return a2;
                    }
                    int i3 = 0;
                    String headerField2 = this.uE.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i3 = com.baidu.adp.lib.g.b.g(headerField2.substring(indexOf + 1), 0);
                    }
                    int g = (i3 == 0 && this.nI.fz().responseCode == 200 && (headerField = this.uE.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.g.b.g(headerField, 0) : i3;
                    this.nI.fz().contentLength = String.valueOf(g);
                    dVar2.uQ = url.getBytes().length;
                    dVar2.uR = this.uE.getHeaderFields().toString().getBytes().length;
                    dVar2.uR += g;
                    if (this.nI.fz().responseCode == 416 || this.nI.fz().responseCode == 204) {
                        this.uH = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.uE);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else if (g != 0 && length >= g) {
                        this.uH = System.currentTimeMillis();
                        this.uH = System.currentTimeMillis();
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.f(this.uE);
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                        return true;
                    } else {
                        InputStream inputStream2 = this.uE.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            int i4 = 0;
                            int i5 = g > 0 ? g / 50 : 0;
                            int i6 = 0;
                            if (hVar != null && length > 0) {
                                hVar.m((int) length, g);
                            }
                            while (!this.nI.fz().vm) {
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
                                this.uH = System.currentTimeMillis();
                                com.baidu.adp.lib.g.a.d(inputStream2);
                                com.baidu.adp.lib.g.a.f(this.uE);
                                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                                return z3;
                            } catch (Exception e2) {
                                throw new FileNotFoundException();
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStream2;
                            fileOutputStream = fileOutputStream2;
                            this.uH = System.currentTimeMillis();
                            com.baidu.adp.lib.g.a.d(inputStream);
                            com.baidu.adp.lib.g.a.f(this.uE);
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
        return this.nI.fz().responseCode == 200 || this.nI.fz().responseCode == 206;
    }

    public void c(int i, int i2, d dVar) throws Exception {
        dVar.uY = -1;
        try {
            String url = this.nI.fy().getUrl();
            dVar.url = url;
            URL a = a(url, dVar);
            if (this.nI.fz().vm) {
                throw new BdHttpCancelException();
            }
            dVar.uY = -2;
            this.uE = c(a);
            dVar.uY = -3;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.uE == null) {
                throw new SocketException("network not available.");
            }
            this.uE.setRequestMethod("POST");
            this.uE.setDoOutput(true);
            this.uE.setDoInput(true);
            this.uE.setConnectTimeout(i2);
            this.uE.setReadTimeout(i);
            this.uE.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (this.nI.fz().vm) {
                throw new BdHttpCancelException();
            }
            this.nI.fy().d(this.uE);
            if (this.nI.fz().vm) {
                throw new BdHttpCancelException();
            }
            dVar.uV = System.currentTimeMillis() - currentTimeMillis;
            dVar.uY = -4;
            this.uE.connect();
            if (this.uF <= 0) {
                this.uF = System.currentTimeMillis();
            }
            this.uG = System.currentTimeMillis();
            dVar.uY = -5;
            dVar.connectTime = (System.currentTimeMillis() - currentTimeMillis) - dVar.uV;
            if (this.nI.fz().vm) {
                throw new BdHttpCancelException();
            }
            dVar.uY = -6;
            this.nI.fy().a(this.uE, dVar);
            dVar.uY = -7;
            if (this.nI.fz().vm) {
                throw new BdHttpCancelException();
            }
            String contentType = this.uE.getContentType();
            this.od = System.currentTimeMillis();
            if (com.baidu.adp.lib.network.a.b.ak(contentType)) {
                this.uE.disconnect();
                this.uE.connect();
                if (this.nI.fz().vm) {
                    throw new BdHttpCancelException();
                }
            }
            dVar.uY = -8;
            this.nI.fz().e(this.uE);
            dVar.uX = this.nI.fz().responseCode;
            dVar.uR = this.uE.getHeaderFields().toString().getBytes().length;
            byte[] c = c(this.uE);
            if (c != null) {
                dVar.uR += c.length;
                this.nI.fz().vq = c.length;
                this.nI.fz().vp = c(this.nI.fz().contentEncoding, c);
            }
            dVar.uS = new Date().getTime() - currentTimeMillis;
            dVar.uY = -9;
        } finally {
            com.baidu.adp.lib.g.a.f(this.uE);
        }
    }
}
