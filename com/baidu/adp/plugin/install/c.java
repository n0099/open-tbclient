package com.baidu.adp.plugin.install;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c {
    private LinkedList<String> CX;
    private ArrayList<String> CY;
    private ArrayList<String> CZ;
    private BroadcastReceiver Da;
    private a Db;
    private HashMap<String, Runnable> De;
    private static Handler ot = new Handler(Looper.getMainLooper());
    private static volatile c Dc = null;
    private boolean CW = false;
    private boolean Dd = true;
    private f Df = null;

    public static c ld() {
        if (Dc == null) {
            synchronized (c.class) {
                if (Dc == null) {
                    Dc = new c();
                }
            }
        }
        return Dc;
    }

    public c() {
        this.CX = null;
        this.CY = null;
        this.CZ = null;
        this.Da = null;
        this.De = null;
        this.CX = new LinkedList<>();
        this.CY = new ArrayList<>();
        this.CZ = new ArrayList<>();
        this.De = new HashMap<>();
        this.Da = new d(this);
        le();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.CX.contains(str)) {
            this.CX.remove(str);
        }
        if (this.CY.contains(str)) {
            this.CY.remove(str);
        }
        ot.removeCallbacks(this.De.remove(str));
        if (z && this.CY.isEmpty() && this.Db != null) {
            this.Db.J(this.Dd);
        }
        if (this.CZ.contains(str)) {
            this.CZ.remove(str);
            com.baidu.adp.plugin.b.a.lh().be("plugin_retry_install_succ");
        }
    }

    public void a(Context context, a aVar) {
        this.Db = aVar;
        if (this.Df != null) {
            this.Df.cancel();
            this.Df = null;
        }
        this.Df = new f(this, context);
        this.Df.setPriority(4);
        this.Df.execute(new String[0]);
    }

    public boolean bb(String str) {
        return this.CX.contains(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [186=4, 187=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(Context context, String str) {
        FileInputStream fileInputStream;
        InputStream inputStream = null;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf("/");
        int lastIndexOf2 = str.lastIndexOf(".apk");
        if (lastIndexOf + 1 < lastIndexOf2) {
            String substring = str.substring(lastIndexOf + 1, lastIndexOf2);
            PluginSetting bi = PluginPackageManager.ls().bi(substring);
            if (substring != null && substring.length() > 0 && bi != null) {
                File file = new File(bi.apkPath);
                if (file.exists() && file.isFile() && file.length() > 0) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            try {
                                com.baidu.adp.plugin.util.f g = Util.g(fileInputStream);
                                inputStream = context.getAssets().open(str);
                                if (g.a(Util.g(inputStream)) == 0) {
                                    if (this.Db != null) {
                                        this.Db.aZ(substring);
                                    }
                                    com.baidu.adp.lib.g.a.d(fileInputStream);
                                    com.baidu.adp.lib.g.a.d(inputStream);
                                    return false;
                                }
                                com.baidu.adp.lib.g.a.d(fileInputStream);
                                com.baidu.adp.lib.g.a.d(inputStream);
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e);
                                com.baidu.adp.lib.g.a.d(fileInputStream);
                                com.baidu.adp.lib.g.a.d(inputStream);
                                c(context, "assets://" + str, false);
                                return true;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.adp.lib.g.a.d(fileInputStream);
                            com.baidu.adp.lib.g.a.d(inputStream);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        com.baidu.adp.lib.g.a.d(inputStream);
                        throw th;
                    }
                }
            }
            c(context, "assets://" + str, false);
            return true;
        }
        return false;
    }

    public void w(Context context, String str) {
        c(context, "file://" + str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, String str, boolean z) {
        PackageInfo packageArchiveInfo;
        boolean z2 = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            le();
            String str2 = null;
            if (str.startsWith("assets://")) {
                str2 = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                z2 = true;
            } else if (str.startsWith("file://") && (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str.substring("file://".length()), 0)) != null) {
                str2 = packageArchiveInfo.packageName;
            }
            if (str2 != null) {
                if (D(str2, str)) {
                    if (z2) {
                        this.CY.add(str2);
                    }
                } else {
                    return;
                }
            }
            Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
            if (z) {
                intent.setClass(context, PluginInstallerRetryService.class);
            } else {
                intent.setClass(context, PluginInstallerService.class);
            }
            intent.putExtra("install_src_file", str);
            intent.putExtra("package_name", str2);
            context.startService(intent);
        }
    }

    public static File bc(String str) {
        PluginSetting bi = PluginPackageManager.ls().bi(str);
        if (bi == null || bi.apkPath == null || bi.apkPath.length() <= 0) {
            return null;
        }
        return new File(bi.apkPath);
    }

    private void le() {
        if (!this.CW) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                applicationContext.registerReceiver(this.Da, intentFilter);
                this.CW = true;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean D(String str, String str2) {
        if (this.CX.contains(str)) {
            return false;
        }
        e eVar = new e(this, str, str2);
        this.De.put(str, eVar);
        ot.postDelayed(eVar, 240000L);
        return this.CX.add(str);
    }
}
