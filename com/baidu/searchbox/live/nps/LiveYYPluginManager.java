package com.baidu.searchbox.live.nps;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Consumer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.interfaces.yy.YYStaticConfig;
import com.baidu.searchbox.live.interfaces.yy.plugin.YYPluginProgressInvokeService;
import com.baidu.searchbox.live.nps.util.SchemeParamsParseUtils;
import com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager;
import com.baidu.tieba.R;
import com.baidu.tieba.a91;
import com.baidu.tieba.b91;
import com.baidu.tieba.y81;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class LiveYYPluginManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KET_HOST_EVENT_USER_CANCEL_LOAD_PROGRESS = "user_cancel_load_progress";
    public static final String[] NPS_PLUGIN_SUB_PKG_GROUP;
    public static final int PAYMENT_START_MIN_VERSION = 601500000;
    public static final int PAYMENT_START_PLUGIN_VER_UNAVAILABLE = 400000;
    public static final String TAG = "LiveYYPluginManager";
    public static final String USE_FROM_DISPATCH_YY_ROUTER = "dispatchYYLiveRouter";
    public static final String USE_FROM_LOAD_YY_PLUGIN = "loadYYPlugin";
    public static final String USE_FROM_START_PAYMENT = "startPayment";
    public static final String USE_FROM_START_YY_CUSTOMER_PAGE = "startYYCustomerServiceActivity";
    public static final String USE_FROM_START_YY_FEED_BACK_PAGE = "startYYFeedbackActivity";
    public static final String USE_FROM_START_YY_LIVE_PAGE = "startYYLiveActivity";
    public static final String USE_FROM_START_YY_TEST_PAGE = "startYYActivity";
    public static final String YY_NPS_IMPL_CLASS_NAME = "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl";
    public static final String YY_NPS_PKG_NAME = "com.baidu.searchbox.yylive.entrance";
    public static final String YY_NPS_YYLIB_PKG_NAME = "com.baidu.searchbox.yylive.yylib";
    public static final String[] YY_PLUGIN_LIST;
    public transient /* synthetic */ FieldHolder $fh;
    public AppInfoService appService;
    public boolean fromDownLoad;
    public Handler handler;
    public boolean isFirst;
    public boolean isLoadingCanceled;
    public LiveNpsLoadingCallback loadingCallback;
    public PluginLoadCallback mCurrentCallback;
    public Handler mHandler;
    public boolean mLoadingShowing;
    public YYStatInfo mStatInfo;
    public Consumer<Boolean> mSubDismissCallback;
    public IYYLiveNPSPlugin mYYLiveNPSPlugin;
    public boolean markClosedByPlugin;
    public ToastService toastService;
    public LiveYalogApi yalogApi;
    public LiveYalogService yalogService;

    /* loaded from: classes2.dex */
    public interface PluginLoadCallback {
        void onResult(int i, String str, Object obj, String str2);
    }

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final LiveYYPluginManager INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(228577729, "Lcom/baidu/searchbox/live/nps/LiveYYPluginManager$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(228577729, "Lcom/baidu/searchbox/live/nps/LiveYYPluginManager$SingletonHolder;");
                    return;
                }
            }
            INSTANCE = new LiveYYPluginManager();
        }

        public SingletonHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2064347700, "Lcom/baidu/searchbox/live/nps/LiveYYPluginManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2064347700, "Lcom/baidu/searchbox/live/nps/LiveYYPluginManager;");
                return;
            }
        }
        NPS_PLUGIN_SUB_PKG_GROUP = new String[]{YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_1, YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_2, "com.baidu.searchbox.yylive.extlib", "com.baidu.searchbox.yylive.createlive", "com.baidu.searchbox.yylive.game", YY_NPS_YYLIB_PKG_NAME, "com.baidu.searchbox.yylive.audiolive", "com.baidu.searchbox.yylive.friends"};
        YY_PLUGIN_LIST = new String[]{YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_1, YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_2, "com.baidu.searchbox.yylive.extlib", "com.baidu.searchbox.yylive.createlive", "com.baidu.searchbox.yylive.game", YY_NPS_YYLIB_PKG_NAME, "com.baidu.searchbox.yylive.audiolive", "com.baidu.searchbox.yylive.friends"};
    }

    private int compareVersion(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65557, this, i, i2)) == null) ? (i / 1000) - (i2 / 1000) : invokeII.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, str) == null) {
            NpsLoadChainLog.getInstance().dLog(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadUpdatePackage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            NPSPackageManager.getInstance().downloadUpdatePackage("com.baidu.searchbox.yylive.entrance", new y81(this) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveYYPluginManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.tieba.y81
                public void onProgress(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    }
                }

                @Override // com.baidu.tieba.y81
                public void onResult(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                    }
                }
            }, new a91(this) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveYYPluginManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.tieba.a91
                public void checkAuthorization(IBundleInfo iBundleInfo, int i, b91 b91Var) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLIL(1048576, this, iBundleInfo, i, b91Var) == null) || b91Var == null) {
                        return;
                    }
                    b91Var.onResult(1);
                }
            }, 1);
        }
    }

    public static LiveYYPluginManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? SingletonHolder.INSTANCE : (LiveYYPluginManager) invokeV.objValue;
    }

    private boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
            if (bundleGroup == null) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: top plugin is null");
                }
                return false;
            }
            int i = 3;
            BundleInfo bundleByType = bundleGroup.getBundleByType(3);
            int i2 = 2;
            BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
            BundleInfo bundleInfo = bundleByType2 != null ? bundleByType2 : bundleByType;
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
            } else if (bundleByType != null || (bundleByType2 != null && (bundleByType2 == null || bundleByType2.getVersionCode() >= 508000000))) {
                if (bundleByType == null || bundleByType.getVersionCode() >= 508000000 || (bundleByType2 != null && bundleByType2.getVersionCode() >= 508000000)) {
                    if (bundleInfo == null) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: top plugin has no update");
                        }
                        return true;
                    }
                    int length = NPS_PLUGIN_SUB_PKG_GROUP.length;
                    BundleInfoGroup[] bundleInfoGroupArr = new BundleInfoGroup[length];
                    boolean z = true;
                    for (int i3 = 0; i3 < length; i3++) {
                        bundleInfoGroupArr[i3] = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_SUB_PKG_GROUP[i3]);
                        if (bundleInfoGroupArr[i3] != null) {
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
                    int versionCode = bundleInfo2 != null ? bundleInfo2.getVersionCode() : 0;
                    int i4 = 0;
                    while (i4 < length) {
                        if (bundleInfoGroupArr[i4] != null) {
                            BundleInfo bundleByType3 = bundleInfoGroupArr[i4].getBundleByType(i);
                            int versionCode2 = bundleInfo.getVersionCode();
                            String[] strArr = NPS_PLUGIN_SUB_PKG_GROUP;
                            if (isYYPlugin(strArr.length > i4 ? strArr[i4] : "") && versionCode != 0) {
                                versionCode2 = versionCode;
                            }
                            if (bundleByType3 != null && compareVersion(versionCode2, bundleByType3.getVersionCode()) < 0) {
                                if (isDebug()) {
                                    Log.d(TAG, "isAvailable: installed " + bundleByType3.getPackageName() + " plugin too high");
                                }
                                pluginYaLog("isAvailable() pkgName = " + bundleByType3.getPackageName() + ", vesion too hign");
                                return false;
                            }
                            BundleInfo bundleByType4 = bundleInfoGroupArr[i4].getBundleByType(1);
                            BundleInfo bundleByType5 = bundleInfoGroupArr[i4].getBundleByType(i2);
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
                        i4++;
                        i = 3;
                        i2 = 2;
                    }
                    return true;
                }
                return false;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            AppInfoService appInfoService = this.appService;
            if (appInfoService != null) {
                return appInfoService.isDebug();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean isYYPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, str)) == null) {
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
        return invokeL.booleanValue;
    }

    private void loadNPSPluginImpl(PluginLoadCallback pluginLoadCallback, String str, String str2, Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, this, new Object[]{pluginLoadCallback, str, str2, context, Boolean.valueOf(z)}) == null) {
            loadNPSPluginImpl(pluginLoadCallback, str, str2, context, true, false, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logPluginVersionCode() {
        BundleInfo bundleInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65566, this) == null) && NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.yylive.entrance") == 43 && (bundleInfo = NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.yylive.entrance")) != null) {
            Log.d("NPS", "NPS Installed live plugin version code " + bundleInfo.getVersionCode());
            Log.e("NPS", "iscancel" + this.isLoadingCanceled);
        }
    }

    private void npsLoadChainInitOther() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog.getInstance().setEntry("YY-Other");
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pluginYaLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, this, str) == null) {
            LiveYalogApi liveYalogApi = this.yalogApi;
            if (liveYalogApi != null) {
                liveYalogApi.w("3036", "load-livenps-plugin", str);
            }
            if (isDebug()) {
                Log.e("load-livenps-plugin", "LiveNpsPluginManager load-livenps-plugin msg = " + str);
            }
        }
    }

    private void preLoadYY(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65569, this, j) == null) {
            NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, new IInvokeCallback(this, j) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveYYPluginManager this$0;
                public final /* synthetic */ long val$startTime;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$startTime = j;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, obj) == null) {
                        LiveYYPluginManager liveYYPluginManager = this.this$0;
                        liveYYPluginManager.dLog("LiveYYPluginManager onResult code = " + i + ", msg = " + str + ", clazz = " + obj + ", time = " + (System.currentTimeMillis() - this.val$startTime));
                    }
                }
            });
        }
    }

    private void showLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            pluginYaLog("showLoading, " + this.loadingCallback);
            LiveNpsLoadingCallback liveNpsLoadingCallback = this.loadingCallback;
            if (liveNpsLoadingCallback != null) {
                liveNpsLoadingCallback.onLoadingProgress(0L, 100L);
                this.loadingCallback.onLoadingStart();
                this.mLoadingShowing = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalToast(int i, int i2) {
        ToastService toastService;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65571, this, i, i2) == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.handler.post(new Runnable(this, i, i2) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveYYPluginManager this$0;
                    public final /* synthetic */ int val$duration;
                    public final /* synthetic */ int val$textResId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i), Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$textResId = i;
                        this.val$duration = i2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.appService == null || this.this$0.toastService == null) {
                            return;
                        }
                        this.this$0.toastService.showNormal(this.this$0.appService.getApplication(), this.this$0.appService.getApplication().getResources().getString(this.val$textResId), this.val$duration);
                    }
                });
                return;
            }
            AppInfoService appInfoService = this.appService;
            if (appInfoService == null || (toastService = this.toastService) == null) {
                return;
            }
            toastService.showNormal(appInfoService.getApplication(), this.appService.getApplication().getResources().getString(i), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLoading(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65572, this, i, str) == null) {
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
    }

    public void cancelLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            pluginYaLog("cancelLoading");
            this.isLoadingCanceled = true;
            Consumer<Boolean> consumer = this.mSubDismissCallback;
            if (consumer != null) {
                consumer.accept(Boolean.TRUE);
            }
            this.mSubDismissCallback = null;
            this.mLoadingShowing = false;
        }
    }

    public void cancelStartYYLiveActivity() {
        IYYLiveNPSPlugin iYYLiveNPSPlugin;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iYYLiveNPSPlugin = this.mYYLiveNPSPlugin) == null) {
            return;
        }
        try {
            iYYLiveNPSPlugin.cancelStartYYLiveActivity();
        } catch (AbstractMethodError e) {
            e.printStackTrace();
        }
    }

    public void dispatchHostEvent(Context context, String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, map) == null) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveYYPluginManager dispatchHostEvent " + str + GlideException.IndentedAppendable.INDENT + this.mYYLiveNPSPlugin);
            IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
            if (iYYLiveNPSPlugin != null) {
                iYYLiveNPSPlugin.dispatchHostEvent(context, str, map);
            }
        }
    }

    public void dispatchYYLiveRouter(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
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
                loadNPSPluginImpl(new PluginLoadCallback(this, str, context) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveYYPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$url;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$url = str;
                        this.val$context = context;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
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
                                    String parserYYSchemaUrl = MultiPluginHelper.parserYYSchemaUrl(this.val$url);
                                    YYStaticConfig.conf.put("PreJoinChannelType", "Schema");
                                    YYStaticConfig.conf.put("PreJoinChannelSchemaUrl", parserYYSchemaUrl);
                                    LiveYYPluginManager liveYYPluginManager = this.this$0;
                                    liveYYPluginManager.dLog("schemaUrl = " + parserYYSchemaUrl);
                                    this.this$0.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                    if (!this.this$0.isLoadingCanceled) {
                                        this.this$0.mYYLiveNPSPlugin.dispatchYYLiveRouter(this.val$context, this.val$url);
                                    }
                                    this.this$0.logPluginVersionCode();
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                        }
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
    }

    public ILiveYYMixEntry getLiveYYMixEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
            if (iYYLiveNPSPlugin == null || iYYLiveNPSPlugin.getLiveYYMixEntry() == null) {
                return null;
            }
            return this.mYYLiveNPSPlugin.getLiveYYMixEntry();
        }
        return (ILiveYYMixEntry) invokeV.objValue;
    }

    public int getPluginInstallVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.yylive.entrance");
            if (bundleInfo == null) {
                return 0;
            }
            return bundleInfo.getVersionCode();
        }
        return invokeV.intValue;
    }

    public boolean isLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mYYLiveNPSPlugin != null : invokeV.booleanValue;
    }

    public boolean isMiniLibPluginLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadPlugin(Context context, String str, String str2, boolean z, com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, str, str2, Boolean.valueOf(z), pluginLoadCallback}) == null) {
            loadPlugin(context, str, str2, z, pluginLoadCallback, null);
        }
    }

    public void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), iLiveDiskClearCacheCallback}) == null) || NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.yylive.entrance") == null) {
            return;
        }
        npsLoadChainInitOther();
        IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
        if (iYYLiveNPSPlugin == null) {
            loadNPSPluginImpl(new PluginLoadCallback(this, j, i, i2, iLiveDiskClearCacheCallback) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveYYPluginManager this$0;
                public final /* synthetic */ ILiveDiskClearCacheCallback val$callback;
                public final /* synthetic */ int val$newState;
                public final /* synthetic */ int val$oldState;
                public final /* synthetic */ long val$quota;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), iLiveDiskClearCacheCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$quota = j;
                    this.val$oldState = i;
                    this.val$newState = i2;
                    this.val$callback = iLiveDiskClearCacheCallback;
                }

                @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                public void onResult(int i3, String str, Object obj, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), str, obj, str2}) == null) {
                        if (i3 == 14) {
                            try {
                                this.this$0.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                this.this$0.mYYLiveNPSPlugin.onDiskClearCacheChange(this.val$quota, this.val$oldState, this.val$newState, this.val$callback);
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                    }
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

    public void onPluginLoadedState(String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
        }
    }

    public void setLoadingCallback(LiveNpsLoadingCallback liveNpsLoadingCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, liveNpsLoadingCallback) == null) {
            this.loadingCallback = liveNpsLoadingCallback;
        }
    }

    public void showLoadingBySubPlugin(Consumer<Boolean> consumer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, consumer) == null) {
            pluginYaLog("showLoadingBySubPlugin, " + this.loadingCallback);
            if (!this.mLoadingShowing) {
                showLoading();
            }
            this.markClosedByPlugin = true;
            this.mSubDismissCallback = consumer;
        }
    }

    public void startPayment(Context context, IPaymentStateCallback iPaymentStateCallback, IPaymentLogDelegate iPaymentLogDelegate, String str, Long l, Boolean bool, Map<String, String> map, Map<String, Object> map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, iPaymentStateCallback, iPaymentLogDelegate, str, l, bool, map, map2}) == null) {
            dLog("startPayment--调起YY收银台，插件版本号 = " + getPluginInstallVersion());
            if (this.mYYLiveNPSPlugin == null) {
                loadNPSPluginImpl(new PluginLoadCallback(this, context, iPaymentStateCallback, iPaymentLogDelegate, str, l, bool, map, map2) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveYYPluginManager this$0;
                    public final /* synthetic */ Long val$amount;
                    public final /* synthetic */ IPaymentStateCallback val$callback;
                    public final /* synthetic */ Boolean val$closeOnSuc;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ Map val$customExpandParams;
                    public final /* synthetic */ Map val$extraParams;
                    public final /* synthetic */ IPaymentLogDelegate val$logDelegate;
                    public final /* synthetic */ String val$title;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, iPaymentStateCallback, iPaymentLogDelegate, str, l, bool, map, map2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$callback = iPaymentStateCallback;
                        this.val$logDelegate = iPaymentLogDelegate;
                        this.val$title = str;
                        this.val$amount = l;
                        this.val$closeOnSuc = bool;
                        this.val$extraParams = map;
                        this.val$customExpandParams = map2;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i == 14) {
                                try {
                                    this.this$0.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                    if (!this.this$0.isLoadingCanceled) {
                                        int pluginInstallVersion = this.this$0.getPluginInstallVersion();
                                        if (pluginInstallVersion >= 601500000) {
                                            this.this$0.mYYLiveNPSPlugin.startPayment(this.val$context, this.val$callback, this.val$logDelegate, this.val$title, this.val$amount, this.val$closeOnSuc, this.val$extraParams, this.val$customExpandParams);
                                        } else {
                                            String str4 = "startPayment check plugin version not available." + pluginInstallVersion;
                                            if (this.val$callback != null) {
                                                this.val$callback.onFail(Integer.valueOf((int) LiveYYPluginManager.PAYMENT_START_PLUGIN_VER_UNAVAILABLE), str4, null);
                                            }
                                            this.this$0.pluginYaLog(str4);
                                        }
                                    }
                                    this.this$0.logPluginVersionCode();
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                        }
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
    }

    public void startYYActivity(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveYYPluginManager startYYLiveActivity " + this.mYYLiveNPSPlugin);
            npsLoadChainInitOther();
            IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
            if (iYYLiveNPSPlugin == null) {
                loadNPSPluginImpl(new PluginLoadCallback(this, context) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveYYPluginManager this$0;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            if (i == 14) {
                                try {
                                    this.this$0.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                    if (!this.this$0.isLoadingCanceled) {
                                        this.this$0.mYYLiveNPSPlugin.startYYActivity(this.val$context);
                                    }
                                    this.this$0.logPluginVersionCode();
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                        }
                    }
                }, USE_FROM_START_YY_TEST_PAGE, "", context, true);
                return;
            }
            iYYLiveNPSPlugin.startYYActivity(context);
            logPluginVersionCode();
        }
    }

    public void startYYCustomerServiceActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, context, str) == null) {
            dLog("startYYCustomerServiceActivity--进入YY客服页面，初始化NpsLoadChainLog，设置Entry，插件版本号 = " + getPluginInstallVersion());
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog.getInstance().setEntry("YY-CustomerService");
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
            IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
            if (iYYLiveNPSPlugin == null) {
                loadNPSPluginImpl(new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveYYPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$url;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$url = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i == 14) {
                                try {
                                    this.this$0.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                    if (!this.this$0.isLoadingCanceled) {
                                        this.this$0.mYYLiveNPSPlugin.startYYCustomerServiceActivity(this.val$context, this.val$url);
                                    }
                                    this.this$0.logPluginVersionCode();
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                        }
                    }
                }, USE_FROM_START_YY_CUSTOMER_PAGE, str, context, true);
                return;
            }
            iYYLiveNPSPlugin.startYYCustomerServiceActivity(context, str);
            logPluginVersionCode();
        }
    }

    public void startYYFeedbackActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, str) == null) {
            dLog("startYYFeedbackActivity--进入YY反馈页面，初始化NpsLoadChainLog，设置Entry，插件版本号 = " + getPluginInstallVersion());
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog.getInstance().setEntry("YY-Feedback");
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
            IYYLiveNPSPlugin iYYLiveNPSPlugin = this.mYYLiveNPSPlugin;
            if (iYYLiveNPSPlugin == null) {
                loadNPSPluginImpl(new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveYYPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$url;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$context = context;
                        this.val$url = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i == 14) {
                                try {
                                    this.this$0.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                                    if (!this.this$0.isLoadingCanceled) {
                                        this.this$0.mYYLiveNPSPlugin.startYYFeedbackActivity(this.val$context, this.val$url);
                                    }
                                    this.this$0.logPluginVersionCode();
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                        }
                    }
                }, USE_FROM_START_YY_FEED_BACK_PAGE, str, context, true);
                return;
            }
            iYYLiveNPSPlugin.startYYFeedbackActivity(context, str);
            logPluginVersionCode();
        }
    }

    public void startYYLiveActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, context, str) == null) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveYYPluginManager startYYLiveActivity " + str + GlideException.IndentedAppendable.INDENT + this.mYYLiveNPSPlugin);
            if (YYStaticConfig.conf == null) {
                YYStaticConfig.conf = new HashMap<>();
            }
            YYStaticConfig.conf.put("hostJoinLiveBegin", Long.valueOf(System.currentTimeMillis()));
            if (this.mYYLiveNPSPlugin == null) {
                loadNPSPluginImpl(new PluginLoadCallback(this, str, context) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveYYPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$url;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$url = str;
                        this.val$context = context;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) && i == 14) {
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
                                Map<String, String> parseYYLiveParamMap = SchemeParamsParseUtils.parseYYLiveParamMap(this.val$url);
                                LiveYYPluginManager liveYYPluginManager = this.this$0;
                                liveYYPluginManager.dLog("parseYYLiveParamMap " + parseYYLiveParamMap);
                                YYStaticConfig.conf.putAll(parseYYLiveParamMap);
                                this.this$0.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            LiveYYPluginManager liveYYPluginManager2 = this.this$0;
                            if (liveYYPluginManager2.isFirst && liveYYPluginManager2.mStatInfo != null) {
                                this.this$0.mYYLiveNPSPlugin.updateStatInfo(this.this$0.mStatInfo);
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.mYYLiveNPSPlugin.startYYLiveActivity(this.val$context, this.val$url);
                            }
                            this.this$0.isFirst = false;
                        }
                    }
                }, USE_FROM_START_YY_LIVE_PAGE, str, context, true);
                return;
            }
            YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "direct");
            this.mYYLiveNPSPlugin.startYYLiveActivity(context, str);
        }
    }

    public void stopLoadingBySubPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            pluginYaLog("stopLoadingBySubPlugin, " + this.mSubDismissCallback);
            LiveNpsLoadingCallback liveNpsLoadingCallback = this.loadingCallback;
            if (liveNpsLoadingCallback != null) {
                liveNpsLoadingCallback.onLoadingProgress(100L, 100L);
                this.loadingCallback.onLoadingEnd(-1);
                this.mLoadingShowing = false;
            }
            this.mSubDismissCallback = null;
        }
    }

    public void updatePluginLoadProgress(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) && YYPluginProgressInvokeService.Companion.getSUB_PLUGIN_PROGRESS().equals(str) && this.loadingCallback != null) {
            dLog("updatePluginLoadProgress, current = " + j + ", total = " + j2);
            long j3 = (j2 / 2) + (j / 2);
            if ((j3 * 100) / j2 < 50) {
                this.loadingCallback.onLoadingProgress(50L, 100L);
            } else {
                this.loadingCallback.onLoadingProgress(j3, j2);
            }
        }
    }

    public void updateStatInfo(YYStatInfo yYStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, yYStatInfo) == null) {
            this.mStatInfo = yYStatInfo;
        }
    }

    public LiveYYPluginManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.mSubDismissCallback = null;
        this.markClosedByPlugin = false;
        this.mLoadingShowing = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.yalogService = (LiveYalogService) ServiceManager.getService(LiveYalogService.Companion.getSERVICE_REFERENCE());
        this.yalogApi = null;
        this.fromDownLoad = false;
        this.isLoadingCanceled = false;
        this.isFirst = true;
        this.handler = new Handler(Looper.getMainLooper());
        LiveYalogService liveYalogService = this.yalogService;
        if (liveYalogService != null) {
            this.yalogApi = liveYalogService.buildYalogApi("live_plugin");
        }
    }

    private void loadNPSPluginImpl(PluginLoadCallback pluginLoadCallback, String str, String str2, Context context, boolean z, boolean z2, boolean z3) {
        BundleInfo bundleInfo;
        BundleInfo bundleInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, this, new Object[]{pluginLoadCallback, str, str2, context, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            NpsLoadChainLog.getInstance().dLog("LiveYYPluginManager loadNPSPluginImpl " + str + GlideException.IndentedAppendable.INDENT + str2);
            this.mCurrentCallback = pluginLoadCallback;
            IInvokeCallback iInvokeCallback = new IInvokeCallback(this) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveYYPluginManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str3, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str3, obj) == null) {
                        LiveYYPluginManager liveYYPluginManager = this.this$0;
                        liveYYPluginManager.pluginYaLog("LiveYYPluginManager Load directly and without install,onResult retCode = " + i + ", retMsg = " + str3 + ", retObj = " + obj);
                        boolean z4 = i == 14;
                        LiveYYPluginManager liveYYPluginManager2 = this.this$0;
                        liveYYPluginManager2.dLog("LiveYYPluginManager 一级加载结束~ invokeSucc = " + z4);
                        if (Looper.myLooper() != Looper.getMainLooper()) {
                            this.this$0.mHandler.post(new Runnable(this, i, str3, obj) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.7.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass7 this$1;
                                public final /* synthetic */ int val$i;
                                public final /* synthetic */ Object val$o;
                                public final /* synthetic */ String val$s;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i), str3, obj};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$i = i;
                                    this.val$s = str3;
                                    this.val$o = obj;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.this$0.mCurrentCallback == null) {
                                        return;
                                    }
                                    this.this$1.this$0.mCurrentCallback.onResult(this.val$i, this.val$s, this.val$o, "load");
                                    this.this$1.this$0.mCurrentCallback = null;
                                }
                            });
                        } else if (this.this$0.mCurrentCallback != null) {
                            this.this$0.mCurrentCallback.onResult(i, str3, obj, "load");
                            this.this$0.mCurrentCallback = null;
                        }
                    }
                }
            };
            IInvokeCallback iInvokeCallback2 = new IInvokeCallback(this) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveYYPluginManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str3, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str3, obj) == null) {
                        LiveYYPluginManager liveYYPluginManager = this.this$0;
                        liveYYPluginManager.pluginYaLog("LiveYYPluginManager Load after install, onResult retCode = " + i + ", retMsg = " + str3 + ", retObj = " + obj);
                        boolean z4 = i == 14;
                        LiveYYPluginManager liveYYPluginManager2 = this.this$0;
                        liveYYPluginManager2.dLog("LiveYYPluginManager 一级安装结束~ invokeSucc = " + z4);
                        String str4 = this.this$0.fromDownLoad ? "download" : "install";
                        if (Looper.myLooper() != Looper.getMainLooper()) {
                            this.this$0.mHandler.post(new Runnable(this, i, str3, obj, str4) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.8.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass8 this$1;
                                public final /* synthetic */ int val$i;
                                public final /* synthetic */ String val$loadType;
                                public final /* synthetic */ Object val$o;
                                public final /* synthetic */ String val$s;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i), str3, obj, str4};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$i = i;
                                    this.val$s = str3;
                                    this.val$o = obj;
                                    this.val$loadType = str4;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.this$0.mCurrentCallback == null) {
                                        return;
                                    }
                                    this.this$1.this$0.mCurrentCallback.onResult(this.val$i, this.val$s, this.val$o, this.val$loadType);
                                    this.this$1.this$0.mCurrentCallback = null;
                                }
                            });
                        } else if (this.this$0.mCurrentCallback != null) {
                            this.this$0.mCurrentCallback.onResult(i, str3, obj, str4);
                            this.this$0.mCurrentCallback = null;
                        }
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
            pluginYaLog("Enter liveworld and load top plugin, useFrom = " + str + ", isTopPluginAvailable = " + isAvailable + ", version { 1 = " + (bundleInfo3 != null ? bundleInfo3.getVersionCode() : 0) + ", 2 = " + (bundleInfo2 != null ? bundleInfo2.getVersionCode() : 0) + ", 3 = " + (bundleInfo != null ? bundleInfo.getVersionCode() : 0) + " }");
            if (isAvailable) {
                this.fromDownLoad = false;
                if (NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance").getBundleByType(2) != null) {
                    ExecutorUtilsExt.postOnElastic(new Runnable(this, z3, iInvokeCallback) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LiveYYPluginManager this$0;
                        public final /* synthetic */ boolean val$enterPage;
                        public final /* synthetic */ IInvokeCallback val$loadCallback;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Boolean.valueOf(z3), iInvokeCallback};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$enterPage = z3;
                            this.val$loadCallback = iInvokeCallback;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.dLog("开始安装 YY 一级");
                                int prepareBundle = NPSPackageManager.getInstance().prepareBundle("com.baidu.searchbox.yylive.entrance");
                                LiveYYPluginManager liveYYPluginManager = this.this$0;
                                liveYYPluginManager.pluginYaLog("Top plugin is available and has downloaded plugin, prepareBundle result = " + prepareBundle + ", and loadClazz");
                                NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                                npsLoadChainLog.setPluginVersion(this.this$0.getPluginInstallVersion() + "");
                                this.this$0.dLog("YY 一级安装结束~成功");
                                this.this$0.mHandler.post(new Runnable(this) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.9.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass9 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            AnonymousClass9 anonymousClass9 = this.this$1;
                                            if (anonymousClass9.val$enterPage) {
                                                anonymousClass9.this$0.pluginYaLog("Top plugin is available and has downloaded plugin, downloadUpdatePackage~");
                                                this.this$1.this$0.downloadUpdatePackage();
                                            }
                                        }
                                    }
                                });
                                NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, this.val$loadCallback);
                            }
                        }
                    }, "nps-preparebundle", 0);
                    return;
                }
                if (z3) {
                    pluginYaLog("Top plugin is available but no downloaded plugin, downloadUpdatePackage");
                    downloadUpdatePackage();
                }
                pluginYaLog("Top plugin is available but no downloaded plugin, directly loadClazz");
                NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, iInvokeCallback);
                return;
            }
            this.isLoadingCanceled = false;
            if (z) {
                showLoading();
            }
            this.fromDownLoad = false;
            dLog("下载 YY 一级 = com.baidu.searchbox.yylive.entrance");
            pluginYaLog("Top plugin is not available and installBundle~");
            NPSPackageManager.getInstance().installBundle("com.baidu.searchbox.yylive.entrance", new IInstallCallback(this, z, str, iInvokeCallback2) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveYYPluginManager this$0;
                public final /* synthetic */ IInvokeCallback val$installedLoadProxyCallback;
                public final /* synthetic */ boolean val$needYYLoading;
                public final /* synthetic */ String val$useFrom;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), str, iInvokeCallback2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$needYYLoading = z;
                    this.val$useFrom = str;
                    this.val$installedLoadProxyCallback = iInvokeCallback2;
                }

                @Override // com.baidu.nps.main.install.IInstallCallback
                public void onProgress(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        LiveYYPluginManager liveYYPluginManager = this.this$0;
                        liveYYPluginManager.pluginYaLog("Install top plugin, onProgress downloadSize = " + j + ", totalSIze = " + j2);
                        this.this$0.fromDownLoad = true;
                        if (this.this$0.loadingCallback != null && !this.this$0.isLoadingCanceled) {
                            if (LiveYYPluginManager.USE_FROM_DISPATCH_YY_ROUTER.equals(this.val$useFrom) || LiveYYPluginManager.USE_FROM_START_YY_FEED_BACK_PAGE.equals(this.val$useFrom) || LiveYYPluginManager.USE_FROM_START_YY_CUSTOMER_PAGE.equals(this.val$useFrom)) {
                                this.this$0.loadingCallback.onLoadingProgress(j / 2, j2);
                            } else {
                                this.this$0.loadingCallback.onLoadingProgress(j, j2);
                            }
                        }
                        LiveYYPluginManager liveYYPluginManager2 = this.this$0;
                        liveYYPluginManager2.dLog("downloadSize = " + j + ", totalSIze = " + j2);
                        if (j >= j2) {
                            this.this$0.dLog("YY 一级下载结束");
                            this.this$0.dLog("开始安装 YY 一级");
                        }
                    }
                }

                @Override // com.baidu.nps.main.install.IInstallCallback
                public void onResult(int i, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str3) == null) {
                        LiveYYPluginManager liveYYPluginManager = this.this$0;
                        liveYYPluginManager.pluginYaLog("Install top plugin, onResult retCode = " + i + ", retMsg = " + str3);
                        if (this.val$needYYLoading && i != 34) {
                            this.this$0.stopLoading(i, this.val$useFrom);
                        }
                        if (i == 13) {
                            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                            npsLoadChainLog.setPluginVersion(this.this$0.getPluginInstallVersion() + "");
                            this.this$0.dLog("YY 一级插件安装结束~成功");
                            this.this$0.dLog("开始加载 YY 一级");
                            this.this$0.pluginYaLog("Install top plugin Success loadClazz");
                            NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, this.val$installedLoadProxyCallback);
                        } else if (i != 3 || NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.yylive.entrance") != 43) {
                            this.this$0.pluginYaLog("Install top plugin Fail, so not loadClazz");
                            LiveYYPluginManager liveYYPluginManager2 = this.this$0;
                            liveYYPluginManager2.dLog("YY 一级安装结束~失败 rerCode = " + i);
                            if (this.val$needYYLoading) {
                                if (i == 34) {
                                    if (this.this$0.loadingCallback == null) {
                                        this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d1, 0);
                                        return;
                                    }
                                    return;
                                }
                                this.this$0.mCurrentCallback = null;
                                this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                            }
                        } else {
                            NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                            npsLoadChainLog2.setPluginVersion(this.this$0.getPluginInstallVersion() + "");
                            this.this$0.dLog("YY 一级安装结束~成功");
                            this.this$0.dLog("开始加载YY 一级");
                            this.this$0.pluginYaLog("Install top plugin no data and is available, so loadClazz");
                            NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, this.val$installedLoadProxyCallback);
                        }
                    }
                }
            });
        }
    }

    public void loadPlugin(Context context, String str, String str2, boolean z, com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, str, str2, Boolean.valueOf(z), pluginLoadCallback, map}) == null) && "com.baidu.searchbox.yylive.entrance".equals(str)) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveYYPluginManager loadPlugin " + str + GlideException.IndentedAppendable.INDENT + str2);
            loadNPSPluginImpl(new PluginLoadCallback(this, pluginLoadCallback) { // from class: com.baidu.searchbox.live.nps.LiveYYPluginManager.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveYYPluginManager this$0;
                public final /* synthetic */ com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback val$loadCallback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, pluginLoadCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$loadCallback = pluginLoadCallback;
                }

                @Override // com.baidu.searchbox.live.nps.LiveYYPluginManager.PluginLoadCallback
                public void onResult(int i, String str3, Object obj, String str4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str3, obj, str4}) == null) {
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
                                this.this$0.mYYLiveNPSPlugin = (IYYLiveNPSPlugin) ((Class) obj).newInstance();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback2 = this.val$loadCallback;
                            if (pluginLoadCallback2 != null) {
                                pluginLoadCallback2.onResult(true, i, str3);
                                return;
                            }
                            return;
                        }
                        com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback3 = this.val$loadCallback;
                        if (pluginLoadCallback3 != null) {
                            pluginLoadCallback3.onResult(false, i, str3);
                        }
                    }
                }
            }, USE_FROM_LOAD_YY_PLUGIN, str2, context, z, (context instanceof Activity) && z, true);
        }
    }
}
