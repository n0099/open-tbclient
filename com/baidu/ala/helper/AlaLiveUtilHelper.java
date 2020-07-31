package com.baidu.ala.helper;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.opengl.Matrix;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.ala.recorder.AlaLiveRecorderConfig;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
/* loaded from: classes7.dex */
public class AlaLiveUtilHelper {
    private static final String ALA_PLUGIN_NAME = "com.baidu.tieba.pluginAla";
    public static final int ALIVE_SDK_PLATFORM = 4;
    public static final int HK_SDK_PLATFORM = 2;
    public static final int QM_SDK_PLATFORM = 3;
    public static final int TB_SDK_PLATFORM = 1;
    private static String apkVersionName = "";

    public static boolean loadPluginLibrary(String str) {
        boolean z;
        try {
            System.loadLibrary(str);
            z = true;
        } catch (Throwable th) {
            th.printStackTrace();
            z = false;
        }
        if (z) {
            return true;
        }
        if (AlaLiveRecorderConfig.getILoadLibraryCallback() != null) {
            return AlaLiveRecorderConfig.getILoadLibraryCallback().loadlibrary(str);
        }
        return false;
    }

    private static boolean loadLibrary(String str, String str2, StringBuilder sb) {
        boolean loadSoLibrary = loadSoLibrary(getLibFile(str, str2), sb);
        if (!loadSoLibrary) {
            try {
                System.loadLibrary(str);
                sb.append("-Succ3-");
                return true;
            } catch (Throwable th) {
                sb.append("-Error3:");
                sb.append(th.getClass().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.getMessage());
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                return loadSoLibrary;
            }
        }
        return loadSoLibrary;
    }

    private static boolean loadSoLibrary(String str, StringBuilder sb) {
        if (!new File(str).exists()) {
            sb.append("-Error1:");
            sb.append(str);
            sb.append("_FileNotFound-");
            return false;
        }
        try {
            System.load(str);
            return true;
        } catch (Throwable th) {
            sb.append("-Error2:");
            sb.append(th.getClass().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.getMessage());
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            return false;
        }
    }

    private static String getLibFile(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str2.endsWith(".apk")) {
            sb.append(str2.substring(0, str2.lastIndexOf(".apk")));
        } else {
            sb.append(str2);
        }
        sb.append(File.separator);
        sb.append("lib");
        sb.append(File.separator);
        sb.append("lib");
        sb.append(str);
        sb.append(PluginInstallerService.APK_LIB_SUFFIX);
        return sb.toString();
    }

    public static int getRealScreenOrientation(Context context) {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(context);
        int i = context.getResources().getConfiguration().orientation;
        if (i == 2 || screenDimensions[0] <= screenDimensions[1]) {
            return i;
        }
        return 2;
    }

    public static void getTextureMatrix(float[] fArr, float f, boolean z) {
        Matrix.setIdentityM(fArr, 0);
        Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
        Matrix.rotateM(fArr, 0, f - 180.0f, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        if (z) {
            Matrix.scaleM(fArr, 0, -1.0f, 1.0f, 1.0f);
        }
        Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
    }

    public static float[] getVertexArray(float f, float f2, float f3, float f4, boolean z) {
        float f5 = f2 / f4;
        float f6 = f / f3;
        float min = z ? Math.min(f5, f6) : Math.max(f5, f6);
        float f7 = (f4 * min) / f2;
        float f8 = (min * f3) / f;
        return new float[]{-f8, -f7, f8, -f7, -f8, f7, f8, f7};
    }

    public static boolean isClassValid(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static String getApkVersionName(Context context) {
        if (apkVersionName != null && apkVersionName.length() > 0) {
            return apkVersionName;
        }
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    apkVersionName = packageInfo.versionName;
                    return packageInfo.versionName;
                }
                return null;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
