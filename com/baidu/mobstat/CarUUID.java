package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.system.Os;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class CarUUID {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f8770a = Pattern.compile("(\\w{32})");

    public static String a(Context context) {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String b(Context context) {
        return a(context.getFileStreamPath("libdueros_uuid.so"));
    }

    public static String c(Context context) {
        if (c(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            return a(new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".dueros_uuid"));
        }
        return null;
    }

    public static String d(Context context) {
        String a2;
        List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(0);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        for (ApplicationInfo applicationInfo2 : installedApplications) {
            if (!applicationInfo.packageName.equals(applicationInfo2.packageName) && (a2 = a(new File(new File(applicationInfo2.dataDir, com.baidu.fsg.face.base.b.c.f5556g), "libdueros_uuid.so"))) != null) {
                return a2;
            }
        }
        return null;
    }

    public static String optUUID(Context context) {
        String b2 = b(context);
        if (b2 != null) {
            return b2;
        }
        String c2 = c(context);
        if (c2 != null) {
            a(context, c2);
            return c2;
        }
        String d2 = d(context);
        if (d2 != null) {
            a(context, d2);
            b(context, d2);
            return d2;
        }
        String a2 = a(context);
        if (a2 != null) {
            a(context, a2);
            b(context, a2);
            return a2;
        }
        return "";
    }

    public static boolean a(Context context, String str) {
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput("libdueros_uuid.so", Build.VERSION.SDK_INT >= 21 ? 0 : 1);
            if (a(fileOutputStream, str)) {
                if (Build.VERSION.SDK_INT < 21) {
                    bu.a(fileOutputStream);
                    return true;
                }
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                File fileStreamPath = context.getFileStreamPath("libdueros_uuid.so");
                if (a(new File(applicationInfo.dataDir), 457)) {
                    if (a(fileStreamPath, 484)) {
                        z = true;
                    }
                }
                bu.a(fileOutputStream);
                return z;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            bu.a(fileOutputStream);
            throw th;
        }
        bu.a(fileOutputStream);
        return false;
    }

    public static boolean b(Context context, String str) {
        FileOutputStream fileOutputStream;
        Throwable th;
        if (!c(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".dueros_uuid"));
            try {
                boolean a2 = a(fileOutputStream, str);
                bu.a(fileOutputStream);
                return a2;
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
                bu.a(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                bu.a(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }

    public static boolean c(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                String str = new String(bArr, 0, fileInputStream.read(bArr));
                String str2 = f8770a.matcher(str).matches() ? str : null;
                bu.a(fileInputStream);
                return str2;
            } catch (Exception unused2) {
                bu.a(fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                bu.a(fileInputStream2);
                throw th;
            }
        }
        return null;
    }

    public static boolean a(FileOutputStream fileOutputStream, String str) {
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean a(File file, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        try {
            Os.chmod(file.getAbsolutePath(), i);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
