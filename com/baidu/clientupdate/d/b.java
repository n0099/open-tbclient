package com.baidu.clientupdate.d;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.util.LogUtil;
import java.io.File;
/* loaded from: classes2.dex */
public final class b {
    public static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0226  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File a(Context context, long j, String str) {
        File file;
        boolean z;
        boolean z2;
        Runnable dVar;
        Handler handler = new Handler(context.getMainLooper());
        boolean a2 = a();
        boolean z3 = a(Environment.getExternalStorageDirectory()) > j;
        if (a2 && z3) {
            if (TextUtils.isEmpty(str)) {
                file = new File(Environment.getExternalStorageDirectory().getPath() + "/lcsdk/downloads");
            } else {
                file = new File(str);
            }
            LogUtil.logD("Helpers", "Common ExternalStorage path =======" + file);
        } else {
            Object[] f2 = j.f(context.getApplicationContext());
            if (f2 != null) {
                int length = f2.length;
                LogUtil.logD("Helpers", "TotalvolumeCount=" + length);
                int i = 0;
                while (true) {
                    if (i >= length) {
                        file = null;
                        break;
                    }
                    String a3 = j.a(f2[i]);
                    LogUtil.logD("Helpers", "invoke path[" + i + "]===========" + a3);
                    if (!j.c(context.getApplicationContext(), a3).equals("mounted") || a(new File(a3)) <= j) {
                        i++;
                    } else {
                        if (TextUtils.isEmpty(str)) {
                            file = new File(a3 + "/lcsdk/downloads");
                        } else {
                            file = new File(a3 + str);
                        }
                        LogUtil.logD("Helpers", "Other Volume path =======" + a3 + "/lcsdk/downloads");
                    }
                }
                z = true;
                if (file == null) {
                    z2 = false;
                } else if (a2) {
                    if (!z3) {
                        dVar = new c(context);
                        handler.post(dVar);
                    }
                    file = context.getFilesDir();
                    z2 = true;
                } else {
                    if (!z) {
                        dVar = new d(context);
                        handler.post(dVar);
                    }
                    file = context.getFilesDir();
                    z2 = true;
                }
                if (file != null || (!file.isDirectory() && !file.mkdirs())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unable to create downloads directory ");
                    sb.append(file != null ? null : file.getPath());
                    LogUtil.logE("Helpers", sb.toString());
                    handler.post(new e(context));
                    return null;
                }
                long a4 = a(file);
                long b2 = b(file);
                double d2 = a4;
                double d3 = b2;
                Double.isNaN(d2);
                Double.isNaN(d3);
                double d4 = d2 / d3;
                LogUtil.logD("Helpers", "download dir is: " + file.getAbsolutePath());
                LogUtil.logD("Helpers", "available space is: " + a4);
                LogUtil.logD("Helpers", "totalBytes space is: " + b2);
                LogUtil.logD("Helpers", "available/totalBytes percent is: " + d4);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("availablepercent<0.1 is: ");
                sb2.append(d4 < 0.1d);
                LogUtil.logD("Helpers", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" available < 20 * 1024 * 1024 is: ");
                sb3.append(a4 < DownloadManager.MIN_LEFT_SIZE);
                LogUtil.logD("Helpers", sb3.toString());
                if (z2) {
                    if (d4 < 0.1d || a4 < 2 * j || a4 < DownloadManager.MIN_LEFT_SIZE) {
                        handler.post(new f(context));
                        LogUtil.logD("Helpers", "download aborted - not enough free space on memory");
                        return null;
                    }
                } else if (a4 < j) {
                    LogUtil.logD("Helpers", "download aborted - not enough free space on external storage");
                }
                return file;
            }
            file = null;
        }
        z = false;
        if (file == null) {
        }
        if (file != null) {
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("unable to create downloads directory ");
        sb4.append(file != null ? null : file.getPath());
        LogUtil.logE("Helpers", sb4.toString());
        handler.post(new e(context));
        return null;
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
