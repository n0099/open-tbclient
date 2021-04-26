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
    public static final String f1935a = "00:00:00:00:00:00";

    /* renamed from: e  reason: collision with root package name */
    public static a f1936e;

    /* renamed from: b  reason: collision with root package name */
    public String f1937b;

    /* renamed from: c  reason: collision with root package name */
    public String f1938c;

    /* renamed from: d  reason: collision with root package name */
    public String f1939d;

    public a(Context context) {
        try {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                b(telephonyManager.getDeviceId());
                a(telephonyManager.getSubscriberId());
                String macAddress = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
                this.f1939d = macAddress;
                if (!TextUtils.isEmpty(macAddress)) {
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (!TextUtils.isEmpty(this.f1939d)) {
                    return;
                }
            }
            this.f1939d = f1935a;
        } catch (Throwable th) {
            if (TextUtils.isEmpty(this.f1939d)) {
                this.f1939d = f1935a;
            }
            throw th;
        }
    }

    public static a a(Context context) {
        if (f1936e == null) {
            f1936e = new a(context);
        }
        return f1936e;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f1938c)) {
            this.f1938c = "000000000000000";
        }
        return this.f1938c;
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
        return this.f1939d;
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
        if (TextUtils.isEmpty(this.f1937b)) {
            this.f1937b = "000000000000000";
        }
        return this.f1937b;
    }

    public void b(String str) {
        if (str != null) {
            byte[] bytes = str.getBytes();
            for (int i2 = 0; i2 < bytes.length; i2++) {
                if (bytes[i2] < 48 || bytes[i2] > 57) {
                    bytes[i2] = 48;
                }
            }
            String str2 = new String(bytes);
            str = (str2 + "000000000000000").substring(0, 15);
        }
        this.f1938c = str;
    }

    public static String c(Context context) {
        return a(context).c().substring(0, 8);
    }

    public void a(String str) {
        if (str != null) {
            str = (str + "000000000000000").substring(0, 15);
        }
        this.f1937b = str;
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
