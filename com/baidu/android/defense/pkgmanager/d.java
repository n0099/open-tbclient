package com.baidu.android.defense.pkgmanager;

import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.systemmonitor.util.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes.dex */
public final class d {
    private static d a;
    private Context b;

    private d(Context context) {
        this.b = context;
    }

    private PackageInfo a(Uri uri) {
        return this.b.getPackageManager().getPackageArchiveInfo(uri.getPath(), 0);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d(context);
            }
            dVar = a;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File a(Context context, File file) {
        String name;
        File fileStreamPath;
        if (file == null || (fileStreamPath = context.getFileStreamPath((name = file.getName()))) == null) {
            return null;
        }
        if (fileStreamPath.exists()) {
            fileStreamPath.delete();
        }
        try {
            try {
                context.openFileOutput(name, 1).close();
                if (com.baidu.android.systemmonitor.util.b.a(file, fileStreamPath)) {
                    return fileStreamPath;
                }
                return null;
            } catch (IOException e) {
                return null;
            }
        } catch (FileNotFoundException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Uri uri, IPackageInstallObserver iPackageInstallObserver, int i, String str) {
        int i2 = 0;
        PackageManager packageManager = this.b.getPackageManager();
        try {
            PackageInfo a2 = a(uri);
            if (a2 == null) {
                if (iPackageInstallObserver != null) {
                    iPackageInstallObserver.packageInstalled("unknown", -2);
                    return;
                }
                return;
            }
            try {
                i2 = packageManager.getPackageInfo(a2.packageName, 8192) == null ? 0 : 2;
            } catch (PackageManager.NameNotFoundException e) {
            }
            if (iPackageInstallObserver == null) {
                iPackageInstallObserver = null;
            }
            packageManager.getClass().getDeclaredMethod("installPackage", Uri.class, IPackageInstallObserver.class, Integer.TYPE, String.class).invoke(packageManager, uri, iPackageInstallObserver, Integer.valueOf(i2), str);
        } catch (Exception e2) {
        }
    }

    public static synchronized void b() {
        synchronized (d.class) {
            if (a != null) {
                a = null;
            }
        }
    }

    private void c(Context context, String str) {
        new com.baidu.android.defense.b(context, str).start();
    }

    public void a(Context context, String str) {
        PackageInfo b = f.b(context, context.getPackageName());
        if (b == null) {
            return;
        }
        if ((b.applicationInfo.flags & 1) != 1) {
            c(context, str);
        } else if (com.baidu.android.systemmonitor.util.b.a(this.b, "android.permission.DELETE_PACKAGES") != 0) {
            SilentPackageDeleteObserver silentPackageDeleteObserver = Build.VERSION.SDK_INT < 14 ? new SilentPackageDeleteObserver(str) : null;
            PackageManager packageManager = this.b.getPackageManager();
            try {
                packageManager.getClass().getDeclaredMethod("deletePackage", String.class, IPackageDeleteObserver.class, Integer.TYPE).invoke(packageManager, str, silentPackageDeleteObserver, 0);
            } catch (Exception e) {
            }
        }
    }

    public void a(String str, Context context) {
        PackageInfo b = f.b(context, context.getPackageName());
        if (b == null || (b.applicationInfo.flags & 1) != 1 || com.baidu.android.systemmonitor.util.b.a(this.b, "android.permission.INSTALL_PACKAGES") == 0) {
            return;
        }
        File file = new File(str);
        if (a()) {
            new b(this, "SystemMonitor_InstallAPKByPackageInstaller", file, context, str).start();
            return;
        }
        a(Uri.fromFile(file), new SilentPackageInstallObserver(context, str), 0, context.getPackageName());
    }

    public void a(boolean z, c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.a()) || com.baidu.android.systemmonitor.util.b.a(this.b, "android.permission.CHANGE_COMPONENT_ENABLED_STATE") == 0) {
            return;
        }
        PackageManager packageManager = this.b.getPackageManager();
        if (z) {
            try {
                packageManager.setApplicationEnabledSetting(cVar.a(), 1, 1);
                return;
            } catch (Exception e) {
                return;
            }
        }
        try {
            packageManager.setApplicationEnabledSetting(cVar.a(), 2, 1);
        } catch (Exception e2) {
        }
    }

    public void a(boolean z, String str) {
        if (TextUtils.isEmpty(str) || com.baidu.android.systemmonitor.util.b.a(this.b, "android.permission.CHANGE_COMPONENT_ENABLED_STATE") == 0) {
            return;
        }
        PackageManager packageManager = this.b.getPackageManager();
        if (z) {
            try {
                packageManager.setApplicationEnabledSetting(str, 1, 1);
                return;
            } catch (Exception e) {
                return;
            }
        }
        try {
            packageManager.setApplicationEnabledSetting(str, 2, 1);
        } catch (Exception e2) {
        }
    }

    public boolean a() {
        return Build.VERSION.SDK_INT == 7;
    }

    public void b(Context context, String str) {
        File fileStreamPath;
        if (TextUtils.isEmpty(str) || (fileStreamPath = context.getFileStreamPath(new File(str).getName())) == null || !fileStreamPath.exists()) {
            return;
        }
        fileStreamPath.delete();
    }

    public void b(String str, Context context) {
        PackageInfo b = f.b(context, context.getPackageName());
        if (b == null) {
            return;
        }
        if ((b.applicationInfo.flags & 1) != 1) {
            if (com.baidu.android.moplus.util.b.a(context).a()) {
                com.baidu.android.moplus.util.b.a(context).a("pm install -r '" + str + "'\n");
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
            intent.setFlags(1342177280);
            context.startActivity(intent);
        } else if (com.baidu.android.systemmonitor.util.b.a(this.b, "android.permission.INSTALL_PACKAGES") != 0) {
            File file = new File(str);
            if (a()) {
                new a(this, "SystemMonitor_InstallAPKByPackageInstaller", file, context, str).start();
                return;
            }
            a(Uri.fromFile(file), new SilentPackageInstallObserver(context, str), 0, context.getPackageName());
        }
    }
}
