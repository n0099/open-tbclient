package com.baidu.adp.plugin.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class Util {

    /* loaded from: classes.dex */
    public enum VersionCompare {
        EQUAL,
        LESS,
        GREATER
    }

    public static boolean mx() {
        try {
            String property = System.getProperty("java.vm.version");
            if (property != null) {
                return property.startsWith("2");
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static f h(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[26];
        if (inputStream.read(new byte[4]) == -1 || inputStream.read(bArr, 0, bArr.length) == -1) {
            return null;
        }
        int d = d(bArr, 6);
        int d2 = d(bArr, 8);
        f fVar = new f();
        fVar.set(((d2 >> 9) & 127) + 1980, (d2 >> 5) & 15, d2 & 31, (d >> 11) & 31, (d >> 5) & 63, (d & 31) << 1);
        return fVar;
    }

    private static int d(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        return ((short) ((bArr[i + 1] << 8) | (bArr[i] & 255))) & 65535;
    }

    public static final boolean o(long j) {
        long mz = mz();
        if (j <= 0) {
            return mz <= 0 || mz >= 31457280;
        }
        int i = 10;
        if (Build.VERSION.SDK_INT < 19) {
            i = 6;
        }
        long j2 = i * j;
        return (j2 <= 31457280 ? j2 : 31457280L) < mz;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [160=4, 162=4, 163=4, 164=4, 165=4, 167=4, 170=4] */
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

    public static void l(File file) {
        if (file != null && file.exists()) {
            j(file);
            try {
                file.delete();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public static void j(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        try {
                            k(file2);
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

    public static void k(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                l(file);
            } else if (file.exists()) {
                try {
                    file.delete();
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    public static int b(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == null) {
            return signatureArr2 == null ? 1 : -1;
        } else if (signatureArr2 == null) {
            return -2;
        } else {
            HashSet hashSet = new HashSet();
            for (Signature signature : signatureArr) {
                hashSet.add(signature);
            }
            HashSet hashSet2 = new HashSet();
            for (Signature signature2 : signatureArr2) {
                hashSet2.add(signature2);
            }
            return !hashSet.equals(hashSet2) ? -3 : 0;
        }
    }

    public static File bX(String str) {
        PluginSetting bA = PluginPackageManager.lL().bA(str);
        if (bA == null || bA.apkPath == null || bA.apkPath.length() <= ".apk".length()) {
            return null;
        }
        return new File(bA.apkPath.substring(0, bA.apkPath.length() - ".apk".length()));
    }

    public static File my() {
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

    public static boolean e(ApplicationInfo applicationInfo) {
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return false;
        }
        return applicationInfo.metaData.getBoolean("is_third", false);
    }

    public static boolean f(ApplicationInfo applicationInfo) {
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return false;
        }
        return applicationInfo.metaData.getBoolean("is_patch", false);
    }

    public static String g(ApplicationInfo applicationInfo) {
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return null;
        }
        return applicationInfo.metaData.getString("replace_method_classes", null);
    }

    public static VersionCompare J(String str, String str2) {
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
            int g = com.baidu.adp.lib.g.b.g(split[i2], 0);
            int g2 = com.baidu.adp.lib.g.b.g(split2[i2], 0);
            if (g > g2) {
                return VersionCompare.GREATER;
            }
            if (g < g2) {
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
        return pluginSetting.packageName + ".apk_" + pluginSetting.tempVersionCode;
    }

    public static String bY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str + ".apk_";
    }

    public static String f(PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            return null;
        }
        return my() + File.separator + e(pluginSetting);
    }

    public static long mz() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e) {
            BdLog.e(e);
            return 0L;
        }
    }

    public static boolean isPreview() {
        try {
            return Build.VERSION.class.getField("PREVIEW_SDK_INT").getInt(null) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
