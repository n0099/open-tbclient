package com.alipay.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.FieldBuilder;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1980a = "00:00:00:00:00:00";

    /* renamed from: e  reason: collision with root package name */
    public static a f1981e;

    /* renamed from: b  reason: collision with root package name */
    public String f1982b;

    /* renamed from: c  reason: collision with root package name */
    public String f1983c;

    /* renamed from: d  reason: collision with root package name */
    public String f1984d;

    public a(Context context) {
        try {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                b(telephonyManager.getDeviceId());
                a(telephonyManager.getSubscriberId());
                String macAddress = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
                this.f1984d = macAddress;
                if (!TextUtils.isEmpty(macAddress)) {
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (!TextUtils.isEmpty(this.f1984d)) {
                    return;
                }
            }
            this.f1984d = f1980a;
        } catch (Throwable th) {
            if (TextUtils.isEmpty(this.f1984d)) {
                this.f1984d = f1980a;
            }
            throw th;
        }
    }

    public static a a(Context context) {
        if (f1981e == null) {
            f1981e = new a(context);
        }
        return f1981e;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f1983c)) {
            this.f1983c = "000000000000000";
        }
        return this.f1983c;
    }

    public String c() {
        String str = b() + FieldBuilder.SE;
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            return str + "000000000000000";
        }
        return str + a2;
    }

    public String d() {
        return this.f1984d;
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f1982b)) {
            this.f1982b = "000000000000000";
        }
        return this.f1982b;
    }

    public void b(String str) {
        if (str != null) {
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] < 48 || bytes[i] > 57) {
                    bytes[i] = 48;
                }
            }
            String str2 = new String(bytes);
            str = (str2 + "000000000000000").substring(0, 15);
        }
        this.f1983c = str;
    }

    public static String c(Context context) {
        return a(context).c().substring(0, 8);
    }

    public void a(String str) {
        if (str != null) {
            str = (str + "000000000000000").substring(0, 15);
        }
        this.f1982b = str;
    }

    public static d b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                return d.a(activeNetworkInfo.getSubtype());
            }
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                return d.WIFI;
            }
            return d.NONE;
        } catch (Exception unused) {
            return d.NONE;
        }
    }
}
