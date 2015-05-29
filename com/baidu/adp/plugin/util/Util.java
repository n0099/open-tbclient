package com.baidu.adp.plugin.util;

import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class Util {

    /* loaded from: classes.dex */
    public enum VersionCompare {
        EQUAL,
        LESS,
        GREATER;

        /* JADX DEBUG: Replace access to removed values field (EM) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static VersionCompare[] valuesCustom() {
            VersionCompare[] valuesCustom = values();
            int length = valuesCustom.length;
            VersionCompare[] versionCompareArr = new VersionCompare[length];
            System.arraycopy(valuesCustom, 0, versionCompareArr, 0, length);
            return versionCompareArr;
        }
    }

    public static i g(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[26];
        if (inputStream.read(new byte[4]) == -1 || inputStream.read(bArr, 0, bArr.length) == -1) {
            return null;
        }
        int e = e(bArr, 6);
        int e2 = e(bArr, 8);
        i iVar = new i();
        iVar.set(((e2 >> 9) & TransportMediator.KEYCODE_MEDIA_PAUSE) + 1980, (e2 >> 5) & 15, e2 & 31, (e >> 11) & 31, (e >> 5) & 63, (e & 31) << 1);
        return iVar;
    }

    private static int e(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        return ((short) ((bArr[i + 1] << 8) | (bArr[i] & 255))) & 65535;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, CONST_STR, RETURN] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=4, 91=4, 92=4, 93=4, 94=4, 96=4, 99=4] */
    public static String b(InputStream inputStream, File file) {
        if (inputStream == null || file == null) {
            return "illegal_param";
        }
        try {
            try {
                if (file.exists()) {
                    file.delete();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read < 0) {
                                fileOutputStream.flush();
                                try {
                                    fileOutputStream.getFD().sync();
                                    fileOutputStream.close();
                                    return null;
                                } catch (IOException e) {
                                    return (e == null || TextUtils.isEmpty(e.getMessage())) ? "unknown_error" : e.getMessage();
                                }
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (Throwable th) {
                        fileOutputStream.flush();
                        try {
                            fileOutputStream.getFD().sync();
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException e2) {
                            return (e2 == null || TextUtils.isEmpty(e2.getMessage())) ? "unknown_error" : e2.getMessage();
                        }
                    }
                } catch (Exception e3) {
                    if (e3 == null || TextUtils.isEmpty(e3.getMessage())) {
                        fileOutputStream.flush();
                        try {
                            fileOutputStream.getFD().sync();
                            fileOutputStream.close();
                            return "unknown_error";
                        } catch (IOException e4) {
                            return (e4 == null || TextUtils.isEmpty(e4.getMessage())) ? "unknown_error" : e4.getMessage();
                        }
                    }
                    String message = e3.getMessage();
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.getFD().sync();
                        fileOutputStream.close();
                        return message;
                    } catch (IOException e5) {
                        return (e5 == null || TextUtils.isEmpty(e5.getMessage())) ? "unknown_error" : e5.getMessage();
                    }
                }
            } catch (IOException e6) {
                BdLog.e(e6);
                return (e6 == null || TextUtils.isEmpty(e6.getMessage())) ? "unknown_error" : e6.getMessage();
            }
        } catch (Exception e7) {
            return (e7 == null || TextUtils.isEmpty(e7.getMessage())) ? "unknown_error" : e7.getMessage();
        }
    }

    public static void f(File file) {
        if (file != null && file.exists()) {
            h(file);
            try {
                file.delete();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public static void h(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        try {
                            i(file2);
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public static void i(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                f(file);
            } else if (file.exists()) {
                try {
                    file.delete();
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    public static File bL(String str) {
        PluginSetting bs = PluginPackageManager.lM().bs(str);
        if (bs == null || bs.apkPath == null || bs.apkPath.length() <= ".apk".length()) {
            return null;
        }
        return new File(bs.apkPath.substring(0, bs.apkPath.length() - ".apk".length()));
    }

    public static File mo() {
        try {
            File dir = BdBaseApplication.getInst().getDir("plugins", 0);
            if (!dir.exists()) {
                if (!dir.mkdir()) {
                    return null;
                }
            }
            return dir;
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public static String a(ApplicationInfo applicationInfo) {
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return null;
        }
        int i = 0;
        StringBuilder sb = null;
        while (true) {
            int i2 = i + 1;
            String string = applicationInfo.metaData.getString("cmd_range_" + i);
            if (TextUtils.isEmpty(string)) {
                break;
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(string);
            sb.append(",");
            i = i2;
        }
        if (sb == null || sb.length() <= 0) {
            return null;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String b(ApplicationInfo applicationInfo) {
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return null;
        }
        return String.valueOf(applicationInfo.metaData.getInt("require_load"));
    }

    public static boolean c(ApplicationInfo applicationInfo) {
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return false;
        }
        return applicationInfo.metaData.getBoolean("is_inject_classloader");
    }

    public static boolean d(ApplicationInfo applicationInfo) {
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return false;
        }
        return applicationInfo.metaData.getBoolean("has_res", false);
    }

    public static VersionCompare R(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return VersionCompare.LESS;
        }
        if (TextUtils.isEmpty(str2)) {
            return VersionCompare.GREATER;
        }
        if (str.equals(str2)) {
            return VersionCompare.EQUAL;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int i = length < length2 ? length : length2;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = com.baidu.adp.lib.g.c.toInt(split[i2], 0);
            int i4 = com.baidu.adp.lib.g.c.toInt(split2[i2], 0);
            if (i3 > i4) {
                return VersionCompare.GREATER;
            }
            if (i3 < i4) {
                return VersionCompare.LESS;
            }
        }
        if (length == length2) {
            return VersionCompare.EQUAL;
        }
        if (length2 > length) {
            return VersionCompare.LESS;
        }
        return VersionCompare.GREATER;
    }

    public static String e(PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            return null;
        }
        return String.valueOf(pluginSetting.packageName) + ".apk_" + pluginSetting.tempVersionCode;
    }

    public static String bM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.valueOf(str) + ".apk_";
    }

    public static String f(PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            return null;
        }
        return mo() + File.separator + e(pluginSetting);
    }

    public static long mp() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e) {
            BdLog.e(e);
            return 0L;
        }
    }
}
