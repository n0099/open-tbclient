package com.baidu.adp.plugin;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.aa;
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
    private ArrayList<String> rN;
    private int rF = 0;
    private File rG = null;
    private ClassLoader rH = null;
    private Resources rI = null;
    private AssetManager rJ = null;
    private PluginBaseApplication rK = null;
    private File rL = null;
    private boolean rM = false;
    private c rO = null;
    private boolean rP = false;
    private String mPackageName = null;
    private final Context mContext = BdBaseApplication.getInst().getApplicationContext();

    public b() {
        this.rN = null;
        this.rN = new ArrayList<>();
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int gJ() {
        return this.rF;
    }

    public String gK() {
        if (this.rG == null || !this.rG.exists()) {
            return null;
        }
        return this.rG.getAbsolutePath();
    }

    public String gL() {
        if (this.rL == null || !this.rL.exists()) {
            return null;
        }
        return new File(this.rL, "lib").getAbsolutePath();
    }

    public boolean isLoaded() {
        return this.rM;
    }

    public ClassLoader gM() {
        return this.rH;
    }

    public Resources gN() {
        return this.rI;
    }

    public PackageInfo gO() {
        if (this.mContext == null || this.rG == null) {
            return null;
        }
        try {
            return this.mContext.getPackageManager().getPackageArchiveInfo(this.rG.getAbsolutePath(), 8447);
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public PluginBaseApplication gP() {
        return this.rK;
    }

    public boolean aN(String str) {
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
        if (this.rP) {
            return false;
        }
        this.rP = true;
        boolean booleanValue = aO(str).booleanValue();
        gR();
        gW();
        b(str, 0, (String) null);
        if (PluginPackageManager.ic().il()) {
            if (booleanValue) {
                com.baidu.adp.plugin.b.a.hU().D("plugin_load", str);
                f.es().eventStat(this.mContext, "plugin_loaded_succ", null, 1, new Object[0]);
                return true;
            }
            f.es().eventStat(this.mContext, "plugin_loaded_failed", null, 1, new Object[0]);
            return true;
        }
        return true;
    }

    public boolean gQ() {
        this.mPackageName = BdBaseApplication.getInst().getPackageName();
        this.rH = this.mContext.getClassLoader();
        this.rI = this.mContext.getResources();
        gW();
        return true;
    }

    public void a(String str, com.baidu.adp.plugin.util.d dVar) {
        if (this.rO != null) {
            this.rO.cancel();
            this.rO = null;
        }
        this.rO = new c(this, str, dVar);
        this.rO.execute(new String[0]);
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
            Class<?> loadClass = this.rH.loadClass(str);
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

    private boolean a(Intent intent, String str, Class<?> cls) {
        intent.putExtra("intent_extra_activity", str);
        intent.putExtra("intent_extra_package_name", this.mPackageName);
        if (cls == null) {
            try {
                cls = this.rH.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> m = d.hg().m(cls);
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
                cls = this.rH.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> n = e.hh().n(cls);
        if (n != null) {
            intent.setClass(this.mContext, n);
            return true;
        }
        return false;
    }

    private void b(String str, int i, String str2) {
        this.rM = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000997, new com.baidu.adp.plugin.message.a(str, i, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR() {
        if (this.rN != null && this.rN.size() > 0) {
            Iterator<String> it = this.rN.iterator();
            StringBuilder sb = null;
            while (it.hasNext()) {
                String next = it.next();
                try {
                    Class.forName(next, true, this.rH);
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
            this.rN.clear();
            this.rN = null;
            if (sb != null) {
                String str = this.mPackageName;
                if (PluginPackageManager.ic().il()) {
                    com.baidu.adp.plugin.b.a.hU().c("plugin_load", "init_static_failed", str, sb.toString());
                }
            }
        }
    }

    private void gS() {
        this.rI = this.mContext.getResources();
    }

    private boolean gT() {
        return this.rG.isFile() && this.rG.getName().endsWith(".apk");
    }

    private void gU() {
        try {
            this.rL = Util.bx(this.mPackageName);
            this.rL.mkdirs();
        } catch (Exception e) {
            BdLog.e(e);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().c("plugin_load", "createdataroot_failed", this.mPackageName, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
            }
        }
    }

    private boolean gV() {
        boolean z;
        String message;
        try {
            if (this.rL == null || !this.rL.exists()) {
                gU();
            }
            this.rH = new DexClassLoader(this.rG.getAbsolutePath(), this.rL.getAbsolutePath(), gL(), this.mContext.getClassLoader());
            try {
                if (this.rH != null) {
                    this.rH.loadClass(String.valueOf(this.mPackageName) + ".Static");
                    z = true;
                } else {
                    z = true;
                }
            } catch (ClassNotFoundException e) {
                if (PluginPackageManager.ic().il()) {
                    com.baidu.adp.plugin.b.a.hU().c("plugin_load", "loadR", this.mPackageName, e.getMessage());
                }
                BdLog.e(e);
                z = false;
            } catch (Exception e2) {
                if (PluginPackageManager.ic().il()) {
                    com.baidu.adp.plugin.b.a.hU().c("plugin_load", "loadR2", this.mPackageName, String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName());
                }
                BdLog.e(e2);
                z = false;
            }
            if (PluginPackageManager.ic().il() && !z) {
                f.es().eventStat(this.mContext, "plugin_class_notfind", null, 1, new Object[0]);
            }
            if (z) {
                PluginSetting findPluginSetting = h.iy().findPluginSetting(this.mPackageName);
                if (findPluginSetting != null && findPluginSetting.isInjectClassloader()) {
                    ClassLoader classLoader = this.mContext.getClassLoader();
                    while (!(classLoader instanceof PathClassLoader)) {
                        classLoader = classLoader.getParent();
                    }
                    this.rF = 1;
                    com.baidu.adp.plugin.util.b a = com.baidu.adp.plugin.util.a.a(classLoader, this.rH, String.valueOf(this.mPackageName) + ".Static");
                    if (a == null || (a != null && !a.tN)) {
                        if (PluginPackageManager.ic().il()) {
                            f.es().eventStat(this.mContext, "plugin_inject_failed", null, 1, new Object[0]);
                            com.baidu.adp.plugin.b.a.hU().c("plugin_load", "inject_failed", this.mPackageName, a.mErrMsg);
                        }
                        return false;
                    }
                }
                DexFile a2 = com.baidu.adp.plugin.util.c.a(this.rH);
                if (a2 == null) {
                    try {
                        a2 = DexFile.loadDex(this.rG.getAbsolutePath(), A(this.rG.getAbsolutePath(), this.rL.getAbsolutePath()), 0);
                        message = null;
                    } catch (Exception e3) {
                        BdLog.e(e3.getMessage());
                        message = e3.getMessage();
                    }
                } else {
                    message = null;
                }
                if (a2 != null) {
                    if (a2.entries() != null) {
                        try {
                            Enumeration<String> entries = a2.entries();
                            while (entries.hasMoreElements()) {
                                String nextElement = entries.nextElement();
                                if (nextElement.endsWith(aa.SUFFIX) || nextElement.endsWith("Activity") || nextElement.endsWith("Service")) {
                                    if (!nextElement.endsWith("WXCallbackActivity") && this.rN != null && !PluginPackageManager.ic().isFeatureForbidden(nextElement)) {
                                        this.rN.add(nextElement);
                                    }
                                }
                            }
                        } catch (Exception e4) {
                            if (PluginPackageManager.ic().il()) {
                                com.baidu.adp.plugin.b.a.hU().c("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, e4.getMessage());
                            }
                        }
                    } else if (PluginPackageManager.ic().il()) {
                        com.baidu.adp.plugin.b.a.hU().c("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, message);
                    }
                } else if (PluginPackageManager.ic().il()) {
                    com.baidu.adp.plugin.b.a.hU().c("plugin_load", "getdexfile_failed", this.mPackageName, message);
                }
                return true;
            }
            return false;
        } catch (Exception e5) {
            BdLog.e(e5);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().c("plugin_load", "new_dexloader_failed", this.mPackageName, String.valueOf(e5.getMessage()) + "---" + e5.getClass().getName());
            }
            return false;
        }
    }

    private static String A(String str, String str2) {
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
    public void gW() {
        if (this.rK == null) {
            this.rK = new PluginBaseApplication();
            this.rK.a((Application) this.mContext);
            this.rK.setPluginPackageName(this.mPackageName);
            this.rK.onCreate();
            this.rM = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean aO(String str) {
        this.rG = com.baidu.adp.plugin.install.c.aX(str);
        if (this.rG == null) {
            h.iy().bu(str);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().g("plugin_load", "apk_file_null", str);
            }
            return false;
        } else if (!gT()) {
            h.iy().bu(str);
            if (PluginPackageManager.ic().il()) {
                com.baidu.adp.plugin.b.a.hU().g("plugin_load", "apk_file_illegal", str);
            }
            return false;
        } else {
            gU();
            boolean gV = gV();
            if (!gV) {
                return false;
            }
            gS();
            return Boolean.valueOf(gV);
        }
    }
}
