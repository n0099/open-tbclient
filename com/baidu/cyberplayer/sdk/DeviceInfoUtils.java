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
    public static final Object LOCK_OBJ = new Object();
    public static final String TAG = "DeviceInfoUtils";
    public static String sDeviceDevice = "";
    public static String sDeviceManufacturer = "";
    public static String sDeviceModel = "";
    public static HDRInfo sHDRInfo = null;
    public static String sHarmonyVersion = "";
    public static boolean sOperatorForce = true;
    public static String sOsVersion = "";

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

    public static boolean needForceApi(int i) {
        return i == -2 || i == 2 || i == -3;
    }

    public static void clearOperator() {
        synchronized (LOCK_OBJ) {
            sOperatorForce = true;
        }
    }

    public static String getDeviceDevice() {
        if (TextUtils.isEmpty(sDeviceDevice)) {
            sDeviceDevice = Build.DEVICE;
        }
        return sDeviceDevice;
    }

    public static String getDeviceManufacturer() {
        if (TextUtils.isEmpty(sDeviceManufacturer)) {
            try {
                sDeviceManufacturer = DeviceInfoManager.INSTANCE.getManufacturer(DI.LIVE_PLAYER, "").deviceId;
            } catch (Error | Exception e) {
                e.printStackTrace();
            }
        }
        return sDeviceManufacturer;
    }

    public static String getDeviceModel() {
        if (TextUtils.isEmpty(sDeviceModel)) {
            try {
                sDeviceModel = DeviceInfoManager.INSTANCE.getModel(DI.LIVE_PLAYER, "").deviceId;
            } catch (Error | Exception unused) {
                sDeviceModel = Build.MODEL;
            }
        }
        return sDeviceModel;
    }

    public static String getOsVersion() {
        if (TextUtils.isEmpty(sOsVersion)) {
            try {
                sOsVersion = DeviceInfoManager.INSTANCE.getOsVersion(DI.LIVE_PLAYER, "").deviceId;
            } catch (Error | Exception e) {
                e.printStackTrace();
            }
        }
        return sOsVersion;
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
            if (sHDRInfo == null) {
                try {
                    sHDRInfo = new HDRInfo();
                    queryDisplay(context);
                    queryLuminance(context);
                    queryConfig(context);
                } catch (Error | Exception e) {
                    e.printStackTrace();
                }
            }
            hDRInfo = sHDRInfo;
        }
        return hDRInfo;
    }

    public static boolean isHarmonyOs(Context context) {
        boolean z = false;
        if (TextUtils.isEmpty(sHarmonyVersion)) {
            try {
                try {
                    sHarmonyVersion = DeviceInfoManager.INSTANCE.getHarmonyVersion(context, DI.LIVE_PLAYER, "").deviceId;
                } catch (Exception unused) {
                }
            } catch (Error | Exception unused2) {
                if (Class.forName("ohos.utils.system.SystemCapability") != null) {
                    z = true;
                }
            }
        }
        if (!TextUtils.isEmpty(sHarmonyVersion)) {
            return true;
        }
        return z;
    }

    public static String getOperator(Context context) {
        boolean z;
        synchronized (LOCK_OBJ) {
            z = sOperatorForce;
            sOperatorForce = false;
        }
        try {
            DeviceIdBag operator = DeviceInfoManager.INSTANCE.getOperator(context, DI.LIVE_PLAYER, "", z);
            if (operator != null && needForceApi(operator.errorCode)) {
                operator = DeviceInfoManager.INSTANCE.getOperator(context, DI.LIVE_PLAYER, "", true);
            }
            return operator.deviceId;
        } catch (Error | Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean queryConfig(Context context) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 26) {
            Configuration configuration = context.getResources().getConfiguration();
            boolean isScreenWideColorGamut = configuration.isScreenWideColorGamut();
            boolean isScreenHdr = configuration.isScreenHdr();
            CyberLog.d("DeviceInfoUtils", "Configuration color " + isScreenWideColorGamut + " hdr " + isScreenHdr);
            if (isScreenWideColorGamut && isScreenHdr) {
                z = true;
            }
            HDRInfo hDRInfo = sHDRInfo;
            hDRInfo.isColorGamut = isScreenWideColorGamut;
            hDRInfo.isScreenHdr = isScreenHdr;
        }
        return z;
    }

    public static boolean queryDisplay(Context context) {
        int i = 0;
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        int[] supportedHdrTypes = ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getHdrCapabilities().getSupportedHdrTypes();
        boolean z = false;
        while (i < supportedHdrTypes.length) {
            CyberLog.d("DeviceInfoUtils", "type= " + supportedHdrTypes[i]);
            i++;
            z = true;
        }
        sHDRInfo.hdrTypes = supportedHdrTypes;
        return z;
    }

    public static boolean queryLuminance(Context context) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 24) {
            Display.HdrCapabilities hdrCapabilities = ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getHdrCapabilities();
            float desiredMaxAverageLuminance = hdrCapabilities.getDesiredMaxAverageLuminance();
            float desiredMaxLuminance = hdrCapabilities.getDesiredMaxLuminance();
            float desiredMinLuminance = hdrCapabilities.getDesiredMinLuminance();
            CyberLog.d("DeviceInfoUtils", "MaxAverageLuminance = " + desiredMaxAverageLuminance + " MaxLuminance= " + desiredMaxLuminance + " MinLuminance = " + desiredMinLuminance);
            if (desiredMaxLuminance > 1000.0f) {
                z = true;
            }
            HDRInfo hDRInfo = sHDRInfo;
            hDRInfo.maxLumAVG = desiredMaxAverageLuminance;
            hDRInfo.maxLum = desiredMaxLuminance;
            hDRInfo.minLum = desiredMinLuminance;
        }
        return z;
    }
}
