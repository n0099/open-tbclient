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
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static volatile c sr = null;
    private LinkedList<String> sk;
    private ArrayList<String> sl;
    private ArrayList<String> sm;
    private BroadcastReceiver so;
    private a sq;
    private HashMap<String, Runnable> st;
    private boolean sj = false;
    private boolean ss = true;
    private f su = null;

    public static c hQ() {
        if (sr == null) {
            synchronized (c.class) {
                if (sr == null) {
                    sr = new c();
                }
            }
        }
        return sr;
    }

    public c() {
        this.sk = null;
        this.sl = null;
        this.sm = null;
        this.so = null;
        this.st = null;
        this.sk = new LinkedList<>();
        this.sl = new ArrayList<>();
        this.sm = new ArrayList<>();
        this.st = new HashMap<>();
        this.so = new d(this);
        hR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.sk.contains(str)) {
            this.sk.remove(str);
        }
        if (this.sl.contains(str)) {
            this.sl.remove(str);
        }
        sHandler.removeCallbacks(this.st.remove(str));
        if (z && this.sl.isEmpty() && this.sq != null) {
            this.sq.J(this.ss);
        }
        if (this.sm.contains(str)) {
            this.sm.remove(str);
            com.baidu.adp.plugin.b.a.hU().aZ("plugin_retry_install_succ");
        }
    }

    public void a(Context context, a aVar) {
        this.sq = aVar;
        if (this.su != null) {
            this.su.cancel();
            this.su = null;
        }
        this.su = new f(this, context);
        this.su.setPriority(4);
        this.su.execute(new String[0]);
    }

    public boolean aW(String str) {
        return this.sk.contains(str);
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
            PluginSetting bd = PluginPackageManager.ic().bd(substring);
            if (substring != null && substring.length() > 0 && bd != null) {
                File file = new File(bd.apkPath);
                if (file.exists() && file.isFile() && file.length() > 0) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            try {
                                com.baidu.adp.plugin.util.f g = Util.g(fileInputStream);
                                inputStream = context.getAssets().open(str);
                                if (g.a(Util.g(inputStream)) == 0) {
                                    if (this.sq != null) {
                                        this.sq.aU(substring);
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
            hR();
            String str2 = null;
            if (str.startsWith("assets://")) {
                str2 = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                z2 = true;
            } else if (str.startsWith("file://") && (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str.substring("file://".length()), 0)) != null) {
                str2 = packageArchiveInfo.packageName;
            }
            if (str2 != null) {
                if (C(str2, str)) {
                    if (z2) {
                        this.sl.add(str2);
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

    public static File aX(String str) {
        PluginSetting bd = PluginPackageManager.ic().bd(str);
        if (bd == null || bd.apkPath == null || bd.apkPath.length() <= 0) {
            return null;
        }
        return new File(bd.apkPath);
    }

    private void hR() {
        if (!this.sj) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                applicationContext.registerReceiver(this.so, intentFilter);
                this.sj = true;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean C(String str, String str2) {
        if (this.sk.contains(str)) {
            return false;
        }
        e eVar = new e(this, str, str2);
        this.st.put(str, eVar);
        sHandler.postDelayed(eVar, 240000L);
        return this.sk.add(str);
    }
}
