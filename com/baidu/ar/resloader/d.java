package com.baidu.ar.resloader;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.ar.algo.ARAlgoJniClient;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.ARSDKInfo;
import com.baidu.ar.util.FileUtils;
import com.baidu.ar.util.MD5Utils;
import com.baidu.baiduarsdk.ArBridge;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes3.dex */
public class d {
    private final Context a;
    private c b;
    private a c;
    private e d;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z);
    }

    public d(Context context) {
        this.a = context;
        this.d = new e(context);
    }

    public static File a(Context context) {
        File file = new File(context.getFilesDir(), "baiduarsolib");
        FileUtils.ensureParent(file);
        return file;
    }

    private void a(boolean z) {
        if (this.c != null) {
            this.c.a(z);
        }
    }

    public static boolean a(File file) {
        return a(b(file));
    }

    private static boolean a(File[] fileArr) {
        if (b(fileArr)) {
            if (fileArr != null) {
                for (File file : fileArr) {
                    if (!c(file)) {
                        return false;
                    }
                }
            }
            return b();
        }
        return false;
    }

    public static String b(String str) {
        return MD5Utils.md5(str);
    }

    private static boolean b() {
        return c() && d();
    }

    private static boolean b(File[] fileArr) {
        if (fileArr == null || fileArr.length != 2) {
            Log.e("SoDownloader", "The number of files is not 2");
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (File file : fileArr) {
            String name = file.getName();
            if ("libARClient.so".equals(name) || "libArTrackerClient.so".equals(name)) {
                z = true;
            } else if ("libbaiduar.so".equals(name)) {
                z2 = true;
            }
        }
        if (z && z2) {
            return true;
        }
        if (!z) {
            Log.e("SoDownloader", "Can not found libARClient.so");
        }
        if (!z2) {
            Log.e("SoDownloader", "Can not found libbaiduar.so");
        }
        return false;
    }

    private static File[] b(File file) {
        return file.listFiles(new FileFilter() { // from class: com.baidu.ar.resloader.d.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.getName().endsWith(PluginInstallerService.APK_LIB_SUFFIX);
            }
        });
    }

    private void c(String str) {
        a();
        this.b = new c(this.a, str, this.c, this.d);
        this.b.start();
    }

    private static boolean c() {
        try {
            return ArBridge.libraryHasLoaded();
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean c(File file) {
        try {
            if (file.exists()) {
                String absolutePath = file.getAbsolutePath();
                if (b.a(absolutePath)) {
                    String name = file.getName();
                    if ("libARClient.so".equals(name) || "libArTrackerClient.so".equals(name)) {
                        System.load(absolutePath);
                    } else if ("libbaiduar.so".equals(name)) {
                        System.load(absolutePath);
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private static boolean d() {
        try {
            ARAlgoJniClient.getVersion();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public void a() {
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public void a(String str) {
        ARLog.d("bdar: url = " + str);
        if (b.a(this.c)) {
            return;
        }
        if (b()) {
            a(true);
            return;
        }
        com.baidu.ar.base.d.a((int) MsgField.MSG_STAT_SOLOAD_START);
        if (TextUtils.isEmpty(str)) {
            ARLog.e("bdar: So URL is NULL!!!!");
            a(false);
            com.baidu.ar.base.d.a((int) MsgField.MSG_STAT_SOLOAD_LOAD_FAILURE);
        } else if (!TextUtils.equals(this.d.b(), String.valueOf(ARSDKInfo.getVersionCode()))) {
            c(str);
        } else {
            String a2 = this.d.a();
            String b = b(str);
            if (!TextUtils.isEmpty(a2) && TextUtils.equals(a2, b)) {
                File file = new File(a(this.a), a2);
                if (file.exists()) {
                    File[] b2 = b(new File(file, "res"));
                    if (b2 != null && b2.length > 0) {
                        boolean a3 = a(b2);
                        a(a3);
                        if (a3) {
                            com.baidu.ar.base.d.a((int) MsgField.MSG_STAT_SOLOAD_LOAD_SUCCESS);
                            return;
                        } else {
                            com.baidu.ar.base.d.a((int) MsgField.MSG_STAT_SOLOAD_LOAD_FAILURE);
                            return;
                        }
                    }
                    this.d.a("");
                }
            }
            c(str);
        }
    }
}
