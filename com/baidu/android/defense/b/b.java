package com.baidu.android.defense.b;

import android.content.Context;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f623a;
    private Context b;

    private b(Context context) {
        this.b = context;
    }

    private PackageInfo a(Uri uri) {
        return this.b.getPackageManager().getPackageArchiveInfo(uri.getPath(), 0);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f623a == null) {
                f623a = new b(context);
            }
            bVar = f623a;
        }
        return bVar;
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
                if (com.baidu.android.systemmonitor.d.c.a(file, fileStreamPath)) {
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
        synchronized (b.class) {
            if (f623a != null) {
                f623a = null;
            }
        }
    }

    public void a(Context context, String str) {
        if (com.baidu.android.systemmonitor.d.c.a(this.b, "android.permission.DELETE_PACKAGES") == 0) {
            return;
        }
        d dVar = Build.VERSION.SDK_INT < 14 ? new d(str) : null;
        PackageManager packageManager = this.b.getPackageManager();
        try {
            packageManager.getClass().getDeclaredMethod("deletePackage", String.class, IPackageDeleteObserver.class, Integer.TYPE).invoke(packageManager, str, dVar, 0);
        } catch (Exception e) {
        }
    }

    public void a(String str, Context context) {
        if (com.baidu.android.systemmonitor.d.c.a(this.b, "android.permission.INSTALL_PACKAGES") == 0) {
            return;
        }
        File file = new File(str);
        if (a()) {
            new c(this, "SystemMonitor_InstallAPKByPackageInstaller", file, context, str).start();
            return;
        }
        a(Uri.fromFile(file), new e(context, str), 0, context.getPackageName());
    }

    public void a(boolean z, a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.a()) || com.baidu.android.systemmonitor.d.c.a(this.b, "android.permission.CHANGE_COMPONENT_ENABLED_STATE") == 0) {
            return;
        }
        PackageManager packageManager = this.b.getPackageManager();
        if (z) {
            try {
                packageManager.setApplicationEnabledSetting(aVar.a(), 1, 1);
                return;
            } catch (Exception e) {
                return;
            }
        }
        try {
            packageManager.setApplicationEnabledSetting(aVar.a(), 2, 1);
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
}
