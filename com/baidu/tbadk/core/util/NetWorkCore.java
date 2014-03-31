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
public class NetWorkCore implements z {
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
    private final com.baidu.tbadk.core.util.a.a o;
    private int n = 0;
    private HttpURLConnection j = null;
    private int k = 0;
    private volatile boolean m = false;
    private boolean l = false;

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

    private static /* synthetic */ int[] l() {
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
        this.i = null;
        i();
        this.o = aVar;
        this.i = TbadkApplication.j().b();
    }

    private static int a(NetworkStateInfo networkStateInfo) {
        switch (l()[networkStateInfo.ordinal()]) {
            case 2:
            default:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
        }
    }

    private static void i() {
        synchronized (NetWorkCore.class) {
            if (!g) {
                g = true;
                j();
            }
        }
    }

    private static synchronized void j() {
        synchronized (NetWorkCore.class) {
            try {
                Cursor query = TbadkApplication.j().b().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    f = "Basic " + bc.a((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e2) {
            }
        }
    }

    public static void h() {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        } else {
            System.setProperty("http.keepAlive", "true");
        }
        e = new al();
    }

    private static NetworkState a(Context context) {
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

    @Override // com.baidu.tbadk.core.util.z
    public final boolean c() {
        return this.m;
    }

    @Override // com.baidu.tbadk.core.util.z
    public final void b() {
        this.m = true;
        try {
            if (this.j != null) {
                this.j.disconnect();
                try {
                    int a2 = aq.a(this.o.a().a().a);
                    if (a2 > 0) {
                        aq.a().a(a2, 1);
                    }
                } catch (Exception e2) {
                    com.baidu.adp.lib.util.f.b(e2.getMessage());
                }
            }
        } catch (Exception e3) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x00fa */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x0013 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.baidu.tbadk.coreExtra.a.a] */
    private HttpURLConnection a(URL url) {
        Exception e2;
        String defaultHost;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        HttpURLConnection httpURLConnection3 = 1;
        NetworkState a2 = a(this.i);
        this.l = false;
        try {
            if (a2 == NetworkState.UNAVAIL) {
                return null;
            }
            try {
                if (a2 == NetworkState.MOBILE && (defaultHost = Proxy.getDefaultHost()) != null && defaultHost.length() > 0) {
                    if (h.matcher(defaultHost).find()) {
                        this.l = true;
                        StringBuilder sb = new StringBuilder(80);
                        sb.append(com.baidu.loginshare.e.f);
                        sb.append(Proxy.getDefaultHost());
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        httpURLConnection.setRequestProperty("X-Online-Host", url.getHost());
                        httpURLConnection.setRequestProperty("User-Agent", "BaiduTieba for Android " + com.baidu.tbadk.core.data.n.c());
                        if (!TextUtils.isEmpty(TbadkApplication.E())) {
                            httpURLConnection.setRequestProperty("client_user_token", TbadkApplication.E());
                            httpURLConnection2 = httpURLConnection;
                        }
                    } else {
                        httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort())));
                        if (f != null) {
                            httpURLConnection.setRequestProperty("Proxy-Authorization", f);
                        }
                        httpURLConnection.setRequestProperty("User-Agent", "BaiduTieba for Android " + com.baidu.tbadk.core.data.n.c());
                        if (!TextUtils.isEmpty(TbadkApplication.E())) {
                            httpURLConnection.setRequestProperty("client_user_token", TbadkApplication.E());
                        }
                    }
                    httpURLConnection2 = httpURLConnection;
                }
                if (httpURLConnection2 == null) {
                    try {
                        httpURLConnection3 = (HttpURLConnection) url.openConnection();
                    } catch (Exception e3) {
                        httpURLConnection3 = httpURLConnection2;
                        e2 = e3;
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "getConnect", "error = " + e2.getMessage());
                        return httpURLConnection3;
                    }
                } else {
                    httpURLConnection3 = httpURLConnection2;
                }
                if (this.o != null) {
                    if (!TextUtils.isEmpty(this.o.a().a().i)) {
                        httpURLConnection3.setRequestProperty("sid", this.o.a().a().i);
                    }
                    if (!TextUtils.isEmpty(this.o.a().a().j)) {
                        httpURLConnection3.setRequestProperty(com.baidu.loginshare.e.e, this.o.a().a().j);
                    }
                }
                com.baidu.tbadk.coreExtra.a.a.a().a(httpURLConnection3);
                return httpURLConnection3;
            } catch (Exception e4) {
                e2 = e4;
            }
        } catch (Exception e5) {
            httpURLConnection3 = null;
            e2 = e5;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, INVOKE, IGET, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [737=12, 738=8, 739=8, 744=12, 745=12] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v22 long)] */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x078b, code lost:
        r17.o.c().a.e = r1 + 1;
        r17.o.c().a.f = r7;
        r3 = new com.baidu.tbadk.core.util.au();
        r3.e = a(b(r17.i));
        r3.c = r17.n;
        r3.b = r7;
        r3.d = r1 + 1;
        r3.a = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x07cb, code lost:
        if (r7 <= 5000) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x07cd, code lost:
        com.baidu.tbadk.core.log.a.a(com.baidu.tbadk.core.log.j.a(r6.toString(), new java.lang.StringBuilder().append(r7).toString(), java.lang.String.valueOf(r3.c) + " |DNS Time" + r17.o.c().a.g + "|ConnectTime" + r17.o.c().a.c + "|current ip" + com.baidu.tbadk.core.util.UtilHelper.b(com.baidu.tbadk.core.util.UtilHelper.a(r6.toString())), "old network download OK, retryCount:" + r3.d, ""));
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0849, code lost:
        com.baidu.tbadk.core.util.at.a(r3);
        com.baidu.tbadk.core.util.TiebaStatic.a(r17.o);
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0853, code lost:
        com.baidu.tbadk.core.util.aq.c(r17.o.a().a().a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0864, code lost:
        if (r4 == null) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0866, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x09cd, code lost:
        r2 = r3;
     */
    @Override // com.baidu.tbadk.core.util.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] e() {
        String str;
        int i;
        int read;
        String headerField;
        byte[] bArr = null;
        try {
            int a2 = aq.a(this.o.a().a().a);
            if (a2 > 0) {
                aq.a().a(a2);
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b(e2.getMessage());
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
                    sb.append(bc.d(this.o.a().a().b.get(i2).getValue()));
                }
                str = sb.toString();
            }
            URL url = new URL(str);
            this.o.c().a.a = str.length();
            if (com.baidu.tbadk.core.data.n.a()) {
                com.baidu.adp.lib.util.f.e(getClass().getName(), "getNetData", str);
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
                            aq.c(this.o.a().a().a);
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
                this.j.setConnectTimeout(5000);
                this.j.setReadTimeout(30000);
                if ((this.o.a().a().d && !this.o.a().a().e) || this.o.a().e) {
                    this.j.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.m) {
                    try {
                        aq.c(this.o.a().a().a);
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
                        at.a.incrementAndGet();
                        this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                        if (i3 == 0) {
                            TiebaStatic.a(this.o);
                        }
                        try {
                            aq.c(this.o.a().a().a);
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
                        if (TbadkApplication.j().m() && (headerField = this.j.getHeaderField("Content-Length")) != null) {
                            try {
                                int parseInt = Integer.parseInt(headerField);
                                if (parseInt > d) {
                                    aq.c(this.o.a().a().a);
                                    try {
                                        aq.c(this.o.a().a().a);
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
                                    if (com.baidu.adp.lib.util.f.a()) {
                                        com.baidu.adp.lib.util.f.e("pre-free memory for downloaded image:[" + this.o.a().a().a + "], size:" + i4);
                                    }
                                    if (!com.baidu.tbadk.imageManager.e.a().b(i4)) {
                                        com.baidu.adp.lib.util.f.e("Image download cacelled. out of memory. url:[" + this.o.a().a().a + "], size:" + i4);
                                        aq.c(this.o.a().a().a);
                                        try {
                                            aq.c(this.o.a().a().a);
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
                                i5 = read2 + 0;
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
                            com.baidu.adp.lib.util.f.a(getClass().getName(), "getNetData", "time = " + String.valueOf(time2) + "ms");
                            if (i >= d) {
                                this.o.b().a = -11;
                                this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.data_too_big);
                                break;
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                                com.baidu.adp.lib.util.f.a(getClass().getName(), "getNetData", "data.zise = " + String.valueOf(i));
                                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                    com.baidu.tbadk.d.a.b(byteArrayInputStream, byteArrayOutputStream2);
                                    bArr = byteArrayOutputStream2.toByteArray();
                                    break;
                                }
                                break;
                            } catch (SocketException e16) {
                                bArr = byteArray;
                                e = e16;
                                this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i3 + "|" + e.getClass() + "|" + e.getMessage();
                                this.o.b().a = -12;
                                at.a.incrementAndGet();
                                this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                                if (i3 == 0) {
                                    TiebaStatic.a(this.o);
                                }
                                try {
                                    aq.c(this.o.a().a().a);
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
                                at.a.incrementAndGet();
                                this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i3 + "|" + e.getClass() + "|" + e.getMessage();
                                this.o.b().a = -13;
                                this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                                if (i3 == 0) {
                                    TiebaStatic.a(this.o);
                                }
                                try {
                                    aq.c(this.o.a().a().a);
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
                                this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                                com.baidu.adp.lib.util.f.b(getClass().getName(), "getNetData", "error = " + e.getMessage());
                                TiebaStatic.a(this.o);
                                try {
                                    aq.c(this.o.a().a().a);
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
                                aq.c(this.o.a().a().a);
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
                    } else if (this.k <= 0) {
                        this.j.disconnect();
                        this.k++;
                        this.o.b().a = 0;
                        i3--;
                        try {
                            aq.c(this.o.a().a().a);
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
                            aq.c(this.o.a().a().a);
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
            try {
                if (this.j != null) {
                    this.j.disconnect();
                }
            } catch (Exception e31) {
            }
            this.k = 0;
            return bArr;
        } catch (Exception e32) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "getNetData", e32.getMessage());
            this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + e32.getClass() + e32.getMessage();
            aq.c(this.o.a().a().a);
            return null;
        }
    }

    private String k() {
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

    private void a(String str) {
        this.o.b().b = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.o.b().b = errorData.getError_code();
                if (this.o.b().b == -1) {
                    this.o.b().c = this.i.getString(com.baidu.tbadk.l.error_unkown_try_again);
                } else if (this.o.b().b != 0) {
                    this.o.b().c = errorData.getError_msg();
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.b("NetWork", "parseServerCode", "error = " + e2.getMessage());
                this.o.b().c = this.i.getString(com.baidu.tbadk.l.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.z
    public final String f() {
        String str;
        Exception e2;
        byte[] e3 = e();
        if (this.o.b().a != 200) {
            return null;
        }
        try {
            str = new String(e3, 0, e3.length, k());
        } catch (Exception e4) {
            str = null;
            e2 = e4;
        }
        try {
            a(str);
            return str;
        } catch (Exception e5) {
            e2 = e5;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "getNetString", "error = " + e2.getMessage());
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1071=12, 1072=6, 1073=6, 1078=12, 1079=12, 1081=4] */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0481, code lost:
        com.baidu.tbadk.core.util.aq.c(r14.o.a().a().a);
     */
    @Override // com.baidu.tbadk.core.util.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String d() {
        SocketTimeoutException socketTimeoutException;
        SocketException socketException;
        Throwable th;
        URL url;
        int read;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        try {
            int a2 = aq.a(this.o.a().a().a);
            if (a2 > 0) {
                aq.a().a(a2);
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b(e2.getMessage());
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
                sb.append(bc.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.o.a().a().f) {
            sb2.append("tiebaclient!!!");
            String a3 = bc.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a3);
        }
        String sb3 = sb.toString();
        this.o.c().a.a = sb3.length();
        if (com.baidu.tbadk.core.data.n.a()) {
            com.baidu.adp.lib.util.f.e(getClass().getName(), "postNetData", String.valueOf(this.o.a().a().a) + "?" + sb3);
        }
        int i3 = 0;
        String str = null;
        boolean z = true;
        while (true) {
            if (this.m || !z || i3 >= 5) {
                break;
            }
            InputStream inputStream = null;
            try {
                try {
                    try {
                        url = new URL(this.o.a().a().a);
                        this.j = a(url);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (SocketException e3) {
                socketException = e3;
            } catch (SocketTimeoutException e4) {
                socketTimeoutException = e4;
            }
            if (this.j == null) {
                this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                try {
                    aq.c(this.o.a().a().a);
                } catch (Exception e5) {
                }
                try {
                    if (this.j != null) {
                        this.j.disconnect();
                    }
                } catch (Exception e6) {
                }
            } else {
                this.j.setConnectTimeout(5000);
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
                        aq.c(this.o.a().a().a);
                    } catch (Exception e7) {
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e8) {
                    }
                } else {
                    long time = new Date().getTime();
                    try {
                        InetAddress.getByName(url.getHost()).getHostAddress();
                    } catch (Exception e9) {
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "checkDNS", e9.toString());
                    }
                    this.o.c().a.g = new Date().getTime() - time;
                    this.j.connect();
                    this.o.c().a.c = (new Date().getTime() - time) - this.o.c().a.g;
                    DataOutputStream dataOutputStream = new DataOutputStream(this.j.getOutputStream());
                    if (!this.m) {
                        dataOutputStream.writeBytes(sb3);
                    }
                    dataOutputStream.flush();
                    com.baidu.adp.lib.util.f.a("NetWork", "postNetData", "Post data.zise = " + String.valueOf(dataOutputStream.size()));
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
                            at.a.incrementAndGet();
                            z = true;
                            this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                            if (i3 == 0) {
                                TiebaStatic.a(this.o);
                            }
                            try {
                                aq.c(this.o.a().a().a);
                            } catch (Exception e10) {
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e11) {
                            }
                            i3++;
                        }
                    }
                    if (!this.o.a().a().f || !this.j.getContentType().contains("text/vnd.wap.wml")) {
                        String contentEncoding = this.j.getContentEncoding();
                        InputStream inputStream2 = this.j.getInputStream();
                        try {
                            try {
                                byte[] bArr = new byte[1024];
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                                int i4 = 0;
                                while (!this.m && (read = inputStream2.read(bArr)) != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                    i4 += read;
                                }
                                inputStream2.close();
                                this.j.disconnect();
                                if (this.m) {
                                    try {
                                        aq.c(this.o.a().a().a);
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                    } catch (Exception e12) {
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e13) {
                                    }
                                } else {
                                    this.n = i4;
                                    long time2 = new Date().getTime() - time;
                                    this.o.c().a.d = (time2 - this.o.c().a.c) - this.o.c().a.g;
                                    com.baidu.adp.lib.util.f.a(getClass().getName(), "postNetData", "time = " + String.valueOf(time2) + "ms");
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    com.baidu.adp.lib.util.f.a(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                                    if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                        com.baidu.tbadk.d.a.b(byteArrayInputStream, byteArrayOutputStream2);
                                        byteArray = byteArrayOutputStream2.toByteArray();
                                        com.baidu.adp.lib.util.f.a(getClass().getName(), "postNetData", "After ungzip data.zise = " + String.valueOf(byteArray.length));
                                    }
                                    byte[] bArr2 = byteArray;
                                    String str2 = new String(bArr2, 0, bArr2.length, k());
                                    try {
                                        if (this.o.a().a().f && this.o.a().a().g) {
                                            a(str2);
                                        }
                                        this.o.c().a.e = i3 + 1;
                                        this.o.c().a.f = time2;
                                        au auVar = new au();
                                        auVar.e = a(b(this.i));
                                        auVar.c = this.n;
                                        auVar.b = time2;
                                        auVar.d = i3 + 1;
                                        auVar.a = 1;
                                        at.a(auVar);
                                        TiebaStatic.a(this.o);
                                        try {
                                            aq.c(this.o.a().a().a);
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                        } catch (Exception e14) {
                                        }
                                        try {
                                            if (this.j != null) {
                                                this.j.disconnect();
                                                str = str2;
                                            } else {
                                                str = str2;
                                            }
                                        } catch (Exception e15) {
                                            str = str2;
                                        }
                                    } catch (SocketException e16) {
                                        inputStream = inputStream2;
                                        socketException = e16;
                                        str = str2;
                                        at.a.incrementAndGet();
                                        this.o.b().a = -12;
                                        z = true;
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", "SocketException " + socketException.getMessage());
                                        if (i3 == 0) {
                                            TiebaStatic.a(this.o);
                                        }
                                        try {
                                            aq.c(this.o.a().a().a);
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
                                        inputStream = inputStream2;
                                        socketTimeoutException = e19;
                                        str = str2;
                                        at.a.incrementAndGet();
                                        this.o.b().a = -13;
                                        z = true;
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", "SocketTimeoutException " + socketTimeoutException.getMessage());
                                        if (i3 == 0) {
                                            TiebaStatic.a(this.o);
                                        }
                                        try {
                                            aq.c(this.o.a().a().a);
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
                                    } catch (Throwable th4) {
                                        inputStream = inputStream2;
                                        th = th4;
                                        str = str2;
                                        this.o.b().a = -10;
                                        z = false;
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                                        com.baidu.adp.lib.util.f.b(getClass().getName(), "postNetData", th.getMessage());
                                        TiebaStatic.a(this.o);
                                        try {
                                            aq.c(this.o.a().a().a);
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                        } catch (Exception e22) {
                                        }
                                        try {
                                            if (this.j != null) {
                                                this.j.disconnect();
                                            }
                                        } catch (Exception e23) {
                                        }
                                        i3++;
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                inputStream = inputStream2;
                                try {
                                    aq.c(this.o.a().a().a);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception e24) {
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e25) {
                                }
                                throw th;
                            }
                        } catch (SocketException e26) {
                            inputStream = inputStream2;
                            socketException = e26;
                        } catch (SocketTimeoutException e27) {
                            inputStream = inputStream2;
                            socketTimeoutException = e27;
                        } catch (Throwable th6) {
                            inputStream = inputStream2;
                            th = th6;
                        }
                    } else if (this.k <= 0) {
                        this.j.disconnect();
                        this.k++;
                        this.o.b().a = 0;
                        i3--;
                        try {
                            aq.c(this.o.a().a().a);
                        } catch (Exception e28) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e29) {
                        }
                        i3++;
                    } else {
                        try {
                            aq.c(this.o.a().a().a);
                        } catch (Exception e30) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e31) {
                        }
                    }
                }
            }
        }
        this.k = 0;
        return str;
        try {
            if (this.j != null) {
                this.j.disconnect();
            }
        } catch (Exception e32) {
        }
        return null;
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1280=6, 1281=11, 1286=6, 1287=11, 1292=9, 1293=6, 1297=9, 1298=11] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04aa A[Catch: all -> 0x057e, TRY_LEAVE, TryCatch #21 {all -> 0x057e, blocks: (B:33:0x00e2, B:35:0x00f0, B:37:0x0102, B:65:0x021e, B:67:0x0232, B:68:0x0289, B:39:0x0106, B:41:0x010a, B:43:0x0118, B:44:0x012c, B:69:0x028e, B:72:0x02a6, B:46:0x0132, B:48:0x017e, B:49:0x018d, B:51:0x019f, B:52:0x01a5, B:54:0x01b1, B:56:0x01f8, B:90:0x033b, B:92:0x0349, B:94:0x034d, B:96:0x035a, B:166:0x04d2, B:151:0x0489, B:153:0x04aa, B:111:0x0395), top: B:306:0x00e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04b8 A[Catch: Exception -> 0x05a1, TRY_LEAVE, TryCatch #24 {Exception -> 0x05a1, blocks: (B:156:0x04b4, B:158:0x04b8), top: B:312:0x04b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0519 A[Catch: Exception -> 0x0584, TRY_LEAVE, TryCatch #44 {Exception -> 0x0584, blocks: (B:169:0x0515, B:171:0x0519), top: B:330:0x0515 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x053a A[Catch: Exception -> 0x0578, TRY_LEAVE, TryCatch #4 {Exception -> 0x0578, blocks: (B:181:0x0536, B:183:0x053a), top: B:280:0x0536 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0512 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x04b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0541 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0533 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0520 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x032c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x031e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0317 A[Catch: all -> 0x057a, TRY_LEAVE, TryCatch #18 {all -> 0x057a, blocks: (B:77:0x02f7, B:79:0x0317), top: B:302:0x02f7 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0325 A[Catch: Exception -> 0x05b9, TRY_LEAVE, TryCatch #42 {Exception -> 0x05b9, blocks: (B:82:0x0321, B:84:0x0325), top: B:328:0x0321 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0333  */
    @Override // com.baidu.tbadk.core.util.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String g() {
        DataOutputStream dataOutputStream;
        Throwable th;
        int i;
        String str;
        Exception e2;
        InputStream inputStream;
        DataOutputStream dataOutputStream2;
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
            try {
                this.j = a(new URL(this.o.a().a().a));
            } catch (SocketException e3) {
                inputStream = null;
                str = str2;
                dataOutputStream2 = null;
                i = i2;
            } catch (SocketTimeoutException e4) {
                dataOutputStream = null;
                str = str2;
                i = i2;
            } catch (Exception e5) {
                dataOutputStream = null;
                i = i2;
                str = str2;
                e2 = e5;
            } catch (Throwable th2) {
                dataOutputStream = null;
                th = th2;
            }
            if (this.j == null) {
                this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                try {
                    if (this.j != null) {
                        this.j.disconnect();
                    }
                } catch (Exception e6) {
                }
                if (e != null) {
                    e.removeMessages(0, this);
                }
            } else {
                this.j.setConnectTimeout(5000);
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
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e7) {
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
                        } catch (SocketException e8) {
                            inputStream = null;
                            i = i2;
                            str = str2;
                            dataOutputStream2 = dataOutputStream;
                        } catch (SocketTimeoutException e9) {
                            i = i2;
                            str = str2;
                        } catch (Exception e10) {
                            str = str2;
                            e2 = e10;
                            i = i2;
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
                    com.baidu.adp.lib.util.f.a("NetWork", "postMultiNetData", "Post data.zise = " + String.valueOf(dataOutputStream.size()));
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
                        at.a.incrementAndGet();
                        this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                        if (i2 == 0) {
                            TiebaStatic.a(this.o);
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e11) {
                        }
                        try {
                            dataOutputStream.close();
                        } catch (Exception e12) {
                        }
                        if (e != null) {
                            e.removeMessages(0, this);
                            str = str2;
                            int i4 = i2;
                            z = true;
                            i = i4;
                        } else {
                            str = str2;
                            int i5 = i2;
                            z = true;
                            i = i5;
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
                                        } catch (Exception e13) {
                                        }
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e14) {
                                    }
                                    try {
                                        dataOutputStream.close();
                                    } catch (Exception e15) {
                                    }
                                    if (e != null) {
                                        e.removeMessages(0, this);
                                    }
                                } else {
                                    inputStream3.close();
                                    this.j.disconnect();
                                    com.baidu.adp.lib.util.f.a("NetWork", "postMultiNetData", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    com.baidu.adp.lib.util.f.a("NetWork", "postMultiNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                                    if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                        bArr = byteArray;
                                    } else {
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                        com.baidu.tbadk.d.a.b(byteArrayInputStream, byteArrayOutputStream2);
                                        bArr = byteArrayOutputStream2.toByteArray();
                                    }
                                    String str3 = new String(bArr, 0, bArr.length, k());
                                    try {
                                        a(str3);
                                        TiebaStatic.a(this.o);
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
                                        try {
                                            dataOutputStream.close();
                                        } catch (Exception e18) {
                                        }
                                        if (e != null) {
                                            e.removeMessages(0, this);
                                            str2 = str3;
                                        } else {
                                            str2 = str3;
                                        }
                                    } catch (SocketException e19) {
                                        dataOutputStream2 = dataOutputStream;
                                        inputStream = inputStream3;
                                        str = str3;
                                        i = i2;
                                        z = true;
                                        this.o.b().a = -12;
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                                        if (i == 0) {
                                            TiebaStatic.a(this.o);
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception e20) {
                                            }
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                        if (dataOutputStream2 != null) {
                                            try {
                                                dataOutputStream2.close();
                                            } catch (Exception e21) {
                                            }
                                        }
                                        if (e == null) {
                                            e.removeMessages(0, this);
                                        }
                                        str2 = str;
                                        z2 = z;
                                        i2 = i + 1;
                                    } catch (SocketTimeoutException e22) {
                                        inputStream2 = inputStream3;
                                        str = str3;
                                        i = i2;
                                        this.o.b().a = -13;
                                        z = true;
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                                        if (i == 0) {
                                            TiebaStatic.a(this.o);
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e23) {
                                            }
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e24) {
                                            }
                                        }
                                        if (e == null) {
                                            e.removeMessages(0, this);
                                        }
                                        str2 = str;
                                        z2 = z;
                                        i2 = i + 1;
                                    } catch (Exception e25) {
                                        e2 = e25;
                                        inputStream2 = inputStream3;
                                        str = str3;
                                        i = i2;
                                        this.o.b().a = -10;
                                        z = false;
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                                        com.baidu.adp.lib.util.f.b("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                                        TiebaStatic.a(this.o);
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception e26) {
                                            }
                                        }
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e27) {
                                            }
                                        }
                                        if (e == null) {
                                            e.removeMessages(0, this);
                                        }
                                        str2 = str;
                                        z2 = z;
                                        i2 = i + 1;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = inputStream3;
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
                                if (e != null) {
                                    e.removeMessages(0, this);
                                }
                                throw th;
                            }
                        } catch (SocketException e30) {
                            inputStream = inputStream3;
                            i = i2;
                            str = str2;
                            dataOutputStream2 = dataOutputStream;
                        } catch (SocketTimeoutException e31) {
                            inputStream2 = inputStream3;
                            i = i2;
                            str = str2;
                        } catch (Exception e32) {
                            inputStream2 = inputStream3;
                            str = str2;
                            e2 = e32;
                            i = i2;
                        }
                    } else if (this.k <= 0) {
                        this.j.disconnect();
                        this.k++;
                        i = i2 - 1;
                        try {
                            this.o.b().a = 0;
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e33) {
                            }
                            try {
                                dataOutputStream.close();
                            } catch (Exception e34) {
                            }
                            if (e != null) {
                                e.removeMessages(0, this);
                                str = str2;
                                z = z2;
                            } else {
                                str = str2;
                                z = z2;
                            }
                        } catch (SocketException e35) {
                            inputStream = null;
                            str = str2;
                            dataOutputStream2 = dataOutputStream;
                            z = true;
                            try {
                                this.o.b().a = -12;
                                this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                                if (i == 0) {
                                }
                                if (inputStream != null) {
                                }
                                try {
                                    if (this.j != null) {
                                    }
                                } catch (Exception e36) {
                                }
                                if (dataOutputStream2 != null) {
                                }
                                if (e == null) {
                                }
                                str2 = str;
                                z2 = z;
                                i2 = i + 1;
                            } catch (Throwable th5) {
                                th = th5;
                                dataOutputStream = dataOutputStream2;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                }
                                try {
                                    if (this.j != null) {
                                    }
                                } catch (Exception e37) {
                                }
                                if (dataOutputStream != null) {
                                }
                                if (e != null) {
                                }
                                throw th;
                            }
                        } catch (SocketTimeoutException e38) {
                            str = str2;
                            this.o.b().a = -13;
                            z = true;
                            this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                            if (i == 0) {
                            }
                            if (inputStream2 != null) {
                            }
                            try {
                                if (this.j != null) {
                                }
                            } catch (Exception e39) {
                            }
                            if (dataOutputStream != null) {
                            }
                            if (e == null) {
                            }
                            str2 = str;
                            z2 = z;
                            i2 = i + 1;
                        } catch (Exception e40) {
                            str = str2;
                            e2 = e40;
                            this.o.b().a = -10;
                            z = false;
                            this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                            com.baidu.adp.lib.util.f.b("NetWork", "postMultiNetData", "error = " + e2.getMessage());
                            TiebaStatic.a(this.o);
                            if (inputStream2 != null) {
                            }
                            try {
                                if (this.j != null) {
                                }
                            } catch (Exception e41) {
                            }
                            if (dataOutputStream != null) {
                            }
                            if (e == null) {
                            }
                            str2 = str;
                            z2 = z;
                            i2 = i + 1;
                        }
                    } else {
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e42) {
                        }
                        try {
                            dataOutputStream.close();
                        } catch (Exception e43) {
                        }
                        if (e != null) {
                            e.removeMessages(0, this);
                        }
                    }
                    str2 = str;
                    z2 = z;
                    i2 = i + 1;
                }
            }
        }
        this.k = 0;
        return str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1455=8, 1457=4, 1458=8, 1463=4, 1464=8, 1469=7, 1470=4] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03b0 A[Catch: Exception -> 0x03d5, TRY_LEAVE, TryCatch #17 {Exception -> 0x03d5, blocks: (B:154:0x03aa, B:156:0x03b0), top: B:230:0x03aa }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tbadk.core.util.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(String str, Handler handler, int i, int i2, int i3) {
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
                this.j.setConnectTimeout(5000);
                this.j.setReadTimeout(30000);
                this.j.setInstanceFollowRedirects(false);
                if (this.m) {
                    this.k = 0;
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e3) {
                    }
                    return false;
                }
                long time = new Date().getTime();
                File g2 = w.g(str);
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
                    if (!(this.o.b().a == 200 || this.o.b().a == 206)) {
                        this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                        TiebaStatic.a(this.o);
                        this.k = 0;
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e4) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception e5) {
                        }
                        return false;
                    } else if (this.j.getContentType().contains("text/vnd.wap.wml") && this.k <= 0) {
                        this.j.disconnect();
                        this.k++;
                        this.o.b().a = 0;
                        boolean a2 = a(str, handler, i, i2, i3);
                        this.k = 0;
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e6) {
                        }
                        try {
                            fileOutputStream.close();
                            return a2;
                        } catch (Exception e7) {
                            return a2;
                        }
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
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e8) {
                            }
                            try {
                                fileOutputStream.close();
                            } catch (Exception e9) {
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
                                        } catch (Exception e10) {
                                            throw new FileNotFoundException();
                                        }
                                    }
                                }
                                try {
                                    fileOutputStream.flush();
                                    com.baidu.adp.lib.util.f.a("NetWork", "downloadFile", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
                                    if (a3 != -1) {
                                        com.baidu.adp.lib.util.f.a("NetWork", "downloadFile", "data.zise = " + String.valueOf(a3));
                                    }
                                    boolean z = ((long) i5) + length >= ((long) a3);
                                    this.k = 0;
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e11) {
                                        }
                                    }
                                    try {
                                        if (this.j != null) {
                                            this.j.disconnect();
                                        }
                                    } catch (Exception e12) {
                                    }
                                    try {
                                        fileOutputStream.close();
                                        return z;
                                    } catch (Exception e13) {
                                        return z;
                                    }
                                } catch (Exception e14) {
                                    throw new FileNotFoundException();
                                }
                            } catch (Throwable th) {
                                th = th;
                                inputStream2 = inputStream3;
                                this.k = 0;
                                if (inputStream2 != null) {
                                }
                                try {
                                    if (this.j != null) {
                                    }
                                } catch (Exception e15) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e16) {
                            inputStream = inputStream3;
                            fileOutputStream2 = fileOutputStream;
                            try {
                                TiebaStatic.a(this.o);
                                this.o.b().a = -100;
                                this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.FileWriteError);
                                this.k = 0;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e17) {
                                    }
                                }
                                try {
                                    if (this.j != null) {
                                        this.j.disconnect();
                                    }
                                } catch (Exception e18) {
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                        return false;
                                    } catch (Exception e19) {
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
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e20) {
                                    }
                                }
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e21) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e22) {
                            inputStream2 = inputStream3;
                            e2 = e22;
                            TiebaStatic.a(this.o);
                            this.o.b().a = -10;
                            this.o.b().c = this.i.getResources().getString(com.baidu.tbadk.l.neterror);
                            com.baidu.adp.lib.util.f.b("NetWork", "downloadFile", "error = " + e2.getMessage());
                            this.k = 0;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e23) {
                                }
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e24) {
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return false;
                                } catch (Exception e25) {
                                    return false;
                                }
                            }
                            return false;
                        }
                    }
                } catch (FileNotFoundException e26) {
                    fileOutputStream2 = fileOutputStream;
                    inputStream = null;
                } catch (Exception e27) {
                    e2 = e27;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e28) {
            inputStream = null;
        } catch (Exception e29) {
            fileOutputStream = null;
            e2 = e29;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    @Override // com.baidu.tbadk.core.util.z
    public final ArrayList<BasicNameValuePair> a() {
        return this.o.a().a().b;
    }

    @Override // com.baidu.tbadk.core.util.z
    public final void a(ArrayList<BasicNameValuePair> arrayList) {
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

    @Override // com.baidu.tbadk.core.util.z
    public final void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.z
    public final void a(String str, byte[] bArr) {
        if (this.o.a().a().c == null) {
            this.o.a().a().c = new HashMap<>();
        }
        this.o.a().a().c.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.z
    public final void a(BasicNameValuePair basicNameValuePair) {
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

    private static int a(ArrayList<BasicNameValuePair> arrayList, String str) {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0069 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.tbadk.core.util.NetWorkCore$NetworkStateInfo] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    private static NetworkStateInfo b(Context context) {
        NetworkStateInfo networkStateInfo;
        ?? e2 = NetworkStateInfo.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkStateInfo = NetworkStateInfo.UNAVAIL;
                try {
                    e2 = "NetWorkCore";
                    com.baidu.adp.lib.util.f.a("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e3) {
                    e2 = e3;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                com.baidu.adp.lib.util.f.a("NetWorkCore", "NetworkStateInfo", "WIFI");
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        com.baidu.adp.lib.util.f.a("NetWorkCore", "NetworkStateInfo", "TwoG");
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
                        com.baidu.adp.lib.util.f.a("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        com.baidu.adp.lib.util.f.a("NetWorkCore", "NetworkStateInfo-default", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                }
            }
            return networkStateInfo;
        } catch (Exception e4) {
            return e2;
        }
    }
}
