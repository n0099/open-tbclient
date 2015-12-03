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
    private ArrayList<String> Cm;
    private boolean Cd = false;
    private boolean Ce = false;
    private long Cf = 0;
    private int Cg = 0;
    private File Ch = null;
    private ClassLoader Ci = null;
    private Resources Cj = null;
    private Application Ck = null;
    private File Cl = null;
    private C0009a Cn = null;
    private String mPackageName = null;
    private final Context mContext = BdBaseApplication.getInst().getApplicationContext();

    /* loaded from: classes.dex */
    public static class b {
        public boolean Cq;
        public String Cr;
        public String pkgName;
        public String reason;
    }

    public a() {
        this.Cm = null;
        this.Cm = new ArrayList<>();
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public long ko() {
        return this.Cf;
    }

    public int kp() {
        return this.Cg;
    }

    public String kq() {
        if (this.Ch == null || !this.Ch.exists()) {
            return null;
        }
        return this.Ch.getAbsolutePath();
    }

    public String kr() {
        if (this.Cl == null || !this.Cl.exists()) {
            return null;
        }
        return new File(this.Cl, "lib").getAbsolutePath();
    }

    public boolean isLoaded() {
        return this.Cd && this.Ce;
    }

    public ClassLoader ks() {
        return this.Ci;
    }

    public Resources kt() {
        return this.Cj;
    }

    public PackageInfo ku() {
        if (this.mContext == null || this.Ch == null) {
            return null;
        }
        try {
            return this.mContext.getPackageManager().getPackageArchiveInfo(this.Ch.getAbsolutePath(), 8447);
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public Application getApplication() {
        return this.Ck;
    }

    public int kv() {
        return 16973829;
    }

    public b bb(String str) {
        b bVar = new b();
        bVar.pkgName = str;
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("Plugin asyncInitWithBroadcast args exception!");
            }
            b(str, 2, (String) null);
            bVar.Cq = false;
        } else {
            this.mPackageName = str;
            this.Cf = System.currentTimeMillis();
            if (isLoaded()) {
                bVar.Cq = true;
            } else {
                kD();
                bVar = bd(str);
                if (PluginPackageManager.lU().hs() && bVar.Cq) {
                    com.baidu.adp.plugin.b.a.lI().E("plugin_load", str);
                }
                if (!bVar.Cq) {
                    b(str, 1, (String) null);
                } else {
                    b(str, 0, (String) null);
                }
            }
        }
        return bVar;
    }

    public boolean kw() {
        this.mPackageName = BdBaseApplication.getInst().getPackageName();
        this.Ci = this.mContext.getClassLoader();
        this.Cj = this.mContext.getResources();
        this.Ck = BdBaseApplication.getInst();
        this.Cd = true;
        this.Ce = true;
        return true;
    }

    public void a(String str, com.baidu.adp.plugin.util.e eVar) {
        if (this.Cn != null) {
            this.Cn.cancel();
            this.Cn = null;
        }
        this.Cn = new C0009a(str, eVar);
        this.Cn.execute(new String[0]);
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
            com.baidu.adp.plugin.b.a.lI().F("plugin_run_fail", this.mPackageName);
            return false;
        }
        try {
            Class<?> loadClass = this.Ci.loadClass(str);
            if (this.Cg == 0) {
                if (g.class.isAssignableFrom(loadClass) || com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(loadClass)) {
                    if (b(intent, str, loadClass)) {
                        context.startService(intent);
                        return true;
                    }
                    com.baidu.adp.plugin.b.a.lI().F("plugin_run_fail", this.mPackageName);
                    BdLog.e("intent remap failed");
                } else if (a(intent, str, loadClass)) {
                    context.startActivity(intent);
                    return true;
                } else {
                    com.baidu.adp.plugin.b.a.lI().F("plugin_run_fail", this.mPackageName);
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
            com.baidu.adp.plugin.b.a.lI().F("plugin_run_fail", this.mPackageName);
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
            com.baidu.adp.plugin.b.a.lI().F("plugin_run_fail", this.mPackageName);
            return false;
        }
        try {
            Class<?> loadClass = this.Ci.loadClass(str);
            if (g.class.isAssignableFrom(loadClass) || com.baidu.adp.plugin.pluginBase.e.class.isAssignableFrom(loadClass)) {
                if (b(intent, str, loadClass)) {
                    context.bindService(intent, serviceConnection, i);
                    return true;
                }
                com.baidu.adp.plugin.b.a.lI().F("plugin_run_fail", this.mPackageName);
                BdLog.e("intent remap failed");
            }
            return false;
        } catch (Exception e) {
            com.baidu.adp.plugin.b.a.lI().F("plugin_run_fail", this.mPackageName);
            return false;
        }
    }

    public void destroy() {
        if (this.Cd && this.Ce && this.Ck != null) {
            this.Ck.onTerminate();
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
    public boolean bc(String str) {
        DexFile loadDex;
        DexFile a = com.baidu.adp.plugin.util.d.a(this.Ci);
        if (a == null) {
            try {
                loadDex = DexFile.loadDex(this.Ch.getAbsolutePath(), C(this.Ch.getAbsolutePath(), this.Cl.getAbsolutePath()), 0);
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
                cls = this.Ci.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> g = e.kE().g(cls);
        if (g != null) {
            intent.setClass(this.mContext, g);
            return true;
        }
        return false;
    }

    private boolean b(Intent intent, String str, Class<?> cls) {
        intent.putExtra("intent_extra_service", str);
        intent.putExtra("intent_extra_package_name", this.mPackageName);
        if (cls == null) {
            try {
                cls = this.Ci.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> h = f.kF().h(cls);
        if (h != null) {
            intent.setClass(this.mContext, h);
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
        if (this.Cm != null && this.Cm.size() > 0) {
            Iterator<String> it = this.Cm.iterator();
            StringBuilder sb = null;
            while (it.hasNext()) {
                String next = it.next();
                try {
                    Class.forName(next, true, this.Ci);
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
            this.Cm.clear();
            this.Cm = null;
            if (sb != null) {
                String str = this.mPackageName;
                if (PluginPackageManager.lU().hs()) {
                    com.baidu.adp.plugin.b.a.lI().d("plugin_load", "init_static_failed", str, sb.toString());
                }
            }
        }
    }

    private b ky() {
        b bVar = new b();
        bVar.pkgName = this.mPackageName;
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(this.mPackageName);
        if (findPluginSetting == null) {
            bVar.Cq = false;
            bVar.reason = "settingnull";
            bVar.Cr = "createPluginResource";
            return bVar;
        } else if (findPluginSetting.isThird) {
            try {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{this.Ch.getAbsolutePath()});
                Resources resources = this.mContext.getResources();
                this.Cj = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                this.Ce = true;
                bVar.Cq = true;
            } catch (Exception e) {
                BdLog.e(e);
            }
            return bVar;
        } else {
            boolean z = findPluginSetting.hasRes;
            this.Cj = this.mContext.getResources();
            if (BdBaseApplication.getInst().getIsPluginResourcOpen() && z) {
                if (this.Ch != null && !TextUtils.isEmpty(this.Ch.getAbsolutePath())) {
                    try {
                        j.dK().D(this.Ch.getAbsolutePath());
                        this.Ce = true;
                        bVar.Cq = true;
                        return bVar;
                    } catch (Error e2) {
                        bVar.reason = "res_failed";
                        bVar.Cr = e2.getMessage();
                        bVar.Cq = false;
                        if (PluginPackageManager.lU().hs()) {
                            com.baidu.adp.plugin.b.a.lI().e("plugin_load", "res_failed", this.mPackageName, e2.getMessage());
                            com.baidu.adp.plugin.b.a.lI().bl("plugin_res_inject_fail");
                        }
                    } catch (Exception e3) {
                        bVar.reason = "res_failed";
                        bVar.Cr = e3.getMessage();
                        bVar.Cq = false;
                        if (PluginPackageManager.lU().hs()) {
                            com.baidu.adp.plugin.b.a.lI().e("plugin_load", "res_failed", this.mPackageName, e3.getMessage());
                            com.baidu.adp.plugin.b.a.lI().bl("plugin_res_inject_fail");
                        }
                    }
                }
                return bVar;
            }
            this.Ce = true;
            bVar.Cq = true;
            return bVar;
        }
    }

    private boolean kz() {
        return this.Ch.isFile() && this.Ch.getName().endsWith(".apk");
    }

    private void kA() {
        try {
            this.Cl = Util.bO(this.mPackageName);
            this.Cl.mkdirs();
        } catch (Exception e) {
            BdLog.e(e);
            if (PluginPackageManager.lU().hs()) {
                com.baidu.adp.plugin.b.a.lI().e("plugin_load", "createdataroot_failed", this.mPackageName, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
            }
        }
    }

    private b kB() {
        boolean z;
        String str;
        b bVar = new b();
        bVar.pkgName = this.mPackageName;
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(this.mPackageName);
        if (findPluginSetting == null) {
            bVar.Cq = false;
            bVar.reason = "settingnull";
            bVar.Cr = "createClassLoader";
            return bVar;
        }
        try {
            if (this.Cl == null || !this.Cl.exists()) {
                kA();
            }
            ClassLoader classLoader = this.mContext.getClassLoader();
            if (findPluginSetting.isThird) {
                this.Ci = new d(this.Ch.getAbsolutePath(), this.Cl.getAbsolutePath(), kr(), classLoader, classLoader);
            } else {
                this.Ci = new DexClassLoader(this.Ch.getAbsolutePath(), this.Cl.getAbsolutePath(), kr(), classLoader);
            }
            try {
                if (this.Ci != null) {
                    this.Ci.loadClass(String.valueOf(this.mPackageName) + ".Static");
                    z = true;
                } else {
                    z = true;
                }
            } catch (ClassNotFoundException e) {
                bVar.reason = "loadR";
                bVar.Cr = e.getMessage();
                if (PluginPackageManager.lU().hs()) {
                    com.baidu.adp.plugin.b.a.lI().e("plugin_load", "loadR", this.mPackageName, e.getMessage());
                }
                BdLog.e(e);
                z = false;
            } catch (Throwable th) {
                bVar.reason = "loadR2";
                bVar.Cr = String.valueOf(th.getMessage()) + "---" + th.getClass().getName();
                if (PluginPackageManager.lU().hs()) {
                    com.baidu.adp.plugin.b.a.lI().e("plugin_load", "loadR2", this.mPackageName, String.valueOf(th.getMessage()) + "---" + th.getClass().getName());
                }
                BdLog.e(th);
                z = false;
            }
            if (PluginPackageManager.lU().hs() && !z) {
                com.baidu.adp.plugin.b.a.lI().bl("plugin_class_notfind");
            }
            if (!z) {
                bVar.Cq = false;
                return bVar;
            }
            if (findPluginSetting.isInjectClassloader()) {
                ClassLoader classLoader2 = this.mContext.getClassLoader();
                while (!(classLoader2 instanceof PathClassLoader)) {
                    classLoader2 = classLoader2.getParent();
                }
                this.Cg = 1;
                a.C0012a a = com.baidu.adp.plugin.util.a.a(classLoader2, this.Ci, String.valueOf(this.mPackageName) + ".Static");
                if (a != null && !a.EV) {
                    if (PluginPackageManager.lU().hs()) {
                        com.baidu.adp.plugin.b.a.lI().bl("plugin_inject_failed");
                    }
                    bVar.reason = "inject_failed";
                    bVar.Cr = a.mErrMsg;
                    com.baidu.adp.plugin.b.a.lI().e("plugin_load", "inject_failed", this.mPackageName, a.mErrMsg);
                    this.Cg = 2;
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
                    a.C0012a a2 = com.baidu.adp.plugin.util.a.a(this.mContext, new DexClassLoader(str2, this.Cl.getAbsolutePath(), str, classLoader2), String.valueOf(this.mPackageName) + ".Static");
                    if (a2 != null && !a2.EV) {
                        if (PluginPackageManager.lU().hs()) {
                            com.baidu.adp.plugin.b.a.lI().e("plugin_load", "replaceparent_failed", this.mPackageName, a2.mErrMsg);
                        }
                        bVar.Cq = false;
                        bVar.reason = "replaceparent_failed";
                        bVar.Cr = a2.mErrMsg;
                        return bVar;
                    } else if (a2 != null && a2.EV) {
                        com.baidu.adp.plugin.b.a.lI().bl("plugin_second_inject_succ");
                    }
                }
            }
            this.Cd = true;
            bVar.Cq = true;
            return bVar;
        } catch (Exception e2) {
            BdLog.e(e2);
            bVar.Cq = false;
            bVar.reason = "new_dexloader_failed";
            bVar.Cr = String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName();
            if (PluginPackageManager.lU().hs()) {
                com.baidu.adp.plugin.b.a.lI().e("plugin_load", "new_dexloader_failed", this.mPackageName, String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName());
            }
            return bVar;
        }
    }

    private boolean kC() {
        if (this.Ci == null) {
            return false;
        }
        DexFile a = com.baidu.adp.plugin.util.d.a(this.Ci);
        String str = null;
        if (a == null) {
            try {
                a = DexFile.loadDex(this.Ch.getAbsolutePath(), C(this.Ch.getAbsolutePath(), this.Cl.getAbsolutePath()), 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                str = e.getMessage();
            }
        }
        if (a != null) {
            Enumeration<String> entries = a.entries();
            if (entries != null) {
                while (entries.hasMoreElements()) {
                    try {
                        String nextElement = entries.nextElement();
                        if (nextElement.endsWith(u.SUFFIX) && this.Cm != null && !PluginPackageManager.lU().isFeatureForbidden(nextElement)) {
                            this.Cm.add(nextElement);
                        }
                    } catch (Exception e2) {
                        if (PluginPackageManager.lU().hs()) {
                            com.baidu.adp.plugin.b.a.lI().e("plugin_load", "getdexfile_failed_reverse", this.mPackageName, e2.getMessage());
                        }
                        return false;
                    }
                }
                kx();
                return true;
            }
            if (PluginPackageManager.lU().hs()) {
                com.baidu.adp.plugin.b.a.lI().e("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, str);
            }
            return false;
        }
        if (PluginPackageManager.lU().hs()) {
            com.baidu.adp.plugin.b.a.lI().e("plugin_load", "getdexfile_failed", this.mPackageName, str);
        }
        return false;
    }

    private static String C(String str, String str2) {
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
        if (this.Ck == null) {
            PluginBaseApplication pluginBaseApplication = new PluginBaseApplication();
            pluginBaseApplication.a((Application) this.mContext);
            pluginBaseApplication.setPluginPackageName(this.mPackageName);
            pluginBaseApplication.onCreate();
            this.Ck = pluginBaseApplication;
        }
    }

    /* renamed from: com.baidu.adp.plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0009a extends BdAsyncTask<String, Object, b> {
        private com.baidu.adp.plugin.util.e Co;
        private String packageName;

        public C0009a(String str, com.baidu.adp.plugin.util.e eVar) {
            this.packageName = null;
            this.Co = null;
            this.packageName = str;
            this.Co = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public b doInBackground(String... strArr) {
            return a.this.bd(this.packageName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(b bVar) {
            super.onPostExecute(bVar);
            if (this.Co != null) {
                this.Co.a(bVar, this.packageName);
            } else {
                BdLog.e("listener is null");
                if (PluginPackageManager.lU().hs()) {
                    com.baidu.adp.plugin.b.a.lI().h("plugin_load", "listener_null", this.packageName);
                }
            }
            if (bVar.Cq) {
                a.this.kx();
                a.this.kD();
                a.this.b(this.packageName, 0, (String) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b bd(String str) {
        Object invoke;
        PluginSetting findPluginSetting;
        String str2;
        b bVar = new b();
        bVar.pkgName = str;
        this.Ch = com.baidu.adp.plugin.install.d.bi(str);
        if (this.Ch == null) {
            if (PluginPackageManager.lU().hs()) {
                if (com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().findPluginSetting(str) != null) {
                    str2 = "-versioncode-" + findPluginSetting.versionCode + "-enable-" + findPluginSetting.enable + "-forbid-" + findPluginSetting.forbidden + "-installstatus-" + findPluginSetting.installStatus + "-url-" + findPluginSetting.url + "-size-" + findPluginSetting.size + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path();
                } else {
                    str2 = "settingssize-" + com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().mo().getPlugins().size() + "-filesize-" + new File(com.baidu.adp.plugin.packageManager.pluginSettings.b.mn().mq()).length();
                }
                bVar.reason = "apk_file_null";
                bVar.Cr = str2;
                com.baidu.adp.plugin.b.a.lI().e("plugin_load", "apk_file_null", str, str2);
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().bH(str);
            bVar.Cq = false;
            return bVar;
        } else if (!kz()) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mr().bH(str);
            if (PluginPackageManager.lU().hs()) {
                com.baidu.adp.plugin.b.a.lI().h("plugin_load", "apk_file_illegal", str);
            }
            bVar.Cq = false;
            bVar.reason = "apk_file_illegal";
            return bVar;
        } else {
            kA();
            if (!this.Cd) {
                b kB = kB();
                if (!kB.Cq) {
                    return kB;
                }
            }
            b ky = ky();
            if (ky.Cq) {
                try {
                    Class<?> cls = Class.forName(String.valueOf(this.mPackageName) + ".PluginStaticClassesArray", true, this.Ci);
                    invoke = cls.getDeclaredMethod("getStaticClasses", new Class[0]).invoke(cls, new Object[0]);
                } catch (Throwable th) {
                    kC();
                }
                if (invoke instanceof String[]) {
                    boolean z = true;
                    for (String str3 : (String[]) invoke) {
                        try {
                            Class.forName(str3, true, this.Ci);
                        } catch (Throwable th2) {
                            z = false;
                        }
                    }
                    if (!z) {
                        throw new RuntimeException();
                    }
                    ky.Cq = true;
                    return ky;
                }
                throw new RuntimeException();
            }
            return ky;
        }
    }
}
