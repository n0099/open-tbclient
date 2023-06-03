package com.baidu.searchbox.yy.gameassist;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\bB\u0010%J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\tJ1\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\"\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0007¢\u0006\u0004\b$\u0010%J)\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0(¢\u0006\u0004\b*\u0010+J)\u0010,\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0(¢\u0006\u0004\b,\u0010+R\u0016\u0010-\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010.R\u0016\u00100\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00101\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010.R\u0016\u00102\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010.R\u0016\u00103\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010.R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\n048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001d\u0010<\u001a\u0002078F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/baidu/searchbox/yy/gameassist/GameAssistNPSPluginManager;", "Landroid/content/Context;", "context", "", "checkGameAssistAlive", "(Landroid/content/Context;)Z", "packageContext", "", GameAssistConstKt.METHOD_CLEAR_ALL_CACHE, "(Landroid/content/Context;)V", "", "key", "", "", "params", "dispatchHostEvent", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V", "Ljava/io/File;", "file", "", "getFileLength", "(Ljava/io/File;)J", "getLiveResourceSize", "(Landroid/content/Context;)J", "Lcom/baidu/searchbox/yy/gameassist/PluginLoadCallback;", "originCallback", "loadNpsPluginImpl", "(Lcom/baidu/searchbox/yy/gameassist/PluginLoadCallback;)V", GameAssistConstKt.KEY_DISK_QUOTA, "", GameAssistConstKt.KEY_DISK_OLD_STATE, GameAssistConstKt.KEY_DISK_NEW_STATE, "Lcom/baidu/searchbox/live/interfaces/callback/ILiveDiskClearCacheCallback;", WebChromeClient.KEY_ARG_CALLBACK, GameAssistConstKt.METHOD_DISK_CLEAR_CACHE_CHANGE, "(JIILcom/baidu/searchbox/live/interfaces/callback/ILiveDiskClearCacheCallback;)V", "onGameAssistProcessDestroy", "()V", "Landroid/app/Activity;", "act", "", "paramsMap", "startGameAssistActivity", "(Landroid/app/Activity;Ljava/util/Map;)V", "startGameAssistActivityFromDebug", "GAMEASSIST_DISKCACHE_DIRNAME", "Ljava/lang/String;", "GAMEASSIST_ENTER_DEBUG", "GAMEASSIST_PKG_NAME", "IMPL_ENTRY_CLASS_NAME", "KEY_YY_WX_PAY_RESULT", "TAG", "", "hostEventSet", "Ljava/util/Set;", "Landroid/os/Handler;", "mMainHandler$delegate", "Lkotlin/Lazy;", "getMMainHandler", "()Landroid/os/Handler;", "mMainHandler", "Lcom/baidu/searchbox/yy/gameassist/IGameAssistPlugin;", "pluginImpl", "Lcom/baidu/searchbox/yy/gameassist/IGameAssistPlugin;", "receiveOnDestroy", "Z", "<init>", "lib-gameassist-host_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class GameAssistNPSPluginManager {
    public static final String GAMEASSIST_DISKCACHE_DIRNAME = "bzrescache";
    public static final String GAMEASSIST_ENTER_DEBUG = "enterDebugPage";
    public static final String GAMEASSIST_PKG_NAME = "com.baidu.searchbox.yylive.gameassist";
    public static final String IMPL_ENTRY_CLASS_NAME = "com.baidu.searchbox.yy.gameassist.GameAssistNpsPluginImpl";
    public static final String TAG = "GameAssistNPSManager";
    public static IGameAssistPlugin pluginImpl;
    public static boolean receiveOnDestroy;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(GameAssistNPSPluginManager.class), "mMainHandler", "getMMainHandler()Landroid/os/Handler;"))};
    public static final GameAssistNPSPluginManager INSTANCE = new GameAssistNPSPluginManager();
    public static final Lazy mMainHandler$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager$mMainHandler$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    public static final String KEY_YY_WX_PAY_RESULT = "yy_wx_pay_result";
    public static final Set<String> hostEventSet = SetsKt__SetsJVMKt.setOf(KEY_YY_WX_PAY_RESULT);

    public final Handler getMMainHandler() {
        Lazy lazy = mMainHandler$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Handler) lazy.getValue();
    }

    public final void onGameAssistProcessDestroy() {
        YalogKt.yalog(TAG, "onGameAssistProcessDestroy");
        receiveOnDestroy = true;
    }

    private final long getFileLength(File file) {
        long j = 0;
        if (file != null && file.exists()) {
            if (!file.isDirectory()) {
                return file.length();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    j += getFileLength(file2);
                }
            }
        }
        return j;
    }

    private final boolean checkGameAssistAlive(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Object systemService = context.getSystemService("activity");
        if (!(systemService instanceof ActivityManager)) {
            systemService = null;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                YalogKt.yalog(TAG, "checkGameAssistAlive processName = " + runningAppProcessInfo.processName);
                String str = runningAppProcessInfo.processName;
                Intrinsics.checkExpressionValueIsNotNull(str, "it.processName");
                if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) GameAssistConstKt.PROCESS_NAME, false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        receiveOnDestroy = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadNpsPluginImpl(PluginLoadCallback pluginLoadCallback) {
        final GameAssistNPSPluginManager$loadNpsPluginImpl$callback$1 gameAssistNPSPluginManager$loadNpsPluginImpl$callback$1 = new GameAssistNPSPluginManager$loadNpsPluginImpl$callback$1(pluginLoadCallback);
        YalogKt.yalog(TAG, "loadNpsPluginImpl, start, " + pluginImpl);
        if (pluginImpl != null) {
            NPSPluginStateHelper.INSTANCE.preloadBZRes(true, gameAssistNPSPluginManager$loadNpsPluginImpl$callback$1, pluginImpl);
        } else if (NPSPluginStateHelper.INSTANCE.isAvailable()) {
            NPSManager.getInstance().loadClazz(GAMEASSIST_PKG_NAME, IMPL_ENTRY_CLASS_NAME, IGameAssistPlugin.class, new IInvokeCallback() { // from class: com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager$loadNpsPluginImpl$1
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public final void onResult(int i, String str, Object obj) {
                    YalogKt.yalog(GameAssistNPSPluginManager.TAG, "resCode = " + i + ", resStr = " + str + ", obj = " + obj);
                    if (i == 14) {
                        try {
                            IGameAssistPlugin iGameAssistPlugin = null;
                            if (!(obj instanceof Class)) {
                                obj = null;
                            }
                            Class cls = (Class) obj;
                            if (cls != null) {
                                iGameAssistPlugin = (IGameAssistPlugin) cls.newInstance();
                            }
                            NPSPluginStateHelper.INSTANCE.preloadBZRes(true, GameAssistNPSPluginManager$loadNpsPluginImpl$callback$1.this, iGameAssistPlugin);
                            return;
                        } catch (Throwable th) {
                            YalogKt.yalog(GameAssistNPSPluginManager.TAG, "new plugins Instances Failed, " + Log.getStackTraceString(th));
                            return;
                        }
                    }
                    GameAssistNPSPluginManager$loadNpsPluginImpl$callback$1.this.onFailed(i, str);
                }
            });
        } else {
            NPSPluginStateHelper.INSTANCE.downloadBundle(new IInvokeCallback() { // from class: com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager$loadNpsPluginImpl$2
                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public final void onResult(int i, String str, Object obj) {
                    YalogKt.yalog(GameAssistNPSPluginManager.TAG, "downloadBundle resCode = " + i + ", resStr = " + str + ", obj = " + obj);
                    if (i == 14) {
                        try {
                            IGameAssistPlugin iGameAssistPlugin = null;
                            if (!(obj instanceof Class)) {
                                obj = null;
                            }
                            Class cls = (Class) obj;
                            if (cls != null) {
                                iGameAssistPlugin = (IGameAssistPlugin) cls.newInstance();
                            }
                            NPSPluginStateHelper.INSTANCE.preloadBZRes(false, GameAssistNPSPluginManager$loadNpsPluginImpl$callback$1.this, iGameAssistPlugin);
                            return;
                        } catch (Throwable th) {
                            YalogKt.yalog(GameAssistNPSPluginManager.TAG, "downloadBundle new plugins Instances Failed, " + Log.getStackTraceString(th));
                            return;
                        }
                    }
                    GameAssistNPSPluginManager$loadNpsPluginImpl$callback$1.this.onFailed(i, str);
                }
            });
        }
    }

    public final void clearLiveResourceSize(final Context context) {
        boolean checkGameAssistAlive = checkGameAssistAlive(context);
        YalogKt.yalog(TAG, "clearLiveResourceSize, " + context + ", alive = " + checkGameAssistAlive);
        if (checkGameAssistAlive) {
            IGameAssistPlugin iGameAssistPlugin = pluginImpl;
            if (iGameAssistPlugin != null) {
                iGameAssistPlugin.clearLiveResourceSize(context);
                return;
            } else {
                loadNpsPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager$clearLiveResourceSize$1
                    @Override // com.baidu.searchbox.yy.gameassist.PluginLoadCallback
                    public void onResult(Object obj, String str) {
                        GameAssistNPSPluginManager.INSTANCE.clearLiveResourceSize(context);
                    }
                });
                return;
            }
        }
        try {
            boolean deleteRecursively = FilesKt__UtilsKt.deleteRecursively(new File(context.getFilesDir(), GAMEASSIST_DISKCACHE_DIRNAME));
            YalogKt.yalog(TAG, "clearLiveResourceSize success = " + deleteRecursively);
        } catch (Throwable th) {
            YalogKt.yalog(TAG, "clearLiveResourceSize delete direct failed -> " + Log.getStackTraceString(th));
        }
    }

    public final long getLiveResourceSize(Context context) {
        File file = new File(context.getFilesDir(), GAMEASSIST_DISKCACHE_DIRNAME);
        YalogKt.yalog(TAG, "getLiveResourceSize, " + context + "， path = " + file.getAbsolutePath());
        try {
            if (file.exists()) {
                long fileLength = getFileLength(file);
                YalogKt.yalog(TAG, "getLiveResourceSize size = " + fileLength);
                return fileLength;
            }
            return 0L;
        } catch (Throwable th) {
            YalogKt.yalog(TAG, "getLiveResources Failed" + Log.getStackTraceString(th));
            return 0L;
        }
    }

    public final void dispatchHostEvent(final Context context, final String str, final Map<String, Object> map) {
        YalogKt.yalog(TAG, "dispatchHostEvent， " + str);
        if (!hostEventSet.contains(str)) {
            return;
        }
        IGameAssistPlugin iGameAssistPlugin = pluginImpl;
        if (iGameAssistPlugin != null) {
            iGameAssistPlugin.dispatchHostEvent(context, str, map);
        } else {
            loadNpsPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager$dispatchHostEvent$1
                @Override // com.baidu.searchbox.yy.gameassist.PluginLoadCallback
                public void onResult(Object obj, String str2) {
                    GameAssistNPSPluginManager.INSTANCE.dispatchHostEvent(context, str, map);
                }
            });
        }
    }

    public final void onDiskClearCacheChange(final long j, final int i, final int i2, final ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        Application application;
        Context applicationContext;
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null && (application = appInfoService.getApplication()) != null && (applicationContext = application.getApplicationContext()) != null) {
            boolean checkGameAssistAlive = checkGameAssistAlive(applicationContext);
            YalogKt.yalog(TAG, "alive = " + checkGameAssistAlive + ", onDiskClearCacheChange, " + j + StringUtil.ARRAY_ELEMENT_SEPARATOR + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2);
            if (checkGameAssistAlive) {
                IGameAssistPlugin iGameAssistPlugin = pluginImpl;
                if (iGameAssistPlugin != null) {
                    iGameAssistPlugin.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
                } else {
                    loadNpsPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager$onDiskClearCacheChange$1
                        @Override // com.baidu.searchbox.yy.gameassist.PluginLoadCallback
                        public void onResult(Object obj, String str) {
                            GameAssistNPSPluginManager.INSTANCE.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
                        }
                    });
                }
            }
        }
    }

    public final void startGameAssistActivity(final Activity activity, final Map<String, String> map) {
        boolean z;
        YalogKt.yalog(TAG, "startGameAssistActivity");
        AccountManagerService accountManagerService = (AccountManagerService) ServiceManager.getService(AccountManagerService.Companion.getSERVICE_REFERENCE());
        if (accountManagerService != null) {
            z = accountManagerService.isLogin(2);
        } else {
            z = false;
        }
        YalogKt.yalog(TAG, "isLogined = " + z);
        if (!z) {
            ThirdPartAccountService thirdPartAccountService = (ThirdPartAccountService) ServiceManager.getService(ThirdPartAccountService.Companion.getSERVICE_REFERENCE());
            if (thirdPartAccountService != null) {
                thirdPartAccountService.showLoginDialog(activity, "", new ThirdPartAccountService.LoginResultCallback() { // from class: com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager$startGameAssistActivity$1
                    @Override // com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService.LoginResultCallback
                    public void onBtnClick(int i) {
                        YalogKt.yalog(GameAssistNPSPluginManager.TAG, "before open check onBtnClick -> " + i);
                    }

                    @Override // com.baidu.searchbox.live.interfaces.service.ThirdPartAccountService.LoginResultCallback
                    public void onResult(int i) {
                        YalogKt.yalog(GameAssistNPSPluginManager.TAG, "before open check onResult -> " + i);
                    }
                });
            }
        } else if (checkGameAssistAlive(activity) && receiveOnDestroy) {
            YalogKt.yalog(TAG, "gameassist process destroying");
            NPSPluginStateHelper.INSTANCE.showLoading();
            getMMainHandler().postDelayed(new Runnable() { // from class: com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager$startGameAssistActivity$2
                @Override // java.lang.Runnable
                public final void run() {
                    GameAssistNPSPluginManager.INSTANCE.loadNpsPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager$startGameAssistActivity$2.1
                        @Override // com.baidu.searchbox.yy.gameassist.PluginLoadCallback
                        public void onResult(Object obj, String str) {
                            IGameAssistPlugin iGameAssistPlugin;
                            GameAssistNPSPluginManager gameAssistNPSPluginManager = GameAssistNPSPluginManager.INSTANCE;
                            iGameAssistPlugin = GameAssistNPSPluginManager.pluginImpl;
                            if (iGameAssistPlugin != null) {
                                GameAssistNPSPluginManager$startGameAssistActivity$2 gameAssistNPSPluginManager$startGameAssistActivity$2 = GameAssistNPSPluginManager$startGameAssistActivity$2.this;
                                iGameAssistPlugin.startGameAssistActivity(activity, map);
                            }
                            NPSPluginStateHelper.INSTANCE.downloadUpdatePackage();
                        }
                    });
                }
            }, 1000L);
        } else {
            loadNpsPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager$startGameAssistActivity$3
                @Override // com.baidu.searchbox.yy.gameassist.PluginLoadCallback
                public void onResult(Object obj, String str) {
                    IGameAssistPlugin iGameAssistPlugin;
                    GameAssistNPSPluginManager gameAssistNPSPluginManager = GameAssistNPSPluginManager.INSTANCE;
                    iGameAssistPlugin = GameAssistNPSPluginManager.pluginImpl;
                    if (iGameAssistPlugin != null) {
                        iGameAssistPlugin.startGameAssistActivity(activity, map);
                    }
                    NPSPluginStateHelper.INSTANCE.downloadUpdatePackage();
                }
            });
        }
    }

    public final void startGameAssistActivityFromDebug(final Activity activity, final Map<String, String> map) {
        YalogKt.yalog(TAG, "startGameAssistActivityFromDebug");
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null && appInfoService.isDebug()) {
            if (checkGameAssistAlive(activity) && receiveOnDestroy) {
                YalogKt.yalog(TAG, "startGameAssistActivityFromDebug gameassist process destroying");
                NPSPluginStateHelper.INSTANCE.showLoading();
                getMMainHandler().postDelayed(new Runnable() { // from class: com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager$startGameAssistActivityFromDebug$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameAssistNPSPluginManager.INSTANCE.loadNpsPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager$startGameAssistActivityFromDebug$1.1
                            @Override // com.baidu.searchbox.yy.gameassist.PluginLoadCallback
                            public void onResult(Object obj, String str) {
                                IGameAssistPlugin iGameAssistPlugin;
                                GameAssistNPSPluginManager gameAssistNPSPluginManager = GameAssistNPSPluginManager.INSTANCE;
                                iGameAssistPlugin = GameAssistNPSPluginManager.pluginImpl;
                                if (iGameAssistPlugin != null) {
                                    GameAssistNPSPluginManager$startGameAssistActivityFromDebug$1 gameAssistNPSPluginManager$startGameAssistActivityFromDebug$1 = GameAssistNPSPluginManager$startGameAssistActivityFromDebug$1.this;
                                    iGameAssistPlugin.startGameAssistActivity(activity, map);
                                }
                                NPSPluginStateHelper.INSTANCE.downloadUpdatePackage();
                            }
                        });
                    }
                }, 1000L);
                return;
            }
            loadNpsPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager$startGameAssistActivityFromDebug$2
                @Override // com.baidu.searchbox.yy.gameassist.PluginLoadCallback
                public void onResult(Object obj, String str) {
                    IGameAssistPlugin iGameAssistPlugin;
                    GameAssistNPSPluginManager gameAssistNPSPluginManager = GameAssistNPSPluginManager.INSTANCE;
                    iGameAssistPlugin = GameAssistNPSPluginManager.pluginImpl;
                    if (iGameAssistPlugin != null) {
                        iGameAssistPlugin.startGameAssistActivity(activity, map);
                    }
                    NPSPluginStateHelper.INSTANCE.downloadUpdatePackage();
                }
            });
            return;
        }
        YalogKt.yalog(TAG, "startGameAssistActivityFromDebug not in debug");
        startGameAssistActivity(activity, map);
    }
}
