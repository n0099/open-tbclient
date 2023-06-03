package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.live.interfaces.DI;
@Keep
/* loaded from: classes3.dex */
public class DeviceInfoUtils {
    public static final Object a = new Object();
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static String f = "";
    public static boolean g = true;
    public static HDRInfo h;

    @Keep
    /* loaded from: classes3.dex */
    public static final class HDRInfo {
        public int[] hdrTypes;
        public boolean isColorGamut;
        public boolean isScreenHdr;
        public float maxLum;
        public float maxLumAVG;
        public float minLum;
    }

    public static boolean a(int i) {
        return i == -2 || i == 2 || i == -3;
    }

    public static void clearOperator() {
        synchronized (a) {
            g = true;
        }
    }

    public static String getDeviceDevice() {
        if (TextUtils.isEmpty(d)) {
            d = Build.DEVICE;
        }
        return d;
    }

    public static String getDeviceManufacturer() {
        if (TextUtils.isEmpty(b)) {
            try {
                b = DeviceInfoManager.INSTANCE.getManufacturer(DI.LIVE_PLAYER, "").deviceId;
            } catch (Error | Exception e2) {
                e2.printStackTrace();
            }
        }
        return b;
    }

    public static String getDeviceModel() {
        if (TextUtils.isEmpty(c)) {
            try {
                c = DeviceInfoManager.INSTANCE.getModel(DI.LIVE_PLAYER, "").deviceId;
            } catch (Error | Exception unused) {
                c = Build.MODEL;
            }
        }
        return c;
    }

    public static String getOsVersion() {
        if (TextUtils.isEmpty(e)) {
            try {
                e = DeviceInfoManager.INSTANCE.getOsVersion(DI.LIVE_PLAYER, "").deviceId;
            } catch (Error | Exception e2) {
                e2.printStackTrace();
            }
        }
        return e;
    }

    public static boolean a(Context context) {
        int i = 0;
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        int[] supportedHdrTypes = ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getHdrCapabilities().getSupportedHdrTypes();
        boolean z = false;
        while (i < supportedHdrTypes.length) {
            CyberLog.d(com.baidu.down.utils.DeviceInfoUtils.TAG, "type= " + supportedHdrTypes[i]);
            i++;
            z = true;
        }
        h.hdrTypes = supportedHdrTypes;
        return z;
    }

    public static boolean c(Context context) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 26) {
            Configuration configuration = context.getResources().getConfiguration();
            boolean isScreenWideColorGamut = configuration.isScreenWideColorGamut();
            boolean isScreenHdr = configuration.isScreenHdr();
            CyberLog.d(com.baidu.down.utils.DeviceInfoUtils.TAG, "Configuration color " + isScreenWideColorGamut + " hdr " + isScreenHdr);
            if (isScreenWideColorGamut && isScreenHdr) {
                z = true;
            }
            HDRInfo hDRInfo = h;
            hDRInfo.isColorGamut = isScreenWideColorGamut;
            hDRInfo.isScreenHdr = isScreenHdr;
        }
        return z;
    }

    public static String getOperator(Context context) {
        boolean z;
        synchronized (a) {
            z = g;
            g = false;
        }
        try {
            DeviceIdBag operator = DeviceInfoManager.INSTANCE.getOperator(context, DI.LIVE_PLAYER, "", z);
            if (operator != null && a(operator.errorCode)) {
                operator = DeviceInfoManager.INSTANCE.getOperator(context, DI.LIVE_PLAYER, "", true);
            }
            return operator.deviceId;
        } catch (Error | Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean b(Context context) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 24) {
            Display.HdrCapabilities hdrCapabilities = ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getHdrCapabilities();
            float desiredMaxAverageLuminance = hdrCapabilities.getDesiredMaxAverageLuminance();
            float desiredMaxLuminance = hdrCapabilities.getDesiredMaxLuminance();
            float desiredMinLuminance = hdrCapabilities.getDesiredMinLuminance();
            CyberLog.d(com.baidu.down.utils.DeviceInfoUtils.TAG, "MaxAverageLuminance = " + desiredMaxAverageLuminance + " MaxLuminance= " + desiredMaxLuminance + " MinLuminance = " + desiredMinLuminance);
            if (desiredMaxLuminance > 1000.0f) {
                z = true;
            }
            HDRInfo hDRInfo = h;
            hDRInfo.maxLumAVG = desiredMaxAverageLuminance;
            hDRInfo.maxLum = desiredMaxLuminance;
            hDRInfo.minLum = desiredMinLuminance;
        }
        return z;
    }

    public static int getDeviceDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static int getDeviceHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getDeviceWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static synchronized HDRInfo getDisplayHDRInfo(Context context) {
        HDRInfo hDRInfo;
        synchronized (DeviceInfoUtils.class) {
            if (h == null) {
                try {
                    h = new HDRInfo();
                    a(context);
                    b(context);
                    c(context);
                } catch (Error | Exception e2) {
                    e2.printStackTrace();
                }
            }
            hDRInfo = h;
        }
        return hDRInfo;
    }

    public static boolean isHarmonyOs(Context context) {
        boolean z = false;
        if (TextUtils.isEmpty(f)) {
            try {
                try {
                    f = DeviceInfoManager.INSTANCE.getHarmonyVersion(context, DI.LIVE_PLAYER, "").deviceId;
                } catch (Exception unused) {
                }
            } catch (Error | Exception unused2) {
                if (Class.forName("ohos.utils.system.SystemCapability") != null) {
                    z = true;
                }
            }
        }
        if (!TextUtils.isEmpty(f)) {
            return true;
        }
        return z;
    }
}
