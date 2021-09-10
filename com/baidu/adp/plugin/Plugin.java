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
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.h;
import c.a.e.e.p.l;
import c.a.e.e.p.r;
import c.a.e.h.e;
import c.a.e.h.j.g.d;
import c.a.e.h.k.a;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes4.dex */
public class Plugin {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isIniting;
    public Application mApplication;
    public final Context mContext;
    public int mCurrentPluginMode;
    public ClassLoader mDexClassLoader;
    public b mInitPluginTask;
    public boolean mIsClassLoaderSucc;
    public boolean mIsPluginResourceSucc;
    public long mLastLaunchTime;
    public c.a.e.h.b mManifest;
    public String mPackageName;
    public File mPluginApkFile;
    public File mPluginDataRoot;
    public Resources mPluginResource;
    public Map<String, ContentProvider> mProviders;
    public Object mStaticClassFielsLock;
    public ArrayList<String> mStaticClassFiles;
    public int mVersionCode;

    /* loaded from: classes4.dex */
    public class a implements c.a.e.h.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(Plugin plugin2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {plugin2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.e.h.k.c
        public void a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, cVar, str) == null) && PluginPackageManager.O().c0()) {
                if (cVar.f36311a) {
                    c.a.e.h.h.a.b().t("plugin_load", str);
                } else {
                    c.a.e.h.h.a.b().g("plugin_loaded_failed");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<String, Object, c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f36308a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.e.h.k.c f36309b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Plugin f36310c;

        public b(Plugin plugin2, String str, c.a.e.h.k.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {plugin2, str, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36310c = plugin2;
            this.f36308a = null;
            this.f36309b = null;
            this.f36308a = str;
            this.f36309b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public c doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) ? this.f36310c.createPlugin(this.f36308a) : (c) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                super.onPostExecute(cVar);
                c.a.e.h.k.c cVar2 = this.f36309b;
                if (cVar2 != null) {
                    cVar2.a(cVar, this.f36308a);
                } else {
                    BdLog.e("listener is null");
                    if (PluginPackageManager.O().c0()) {
                        c.a.e.h.h.a.b().q("plugin_load", "listener_null", this.f36308a);
                    }
                }
                if (cVar.f36311a) {
                    this.f36310c.initStaticBlock();
                    this.f36310c.initApplication();
                    this.f36310c.sendMessageForPluginLoaded(this.f36308a, 0, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f36311a;

        /* renamed from: b  reason: collision with root package name */
        public String f36312b;

        /* renamed from: c  reason: collision with root package name */
        public String f36313c;

        /* renamed from: d  reason: collision with root package name */
        public long f36314d;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public Plugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsClassLoaderSucc = false;
        this.mIsPluginResourceSucc = false;
        this.mLastLaunchTime = 0L;
        this.mCurrentPluginMode = 0;
        this.mPluginApkFile = null;
        this.mDexClassLoader = null;
        this.mPluginResource = null;
        this.mApplication = null;
        this.mPluginDataRoot = null;
        this.mStaticClassFiles = null;
        this.mStaticClassFielsLock = new Object();
        this.mInitPluginTask = null;
        this.mPackageName = null;
        this.mManifest = null;
        this.mProviders = null;
        this.isIniting = false;
        this.mContext = BdBaseApplication.getInst().getApplicationContext();
        this.mStaticClassFiles = new ArrayList<>();
        this.mProviders = new HashMap();
    }

    private void addStaticClassToInitList(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str) == null) || TextUtils.isEmpty(str) || !str.endsWith(r.f2587a) || this.mStaticClassFiles == null || PluginPackageManager.O().a0(str)) {
            return;
        }
        synchronized (this.mStaticClassFielsLock) {
            this.mStaticClassFiles.add(str);
        }
    }

    private boolean assertApkFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            return this.mPluginApkFile.isFile() && this.mPluginApkFile.getName().endsWith(".apk");
        }
        return invokeV.booleanValue;
    }

    private c createClassLoader() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            c cVar = new c();
            PluginSetting h2 = d.k().h(this.mPackageName);
            if (h2 == null) {
                cVar.f36311a = false;
                cVar.f36312b = "settingnull";
                cVar.f36313c = "createClassLoader";
                return cVar;
            }
            try {
                if (this.mPluginDataRoot == null || !this.mPluginDataRoot.exists()) {
                    createDataRoot();
                }
                ClassLoader classLoader = this.mContext.getClassLoader();
                long currentTimeMillis = System.currentTimeMillis();
                if (h2.isThird) {
                    this.mDexClassLoader = new c.a.e.h.a(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath(), getPluginLibPath(), classLoader.getParent(), classLoader);
                } else {
                    this.mDexClassLoader = new DexClassLoader(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath(), getPluginLibPath(), classLoader);
                }
                cVar.f36314d = System.currentTimeMillis() - currentTimeMillis;
                try {
                    if (this.mDexClassLoader != null) {
                        ClassLoader classLoader2 = this.mDexClassLoader;
                        classLoader2.loadClass(this.mPackageName + ".Static");
                    }
                    z = true;
                } catch (ClassNotFoundException e2) {
                    cVar.f36312b = "loadR";
                    cVar.f36313c = e2.getMessage();
                    if (PluginPackageManager.O().c0()) {
                        c.a.e.h.h.a.b().r("plugin_load", "loadR", this.mPackageName, e2.getMessage());
                    }
                    BdLog.e(e2);
                    z = false;
                }
                if (PluginPackageManager.O().c0() && !z) {
                    c.a.e.h.h.a.b().g("plugin_class_notfind");
                }
                if (!z) {
                    cVar.f36311a = false;
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
                        a.c k = c.a.e.h.k.a.k(classLoader3, classLoader4, this.mPackageName + ".Static", false, this.mPluginApkFile.getAbsolutePath());
                        if (k == null || !k.f2872a) {
                            c.a.e.h.h.a b2 = c.a.e.h.h.a.b();
                            String str = this.mPackageName;
                            b2.r("plugin_load", "createClassLoader_failed", str, "patch apk inject failed!" + k.f2873b);
                            cVar.f36311a = false;
                            cVar.f36312b = "patchClassLoaderInject_failed";
                            cVar.f36313c = "inject failed, patch failed!";
                            return cVar;
                        }
                    } else {
                        if (Build.VERSION.SDK_INT <= 23 && (!Util.q() || Build.VERSION.SDK_INT >= 21)) {
                            cVar.f36311a = false;
                            cVar.f36312b = "replace lib load failed!";
                            cVar.f36313c = "patch replace failed!!";
                            c.a.e.h.h.a.b().r("plugin_load", "create_patch_classloader_error", this.mPackageName, cVar.f36312b);
                            return cVar;
                        }
                        cVar.f36311a = true;
                        c.a.e.h.h.a.b().r("plugin_load", "create_patch_classloader_error", this.mPackageName, "system not support!");
                    }
                }
                if (h2.isInjectClassloader()) {
                    ClassLoader classLoader5 = this.mContext.getClassLoader();
                    while (!(classLoader5 instanceof PathClassLoader)) {
                        classLoader5 = classLoader5.getParent();
                    }
                    this.mCurrentPluginMode = 1;
                    ClassLoader classLoader6 = this.mDexClassLoader;
                    a.c k2 = c.a.e.h.k.a.k(classLoader5, classLoader6, this.mPackageName + ".Static", true, this.mPluginApkFile.getAbsolutePath());
                    if (k2 != null && !k2.f2872a) {
                        if (PluginPackageManager.O().c0()) {
                            c.a.e.h.h.a.b().g("plugin_inject_failed");
                        }
                        cVar.f36312b = "inject_failed";
                        cVar.f36313c = k2.f2873b;
                        c.a.e.h.h.a.b().r("plugin_load", "inject_failed", this.mPackageName, k2.f2873b);
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
                        a.c l = c.a.e.h.k.a.l(context, dexClassLoader, this.mPackageName + ".Static");
                        if (l != null && !l.f2872a) {
                            if (PluginPackageManager.O().c0()) {
                                c.a.e.h.h.a.b().r("plugin_load", "replaceparent_failed", this.mPackageName, l.f2873b);
                            }
                            cVar.f36311a = false;
                            cVar.f36312b = "replaceparent_failed";
                            cVar.f36313c = l.f2873b;
                            return cVar;
                        } else if (l != null && l.f2872a) {
                            c.a.e.h.h.a.b().g("plugin_second_inject_succ");
                        }
                    }
                }
                this.mIsClassLoaderSucc = true;
                cVar.f36311a = true;
                return cVar;
            } catch (Exception e3) {
                BdLog.e(e3);
                cVar.f36311a = false;
                cVar.f36312b = "new_dexloader_failed";
                cVar.f36313c = e3.getMessage() + "---" + e3.getClass().getName();
                if (PluginPackageManager.O().c0()) {
                    c.a.e.h.h.a b3 = c.a.e.h.h.a.b();
                    String str2 = this.mPackageName;
                    b3.r("plugin_load", "new_dexloader_failed", str2, e3.getMessage() + "---" + e3.getClass().getName());
                }
                return cVar;
            }
        }
        return (c) invokeV.objValue;
    }

    private void createDataRoot() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            try {
                File i2 = Util.i(this.mPackageName);
                this.mPluginDataRoot = i2;
                i2.mkdirs();
            } catch (Exception e2) {
                BdLog.e(e2);
                if (PluginPackageManager.O().c0()) {
                    c.a.e.h.h.a b2 = c.a.e.h.h.a.b();
                    String str = this.mPackageName;
                    b2.r("plugin_load", "createdataroot_failed", str, e2.getMessage() + "---" + e2.getClass().getName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0227 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c createPlugin(String str) {
        InterceptResult invokeL;
        Object invoke;
        boolean z;
        boolean z2;
        boolean z3;
        c createClassLoader;
        String str2;
        PluginSetting h2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            c cVar = new c();
            File A = c.a.e.h.g.c.A(str);
            this.mPluginApkFile = A;
            if (A == null) {
                if (PluginPackageManager.O().c0()) {
                    if (d.k().h(str) != null) {
                        str3 = "-versioncode-" + h2.versionCode + "-enable-" + h2.enable + "-forbid-" + h2.forbidden + "-installstatus-" + h2.installStatus + "-url-" + h2.url + "-size-" + h2.size + "-abandonapkpath-" + h2.getAbandon_apk_path();
                    } else {
                        int size = d.k().l().getPlugins().size();
                        File file = new File(c.a.e.h.j.g.c.b().c());
                        str3 = "settingssize-" + size + "-filesize-" + file.length();
                    }
                    cVar.f36312b = "apk_file_null";
                    cVar.f36313c = str3;
                    c.a.e.h.h.a.b().r("plugin_load", "apk_file_null", str, str3);
                }
                d.k().C(str);
                cVar.f36311a = false;
                return cVar;
            } else if (!assertApkFile()) {
                d.k().C(str);
                if (PluginPackageManager.O().c0()) {
                    c.a.e.h.h.a.b().r("plugin_load", "apk_file_illegal", str, this.mPluginApkFile.getAbsolutePath());
                }
                cVar.f36311a = false;
                cVar.f36312b = "apk_file_illegal";
                return cVar;
            } else {
                createDataRoot();
                if (!this.mIsClassLoaderSucc) {
                    String str4 = Util.m() + "/oat/";
                    File file2 = new File(str4);
                    PluginSetting h3 = d.k().h(this.mPackageName);
                    if (h3 != null && (str2 = h3.apkPath) != null) {
                        int lastIndexOf = str2.lastIndexOf("/");
                        int lastIndexOf2 = h3.apkPath.lastIndexOf(".apk");
                        int i2 = lastIndexOf + 1;
                        if (i2 < lastIndexOf2) {
                            String substring = h3.apkPath.substring(i2, lastIndexOf2);
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
                                c.a.e.h.h.a.b().o("plugin_load", "plugin_dex_oat_null", str, "processName_" + mProcessName + "-newTime_" + createClassLoader.f36314d);
                            } else if (z2 && !z) {
                                c.a.e.h.h.a.b().o("plugin_load", "plugin_oatfile_null", str, "processName_" + mProcessName + "-newTime_" + createClassLoader.f36314d);
                            }
                            if (!createClassLoader.f36311a) {
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
                        c.a.e.h.h.a.b().o("plugin_load", "plugin_oatfile_null", str, "processName_" + mProcessName + "-newTime_" + createClassLoader.f36314d);
                    }
                    if (!createClassLoader.f36311a) {
                    }
                }
                c createPluginResource = createPluginResource();
                if (createPluginResource.f36311a) {
                    this.mManifest = new c.a.e.h.b(this.mContext, this.mPluginApkFile, this.mPluginResource);
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
                        createPluginResource.f36311a = true;
                        return createPluginResource;
                    }
                    throw new RuntimeException();
                }
                return createPluginResource;
            }
        }
        return (c) invokeL.objValue;
    }

    private c createPluginResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            c cVar = new c();
            PluginSetting h2 = d.k().h(this.mPackageName);
            if (h2 == null) {
                cVar.f36311a = false;
                cVar.f36312b = "settingnull";
                cVar.f36313c = "createPluginResource";
                return cVar;
            } else if (h2.isPatch) {
                this.mIsPluginResourceSucc = true;
                cVar.f36311a = true;
                return cVar;
            } else if (h2.isThird) {
                try {
                    AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                    c.a.e.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{this.mPluginApkFile.getAbsolutePath()});
                    Resources resources = this.mContext.getResources();
                    this.mPluginResource = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    this.mIsPluginResourceSucc = true;
                    cVar.f36311a = true;
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
                            cVar.f36311a = true;
                            if ("com.baidu.tieba.pluginPhotoLive".equals(this.mPackageName)) {
                                try {
                                    h.a().b().getIdentifier("photo_live_activity", "layout", BdBaseApplication.getInst().getPackageName());
                                } catch (Throwable th) {
                                    c.a.e.h.h.a.b().o("plugin_load", "photolive_res_fail", this.mPackageName, th.getMessage());
                                }
                            }
                            return cVar;
                        } catch (Error e3) {
                            cVar.f36312b = "res_failed";
                            cVar.f36313c = e3.getMessage();
                            cVar.f36311a = false;
                            if (PluginPackageManager.O().c0()) {
                                c.a.e.h.h.a.b().r("plugin_load", "res_failed", this.mPackageName, e3.getMessage());
                                c.a.e.h.h.a.b().g("plugin_res_inject_fail");
                            }
                        } catch (Exception e4) {
                            cVar.f36312b = "res_failed";
                            cVar.f36313c = e4.getMessage();
                            cVar.f36311a = false;
                            if (PluginPackageManager.O().c0()) {
                                c.a.e.h.h.a.b().r("plugin_load", "res_failed", this.mPackageName, e4.getMessage());
                                c.a.e.h.h.a.b().g("plugin_res_inject_fail");
                            }
                        }
                    }
                    return cVar;
                }
                this.mIsPluginResourceSucc = true;
                cVar.f36311a = true;
                return cVar;
            }
        }
        return (c) invokeV.objValue;
    }

    private void createProviders() {
        c.a.e.h.b bVar;
        Object split;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (bVar = this.mManifest) == null || bVar.b() == null) {
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
            Object h2 = c.a.e.h.k.d.h(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthorities");
            if (h2 != null) {
                split = c.a.e.h.k.d.c(h2, str.split(";"));
            } else {
                split = str.split(";");
            }
            c.a.e.h.k.d.l(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthorities", split);
            c.a.e.h.k.d.l(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthority", null);
        } catch (Exception e2) {
            BdLog.e(e2);
            c.a.e.h.h.a.b().r("plugin_install", "create_provider_failed", this.mPackageName, e2.getMessage());
        }
    }

    public static String generateOutputName(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
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
        return (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initApplication() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65549, this) == null) && this.mApplication == null) {
            PluginBaseApplication pluginBaseApplication = new PluginBaseApplication();
            pluginBaseApplication.setApplicationProxy((Application) this.mContext);
            pluginBaseApplication.setPluginPackageName(this.mPackageName);
            pluginBaseApplication.onCreate();
            this.mApplication = pluginBaseApplication;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initStaticBlock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
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
                            c.a.e.h.h.a.b().o("plugin_load", "init_static_failed", str, sb.toString());
                        }
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean loadStaticClasses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            ClassLoader classLoader = this.mDexClassLoader;
            if (classLoader == null) {
                return false;
            }
            DexFile b2 = c.a.e.h.k.b.b(classLoader);
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
                                c.a.e.h.h.a.b().r("plugin_load", "getdexfile_failed_reverse", this.mPackageName, e3.getMessage());
                            }
                            return false;
                        }
                    }
                    initStaticBlock();
                    return true;
                }
                if (PluginPackageManager.O().c0()) {
                    c.a.e.h.h.a.b().r("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, str);
                }
                return false;
            }
            if (PluginPackageManager.O().c0()) {
                c.a.e.h.h.a.b().r("plugin_load", "getdexfile_failed", this.mPackageName, str);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessageForPluginLoaded(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, this, str, i2, str2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000997, new PluginLoadedMessage.a(str, i2, str2)));
        }
    }

    public void asyncInit(String str, c.a.e.h.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            b bVar = this.mInitPluginTask;
            if (bVar != null) {
                bVar.cancel();
                this.mInitPluginTask = null;
            }
            b bVar2 = new b(this, str, cVar);
            this.mInitPluginTask = bVar2;
            bVar2.execute(new String[0]);
        }
    }

    public boolean asyncInitWithBroadcast(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, context, intent, serviceConnection, i2)) == null) {
            if (context != null && intent != null) {
                String className = intent.getComponent() != null ? intent.getComponent().getClassName() : null;
                if (TextUtils.isEmpty(className)) {
                    c.a.e.h.h.a.b().i("plugin_run_fail", this.mPackageName);
                    return false;
                }
                try {
                    Class<?> loadClass = this.mDexClassLoader.loadClass(className);
                    if (PluginBaseService.class.isAssignableFrom(loadClass) || PluginBaseRemoteService.class.isAssignableFrom(loadClass)) {
                        if (remapStartServiceIntent(intent, className, loadClass)) {
                            context.bindService(intent, serviceConnection, i2);
                            return true;
                        }
                        c.a.e.h.h.a.b().i("plugin_run_fail", this.mPackageName);
                        BdLog.e("intent remap failed");
                    }
                    return false;
                } catch (Exception unused) {
                    c.a.e.h.h.a.b().i("plugin_run_fail", this.mPackageName);
                }
            }
            return false;
        }
        return invokeLLLI.booleanValue;
    }

    public boolean containssClass(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            DexFile b2 = c.a.e.h.k.b.b(this.mDexClassLoader);
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
        return invokeL.booleanValue;
    }

    public void destroy() {
        Application application;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.mIsClassLoaderSucc && this.mIsPluginResourceSucc && (application = this.mApplication) != null) {
            application.onTerminate();
        }
    }

    public ServiceInfo findServiceInfo(String str) {
        InterceptResult invokeL;
        c.a.e.h.b bVar;
        PackageInfo c2;
        ServiceInfo[] serviceInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (bVar = this.mManifest) != null && (c2 = bVar.c()) != null && (serviceInfoArr = c2.services) != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    if (str.equals(serviceInfo.name)) {
                        return serviceInfo;
                    }
                }
            }
            return null;
        }
        return (ServiceInfo) invokeL.objValue;
    }

    public int getActivityThemeResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 16973829;
        }
        return invokeV.intValue;
    }

    public Application getApplication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mApplication : (Application) invokeV.objValue;
    }

    public ContentProvider getContentProvider(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.isEmpty(str) || this.mProviders.isEmpty()) {
                return null;
            }
            return this.mProviders.get(str);
        }
        return (ContentProvider) invokeL.objValue;
    }

    public int getCurrentPluginMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mCurrentPluginMode : invokeV.intValue;
    }

    public ClassLoader getDexClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mDexClassLoader : (ClassLoader) invokeV.objValue;
    }

    public long getLastLaunchTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mLastLaunchTime : invokeV.longValue;
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mPackageName : (String) invokeV.objValue;
    }

    public String getPluginApkFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            File file = this.mPluginApkFile;
            if (file == null || !file.exists()) {
                return null;
            }
            return this.mPluginApkFile.getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public File getPluginDataRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mPluginDataRoot : (File) invokeV.objValue;
    }

    public String getPluginLibPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            File file = this.mPluginDataRoot;
            if (file == null || !file.exists()) {
                return null;
            }
            return new File(this.mPluginDataRoot, "lib").getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public c.a.e.h.b getPluginManifest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mManifest : (c.a.e.h.b) invokeV.objValue;
    }

    public PackageInfo getPluginPackageInfo() {
        InterceptResult invokeV;
        c.a.e.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.mContext == null || this.mPluginApkFile == null || (bVar = this.mManifest) == null) {
                return null;
            }
            return bVar.c();
        }
        return (PackageInfo) invokeV.objValue;
    }

    public Resources getPluginResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mPluginResource : (Resources) invokeV.objValue;
    }

    public int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mVersionCode : invokeV.intValue;
    }

    public boolean initBuildInCodePlugin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            this.mPackageName = BdBaseApplication.getInst().getPackageName();
            this.mDexClassLoader = this.mContext.getClassLoader();
            this.mPluginResource = this.mContext.getResources();
            this.mApplication = BdBaseApplication.getInst();
            this.mIsClassLoaderSucc = true;
            this.mIsPluginResourceSucc = true;
            return true;
        }
        return invokeV.booleanValue;
    }

    public c initWithBroadcast(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (this.isIniting) {
                c.a.e.h.h.a b2 = c.a.e.h.h.a.b();
                b2.o("plugin_load", "load_in_multithread", str, "curthread is main?" + String.valueOf(l.C()));
            }
            int i2 = 1;
            this.isIniting = true;
            c cVar = new c();
            if (TextUtils.isEmpty(str)) {
                if (!BdBaseApplication.getInst().isDebugMode()) {
                    sendMessageForPluginLoaded(str, 2, null);
                    cVar.f36311a = true;
                    cVar.f36312b = "packageName is null";
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
                cVar.f36312b = "plugin has loaded";
                cVar.f36311a = true;
                return cVar;
            }
            PluginSetting h2 = d.k().h(this.mPackageName);
            if (h2 != null && h2.isPatch && PluginPackageManager.O().Q() > 0) {
                this.isIniting = false;
                cVar.f36311a = true;
                return cVar;
            }
            initApplication();
            c createPlugin = createPlugin(str);
            if (PluginPackageManager.O().c0() && createPlugin.f36311a) {
                c.a.e.h.h.a.b().t("plugin_load", str);
            }
            if (!createPlugin.f36311a) {
                sendMessageForPluginLoaded(str, 1, null);
                this.isIniting = false;
                return createPlugin;
            }
            if (PluginPackageManager.O().f0() && h2 != null && h2.isThird) {
                if (this.mManifest.e()) {
                    createProviders();
                } else {
                    createPlugin.f36311a = false;
                    if (createPlugin.f36311a && h2 != null) {
                        this.mVersionCode = h2.versionCode;
                    }
                    sendMessageForPluginLoaded(str, i2, null);
                    this.isIniting = false;
                    return createPlugin;
                }
            }
            i2 = 0;
            if (createPlugin.f36311a) {
                this.mVersionCode = h2.versionCode;
            }
            sendMessageForPluginLoaded(str, i2, null);
            this.isIniting = false;
            return createPlugin;
        }
        return (c) invokeL.objValue;
    }

    public boolean isLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mIsClassLoaderSucc && this.mIsPluginResourceSucc : invokeV.booleanValue;
    }

    public boolean launchIntent(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, context, intent)) == null) {
            if (intent == null) {
                return false;
            }
            String className = intent.getComponent() != null ? intent.getComponent().getClassName() : null;
            if (TextUtils.isEmpty(className)) {
                c.a.e.h.h.a.b().i("plugin_run_fail", this.mPackageName);
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
                        c.a.e.h.h.a.b().i("plugin_run_fail", this.mPackageName);
                        BdLog.e("intent remap failed");
                    } else if (remapStartServiceIntent(intent, className, loadClass)) {
                        context.startService(intent);
                        return true;
                    } else {
                        c.a.e.h.h.a.b().i("plugin_run_fail", this.mPackageName);
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
                c.a.e.h.h.a.b().i("plugin_run_fail", this.mPackageName);
                BdLog.e(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean remapBroadcastReceiver(Intent intent) {
        InterceptResult invokeL;
        String className;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, intent)) == null) {
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
        return invokeL.booleanValue;
    }

    public boolean remapStartActivityIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, intent)) == null) {
            if (intent == null || intent.getComponent() == null) {
                return false;
            }
            return remapStartActivityIntent(intent, intent.getComponent().getClassName(), null);
        }
        return invokeL.booleanValue;
    }

    public boolean remapStartServiceIntent(Intent intent) {
        InterceptResult invokeL;
        String className;
        ServiceInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, intent)) == null) {
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
        return invokeL.booleanValue;
    }

    public void setVersionCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.mVersionCode = i2;
        }
    }

    private boolean remapStartActivityIntent(Intent intent, String str, Class<?> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, this, intent, str, cls)) == null) {
            intent.putExtra(INTENT_EXTRA_ACTIVITY, str);
            intent.putExtra(INTENT_EXTRA_PACKAGE_NAME, this.mPackageName);
            if (cls == null) {
                try {
                    cls = this.mDexClassLoader.loadClass(str);
                } catch (Exception unused) {
                    return false;
                }
            }
            Class<?> b2 = c.a.e.h.c.a().b(cls);
            if (b2 != null) {
                intent.setClass(this.mContext, b2);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    private boolean remapStartServiceIntent(Intent intent, String str, Class<?> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, this, intent, str, cls)) == null) {
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
        return invokeLLL.booleanValue;
    }

    private boolean remapBroadcastReceiver(Intent intent, String str, Class<?> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, this, intent, str, cls)) == null) {
            intent.putExtra(INTENT_EXTRA_RECEIVER, str);
            intent.putExtra(INTENT_EXTRA_PACKAGE_NAME, this.mPackageName);
            intent.setClass(this.mContext, BroadcastReceiverProxy.class);
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
