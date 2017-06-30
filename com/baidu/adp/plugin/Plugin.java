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
import com.baidu.adp.base.i;
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
import com.baidu.adp.plugin.util.PatchReplaceMethodHelper;
import com.baidu.adp.plugin.util.Util;
import com.baidu.adp.plugin.util.a;
import com.xiaomi.mipush.sdk.Constants;
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
    private Map<String, ContentProvider> mProviders;
    private ArrayList<String> mStaticClassFiles;
    private int mVersionCode;
    private boolean mIsClassLoaderSucc = false;
    private boolean mIsPluginResourceSucc = false;
    private long mLastLaunchTime = 0;
    private int mCurrentPluginMode = 0;
    private File mPluginApkFile = null;
    private ClassLoader mDexClassLoader = null;
    private Resources mPluginResource = null;
    private Application mApplication = null;
    private File mPluginDataRoot = null;
    private Object mStaticClassFielsLock = new Object();
    private a mInitPluginTask = null;
    private String mPackageName = null;
    private e mManifest = null;
    private boolean isIniting = false;
    private final Context mContext = BdBaseApplication.getInst().getApplicationContext();

    /* loaded from: classes.dex */
    public static class b {
        public boolean CB;
        public String CC;
        public String CD;
        public String reason;
    }

    public Plugin() {
        this.mStaticClassFiles = null;
        this.mProviders = null;
        this.mStaticClassFiles = new ArrayList<>();
        this.mProviders = new HashMap();
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void setVersionCode(int i) {
        this.mVersionCode = i;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public long getLastLaunchTime() {
        return this.mLastLaunchTime;
    }

    public File getPluginDataRoot() {
        return this.mPluginDataRoot;
    }

    public int getCurrentPluginMode() {
        return this.mCurrentPluginMode;
    }

    public String getPluginApkFilePath() {
        if (this.mPluginApkFile == null || !this.mPluginApkFile.exists()) {
            return null;
        }
        return this.mPluginApkFile.getAbsolutePath();
    }

    public String getPluginLibPath() {
        if (this.mPluginDataRoot == null || !this.mPluginDataRoot.exists()) {
            return null;
        }
        return new File(this.mPluginDataRoot, SO_LIB_DIR_NAME).getAbsolutePath();
    }

    public boolean isLoaded() {
        return this.mIsClassLoaderSucc && this.mIsPluginResourceSucc;
    }

    public ClassLoader getDexClassLoader() {
        return this.mDexClassLoader;
    }

    public Resources getPluginResources() {
        return this.mPluginResource;
    }

    public PackageInfo getPluginPackageInfo() {
        if (this.mContext == null || this.mPluginApkFile == null || this.mManifest == null) {
            return null;
        }
        return this.mManifest.getPluginPackageInfo();
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public int getActivityThemeResource() {
        return 16973829;
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
        asyncInit(str, new com.baidu.adp.plugin.a(this));
        return true;
    }

    public b initWithBroadcast(String str) {
        int i = 1;
        if (this.isIniting) {
            com.baidu.adp.plugin.b.a.jj().e("plugin_load", "load_in_multithread", str, "curthread is main?" + String.valueOf(k.hz()));
        }
        this.isIniting = true;
        b bVar = new b();
        bVar.CC = str;
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                this.isIniting = false;
                throw new IllegalArgumentException("Plugin asyncInitWithBroadcast args exception!");
            }
            sendMessageForPluginLoaded(str, 2, null);
            bVar.CB = true;
            bVar.reason = "packageName is null";
            this.isIniting = false;
            return bVar;
        }
        this.mPackageName = str;
        this.mLastLaunchTime = System.currentTimeMillis();
        if (isLoaded()) {
            this.isIniting = false;
            bVar.reason = "plugin has loaded";
            bVar.CB = true;
            return bVar;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(this.mPackageName);
        if (findPluginSetting != null && findPluginSetting.isPatch && PluginPackageManager.jw().jN() > 0) {
            this.isIniting = false;
            bVar.CB = true;
            return bVar;
        }
        initApplication();
        b createPlugin = createPlugin(str);
        if (PluginPackageManager.jw().isMainProcess() && createPlugin.CB) {
            com.baidu.adp.plugin.b.a.jj().A("plugin_load", str);
        }
        if (!createPlugin.CB) {
            sendMessageForPluginLoaded(str, 1, null);
            this.isIniting = false;
            return createPlugin;
        }
        if (!PluginPackageManager.jw().jI() || findPluginSetting == null || !findPluginSetting.isThird) {
            i = 0;
        } else if (this.mManifest.iL()) {
            createProviders();
            i = 0;
        } else {
            createPlugin.CB = false;
        }
        if (createPlugin.CB && findPluginSetting != null) {
            this.mVersionCode = findPluginSetting.versionCode;
        }
        sendMessageForPluginLoaded(str, i, null);
        this.isIniting = false;
        return createPlugin;
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

    public void asyncInit(String str, com.baidu.adp.plugin.util.e eVar) {
        if (this.mInitPluginTask != null) {
            this.mInitPluginTask.cancel();
            this.mInitPluginTask = null;
        }
        this.mInitPluginTask = new a(str, eVar);
        this.mInitPluginTask.execute(new String[0]);
    }

    public boolean launchIntent(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        String str = null;
        if (intent.getComponent() != null) {
            str = intent.getComponent().getClassName();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.b.a.jj().B("plugin_run_fail", this.mPackageName);
            return false;
        }
        try {
            Class<?> loadClass = this.mDexClassLoader.loadClass(str);
            if (this.mCurrentPluginMode == 0) {
                if (PluginBaseService.class.isAssignableFrom(loadClass) || PluginBaseRemoteService.class.isAssignableFrom(loadClass)) {
                    if (remapStartServiceIntent(intent, str, loadClass)) {
                        context.startService(intent);
                        return true;
                    }
                    com.baidu.adp.plugin.b.a.jj().B("plugin_run_fail", this.mPackageName);
                    BdLog.e("intent remap failed");
                } else if (remapStartActivityIntent(intent, str, loadClass)) {
                    context.startActivity(intent);
                    return true;
                } else {
                    com.baidu.adp.plugin.b.a.jj().B("plugin_run_fail", this.mPackageName);
                    BdLog.e("intent remap failed");
                }
                return false;
            }
            intent.putExtra(INTENT_EXTRA_PACKAGE_NAME, this.mPackageName);
            if (Service.class.isAssignableFrom(loadClass)) {
                context.startService(intent);
            } else {
                context.startActivity(intent);
            }
            return true;
        } catch (Exception e) {
            com.baidu.adp.plugin.b.a.jj().B("plugin_run_fail", this.mPackageName);
            BdLog.e(e);
            return false;
        }
    }

    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        if (context == null || intent == null) {
            return false;
        }
        String str = null;
        if (intent.getComponent() != null) {
            str = intent.getComponent().getClassName();
        }
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.b.a.jj().B("plugin_run_fail", this.mPackageName);
            return false;
        }
        try {
            Class<?> loadClass = this.mDexClassLoader.loadClass(str);
            if (PluginBaseService.class.isAssignableFrom(loadClass) || PluginBaseRemoteService.class.isAssignableFrom(loadClass)) {
                if (remapStartServiceIntent(intent, str, loadClass)) {
                    context.bindService(intent, serviceConnection, i);
                    return true;
                }
                com.baidu.adp.plugin.b.a.jj().B("plugin_run_fail", this.mPackageName);
                BdLog.e("intent remap failed");
            }
            return false;
        } catch (Exception e) {
            com.baidu.adp.plugin.b.a.jj().B("plugin_run_fail", this.mPackageName);
            return false;
        }
    }

    public ContentProvider getContentProvider(String str) {
        if (TextUtils.isEmpty(str) || this.mProviders.isEmpty()) {
            return null;
        }
        return this.mProviders.get(str);
    }

    public e getPluginManifest() {
        return this.mManifest;
    }

    public ServiceInfo findServiceInfo(String str) {
        ServiceInfo[] serviceInfoArr;
        if (TextUtils.isEmpty(str) || this.mManifest == null) {
            return null;
        }
        PackageInfo pluginPackageInfo = this.mManifest.getPluginPackageInfo();
        if (pluginPackageInfo == null || pluginPackageInfo.services == null) {
            return null;
        }
        for (ServiceInfo serviceInfo : pluginPackageInfo.services) {
            if (str.equals(serviceInfo.name)) {
                return serviceInfo;
            }
        }
        return null;
    }

    public void destroy() {
        if (this.mIsClassLoaderSucc && this.mIsPluginResourceSucc && this.mApplication != null) {
            this.mApplication.onTerminate();
        }
    }

    public boolean remapStartServiceIntent(Intent intent) {
        String className;
        ServiceInfo aR;
        if (intent == null) {
            return false;
        }
        if (intent.getComponent() == null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || (aR = this.mManifest.aR(action)) == null || TextUtils.isEmpty(aR.name)) {
                return false;
            }
            className = aR.name;
        } else {
            className = intent.getComponent().getClassName();
        }
        return remapStartServiceIntent(intent, className, null);
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
            for (Map.Entry<String, IntentFilter> entry : this.mManifest.iJ().entrySet()) {
                if (entry.getValue().hasAction(action)) {
                    str = String.valueOf(str) + "#" + entry.getKey();
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

    /* JADX WARN: Removed duplicated region for block: B:6:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean containssClass(String str) {
        DexFile loadDex;
        DexFile a2 = com.baidu.adp.plugin.util.d.a(this.mDexClassLoader);
        if (a2 == null) {
            try {
                loadDex = DexFile.loadDex(this.mPluginApkFile.getAbsolutePath(), generateOutputName(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath()), 0);
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
        loadDex = a2;
        if (loadDex != null) {
        }
        return false;
    }

    private boolean remapStartActivityIntent(Intent intent, String str, Class<?> cls) {
        intent.putExtra(INTENT_EXTRA_ACTIVITY, str);
        intent.putExtra(INTENT_EXTRA_PACKAGE_NAME, this.mPackageName);
        if (cls == null) {
            try {
                cls = this.mDexClassLoader.loadClass(str);
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> g = f.iM().g(cls);
        if (g != null) {
            intent.setClass(this.mContext, g);
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
            } catch (Exception e) {
                return false;
            }
        }
        Class<?> h = h.iP().h(cls);
        if (h != null) {
            intent.setClass(this.mContext, h);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessageForPluginLoaded(String str, int i, String str2) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000997, new PluginLoadedMessage.a(str, i, str2)));
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
                    } catch (ClassNotFoundException e) {
                        BdLog.e(e);
                        if (sb == null) {
                            sb = new StringBuilder();
                        }
                        sb.append(next);
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        sb.append(e.getMessage());
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                this.mStaticClassFiles.clear();
                this.mStaticClassFiles = null;
                if (sb != null) {
                    String str = this.mPackageName;
                    if (PluginPackageManager.jw().isMainProcess()) {
                        com.baidu.adp.plugin.b.a.jj().e("plugin_load", "init_static_failed", str, sb.toString());
                    }
                    return false;
                }
            }
            return true;
        }
    }

    private b createPluginResource() {
        b bVar = new b();
        bVar.CC = this.mPackageName;
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(this.mPackageName);
        if (findPluginSetting == null) {
            bVar.CB = false;
            bVar.reason = "settingnull";
            bVar.CD = "createPluginResource";
            return bVar;
        } else if (findPluginSetting.isPatch) {
            this.mIsPluginResourceSucc = true;
            bVar.CB = true;
            return bVar;
        } else if (findPluginSetting.isThird) {
            try {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                com.baidu.adp.plugin.util.f.c(assetManager, "addAssetPath", new Object[]{this.mPluginApkFile.getAbsolutePath()});
                Resources resources = this.mContext.getResources();
                this.mPluginResource = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                this.mIsPluginResourceSucc = true;
                bVar.CB = true;
            } catch (Exception e) {
                BdLog.e(e);
            }
            return bVar;
        } else {
            boolean z = findPluginSetting.hasRes;
            this.mPluginResource = this.mContext.getResources();
            if (BdBaseApplication.getInst().getIsPluginResourcOpen() && z) {
                if (this.mPluginApkFile != null && !TextUtils.isEmpty(this.mPluginApkFile.getAbsolutePath())) {
                    try {
                        i.cg().g(this.mPackageName, this.mPluginApkFile.getAbsolutePath());
                        this.mIsPluginResourceSucc = true;
                        bVar.CB = true;
                        if ("com.baidu.tieba.pluginPhotoLive".equals(this.mPackageName)) {
                            i.cg().getResources().getIdentifier("photo_live_activity", "layout", BdBaseApplication.getInst().getPackageName());
                        }
                        return bVar;
                    } catch (Error e2) {
                        bVar.reason = "res_failed";
                        bVar.CD = e2.getMessage();
                        bVar.CB = false;
                        if (PluginPackageManager.jw().isMainProcess()) {
                            com.baidu.adp.plugin.b.a.jj().f("plugin_load", "res_failed", this.mPackageName, e2.getMessage());
                            com.baidu.adp.plugin.b.a.jj().ba("plugin_res_inject_fail");
                        }
                    } catch (Exception e3) {
                        bVar.reason = "res_failed";
                        bVar.CD = e3.getMessage();
                        bVar.CB = false;
                        if (PluginPackageManager.jw().isMainProcess()) {
                            com.baidu.adp.plugin.b.a.jj().f("plugin_load", "res_failed", this.mPackageName, e3.getMessage());
                            com.baidu.adp.plugin.b.a.jj().ba("plugin_res_inject_fail");
                        }
                    }
                }
                return bVar;
            }
            this.mIsPluginResourceSucc = true;
            bVar.CB = true;
            return bVar;
        }
    }

    private boolean assertApkFile() {
        return this.mPluginApkFile.isFile() && this.mPluginApkFile.getName().endsWith(".apk");
    }

    private void createDataRoot() {
        try {
            this.mPluginDataRoot = Util.bB(this.mPackageName);
            this.mPluginDataRoot.mkdirs();
        } catch (Exception e) {
            BdLog.e(e);
            if (PluginPackageManager.jw().isMainProcess()) {
                com.baidu.adp.plugin.b.a.jj().f("plugin_load", "createdataroot_failed", this.mPackageName, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
            }
        }
    }

    private b createClassLoader() {
        boolean z;
        String str;
        b bVar = new b();
        bVar.CC = this.mPackageName;
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(this.mPackageName);
        if (findPluginSetting == null) {
            bVar.CB = false;
            bVar.reason = "settingnull";
            bVar.CD = "createClassLoader";
            return bVar;
        }
        try {
            if (this.mPluginDataRoot == null || !this.mPluginDataRoot.exists()) {
                createDataRoot();
            }
            ClassLoader classLoader = this.mContext.getClassLoader();
            if (findPluginSetting.isThird) {
                this.mDexClassLoader = new d(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath(), getPluginLibPath(), classLoader.getParent(), classLoader);
            } else {
                this.mDexClassLoader = new DexClassLoader(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath(), getPluginLibPath(), classLoader);
            }
            try {
                if (this.mDexClassLoader != null) {
                    this.mDexClassLoader.loadClass(String.valueOf(this.mPackageName) + ".Static");
                    z = true;
                } else {
                    z = true;
                }
            } catch (ClassNotFoundException e) {
                bVar.reason = "loadR";
                bVar.CD = e.getMessage();
                if (PluginPackageManager.jw().isMainProcess()) {
                    com.baidu.adp.plugin.b.a.jj().f("plugin_load", "loadR", this.mPackageName, e.getMessage());
                }
                BdLog.e(e);
                z = false;
            } catch (Throwable th) {
                bVar.reason = "loadR2";
                bVar.CD = String.valueOf(th.getMessage()) + "---" + th.getClass().getName();
                if (PluginPackageManager.jw().isMainProcess()) {
                    com.baidu.adp.plugin.b.a.jj().f("plugin_load", "loadR2", this.mPackageName, String.valueOf(th.getMessage()) + "---" + th.getClass().getName());
                }
                BdLog.e(th);
                z = false;
            }
            if (PluginPackageManager.jw().isMainProcess() && !z) {
                com.baidu.adp.plugin.b.a.jj().ba("plugin_class_notfind");
            }
            if (!z) {
                bVar.CB = false;
                return bVar;
            }
            if (findPluginSetting.isPatch) {
                this.mCurrentPluginMode = 1;
                if (TextUtils.isEmpty(findPluginSetting.replaceMethodClasses)) {
                    ClassLoader classLoader2 = this.mContext.getClassLoader();
                    while (!(classLoader2 instanceof PathClassLoader)) {
                        classLoader2 = classLoader2.getParent();
                    }
                    a.C0011a a2 = com.baidu.adp.plugin.util.a.a(classLoader2, this.mDexClassLoader, String.valueOf(this.mPackageName) + ".Static", false, this.mPluginApkFile.getAbsolutePath());
                    if (a2 == null || !a2.Fp) {
                        com.baidu.adp.plugin.b.a.jj().f("plugin_load", "createClassLoader_failed", this.mPackageName, "patch apk inject failed!" + a2.mErrMsg);
                        bVar.CB = false;
                        bVar.reason = "patchClassLoaderInject_failed";
                        bVar.CD = "inject failed, patch failed!";
                        return bVar;
                    }
                } else if (Build.VERSION.SDK_INT > 23 || (Util.ki() && Build.VERSION.SDK_INT < 21)) {
                    bVar.CB = true;
                    com.baidu.adp.plugin.b.a.jj().f("plugin_load", "create_patch_classloader_error", this.mPackageName, "system not support!");
                } else if (PluginNative.bLoadLibrary) {
                    bVar.CB = PluginNative.replaceInit(Util.ki(), Build.VERSION.SDK_INT);
                    if (bVar.CB) {
                        bVar.CB = PatchReplaceMethodHelper.loadPatch(this, this.mContext, generateOutputName(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath()));
                    }
                    if (!bVar.CB) {
                        bVar.reason = "patch method replace failed";
                        bVar.CD = "patch replace failed!!";
                        com.baidu.adp.plugin.b.a.jj().f("plugin_load", "create_patch_classloader_error", this.mPackageName, bVar.reason);
                        return bVar;
                    }
                } else {
                    bVar.CB = false;
                    bVar.reason = "replace lib load failed!";
                    bVar.CD = "patch replace failed!!";
                    com.baidu.adp.plugin.b.a.jj().f("plugin_load", "create_patch_classloader_error", this.mPackageName, bVar.reason);
                    return bVar;
                }
            }
            if (findPluginSetting.isInjectClassloader()) {
                ClassLoader classLoader3 = this.mContext.getClassLoader();
                while (!(classLoader3 instanceof PathClassLoader)) {
                    classLoader3 = classLoader3.getParent();
                }
                this.mCurrentPluginMode = 1;
                a.C0011a a3 = com.baidu.adp.plugin.util.a.a(classLoader3, this.mDexClassLoader, String.valueOf(this.mPackageName) + ".Static", true, this.mPluginApkFile.getAbsolutePath());
                if (a3 != null && !a3.Fp) {
                    if (PluginPackageManager.jw().isMainProcess()) {
                        com.baidu.adp.plugin.b.a.jj().ba("plugin_inject_failed");
                    }
                    bVar.reason = "inject_failed";
                    bVar.CD = a3.mErrMsg;
                    com.baidu.adp.plugin.b.a.jj().f("plugin_load", "inject_failed", this.mPackageName, a3.mErrMsg);
                    this.mCurrentPluginMode = 2;
                    String str2 = "";
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
                    if (sb.length() > 0) {
                        str2 = sb.substring(0, sb.length() - 1);
                    }
                    if (sb2.length() <= 0) {
                        str = "";
                    } else {
                        str = sb2.substring(0, sb2.length() - 1);
                    }
                    a.C0011a a4 = com.baidu.adp.plugin.util.a.a(this.mContext, new DexClassLoader(str2, this.mPluginDataRoot.getAbsolutePath(), str, classLoader3), String.valueOf(this.mPackageName) + ".Static");
                    if (a4 != null && !a4.Fp) {
                        if (PluginPackageManager.jw().isMainProcess()) {
                            com.baidu.adp.plugin.b.a.jj().f("plugin_load", "replaceparent_failed", this.mPackageName, a4.mErrMsg);
                        }
                        bVar.CB = false;
                        bVar.reason = "replaceparent_failed";
                        bVar.CD = a4.mErrMsg;
                        return bVar;
                    } else if (a4 != null && a4.Fp) {
                        com.baidu.adp.plugin.b.a.jj().ba("plugin_second_inject_succ");
                    }
                }
            }
            this.mIsClassLoaderSucc = true;
            bVar.CB = true;
            return bVar;
        } catch (Exception e2) {
            BdLog.e(e2);
            bVar.CB = false;
            bVar.reason = "new_dexloader_failed";
            bVar.CD = String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName();
            if (PluginPackageManager.jw().isMainProcess()) {
                com.baidu.adp.plugin.b.a.jj().f("plugin_load", "new_dexloader_failed", this.mPackageName, String.valueOf(e2.getMessage()) + "---" + e2.getClass().getName());
            }
            return bVar;
        }
    }

    private void createProviders() {
        Object split;
        if (this.mManifest != null && this.mManifest.iK() != null) {
            try {
                Iterator<Map.Entry<String, ProviderInfo>> it = this.mManifest.iK().entrySet().iterator();
                if (it != null) {
                    String str = ContentProviderProxy.PROVIDER_AUTHOR;
                    while (it.hasNext()) {
                        ProviderInfo value = it.next().getValue();
                        if (!TextUtils.isEmpty(value.authority) && !this.mProviders.containsKey(value.authority)) {
                            if (Build.VERSION.SDK_INT >= 21) {
                                str = String.valueOf(str) + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + value.authority;
                            }
                            ContentProvider contentProvider = (ContentProvider) this.mDexClassLoader.loadClass(value.name).newInstance();
                            contentProvider.attachInfo(this.mApplication, value);
                            this.mProviders.put(value.authority, contentProvider);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 21 && ContentProviderProxy.getInstance() != null) {
                        Object a2 = com.baidu.adp.plugin.util.f.a(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthorities");
                        if (a2 != null) {
                            split = com.baidu.adp.plugin.util.f.d(a2, str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
                        } else {
                            split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                        }
                        com.baidu.adp.plugin.util.f.a(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthorities", split);
                        com.baidu.adp.plugin.util.f.a(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthority", (Object) null);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
                com.baidu.adp.plugin.b.a.jj().f("plugin_install", "create_provider_failed", this.mPackageName, e.getMessage());
            }
        }
    }

    private boolean loadStaticClasses() {
        if (this.mDexClassLoader == null) {
            return false;
        }
        DexFile a2 = com.baidu.adp.plugin.util.d.a(this.mDexClassLoader);
        String str = null;
        if (a2 == null) {
            try {
                a2 = DexFile.loadDex(this.mPluginApkFile.getAbsolutePath(), generateOutputName(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath()), 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                str = e.getMessage();
            }
        }
        if (a2 != null) {
            Enumeration<String> entries = a2.entries();
            if (entries != null) {
                while (entries.hasMoreElements()) {
                    try {
                        addStaticClassToInitList(entries.nextElement());
                    } catch (Exception e2) {
                        if (PluginPackageManager.jw().isMainProcess()) {
                            com.baidu.adp.plugin.b.a.jj().f("plugin_load", "getdexfile_failed_reverse", this.mPackageName, e2.getMessage());
                        }
                        return false;
                    }
                }
                initStaticBlock();
                return true;
            }
            if (PluginPackageManager.jw().isMainProcess()) {
                com.baidu.adp.plugin.b.a.jj().f("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, str);
            }
            return false;
        }
        if (PluginPackageManager.jw().isMainProcess()) {
            com.baidu.adp.plugin.b.a.jj().f("plugin_load", "getdexfile_failed", this.mPackageName, str);
        }
        return false;
    }

    private static String generateOutputName(String str, String str2) {
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
        if (this.mApplication == null) {
            PluginBaseApplication pluginBaseApplication = new PluginBaseApplication();
            pluginBaseApplication.setApplicationProxy((Application) this.mContext);
            pluginBaseApplication.setPluginPackageName(this.mPackageName);
            pluginBaseApplication.onCreate();
            this.mApplication = pluginBaseApplication;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Object, b> {
        private com.baidu.adp.plugin.util.e CA;
        private String packageName;

        public a(String str, com.baidu.adp.plugin.util.e eVar) {
            this.packageName = null;
            this.CA = null;
            this.packageName = str;
            this.CA = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public b doInBackground(String... strArr) {
            return Plugin.this.createPlugin(this.packageName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(b bVar) {
            super.onPostExecute(bVar);
            if (this.CA != null) {
                this.CA.a(bVar, this.packageName);
            } else {
                BdLog.e("listener is null");
                if (PluginPackageManager.jw().isMainProcess()) {
                    com.baidu.adp.plugin.b.a.jj().f("plugin_load", "listener_null", this.packageName);
                }
            }
            if (bVar.CB) {
                Plugin.this.initStaticBlock();
                Plugin.this.initApplication();
                Plugin.this.sendMessageForPluginLoaded(this.packageName, 0, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b createPlugin(String str) {
        Object invoke;
        PluginSetting findPluginSetting;
        String str2;
        b bVar = new b();
        bVar.CC = str;
        this.mPluginApkFile = com.baidu.adp.plugin.install.c.aX(str);
        if (this.mPluginApkFile == null) {
            if (PluginPackageManager.jw().isMainProcess()) {
                if (com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting(str) != null) {
                    str2 = "-versioncode-" + findPluginSetting.versionCode + "-enable-" + findPluginSetting.enable + "-forbid-" + findPluginSetting.forbidden + "-installstatus-" + findPluginSetting.installStatus + "-url-" + findPluginSetting.url + "-size-" + findPluginSetting.size + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path();
                } else {
                    str2 = "settingssize-" + com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().jV().getPlugins().size() + "-filesize-" + new File(com.baidu.adp.plugin.packageManager.pluginSettings.b.jU().jX()).length();
                }
                bVar.reason = "apk_file_null";
                bVar.CD = str2;
                com.baidu.adp.plugin.b.a.jj().f("plugin_load", "apk_file_null", str, str2);
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().bw(str);
            bVar.CB = false;
            return bVar;
        } else if (!assertApkFile()) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().bw(str);
            if (PluginPackageManager.jw().isMainProcess()) {
                com.baidu.adp.plugin.b.a.jj().f("plugin_load", "apk_file_illegal", str, this.mPluginApkFile.getAbsolutePath());
            }
            bVar.CB = false;
            bVar.reason = "apk_file_illegal";
            return bVar;
        } else {
            createDataRoot();
            if (!this.mIsClassLoaderSucc) {
                b createClassLoader = createClassLoader();
                if (!createClassLoader.CB) {
                    return createClassLoader;
                }
            }
            b createPluginResource = createPluginResource();
            if (createPluginResource.CB) {
                this.mManifest = new e(this.mContext, this.mPluginApkFile, this.mPluginResource);
                try {
                    Class<?> cls = Class.forName(String.valueOf(this.mPackageName) + ".PluginStaticClassesArray", true, this.mDexClassLoader);
                    invoke = cls.getDeclaredMethod("getStaticClasses", new Class[0]).invoke(cls, new Object[0]);
                } catch (Throwable th) {
                    synchronized (this.mStaticClassFielsLock) {
                        this.mStaticClassFiles = new ArrayList<>();
                        loadStaticClasses();
                    }
                }
                if (invoke instanceof String[]) {
                    for (String str3 : (String[]) invoke) {
                        addStaticClassToInitList(str3);
                    }
                    if (!initStaticBlock()) {
                        throw new RuntimeException();
                    }
                    createPluginResource.CB = true;
                    return createPluginResource;
                }
                throw new RuntimeException();
            }
            return createPluginResource;
        }
    }

    private void addStaticClassToInitList(String str) {
        if (!TextUtils.isEmpty(str) && str.endsWith(u.SUFFIX) && this.mStaticClassFiles != null && !PluginPackageManager.jw().isFeatureForbidden(str)) {
            synchronized (this.mStaticClassFielsLock) {
                this.mStaticClassFiles.add(str);
            }
        }
    }
}
