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
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.repackage.cm;
import com.repackage.d9;
import com.repackage.em;
import com.repackage.nm;
import com.repackage.oi;
import com.repackage.om;
import com.repackage.sl;
import com.repackage.sm;
import com.repackage.tl;
import com.repackage.tm;
import com.repackage.ul;
import com.repackage.um;
import com.repackage.vi;
import com.repackage.vm;
import com.repackage.wl;
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
    public tl mManifest;
    public String mPackageName;
    public File mPluginApkFile;
    public File mPluginDataRoot;
    public Resources mPluginResource;
    public Map<String, ContentProvider> mProviders;
    public Object mStaticClassFielsLock;
    public ArrayList<String> mStaticClassFiles;
    public int mVersionCode;

    /* loaded from: classes.dex */
    public class a implements um {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(Plugin plugin2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {plugin2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.um
        public void a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, cVar, str) == null) && PluginPackageManager.p().t()) {
                if (cVar.a) {
                    em.b().r("plugin_load", str);
                } else {
                    em.b().g("plugin_loaded_failed");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Object, c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public um b;
        public final /* synthetic */ Plugin c;

        public b(Plugin plugin2, String str, um umVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {plugin2, str, umVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = plugin2;
            this.a = null;
            this.b = null;
            this.a = str;
            this.b = umVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public c doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) ? this.c.createPlugin(this.a) : (c) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                super.onPostExecute(cVar);
                um umVar = this.b;
                if (umVar != null) {
                    umVar.a(cVar, this.a);
                } else {
                    BdLog.e("listener is null");
                    if (PluginPackageManager.p().t()) {
                        em.b().o("plugin_load", "listener_null", this.a);
                    }
                }
                if (cVar.a) {
                    this.c.initStaticBlock();
                    this.c.initApplication();
                    this.c.sendMessageForPluginLoaded(this.a, 0, null);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;
        public String c;
        public long d;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (!(interceptable == null || interceptable.invokeL(65541, this, str) == null) || TextUtils.isEmpty(str) || !str.endsWith(vi.a) || this.mStaticClassFiles == null || PluginPackageManager.p().s(str)) {
            return;
        }
        synchronized (this.mStaticClassFielsLock) {
            this.mStaticClassFiles.add(str);
        }
    }

    private boolean assertApkFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return this.mPluginApkFile.isFile() && this.mPluginApkFile.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
        }
        return invokeV.booleanValue;
    }

    private c createClassLoader() {
        InterceptResult invokeV;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            c cVar = new c();
            PluginSetting g = om.h().g(this.mPackageName);
            if (g == null) {
                cVar.a = false;
                cVar.b = "settingnull";
                cVar.c = "createClassLoader";
                return cVar;
            }
            try {
                if (this.mPluginDataRoot == null || !this.mPluginDataRoot.exists()) {
                    createDataRoot();
                }
                ClassLoader classLoader = this.mContext.getClassLoader();
                long currentTimeMillis = System.currentTimeMillis();
                if (g.isThird) {
                    this.mDexClassLoader = new sl(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath(), getPluginLibPath(), classLoader.getParent(), classLoader);
                } else {
                    this.mDexClassLoader = new DexClassLoader(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath(), getPluginLibPath(), classLoader);
                }
                cVar.d = System.currentTimeMillis() - currentTimeMillis;
                try {
                    if (this.mDexClassLoader != null) {
                        ClassLoader classLoader2 = this.mDexClassLoader;
                        classLoader2.loadClass(this.mPackageName + ".Static");
                    }
                    z = true;
                } catch (ClassNotFoundException e) {
                    cVar.b = "loadR";
                    cVar.c = e.getMessage();
                    if (PluginPackageManager.p().t()) {
                        em.b().p("plugin_load", "loadR", this.mPackageName, e.getMessage());
                    }
                    BdLog.e(e);
                    z = false;
                }
                if (PluginPackageManager.p().t() && !z) {
                    em.b().g("plugin_class_notfind");
                }
                if (!z) {
                    cVar.a = false;
                    return cVar;
                }
                str = "";
                if (g.isPatch) {
                    this.mCurrentPluginMode = 1;
                    if (TextUtils.isEmpty(g.replaceMethodClasses)) {
                        ClassLoader classLoader3 = this.mContext.getClassLoader();
                        while (!(classLoader3 instanceof PathClassLoader)) {
                            classLoader3 = classLoader3.getParent();
                        }
                        ClassLoader classLoader4 = this.mDexClassLoader;
                        sm.c j = sm.j(classLoader3, classLoader4, this.mPackageName + ".Static", false, this.mPluginApkFile.getAbsolutePath());
                        if (j == null || !j.a) {
                            em b2 = em.b();
                            String str2 = this.mPackageName;
                            StringBuilder sb = new StringBuilder();
                            sb.append("patch apk inject failed!");
                            if (j != null) {
                                str = j.b;
                            }
                            sb.append(str);
                            b2.p("plugin_load", "createClassLoader_failed", str2, sb.toString());
                            cVar.a = false;
                            cVar.b = "patchClassLoaderInject_failed";
                            cVar.c = "inject failed, patch failed!";
                            return cVar;
                        }
                    } else {
                        if (Build.VERSION.SDK_INT <= 23 && (!Util.k() || Build.VERSION.SDK_INT >= 21)) {
                            cVar.a = false;
                            cVar.b = "replace lib load failed!";
                            cVar.c = "patch replace failed!!";
                            em.b().p("plugin_load", "create_patch_classloader_error", this.mPackageName, cVar.b);
                            return cVar;
                        }
                        cVar.a = true;
                        em.b().p("plugin_load", "create_patch_classloader_error", this.mPackageName, "system not support!");
                    }
                }
                if (g.isInjectClassloader()) {
                    ClassLoader classLoader5 = this.mContext.getClassLoader();
                    while (!(classLoader5 instanceof PathClassLoader)) {
                        classLoader5 = classLoader5.getParent();
                    }
                    this.mCurrentPluginMode = 1;
                    ClassLoader classLoader6 = this.mDexClassLoader;
                    sm.c j2 = sm.j(classLoader5, classLoader6, this.mPackageName + ".Static", true, this.mPluginApkFile.getAbsolutePath());
                    if (j2 != null && !j2.a) {
                        if (PluginPackageManager.p().t()) {
                            em.b().g("plugin_inject_failed");
                        }
                        cVar.b = "inject_failed";
                        cVar.c = j2.b;
                        em.b().p("plugin_load", "inject_failed", this.mPackageName, j2.b);
                        this.mCurrentPluginMode = 2;
                        StringBuilder sb2 = new StringBuilder();
                        StringBuilder sb3 = new StringBuilder();
                        ArrayList<Plugin> allPlugins = PluginCenter.getInstance().getAllPlugins();
                        if (allPlugins != null && allPlugins.size() > 0) {
                            Iterator<Plugin> it = allPlugins.iterator();
                            while (it.hasNext()) {
                                Plugin next = it.next();
                                if (next != null) {
                                    sb2.append(next.getPluginApkFilePath());
                                    sb2.append(File.pathSeparator);
                                    sb3.append(next.getPluginLibPath());
                                    sb3.append(File.pathSeparator);
                                }
                            }
                        }
                        DexClassLoader dexClassLoader = new DexClassLoader(sb2.length() > 0 ? sb2.substring(0, sb2.length() - 1) : "", this.mPluginDataRoot.getAbsolutePath(), sb3.length() > 0 ? sb3.substring(0, sb3.length() - 1) : "", classLoader5);
                        Context context = this.mContext;
                        sm.c k = sm.k(context, dexClassLoader, this.mPackageName + ".Static");
                        if (k != null && !k.a) {
                            if (PluginPackageManager.p().t()) {
                                em.b().p("plugin_load", "replaceparent_failed", this.mPackageName, k.b);
                            }
                            cVar.a = false;
                            cVar.b = "replaceparent_failed";
                            cVar.c = k.b;
                            return cVar;
                        } else if (k != null && k.a) {
                            em.b().g("plugin_second_inject_succ");
                        }
                    }
                }
                this.mIsClassLoaderSucc = true;
                cVar.a = true;
                return cVar;
            } catch (Exception e2) {
                BdLog.e(e2);
                cVar.a = false;
                cVar.b = "new_dexloader_failed";
                cVar.c = e2.getMessage() + "---" + e2.getClass().getName();
                if (PluginPackageManager.p().t()) {
                    em b3 = em.b();
                    String str3 = this.mPackageName;
                    b3.p("plugin_load", "new_dexloader_failed", str3, e2.getMessage() + "---" + e2.getClass().getName());
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
                File e = Util.e(this.mPackageName);
                this.mPluginDataRoot = e;
                e.mkdirs();
            } catch (Exception e2) {
                BdLog.e(e2);
                if (PluginPackageManager.p().t()) {
                    em b2 = em.b();
                    String str = this.mPackageName;
                    b2.p("plugin_load", "createdataroot_failed", str, e2.getMessage() + "---" + e2.getClass().getName());
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
        PluginSetting g;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            c cVar = new c();
            File x = cm.x(str);
            this.mPluginApkFile = x;
            if (x == null) {
                if (PluginPackageManager.p().t()) {
                    if (om.h().g(str) != null) {
                        str3 = "-versioncode-" + g.versionCode + "-enable-" + g.enable + "-forbid-" + g.forbidden + "-installstatus-" + g.installStatus + "-url-" + g.url + "-size-" + g.size + "-abandonapkpath-" + g.getAbandon_apk_path();
                    } else {
                        int size = om.h().i().getPlugins().size();
                        File file = new File(nm.b().c());
                        str3 = "settingssize-" + size + "-filesize-" + file.length();
                    }
                    cVar.b = "apk_file_null";
                    cVar.c = str3;
                    em.b().p("plugin_load", "apk_file_null", str, str3);
                }
                om.h().s(str);
                cVar.a = false;
                return cVar;
            } else if (!assertApkFile()) {
                om.h().s(str);
                if (PluginPackageManager.p().t()) {
                    em.b().p("plugin_load", "apk_file_illegal", str, this.mPluginApkFile.getAbsolutePath());
                }
                cVar.a = false;
                cVar.b = "apk_file_illegal";
                return cVar;
            } else {
                createDataRoot();
                if (!this.mIsClassLoaderSucc) {
                    String str4 = Util.g() + "/oat/";
                    File file2 = new File(str4);
                    PluginSetting g2 = om.h().g(this.mPackageName);
                    if (g2 != null && (str2 = g2.apkPath) != null) {
                        int lastIndexOf = str2.lastIndexOf("/");
                        int lastIndexOf2 = g2.apkPath.lastIndexOf(Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                        int i = lastIndexOf + 1;
                        if (i < lastIndexOf2) {
                            String substring = g2.apkPath.substring(i, lastIndexOf2);
                            z3 = new File(Util.g() + "/" + substring + "/" + substring + ".dex").exists();
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
                                em.b().m("plugin_load", "plugin_dex_oat_null", str, "processName_" + mProcessName + "-newTime_" + createClassLoader.d);
                            } else if (z2 && !z) {
                                em.b().m("plugin_load", "plugin_oatfile_null", str, "processName_" + mProcessName + "-newTime_" + createClassLoader.d);
                            }
                            if (!createClassLoader.a) {
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
                        em.b().m("plugin_load", "plugin_oatfile_null", str, "processName_" + mProcessName + "-newTime_" + createClassLoader.d);
                    }
                    if (!createClassLoader.a) {
                    }
                }
                c createPluginResource = createPluginResource();
                if (createPluginResource.a) {
                    this.mManifest = new tl(this.mContext, this.mPluginApkFile, this.mPluginResource);
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
                        createPluginResource.a = true;
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
            PluginSetting g = om.h().g(this.mPackageName);
            if (g == null) {
                cVar.a = false;
                cVar.b = "settingnull";
                cVar.c = "createPluginResource";
                return cVar;
            } else if (g.isPatch) {
                this.mIsPluginResourceSucc = true;
                cVar.a = true;
                return cVar;
            } else if (g.isThird) {
                try {
                    AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                    vm.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{this.mPluginApkFile.getAbsolutePath()});
                    Resources resources = this.mContext.getResources();
                    this.mPluginResource = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    this.mIsPluginResourceSucc = true;
                    cVar.a = true;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                return cVar;
            } else {
                boolean z = g.hasRes;
                this.mPluginResource = this.mContext.getResources();
                if (BdBaseApplication.getInst().getIsPluginResourcOpen() && z) {
                    File file = this.mPluginApkFile;
                    if (file != null && !TextUtils.isEmpty(file.getAbsolutePath())) {
                        try {
                            d9.a().b(this.mPackageName, this.mPluginApkFile.getAbsolutePath());
                            this.mIsPluginResourceSucc = true;
                            cVar.a = true;
                            if ("com.baidu.tieba.pluginPhotoLive".equals(this.mPackageName)) {
                                try {
                                    d9.a().getResources().getIdentifier("photo_live_activity", TtmlNode.TAG_LAYOUT, BdBaseApplication.getInst().getPackageName());
                                } catch (Throwable th) {
                                    em.b().m("plugin_load", "photolive_res_fail", this.mPackageName, th.getMessage());
                                }
                            }
                            return cVar;
                        } catch (Error e2) {
                            cVar.b = "res_failed";
                            cVar.c = e2.getMessage();
                            cVar.a = false;
                            if (PluginPackageManager.p().t()) {
                                em.b().p("plugin_load", "res_failed", this.mPackageName, e2.getMessage());
                                em.b().g("plugin_res_inject_fail");
                            }
                        } catch (Exception e3) {
                            cVar.b = "res_failed";
                            cVar.c = e3.getMessage();
                            cVar.a = false;
                            if (PluginPackageManager.p().t()) {
                                em.b().p("plugin_load", "res_failed", this.mPackageName, e3.getMessage());
                                em.b().g("plugin_res_inject_fail");
                            }
                        }
                    }
                    return cVar;
                }
                this.mIsPluginResourceSucc = true;
                cVar.a = true;
                return cVar;
            }
        }
        return (c) invokeV.objValue;
    }

    private void createProviders() {
        tl tlVar;
        Object split;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (tlVar = this.mManifest) == null || tlVar.b() == null) {
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
            Object h = vm.h(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthorities");
            if (h != null) {
                split = vm.c(h, str.split(";"));
            } else {
                split = str.split(";");
            }
            vm.l(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthorities", split);
            vm.l(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthority", null);
        } catch (Exception e) {
            BdLog.e(e);
            em.b().p("plugin_install", "create_provider_failed", this.mPackageName, e.getMessage());
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
                    this.mStaticClassFiles.clear();
                    this.mStaticClassFiles = null;
                    if (sb != null) {
                        String str = this.mPackageName;
                        if (PluginPackageManager.p().t()) {
                            em.b().m("plugin_load", "init_static_failed", str, sb.toString());
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
            DexFile b2 = tm.b(classLoader);
            String str = null;
            if (b2 == null) {
                try {
                    b2 = DexFile.loadDex(this.mPluginApkFile.getAbsolutePath(), generateOutputName(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath()), 0);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    str = e.getMessage();
                }
            }
            if (b2 != null) {
                Enumeration<String> entries = b2.entries();
                if (entries != null) {
                    while (entries.hasMoreElements()) {
                        try {
                            addStaticClassToInitList(entries.nextElement());
                        } catch (Exception e2) {
                            if (PluginPackageManager.p().t()) {
                                em.b().p("plugin_load", "getdexfile_failed_reverse", this.mPackageName, e2.getMessage());
                            }
                            return false;
                        }
                    }
                    initStaticBlock();
                    return true;
                }
                if (PluginPackageManager.p().t()) {
                    em.b().p("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, str);
                }
                return false;
            }
            if (PluginPackageManager.p().t()) {
                em.b().p("plugin_load", "getdexfile_failed", this.mPackageName, str);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessageForPluginLoaded(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, this, str, i, str2) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000997, new PluginLoadedMessage.a(str, i, str2)));
        }
    }

    public void asyncInit(String str, um umVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, umVar) == null) {
            b bVar = this.mInitPluginTask;
            if (bVar != null) {
                bVar.cancel();
                this.mInitPluginTask = null;
            }
            b bVar2 = new b(this, str, umVar);
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

    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, context, intent, serviceConnection, i)) == null) {
            if (context != null && intent != null) {
                String className = intent.getComponent() != null ? intent.getComponent().getClassName() : null;
                if (TextUtils.isEmpty(className)) {
                    em.b().i("plugin_run_fail", this.mPackageName);
                    return false;
                }
                try {
                    Class<?> loadClass = this.mDexClassLoader.loadClass(className);
                    if (PluginBaseService.class.isAssignableFrom(loadClass) || PluginBaseRemoteService.class.isAssignableFrom(loadClass)) {
                        if (remapStartServiceIntent(intent, className, loadClass)) {
                            context.bindService(intent, serviceConnection, i);
                            return true;
                        }
                        em.b().i("plugin_run_fail", this.mPackageName);
                        BdLog.e("intent remap failed");
                    }
                    return false;
                } catch (Exception unused) {
                    em.b().i("plugin_run_fail", this.mPackageName);
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
            DexFile b2 = tm.b(this.mDexClassLoader);
            if (b2 == null) {
                try {
                    b2 = DexFile.loadDex(this.mPluginApkFile.getAbsolutePath(), generateOutputName(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath()), 0);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
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
        tl tlVar;
        PackageInfo c2;
        ServiceInfo[] serviceInfoArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (tlVar = this.mManifest) != null && (c2 = tlVar.c()) != null && (serviceInfoArr = c2.services) != null) {
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

    public tl getPluginManifest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mManifest : (tl) invokeV.objValue;
    }

    public PackageInfo getPluginPackageInfo() {
        InterceptResult invokeV;
        tl tlVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.mContext == null || this.mPluginApkFile == null || (tlVar = this.mManifest) == null) {
                return null;
            }
            return tlVar.c();
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
                em b2 = em.b();
                b2.m("plugin_load", "load_in_multithread", str, "curthread is main?" + String.valueOf(oi.B()));
            }
            int i = 1;
            this.isIniting = true;
            c cVar = new c();
            if (TextUtils.isEmpty(str)) {
                if (!BdBaseApplication.getInst().isDebugMode()) {
                    sendMessageForPluginLoaded(str, 2, null);
                    cVar.a = true;
                    cVar.b = "packageName is null";
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
                cVar.b = "plugin has loaded";
                cVar.a = true;
                return cVar;
            }
            PluginSetting g = om.h().g(this.mPackageName);
            if (g != null && g.isPatch && PluginPackageManager.p().r() > 0) {
                this.isIniting = false;
                cVar.a = true;
                return cVar;
            }
            initApplication();
            c createPlugin = createPlugin(str);
            if (PluginPackageManager.p().t() && createPlugin.a) {
                em.b().r("plugin_load", str);
            }
            if (!createPlugin.a) {
                sendMessageForPluginLoaded(str, 1, null);
                this.isIniting = false;
                return createPlugin;
            }
            if (PluginPackageManager.p().w() && g != null && g.isThird) {
                if (this.mManifest.e()) {
                    createProviders();
                } else {
                    createPlugin.a = false;
                    if (createPlugin.a && g != null) {
                        this.mVersionCode = g.versionCode;
                    }
                    sendMessageForPluginLoaded(str, i, null);
                    this.isIniting = false;
                    return createPlugin;
                }
            }
            i = 0;
            if (createPlugin.a) {
                this.mVersionCode = g.versionCode;
            }
            sendMessageForPluginLoaded(str, i, null);
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
                em.b().i("plugin_run_fail", this.mPackageName);
                return false;
            }
            try {
                Class<?> loadClass = this.mDexClassLoader.loadClass(className);
                if (this.mCurrentPluginMode == 0) {
                    if (!PluginBaseService.class.isAssignableFrom(loadClass) && !PluginBaseRemoteService.class.isAssignableFrom(loadClass)) {
                        if (remapStartActivityIntent(intent, className, loadClass)) {
                            if (!(context instanceof Activity) && intent != null) {
                                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                            }
                            context.startActivity(intent);
                            return true;
                        }
                        em.b().i("plugin_run_fail", this.mPackageName);
                        BdLog.e("intent remap failed");
                    } else if (remapStartServiceIntent(intent, className, loadClass)) {
                        context.startService(intent);
                        return true;
                    } else {
                        em.b().i("plugin_run_fail", this.mPackageName);
                        BdLog.e("intent remap failed");
                    }
                    return false;
                }
                intent.putExtra(INTENT_EXTRA_PACKAGE_NAME, this.mPackageName);
                if (Service.class.isAssignableFrom(loadClass)) {
                    context.startService(intent);
                } else {
                    if (!(context instanceof Activity) && intent != null) {
                        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    }
                    context.startActivity(intent);
                }
                return true;
            } catch (Exception e) {
                em.b().i("plugin_run_fail", this.mPackageName);
                BdLog.e(e);
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

    public void setVersionCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.mVersionCode = i;
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
            Class<?> b2 = ul.a().b(cls);
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
            Class<?> b2 = wl.a().b(cls);
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
