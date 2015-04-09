package com.baidu.adp.plugin;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ac;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.h;
import com.baidu.adp.plugin.pluginBase.PluginBaseApplication;
import com.baidu.adp.plugin.pluginBase.g;
import com.baidu.adp.plugin.util.Util;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b {
    private ArrayList<String> CH;
    private int Cy = 0;
    private File Cz = null;
    private ClassLoader CA = null;
    private Resources CB = null;
    private AssetManager CC = null;
    private Application CE = null;
    private File CF = null;
    private boolean CG = false;
    private c CI = null;
    private boolean CJ = false;
    private String mPackageName = null;
    private final Context mContext = BdBaseApplication.getInst().getApplicationContext();

    public b() {
        this.CH = null;
        this.CH = new ArrayList<>();
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int ke() {
        return this.Cy;
    }

    public String kf() {
        if (this.Cz == null || !this.Cz.exists()) {
            return null;
        }
        return this.Cz.getAbsolutePath();
    }

    public String kg() {
        if (this.CF == null || !this.CF.exists()) {
            return null;
        }
        return new File(this.CF, "lib").getAbsolutePath();
    }

    public boolean isLoaded() {
        return this.CG;
    }

    public ClassLoader kh() {
        return this.CA;
    }

    public Resources ki() {
        return this.CB;
    }

    public PackageInfo kj() {
        if (this.mContext == null || this.Cz == null) {
            return null;
        }
        try {
            return this.mContext.getPackageManager().getPackageArchiveInfo(this.Cz.getAbsolutePath(), 8447);
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public Application getApplication() {
        return this.CE;
    }

    public boolean aV(String str) {
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("Plugin asyncInitWithBroadcast args exception!");
            }
            return false;
        }
        this.mPackageName = str;
        if (isLoaded()) {
            return true;
        }
        if (this.CJ) {
            return false;
        }
        this.CJ = true;
        boolean booleanValue = aX(str).booleanValue();
        kl();
        kq();
        b(str, 0, (String) null);
        if (PluginPackageManager.ls().lA()) {
            if (booleanValue) {
                com.baidu.adp.plugin.b.a.lh().I("plugin_load", str);
                com.baidu.adp.plugin.b.a.lh().be("plugin_loaded_succ");
            } else {
                com.baidu.adp.plugin.b.a.lh().be("plugin_loaded_failed");
            }
        }
        return true;
    }

    public boolean kk() {
        this.mPackageName = BdBaseApplication.getInst().getPackageName();
        this.CA = this.mContext.getClassLoader();
        this.CB = this.mContext.getResources();
        this.CE = BdBaseApplication.getInst();
        this.CG = true;
        return true;
    }

    public void a(String str, com.baidu.adp.plugin.util.d dVar) {
        if (this.CI != null) {
            this.CI.cancel();
            this.CI = null;
        }
        this.CI = new c(this, str, dVar);
        this.CI.execute(new String[0]);
    }

    public boolean i(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        String str = null;
        if (intent.getComponent() != null) {
            str = intent.getComponent().getClassName();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class<?> loadClass = this.CA.loadClass(str);
            if (g.class.isAssignableFrom(loadClass) || com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(loadClass)) {
                if (b(intent, str, loadClass)) {
                    context.startService(intent);
                    return true;
                }
                BdLog.e("intent remap failed");
            } else if (a(intent, str, loadClass)) {
                context.startActivity(intent);
                return true;
            } else {
                BdLog.e("intent remap failed");
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        if (context == null || intent == null) {
            return false;
        }
        String str = null;
        if (intent.getComponent() != null) {
            str = intent.getComponent().getClassName();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class<?> loadClass = this.CA.loadClass(str);
            if (g.class.isAssignableFrom(loadClass) || com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(loadClass)) {
                if (b(intent, str, loadClass)) {
                    context.bindService(intent, serviceConnection, i);
                    return true;
                }
                BdLog.e("intent remap failed");
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void destroy() {
        if (this.CG && this.CE != null) {
            this.CE.onTerminate();
        }
    }

    public boolean C(Intent intent) {
        if (intent.getComponent() == null) {
            return false;
        }
        return b(intent, intent.getComponent().getClassName(), (Class<?>) null);
    }

    public boolean D(Intent intent) {
        if (intent.getComponent() == null) {
            return false;
        }
        return a(intent, intent.getComponent().getClassName(), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean aW(String str) {
        DexFile loadDex;
        DexFile a = com.baidu.adp.plugin.util.c.a(this.CA);
        if (a == null) {
            try {
                loadDex = DexFile.loadDex(this.Cz.getAbsolutePath(), B(this.Cz.getAbsolutePath(), this.CF.getAbsolutePath()), 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            if (loadDex != null) {
                Enumeration<String> entries = loadDex.entries();
                while (entries.hasMoreElements()) {
                    if (entries.nextElement().equals(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        loadDex = a;
        if (loadDex != null) {
        }
        return false;
    }

    private boolean a(Intent intent, String str, Class<?> cls) {
        intent.putExtra("intent_extra_activity", str);
        intent.putExtra("intent_extra_package_name", this.mPackageName);
        if (cls == null) {
            try {
                cls = this.CA.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> m = d.kr().m(cls);
        if (m != null) {
            intent.setClass(this.mContext, m);
            return true;
        }
        return false;
    }

    private boolean b(Intent intent, String str, Class<?> cls) {
        intent.putExtra("intent_extra_service", str);
        intent.putExtra("intent_extra_package_name", this.mPackageName);
        if (cls == null) {
            try {
                cls = this.CA.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> n = e.ks().n(cls);
        if (n != null) {
            intent.setClass(this.mContext, n);
            return true;
        }
        return false;
    }

    private void b(String str, int i, String str2) {
        this.CG = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000997, new com.baidu.adp.plugin.message.a(str, i, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kl() {
        if (this.CH != null && this.CH.size() > 0) {
            Iterator<String> it = this.CH.iterator();
            StringBuilder sb = null;
            while (it.hasNext()) {
                String next = it.next();
                try {
                    Class.forName(next, true, this.CA);
                } catch (ClassNotFoundException e) {
                    BdLog.e(e);
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(next);
                    sb.append("-");
                    sb.append(e.getMessage());
                    sb.append(",");
                } catch (Throwable th) {
                    BdLog.e(th);
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(next);
                    sb.append("-");
                    sb.append(th.getMessage());
                    sb.append(",");
                }
            }
            this.CH.clear();
            this.CH = null;
            if (sb != null) {
                String str = this.mPackageName;
                if (PluginPackageManager.ls().lA()) {
                    com.baidu.adp.plugin.b.a.lh().d("plugin_load", "init_static_failed", str, sb.toString());
                }
            }
        }
    }

    private void km() {
        this.CB = this.mContext.getResources();
    }

    private boolean kn() {
        return this.Cz.isFile() && this.Cz.getName().endsWith(".apk");
    }

    private void ko() {
        try {
            this.CF = Util.bB(this.mPackageName);
            this.CF.mkdirs();
        } catch (Exception e) {
            BdLog.e(e);
            if (PluginPackageManager.ls().lA()) {
                com.baidu.adp.plugin.b.a.lh().d("plugin_load", "createdataroot_failed", this.mPackageName, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
            }
        }
    }

    private boolean kp() {
        boolean z;
        String str;
        try {
            if (this.CF == null || !this.CF.exists()) {
                ko();
            }
            this.CA = new DexClassLoader(this.Cz.getAbsolutePath(), this.CF.getAbsolutePath(), kg(), this.mContext.getClassLoader());
            try {
                try {
                    if (this.CA != null) {
                        this.CA.loadClass(String.valueOf(this.mPackageName) + ".Static");
                        z = true;
                    } else {
                        z = true;
                    }
                } catch (ClassNotFoundException e) {
                    if (PluginPackageManager.ls().lA()) {
                        com.baidu.adp.plugin.b.a.lh().d("plugin_load", "loadR", this.mPackageName, e.getMessage());
                    }
                    BdLog.e(e);
                    z = false;
                }
            } catch (Exception e2) {
                if (PluginPackageManager.ls().lA()) {
                    com.baidu.adp.plugin.b.a.lh().d("plugin_load", "loadR2", this.mPackageName, String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName());
                }
                BdLog.e(e2);
                z = false;
            }
            if (z) {
                if (PluginPackageManager.ls().lA() && !z) {
                    com.baidu.adp.plugin.b.a.lh().be("plugin_class_notfind");
                }
                PluginSetting findPluginSetting = h.lP().findPluginSetting(this.mPackageName);
                if (findPluginSetting != null && findPluginSetting.isInjectClassloader()) {
                    ClassLoader classLoader = this.mContext.getClassLoader();
                    while (!(classLoader instanceof PathClassLoader)) {
                        classLoader = classLoader.getParent();
                    }
                    this.Cy = 1;
                    com.baidu.adp.plugin.util.b a = com.baidu.adp.plugin.util.a.a(classLoader, this.CA, String.valueOf(this.mPackageName) + ".Static");
                    if (a != null && !a.EP) {
                        if (PluginPackageManager.ls().lA()) {
                            com.baidu.adp.plugin.b.a.lh().be("plugin_inject_failed");
                        }
                        com.baidu.adp.plugin.b.a.lh().d("plugin_load", "inject_failed", this.mPackageName, a.mErrMsg);
                        this.Cy = 2;
                        String str2 = "";
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder();
                        ArrayList<b> allPlugins = PluginCenter.getInstance().getAllPlugins();
                        if (allPlugins != null && allPlugins.size() > 0) {
                            Iterator<b> it = allPlugins.iterator();
                            while (it.hasNext()) {
                                b next = it.next();
                                if (next != null) {
                                    sb.append(next.kf());
                                    sb.append(File.pathSeparator);
                                    sb2.append(next.kg());
                                    sb2.append(File.pathSeparator);
                                }
                            }
                        }
                        if (sb.length() > 0) {
                            str2 = sb.substring(0, sb.length() - 1);
                        }
                        if (sb2.length() <= 0) {
                            str = "";
                        } else {
                            str = sb2.substring(0, sb2.length() - 1);
                        }
                        com.baidu.adp.plugin.util.b a2 = com.baidu.adp.plugin.util.a.a(this.mContext, new DexClassLoader(str2, this.CF.getAbsolutePath(), str, classLoader), String.valueOf(this.mPackageName) + ".Static");
                        if (a2 != null && !a2.EP && PluginPackageManager.ls().lA()) {
                            com.baidu.adp.plugin.b.a.lh().d("plugin_load", "replaceparent_failed", this.mPackageName, a2.mErrMsg);
                            return false;
                        } else if (a2 != null && a2.EP) {
                            com.baidu.adp.plugin.b.a.lh().be("plugin_second_inject_succ");
                        }
                    }
                }
                DexFile a3 = com.baidu.adp.plugin.util.c.a(this.CA);
                String str3 = null;
                if (a3 == null) {
                    try {
                        a3 = DexFile.loadDex(this.Cz.getAbsolutePath(), B(this.Cz.getAbsolutePath(), this.CF.getAbsolutePath()), 0);
                    } catch (Exception e3) {
                        BdLog.e(e3.getMessage());
                        str3 = e3.getMessage();
                    }
                }
                if (a3 != null) {
                    if (a3.entries() != null) {
                        try {
                            Enumeration<String> entries = a3.entries();
                            while (entries.hasMoreElements()) {
                                String nextElement = entries.nextElement();
                                if (nextElement.endsWith(ac.SUFFIX) || nextElement.endsWith("Activity") || nextElement.endsWith("Service")) {
                                    if (this.CH != null && !PluginPackageManager.ls().isFeatureForbidden(nextElement)) {
                                        this.CH.add(nextElement);
                                    }
                                }
                            }
                        } catch (Exception e4) {
                            if (PluginPackageManager.ls().lA()) {
                                com.baidu.adp.plugin.b.a.lh().d("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, e4.getMessage());
                            }
                        }
                    } else if (PluginPackageManager.ls().lA()) {
                        com.baidu.adp.plugin.b.a.lh().d("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, str3);
                    }
                } else if (PluginPackageManager.ls().lA()) {
                    com.baidu.adp.plugin.b.a.lh().d("plugin_load", "getdexfile_failed", this.mPackageName, str3);
                }
                return true;
            }
            return false;
        } catch (Exception e5) {
            BdLog.e(e5);
            if (PluginPackageManager.ls().lA()) {
                com.baidu.adp.plugin.b.a.lh().d("plugin_load", "new_dexloader_failed", this.mPackageName, String.valueOf(e5.getMessage()) + "---" + e5.getClass().getName());
            }
            return false;
        }
    }

    private static String B(String str, String str2) {
        StringBuilder sb = new StringBuilder(80);
        sb.append(str2);
        if (!str2.endsWith("/")) {
            sb.append("/");
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf >= 0) {
            str = str.substring(lastIndexOf + 1);
        }
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf2 < 0) {
            sb.append(str);
        } else {
            sb.append((CharSequence) str, 0, lastIndexOf2);
        }
        sb.append(".dex");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kq() {
        if (this.CE == null) {
            PluginBaseApplication pluginBaseApplication = new PluginBaseApplication();
            pluginBaseApplication.a((Application) this.mContext);
            pluginBaseApplication.setPluginPackageName(this.mPackageName);
            pluginBaseApplication.onCreate();
            this.CE = pluginBaseApplication;
            this.CG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean aX(String str) {
        this.Cz = com.baidu.adp.plugin.install.c.bc(str);
        if (this.Cz == null) {
            h.lP().bz(str);
            if (PluginPackageManager.ls().lA()) {
                com.baidu.adp.plugin.b.a.lh().g("plugin_load", "apk_file_null", str);
            }
            return false;
        } else if (!kn()) {
            h.lP().bz(str);
            if (PluginPackageManager.ls().lA()) {
                com.baidu.adp.plugin.b.a.lh().g("plugin_load", "apk_file_illegal", str);
            }
            return false;
        } else {
            ko();
            boolean kp = kp();
            if (!kp) {
                return false;
            }
            km();
            return Boolean.valueOf(kp);
        }
    }
}
