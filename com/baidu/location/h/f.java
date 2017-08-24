package com.baidu.location.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class f {
    public String h = null;
    public int i = 3;
    public String j = null;
    public Map<String, Object> k = null;
    public String l = null;
    public byte[] m = null;
    public String n = null;
    public static int g = b.g;
    private static String a = "10.0.0.172";
    private static int b = 80;
    protected static int o = 0;

    private static int b(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        if (networkInfo != null && networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                String defaultHost = Proxy.getDefaultHost();
                a = (defaultHost == null || defaultHost.equals("") || defaultHost.equals("null")) ? "10.0.0.172" : "10.0.0.172";
                return b.d;
            } else if (lowerCase.startsWith("ctwap")) {
                String defaultHost2 = Proxy.getDefaultHost();
                a = (defaultHost2 == null || defaultHost2.equals("") || defaultHost2.equals("null")) ? "10.0.0.200" : "10.0.0.200";
                return b.d;
            } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                return b.e;
            }
        }
        String defaultHost3 = Proxy.getDefaultHost();
        if (defaultHost3 != null && defaultHost3.length() > 0) {
            if ("10.0.0.172".equals(defaultHost3.trim())) {
                a = "10.0.0.172";
                return b.d;
            } else if ("10.0.0.200".equals(defaultHost3.trim())) {
                a = "10.0.0.200";
                return b.d;
            }
        }
        return b.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        g = c();
    }

    private int c() {
        int i;
        Context serviceContext = com.baidu.location.f.getServiceContext();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) serviceContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                i = b.g;
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    i = b.g;
                } else if (activeNetworkInfo.getType() == 1) {
                    String defaultHost = Proxy.getDefaultHost();
                    i = (defaultHost == null || defaultHost.length() <= 0) ? b.f : b.h;
                } else {
                    i = b(serviceContext, activeNetworkInfo);
                }
            }
            return i;
        } catch (Exception e) {
            return b.g;
        }
    }

    public abstract void a();

    public abstract void a(boolean z);

    public void b(boolean z) {
        new k(this, z).start();
    }

    public void d() {
        new j(this).start();
    }

    public void e() {
        b(false);
    }
}
