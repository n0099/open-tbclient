package com.baidu.android.nebula.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
/* loaded from: classes.dex */
public class h {
    private static final String a = h.class.getSimpleName();
    private String b;
    private String c;
    private String d;
    private boolean e;
    private String f;

    public h(Context context) {
        b(context);
    }

    private void a(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                this.e = true;
                this.b = lowerCase;
                this.c = "10.0.0.172";
                this.d = "80";
                return;
            } else if (lowerCase.startsWith("ctwap")) {
                this.e = true;
                this.b = lowerCase;
                this.c = "10.0.0.200";
                this.d = "80";
                return;
            } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                this.e = false;
                this.b = lowerCase;
                return;
            }
        }
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost == null || defaultHost.length() <= 0) {
            this.e = false;
            return;
        }
        this.c = defaultHost;
        if ("10.0.0.172".equals(this.c.trim())) {
            this.e = true;
            this.d = "80";
        } else if ("10.0.0.200".equals(this.c.trim())) {
            this.e = true;
            this.d = "80";
        } else {
            this.e = false;
            this.d = Integer.toString(defaultPort);
        }
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    private void b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if ("wifi".equals(activeNetworkInfo.getTypeName().toLowerCase())) {
                this.f = "wifi";
                this.e = false;
                return;
            }
            a(context, activeNetworkInfo);
            this.f = this.b;
        }
    }

    public boolean a() {
        return this.e;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.f;
    }
}
