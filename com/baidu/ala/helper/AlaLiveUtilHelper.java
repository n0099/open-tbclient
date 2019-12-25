package com.baidu.ala.helper;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.Matrix;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.ala.recorder.AlaLiveRecorderConfig;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class AlaLiveUtilHelper {
    private static final String ALA_PLUGIN_NAME = "com.baidu.tieba.pluginAla";
    public static final int ALIVE_SDK_PLATFORM = 4;
    public static final int HK_SDK_PLATFORM = 2;
    public static final int QM_SDK_PLATFORM = 3;
    public static final int TB_SDK_PLATFORM = 1;

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

    public static int getCpuCoreCount() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new CpuFilter()).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static float getCpuMaxFreq(int i) {
        long j = 0;
        for (int i2 = 0; i2 < i && i2 < 32; i2++) {
            try {
                FileReader fileReader = new FileReader(String.format("/sys/devices/system/cpu/cpu%d/cpufreq/cpuinfo_max_freq", Integer.valueOf(i2)));
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String readLine = bufferedReader.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    bufferedReader.close();
                    fileReader.close();
                } else {
                    long parseLong = Long.parseLong(readLine);
                    if (parseLong > j) {
                        j = parseLong;
                    }
                    bufferedReader.close();
                    fileReader.close();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return (float) (j / TimeUtils.NANOS_PER_MS);
    }

    public static float getRamSize() {
        long j;
        Exception e;
        FileReader fileReader;
        BufferedReader bufferedReader;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager == null) {
                j = 0;
            } else {
                activityManager.getMemoryInfo(memoryInfo);
                j = memoryInfo.totalMem;
            }
        } else {
            try {
                fileReader = new FileReader("/proc/meminfo");
                bufferedReader = new BufferedReader(fileReader);
                j = Long.parseLong(bufferedReader.readLine());
            } catch (Exception e2) {
                j = 0;
                e = e2;
            }
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return ((float) j) / 1.0737418E9f;
            }
        }
        return ((float) j) / 1.0737418E9f;
    }

    /* loaded from: classes2.dex */
    static class CpuFilter implements FileFilter {
        CpuFilter() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
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
}
