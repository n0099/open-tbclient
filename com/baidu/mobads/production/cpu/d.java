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
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public Set<String> f8446a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f8447b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f8448c;

    /* renamed from: d  reason: collision with root package name */
    public CookieManager f8449d;

    /* renamed from: e  reason: collision with root package name */
    public IXAdSystemUtils f8450e;

    /* renamed from: f  reason: collision with root package name */
    public IXAdCommonUtils f8451f;

    /* renamed from: g  reason: collision with root package name */
    public Context f8452g;

    /* renamed from: h  reason: collision with root package name */
    public int f8453h;
    public String i;
    public String j;
    public String k;

    public d(Context context, int i, String str) {
        this.f8450e = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        this.f8451f = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        this.f8452g = context;
        this.f8453h = i;
        this.i = str;
        this.j = null;
        b();
        c();
    }

    private void b() {
        try {
            CookieSyncManager.createInstance(this.f8452g);
        } catch (Throwable unused) {
        }
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            this.f8449d = cookieManager;
            cookieManager.setAcceptCookie(true);
        } catch (Throwable unused2) {
        }
    }

    private void c() {
        HashSet hashSet = new HashSet();
        this.f8446a = hashSet;
        hashSet.add("46000");
        this.f8446a.add("46002");
        this.f8446a.add("46007");
        HashSet hashSet2 = new HashSet();
        this.f8447b = hashSet2;
        hashSet2.add("46001");
        this.f8447b.add("46006");
        HashSet hashSet3 = new HashSet();
        this.f8448c = hashSet3;
        hashSet3.add("46003");
        this.f8448c.add("46005");
    }

    private void d() {
        Rect screenRect = this.f8451f.getScreenRect(this.f8452g);
        int height = screenRect.height();
        int width = screenRect.width();
        boolean e2 = e();
        String b2 = e2 ? b(h()) : null;
        int f2 = e2 ? f() : 0;
        String g2 = e2 ? g() : null;
        String cuid = this.f8450e.getCUID(this.f8452g);
        a("v", i());
        a("im", com.baidu.mobads.utils.b.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvz5XO+wDhxUaIDOtrp72fUeIfTYXUSkZXNbA0REQzFGXPFqeMvKEOacgixdfeb/1jWif6dE2pzX1kwMAaOCenIjP9MSw8ZRgR3bZmRq8IuiBPDLI68tFDE6jpA8WjTlcaSkBy06iPtPckAT3LQiPFQroz4Dsoxnrw1QFO82QyWoFfUhGZjj895BQSjfjJjZajOoEY6GBtcRmI30XlVUwMJT9JAqf8GjyvoOMDR3Tjp226UepBIF/NhJKMrW3M5a0SHWo6r+KiAuG6pSVCHPXdP6MaQ/6W2W62wxRqrf24hi407qyKOu4MiEAPbEP3UjdIV3AW1nADjUzg2nxSjRFKQIDAQAB", this.f8450e.getIMEI(this.f8452g)));
        a("aid", com.baidu.mobads.utils.b.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvz5XO+wDhxUaIDOtrp72fUeIfTYXUSkZXNbA0REQzFGXPFqeMvKEOacgixdfeb/1jWif6dE2pzX1kwMAaOCenIjP9MSw8ZRgR3bZmRq8IuiBPDLI68tFDE6jpA8WjTlcaSkBy06iPtPckAT3LQiPFQroz4Dsoxnrw1QFO82QyWoFfUhGZjj895BQSjfjJjZajOoEY6GBtcRmI30XlVUwMJT9JAqf8GjyvoOMDR3Tjp226UepBIF/NhJKMrW3M5a0SHWo6r+KiAuG6pSVCHPXdP6MaQ/6W2W62wxRqrf24hi407qyKOu4MiEAPbEP3UjdIV3AW1nADjUzg2nxSjRFKQIDAQAB", this.f8450e.getAndroidId(this.f8452g)));
        a("m", b(this.f8450e.getMacAddress(this.f8452g)));
        a("cuid", com.baidu.mobads.utils.b.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvz5XO+wDhxUaIDOtrp72fUeIfTYXUSkZXNbA0REQzFGXPFqeMvKEOacgixdfeb/1jWif6dE2pzX1kwMAaOCenIjP9MSw8ZRgR3bZmRq8IuiBPDLI68tFDE6jpA8WjTlcaSkBy06iPtPckAT3LQiPFQroz4Dsoxnrw1QFO82QyWoFfUhGZjj895BQSjfjJjZajOoEY6GBtcRmI30XlVUwMJT9JAqf8GjyvoOMDR3Tjp226UepBIF/NhJKMrW3M5a0SHWo6r+KiAuG6pSVCHPXdP6MaQ/6W2W62wxRqrf24hi407qyKOu4MiEAPbEP3UjdIV3AW1nADjUzg2nxSjRFKQIDAQAB", cuid));
        a(Config.EXCEPTION_CRASH_TYPE, Integer.valueOf(b.a(this.f8452g)));
        a("oi", Integer.valueOf(j()));
        a(UserAccountActionItem.KEY_SRC, 1);
        a("h", Integer.valueOf(height));
        a("w", Integer.valueOf(width));
        a("apm", b2);
        a("rssi", Integer.valueOf(f2));
        a("apn", g2);
        a("isc", Integer.valueOf(e2 ? 1 : 0));
        a("sdk_version", "android_" + g.b(this.f8452g));
        if (TextUtils.isEmpty(this.k)) {
            return;
        }
        a("outerId", com.baidu.mobads.utils.b.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvz5XO+wDhxUaIDOtrp72fUeIfTYXUSkZXNbA0REQzFGXPFqeMvKEOacgixdfeb/1jWif6dE2pzX1kwMAaOCenIjP9MSw8ZRgR3bZmRq8IuiBPDLI68tFDE6jpA8WjTlcaSkBy06iPtPckAT3LQiPFQroz4Dsoxnrw1QFO82QyWoFfUhGZjj895BQSjfjJjZajOoEY6GBtcRmI30XlVUwMJT9JAqf8GjyvoOMDR3Tjp226UepBIF/NhJKMrW3M5a0SHWo6r+KiAuG6pSVCHPXdP6MaQ/6W2W62wxRqrf24hi407qyKOu4MiEAPbEP3UjdIV3AW1nADjUzg2nxSjRFKQIDAQAB", this.k));
    }

    private boolean e() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f8452g.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private int f() {
        try {
            WifiInfo connectionInfo = ((WifiManager) this.f8452g.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null) {
                return 0;
            }
            return connectionInfo.getRssi();
        } catch (Exception unused) {
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
        try {
            PackageInfo packageInfo = this.f8452g.getPackageManager().getPackageInfo(this.f8452g.getPackageName(), 0);
            String str = packageInfo == null ? null : packageInfo.versionName;
            if (str != null) {
                return str.replace(".", "-");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private int j() {
        String networkOperator = this.f8450e.getNetworkOperator(this.f8452g);
        if (networkOperator == null) {
            return 0;
        }
        if (this.f8446a.contains(networkOperator)) {
            return 1;
        }
        if (this.f8448c.contains(networkOperator)) {
            return 2;
        }
        return this.f8447b.contains(networkOperator) ? 3 : 99;
    }

    public void a(String str) {
        this.k = str;
    }

    public String a() {
        d();
        if (this.j != null) {
            return "https://cpu.baidu.com/block/app/" + this.i + "/" + this.j;
        }
        return "https://cpu.baidu.com/" + this.f8453h + "/" + this.i;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(":", "-");
    }

    private void a(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("=");
        stringBuffer.append(obj);
        stringBuffer.append(";");
        try {
            this.f8449d.setCookie("https://cpu.baidu.com/", stringBuffer.toString());
        } catch (Throwable unused) {
        }
    }

    public d(Context context, String str, String str2) {
        this.f8450e = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        this.f8451f = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        this.f8452g = context;
        this.j = str;
        this.i = str2;
        this.f8453h = -1;
        b();
        c();
    }
}
