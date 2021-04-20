package com.baidu.adp.plugin.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import d.b.c.e.m.b;
import d.b.c.e.p.f;
import d.b.c.e.p.m;
import d.b.c.e.p.q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashSet;
import kotlin.UShort;
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

        /* renamed from: a  reason: collision with root package name */
        public boolean f2273a = false;

        /* renamed from: b  reason: collision with root package name */
        public String f2274b = null;

        /* renamed from: c  reason: collision with root package name */
        public int f2275c = 0;
    }

    public static void a(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return;
                }
                for (File file2 : listFiles) {
                    try {
                        f(file2);
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                }
            } catch (Exception e3) {
                BdLog.e(e3);
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
            return hashSet.equals(hashSet2) ? 0 : -3;
        }
    }

    public static VersionCompare c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return VersionCompare.LESS;
        }
        if (TextUtils.isEmpty(str2)) {
            return VersionCompare.GREATER;
        }
        if (str.equals(str2)) {
            return VersionCompare.EQUAL;
        }
        String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        int length = split.length;
        int length2 = split2.length;
        int i = length < length2 ? length : length2;
        for (int i2 = 0; i2 < i; i2++) {
            int d2 = b.d(split[i2], 0);
            int d3 = b.d(split2[i2], 0);
            if (d2 > d3) {
                return VersionCompare.GREATER;
            }
            if (d2 < d3) {
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

    public static a d(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        a aVar = new a();
        if (inputStream != null && file != null) {
            if (file.exists()) {
                f.n(file);
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
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
                aVar.f2273a = true;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                aVar.f2273a = false;
                aVar.f2274b = e.toString();
                d.b.c.e.m.a.d(fileOutputStream2);
                return aVar;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                d.b.c.e.m.a.d(fileOutputStream2);
                throw th;
            }
            d.b.c.e.m.a.d(fileOutputStream2);
            return aVar;
        }
        aVar.f2274b = "illegal_param";
        return aVar;
    }

    public static void e(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        a(file);
        try {
            file.delete();
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public static void f(File file) {
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            e(file);
        } else if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public static long g() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e2) {
            BdLog.e(e2);
            return 0L;
        }
    }

    public static String h(ApplicationInfo applicationInfo) {
        if (applicationInfo == null || applicationInfo.metaData == null) {
            return null;
        }
        StringBuilder sb = null;
        int i = 0;
        while (true) {
            Bundle bundle = applicationInfo.metaData;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("cmd_range_");
            int i2 = i + 1;
            sb2.append(i);
            String string = bundle.getString(sb2.toString());
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

    public static File i(String str) {
        String str2;
        PluginSetting P = PluginPackageManager.O().P(str);
        if (P == null || (str2 = P.apkPath) == null || str2.length() <= 4) {
            return null;
        }
        String str3 = P.apkPath;
        return new File(str3.substring(0, str3.length() - 4));
    }

    public static String j(PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            return null;
        }
        return pluginSetting.packageName + ".apk_" + pluginSetting.tempVersionCode;
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str + ".apk_";
    }

    public static String l(PluginSetting pluginSetting) {
        if (pluginSetting == null) {
            return null;
        }
        return m() + File.separator + j(pluginSetting);
    }

    public static File m() {
        try {
            File dir = BdBaseApplication.getInst().getDir("plugins", 0);
            if (!dir.exists()) {
                if (!dir.mkdir()) {
                    return null;
                }
            }
            return dir;
        } catch (Exception e2) {
            BdLog.e(e2);
            return null;
        }
    }

    public static String n(ApplicationInfo applicationInfo) {
        Bundle bundle;
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return null;
        }
        return bundle.getString("replace_method_classes", null);
    }

    public static String o(ApplicationInfo applicationInfo) {
        Bundle bundle;
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return null;
        }
        return String.valueOf(bundle.getInt("require_load"));
    }

    public static boolean p(ApplicationInfo applicationInfo) {
        Bundle bundle;
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return false;
        }
        return bundle.getBoolean("has_res", false);
    }

    public static boolean q() {
        try {
            String property = System.getProperty("java.vm.version");
            if (property != null) {
                return property.startsWith("2");
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean r(ApplicationInfo applicationInfo) {
        Bundle bundle;
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return false;
        }
        return bundle.getBoolean("is_inject_classloader");
    }

    public static boolean s(ApplicationInfo applicationInfo) {
        Bundle bundle;
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return false;
        }
        return bundle.getBoolean("is_patch", false);
    }

    public static boolean t() {
        try {
            return Build.VERSION.class.getField("PREVIEW_SDK_INT").getInt(null) > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final boolean u(long j) {
        long g2 = g();
        if (j <= 0) {
            return g2 <= 0 || g2 >= 31457280;
        }
        long j2 = j * (Build.VERSION.SDK_INT < 19 ? 6 : 10);
        return (j2 <= 31457280 ? j2 : 31457280L) < g2;
    }

    public static boolean v(ApplicationInfo applicationInfo) {
        Bundle bundle;
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return false;
        }
        return bundle.getBoolean("is_third", false);
    }

    public static int w(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        return ((short) ((bArr[i] & 255) | (bArr[i + 1] << 8))) & UShort.MAX_VALUE;
    }

    public static d.b.c.h.k.f x(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[26];
        if (inputStream.read(new byte[4]) == -1 || inputStream.read(bArr, 0, 26) == -1) {
            return null;
        }
        int w = w(bArr, 6);
        int w2 = w(bArr, 8);
        d.b.c.h.k.f fVar = new d.b.c.h.k.f();
        fVar.b(((w2 >> 9) & 127) + 1980, (w2 >> 5) & 15, w2 & 31, (w >> 11) & 31, (w >> 5) & 63, (w & 31) << 1);
        return fVar;
    }

    public static String y(InputStream inputStream, byte[] bArr) {
        String str = null;
        if (inputStream == null) {
            return null;
        }
        try {
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
                str = q.a(messageDigest.digest());
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
            return str;
        } finally {
            m.e(inputStream);
        }
    }
}
