package com.baidu.adp.plugin;

import android.app.Activity;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.message.PluginLoadedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.pluginBase.PluginBaseApplication;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.proxy.BroadcastReceiverProxy;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.adp.plugin.util.Util;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.v8engine.V8Engine;
import d.b.b.a.h;
import d.b.b.e.p.l;
import d.b.b.e.p.r;
import d.b.b.h.e;
import d.b.b.h.j.g.d;
import d.b.b.h.k.a;
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
public class Plugin {
    public static final String ACTION_PLUGIN_LOADED = "com.baidu.adp.plugin.action.plugin_loaded";
    public static final String ACTION_PLUGIN_LOADED_ERRMSG = "com.baidu.adp.plugin.action.plugin_loaded_errmsg";
    public static final String ACTION_PLUGIN_LOADED_ERRNO = "com.baidu.adp.plugin.action.plugin_loaded_errno";
    public static final String INTENT_EXTRA_ACTIVITY = "intent_extra_activity";
    public static final String INTENT_EXTRA_PACKAGE_NAME = "intent_extra_package_name";
    public static final String INTENT_EXTRA_RECEIVER = "intent_extra_receiver";
    public static final String INTENT_EXTRA_RECEIVER_SPLIT_CHAR = "#";
    public static final String INTENT_EXTRA_REDIRECT_ACTIVITY = "intent_extra_redirect_activity";
    public static final String INTENT_EXTRA_SERVICE = "intent_extra_service";
    public static final String SO_LIB_DIR_NAME = "lib";
    public static String mProcessName;
    public Map<String, ContentProvider> mProviders;
    public ArrayList<String> mStaticClassFiles;
    public int mVersionCode;
    public boolean mIsClassLoaderSucc = false;
    public boolean mIsPluginResourceSucc = false;
    public long mLastLaunchTime = 0;
    public int mCurrentPluginMode = 0;
    public File mPluginApkFile = null;
    public ClassLoader mDexClassLoader = null;
    public Resources mPluginResource = null;
    public Application mApplication = null;
    public File mPluginDataRoot = null;
    public Object mStaticClassFielsLock = new Object();
    public b mInitPluginTask = null;
    public String mPackageName = null;
    public d.b.b.h.b mManifest = null;
    public boolean isIniting = false;
    public final Context mContext = BdBaseApplication.getInst().getApplicationContext();

    /* loaded from: classes.dex */
    public class a implements d.b.b.h.k.c {
        public a(Plugin plugin2) {
        }

        @Override // d.b.b.h.k.c
        public void a(c cVar, String str) {
            if (PluginPackageManager.O().c0()) {
                if (cVar.f2186a) {
                    d.b.b.h.h.a.b().t("plugin_load", str);
                } else {
                    d.b.b.h.h.a.b().g("plugin_loaded_failed");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Object, c> {

        /* renamed from: a  reason: collision with root package name */
        public String f2183a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.b.h.k.c f2184b;

        public b(String str, d.b.b.h.k.c cVar) {
            this.f2183a = null;
            this.f2184b = null;
            this.f2183a = str;
            this.f2184b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public c doInBackground(String... strArr) {
            return Plugin.this.createPlugin(this.f2183a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(c cVar) {
            super.onPostExecute(cVar);
            d.b.b.h.k.c cVar2 = this.f2184b;
            if (cVar2 != null) {
                cVar2.a(cVar, this.f2183a);
            } else {
                BdLog.e("listener is null");
                if (PluginPackageManager.O().c0()) {
                    d.b.b.h.h.a.b().q("plugin_load", "listener_null", this.f2183a);
                }
            }
            if (cVar.f2186a) {
                Plugin.this.initStaticBlock();
                Plugin.this.initApplication();
                Plugin.this.sendMessageForPluginLoaded(this.f2183a, 0, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2186a;

        /* renamed from: b  reason: collision with root package name */
        public String f2187b;

        /* renamed from: c  reason: collision with root package name */
        public String f2188c;

        /* renamed from: d  reason: collision with root package name */
        public long f2189d;
    }

    public Plugin() {
        this.mStaticClassFiles = null;
        this.mProviders = null;
        this.mStaticClassFiles = new ArrayList<>();
        this.mProviders = new HashMap();
    }

    private void addStaticClassToInitList(String str) {
        if (TextUtils.isEmpty(str) || !str.endsWith(r.f42034a) || this.mStaticClassFiles == null || PluginPackageManager.O().a0(str)) {
            return;
        }
        synchronized (this.mStaticClassFielsLock) {
            this.mStaticClassFiles.add(str);
        }
    }

    private boolean assertApkFile() {
        return this.mPluginApkFile.isFile() && this.mPluginApkFile.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
    }

    private c createClassLoader() {
        boolean z;
        c cVar = new c();
        PluginSetting h2 = d.k().h(this.mPackageName);
        if (h2 == null) {
            cVar.f2186a = false;
            cVar.f2187b = "settingnull";
            cVar.f2188c = "createClassLoader";
            return cVar;
        }
        try {
            if (this.mPluginDataRoot == null || !this.mPluginDataRoot.exists()) {
                createDataRoot();
            }
            ClassLoader classLoader = this.mContext.getClassLoader();
            long currentTimeMillis = System.currentTimeMillis();
            if (h2.isThird) {
                this.mDexClassLoader = new d.b.b.h.a(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath(), getPluginLibPath(), classLoader.getParent(), classLoader);
            } else {
                this.mDexClassLoader = new DexClassLoader(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath(), getPluginLibPath(), classLoader);
            }
            cVar.f2189d = System.currentTimeMillis() - currentTimeMillis;
            try {
                if (this.mDexClassLoader != null) {
                    ClassLoader classLoader2 = this.mDexClassLoader;
                    classLoader2.loadClass(this.mPackageName + ".Static");
                }
                z = true;
            } catch (ClassNotFoundException e2) {
                cVar.f2187b = "loadR";
                cVar.f2188c = e2.getMessage();
                if (PluginPackageManager.O().c0()) {
                    d.b.b.h.h.a.b().r("plugin_load", "loadR", this.mPackageName, e2.getMessage());
                }
                BdLog.e(e2);
                z = false;
            }
            if (PluginPackageManager.O().c0() && !z) {
                d.b.b.h.h.a.b().g("plugin_class_notfind");
            }
            if (!z) {
                cVar.f2186a = false;
                return cVar;
            }
            if (h2.isPatch) {
                this.mCurrentPluginMode = 1;
                if (TextUtils.isEmpty(h2.replaceMethodClasses)) {
                    ClassLoader classLoader3 = this.mContext.getClassLoader();
                    while (!(classLoader3 instanceof PathClassLoader)) {
                        classLoader3 = classLoader3.getParent();
                    }
                    ClassLoader classLoader4 = this.mDexClassLoader;
                    a.c k = d.b.b.h.k.a.k(classLoader3, classLoader4, this.mPackageName + ".Static", false, this.mPluginApkFile.getAbsolutePath());
                    if (k == null || !k.f42312a) {
                        d.b.b.h.h.a b2 = d.b.b.h.h.a.b();
                        String str = this.mPackageName;
                        b2.r("plugin_load", "createClassLoader_failed", str, "patch apk inject failed!" + k.f42313b);
                        cVar.f2186a = false;
                        cVar.f2187b = "patchClassLoaderInject_failed";
                        cVar.f2188c = "inject failed, patch failed!";
                        return cVar;
                    }
                } else {
                    if (Build.VERSION.SDK_INT <= 23 && (!Util.q() || Build.VERSION.SDK_INT >= 21)) {
                        cVar.f2186a = false;
                        cVar.f2187b = "replace lib load failed!";
                        cVar.f2188c = "patch replace failed!!";
                        d.b.b.h.h.a.b().r("plugin_load", "create_patch_classloader_error", this.mPackageName, cVar.f2187b);
                        return cVar;
                    }
                    cVar.f2186a = true;
                    d.b.b.h.h.a.b().r("plugin_load", "create_patch_classloader_error", this.mPackageName, "system not support!");
                }
            }
            if (h2.isInjectClassloader()) {
                ClassLoader classLoader5 = this.mContext.getClassLoader();
                while (!(classLoader5 instanceof PathClassLoader)) {
                    classLoader5 = classLoader5.getParent();
                }
                this.mCurrentPluginMode = 1;
                ClassLoader classLoader6 = this.mDexClassLoader;
                a.c k2 = d.b.b.h.k.a.k(classLoader5, classLoader6, this.mPackageName + ".Static", true, this.mPluginApkFile.getAbsolutePath());
                if (k2 != null && !k2.f42312a) {
                    if (PluginPackageManager.O().c0()) {
                        d.b.b.h.h.a.b().g("plugin_inject_failed");
                    }
                    cVar.f2187b = "inject_failed";
                    cVar.f2188c = k2.f42313b;
                    d.b.b.h.h.a.b().r("plugin_load", "inject_failed", this.mPackageName, k2.f42313b);
                    this.mCurrentPluginMode = 2;
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    ArrayList<Plugin> allPlugins = PluginCenter.getInstance().getAllPlugins();
                    if (allPlugins != null && allPlugins.size() > 0) {
                        Iterator<Plugin> it = allPlugins.iterator();
                        while (it.hasNext()) {
                            Plugin next = it.next();
                            if (next != null) {
                                sb.append(next.getPluginApkFilePath());
                                sb.append(File.pathSeparator);
                                sb2.append(next.getPluginLibPath());
                                sb2.append(File.pathSeparator);
                            }
                        }
                    }
                    DexClassLoader dexClassLoader = new DexClassLoader(sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "", this.mPluginDataRoot.getAbsolutePath(), sb2.length() > 0 ? sb2.substring(0, sb2.length() - 1) : "", classLoader5);
                    Context context = this.mContext;
                    a.c l = d.b.b.h.k.a.l(context, dexClassLoader, this.mPackageName + ".Static");
                    if (l != null && !l.f42312a) {
                        if (PluginPackageManager.O().c0()) {
                            d.b.b.h.h.a.b().r("plugin_load", "replaceparent_failed", this.mPackageName, l.f42313b);
                        }
                        cVar.f2186a = false;
                        cVar.f2187b = "replaceparent_failed";
                        cVar.f2188c = l.f42313b;
                        return cVar;
                    } else if (l != null && l.f42312a) {
                        d.b.b.h.h.a.b().g("plugin_second_inject_succ");
                    }
                }
            }
            this.mIsClassLoaderSucc = true;
            cVar.f2186a = true;
            return cVar;
        } catch (Exception e3) {
            BdLog.e(e3);
            cVar.f2186a = false;
            cVar.f2187b = "new_dexloader_failed";
            cVar.f2188c = e3.getMessage() + "---" + e3.getClass().getName();
            if (PluginPackageManager.O().c0()) {
                d.b.b.h.h.a b3 = d.b.b.h.h.a.b();
                String str2 = this.mPackageName;
                b3.r("plugin_load", "new_dexloader_failed", str2, e3.getMessage() + "---" + e3.getClass().getName());
            }
            return cVar;
        }
    }

    private void createDataRoot() {
        try {
            File i = Util.i(this.mPackageName);
            this.mPluginDataRoot = i;
            i.mkdirs();
        } catch (Exception e2) {
            BdLog.e(e2);
            if (PluginPackageManager.O().c0()) {
                d.b.b.h.h.a b2 = d.b.b.h.h.a.b();
                String str = this.mPackageName;
                b2.r("plugin_load", "createdataroot_failed", str, e2.getMessage() + "---" + e2.getClass().getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0223 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c createPlugin(String str) {
        Object invoke;
        boolean z;
        boolean z2;
        boolean z3;
        c createClassLoader;
        String str2;
        PluginSetting h2;
        String str3;
        c cVar = new c();
        File A = d.b.b.h.g.c.A(str);
        this.mPluginApkFile = A;
        if (A == null) {
            if (PluginPackageManager.O().c0()) {
                if (d.k().h(str) != null) {
                    str3 = "-versioncode-" + h2.versionCode + "-enable-" + h2.enable + "-forbid-" + h2.forbidden + "-installstatus-" + h2.installStatus + "-url-" + h2.url + "-size-" + h2.size + "-abandonapkpath-" + h2.getAbandon_apk_path();
                } else {
                    int size = d.k().l().getPlugins().size();
                    File file = new File(d.b.b.h.j.g.c.b().c());
                    str3 = "settingssize-" + size + "-filesize-" + file.length();
                }
                cVar.f2187b = "apk_file_null";
                cVar.f2188c = str3;
                d.b.b.h.h.a.b().r("plugin_load", "apk_file_null", str, str3);
            }
            d.k().C(str);
            cVar.f2186a = false;
            return cVar;
        } else if (!assertApkFile()) {
            d.k().C(str);
            if (PluginPackageManager.O().c0()) {
                d.b.b.h.h.a.b().r("plugin_load", "apk_file_illegal", str, this.mPluginApkFile.getAbsolutePath());
            }
            cVar.f2186a = false;
            cVar.f2187b = "apk_file_illegal";
            return cVar;
        } else {
            createDataRoot();
            if (!this.mIsClassLoaderSucc) {
                String str4 = Util.m() + "/oat/";
                File file2 = new File(str4);
                PluginSetting h3 = d.k().h(this.mPackageName);
                if (h3 != null && (str2 = h3.apkPath) != null) {
                    int lastIndexOf = str2.lastIndexOf("/");
                    int lastIndexOf2 = h3.apkPath.lastIndexOf(Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                    int i = lastIndexOf + 1;
                    if (i < lastIndexOf2) {
                        String substring = h3.apkPath.substring(i, lastIndexOf2);
                        z3 = new File(Util.m() + "/" + substring + "/" + substring + ".dex").exists();
                        z2 = file2.exists();
                        StringBuilder sb = new StringBuilder();
                        sb.append(str4);
                        sb.append("/arm/");
                        sb.append(substring);
                        sb.append(".vdex");
                        boolean exists = new File(sb.toString()).exists();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str4);
                        sb2.append("/arm/");
                        sb2.append(substring);
                        sb2.append(".odex");
                        z = exists && new File(sb2.toString()).exists();
                        createClassLoader = createClassLoader();
                        if (z2 && !z3) {
                            d.b.b.h.h.a.b().o("plugin_load", "plugin_dex_oat_null", str, "processName_" + mProcessName + "-newTime_" + createClassLoader.f2189d);
                        } else if (z2 && !z) {
                            d.b.b.h.h.a.b().o("plugin_load", "plugin_oatfile_null", str, "processName_" + mProcessName + "-newTime_" + createClassLoader.f2189d);
                        }
                        if (!createClassLoader.f2186a) {
                            return createClassLoader;
                        }
                    }
                }
                z = false;
                z2 = false;
                z3 = false;
                createClassLoader = createClassLoader();
                if (z2) {
                }
                if (z2) {
                    d.b.b.h.h.a.b().o("plugin_load", "plugin_oatfile_null", str, "processName_" + mProcessName + "-newTime_" + createClassLoader.f2189d);
                }
                if (!createClassLoader.f2186a) {
                }
            }
            c createPluginResource = createPluginResource();
            if (createPluginResource.f2186a) {
                this.mManifest = new d.b.b.h.b(this.mContext, this.mPluginApkFile, this.mPluginResource);
                try {
                    Class<?> cls = Class.forName(this.mPackageName + ".PluginStaticClassesArray", true, this.mDexClassLoader);
                    invoke = cls.getDeclaredMethod("getStaticClasses", new Class[0]).invoke(cls, new Object[0]);
                } catch (Throwable unused) {
                    synchronized (this.mStaticClassFielsLock) {
                        this.mStaticClassFiles = new ArrayList<>();
                        loadStaticClasses();
                    }
                }
                if (invoke instanceof String[]) {
                    for (String str5 : (String[]) invoke) {
                        addStaticClassToInitList(str5);
                    }
                    if (!initStaticBlock()) {
                        throw new RuntimeException();
                    }
                    createPluginResource.f2186a = true;
                    return createPluginResource;
                }
                throw new RuntimeException();
            }
            return createPluginResource;
        }
    }

    private c createPluginResource() {
        c cVar = new c();
        PluginSetting h2 = d.k().h(this.mPackageName);
        if (h2 == null) {
            cVar.f2186a = false;
            cVar.f2187b = "settingnull";
            cVar.f2188c = "createPluginResource";
            return cVar;
        } else if (h2.isPatch) {
            this.mIsPluginResourceSucc = true;
            cVar.f2186a = true;
            return cVar;
        } else if (h2.isThird) {
            try {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                d.b.b.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{this.mPluginApkFile.getAbsolutePath()});
                Resources resources = this.mContext.getResources();
                this.mPluginResource = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                this.mIsPluginResourceSucc = true;
                cVar.f2186a = true;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            return cVar;
        } else {
            boolean z = h2.hasRes;
            this.mPluginResource = this.mContext.getResources();
            if (BdBaseApplication.getInst().getIsPluginResourcOpen() && z) {
                File file = this.mPluginApkFile;
                if (file != null && !TextUtils.isEmpty(file.getAbsolutePath())) {
                    try {
                        h.a().c(this.mPackageName, this.mPluginApkFile.getAbsolutePath());
                        this.mIsPluginResourceSucc = true;
                        cVar.f2186a = true;
                        if ("com.baidu.tieba.pluginPhotoLive".equals(this.mPackageName)) {
                            h.a().b().getIdentifier("photo_live_activity", "layout", BdBaseApplication.getInst().getPackageName());
                        }
                        return cVar;
                    } catch (Error e3) {
                        cVar.f2187b = "res_failed";
                        cVar.f2188c = e3.getMessage();
                        cVar.f2186a = false;
                        if (PluginPackageManager.O().c0()) {
                            d.b.b.h.h.a.b().r("plugin_load", "res_failed", this.mPackageName, e3.getMessage());
                            d.b.b.h.h.a.b().g("plugin_res_inject_fail");
                        }
                    } catch (Exception e4) {
                        cVar.f2187b = "res_failed";
                        cVar.f2188c = e4.getMessage();
                        cVar.f2186a = false;
                        if (PluginPackageManager.O().c0()) {
                            d.b.b.h.h.a.b().r("plugin_load", "res_failed", this.mPackageName, e4.getMessage());
                            d.b.b.h.h.a.b().g("plugin_res_inject_fail");
                        }
                    }
                }
                return cVar;
            }
            this.mIsPluginResourceSucc = true;
            cVar.f2186a = true;
            return cVar;
        }
    }

    private void createProviders() {
        Object split;
        d.b.b.h.b bVar = this.mManifest;
        if (bVar == null || bVar.b() == null) {
            return;
        }
        try {
            Iterator<Map.Entry<String, ProviderInfo>> it = this.mManifest.b().entrySet().iterator();
            if (it == null) {
                return;
            }
            String str = ContentProviderProxy.PROVIDER_AUTHOR;
            while (it.hasNext()) {
                ProviderInfo value = it.next().getValue();
                if (!TextUtils.isEmpty(value.authority) && !this.mProviders.containsKey(value.authority)) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        str = str + ";" + value.authority;
                    }
                    ContentProvider contentProvider = (ContentProvider) this.mDexClassLoader.loadClass(value.name).newInstance();
                    contentProvider.attachInfo(this.mApplication, value);
                    this.mProviders.put(value.authority, contentProvider);
                }
            }
            if (Build.VERSION.SDK_INT < 21 || ContentProviderProxy.getInstance() == null) {
                return;
            }
            Object h2 = d.b.b.h.k.d.h(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthorities");
            if (h2 != null) {
                split = d.b.b.h.k.d.c(h2, str.split(";"));
            } else {
                split = str.split(";");
            }
            d.b.b.h.k.d.l(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthorities", split);
            d.b.b.h.k.d.l(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthority", null);
        } catch (Exception e2) {
            BdLog.e(e2);
            d.b.b.h.h.a.b().r("plugin_install", "create_provider_failed", this.mPackageName, e2.getMessage());
        }
    }

    public static String generateOutputName(String str, String str2) {
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
    public void initApplication() {
        if (this.mApplication != null) {
            return;
        }
        PluginBaseApplication pluginBaseApplication = new PluginBaseApplication();
        pluginBaseApplication.setApplicationProxy((Application) this.mContext);
        pluginBaseApplication.setPluginPackageName(this.mPackageName);
        pluginBaseApplication.onCreate();
        this.mApplication = pluginBaseApplication;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initStaticBlock() {
        synchronized (this.mStaticClassFielsLock) {
            if (this.mStaticClassFiles != null && this.mStaticClassFiles.size() > 0) {
                Iterator<String> it = this.mStaticClassFiles.iterator();
                StringBuilder sb = null;
                while (it.hasNext()) {
                    String next = it.next();
                    try {
                        Class.forName(next, true, this.mDexClassLoader);
                    } catch (ClassNotFoundException e2) {
                        BdLog.e(e2);
                        if (sb == null) {
                            sb = new StringBuilder();
                        }
                        sb.append(next);
                        sb.append("-");
                        sb.append(e2.getMessage());
                        sb.append(",");
                    }
                }
                this.mStaticClassFiles.clear();
                this.mStaticClassFiles = null;
                if (sb != null) {
                    String str = this.mPackageName;
                    if (PluginPackageManager.O().c0()) {
                        d.b.b.h.h.a.b().o("plugin_load", "init_static_failed", str, sb.toString());
                    }
                    return false;
                }
            }
            return true;
        }
    }

    private boolean loadStaticClasses() {
        ClassLoader classLoader = this.mDexClassLoader;
        if (classLoader == null) {
            return false;
        }
        DexFile b2 = d.b.b.h.k.b.b(classLoader);
        String str = null;
        if (b2 == null) {
            try {
                b2 = DexFile.loadDex(this.mPluginApkFile.getAbsolutePath(), generateOutputName(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath()), 0);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                str = e2.getMessage();
            }
        }
        if (b2 != null) {
            Enumeration<String> entries = b2.entries();
            if (entries != null) {
                while (entries.hasMoreElements()) {
                    try {
                        addStaticClassToInitList(entries.nextElement());
                    } catch (Exception e3) {
                        if (PluginPackageManager.O().c0()) {
                            d.b.b.h.h.a.b().r("plugin_load", "getdexfile_failed_reverse", this.mPackageName, e3.getMessage());
                        }
                        return false;
                    }
                }
                initStaticBlock();
                return true;
            }
            if (PluginPackageManager.O().c0()) {
                d.b.b.h.h.a.b().r("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, str);
            }
            return false;
        }
        if (PluginPackageManager.O().c0()) {
            d.b.b.h.h.a.b().r("plugin_load", "getdexfile_failed", this.mPackageName, str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessageForPluginLoaded(String str, int i, String str2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000997, new PluginLoadedMessage.a(str, i, str2)));
    }

    public void asyncInit(String str, d.b.b.h.k.c cVar) {
        b bVar = this.mInitPluginTask;
        if (bVar != null) {
            bVar.cancel();
            this.mInitPluginTask = null;
        }
        b bVar2 = new b(str, cVar);
        this.mInitPluginTask = bVar2;
        bVar2.execute(new String[0]);
    }

    public boolean asyncInitWithBroadcast(String str) {
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
        asyncInit(str, new a(this));
        return true;
    }

    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        if (context != null && intent != null) {
            String className = intent.getComponent() != null ? intent.getComponent().getClassName() : null;
            if (TextUtils.isEmpty(className)) {
                d.b.b.h.h.a.b().i("plugin_run_fail", this.mPackageName);
                return false;
            }
            try {
                Class<?> loadClass = this.mDexClassLoader.loadClass(className);
                if (PluginBaseService.class.isAssignableFrom(loadClass) || PluginBaseRemoteService.class.isAssignableFrom(loadClass)) {
                    if (remapStartServiceIntent(intent, className, loadClass)) {
                        context.bindService(intent, serviceConnection, i);
                        return true;
                    }
                    d.b.b.h.h.a.b().i("plugin_run_fail", this.mPackageName);
                    BdLog.e("intent remap failed");
                }
                return false;
            } catch (Exception unused) {
                d.b.b.h.h.a.b().i("plugin_run_fail", this.mPackageName);
            }
        }
        return false;
    }

    public boolean containssClass(String str) {
        DexFile b2 = d.b.b.h.k.b.b(this.mDexClassLoader);
        if (b2 == null) {
            try {
                b2 = DexFile.loadDex(this.mPluginApkFile.getAbsolutePath(), generateOutputName(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath()), 0);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (b2 != null) {
            Enumeration<String> entries = b2.entries();
            while (entries.hasMoreElements()) {
                if (entries.nextElement().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void destroy() {
        Application application;
        if (this.mIsClassLoaderSucc && this.mIsPluginResourceSucc && (application = this.mApplication) != null) {
            application.onTerminate();
        }
    }

    public ServiceInfo findServiceInfo(String str) {
        d.b.b.h.b bVar;
        PackageInfo c2;
        ServiceInfo[] serviceInfoArr;
        if (!TextUtils.isEmpty(str) && (bVar = this.mManifest) != null && (c2 = bVar.c()) != null && (serviceInfoArr = c2.services) != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (str.equals(serviceInfo.name)) {
                    return serviceInfo;
                }
            }
        }
        return null;
    }

    public int getActivityThemeResource() {
        return 16973829;
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public ContentProvider getContentProvider(String str) {
        if (TextUtils.isEmpty(str) || this.mProviders.isEmpty()) {
            return null;
        }
        return this.mProviders.get(str);
    }

    public int getCurrentPluginMode() {
        return this.mCurrentPluginMode;
    }

    public ClassLoader getDexClassLoader() {
        return this.mDexClassLoader;
    }

    public long getLastLaunchTime() {
        return this.mLastLaunchTime;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getPluginApkFilePath() {
        File file = this.mPluginApkFile;
        if (file == null || !file.exists()) {
            return null;
        }
        return this.mPluginApkFile.getAbsolutePath();
    }

    public File getPluginDataRoot() {
        return this.mPluginDataRoot;
    }

    public String getPluginLibPath() {
        File file = this.mPluginDataRoot;
        if (file == null || !file.exists()) {
            return null;
        }
        return new File(this.mPluginDataRoot, "lib").getAbsolutePath();
    }

    public d.b.b.h.b getPluginManifest() {
        return this.mManifest;
    }

    public PackageInfo getPluginPackageInfo() {
        d.b.b.h.b bVar;
        if (this.mContext == null || this.mPluginApkFile == null || (bVar = this.mManifest) == null) {
            return null;
        }
        return bVar.c();
    }

    public Resources getPluginResources() {
        return this.mPluginResource;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean initBuildInCodePlugin() {
        this.mPackageName = BdBaseApplication.getInst().getPackageName();
        this.mDexClassLoader = this.mContext.getClassLoader();
        this.mPluginResource = this.mContext.getResources();
        this.mApplication = BdBaseApplication.getInst();
        this.mIsClassLoaderSucc = true;
        this.mIsPluginResourceSucc = true;
        return true;
    }

    public c initWithBroadcast(String str) {
        if (this.isIniting) {
            d.b.b.h.h.a b2 = d.b.b.h.h.a.b();
            b2.o("plugin_load", "load_in_multithread", str, "curthread is main?" + String.valueOf(l.B()));
        }
        int i = 1;
        this.isIniting = true;
        c cVar = new c();
        if (TextUtils.isEmpty(str)) {
            if (!BdBaseApplication.getInst().isDebugMode()) {
                sendMessageForPluginLoaded(str, 2, null);
                cVar.f2186a = true;
                cVar.f2187b = "packageName is null";
                this.isIniting = false;
                return cVar;
            }
            this.isIniting = false;
            throw new IllegalArgumentException("Plugin asyncInitWithBroadcast args exception!");
        }
        this.mPackageName = str;
        this.mLastLaunchTime = System.currentTimeMillis();
        if (isLoaded()) {
            this.isIniting = false;
            cVar.f2187b = "plugin has loaded";
            cVar.f2186a = true;
            return cVar;
        }
        PluginSetting h2 = d.k().h(this.mPackageName);
        if (h2 != null && h2.isPatch && PluginPackageManager.O().Q() > 0) {
            this.isIniting = false;
            cVar.f2186a = true;
            return cVar;
        }
        initApplication();
        c createPlugin = createPlugin(str);
        if (PluginPackageManager.O().c0() && createPlugin.f2186a) {
            d.b.b.h.h.a.b().t("plugin_load", str);
        }
        if (!createPlugin.f2186a) {
            sendMessageForPluginLoaded(str, 1, null);
            this.isIniting = false;
            return createPlugin;
        }
        if (PluginPackageManager.O().f0() && h2 != null && h2.isThird) {
            if (this.mManifest.e()) {
                createProviders();
            } else {
                createPlugin.f2186a = false;
                if (createPlugin.f2186a && h2 != null) {
                    this.mVersionCode = h2.versionCode;
                }
                sendMessageForPluginLoaded(str, i, null);
                this.isIniting = false;
                return createPlugin;
            }
        }
        i = 0;
        if (createPlugin.f2186a) {
            this.mVersionCode = h2.versionCode;
        }
        sendMessageForPluginLoaded(str, i, null);
        this.isIniting = false;
        return createPlugin;
    }

    public boolean isLoaded() {
        return this.mIsClassLoaderSucc && this.mIsPluginResourceSucc;
    }

    public boolean launchIntent(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        String className = intent.getComponent() != null ? intent.getComponent().getClassName() : null;
        if (TextUtils.isEmpty(className)) {
            d.b.b.h.h.a.b().i("plugin_run_fail", this.mPackageName);
            return false;
        }
        try {
            Class<?> loadClass = this.mDexClassLoader.loadClass(className);
            if (this.mCurrentPluginMode == 0) {
                if (!PluginBaseService.class.isAssignableFrom(loadClass) && !PluginBaseRemoteService.class.isAssignableFrom(loadClass)) {
                    if (remapStartActivityIntent(intent, className, loadClass)) {
                        if (!(context instanceof Activity) && intent != null) {
                            intent.addFlags(268435456);
                        }
                        context.startActivity(intent);
                        return true;
                    }
                    d.b.b.h.h.a.b().i("plugin_run_fail", this.mPackageName);
                    BdLog.e("intent remap failed");
                } else if (remapStartServiceIntent(intent, className, loadClass)) {
                    context.startService(intent);
                    return true;
                } else {
                    d.b.b.h.h.a.b().i("plugin_run_fail", this.mPackageName);
                    BdLog.e("intent remap failed");
                }
                return false;
            }
            intent.putExtra(INTENT_EXTRA_PACKAGE_NAME, this.mPackageName);
            if (Service.class.isAssignableFrom(loadClass)) {
                context.startService(intent);
            } else {
                if (!(context instanceof Activity) && intent != null) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            }
            return true;
        } catch (Exception e2) {
            d.b.b.h.h.a.b().i("plugin_run_fail", this.mPackageName);
            BdLog.e(e2);
            return false;
        }
    }

    public boolean remapBroadcastReceiver(Intent intent) {
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
            for (Map.Entry<String, IntentFilter> entry : this.mManifest.d().entrySet()) {
                if (entry.getValue().hasAction(action)) {
                    str = str + "#" + entry.getKey();
                }
            }
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            className = str.substring(1);
        } else {
            className = intent.getComponent().getClassName();
        }
        return remapBroadcastReceiver(intent, className, null);
    }

    public boolean remapStartActivityIntent(Intent intent) {
        if (intent == null || intent.getComponent() == null) {
            return false;
        }
        return remapStartActivityIntent(intent, intent.getComponent().getClassName(), null);
    }

    public boolean remapStartServiceIntent(Intent intent) {
        String className;
        ServiceInfo a2;
        if (intent == null) {
            return false;
        }
        if (intent.getComponent() == null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || (a2 = this.mManifest.a(action)) == null || TextUtils.isEmpty(a2.name)) {
                return false;
            }
            className = a2.name;
        } else {
            className = intent.getComponent().getClassName();
        }
        return remapStartServiceIntent(intent, className, null);
    }

    public void setVersionCode(int i) {
        this.mVersionCode = i;
    }

    private boolean remapStartActivityIntent(Intent intent, String str, Class<?> cls) {
        intent.putExtra(INTENT_EXTRA_ACTIVITY, str);
        intent.putExtra(INTENT_EXTRA_PACKAGE_NAME, this.mPackageName);
        if (cls == null) {
            try {
                cls = this.mDexClassLoader.loadClass(str);
            } catch (Exception unused) {
                return false;
            }
        }
        Class<?> b2 = d.b.b.h.c.a().b(cls);
        if (b2 != null) {
            intent.setClass(this.mContext, b2);
            return true;
        }
        return false;
    }

    private boolean remapStartServiceIntent(Intent intent, String str, Class<?> cls) {
        intent.putExtra(INTENT_EXTRA_SERVICE, str);
        intent.putExtra(INTENT_EXTRA_PACKAGE_NAME, this.mPackageName);
        if (cls == null) {
            try {
                cls = this.mDexClassLoader.loadClass(str);
            } catch (Exception unused) {
                return false;
            }
        }
        Class<?> b2 = e.a().b(cls);
        if (b2 != null) {
            intent.setClass(this.mContext, b2);
            return true;
        }
        return false;
    }

    private boolean remapBroadcastReceiver(Intent intent, String str, Class<?> cls) {
        intent.putExtra(INTENT_EXTRA_RECEIVER, str);
        intent.putExtra(INTENT_EXTRA_PACKAGE_NAME, this.mPackageName);
        intent.setClass(this.mContext, BroadcastReceiverProxy.class);
        return true;
    }
}
