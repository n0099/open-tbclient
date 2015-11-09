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
    private ArrayList<String> Cf;
    private boolean BW = false;
    private boolean BX = false;
    private long BY = 0;
    private int BZ = 0;
    private File Ca = null;
    private ClassLoader Cb = null;
    private Resources Cc = null;
    private Application Cd = null;
    private File Ce = null;
    private C0009a Cg = null;
    private String mPackageName = null;
    private final Context mContext = BdBaseApplication.getInst().getApplicationContext();

    /* loaded from: classes.dex */
    public static class b {
        public boolean Cj;
        public String Ck;
        public String pkgName;
        public String reason;
    }

    public a() {
        this.Cf = null;
        this.Cf = new ArrayList<>();
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public long kn() {
        return this.BY;
    }

    public int ko() {
        return this.BZ;
    }

    public String kp() {
        if (this.Ca == null || !this.Ca.exists()) {
            return null;
        }
        return this.Ca.getAbsolutePath();
    }

    public String kq() {
        if (this.Ce == null || !this.Ce.exists()) {
            return null;
        }
        return new File(this.Ce, "lib").getAbsolutePath();
    }

    public boolean isLoaded() {
        return this.BW && this.BX;
    }

    public ClassLoader kr() {
        return this.Cb;
    }

    public Resources ks() {
        return this.Cc;
    }

    public PackageInfo kt() {
        if (this.mContext == null || this.Ca == null) {
            return null;
        }
        try {
            return this.mContext.getPackageManager().getPackageArchiveInfo(this.Ca.getAbsolutePath(), 8447);
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public Application getApplication() {
        return this.Cd;
    }

    public int ku() {
        return 16973829;
    }

    public b aX(String str) {
        b bVar = new b();
        bVar.pkgName = str;
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("Plugin asyncInitWithBroadcast args exception!");
            }
            b(str, 2, (String) null);
            bVar.Cj = false;
        } else {
            this.mPackageName = str;
            this.BY = System.currentTimeMillis();
            if (isLoaded()) {
                bVar.Cj = true;
            } else {
                bVar = aZ(str);
                if (PluginPackageManager.lS().hq() && bVar.Cj) {
                    com.baidu.adp.plugin.b.a.lG().H("plugin_load", str);
                }
                if (!bVar.Cj) {
                    b(str, 1, (String) null);
                } else {
                    kC();
                    b(str, 0, (String) null);
                }
            }
        }
        return bVar;
    }

    public boolean kv() {
        this.mPackageName = BdBaseApplication.getInst().getPackageName();
        this.Cb = this.mContext.getClassLoader();
        this.Cc = this.mContext.getResources();
        this.Cd = BdBaseApplication.getInst();
        this.BW = true;
        this.BX = true;
        return true;
    }

    public void a(String str, com.baidu.adp.plugin.util.e eVar) {
        if (this.Cg != null) {
            this.Cg.cancel();
            this.Cg = null;
        }
        this.Cg = new C0009a(str, eVar);
        this.Cg.execute(new String[0]);
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
            com.baidu.adp.plugin.b.a.lG().I("plugin_run_fail", this.mPackageName);
            return false;
        }
        try {
            Class<?> loadClass = this.Cb.loadClass(str);
            if (this.BZ == 0) {
                if (g.class.isAssignableFrom(loadClass) || com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(loadClass)) {
                    if (b(intent, str, loadClass)) {
                        context.startService(intent);
                        return true;
                    }
                    com.baidu.adp.plugin.b.a.lG().I("plugin_run_fail", this.mPackageName);
                    BdLog.e("intent remap failed");
                } else if (a(intent, str, loadClass)) {
                    context.startActivity(intent);
                    return true;
                } else {
                    com.baidu.adp.plugin.b.a.lG().I("plugin_run_fail", this.mPackageName);
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
            com.baidu.adp.plugin.b.a.lG().I("plugin_run_fail", this.mPackageName);
            BdLog.e(e);
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
            com.baidu.adp.plugin.b.a.lG().I("plugin_run_fail", this.mPackageName);
            return false;
        }
        try {
            Class<?> loadClass = this.Cb.loadClass(str);
            if (g.class.isAssignableFrom(loadClass) || com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(loadClass)) {
                if (b(intent, str, loadClass)) {
                    context.bindService(intent, serviceConnection, i);
                    return true;
                }
                com.baidu.adp.plugin.b.a.lG().I("plugin_run_fail", this.mPackageName);
                BdLog.e("intent remap failed");
            }
            return false;
        } catch (Exception e) {
            com.baidu.adp.plugin.b.a.lG().I("plugin_run_fail", this.mPackageName);
            return false;
        }
    }

    public void destroy() {
        if (this.BW && this.BX && this.Cd != null) {
            this.Cd.onTerminate();
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
    public boolean aY(String str) {
        DexFile loadDex;
        DexFile a = com.baidu.adp.plugin.util.d.a(this.Cb);
        if (a == null) {
            try {
                loadDex = DexFile.loadDex(this.Ca.getAbsolutePath(), B(this.Ca.getAbsolutePath(), this.Ce.getAbsolutePath()), 0);
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
                cls = this.Cb.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> f = e.kD().f(cls);
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
                cls = this.Cb.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> g = f.kE().g(cls);
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
    public void kw() {
        if (this.Cf != null && this.Cf.size() > 0) {
            Iterator<String> it = this.Cf.iterator();
            StringBuilder sb = null;
            while (it.hasNext()) {
                String next = it.next();
                try {
                    Class.forName(next, true, this.Cb);
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
            this.Cf.clear();
            this.Cf = null;
            if (sb != null) {
                String str = this.mPackageName;
                if (PluginPackageManager.lS().hq()) {
                    com.baidu.adp.plugin.b.a.lG().d("plugin_load", "init_static_failed", str, sb.toString());
                }
            }
        }
    }

    private b kx() {
        b bVar = new b();
        bVar.pkgName = this.mPackageName;
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(this.mPackageName);
        if (findPluginSetting == null) {
            bVar.Cj = false;
            bVar.reason = "settingnull";
            bVar.Ck = "createPluginResource";
            return bVar;
        } else if (findPluginSetting.isThird) {
            try {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{this.Ca.getAbsolutePath()});
                Resources resources = this.mContext.getResources();
                this.Cc = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                this.BX = true;
                bVar.Cj = true;
            } catch (Exception e) {
                BdLog.e(e);
            }
            return bVar;
        } else {
            boolean z = findPluginSetting.hasRes;
            this.Cc = this.mContext.getResources();
            if (BdBaseApplication.getInst().getIsPluginResourcOpen() && z) {
                if (this.Ca != null && !TextUtils.isEmpty(this.Ca.getAbsolutePath())) {
                    try {
                        j.dK().D(this.Ca.getAbsolutePath());
                        this.BX = true;
                        bVar.Cj = true;
                        return bVar;
                    } catch (Error e2) {
                        bVar.reason = "res_failed";
                        bVar.Ck = e2.getMessage();
                        bVar.Cj = false;
                        if (PluginPackageManager.lS().hq()) {
                            com.baidu.adp.plugin.b.a.lG().e("plugin_load", "res_failed", this.mPackageName, e2.getMessage());
                            com.baidu.adp.plugin.b.a.lG().bh("plugin_res_inject_fail");
                        }
                    } catch (Exception e3) {
                        bVar.reason = "res_failed";
                        bVar.Ck = e3.getMessage();
                        bVar.Cj = false;
                        if (PluginPackageManager.lS().hq()) {
                            com.baidu.adp.plugin.b.a.lG().e("plugin_load", "res_failed", this.mPackageName, e3.getMessage());
                            com.baidu.adp.plugin.b.a.lG().bh("plugin_res_inject_fail");
                        }
                    }
                }
                return bVar;
            }
            this.BX = true;
            bVar.Cj = true;
            return bVar;
        }
    }

    private boolean ky() {
        return this.Ca.isFile() && this.Ca.getName().endsWith(".apk");
    }

    private void kz() {
        try {
            this.Ce = Util.bI(this.mPackageName);
            this.Ce.mkdirs();
        } catch (Exception e) {
            BdLog.e(e);
            if (PluginPackageManager.lS().hq()) {
                com.baidu.adp.plugin.b.a.lG().e("plugin_load", "createdataroot_failed", this.mPackageName, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
            }
        }
    }

    private b kA() {
        boolean z;
        String str;
        b bVar = new b();
        bVar.pkgName = this.mPackageName;
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(this.mPackageName);
        if (findPluginSetting == null) {
            bVar.Cj = false;
            bVar.reason = "settingnull";
            bVar.Ck = "createClassLoader";
            return bVar;
        }
        try {
            if (this.Ce == null || !this.Ce.exists()) {
                kz();
            }
            ClassLoader classLoader = this.mContext.getClassLoader();
            if (findPluginSetting.isThird) {
                this.Cb = new d(this.Ca.getAbsolutePath(), this.Ce.getAbsolutePath(), kq(), classLoader, classLoader);
            } else {
                this.Cb = new DexClassLoader(this.Ca.getAbsolutePath(), this.Ce.getAbsolutePath(), kq(), classLoader);
            }
            try {
                if (this.Cb != null) {
                    this.Cb.loadClass(String.valueOf(this.mPackageName) + ".Static");
                    z = true;
                } else {
                    z = true;
                }
            } catch (ClassNotFoundException e) {
                bVar.reason = "loadR";
                bVar.Ck = e.getMessage();
                if (PluginPackageManager.lS().hq()) {
                    com.baidu.adp.plugin.b.a.lG().e("plugin_load", "loadR", this.mPackageName, e.getMessage());
                }
                BdLog.e(e);
                z = false;
            } catch (Exception e2) {
                bVar.reason = "loadR2";
                bVar.Ck = String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName();
                if (PluginPackageManager.lS().hq()) {
                    com.baidu.adp.plugin.b.a.lG().e("plugin_load", "loadR2", this.mPackageName, String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName());
                }
                BdLog.e(e2);
                z = false;
            }
            if (PluginPackageManager.lS().hq() && !z) {
                com.baidu.adp.plugin.b.a.lG().bh("plugin_class_notfind");
            }
            if (!z) {
                bVar.Cj = false;
                return bVar;
            }
            if (findPluginSetting.isInjectClassloader()) {
                ClassLoader classLoader2 = this.mContext.getClassLoader();
                while (!(classLoader2 instanceof PathClassLoader)) {
                    classLoader2 = classLoader2.getParent();
                }
                this.BZ = 1;
                a.C0012a a = com.baidu.adp.plugin.util.a.a(classLoader2, this.Cb, String.valueOf(this.mPackageName) + ".Static");
                if (a != null && !a.EH) {
                    if (PluginPackageManager.lS().hq()) {
                        com.baidu.adp.plugin.b.a.lG().bh("plugin_inject_failed");
                    }
                    bVar.reason = "inject_failed";
                    bVar.Ck = a.mErrMsg;
                    com.baidu.adp.plugin.b.a.lG().e("plugin_load", "inject_failed", this.mPackageName, a.mErrMsg);
                    this.BZ = 2;
                    String str2 = "";
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    ArrayList<a> allPlugins = PluginCenter.getInstance().getAllPlugins();
                    if (allPlugins != null && allPlugins.size() > 0) {
                        Iterator<a> it = allPlugins.iterator();
                        while (it.hasNext()) {
                            a next = it.next();
                            if (next != null) {
                                sb.append(next.kp());
                                sb.append(File.pathSeparator);
                                sb2.append(next.kq());
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
                    a.C0012a a2 = com.baidu.adp.plugin.util.a.a(this.mContext, new DexClassLoader(str2, this.Ce.getAbsolutePath(), str, classLoader2), String.valueOf(this.mPackageName) + ".Static");
                    if (a2 != null && !a2.EH) {
                        if (PluginPackageManager.lS().hq()) {
                            com.baidu.adp.plugin.b.a.lG().e("plugin_load", "replaceparent_failed", this.mPackageName, a2.mErrMsg);
                        }
                        bVar.Cj = false;
                        bVar.reason = "replaceparent_failed";
                        bVar.Ck = a2.mErrMsg;
                        return bVar;
                    } else if (a2 != null && a2.EH) {
                        com.baidu.adp.plugin.b.a.lG().bh("plugin_second_inject_succ");
                    }
                }
            }
            this.BW = true;
            bVar.Cj = true;
            return bVar;
        } catch (Exception e3) {
            BdLog.e(e3);
            bVar.Cj = false;
            bVar.reason = "new_dexloader_failed";
            bVar.Ck = String.valueOf(e3.getMessage()) + "---" + e3.getClass().getName();
            if (PluginPackageManager.lS().hq()) {
                com.baidu.adp.plugin.b.a.lG().e("plugin_load", "new_dexloader_failed", this.mPackageName, String.valueOf(e3.getMessage()) + "---" + e3.getClass().getName());
            }
            return bVar;
        }
    }

    private boolean kB() {
        if (this.Cb == null) {
            return false;
        }
        DexFile a = com.baidu.adp.plugin.util.d.a(this.Cb);
        String str = null;
        if (a == null) {
            try {
                a = DexFile.loadDex(this.Ca.getAbsolutePath(), B(this.Ca.getAbsolutePath(), this.Ce.getAbsolutePath()), 0);
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
                        if (nextElement.endsWith(u.SUFFIX) && this.Cf != null && !PluginPackageManager.lS().isFeatureForbidden(nextElement)) {
                            this.Cf.add(nextElement);
                        }
                    }
                    kw();
                    return true;
                } catch (Exception e2) {
                    if (PluginPackageManager.lS().hq()) {
                        com.baidu.adp.plugin.b.a.lG().e("plugin_load", "getdexfile_failed_reverse", this.mPackageName, e2.getMessage());
                    }
                    return false;
                }
            }
            if (PluginPackageManager.lS().hq()) {
                com.baidu.adp.plugin.b.a.lG().e("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, str);
            }
            return false;
        }
        if (PluginPackageManager.lS().hq()) {
            com.baidu.adp.plugin.b.a.lG().e("plugin_load", "getdexfile_failed", this.mPackageName, str);
        }
        return false;
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
    public void kC() {
        if (this.Cd == null) {
            PluginBaseApplication pluginBaseApplication = new PluginBaseApplication();
            pluginBaseApplication.a((Application) this.mContext);
            pluginBaseApplication.setPluginPackageName(this.mPackageName);
            pluginBaseApplication.onCreate();
            this.Cd = pluginBaseApplication;
        }
    }

    /* renamed from: com.baidu.adp.plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0009a extends BdAsyncTask<String, Object, b> {
        private com.baidu.adp.plugin.util.e Ch;
        private String packageName;

        public C0009a(String str, com.baidu.adp.plugin.util.e eVar) {
            this.packageName = null;
            this.Ch = null;
            this.packageName = str;
            this.Ch = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public b doInBackground(String... strArr) {
            return a.this.aZ(this.packageName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(b bVar) {
            super.onPostExecute(bVar);
            if (this.Ch != null) {
                this.Ch.a(bVar, this.packageName);
            } else {
                BdLog.e("listener is null");
                if (PluginPackageManager.lS().hq()) {
                    com.baidu.adp.plugin.b.a.lG().g("plugin_load", "listener_null", this.packageName);
                }
            }
            if (bVar.Cj) {
                a.this.kw();
                a.this.kC();
                a.this.b(this.packageName, 0, (String) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b aZ(String str) {
        PluginSetting findPluginSetting;
        String str2;
        b bVar = new b();
        bVar.pkgName = str;
        this.Ca = com.baidu.adp.plugin.install.d.be(str);
        if (this.Ca == null) {
            if (PluginPackageManager.lS().hq()) {
                if (com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().findPluginSetting(str) != null) {
                    str2 = "-versioncode-" + findPluginSetting.versionCode + "-enable-" + findPluginSetting.enable + "-forbid-" + findPluginSetting.forbidden + "-installstatus-" + findPluginSetting.installStatus + "-url-" + findPluginSetting.url + "-size-" + findPluginSetting.size + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path();
                } else {
                    str2 = "settingssize-" + com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().ml().getPlugins().size() + "-filesize-" + new File(com.baidu.adp.plugin.packageManager.pluginSettings.b.mk().mn()).length();
                }
                bVar.reason = "apk_file_null";
                bVar.Ck = str2;
                com.baidu.adp.plugin.b.a.lG().e("plugin_load", "apk_file_null", str, str2);
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().bD(str);
            bVar.Cj = false;
            return bVar;
        } else if (!ky()) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().bD(str);
            if (PluginPackageManager.lS().hq()) {
                com.baidu.adp.plugin.b.a.lG().g("plugin_load", "apk_file_illegal", str);
            }
            bVar.Cj = false;
            bVar.reason = "apk_file_illegal";
            return bVar;
        } else {
            kz();
            if (!this.BW) {
                b kA = kA();
                if (!kA.Cj) {
                    return kA;
                }
            }
            b kx = kx();
            if (kx.Cj) {
                kB();
                kx.Cj = true;
                return kx;
            }
            return kx;
        }
    }
}
