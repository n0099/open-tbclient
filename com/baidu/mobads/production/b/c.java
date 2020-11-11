package com.baidu.mobads.production.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobstat.Config;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Set<String> f2396a;
    private Set<String> b;
    private Set<String> c;
    private CookieManager d;
    private IXAdSystemUtils e;
    private IXAdCommonUtils f;
    private Context g;
    private int h;
    private String i;
    private String j;

    public c(Context context, int i, String str) {
        this.e = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        this.f = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        this.g = context;
        this.h = i;
        this.i = str;
        this.j = null;
        b();
        c();
    }

    public c(Context context, String str, String str2) {
        this.e = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        this.f = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        this.g = context;
        this.j = str;
        this.i = str2;
        this.h = -1;
        b();
        c();
    }

    private void b() {
        try {
            CookieSyncManager.createInstance(this.g);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            this.d = CookieManager.getInstance();
            this.d.setAcceptCookie(true);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public String a() {
        d();
        return this.j != null ? "https://cpu.baidu.com/block/app/" + this.i + "/" + this.j : "https://cpu.baidu.com/" + this.h + "/" + this.i;
    }

    private void c() {
        this.f2396a = new HashSet();
        this.f2396a.add("46000");
        this.f2396a.add("46002");
        this.f2396a.add("46007");
        this.b = new HashSet();
        this.b.add("46001");
        this.b.add("46006");
        this.c = new HashSet();
        this.c.add("46003");
        this.c.add("46005");
    }

    private void d() {
        Rect screenRect = this.f.getScreenRect(this.g);
        int height = screenRect.height();
        int width = screenRect.width();
        boolean e = e();
        String a2 = e ? a(h()) : null;
        int f = e ? f() : 0;
        String g = e ? g() : null;
        int i = e ? 1 : 0;
        String cuid = this.e.getCUID(this.g);
        a("v", i());
        a("im", this.e.getIMEI(this.g));
        a("aid", this.e.getAndroidId(this.g));
        a("m", a(this.e.getMacAddress(this.g)));
        a("cuid", cuid);
        a(Config.EXCEPTION_CRASH_TYPE, Integer.valueOf(a.a(this.g)));
        a("oi", Integer.valueOf(j()));
        a("src", 1);
        a("h", Integer.valueOf(height));
        a("w", Integer.valueOf(width));
        a("apm", a2);
        a("rssi", Integer.valueOf(f));
        a("apn", g);
        a("isc", Integer.valueOf(i));
    }

    private void a(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(ETAG.EQUAL);
        stringBuffer.append(obj);
        stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        try {
            this.d.setCookie("https://cpu.baidu.com/", stringBuffer.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean e() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.g.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private int f() {
        try {
            WifiInfo connectionInfo = ((WifiManager) this.g.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null) {
                return 0;
            }
            return connectionInfo.getRssi();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private String g() {
        try {
            WifiInfo connectionInfo = ((WifiManager) this.g.getSystemService("wifi")).getConnectionInfo();
            String ssid = connectionInfo == null ? "" : connectionInfo.getSSID();
            if (ssid.startsWith("\"") && ssid.endsWith("\"")) {
                return ssid.substring(1, ssid.length() - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private String h() {
        try {
            WifiInfo connectionInfo = ((WifiManager) this.g.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null) {
                return null;
            }
            return connectionInfo.getMacAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String i() {
        String str = null;
        try {
            PackageInfo packageInfo = this.g.getPackageManager().getPackageInfo(this.g.getPackageName(), 0);
            String str2 = packageInfo == null ? null : packageInfo.versionName;
            if (str2 != null) {
                str = str2.replace(".", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                return str;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return str;
        }
    }

    private int j() {
        String networkOperator = this.e.getNetworkOperator(this.g);
        if (networkOperator == null) {
            return 0;
        }
        if (this.f2396a.contains(networkOperator)) {
            return 1;
        }
        if (this.c.contains(networkOperator)) {
            return 2;
        }
        if (this.b.contains(networkOperator)) {
            return 3;
        }
        return 99;
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(":", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }
}
