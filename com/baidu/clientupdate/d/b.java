package com.baidu.clientupdate.d;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.util.LogUtil;
import java.io.File;
/* loaded from: classes5.dex */
public final class b {
    public static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
    }

    public static File a(Context context, long j, String str) {
        File file;
        Handler handler = new Handler(context.getMainLooper());
        boolean z = false;
        boolean z2 = false;
        boolean a2 = a();
        boolean z3 = a(Environment.getExternalStorageDirectory()) > j;
        if (a2 && z3) {
            File file2 = TextUtils.isEmpty(str) ? new File(Environment.getExternalStorageDirectory().getPath() + "/lcsdk/downloads") : new File(str);
            LogUtil.logD("Helpers", "Common ExternalStorage path =======" + file2);
            file = file2;
        } else {
            Object[] f = j.f(context.getApplicationContext());
            if (f != null) {
                z = true;
                int length = f.length;
                LogUtil.logD("Helpers", "TotalvolumeCount=" + length);
                for (int i = 0; i < length; i++) {
                    String a3 = j.a(f[i]);
                    LogUtil.logD("Helpers", "invoke path[" + i + "]===========" + a3);
                    if (j.c(context.getApplicationContext(), a3).equals("mounted") && a(new File(a3)) > j) {
                        File file3 = TextUtils.isEmpty(str) ? new File(a3 + "/lcsdk/downloads") : new File(a3 + str);
                        LogUtil.logD("Helpers", "Other Volume path =======" + a3 + "/lcsdk/downloads");
                        file = file3;
                    }
                }
            }
            file = null;
        }
        if (file == null) {
            if (a2) {
                if (!z3) {
                    handler.post(new c(context));
                }
            } else if (!z) {
                handler.post(new d(context));
            }
            file = context.getFilesDir();
            z2 = true;
        }
        if (file == null || !(file.isDirectory() || file.mkdirs())) {
            LogUtil.logE("Helpers", "unable to create downloads directory " + (file == null ? null : file.getPath()));
            handler.post(new e(context));
            return null;
        }
        long a4 = a(file);
        long b2 = b(file);
        double d = a4 / b2;
        LogUtil.logD("Helpers", "download dir is: " + file.getAbsolutePath());
        LogUtil.logD("Helpers", "available space is: " + a4);
        LogUtil.logD("Helpers", "totalBytes space is: " + b2);
        LogUtil.logD("Helpers", "available/totalBytes percent is: " + (a4 / b2));
        LogUtil.logD("Helpers", "availablepercent<0.1 is: " + (d < 0.1d));
        LogUtil.logD("Helpers", " available < 20 * 1024 * 1024 is: " + (a4 < 20971520));
        if (z2) {
            if (d < 0.1d || a4 < 2 * j || a4 < 20971520) {
                handler.post(new f(context));
                LogUtil.logD("Helpers", "download aborted - not enough free space on memory");
                return null;
            }
        } else if (a4 < j) {
            LogUtil.logD("Helpers", "download aborted - not enough free space on external storage");
        }
        return file;
    }

    public static boolean a() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        LogUtil.logD("Helpers", "no external storage");
        return false;
    }

    public static long b(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSize() * (statFs.getBlockCount() - 4);
    }
}
