package com.alipay.security.mobile.module.deviceinfo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.io.File;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static d f2074a = new d();

    public static d a() {
        return f2074a;
    }

    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public boolean a(Context context) {
        boolean z;
        int length;
        try {
            if (!Build.HARDWARE.contains("goldfish") && !Build.PRODUCT.contains("sdk") && !Build.FINGERPRINT.contains("generic")) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String deviceId = telephonyManager.getDeviceId();
                    if (deviceId != null && (length = deviceId.length()) != 0) {
                        for (int i = 0; i < length; i++) {
                            if (!Character.isWhitespace(deviceId.charAt(i)) && deviceId.charAt(i) != '0') {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        return true;
                    }
                }
                return com.alipay.security.mobile.module.a.a.a(Settings.Secure.getString(context.getContentResolver(), "android_id"));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String b() {
        return "android";
    }

    public String b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager.getActiveNetworkInfo().isConnected()) {
                String typeName = connectivityManager.getActiveNetworkInfo().getTypeName();
                return typeName == null ? false : typeName.equalsIgnoreCase(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING) ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : connectivityManager.getActiveNetworkInfo().getExtraInfo();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public boolean c() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i = 0; i < 5; i++) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public String d() {
        return Build.BOARD;
    }

    public String e() {
        return Build.BRAND;
    }

    public String f() {
        return Build.DEVICE;
    }

    public String g() {
        return Build.DISPLAY;
    }

    public String h() {
        return Build.VERSION.INCREMENTAL;
    }

    public String i() {
        return Build.MANUFACTURER;
    }

    public String j() {
        return Build.MODEL;
    }

    public String k() {
        return Build.PRODUCT;
    }

    public String l() {
        return Build.VERSION.RELEASE;
    }

    public String m() {
        return Build.VERSION.SDK;
    }

    public String n() {
        return Build.TAGS;
    }

    public String o() {
        return a("ro.kernel.qemu", "0");
    }

    public String p() {
        return a("gsm.sim.state", "");
    }

    public String q() {
        return a("gsm.sim.state.2", "");
    }

    public String r() {
        return a("wifi.interface", "");
    }

    public String s() {
        return a("sys.usb.state", "");
    }
}
