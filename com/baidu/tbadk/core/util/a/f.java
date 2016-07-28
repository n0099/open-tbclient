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
import com.baidu.tieba.u;
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
public class f implements a.InterfaceC0006a {
    private static int Xz;
    public static String ZO;
    private static HttpClient ZP;
    private static String ZU;
    private static int ZV;
    private static long ZW;
    private HttpGet ZK;
    private final com.baidu.adp.lib.network.http.f ZN;
    public boolean ZS;
    private final Context mContext;
    private static volatile String ZI = null;
    private static volatile boolean ZJ = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    public static BasicHttpParams ZQ = new BasicHttpParams();
    private boolean iu = false;
    private boolean ZR = false;
    private int ZT = 0;
    private int ZL = 0;
    private volatile boolean ZM = false;

    static {
        Xz = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
        HttpConnectionParams.setConnectionTimeout(ZQ, 5000);
        HttpConnectionParams.setSoTimeout(ZQ, 30000);
        HttpConnectionParams.setSocketBufferSize(ZQ, 1024);
        HttpConnectionParams.setTcpNoDelay(ZQ, true);
        HttpClientParams.setRedirecting(ZQ, true);
        ConnManagerParams.setMaxConnectionsPerRoute(ZQ, new ConnPerRouteBean(15));
        ConnManagerParams.setTimeout(ZQ, 10000L);
        ConnManagerParams.setMaxTotalConnections(ZQ, 15);
        HttpProtocolParams.setUserAgent(ZQ, "bdtb for Android " + TbConfig.getVersion());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ZP = new DefaultHttpClient(new ThreadSafeClientConnManager(ZQ, schemeRegistry), ZQ);
        ZP.setRedirectHandler(new g());
        if (Runtime.getRuntime().maxMemory() >= 67108864) {
            Xz = 4194304;
        }
        ZU = null;
        ZV = 0;
        ZW = System.currentTimeMillis();
    }

    public f(com.baidu.adp.lib.network.http.f fVar) {
        uz();
        this.ZN = fVar;
        this.mContext = TbadkCoreApplication.m10getInst().getApp();
    }

    public static void uz() {
        synchronized (f.class) {
            if (!ZJ) {
                ZJ = true;
                uA();
            }
        }
    }

    public static synchronized void uA() {
        synchronized (f.class) {
            try {
                Cursor query = TbadkCoreApplication.m10getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    ZI = "Basic " + com.baidu.adp.lib.util.c.encodeBytes((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e) {
            }
        }
    }

    public void dl() {
        this.ZM = true;
        this.ZN.dv().mh = true;
        uB();
    }

    private void uB() {
        try {
            if (this.ZK != null) {
                this.ZK.abort();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void s(String str, String str2, String str3) {
        boolean z;
        if (e.getInstance() != null) {
            if (!e.getInstance().ZG) {
                e.getInstance().init();
            }
            z = true;
        } else {
            z = false;
        }
        if (com.baidu.adp.lib.util.i.fq()) {
            this.ZS = false;
            try {
                if (com.baidu.adp.lib.util.i.fs()) {
                    URL url = new URL(str);
                    synchronized (f.class) {
                        if (ZO == null) {
                            ZO = com.baidu.adp.lib.util.i.fA();
                        }
                        if (ZO != null && ZO.length() > 0) {
                            this.ZS = true;
                            if (dJ(ZO) && com.baidu.adp.lib.util.i.fC()) {
                                StringBuilder sb = new StringBuilder(80);
                                sb.append("http://");
                                sb.append(ZO);
                                String file = url.getFile();
                                if (file != null && file.startsWith("?")) {
                                    sb.append("/");
                                }
                                sb.append(file);
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ZK = e.getInstance().httpGetFactory(sb.toString(), this.ZT, false);
                                    } else {
                                        this.ZK = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ZK = new HttpGet(sb.toString());
                                }
                                this.ZK.setHeader("X-Online-Host", url.getHost());
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ZK.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            } else {
                                Object parameter = ZQ.getParameter("http.route.default-proxy");
                                if (parameter == null || !(parameter instanceof HttpHost)) {
                                    ZQ.setParameter("http.route.default-proxy", new HttpHost(ZO, com.baidu.adp.lib.util.i.fB()));
                                } else {
                                    HttpHost httpHost = (HttpHost) parameter;
                                    if (httpHost.getHostName() == null || !httpHost.getHostName().equals(ZO) || httpHost.getPort() != com.baidu.adp.lib.util.i.fB()) {
                                        ZQ.setParameter("http.route.default-proxy", new HttpHost(ZO, com.baidu.adp.lib.util.i.fB()));
                                    }
                                }
                                if (z) {
                                    if (str2 == null || str2.length() == 0) {
                                        this.ZK = e.getInstance().httpGetFactory(str, this.ZT, false);
                                    } else {
                                        this.ZK = e.getInstance().httpGetFactory(str, str2, str3);
                                    }
                                } else {
                                    this.ZK = new HttpGet(str);
                                }
                                if (ZI != null) {
                                    this.ZK.setHeader("Proxy-Authorization", ZI);
                                }
                                if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                                    this.ZK.setHeader("client_user_token", TbadkCoreApplication.getCurrentAccount());
                                }
                            }
                        }
                    }
                }
                if (z) {
                    if (str2 == null || str2.length() == 0) {
                        if (com.baidu.adp.lib.util.i.fs()) {
                            if (!this.ZS || this.ZK == null) {
                                this.ZK = e.getInstance().httpGetFactory(str, this.ZT, false);
                            }
                        } else {
                            this.ZK = e.getInstance().httpGetFactory(str, this.ZT, true);
                        }
                    } else {
                        this.ZK = e.getInstance().httpGetFactory(str, str2, str3);
                    }
                } else {
                    this.ZK = new HttpGet(str);
                }
                this.ZK.setHeader("needginfo", "1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private boolean dJ(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [633=13, 634=13, 638=13, 644=13, 645=13, 646=13, 647=13, 648=13, 649=26, 651=13, 652=13, 653=13, 654=13, 657=13, 658=26, 659=13, 660=13, 661=26, 662=13, 663=13, 664=13, 665=13, 667=26, 668=13] */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x09a6, code lost:
        r12.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0c74  */
    /* JADX WARN: Removed duplicated region for block: B:664:0x0c92  */
    /* JADX WARN: Removed duplicated region for block: B:672:0x0cb5  */
    /* JADX WARN: Removed duplicated region for block: B:757:0x0c54 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str, String str2, int i) {
        long currentTimeMillis;
        com.baidu.adp.lib.network.http.e eVar;
        String c;
        InputStream inputStream;
        Throwable th;
        boolean z;
        boolean z2;
        boolean z3;
        boolean fr;
        boolean z4;
        boolean z5;
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
        Header[] headers;
        byte[] bArr = null;
        boolean z15 = false;
        if (e.getInstance() != null) {
            z15 = true;
            if (!e.getInstance().ZG) {
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
            if (this.ZM || i2 >= i) {
                break;
            }
            this.ZT = i2;
            currentTimeMillis = System.currentTimeMillis();
            eVar = new com.baidu.adp.lib.network.http.e();
            this.ZN.a(eVar);
            eVar.lS = -1;
            InputStream inputStream2 = null;
            c = this.ZN.du().c(eVar);
            try {
                eVar.lS = -2;
                currentTimeMillis2 = System.currentTimeMillis();
                if (str == null || str.length() == 0) {
                    s(c, null, null);
                    if (z16) {
                        eVar.lT = e.getInstance().getCachedCdnIp(this.ZT);
                    }
                } else {
                    s(c, str, str2);
                    eVar.lT = str;
                }
                eVar.lS = -3;
            } catch (IllegalStateException e) {
                e = e;
                inputStream = null;
            } catch (SocketException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
            } catch (HttpException e4) {
                e = e4;
                inputStream = null;
            } catch (SocketTimeoutException e5) {
                e = e5;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            if (this.ZK == null) {
                throw new SocketException("network not available.");
            }
            if (this.ZM) {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                uB();
                this.ZN.b(eVar);
                if ((str == null || str.length() == 0) && c != null) {
                    boolean fr2 = com.baidu.adp.lib.util.i.fr();
                    if ((fr2 ? eVar.lT != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gk(c) && z16) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (fr2) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().KP);
                        } else if (com.baidu.adp.lib.util.i.fv()) {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().KR);
                        } else {
                            z8 = currentTimeMillis3 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                        }
                        e.getInstance().result(c, eVar.lT, z17, z8, fr2);
                    }
                }
            } else {
                eVar.lS = -8;
                HttpResponse execute = ZP.execute(this.ZK);
                if (execute == null) {
                    throw new SocketException("httpResponse is null.");
                }
                if (execute.getStatusLine() == null) {
                    throw new SocketException("httpResponse getStatusLine is null.");
                }
                this.ZN.dv().responseCode = execute.getStatusLine().getStatusCode();
                eVar.lR = this.ZN.dv().responseCode;
                if (execute.getEntity() == null) {
                    throw new SocketException("httpResponse getEntity is null.");
                }
                HttpEntity entity = execute.getEntity();
                inputStream = entity.getContent();
                try {
                    try {
                        if (c.contains("c.tieba.baidu.com") && (headers = execute.getHeaders("Tracecode")) != null && headers.length > 0) {
                            eVar.lV = headers[0].getValue();
                            eVar.lW = headers[1].getValue();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (HttpException e7) {
                    e = e7;
                } catch (SocketException e8) {
                    e = e8;
                    inputStream2 = inputStream;
                } catch (SocketTimeoutException e9) {
                    e = e9;
                } catch (IOException e10) {
                    e = e10;
                } catch (IllegalStateException e11) {
                    e = e11;
                } catch (Throwable th4) {
                    th = th4;
                }
                if (inputStream == null) {
                    throw new IOException("get content is null.");
                }
                if (entity.getContentType() != null) {
                    String obj2 = entity.getContentType().toString();
                    this.ZN.dv().contentType = obj2;
                    if (obj2.contains("text/vnd.wap.wml")) {
                        if (this.ZL < 1) {
                            uB();
                            this.ZL++;
                            this.ZN.dv().responseCode = 0;
                            i2--;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e12) {
                                }
                            }
                            uB();
                            this.ZN.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean fr3 = com.baidu.adp.lib.util.i.fr();
                                if ((fr3 ? eVar.lT != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gk(c) && z16) {
                                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                                    if (fr3) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().KP);
                                    } else if (com.baidu.adp.lib.util.i.fv()) {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                    } else {
                                        z14 = currentTimeMillis4 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                    }
                                    e.getInstance().result(c, eVar.lT, z17, z14, fr3);
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
                            uB();
                            this.ZN.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean fr4 = com.baidu.adp.lib.util.i.fr();
                                if ((fr4 ? eVar.lT != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gk(c) && z16) {
                                    long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis;
                                    if (fr4) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().KP);
                                    } else if (com.baidu.adp.lib.util.i.fv()) {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                    } else {
                                        z13 = currentTimeMillis5 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                    }
                                    e.getInstance().result(c, eVar.lT, z17, z13, fr4);
                                }
                            }
                        }
                    }
                }
                if (((int) entity.getContentLength()) > Xz) {
                    this.ZN.dv().mi = -11;
                    eVar.lQ = this.mContext.getResources().getString(u.j.data_too_big);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e14) {
                        }
                    }
                    uB();
                    this.ZN.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean fr5 = com.baidu.adp.lib.util.i.fr();
                        if ((fr5 ? eVar.lT != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gk(c) && z16) {
                            long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis;
                            if (fr5) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().KP);
                            } else if (com.baidu.adp.lib.util.i.fv()) {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().KR);
                            } else {
                                z9 = currentTimeMillis6 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                            }
                            e.getInstance().result(c, eVar.lT, z17, z9, fr5);
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
                        this.iu = true;
                    } else {
                        this.iu = false;
                    }
                }
                while (!this.ZM && i3 < Xz && (read = inputStream.read(bArr2)) != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                    i3 += read;
                }
                eVar.lS = -9;
                if (this.ZM) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e15) {
                        }
                    }
                    uB();
                    this.ZN.b(eVar);
                    if ((str == null || str.length() == 0) && c != null) {
                        boolean fr6 = com.baidu.adp.lib.util.i.fr();
                        if ((fr6 ? eVar.lT != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gk(c) && z16) {
                            long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                            if (fr6) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().KP);
                            } else if (com.baidu.adp.lib.util.i.fv()) {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().KR);
                            } else {
                                z10 = currentTimeMillis7 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                            }
                            e.getInstance().result(c, eVar.lT, z17, z10, fr6);
                        }
                    }
                } else {
                    if (i3 < Xz) {
                        bArr = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        if (entity.getContentEncoding() != null && (value2 = entity.getContentEncoding().getValue()) != null && value2.contains("gzip")) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                            com.baidu.adp.lib.util.f.c(byteArrayInputStream, byteArrayOutputStream2);
                            bArr = byteArrayOutputStream2.toByteArray();
                        }
                    } else {
                        this.ZN.dv().mi = -11;
                        eVar.lQ = this.mContext.getResources().getString(u.j.data_too_big);
                    }
                    eVar.lK = i3;
                    eVar.lN = i2 + 1;
                    eVar.lM = System.currentTimeMillis() - currentTimeMillis2;
                    if (execute.getFirstHeader("Error-Message") != null) {
                        Header firstHeader = execute.getFirstHeader("Error-Message");
                        if (firstHeader == null || TextUtils.isEmpty(firstHeader.getValue()) || firstHeader.getValue().equalsIgnoreCase("OK")) {
                            this.ZR = false;
                        } else {
                            this.ZR = true;
                        }
                    }
                    z11 = (i3 <= 0 || !(this.ZN.dv().responseCode == 200 || this.ZN.dv().responseCode == 302)) ? z17 : true;
                    try {
                        if (com.baidu.adp.b.a.iw() != null && eVar != null) {
                            com.baidu.adp.b.a.iw().a(TbConfig.TMP_PIC_DIR_NAME, eVar.lJ, eVar.lK);
                        }
                        if (execute.getFirstHeader("ginfo") != null && (value = execute.getFirstHeader("ginfo").getValue()) != null && value.length() > 0) {
                            dK(value);
                            break;
                        }
                        break;
                    } catch (HttpException e16) {
                        e = e16;
                        z17 = z11;
                        this.ZN.dv().mi = -18;
                        eVar.lQ = "errorCode:" + String.valueOf(this.ZN.dv().mi) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        uB();
                        this.ZN.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean fr7 = com.baidu.adp.lib.util.i.fr();
                            if ((fr7 ? eVar.lT != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gk(c) && z16) {
                                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis;
                                if (fr7) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().KP);
                                } else if (com.baidu.adp.lib.util.i.fv()) {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                } else {
                                    z7 = currentTimeMillis8 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                }
                                e.getInstance().result(c, eVar.lT, z17, z7, fr7);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IllegalStateException e18) {
                        e = e18;
                        z17 = z11;
                        this.ZN.dv().mi = -19;
                        eVar.lQ = "errorCode:" + String.valueOf(this.ZN.dv().mi) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e19) {
                            }
                        }
                        uB();
                        this.ZN.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean fr8 = com.baidu.adp.lib.util.i.fr();
                            if ((fr8 ? eVar.lT != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gk(c) && z16) {
                                long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                                if (fr8) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().KP);
                                } else if (com.baidu.adp.lib.util.i.fv()) {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                } else {
                                    z6 = currentTimeMillis9 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                }
                                e.getInstance().result(c, eVar.lT, z17, z6, fr8);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (SocketException e20) {
                        e = e20;
                        inputStream2 = inputStream;
                        z17 = z11;
                        try {
                            this.ZN.dv().mi = -12;
                            eVar.lQ = "errorCode:" + String.valueOf(this.ZN.dv().mi) + "|" + e.getClass() + "|" + e.getMessage();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e21) {
                                }
                            }
                            uB();
                            this.ZN.b(eVar);
                            if ((str == null || str.length() == 0) && c != null) {
                                boolean fr9 = com.baidu.adp.lib.util.i.fr();
                                if ((fr9 ? eVar.lT != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gk(c) && z16) {
                                    long currentTimeMillis10 = System.currentTimeMillis() - currentTimeMillis;
                                    if (fr9) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().KP);
                                    } else if (com.baidu.adp.lib.util.i.fv()) {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                    } else {
                                        z5 = currentTimeMillis10 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                    }
                                    e.getInstance().result(c, eVar.lT, z17, z5, fr9);
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
                            uB();
                            this.ZN.b(eVar);
                            if ((str != null || str.length() == 0) && c != null) {
                                fr = com.baidu.adp.lib.util.i.fr();
                                if ((fr ? eVar.lT != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gk(c) && z16) {
                                    long currentTimeMillis11 = System.currentTimeMillis() - currentTimeMillis;
                                    if (!fr) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().KP);
                                    } else if (com.baidu.adp.lib.util.i.fv()) {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                    } else {
                                        z4 = currentTimeMillis11 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                    }
                                    e.getInstance().result(c, eVar.lT, z17, z4, fr);
                                }
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e23) {
                        e = e23;
                        z17 = z11;
                        this.ZN.dv().mi = -13;
                        eVar.lQ = "errorCode:" + String.valueOf(this.ZN.dv().mi) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        uB();
                        this.ZN.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean fr10 = com.baidu.adp.lib.util.i.fr();
                            if ((fr10 ? eVar.lT != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gk(c) && z16) {
                                long currentTimeMillis12 = System.currentTimeMillis() - currentTimeMillis;
                                if (fr10) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().KP);
                                } else if (com.baidu.adp.lib.util.i.fv()) {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                } else {
                                    z3 = currentTimeMillis12 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                }
                                e.getInstance().result(c, eVar.lT, z17, z3, fr10);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (IOException e25) {
                        e = e25;
                        z17 = z11;
                        this.ZN.dv().mi = -19;
                        eVar.lQ = "errorCode:" + String.valueOf(this.ZN.dv().mi) + "|" + e.getClass() + "|" + e.getMessage();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                            }
                        }
                        uB();
                        this.ZN.b(eVar);
                        if ((str == null || str.length() == 0) && c != null) {
                            boolean fr11 = com.baidu.adp.lib.util.i.fr();
                            if ((fr11 ? eVar.lT != null || z17 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gk(c) && z16) {
                                long currentTimeMillis13 = System.currentTimeMillis() - currentTimeMillis;
                                if (fr11) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().KP);
                                } else if (com.baidu.adp.lib.util.i.fv()) {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().KR);
                                } else {
                                    z2 = currentTimeMillis13 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                                }
                                e.getInstance().result(c, eVar.lT, z17, z2, fr11);
                            }
                        }
                        i2++;
                        bArr = bArr;
                    } catch (Throwable th6) {
                        th = th6;
                        z17 = z11;
                        if (inputStream != null) {
                        }
                        uB();
                        this.ZN.b(eVar);
                        if (str != null) {
                        }
                        fr = com.baidu.adp.lib.util.i.fr();
                        if (fr ? eVar.lT != null || z17 || i2 >= i + (-1) : true) {
                            long currentTimeMillis112 = System.currentTimeMillis() - currentTimeMillis;
                            if (!fr) {
                            }
                            e.getInstance().result(c, eVar.lT, z17, z4, fr);
                        }
                        throw th;
                    }
                }
            }
        }
        uB();
        this.ZN.b(eVar);
        if ((str == null || str.length() == 0) && c != null) {
            boolean fr12 = com.baidu.adp.lib.util.i.fr();
            if ((fr12 ? eVar.lT != null || z11 || i2 >= i + (-1) : true) && com.baidu.tbadk.util.h.gk(c) && z16) {
                long currentTimeMillis14 = System.currentTimeMillis() - currentTimeMillis;
                if (fr12) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().KP);
                } else if (com.baidu.adp.lib.util.i.fv()) {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().KR);
                } else {
                    z12 = currentTimeMillis14 > ((long) e.getInstance().getCDNImageTimeData().KQ);
                }
                e.getInstance().result(c, eVar.lT, z11, z12, fr12);
            }
        }
        this.ZL = 0;
        this.ZN.dv().mk = bArr;
    }

    private void dK(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(ZU) && (System.currentTimeMillis() - ZW) - (1800000 * (ZV / 3)) >= 0) {
            ZV++;
            try {
                char[] charArray = TbadkCoreApplication.m10getInst().getCuid().toCharArray();
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
                ZU = str;
                new Thread(new h(this, url)).start();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean cd() {
        return this.iu;
    }

    public boolean uC() {
        return this.ZR;
    }

    @Override // com.baidu.adp.lib.g.a.InterfaceC0006a
    public void cancel() {
        dl();
    }
}
