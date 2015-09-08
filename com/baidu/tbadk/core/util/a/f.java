package com.baidu.tbadk.core.util.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import com.baidu.adp.lib.f.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
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
public class f implements a.InterfaceC0004a {
    private static int aac;
    public static String acb;
    private static HttpClient acc;
    private static Header ace;
    private static String acf;
    private HttpGet abX;
    private final com.baidu.adp.lib.network.http.e aca;
    public boolean ach;
    private final Context mContext;
    private static volatile String abV = null;
    private static volatile boolean abW = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams acd = new BasicHttpParams();
    private boolean rG = false;
    private boolean acg = false;
    private int aci = 0;
    private int abY = 0;
    private volatile boolean abZ = false;

    static {
        aac = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(acd, 5000);
        HttpConnectionParams.setSoTimeout(acd, 30000);
        HttpConnectionParams.setSocketBufferSize(acd, 1024);
        HttpConnectionParams.setTcpNoDelay(acd, true);
        HttpClientParams.setRedirecting(acd, true);
        ConnManagerParams.setMaxConnectionsPerRoute(acd, new ConnPerRouteBean(10));
        ConnManagerParams.setTimeout(acd, 10000L);
        ConnManagerParams.setMaxTotalConnections(acd, 10);
        HttpProtocolParams.setUserAgent(acd, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        acc = new DefaultHttpClient(new ThreadSafeClientConnManager(acd, schemeRegistry), acd);
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            aac = 4194304;
        }
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        ve();
        this.aca = eVar;
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
    }

    public static void ve() {
        synchronized (f.class) {
            if (!abW) {
                abW = true;
                vf();
            }
        }
    }

    public static synchronized void vf() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m411getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    abV = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void gJ() {
        this.abZ = true;
        this.aca.gQ().vc = true;
        vg();
    }

    private void vg() {
        try {
            if (this.abX != null) {
                this.abX.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().abT) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.iL()) {
            this.ach = false;
            try {
                if (com.baidu.adp.lib.util.i.iN()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (acb == null) {
                            acb = com.baidu.adp.lib.util.i.iV();
                        }
                        if (acb != null && acb.length() > 0) {
                            this.ach = true;
                            if (dp(acb) && com.baidu.adp.lib.util.i.iX()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(acb);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.abX = e.getInstance().httpGetFactory(sb.toString(), this.aci, false);
                                    } else {
                                        this.abX = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.abX = new HttpGet(sb.toString());
                                }
                                this.abX.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.abX.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = acd.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    acd.setParameter("http.route.default-proxy", new HttpHost(acb, com.baidu.adp.lib.util.i.iW()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(acb) || httpHost.getPort() != com.baidu.adp.lib.util.i.iW()) {
                                        acd.setParameter("http.route.default-proxy", new HttpHost(acb, com.baidu.adp.lib.util.i.iW()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.abX = e.getInstance().httpGetFactory(str, this.aci, false);
                                    } else {
                                        this.abX = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.abX = new HttpGet(str);
                                }
                                if (abV != null) {
                                    this.abX.setHeader("Proxy-Authorization", abV);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.abX.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.iN()) {
                            if (!this.ach || this.abX == null) {
                                this.abX = e.getInstance().httpGetFactory(str, this.aci, false);
                                return;
                            }
                            return;
                        }
                        this.abX = e.getInstance().httpGetFactory(str, this.aci, true);
                        return;
                    }
                    this.abX = e.getInstance().httpGetFactory(str, str2, str3);
                    return;
                }
                this.abX = new HttpGet(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void dn(String str) {
        l(str, null, null);
    }

    private boolean dp(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [611=12, 612=12, 616=12, 618=12, 619=12, 620=12, 621=12, 622=24, 624=12, 625=12, 626=12, 627=12, 630=12, 631=24, 632=12, 633=12, 634=24, 635=12, 636=12, 637=12, 638=12, 640=24, 641=12] */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x08ea, code lost:
        if (r12 == null) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:461:0x08ec, code lost:
        r12.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:588:0x0aca  */
    /* JADX WARN: Removed duplicated region for block: B:600:0x0ae8  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x0b0b  */
    /* JADX WARN: Removed duplicated region for block: B:669:0x0ab3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.d dVar;
        String b;
        Throwable th;
        InputStream inputStream;
        boolean z;
        boolean iM;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        long currentTimeMillis2;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        String value;
        int read;
        String obj;
        boolean z12;
        boolean z13;
        byte[] bArr = null;
        boolean z14 = false;
        if (e.getInstance() != null) {
            z14 = true;
            if (!e.getInstance().abT) {
                e.getInstance().init();
            }
        }
        boolean z15 = z14;
        if (i <= 0) {
            i = 5;
        }
        boolean z16 = false;
        int i2 = 0;
        while (true) {
            if (this.abZ || i2 >= i) {
                break;
            }
            this.aci = i2;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.aca.a(dVar);
            dVar.uT = -1;
            InputStream inputStream2 = null;
            b = this.aca.gP().b(dVar);
            try {
                dVar.uT = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    dn(b);
                    if (z15) {
                        dVar.uU = e.getInstance().getCachedCdnIp(this.aci);
                    }
                } else {
                    l(b, str, str2);
                    dVar.uU = str;
                }
                dVar.uT = -3;
            } catch (SocketException e) {
                e = e;
            } catch (SocketTimeoutException e2) {
                e = e2;
                inputStream = null;
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
            } catch (HttpException e4) {
                e = e4;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            if (this.abX == null) {
                throw new SocketException("network not available.");
            }
            if (this.abZ) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e5) {
                    }
                }
                vg();
                if ((str == null || str.length() == 0) && b != null) {
                    boolean iM2 = com.baidu.adp.lib.util.i.iM();
                    if ((iM2 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fE(b) && z15) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (iM2) {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().SD);
                        } else if (com.baidu.adp.lib.util.i.iQ()) {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().SF);
                        } else {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().SE);
                        }
                        e.getInstance().result(b, dVar.uU, z16, z7, iM2);
                    }
                }
            } else {
                ace = this.abX.getFirstHeader("Host");
                if (ace != null) {
                    acf = ace.getValue();
                }
                dVar.uT = -8;
                HttpResponse execute = acc.execute(this.abX);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.aca.gQ().responseCode = execute.getStatusLine().getStatusCode();
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (HttpException e6) {
                    e = e6;
                } catch (SocketException e7) {
                    e = e7;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e8) {
                    e = e8;
                } catch (IOException e9) {
                    e = e9;
                } catch (Throwable th4) {
                    th = th4;
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.aca.gQ().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.abY < 1) {
                            vg();
                            this.abY++;
                            this.aca.gQ().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e10) {
                                }
                            }
                            vg();
                            if ((str == null || str.length() == 0) && b != null) {
                                boolean iM3 = com.baidu.adp.lib.util.i.iM();
                                if ((iM3 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fE(b) && z15) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iM3) {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                    } else if (com.baidu.adp.lib.util.i.iQ()) {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().SF);
                                    } else {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().SE);
                                    }
                                    e.getInstance().result(b, dVar.uU, z16, z13, iM3);
                                }
                            }
                            i2++;
                            bArr = bArr;
                        } else {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e11) {
                                }
                            }
                            vg();
                            if ((str == null || str.length() == 0) && b != null) {
                                boolean iM4 = com.baidu.adp.lib.util.i.iM();
                                if ((iM4 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fE(b) && z15) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iM4) {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                    } else if (com.baidu.adp.lib.util.i.iQ()) {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().SF);
                                    } else {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().SE);
                                    }
                                    e.getInstance().result(b, dVar.uU, z16, z12, iM4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > aac) {
                    this.aca.gQ().responseCode = -11;
                    dVar.uR = this.mContext.getResources().getString(i.h.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e12) {
                        }
                    }
                    vg();
                    if ((str == null || str.length() == 0) && b != null) {
                        boolean iM5 = com.baidu.adp.lib.util.i.iM();
                        if ((iM5 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fE(b) && z15) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (iM5) {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().SD);
                            } else if (com.baidu.adp.lib.util.i.iQ()) {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().SF);
                            } else {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().SE);
                            }
                            e.getInstance().result(b, dVar.uU, z16, z8, iM5);
                            return;
                        }
                        return;
                    }
                    return;
                }
                byte[] bArr2 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                int i3 = 0;
                boolean z17 = false;
                if (execute.getFirstHeader("imgsrc") != null && (obj = execute.getFirstHeader("imgsrc").toString()) != null && obj.length() > 0) {
                    z17 = true;
                }
                if (z17) {
                    byte[] bArr3 = new byte[23];
                    int read2 = inputStream.read(bArr3, 0, 23);
                    if (!new String(bArr3, 0, bArr3.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                        byteArrayOutputStream.write(bArr3, 0, read2);
                        i3 = 0 + read2;
                    }
                }
                if (execute.getFirstHeader("Src-Content-Type") != null) {
                    if ("image/gif".equalsIgnoreCase(execute.getFirstHeader("Src-Content-Type").getValue())) {
                        this.rG = true;
                    } else {
                        this.rG = false;
                    }
                }
                while (!this.abZ && i3 < aac && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                dVar.uT = -9;
                if (this.abZ) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e13) {
                        }
                    }
                    vg();
                    if ((str == null || str.length() == 0) && b != null) {
                        boolean iM6 = com.baidu.adp.lib.util.i.iM();
                        if ((iM6 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fE(b) && z15) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (iM6) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().SD);
                            } else if (com.baidu.adp.lib.util.i.iQ()) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().SF);
                            } else {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().SE);
                            }
                            e.getInstance().result(b, dVar.uU, z16, z9, iM6);
                        }
                    }
                } else {
                    if (i3 < aac) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value = entity.getContentEncoding().getValue()) != null && value.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.b(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.aca.gQ().responseCode = -11;
                        dVar.uR = this.mContext.getResources().getString(i.h.data_too_big);
                    }
                    dVar.uL = i3;
                    dVar.uO = i2 + 1;
                    dVar.uN = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.acg = false;
                        } else {
                            this.acg = true;
                        }
                    }
                    z10 = i3 > 0 ? true : z16;
                    try {
                        if (com.baidu.adp.b.a.mx() != null && dVar != null) {
                            com.baidu.adp.b.a.mx().b(TbConfig.TMP_PIC_DIR_NAME, dVar.uK, dVar.uL);
                            break;
                        }
                        break;
                    } catch (SocketTimeoutException e14) {
                        e = e14;
                        z16 = z10;
                        this.aca.gQ().responseCode = -13;
                        dVar.uR = String.valueOf(String.valueOf(this.aca.gQ().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e15) {
                            }
                        }
                        vg();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean iM7 = com.baidu.adp.lib.util.i.iM();
                            if ((iM7 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fE(b) && z15) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (iM7) {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                } else if (com.baidu.adp.lib.util.i.iQ()) {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().SF);
                                } else {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().SE);
                                }
                                e.getInstance().result(b, dVar.uU, z16, z6, iM7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IOException e16) {
                        e = e16;
                        z16 = z10;
                        this.aca.gQ().responseCode = -19;
                        dVar.uR = String.valueOf(String.valueOf(this.aca.gQ().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        vg();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean iM8 = com.baidu.adp.lib.util.i.iM();
                            if ((iM8 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fE(b) && z15) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (iM8) {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                } else if (com.baidu.adp.lib.util.i.iQ()) {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().SF);
                                } else {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().SE);
                                }
                                e.getInstance().result(b, dVar.uU, z16, z5, iM8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (HttpException e18) {
                        e = e18;
                        z16 = z10;
                        this.aca.gQ().responseCode = -18;
                        dVar.uR = String.valueOf(String.valueOf(this.aca.gQ().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e19) {
                            }
                        }
                        vg();
                        if ((str == null || str.length() == 0) && b != null) {
                            boolean iM9 = com.baidu.adp.lib.util.i.iM();
                            if ((iM9 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fE(b) && z15) {
                                long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                if (iM9) {
                                    z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                } else if (com.baidu.adp.lib.util.i.iQ()) {
                                    z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().SF);
                                } else {
                                    z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().SE);
                                }
                                e.getInstance().result(b, dVar.uU, z16, z4, iM9);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e20) {
                        e = e20;
                        inputStream2 = inputStream;
                        z16 = z10;
                        try {
                            this.aca.gQ().responseCode = -12;
                            dVar.uR = String.valueOf(String.valueOf(this.aca.gQ().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e21) {
                                }
                            }
                            vg();
                            if ((str == null || str.length() == 0) && b != null) {
                                boolean iM10 = com.baidu.adp.lib.util.i.iM();
                                if ((iM10 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fE(b) && z15) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iM10) {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                    } else if (com.baidu.adp.lib.util.i.iQ()) {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().SF);
                                    } else {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().SE);
                                    }
                                    e.getInstance().result(b, dVar.uU, z16, z3, iM10);
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
                                } catch (Exception e22) {
                                }
                            }
                            vg();
                            if ((str != null || str.length() == 0) && b != null) {
                                iM = com.baidu.adp.lib.util.i.iM();
                                if ((iM ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fE(b) && z15) {
                                    long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!iM) {
                                        z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().SD);
                                    } else if (com.baidu.adp.lib.util.i.iQ()) {
                                        z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().SF);
                                    } else {
                                        z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().SE);
                                    }
                                    e.getInstance().result(b, dVar.uU, z16, z2, iM);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        z16 = z10;
                        if (inputStream != null) {
                        }
                        vg();
                        if (str != null) {
                        }
                        iM = com.baidu.adp.lib.util.i.iM();
                        if (iM ? dVar.uU != null || z16 || i2 >= i + (-1) : true) {
                            long currentTimeMillis122 = System.currentTimeMillis() - currentTimeMillis;
                            if (!iM) {
                            }
                            e.getInstance().result(b, dVar.uU, z16, z2, iM);
                        }
                        throw th;
                    }
                }
            }
        }
        this.abY = 0;
        this.aca.gQ().ve = bArr;
        vg();
        if ((str == null || str.length() == 0) && b != null) {
            boolean iM11 = com.baidu.adp.lib.util.i.iM();
            if ((iM11 ? dVar.uU != null || z10 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.d.fE(b) && z15) {
                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                if (iM11) {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().SD);
                } else if (com.baidu.adp.lib.util.i.iQ()) {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().SF);
                } else {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().SE);
                }
                e.getInstance().result(b, dVar.uU, z10, z11, iM11);
            }
        }
        this.abY = 0;
        this.aca.gQ().ve = bArr;
    }

    public void vh() {
        e(null, null, -1);
    }

    public boolean fF() {
        return this.rG;
    }

    public boolean vi() {
        return this.acg;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0004a
    public void cancel() {
        gJ();
    }

    public String vj() {
        return acf;
    }

    public void dq(String str) {
        acf = str;
    }
}
