package com.baidu.adp.plugin.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.lib.util.s;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class Util {

    /* loaded from: classes.dex */
    public enum VersionCompare {
        EQUAL,
        LESS,
        GREATER
    }

    /* loaded from: classes.dex */
    public static class a {
        public boolean isSuccess = false;
        public String error = null;
        public int step = 0;
    }

    public static boolean pa() {
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

    public static String a(InputStream inputStream, byte[] bArr) {
        String str = null;
        if (inputStream != null) {
            try {
                byte[] bArr2 = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                if (bArr != null && bArr.length > 0) {
                    messageDigest.update(bArr, 0, bArr.length);
                }
                while (true) {
                    int read = inputStream.read(bArr2);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr2, 0, read);
                }
                str = s.toHexString(messageDigest.digest());
            } catch (Exception e) {
                BdLog.e(e.toString());
            } finally {
                n.close(inputStream);
            }
        }
        return str;
    }

    public static f g(InputStream inputStream) throws IOException {
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
        fVar.d(((d2 >> 9) & 127) + 1980, (d2 >> 5) & 15, d2 & 31, (d >> 11) & 31, (d >> 5) & 63, (d & 31) << 1);
        return fVar;
    }

    private static int d(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        return ((short) ((bArr[i + 1] << 8) | (bArr[i] & 255))) & 65535;
    }

    public static final boolean O(long j) {
        long pc = pc();
        if (j <= 0) {
            return pc <= 0 || pc >= 31457280;
        }
        int i = 10;
        if (Build.VERSION.SDK_INT < 19) {
            i = 6;
        }
        long j2 = i * j;
        return (j2 <= 31457280 ? j2 : 31457280L) < pc;
    }

    public static a b(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        a aVar = new a();
        if (inputStream == null || file == null) {
            aVar.error = "illegal_param";
        } else {
            if (file.exists()) {
                com.baidu.adp.lib.util.f.deleteQuietly(file);
            }
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        aVar.isSuccess = true;
                        com.baidu.adp.lib.f.a.close((OutputStream) null);
                    } catch (Exception e) {
                        e = e;
                        aVar.isSuccess = false;
                        aVar.error = e.toString();
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                        return aVar;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                throw th;
            }
        }
        return aVar;
    }

    public static void deleteDirectory(File file) {
        if (file != null && file.exists()) {
            cleanDirectory(file);
            try {
                file.delete();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public static void cleanDirectory(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        try {
                            forceDelete(file2);
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

    public static void forceDelete(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                deleteDirectory(file);
            } else if (file.exists()) {
                try {
                    file.delete();
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    public static int a(Signature[] signatureArr, Signature[] signatureArr2) {
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

    public static File cL(String str) {
        PluginSetting cq = PluginPackageManager.op().cq(str);
        if (cq == null || cq.apkPath == null || cq.apkPath.length() <= ".apk".length()) {
            return null;
        }
        return new File(cq.apkPath.substring(0, cq.apkPath.length() - ".apk".length()));
    }

    public static File pb() {
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
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
            int i3 = com.baidu.adp.lib.f.b.toInt(split[i2], 0);
            int i4 = com.baidu.adp.lib.f.b.toInt(split2[i2], 0);
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
        return pluginSetting.packageName + ".apk" + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + pluginSetting.tempVersionCode;
    }

    public static String cM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str + ".apk_";
    }

    public static String f(PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            return null;
        }
        return pb() + File.separator + e(pluginSetting);
    }

    public static long pc() {
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
