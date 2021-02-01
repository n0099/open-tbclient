package com.baidu.helios.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
/* loaded from: classes6.dex */
class n implements j {

    /* loaded from: classes6.dex */
    private static class a {
        private static a asB;

        /* renamed from: b  reason: collision with root package name */
        private static HashMap<String, Integer> f2393b = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.helios.a.a.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0119a {

            /* renamed from: a  reason: collision with root package name */
            private String f2394a;

            /* renamed from: b  reason: collision with root package name */
            private String f2395b;
            private String c;
            private boolean d;
            private String e;
            private int f;
            private String g;

            public C0119a(Context context) {
                c(context);
            }

            private void a(Context context, NetworkInfo networkInfo) {
                String lowerCase;
                if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                    if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                        this.d = true;
                        this.f2394a = lowerCase;
                        this.f2395b = "10.0.0.172";
                        this.c = "80";
                        return;
                    } else if (lowerCase.startsWith("ctwap")) {
                        this.d = true;
                        this.f2394a = lowerCase;
                        this.f2395b = "10.0.0.200";
                        this.c = "80";
                        return;
                    } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                        this.d = false;
                        this.f2394a = lowerCase;
                        return;
                    }
                }
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost == null || defaultHost.length() <= 0) {
                    this.d = false;
                    return;
                }
                this.f2395b = defaultHost;
                if ("10.0.0.172".equals(this.f2395b.trim())) {
                    this.d = true;
                    this.c = "80";
                } else if ("10.0.0.200".equals(this.f2395b.trim())) {
                    this.d = true;
                    this.c = "80";
                } else {
                    this.d = false;
                    this.c = Integer.toString(defaultPort);
                }
            }

            @SuppressLint({"MissingPermission"})
            private void c(Context context) {
                NetworkInfo networkInfo;
                try {
                    networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (Exception e) {
                    networkInfo = null;
                }
                if (networkInfo != null) {
                    if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                        this.e = "wifi";
                        this.d = false;
                    } else {
                        a(context, networkInfo);
                        this.e = this.f2394a;
                    }
                    this.f = networkInfo.getSubtype();
                    this.g = networkInfo.getSubtypeName();
                }
            }

            public int e() {
                return this.f;
            }

            public String g() {
                return this.e;
            }
        }

        static {
            f2393b.put("WIFI", 1);
            f2393b.put("3GNET", 21);
            f2393b.put("3GWAP", 22);
            f2393b.put("CMNET", 31);
            f2393b.put("UNINET", 32);
            f2393b.put("CTNET", 33);
            f2393b.put("CMWAP", 41);
            f2393b.put("UNIWAP", 42);
            f2393b.put("CTWAP", 43);
            asB = new a();
        }

        private a() {
        }

        public static a uY() {
            return asB;
        }

        public String a(Context context) {
            C0119a c0119a = new C0119a(context);
            String g = c0119a.g();
            int e = c0119a.e();
            if (TextUtils.isEmpty(g)) {
                return ((Object) 5) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e;
            }
            Integer num = f2393b.get(g.toUpperCase());
            if (num == null) {
                num = 5;
            }
            return num + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e;
        }
    }

    /* loaded from: classes6.dex */
    private static class b {
        private static b asC = new b();

        /* renamed from: b  reason: collision with root package name */
        private String f2396b;
        private DisplayMetrics c;

        private b() {
        }

        private String b(Context context) {
            int d = d(context.getApplicationContext());
            int e = e(context.getApplicationContext());
            int f = f(context.getApplicationContext());
            String c = c(context.getApplicationContext());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(d);
            stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            stringBuffer.append(e);
            stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            stringBuffer.append(HttpConstants.OS_TYPE_VALUE);
            stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            stringBuffer.append(c);
            stringBuffer.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            stringBuffer.append(f);
            return stringBuffer.toString();
        }

        private static String c(Context context) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "0.8";
            }
        }

        private int d(Context context) {
            g(context);
            if (this.c != null) {
                return this.c.widthPixels;
            }
            return 0;
        }

        private int e(Context context) {
            g(context);
            if (this.c != null) {
                return this.c.heightPixels;
            }
            return 0;
        }

        private int f(Context context) {
            g(context);
            if (this.c != null) {
                return this.c.densityDpi;
            }
            return 0;
        }

        private void g(Context context) {
            if (context != null && this.c == null) {
                this.c = context.getResources().getDisplayMetrics();
            }
        }

        public static b uZ() {
            return asC;
        }

        public String a(Context context) {
            synchronized (b.class) {
                if (TextUtils.isEmpty(this.f2396b)) {
                    this.f2396b = b(context);
                }
            }
            return this.f2396b;
        }
    }

    /* loaded from: classes6.dex */
    private static class c {
        private static c asD = new c();

        /* renamed from: a  reason: collision with root package name */
        private String f2397a;

        /* renamed from: b  reason: collision with root package name */
        private String f2398b;
        private String c;
        private String d;

        private c() {
            c();
        }

        private void c() {
            this.f2397a = Build.MODEL;
            if (TextUtils.isEmpty(this.f2397a)) {
                this.f2397a = "NUL";
            } else {
                this.f2397a = this.f2397a.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
            this.f2398b = Build.MANUFACTURER;
            if (TextUtils.isEmpty(this.f2398b)) {
                this.f2398b = "NUL";
            } else {
                this.f2398b = this.f2398b.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
            this.c = Build.VERSION.RELEASE;
            if (TextUtils.isEmpty(this.c)) {
                this.c = "0.0";
            } else {
                this.c = this.c.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
            this.d = d();
        }

        private String d() {
            String str = this.f2397a;
            String str2 = this.c;
            int i = Build.VERSION.SDK_INT;
            return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.f2398b;
        }

        public static c va() {
            return asD;
        }

        public String b() {
            return this.d;
        }
    }

    @Override // com.baidu.helios.a.a.j
    public String a() {
        return c.va().b();
    }

    @Override // com.baidu.helios.a.a.j
    public String a(Context context) {
        return b.uZ().a(context);
    }

    @Override // com.baidu.helios.a.a.j
    public long b() {
        return System.currentTimeMillis();
    }

    @Override // com.baidu.helios.a.a.j
    public String b(Context context) {
        return (context == null || context.getApplicationContext() == null) ? "" : context.getApplicationContext().getPackageName();
    }

    @Override // com.baidu.helios.a.a.j
    public String c(Context context) {
        return com.baidu.helios.b.aj(context).uA();
    }

    @Override // com.baidu.helios.a.a.j
    public String d(Context context) {
        return a.uY().a(context);
    }
}
