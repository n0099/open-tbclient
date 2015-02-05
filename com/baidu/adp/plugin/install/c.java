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
    private static volatile c sm = null;
    private LinkedList<String> sh;
    private ArrayList<String> si;
    private ArrayList<String> sj;
    private BroadcastReceiver sk;
    private a sl;
    private HashMap<String, Runnable> sq;
    private boolean sg = false;
    private boolean so = true;
    private f sr = null;

    public static c hJ() {
        if (sm == null) {
            synchronized (c.class) {
                if (sm == null) {
                    sm = new c();
                }
            }
        }
        return sm;
    }

    public c() {
        this.sh = null;
        this.si = null;
        this.sj = null;
        this.sk = null;
        this.sq = null;
        this.sh = new LinkedList<>();
        this.si = new ArrayList<>();
        this.sj = new ArrayList<>();
        this.sq = new HashMap<>();
        this.sk = new d(this);
        hK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, boolean z) {
        if (this.sh.contains(str)) {
            this.sh.remove(str);
        }
        if (this.si.contains(str)) {
            this.si.remove(str);
        }
        sHandler.removeCallbacks(this.sq.remove(str));
        if (z && this.si.isEmpty() && this.sl != null) {
            this.sl.J(this.so);
        }
        if (this.sj.contains(str)) {
            this.sj.remove(str);
            com.baidu.adp.plugin.b.a.hN().aW("plugin_retry_install_succ");
        }
    }

    public void a(Context context, a aVar) {
        this.sl = aVar;
        if (this.sr != null) {
            this.sr.cancel();
            this.sr = null;
        }
        this.sr = new f(this, context);
        this.sr.setPriority(4);
        this.sr.execute(new String[0]);
    }

    public boolean aT(String str) {
        return this.sh.contains(str);
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
            PluginSetting ba = PluginPackageManager.hV().ba(substring);
            if (substring != null && substring.length() > 0 && ba != null) {
                File file = new File(ba.apkPath);
                if (file.exists() && file.isFile() && file.length() > 0) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            try {
                                com.baidu.adp.plugin.util.f g = Util.g(fileInputStream);
                                inputStream = context.getAssets().open(str);
                                if (g.a(Util.g(inputStream)) == 0) {
                                    if (this.sl != null) {
                                        this.sl.aR(substring);
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
            hK();
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
                        this.si.add(str2);
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

    public static File aU(String str) {
        PluginSetting ba = PluginPackageManager.hV().ba(str);
        if (ba == null || ba.apkPath == null || ba.apkPath.length() <= 0) {
            return null;
        }
        return new File(ba.apkPath);
    }

    private void hK() {
        if (!this.sg) {
            try {
                Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.adp.plugin.installed");
                intentFilter.addAction("com.baidu.adp.plugin.installfail");
                applicationContext.registerReceiver(this.sk, intentFilter);
                this.sg = true;
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private boolean C(String str, String str2) {
        if (this.sh.contains(str)) {
            return false;
        }
        e eVar = new e(this, str, str2);
        this.sq.put(str, eVar);
        sHandler.postDelayed(eVar, 240000L);
        return this.sh.add(str);
    }
}
