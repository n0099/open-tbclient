package com.baidu.kirin.a;

import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.kirin.d.d;
import com.baidu.kirin.objects.LatitudeAndLongitude;
import com.baidu.kirin.objects.NetworkStatus;
import com.baidu.mobstat.CooperService;
import com.baidu.mobstat.a.c;
import com.baidu.mobstat.a.e;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    public static String a() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String a(Context context) {
        return CooperService.getAppChannel(context);
    }

    public static String a(Context context, boolean z) {
        LatitudeAndLongitude latitudeAndLongitude = new LatitudeAndLongitude();
        if (z) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            for (String str : locationManager.getAllProviders()) {
                System.out.println(str);
                Location lastKnownLocation = locationManager.getLastKnownLocation(str);
                if (lastKnownLocation != null) {
                    latitudeAndLongitude.latitude = lastKnownLocation.getLatitude() + "";
                    latitudeAndLongitude.longitude = lastKnownLocation.getLongitude() + "";
                } else {
                    latitudeAndLongitude.latitude = "";
                    latitudeAndLongitude.longitude = "";
                }
            }
        } else {
            latitudeAndLongitude.latitude = "";
            latitudeAndLongitude.longitude = "";
        }
        return latitudeAndLongitude.latitude + "," + latitudeAndLongitude.longitude;
    }

    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static String b(Context context) {
        return CooperService.getAppKey(context);
    }

    public static String c(Context context) {
        return CooperService.getAppVersionName(context);
    }

    public static int d(Context context) {
        return CooperService.getAppVersionCode(context);
    }

    public static String e(Context context) {
        if (!o(context)) {
            d.c("android OsVerson get failed");
            return "";
        }
        String str = Build.VERSION.RELEASE;
        d.a("android_osVersion : " + str);
        return str;
    }

    public static String f(Context context) {
        return "Android" + CooperService.getOSVersion();
    }

    public static String g(Context context) {
        if (!o(context)) {
            d.c("android manufacturer get failed!");
            return "";
        }
        String str = Build.MANUFACTURER;
        d.a("manufacturer_info : " + str);
        return str;
    }

    public static String h(Context context) {
        return CooperService.getDeviceId((TelephonyManager) context.getSystemService("phone"), context);
    }

    public static String i(Context context) {
        String str;
        String str2 = "";
        try {
            if (c.e(context, "android.permission.ACCESS_WIFI_STATE")) {
                str2 = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                str = CooperService.getSecretValue(str2);
            } else {
                e.c("You need the android.Manifest.permission.ACCESS_WIFI_STATE permission. Open AndroidManifest.xml and just before the final </manifest> tag add:android.permission.ACCESS_WIFI_STATE");
                str = "";
            }
            return str;
        } catch (Exception e) {
            return str2;
        }
    }

    public static String j(Context context) {
        if (!a(context, "android.permission.READ_PHONE_STATE")) {
            d.c("lost permissioin : android.permission.READ_PHONE_STATE");
            return "";
        }
        String str = o(context) ? ((TelephonyManager) context.getSystemService("phone")).getPhoneType() + "" : "";
        if (str.length() != 0) {
            d.a("phoneType : " + str);
            return str;
        }
        d.b("phoneType get nothing");
        return "";
    }

    public static String k(Context context) {
        return CooperService.getCUID(context, true);
    }

    public static String l(Context context) {
        if (!a(context, "android.permission.READ_PHONE_STATE")) {
            d.c("lost permissioin : android.permission.READ_PHONE_STATE");
            return "";
        }
        String deviceId = o(context) ? ((TelephonyManager) context.getSystemService("phone")).getDeviceId() : "";
        if (deviceId != null) {
            d.a("Imei:" + deviceId);
            return CooperService.getSecretValue(deviceId);
        }
        d.b("Imei is null");
        return "";
    }

    public static NetworkStatus m(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return NetworkStatus.NotReachable;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return NetworkStatus.NotReachable;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (connectivityManager.getActiveNetworkInfo().getType() == 1) {
            return NetworkStatus.Wifi;
        }
        switch (telephonyManager.getNetworkType()) {
            case 0:
                return NetworkStatus.TwoG;
            case 1:
                return NetworkStatus.TwoG;
            case 2:
                return NetworkStatus.TwoG;
            case 3:
                return NetworkStatus.ThreeG;
            case 4:
                return NetworkStatus.TwoG;
            case 5:
                return NetworkStatus.ThreeG;
            case 6:
                return NetworkStatus.ThreeG;
            case 7:
                return NetworkStatus.TwoG;
            case 8:
            case 9:
            case 10:
            default:
                return NetworkStatus.TwoG;
            case 11:
                return NetworkStatus.TwoG;
            case 12:
                return NetworkStatus.ThreeG;
            case 13:
                return NetworkStatus.ThreeG;
            case 14:
                return NetworkStatus.ThreeG;
            case 15:
                return NetworkStatus.ThreeG;
        }
    }

    public static String n(Context context) {
        int i;
        int i2;
        Exception exc;
        int i3 = Build.VERSION.SDK_INT;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        int i4 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        d.a("Run1 first get resolution:" + i4 + " * " + i5 + ",ver " + i3);
        if (i3 < 13) {
            i = displayMetrics.heightPixels;
            i2 = i4;
        } else if (i3 == 13) {
            try {
                i = ((Integer) defaultDisplay.getClass().getMethod("getRealHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i2 = i4;
            } catch (Exception e) {
                e.printStackTrace();
                i = i5;
                i2 = i4;
            }
        } else if (i3 > 13) {
            try {
                Method method = defaultDisplay.getClass().getMethod("getSize", Point.class);
                Point point = new Point();
                method.invoke(defaultDisplay, point);
                i4 = point.x;
                i = point.y;
            } catch (Exception e2) {
                i = i5;
                i2 = i4;
                exc = e2;
            }
            try {
                d.a("ver>13 resolution : " + i4 + " * " + i);
                i2 = i4;
            } catch (Exception e3) {
                i2 = i4;
                exc = e3;
                exc.printStackTrace();
                d.a("Run2 Calibration resolution:" + i2 + " * " + i);
                return i2 + "*" + i;
            }
        } else {
            i = i5;
            i2 = i4;
        }
        d.a("Run2 Calibration resolution:" + i2 + " * " + i);
        return i2 + "*" + i;
    }

    public static boolean o(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    public static boolean p(Context context) {
        if (!a(context, "android.permission.INTERNET")) {
            d.c(" lost  permission : android.permission.INTERNET");
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            d.c("Network error");
            return false;
        }
        return true;
    }
}
