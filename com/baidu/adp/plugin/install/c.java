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
import com.baidu.adp.plugin.util.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c {
    private LinkedList<String> CO;
    private ArrayList<String> CP;
    private ArrayList<String> CQ;
    private BroadcastReceiver CR;
    private a CS;
    private HashMap<String, Runnable> CV;
    private static Handler oy = new Handler(Looper.getMainLooper());
    private static volatile c CT = null;
    private boolean CM = false;
    private boolean CU = true;
    private f CW = null;

    public static c lx() {
        if (CT == null) {
            synchronized (c.class) {
                if (CT == null) {
                    CT = new c();
                }
            }
        }
        return CT;
    }

    public c() {
        this.CO = null;
        this.CP = null;
        this.CQ = null;
        this.CR = null;
        this.CV = null;
        this.CO = new LinkedList<>();
        this.CP = new ArrayList<>();
        this.CQ = new ArrayList<>();
        this.CV = new HashMap<>();
        this.CR = new d(this);
        ly();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.CO.contains(str)) {
            this.CO.remove(str);
        }
        if (this.CP.contains(str)) {
            this.CP.remove(str);
        }
        oy.removeCallbacks(this.CV.remove(str));
        if (z && this.CP.isEmpty() && this.CS != null) {
            this.CS.L(this.CU);
        }
        if (this.CQ.contains(str)) {
            this.CQ.remove(str);
            com.baidu.adp.plugin.b.a.lB().bo("plugin_retry_install_succ");
        }
    }

    public void a(Context context, a aVar) {
        this.CS = aVar;
        if (this.CW != null) {
            this.CW.cancel();
            this.CW = null;
        }
        this.CW = new f(this, context);
        this.CW.setPriority(4);
        this.CW.execute(new String[0]);
    }

    public boolean bl(String str) {
        return this.CO.contains(str);
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
            PluginSetting bs = PluginPackageManager.lM().bs(substring);
            if (substring != null && substring.length() > 0 && bs != null && bs.apkPath != null) {
                File file = new File(bs.apkPath);
                if (file.exists() && file.isFile() && file.length() > 0) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            try {
                                i g = Util.g(fileInputStream);
                                inputStream = context.getAssets().open(str);
                                if (g.a(Util.g(inputStream)) == 0) {
                                    if (this.CS != null) {
                                        this.CS.bj(substring);
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
            ly();
            String str2 = null;
            if (str.startsWith("assets://")) {
                str2 = str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(".apk"));
                z2 = true;
            } else if (str.startsWith("file://") && (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str.substring("file://".length()), 0)) != null) {
                str2 = packageArchiveInfo.packageName;
            }
            if (str2 != null) {
                if (F(str2, str)) {
                    if (z2) {
                        this.CP.add(str2);
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

    public static File bm(String str) {
        PluginSetting bs = PluginPackageManager.lM().bs(str);
        if (bs == null || bs.apkPath == null || bs.apkPath.length() <= 0) {
            return null;
        }
        return new File(bs.apkPath);
    }

    private void ly() {
        if (!this.CM) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                applicationContext.registerReceiver(this.CR, intentFilter);
                this.CM = true;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean F(String str, String str2) {
        if (this.CO.contains(str)) {
            return false;
        }
        e eVar = new e(this, str, str2);
        this.CV.put(str, eVar);
        oy.postDelayed(eVar, 240000L);
        return this.CO.add(str);
    }
}
