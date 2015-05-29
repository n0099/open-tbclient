package com.baidu.adp.plugin;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ad;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.h;
import com.baidu.adp.plugin.pluginBase.PluginBaseApplication;
import com.baidu.adp.plugin.pluginBase.g;
import com.baidu.adp.plugin.util.Util;
import com.baidu.adp.plugin.util.f;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<String> Cx;
    private boolean Cn = false;
    private boolean Co = false;
    private long Cp = 0;
    private int Cq = 0;
    private File Cr = null;
    private ClassLoader Cs = null;
    private Resources Ct = null;
    private AssetManager Cu = null;
    private Application Cv = null;
    private File Cw = null;
    private b Cy = null;
    private String mPackageName = null;
    private final Context mContext = BdBaseApplication.getInst().getApplicationContext();

    public a() {
        this.Cx = null;
        this.Cx = new ArrayList<>();
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public long kv() {
        return this.Cp;
    }

    public int kw() {
        return this.Cq;
    }

    public String kx() {
        if (this.Cr == null || !this.Cr.exists()) {
            return null;
        }
        return this.Cr.getAbsolutePath();
    }

    public String ky() {
        if (this.Cw == null || !this.Cw.exists()) {
            return null;
        }
        return new File(this.Cw, "lib").getAbsolutePath();
    }

    public boolean isLoaded() {
        return this.Cn && this.Co;
    }

    public ClassLoader kz() {
        return this.Cs;
    }

    public Resources kA() {
        return this.Ct;
    }

    public PackageInfo kB() {
        if (this.mContext == null || this.Cr == null) {
            return null;
        }
        try {
            return this.mContext.getPackageManager().getPackageArchiveInfo(this.Cr.getAbsolutePath(), 8447);
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public Application getApplication() {
        return this.Cv;
    }

    public int kC() {
        return 16973829;
    }

    public boolean bf(String str) {
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("Plugin asyncInitWithBroadcast args exception!");
            }
            return false;
        }
        this.mPackageName = str;
        this.Cp = System.currentTimeMillis();
        if (isLoaded()) {
            return true;
        }
        boolean booleanValue = bh(str).booleanValue();
        if (PluginPackageManager.lM().iE()) {
            if (booleanValue) {
                com.baidu.adp.plugin.b.a.lB().K("plugin_load", str);
            } else {
                com.baidu.adp.plugin.b.a.lB().bo("plugin_loaded_failed");
            }
        }
        if (booleanValue) {
            kK();
            b(str, 0, (String) null);
            return true;
        }
        return false;
    }

    public boolean kD() {
        this.mPackageName = BdBaseApplication.getInst().getPackageName();
        this.Cs = this.mContext.getClassLoader();
        this.Ct = this.mContext.getResources();
        this.Cv = BdBaseApplication.getInst();
        this.Cn = true;
        this.Co = true;
        return true;
    }

    public void a(String str, f fVar) {
        if (this.Cy != null) {
            this.Cy.cancel();
            this.Cy = null;
        }
        this.Cy = new b(this, str, fVar);
        this.Cy.execute(new String[0]);
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
            Class<?> loadClass = this.Cs.loadClass(str);
            if (this.Cq == 0) {
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
            }
            intent.putExtra("intent_extra_package_name", this.mPackageName);
            if (Service.class.isAssignableFrom(loadClass)) {
                context.startService(intent);
            } else {
                context.startActivity(intent);
            }
            return true;
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
            Class<?> loadClass = this.Cs.loadClass(str);
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
        if (this.Cn && this.Co && this.Cv != null) {
            this.Cv.onTerminate();
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
    public boolean bg(String str) {
        DexFile loadDex;
        DexFile a = com.baidu.adp.plugin.util.e.a(this.Cs);
        if (a == null) {
            try {
                loadDex = DexFile.loadDex(this.Cr.getAbsolutePath(), D(this.Cr.getAbsolutePath(), this.Cw.getAbsolutePath()), 0);
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
                cls = this.Cs.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> m = d.kL().m(cls);
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
                cls = this.Cs.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> n = e.kM().n(cls);
        if (n != null) {
            intent.setClass(this.mContext, n);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i, String str2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000997, new com.baidu.adp.plugin.message.a(str, i, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kE() {
        if (this.Cx != null && this.Cx.size() > 0) {
            Iterator<String> it = this.Cx.iterator();
            StringBuilder sb = null;
            while (it.hasNext()) {
                String next = it.next();
                try {
                    Class.forName(next, true, this.Cs);
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
            this.Cx.clear();
            this.Cx = null;
            if (sb != null) {
                String str = this.mPackageName;
                if (PluginPackageManager.lM().iE()) {
                    com.baidu.adp.plugin.b.a.lB().d("plugin_load", "init_static_failed", str, sb.toString());
                }
            }
        }
    }

    private boolean kF() {
        PluginSetting findPluginSetting = h.mi().findPluginSetting(this.mPackageName);
        boolean z = findPluginSetting != null ? findPluginSetting.hasRes : false;
        this.Ct = this.mContext.getResources();
        if (BdBaseApplication.getInst().getIsPluginResourcOpen() && z) {
            if (this.Cr == null || TextUtils.isEmpty(this.Cr.getAbsolutePath())) {
                return false;
            }
            try {
                l.dJ().D(this.Cr.getAbsolutePath());
                this.Co = true;
                return true;
            } catch (Error e) {
                if (PluginPackageManager.lM().iE()) {
                    com.baidu.adp.plugin.b.a.lB().d("plugin_load", "res_failed", this.mPackageName, e.getMessage());
                    com.baidu.adp.plugin.b.a.lB().bo("plugin_res_inject_fail");
                    return false;
                }
                return false;
            } catch (Exception e2) {
                if (PluginPackageManager.lM().iE()) {
                    com.baidu.adp.plugin.b.a.lB().d("plugin_load", "res_failed", this.mPackageName, e2.getMessage());
                    com.baidu.adp.plugin.b.a.lB().bo("plugin_res_inject_fail");
                    return false;
                }
                return false;
            }
        }
        this.Co = true;
        return true;
    }

    private boolean kG() {
        return this.Cr.isFile() && this.Cr.getName().endsWith(".apk");
    }

    private void kH() {
        try {
            this.Cw = Util.bL(this.mPackageName);
            this.Cw.mkdirs();
        } catch (Exception e) {
            BdLog.e(e);
            if (PluginPackageManager.lM().iE()) {
                com.baidu.adp.plugin.b.a.lB().d("plugin_load", "createdataroot_failed", this.mPackageName, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
            }
        }
    }

    private boolean kI() {
        boolean z;
        String str;
        try {
            if (this.Cw == null || !this.Cw.exists()) {
                kH();
            }
            this.Cs = new DexClassLoader(this.Cr.getAbsolutePath(), this.Cw.getAbsolutePath(), ky(), this.mContext.getClassLoader());
            try {
                if (this.Cs != null) {
                    this.Cs.loadClass(String.valueOf(this.mPackageName) + ".Static");
                    z = true;
                } else {
                    z = true;
                }
            } catch (ClassNotFoundException e) {
                if (PluginPackageManager.lM().iE()) {
                    com.baidu.adp.plugin.b.a.lB().d("plugin_load", "loadR", this.mPackageName, e.getMessage());
                }
                BdLog.e(e);
                z = false;
            } catch (Exception e2) {
                if (PluginPackageManager.lM().iE()) {
                    com.baidu.adp.plugin.b.a.lB().d("plugin_load", "loadR2", this.mPackageName, String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName());
                }
                BdLog.e(e2);
                z = false;
            }
            if (PluginPackageManager.lM().iE() && !z) {
                com.baidu.adp.plugin.b.a.lB().bo("plugin_class_notfind");
            }
            if (z) {
                PluginSetting findPluginSetting = h.mi().findPluginSetting(this.mPackageName);
                if (findPluginSetting != null && findPluginSetting.isInjectClassloader()) {
                    ClassLoader classLoader = this.mContext.getClassLoader();
                    while (!(classLoader instanceof PathClassLoader)) {
                        classLoader = classLoader.getParent();
                    }
                    this.Cq = 1;
                    com.baidu.adp.plugin.util.d a = com.baidu.adp.plugin.util.a.a(classLoader, this.Cs, String.valueOf(this.mPackageName) + ".Static");
                    if (a != null && !a.ED) {
                        if (PluginPackageManager.lM().iE()) {
                            com.baidu.adp.plugin.b.a.lB().bo("plugin_inject_failed");
                        }
                        com.baidu.adp.plugin.b.a.lB().d("plugin_load", "inject_failed", this.mPackageName, a.mErrMsg);
                        this.Cq = 2;
                        String str2 = "";
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder();
                        ArrayList<a> allPlugins = PluginCenter.getInstance().getAllPlugins();
                        if (allPlugins != null && allPlugins.size() > 0) {
                            Iterator<a> it = allPlugins.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null) {
                                    sb.append(next.kx());
                                    sb.append(File.pathSeparator);
                                    sb2.append(next.ky());
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
                        com.baidu.adp.plugin.util.d a2 = com.baidu.adp.plugin.util.a.a(this.mContext, new DexClassLoader(str2, this.Cw.getAbsolutePath(), str, classLoader), String.valueOf(this.mPackageName) + ".Static");
                        if (a2 != null && !a2.ED) {
                            if (PluginPackageManager.lM().iE()) {
                                com.baidu.adp.plugin.b.a.lB().d("plugin_load", "replaceparent_failed", this.mPackageName, a2.mErrMsg);
                            }
                            return false;
                        } else if (a2 != null && a2.ED) {
                            com.baidu.adp.plugin.b.a.lB().bo("plugin_second_inject_succ");
                        }
                    }
                }
                this.Cn = true;
                return true;
            }
            return false;
        } catch (Exception e3) {
            BdLog.e(e3);
            if (PluginPackageManager.lM().iE()) {
                com.baidu.adp.plugin.b.a.lB().d("plugin_load", "new_dexloader_failed", this.mPackageName, String.valueOf(e3.getMessage()) + "---" + e3.getClass().getName());
            }
            return false;
        }
    }

    private boolean kJ() {
        if (this.Cs == null) {
            return false;
        }
        DexFile a = com.baidu.adp.plugin.util.e.a(this.Cs);
        String str = null;
        if (a == null) {
            try {
                a = DexFile.loadDex(this.Cr.getAbsolutePath(), D(this.Cr.getAbsolutePath(), this.Cw.getAbsolutePath()), 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                str = e.getMessage();
            }
        }
        if (a != null) {
            if (a.entries() != null) {
                try {
                    Enumeration<String> entries = a.entries();
                    while (entries.hasMoreElements()) {
                        String nextElement = entries.nextElement();
                        if (nextElement.endsWith(ad.SUFFIX) || nextElement.endsWith("Activity") || nextElement.endsWith("Service")) {
                            if (this.Cx != null && !PluginPackageManager.lM().isFeatureForbidden(nextElement)) {
                                this.Cx.add(nextElement);
                            }
                        }
                    }
                } catch (Exception e2) {
                    if (PluginPackageManager.lM().iE()) {
                        com.baidu.adp.plugin.b.a.lB().d("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, e2.getMessage());
                    }
                }
                kE();
                return true;
            } else if (PluginPackageManager.lM().iE()) {
                com.baidu.adp.plugin.b.a.lB().d("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, str);
                return false;
            } else {
                return false;
            }
        } else if (PluginPackageManager.lM().iE()) {
            com.baidu.adp.plugin.b.a.lB().d("plugin_load", "getdexfile_failed", this.mPackageName, str);
            return false;
        } else {
            return false;
        }
    }

    private static String D(String str, String str2) {
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
    public void kK() {
        if (this.Cv == null) {
            PluginBaseApplication pluginBaseApplication = new PluginBaseApplication();
            pluginBaseApplication.a((Application) this.mContext);
            pluginBaseApplication.setPluginPackageName(this.mPackageName);
            pluginBaseApplication.onCreate();
            this.Cv = pluginBaseApplication;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean bh(String str) {
        boolean kF;
        this.Cr = com.baidu.adp.plugin.install.c.bm(str);
        if (this.Cr == null) {
            h.mi().bJ(str);
            if (PluginPackageManager.lM().iE()) {
                com.baidu.adp.plugin.b.a.lB().g("plugin_load", "apk_file_null", str);
            }
            return false;
        } else if (!kG()) {
            h.mi().bJ(str);
            if (PluginPackageManager.lM().iE()) {
                com.baidu.adp.plugin.b.a.lB().g("plugin_load", "apk_file_illegal", str);
            }
            return false;
        } else {
            kH();
            if ((this.Cn || kI()) && (kF = kF())) {
                kJ();
                return Boolean.valueOf(kF);
            }
            return false;
        }
    }
}
