package com.baidu.searchbox.yy.gameassist;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tieba.hg1;
import com.baidu.tieba.jg1;
import com.baidu.tieba.of1;
import com.baidu.tieba.qf1;
import com.baidu.tieba.rf1;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.File;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b9\u0010\u0003J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0003J'\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u00012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0001¢\u0006\u0004\b$\u0010\u0003J\u001f\u0010'\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0010H\u0002¢\u0006\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00148\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010.\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00101\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010,R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/yy/gameassist/NPSPluginStateHelper;", "", "cancelLoading", "()V", "Lcom/baidu/nps/main/invoke/IInvokeCallback;", "installCallback", "downloadBundle", "(Lcom/baidu/nps/main/invoke/IInvokeCallback;)V", "downloadUpdatePackage", "Landroid/content/Context;", "context", "ensureSubProcessProvider", "(Landroid/content/Context;)V", "", "isAvailable", "()Z", "", "progress", "onPreloadBZResReturnInProgress", "(I)V", "", StatConstants.KEY_EXT_ERR_MSG, "onPreloadBZResReturnOnError", "(Ljava/lang/String;)V", "onPreloadBZResReturnOnSuccess", "pluginDownloaded", "Lcom/baidu/searchbox/yy/gameassist/PluginLoadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/searchbox/yy/gameassist/IGameAssistPlugin;", "impl", "preloadBZRes", "(ZLcom/baidu/searchbox/yy/gameassist/PluginLoadCallback;Lcom/baidu/searchbox/yy/gameassist/IGameAssistPlugin;)V", "Lcom/baidu/searchbox/yy/gameassist/LiveYYNpsLoadingCallback;", "loadingImpl", "setLoadingCallback", "(Lcom/baidu/searchbox/yy/gameassist/LiveYYNpsLoadingCallback;)V", "showLoading", "text", "duration", "showNormalToast", "(Ljava/lang/String;I)V", "TAG", "Ljava/lang/String;", "isLoadingCanceled", "Z", "isLoadingShowing", "isPluginDownload", "loadingDelegate", "Lcom/baidu/searchbox/yy/gameassist/LiveYYNpsLoadingCallback;", "pluginImpl", "Lcom/baidu/searchbox/yy/gameassist/IGameAssistPlugin;", "pluginLoadCallback", "Lcom/baidu/searchbox/yy/gameassist/PluginLoadCallback;", "preloadProgressing", "Ljava/lang/Runnable;", "showLoadingDialog", "Ljava/lang/Runnable;", "<init>", "lib-gameassist-host_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class NPSPluginStateHelper {
    public static final String TAG = "NPSPluginStateHelper";
    public static boolean isLoadingCanceled;
    public static boolean isLoadingShowing;
    public static boolean isPluginDownload;
    public static LiveYYNpsLoadingCallback loadingDelegate;
    public static IGameAssistPlugin pluginImpl;
    public static PluginLoadCallback pluginLoadCallback;
    public static boolean preloadProgressing;
    public static final NPSPluginStateHelper INSTANCE = new NPSPluginStateHelper();
    public static final Runnable showLoadingDialog = new Runnable() { // from class: com.baidu.searchbox.yy.gameassist.NPSPluginStateHelper$showLoadingDialog$1
        @Override // java.lang.Runnable
        public final void run() {
            LiveYYNpsLoadingCallback liveYYNpsLoadingCallback;
            boolean z;
            LiveYYNpsLoadingCallback liveYYNpsLoadingCallback2;
            LiveYYNpsLoadingCallback liveYYNpsLoadingCallback3;
            YalogKt.yalog(NPSPluginStateHelper.TAG, "showLoading running");
            NPSPluginStateHelper nPSPluginStateHelper = NPSPluginStateHelper.INSTANCE;
            NPSPluginStateHelper.isLoadingShowing = true;
            NPSPluginStateHelper nPSPluginStateHelper2 = NPSPluginStateHelper.INSTANCE;
            liveYYNpsLoadingCallback = NPSPluginStateHelper.loadingDelegate;
            if (liveYYNpsLoadingCallback != null) {
                liveYYNpsLoadingCallback.onLoadingStart();
            }
            NPSPluginStateHelper nPSPluginStateHelper3 = NPSPluginStateHelper.INSTANCE;
            z = NPSPluginStateHelper.isPluginDownload;
            if (z) {
                NPSPluginStateHelper nPSPluginStateHelper4 = NPSPluginStateHelper.INSTANCE;
                liveYYNpsLoadingCallback3 = NPSPluginStateHelper.loadingDelegate;
                if (liveYYNpsLoadingCallback3 != null) {
                    liveYYNpsLoadingCallback3.onLoadingProgress(0L, 100L);
                    return;
                }
                return;
            }
            NPSPluginStateHelper nPSPluginStateHelper5 = NPSPluginStateHelper.INSTANCE;
            liveYYNpsLoadingCallback2 = NPSPluginStateHelper.loadingDelegate;
            if (liveYYNpsLoadingCallback2 != null) {
                liveYYNpsLoadingCallback2.onLoadingProgress(90L, 100L);
            }
        }
    };

    public final void cancelLoading() {
        YalogKt.yalog(TAG, "cancelLoading");
        isLoadingCanceled = true;
    }

    public final void downloadUpdatePackage() {
        NPSPackageManager.getInstance().downloadUpdatePackage(GameAssistNPSPluginManager.GAMEASSIST_PKG_NAME, new of1() { // from class: com.baidu.searchbox.yy.gameassist.NPSPluginStateHelper$downloadUpdatePackage$1
            @Override // com.baidu.tieba.of1
            public void onProgress(long j, long j2) {
            }

            @Override // com.baidu.tieba.of1
            public void onResult(int i, String str) {
            }
        }, new qf1() { // from class: com.baidu.searchbox.yy.gameassist.NPSPluginStateHelper$downloadUpdatePackage$2
            @Override // com.baidu.tieba.qf1
            public void checkAuthorization(IBundleInfo iBundleInfo, int i, rf1 rf1Var) {
                if (rf1Var != null) {
                    rf1Var.onResult(1);
                }
            }
        }, 1);
    }

    public final void showLoading() {
        LiveYYNpsLoadingCallback liveYYNpsLoadingCallback = loadingDelegate;
        if (liveYYNpsLoadingCallback != null) {
            liveYYNpsLoadingCallback.onLoadingStart();
        }
        isLoadingShowing = true;
    }

    public final void downloadBundle(final IInvokeCallback iInvokeCallback) {
        YalogKt.yalog(TAG, "downloadBundle");
        isLoadingShowing = true;
        LiveYYNpsLoadingCallback liveYYNpsLoadingCallback = loadingDelegate;
        if (liveYYNpsLoadingCallback != null) {
            liveYYNpsLoadingCallback.onLoadingStart();
        }
        NPSPackageManager.getInstance().installBundle(GameAssistNPSPluginManager.GAMEASSIST_PKG_NAME, new IInstallCallback() { // from class: com.baidu.searchbox.yy.gameassist.NPSPluginStateHelper$downloadBundle$1
            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onProgress(long j, long j2) {
                LiveYYNpsLoadingCallback liveYYNpsLoadingCallback2;
                NPSPluginStateHelper nPSPluginStateHelper = NPSPluginStateHelper.INSTANCE;
                liveYYNpsLoadingCallback2 = NPSPluginStateHelper.loadingDelegate;
                if (liveYYNpsLoadingCallback2 != null) {
                    liveYYNpsLoadingCallback2.onLoadingProgress(((float) j) * 0.9f, j2);
                }
            }

            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onResult(int i, String str) {
                boolean z;
                NPSPluginStateHelper nPSPluginStateHelper = NPSPluginStateHelper.INSTANCE;
                z = NPSPluginStateHelper.isLoadingCanceled;
                if (z) {
                    YalogKt.yalog(NPSPluginStateHelper.TAG, "loading already be canceled");
                    NPSPluginStateHelper nPSPluginStateHelper2 = NPSPluginStateHelper.INSTANCE;
                    NPSPluginStateHelper.isLoadingCanceled = false;
                    return;
                }
                if (i != 3) {
                    if (i == 13) {
                        NPSManager.getInstance().loadClazz(GameAssistNPSPluginManager.GAMEASSIST_PKG_NAME, GameAssistNPSPluginManager.IMPL_ENTRY_CLASS_NAME, IGameAssistPlugin.class, IInvokeCallback.this);
                    } else {
                        NPSPluginStateHelper.INSTANCE.showNormalToast("加载失败，请稍候重试", 0);
                        YalogKt.yalog(NPSPluginStateHelper.TAG, "install gameassist plugin error=" + i + "， " + str);
                    }
                } else {
                    NPSManager.getInstance().loadClazz(GameAssistNPSPluginManager.GAMEASSIST_PKG_NAME, GameAssistNPSPluginManager.IMPL_ENTRY_CLASS_NAME, IGameAssistPlugin.class, IInvokeCallback.this);
                }
            }
        });
    }

    public final void setLoadingCallback(LiveYYNpsLoadingCallback liveYYNpsLoadingCallback) {
        YalogKt.yalog(TAG, "setLoadingCallback");
        loadingDelegate = liveYYNpsLoadingCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNormalToast(final String str, final int i) {
        GameAssistNPSPluginManager.INSTANCE.getMMainHandler().post(new Runnable() { // from class: com.baidu.searchbox.yy.gameassist.NPSPluginStateHelper$showNormalToast$1
            @Override // java.lang.Runnable
            public final void run() {
                AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
                ToastService toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
                if (appInfoService != null && toastService != null) {
                    toastService.showNormal(appInfoService.getApplication(), str, i);
                }
            }
        });
    }

    private final void ensureSubProcessProvider(Context context) {
        try {
            Bundle bundle = NPSManager.getInstance().getBundle(GameAssistNPSPluginManager.GAMEASSIST_PKG_NAME);
            Method declaredMethod = bundle.getClass().getDeclaredMethod("bindProviders", PackageInfo.class);
            Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "bundle.javaClass.getDecl… PackageInfo::class.java)");
            declaredMethod.setAccessible(true);
            File d = hg1.d(context, "com.baidu.searchbox.yylive.gameassist.apk");
            Intrinsics.checkExpressionValueIsNotNull(d, "FileUtils.getBundleDest(…UFFIX}\"\n                )");
            declaredMethod.invoke(bundle, jg1.a(d.getAbsolutePath(), 138));
        } catch (Throwable th) {
            YalogKt.yalog(TAG, "ensureSubProcessProvider failed, " + Log.getStackTraceString(th));
        }
    }

    public final void onPreloadBZResReturnInProgress(int i) {
        YalogKt.yalog(TAG, "onPreloadBZResReturnInProgress running, progress = " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + isLoadingShowing);
        preloadProgressing = true;
        if (!isLoadingShowing) {
            YalogKt.yalog(TAG, "onPreloadBZResReturnInProgress, but not showing, wait runnable");
        } else if (isPluginDownload) {
            LiveYYNpsLoadingCallback liveYYNpsLoadingCallback = loadingDelegate;
            if (liveYYNpsLoadingCallback != null) {
                liveYYNpsLoadingCallback.onLoadingProgress(i, 100L);
            }
        } else {
            LiveYYNpsLoadingCallback liveYYNpsLoadingCallback2 = loadingDelegate;
            if (liveYYNpsLoadingCallback2 != null) {
                liveYYNpsLoadingCallback2.onLoadingProgress(90 + (i * 0.1f), 100L);
            }
        }
    }

    public final boolean isAvailable() {
        int bundleStatus = NPSPackageManager.getInstance().getBundleStatus(GameAssistNPSPluginManager.GAMEASSIST_PKG_NAME);
        if (bundleStatus != 43) {
            YalogKt.yalog(TAG, "com.baidu.searchbox.yylive.gameassist, isAvailable " + bundleStatus);
            return false;
        }
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(GameAssistNPSPluginManager.GAMEASSIST_PKG_NAME);
        if (bundleGroup != null) {
            BundleInfo bundleByType = bundleGroup.getBundleByType(3);
            BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
            BundleInfo bundleByType3 = bundleGroup.getBundleByType(1);
            if (bundleByType3 != null && bundleByType3.needForceUpdate()) {
                return false;
            }
            if (bundleByType2 != null || bundleByType != null) {
                return true;
            }
        }
        return false;
    }

    public final void onPreloadBZResReturnOnError(String str) {
        YalogKt.yalog(TAG, "onPreloadBZResReturnOnError running");
        preloadProgressing = false;
        if (!isLoadingShowing) {
            GameAssistNPSPluginManager.INSTANCE.getMMainHandler().removeCallbacks(showLoadingDialog);
        }
        if (isLoadingCanceled) {
            isLoadingCanceled = false;
            return;
        }
        isLoadingCanceled = false;
        LiveYYNpsLoadingCallback liveYYNpsLoadingCallback = loadingDelegate;
        if (liveYYNpsLoadingCallback != null) {
            liveYYNpsLoadingCallback.onLoadingEnd(19);
        }
        showNormalToast(str, 1);
        PluginLoadCallback pluginLoadCallback2 = pluginLoadCallback;
        if (pluginLoadCallback2 != null) {
            pluginLoadCallback2.onFailed(19, "error in preload bz res");
        }
        isLoadingShowing = false;
        pluginLoadCallback = null;
        pluginImpl = null;
    }

    public final void onPreloadBZResReturnOnSuccess() {
        YalogKt.yalog(TAG, "onPreloadBZResReturnOnSuccess running");
        preloadProgressing = false;
        if (!isLoadingShowing) {
            GameAssistNPSPluginManager.INSTANCE.getMMainHandler().removeCallbacks(showLoadingDialog);
        }
        if (isLoadingCanceled) {
            isLoadingCanceled = false;
            return;
        }
        isLoadingCanceled = false;
        LiveYYNpsLoadingCallback liveYYNpsLoadingCallback = loadingDelegate;
        if (liveYYNpsLoadingCallback != null) {
            liveYYNpsLoadingCallback.onLoadingEnd(13);
        }
        PluginLoadCallback pluginLoadCallback2 = pluginLoadCallback;
        if (pluginLoadCallback2 != null) {
            pluginLoadCallback2.onResult(pluginImpl, GameAssistConstKt.PROCESS_NAME);
        }
        isLoadingShowing = false;
        pluginLoadCallback = null;
        pluginImpl = null;
    }

    public final void preloadBZRes(boolean z, PluginLoadCallback pluginLoadCallback2, IGameAssistPlugin iGameAssistPlugin) {
        YalogKt.yalog(TAG, "preloadBZRes running");
        isLoadingCanceled = false;
        isPluginDownload = z;
        pluginLoadCallback = pluginLoadCallback2;
        pluginImpl = iGameAssistPlugin;
        Application application = ((AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE())).getApplication();
        if (preloadProgressing) {
            YalogKt.yalog(TAG, "preloadBZRes, already progressing");
            return;
        }
        ensureSubProcessProvider(application);
        if (!isLoadingShowing) {
            GameAssistNPSPluginManager.INSTANCE.getMMainHandler().postDelayed(showLoadingDialog, 500L);
        }
        if (application.getContentResolver().call(Uri.parse(GameAssistConstKt.getSUB_PROCESS_PROVIDER()), GameAssistConstKt.METHOD_PRELOAD_BZ, (String) null, new android.os.Bundle()) == null) {
            YalogKt.yalog(TAG, "preloadBZRes running return , null");
            GameAssistNPSPluginManager.INSTANCE.getMMainHandler().removeCallbacks(showLoadingDialog);
            LiveYYNpsLoadingCallback liveYYNpsLoadingCallback = loadingDelegate;
            if (liveYYNpsLoadingCallback != null) {
                liveYYNpsLoadingCallback.onLoadingEnd(19);
            }
            PluginLoadCallback pluginLoadCallback3 = pluginLoadCallback;
            if (pluginLoadCallback3 != null) {
                pluginLoadCallback3.onFailed(19, "null at bzres");
            }
            showNormalToast("功能加载失败 - BZ", 1);
            pluginLoadCallback = null;
            pluginImpl = null;
        }
    }
}
