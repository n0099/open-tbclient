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
    private static int ZY;
    public static String acd;
    private static HttpClient ace;
    private HttpGet abZ;
    private final com.baidu.adp.lib.network.http.e acc;
    public boolean ach;
    private final Context mContext;
    private static volatile String abX = null;
    private static volatile boolean abY = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams acf = new BasicHttpParams();
    private boolean rG = false;
    private boolean acg = false;
    private int aci = 0;
    private int aca = 0;
    private volatile boolean acb = false;

    static {
        ZY = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(acf, 5000);
        HttpConnectionParams.setSoTimeout(acf, 30000);
        HttpConnectionParams.setSocketBufferSize(acf, 1024);
        HttpConnectionParams.setTcpNoDelay(acf, true);
        HttpClientParams.setRedirecting(acf, true);
        ConnManagerParams.setMaxConnectionsPerRoute(acf, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(acf, 10000L);
        ConnManagerParams.setMaxTotalConnections(acf, 15);
        HttpProtocolParams.setUserAgent(acf, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ace = new DefaultHttpClient(new ThreadSafeClientConnManager(acf, schemeRegistry), acf);
        ace.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            ZY = 4194304;
        }
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        vd();
        this.acc = eVar;
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
    }

    public static void vd() {
        synchronized (f.class) {
            if (!abY) {
                abY = true;
                ve();
            }
        }
    }

    public static synchronized void ve() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m411getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    abX = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void gJ() {
        this.acb = true;
        this.acc.gQ().vd = true;
        vf();
    }

    private void vf() {
        try {
            if (this.abZ != null) {
                this.abZ.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void k(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().abV) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.iM()) {
            this.ach = false;
            try {
                if (com.baidu.adp.lib.util.i.iO()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (acd == null) {
                            acd = com.baidu.adp.lib.util.i.iW();
                        }
                        if (acd != null && acd.length() > 0) {
                            this.ach = true;
                            if (du(acd) && com.baidu.adp.lib.util.i.iY()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(acd);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.abZ = e.getInstance().httpGetFactory(sb.toString(), this.aci, false);
                                    } else {
                                        this.abZ = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.abZ = new HttpGet(sb.toString());
                                }
                                this.abZ.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.abZ.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = acf.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    acf.setParameter("http.route.default-proxy", new HttpHost(acd, com.baidu.adp.lib.util.i.iX()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(acd) || httpHost.getPort() != com.baidu.adp.lib.util.i.iX()) {
                                        acf.setParameter("http.route.default-proxy", new HttpHost(acd, com.baidu.adp.lib.util.i.iX()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.abZ = e.getInstance().httpGetFactory(str, this.aci, false);
                                    } else {
                                        this.abZ = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.abZ = new HttpGet(str);
                                }
                                if (abX != null) {
                                    this.abZ.setHeader("Proxy-Authorization", abX);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.abZ.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.iO()) {
                            if (!this.ach || this.abZ == null) {
                                this.abZ = e.getInstance().httpGetFactory(str, this.aci, false);
                                return;
                            }
                            return;
                        }
                        this.abZ = e.getInstance().httpGetFactory(str, this.aci, true);
                        return;
                    }
                    this.abZ = e.getInstance().httpGetFactory(str, str2, str3);
                    return;
                }
                this.abZ = new HttpGet(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void dt(String str) {
        k(str, null, null);
    }

    private boolean du(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [617=12, 618=12, 622=12, 623=12, 624=12, 625=12, 626=12, 627=12, 628=24, 630=12, 631=12, 632=12, 633=12, 636=12, 637=24, 638=12, 639=12, 640=24, 641=12, 642=12, 643=12, 644=12, 646=24, 647=12] */
    /* JADX WARN: Code restructure failed: missing block: B:463:0x094a, code lost:
        if (r12 == null) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:464:0x094c, code lost:
        r12.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:591:0x0b3c  */
    /* JADX WARN: Removed duplicated region for block: B:603:0x0b5a  */
    /* JADX WARN: Removed duplicated region for block: B:611:0x0b7d  */
    /* JADX WARN: Removed duplicated region for block: B:679:0x0b1c A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        boolean iN;
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
            if (!e.getInstance().abV) {
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
            if (this.acb || i2 >= i) {
                break;
            }
            this.aci = i2;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.acc.a(dVar);
            dVar.uT = -1;
            InputStream inputStream2 = null;
            c = this.acc.gP().c(dVar);
            try {
                dVar.uT = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    dt(c);
                    if (z15) {
                        dVar.uU = e.getInstance().getCachedCdnIp(this.aci);
                    }
                } else {
                    k(c, str, str2);
                    dVar.uU = str;
                }
                dVar.uT = -3;
            } catch (SocketException e) {
                e = e;
            } catch (SocketTimeoutException e2) {
                e = e2;
                inputStream = null;
            } catch (HttpException e3) {
                e = e3;
                inputStream = null;
            } catch (IOException e4) {
                e = e4;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            if (this.abZ == null) {
                throw new SocketException("network not available.");
            }
            if (this.acb) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e5) {
                    }
                }
                vf();
                this.acc.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean iN2 = com.baidu.adp.lib.util.i.iN();
                    if ((iN2 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fJ(c) && z15) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (iN2) {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Sq);
                        } else if (com.baidu.adp.lib.util.i.iR()) {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                        } else {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                        }
                        e.getInstance().result(c, dVar.uU, z16, z7, iN2);
                    }
                }
            } else {
                dVar.uT = -8;
                HttpResponse execute = ace.execute(this.abZ);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.acc.gQ().responseCode = execute.getStatusLine().getStatusCode();
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
                    this.acc.gQ().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.aca < 1) {
                            vf();
                            this.aca++;
                            this.acc.gQ().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e10) {
                                }
                            }
                            vf();
                            this.acc.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean iN3 = com.baidu.adp.lib.util.i.iN();
                                if ((iN3 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fJ(c) && z15) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iN3) {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Sq);
                                    } else if (com.baidu.adp.lib.util.i.iR()) {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                    } else {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                    }
                                    e.getInstance().result(c, dVar.uU, z16, z13, iN3);
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
                            vf();
                            this.acc.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean iN4 = com.baidu.adp.lib.util.i.iN();
                                if ((iN4 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fJ(c) && z15) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iN4) {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Sq);
                                    } else if (com.baidu.adp.lib.util.i.iR()) {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                    } else {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                    }
                                    e.getInstance().result(c, dVar.uU, z16, z12, iN4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > ZY) {
                    this.acc.gQ().responseCode = -11;
                    dVar.uR = this.mContext.getResources().getString(i.h.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e12) {
                        }
                    }
                    vf();
                    this.acc.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean iN5 = com.baidu.adp.lib.util.i.iN();
                        if ((iN5 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fJ(c) && z15) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (iN5) {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Sq);
                            } else if (com.baidu.adp.lib.util.i.iR()) {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                            } else {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                            }
                            e.getInstance().result(c, dVar.uU, z16, z8, iN5);
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
                while (!this.acb && i3 < ZY && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                dVar.uT = -9;
                if (this.acb) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e13) {
                        }
                    }
                    vf();
                    this.acc.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean iN6 = com.baidu.adp.lib.util.i.iN();
                        if ((iN6 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fJ(c) && z15) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (iN6) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Sq);
                            } else if (com.baidu.adp.lib.util.i.iR()) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                            } else {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                            }
                            e.getInstance().result(c, dVar.uU, z16, z9, iN6);
                        }
                    }
                } else {
                    if (i3 < ZY) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value = entity.getContentEncoding().getValue()) != null && value.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.b(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.acc.gQ().responseCode = -11;
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
                    z10 = (i3 <= 0 || !(this.acc.gQ().responseCode == 200 || this.acc.gQ().responseCode == 302)) ? z16 : true;
                    try {
                        if (com.baidu.adp.b.a.my() != null && dVar != null) {
                            com.baidu.adp.b.a.my().b(TbConfig.TMP_PIC_DIR_NAME, dVar.uK, dVar.uL);
                            break;
                        }
                        break;
                    } catch (SocketTimeoutException e14) {
                        e = e14;
                        z16 = z10;
                        this.acc.gQ().responseCode = -13;
                        dVar.uR = String.valueOf(String.valueOf(this.acc.gQ().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e15) {
                            }
                        }
                        vf();
                        this.acc.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean iN7 = com.baidu.adp.lib.util.i.iN();
                            if ((iN7 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fJ(c) && z15) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (iN7) {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Sq);
                                } else if (com.baidu.adp.lib.util.i.iR()) {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                } else {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                }
                                e.getInstance().result(c, dVar.uU, z16, z6, iN7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (HttpException e16) {
                        e = e16;
                        z16 = z10;
                        this.acc.gQ().responseCode = -18;
                        dVar.uR = String.valueOf(String.valueOf(this.acc.gQ().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        vf();
                        this.acc.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean iN8 = com.baidu.adp.lib.util.i.iN();
                            if ((iN8 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fJ(c) && z15) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (iN8) {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Sq);
                                } else if (com.baidu.adp.lib.util.i.iR()) {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                } else {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                }
                                e.getInstance().result(c, dVar.uU, z16, z5, iN8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e18) {
                        e = e18;
                        inputStream2 = inputStream;
                        z16 = z10;
                        try {
                            this.acc.gQ().responseCode = -12;
                            dVar.uR = String.valueOf(String.valueOf(this.acc.gQ().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e19) {
                                }
                            }
                            vf();
                            this.acc.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean iN9 = com.baidu.adp.lib.util.i.iN();
                                if ((iN9 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fJ(c) && z15) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iN9) {
                                        z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Sq);
                                    } else if (com.baidu.adp.lib.util.i.iR()) {
                                        z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                    } else {
                                        z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                    }
                                    e.getInstance().result(c, dVar.uU, z16, z4, iN9);
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
                                } catch (Exception e20) {
                                }
                            }
                            vf();
                            this.acc.b(dVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                iN = com.baidu.adp.lib.util.i.iN();
                                if ((iN ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fJ(c) && z15) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!iN) {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Sq);
                                    } else if (com.baidu.adp.lib.util.i.iR()) {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                    } else {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                    }
                                    e.getInstance().result(c, dVar.uU, z16, z3, iN);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e21) {
                        e = e21;
                        z16 = z10;
                        this.acc.gQ().responseCode = -19;
                        dVar.uR = String.valueOf(String.valueOf(this.acc.gQ().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e22) {
                            }
                        }
                        vf();
                        this.acc.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean iN10 = com.baidu.adp.lib.util.i.iN();
                            if ((iN10 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fJ(c) && z15) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (iN10) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Sq);
                                } else if (com.baidu.adp.lib.util.i.iR()) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                } else {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                }
                                e.getInstance().result(c, dVar.uU, z16, z2, iN10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z16 = z10;
                        if (inputStream != null) {
                        }
                        vf();
                        this.acc.b(dVar);
                        if (str != null) {
                        }
                        iN = com.baidu.adp.lib.util.i.iN();
                        if (iN ? dVar.uU != null || z16 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!iN) {
                            }
                            e.getInstance().result(c, dVar.uU, z16, z3, iN);
                        }
                        throw th;
                    }
                }
            }
        }
        this.aca = 0;
        this.acc.gQ().vf = bArr;
        vf();
        this.acc.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean iN11 = com.baidu.adp.lib.util.i.iN();
            if ((iN11 ? dVar.uU != null || z10 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fJ(c) && z15) {
                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                if (iN11) {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Sq);
                } else if (com.baidu.adp.lib.util.i.iR()) {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                } else {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                }
                e.getInstance().result(c, dVar.uU, z10, z11, iN11);
            }
        }
        this.aca = 0;
        this.acc.gQ().vf = bArr;
    }

    public void vg() {
        e(null, null, -1);
    }

    public boolean fF() {
        return this.rG;
    }

    public boolean vh() {
        return this.acg;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0004a
    public void cancel() {
        gJ();
    }
}
