package com.baidu.location.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.webkit.internal.ConectivityUtils;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: h  reason: collision with root package name */
    public String f6741h = null;
    public int i = 3;
    public String j = null;
    public Map<String, Object> k = null;
    public String l = null;
    public byte[] m = null;
    public byte[] n = null;
    public String o = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f6740g = a.f6710g;

    /* renamed from: a  reason: collision with root package name */
    public static String f6738a = "10.0.0.172";

    /* renamed from: b  reason: collision with root package name */
    public static int f6739b = 80;
    public static int p = 0;

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ad, code lost:
        if ("10.0.0.200".equals(r5.trim()) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        String str = "10.0.0.200";
        String str2 = "10.0.0.172";
        if (networkInfo != null && networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
            if (lowerCase.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                String defaultHost = Proxy.getDefaultHost();
                if (defaultHost != null && !defaultHost.equals("") && !defaultHost.equals(StringUtil.NULL_STRING)) {
                    str2 = defaultHost;
                }
                f6738a = str2;
                return a.f6707d;
            } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                String defaultHost2 = Proxy.getDefaultHost();
                if (defaultHost2 != null && !defaultHost2.equals("") && !defaultHost2.equals(StringUtil.NULL_STRING)) {
                    str = defaultHost2;
                }
                f6738a = str;
                return a.f6707d;
            } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                return a.f6708e;
            }
        }
        String defaultHost3 = Proxy.getDefaultHost();
        if (defaultHost3 != null && defaultHost3.length() > 0) {
            if (!"10.0.0.172".equals(defaultHost3.trim())) {
            }
            f6738a = str2;
            return a.f6707d;
        }
        return a.f6708e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        f6740g = c();
    }

    private int c() {
        Context serviceContext = com.baidu.location.f.getServiceContext();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) serviceContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                return a.f6710g;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getType() == 1) {
                    String defaultHost = Proxy.getDefaultHost();
                    return (defaultHost == null || defaultHost.length() <= 0) ? a.f6709f : a.f6711h;
                }
                return a(serviceContext, activeNetworkInfo);
            }
            return a.f6710g;
        } catch (Exception unused) {
            return a.f6710g;
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
