package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.system.Os;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class CarUUID {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f2488a = Pattern.compile("(\\w{32})");

    public static String optUUID(Context context) {
        String b = b(context);
        if (b == null) {
            String c = c(context);
            if (c != null) {
                a(context, c);
                return c;
            }
            String d = d(context);
            if (d != null) {
                a(context, d);
                b(context, d);
                return d;
            }
            String a2 = a(context);
            if (a2 != null) {
                a(context, a2);
                b(context, a2);
                return a2;
            }
            return "";
        }
        return b;
    }

    private static String a(Context context) {
        return UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    private static String b(Context context) {
        return a(context.getFileStreamPath("libdueros_uuid.so"));
    }

    private static String c(Context context) {
        if (!c(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            return null;
        }
        return a(new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".dueros_uuid"));
    }

    private static String d(Context context) {
        String a2;
        List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(0);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        for (ApplicationInfo applicationInfo2 : installedApplications) {
            if (!applicationInfo.packageName.equals(applicationInfo2.packageName) && (a2 = a(new File(new File(applicationInfo2.dataDir, com.baidu.fsg.face.base.b.c.g), "libdueros_uuid.so"))) != null) {
                return a2;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (a(r4, 484) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(Context context, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream openFileOutput;
        boolean z = true;
        try {
            try {
                openFileOutput = context.openFileOutput("libdueros_uuid.so", Build.VERSION.SDK_INT >= 21 ? 0 : 1);
            } catch (Exception e) {
                fileOutputStream = null;
            }
            try {
            } catch (Exception e2) {
                fileOutputStream = openFileOutput;
                bu.a(fileOutputStream);
                return false;
            }
            if (!a(openFileOutput, str)) {
                bu.a(openFileOutput);
                return false;
            } else if (Build.VERSION.SDK_INT >= 21) {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                File fileStreamPath = context.getFileStreamPath("libdueros_uuid.so");
                if (a(new File(applicationInfo.dataDir), 457)) {
                }
                z = false;
                bu.a(openFileOutput);
                return z;
            } else {
                bu.a(openFileOutput);
                return true;
            }
        } catch (Throwable th) {
            bu.a(null);
            throw th;
        }
    }

    private static boolean b(Context context, String str) {
        FileOutputStream fileOutputStream;
        boolean z = false;
        if (c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".dueros_uuid"));
            } catch (Exception e) {
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                z = a(fileOutputStream, str);
                bu.a(fileOutputStream);
            } catch (Exception e2) {
                bu.a(fileOutputStream);
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                bu.a(fileOutputStream2);
                throw th;
            }
        }
        return z;
    }

    private static String a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e) {
                fileInputStream2 = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                String str = new String(bArr, 0, fileInputStream.read(bArr));
                if (!f2488a.matcher(str).matches()) {
                    str = null;
                }
                bu.a(fileInputStream);
                return str;
            } catch (Exception e2) {
                fileInputStream2 = fileInputStream;
                bu.a(fileInputStream2);
                return null;
            } catch (Throwable th2) {
                th = th2;
                bu.a(fileInputStream);
                throw th;
            }
        }
        return null;
    }

    private static boolean a(FileOutputStream fileOutputStream, String str) {
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean a(File file, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        try {
            Os.chmod(file.getAbsolutePath(), i);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean c(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
