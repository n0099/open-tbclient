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
import com.baidu.tieba.n;
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
    private static int aaO;
    public static String ada;
    private static HttpClient adb;
    private HttpGet acW;
    private final com.baidu.adp.lib.network.http.e acZ;
    public boolean adf;
    private final Context mContext;
    private static volatile String acU = null;
    private static volatile boolean acV = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams adc = new BasicHttpParams();
    private boolean rI = false;
    private boolean ade = false;
    private int adg = 0;
    private int acX = 0;
    private volatile boolean acY = false;

    static {
        aaO = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(adc, 5000);
        HttpConnectionParams.setSoTimeout(adc, 30000);
        HttpConnectionParams.setSocketBufferSize(adc, 1024);
        HttpConnectionParams.setTcpNoDelay(adc, true);
        HttpClientParams.setRedirecting(adc, true);
        ConnManagerParams.setMaxConnectionsPerRoute(adc, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(adc, 10000L);
        ConnManagerParams.setMaxTotalConnections(adc, 15);
        HttpProtocolParams.setUserAgent(adc, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        adb = new DefaultHttpClient(new ThreadSafeClientConnManager(adc, schemeRegistry), adc);
        adb.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            aaO = 4194304;
        }
    }

    public f(com.baidu.adp.lib.network.http.e eVar) {
        vK();
        this.acZ = eVar;
        this.mContext = TbadkCoreApplication.m411getInst().getApp();
    }

    public static void vK() {
        synchronized (f.class) {
            if (!acV) {
                acV = true;
                vL();
            }
        }
    }

    public static synchronized void vL() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m411getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    acU = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void gL() {
        this.acY = true;
        this.acZ.gT().vj = true;
        vM();
    }

    private void vM() {
        try {
            if (this.acW != null) {
                this.acW.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void l(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().acS) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.iP()) {
            this.adf = false;
            try {
                if (com.baidu.adp.lib.util.i.iR()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (ada == null) {
                            ada = com.baidu.adp.lib.util.i.iZ();
                        }
                        if (ada != null && ada.length() > 0) {
                            this.adf = true;
                            if (dE(ada) && com.baidu.adp.lib.util.i.jb()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(ada);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.acW = e.getInstance().httpGetFactory(sb.toString(), this.adg, false);
                                    } else {
                                        this.acW = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.acW = new HttpGet(sb.toString());
                                }
                                this.acW.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.acW.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = adc.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    adc.setParameter("http.route.default-proxy", new HttpHost(ada, com.baidu.adp.lib.util.i.ja()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(ada) || httpHost.getPort() != com.baidu.adp.lib.util.i.ja()) {
                                        adc.setParameter("http.route.default-proxy", new HttpHost(ada, com.baidu.adp.lib.util.i.ja()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.acW = e.getInstance().httpGetFactory(str, this.adg, false);
                                    } else {
                                        this.acW = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.acW = new HttpGet(str);
                                }
                                if (acU != null) {
                                    this.acW.setHeader("Proxy-Authorization", acU);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.acW.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.iR()) {
                            if (!this.adf || this.acW == null) {
                                this.acW = e.getInstance().httpGetFactory(str, this.adg, false);
                                return;
                            }
                            return;
                        }
                        this.acW = e.getInstance().httpGetFactory(str, this.adg, true);
                        return;
                    }
                    this.acW = e.getInstance().httpGetFactory(str, str2, str3);
                    return;
                }
                this.acW = new HttpGet(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void dD(String str) {
        l(str, null, null);
    }

    private boolean dE(String str) {
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
        boolean iQ;
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
            if (!e.getInstance().acS) {
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
            if (this.acY || i2 >= i) {
                break;
            }
            this.adg = i2;
            currentTimeMillis = System.currentTimeMillis();
            dVar = new com.baidu.adp.lib.network.http.d();
            this.acZ.a(dVar);
            dVar.uZ = -1;
            InputStream inputStream2 = null;
            c = this.acZ.gS().c(dVar);
            try {
                dVar.uZ = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    dD(c);
                    if (z15) {
                        dVar.va = e.getInstance().getCachedCdnIp(this.adg);
                    }
                } else {
                    l(c, str, str2);
                    dVar.va = str;
                }
                dVar.uZ = -3;
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
            if (this.acW == null) {
                throw new SocketException("network not available.");
            }
            if (this.acY) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e5) {
                    }
                }
                vM();
                this.acZ.b(dVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean iQ2 = com.baidu.adp.lib.util.i.iQ();
                    if ((iQ2 ? dVar.va != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fZ(c) && z15) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (iQ2) {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().SG);
                        } else if (com.baidu.adp.lib.util.i.iU()) {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().SI);
                        } else {
                            z7 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().SH);
                        }
                        e.getInstance().result(c, dVar.va, z16, z7, iQ2);
                    }
                }
            } else {
                dVar.uZ = -8;
                HttpResponse execute = adb.execute(this.acW);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.acZ.gT().responseCode = execute.getStatusLine().getStatusCode();
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
                    this.acZ.gT().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.acX < 1) {
                            vM();
                            this.acX++;
                            this.acZ.gT().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e10) {
                                }
                            }
                            vM();
                            this.acZ.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean iQ3 = com.baidu.adp.lib.util.i.iQ();
                                if ((iQ3 ? dVar.va != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fZ(c) && z15) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iQ3) {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                    } else if (com.baidu.adp.lib.util.i.iU()) {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                    } else {
                                        z13 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                    }
                                    e.getInstance().result(c, dVar.va, z16, z13, iQ3);
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
                            vM();
                            this.acZ.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean iQ4 = com.baidu.adp.lib.util.i.iQ();
                                if ((iQ4 ? dVar.va != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fZ(c) && z15) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iQ4) {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                    } else if (com.baidu.adp.lib.util.i.iU()) {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                    } else {
                                        z12 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                    }
                                    e.getInstance().result(c, dVar.va, z16, z12, iQ4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > aaO) {
                    this.acZ.gT().responseCode = -11;
                    dVar.uX = this.mContext.getResources().getString(n.i.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e12) {
                        }
                    }
                    vM();
                    this.acZ.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean iQ5 = com.baidu.adp.lib.util.i.iQ();
                        if ((iQ5 ? dVar.va != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fZ(c) && z15) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (iQ5) {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().SG);
                            } else if (com.baidu.adp.lib.util.i.iU()) {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().SI);
                            } else {
                                z8 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().SH);
                            }
                            e.getInstance().result(c, dVar.va, z16, z8, iQ5);
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
                        this.rI = true;
                    } else {
                        this.rI = false;
                    }
                }
                while (!this.acY && i3 < aaO && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                dVar.uZ = -9;
                if (this.acY) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e13) {
                        }
                    }
                    vM();
                    this.acZ.b(dVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean iQ6 = com.baidu.adp.lib.util.i.iQ();
                        if ((iQ6 ? dVar.va != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fZ(c) && z15) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (iQ6) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().SG);
                            } else if (com.baidu.adp.lib.util.i.iU()) {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().SI);
                            } else {
                                z9 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().SH);
                            }
                            e.getInstance().result(c, dVar.va, z16, z9, iQ6);
                        }
                    }
                } else {
                    if (i3 < aaO) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value = entity.getContentEncoding().getValue()) != null && value.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.acZ.gT().responseCode = -11;
                        dVar.uX = this.mContext.getResources().getString(n.i.data_too_big);
                    }
                    dVar.uR = i3;
                    dVar.uU = i2 + 1;
                    dVar.uT = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.ade = false;
                        } else {
                            this.ade = true;
                        }
                    }
                    z10 = (i3 <= 0 || !(this.acZ.gT().responseCode == 200 || this.acZ.gT().responseCode == 302)) ? z16 : true;
                    try {
                        if (com.baidu.adp.b.a.mD() != null && dVar != null) {
                            com.baidu.adp.b.a.mD().b(TbConfig.TMP_PIC_DIR_NAME, dVar.uQ, dVar.uR);
                            break;
                        }
                        break;
                    } catch (SocketTimeoutException e14) {
                        e = e14;
                        z16 = z10;
                        this.acZ.gT().responseCode = -13;
                        dVar.uX = String.valueOf(String.valueOf(this.acZ.gT().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e15) {
                            }
                        }
                        vM();
                        this.acZ.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean iQ7 = com.baidu.adp.lib.util.i.iQ();
                            if ((iQ7 ? dVar.va != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fZ(c) && z15) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (iQ7) {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                } else if (com.baidu.adp.lib.util.i.iU()) {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                } else {
                                    z6 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                }
                                e.getInstance().result(c, dVar.va, z16, z6, iQ7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (HttpException e16) {
                        e = e16;
                        z16 = z10;
                        this.acZ.gT().responseCode = -18;
                        dVar.uX = String.valueOf(String.valueOf(this.acZ.gT().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        vM();
                        this.acZ.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean iQ8 = com.baidu.adp.lib.util.i.iQ();
                            if ((iQ8 ? dVar.va != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fZ(c) && z15) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (iQ8) {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                } else if (com.baidu.adp.lib.util.i.iU()) {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                } else {
                                    z5 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                }
                                e.getInstance().result(c, dVar.va, z16, z5, iQ8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e18) {
                        e = e18;
                        inputStream2 = inputStream;
                        z16 = z10;
                        try {
                            this.acZ.gT().responseCode = -12;
                            dVar.uX = String.valueOf(String.valueOf(this.acZ.gT().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e19) {
                                }
                            }
                            vM();
                            this.acZ.b(dVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean iQ9 = com.baidu.adp.lib.util.i.iQ();
                                if ((iQ9 ? dVar.va != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fZ(c) && z15) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (iQ9) {
                                        z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                    } else if (com.baidu.adp.lib.util.i.iU()) {
                                        z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                    } else {
                                        z4 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                    }
                                    e.getInstance().result(c, dVar.va, z16, z4, iQ9);
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
                            vM();
                            this.acZ.b(dVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                iQ = com.baidu.adp.lib.util.i.iQ();
                                if ((iQ ? dVar.va != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fZ(c) && z15) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!iQ) {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                    } else if (com.baidu.adp.lib.util.i.iU()) {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                    } else {
                                        z3 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                    }
                                    e.getInstance().result(c, dVar.va, z16, z3, iQ);
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e21) {
                        e = e21;
                        z16 = z10;
                        this.acZ.gT().responseCode = -19;
                        dVar.uX = String.valueOf(String.valueOf(this.acZ.gT().responseCode)) + "|retryCount:" + i2 + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e22) {
                            }
                        }
                        vM();
                        this.acZ.b(dVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean iQ10 = com.baidu.adp.lib.util.i.iQ();
                            if ((iQ10 ? dVar.va != null || z16 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fZ(c) && z15) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (iQ10) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().SG);
                                } else if (com.baidu.adp.lib.util.i.iU()) {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().SI);
                                } else {
                                    z2 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().SH);
                                }
                                e.getInstance().result(c, dVar.va, z16, z2, iQ10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z16 = z10;
                        if (inputStream != null) {
                        }
                        vM();
                        this.acZ.b(dVar);
                        if (str != null) {
                        }
                        iQ = com.baidu.adp.lib.util.i.iQ();
                        if (iQ ? dVar.va != null || z16 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!iQ) {
                            }
                            e.getInstance().result(c, dVar.va, z16, z3, iQ);
                        }
                        throw th;
                    }
                }
            }
        }
        this.acX = 0;
        this.acZ.gT().vl = bArr;
        vM();
        this.acZ.b(dVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean iQ11 = com.baidu.adp.lib.util.i.iQ();
            if ((iQ11 ? dVar.va != null || z10 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.e.fZ(c) && z15) {
                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                if (iQ11) {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().SG);
                } else if (com.baidu.adp.lib.util.i.iU()) {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().SI);
                } else {
                    z11 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().SH);
                }
                e.getInstance().result(c, dVar.va, z10, z11, iQ11);
            }
        }
        this.acX = 0;
        this.acZ.gT().vl = bArr;
    }

    public void vN() {
        e(null, null, -1);
    }

    public boolean fF() {
        return this.rI;
    }

    public boolean vO() {
        return this.ade;
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0004a
    public void cancel() {
        gL();
    }
}
