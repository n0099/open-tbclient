package com.baidu.tbadk.core.util.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.g.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
/* loaded from: classes.dex */
public class f implements a.InterfaceC0005a {
    private static int abO;
    public static String aea;
    private static HttpClient aeb;
    private static String aeg;
    private static int aeh;
    private static long aei;
    private HttpGet adW;
    private final com.baidu.adp.lib.network.http.e adZ;
    public boolean aee;
    private final Context mContext;
    private static volatile String adU = null;
    private static volatile boolean adV = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams aec = new BasicHttpParams();
    private boolean rR = false;
    private boolean aed = false;
    private int aef = 0;
    private int adX = 0;
    private volatile boolean adY = false;

    static {
        abO = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(aec, 5000);
        HttpConnectionParams.setSoTimeout(aec, 30000);
        HttpConnectionParams.setSocketBufferSize(aec, 1024);
        HttpConnectionParams.setTcpNoDelay(aec, true);
        HttpClientParams.setRedirecting(aec, true);
        ConnManagerParams.setMaxConnectionsPerRoute(aec, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(aec, 10000L);
        ConnManagerParams.setMaxTotalConnections(aec, 15);
        HttpProtocolParams.setUserAgent(aec, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        aeb = new DefaultHttpClient(new ThreadSafeClientConnManager(aec, schemeRegistry), aec);
        aeb.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            abO = 4194304;
        }
        aeg = null;
        aeh = 0;
        aei = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        wA();
        this.adZ = eVar;
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
    }

    public static void wA() {
        synchronized (f.class) {
            if (!adV) {
                adV = true;
                wB();
            }
        }
    }

    public static synchronized void wB() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m411getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    adU = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void gT() {
        this.adY = true;
        this.adZ.hb().vu = true;
        wC();
    }

    private void wC() {
        try {
            if (this.adW != null) {
                this.adW.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().adS) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.iZ()) {
            this.aee = false;
            try {
                if (com.baidu.adp.lib.util.i.jb()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (aea == null) {
                            aea = com.baidu.adp.lib.util.i.jj();
                        }
                        if (aea != null && aea.length() > 0) {
                            this.aee = true;
                            if (dF(aea) && com.baidu.adp.lib.util.i.jl()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(aea);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.adW = e.getInstance().httpGetFactory(sb.toString(), this.aef, false);
                                    } else {
                                        this.adW = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.adW = new HttpGet(sb.toString());
                                }
                                this.adW.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.adW.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = aec.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    aec.setParameter("http.route.default-proxy", new HttpHost(aea, com.baidu.adp.lib.util.i.jk()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(aea) || httpHost.getPort() != com.baidu.adp.lib.util.i.jk()) {
                                        aec.setParameter("http.route.default-proxy", new HttpHost(aea, com.baidu.adp.lib.util.i.jk()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.adW = e.getInstance().httpGetFactory(str, this.aef, false);
                                    } else {
                                        this.adW = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.adW = new HttpGet(str);
                                }
                                if (adU != null) {
                                    this.adW.setHeader("Proxy-Authorization", adU);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.adW.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.jb()) {
                            if (!this.aee || this.adW == null) {
                                this.adW = e.getInstance().httpGetFactory(str, this.aef, false);
                            }
                        } else {
                            this.adW = e.getInstance().httpGetFactory(str, this.aef, true);
                        }
                    } else {
                        this.adW = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.adW = new HttpGet(str);
                }
                this.adW.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void dE(String str) {
        l(str, null, null);
    }

    private boolean dF(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [631=13, 632=13, 636=13, 637=13, 638=13, 639=13, 640=13, 641=13, 642=26, 644=13, 645=13, 646=13, 647=13, 650=13, 651=26, 652=13, 653=13, 654=26, 655=13, 656=13, 657=13, 658=13, 660=26, 661=13] */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x096c, code lost:
        r12.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:645:0x0c38  */
    /* JADX WARN: Removed duplicated region for block: B:657:0x0c56  */
    /* JADX WARN: Removed duplicated region for block: B:665:0x0c79  */
    /* JADX WARN: Removed duplicated region for block: B:739:0x0c18 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.d dVar;
        String c;
        InputStream inputStream;
        Throwable th;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean ja;
        boolean z6;
        boolean z7;
        long currentTimeMillis2;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        String value;
        String value2;
        int read;
        String obj;
        boolean z13;
        boolean z14;
        byte[] bArr = null;
        boolean z15 = false;
        if (e.getInstance() != null) {
            z15 = true;
            if (!e.getInstance().adS) {
                e.getInstance().init();
            }
        }
        boolean z16 = z15;
        if (i <= 0) {
            i = 5;
        }
        boolean z17 = false;
        int i2 = 0;
        while (true) {
            if (this.adY || i2 >= i) {
                break;
            }
            this.aef = i2;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.adZ.a(dVar);
            dVar.vk = -1;
            InputStream inputStream2 = null;
            c = this.adZ.ha().c(dVar);
            try {
                dVar.vk = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    dE(c);
                    if (z16) {
                        dVar.vl = e.getInstance().getCachedCdnIp(this.aef);
                    }
                } else {
                    l(c, str, str2);
                    dVar.vl = str;
                }
                dVar.vk = -3;
            } catch (HttpException e) {
                e = e;
                inputStream = null;
            } catch (SocketException e2) {
                e = e2;
            } catch (SocketTimeoutException e3) {
                e = e3;
                inputStream = null;
            } catch (IOException e4) {
                e = e4;
                inputStream = null;
            } catch (IllegalStateException e5) {
                e = e5;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            if (this.adW == null) {
                throw new SocketException("network not available.");
            }
            if (this.adY) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                wC();
                this.adZ.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean ja2 = com.baidu.adp.lib.util.i.ja();
                    if ((ja2 ? dVar.vl != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.ga(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (ja2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().SB);
                        } else if (com.baidu.adp.lib.util.i.je()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().SD);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().SC);
                        }
                        e.getInstance().result(c, dVar.vl, z17, z8, ja2);
                    }
                }
            } else {
                dVar.vk = -8;
                HttpResponse execute = aeb.execute(this.adW);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.adZ.hb().responseCode = execute.getStatusLine().getStatusCode();
                dVar.vj = this.adZ.hb().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                if (inputStream == null) {
                    throw new IOException("get content is null.");
                }
                try {
                    try {
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (HttpException e7) {
                    e = e7;
                } catch (IOException e8) {
                    e = e8;
                } catch (IllegalStateException e9) {
                    e = e9;
                } catch (SocketException e10) {
                    e = e10;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e11) {
                    e = e11;
                } catch (Throwable th4) {
                    th = th4;
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.adZ.hb().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.adX < 1) {
                            wC();
                            this.adX++;
                            this.adZ.hb().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            wC();
                            this.adZ.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean ja3 = com.baidu.adp.lib.util.i.ja();
                                if ((ja3 ? dVar.vl != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.ga(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (ja3) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().SB);
                                    } else if (com.baidu.adp.lib.util.i.je()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().SC);
                                    }
                                    e.getInstance().result(c, dVar.vl, z17, z14, ja3);
                                }
                            }
                            i2++;
                            bArr = bArr;
                        } else {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e13) {
                                }
                            }
                            wC();
                            this.adZ.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean ja4 = com.baidu.adp.lib.util.i.ja();
                                if ((ja4 ? dVar.vl != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.ga(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (ja4) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().SB);
                                    } else if (com.baidu.adp.lib.util.i.je()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().SC);
                                    }
                                    e.getInstance().result(c, dVar.vl, z17, z13, ja4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > abO) {
                    this.adZ.hb().vv = -11;
                    dVar.vi = this.mContext.getResources().getString(t.j.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    wC();
                    this.adZ.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean ja5 = com.baidu.adp.lib.util.i.ja();
                        if ((ja5 ? dVar.vl != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.ga(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (ja5) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().SB);
                            } else if (com.baidu.adp.lib.util.i.je()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().SD);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().SC);
                            }
                            e.getInstance().result(c, dVar.vl, z17, z9, ja5);
                            return;
                        }
                        return;
                    }
                    return;
                }
                byte[] bArr2 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                int i3 = 0;
                boolean z18 = false;
                if (execute.getFirstHeader("imgsrc") != null && (obj = execute.getFirstHeader("imgsrc").toString()) != null && obj.length() > 0) {
                    z18 = true;
                }
                if (z18) {
                    byte[] bArr3 = new byte[23];
                    int read2 = inputStream.read(bArr3, 0, 23);
                    if (!new String(bArr3, 0, bArr3.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                        byteArrayOutputStream.write(bArr3, 0, read2);
                        i3 = 0 + read2;
                    }
                }
                if (execute.getFirstHeader("Src-Content-Type") != null) {
                    if ("image/gif".equalsIgnoreCase(execute.getFirstHeader("Src-Content-Type").getValue())) {
                        this.rR = true;
                    } else {
                        this.rR = false;
                    }
                }
                while (!this.adY && i3 < abO && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                dVar.vk = -9;
                if (this.adY) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e15) {
                        }
                    }
                    wC();
                    this.adZ.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean ja6 = com.baidu.adp.lib.util.i.ja();
                        if ((ja6 ? dVar.vl != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.ga(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (ja6) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().SB);
                            } else if (com.baidu.adp.lib.util.i.je()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().SD);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().SC);
                            }
                            e.getInstance().result(c, dVar.vl, z17, z10, ja6);
                        }
                    }
                } else {
                    if (i3 < abO) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value2 = entity.getContentEncoding().getValue()) != null && value2.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.adZ.hb().vv = -11;
                        dVar.vi = this.mContext.getResources().getString(t.j.data_too_big);
                    }
                    dVar.vc = i3;
                    dVar.vf = i2 + 1;
                    dVar.ve = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.aed = false;
                        } else {
                            this.aed = true;
                        }
                    }
                    z11 = (i3 <= 0 || !(this.adZ.hb().responseCode == 200 || this.adZ.hb().responseCode == 302)) ? z17 : true;
                    try {
                        if (com.baidu.adp.b.a.mo() != null && dVar != null) {
                            com.baidu.adp.b.a.mo().a(TbConfig.TMP_PIC_DIR_NAME, dVar.vb, dVar.vc);
                        }
                        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                            dG(value);
                            break;
                        }
                        break;
                    } catch (SocketException e16) {
                        e = e16;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.adZ.hb().vv = -12;
                            dVar.vi = "errorCode:" + String.valueOf(this.adZ.hb().vv) + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e17) {
                                }
                            }
                            wC();
                            this.adZ.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean ja7 = com.baidu.adp.lib.util.i.ja();
                                if ((ja7 ? dVar.vl != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.ga(c) && z16) {
                                    long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                    if (ja7) {
                                        z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().SB);
                                    } else if (com.baidu.adp.lib.util.i.je()) {
                                        z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                    } else {
                                        z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().SC);
                                    }
                                    e.getInstance().result(c, dVar.vl, z17, z7, ja7);
                                }
                            }
                            i2++;
                            bArr = bArr;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e18) {
                                }
                            }
                            wC();
                            this.adZ.b(dVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                ja = com.baidu.adp.lib.util.i.ja();
                                if ((ja ? dVar.vl != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.ga(c) && z16) {
                                    long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!ja) {
                                        z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().SB);
                                    } else if (com.baidu.adp.lib.util.i.je()) {
                                        z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                    } else {
                                        z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().SC);
                                    }
                                    e.getInstance().result(c, dVar.vl, z17, z6, ja);
                                }
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e19) {
                        e = e19;
                        z17 = z11;
                        this.adZ.hb().vv = -13;
                        dVar.vi = "errorCode:" + String.valueOf(this.adZ.hb().vv) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e20) {
                            }
                        }
                        wC();
                        this.adZ.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean ja8 = com.baidu.adp.lib.util.i.ja();
                            if ((ja8 ? dVar.vl != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.ga(c) && z16) {
                                long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                if (ja8) {
                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().SB);
                                } else if (com.baidu.adp.lib.util.i.je()) {
                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                } else {
                                    z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().SC);
                                }
                                e.getInstance().result(c, dVar.vl, z17, z5, ja8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IOException e21) {
                        e = e21;
                        z17 = z11;
                        this.adZ.hb().vv = -19;
                        dVar.vi = "errorCode:" + String.valueOf(this.adZ.hb().vv) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e22) {
                            }
                        }
                        wC();
                        this.adZ.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean ja9 = com.baidu.adp.lib.util.i.ja();
                            if ((ja9 ? dVar.vl != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.ga(c) && z16) {
                                long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                if (ja9) {
                                    z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().SB);
                                } else if (com.baidu.adp.lib.util.i.je()) {
                                    z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                } else {
                                    z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().SC);
                                }
                                e.getInstance().result(c, dVar.vl, z17, z4, ja9);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IllegalStateException e23) {
                        e = e23;
                        z17 = z11;
                        this.adZ.hb().vv = -19;
                        dVar.vi = "errorCode:" + String.valueOf(this.adZ.hb().vv) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        wC();
                        this.adZ.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean ja10 = com.baidu.adp.lib.util.i.ja();
                            if ((ja10 ? dVar.vl != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.ga(c) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (ja10) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().SB);
                                } else if (com.baidu.adp.lib.util.i.je()) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                } else {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().SC);
                                }
                                e.getInstance().result(c, dVar.vl, z17, z3, ja10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (HttpException e25) {
                        e = e25;
                        z17 = z11;
                        this.adZ.hb().vv = -18;
                        dVar.vi = "errorCode:" + String.valueOf(this.adZ.hb().vv) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                            }
                        }
                        wC();
                        this.adZ.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean ja11 = com.baidu.adp.lib.util.i.ja();
                            if ((ja11 ? dVar.vl != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.ga(c) && z16) {
                                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                if (ja11) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().SB);
                                } else if (com.baidu.adp.lib.util.i.je()) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                } else {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().SC);
                                }
                                e.getInstance().result(c, dVar.vl, z17, z2, ja11);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z17 = z11;
                        if (inputStream != null) {
                        }
                        wC();
                        this.adZ.b(dVar);
                        if (str != null) {
                        }
                        ja = com.baidu.adp.lib.util.i.ja();
                        if (ja ? dVar.vl != null || z17 || i2 >= i + (-1) : true) {
                            long currentTimeMillis92 = System.currentTimeMillis() - currentTimeMillis;
                            if (!ja) {
                            }
                            e.getInstance().result(c, dVar.vl, z17, z6, ja);
                        }
                        throw th;
                    }
                }
            }
        }
        this.adX = 0;
        this.adZ.hb().vx = bArr;
        wC();
        this.adZ.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean ja12 = com.baidu.adp.lib.util.i.ja();
            if ((ja12 ? dVar.vl != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.ga(c) && z16) {
                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                if (ja12) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().SB);
                } else if (com.baidu.adp.lib.util.i.je()) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().SD);
                } else {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().SC);
                }
                e.getInstance().result(c, dVar.vl, z11, z12, ja12);
            }
        }
        this.adX = 0;
        this.adZ.hb().vx = bArr;
    }

    private void dG(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(aeg) && (System.currentTimeMillis() - aei) - (1800000 * (aeh / 3)) >= 0) {
            aeh++;
            try {
                char[] charArray = TbadkCoreApplication.m411getInst().getCuid().toCharArray();
                StringBuilder sb = new StringBuilder();
                sb.append("http://");
                sb.append(str);
                int i = 0;
                while (i < charArray.length && i < 32) {
                    if (Character.isLetterOrDigit(charArray[i])) {
                        sb.append(charArray[i]);
                        i++;
                    }
                }
                sb.append(".tieba.galileo.baiduyundns.com");
                URL url = new URL(sb.toString());
                aeg = str;
                new Thread(new h(this, url)).start();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wD() {
        e(null, null, -1);
    }

    public boolean fN() {
        return this.rR;
    }

    public boolean wE() {
        return this.aed;
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0005a
    public void cancel() {
        gT();
    }
}
