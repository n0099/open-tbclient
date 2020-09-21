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
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.lib.util.t;
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
import com.baidu.live.adp.framework.MessageConfig;
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
    public static String mProcessName;
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
    private com.baidu.adp.plugin.b mManifest = null;
    private boolean isIniting = false;
    private final Context mContext = BdBaseApplication.getInst().getApplicationContext();

    /* loaded from: classes.dex */
    public static class b {
        public String Rt;
        public boolean isSucc;
        public String pkgName;
        public String reason;
        public long time;
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
        return new File(this.mPluginDataRoot, "lib").getAbsolutePath();
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
        asyncInit(str, new com.baidu.adp.plugin.util.c() { // from class: com.baidu.adp.plugin.Plugin.1
            @Override // com.baidu.adp.plugin.util.c
            public void a(b bVar, String str2) {
                if (PluginPackageManager.pT().isMainProcess()) {
                    if (bVar.isSucc) {
                        com.baidu.adp.plugin.b.a.pD().D("plugin_load", str2);
                    } else {
                        com.baidu.adp.plugin.b.a.pD().log("plugin_loaded_failed");
                    }
                }
            }
        });
        return true;
    }

    public b initWithBroadcast(String str) {
        int i = 1;
        if (this.isIniting) {
            com.baidu.adp.plugin.b.a.pD().f("plugin_load", "load_in_multithread", str, "curthread is main?" + String.valueOf(l.isMainThread()));
        }
        this.isIniting = true;
        b bVar = new b();
        bVar.pkgName = str;
        if (TextUtils.isEmpty(str)) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                this.isIniting = false;
                throw new IllegalArgumentException("Plugin asyncInitWithBroadcast args exception!");
            }
            sendMessageForPluginLoaded(str, 2, null);
            bVar.isSucc = true;
            bVar.reason = "packageName is null";
            this.isIniting = false;
            return bVar;
        }
        this.mPackageName = str;
        this.mLastLaunchTime = System.currentTimeMillis();
        if (isLoaded()) {
            this.isIniting = false;
            bVar.reason = "plugin has loaded";
            bVar.isSucc = true;
            return bVar;
        }
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.qv().findPluginSetting(this.mPackageName);
        if (findPluginSetting != null && findPluginSetting.isPatch && PluginPackageManager.pT().qk() > 0) {
            this.isIniting = false;
            bVar.isSucc = true;
            return bVar;
        }
        initApplication();
        b createPlugin = createPlugin(str);
        if (PluginPackageManager.pT().isMainProcess() && createPlugin.isSucc) {
            com.baidu.adp.plugin.b.a.pD().D("plugin_load", str);
        }
        if (!createPlugin.isSucc) {
            sendMessageForPluginLoaded(str, 1, null);
            this.isIniting = false;
            return createPlugin;
        }
        if (!PluginPackageManager.pT().qf() || findPluginSetting == null || !findPluginSetting.isThird) {
            i = 0;
        } else if (this.mManifest.pg()) {
            createProviders();
            i = 0;
        } else {
            createPlugin.isSucc = false;
        }
        if (createPlugin.isSucc && findPluginSetting != null) {
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

    public void asyncInit(String str, com.baidu.adp.plugin.util.c cVar) {
        if (this.mInitPluginTask != null) {
            this.mInitPluginTask.cancel();
            this.mInitPluginTask = null;
        }
        this.mInitPluginTask = new a(str, cVar);
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
            com.baidu.adp.plugin.b.a.pD().E("plugin_run_fail", this.mPackageName);
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
                    com.baidu.adp.plugin.b.a.pD().E("plugin_run_fail", this.mPackageName);
                    BdLog.e("intent remap failed");
                } else if (remapStartActivityIntent(intent, str, loadClass)) {
                    if (!(context instanceof Activity) && intent != null) {
                        intent.addFlags(268435456);
                    }
                    context.startActivity(intent);
                    return true;
                } else {
                    com.baidu.adp.plugin.b.a.pD().E("plugin_run_fail", this.mPackageName);
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
        } catch (Exception e) {
            com.baidu.adp.plugin.b.a.pD().E("plugin_run_fail", this.mPackageName);
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
            com.baidu.adp.plugin.b.a.pD().E("plugin_run_fail", this.mPackageName);
            return false;
        }
        try {
            Class<?> loadClass = this.mDexClassLoader.loadClass(str);
            if (PluginBaseService.class.isAssignableFrom(loadClass) || PluginBaseRemoteService.class.isAssignableFrom(loadClass)) {
                if (remapStartServiceIntent(intent, str, loadClass)) {
                    context.bindService(intent, serviceConnection, i);
                    return true;
                }
                com.baidu.adp.plugin.b.a.pD().E("plugin_run_fail", this.mPackageName);
                BdLog.e("intent remap failed");
            }
            return false;
        } catch (Exception e) {
            com.baidu.adp.plugin.b.a.pD().E("plugin_run_fail", this.mPackageName);
            return false;
        }
    }

    public ContentProvider getContentProvider(String str) {
        if (TextUtils.isEmpty(str) || this.mProviders.isEmpty()) {
            return null;
        }
        return this.mProviders.get(str);
    }

    public com.baidu.adp.plugin.b getPluginManifest() {
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
        ServiceInfo cl;
        if (intent == null) {
            return false;
        }
        if (intent.getComponent() == null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || (cl = this.mManifest.cl(action)) == null || TextUtils.isEmpty(cl.name)) {
                return false;
            }
            className = cl.name;
        } else {
            className = intent.getComponent().getClassName();
        }
        return remapStartServiceIntent(intent, className, null);
    }

    public boolean remapBroadcastReceiver(Intent intent) {
        String className;
        String str = "";
        if (intent == null) {
            return false;
        }
        if (intent.getComponent() == null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return false;
            }
            for (Map.Entry<String, IntentFilter> entry : this.mManifest.pe().entrySet()) {
                str = entry.getValue().hasAction(action) ? str + "#" + entry.getKey() : str;
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
        DexFile a2 = com.baidu.adp.plugin.util.b.a(this.mDexClassLoader);
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
        Class<?> n = c.ph().n(cls);
        if (n != null) {
            intent.setClass(this.mContext, n);
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
        Class<?> o = e.pk().o(cls);
        if (o != null) {
            intent.setClass(this.mContext, o);
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
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(MessageConfig.PLUGIN_LOADED, new PluginLoadedMessage.a(str, i, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initStaticBlock() {
        StringBuilder sb;
        StringBuilder sb2 = null;
        synchronized (this.mStaticClassFielsLock) {
            if (this.mStaticClassFiles != null && this.mStaticClassFiles.size() > 0) {
                Iterator<String> it = this.mStaticClassFiles.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    try {
                        Class.forName(next, true, this.mDexClassLoader);
                        sb = sb2;
                    } catch (ClassNotFoundException e) {
                        BdLog.e(e);
                        if (sb2 == null) {
                            sb2 = new StringBuilder();
                        }
                        sb2.append(next);
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        sb2.append(e.getMessage());
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        sb = sb2;
                    } catch (Throwable th) {
                        BdLog.e(th);
                        if (sb2 == null) {
                            sb2 = new StringBuilder();
                        }
                        sb2.append(next);
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        sb2.append(th.getMessage());
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        sb = sb2;
                    }
                    sb2 = sb;
                }
                this.mStaticClassFiles.clear();
                this.mStaticClassFiles = null;
                if (sb2 != null) {
                    String str = this.mPackageName;
                    if (PluginPackageManager.pT().isMainProcess()) {
                        com.baidu.adp.plugin.b.a.pD().f("plugin_load", "init_static_failed", str, sb2.toString());
                    }
                    return false;
                }
            }
            return true;
        }
    }

    private b createPluginResource() {
        b bVar = new b();
        bVar.pkgName = this.mPackageName;
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.qv().findPluginSetting(this.mPackageName);
        if (findPluginSetting == null) {
            bVar.isSucc = false;
            bVar.reason = "settingnull";
            bVar.Rt = "createPluginResource";
            return bVar;
        } else if (findPluginSetting.isPatch) {
            this.mIsPluginResourceSucc = true;
            bVar.isSucc = true;
            return bVar;
        } else if (findPluginSetting.isThird) {
            try {
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                com.baidu.adp.plugin.util.d.callMethod(assetManager, "addAssetPath", new Object[]{this.mPluginApkFile.getAbsolutePath()});
                Resources resources = this.mContext.getResources();
                this.mPluginResource = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                this.mIsPluginResourceSucc = true;
                bVar.isSucc = true;
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
                        g.lh().r(this.mPackageName, this.mPluginApkFile.getAbsolutePath());
                        this.mIsPluginResourceSucc = true;
                        bVar.isSucc = true;
                        if ("com.baidu.tieba.pluginPhotoLive".equals(this.mPackageName)) {
                            try {
                                g.lh().getResources().getIdentifier("photo_live_activity", "layout", BdBaseApplication.getInst().getPackageName());
                            } catch (Throwable th) {
                                com.baidu.adp.plugin.b.a.pD().f("plugin_load", "photolive_res_fail", this.mPackageName, th.getMessage());
                            }
                        }
                        return bVar;
                    } catch (Error e2) {
                        bVar.reason = "res_failed";
                        bVar.Rt = e2.getMessage();
                        bVar.isSucc = false;
                        if (PluginPackageManager.pT().isMainProcess()) {
                            com.baidu.adp.plugin.b.a.pD().h("plugin_load", "res_failed", this.mPackageName, e2.getMessage());
                            com.baidu.adp.plugin.b.a.pD().log("plugin_res_inject_fail");
                        }
                    } catch (Exception e3) {
                        bVar.reason = "res_failed";
                        bVar.Rt = e3.getMessage();
                        bVar.isSucc = false;
                        if (PluginPackageManager.pT().isMainProcess()) {
                            com.baidu.adp.plugin.b.a.pD().h("plugin_load", "res_failed", this.mPackageName, e3.getMessage());
                            com.baidu.adp.plugin.b.a.pD().log("plugin_res_inject_fail");
                        }
                    }
                }
                return bVar;
            }
            this.mIsPluginResourceSucc = true;
            bVar.isSucc = true;
            return bVar;
        }
    }

    private boolean assertApkFile() {
        return this.mPluginApkFile.isFile() && this.mPluginApkFile.getName().endsWith(".apk");
    }

    private void createDataRoot() {
        try {
            this.mPluginDataRoot = Util.cT(this.mPackageName);
            this.mPluginDataRoot.mkdirs();
        } catch (Exception e) {
            BdLog.e(e);
            if (PluginPackageManager.pT().isMainProcess()) {
                com.baidu.adp.plugin.b.a.pD().h("plugin_load", "createdataroot_failed", this.mPackageName, e.getMessage() + "---" + e.getClass().getName());
            }
        }
    }

    private b createClassLoader() {
        boolean z;
        String str;
        b bVar = new b();
        bVar.pkgName = this.mPackageName;
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.qv().findPluginSetting(this.mPackageName);
        if (findPluginSetting == null) {
            bVar.isSucc = false;
            bVar.reason = "settingnull";
            bVar.Rt = "createClassLoader";
            return bVar;
        }
        try {
            if (this.mPluginDataRoot == null || !this.mPluginDataRoot.exists()) {
                createDataRoot();
            }
            ClassLoader classLoader = this.mContext.getClassLoader();
            long currentTimeMillis = System.currentTimeMillis();
            if (findPluginSetting.isThird) {
                this.mDexClassLoader = new com.baidu.adp.plugin.a(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath(), getPluginLibPath(), classLoader.getParent(), classLoader);
            } else {
                this.mDexClassLoader = new DexClassLoader(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath(), getPluginLibPath(), classLoader);
            }
            bVar.time = System.currentTimeMillis() - currentTimeMillis;
            try {
                if (this.mDexClassLoader != null) {
                    this.mDexClassLoader.loadClass(this.mPackageName + ".Static");
                }
                z = true;
            } catch (ClassNotFoundException e) {
                bVar.reason = "loadR";
                bVar.Rt = e.getMessage();
                if (PluginPackageManager.pT().isMainProcess()) {
                    com.baidu.adp.plugin.b.a.pD().h("plugin_load", "loadR", this.mPackageName, e.getMessage());
                }
                BdLog.e(e);
                z = false;
            }
            if (PluginPackageManager.pT().isMainProcess() && !z) {
                com.baidu.adp.plugin.b.a.pD().log("plugin_class_notfind");
            }
            if (!z) {
                bVar.isSucc = false;
                return bVar;
            }
            if (findPluginSetting.isPatch) {
                this.mCurrentPluginMode = 1;
                if (TextUtils.isEmpty(findPluginSetting.replaceMethodClasses)) {
                    ClassLoader classLoader2 = this.mContext.getClassLoader();
                    while (!(classLoader2 instanceof PathClassLoader)) {
                        classLoader2 = classLoader2.getParent();
                    }
                    a.C0028a a2 = com.baidu.adp.plugin.util.a.a(classLoader2, this.mDexClassLoader, this.mPackageName + ".Static", false, this.mPluginApkFile.getAbsolutePath());
                    if (a2 == null || !a2.Ut) {
                        com.baidu.adp.plugin.b.a.pD().h("plugin_load", "createClassLoader_failed", this.mPackageName, "patch apk inject failed!" + a2.mErrMsg);
                        bVar.isSucc = false;
                        bVar.reason = "patchClassLoaderInject_failed";
                        bVar.Rt = "inject failed, patch failed!";
                        return bVar;
                    }
                } else if (Build.VERSION.SDK_INT > 23 || (Util.qE() && Build.VERSION.SDK_INT < 21)) {
                    bVar.isSucc = true;
                    com.baidu.adp.plugin.b.a.pD().h("plugin_load", "create_patch_classloader_error", this.mPackageName, "system not support!");
                } else if (PluginNative.bLoadLibrary) {
                    bVar.isSucc = PluginNative.replaceInit(Util.qE(), Build.VERSION.SDK_INT);
                    if (bVar.isSucc) {
                        bVar.isSucc = PatchReplaceMethodHelper.loadPatch(this, this.mContext, generateOutputName(this.mPluginApkFile.getAbsolutePath(), this.mPluginDataRoot.getAbsolutePath()));
                    }
                    if (!bVar.isSucc) {
                        bVar.reason = "patch method replace failed";
                        bVar.Rt = "patch replace failed!!";
                        com.baidu.adp.plugin.b.a.pD().h("plugin_load", "create_patch_classloader_error", this.mPackageName, bVar.reason);
                        return bVar;
                    }
                } else {
                    bVar.isSucc = false;
                    bVar.reason = "replace lib load failed!";
                    bVar.Rt = "patch replace failed!!";
                    com.baidu.adp.plugin.b.a.pD().h("plugin_load", "create_patch_classloader_error", this.mPackageName, bVar.reason);
                    return bVar;
                }
            }
            if (findPluginSetting.isInjectClassloader()) {
                ClassLoader classLoader3 = this.mContext.getClassLoader();
                while (!(classLoader3 instanceof PathClassLoader)) {
                    classLoader3 = classLoader3.getParent();
                }
                this.mCurrentPluginMode = 1;
                a.C0028a a3 = com.baidu.adp.plugin.util.a.a(classLoader3, this.mDexClassLoader, this.mPackageName + ".Static", true, this.mPluginApkFile.getAbsolutePath());
                if (a3 != null && !a3.Ut) {
                    if (PluginPackageManager.pT().isMainProcess()) {
                        com.baidu.adp.plugin.b.a.pD().log("plugin_inject_failed");
                    }
                    bVar.reason = "inject_failed";
                    bVar.Rt = a3.mErrMsg;
                    com.baidu.adp.plugin.b.a.pD().h("plugin_load", "inject_failed", this.mPackageName, a3.mErrMsg);
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
                    a.C0028a b2 = com.baidu.adp.plugin.util.a.b(this.mContext, new DexClassLoader(str2, this.mPluginDataRoot.getAbsolutePath(), str, classLoader3), this.mPackageName + ".Static");
                    if (b2 != null && !b2.Ut) {
                        if (PluginPackageManager.pT().isMainProcess()) {
                            com.baidu.adp.plugin.b.a.pD().h("plugin_load", "replaceparent_failed", this.mPackageName, b2.mErrMsg);
                        }
                        bVar.isSucc = false;
                        bVar.reason = "replaceparent_failed";
                        bVar.Rt = b2.mErrMsg;
                        return bVar;
                    } else if (b2 != null && b2.Ut) {
                        com.baidu.adp.plugin.b.a.pD().log("plugin_second_inject_succ");
                    }
                }
            }
            this.mIsClassLoaderSucc = true;
            bVar.isSucc = true;
            return bVar;
        } catch (Exception e2) {
            BdLog.e(e2);
            bVar.isSucc = false;
            bVar.reason = "new_dexloader_failed";
            bVar.Rt = e2.getMessage() + "---" + e2.getClass().getName();
            if (PluginPackageManager.pT().isMainProcess()) {
                com.baidu.adp.plugin.b.a.pD().h("plugin_load", "new_dexloader_failed", this.mPackageName, e2.getMessage() + "---" + e2.getClass().getName());
            }
            return bVar;
        }
    }

    private void createProviders() {
        Object split;
        if (this.mManifest != null && this.mManifest.pf() != null) {
            try {
                Iterator<Map.Entry<String, ProviderInfo>> it = this.mManifest.pf().entrySet().iterator();
                if (it != null) {
                    String str = ContentProviderProxy.PROVIDER_AUTHOR;
                    while (it.hasNext()) {
                        ProviderInfo value = it.next().getValue();
                        if (!TextUtils.isEmpty(value.authority) && !this.mProviders.containsKey(value.authority)) {
                            if (Build.VERSION.SDK_INT >= 21) {
                                str = str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + value.authority;
                            }
                            ContentProvider contentProvider = (ContentProvider) this.mDexClassLoader.loadClass(value.name).newInstance();
                            contentProvider.attachInfo(this.mApplication, value);
                            this.mProviders.put(value.authority, contentProvider);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 21 && ContentProviderProxy.getInstance() != null) {
                        Object field = com.baidu.adp.plugin.util.d.getField(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthorities");
                        if (field != null) {
                            split = com.baidu.adp.plugin.util.d.combineArray(field, str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR));
                        } else {
                            split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                        }
                        com.baidu.adp.plugin.util.d.setField(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthorities", split);
                        com.baidu.adp.plugin.util.d.setField(ContentProviderProxy.getInstance(), ContentProvider.class, "mAuthority", null);
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
                com.baidu.adp.plugin.b.a.pD().h("plugin_install", "create_provider_failed", this.mPackageName, e.getMessage());
            }
        }
    }

    private boolean loadStaticClasses() {
        if (this.mDexClassLoader == null) {
            return false;
        }
        DexFile a2 = com.baidu.adp.plugin.util.b.a(this.mDexClassLoader);
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
                        if (PluginPackageManager.pT().isMainProcess()) {
                            com.baidu.adp.plugin.b.a.pD().h("plugin_load", "getdexfile_failed_reverse", this.mPackageName, e2.getMessage());
                        }
                        return false;
                    }
                }
                initStaticBlock();
                return true;
            }
            if (PluginPackageManager.pT().isMainProcess()) {
                com.baidu.adp.plugin.b.a.pD().h("plugin_load", "getdexfile_failed_entries_null", this.mPackageName, str);
            }
            return false;
        }
        if (PluginPackageManager.pT().isMainProcess()) {
            com.baidu.adp.plugin.b.a.pD().h("plugin_load", "getdexfile_failed", this.mPackageName, str);
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
        private com.baidu.adp.plugin.util.c Rs;
        private String packageName;

        public a(String str, com.baidu.adp.plugin.util.c cVar) {
            this.packageName = null;
            this.Rs = null;
            this.packageName = str;
            this.Rs = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public b doInBackground(String... strArr) {
            return Plugin.this.createPlugin(this.packageName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(b bVar) {
            super.onPostExecute(bVar);
            if (this.Rs != null) {
                this.Rs.a(bVar, this.packageName);
            } else {
                BdLog.e("listener is null");
                if (PluginPackageManager.pT().isMainProcess()) {
                    com.baidu.adp.plugin.b.a.pD().g("plugin_load", "listener_null", this.packageName);
                }
            }
            if (bVar.isSucc) {
                Plugin.this.initStaticBlock();
                Plugin.this.initApplication();
                Plugin.this.sendMessageForPluginLoaded(this.packageName, 0, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0241  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b createPlugin(String str) {
        Object invoke;
        boolean z;
        boolean z2;
        boolean z3;
        b createClassLoader;
        PluginSetting findPluginSetting;
        String str2;
        b bVar = new b();
        bVar.pkgName = str;
        this.mPluginApkFile = com.baidu.adp.plugin.install.c.cr(str);
        if (this.mPluginApkFile == null) {
            if (PluginPackageManager.pT().isMainProcess()) {
                if (com.baidu.adp.plugin.packageManager.pluginSettings.c.qv().findPluginSetting(str) != null) {
                    str2 = "-versioncode-" + findPluginSetting.versionCode + "-enable-" + findPluginSetting.enable + "-forbid-" + findPluginSetting.forbidden + "-installstatus-" + findPluginSetting.installStatus + "-url-" + findPluginSetting.url + "-size-" + findPluginSetting.size + "-abandonapkpath-" + findPluginSetting.getAbandon_apk_path();
                } else {
                    str2 = "settingssize-" + com.baidu.adp.plugin.packageManager.pluginSettings.c.qv().qs().getPlugins().size() + "-filesize-" + new File(com.baidu.adp.plugin.packageManager.pluginSettings.b.qr().qu()).length();
                }
                bVar.reason = "apk_file_null";
                bVar.Rt = str2;
                com.baidu.adp.plugin.b.a.pD().h("plugin_load", "apk_file_null", str, str2);
            }
            com.baidu.adp.plugin.packageManager.pluginSettings.c.qv().cO(str);
            bVar.isSucc = false;
            return bVar;
        } else if (!assertApkFile()) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.qv().cO(str);
            if (PluginPackageManager.pT().isMainProcess()) {
                com.baidu.adp.plugin.b.a.pD().h("plugin_load", "apk_file_illegal", str, this.mPluginApkFile.getAbsolutePath());
            }
            bVar.isSucc = false;
            bVar.reason = "apk_file_illegal";
            return bVar;
        } else {
            createDataRoot();
            if (!this.mIsClassLoaderSucc) {
                String str3 = Util.qF() + "/oat/";
                File file = new File(str3);
                PluginSetting findPluginSetting2 = com.baidu.adp.plugin.packageManager.pluginSettings.c.qv().findPluginSetting(this.mPackageName);
                if (findPluginSetting2 != null && findPluginSetting2.apkPath != null) {
                    int lastIndexOf = findPluginSetting2.apkPath.lastIndexOf("/");
                    int lastIndexOf2 = findPluginSetting2.apkPath.lastIndexOf(".apk");
                    if (lastIndexOf + 1 < lastIndexOf2) {
                        String substring = findPluginSetting2.apkPath.substring(lastIndexOf + 1, lastIndexOf2);
                        boolean exists = new File(Util.qF() + "/" + substring + "/" + substring + ".dex").exists();
                        z3 = file.exists();
                        z2 = new File(new StringBuilder().append(str3).append("/arm/").append(substring).append(".vdex").toString()).exists() && new File(new StringBuilder().append(str3).append("/arm/").append(substring).append(".odex").toString()).exists();
                        z = exists;
                        createClassLoader = createClassLoader();
                        if (z3 && !z) {
                            com.baidu.adp.plugin.b.a.pD().f("plugin_load", "plugin_dex_oat_null", str, "processName_" + mProcessName + "-newTime_" + createClassLoader.time);
                        } else if (z3 && !z2) {
                            com.baidu.adp.plugin.b.a.pD().f("plugin_load", "plugin_oatfile_null", str, "processName_" + mProcessName + "-newTime_" + createClassLoader.time);
                        }
                        if (!createClassLoader.isSucc) {
                            return createClassLoader;
                        }
                    }
                }
                z = false;
                z2 = false;
                z3 = false;
                createClassLoader = createClassLoader();
                if (z3) {
                }
                if (z3) {
                    com.baidu.adp.plugin.b.a.pD().f("plugin_load", "plugin_oatfile_null", str, "processName_" + mProcessName + "-newTime_" + createClassLoader.time);
                }
                if (!createClassLoader.isSucc) {
                }
            }
            b createPluginResource = createPluginResource();
            if (createPluginResource.isSucc) {
                this.mManifest = new com.baidu.adp.plugin.b(this.mContext, this.mPluginApkFile, this.mPluginResource);
                try {
                    Class<?> cls = Class.forName(this.mPackageName + ".PluginStaticClassesArray", true, this.mDexClassLoader);
                    invoke = cls.getDeclaredMethod("getStaticClasses", new Class[0]).invoke(cls, new Object[0]);
                } catch (Throwable th) {
                    synchronized (this.mStaticClassFielsLock) {
                        this.mStaticClassFiles = new ArrayList<>();
                        loadStaticClasses();
                    }
                }
                if (invoke instanceof String[]) {
                    for (String str4 : (String[]) invoke) {
                        addStaticClassToInitList(str4);
                    }
                    if (!initStaticBlock()) {
                        throw new RuntimeException();
                    }
                    createPluginResource.isSucc = true;
                    return createPluginResource;
                }
                throw new RuntimeException();
            }
            return createPluginResource;
        }
    }

    private void addStaticClassToInitList(String str) {
        if (!TextUtils.isEmpty(str) && str.endsWith(t.SUFFIX) && this.mStaticClassFiles != null && !PluginPackageManager.pT().isFeatureForbidden(str)) {
            synchronized (this.mStaticClassFielsLock) {
                this.mStaticClassFiles.add(str);
            }
        }
    }
}
