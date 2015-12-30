package com.baidu.adp.plugin;

import android.app.Application;
import android.app.Service;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.u;
import com.baidu.adp.plugin.message.PluginLoadedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.pluginBase.PluginBaseApplication;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.proxy.BroadcastReceiverProxy;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.adp.plugin.util.Util;
import com.baidu.adp.plugin.util.a;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private ArrayList<String> Co;
    private Map<String, ContentProvider> Cr;
    private boolean Cf = false;
    private boolean Cg = false;
    private long Ch = 0;
    private int Ci = 0;
    private File Cj = null;
    private ClassLoader Ck = null;
    private Resources Cl = null;
    private Application Cm = null;
    private File Cn = null;
    private C0010a Cp = null;
    private String mPackageName = null;
    private e Cq = null;
    private boolean Cs = false;
    private final Context mContext = BdBaseApplication.getInst().getApplicationContext();

    /* loaded from: classes.dex */
    public static class b {
        public boolean Cv;
        public String Cw;
        public String pkgName;
        public String reason;
    }

    public a() {
        this.Co = null;
        this.Cr = null;
        this.Co = new ArrayList<>();
        this.Cr = new HashMap();
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public long kp() {
        return this.Ch;
    }

    public int kq() {
        return this.Ci;
    }

    public String kr() {
        if (this.Cj == null || !this.Cj.exists()) {
            return null;
        }
        return this.Cj.getAbsolutePath();
    }

    public String ks() {
        if (this.Cn == null || !this.Cn.exists()) {
            return null;
        }
        return new File(this.Cn, "lib").getAbsolutePath();
    }

    public boolean isLoaded() {
        return this.Cf && this.Cg;
    }

    public ClassLoader kt() {
        return this.Ck;
    }

    public Resources ku() {
        return this.Cl;
    }

    public PackageInfo kv() {
        if (this.mContext == null || this.Cj == null || this.Cq == null) {
            return null;
        }
        return this.Cq.kv();
    }

    public Application getApplication() {
        return this.Cm;
    }

    public int kw() {
        return 16973829;
    }

    public b bb(String str) {
        int i = 1;
        if (this.Cs) {
            com.baidu.adp.plugin.b.a.lf().d("plugin_load", "load_in_multithread", str, "curthread is main?" + String.valueOf(k.jg()));
        }
        this.Cs = true;
        b bVar = new b();
        bVar.pkgName = str;
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                this.Cs = false;
                throw new IllegalArgumentException("Plugin asyncInitWithBroadcast args exception!");
            }
            b(str, 2, (String) null);
            bVar.Cv = false;
            this.Cs = false;
            return bVar;
        }
        this.mPackageName = str;
        this.Ch = System.currentTimeMillis();
        if (isLoaded()) {
            this.Cs = false;
            bVar.Cv = true;
            return bVar;
        }
        kF();
        b be = be(str);
        if (PluginPackageManager.ls().hs() && be.Cv) {
            com.baidu.adp.plugin.b.a.lf().D("plugin_load", str);
        }
        if (!be.Cv) {
            b(str, 1, (String) null);
            this.Cs = false;
            return be;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(this.mPackageName);
        if (!PluginPackageManager.ls().lA() || findPluginSetting == null || !findPluginSetting.isThird) {
            i = 0;
        } else if (this.Cq.kI()) {
            kD();
            i = 0;
        } else {
            be.Cv = false;
        }
        b(str, i, (String) null);
        this.Cs = false;
        return be;
    }

    public boolean kx() {
        this.mPackageName = BdBaseApplication.getInst().getPackageName();
        this.Ck = this.mContext.getClassLoader();
        this.Cl = this.mContext.getResources();
        this.Cm = BdBaseApplication.getInst();
        this.Cf = true;
        this.Cg = true;
        return true;
    }

    public void a(String str, com.baidu.adp.plugin.util.e eVar) {
        if (this.Cp != null) {
            this.Cp.cancel();
            this.Cp = null;
        }
        this.Cp = new C0010a(str, eVar);
        this.Cp.execute(new String[0]);
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
            com.baidu.adp.plugin.b.a.lf().E("plugin_run_fail", this.mPackageName);
            return false;
        }
        try {
            Class<?> loadClass = this.Ck.loadClass(str);
            if (this.Ci == 0) {
                if (PluginBaseService.class.isAssignableFrom(loadClass) || PluginBaseRemoteService.class.isAssignableFrom(loadClass)) {
                    if (b(intent, str, loadClass)) {
                        context.startService(intent);
                        return true;
                    }
                    com.baidu.adp.plugin.b.a.lf().E("plugin_run_fail", this.mPackageName);
                    BdLog.e("intent remap failed");
                } else if (a(intent, str, loadClass)) {
                    context.startActivity(intent);
                    return true;
                } else {
                    com.baidu.adp.plugin.b.a.lf().E("plugin_run_fail", this.mPackageName);
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
            com.baidu.adp.plugin.b.a.lf().E("plugin_run_fail", this.mPackageName);
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
            com.baidu.adp.plugin.b.a.lf().E("plugin_run_fail", this.mPackageName);
            return false;
        }
        try {
            Class<?> loadClass = this.Ck.loadClass(str);
            if (PluginBaseService.class.isAssignableFrom(loadClass) || PluginBaseRemoteService.class.isAssignableFrom(loadClass)) {
                if (b(intent, str, loadClass)) {
                    context.bindService(intent, serviceConnection, i);
                    return true;
                }
                com.baidu.adp.plugin.b.a.lf().E("plugin_run_fail", this.mPackageName);
                BdLog.e("intent remap failed");
            }
            return false;
        } catch (Exception e) {
            com.baidu.adp.plugin.b.a.lf().E("plugin_run_fail", this.mPackageName);
            return false;
        }
    }

    public ContentProvider bc(String str) {
        if (TextUtils.isEmpty(str) || this.Cr.isEmpty()) {
            return null;
        }
        return this.Cr.get(str);
    }

    public void destroy() {
        if (this.Cf && this.Cg && this.Cm != null) {
            this.Cm.onTerminate();
        }
    }

    public boolean C(Intent intent) {
        String className;
        ServiceInfo bf;
        if (intent == null) {
            return false;
        }
        if (intent.getComponent() == null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || (bf = this.Cq.bf(action)) == null || TextUtils.isEmpty(bf.name)) {
                return false;
            }
            className = bf.name;
        } else {
            className = intent.getComponent().getClassName();
        }
        return b(intent, className, (Class<?>) null);
    }

    public boolean D(Intent intent) {
        String className;
        if (intent == null) {
            return false;
        }
        if (intent.getComponent() == null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return false;
            }
            String str = "";
            for (Map.Entry<String, IntentFilter> entry : this.Cq.kG().entrySet()) {
                if (entry.getValue().hasAction(action)) {
                    str = String.valueOf(str) + ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR + entry.getKey();
                }
            }
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            className = str.substring(1);
        } else {
            className = intent.getComponent().getClassName();
        }
        return c(intent, className, null);
    }

    public boolean E(Intent intent) {
        if (intent == null || intent.getComponent() == null) {
            return false;
        }
        return a(intent, intent.getComponent().getClassName(), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bd(String str) {
        DexFile loadDex;
        DexFile a = com.baidu.adp.plugin.util.d.a(this.Ck);
        if (a == null) {
            try {
                loadDex = DexFile.loadDex(this.Cj.getAbsolutePath(), B(this.Cj.getAbsolutePath(), this.Cn.getAbsolutePath()), 0);
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
                cls = this.Ck.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> f = f.kJ().f(cls);
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
                cls = this.Ck.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> g = h.kM().g(cls);
        if (g != null) {
            intent.setClass(this.mContext, g);
            return true;
        }
        return false;
    }

    private boolean c(Intent intent, String str, Class<?> cls) {
        intent.putExtra("intent_extra_receiver", str);
        intent.putExtra("intent_extra_package_name", this.mPackageName);
        intent.setClass(this.mContext, BroadcastReceiverProxy.class);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i, String str2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000997, new PluginLoadedMessage.a(str, i, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ky() {
        if (this.Co != null && this.Co.size() > 0) {
            Iterator<String> it = this.Co.iterator();
            StringBuilder sb = null;
            while (it.hasNext()) {
                String next = it.next();
                try {
                    Class.forName(next, true, this.Ck);
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
            this.Co.clear();
            this.Co = null;
            if (sb != null) {
                String str = this.mPackageName;
                if (PluginPackageManager.ls().hs()) {
                    com.baidu.adp.plugin.b.a.lf().d("plugin_load", "init_static_failed", str, sb.toString());
                }
            }
        }
    }

    private b kz() {
        b bVar = new b();
        bVar.pkgName = this.mPackageName;
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(this.mPackageName);
        if (findPluginSetting == null) {
            bVar.Cv = false;
            bVar.reason = "settingnull";
            bVar.Cw = "createPluginResource";
            return bVar;
        } else if (findPluginSetting.isThird) {
            try {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{this.Cj.getAbsolutePath()});
                Resources resources = this.mContext.getResources();
                this.Cl = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                this.Cg = true;
                bVar.Cv = true;
            } catch (Exception e) {
                BdLog.e(e);
            }
            return bVar;
        } else {
            boolean z = findPluginSetting.hasRes;
            this.Cl = this.mContext.getResources();
            if (BdBaseApplication.getInst().getIsPluginResourcOpen() && z) {
                if (this.Cj != null && !TextUtils.isEmpty(this.Cj.getAbsolutePath())) {
                    try {
                        j.dK().D(this.Cj.getAbsolutePath());
                        this.Cg = true;
                        bVar.Cv = true;
                        return bVar;
                    } catch (Error e2) {
                        bVar.reason = "res_failed";
                        bVar.Cw = e2.getMessage();
                        bVar.Cv = false;
                        if (PluginPackageManager.ls().hs()) {
                            com.baidu.adp.plugin.b.a.lf().e("plugin_load", "res_failed", this.mPackageName, e2.getMessage());
                            com.baidu.adp.plugin.b.a.lf().bo("plugin_res_inject_fail");
                        }
                    } catch (Exception e3) {
                        bVar.reason = "res_failed";
                        bVar.Cw = e3.getMessage();
                        bVar.Cv = false;
                        if (PluginPackageManager.ls().hs()) {
                            com.baidu.adp.plugin.b.a.lf().e("plugin_load", "res_failed", this.mPackageName, e3.getMessage());
                            com.baidu.adp.plugin.b.a.lf().bo("plugin_res_inject_fail");
                        }
                    }
                }
                return bVar;
            }
            this.Cg = true;
            bVar.Cv = true;
            return bVar;
        }
    }

    private boolean kA() {
        return this.Cj.isFile() && this.Cj.getName().endsWith(".apk");
    }

    private void kB() {
        try {
            this.Cn = Util.bQ(this.mPackageName);
            this.Cn.mkdirs();
        } catch (Exception e) {
            BdLog.e(e);
            if (PluginPackageManager.ls().hs()) {
                com.baidu.adp.plugin.b.a.lf().e("plugin_load", "createdataroot_failed", this.mPackageName, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
            }
        }
    }

    private b kC() {
        boolean z;
        String str;
        b bVar = new b();
        bVar.pkgName = this.mPackageName;
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(this.mPackageName);
        if (findPluginSetting == null) {
            bVar.Cv = false;
            bVar.reason = "settingnull";
            bVar.Cw = "createClassLoader";
            return bVar;
        }
        try {
            if (this.Cn == null || !this.Cn.exists()) {
                kB();
            }
            ClassLoader classLoader = this.mContext.getClassLoader();
            if (findPluginSetting.isThird) {
                this.Ck = new d(this.Cj.getAbsolutePath(), this.Cn.getAbsolutePath(), ks(), classLoader.getParent(), classLoader);
            } else {
                this.Ck = new DexClassLoader(this.Cj.getAbsolutePath(), this.Cn.getAbsolutePath(), ks(), classLoader);
            }
            try {
                if (this.Ck != null) {
                    this.Ck.loadClass(String.valueOf(this.mPackageName) + ".Static");
                    z = true;
                } else {
                    z = true;
                }
            } catch (ClassNotFoundException e) {
                bVar.reason = "loadR";
                bVar.Cw = e.getMessage();
                if (PluginPackageManager.ls().hs()) {
                    com.baidu.adp.plugin.b.a.lf().e("plugin_load", "loadR", this.mPackageName, e.getMessage());
                }
                BdLog.e(e);
                z = false;
            } catch (Throwable th) {
                bVar.reason = "loadR2";
                bVar.Cw = String.valueOf(th.getMessage()) + "---" + th.getClass().getName();
                if (PluginPackageManager.ls().hs()) {
                    com.baidu.adp.plugin.b.a.lf().e("plugin_load", "loadR2", this.mPackageName, String.valueOf(th.getMessage()) + "---" + th.getClass().getName());
                }
                BdLog.e(th);
                z = false;
            }
            if (PluginPackageManager.ls().hs() && !z) {
                com.baidu.adp.plugin.b.a.lf().bo("plugin_class_notfind");
            }
            if (!z) {
                bVar.Cv = false;
                return bVar;
            }
            if (findPluginSetting.isInjectClassloader()) {
                ClassLoader classLoader2 = this.mContext.getClassLoader();
                while (!(classLoader2 instanceof PathClassLoader)) {
                    classLoader2 = classLoader2.getParent();
                }
                this.Ci = 1;
                a.C0013a a = com.baidu.adp.plugin.util.a.a(classLoader2, this.Ck, String.valueOf(this.mPackageName) + ".Static");
                if (a != null && !a.Fh) {
                    if (PluginPackageManager.ls().hs()) {
                        com.baidu.adp.plugin.b.a.lf().bo("plugin_inject_failed");
                    }
                    bVar.reason = "inject_failed";
                    bVar.Cw = a.mErrMsg;
                    com.baidu.adp.plugin.b.a.lf().e("plugin_load", "inject_failed", this.mPackageName, a.mErrMsg);
                    this.Ci = 2;
                    String str2 = "";
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    ArrayList<a> allPlugins = PluginCenter.getInstance().getAllPlugins();
                    if (allPlugins != null && allPlugins.size() > 0) {
                        Iterator<a> it = allPlugins.iterator();
                        while (it.hasNext()) {
                            a next = it.next();
                            if (next != null) {
                                sb.append(next.kr());
                                sb.append(File.pathSeparator);
                                sb2.append(next.ks());
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
                    a.C0013a a2 = com.baidu.adp.plugin.util.a.a(this.mContext, new DexClassLoader(str2, this.Cn.getAbsolutePath(), str, classLoader2), String.valueOf(this.mPackageName) + ".Static");
                    if (a2 != null && !a2.Fh) {
                        if (PluginPackageManager.ls().hs()) {
                            com.baidu.adp.plugin.b.a.lf().e("plugin_load", "replaceparent_failed", this.mPackageName, a2.mErrMsg);
                        }
                        bVar.Cv = false;
                        bVar.reason = "replaceparent_failed";
                        bVar.Cw = a2.mErrMsg;
                        return bVar;
                    } else if (a2 != null && a2.Fh) {
                        com.baidu.adp.plugin.b.a.lf().bo("plugin_second_inject_succ");
                    }
                }
            }
            this.Cf = true;
            bVar.Cv = true;
            return bVar;
        } catch (Exception e2) {
            BdLog.e(e2);
            bVar.Cv = false;
            bVar.reason = "new_dexloader_failed";
            bVar.Cw = String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName();
            if (PluginPackageManager.ls().hs()) {
                com.baidu.adp.plugin.b.a.lf().e("plugin_load", "new_dexloader_failed", this.mPackageName, String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName());
            }
            return bVar;
        }
    }

    private void kD() {
        Object split;
        if (this.Cq != null && this.Cq.kH() != null) {
            try {
                Iterator<Map.Entry<String, ProviderInfo>> it = this.Cq.kH().entrySet().iterator();
                if (it != null) {
                    String str = ContentProviderProxy.PROVIDER_AUTHOR;
                    while (it.hasNext()) {
                        ProviderInfo value = it.next().getValue();
                        if (!TextUtils.isEmpty(value.authority) && !this.Cr.containsKey(value.authority)) {
                            if (Build.VERSION.SDK_INT >= 21) {
                                str = String.valueOf(str) + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + value.authority;
                            }
                            ContentProvider contentProvider = (ContentProvider) this.Ck.loadClass(value.name).newInstance();
                            contentProvider.attachInfo(this.Cm, value);
                            this.Cr.put(value.authority, contentProvider);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 21 && ContentProviderProxy.getInstance() != null) {
                        Object a = com.baidu.adp.plugin.util.f.a(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthorities");
                        if (a != null) {
                            split = com.baidu.adp.plugin.util.f.c(a, str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
                        } else {
                            split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                        }
                        com.baidu.adp.plugin.util.f.a(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthorities", split);
                        com.baidu.adp.plugin.util.f.a(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthority", (Object) null);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
                com.baidu.adp.plugin.b.a.lf().e("plugin_install", "create_provider_failed", this.mPackageName, e.getMessage());
            }
        }
    }

    private boolean kE() {
        if (this.Ck == null) {
            return false;
        }
        DexFile a = com.baidu.adp.plugin.util.d.a(this.Ck);
        String str = null;
        if (a == null) {
            try {
                a = DexFile.loadDex(this.Cj.getAbsolutePath(), B(this.Cj.getAbsolutePath(), this.Cn.getAbsolutePath()), 0);
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
                        if (nextElement.endsWith(u.SUFFIX) && this.Co != null && !PluginPackageManager.ls().isFeatureForbidden(nextElement)) {
                            this.Co.add(nextElement);
                        }
                    } catch (Exception e2) {
                        if (PluginPackageManager.ls().hs()) {
                            com.baidu.adp.plugin.b.a.lf().e("plugin_load", "getdexfile_failed_reverse", this.mPackageName, e2.getMessage());
                        }
                        return false;
                    }
                }
                ky();
                return true;
            }
            if (PluginPackageManager.ls().hs()) {
                com.baidu.adp.plugin.b.a.lf().e("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, str);
            }
            return false;
        }
        if (PluginPackageManager.ls().hs()) {
            com.baidu.adp.plugin.b.a.lf().e("plugin_load", "getdexfile_failed", this.mPackageName, str);
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
    public void kF() {
        if (this.Cm == null) {
            PluginBaseApplication pluginBaseApplication = new PluginBaseApplication();
            pluginBaseApplication.setApplicationProxy((Application) this.mContext);
            pluginBaseApplication.setPluginPackageName(this.mPackageName);
            pluginBaseApplication.onCreate();
            this.Cm = pluginBaseApplication;
        }
    }

    /* renamed from: com.baidu.adp.plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0010a extends BdAsyncTask<String, Object, b> {
        private com.baidu.adp.plugin.util.e Ct;
        private String packageName;

        public C0010a(String str, com.baidu.adp.plugin.util.e eVar) {
            this.packageName = null;
            this.Ct = null;
            this.packageName = str;
            this.Ct = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public b doInBackground(String... strArr) {
            return a.this.be(this.packageName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(b bVar) {
            super.onPostExecute(bVar);
            if (this.Ct != null) {
                this.Ct.a(bVar, this.packageName);
            } else {
                BdLog.e("listener is null");
                if (PluginPackageManager.ls().hs()) {
                    com.baidu.adp.plugin.b.a.lf().h("plugin_load", "listener_null", this.packageName);
                }
            }
            if (bVar.Cv) {
                a.this.ky();
                a.this.kF();
                a.this.b(this.packageName, 0, (String) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b be(String str) {
        Object invoke;
        PluginSetting findPluginSetting;
        String str2;
        b bVar = new b();
        bVar.pkgName = str;
        this.Cj = com.baidu.adp.plugin.install.d.bl(str);
        if (this.Cj == null) {
            if (PluginPackageManager.ls().hs()) {
                if (com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().findPluginSetting(str) != null) {
                    str2 = "-versioncode-" + findPluginSetting.versionCode + "-enable-" + findPluginSetting.enable + "-forbid-" + findPluginSetting.forbidden + "-installstatus-" + findPluginSetting.installStatus + "-url-" + findPluginSetting.url + "-size-" + findPluginSetting.size + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path();
                } else {
                    str2 = "settingssize-" + com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().lM().getPlugins().size() + "-filesize-" + new File(com.baidu.adp.plugin.packageManager.pluginSettings.b.lL().lO()).length();
                }
                bVar.reason = "apk_file_null";
                bVar.Cw = str2;
                com.baidu.adp.plugin.b.a.lf().e("plugin_load", "apk_file_null", str, str2);
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().bK(str);
            bVar.Cv = false;
            return bVar;
        } else if (!kA()) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.lP().bK(str);
            if (PluginPackageManager.ls().hs()) {
                com.baidu.adp.plugin.b.a.lf().e("plugin_load", "apk_file_illegal", str, this.Cj.getAbsolutePath());
            }
            bVar.Cv = false;
            bVar.reason = "apk_file_illegal";
            return bVar;
        } else {
            kB();
            if (!this.Cf) {
                b kC = kC();
                if (!kC.Cv) {
                    return kC;
                }
            }
            b kz = kz();
            if (kz.Cv) {
                this.Cq = new e(this.mContext, this.Cj, this.Cl);
                try {
                    Class<?> cls = Class.forName(String.valueOf(this.mPackageName) + ".PluginStaticClassesArray", true, this.Ck);
                    invoke = cls.getDeclaredMethod("getStaticClasses", new Class[0]).invoke(cls, new Object[0]);
                } catch (Throwable th) {
                    kE();
                }
                if (invoke instanceof String[]) {
                    boolean z = true;
                    for (String str3 : (String[]) invoke) {
                        try {
                            Class.forName(str3, true, this.Ck);
                        } catch (Throwable th2) {
                            z = false;
                        }
                    }
                    if (!z) {
                        throw new RuntimeException();
                    }
                    kz.Cv = true;
                    return kz;
                }
                throw new RuntimeException();
            }
            return kz;
        }
    }
}
