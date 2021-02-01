package com.baidu.mobads.production.cpu;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiContext;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Set<String> f3441a;

    /* renamed from: b  reason: collision with root package name */
    private Set<String> f3442b;
    private Set<String> c;
    private CookieManager d;
    private IXAdSystemUtils e;
    private IXAdCommonUtils f;
    private Context g;
    private int h;
    private String i;
    private String j;
    private String k;

    public d(Context context, int i, String str) {
        this.e = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        this.f = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        this.g = context;
        this.h = i;
        this.i = str;
        this.j = null;
        b();
        c();
    }

    public d(Context context, String str, String str2) {
        this.e = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        this.f = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        this.g = context;
        this.j = str;
        this.i = str2;
        this.h = -1;
        b();
        c();
    }

    public void a(String str) {
        this.k = str;
    }

    private void b() {
        try {
            CookieSyncManager.createInstance(this.g);
        } catch (Throwable th) {
        }
        try {
            this.d = CookieManager.getInstance();
            this.d.setAcceptCookie(true);
        } catch (Throwable th2) {
        }
    }

    public String a() {
        d();
        return this.j != null ? "https://cpu.baidu.com/block/app/" + this.i + "/" + this.j : "https://cpu.baidu.com/" + this.h + "/" + this.i;
    }

    private void c() {
        this.f3441a = new HashSet();
        this.f3441a.add("46000");
        this.f3441a.add("46002");
        this.f3441a.add("46007");
        this.f3442b = new HashSet();
        this.f3442b.add("46001");
        this.f3442b.add("46006");
        this.c = new HashSet();
        this.c.add("46003");
        this.c.add("46005");
    }

    private void d() {
        Rect screenRect = this.f.getScreenRect(this.g);
        int height = screenRect.height();
        int width = screenRect.width();
        boolean e = e();
        String b2 = e ? b(h()) : null;
        int f = e ? f() : 0;
        String g = e ? g() : null;
        int i = e ? 1 : 0;
        String cuid = this.e.getCUID(this.g);
        a("v", i());
        a("im", com.baidu.mobads.utils.b.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvz5XO+wDhxUaIDOtrp72fUeIfTYXUSkZXNbA0REQzFGXPFqeMvKEOacgixdfeb/1jWif6dE2pzX1kwMAaOCenIjP9MSw8ZRgR3bZmRq8IuiBPDLI68tFDE6jpA8WjTlcaSkBy06iPtPckAT3LQiPFQroz4Dsoxnrw1QFO82QyWoFfUhGZjj895BQSjfjJjZajOoEY6GBtcRmI30XlVUwMJT9JAqf8GjyvoOMDR3Tjp226UepBIF/NhJKMrW3M5a0SHWo6r+KiAuG6pSVCHPXdP6MaQ/6W2W62wxRqrf24hi407qyKOu4MiEAPbEP3UjdIV3AW1nADjUzg2nxSjRFKQIDAQAB", this.e.getIMEI(this.g)));
        a("aid", com.baidu.mobads.utils.b.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvz5XO+wDhxUaIDOtrp72fUeIfTYXUSkZXNbA0REQzFGXPFqeMvKEOacgixdfeb/1jWif6dE2pzX1kwMAaOCenIjP9MSw8ZRgR3bZmRq8IuiBPDLI68tFDE6jpA8WjTlcaSkBy06iPtPckAT3LQiPFQroz4Dsoxnrw1QFO82QyWoFfUhGZjj895BQSjfjJjZajOoEY6GBtcRmI30XlVUwMJT9JAqf8GjyvoOMDR3Tjp226UepBIF/NhJKMrW3M5a0SHWo6r+KiAuG6pSVCHPXdP6MaQ/6W2W62wxRqrf24hi407qyKOu4MiEAPbEP3UjdIV3AW1nADjUzg2nxSjRFKQIDAQAB", this.e.getAndroidId(this.g)));
        a("m", b(this.e.getMacAddress(this.g)));
        a("cuid", com.baidu.mobads.utils.b.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvz5XO+wDhxUaIDOtrp72fUeIfTYXUSkZXNbA0REQzFGXPFqeMvKEOacgixdfeb/1jWif6dE2pzX1kwMAaOCenIjP9MSw8ZRgR3bZmRq8IuiBPDLI68tFDE6jpA8WjTlcaSkBy06iPtPckAT3LQiPFQroz4Dsoxnrw1QFO82QyWoFfUhGZjj895BQSjfjJjZajOoEY6GBtcRmI30XlVUwMJT9JAqf8GjyvoOMDR3Tjp226UepBIF/NhJKMrW3M5a0SHWo6r+KiAuG6pSVCHPXdP6MaQ/6W2W62wxRqrf24hi407qyKOu4MiEAPbEP3UjdIV3AW1nADjUzg2nxSjRFKQIDAQAB", cuid));
        a(Config.EXCEPTION_CRASH_TYPE, Integer.valueOf(b.a(this.g)));
        a("oi", Integer.valueOf(j()));
        a(UserAccountActionItem.KEY_SRC, 1);
        a("h", Integer.valueOf(height));
        a("w", Integer.valueOf(width));
        a("apm", b2);
        a("rssi", Integer.valueOf(f));
        a("apn", g);
        a("isc", Integer.valueOf(i));
        a(SapiContext.KEY_SDK_VERSION, "android_" + g.b(this.g));
        if (!TextUtils.isEmpty(this.k)) {
            a("outerId", com.baidu.mobads.utils.b.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvz5XO+wDhxUaIDOtrp72fUeIfTYXUSkZXNbA0REQzFGXPFqeMvKEOacgixdfeb/1jWif6dE2pzX1kwMAaOCenIjP9MSw8ZRgR3bZmRq8IuiBPDLI68tFDE6jpA8WjTlcaSkBy06iPtPckAT3LQiPFQroz4Dsoxnrw1QFO82QyWoFfUhGZjj895BQSjfjJjZajOoEY6GBtcRmI30XlVUwMJT9JAqf8GjyvoOMDR3Tjp226UepBIF/NhJKMrW3M5a0SHWo6r+KiAuG6pSVCHPXdP6MaQ/6W2W62wxRqrf24hi407qyKOu4MiEAPbEP3UjdIV3AW1nADjUzg2nxSjRFKQIDAQAB", this.k));
        }
    }

    private void a(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("=");
        stringBuffer.append(obj);
        stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        try {
            this.d.setCookie("https://cpu.baidu.com/", stringBuffer.toString());
        } catch (Throwable th) {
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
            return 0;
        }
    }

    private String g() {
        return "";
    }

    private String h() {
        return "";
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
            return str;
        }
    }

    private int j() {
        String networkOperator = this.e.getNetworkOperator(this.g);
        if (networkOperator == null) {
            return 0;
        }
        if (this.f3441a.contains(networkOperator)) {
            return 1;
        }
        if (this.c.contains(networkOperator)) {
            return 2;
        }
        if (this.f3442b.contains(networkOperator)) {
            return 3;
        }
        return 99;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(":", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }
}
