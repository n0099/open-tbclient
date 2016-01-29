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
    private Map<String, ContentProvider> CB;
    private ArrayList<String> Cw;
    private int Cz;
    private boolean Cn = false;
    private boolean Co = false;
    private long Cp = 0;
    private int Cq = 0;
    private File Cr = null;
    private ClassLoader Cs = null;
    private Resources Ct = null;
    private Application Cu = null;
    private File Cv = null;
    private Object Cx = new Object();
    private C0010a Cy = null;
    private String mPackageName = null;
    private e CA = null;
    private boolean CC = false;
    private final Context mContext = BdBaseApplication.getInst().getApplicationContext();

    /* loaded from: classes.dex */
    public static class b {
        public boolean CF;
        public String CG;
        public String pkgName;
        public String reason;
    }

    public a() {
        this.Cw = null;
        this.CB = null;
        this.Cw = new ArrayList<>();
        this.CB = new HashMap();
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getVersionCode() {
        return this.Cz;
    }

    public long kz() {
        return this.Cp;
    }

    public int kA() {
        return this.Cq;
    }

    public String kB() {
        if (this.Cr == null || !this.Cr.exists()) {
            return null;
        }
        return this.Cr.getAbsolutePath();
    }

    public String kC() {
        if (this.Cv == null || !this.Cv.exists()) {
            return null;
        }
        return new File(this.Cv, "lib").getAbsolutePath();
    }

    public boolean isLoaded() {
        return this.Cn && this.Co;
    }

    public ClassLoader kD() {
        return this.Cs;
    }

    public Resources kE() {
        return this.Ct;
    }

    public PackageInfo kF() {
        if (this.mContext == null || this.Cr == null || this.CA == null) {
            return null;
        }
        return this.CA.kF();
    }

    public Application getApplication() {
        return this.Cu;
    }

    public int kG() {
        return 16973829;
    }

    public b ba(String str) {
        int i = 1;
        if (this.CC) {
            com.baidu.adp.plugin.b.a.lq().e("plugin_load", "load_in_multithread", str, "curthread is main?" + String.valueOf(k.jp()));
        }
        this.CC = true;
        b bVar = new b();
        bVar.pkgName = str;
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                this.CC = false;
                throw new IllegalArgumentException("Plugin asyncInitWithBroadcast args exception!");
            }
            b(str, 2, (String) null);
            bVar.CF = false;
            this.CC = false;
            return bVar;
        }
        this.mPackageName = str;
        this.Cp = System.currentTimeMillis();
        if (isLoaded()) {
            this.CC = false;
            bVar.CF = true;
            return bVar;
        }
        kP();
        b bd = bd(str);
        if (PluginPackageManager.lD().hA() && bd.CF) {
            com.baidu.adp.plugin.b.a.lq().E("plugin_load", str);
        }
        if (!bd.CF) {
            b(str, 1, (String) null);
            this.CC = false;
            return bd;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(this.mPackageName);
        if (!PluginPackageManager.lD().lN() || findPluginSetting == null || !findPluginSetting.isThird) {
            i = 0;
        } else if (this.CA.kS()) {
            kN();
            i = 0;
        } else {
            bd.CF = false;
        }
        if (bd.CF && findPluginSetting != null) {
            this.Cz = findPluginSetting.versionCode;
        }
        b(str, i, (String) null);
        this.CC = false;
        return bd;
    }

    public boolean kH() {
        this.mPackageName = BdBaseApplication.getInst().getPackageName();
        this.Cs = this.mContext.getClassLoader();
        this.Ct = this.mContext.getResources();
        this.Cu = BdBaseApplication.getInst();
        this.Cn = true;
        this.Co = true;
        return true;
    }

    public void a(String str, com.baidu.adp.plugin.util.e eVar) {
        if (this.Cy != null) {
            this.Cy.cancel();
            this.Cy = null;
        }
        this.Cy = new C0010a(str, eVar);
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
            com.baidu.adp.plugin.b.a.lq().F("plugin_run_fail", this.mPackageName);
            return false;
        }
        try {
            Class<?> loadClass = this.Cs.loadClass(str);
            if (this.Cq == 0) {
                if (PluginBaseService.class.isAssignableFrom(loadClass) || PluginBaseRemoteService.class.isAssignableFrom(loadClass)) {
                    if (b(intent, str, loadClass)) {
                        context.startService(intent);
                        return true;
                    }
                    com.baidu.adp.plugin.b.a.lq().F("plugin_run_fail", this.mPackageName);
                    BdLog.e("intent remap failed");
                } else if (a(intent, str, loadClass)) {
                    context.startActivity(intent);
                    return true;
                } else {
                    com.baidu.adp.plugin.b.a.lq().F("plugin_run_fail", this.mPackageName);
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
            com.baidu.adp.plugin.b.a.lq().F("plugin_run_fail", this.mPackageName);
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
            com.baidu.adp.plugin.b.a.lq().F("plugin_run_fail", this.mPackageName);
            return false;
        }
        try {
            Class<?> loadClass = this.Cs.loadClass(str);
            if (PluginBaseService.class.isAssignableFrom(loadClass) || PluginBaseRemoteService.class.isAssignableFrom(loadClass)) {
                if (b(intent, str, loadClass)) {
                    context.bindService(intent, serviceConnection, i);
                    return true;
                }
                com.baidu.adp.plugin.b.a.lq().F("plugin_run_fail", this.mPackageName);
                BdLog.e("intent remap failed");
            }
            return false;
        } catch (Exception e) {
            com.baidu.adp.plugin.b.a.lq().F("plugin_run_fail", this.mPackageName);
            return false;
        }
    }

    public ContentProvider bb(String str) {
        if (TextUtils.isEmpty(str) || this.CB.isEmpty()) {
            return null;
        }
        return this.CB.get(str);
    }

    public void destroy() {
        if (this.Cn && this.Co && this.Cu != null) {
            this.Cu.onTerminate();
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
            if (TextUtils.isEmpty(action) || (bf = this.CA.bf(action)) == null || TextUtils.isEmpty(bf.name)) {
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
            for (Map.Entry<String, IntentFilter> entry : this.CA.kQ().entrySet()) {
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
    public boolean bc(String str) {
        DexFile loadDex;
        DexFile a = com.baidu.adp.plugin.util.d.a(this.Cs);
        if (a == null) {
            try {
                loadDex = DexFile.loadDex(this.Cr.getAbsolutePath(), C(this.Cr.getAbsolutePath(), this.Cv.getAbsolutePath()), 0);
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
        Class<?> f = f.kT().f(cls);
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
                cls = this.Cs.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> g = h.kW().g(cls);
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
    public boolean kI() {
        synchronized (this.Cx) {
            if (this.Cw != null && this.Cw.size() > 0) {
                Iterator<String> it = this.Cw.iterator();
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
                    }
                }
                this.Cw.clear();
                this.Cw = null;
                if (sb != null) {
                    String str = this.mPackageName;
                    if (PluginPackageManager.lD().hA()) {
                        com.baidu.adp.plugin.b.a.lq().e("plugin_load", "init_static_failed", str, sb.toString());
                    }
                    return false;
                }
            }
            return true;
        }
    }

    private b kJ() {
        b bVar = new b();
        bVar.pkgName = this.mPackageName;
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(this.mPackageName);
        if (findPluginSetting == null) {
            bVar.CF = false;
            bVar.reason = "settingnull";
            bVar.CG = "createPluginResource";
            return bVar;
        } else if (findPluginSetting.isPatch) {
            this.Co = true;
            bVar.CF = true;
            return bVar;
        } else if (findPluginSetting.isThird) {
            try {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                com.baidu.adp.plugin.util.f.a(assetManager, "addAssetPath", new Object[]{this.Cr.getAbsolutePath()});
                Resources resources = this.mContext.getResources();
                this.Ct = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                this.Co = true;
                bVar.CF = true;
            } catch (Exception e) {
                BdLog.e(e);
            }
            return bVar;
        } else {
            boolean z = findPluginSetting.hasRes;
            this.Ct = this.mContext.getResources();
            if (BdBaseApplication.getInst().getIsPluginResourcOpen() && z) {
                if (this.Cr != null && !TextUtils.isEmpty(this.Cr.getAbsolutePath())) {
                    try {
                        j.dN().j(this.mPackageName, this.Cr.getAbsolutePath());
                        this.Co = true;
                        bVar.CF = true;
                        if ("com.baidu.tieba.pluginPhotoLive".equals(this.mPackageName)) {
                            j.dN().getResources().getIdentifier("photo_live_activity", "layout", BdBaseApplication.getInst().getPackageName());
                        }
                        return bVar;
                    } catch (Error e2) {
                        bVar.reason = "res_failed";
                        bVar.CG = e2.getMessage();
                        bVar.CF = false;
                        if (PluginPackageManager.lD().hA()) {
                            com.baidu.adp.plugin.b.a.lq().f("plugin_load", "res_failed", this.mPackageName, e2.getMessage());
                            com.baidu.adp.plugin.b.a.lq().bo("plugin_res_inject_fail");
                        }
                    } catch (Exception e3) {
                        bVar.reason = "res_failed";
                        bVar.CG = e3.getMessage();
                        bVar.CF = false;
                        if (PluginPackageManager.lD().hA()) {
                            com.baidu.adp.plugin.b.a.lq().f("plugin_load", "res_failed", this.mPackageName, e3.getMessage());
                            com.baidu.adp.plugin.b.a.lq().bo("plugin_res_inject_fail");
                        }
                    }
                }
                return bVar;
            }
            this.Co = true;
            bVar.CF = true;
            return bVar;
        }
    }

    private boolean kK() {
        return this.Cr.isFile() && this.Cr.getName().endsWith(".apk");
    }

    private void kL() {
        try {
            this.Cv = Util.bQ(this.mPackageName);
            this.Cv.mkdirs();
        } catch (Exception e) {
            BdLog.e(e);
            if (PluginPackageManager.lD().hA()) {
                com.baidu.adp.plugin.b.a.lq().f("plugin_load", "createdataroot_failed", this.mPackageName, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
            }
        }
    }

    private b kM() {
        boolean z;
        String str;
        b bVar = new b();
        bVar.pkgName = this.mPackageName;
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(this.mPackageName);
        if (findPluginSetting == null) {
            bVar.CF = false;
            bVar.reason = "settingnull";
            bVar.CG = "createClassLoader";
            return bVar;
        }
        try {
            if (this.Cv == null || !this.Cv.exists()) {
                kL();
            }
            ClassLoader classLoader = this.mContext.getClassLoader();
            if (findPluginSetting.isThird) {
                this.Cs = new d(this.Cr.getAbsolutePath(), this.Cv.getAbsolutePath(), kC(), classLoader.getParent(), classLoader);
            } else {
                this.Cs = new DexClassLoader(this.Cr.getAbsolutePath(), this.Cv.getAbsolutePath(), kC(), classLoader);
            }
            try {
                if (this.Cs != null) {
                    this.Cs.loadClass(String.valueOf(this.mPackageName) + ".Static");
                    z = true;
                } else {
                    z = true;
                }
            } catch (ClassNotFoundException e) {
                bVar.reason = "loadR";
                bVar.CG = e.getMessage();
                if (PluginPackageManager.lD().hA()) {
                    com.baidu.adp.plugin.b.a.lq().f("plugin_load", "loadR", this.mPackageName, e.getMessage());
                }
                BdLog.e(e);
                z = false;
            } catch (Throwable th) {
                bVar.reason = "loadR2";
                bVar.CG = String.valueOf(th.getMessage()) + "---" + th.getClass().getName();
                if (PluginPackageManager.lD().hA()) {
                    com.baidu.adp.plugin.b.a.lq().f("plugin_load", "loadR2", this.mPackageName, String.valueOf(th.getMessage()) + "---" + th.getClass().getName());
                }
                BdLog.e(th);
                z = false;
            }
            if (PluginPackageManager.lD().hA() && !z) {
                com.baidu.adp.plugin.b.a.lq().bo("plugin_class_notfind");
            }
            if (!z) {
                bVar.CF = false;
                return bVar;
            }
            if (findPluginSetting.isPatch) {
                ClassLoader classLoader2 = this.mContext.getClassLoader();
                while (!(classLoader2 instanceof PathClassLoader)) {
                    classLoader2 = classLoader2.getParent();
                }
                this.Cq = 1;
                a.C0013a a = com.baidu.adp.plugin.util.a.a(classLoader2, this.Cs, String.valueOf(this.mPackageName) + ".Static", false);
                if (a == null || !a.Fu) {
                    com.baidu.adp.plugin.b.a.lq().f("plugin_load", "createClassLoader_failed", this.mPackageName, "patch apk inject failed!" + a.mErrMsg);
                    bVar.CF = false;
                    bVar.reason = "patchClassLoaderInject_failed";
                    bVar.CG = "inject failed, patch failed!";
                    return bVar;
                }
            }
            if (findPluginSetting.isInjectClassloader()) {
                ClassLoader classLoader3 = this.mContext.getClassLoader();
                while (!(classLoader3 instanceof PathClassLoader)) {
                    classLoader3 = classLoader3.getParent();
                }
                this.Cq = 1;
                a.C0013a a2 = com.baidu.adp.plugin.util.a.a(classLoader3, this.Cs, String.valueOf(this.mPackageName) + ".Static", true);
                if (a2 != null && !a2.Fu) {
                    if (PluginPackageManager.lD().hA()) {
                        com.baidu.adp.plugin.b.a.lq().bo("plugin_inject_failed");
                    }
                    bVar.reason = "inject_failed";
                    bVar.CG = a2.mErrMsg;
                    com.baidu.adp.plugin.b.a.lq().f("plugin_load", "inject_failed", this.mPackageName, a2.mErrMsg);
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
                                sb.append(next.kB());
                                sb.append(File.pathSeparator);
                                sb2.append(next.kC());
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
                    a.C0013a a3 = com.baidu.adp.plugin.util.a.a(this.mContext, new DexClassLoader(str2, this.Cv.getAbsolutePath(), str, classLoader3), String.valueOf(this.mPackageName) + ".Static");
                    if (a3 != null && !a3.Fu) {
                        if (PluginPackageManager.lD().hA()) {
                            com.baidu.adp.plugin.b.a.lq().f("plugin_load", "replaceparent_failed", this.mPackageName, a3.mErrMsg);
                        }
                        bVar.CF = false;
                        bVar.reason = "replaceparent_failed";
                        bVar.CG = a3.mErrMsg;
                        return bVar;
                    } else if (a3 != null && a3.Fu) {
                        com.baidu.adp.plugin.b.a.lq().bo("plugin_second_inject_succ");
                    }
                }
            }
            this.Cn = true;
            bVar.CF = true;
            return bVar;
        } catch (Exception e2) {
            BdLog.e(e2);
            bVar.CF = false;
            bVar.reason = "new_dexloader_failed";
            bVar.CG = String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName();
            if (PluginPackageManager.lD().hA()) {
                com.baidu.adp.plugin.b.a.lq().f("plugin_load", "new_dexloader_failed", this.mPackageName, String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName());
            }
            return bVar;
        }
    }

    private void kN() {
        Object split;
        if (this.CA != null && this.CA.kR() != null) {
            try {
                Iterator<Map.Entry<String, ProviderInfo>> it = this.CA.kR().entrySet().iterator();
                if (it != null) {
                    String str = ContentProviderProxy.PROVIDER_AUTHOR;
                    while (it.hasNext()) {
                        ProviderInfo value = it.next().getValue();
                        if (!TextUtils.isEmpty(value.authority) && !this.CB.containsKey(value.authority)) {
                            if (Build.VERSION.SDK_INT >= 21) {
                                str = String.valueOf(str) + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + value.authority;
                            }
                            ContentProvider contentProvider = (ContentProvider) this.Cs.loadClass(value.name).newInstance();
                            contentProvider.attachInfo(this.Cu, value);
                            this.CB.put(value.authority, contentProvider);
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
                com.baidu.adp.plugin.b.a.lq().f("plugin_install", "create_provider_failed", this.mPackageName, e.getMessage());
            }
        }
    }

    private boolean kO() {
        if (this.Cs == null) {
            return false;
        }
        DexFile a = com.baidu.adp.plugin.util.d.a(this.Cs);
        String str = null;
        if (a == null) {
            try {
                a = DexFile.loadDex(this.Cr.getAbsolutePath(), C(this.Cr.getAbsolutePath(), this.Cv.getAbsolutePath()), 0);
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
                        be(entries.nextElement());
                    } catch (Exception e2) {
                        if (PluginPackageManager.lD().hA()) {
                            com.baidu.adp.plugin.b.a.lq().f("plugin_load", "getdexfile_failed_reverse", this.mPackageName, e2.getMessage());
                        }
                        return false;
                    }
                }
                kI();
                return true;
            }
            if (PluginPackageManager.lD().hA()) {
                com.baidu.adp.plugin.b.a.lq().f("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, str);
            }
            return false;
        }
        if (PluginPackageManager.lD().hA()) {
            com.baidu.adp.plugin.b.a.lq().f("plugin_load", "getdexfile_failed", this.mPackageName, str);
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
    public void kP() {
        if (this.Cu == null) {
            PluginBaseApplication pluginBaseApplication = new PluginBaseApplication();
            pluginBaseApplication.setApplicationProxy((Application) this.mContext);
            pluginBaseApplication.setPluginPackageName(this.mPackageName);
            pluginBaseApplication.onCreate();
            this.Cu = pluginBaseApplication;
        }
    }

    /* renamed from: com.baidu.adp.plugin.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0010a extends BdAsyncTask<String, Object, b> {
        private com.baidu.adp.plugin.util.e CD;
        private String packageName;

        public C0010a(String str, com.baidu.adp.plugin.util.e eVar) {
            this.packageName = null;
            this.CD = null;
            this.packageName = str;
            this.CD = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public b doInBackground(String... strArr) {
            return a.this.bd(this.packageName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(b bVar) {
            super.onPostExecute(bVar);
            if (this.CD != null) {
                this.CD.a(bVar, this.packageName);
            } else {
                BdLog.e("listener is null");
                if (PluginPackageManager.lD().hA()) {
                    com.baidu.adp.plugin.b.a.lq().h("plugin_load", "listener_null", this.packageName);
                }
            }
            if (bVar.CF) {
                a.this.kI();
                a.this.kP();
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
        this.Cr = com.baidu.adp.plugin.install.d.bl(str);
        if (this.Cr == null) {
            if (PluginPackageManager.lD().hA()) {
                if (com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().findPluginSetting(str) != null) {
                    str2 = "-versioncode-" + findPluginSetting.versionCode + "-enable-" + findPluginSetting.enable + "-forbid-" + findPluginSetting.forbidden + "-installstatus-" + findPluginSetting.installStatus + "-url-" + findPluginSetting.url + "-size-" + findPluginSetting.size + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path();
                } else {
                    str2 = "settingssize-" + com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().lZ().getPlugins().size() + "-filesize-" + new File(com.baidu.adp.plugin.packageManager.pluginSettings.b.lY().mb()).length();
                }
                bVar.reason = "apk_file_null";
                bVar.CG = str2;
                com.baidu.adp.plugin.b.a.lq().f("plugin_load", "apk_file_null", str, str2);
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().bK(str);
            bVar.CF = false;
            return bVar;
        } else if (!kK()) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mc().bK(str);
            if (PluginPackageManager.lD().hA()) {
                com.baidu.adp.plugin.b.a.lq().f("plugin_load", "apk_file_illegal", str, this.Cr.getAbsolutePath());
            }
            bVar.CF = false;
            bVar.reason = "apk_file_illegal";
            return bVar;
        } else {
            kL();
            if (!this.Cn) {
                b kM = kM();
                if (!kM.CF) {
                    return kM;
                }
            }
            b kJ = kJ();
            if (kJ.CF) {
                this.CA = new e(this.mContext, this.Cr, this.Ct);
                try {
                    Class<?> cls = Class.forName(String.valueOf(this.mPackageName) + ".PluginStaticClassesArray", true, this.Cs);
                    invoke = cls.getDeclaredMethod("getStaticClasses", new Class[0]).invoke(cls, new Object[0]);
                } catch (Throwable th) {
                    synchronized (this.Cx) {
                        this.Cw = new ArrayList<>();
                        kO();
                    }
                }
                if (invoke instanceof String[]) {
                    for (String str3 : (String[]) invoke) {
                        be(str3);
                    }
                    if (!kI()) {
                        throw new RuntimeException();
                    }
                    kJ.CF = true;
                    return kJ;
                }
                throw new RuntimeException();
            }
            return kJ;
        }
    }

    private void be(String str) {
        if (!TextUtils.isEmpty(str) && str.endsWith(u.SUFFIX) && this.Cw != null && !PluginPackageManager.lD().isFeatureForbidden(str)) {
            synchronized (this.Cx) {
                this.Cw.add(str);
            }
        }
    }
}
