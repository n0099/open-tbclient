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
    public static String aci;
    private static HttpClient acj;
    private HttpGet ace;
    private final com.baidu.adp.lib.network.http.e ach;
    public boolean acm;
    private final Context mContext;
    private static volatile String acc = null;
    private static volatile boolean acd = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams ack = new BasicHttpParams();
    private boolean rG = false;
    private boolean acl = false;
    private int acn = 0;
    private int acf = 0;
    private volatile boolean acg = false;

    static {
        aac = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(ack, 5000);
        HttpConnectionParams.setSoTimeout(ack, 30000);
        HttpConnectionParams.setSocketBufferSize(ack, 1024);
        HttpConnectionParams.setTcpNoDelay(ack, true);
        HttpClientParams.setRedirecting(ack, true);
        ConnManagerParams.setMaxConnectionsPerRoute(ack, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(ack, 10000L);
        ConnManagerParams.setMaxTotalConnections(ack, 15);
        HttpProtocolParams.setUserAgent(ack, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        acj = new DefaultHttpClient(new ThreadSafeClientConnManager(ack, schemeRegistry), ack);
        acj.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            aac = 4194304;
        }
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        ve();
        this.ach = eVar;
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
    }

    public static void ve() {
        synchronized (f.class) {
            if (!acd) {
                acd = true;
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
                    acc = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void gJ() {
        this.acg = true;
        this.ach.gR().vd = true;
        vg();
    }

    private void vg() {
        try {
            if (this.ace != null) {
                this.ace.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void k(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().aca) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.iN()) {
            this.acm = false;
            try {
                if (com.baidu.adp.lib.util.i.iP()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (aci == null) {
                            aci = com.baidu.adp.lib.util.i.iX();
                        }
                        if (aci != null && aci.length() > 0) {
                            this.acm = true;
                            if (du(aci) && com.baidu.adp.lib.util.i.iZ()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(aci);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ace = e.getInstance().httpGetFactory(sb.toString(), this.acn, false);
                                    } else {
                                        this.ace = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ace = new HttpGet(sb.toString());
                                }
                                this.ace.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ace.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = ack.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    ack.setParameter("http.route.default-proxy", new HttpHost(aci, com.baidu.adp.lib.util.i.iY()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(aci) || httpHost.getPort() != com.baidu.adp.lib.util.i.iY()) {
                                        ack.setParameter("http.route.default-proxy", new HttpHost(aci, com.baidu.adp.lib.util.i.iY()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ace = e.getInstance().httpGetFactory(str, this.acn, false);
                                    } else {
                                        this.ace = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ace = new HttpGet(str);
                                }
                                if (acc != null) {
                                    this.ace.setHeader("Proxy-Authorization", acc);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ace.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.iP()) {
                            if (!this.acm || this.ace == null) {
                                this.ace = e.getInstance().httpGetFactory(str, this.acn, false);
                                return;
                            }
                            return;
                        }
                        this.ace = e.getInstance().httpGetFactory(str, this.acn, true);
                        return;
                    }
                    this.ace = e.getInstance().httpGetFactory(str, str2, str3);
                    return;
                }
                this.ace = new HttpGet(str);
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
        boolean iO;
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
            if (!e.getInstance().aca) {
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
            if (this.acg || i2 >= i) {
                break;
            }
            this.acn = i2;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.ach.a(dVar);
            dVar.uT = -1;
            InputStream inputStream2 = null;
            c = this.ach.gQ().c(dVar);
            try {
                dVar.uT = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    dt(c);
                    if (z15) {
                        dVar.uU = e.getInstance().getCachedCdnIp(this.acn);
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
            if (this.ace == null) {
                throw new SocketException("network not available.");
            }
            if (this.acg) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e5) {
                    }
                }
                vg();
                this.ach.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean iO2 = com.baidu.adp.lib.util.i.iO();
                    if ((iO2 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fL(c) && z15) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (iO2) {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                        } else if (com.baidu.adp.lib.util.i.iS()) {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().St);
                        } else {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                        }
                        e.getInstance().result(c, dVar.uU, z16, z7, iO2);
                    }
                }
            } else {
                dVar.uT = -8;
                HttpResponse execute = acj.execute(this.ace);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.ach.gR().responseCode = execute.getStatusLine().getStatusCode();
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
                    this.ach.gR().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.acf < 1) {
                            vg();
                            this.acf++;
                            this.ach.gR().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e10) {
                                }
                            }
                            vg();
                            this.ach.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean iO3 = com.baidu.adp.lib.util.i.iO();
                                if ((iO3 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fL(c) && z15) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iO3) {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                    } else if (com.baidu.adp.lib.util.i.iS()) {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().St);
                                    } else {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                    }
                                    e.getInstance().result(c, dVar.uU, z16, z13, iO3);
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
                            this.ach.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean iO4 = com.baidu.adp.lib.util.i.iO();
                                if ((iO4 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fL(c) && z15) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iO4) {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                    } else if (com.baidu.adp.lib.util.i.iS()) {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().St);
                                    } else {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                    }
                                    e.getInstance().result(c, dVar.uU, z16, z12, iO4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > aac) {
                    this.ach.gR().responseCode = -11;
                    dVar.uR = this.mContext.getResources().getString(i.h.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e12) {
                        }
                    }
                    vg();
                    this.ach.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean iO5 = com.baidu.adp.lib.util.i.iO();
                        if ((iO5 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fL(c) && z15) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (iO5) {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                            } else if (com.baidu.adp.lib.util.i.iS()) {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().St);
                            } else {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                            }
                            e.getInstance().result(c, dVar.uU, z16, z8, iO5);
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
                while (!this.acg && i3 < aac && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                dVar.uT = -9;
                if (this.acg) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e13) {
                        }
                    }
                    vg();
                    this.ach.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean iO6 = com.baidu.adp.lib.util.i.iO();
                        if ((iO6 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fL(c) && z15) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (iO6) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                            } else if (com.baidu.adp.lib.util.i.iS()) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().St);
                            } else {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                            }
                            e.getInstance().result(c, dVar.uU, z16, z9, iO6);
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
                        this.ach.gR().responseCode = -11;
                        dVar.uR = this.mContext.getResources().getString(i.h.data_too_big);
                    }
                    dVar.uL = i3;
                    dVar.uO = i2 + 1;
                    dVar.uN = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.acl = false;
                        } else {
                            this.acl = true;
                        }
                    }
                    z10 = (i3 <= 0 || !(this.ach.gR().responseCode == 200 || this.ach.gR().responseCode == 302)) ? z16 : true;
                    try {
                        if (com.baidu.adp.b.a.mz() != null && dVar != null) {
                            com.baidu.adp.b.a.mz().b(TbConfig.TMP_PIC_DIR_NAME, dVar.uK, dVar.uL);
                            break;
                        }
                        break;
                    } catch (SocketTimeoutException e14) {
                        e = e14;
                        z16 = z10;
                        this.ach.gR().responseCode = -13;
                        dVar.uR = String.valueOf(String.valueOf(this.ach.gR().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e15) {
                            }
                        }
                        vg();
                        this.ach.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean iO7 = com.baidu.adp.lib.util.i.iO();
                            if ((iO7 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fL(c) && z15) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (iO7) {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                } else if (com.baidu.adp.lib.util.i.iS()) {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().St);
                                } else {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                }
                                e.getInstance().result(c, dVar.uU, z16, z6, iO7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (HttpException e16) {
                        e = e16;
                        z16 = z10;
                        this.ach.gR().responseCode = -18;
                        dVar.uR = String.valueOf(String.valueOf(this.ach.gR().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        vg();
                        this.ach.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean iO8 = com.baidu.adp.lib.util.i.iO();
                            if ((iO8 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fL(c) && z15) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (iO8) {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                } else if (com.baidu.adp.lib.util.i.iS()) {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().St);
                                } else {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                }
                                e.getInstance().result(c, dVar.uU, z16, z5, iO8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e18) {
                        e = e18;
                        inputStream2 = inputStream;
                        z16 = z10;
                        try {
                            this.ach.gR().responseCode = -12;
                            dVar.uR = String.valueOf(String.valueOf(this.ach.gR().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e19) {
                                }
                            }
                            vg();
                            this.ach.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean iO9 = com.baidu.adp.lib.util.i.iO();
                                if ((iO9 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fL(c) && z15) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iO9) {
                                        z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                    } else if (com.baidu.adp.lib.util.i.iS()) {
                                        z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().St);
                                    } else {
                                        z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                    }
                                    e.getInstance().result(c, dVar.uU, z16, z4, iO9);
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
                            vg();
                            this.ach.b(dVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                iO = com.baidu.adp.lib.util.i.iO();
                                if ((iO ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fL(c) && z15) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!iO) {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                    } else if (com.baidu.adp.lib.util.i.iS()) {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().St);
                                    } else {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                    }
                                    e.getInstance().result(c, dVar.uU, z16, z3, iO);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e21) {
                        e = e21;
                        z16 = z10;
                        this.ach.gR().responseCode = -19;
                        dVar.uR = String.valueOf(String.valueOf(this.ach.gR().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e22) {
                            }
                        }
                        vg();
                        this.ach.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean iO10 = com.baidu.adp.lib.util.i.iO();
                            if ((iO10 ? dVar.uU != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fL(c) && z15) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (iO10) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                                } else if (com.baidu.adp.lib.util.i.iS()) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().St);
                                } else {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                                }
                                e.getInstance().result(c, dVar.uU, z16, z2, iO10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z16 = z10;
                        if (inputStream != null) {
                        }
                        vg();
                        this.ach.b(dVar);
                        if (str != null) {
                        }
                        iO = com.baidu.adp.lib.util.i.iO();
                        if (iO ? dVar.uU != null || z16 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!iO) {
                            }
                            e.getInstance().result(c, dVar.uU, z16, z3, iO);
                        }
                        throw th;
                    }
                }
            }
        }
        this.acf = 0;
        this.ach.gR().vf = bArr;
        vg();
        this.ach.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean iO11 = com.baidu.adp.lib.util.i.iO();
            if ((iO11 ? dVar.uU != null || z10 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fL(c) && z15) {
                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                if (iO11) {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Sr);
                } else if (com.baidu.adp.lib.util.i.iS()) {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().St);
                } else {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().Ss);
                }
                e.getInstance().result(c, dVar.uU, z10, z11, iO11);
            }
        }
        this.acf = 0;
        this.ach.gR().vf = bArr;
    }

    public void vh() {
        e(null, null, -1);
    }

    public boolean fF() {
        return this.rG;
    }

    public boolean vi() {
        return this.acl;
    }

    @Override // com.baidu.adp.lib.f.a.InterfaceC0004a
    public void cancel() {
        gJ();
    }
}
