package com.baidu.location.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.webkit.net.BdNetEngine;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class e {
    public String h = null;
    public int i = 3;
    public String j = null;
    public Map<String, Object> k = null;
    public String l = null;
    public byte[] m = null;
    public byte[] n = null;
    public String o = null;
    public static int g = a.g;
    private static String a = BdNetEngine.URI_PROXY_CMWAP;
    private static int b = 80;
    protected static int p = 0;

    private static int a(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        if (networkInfo != null && networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                String defaultHost = Proxy.getDefaultHost();
                if (defaultHost == null || defaultHost.equals("") || defaultHost.equals("null")) {
                    defaultHost = BdNetEngine.URI_PROXY_CMWAP;
                }
                a = defaultHost;
                return a.d;
            } else if (lowerCase.startsWith("ctwap")) {
                String defaultHost2 = Proxy.getDefaultHost();
                if (defaultHost2 == null || defaultHost2.equals("") || defaultHost2.equals("null")) {
                    defaultHost2 = BdNetEngine.URI_PROXY_CTWAP;
                }
                a = defaultHost2;
                return a.d;
            } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                return a.e;
            }
        }
        String defaultHost3 = Proxy.getDefaultHost();
        if (defaultHost3 != null && defaultHost3.length() > 0) {
            if (BdNetEngine.URI_PROXY_CMWAP.equals(defaultHost3.trim())) {
                a = BdNetEngine.URI_PROXY_CMWAP;
                return a.d;
            } else if (BdNetEngine.URI_PROXY_CTWAP.equals(defaultHost3.trim())) {
                a = BdNetEngine.URI_PROXY_CTWAP;
                return a.d;
            }
        }
        return a.e;
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
                i = a.g;
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    i = a.g;
                } else if (activeNetworkInfo.getType() == 1) {
                    String defaultHost = Proxy.getDefaultHost();
                    i = (defaultHost == null || defaultHost.length() <= 0) ? a.f : a.h;
                } else {
                    i = a(serviceContext, activeNetworkInfo);
                }
            }
            return i;
        } catch (Exception e) {
            return a.g;
        }
    }

    public abstract void a();

    public abstract void a(boolean z);

    public void a(boolean z, String str) {
        new g(this, str, z).start();
    }

    public void b(String str) {
        new h(this, str).start();
    }

    public void d() {
        new f(this).start();
    }

    public void e() {
        a(false, "loc.map.baidu.com");
    }
}
