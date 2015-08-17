package com.baidu.adp.plugin;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import com.baidu.adp.plugin.message.PluginLoadedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.pluginBase.PluginBaseApplication;
import com.baidu.adp.plugin.pluginBase.g;
import com.baidu.adp.plugin.util.Util;
import com.baidu.adp.plugin.util.a;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private ArrayList<String> Cg;
    private boolean BX = false;
    private boolean BY = false;
    private long BZ = 0;
    private int Ca = 0;
    private File Cb = null;
    private ClassLoader Cc = null;
    private Resources Cd = null;
    private Application Ce = null;
    private File Cf = null;
    private C0009a Ch = null;
    private String mPackageName = null;
    private final Context mContext = BdBaseApplication.getInst().getApplicationContext();

    public a() {
        this.Cg = null;
        this.Cg = new ArrayList<>();
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public long ko() {
        return this.BZ;
    }

    public int kp() {
        return this.Ca;
    }

    public String kq() {
        if (this.Cb == null || !this.Cb.exists()) {
            return null;
        }
        return this.Cb.getAbsolutePath();
    }

    public String kr() {
        if (this.Cf == null || !this.Cf.exists()) {
            return null;
        }
        return new File(this.Cf, "lib").getAbsolutePath();
    }

    public boolean isLoaded() {
        return this.BX && this.BY;
    }

    public ClassLoader ks() {
        return this.Cc;
    }

    public Resources kt() {
        return this.Cd;
    }

    public PackageInfo ku() {
        if (this.mContext == null || this.Cb == null) {
            return null;
        }
        try {
            return this.mContext.getPackageManager().getPackageArchiveInfo(this.Cb.getAbsolutePath(), 8447);
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public Application getApplication() {
        return this.Ce;
    }

    public int kv() {
        return 16973829;
    }

    public boolean aY(String str) {
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("Plugin asyncInitWithBroadcast args exception!");
            }
            b(str, 2, (String) null);
            return false;
        }
        this.mPackageName = str;
        this.BZ = System.currentTimeMillis();
        if (isLoaded()) {
            return true;
        }
        boolean booleanValue = ba(str).booleanValue();
        if (PluginPackageManager.lT().hr() && booleanValue) {
            com.baidu.adp.plugin.b.a.lH().H("plugin_load", str);
        }
        if (!booleanValue) {
            b(str, 1, (String) null);
            return false;
        }
        kD();
        b(str, 0, (String) null);
        return true;
    }

    public boolean kw() {
        this.mPackageName = BdBaseApplication.getInst().getPackageName();
        this.Cc = this.mContext.getClassLoader();
        this.Cd = this.mContext.getResources();
        this.Ce = BdBaseApplication.getInst();
        this.BX = true;
        this.BY = true;
        return true;
    }

    public void a(String str, com.baidu.adp.plugin.util.e eVar) {
        if (this.Ch != null) {
            this.Ch.cancel();
            this.Ch = null;
        }
        this.Ch = new C0009a(str, eVar);
        this.Ch.execute(new String[0]);
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
            com.baidu.adp.plugin.b.a.lH().bi("plugin_run_fail");
            return false;
        }
        try {
            Class<?> loadClass = this.Cc.loadClass(str);
            if (this.Ca == 0) {
                if (g.class.isAssignableFrom(loadClass) || com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(loadClass)) {
                    if (b(intent, str, loadClass)) {
                        context.startService(intent);
                        return true;
                    }
                    com.baidu.adp.plugin.b.a.lH().bi("plugin_run_fail");
                    BdLog.e("intent remap failed");
                } else if (a(intent, str, loadClass)) {
                    context.startActivity(intent);
                    return true;
                } else {
                    com.baidu.adp.plugin.b.a.lH().bi("plugin_run_fail");
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
            com.baidu.adp.plugin.b.a.lH().bi("plugin_run_fail");
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
            com.baidu.adp.plugin.b.a.lH().bi("plugin_run_fail");
            return false;
        }
        try {
            Class<?> loadClass = this.Cc.loadClass(str);
            if (g.class.isAssignableFrom(loadClass) || com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(loadClass)) {
                if (b(intent, str, loadClass)) {
                    context.bindService(intent, serviceConnection, i);
                    return true;
                }
                com.baidu.adp.plugin.b.a.lH().bi("plugin_run_fail");
                BdLog.e("intent remap failed");
            }
            return false;
        } catch (Exception e) {
            com.baidu.adp.plugin.b.a.lH().bi("plugin_run_fail");
            return false;
        }
    }

    public void destroy() {
        if (this.BX && this.BY && this.Ce != null) {
            this.Ce.onTerminate();
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
    public boolean aZ(String str) {
        DexFile loadDex;
        DexFile a = com.baidu.adp.plugin.util.d.a(this.Cc);
        if (a == null) {
            try {
                loadDex = DexFile.loadDex(this.Cb.getAbsolutePath(), B(this.Cb.getAbsolutePath(), this.Cf.getAbsolutePath()), 0);
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
                cls = this.Cc.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> f = d.kE().f(cls);
        if (f != null) {
            intent.setClass(this.mContext, f);
            return true;
        }
        return false;
    }

    private boolean b(Intent intent, String str, Class<?> cls) {
        intent.putExtra("intent_extra_service", str);
        intent.putExtra("intent_extra_package_name", this.mPackageName);
        if (cls == null) {
            try {
                cls = this.Cc.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> g = e.kF().g(cls);
        if (g != null) {
            intent.setClass(this.mContext, g);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i, String str2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000997, new PluginLoadedMessage.a(str, i, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kx() {
        if (this.Cg != null && this.Cg.size() > 0) {
            Iterator<String> it = this.Cg.iterator();
            StringBuilder sb = null;
            while (it.hasNext()) {
                String next = it.next();
                try {
                    Class.forName(next, true, this.Cc);
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
            this.Cg.clear();
            this.Cg = null;
            if (sb != null) {
                String str = this.mPackageName;
                if (PluginPackageManager.lT().hr()) {
                    com.baidu.adp.plugin.b.a.lH().d("plugin_load", "init_static_failed", str, sb.toString());
                }
            }
        }
    }

    private boolean ky() {
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(this.mPackageName);
        boolean z = findPluginSetting != null ? findPluginSetting.hasRes : false;
        this.Cd = this.mContext.getResources();
        if (BdBaseApplication.getInst().getIsPluginResourcOpen() && z) {
            if (this.Cb == null || TextUtils.isEmpty(this.Cb.getAbsolutePath())) {
                return false;
            }
            try {
                j.dK().D(this.Cb.getAbsolutePath());
                this.BY = true;
                return true;
            } catch (Error e) {
                if (PluginPackageManager.lT().hr()) {
                    com.baidu.adp.plugin.b.a.lH().d("plugin_load", "res_failed", this.mPackageName, e.getMessage());
                    com.baidu.adp.plugin.b.a.lH().bi("plugin_res_inject_fail");
                    return false;
                }
                return false;
            } catch (Exception e2) {
                if (PluginPackageManager.lT().hr()) {
                    com.baidu.adp.plugin.b.a.lH().d("plugin_load", "res_failed", this.mPackageName, e2.getMessage());
                    com.baidu.adp.plugin.b.a.lH().bi("plugin_res_inject_fail");
                    return false;
                }
                return false;
            }
        }
        this.BY = true;
        return true;
    }

    private boolean kz() {
        return this.Cb.isFile() && this.Cb.getName().endsWith(".apk");
    }

    private void kA() {
        try {
            this.Cf = Util.bI(this.mPackageName);
            this.Cf.mkdirs();
        } catch (Exception e) {
            BdLog.e(e);
            if (PluginPackageManager.lT().hr()) {
                com.baidu.adp.plugin.b.a.lH().d("plugin_load", "createdataroot_failed", this.mPackageName, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
            }
        }
    }

    private boolean kB() {
        boolean z;
        String str;
        try {
            if (this.Cf == null || !this.Cf.exists()) {
                kA();
            }
            this.Cc = new DexClassLoader(this.Cb.getAbsolutePath(), this.Cf.getAbsolutePath(), kr(), this.mContext.getClassLoader());
            try {
                if (this.Cc != null) {
                    this.Cc.loadClass(String.valueOf(this.mPackageName) + ".Static");
                    z = true;
                } else {
                    z = true;
                }
            } catch (ClassNotFoundException e) {
                if (PluginPackageManager.lT().hr()) {
                    com.baidu.adp.plugin.b.a.lH().d("plugin_load", "loadR", this.mPackageName, e.getMessage());
                }
                BdLog.e(e);
                z = false;
            } catch (Exception e2) {
                if (PluginPackageManager.lT().hr()) {
                    com.baidu.adp.plugin.b.a.lH().d("plugin_load", "loadR2", this.mPackageName, String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName());
                }
                BdLog.e(e2);
                z = false;
            }
            if (PluginPackageManager.lT().hr() && !z) {
                com.baidu.adp.plugin.b.a.lH().bi("plugin_class_notfind");
            }
            if (z) {
                PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(this.mPackageName);
                if (findPluginSetting != null && findPluginSetting.isInjectClassloader()) {
                    ClassLoader classLoader = this.mContext.getClassLoader();
                    while (!(classLoader instanceof PathClassLoader)) {
                        classLoader = classLoader.getParent();
                    }
                    this.Ca = 1;
                    a.C0012a a = com.baidu.adp.plugin.util.a.a(classLoader, this.Cc, String.valueOf(this.mPackageName) + ".Static");
                    if (a != null && !a.EE) {
                        if (PluginPackageManager.lT().hr()) {
                            com.baidu.adp.plugin.b.a.lH().bi("plugin_inject_failed");
                        }
                        com.baidu.adp.plugin.b.a.lH().d("plugin_load", "inject_failed", this.mPackageName, a.mErrMsg);
                        this.Ca = 2;
                        String str2 = "";
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder();
                        ArrayList<a> allPlugins = PluginCenter.getInstance().getAllPlugins();
                        if (allPlugins != null && allPlugins.size() > 0) {
                            Iterator<a> it = allPlugins.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next != null) {
                                    sb.append(next.kq());
                                    sb.append(File.pathSeparator);
                                    sb2.append(next.kr());
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
                        a.C0012a a2 = com.baidu.adp.plugin.util.a.a(this.mContext, new DexClassLoader(str2, this.Cf.getAbsolutePath(), str, classLoader), String.valueOf(this.mPackageName) + ".Static");
                        if (a2 != null && !a2.EE) {
                            if (PluginPackageManager.lT().hr()) {
                                com.baidu.adp.plugin.b.a.lH().d("plugin_load", "replaceparent_failed", this.mPackageName, a2.mErrMsg);
                            }
                            return false;
                        } else if (a2 != null && a2.EE) {
                            com.baidu.adp.plugin.b.a.lH().bi("plugin_second_inject_succ");
                        }
                    }
                }
                this.BX = true;
                return true;
            }
            return false;
        } catch (Exception e3) {
            BdLog.e(e3);
            if (PluginPackageManager.lT().hr()) {
                com.baidu.adp.plugin.b.a.lH().d("plugin_load", "new_dexloader_failed", this.mPackageName, String.valueOf(e3.getMessage()) + "---" + e3.getClass().getName());
            }
            return false;
        }
    }

    private boolean kC() {
        if (this.Cc == null) {
            return false;
        }
        DexFile a = com.baidu.adp.plugin.util.d.a(this.Cc);
        String str = null;
        if (a == null) {
            try {
                a = DexFile.loadDex(this.Cb.getAbsolutePath(), B(this.Cb.getAbsolutePath(), this.Cf.getAbsolutePath()), 0);
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
                        if (nextElement.endsWith(u.SUFFIX) || nextElement.endsWith("Activity") || nextElement.endsWith("Service")) {
                            if (this.Cg != null && !PluginPackageManager.lT().isFeatureForbidden(nextElement)) {
                                this.Cg.add(nextElement);
                            }
                        }
                    }
                } catch (Exception e2) {
                    if (PluginPackageManager.lT().hr()) {
                        com.baidu.adp.plugin.b.a.lH().d("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, e2.getMessage());
                    }
                }
                kx();
                return true;
            } else if (PluginPackageManager.lT().hr()) {
                com.baidu.adp.plugin.b.a.lH().d("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, str);
                return false;
            } else {
                return false;
            }
        } else if (PluginPackageManager.lT().hr()) {
            com.baidu.adp.plugin.b.a.lH().d("plugin_load", "getdexfile_failed", this.mPackageName, str);
            return false;
        } else {
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
    public void kD() {
        if (this.Ce == null) {
            PluginBaseApplication pluginBaseApplication = new PluginBaseApplication();
            pluginBaseApplication.a((Application) this.mContext);
            pluginBaseApplication.setPluginPackageName(this.mPackageName);
            pluginBaseApplication.onCreate();
            this.Ce = pluginBaseApplication;
        }
    }

    /* renamed from: com.baidu.adp.plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0009a extends BdAsyncTask<String, Object, Boolean> {
        private com.baidu.adp.plugin.util.e Ci;
        private String packageName;

        public C0009a(String str, com.baidu.adp.plugin.util.e eVar) {
            this.packageName = null;
            this.Ci = null;
            this.packageName = str;
            this.Ci = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Boolean doInBackground(String... strArr) {
            return a.this.ba(this.packageName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (this.Ci != null) {
                this.Ci.c(bool.booleanValue(), this.packageName);
            } else {
                BdLog.e("listener is null");
                if (PluginPackageManager.lT().hr()) {
                    com.baidu.adp.plugin.b.a.lH().g("plugin_load", "listener_null", this.packageName);
                }
            }
            if (bool.booleanValue()) {
                a.this.kx();
                a.this.kD();
                a.this.b(this.packageName, 0, (String) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean ba(String str) {
        boolean ky;
        PluginSetting findPluginSetting;
        this.Cb = com.baidu.adp.plugin.install.d.bf(str);
        if (this.Cb == null) {
            if (PluginPackageManager.lT().hr()) {
                String str2 = null;
                if (com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().findPluginSetting(str) != null) {
                    str2 = "-versioncode-" + findPluginSetting.versionCode + "-enable-" + findPluginSetting.enable + "-forbid-" + findPluginSetting.forbidden + "-installstatus-" + findPluginSetting.installStatus + "-url-" + findPluginSetting.url + "-size-" + findPluginSetting.size + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path();
                }
                com.baidu.adp.plugin.b.a.lH().d("plugin_load", "apk_file_null", str, str2);
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().bD(str);
            return false;
        } else if (!kz()) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().bD(str);
            if (PluginPackageManager.lT().hr()) {
                com.baidu.adp.plugin.b.a.lH().g("plugin_load", "apk_file_illegal", str);
            }
            return false;
        } else {
            kA();
            if ((this.BX || kB()) && (ky = ky())) {
                kC();
                return Boolean.valueOf(ky);
            }
            return false;
        }
    }
}
