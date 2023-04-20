package com.baidu.searchbox.live.nps;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Consumer;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleConfig;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.live.chainlog.NpsLoadChainLog;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.entry.ILiveYYMixEntry;
import com.baidu.searchbox.live.interfaces.payment.IPaymentLogDelegate;
import com.baidu.searchbox.live.interfaces.payment.IPaymentStateCallback;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.LiveYalogService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.yalog.LiveYalogApi;
import com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.yy.YYEnvResultCallback;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.interfaces.yy.YYStaticConfig;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService;
import com.baidu.searchbox.live.nps.util.SchemeParamsParseUtils;
import com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager;
import com.baidu.tieba.R;
import com.baidu.tieba.jd1;
import com.baidu.tieba.ld1;
import com.baidu.tieba.md1;
import com.bumptech.glide.load.engine.GlideException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveYYPluginManager {
    public static final int ENTRANCE_PAY_RELEASE_SUPPORT_MIN_VER = 607500000;
    public static final String KET_HOST_EVENT_USER_CANCEL_LOAD_PROGRESS = "user_cancel_load_progress";
    public static final int PAYMENT_START_MIN_VERSION = 601500000;
    public static final int PAYMENT_START_PLUGIN_VER_UNAVAILABLE = 400000;
    public static final String TAG = "LiveYYPluginManager";
    public static final String USE_FROM_DISPATCH_YY_ROUTER = "dispatchYYLiveRouter";
    public static final String USE_FROM_LOAD_YY_PLUGIN = "loadYYPlugin";
    public static final String USE_FROM_PREPARE_CREATE_LIVE = "prepareCreateLive";
    public static final String USE_FROM_START_PAYMENT = "startPayment";
    public static final String USE_FROM_START_YY_CUSTOMER_PAGE = "startYYCustomerServiceActivity";
    public static final String USE_FROM_START_YY_FEED_BACK_PAGE = "startYYFeedbackActivity";
    public static final String USE_FROM_START_YY_LIVE_PAGE = "startYYLiveActivity";
    public static final String USE_FROM_START_YY_TEST_PAGE = "startYYActivity";
    public static final String YY_NPS_IMPL_CLASS_NAME = "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl";
    public static final String YY_NPS_PKG_NAME = "com.baidu.searchbox.yylive.entrance";
    public AppInfoService appService;
    public boolean fromDownLoad;
    public Handler handler;
    public boolean isFirst;
    public boolean isLoadingCanceled;
    public LiveNpsLoadingCallback loadingCallback;
    public PluginLoadCallback mCurrentCallback;
    public Handler mHandler;
    public volatile boolean mLiveNpsPreload;
    public boolean mLoadingShowing;
    public YYStatInfo mStatInfo;
    public Consumer<Boolean> mSubDismissCallback;
    public IYYLiveNPSPlugin mYYLiveNPSPlugin;
    public boolean markClosedByPlugin;
    public ToastService toastService;
    public LiveYalogApi yalogApi;
    public LiveYalogService yalogService;
    public static final String YY_NPS_YYLIB_PKG_NAME = "com.baidu.searchbox.yylive.yylib";
    public static final String[] NPS_PLUGIN_SUB_PKG_GROUP = {YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_1, YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_2, "com.baidu.searchbox.yylive.extlib", "com.baidu.searchbox.yylive.createlive", "com.baidu.searchbox.yylive.game", YY_NPS_YYLIB_PKG_NAME, "com.baidu.searchbox.yylive.audiolive", "com.baidu.searchbox.yylive.friends"};
    public static final String[] YY_PLUGIN_LIST = {YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_1, YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_2, "com.baidu.searchbox.yylive.extlib", "com.baidu.searchbox.yylive.createlive", "com.baidu.searchbox.yylive.game", YY_NPS_YYLIB_PKG_NAME, "com.baidu.searchbox.yylive.audiolive", "com.baidu.searchbox.yylive.friends"};

    /* loaded from: classes2.dex */
    public interface PluginLoadCallback {
        void onResult(int i, String str, Object obj, String str2);
    }

    public boolean isMiniLibPluginLoaded() {
        return false;
    }

    public void onPluginLoadedState(String str, boolean z, String str2) {
    }

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        public static final LiveYYPluginManager INSTANCE = new LiveYYPluginManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadUpdatePackage() {
        NPSPackageManager.getInstance().downloadUpdatePackage("com.baidu.searchbox.yylive.entrance", new jd1() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.13
            @Override // com.baidu.tieba.jd1
            public void onProgress(long j, long j2) {
            }

            @Override // com.baidu.tieba.jd1
            public void onResult(int i, String str) {
            }
        }, new ld1() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.14
            @Override // com.baidu.tieba.ld1
            public void checkAuthorization(IBundleInfo iBundleInfo, int i, md1 md1Var) {
                if (md1Var != null) {
                    md1Var.onResult(1);
                }
            }
        }, 1);
    }

    public static LiveYYPluginManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private boolean isDebug() {
        AppInfoService appInfoService = this.appService;
        if (appInfoService != null) {
            return appInfoService.isDebug();
        }
        return false;
    }

    private void showLoading() {
        pluginYaLog("showLoading, " + this.loadingCallback);
        LiveNpsLoadingCallback liveNpsLoadingCallback = this.loadingCallback;
        if (liveNpsLoadingCallback != null) {
            liveNpsLoadingCallback.onLoadingProgress(0L, 100L);
            this.loadingCallback.onLoadingStart();
            this.mLoadingShowing = true;
        }
    }

    public void cancelStartYYLiveActivity() {
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
        if (iYYLiveNPSPlugin != null) {
            try {
                iYYLiveNPSPlugin.cancelStartYYLiveActivity();
            } catch (AbstractMethodError e) {
                e.printStackTrace();
            }
        }
    }

    public ILiveYYMixEntry getLiveYYMixEntry() {
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
        if (iYYLiveNPSPlugin != null && iYYLiveNPSPlugin.getLiveYYMixEntry() != null) {
            return this.mYYLiveNPSPlugin.getLiveYYMixEntry();
        }
        return null;
    }

    public int getPluginInstallVersion() {
        BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.yylive.entrance");
        if (bundleInfo == null) {
            return 0;
        }
        return bundleInfo.getVersionCode();
    }

    public boolean isLoaded() {
        if (this.mYYLiveNPSPlugin != null) {
            return true;
        }
        return false;
    }

    public void stopLoadingBySubPlugin() {
        pluginYaLog("stopLoadingBySubPlugin, " + this.mSubDismissCallback);
        LiveNpsLoadingCallback liveNpsLoadingCallback = this.loadingCallback;
        if (liveNpsLoadingCallback != null) {
            liveNpsLoadingCallback.onLoadingProgress(100L, 100L);
            this.loadingCallback.onLoadingEnd(-1);
            this.mLoadingShowing = false;
        }
        this.mSubDismissCallback = null;
    }

    public LiveYYPluginManager() {
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.mSubDismissCallback = null;
        this.markClosedByPlugin = false;
        this.mLoadingShowing = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.yalogService = (LiveYalogService) ServiceManager.getService(LiveYalogService.Companion.getSERVICE_REFERENCE());
        this.yalogApi = null;
        this.fromDownLoad = false;
        this.mLiveNpsPreload = false;
        this.isLoadingCanceled = false;
        this.isFirst = true;
        this.handler = new Handler(Looper.getMainLooper());
        LiveYalogService liveYalogService = this.yalogService;
        if (liveYalogService != null) {
            this.yalogApi = liveYalogService.buildYalogApi("live_plugin");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logPluginVersionCode() {
        BundleInfo bundleInfo;
        if (NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.yylive.entrance") == 43 && (bundleInfo = NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.yylive.entrance")) != null) {
            Log.d("NPS", "NPS Installed live plugin version code " + bundleInfo.getVersionCode());
            Log.e("NPS", "iscancel" + this.isLoadingCanceled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLog(String str) {
        NpsLoadChainLog.getInstance().dLog(str);
    }

    private boolean isYYPlugin(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : YY_PLUGIN_LIST) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pluginYaLog(String str) {
        LiveYalogApi liveYalogApi = this.yalogApi;
        if (liveYalogApi != null) {
            liveYalogApi.w("3036", "load-livenps-plugin", str);
        }
        if (isDebug()) {
            Log.e("load-livenps-plugin", "LiveNpsPluginManager load-livenps-plugin msg = " + str);
        }
    }

    private void preLoadYY(final long j) {
        NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.15
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(int i, String str, Object obj) {
                LiveYYPluginManager liveYYPluginManager = LiveYYPluginManager.this;
                liveYYPluginManager.dLog("LiveYYPluginManager onResult code = " + i + ", msg = " + str + ", clazz = " + obj + ", time = " + (System.currentTimeMillis() - j));
                if (i != 14) {
                    return;
                }
                LiveYYPluginManager.this.mLiveNpsPreload = true;
            }
        });
    }

    public void releasePayment(Map<String, Object> map) {
        if (this.mYYLiveNPSPlugin == null) {
            return;
        }
        logPluginVersionCode();
        if (getPluginInstallVersion() < 607500000) {
            return;
        }
        this.mYYLiveNPSPlugin.releasePayment(map);
    }

    public void setLoadingCallback(LiveNpsLoadingCallback liveNpsLoadingCallback) {
        this.loadingCallback = liveNpsLoadingCallback;
    }

    public void showLoadingBySubPlugin(Consumer<Boolean> consumer) {
        pluginYaLog("showLoadingBySubPlugin, " + this.loadingCallback);
        if (!this.mLoadingShowing) {
            showLoading();
        }
        this.markClosedByPlugin = true;
        this.mSubDismissCallback = consumer;
    }

    public void updateStatInfo(YYStatInfo yYStatInfo) {
        this.mStatInfo = yYStatInfo;
    }

    private int compareVersion(int i, int i2) {
        return (i / 1000) - (i2 / 1000);
    }

    public void reportUBCNotify(String str, JSONObject jSONObject) {
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
        if (iYYLiveNPSPlugin != null) {
            try {
                iYYLiveNPSPlugin.reportNotify(str, jSONObject);
            } catch (Throwable th) {
                pluginYaLog("版本不兼容 error = " + Log.getStackTraceString(th));
            }
        }
    }

    public void dispatchHostEvent(Context context, String str, Map<String, Object> map) {
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.dLog("LiveYYPluginManager dispatchHostEvent " + str + GlideException.IndentedAppendable.INDENT + this.mYYLiveNPSPlugin);
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
        if (iYYLiveNPSPlugin != null) {
            iYYLiveNPSPlugin.dispatchHostEvent(context, str, map);
        }
    }

    public void prepareYYEnv(Context context, final String str, final YYEnvResultCallback yYEnvResultCallback) {
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.3
                @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveYYPluginManager.this.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveYYPluginManager.this.isLoadingCanceled) {
                                LiveYYPluginManager.this.mYYLiveNPSPlugin.prepareYYEnv(str, yYEnvResultCallback);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveYYPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                }
            }, USE_FROM_PREPARE_CREATE_LIVE, "", context, true);
        } else {
            iYYLiveNPSPlugin.prepareYYEnv(str, yYEnvResultCallback);
        }
    }

    private boolean isAvailable() {
        BundleInfo bundleInfo;
        int i;
        String str;
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
        if (bundleGroup == null) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: top plugin is null");
            }
            return false;
        }
        int i2 = 3;
        BundleInfo bundleByType = bundleGroup.getBundleByType(3);
        int i3 = 2;
        BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
        if (bundleByType2 != null) {
            bundleInfo = bundleByType2;
        } else {
            bundleInfo = bundleByType;
        }
        BundleConfig bundleConfig = new BundleConfig();
        if (bundleInfo == null || bundleInfo.getVersionCode() < 508000000) {
            bundleConfig.skipPresetBundle = true;
        }
        int bundleStatus = NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.yylive.entrance", false, bundleConfig);
        if (isDebug()) {
            Log.d(TAG, "isAvailable() isMultiBundleEnable = false, status = " + bundleStatus);
        }
        if (bundleStatus != 43) {
            if (isDebug()) {
                Log.d(TAG, "isAvailable: bundle status=" + bundleStatus);
            }
            return false;
        } else if (bundleByType == null && (bundleByType2 == null || (bundleByType2 != null && bundleByType2.getVersionCode() < 508000000))) {
            return false;
        } else {
            if (bundleByType != null && bundleByType.getVersionCode() < 508000000 && (bundleByType2 == null || bundleByType2.getVersionCode() < 508000000)) {
                return false;
            }
            if (bundleInfo == null) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: top plugin has no update");
                }
                return true;
            }
            int length = NPS_PLUGIN_SUB_PKG_GROUP.length;
            BundleInfoGroup[] bundleInfoGroupArr = new BundleInfoGroup[length];
            boolean z = true;
            for (int i4 = 0; i4 < length; i4++) {
                bundleInfoGroupArr[i4] = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_SUB_PKG_GROUP[i4]);
                if (bundleInfoGroupArr[i4] != null) {
                    z = false;
                }
            }
            if (z) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: sec plugin not exist");
                }
                return true;
            }
            BundleInfo bundleInfo2 = NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.yylive.entrance");
            if (bundleInfo2 != null) {
                i = bundleInfo2.getVersionCode();
            } else {
                i = 0;
            }
            int i5 = 0;
            while (i5 < length) {
                if (bundleInfoGroupArr[i5] != null) {
                    BundleInfo bundleByType3 = bundleInfoGroupArr[i5].getBundleByType(i2);
                    int versionCode = bundleInfo.getVersionCode();
                    String[] strArr = NPS_PLUGIN_SUB_PKG_GROUP;
                    if (strArr.length > i5) {
                        str = strArr[i5];
                    } else {
                        str = "";
                    }
                    if (isYYPlugin(str) && i != 0) {
                        versionCode = i;
                    }
                    if (bundleByType3 != null && compareVersion(versionCode, bundleByType3.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: installed " + bundleByType3.getPackageName() + " plugin too high");
                        }
                        pluginYaLog("isAvailable() pkgName = " + bundleByType3.getPackageName() + ", vesion too hign");
                        return false;
                    }
                    BundleInfo bundleByType4 = bundleInfoGroupArr[i5].getBundleByType(1);
                    BundleInfo bundleByType5 = bundleInfoGroupArr[i5].getBundleByType(i3);
                    if (bundleByType4 != null && bundleByType4.needForceUpdate() && compareVersion(bundleInfo.getVersionCode(), bundleByType4.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: sec " + bundleByType4.getPackageName() + " plugin force update1");
                        }
                        if (bundleByType3 != null) {
                            pluginYaLog("isAvailable() pkgName = " + bundleByType3.getPackageName() + ", plugin force update1");
                        }
                        return false;
                    } else if (bundleByType4 == null && bundleByType5 != null && bundleByType5.needForceUpdate() && compareVersion(bundleInfo.getVersionCode(), bundleByType5.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: sec " + bundleByType5.getPackageName() + " plugin force update2");
                        }
                        if (bundleByType3 != null) {
                            pluginYaLog("isAvailable() pkgName = " + bundleByType3.getPackageName() + ", plugin force update2");
                        }
                        return false;
                    }
                }
                i5++;
                i2 = 3;
                i3 = 2;
            }
            return true;
        }
    }

    private void loadNPSPluginImpl(PluginLoadCallback pluginLoadCallback, String str, String str2, Context context, boolean z) {
        loadNPSPluginImpl(pluginLoadCallback, str, str2, context, true, false, z);
    }

    public void loadPlugin(Context context, String str, String str2, boolean z, com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback) {
        loadPlugin(context, str, str2, z, pluginLoadCallback, null);
    }

    private void loadNPSPluginImpl(PluginLoadCallback pluginLoadCallback, final String str, String str2, Context context, final boolean z, boolean z2, final boolean z3) {
        BundleInfo bundleInfo;
        BundleInfo bundleInfo2;
        int i;
        int i2;
        int i3;
        NpsLoadChainLog.getInstance().dLog("LiveYYPluginManager loadNPSPluginImpl " + str + GlideException.IndentedAppendable.INDENT + str2);
        this.mCurrentCallback = pluginLoadCallback;
        final IInvokeCallback iInvokeCallback = new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.8
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(final int i4, final String str3, final Object obj) {
                boolean z4;
                LiveYYPluginManager liveYYPluginManager = LiveYYPluginManager.this;
                liveYYPluginManager.pluginYaLog("LiveYYPluginManager Load directly and without install,onResult retCode = " + i4 + ", retMsg = " + str3 + ", retObj = " + obj);
                if (i4 == 14) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                LiveYYPluginManager liveYYPluginManager2 = LiveYYPluginManager.this;
                liveYYPluginManager2.dLog("LiveYYPluginManager 一级加载结束~ invokeSucc = " + z4);
                NpsLoadChainLog.getInstance().endLoadClazzLiveNps(z4, i4);
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    LiveYYPluginManager.this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LiveYYPluginManager.this.mCurrentCallback != null) {
                                LiveYYPluginManager.this.mCurrentCallback.onResult(i4, str3, obj, "load");
                                LiveYYPluginManager.this.mCurrentCallback = null;
                            }
                        }
                    });
                } else if (LiveYYPluginManager.this.mCurrentCallback != null) {
                    LiveYYPluginManager.this.mCurrentCallback.onResult(i4, str3, obj, "load");
                    LiveYYPluginManager.this.mCurrentCallback = null;
                }
            }
        };
        final IInvokeCallback iInvokeCallback2 = new IInvokeCallback() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.9
            @Override // com.baidu.nps.main.invoke.IInvokeCallback
            public void onResult(final int i4, final String str3, final Object obj) {
                boolean z4;
                String str4;
                LiveYYPluginManager liveYYPluginManager = LiveYYPluginManager.this;
                liveYYPluginManager.pluginYaLog("LiveYYPluginManager Load after install, onResult retCode = " + i4 + ", retMsg = " + str3 + ", retObj = " + obj);
                if (i4 == 14) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                LiveYYPluginManager liveYYPluginManager2 = LiveYYPluginManager.this;
                liveYYPluginManager2.dLog("LiveYYPluginManager 一级安装结束~ invokeSucc = " + z4);
                NpsLoadChainLog.getInstance().endLoadClazzLiveNps(z4, i4);
                if (LiveYYPluginManager.this.fromDownLoad) {
                    str4 = "download";
                } else {
                    str4 = "install";
                }
                final String str5 = str4;
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    LiveYYPluginManager.this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LiveYYPluginManager.this.mCurrentCallback != null) {
                                LiveYYPluginManager.this.mCurrentCallback.onResult(i4, str3, obj, str5);
                                LiveYYPluginManager.this.mCurrentCallback = null;
                            }
                        }
                    });
                } else if (LiveYYPluginManager.this.mCurrentCallback != null) {
                    LiveYYPluginManager.this.mCurrentCallback.onResult(i4, str3, obj, str5);
                    LiveYYPluginManager.this.mCurrentCallback = null;
                }
            }
        };
        boolean isAvailable = isAvailable();
        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
        BundleInfo bundleInfo3 = null;
        if (bundleGroup != null) {
            bundleInfo3 = bundleGroup.getBundleByType(1);
            bundleInfo2 = bundleGroup.getBundleByType(2);
            bundleInfo = bundleGroup.getBundleByType(3);
        } else {
            bundleInfo = null;
            bundleInfo2 = null;
        }
        if (bundleInfo3 != null) {
            i = bundleInfo3.getVersionCode();
        } else {
            i = 0;
        }
        if (bundleInfo2 != null) {
            i2 = bundleInfo2.getVersionCode();
        } else {
            i2 = 0;
        }
        if (bundleInfo != null) {
            i3 = bundleInfo.getVersionCode();
        } else {
            i3 = 0;
        }
        pluginYaLog("Enter liveworld and load top plugin, useFrom = " + str + ", isTopPluginAvailable = " + isAvailable + ", version { 1 = " + i + ", 2 = " + i2 + ", 3 = " + i3 + " }");
        if (isAvailable) {
            this.fromDownLoad = false;
            if (NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance").getBundleByType(2) != null) {
                ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.10
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveYYPluginManager.this.dLog("开始安装 YY 一级");
                        NpsLoadChainLog.getInstance().startInstallLiveNps();
                        int prepareBundle = NPSPackageManager.getInstance().prepareBundle("com.baidu.searchbox.yylive.entrance");
                        LiveYYPluginManager liveYYPluginManager = LiveYYPluginManager.this;
                        liveYYPluginManager.pluginYaLog("Top plugin is available and has downloaded plugin, prepareBundle result = " + prepareBundle + ", and loadClazz");
                        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                        npsLoadChainLog.setPluginVersion(LiveYYPluginManager.this.getPluginInstallVersion() + "");
                        LiveYYPluginManager.this.dLog("YY 一级安装结束~成功");
                        NpsLoadChainLog.getInstance().endInstallLiveNps(true, prepareBundle);
                        LiveYYPluginManager.this.dLog("开始加载YY一级插件");
                        if (!LiveYYPluginManager.this.mLiveNpsPreload) {
                            NpsLoadChainLog.getInstance().startLoadClazzLiveNps();
                        } else {
                            LiveYYPluginManager.this.dLog("已预加载YY一级插件");
                            NpsLoadChainLog.getInstance().startLoadClazzLiveNpsPreload();
                        }
                        LiveYYPluginManager.this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                if (!z3) {
                                    return;
                                }
                                LiveYYPluginManager.this.pluginYaLog("Top plugin is available and has downloaded plugin, downloadUpdatePackage~");
                                LiveYYPluginManager.this.downloadUpdatePackage();
                            }
                        });
                        NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, iInvokeCallback);
                    }
                }, "nps-preparebundle", 0);
                return;
            }
            if (z3) {
                pluginYaLog("Top plugin is available but no downloaded plugin, downloadUpdatePackage");
                downloadUpdatePackage();
            }
            pluginYaLog("Top plugin is available but no downloaded plugin, directly loadClazz");
            dLog("开始加载YY一级插件");
            if (this.mLiveNpsPreload) {
                dLog("已预加载YY一级插件");
                NpsLoadChainLog.getInstance().startLoadClazzLiveNpsPreload();
            } else {
                NpsLoadChainLog.getInstance().startLoadClazzLiveNps();
            }
            NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, iInvokeCallback);
            return;
        }
        this.isLoadingCanceled = false;
        if (z) {
            showLoading();
        }
        this.fromDownLoad = false;
        dLog("下载 YY 一级 = com.baidu.searchbox.yylive.entrance");
        NpsLoadChainLog.getInstance().startDownloadLiveNps();
        pluginYaLog("Top plugin is not available and installBundle~");
        NPSPackageManager.getInstance().installBundle("com.baidu.searchbox.yylive.entrance", new IInstallCallback() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.11
            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onProgress(long j, long j2) {
                LiveYYPluginManager liveYYPluginManager = LiveYYPluginManager.this;
                liveYYPluginManager.pluginYaLog("Install top plugin, onProgress downloadSize = " + j + ", totalSIze = " + j2);
                LiveYYPluginManager.this.fromDownLoad = true;
                if (LiveYYPluginManager.this.loadingCallback != null && !LiveYYPluginManager.this.isLoadingCanceled) {
                    if (!LiveYYPluginManager.USE_FROM_DISPATCH_YY_ROUTER.equals(str) && !LiveYYPluginManager.USE_FROM_START_YY_FEED_BACK_PAGE.equals(str) && !LiveYYPluginManager.USE_FROM_START_YY_CUSTOMER_PAGE.equals(str)) {
                        LiveYYPluginManager.this.loadingCallback.onLoadingProgress(j, j2);
                    } else {
                        LiveYYPluginManager.this.loadingCallback.onLoadingProgress(j / 2, j2);
                    }
                }
                LiveYYPluginManager liveYYPluginManager2 = LiveYYPluginManager.this;
                liveYYPluginManager2.dLog("downloadSize = " + j + ", totalSIze = " + j2);
                if (j < j2) {
                    return;
                }
                LiveYYPluginManager.this.dLog("YY 一级下载结束");
                NpsLoadChainLog.getInstance().endDownloadLiveNps(j, j2);
                LiveYYPluginManager.this.dLog("开始安装 YY 一级");
                NpsLoadChainLog.getInstance().startInstallLiveNps();
            }

            @Override // com.baidu.nps.main.install.IInstallCallback
            public void onResult(int i4, String str3) {
                LiveYYPluginManager liveYYPluginManager = LiveYYPluginManager.this;
                liveYYPluginManager.pluginYaLog("Install top plugin, onResult retCode = " + i4 + ", retMsg = " + str3);
                if (z && i4 != 34) {
                    LiveYYPluginManager.this.stopLoading(i4, str);
                }
                if (i4 == 13) {
                    NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                    npsLoadChainLog.setPluginVersion(LiveYYPluginManager.this.getPluginInstallVersion() + "");
                    LiveYYPluginManager.this.dLog("YY 一级插件安装结束~成功");
                    NpsLoadChainLog.getInstance().endInstallLiveNps(true, i4);
                    LiveYYPluginManager.this.dLog("开始加载 YY 一级");
                    NpsLoadChainLog.getInstance().startLoadClazzLiveNps();
                    LiveYYPluginManager.this.pluginYaLog("Install top plugin Success loadClazz");
                    NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, iInvokeCallback2);
                } else if (i4 == 3 && NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.yylive.entrance") == 43) {
                    NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                    npsLoadChainLog2.setPluginVersion(LiveYYPluginManager.this.getPluginInstallVersion() + "");
                    LiveYYPluginManager.this.dLog("YY 一级安装结束~成功");
                    NpsLoadChainLog.getInstance().endInstallLiveNps(true, i4);
                    LiveYYPluginManager.this.dLog("开始加载YY 一级");
                    NpsLoadChainLog.getInstance().startLoadClazzLiveNps();
                    LiveYYPluginManager.this.pluginYaLog("Install top plugin no data and is available, so loadClazz");
                    NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, iInvokeCallback2);
                } else {
                    LiveYYPluginManager.this.pluginYaLog("Install top plugin Fail, so not loadClazz");
                    LiveYYPluginManager liveYYPluginManager2 = LiveYYPluginManager.this;
                    liveYYPluginManager2.dLog("YY 一级安装结束~失败 rerCode = " + i4);
                    if (i4 != 34) {
                        NpsLoadChainLog.getInstance().endInstallLiveNps(false, i4);
                    }
                    if (z) {
                        if (i4 == 34) {
                            if (LiveYYPluginManager.this.loadingCallback != null) {
                                return;
                            }
                            LiveYYPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d1, 0);
                            return;
                        }
                        LiveYYPluginManager.this.mCurrentCallback = null;
                        LiveYYPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
                }
            }
        });
    }

    /* JADX DEBUG: Type inference failed for r5v6. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    private String parseEntry(String str) {
        LiveNPSPluginManagerOld.getInstance();
        String paramsStr = LiveNPSPluginManagerOld.getParamsStr(str);
        LiveNPSPluginManagerOld.getInstance();
        HashMap<String, String> stringToMap = LiveNPSPluginManagerOld.stringToMap(paramsStr);
        boolean containsKey = stringToMap.containsKey("params");
        Map map = stringToMap;
        if (containsKey) {
            try {
                JSONObject jSONObject = new JSONObject(stringToMap.get("params"));
                LiveNPSPluginManagerOld.getInstance();
                map = LiveNPSPluginManagerOld.paramsJsonToMap(jSONObject);
            } catch (Exception unused) {
                map = null;
            }
        }
        String str2 = "";
        if (map == null) {
            return "";
        }
        String str3 = map.get("tab");
        String str4 = map.get("tag");
        String str5 = map.get("source");
        StringBuilder sb = new StringBuilder();
        if (str3 == null) {
            str3 = "";
        }
        sb.append(str3);
        sb.append("-");
        if (str4 != null) {
            str2 = str4;
        }
        sb.append(str2);
        sb.append("-");
        sb.append(str5);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalToast(final int i, final int i2) {
        ToastService toastService;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.handler.post(new Runnable() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.17
                @Override // java.lang.Runnable
                public void run() {
                    if (LiveYYPluginManager.this.appService != null && LiveYYPluginManager.this.toastService != null) {
                        LiveYYPluginManager.this.toastService.showNormal(LiveYYPluginManager.this.appService.getApplication(), LiveYYPluginManager.this.appService.getApplication().getResources().getString(i), i2);
                    }
                }
            });
            return;
        }
        AppInfoService appInfoService = this.appService;
        if (appInfoService != null && (toastService = this.toastService) != null) {
            toastService.showNormal(appInfoService.getApplication(), this.appService.getApplication().getResources().getString(i), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLoading(int i, String str) {
        pluginYaLog("stopLoading, " + str);
        if (!this.markClosedByPlugin && !USE_FROM_DISPATCH_YY_ROUTER.equals(str) && !USE_FROM_START_YY_CUSTOMER_PAGE.equals(str) && !USE_FROM_START_YY_FEED_BACK_PAGE.equals(str)) {
            LiveNpsLoadingCallback liveNpsLoadingCallback = this.loadingCallback;
            if (liveNpsLoadingCallback != null) {
                liveNpsLoadingCallback.onLoadingProgress(100L, 100L);
                this.loadingCallback.onLoadingEnd(i);
                this.mLoadingShowing = false;
            }
            this.mSubDismissCallback = null;
            return;
        }
        pluginYaLog("stopLoading, but marked by SubPlugin");
    }

    public void startYYCustomerServiceActivity(final Context context, final String str) {
        dLog("startYYCustomerServiceActivity--进入YY客服页面，初始化NpsLoadChainLog，设置Entry，插件版本号 = " + getPluginInstallVersion());
        NpsLoadChainLog.getInstance().initAndStart();
        NpsLoadChainLog.getInstance().setEntry("YY-CustomerService");
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.2
                @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveYYPluginManager.this.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveYYPluginManager.this.isLoadingCanceled) {
                                LiveYYPluginManager.this.mYYLiveNPSPlugin.startYYCustomerServiceActivity(context, str);
                            }
                            LiveYYPluginManager.this.logPluginVersionCode();
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveYYPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                }
            }, USE_FROM_START_YY_CUSTOMER_PAGE, str, context, true);
            return;
        }
        iYYLiveNPSPlugin.startYYCustomerServiceActivity(context, str);
        logPluginVersionCode();
    }

    public void startYYFeedbackActivity(final Context context, final String str) {
        dLog("startYYFeedbackActivity--进入YY反馈页面，初始化NpsLoadChainLog，设置Entry，插件版本号 = " + getPluginInstallVersion());
        NpsLoadChainLog.getInstance().initAndStart();
        NpsLoadChainLog.getInstance().setEntry("YY-Feedback");
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.1
                @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveYYPluginManager.this.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveYYPluginManager.this.isLoadingCanceled) {
                                LiveYYPluginManager.this.mYYLiveNPSPlugin.startYYFeedbackActivity(context, str);
                            }
                            LiveYYPluginManager.this.logPluginVersionCode();
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveYYPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                }
            }, USE_FROM_START_YY_FEED_BACK_PAGE, str, context, true);
            return;
        }
        iYYLiveNPSPlugin.startYYFeedbackActivity(context, str);
        logPluginVersionCode();
    }

    public void cancelLoading() {
        pluginYaLog("cancelLoading");
        HashMap hashMap = new HashMap();
        hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
        NpsLoadChainLog.getInstance().yyCompletionEvent("npsPluginCancel", new JSONObject(hashMap));
        this.isLoadingCanceled = true;
        Consumer<Boolean> consumer = this.mSubDismissCallback;
        if (consumer != null) {
            consumer.accept(Boolean.TRUE);
        }
        this.mSubDismissCallback = null;
        this.mLoadingShowing = false;
    }

    public void dispatchYYLiveRouter(final Context context, final String str) {
        if (YYStaticConfig.conf == null) {
            YYStaticConfig.conf = new HashMap<>();
        }
        YYStaticConfig.conf.put("hostSchemeParseBegin", Long.valueOf(System.currentTimeMillis()));
        dLog("dispatchYYLiveRouter--YY万能路由，初始化NpsLoadChainLog，设置Entry，插件版本号 = " + getPluginInstallVersion());
        NpsLoadChainLog.getInstance().initAndStart();
        NpsLoadChainLog.getInstance().setEntry("YY-Router");
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        if (this.mYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.4
                @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            if (YYStaticConfig.conf == null) {
                                YYStaticConfig.conf = new HashMap<>();
                            }
                            if ("download".equals(str3)) {
                                YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "download");
                            } else if ("install".equals(str3)) {
                                YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "install");
                            } else if ("load".equals(str3)) {
                                YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "load");
                            }
                            String parserYYSchemaUrl = MultiPluginHelper.parserYYSchemaUrl(str);
                            YYStaticConfig.conf.put("PreJoinChannelType", "Schema");
                            YYStaticConfig.conf.put("PreJoinChannelSchemaUrl", parserYYSchemaUrl);
                            LiveYYPluginManager liveYYPluginManager = LiveYYPluginManager.this;
                            liveYYPluginManager.dLog("schemaUrl = " + parserYYSchemaUrl);
                            LiveYYPluginManager.this.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveYYPluginManager.this.isLoadingCanceled) {
                                LiveYYPluginManager.this.mYYLiveNPSPlugin.dispatchYYLiveRouter(context, str);
                            }
                            LiveYYPluginManager.this.logPluginVersionCode();
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveYYPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                }
            }, USE_FROM_DISPATCH_YY_ROUTER, str, context, true);
            return;
        }
        if (YYStaticConfig.conf == null) {
            YYStaticConfig.conf = new HashMap<>();
        }
        YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "direct");
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
        if (iYYLiveNPSPlugin != null && !iYYLiveNPSPlugin.isLoaded()) {
            String parserYYSchemaUrl = MultiPluginHelper.parserYYSchemaUrl(str);
            YYStaticConfig.conf.put("PreJoinChannelType", "Schema");
            YYStaticConfig.conf.put("PreJoinChannelSchemaUrl", parserYYSchemaUrl);
            dLog("not load, schemaUrl = " + parserYYSchemaUrl);
        }
        IYYLiveNPSPlugin iYYLiveNPSPlugin2 = this.mYYLiveNPSPlugin;
        if (iYYLiveNPSPlugin2 != null) {
            iYYLiveNPSPlugin2.dispatchYYLiveRouter(context, str);
        }
        logPluginVersionCode();
    }

    public void loadPlugin(Context context, String str, String str2, boolean z, final com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback, Map<String, String> map) {
        boolean z2;
        if ("com.baidu.searchbox.yylive.entrance".equals(str)) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveYYPluginManager loadPlugin " + str + GlideException.IndentedAppendable.INDENT + str2);
            PluginLoadCallback pluginLoadCallback2 = new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.7
                @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                public void onResult(int i, String str3, Object obj, String str4) {
                    if (YYStaticConfig.conf == null) {
                        YYStaticConfig.conf = new HashMap<>();
                    }
                    if ("download".equals(str4)) {
                        YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "download");
                    } else if ("install".equals(str4)) {
                        YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "install");
                    } else if ("load".equals(str4)) {
                        YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "load");
                    }
                    if (i == 14) {
                        try {
                            LiveYYPluginManager.this.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback3 = pluginLoadCallback;
                        if (pluginLoadCallback3 != null) {
                            pluginLoadCallback3.onResult(true, i, str3);
                            return;
                        }
                        return;
                    }
                    com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback4 = pluginLoadCallback;
                    if (pluginLoadCallback4 != null) {
                        pluginLoadCallback4.onResult(false, i, str3);
                    }
                }
            };
            if ((context instanceof Activity) && z) {
                z2 = true;
            } else {
                z2 = false;
            }
            loadNPSPluginImpl(pluginLoadCallback2, USE_FROM_LOAD_YY_PLUGIN, str2, context, z, z2, true);
        }
    }

    public void onDiskClearCacheChange(final long j, final int i, final int i2, final ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        if (NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.yylive.entrance") == null) {
            return;
        }
        NpsLoadChainLog.getInstance().initAndStart();
        NpsLoadChainLog.getInstance().setEntry("YY-DiskCleaner");
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.12
                @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                public void onResult(int i3, String str, Object obj, String str2) {
                    if (i3 == 14) {
                        try {
                            LiveYYPluginManager.this.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                            LiveYYPluginManager.this.mYYLiveNPSPlugin.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveYYPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                }
            }, "onDiskClearCacheChange", "", LiveNpsRuntime.getApplication(), false);
            return;
        }
        try {
            iYYLiveNPSPlugin.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void startPayment(final Context context, final IPaymentStateCallback iPaymentStateCallback, final IPaymentLogDelegate iPaymentLogDelegate, final String str, final Long l, final Boolean bool, final Map<String, String> map, final Map<String, Object> map2) {
        dLog("startPayment--调起YY收银台，插件版本号 = " + getPluginInstallVersion());
        if (this.mYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.16
                @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            LiveYYPluginManager.this.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveYYPluginManager.this.isLoadingCanceled) {
                                int pluginInstallVersion = LiveYYPluginManager.this.getPluginInstallVersion();
                                if (pluginInstallVersion >= 601500000) {
                                    LiveYYPluginManager.this.mYYLiveNPSPlugin.startPayment(context, iPaymentStateCallback, iPaymentLogDelegate, str, l, bool, map, map2);
                                } else {
                                    String str4 = "startPayment check plugin version not available." + pluginInstallVersion;
                                    if (iPaymentStateCallback != null) {
                                        iPaymentStateCallback.onFail(Integer.valueOf((int) LiveYYPluginManager.PAYMENT_START_PLUGIN_VER_UNAVAILABLE), str4, null);
                                    }
                                    LiveYYPluginManager.this.pluginYaLog(str4);
                                }
                            }
                            LiveYYPluginManager.this.logPluginVersionCode();
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveYYPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                }
            }, USE_FROM_START_PAYMENT, "", LiveNpsRuntime.getApplication(), true);
            return;
        }
        int pluginInstallVersion = getPluginInstallVersion();
        if (pluginInstallVersion >= 601500000) {
            this.mYYLiveNPSPlugin.startPayment(context, iPaymentStateCallback, iPaymentLogDelegate, str, l, bool, map, map2);
        } else {
            String str2 = "startPayment check plugin version not available." + pluginInstallVersion;
            if (iPaymentStateCallback != null) {
                iPaymentStateCallback.onFail(Integer.valueOf((int) PAYMENT_START_PLUGIN_VER_UNAVAILABLE), str2, null);
            }
            pluginYaLog(str2);
        }
        logPluginVersionCode();
    }

    public void startYYActivity(final Context context) {
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.dLog("LiveYYPluginManager startYYLiveActivity " + this.mYYLiveNPSPlugin);
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.5
                @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                public void onResult(int i, String str, Object obj, String str2) {
                    if (i == 14) {
                        try {
                            LiveYYPluginManager.this.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                            if (!LiveYYPluginManager.this.isLoadingCanceled) {
                                LiveYYPluginManager.this.mYYLiveNPSPlugin.startYYActivity(context);
                            }
                            LiveYYPluginManager.this.logPluginVersionCode();
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    LiveYYPluginManager.this.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                }
            }, USE_FROM_START_YY_TEST_PAGE, "", context, true);
            return;
        }
        iYYLiveNPSPlugin.startYYActivity(context);
        logPluginVersionCode();
    }

    public void startYYLiveActivity(final Context context, final String str) {
        NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
        npsLoadChainLog.dLog("LiveYYPluginManager startYYLiveActivity " + str + GlideException.IndentedAppendable.INDENT + this.mYYLiveNPSPlugin);
        if (YYStaticConfig.conf == null) {
            YYStaticConfig.conf = new HashMap<>();
        }
        YYStaticConfig.conf.put("hostJoinLiveBegin", Long.valueOf(System.currentTimeMillis()));
        NpsLoadChainLog.getInstance().initAndStart();
        NpsLoadChainLog.getInstance().setEntry(parseEntry(str));
        NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
        npsLoadChainLog2.setPluginVersion(getPluginInstallVersion() + "");
        if (this.mYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(new PluginLoadCallback() { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.6
                @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                public void onResult(int i, String str2, Object obj, String str3) {
                    if (i == 14) {
                        try {
                            if (YYStaticConfig.conf == null) {
                                YYStaticConfig.conf = new HashMap<>();
                            }
                            if ("download".equals(str3)) {
                                YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "download");
                            } else if ("install".equals(str3)) {
                                YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "install");
                            } else if ("load".equals(str3)) {
                                YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "load");
                            }
                            Map<String, String> parseYYLiveParamMap = SchemeParamsParseUtils.parseYYLiveParamMap(str);
                            LiveYYPluginManager liveYYPluginManager = LiveYYPluginManager.this;
                            liveYYPluginManager.dLog("parseYYLiveParamMap " + parseYYLiveParamMap);
                            YYStaticConfig.conf.putAll(parseYYLiveParamMap);
                            LiveYYPluginManager.this.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        LiveYYPluginManager liveYYPluginManager2 = LiveYYPluginManager.this;
                        if (liveYYPluginManager2.isFirst && liveYYPluginManager2.mStatInfo != null) {
                            LiveYYPluginManager.this.mYYLiveNPSPlugin.updateStatInfo(LiveYYPluginManager.this.mStatInfo);
                        }
                        if (!LiveYYPluginManager.this.isLoadingCanceled) {
                            LiveYYPluginManager.this.mYYLiveNPSPlugin.startYYLiveActivity(context, str);
                        }
                        LiveYYPluginManager.this.isFirst = false;
                    }
                }
            }, USE_FROM_START_YY_LIVE_PAGE, str, context, true);
            return;
        }
        YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "direct");
        this.mYYLiveNPSPlugin.startYYLiveActivity(context, str);
    }

    public void updatePluginLoadProgress(String str, long j, long j2) {
        if (YYPluginProgressInvokeService.Companion.getSUB_PLUGIN_PROGRESS().equals(str) && this.loadingCallback != null) {
            dLog("updatePluginLoadProgress, current = " + j + ", total = " + j2);
            long j3 = (j2 / 2) + (j / 2);
            if ((j3 * 100) / j2 < 50) {
                this.loadingCallback.onLoadingProgress(50L, 100L);
            } else {
                this.loadingCallback.onLoadingProgress(j3, j2);
            }
        }
    }
}
