package com.baidu.mapsdkvi;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public class VDeviceAPI {

    /* renamed from: a  reason: collision with root package name */
    public static PowerManager.WakeLock f7908a;

    /* renamed from: b  reason: collision with root package name */
    public static BroadcastReceiver f7909b;

    public static String getAppVersion() {
        try {
            return b.a().getPackageManager().getPackageInfo(b.a().getApplicationInfo().packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static long getAvailableMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) b.a().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    public static String getCachePath() {
        return Environment.getDataDirectory().getAbsolutePath();
    }

    public static String getCellId() {
        TelephonyManager telephonyManager = (TelephonyManager) b.a().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        CellLocation cellLocation = telephonyManager.getCellLocation();
        if (cellLocation instanceof GsmCellLocation) {
            return " " + ((GsmCellLocation) cellLocation).getCid();
        }
        return " ";
    }

    public static int getCurrentNetworkType() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) b.a().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo == null) {
            return 0;
        }
        int type = networkInfo.getType();
        if (type != 0) {
            return type != 1 ? 1 : 2;
        }
        return 3;
    }

    public static long getFreeSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024;
    }

    public static String getImei() {
        TelephonyManager telephonyManager = (TelephonyManager) b.a().getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getDeviceId();
        }
        return null;
    }

    public static String getImsi() {
        TelephonyManager telephonyManager = (TelephonyManager) b.a().getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getSubscriberId();
        }
        return null;
    }

    public static String getLac() {
        TelephonyManager telephonyManager = (TelephonyManager) b.a().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        CellLocation cellLocation = telephonyManager.getCellLocation();
        if (cellLocation instanceof GsmCellLocation) {
            return "" + ((GsmCellLocation) cellLocation).getLac();
        }
        return "";
    }

    public static String getModuleFileName() {
        return b.a().getFilesDir().getAbsolutePath();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0024 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c getNetworkInfo(int i) {
        int i2;
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) b.a().getSystemService("connectivity");
        if (i == 2) {
            i2 = 1;
        } else if (i != 3) {
            networkInfo = null;
            if (networkInfo == null) {
                return new c(networkInfo);
            }
            return null;
        } else {
            i2 = 0;
        }
        networkInfo = connectivityManager.getNetworkInfo(i2);
        if (networkInfo == null) {
        }
    }

    public static String getOsVersion() {
        return "android";
    }

    public static int getScreenBrightness() {
        int i;
        ContentResolver contentResolver = b.a().getContentResolver();
        try {
            i = Settings.System.getInt(contentResolver, "screen_brightness_mode");
        } catch (Settings.SettingNotFoundException unused) {
            i = 0;
        }
        if (i == 1) {
            return -1;
        }
        try {
            return Settings.System.getInt(contentResolver, "screen_brightness");
        } catch (Settings.SettingNotFoundException unused2) {
            return -1;
        }
    }

    public static float getScreenDensity() {
        if (b.a() == null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.a().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.density;
    }

    public static int getScreenDensityDpi() {
        if (b.a() == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.a().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.densityDpi;
    }

    public static long getSdcardFreeSpace() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024;
    }

    public static String getSdcardPath() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            return externalStorageDirectory.getAbsolutePath();
        }
        return null;
    }

    public static long getSdcardTotalSpace() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getBlockCount()) / 1024;
    }

    public static float getSystemMetricsX() {
        if (b.a() == null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.a().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static float getSystemMetricsY() {
        if (b.a() == null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) b.a().getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static long getTotalMemory() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            r1 = readLine != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() : 0L;
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return r1;
    }

    public static long getTotalSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        return (statFs.getBlockSize() * statFs.getBlockCount()) / 1024;
    }

    public static ScanResult[] getWifiHotpot() {
        List<ScanResult> scanResults = ((WifiManager) b.a().getSystemService("wifi")).getScanResults();
        return (ScanResult[]) scanResults.toArray(new ScanResult[scanResults.size()]);
    }

    public static boolean isWifiConnected() {
        NetworkInfo networkInfo = ((ConnectivityManager) b.a().getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo == null) {
            return false;
        }
        return networkInfo.isConnected();
    }

    public static void makeCall(String str) {
        b.a().startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
    }

    public static native void onNetworkStateChanged();

    public static void openUrl(String str) {
        b.a().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public static int sendMMS(String str, String str2, String str3, String str4) {
        if (PhoneNumberUtils.isWellFormedSmsAddress(str)) {
            try {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(str4)).toString()));
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("address", str);
                intent.putExtra("subject", str2);
                intent.putExtra("sms_body", str3);
                intent.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + str4));
                intent.setType(mimeTypeFromExtension);
                b.a().startActivity(intent);
                return 0;
            } catch (Exception unused) {
                return 2;
            }
        }
        return 1;
    }

    public static void sendSMS(String str, String str2) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", str2);
        b.a().startActivity(intent);
    }

    public static void setNetworkChangedCallback() {
        unsetNetworkChangedCallback();
        f7909b = new a();
        b.a().registerReceiver(f7909b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static void setScreenAlwaysOn(boolean z) {
        if (z) {
            if (f7908a == null) {
                f7908a = ((PowerManager) b.a().getSystemService("power")).newWakeLock(10, "VDeviceAPI");
            }
            f7908a.acquire();
            return;
        }
        PowerManager.WakeLock wakeLock = f7908a;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        f7908a.release();
        f7908a = null;
    }

    public static void setupSoftware(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        b.a().startActivity(intent);
    }

    public static void unsetNetworkChangedCallback() {
        if (f7909b != null) {
            b.a().unregisterReceiver(f7909b);
            f7909b = null;
        }
    }
}
