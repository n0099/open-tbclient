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
/* loaded from: classes14.dex */
class n implements j {

    /* loaded from: classes14.dex */
    private static class a {
        private static a asL;

        /* renamed from: b  reason: collision with root package name */
        private static HashMap<String, Integer> f2395b = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.baidu.helios.a.a.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static class C0119a {

            /* renamed from: a  reason: collision with root package name */
            private String f2396a;

            /* renamed from: b  reason: collision with root package name */
            private String f2397b;
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
                        this.f2396a = lowerCase;
                        this.f2397b = "10.0.0.172";
                        this.c = "80";
                        return;
                    } else if (lowerCase.startsWith("ctwap")) {
                        this.d = true;
                        this.f2396a = lowerCase;
                        this.f2397b = "10.0.0.200";
                        this.c = "80";
                        return;
                    } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                        this.d = false;
                        this.f2396a = lowerCase;
                        return;
                    }
                }
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost == null || defaultHost.length() <= 0) {
                    this.d = false;
                    return;
                }
                this.f2397b = defaultHost;
                if ("10.0.0.172".equals(this.f2397b.trim())) {
                    this.d = true;
                    this.c = "80";
                } else if ("10.0.0.200".equals(this.f2397b.trim())) {
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
                        this.e = this.f2396a;
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
            f2395b.put("WIFI", 1);
            f2395b.put("3GNET", 21);
            f2395b.put("3GWAP", 22);
            f2395b.put("CMNET", 31);
            f2395b.put("UNINET", 32);
            f2395b.put("CTNET", 33);
            f2395b.put("CMWAP", 41);
            f2395b.put("UNIWAP", 42);
            f2395b.put("CTWAP", 43);
            asL = new a();
        }

        private a() {
        }

        public static a vb() {
            return asL;
        }

        public String a(Context context) {
            C0119a c0119a = new C0119a(context);
            String g = c0119a.g();
            int e = c0119a.e();
            if (TextUtils.isEmpty(g)) {
                return ((Object) 5) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e;
            }
            Integer num = f2395b.get(g.toUpperCase());
            if (num == null) {
                num = 5;
            }
            return num + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + e;
        }
    }

    /* loaded from: classes14.dex */
    private static class b {
        private static b asM = new b();

        /* renamed from: b  reason: collision with root package name */
        private String f2398b;
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

        public static b vc() {
            return asM;
        }

        public String a(Context context) {
            synchronized (b.class) {
                if (TextUtils.isEmpty(this.f2398b)) {
                    this.f2398b = b(context);
                }
            }
            return this.f2398b;
        }
    }

    /* loaded from: classes14.dex */
    private static class c {
        private static c asN = new c();

        /* renamed from: a  reason: collision with root package name */
        private String f2399a;

        /* renamed from: b  reason: collision with root package name */
        private String f2400b;
        private String c;
        private String d;

        private c() {
            c();
        }

        private void c() {
            this.f2399a = Build.MODEL;
            if (TextUtils.isEmpty(this.f2399a)) {
                this.f2399a = "NUL";
            } else {
                this.f2399a = this.f2399a.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
            this.f2400b = Build.MANUFACTURER;
            if (TextUtils.isEmpty(this.f2400b)) {
                this.f2400b = "NUL";
            } else {
                this.f2400b = this.f2400b.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
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
            String str = this.f2399a;
            String str2 = this.c;
            int i = Build.VERSION.SDK_INT;
            return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.f2400b;
        }

        public static c vd() {
            return asN;
        }

        public String b() {
            return this.d;
        }
    }

    @Override // com.baidu.helios.a.a.j
    public String a() {
        return c.vd().b();
    }

    @Override // com.baidu.helios.a.a.j
    public String a(Context context) {
        return b.vc().a(context);
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
        return com.baidu.helios.b.aj(context).uD();
    }

    @Override // com.baidu.helios.a.a.j
    public String d(Context context) {
        return a.vb().a(context);
    }
}
