package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.base.compat.ApiHelperForM;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class BuildInfo {
    public static PackageInfo sBrowserPackageInfo;
    public static String sFirebaseAppId;
    public final String abiString;
    public final String androidBuildFingerprint;
    public final String customThemes;
    public final String extractedFileSuffix;
    public final String gmsVersionCode;
    public final String hostPackageLabel;
    public final long hostVersionCode;
    public final String installerPackageName;
    public final String packageName;
    public final String resourcesVersion;
    public final long versionCode;
    public final String versionName;

    /* loaded from: classes3.dex */
    private static class Holder {
        public static BuildInfo sInstance = new BuildInfo(null);
    }

    static {
        BuildInfo.class.desiredAssertionStatus();
        sFirebaseAppId = "";
    }

    public BuildInfo() {
        PackageInfo packageInfo = null;
        try {
            Context context = ContextUtils.sApplicationContext;
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo2 = packageManager.getPackageInfo(packageName, 0);
            this.hostVersionCode = packageVersionCode(packageInfo2);
            if (sBrowserPackageInfo != null) {
                this.packageName = sBrowserPackageInfo.packageName;
                this.versionCode = packageVersionCode(sBrowserPackageInfo);
                this.versionName = nullToEmpty(sBrowserPackageInfo.versionName);
                sBrowserPackageInfo = null;
            } else {
                this.packageName = packageName;
                this.versionCode = this.hostVersionCode;
                this.versionName = nullToEmpty(packageInfo2.versionName);
            }
            this.hostPackageLabel = nullToEmpty(packageManager.getApplicationLabel(packageInfo2.applicationInfo));
            this.installerPackageName = nullToEmpty(packageManager.getInstallerPackageName(this.packageName));
            try {
                packageInfo = packageManager.getPackageInfo("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException e) {
            }
            this.gmsVersionCode = packageInfo != null ? String.valueOf(packageVersionCode(packageInfo)) : "gms versionCode not available.";
            String str = "true";
            try {
                packageManager.getPackageInfo("projekt.substratum", 0);
            } catch (PackageManager.NameNotFoundException e2) {
                str = "false";
            }
            this.customThemes = str;
            String str2 = "Not Enabled";
            if (BuildConfig.R_STRING_PRODUCT_VERSION != 0) {
                try {
                    str2 = ContextUtils.sApplicationContext.getString(BuildConfig.R_STRING_PRODUCT_VERSION);
                } catch (Exception e3) {
                    str2 = "Not found";
                }
            }
            this.resourcesVersion = str2;
            if (Build.VERSION.SDK_INT >= 21) {
                this.abiString = TextUtils.join(", ", Build.SUPPORTED_ABIS);
            } else {
                this.abiString = String.format("ABI1: %s, ABI2: %s", Build.CPU_ABI, Build.CPU_ABI2);
            }
            this.extractedFileSuffix = String.format("@%x_%x", Long.valueOf(this.versionCode), Long.valueOf(packageInfo2.lastUpdateTime));
            this.androidBuildFingerprint = Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128));
        } catch (PackageManager.NameNotFoundException e4) {
            throw new RuntimeException(e4);
        }
    }

    public /* synthetic */ BuildInfo(AnonymousClass1 anonymousClass1) {
        PackageInfo packageInfo = null;
        try {
            Context context = ContextUtils.sApplicationContext;
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo2 = packageManager.getPackageInfo(packageName, 0);
            this.hostVersionCode = packageVersionCode(packageInfo2);
            if (sBrowserPackageInfo != null) {
                this.packageName = sBrowserPackageInfo.packageName;
                this.versionCode = packageVersionCode(sBrowserPackageInfo);
                this.versionName = nullToEmpty(sBrowserPackageInfo.versionName);
                sBrowserPackageInfo = null;
            } else {
                this.packageName = packageName;
                this.versionCode = this.hostVersionCode;
                this.versionName = nullToEmpty(packageInfo2.versionName);
            }
            this.hostPackageLabel = nullToEmpty(packageManager.getApplicationLabel(packageInfo2.applicationInfo));
            this.installerPackageName = nullToEmpty(packageManager.getInstallerPackageName(this.packageName));
            try {
                packageInfo = packageManager.getPackageInfo("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException e) {
            }
            this.gmsVersionCode = packageInfo != null ? String.valueOf(packageVersionCode(packageInfo)) : "gms versionCode not available.";
            String str = "true";
            try {
                packageManager.getPackageInfo("projekt.substratum", 0);
            } catch (PackageManager.NameNotFoundException e2) {
                str = "false";
            }
            this.customThemes = str;
            String str2 = "Not Enabled";
            if (BuildConfig.R_STRING_PRODUCT_VERSION != 0) {
                try {
                    str2 = ContextUtils.sApplicationContext.getString(BuildConfig.R_STRING_PRODUCT_VERSION);
                } catch (Exception e3) {
                    str2 = "Not found";
                }
            }
            this.resourcesVersion = str2;
            if (Build.VERSION.SDK_INT >= 21) {
                this.abiString = TextUtils.join(", ", Build.SUPPORTED_ABIS);
            } else {
                this.abiString = String.format("ABI1: %s, ABI2: %s", Build.CPU_ABI, Build.CPU_ABI2);
            }
            this.extractedFileSuffix = String.format("@%x_%x", Long.valueOf(this.versionCode), Long.valueOf(packageInfo2.lastUpdateTime));
            this.androidBuildFingerprint = Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128));
        } catch (PackageManager.NameNotFoundException e4) {
            throw new RuntimeException(e4);
        }
    }

    @CalledByNative
    public static String[] getAll() {
        BuildInfo buildInfo = Holder.sInstance;
        String packageName = ContextUtils.sApplicationContext.getPackageName();
        String[] strArr = new String[24];
        strArr[0] = Build.BRAND;
        strArr[1] = Build.DEVICE;
        strArr[2] = Build.ID;
        strArr[3] = Build.MANUFACTURER;
        strArr[4] = Build.MODEL;
        strArr[5] = String.valueOf(Build.VERSION.SDK_INT);
        strArr[6] = Build.TYPE;
        strArr[7] = Build.BOARD;
        strArr[8] = packageName;
        strArr[9] = String.valueOf(buildInfo.hostVersionCode);
        strArr[10] = buildInfo.hostPackageLabel;
        strArr[11] = buildInfo.packageName;
        strArr[12] = String.valueOf(buildInfo.versionCode);
        strArr[13] = buildInfo.versionName;
        strArr[14] = buildInfo.androidBuildFingerprint;
        strArr[15] = buildInfo.gmsVersionCode;
        strArr[16] = buildInfo.installerPackageName;
        strArr[17] = buildInfo.abiString;
        strArr[18] = sFirebaseAppId;
        strArr[19] = buildInfo.customThemes;
        strArr[20] = buildInfo.resourcesVersion;
        strArr[21] = buildInfo.extractedFileSuffix;
        strArr[22] = isAtLeastQ() ? "1" : "0";
        strArr[23] = "eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE) ? "1" : "0";
        return strArr;
    }

    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static String nullToEmpty(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString();
    }

    public static long packageVersionCode(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? ApiHelperForM.getLongVersionCode(packageInfo) : packageInfo.versionCode;
    }
}
