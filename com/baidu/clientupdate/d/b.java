package com.baidu.clientupdate.d;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.util.LogUtil;
import java.io.File;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            StatFs statFs = new StatFs(file.getPath());
            return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
        }
        return invokeL.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0220  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File a(Context context, long j2, String str) {
        InterceptResult invokeCommon;
        File file;
        boolean z;
        boolean z2;
        Runnable dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Long.valueOf(j2), str})) == null) {
            Handler handler = new Handler(context.getMainLooper());
            boolean a2 = a();
            boolean z3 = a(Environment.getExternalStorageDirectory()) > j2;
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
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            file = null;
                            break;
                        }
                        String a3 = j.a(f2[i2]);
                        LogUtil.logD("Helpers", "invoke path[" + i2 + "]===========" + a3);
                        if (!j.c(context.getApplicationContext(), a3).equals("mounted") || a(new File(a3)) <= j2) {
                            i2++;
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
                    double d2 = a4 / b2;
                    LogUtil.logD("Helpers", "download dir is: " + file.getAbsolutePath());
                    LogUtil.logD("Helpers", "available space is: " + a4);
                    LogUtil.logD("Helpers", "totalBytes space is: " + b2);
                    LogUtil.logD("Helpers", "available/totalBytes percent is: " + d2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("availablepercent<0.1 is: ");
                    int i3 = (d2 > 0.1d ? 1 : (d2 == 0.1d ? 0 : -1));
                    sb2.append(i3 < 0);
                    LogUtil.logD("Helpers", sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(" available < 20 * 1024 * 1024 is: ");
                    int i4 = (a4 > DownloadManager.MIN_LEFT_SIZE ? 1 : (a4 == DownloadManager.MIN_LEFT_SIZE ? 0 : -1));
                    sb3.append(i4 < 0);
                    LogUtil.logD("Helpers", sb3.toString());
                    if (z2) {
                        if (i3 < 0 || a4 < 2 * j2 || i4 < 0) {
                            handler.post(new f(context));
                            LogUtil.logD("Helpers", "download aborted - not enough free space on memory");
                            return null;
                        }
                    } else if (a4 < j2) {
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
        return (File) invokeCommon.objValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return true;
            }
            LogUtil.logD("Helpers", "no external storage");
            return false;
        }
        return invokeV.booleanValue;
    }

    public static long b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            StatFs statFs = new StatFs(file.getPath());
            return statFs.getBlockSize() * (statFs.getBlockCount() - 4);
        }
        return invokeL.longValue;
    }
}
