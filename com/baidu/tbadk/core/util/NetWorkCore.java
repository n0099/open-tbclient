package com.baidu.tbadk.core.util;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.kirin.KirinConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ErrorData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import org.apache.http.message.BasicNameValuePair;
@Deprecated
/* loaded from: classes.dex */
public class NetWorkCore implements aa {
    private static String a = IOUtils.LINE_SEPARATOR_WINDOWS;
    private static String b = "--";
    private static String c = "--------7da3d81520810*";
    private static int d = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
    private static Handler e = null;
    private static volatile String f = null;
    private static volatile boolean g = false;
    private static Pattern h = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    private static /* synthetic */ int[] p;
    private Context i;
    private HttpURLConnection j;
    private int k;
    private boolean l;
    private volatile boolean m;
    private int n = 0;
    private final com.baidu.tbadk.core.util.a.a o;

    /* loaded from: classes.dex */
    public enum NetworkState {
        UNAVAIL,
        WIFI,
        MOBILE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetworkState[] valuesCustom() {
            NetworkState[] valuesCustom = values();
            int length = valuesCustom.length;
            NetworkState[] networkStateArr = new NetworkState[length];
            System.arraycopy(valuesCustom, 0, networkStateArr, 0, length);
            return networkStateArr;
        }
    }

    /* loaded from: classes.dex */
    public enum NetworkStateInfo {
        UNAVAIL,
        WIFI,
        TwoG,
        ThreeG;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetworkStateInfo[] valuesCustom() {
            NetworkStateInfo[] valuesCustom = values();
            int length = valuesCustom.length;
            NetworkStateInfo[] networkStateInfoArr = new NetworkStateInfo[length];
            System.arraycopy(valuesCustom, 0, networkStateInfoArr, 0, length);
            return networkStateInfoArr;
        }
    }

    static /* synthetic */ int[] m() {
        int[] iArr = p;
        if (iArr == null) {
            iArr = new int[NetworkStateInfo.valuesCustom().length];
            try {
                iArr[NetworkStateInfo.ThreeG.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NetworkStateInfo.TwoG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[NetworkStateInfo.UNAVAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[NetworkStateInfo.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            p = iArr;
        }
        return iArr;
    }

    public NetWorkCore(com.baidu.tbadk.core.util.a.a aVar) {
        n();
        this.o = aVar;
        this.i = TbadkApplication.m252getInst().getApp();
    }

    private int a(NetworkStateInfo networkStateInfo) {
        switch (m()[networkStateInfo.ordinal()]) {
            case 2:
            default:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
        }
    }

    private void n() {
        this.j = null;
        this.i = null;
        this.k = 0;
        this.m = false;
        this.l = false;
        h();
    }

    public static void h() {
        synchronized (NetWorkCore.class) {
            if (!g) {
                g = true;
                i();
            }
        }
    }

    public static synchronized void i() {
        synchronized (NetWorkCore.class) {
            try {
                Cursor query = TbadkApplication.m252getInst().getApp().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    f = "Basic " + be.b((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e2) {
            }
        }
    }

    public static void j() {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        } else {
            System.setProperty("http.keepAlive", "true");
        }
        e = new am();
    }

    public static NetworkState a(Context context) {
        NetworkState networkState;
        NetworkState networkState2 = NetworkState.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkState = NetworkState.UNAVAIL;
            } else if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                networkState = NetworkState.WIFI;
            } else {
                networkState = NetworkState.MOBILE;
            }
            return networkState;
        } catch (Exception e2) {
            return networkState2;
        }
    }

    public String k() {
        return this.o.a().a().a;
    }

    @Override // com.baidu.tbadk.core.util.aa
    public boolean c() {
        return this.m;
    }

    @Override // com.baidu.tbadk.core.util.aa
    public void b() {
        this.m = true;
        try {
            if (this.j != null) {
                this.j.disconnect();
                try {
                    int a2 = ar.a(k());
                    if (a2 > 0) {
                        ar.a().a(a2, 1);
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        } catch (Exception e3) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x00fa */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x0012 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tbadk.core.util.NetWorkCore$NetworkState] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.baidu.tbadk.coreExtra.a.a] */
    private HttpURLConnection a(URL url) {
        Exception e2;
        String defaultHost;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        HttpURLConnection a2 = a(this.i);
        this.l = false;
        try {
            if (a2 == NetworkState.UNAVAIL) {
                return null;
            }
            try {
                if (a2 == NetworkState.MOBILE && (defaultHost = Proxy.getDefaultHost()) != null && defaultHost.length() > 0) {
                    if (b(defaultHost)) {
                        this.l = true;
                        StringBuilder sb = new StringBuilder(80);
                        sb.append("http://");
                        sb.append(Proxy.getDefaultHost());
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        httpURLConnection.setRequestProperty("X-Online-Host", url.getHost());
                        httpURLConnection.setRequestProperty("User-Agent", "BaiduTieba for Android " + TbConfig.getVersion());
                        if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                            httpURLConnection.setRequestProperty("client_user_token", TbadkApplication.getCurrentAccount());
                            httpURLConnection2 = httpURLConnection;
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort())));
                        if (f != null) {
                            httpURLConnection.setRequestProperty("Proxy-Authorization", f);
                        }
                        httpURLConnection.setRequestProperty("User-Agent", "BaiduTieba for Android " + TbConfig.getVersion());
                        if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                            httpURLConnection.setRequestProperty("client_user_token", TbadkApplication.getCurrentAccount());
                        }
                    }
                    httpURLConnection2 = httpURLConnection;
                }
                if (httpURLConnection2 == null) {
                    try {
                        a2 = (HttpURLConnection) url.openConnection();
                    } catch (Exception e3) {
                        a2 = httpURLConnection2;
                        e2 = e3;
                        BdLog.e(getClass().getName(), "getConnect", "error = " + e2.getMessage());
                        return a2;
                    }
                } else {
                    a2 = httpURLConnection2;
                }
                if (this.o != null) {
                    if (!TextUtils.isEmpty(this.o.a().a().i)) {
                        a2.setRequestProperty("sid", this.o.a().a().i);
                    }
                    if (!TextUtils.isEmpty(this.o.a().a().j)) {
                        a2.setRequestProperty("net", this.o.a().a().j);
                    }
                }
                com.baidu.tbadk.coreExtra.a.a.a().a(a2);
                return a2;
            } catch (Exception e4) {
                e2 = e4;
            }
        } catch (Exception e5) {
            a2 = null;
            e2 = e5;
        }
    }

    private boolean b(String str) {
        if (h.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [737=12, 738=12, 739=12, 744=12, 745=12] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v22 long)] */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x07c1, code lost:
        r17.o.c().a.e = r1 + 1;
        r17.o.c().a.f = r7;
        r3 = new com.baidu.tbadk.core.util.av();
        r3.e = a(b(r17.i));
        r3.c = r17.n;
        r3.b = r7;
        r3.d = r1 + 1;
        r3.a = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0803, code lost:
        if (r7 <= com.baidu.tbadk.TbConfig.NOTIFY_SOUND_INTERVAL) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0805, code lost:
        com.baidu.tbadk.core.log.a.a(com.baidu.tbadk.core.log.k.a(r6.toString(), new java.lang.StringBuilder().append(r7).toString(), java.lang.String.valueOf(r3.c) + " |DNS Time" + r17.o.c().a.g + "|ConnectTime" + r17.o.c().a.c + "|current ip" + com.baidu.tbadk.core.util.UtilHelper.getIpFromDomain(com.baidu.tbadk.core.util.UtilHelper.getDomainName(r6.toString())), "old network download OK, retryCount:" + r3.d, ""));
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0886, code lost:
        com.baidu.tbadk.core.util.au.a(r3);
        com.baidu.tbadk.core.util.TiebaStatic.net(r17.o);
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0890, code lost:
        com.baidu.tbadk.core.util.ar.c(r17.o.a().a().a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x08a1, code lost:
        if (r4 == null) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x08a3, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0a0f, code lost:
        r2 = r3;
     */
    @Override // com.baidu.tbadk.core.util.aa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] e() {
        String str;
        int i;
        int read;
        String headerField;
        byte[] bArr = null;
        try {
            int a2 = ar.a(this.o.a().a().a);
            if (a2 > 0) {
                ar.a().a(a2);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        try {
            if (this.o.a().a().b == null || this.o.a().a().b.size() <= 0 || this.o.a().e) {
                str = this.o.a().a().a;
            } else {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.o.a().a().a);
                if (this.o.a().a().a.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.o.a().a().a.endsWith("?") && !this.o.a().a().a.endsWith("&")) {
                    sb.append("&");
                }
                for (int i2 = 0; i2 < this.o.a().a().b.size(); i2++) {
                    if (i2 != 0) {
                        sb.append("&");
                    }
                    sb.append(this.o.a().a().b.get(i2).getName());
                    sb.append("=");
                    sb.append(be.d(this.o.a().a().b.get(i2).getValue()));
                }
                str = sb.toString();
            }
            URL url = new URL(str);
            this.o.c().a.a = str.length();
            if (TbConfig.getDebugSwitch()) {
                BdLog.d(getClass().getName(), "getNetData", str);
            }
            int i3 = 0;
            while (true) {
                if (this.m || i3 >= 5) {
                    break;
                }
                InputStream inputStream = null;
                try {
                    try {
                        this.j = a(url);
                    } catch (Throwable th) {
                        try {
                            ar.c(this.o.a().a().a);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e3) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e4) {
                        }
                        throw th;
                    }
                } catch (SocketException e5) {
                    e = e5;
                } catch (SocketTimeoutException e6) {
                    e = e6;
                } catch (Exception e7) {
                    e = e7;
                }
                if (this.j == null) {
                    throw new SocketException("network not available.");
                }
                this.j.setConnectTimeout(KirinConfig.READ_TIME_OUT);
                this.j.setReadTimeout(30000);
                if ((this.o.a().a().d && !this.o.a().a().e) || this.o.a().e) {
                    this.j.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.m) {
                    try {
                        ar.c(this.o.a().a().a);
                        if (0 != 0) {
                            inputStream.close();
                        }
                    } catch (Exception e8) {
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e9) {
                    }
                } else {
                    long time = new Date().getTime();
                    this.o.c().a.g = new Date().getTime() - time;
                    this.j.connect();
                    this.o.c().a.c = (new Date().getTime() - time) - this.o.c().a.g;
                    this.o.b().a = this.j.getResponseCode();
                    if (this.o.b().a != 200) {
                        this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i3;
                        au.a.incrementAndGet();
                        this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                        if (i3 == 0) {
                            TiebaStatic.net(this.o);
                        }
                        try {
                            ar.c(this.o.a().a().a);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e10) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e11) {
                        }
                    } else if (!this.j.getContentType().contains("text/vnd.wap.wml")) {
                        String contentEncoding = this.j.getContentEncoding();
                        inputStream = this.j.getInputStream();
                        if (TbadkApplication.m252getInst().isMainProcess() && (headerField = this.j.getHeaderField("Content-Length")) != null) {
                            try {
                                int parseInt = Integer.parseInt(headerField);
                                if (parseInt > d) {
                                    ar.c(this.o.a().a().a);
                                    try {
                                        ar.c(this.o.a().a().a);
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Exception e12) {
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e13) {
                                    }
                                    return null;
                                }
                                int i4 = parseInt * 10;
                                if (i4 > 0) {
                                    if (BdLog.isDebugMode()) {
                                        BdLog.d("pre-free memory for downloaded image:[" + this.o.a().a().a + "], size:" + i4);
                                    }
                                    if (!com.baidu.tbadk.imageManager.e.a().c(i4)) {
                                        BdLog.d("Image download cacelled. out of memory. url:[" + this.o.a().a().a + "], size:" + i4);
                                        ar.c(this.o.a().a().a);
                                        try {
                                            ar.c(this.o.a().a().a);
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                        } catch (Exception e14) {
                                        }
                                        try {
                                            if (this.j != null) {
                                                this.j.disconnect();
                                            }
                                        } catch (Exception e15) {
                                        }
                                        return null;
                                    }
                                }
                            } catch (Throwable th2) {
                            }
                        }
                        byte[] bArr2 = new byte[1024];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        int i5 = 0;
                        String headerField2 = this.j.getHeaderField("imgsrc");
                        boolean z = false;
                        if (headerField2 != null && headerField2.length() > 0) {
                            z = true;
                        }
                        if (this.o.a().a().e || z) {
                            byte[] bArr3 = new byte[23];
                            int read2 = inputStream.read(bArr3, 0, 23);
                            if (!new String(bArr3, 0, bArr3.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                                byteArrayOutputStream.write(bArr3, 0, read2);
                                i5 = 0 + read2;
                            }
                        }
                        if (this.j != null) {
                            if ("image/gif".equalsIgnoreCase(this.j.getHeaderField("Src-Content-Type"))) {
                                this.o.b().e = true;
                            } else {
                                this.o.b().e = false;
                            }
                        }
                        if (this.o.b().e && this.o.a().h == 1) {
                            this.o.a().h = 2;
                            i = i5;
                        } else {
                            i = i5;
                        }
                        while (!this.m && i < d && (read = inputStream.read(bArr2)) != -1) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                            i = read + i;
                        }
                        if (!this.m) {
                            this.n = i;
                            long time2 = new Date().getTime() - time;
                            this.o.c().a.d = (time2 - this.o.c().a.c) - this.o.c().a.g;
                            BdLog.i(getClass().getName(), "getNetData", "time = " + String.valueOf(time2) + "ms");
                            if (i >= d) {
                                this.o.b().a = -11;
                                this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.data_too_big);
                                break;
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                                BdLog.i(getClass().getName(), "getNetData", "data.zise = " + String.valueOf(i));
                                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                    com.baidu.tbadk.c.a.b(byteArrayInputStream, byteArrayOutputStream2);
                                    bArr = byteArrayOutputStream2.toByteArray();
                                    break;
                                }
                                break;
                            } catch (SocketException e16) {
                                bArr = byteArray;
                                e = e16;
                                this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i3 + "|" + e.getClass() + "|" + e.getMessage();
                                this.o.b().a = -12;
                                au.a.incrementAndGet();
                                this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                                if (i3 == 0) {
                                    TiebaStatic.net(this.o);
                                }
                                try {
                                    ar.c(this.o.a().a().a);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception e17) {
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e18) {
                                }
                                i3++;
                            } catch (SocketTimeoutException e19) {
                                bArr = byteArray;
                                e = e19;
                                au.a.incrementAndGet();
                                this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i3 + "|" + e.getClass() + "|" + e.getMessage();
                                this.o.b().a = -13;
                                this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                                if (i3 == 0) {
                                    TiebaStatic.net(this.o);
                                }
                                try {
                                    ar.c(this.o.a().a().a);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception e20) {
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e21) {
                                }
                                i3++;
                            } catch (Exception e22) {
                                bArr = byteArray;
                                e = e22;
                                this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i3 + "|" + e.getClass() + "|" + e.getMessage();
                                this.o.b().a = -10;
                                this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                                BdLog.e(getClass().getName(), "getNetData", "error = " + e.getMessage());
                                TiebaStatic.net(this.o);
                                try {
                                    ar.c(this.o.a().a().a);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception e23) {
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e24) {
                                }
                                this.k = 0;
                                return bArr;
                            }
                        } else {
                            try {
                                ar.c(this.o.a().a().a);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (Exception e25) {
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e26) {
                            }
                        }
                    } else if (this.k < 1) {
                        this.j.disconnect();
                        this.k++;
                        this.o.b().a = 0;
                        i3--;
                        try {
                            ar.c(this.o.a().a().a);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e27) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e28) {
                        }
                    } else {
                        try {
                            ar.c(this.o.a().a().a);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e29) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e30) {
                        }
                    }
                    i3++;
                }
            }
            this.k = 0;
            return bArr;
            try {
                if (this.j != null) {
                    this.j.disconnect();
                }
            } catch (Exception e31) {
            }
            this.k = 0;
            return bArr;
        } catch (Exception e32) {
            BdLog.e(getClass().getName(), "getNetData", e32.getMessage());
            this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + e32.getClass() + e32.getMessage();
            ar.c(this.o.a().a().a);
            return null;
        }
    }

    private String o() {
        int indexOf;
        String str = null;
        if (this.j != null) {
            str = this.j.getContentType();
        }
        if (str == null || (indexOf = str.indexOf("charset")) == -1) {
            return "utf-8";
        }
        int indexOf2 = str.indexOf(32, indexOf);
        if (indexOf2 == -1) {
            return str.substring(indexOf + 8);
        }
        return str.substring(indexOf + 8, indexOf2);
    }

    public void a(String str) {
        this.o.b().b = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.o.b().b = errorData.getError_code();
                if (this.o.b().b == -1) {
                    this.o.b().c = this.i.getString(com.baidu.tieba.u.error_unkown_try_again);
                } else if (this.o.b().b != 0) {
                    this.o.b().c = errorData.getError_msg();
                }
            } catch (Exception e2) {
                BdLog.e("NetWork", "parseServerCode", "error = " + e2.getMessage());
                this.o.b().c = this.i.getString(com.baidu.tieba.u.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.aa
    public String f() {
        String str;
        Exception e2;
        byte[] e3 = e();
        if (this.o.b().a != 200) {
            return null;
        }
        try {
            str = new String(e3, 0, e3.length, o());
        } catch (Exception e4) {
            str = null;
            e2 = e4;
        }
        try {
            a(str);
            return str;
        } catch (Exception e5) {
            e2 = e5;
            BdLog.e(getClass().getName(), "getNetString", "error = " + e2.getMessage());
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1071=12, 1072=12, 1073=12, 1078=12, 1079=12, 1081=4] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x073a A[Catch: Exception -> 0x0749, TRY_LEAVE, TryCatch #21 {Exception -> 0x0749, blocks: (B:220:0x0729, B:222:0x073a), top: B:295:0x0729 }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0741 A[Catch: Exception -> 0x0747, TRY_LEAVE, TryCatch #30 {Exception -> 0x0747, blocks: (B:223:0x073d, B:225:0x0741), top: B:313:0x073d }] */
    @Override // com.baidu.tbadk.core.util.aa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d() {
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        InputStream inputStream3;
        SocketTimeoutException socketTimeoutException;
        InputStream inputStream4;
        SocketException socketException;
        URL url;
        int read;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        try {
            int a2 = ar.a(this.o.a().a().a);
            if (a2 > 0) {
                ar.a().a(a2);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.o.a().a().b == null || i2 >= this.o.a().a().b.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.o.a().a().b.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(String.valueOf(name) + "=");
                sb.append(be.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.o.a().a().f) {
            sb2.append("tiebaclient!!!");
            String a3 = be.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a3);
        }
        String sb3 = sb.toString();
        this.o.c().a.a = sb3.length();
        if (TbConfig.getDebugSwitch()) {
            BdLog.d(getClass().getName(), "postNetData", String.valueOf(this.o.a().a().a) + "?" + sb3);
        }
        int i3 = 0;
        boolean z = true;
        String str = null;
        while (true) {
            if (this.m || !z || i3 >= 5) {
                break;
            }
            inputStream = null;
            try {
                try {
                    url = new URL(this.o.a().a().a);
                    this.j = a(url);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ar.c(this.o.a().a().a);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Exception e3) {
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e4) {
                    }
                    throw th;
                }
            } catch (SocketException e5) {
                inputStream4 = null;
                socketException = e5;
            } catch (SocketTimeoutException e6) {
                inputStream3 = null;
                socketTimeoutException = e6;
            } catch (Throwable th3) {
                inputStream2 = null;
                th = th3;
            }
            if (this.j == null) {
                this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                try {
                    ar.c(this.o.a().a().a);
                    if (0 != 0) {
                        inputStream.close();
                    }
                } catch (Exception e7) {
                }
                try {
                    if (this.j != null) {
                        this.j.disconnect();
                    }
                } catch (Exception e8) {
                }
            } else {
                this.j.setConnectTimeout(KirinConfig.READ_TIME_OUT);
                this.j.setReadTimeout(15000);
                this.j.setDoOutput(true);
                this.j.setDoInput(true);
                this.j.setRequestMethod("POST");
                this.j.setRequestProperty("Charset", "UTF-8");
                this.j.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                if (this.o.a().a().d) {
                    this.j.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.m) {
                    try {
                        ar.c(this.o.a().a().a);
                        if (0 != 0) {
                            inputStream.close();
                        }
                    } catch (Exception e9) {
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e10) {
                    }
                } else {
                    long time = new Date().getTime();
                    b(url);
                    this.o.c().a.g = new Date().getTime() - time;
                    this.j.connect();
                    this.o.c().a.c = (new Date().getTime() - time) - this.o.c().a.g;
                    DataOutputStream dataOutputStream = new DataOutputStream(this.j.getOutputStream());
                    if (!this.m) {
                        dataOutputStream.writeBytes(sb3);
                    }
                    dataOutputStream.flush();
                    BdLog.i("NetWork", "postNetData", "Post data.zise = " + String.valueOf(dataOutputStream.size()));
                    dataOutputStream.close();
                    if (this.j != null) {
                        if ("image/gif".equalsIgnoreCase(this.j.getHeaderField("Src-Content-Type"))) {
                            this.o.b().e = true;
                        } else {
                            this.o.b().e = false;
                        }
                    }
                    this.o.b().a = this.j.getResponseCode();
                    if (this.o.b().a != 200) {
                        if (this.o.b().a != 202 && this.o.b().a != 201 && this.o.b().a != 205 && this.o.b().a != 304 && this.o.b().a != 305 && this.o.b().a != 408) {
                            if (this.o.b().a == 502 || this.o.b().a == 503 || this.o.b().a == 504) {
                                break;
                            }
                        } else {
                            this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i3;
                            au.a.incrementAndGet();
                            z = true;
                            this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                            if (i3 == 0) {
                                TiebaStatic.net(this.o);
                            }
                            try {
                                ar.c(this.o.a().a().a);
                                if (0 != 0) {
                                    inputStream.close();
                                }
                            } catch (Exception e11) {
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e12) {
                            }
                            i3++;
                        }
                    }
                    if (!this.o.a().a().f || !this.j.getContentType().contains("text/vnd.wap.wml")) {
                        String contentEncoding = this.j.getContentEncoding();
                        InputStream inputStream5 = this.j.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                            int i4 = 0;
                            while (!this.m && (read = inputStream5.read(bArr)) != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                                i4 += read;
                            }
                            inputStream5.close();
                            this.j.disconnect();
                            if (this.m) {
                                try {
                                    ar.c(this.o.a().a().a);
                                    if (inputStream5 != null) {
                                        inputStream5.close();
                                    }
                                } catch (Exception e13) {
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e14) {
                                }
                            } else {
                                this.n = i4;
                                long time2 = new Date().getTime() - time;
                                this.o.c().a.d = (time2 - this.o.c().a.c) - this.o.c().a.g;
                                BdLog.i(getClass().getName(), "postNetData", "time = " + String.valueOf(time2) + "ms");
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                BdLog.i(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                    com.baidu.tbadk.c.a.b(byteArrayInputStream, byteArrayOutputStream2);
                                    byteArray = byteArrayOutputStream2.toByteArray();
                                    BdLog.i(getClass().getName(), "postNetData", "After ungzip data.zise = " + String.valueOf(byteArray.length));
                                }
                                byte[] bArr2 = byteArray;
                                String str2 = new String(bArr2, 0, bArr2.length, o());
                                try {
                                    if (this.o.a().a().f && this.o.a().a().g) {
                                        a(str2);
                                    }
                                    this.o.c().a.e = i3 + 1;
                                    this.o.c().a.f = time2;
                                    av avVar = new av();
                                    avVar.e = a(b(this.i));
                                    avVar.c = this.n;
                                    avVar.b = time2;
                                    avVar.d = i3 + 1;
                                    avVar.a = 1;
                                    au.a(avVar);
                                    TiebaStatic.net(this.o);
                                    try {
                                        ar.c(this.o.a().a().a);
                                        if (inputStream5 != null) {
                                            inputStream5.close();
                                        }
                                    } catch (Exception e15) {
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                            str = str2;
                                        } else {
                                            str = str2;
                                        }
                                    } catch (Exception e16) {
                                        str = str2;
                                    }
                                } catch (SocketException e17) {
                                    inputStream4 = inputStream5;
                                    socketException = e17;
                                    str = str2;
                                    au.a.incrementAndGet();
                                    this.o.b().a = -12;
                                    z = true;
                                    this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                                    BdLog.e(getClass().getName(), "postNetData", "SocketException " + socketException.getMessage());
                                    if (i3 == 0) {
                                        TiebaStatic.net(this.o);
                                    }
                                    try {
                                        ar.c(this.o.a().a().a);
                                        if (inputStream4 != null) {
                                            inputStream4.close();
                                        }
                                    } catch (Exception e18) {
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e19) {
                                    }
                                    i3++;
                                } catch (SocketTimeoutException e20) {
                                    inputStream3 = inputStream5;
                                    socketTimeoutException = e20;
                                    str = str2;
                                    try {
                                        au.a.incrementAndGet();
                                        this.o.b().a = -13;
                                        z = true;
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                                        BdLog.e(getClass().getName(), "postNetData", "SocketTimeoutException " + socketTimeoutException.getMessage());
                                        if (i3 == 0) {
                                            TiebaStatic.net(this.o);
                                        }
                                        try {
                                            ar.c(this.o.a().a().a);
                                            if (inputStream3 != null) {
                                                inputStream3.close();
                                            }
                                        } catch (Exception e21) {
                                        }
                                        try {
                                            if (this.j != null) {
                                                this.j.disconnect();
                                            }
                                        } catch (Exception e22) {
                                        }
                                        i3++;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        inputStream = inputStream3;
                                        ar.c(this.o.a().a().a);
                                        if (inputStream != null) {
                                        }
                                        if (this.j != null) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th5) {
                                    inputStream2 = inputStream5;
                                    th = th5;
                                    str = str2;
                                    this.o.b().a = -10;
                                    z = false;
                                    this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                                    BdLog.e(getClass().getName(), "postNetData", th.getMessage());
                                    TiebaStatic.net(this.o);
                                    try {
                                        ar.c(this.o.a().a().a);
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                    } catch (Exception e23) {
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e24) {
                                    }
                                    i3++;
                                }
                            }
                        } catch (SocketException e25) {
                            inputStream4 = inputStream5;
                            socketException = e25;
                        } catch (SocketTimeoutException e26) {
                            inputStream3 = inputStream5;
                            socketTimeoutException = e26;
                        } catch (Throwable th6) {
                            inputStream2 = inputStream5;
                            th = th6;
                        }
                    } else if (this.k < 1) {
                        this.j.disconnect();
                        this.k++;
                        this.o.b().a = 0;
                        i3--;
                        try {
                            ar.c(this.o.a().a().a);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e27) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e28) {
                        }
                        i3++;
                    } else {
                        try {
                            ar.c(this.o.a().a().a);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e29) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e30) {
                        }
                    }
                }
            }
        }
        TiebaStatic.net(this.o);
        ar.c(this.o.a().a().a);
        try {
            ar.c(this.o.a().a().a);
            if (0 != 0) {
                inputStream.close();
            }
        } catch (Exception e31) {
        }
        try {
            if (this.j != null) {
                this.j.disconnect();
            }
        } catch (Exception e32) {
        }
        return null;
        this.k = 0;
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1280=11, 1281=11, 1286=11, 1287=11, 1292=11, 1293=11, 1297=11, 1298=11] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x038a A[Catch: all -> 0x05dd, TRY_LEAVE, TryCatch #13 {all -> 0x05dd, blocks: (B:41:0x00fd, B:43:0x010b, B:45:0x011d, B:76:0x0243, B:78:0x0257, B:79:0x025c, B:47:0x0121, B:49:0x0125, B:51:0x0133, B:52:0x0147, B:97:0x0301, B:100:0x0319, B:54:0x014d, B:56:0x019c, B:57:0x01ab, B:59:0x01bd, B:60:0x01c3, B:62:0x01cf, B:64:0x0217, B:117:0x03ae, B:119:0x03bd, B:121:0x03c2, B:123:0x03cf, B:186:0x0519, B:104:0x0369, B:106:0x038a, B:144:0x0418), top: B:316:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0398 A[Catch: Exception -> 0x05fe, TRY_LEAVE, TryCatch #10 {Exception -> 0x05fe, blocks: (B:109:0x0394, B:111:0x0398), top: B:312:0x0394 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0563 A[Catch: Exception -> 0x05e3, TRY_LEAVE, TryCatch #7 {Exception -> 0x05e3, blocks: (B:189:0x055f, B:191:0x0563), top: B:308:0x055f }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0584 A[Catch: Exception -> 0x05d7, TRY_LEAVE, TryCatch #39 {Exception -> 0x05d7, blocks: (B:201:0x0580, B:203:0x0584), top: B:354:0x0580 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x055c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x039f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0391 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x058b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:358:0x057d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x056a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:374:0x02f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x02e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x023c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:398:0x023c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:401:0x023c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02dd A[Catch: all -> 0x05d9, TRY_LEAVE, TryCatch #12 {all -> 0x05d9, blocks: (B:84:0x02bd, B:86:0x02dd), top: B:314:0x02bd }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02eb A[Catch: Exception -> 0x0618, TRY_LEAVE, TryCatch #8 {Exception -> 0x0618, blocks: (B:89:0x02e7, B:91:0x02eb), top: B:310:0x02e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02f9  */
    @Override // com.baidu.tbadk.core.util.aa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String g() {
        DataOutputStream dataOutputStream;
        Throwable th;
        Exception e2;
        int i;
        String str;
        DataOutputStream dataOutputStream2;
        InputStream inputStream;
        boolean z;
        byte[] bArr;
        int read;
        String str2 = null;
        boolean z2 = true;
        int i2 = 0;
        while (true) {
            if (this.m || !z2 || i2 >= 5) {
                break;
            }
            InputStream inputStream2 = null;
            DataOutputStream dataOutputStream3 = null;
            try {
                this.j = a(new URL(this.o.a().a().a));
            } catch (SocketException e3) {
                dataOutputStream2 = null;
                i = i2;
                str = str2;
                inputStream = null;
            } catch (SocketTimeoutException e4) {
                dataOutputStream = null;
                i = i2;
                str = str2;
            } catch (Exception e5) {
                e2 = e5;
                dataOutputStream = null;
                i = i2;
                str = str2;
            } catch (Throwable th2) {
                dataOutputStream = null;
                th = th2;
            }
            if (this.j == null) {
                this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                    }
                }
                try {
                    if (this.j != null) {
                        this.j.disconnect();
                    }
                } catch (Exception e7) {
                }
                if (0 != 0) {
                    try {
                        dataOutputStream3.close();
                    } catch (Exception e8) {
                    }
                }
                if (e != null) {
                    e.removeMessages(0, this);
                }
            } else {
                this.j.setConnectTimeout(KirinConfig.READ_TIME_OUT);
                this.j.setReadTimeout(15000);
                this.j.setDoOutput(true);
                this.j.setDoInput(true);
                this.j.setRequestMethod("POST");
                this.j.setRequestProperty("Charset", "UTF-8");
                this.j.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + c);
                if (this.o.a().a().d) {
                    this.j.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.m) {
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (Exception e9) {
                        }
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e10) {
                    }
                    if (0 != 0) {
                        try {
                            dataOutputStream3.close();
                        } catch (Exception e11) {
                        }
                    }
                    if (e != null) {
                        e.removeMessages(0, this);
                    }
                } else {
                    long time = new Date().getTime();
                    this.j.connect();
                    dataOutputStream = new DataOutputStream(this.j.getOutputStream());
                    for (int i3 = 0; this.o.a().a().b != null && i3 < this.o.a().a().b.size() && !this.m; i3++) {
                        try {
                            try {
                                BasicNameValuePair basicNameValuePair = this.o.a().a().b.get(i3);
                                if (basicNameValuePair != null) {
                                    String name = basicNameValuePair.getName();
                                    String value = basicNameValuePair.getValue();
                                    dataOutputStream.writeBytes(String.valueOf(b) + c + a);
                                    byte[] bytes = value.getBytes("UTF-8");
                                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + a);
                                    dataOutputStream.writeBytes(a);
                                    dataOutputStream.write(bytes);
                                    dataOutputStream.writeBytes(a);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (SocketException e12) {
                            dataOutputStream2 = dataOutputStream;
                            i = i2;
                            str = str2;
                            inputStream = null;
                        } catch (SocketTimeoutException e13) {
                            i = i2;
                            str = str2;
                        } catch (Exception e14) {
                            e2 = e14;
                            i = i2;
                            str = str2;
                        }
                    }
                    if (!this.m && this.o.a().a().c != null) {
                        for (Map.Entry<String, byte[]> entry : this.o.a().a().c.entrySet()) {
                            String key = entry.getKey();
                            byte[] value2 = entry.getValue();
                            if (this.m) {
                                break;
                            } else if (value2 != null) {
                                dataOutputStream.writeBytes(String.valueOf(b) + c + a);
                                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"" + a);
                                dataOutputStream.writeBytes(a);
                                dataOutputStream.write(value2);
                                dataOutputStream.writeBytes(a);
                            }
                        }
                    }
                    dataOutputStream.writeBytes(String.valueOf(b) + c + b + a);
                    dataOutputStream.flush();
                    BdLog.i("NetWork", "postMultiNetData", "Post data.zise = " + String.valueOf(dataOutputStream.size()));
                    dataOutputStream.close();
                    if (e != null) {
                        e.sendMessageDelayed(e.obtainMessage(0, this), 45000L);
                    }
                    this.o.b().a = this.j.getResponseCode();
                    if (e != null) {
                        e.removeMessages(0, this);
                    }
                    if (this.o.b().a != 200) {
                        this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i2;
                        au.a.incrementAndGet();
                        this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                        if (i2 == 0) {
                            TiebaStatic.net(this.o);
                        }
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e15) {
                            }
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e16) {
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e17) {
                            }
                        }
                        if (e != null) {
                            e.removeMessages(0, this);
                            z = true;
                            i = i2;
                            str = str2;
                        } else {
                            z = true;
                            i = i2;
                            str = str2;
                        }
                    } else if (!this.j.getContentType().contains("text/vnd.wap.wml")) {
                        String contentEncoding = this.j.getContentEncoding();
                        InputStream inputStream3 = this.j.getInputStream();
                        try {
                            try {
                                byte[] bArr2 = new byte[1024];
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                while (!this.m && (read = inputStream3.read(bArr2)) != -1) {
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                }
                                if (this.m) {
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e18) {
                                        }
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e19) {
                                    }
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (Exception e20) {
                                        }
                                    }
                                    if (e != null) {
                                        e.removeMessages(0, this);
                                    }
                                } else {
                                    inputStream3.close();
                                    this.j.disconnect();
                                    BdLog.i("NetWork", "postMultiNetData", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    BdLog.i("NetWork", "postMultiNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                                    if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                        bArr = byteArray;
                                    } else {
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                        com.baidu.tbadk.c.a.b(byteArrayInputStream, byteArrayOutputStream2);
                                        bArr = byteArrayOutputStream2.toByteArray();
                                    }
                                    String str3 = new String(bArr, 0, bArr.length, o());
                                    try {
                                        a(str3);
                                        TiebaStatic.net(this.o);
                                        if (inputStream3 != null) {
                                            try {
                                                inputStream3.close();
                                            } catch (Exception e21) {
                                            }
                                        }
                                        try {
                                            if (this.j != null) {
                                                this.j.disconnect();
                                            }
                                        } catch (Exception e22) {
                                        }
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e23) {
                                            }
                                        }
                                        if (e != null) {
                                            e.removeMessages(0, this);
                                            str2 = str3;
                                        } else {
                                            str2 = str3;
                                        }
                                    } catch (SocketException e24) {
                                        dataOutputStream2 = dataOutputStream;
                                        inputStream = inputStream3;
                                        int i4 = i2;
                                        str = str3;
                                        i = i4;
                                        z = true;
                                        this.o.b().a = -12;
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                                        if (i == 0) {
                                            TiebaStatic.net(this.o);
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e25) {
                                            }
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                        if (dataOutputStream2 != null) {
                                            try {
                                                dataOutputStream2.close();
                                            } catch (Exception e26) {
                                            }
                                        }
                                        if (e == null) {
                                            e.removeMessages(0, this);
                                        }
                                        z2 = z;
                                        str2 = str;
                                        i2 = i + 1;
                                    } catch (SocketTimeoutException e27) {
                                        inputStream2 = inputStream3;
                                        int i5 = i2;
                                        str = str3;
                                        i = i5;
                                        this.o.b().a = -13;
                                        z = true;
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                                        if (i == 0) {
                                            TiebaStatic.net(this.o);
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e28) {
                                            }
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e29) {
                                            }
                                        }
                                        if (e == null) {
                                            e.removeMessages(0, this);
                                        }
                                        z2 = z;
                                        str2 = str;
                                        i2 = i + 1;
                                    } catch (Exception e30) {
                                        e2 = e30;
                                        inputStream2 = inputStream3;
                                        int i6 = i2;
                                        str = str3;
                                        i = i6;
                                        this.o.b().a = -10;
                                        z = false;
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                                        BdLog.e("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                                        TiebaStatic.net(this.o);
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e31) {
                                            }
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e32) {
                                            }
                                        }
                                        if (e == null) {
                                            e.removeMessages(0, this);
                                        }
                                        z2 = z;
                                        str2 = str;
                                        i2 = i + 1;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = inputStream3;
                                if (inputStream2 != null) {
                                }
                                if (this.j != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                                if (e != null) {
                                }
                                throw th;
                            }
                        } catch (SocketException e33) {
                            dataOutputStream2 = dataOutputStream;
                            i = i2;
                            str = str2;
                            inputStream = inputStream3;
                        } catch (SocketTimeoutException e34) {
                            inputStream2 = inputStream3;
                            i = i2;
                            str = str2;
                        } catch (Exception e35) {
                            e2 = e35;
                            inputStream2 = inputStream3;
                            i = i2;
                            str = str2;
                        }
                    } else if (this.k < 1) {
                        this.j.disconnect();
                        this.k++;
                        i = i2 - 1;
                        try {
                            this.o.b().a = 0;
                            if (0 != 0) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e36) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e37) {
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e38) {
                                }
                            }
                            if (e != null) {
                                e.removeMessages(0, this);
                                z = z2;
                                str = str2;
                            } else {
                                z = z2;
                                str = str2;
                            }
                        } catch (SocketException e39) {
                            dataOutputStream2 = dataOutputStream;
                            str = str2;
                            inputStream = null;
                            z = true;
                            try {
                                this.o.b().a = -12;
                                this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                                if (i == 0) {
                                }
                                if (inputStream != null) {
                                }
                                try {
                                    if (this.j != null) {
                                    }
                                } catch (Exception e40) {
                                }
                                if (dataOutputStream2 != null) {
                                }
                                if (e == null) {
                                }
                                z2 = z;
                                str2 = str;
                                i2 = i + 1;
                            } catch (Throwable th5) {
                                th = th5;
                                dataOutputStream = dataOutputStream2;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e41) {
                                    }
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e42) {
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (Exception e43) {
                                    }
                                }
                                if (e != null) {
                                    e.removeMessages(0, this);
                                }
                                throw th;
                            }
                        } catch (SocketTimeoutException e44) {
                            str = str2;
                            this.o.b().a = -13;
                            z = true;
                            this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                            if (i == 0) {
                            }
                            if (inputStream2 != null) {
                            }
                            try {
                                if (this.j != null) {
                                }
                            } catch (Exception e45) {
                            }
                            if (dataOutputStream != null) {
                            }
                            if (e == null) {
                            }
                            z2 = z;
                            str2 = str;
                            i2 = i + 1;
                        } catch (Exception e46) {
                            e2 = e46;
                            str = str2;
                            this.o.b().a = -10;
                            z = false;
                            this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                            BdLog.e("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                            TiebaStatic.net(this.o);
                            if (inputStream2 != null) {
                            }
                            try {
                                if (this.j != null) {
                                }
                            } catch (Exception e47) {
                            }
                            if (dataOutputStream != null) {
                            }
                            if (e == null) {
                            }
                            z2 = z;
                            str2 = str;
                            i2 = i + 1;
                        }
                    } else {
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e48) {
                            }
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e49) {
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e50) {
                            }
                        }
                        if (e != null) {
                            e.removeMessages(0, this);
                        }
                    }
                    z2 = z;
                    str2 = str;
                    i2 = i + 1;
                }
            }
        }
        this.k = 0;
        return str2;
    }

    public boolean l() {
        return this.o.b().a == 200 || this.o.b().a == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1455=8, 1457=8, 1458=8, 1463=8, 1464=8, 1469=8, 1470=8] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03cb A[Catch: Exception -> 0x0400, TRY_LEAVE, TryCatch #31 {Exception -> 0x0400, blocks: (B:163:0x03c5, B:165:0x03cb), top: B:269:0x03c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tbadk.core.util.aa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        FileOutputStream fileOutputStream;
        Exception e2;
        InputStream inputStream;
        String headerField;
        int indexOf;
        InputStream inputStream2 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                this.j = a(new URL(this.o.a().a().a));
                if (this.j == null) {
                    throw new SocketException();
                }
                this.j.setConnectTimeout(KirinConfig.READ_TIME_OUT);
                this.j.setReadTimeout(30000);
                this.j.setInstanceFollowRedirects(false);
                if (this.m) {
                    this.k = 0;
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (Exception e3) {
                        }
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e4) {
                    }
                    if (0 != 0) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e5) {
                        }
                    }
                    return false;
                }
                long time = new Date().getTime();
                File g2 = x.g(str);
                if (g2 == null) {
                    throw new FileNotFoundException();
                }
                long length = g2.length();
                fileOutputStream = new FileOutputStream(g2, true);
                try {
                    if (this.l) {
                        this.j.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-" + String.valueOf(200000 + length));
                    } else {
                        this.j.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                    }
                    this.j.connect();
                    this.o.b().a = this.j.getResponseCode();
                    if (!l()) {
                        this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                        TiebaStatic.net(this.o);
                        this.k = 0;
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e6) {
                            }
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e7) {
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e8) {
                            }
                        }
                        return false;
                    } else if (this.j.getContentType().contains("text/vnd.wap.wml") && this.k < 1) {
                        this.j.disconnect();
                        this.k++;
                        this.o.b().a = 0;
                        boolean a2 = a(str, handler, i, i2, i3);
                        this.k = 0;
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e9) {
                            }
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e10) {
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return a2;
                            } catch (Exception e11) {
                                return a2;
                            }
                        }
                        return a2;
                    } else {
                        this.k = 0;
                        int i4 = 0;
                        String headerField2 = this.j.getHeaderField("Content-Range");
                        if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                            i4 = com.baidu.adp.lib.f.b.a(headerField2.substring(indexOf + 1), 0);
                        }
                        int a3 = (i4 == 0 && this.o.b().a == 200 && (headerField = this.j.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.f.b.a(headerField, 0) : i4;
                        if (length >= a3) {
                            this.k = 0;
                            if (0 != 0) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e12) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e13) {
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e14) {
                                }
                            }
                            return true;
                        }
                        InputStream inputStream3 = this.j.getInputStream();
                        try {
                            try {
                                byte[] bArr = new byte[1024];
                                int i5 = 0;
                                int i6 = a3 > 0 ? a3 / 50 : 0;
                                int i7 = 0;
                                if (handler != null && length > 0) {
                                    handler.sendMessage(handler.obtainMessage(i, (int) length, a3));
                                }
                                while (!this.m) {
                                    int read = inputStream3.read(bArr);
                                    if (read != -1) {
                                        try {
                                            fileOutputStream.write(bArr, 0, read);
                                            i5 += read;
                                            i7 += read;
                                            if (handler != null && (i7 > i6 || i5 == a3)) {
                                                i7 = 0;
                                                handler.sendMessage(handler.obtainMessage(i, (int) (i5 + length), a3));
                                            }
                                        } catch (Exception e15) {
                                            throw new FileNotFoundException();
                                        }
                                    }
                                }
                                try {
                                    fileOutputStream.flush();
                                    BdLog.i("NetWork", "downloadFile", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
                                    if (a3 != -1) {
                                        BdLog.i("NetWork", "downloadFile", "data.zise = " + String.valueOf(a3));
                                    }
                                    boolean z = ((long) i5) + length >= ((long) a3);
                                    this.k = 0;
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e16) {
                                        }
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e17) {
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            return z;
                                        } catch (Exception e18) {
                                            return z;
                                        }
                                    }
                                    return z;
                                } catch (Exception e19) {
                                    throw new FileNotFoundException();
                                }
                            } catch (Throwable th) {
                                th = th;
                                inputStream2 = inputStream3;
                                this.k = 0;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e20) {
                                    }
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e21) {
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e22) {
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e23) {
                            inputStream = inputStream3;
                            fileOutputStream2 = fileOutputStream;
                            try {
                                TiebaStatic.net(this.o);
                                this.o.b().a = -100;
                                this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.FileWriteError);
                                this.k = 0;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e24) {
                                    }
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e25) {
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                        return false;
                                    } catch (Exception e26) {
                                        return false;
                                    }
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                fileOutputStream = fileOutputStream2;
                                this.k = 0;
                                if (inputStream2 != null) {
                                }
                                if (this.j != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e27) {
                            inputStream2 = inputStream3;
                            e2 = e27;
                            TiebaStatic.net(this.o);
                            this.o.b().a = -10;
                            this.o.b().c = this.i.getResources().getString(com.baidu.tieba.u.neterror);
                            BdLog.e("NetWork", "downloadFile", "error = " + e2.getMessage());
                            this.k = 0;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e28) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e29) {
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return false;
                                } catch (Exception e30) {
                                    return false;
                                }
                            }
                            return false;
                        }
                    }
                } catch (FileNotFoundException e31) {
                    fileOutputStream2 = fileOutputStream;
                    inputStream = null;
                } catch (Exception e32) {
                    e2 = e32;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e33) {
            inputStream = null;
        } catch (Exception e34) {
            fileOutputStream = null;
            e2 = e34;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    @Override // com.baidu.tbadk.core.util.aa
    public ArrayList<BasicNameValuePair> a() {
        return this.o.a().a().b;
    }

    @Override // com.baidu.tbadk.core.util.aa
    public void a(ArrayList<BasicNameValuePair> arrayList) {
        if (this.o.a().a().b != null) {
            this.o.a().a().b.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                a(arrayList.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.aa
    public void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.aa
    public void a(String str, byte[] bArr) {
        if (this.o.a().a().c == null) {
            this.o.a().a().c = new HashMap<>();
        }
        this.o.a().a().c.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.aa
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.o.a().a().b == null) {
                this.o.a().a().b = new ArrayList<>();
            }
            int a2 = a(this.o.a().a().b, basicNameValuePair.getName());
            int size = this.o.a().a().b.size();
            if (a2 >= 0 && a2 < size) {
                if (basicNameValuePair.getName().equals(this.o.a().a().b.get(a2).getName())) {
                    this.o.a().a().b.set(a2, basicNameValuePair);
                } else {
                    this.o.a().a().b.add(a2, basicNameValuePair);
                }
            } else if (a2 == size) {
                this.o.a().a().b.add(a2, basicNameValuePair);
            }
        }
    }

    private int a(ArrayList<BasicNameValuePair> arrayList, String str) {
        int i = 0;
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            int compareTo = str.compareTo(arrayList.get(i).getName());
            if (compareTo < 0) {
                i2 = i;
                break;
            } else if (compareTo == 0) {
                return -1;
            } else {
                i2 = i;
                i++;
            }
        }
        return i >= size ? size : i2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x007a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.tbadk.core.util.NetWorkCore$NetworkStateInfo] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    public static NetworkStateInfo b(Context context) {
        NetworkStateInfo networkStateInfo;
        ?? e2 = NetworkStateInfo.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkStateInfo = NetworkStateInfo.UNAVAIL;
                try {
                    e2 = "NetWorkCore";
                    BdLog.i("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e3) {
                    e2 = e3;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                BdLog.i("NetWorkCore", "NetworkStateInfo", "WIFI");
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        BdLog.i("NetWorkCore", "NetworkStateInfo", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        BdLog.i("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        BdLog.i("NetWorkCore", "NetworkStateInfo-default", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                }
            }
            return networkStateInfo;
        } catch (Exception e4) {
            return e2;
        }
    }

    private void b(URL url) {
        try {
            InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Exception e2) {
            BdLog.e(getClass().getName(), "checkDNS", e2.toString());
        }
    }
}
