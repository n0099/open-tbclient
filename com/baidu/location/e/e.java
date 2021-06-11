package com.baidu.location.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.webkit.internal.ConectivityUtils;
import java.util.Map;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: h  reason: collision with root package name */
    public String f6750h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f6751i = 1;
    public String j = null;
    public Map<String, Object> k = null;
    public String l = null;
    public byte[] m = null;
    public byte[] n = null;
    public String o = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f6749g = a.f6716g;

    /* renamed from: a  reason: collision with root package name */
    public static String f6747a = "10.0.0.172";

    /* renamed from: b  reason: collision with root package name */
    public static int f6748b = 80;
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
                f6747a = str2;
                return a.f6713d;
            } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                String defaultHost2 = Proxy.getDefaultHost();
                if (defaultHost2 != null && !defaultHost2.equals("") && !defaultHost2.equals(StringUtil.NULL_STRING)) {
                    str = defaultHost2;
                }
                f6747a = str;
                return a.f6713d;
            } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                return a.f6714e;
            }
        }
        String defaultHost3 = Proxy.getDefaultHost();
        if (defaultHost3 != null && defaultHost3.length() > 0) {
            if (!"10.0.0.172".equals(defaultHost3.trim())) {
            }
            f6747a = str2;
            return a.f6713d;
        }
        return a.f6714e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        f6749g = c();
    }

    private int c() {
        Context serviceContext = com.baidu.location.f.getServiceContext();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) serviceContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                return a.f6716g;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getType() == 1) {
                    String defaultHost = Proxy.getDefaultHost();
                    return (defaultHost == null || defaultHost.length() <= 0) ? a.f6715f : a.f6717h;
                }
                return a(serviceContext, activeNetworkInfo);
            }
            return a.f6716g;
        } catch (Exception unused) {
            return a.f6716g;
        }
    }

    public abstract void a();

    public void a(ExecutorService executorService) {
        try {
            executorService.execute(new f(this));
        } catch (Throwable unused) {
            a(false);
        }
    }

    public void a(ExecutorService executorService, String str) {
        try {
            executorService.execute(new i(this, str));
        } catch (Throwable unused) {
            a(false);
        }
    }

    public void a(ExecutorService executorService, boolean z, String str) {
        try {
            executorService.execute(new g(this, str, z));
        } catch (Throwable unused) {
            a(false);
        }
    }

    public abstract void a(boolean z);

    public void b(String str) {
        try {
            new h(this, str).start();
        } catch (Throwable unused) {
            a(false);
        }
    }

    public void b(ExecutorService executorService) {
        a(executorService, false, "loc.map.baidu.com");
    }
}
