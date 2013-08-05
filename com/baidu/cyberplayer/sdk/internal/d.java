package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
class d {
    /* renamed from: a  reason: collision with other method in class */
    public static String m15a(Context context) {
        ApplicationInfo a2 = a(context);
        if (a2 != null) {
            return a2.sourceDir;
        }
        return null;
    }

    public static String b(Context context) {
        if (context != null) {
            String libPath = CyberPlayerEngineConstants.getLibPath();
            return libPath == null ? context.getFilesDir().getAbsolutePath() + CyberPlayerEngineConstants.CYBERPLAYER_LIB_LOCAL_RELATIVE_PATH : libPath;
        }
        return null;
    }

    public static ApplicationInfo a(Context context) {
        PackageManager packageManager;
        if (context != null && (packageManager = context.getPackageManager()) != null) {
            try {
                return packageManager.getApplicationInfo(CyberPlayerEngineConstants.getEnginePkgName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m16a(Context context) {
        return a(context) != null;
    }

    public static String a() {
        try {
            byte[] bArr = new byte[1024];
            new RandomAccessFile("/proc/cpuinfo", "r").read(bArr);
            String str = new String(bArr);
            int indexOf = str.indexOf(0);
            if (indexOf != -1) {
                return str.substring(0, indexOf);
            }
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
