package com.baidu.mobstat;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
final class y {
    public static int a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = j(context);
        } catch (Exception e) {
            com.baidu.mobstat.a.e.a("createAdReqURL", e);
        }
        return displayMetrics.widthPixels;
    }

    public static String a() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                String address = defaultAdapter.getAddress();
                return address != null ? com.baidu.a.a.a.a.b.a(com.baidu.mobstat.a.a.a("h9YLQoINGWyOBYYk", "h9YLQoINGWyOBYYk", address.getBytes()), "utf-8") : address;
            }
            return "";
        } catch (Exception e) {
            com.baidu.mobstat.a.e.a("statsdk", e);
            return "";
        }
    }

    public static String a(Context context, String str) {
        String str2 = "";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData != null ? applicationInfo.metaData.get(str) : null;
                if (obj == null) {
                    com.baidu.mobstat.a.e.a("StatSDK", "null,can't find information for key:" + str);
                    if (str == "BaiduMobAd_STAT_ID") {
                        com.baidu.mobstat.a.e.c("不能在manifest.xml中找到APP Key||can't find app key in manifest.xml.");
                    }
                } else {
                    str2 = obj.toString();
                    if (str2.trim().equals("") && str == "BaiduMobAd_STAT_ID") {
                        com.baidu.mobstat.a.e.c("APP Key值为空||The value of APP Key is empty.");
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (str == "BaiduMobAd_STAT_ID") {
                com.baidu.mobstat.a.e.c("不能在manifest.xml中找到APP Key||can't find app key in manifest.xml.");
            }
        }
        return str2;
    }

    public static String a(Context context, String str, String str2, int i, int i2) {
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter = null;
        HttpURLConnection a = com.baidu.mobstat.a.c.a(context, str, i, i2);
        a.setDoOutput(true);
        a.setInstanceFollowRedirects(false);
        a.setUseCaches(false);
        a.setRequestProperty("Content-Type", "gzip");
        a.connect();
        com.baidu.mobstat.a.e.a("AdUtil.httpPost connected");
        StringBuilder sb = new StringBuilder();
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(a.getOutputStream())));
            try {
                bufferedWriter2.write(str2);
                bufferedWriter2.close();
                bufferedReader = new BufferedReader(new InputStreamReader(a.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (IOException e) {
                        e = e;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                        a.disconnect();
                        throw e;
                    }
                }
                bufferedReader.close();
                a.disconnect();
                int contentLength = a.getContentLength();
                if (a.getResponseCode() == 200 && contentLength == 0) {
                    return sb.toString();
                }
                throw new IOException("http code =" + a.getResponseCode() + "& contentResponse=" + ((Object) sb));
            } catch (IOException e2) {
                e = e2;
                bufferedWriter = bufferedWriter2;
                bufferedReader = null;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
        }
    }

    public static int b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = j(context);
        } catch (Exception e) {
            com.baidu.mobstat.a.e.a("createAdReqURL", e);
        }
        return displayMetrics.heightPixels;
    }

    public static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.baidu.mobstat.a.e.c("statsdk", "get app version code exception");
            return 1;
        }
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            com.baidu.mobstat.a.e.c("statsdk", "get app version name exception");
            return "";
        }
    }

    public static String e(Context context) {
        String format = String.format("%s_%s_%s", 0, 0, 0);
        try {
            if (com.baidu.mobstat.a.c.e(context, "android.permission.ACCESS_FINE_LOCATION") || com.baidu.mobstat.a.c.e(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
                com.baidu.mobstat.a.e.a("getLocation cell:", cellLocation + "");
                if (cellLocation == null) {
                    return format;
                }
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    return String.format("%s_%s_%s", String.format("%d", Integer.valueOf(gsmCellLocation.getCid())), String.format("%d", Integer.valueOf(gsmCellLocation.getLac())), 0);
                }
                String[] split = cellLocation.toString().replace("[", "").replace("]", "").split(",");
                return String.format("%s_%s_%s", split[0], split[3], split[4]);
            }
        } catch (Exception e) {
            com.baidu.mobstat.a.e.a("getLocation", e);
        }
        return format;
    }

    public static String f(Context context) {
        try {
            if (com.baidu.mobstat.a.c.e(context, "android.permission.ACCESS_FINE_LOCATION")) {
                Location lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("gps");
                com.baidu.mobstat.a.e.a("statsdk", "location: " + lastKnownLocation);
                if (lastKnownLocation != null) {
                    return String.format("%s_%s_%s", Long.valueOf(lastKnownLocation.getTime()), Double.valueOf(lastKnownLocation.getLongitude()), Double.valueOf(lastKnownLocation.getLatitude()));
                }
            }
        } catch (Exception e) {
            com.baidu.mobstat.a.e.a("statsdk", e);
        }
        return "";
    }

    public static String g(Context context) {
        String str;
        Exception e;
        String str2 = null;
        try {
            if (com.baidu.mobstat.a.c.e(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                str = connectionInfo.getMacAddress();
                try {
                    str2 = String.format("ssid=%s mac=%s", connectionInfo.getSSID(), connectionInfo.getMacAddress());
                    com.baidu.mobstat.a.e.a(str2);
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.mobstat.a.e.a("statsdk", e);
                    return str;
                }
            } else {
                com.baidu.mobstat.a.e.c("You need the android.Manifest.permission.ACCESS_WIFI_STATE permission. Open AndroidManifest.xml and just before the final </manifest> tag add:android.permission.ACCESS_WIFI_STATE");
                str = null;
            }
        } catch (Exception e3) {
            str = str2;
            e = e3;
        }
        return str;
    }

    public static String h(Context context) {
        Exception exc;
        String str;
        String str2;
        int i;
        int i2;
        int i3 = 0;
        try {
            if (com.baidu.mobstat.a.c.e(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled()) {
                    com.baidu.mobstat.a.e.a("[d]", wifiManager.getScanResults() + "");
                    int i4 = Integer.MAX_VALUE;
                    int i5 = -1;
                    while (i3 < wifiManager.getScanResults().size()) {
                        ScanResult scanResult = wifiManager.getScanResults().get(i3);
                        int abs = Math.abs(scanResult.level);
                        com.baidu.mobstat.a.e.a(String.format("%s %s_%s", scanResult.SSID, scanResult.BSSID, Integer.valueOf(abs)));
                        if (i4 > abs) {
                            i = i3;
                            i2 = abs;
                        } else {
                            i = i5;
                            i2 = i4;
                        }
                        i3++;
                        i4 = i2;
                        i5 = i;
                    }
                    if (i5 >= 0) {
                        ScanResult scanResult2 = wifiManager.getScanResults().get(i5);
                        str2 = String.format("%s_%s", scanResult2.BSSID.replace(":", "").toLowerCase(), Integer.valueOf(Math.abs(scanResult2.level)));
                    } else {
                        str2 = "";
                    }
                    try {
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        com.baidu.mobstat.a.e.a(String.format("[active]%s %s_%s", connectionInfo.getSSID(), connectionInfo.getMacAddress(), Integer.valueOf(Math.abs(connectionInfo.getRssi()))));
                        return str2;
                    } catch (Exception e) {
                        str = str2;
                        exc = e;
                        com.baidu.mobstat.a.e.a("getWifiLocation", exc);
                        return str;
                    }
                }
            }
            return "";
        } catch (Exception e2) {
            exc = e2;
            str = "";
        }
    }

    public static String i(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        String typeName = activeNetworkInfo.getTypeName();
        return (typeName.equals(NetworkChangeReceiver.WIFI_STRING) || activeNetworkInfo.getSubtypeName() == null) ? typeName : activeNetworkInfo.getSubtypeName();
    }

    public static DisplayMetrics j(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }
}
