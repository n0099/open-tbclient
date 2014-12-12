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
import com.baidu.adp.plugin.util.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c {
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c sj = null;
    private LinkedList<String> sf;
    private ArrayList<String> sg;
    private BroadcastReceiver sh;
    private a si;
    private HashMap<String, Runnable> sl;
    private boolean se = false;
    private boolean sk = true;
    private f sm = null;

    public static c hS() {
        if (sj == null) {
            synchronized (c.class) {
                if (sj == null) {
                    sj = new c();
                }
            }
        }
        return sj;
    }

    public c() {
        this.sf = null;
        this.sg = null;
        this.sh = null;
        this.sl = null;
        this.sf = new LinkedList<>();
        this.sg = new ArrayList<>();
        this.sl = new HashMap<>();
        this.sh = new d(this);
        hT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.sf.contains(str)) {
            this.sf.remove(str);
        }
        if (this.sg.contains(str)) {
            this.sg.remove(str);
        }
        sHandler.removeCallbacks(this.sl.remove(str));
        if (z && this.sg.isEmpty() && this.si != null) {
            this.si.J(this.sk);
        }
    }

    public void a(Context context, a aVar) {
        this.si = aVar;
        if (this.sm != null) {
            this.sm.cancel();
            this.sm = null;
        }
        this.sm = new f(this, context);
        this.sm.setPriority(4);
        this.sm.execute(new String[0]);
    }

    public boolean aW(String str) {
        return this.sf.contains(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [178=4, 179=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(Context context, String str) {
        FileInputStream fileInputStream;
        InputStream inputStream = null;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
        PluginSetting bd = PluginPackageManager.ic().bd(substring);
        if (substring != null && substring.length() > 0 && bd != null && bd.apkPath != null) {
            File file = new File(bd.apkPath);
            if (file.exists() && file.isFile() && file.length() > 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            g g = Util.g(fileInputStream);
                            inputStream = context.getAssets().open(str);
                            if (g.a(Util.g(inputStream)) >= 0) {
                                if (this.si != null) {
                                    this.si.aU(substring);
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
                            x(context, "assets://" + str);
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
        x(context, "assets://" + str);
        return true;
    }

    public void w(Context context, String str) {
        x(context, "file://" + str);
    }

    private void x(Context context, String str) {
        PackageInfo packageArchiveInfo;
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            hT();
            String str2 = null;
            if (str.startsWith("assets://")) {
                str2 = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                z = true;
            } else if (str.startsWith("file://") && (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str.substring("file://".length()), 0)) != null) {
                str2 = packageArchiveInfo.packageName;
            }
            if (str2 != null) {
                if (aY(str2)) {
                    if (z) {
                        this.sg.add(str2);
                    }
                } else {
                    return;
                }
            }
            Intent intent = new Intent(PluginInstallerService.ACTION_INSTALL);
            intent.setClass(context, PluginInstallerService.class);
            intent.putExtra("install_src_file", str);
            intent.putExtra("package_name", str2);
            context.startService(intent);
        }
    }

    public static File aX(String str) {
        PluginSetting bd = PluginPackageManager.ic().bd(str);
        if (bd == null || bd.apkPath == null || bd.apkPath.length() <= 0) {
            return null;
        }
        return new File(bd.apkPath);
    }

    private void hT() {
        if (!this.se) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                applicationContext.registerReceiver(this.sh, intentFilter);
                this.se = true;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean aY(String str) {
        if (this.sf.contains(str)) {
            return false;
        }
        e eVar = new e(this, str);
        this.sl.put(str, eVar);
        sHandler.postDelayed(eVar, 300000L);
        return this.sf.add(str);
    }
}
