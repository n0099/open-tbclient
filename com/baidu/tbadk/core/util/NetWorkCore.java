package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
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
import org.apache.http.message.BasicNameValuePair;
@Deprecated
/* loaded from: classes.dex */
public class NetWorkCore implements v {
    private static String a = "\r\n";
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
    private final com.baidu.tbadk.core.util.httpNet.e o;

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

    public NetWorkCore(com.baidu.tbadk.core.util.httpNet.e eVar) {
        n();
        this.o = eVar;
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
                    f = "Basic " + ba.b((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e2) {
            }
        }
    }

    public static void j() {
        System.setProperty("http.keepAlive", "false");
        e = new af();
    }

    public static NetworkState a(Context context) {
        NetworkState networkState;
        NetworkState networkState2 = NetworkState.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkState = NetworkState.UNAVAIL;
            } else if (activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkChangeReceiver.WIFI_STRING)) {
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

    @Override // com.baidu.tbadk.core.util.v
    public boolean c() {
        return this.m;
    }

    @Override // com.baidu.tbadk.core.util.v
    public void b() {
        this.m = true;
        try {
            if (this.j != null) {
                this.j.disconnect();
                try {
                    int a2 = ak.a(k());
                    if (a2 > 0) {
                        ak.a().a(a2, 1);
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        } catch (Exception e3) {
        }
    }

    private HttpURLConnection a(URL url) {
        String defaultHost;
        HttpURLConnection httpURLConnection = null;
        NetworkState a2 = a(this.i);
        this.l = false;
        if (a2 != NetworkState.UNAVAIL) {
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
                    httpURLConnection.setRequestProperty("User-Agent", "bdtb for Android " + TbConfig.getVersion());
                    if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                        httpURLConnection.setRequestProperty("client_user_token", TbadkApplication.getCurrentAccount());
                    }
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort())));
                    if (f != null) {
                        httpURLConnection.setRequestProperty("Proxy-Authorization", f);
                    }
                    httpURLConnection.setRequestProperty("User-Agent", "bdtb for Android " + TbConfig.getVersion());
                    if (!TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                        httpURLConnection.setRequestProperty("client_user_token", TbadkApplication.getCurrentAccount());
                    }
                }
            }
            if (httpURLConnection == null) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            if (this.o != null) {
                if (!TextUtils.isEmpty(this.o.a().a().i)) {
                    httpURLConnection.setRequestProperty("sid", this.o.a().a().i);
                }
                if (!TextUtils.isEmpty(this.o.a().a().j)) {
                    httpURLConnection.setRequestProperty("net", this.o.a().a().j);
                }
            }
            com.baidu.tbadk.coreExtra.a.a.a().a(httpURLConnection);
        }
        return httpURLConnection;
    }

    private boolean b(String str) {
        if (h.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [711=12, 712=12, 713=12, 718=12, 719=12] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:140:0x0506 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:177:0x05ca */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:212:0x076f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:221:0x0815 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:253:0x086a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:257:0x0870 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:304:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:342:0x026d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x01c9 */
    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: com.baidu.tbadk.core.util.NetWorkCore */
    /* JADX DEBUG: Multi-variable search result rejected for r4v14, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r9v3, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r9v4, resolved type: long */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02ad, code lost:
        if (r17.o.a().e != false) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0644 A[Catch: all -> 0x0818, TRY_LEAVE, TryCatch #28 {all -> 0x0818, blocks: (B:43:0x01b0, B:45:0x01c0, B:46:0x01c8, B:58:0x0271, B:60:0x0293, B:64:0x02af, B:65:0x02bc, B:76:0x02ea, B:78:0x0353, B:80:0x03a2, B:90:0x03d1, B:92:0x03e2, B:94:0x03e9, B:114:0x0457, B:116:0x0472, B:142:0x0509, B:144:0x0521, B:147:0x0528, B:153:0x055a, B:155:0x0560, B:157:0x0574, B:175:0x05be, B:158:0x057f, B:160:0x0585, B:162:0x0589, B:191:0x0674, B:164:0x0590, B:192:0x067a, B:194:0x06b4, B:195:0x06b8, B:197:0x06bd, B:199:0x06c6, B:200:0x06d9, B:213:0x0770, B:178:0x05cb, B:180:0x0644, B:48:0x01ca, B:50:0x0243, B:210:0x0749, B:150:0x053a, B:152:0x0555, B:62:0x02a3), top: B:317:0x01b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x065e A[Catch: Exception -> 0x084b, TRY_LEAVE, TryCatch #16 {Exception -> 0x084b, blocks: (B:181:0x064b, B:183:0x065e), top: B:294:0x064b }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0667 A[Catch: Exception -> 0x0670, TRY_LEAVE, TryCatch #0 {Exception -> 0x0670, blocks: (B:184:0x0661, B:186:0x0667), top: B:270:0x0661 }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0803 A[Catch: Exception -> 0x0841, TRY_LEAVE, TryCatch #33 {Exception -> 0x0841, blocks: (B:214:0x07f0, B:216:0x0803), top: B:324:0x07f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x080c A[Catch: Exception -> 0x0815, TRY_LEAVE, TryCatch #18 {Exception -> 0x0815, blocks: (B:217:0x0806, B:219:0x080c), top: B:298:0x0806 }] */
    /* JADX WARN: Removed duplicated region for block: B:333:0x026d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x026d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0243 A[Catch: all -> 0x0818, TRY_LEAVE, TryCatch #28 {all -> 0x0818, blocks: (B:43:0x01b0, B:45:0x01c0, B:46:0x01c8, B:58:0x0271, B:60:0x0293, B:64:0x02af, B:65:0x02bc, B:76:0x02ea, B:78:0x0353, B:80:0x03a2, B:90:0x03d1, B:92:0x03e2, B:94:0x03e9, B:114:0x0457, B:116:0x0472, B:142:0x0509, B:144:0x0521, B:147:0x0528, B:153:0x055a, B:155:0x0560, B:157:0x0574, B:175:0x05be, B:158:0x057f, B:160:0x0585, B:162:0x0589, B:191:0x0674, B:164:0x0590, B:192:0x067a, B:194:0x06b4, B:195:0x06b8, B:197:0x06bd, B:199:0x06c6, B:200:0x06d9, B:213:0x0770, B:178:0x05cb, B:180:0x0644, B:48:0x01ca, B:50:0x0243, B:210:0x0749, B:150:0x053a, B:152:0x0555, B:62:0x02a3), top: B:317:0x01b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x025d A[Catch: Exception -> 0x0859, TRY_LEAVE, TryCatch #10 {Exception -> 0x0859, blocks: (B:51:0x024a, B:53:0x025d), top: B:284:0x024a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0266 A[Catch: Exception -> 0x0856, TRY_LEAVE, TryCatch #17 {Exception -> 0x0856, blocks: (B:54:0x0260, B:56:0x0266), top: B:296:0x0260 }] */
    /* JADX WARN: Type inference failed for: r1v77, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r1v79, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v80, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v86, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v87 */
    /* JADX WARN: Type inference failed for: r1v88, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v89, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v14, types: [int] */
    /* JADX WARN: Type inference failed for: r7v21, types: [int] */
    /* JADX WARN: Type inference failed for: r7v22, types: [long] */
    /* JADX WARN: Type inference failed for: r7v23, types: [long] */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28, types: [long] */
    /* JADX WARN: Type inference failed for: r7v35, types: [int] */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v16, types: [long] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:170:0x05b0 -> B:25:0x00bd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x05b2 -> B:25:0x00bd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:173:0x05bb -> B:25:0x00bd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:205:0x073b -> B:25:0x00bd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:206:0x073d -> B:25:0x00bd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:208:0x0746 -> B:25:0x00bd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:218:0x080a -> B:25:0x00bd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:219:0x080c -> B:25:0x00bd). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:221:0x0815 -> B:25:0x00bd). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] e() {
        String str;
        int i;
        ?? r6;
        InputStream inputStream;
        long j;
        ?? r7;
        Exception e2;
        SocketTimeoutException e3;
        SocketException e4;
        int read;
        String headerField;
        StringBuilder sb;
        byte[] bArr = null;
        try {
            int a2 = ak.a(this.o.a().a().a);
            if (a2 > 0) {
                ak.a().a(a2);
            }
        } catch (Exception e5) {
            BdLog.e(e5.getMessage());
        }
        try {
            if (this.o.a().a().b == null || this.o.a().a().b.size() <= 0 || this.o.a().e) {
                str = this.o.a().a().a;
            } else {
                sb = new StringBuilder(30);
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
                    sb.append(ba.d(this.o.a().a().b.get(i2).getValue()));
                }
                str = sb.toString();
            }
            URL url = new URL(str);
            this.o.c().a.a = str.length();
            TbConfig.getDebugSwitch();
            i = 0;
            inputStream = sb;
            r6 = url;
        } catch (Exception e6) {
            BdLog.e(e6.getMessage());
            this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + e6.getClass() + e6.getMessage();
            ak.b(this.o.a().a().a);
        }
        while (true) {
            if (!this.m && i < 5) {
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                inputStream = null;
                try {
                    try {
                        this.j = a((URL) r6);
                    } catch (Throwable th) {
                        try {
                            ak.b(this.o.a().a().a);
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
                        throw th;
                    }
                } catch (SocketException e9) {
                    e4 = e9;
                    this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.o.b().a = -12;
                    an.a.incrementAndGet();
                    com.baidu.tbadk.core.util.httpNet.g b2 = this.o.b();
                    Resources resources = this.i.getResources();
                    r7 = com.baidu.tieba.x.neterror;
                    b2.c = resources.getString(r7);
                    if (i == 0) {
                        TiebaStatic.net(this.o);
                    }
                    try {
                        ak.b(this.o.a().a().a);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Exception e10) {
                    }
                    try {
                        if (this.j == null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e11) {
                    }
                    i++;
                    inputStream = inputStream;
                    r6 = r6;
                } catch (SocketTimeoutException e12) {
                    e3 = e12;
                    an.a.incrementAndGet();
                    this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.o.b().a = -13;
                    com.baidu.tbadk.core.util.httpNet.g b3 = this.o.b();
                    Resources resources2 = this.i.getResources();
                    r7 = com.baidu.tieba.x.neterror;
                    b3.c = resources2.getString(r7);
                    if (i == 0) {
                        TiebaStatic.net(this.o);
                    }
                    try {
                        ak.b(this.o.a().a().a);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Exception e13) {
                    }
                    try {
                        if (this.j == null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e14) {
                    }
                    i++;
                    inputStream = inputStream;
                    r6 = r6;
                } catch (Exception e15) {
                    e2 = e15;
                    r7 = "|retryCount:";
                    this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.o.b().a = -10;
                    com.baidu.tbadk.core.util.httpNet.g b4 = this.o.b();
                    Resources resources3 = this.i.getResources();
                    r6 = com.baidu.tieba.x.neterror;
                    b4.c = resources3.getString(r6);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.o);
                    try {
                        ak.b(this.o.a().a().a);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Exception e16) {
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e17) {
                    }
                    i = 0;
                    this.k = 0;
                    inputStream = inputStream;
                    r6 = r6;
                    r7 = r7;
                    j = j;
                    return bArr;
                }
                if (this.j == null) {
                    throw new SocketException("network not available.");
                }
                this.j.setConnectTimeout(5000);
                this.j.setReadTimeout(30000);
                if (!this.o.a().a().d || this.o.a().a().e) {
                    r7 = r7;
                }
                this.j.setRequestProperty("Accept-Encoding", "gzip");
                r7 = "gzip";
                if (this.m) {
                    try {
                        ak.b(this.o.a().a().a);
                        if (0 != 0) {
                            inputStream.close();
                        }
                    } catch (Exception e18) {
                    }
                    try {
                        if (this.j != null) {
                            this.j.disconnect();
                        }
                    } catch (Exception e19) {
                    }
                } else {
                    r7 = new Date().getTime();
                    this.o.c().a.g = new Date().getTime() - r7;
                    this.j.connect();
                    com.baidu.adp.lib.network.http.d dVar = this.o.c().a;
                    j = (new Date().getTime() - r7) - this.o.c().a.g;
                    dVar.c = j;
                    this.o.b().a = this.j.getResponseCode();
                    if (this.o.b().a != 200) {
                        this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i;
                        an.a.incrementAndGet();
                        com.baidu.tbadk.core.util.httpNet.g b5 = this.o.b();
                        Resources resources4 = this.i.getResources();
                        r7 = com.baidu.tieba.x.neterror;
                        b5.c = resources4.getString(r7);
                        if (i == 0) {
                            TiebaStatic.net(this.o);
                        }
                        try {
                            ak.b(this.o.a().a().a);
                            if (0 != 0) {
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
                    } else if (!this.j.getContentType().contains("text/vnd.wap.wml")) {
                        j = this.j.getContentEncoding();
                        inputStream = this.j.getInputStream();
                        if (TbadkApplication.m252getInst().isMainProcess(true) && (headerField = this.j.getHeaderField("Content-Length")) != null) {
                            try {
                                int parseInt = Integer.parseInt(headerField);
                                if (parseInt > d) {
                                    ak.b(this.o.a().a().a);
                                    try {
                                        ak.b(this.o.a().a().a);
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Exception e22) {
                                    }
                                    try {
                                        e = this.j;
                                        if (e != 0) {
                                            e = this.j;
                                            e.disconnect();
                                        }
                                    } catch (Exception e23) {
                                        e = e23;
                                    }
                                    bArr = null;
                                    i = e;
                                    inputStream = inputStream;
                                    r6 = r6;
                                    r7 = r7;
                                    j = j;
                                } else {
                                    int i3 = parseInt * 10;
                                    if (i3 > 0) {
                                        BdLog.isDebugMode();
                                        if (!com.baidu.tbadk.imageManager.e.a().c(i3)) {
                                            ak.b(this.o.a().a().a);
                                            try {
                                                ak.b(this.o.a().a().a);
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                            } catch (Exception e24) {
                                            }
                                            try {
                                                e = this.j;
                                                if (e != 0) {
                                                    e = this.j;
                                                    e.disconnect();
                                                }
                                            } catch (Exception e25) {
                                                e = e25;
                                            }
                                            bArr = null;
                                            i = e;
                                            inputStream = inputStream;
                                            r6 = r6;
                                            r7 = r7;
                                            j = j;
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                            }
                            return bArr;
                        }
                        byte[] bArr2 = new byte[1024];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        int i4 = 0;
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
                                i4 = 0 + read2;
                            }
                        }
                        if (this.j != null) {
                            if ("image/gif".equalsIgnoreCase(this.j.getHeaderField("Src-Content-Type"))) {
                                this.o.b().e = true;
                            } else {
                                this.o.b().e = false;
                            }
                        }
                        while (!this.m && i4 < d && (read = inputStream.read(bArr2)) != -1) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                            i4 += read;
                        }
                        if (this.m) {
                            try {
                                ak.b(this.o.a().a().a);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } catch (Exception e26) {
                            }
                            try {
                                if (this.j != null) {
                                    this.j.disconnect();
                                }
                            } catch (Exception e27) {
                            }
                        } else {
                            this.n = i4;
                            r7 = new Date().getTime() - r7;
                            this.o.c().a.d = (r7 - this.o.c().a.c) - this.o.c().a.g;
                            if (i4 < d) {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                    if (j == 0 || !j.contains("gzip")) {
                                        bArr = byteArray;
                                        j = j;
                                    } else {
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                        j = 1024;
                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                        com.baidu.tbadk.b.b.b(byteArrayInputStream, byteArrayOutputStream2);
                                        bArr = byteArrayOutputStream2.toByteArray();
                                    }
                                } catch (SocketException e28) {
                                    bArr = byteArray;
                                    e4 = e28;
                                    this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i + "|" + e4.getClass() + "|" + e4.getMessage();
                                    this.o.b().a = -12;
                                    an.a.incrementAndGet();
                                    com.baidu.tbadk.core.util.httpNet.g b22 = this.o.b();
                                    Resources resources5 = this.i.getResources();
                                    r7 = com.baidu.tieba.x.neterror;
                                    b22.c = resources5.getString(r7);
                                    if (i == 0) {
                                    }
                                    ak.b(this.o.a().a().a);
                                    if (inputStream != null) {
                                    }
                                    if (this.j == null) {
                                    }
                                    i++;
                                    inputStream = inputStream;
                                    r6 = r6;
                                } catch (SocketTimeoutException e29) {
                                    bArr = byteArray;
                                    e3 = e29;
                                    an.a.incrementAndGet();
                                    this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i + "|" + e3.getClass() + "|" + e3.getMessage();
                                    this.o.b().a = -13;
                                    com.baidu.tbadk.core.util.httpNet.g b32 = this.o.b();
                                    Resources resources22 = this.i.getResources();
                                    r7 = com.baidu.tieba.x.neterror;
                                    b32.c = resources22.getString(r7);
                                    if (i == 0) {
                                    }
                                    ak.b(this.o.a().a().a);
                                    if (inputStream != null) {
                                    }
                                    if (this.j == null) {
                                    }
                                    i++;
                                    inputStream = inputStream;
                                    r6 = r6;
                                } catch (Exception e30) {
                                    bArr = byteArray;
                                    e2 = e30;
                                    r7 = "|retryCount:";
                                    this.o.b().d = String.valueOf(String.valueOf(this.o.b().a)) + "|retryCount:" + i + "|" + e2.getClass() + "|" + e2.getMessage();
                                    this.o.b().a = -10;
                                    com.baidu.tbadk.core.util.httpNet.g b42 = this.o.b();
                                    Resources resources32 = this.i.getResources();
                                    r6 = com.baidu.tieba.x.neterror;
                                    b42.c = resources32.getString(r6);
                                    BdLog.e(e2.getMessage());
                                    TiebaStatic.net(this.o);
                                    ak.b(this.o.a().a().a);
                                    if (inputStream != null) {
                                    }
                                    if (this.j != null) {
                                    }
                                    i = 0;
                                    this.k = 0;
                                    inputStream = inputStream;
                                    r6 = r6;
                                    r7 = r7;
                                    j = j;
                                    return bArr;
                                }
                            } else {
                                this.o.b().a = -11;
                                com.baidu.tbadk.core.util.httpNet.g b6 = this.o.b();
                                Resources resources6 = this.i.getResources();
                                int i5 = com.baidu.tieba.x.data_too_big;
                                b6.c = resources6.getString(i5);
                                j = i5;
                            }
                            this.o.c().a.e = i + 1;
                            this.o.c().a.f = r7;
                            ao aoVar = new ao();
                            aoVar.e = a(b(this.i));
                            aoVar.c = this.n;
                            aoVar.b = r7;
                            aoVar.d = i + 1;
                            aoVar.a = 2;
                            an.a(aoVar);
                            TiebaStatic.net(this.o);
                            try {
                                ak.b(this.o.a().a().a);
                                if (inputStream != null) {
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
                        }
                    } else if (this.k < 1) {
                        this.j.disconnect();
                        this.k++;
                        this.o.b().a = 0;
                        i--;
                        try {
                            ak.b(this.o.a().a().a);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e33) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e34) {
                        }
                    } else {
                        try {
                            ak.b(this.o.a().a().a);
                            if (0 != 0) {
                                inputStream.close();
                            }
                        } catch (Exception e35) {
                        }
                        try {
                            if (this.j != null) {
                                this.j.disconnect();
                            }
                        } catch (Exception e36) {
                        }
                    }
                    i++;
                    inputStream = inputStream;
                    r6 = r6;
                }
            }
            i = 0;
            this.k = 0;
            inputStream = inputStream;
            r6 = r6;
            r7 = r7;
            j = j;
            return bArr;
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
                    this.o.b().c = this.i.getString(com.baidu.tieba.x.error_unkown_try_again);
                } else if (this.o.b().b != 0) {
                    this.o.b().c = errorData.getError_msg();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                this.o.b().c = this.i.getString(com.baidu.tieba.x.error_unkown_try_again);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.v
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
            BdLog.e(e2.getMessage());
            return str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1030=12, 1031=12, 1032=12, 1037=12, 1038=12, 1040=4] */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x03aa, code lost:
        com.baidu.tbadk.core.util.ak.b(r14.o.a().a().a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x03b9, code lost:
        if (0 == 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x03bb, code lost:
        r3.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0633 A[Catch: Exception -> 0x0642, TRY_LEAVE, TryCatch #33 {Exception -> 0x0642, blocks: (B:217:0x0622, B:219:0x0633), top: B:319:0x0622 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x063a A[Catch: Exception -> 0x0640, TRY_LEAVE, TryCatch #25 {Exception -> 0x0640, blocks: (B:220:0x0636, B:222:0x063a), top: B:303:0x0636 }] */
    @Override // com.baidu.tbadk.core.util.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d() {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        SocketTimeoutException socketTimeoutException;
        InputStream inputStream3;
        SocketException socketException;
        URL url;
        byte[] bArr;
        int read;
        StringBuilder sb = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        try {
            int a2 = ak.a(this.o.a().a().a);
            if (a2 > 0) {
                ak.a().a(a2);
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
                sb.append(ba.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.o.a().a().f) {
            sb2.append("tiebaclient!!!");
            String a3 = ba.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a3);
        }
        String sb3 = sb.toString();
        this.o.c().a.a = sb3.length();
        TbConfig.getDebugSwitch();
        int i3 = 0;
        boolean z = true;
        String str = null;
        while (true) {
            if (this.m || !z || i3 >= 5) {
                break;
            }
            InputStream inputStream4 = null;
            try {
                try {
                    url = new URL(this.o.a().a().a);
                    this.j = a(url);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ak.b(this.o.a().a().a);
                        if (inputStream4 != null) {
                            inputStream4.close();
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
                inputStream3 = null;
                socketException = e5;
            } catch (SocketTimeoutException e6) {
                inputStream2 = null;
                socketTimeoutException = e6;
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
            }
            if (this.j == null) {
                this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
                try {
                    ak.b(this.o.a().a().a);
                    if (0 != 0) {
                        inputStream4.close();
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
                        ak.b(this.o.a().a().a);
                        if (0 != 0) {
                            inputStream4.close();
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
                            an.a.incrementAndGet();
                            z = true;
                            this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
                            if (i3 == 0) {
                                TiebaStatic.net(this.o);
                            }
                            try {
                                ak.b(this.o.a().a().a);
                                if (0 != 0) {
                                    inputStream4.close();
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
                            byte[] bArr2 = new byte[1024];
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                            int i4 = 0;
                            while (!this.m && (read = inputStream5.read(bArr2)) != -1) {
                                byteArrayOutputStream.write(bArr2, 0, read);
                                i4 += read;
                            }
                            inputStream5.close();
                            this.j.disconnect();
                            if (this.m) {
                                try {
                                    ak.b(this.o.a().a().a);
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
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                    bArr = byteArray;
                                } else {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                    com.baidu.tbadk.b.b.b(byteArrayInputStream, byteArrayOutputStream2);
                                    bArr = byteArrayOutputStream2.toByteArray();
                                }
                                String str2 = new String(bArr, 0, bArr.length, o());
                                try {
                                    if (this.o.a().a().f && this.o.a().a().g) {
                                        a(str2);
                                    }
                                    this.o.c().a.e = i3 + 1;
                                    this.o.c().a.f = time2;
                                    ao aoVar = new ao();
                                    aoVar.e = a(b(this.i));
                                    aoVar.c = this.n;
                                    aoVar.b = time2;
                                    aoVar.d = i3 + 1;
                                    aoVar.a = 1;
                                    an.a(aoVar);
                                    TiebaStatic.net(this.o);
                                    try {
                                        ak.b(this.o.a().a().a);
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
                                    inputStream3 = inputStream5;
                                    socketException = e17;
                                    str = str2;
                                    an.a.incrementAndGet();
                                    this.o.b().a = -12;
                                    z = true;
                                    this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
                                    BdLog.e(socketException.getMessage());
                                    if (i3 == 0) {
                                        TiebaStatic.net(this.o);
                                    }
                                    try {
                                        ak.b(this.o.a().a().a);
                                        if (inputStream3 != null) {
                                            inputStream3.close();
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
                                    inputStream2 = inputStream5;
                                    socketTimeoutException = e20;
                                    str = str2;
                                    try {
                                        an.a.incrementAndGet();
                                        this.o.b().a = -13;
                                        z = true;
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
                                        BdLog.e(socketTimeoutException.getMessage());
                                        if (i3 == 0) {
                                            TiebaStatic.net(this.o);
                                        }
                                        try {
                                            ak.b(this.o.a().a().a);
                                            if (inputStream2 != null) {
                                                inputStream2.close();
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
                                        inputStream4 = inputStream2;
                                        ak.b(this.o.a().a().a);
                                        if (inputStream4 != null) {
                                        }
                                        if (this.j != null) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th5) {
                                    inputStream = inputStream5;
                                    th = th5;
                                    str = str2;
                                    this.o.b().a = -10;
                                    z = false;
                                    this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
                                    BdLog.e(th.getMessage());
                                    TiebaStatic.net(this.o);
                                    try {
                                        ak.b(this.o.a().a().a);
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
                                    i3++;
                                }
                            }
                        } catch (SocketException e25) {
                            inputStream3 = inputStream5;
                            socketException = e25;
                        } catch (SocketTimeoutException e26) {
                            inputStream2 = inputStream5;
                            socketTimeoutException = e26;
                        } catch (Throwable th6) {
                            inputStream = inputStream5;
                            th = th6;
                        }
                    } else if (this.k < 1) {
                        this.j.disconnect();
                        this.k++;
                        this.o.b().a = 0;
                        i3--;
                        try {
                            ak.b(this.o.a().a().a);
                            if (0 != 0) {
                                inputStream4.close();
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
                            ak.b(this.o.a().a().a);
                            if (0 != 0) {
                                inputStream4.close();
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
        this.k = 0;
        return str;
        return null;
        try {
            if (this.j != null) {
                this.j.disconnect();
            }
        } catch (Exception e31) {
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1232=11, 1233=11, 1238=11, 1239=11, 1244=11, 1245=11, 1249=11, 1250=11] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0369 A[Catch: all -> 0x0564, TRY_LEAVE, TryCatch #17 {all -> 0x0564, blocks: (B:41:0x00fd, B:43:0x010b, B:45:0x011d, B:76:0x0222, B:78:0x0236, B:79:0x023b, B:47:0x0121, B:49:0x0125, B:51:0x0133, B:52:0x0147, B:97:0x02e0, B:100:0x02f8, B:54:0x014d, B:56:0x017b, B:57:0x018a, B:59:0x019c, B:60:0x01a2, B:62:0x01ae, B:64:0x01f6, B:117:0x038d, B:119:0x039c, B:121:0x03a1, B:123:0x03ae, B:186:0x04b6, B:104:0x0348, B:106:0x0369, B:144:0x03f7), top: B:324:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0377 A[Catch: Exception -> 0x0585, TRY_LEAVE, TryCatch #13 {Exception -> 0x0585, blocks: (B:109:0x0373, B:111:0x0377), top: B:316:0x0373 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04ea A[Catch: Exception -> 0x056a, TRY_LEAVE, TryCatch #2 {Exception -> 0x056a, blocks: (B:189:0x04e6, B:191:0x04ea), top: B:308:0x04e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x050b A[Catch: Exception -> 0x055e, TRY_LEAVE, TryCatch #6 {Exception -> 0x055e, blocks: (B:201:0x0507, B:203:0x050b), top: B:310:0x0507 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0512 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0504 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0370 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x02d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x02c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x04f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x04e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:358:0x037e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x021b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x021b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:400:0x021b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02bc A[Catch: all -> 0x0560, TRY_LEAVE, TryCatch #14 {all -> 0x0560, blocks: (B:84:0x029c, B:86:0x02bc), top: B:318:0x029c }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02ca A[Catch: Exception -> 0x059f, TRY_LEAVE, TryCatch #27 {Exception -> 0x059f, blocks: (B:89:0x02c6, B:91:0x02ca), top: B:338:0x02c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02d8  */
    @Override // com.baidu.tbadk.core.util.v
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
                this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
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
                        an.a.incrementAndGet();
                        this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
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
                                    long time2 = new Date().getTime() - time;
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                        bArr = byteArray;
                                    } else {
                                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                                        com.baidu.tbadk.b.b.b(byteArrayInputStream, byteArrayOutputStream2);
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
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
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
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
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
                                        this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
                                        BdLog.e(e2.getMessage());
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
                                this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
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
                            this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
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
                            this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
                            BdLog.e(e2.getMessage());
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1408=8, 1413=8, 1414=8, 1399=8, 1401=8, 1402=8, 1407=8] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02dd A[Catch: Exception -> 0x0310, TRY_LEAVE, TryCatch #18 {Exception -> 0x0310, blocks: (B:160:0x02d9, B:162:0x02dd), top: B:246:0x02d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x02e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x02d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tbadk.core.util.v
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
                this.j.setConnectTimeout(5000);
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
                File g2 = s.g(str);
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
                        this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
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
                            i4 = com.baidu.adp.lib.e.c.a(headerField2.substring(indexOf + 1), 0);
                        }
                        int a3 = (i4 == 0 && this.o.b().a == 200 && (headerField = this.j.getHeaderField("Content-Length")) != null) ? com.baidu.adp.lib.e.c.a(headerField, 0) : i4;
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
                                this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.FileWriteError);
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
                            this.o.b().c = this.i.getResources().getString(com.baidu.tieba.x.neterror);
                            BdLog.e(e2.getMessage());
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

    @Override // com.baidu.tbadk.core.util.v
    public ArrayList<BasicNameValuePair> a() {
        return this.o.a().a().b;
    }

    @Override // com.baidu.tbadk.core.util.v
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

    @Override // com.baidu.tbadk.core.util.v
    public void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.v
    public void a(String str, byte[] bArr) {
        if (this.o.a().a().c == null) {
            this.o.a().a().c = new HashMap<>();
        }
        this.o.a().a().c.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.v
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

    public static NetworkStateInfo b(Context context) {
        NetworkStateInfo networkStateInfo;
        NetworkStateInfo networkStateInfo2 = NetworkStateInfo.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkStateInfo = NetworkStateInfo.UNAVAIL;
            } else if (activeNetworkInfo.getType() == 1) {
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
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
                    case DealIntentService.CLASS_TYPE_GROUP_EVENT /* 14 */:
                    case 15:
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                }
            }
            return networkStateInfo;
        } catch (Exception e2) {
            return networkStateInfo2;
        }
    }

    private void b(URL url) {
        try {
            InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }
}
