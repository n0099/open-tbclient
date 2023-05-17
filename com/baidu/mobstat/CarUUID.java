package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.system.Os;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class CarUUID {
    public static final Pattern a = Pattern.compile("(\\w{32})");

    public static String a(Context context) {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String b(Context context) {
        return a(context.getFileStreamPath("libdueros_uuid.so"));
    }

    public static String optUUID(Context context) {
        String b = b(context);
        if (b != null) {
            return b;
        }
        String c = c(context);
        if (c != null) {
            a(context, c);
            return c;
        }
        String a2 = a(context);
        if (a2 != null) {
            a(context, a2);
            return a2;
        }
        return "";
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        String str = null;
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
                String str2 = new String(bArr, 0, fileInputStream.read(bArr));
                if (a.matcher(str2).matches()) {
                    str = str2;
                }
                bt.a(fileInputStream);
                return str;
            } catch (Exception unused2) {
                bt.a(fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                bt.a(fileInputStream2);
                throw th;
            }
        }
        return null;
    }

    public static String c(Context context) {
        String a2;
        List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(0);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        for (ApplicationInfo applicationInfo2 : installedApplications) {
            if (!applicationInfo.packageName.equals(applicationInfo2.packageName) && (a2 = a(new File(new File(applicationInfo2.dataDir, NetDiskFileMsg.JSON_KEY_FILES), "libdueros_uuid.so"))) != null) {
                return a2;
            }
        }
        return null;
    }

    public static boolean a(Context context, String str) {
        int i;
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                i = 0;
            } else {
                i = 1;
            }
            fileOutputStream = context.openFileOutput("libdueros_uuid.so", i);
            if (a(fileOutputStream, str)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    File fileStreamPath = context.getFileStreamPath("libdueros_uuid.so");
                    if (a(new File(applicationInfo.dataDir), 457)) {
                        if (a(fileStreamPath, 484)) {
                            z = true;
                        }
                    }
                    bt.a(fileOutputStream);
                    return z;
                }
                bt.a(fileOutputStream);
                return true;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            bt.a(fileOutputStream);
            throw th;
        }
        bt.a(fileOutputStream);
        return false;
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

    public static boolean a(FileOutputStream fileOutputStream, String str) {
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
