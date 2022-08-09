package com.baidu.searchbox.live.nps;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pass.biometrics.face.liveness.b.a;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.live.chainlog.NpsLoadChainLog;
import com.baidu.searchbox.live.goback.IYYGobackController;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveStatusDataCallback;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.FloatingService;
import com.baidu.searchbox.live.interfaces.service.LiveYalogService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.smallwindow.IYYSmallWindowController;
import com.baidu.searchbox.live.interfaces.storage.IYYStorageController;
import com.baidu.searchbox.live.interfaces.yalog.LiveYalogApi;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.mix.proxy.LiveMixShellManager;
import com.baidu.searchbox.live.recommendmore.ILiveRecMoreController;
import com.baidu.searchbox.live.ubc.FlowInfoHelper;
import com.baidu.searchbox.live.ubc.MediaLivePlayLogger;
import com.baidu.searchbox.live.ubc.MediaLivePluginLogger;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import com.bumptech.glide.load.engine.GlideException;
import com.repackage.p61;
import com.repackage.r61;
import com.repackage.s61;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveMediaPluginManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUDIO_CREATE_LIVE_ROOM_H5 = "AUDIO_CREATE_LIVE_ROOM_H5";
    public static final String BJH_PLUGIN_PKG_NAME = "com.baidu.searchbox.bjhlivenps";
    public static final int LIVE_PLUGIN_SUPPORT_GET_PLAY_CONFIG_MIM_VERSION = 601500000;
    public static final String LIVE_SHOW_ADMIN_LIST = "LIVE_SHOW_ADMIN_LIST";
    public static final String LIVE_SHOW_CHECK_AR = "LIVE_SHOW_CHECK_AR";
    public static final String LIVE_SHOW_CREATE_ROOM = "LIVE_SHOW_CREATE_ROOM";
    public static final String LIVE_SHOW_ENTER_LIVE_ROOM = "LIVE_SHOW_ENTER_LIVE_ROOM";
    public static final String LIVE_SHOW_FANS_LIST = "LIVE_SHOW_FANS_LIST";
    public static final String LIVE_SHOW_FORBIDDEN_LIST = "LIVE_SHOW_FORBIDDEN_LIST";
    public static final String LIVE_SHOW_GUARD_LIST = "LIVE_SHOW_GUARD_LIST";
    public static final String LIVE_SHOW_LIVE_EXP = "LIVE_SHOW_LIVE_EXP";
    public static final String LIVE_SHOW_LOAD_AR = "LIVE_SHOW_LOAD_AR";
    public static final String LIVE_SHOW_REAL_AUTH = "LIVE_SHOW_REAL_AUTH";
    public static final String LIVE_SHOW_START_PATRONAGE = "LIVE_SHOW_START_PATRONAGE";
    public static final String LIVE_SHOW_START_PATRONS = "LIVE_SHOW_START_PATRONS";
    public static final String LIVE_SHOW_START_PAY = "LIVE_SHOW_START_PAY";
    public static final String LOAD_FROM_NPS_DOWNLOAD = "nps_download";
    public static final String LOAD_FROM_NPS_INSTALL = "nps_install";
    public static final String LOAD_FROM_NPS_LOAD = "nps_load";
    public static final String MEDIA_BJH_CREATE_LIVE_ROOM = "MEDIA_BJH_CREATE_LIVE_ROOM";
    public static final String MEDIA_BUSINESS_PKG_NAME = "com.baidu.live.media.business";
    public static final String MEDIA_ENTER_LIVE_ROOM = "MEDIA_ENTER_LIVE_ROOM";
    public static final String MEDIA_MASTER_ROUTER = "MEDIA_MASTER_ROUTER";
    public static final String NEW_CLEAR_RESOURCE_FILE = "NEW_CLEAR_RESOURCE_FILE";
    public static final String NEW_CREATE_LIVE_ROOM = "NEW_CREATE_LIVE_ROOM";
    public static final String NEW_GET_LIVE_ROOM_STATUS = "NEW_GET_LIVE_ROOM_STATUS";
    public static final String NEW_GET_LIVE_SDK_FILE_SIZE = "NEW_GET_LIVE_SDK_FILE_SIZE";
    public static final String NEW_GET_RESOURCE_FILE_SIZE = "NEW_GET_RESOURCE_FILE_SIZE";
    public static final String NEW_IS_HISTORY = "NEW_IS_HISTORY";
    public static final String NEW_ON_DISK_CLEAR_CACHE_CHANGE = "NEW_ON_DISK_CLEAR_CACHE_CHANGE";
    public static final String NPS_PLUGIN_IMPL_CLASS_NAME = "com.baidu.searchbox.live.LiveNPSPluginImpl";
    public static final String NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public static final String[] NPS_PLUGIN_SUB_PKG_GROUP;
    public static final String PAGE_SLOT_PAGE_PLUGIN_INSTALL = "plugin_install";
    public static final String PAGE_SLOT_PAGE_PLUGIN_LOAD = "plugin_load";
    public static final String TAG = "LIVE_PLUGIN";
    public static final String UBC_ID_PLUGIN_END = "3185";
    public static final String UBC_ID_PLUGIN_START = "3186";
    public static final String USE_FROM_FETCH_RECOM = "reccom";
    public static final String USE_FROM_MIX_LOAD_PLUGIN = "mixLoadPlugin";
    public static final String USE_FROM_START_LIVE_PAGE = "startLiveActivity";
    public static final String YU_YIN_CREATE_LIVE_ROOM = "YU_YIN_CREATE_LIVE_ROOM";
    public static final String YU_YIN_ENTER_LIVE_ROOM = "YU_YIN_ENTER_LIVE_ROOM";
    public static final String YY_CUSTOMER_SERVICE = "YY_CUSTOMER_SERVICE";
    public static final String YY_ENTER_LIVE_ROOM = "YY_ENTER_LIVE_ROOM";
    public static final String YY_FEED_BACK = "YY_FEED_BACK";
    public static final String YY_LIVE_ROUTER = "YY_LIVE_ROUTER";
    public static final String YY_TEST_ENTER_LIVE_ROOM = "YY_TEST_ENTER_LIVE_ROOM";
    public transient /* synthetic */ FieldHolder $fh;
    public AppInfoService appService;
    public boolean fromDownLoad;
    public Handler handler;
    public boolean isLoadingCanceled;
    public LiveNpsLoadingCallback loadingCallback;
    public PluginLoadCallback mCurrentCallback;
    public Handler mHandler;
    public HashMap<String, Object> mLaunchInfo;
    public ILiveNPSPlugin mLiveNPSPlugin;
    public volatile boolean mLiveNpsPreload;
    public ToastService toastService;
    public UBCManager ubcManager;
    public LiveYalogApi yalogApi;
    public LiveYalogService yalogService;

    /* loaded from: classes2.dex */
    public interface PluginLoadCallback {
        void onResult(int i, String str, Object obj, String str2);
    }

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final LiveMediaPluginManager INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(245574047, "Lcom/baidu/searchbox/live/nps/LiveMediaPluginManager$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(245574047, "Lcom/baidu/searchbox/live/nps/LiveMediaPluginManager$SingletonHolder;");
                    return;
                }
            }
            INSTANCE = new LiveMediaPluginManager();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(986072594, "Lcom/baidu/searchbox/live/nps/LiveMediaPluginManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(986072594, "Lcom/baidu/searchbox/live/nps/LiveMediaPluginManager;");
                return;
            }
        }
        NPS_PLUGIN_SUB_PKG_GROUP = new String[]{BJH_PLUGIN_PKG_NAME, "com.baidu.live.media.business"};
    }

    private int compareVersion(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65558, this, i, i2)) == null) ? (i / 1000) - (i2 / 1000) : invokeII.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, str) == null) {
            NpsLoadChainLog.getInstance().dLog(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadUpdatePackage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            NPSPackageManager.getInstance().downloadUpdatePackage("com.baidu.searchbox.livenps", new p61(this) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveMediaPluginManager this$0;

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

                @Override // com.repackage.p61
                public void onProgress(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    }
                }

                @Override // com.repackage.p61
                public void onResult(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                    }
                }
            }, new r61(this) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveMediaPluginManager this$0;

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

                @Override // com.repackage.r61
                public void checkAuthorization(IBundleInfo iBundleInfo, int i, s61 s61Var) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLIL(1048576, this, iBundleInfo, i, s61Var) == null) || s61Var == null) {
                        return;
                    }
                    s61Var.onResult(1);
                }
            }, 1);
            BundleInfo bundleByType = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps").getBundleByType(3);
            BundleInfo bundleByType2 = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps").getBundleByType(1);
            if (bundleByType == null || bundleByType2 == null || bundleByType.getVersionCode() >= 505500000 || bundleByType2.getVersionCode() < 505500000) {
                return;
            }
            pluginYaLog("downloadUpdatePackage and need preDownloadMediaBusinessPlugin");
            preDownloadMediaBusinessPlugin();
        }
    }

    public static LiveMediaPluginManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? SingletonHolder.INSTANCE : (LiveMediaPluginManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
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

    private void loadLiveNpsPlugin(Context context, String str, String str2, com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65563, this, context, str, str2, pluginLoadCallback) == null) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveMediaPluginManager loadPlugin " + this.mLiveNPSPlugin);
            if (this.mLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, true, new PluginLoadCallback(this, pluginLoadCallback) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveMediaPluginManager this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                    public void onResult(int i, String str3, Object obj, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str3, obj, str4}) == null) {
                            NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                            npsLoadChainLog2.dLog("LiveMediaPluginManager loadPluginonResult " + i + GlideException.IndentedAppendable.INDENT + str3 + GlideException.IndentedAppendable.INDENT + obj + GlideException.IndentedAppendable.INDENT + str4);
                            if (i == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.val$loadCallback != null) {
                                        this.val$loadCallback.onResult(true, i, str3);
                                        return;
                                    }
                                    return;
                                } catch (Exception e) {
                                    NpsLoadChainLog npsLoadChainLog3 = NpsLoadChainLog.getInstance();
                                    npsLoadChainLog3.dLog("LiveMediaPluginManager loadPluginException " + e.getMessage());
                                    return;
                                }
                            }
                            com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback2 = this.val$loadCallback;
                            if (pluginLoadCallback2 != null) {
                                pluginLoadCallback2.onResult(false, i, str3);
                            }
                        }
                    }
                }, str2, str, context);
            } else if (pluginLoadCallback != null) {
                pluginLoadCallback.onResult(true, 14, "");
            }
        }
    }

    private void loadNPSPluginImpl(boolean z, boolean z2, PluginLoadCallback pluginLoadCallback, String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), pluginLoadCallback, str, context}) == null) {
            loadNPSPluginImpl(z, z2, pluginLoadCallback, str, "", "", context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logPluginEnd(String str, int i, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65567, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), str2, str3, str4}) == null) || this.ubcManager == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "live");
            jSONObject.put("type", "end_load");
            jSONObject.put("source", str3);
            if (z) {
                jSONObject.put("value", "suc");
            } else {
                jSONObject.put("value", a.g0);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkg", str);
            jSONObject2.put("ver", i);
            jSONObject2.put("useFrom", str4);
            jSONObject2.put("reason", str2);
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.ubcManager.onEvent("3185", jSONObject);
    }

    private void logPluginLoad(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65568, this, str, str2) == null) || this.ubcManager == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "live");
            jSONObject.put("type", "start_load");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkg", str);
            jSONObject2.put("useFrom", str2);
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.ubcManager.onEvent("3186", jSONObject);
    }

    private void npsLoadChainInitMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog.getInstance().setEntry("YY-Media");
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        }
    }

    private void npsLoadChainInitOther() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog.getInstance().setEntry("YY-Other");
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        }
    }

    private void npsLoadChainInitStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog.getInstance().setEntry("YY-StartLive");
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        }
    }

    private void pluginYaLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, this, str) == null) {
            LiveYalogApi liveYalogApi = this.yalogApi;
            if (liveYalogApi != null) {
                liveYalogApi.w("3036", "load-livenps-plugin", str);
            }
            if (isDebug()) {
                Log.e("load-livenps-plugin", "LiveMediaPluginManager load-livenps-plugin msg = " + str);
            }
        }
    }

    private void preDownloadMediaBusinessPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            if (isDebug()) {
                dLog("preDownloadMediaBusinessPlugin 预加载媒体二级插件");
                Log.d(TAG, "preDownloadYYPluginForCreateLive: + com.baidu.live.media.business start Download");
            }
            NPSPackageManager.getInstance().downloadBundle("com.baidu.live.media.business", new p61(this) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveMediaPluginManager this$0;

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

                @Override // com.repackage.p61
                public void onProgress(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.this$0.isDebug()) {
                        LiveMediaPluginManager liveMediaPluginManager = this.this$0;
                        liveMediaPluginManager.dLog("preDownloadMediaBusinessPlugin 媒体二级插件进度 total = " + j2 + ", current = " + j);
                        Log.d(LiveMediaPluginManager.TAG, "preDownloadYYPluginForCreateLive: + com.baidu.live.media.business is Downloading, cur=" + j + " total=" + j2);
                    }
                }

                @Override // com.repackage.p61
                public void onResult(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && this.this$0.isDebug()) {
                        if (i == 2) {
                            this.this$0.dLog("preDownloadMediaBusinessPlugin 媒体二级插件加载【成功】");
                            Log.d(LiveMediaPluginManager.TAG, "preDownloadYYPluginForCreateLive: + com.baidu.live.media.business Download succeed");
                            return;
                        }
                        this.this$0.dLog("preDownloadMediaBusinessPlugin 媒体二级插件加载【~失败~】");
                        Log.d(LiveMediaPluginManager.TAG, "preDownloadYYPluginForCreateLive: + com.baidu.live.media.business Download failed, code=" + i + " msg=" + str);
                    }
                }
            });
        }
    }

    private void preLoadLiveNps(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65574, this, j) == null) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveMediaPluginManager preLoadLiveNps " + j);
            NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, new IInvokeCallback(this, j) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveMediaPluginManager this$0;
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
                        LiveMediaPluginManager liveMediaPluginManager = this.this$0;
                        liveMediaPluginManager.dLog("onResult code = " + i + ", msg = " + str + ", clazz = " + obj + ", time = " + (System.currentTimeMillis() - this.val$startTime));
                        if (i == 14) {
                            this.this$0.mLiveNpsPreload = true;
                        }
                    }
                }
            });
        }
    }

    private void showLoading() {
        LiveNpsLoadingCallback liveNpsLoadingCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65575, this) == null) || (liveNpsLoadingCallback = this.loadingCallback) == null) {
            return;
        }
        liveNpsLoadingCallback.onLoadingStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalToast(int i, int i2) {
        ToastService toastService;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65576, this, i, i2) == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.handler.post(new Runnable(this, i, i2) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.22
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveMediaPluginManager this$0;
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
    public void stopLoading(int i) {
        LiveNpsLoadingCallback liveNpsLoadingCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65577, this, i) == null) || (liveNpsLoadingCallback = this.loadingCallback) == null) {
            return;
        }
        liveNpsLoadingCallback.onLoadingEnd(i);
    }

    public void cancelLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.isLoadingCanceled = true;
        }
    }

    public void closeSmallWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, false, new PluginLoadCallback(this) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.21
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveMediaPluginManager this$0;

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

                    @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                            npsLoadChainLog.dLog("LiveMediaPluginManager smallWindowSwitch loadPluginonResult " + i + GlideException.IndentedAppendable.INDENT + str + GlideException.IndentedAppendable.INDENT + obj + GlideException.IndentedAppendable.INDENT + str2);
                            if (i == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.mLiveNPSPlugin == null || this.this$0.mLiveNPSPlugin.getLiveMediaEntry() == null || this.this$0.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController().closeSmallWindow();
                                } catch (Exception e) {
                                    NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                                    npsLoadChainLog2.dLog("LiveMediaPluginManager smallWindowSwitch loadPluginException " + e.getMessage());
                                }
                            }
                        }
                    }
                }, "closeSmallWindow", LiveNpsRuntime.getApplication());
            } else if (iLiveNPSPlugin == null || iLiveNPSPlugin.getLiveMediaEntry() == null || this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController() == null) {
            } else {
                this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController().closeSmallWindow();
            }
        }
    }

    public void dispatchHostEvent(Context context, String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, map) == null) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveMediaPluginManager dispatchHostEvent " + str);
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin != null) {
                iLiveNPSPlugin.dispatchHostEvent(context, str, map);
                if (this.mLiveNPSPlugin.getLiveMediaEntry() != null) {
                    this.mLiveNPSPlugin.getLiveMediaEntry().dispatchHostEvent(context, str, map);
                }
            }
        }
    }

    public void dispatchLiveMasterRouter(@NonNull Application application, String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, application, str, map) == null) {
            npsLoadChainInitStart();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, false, new PluginLoadCallback(this, application, str, map) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveMediaPluginManager this$0;
                    public final /* synthetic */ Application val$packageContext;
                    public final /* synthetic */ Map val$params;
                    public final /* synthetic */ String val$path;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, application, str, map};
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
                        this.val$packageContext = application;
                        this.val$path = str;
                        this.val$params = map;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveBjhEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveBjhEntry().dispatchLiveMasterRouter(this.val$packageContext, this.val$path, this.val$params);
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveMediaPluginManager.TAG, "load live nps plugin error=" + i);
                            }
                        }
                    }
                }, "dispatchLiveMasterRouter", application);
            } else if (iLiveNPSPlugin.getLiveBjhEntry() != null) {
                this.mLiveNPSPlugin.getLiveBjhEntry().dispatchLiveMasterRouter(application, str, map);
            }
        }
    }

    public int getInstallPluginVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo(str);
            if (bundleInfo == null) {
                return 0;
            }
            return bundleInfo.getVersionCode();
        }
        return invokeL.intValue;
    }

    public void getLiveRoomStatus(@NonNull String str, @NonNull LiveStatusDataCallback<String> liveStatusDataCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, liveStatusDataCallback) == null) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveMediaPluginManager getLiveRoomStatus " + str);
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, false, new PluginLoadCallback(this, str, liveStatusDataCallback) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveMediaPluginManager this$0;
                    public final /* synthetic */ LiveStatusDataCallback val$callback;
                    public final /* synthetic */ String val$roomId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, liveStatusDataCallback};
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
                        this.val$roomId = str;
                        this.val$callback = liveStatusDataCallback;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    this.this$0.mLiveNPSPlugin.getLiveRoomStatus(this.val$roomId, this.val$callback);
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                            if (this.this$0.isDebug()) {
                                Log.w(LiveMediaPluginManager.TAG, "load live nps plugin error=" + i);
                            }
                        }
                    }
                }, "getLiveRoomStatus", LiveNpsRuntime.getApplication());
            } else {
                iLiveNPSPlugin.getLiveRoomStatus(str, liveStatusDataCallback);
            }
        }
    }

    public Map<String, Object> getMediaLivePlayConfig(String str, Map<String, Object> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, map)) == null) {
            if (this.mLiveNPSPlugin == null || getInstallPluginVersion("com.baidu.searchbox.livenps") < 601500000) {
                return null;
            }
            return this.mLiveNPSPlugin.getPlayConfig(str, map);
        }
        return (Map) invokeLL.objValue;
    }

    public IMixActivityInterface getMixActivityImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            NpsLoadChainLog.getInstance().dLog("LiveMediaPluginManager getMixActivityImpl");
            try {
                if (this.mLiveNPSPlugin != null && this.mLiveNPSPlugin.getLiveMediaEntry() != null && this.mLiveNPSPlugin.getLiveMediaEntry().getMixShellEntry() != null) {
                    return this.mLiveNPSPlugin.getLiveMediaEntry().getMixShellEntry().genFakeActivityImpl();
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (IMixActivityInterface) invokeV.objValue;
    }

    public int getPluginInstallVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.livenps");
            if (bundleInfo == null) {
                return 0;
            }
            return bundleInfo.getVersionCode();
        }
        return invokeV.intValue;
    }

    public ILiveRecMoreController getRecMoreController(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null || iLiveNPSPlugin.getLiveMediaEntry() == null) {
                return null;
            }
            return this.mLiveNPSPlugin.getLiveMediaEntry().getRecMoreController(context);
        }
        return (ILiveRecMoreController) invokeL.objValue;
    }

    public IYYStorageController getStorageOptInfoHelperInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null || iLiveNPSPlugin.getLiveMediaEntry() == null) {
                return null;
            }
            return this.mLiveNPSPlugin.getLiveMediaEntry().getStorageOptInfoHelperInterface();
        }
        return (IYYStorageController) invokeV.objValue;
    }

    public IYYGobackController getYYGobackController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null || iLiveNPSPlugin.getLiveMediaEntry() == null) {
                return null;
            }
            return this.mLiveNPSPlugin.getLiveMediaEntry().getYYGobackController();
        }
        return (IYYGobackController) invokeV.objValue;
    }

    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            NpsLoadChainLog.getInstance().dLog("LiveMediaPluginManager isAvailable ");
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps");
            if (bundleGroup == null) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: top plugin is null");
                }
                return false;
            }
            int i = 3;
            BundleInfo bundleByType = bundleGroup.getBundleByType(3);
            BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
            if (bundleByType2 != null) {
                bundleByType = bundleByType2;
            }
            if (bundleByType == null || bundleByType.getVersionCode() >= 508000000) {
                boolean z = bundleByType == null || bundleByType.getVersionCode() >= 507500000;
                int bundleStatus = NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.livenps", z);
                pluginYaLog("isAvailable() isMultiBundleEnable = " + z + ", status = " + bundleStatus);
                if (bundleStatus != 43) {
                    if (isDebug()) {
                        Log.d(TAG, "isAvailable: bundle status=" + bundleStatus);
                    }
                    return false;
                } else if (bundleByType == null) {
                    if (isDebug()) {
                        Log.d(TAG, "isAvailable: top plugin has no update");
                    }
                    return true;
                } else if (z) {
                    Log.d(TAG, "isAvailable: multiBundleEnable=true, skip business check");
                    return true;
                } else {
                    int length = NPS_PLUGIN_SUB_PKG_GROUP.length;
                    BundleInfoGroup[] bundleInfoGroupArr = new BundleInfoGroup[length];
                    boolean z2 = true;
                    for (int i2 = 0; i2 < length; i2++) {
                        bundleInfoGroupArr[i2] = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_SUB_PKG_GROUP[i2]);
                        if (bundleInfoGroupArr[i2] != null) {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: sec plugin not exist");
                        }
                        return true;
                    }
                    int i3 = 0;
                    while (i3 < length) {
                        if (bundleInfoGroupArr[i3] != null) {
                            BundleInfo bundleByType3 = bundleInfoGroupArr[i3].getBundleByType(i);
                            int versionCode = bundleByType.getVersionCode();
                            if (bundleByType3 != null && compareVersion(versionCode, bundleByType3.getVersionCode()) < 0) {
                                if (isDebug()) {
                                    Log.d(TAG, "isAvailable: installed " + bundleByType3.getPackageName() + " plugin too high");
                                }
                                pluginYaLog("isAvailable() pkgName = " + bundleByType3.getPackageName() + ", vesion too hign");
                                return false;
                            }
                            BundleInfo bundleByType4 = bundleInfoGroupArr[i3].getBundleByType(1);
                            BundleInfo bundleByType5 = bundleInfoGroupArr[i3].getBundleByType(2);
                            if (bundleByType4 != null && bundleByType4.needForceUpdate() && compareVersion(bundleByType.getVersionCode(), bundleByType4.getVersionCode()) < 0) {
                                if (isDebug()) {
                                    Log.d(TAG, "isAvailable: sec " + bundleByType4.getPackageName() + " plugin force update1");
                                }
                                if (bundleByType3 != null) {
                                    pluginYaLog("isAvailable() pkgName = " + bundleByType3.getPackageName() + ", plugin force update1");
                                }
                                return false;
                            } else if (bundleByType4 == null && bundleByType5 != null && bundleByType5.needForceUpdate() && compareVersion(bundleByType.getVersionCode(), bundleByType5.getVersionCode()) < 0) {
                                if (isDebug()) {
                                    Log.d(TAG, "isAvailable: sec " + bundleByType5.getPackageName() + " plugin force update2");
                                }
                                if (bundleByType3 != null) {
                                    pluginYaLog("isAvailable() pkgName = " + bundleByType3.getPackageName() + ", plugin force update2");
                                }
                                return false;
                            }
                        }
                        i3++;
                        i = 3;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void isInHistory(@NonNull String str, @NonNull LiveStatusDataCallback<Boolean> liveStatusDataCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, liveStatusDataCallback) == null) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveMediaPluginManager isInHistory " + str + GlideException.IndentedAppendable.INDENT + this.mLiveNPSPlugin);
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, false, new PluginLoadCallback(this, str, liveStatusDataCallback) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveMediaPluginManager this$0;
                    public final /* synthetic */ LiveStatusDataCallback val$callback;
                    public final /* synthetic */ String val$roomId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, liveStatusDataCallback};
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
                        this.val$roomId = str;
                        this.val$callback = liveStatusDataCallback;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    this.this$0.mLiveNPSPlugin.isInHistory(this.val$roomId, this.val$callback);
                                    return;
                                } catch (Exception e) {
                                    NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                                    npsLoadChainLog2.dLog("LiveMediaPluginManager isInHistoryException " + e.getMessage());
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                            if (this.this$0.isDebug()) {
                                Log.w(LiveMediaPluginManager.TAG, "load live nps plugin error=" + i);
                            }
                        }
                    }
                }, "isInHistory", LiveNpsRuntime.getApplication());
            } else {
                iLiveNPSPlugin.isInHistory(str, liveStatusDataCallback);
            }
        }
    }

    public boolean isLoaded(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveMediaPluginManager isLoaded" + str);
            if ("com.baidu.searchbox.livenps".equals(str)) {
                NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                npsLoadChainLog2.dLog("LiveMediaPluginManager isLoaded  " + this.mLiveNPSPlugin);
                return this.mLiveNPSPlugin != null;
            }
            Object obj = "";
            if ("com.baidu.live.media.business".equals(str)) {
                NpsLoadChainLog npsLoadChainLog3 = NpsLoadChainLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("LiveMediaPluginManager isLoaded  ");
                ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
                if (iLiveNPSPlugin != null && iLiveNPSPlugin.getLiveMediaEntry() != null) {
                    obj = Boolean.valueOf(this.mLiveNPSPlugin.getLiveMediaEntry().isLoaded());
                }
                sb.append(obj);
                npsLoadChainLog3.dLog(sb.toString());
                ILiveNPSPlugin iLiveNPSPlugin2 = this.mLiveNPSPlugin;
                if (iLiveNPSPlugin2 == null || iLiveNPSPlugin2.getLiveMediaEntry() == null) {
                    return false;
                }
                return this.mLiveNPSPlugin.getLiveMediaEntry().isLoaded();
            }
            if (BJH_PLUGIN_PKG_NAME.equals(str)) {
                NpsLoadChainLog npsLoadChainLog4 = NpsLoadChainLog.getInstance();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("LiveMediaPluginManager isLoaded  ");
                ILiveNPSPlugin iLiveNPSPlugin3 = this.mLiveNPSPlugin;
                if (iLiveNPSPlugin3 != null && iLiveNPSPlugin3.getLiveBjhEntry() != null) {
                    obj = Boolean.valueOf(this.mLiveNPSPlugin.getLiveBjhEntry().isLoaded());
                }
                sb2.append(obj);
                npsLoadChainLog4.dLog(sb2.toString());
                ILiveNPSPlugin iLiveNPSPlugin4 = this.mLiveNPSPlugin;
                if (iLiveNPSPlugin4 != null && iLiveNPSPlugin4.getLiveBjhEntry() != null) {
                    return this.mLiveNPSPlugin.getLiveBjhEntry().isLoaded();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void loadPlugin(Context context, String str, String str2, com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048591, this, context, str, str2, pluginLoadCallback) == null) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveMediaPluginManager loadPlugin " + str);
            String str3 = TextUtils.isEmpty(str2) ? USE_FROM_MIX_LOAD_PLUGIN : str2;
            if ("com.baidu.searchbox.livenps".equals(str)) {
                loadLiveNpsPlugin(context, str2, str3, pluginLoadCallback);
            } else if ("com.baidu.live.media.business".equals(str)) {
                NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                npsLoadChainLog2.dLog("LiveMediaPluginManager loadPlugin " + this.mLiveNPSPlugin);
                ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
                if (iLiveNPSPlugin == null) {
                    loadLiveNpsPlugin(context, str2, str3, new com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback(this, context, pluginLoadCallback) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LiveMediaPluginManager this$0;
                        public final /* synthetic */ com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback val$loadCallback;
                        public final /* synthetic */ Context val$packageContext;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context, pluginLoadCallback};
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
                            this.val$packageContext = context;
                            this.val$loadCallback = pluginLoadCallback;
                        }

                        @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
                        public void onResult(boolean z, int i, @Nullable String str4) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str4}) == null) {
                                NpsLoadChainLog npsLoadChainLog3 = NpsLoadChainLog.getInstance();
                                npsLoadChainLog3.dLog("LiveMediaPluginManager 一级onResult " + i + GlideException.IndentedAppendable.INDENT + str4 + GlideException.IndentedAppendable.INDENT);
                                if (z && this.this$0.mLiveNPSPlugin != null && this.this$0.mLiveNPSPlugin.getLiveMediaEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveMediaEntry().loadMediaPlugin(this.val$packageContext, this.val$loadCallback);
                                    return;
                                }
                                com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback pluginLoadCallback2 = this.val$loadCallback;
                                if (pluginLoadCallback2 != null) {
                                    pluginLoadCallback2.onResult(false, i, "LiveNps 加载失败");
                                }
                            }
                        }
                    });
                } else if (iLiveNPSPlugin.getLiveMediaEntry() == null) {
                    if (pluginLoadCallback != null) {
                        pluginLoadCallback.onResult(false, 0, "MediaEntry 加载失败");
                    }
                } else if (!this.mLiveNPSPlugin.getLiveMediaEntry().isLoaded()) {
                    this.mLiveNPSPlugin.getLiveMediaEntry().loadMediaPlugin(context, pluginLoadCallback);
                } else if (pluginLoadCallback != null) {
                    pluginLoadCallback.onResult(true, 14, "");
                }
            }
        }
    }

    public void onChangeToSmallWindow(Map<String, String> map, IYYSmallWindowController.IPlayController iPlayController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, map, iPlayController) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, false, new PluginLoadCallback(this, map, iPlayController) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.20
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveMediaPluginManager this$0;
                    public final /* synthetic */ IYYSmallWindowController.IPlayController val$controller;
                    public final /* synthetic */ Map val$params;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, map, iPlayController};
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
                        this.val$params = map;
                        this.val$controller = iPlayController;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                            npsLoadChainLog.dLog("LiveMediaPluginManager smallWindowSwitch loadPluginonResult " + i + GlideException.IndentedAppendable.INDENT + str + GlideException.IndentedAppendable.INDENT + obj + GlideException.IndentedAppendable.INDENT + str2);
                            if (i == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.mLiveNPSPlugin == null || this.this$0.mLiveNPSPlugin.getLiveMediaEntry() == null || this.this$0.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController().onChangeToSmallWindow(this.val$params, this.val$controller);
                                } catch (Exception e) {
                                    NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                                    npsLoadChainLog2.dLog("LiveMediaPluginManager smallWindowSwitch loadPluginException " + e.getMessage());
                                }
                            }
                        }
                    }
                }, "onChangeToSmallWindow", LiveNpsRuntime.getApplication());
            } else if (iLiveNPSPlugin == null || iLiveNPSPlugin.getLiveMediaEntry() == null || this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController() == null) {
            } else {
                this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController().onChangeToSmallWindow(map, iPlayController);
            }
        }
    }

    public void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), iLiveDiskClearCacheCallback}) == null) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveMediaPluginManager onDiskClearCacheChange " + this.mLiveNPSPlugin);
            if (NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.livenps") == null) {
                return;
            }
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, false, new PluginLoadCallback(this, j, i, i2, iLiveDiskClearCacheCallback) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveMediaPluginManager this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                    public void onResult(int i3, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), str, obj, str2}) == null) {
                            if (i3 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    this.this$0.mLiveNPSPlugin.onDiskClearCacheChange(this.val$quota, this.val$oldState, this.val$newState, this.val$callback);
                                    return;
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                        }
                    }
                }, "onDiskClearCacheChange", LiveNpsRuntime.getApplication());
                return;
            }
            try {
                iLiveNPSPlugin.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void onYYJoinChannelSuc(String str) {
        ILiveNPSPlugin iLiveNPSPlugin;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (iLiveNPSPlugin = this.mLiveNPSPlugin) == null || iLiveNPSPlugin.getLiveMediaEntry() == null) {
            return;
        }
        this.mLiveNPSPlugin.getLiveMediaEntry().onYYJoinChannelSuc(str);
    }

    public void prepareBundle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean isAvailable = isAvailable();
            dLog("插件预加载 LiveMediaPluginManager isAvailable = " + isAvailable);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                pluginYaLog("Idle task prepareBundle, topPlugin isAvailable = " + isAvailable);
                if (isAvailable) {
                    if (NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps").getBundleByType(2) != null) {
                        dLog("插件预加载 LiveMediaPluginManager 开始静默安装，升级插件");
                        int prepareBundle = NPSPackageManager.getInstance().prepareBundle("com.baidu.searchbox.livenps");
                        long currentTimeMillis2 = System.currentTimeMillis();
                        dLog("插件预加载 LiveMediaPluginManager 静默安装结束，耗时 = " + (currentTimeMillis2 - currentTimeMillis) + " 毫秒");
                        StringBuilder sb = new StringBuilder();
                        sb.append("Idle task prepareBundle, installPlugin retCode = ");
                        sb.append(prepareBundle);
                        pluginYaLog(sb.toString());
                    }
                    dLog("livenps准备预加载");
                    preLoadLiveNps(System.currentTimeMillis());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            dLog("插件预加载 LiveMediaPluginManager 整体耗时 = " + (currentTimeMillis3 - currentTimeMillis) + " 毫秒");
        }
    }

    public void sendLog(int i, @NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048596, this, i, context, str) == null) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveMediaPluginManager sendLog " + i + " " + str);
            npsLoadChainInitMedia();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, true, new PluginLoadCallback(this, i, context, str) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveMediaPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ int val$logType;
                    public final /* synthetic */ String val$params;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i), context, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$logType = i;
                        this.val$context = context;
                        this.val$params = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    this.this$0.mLiveNPSPlugin.getLiveMediaEntry().sendLog(this.val$logType, this.val$context, this.val$params);
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                        }
                    }
                }, "sendYaLog", context);
            } else {
                iLiveNPSPlugin.getLiveMediaEntry().sendLog(i, context, str);
            }
        }
    }

    public void setLoadingCallback(LiveNpsLoadingCallback liveNpsLoadingCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, liveNpsLoadingCallback) == null) {
            this.loadingCallback = liveNpsLoadingCallback;
        }
    }

    public void setSmallWindowSwitch(boolean z, Activity activity, FloatingService.OnPermissionResultListener onPermissionResultListener, FloatingService.OnPermissionCancelListener onPermissionCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), activity, onPermissionResultListener, onPermissionCancelListener}) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, false, new PluginLoadCallback(this, z, activity, onPermissionResultListener, onPermissionCancelListener) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveMediaPluginManager this$0;
                    public final /* synthetic */ Activity val$activity;
                    public final /* synthetic */ FloatingService.OnPermissionCancelListener val$cancelListener;
                    public final /* synthetic */ FloatingService.OnPermissionResultListener val$resultListener;
                    public final /* synthetic */ boolean val$switchOn;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z), activity, onPermissionResultListener, onPermissionCancelListener};
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
                        this.val$switchOn = z;
                        this.val$activity = activity;
                        this.val$resultListener = onPermissionResultListener;
                        this.val$cancelListener = onPermissionCancelListener;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                            npsLoadChainLog.dLog("LiveMediaPluginManager smallWindowSwitch loadPluginonResult " + i + GlideException.IndentedAppendable.INDENT + str + GlideException.IndentedAppendable.INDENT + obj + GlideException.IndentedAppendable.INDENT + str2);
                            if (i == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.mLiveNPSPlugin == null || this.this$0.mLiveNPSPlugin.getLiveMediaEntry() == null || this.this$0.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController().setSmallWindowSwitch(this.val$switchOn, this.val$activity, this.val$resultListener, this.val$cancelListener);
                                } catch (Exception e) {
                                    NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                                    npsLoadChainLog2.dLog("LiveMediaPluginManager smallWindowSwitch loadPluginException " + e.getMessage());
                                }
                            }
                        }
                    }
                }, "setSmallWindowSwitch", activity);
            } else if (iLiveNPSPlugin == null || iLiveNPSPlugin.getLiveMediaEntry() == null || this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController() == null) {
            } else {
                this.mLiveNPSPlugin.getLiveMediaEntry().getYYSmallWindowController().setSmallWindowSwitch(z, activity, onPermissionResultListener, onPermissionCancelListener);
            }
        }
    }

    public void startAudioMasterActivity(@NonNull Application application, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, application, str) == null) {
            npsLoadChainInitStart();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("enter_outlive_commonwebview", "1");
                jSONObject.put("enter_outlive_weburl", "https://live.baidu.com/m/media/multipage/cb_start_broad/index.html?app_type=tieba&params=" + str);
                jSONObject.put("navigationBar", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.mLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, true, new PluginLoadCallback(this, application, jSONObject) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveMediaPluginManager this$0;
                    public final /* synthetic */ JSONObject val$jsonObject;
                    public final /* synthetic */ Application val$packageContext;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, application, jSONObject};
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
                        this.val$packageContext = application;
                        this.val$jsonObject = jSONObject;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled) {
                                        MultiPluginHelper.logCancelJoinLive(str3, false, this.this$0.ubcManager);
                                        if (this.this$0.isDebug()) {
                                            Log.w(LiveMediaPluginManager.TAG, "cancel startLiveMediaActivity");
                                        }
                                    } else {
                                        LiveMixShellManager.INSTANCE.enterLiveRoom(this.val$packageContext, null, null, this.val$jsonObject.toString(), null);
                                    }
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveMediaPluginManager.TAG, "load live nps plugin error=" + i);
                            }
                        }
                    }
                }, "startAudioMasterActivity", application);
            } else {
                LiveMixShellManager.INSTANCE.enterLiveRoom(application, null, null, jSONObject.toString(), null);
            }
        }
    }

    public void startBjhMasterActivity(@NonNull Application application, String str, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048600, this, application, str, uri) == null) {
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.dLog("LiveMediaPluginManager startBjhMasterActivity " + str);
            npsLoadChainInitStart();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, true, new PluginLoadCallback(this, application, str, uri) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveMediaPluginManager this$0;
                    public final /* synthetic */ Application val$packageContext;
                    public final /* synthetic */ String val$params;
                    public final /* synthetic */ Uri val$uri;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, application, str, uri};
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
                        this.val$packageContext = application;
                        this.val$params = str;
                        this.val$uri = uri;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.mLiveNPSPlugin.getLiveBjhEntry() != null) {
                                        this.this$0.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivity(this.val$packageContext, this.val$params, this.val$uri);
                                        return;
                                    }
                                    return;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveMediaPluginManager.TAG, "load live nps plugin error=" + i);
                            }
                        }
                    }
                }, "startBjhMasterActivity", application);
            } else if (iLiveNPSPlugin.getLiveBjhEntry() != null) {
                this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivity(application, str, uri);
            }
        }
    }

    public void startBjhMasterActivityNew(@NonNull Context context, String str, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, context, str, uri) == null) {
            if (getPluginInstallVersion() >= 506000000) {
                npsLoadChainInitStart();
                ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
                if (iLiveNPSPlugin == null) {
                    loadNPSPluginImpl(true, true, new PluginLoadCallback(this, context, str, uri) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LiveMediaPluginManager this$0;
                        public final /* synthetic */ Context val$packageContext;
                        public final /* synthetic */ String val$params;
                        public final /* synthetic */ Uri val$uri;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context, str, uri};
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
                            this.val$packageContext = context;
                            this.val$params = str;
                            this.val$uri = uri;
                        }

                        @Override // com.baidu.searchbox.live.nps.LiveMediaPluginManager.PluginLoadCallback
                        public void onResult(int i, String str2, Object obj, String str3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                                if (i == 14) {
                                    try {
                                        this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                        if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveBjhEntry() == null) {
                                            return;
                                        }
                                        this.this$0.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivityNew(this.val$packageContext, this.val$params, this.val$uri);
                                        return;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        return;
                                    }
                                }
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveMediaPluginManager.TAG, "load live nps plugin error=" + i);
                                }
                            }
                        }
                    }, "startBjhMasterActivityNew", context);
                    return;
                } else if (iLiveNPSPlugin.getLiveBjhEntry() != null) {
                    this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivityNew(context, str, uri);
                    return;
                } else {
                    return;
                }
            }
            startBjhMasterActivity((Application) context.getApplicationContext(), str, uri);
        }
    }

    public void updateStatInfo(YYStatInfo yYStatInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, yYStatInfo) == null) || yYStatInfo == null || this.mLiveNPSPlugin == null) {
            return;
        }
        HashMap<String, Object> popFlow = FlowInfoHelper.popFlow(yYStatInfo.roomId);
        if (popFlow != null) {
            if (yYStatInfo.statInfo == null) {
                yYStatInfo.statInfo = popFlow;
            } else {
                for (String str : popFlow.keySet()) {
                    if (!TextUtils.isEmpty(str) && popFlow.get(str) != null) {
                        yYStatInfo.statInfo.put(str, popFlow.get(str));
                    }
                }
            }
        }
        this.mLiveNPSPlugin.getLiveMediaEntry().updateStatInfo(yYStatInfo);
        MediaLivePluginLogger.Companion.getInstance().updateLaunchFlowObj(yYStatInfo.flowObj);
        MediaLivePlayLogger.Companion.getInstance().updateLaunchInfo(yYStatInfo.statInfo);
    }

    public LiveMediaPluginManager() {
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
        this.fromDownLoad = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.mLiveNpsPreload = false;
        this.isLoadingCanceled = false;
        this.yalogService = (LiveYalogService) ServiceManager.getService(LiveYalogService.Companion.getSERVICE_REFERENCE());
        this.yalogApi = null;
        this.handler = new Handler(Looper.getMainLooper());
        LiveYalogService liveYalogService = this.yalogService;
        if (liveYalogService != null) {
            this.yalogApi = liveYalogService.buildYalogApi("live_plugin");
        }
    }

    private void loadNPSPluginImpl(boolean z, boolean z2, PluginLoadCallback pluginLoadCallback, String str, String str2, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), pluginLoadCallback, str, str2, context}) == null) {
            loadNPSPluginImpl(z, z2, pluginLoadCallback, str, "", str2, context);
        }
    }

    private void loadNPSPluginImpl(boolean z, boolean z2, PluginLoadCallback pluginLoadCallback, String str, String str2, String str3, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), pluginLoadCallback, str, str2, str3, context}) == null) {
            this.mCurrentCallback = pluginLoadCallback;
            Log.d(TAG, "NPS load from=" + str2);
            IInvokeCallback iInvokeCallback = new IInvokeCallback(this, str2, pluginLoadCallback) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveMediaPluginManager this$0;
                public final /* synthetic */ PluginLoadCallback val$callback;
                public final /* synthetic */ String val$useFrom;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, pluginLoadCallback};
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
                    this.val$useFrom = str2;
                    this.val$callback = pluginLoadCallback;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str4, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str4, obj) == null) {
                        LiveMixShellManager.INSTANCE.enterFlowEndSlot("plugin_load");
                        LiveMediaPluginManager liveMediaPluginManager = this.this$0;
                        int pluginInstallVersion = liveMediaPluginManager.getPluginInstallVersion();
                        boolean z3 = i == 14;
                        liveMediaPluginManager.logPluginEnd("com.baidu.searchbox.livenps", pluginInstallVersion, z3, "load code" + i, this.this$0.fromDownLoad ? "nps_download" : "nps_install", this.val$useFrom);
                        boolean z4 = i == 14;
                        LiveMediaPluginManager liveMediaPluginManager2 = this.this$0;
                        liveMediaPluginManager2.dLog("LiveNps加载结束~ invokeSucc = " + z4);
                        NpsLoadChainLog.getInstance().endLoadClazzLiveNps(z4, i);
                        if (this.val$callback != null) {
                            String str5 = this.this$0.fromDownLoad ? "download" : "install";
                            if (Looper.myLooper() != Looper.getMainLooper()) {
                                this.this$0.handler.post(new Runnable(this, i, str4, obj, str5) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.12.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass12 this$1;
                                    public final /* synthetic */ int val$i;
                                    public final /* synthetic */ String val$loadType;
                                    public final /* synthetic */ Object val$o;
                                    public final /* synthetic */ String val$s;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Integer.valueOf(i), str4, obj, str5};
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
                                        this.val$s = str4;
                                        this.val$o = obj;
                                        this.val$loadType = str5;
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
                                this.this$0.mCurrentCallback.onResult(i, str4, obj, str5);
                                this.this$0.mCurrentCallback = null;
                            }
                        }
                    }
                }
            };
            IInvokeCallback iInvokeCallback2 = new IInvokeCallback(this, str2, pluginLoadCallback) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveMediaPluginManager this$0;
                public final /* synthetic */ PluginLoadCallback val$callback;
                public final /* synthetic */ String val$useFrom;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, pluginLoadCallback};
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
                    this.val$useFrom = str2;
                    this.val$callback = pluginLoadCallback;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str4, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str4, obj) == null) {
                        boolean z3 = i == 14;
                        LiveMediaPluginManager liveMediaPluginManager = this.this$0;
                        liveMediaPluginManager.dLog("LiveNps加载结束~ invokeSucc = " + z3);
                        NpsLoadChainLog.getInstance().endLoadClazzLiveNps(z3, i);
                        LiveMixShellManager.INSTANCE.enterFlowEndSlot("plugin_load");
                        LiveMediaPluginManager liveMediaPluginManager2 = this.this$0;
                        int pluginInstallVersion = liveMediaPluginManager2.getPluginInstallVersion();
                        boolean z4 = i == 14;
                        liveMediaPluginManager2.logPluginEnd("com.baidu.searchbox.livenps", pluginInstallVersion, z4, "load code" + i, "nps_load", this.val$useFrom);
                        if (this.val$callback != null) {
                            if (Looper.myLooper() != Looper.getMainLooper()) {
                                this.this$0.handler.post(new Runnable(this, i, str4, obj) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.13.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass13 this$1;
                                    public final /* synthetic */ int val$i;
                                    public final /* synthetic */ Object val$o;
                                    public final /* synthetic */ String val$s;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Integer.valueOf(i), str4, obj};
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
                                        this.val$s = str4;
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
                                this.this$0.mCurrentCallback.onResult(i, str4, obj, "load");
                                this.this$0.mCurrentCallback = null;
                            }
                        }
                    }
                }
            };
            this.fromDownLoad = false;
            this.isLoadingCanceled = false;
            logPluginLoad("com.baidu.searchbox.livenps", str2);
            if (isAvailable()) {
                this.fromDownLoad = false;
                LiveMixShellManager.INSTANCE.enterFlowStartSlot("plugin_load", null);
                Log.d(TAG, "start load Class t=" + System.currentTimeMillis());
                if (NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps").getBundleByType(2) != null) {
                    ExecutorUtilsExt.postOnElastic(new Runnable(this, iInvokeCallback2, z2) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.14
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LiveMediaPluginManager this$0;
                        public final /* synthetic */ boolean val$enterPage;
                        public final /* synthetic */ IInvokeCallback val$proxyLoadCallback;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iInvokeCallback2, Boolean.valueOf(z2)};
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
                            this.val$proxyLoadCallback = iInvokeCallback2;
                            this.val$enterPage = z2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.dLog("开始安装LiveNps");
                                NpsLoadChainLog.getInstance().startInstallLiveNps();
                                int prepareBundle = NPSPackageManager.getInstance().prepareBundle("com.baidu.searchbox.livenps");
                                if (prepareBundle == 41) {
                                    NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                                    npsLoadChainLog.setPluginVersion(this.this$0.getPluginInstallVersion() + "");
                                    this.this$0.dLog("LiveNps安装结束~成功");
                                    NpsLoadChainLog.getInstance().endInstallLiveNps(true, prepareBundle);
                                    this.this$0.dLog("开始加载LiveNps");
                                    NpsLoadChainLog.getInstance().startLoadClazzLiveNps();
                                    NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, this.val$proxyLoadCallback);
                                } else {
                                    this.val$proxyLoadCallback.onResult(-58, "NPS prepareBundle failed", null);
                                }
                                this.this$0.handler.post(new Runnable(this) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.14.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass14 this$1;

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
                                            AnonymousClass14 anonymousClass14 = this.this$1;
                                            if (anonymousClass14.val$enterPage) {
                                                anonymousClass14.this$0.downloadUpdatePackage();
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }, "nps-preparebundle", 0);
                    return;
                }
                dLog("开始加载LiveNps");
                NpsLoadChainLog.getInstance().startLoadClazzLiveNps();
                NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, iInvokeCallback2);
                if (z2) {
                    downloadUpdatePackage();
                    return;
                }
                return;
            }
            if (z2) {
                showLoading();
            }
            LiveMixShellManager.INSTANCE.enterFlowStartSlot("plugin_install", null);
            this.fromDownLoad = false;
            Log.d(TAG, "start install bundle t=" + System.currentTimeMillis());
            dLog("下载LiveNps插件 = com.baidu.searchbox.livenps");
            NpsLoadChainLog.getInstance().startDownloadLiveNps();
            NPSPackageManager.getInstance().installBundle("com.baidu.searchbox.livenps", new IInstallCallback(this, iInvokeCallback, z2, str2) { // from class: com.baidu.searchbox.live.nps.LiveMediaPluginManager.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveMediaPluginManager this$0;
                public final /* synthetic */ boolean val$enterPage;
                public final /* synthetic */ IInvokeCallback val$proxyInstallCallback;
                public final /* synthetic */ String val$useFrom;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iInvokeCallback, Boolean.valueOf(z2), str2};
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
                    this.val$proxyInstallCallback = iInvokeCallback;
                    this.val$enterPage = z2;
                    this.val$useFrom = str2;
                }

                @Override // com.baidu.nps.main.install.IInstallCallback
                public void onProgress(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        this.this$0.fromDownLoad = true;
                        if (this.this$0.loadingCallback != null && !this.this$0.isLoadingCanceled) {
                            this.this$0.loadingCallback.onLoadingProgress(j, j2);
                        }
                        LiveMediaPluginManager liveMediaPluginManager = this.this$0;
                        liveMediaPluginManager.dLog("downloadSize = " + j + ", totalSIze = " + j2);
                        if (j >= j2) {
                            this.this$0.dLog("LiveNps下载结束");
                            NpsLoadChainLog.getInstance().endDownloadLiveNps(j, j2);
                            this.this$0.dLog("开始安装LiveNps");
                            NpsLoadChainLog.getInstance().startInstallLiveNps();
                        }
                    }
                }

                @Override // com.baidu.nps.main.install.IInstallCallback
                public void onResult(int i, String str4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str4) == null) {
                        if (!this.this$0.isLoadingCanceled && i != 34) {
                            this.this$0.stopLoading(i);
                        }
                        if (i == 13) {
                            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                            npsLoadChainLog.setPluginVersion(this.this$0.getPluginInstallVersion() + "");
                            this.this$0.dLog("LiveNps安装结束~成功");
                            NpsLoadChainLog.getInstance().endInstallLiveNps(true, i);
                            LiveMixShellManager.INSTANCE.enterFlowEndSlot("plugin_install");
                            LiveMixShellManager.INSTANCE.enterFlowStartSlot("plugin_load", null);
                            Log.d(LiveMediaPluginManager.TAG, "start load Class t=" + System.currentTimeMillis());
                            this.this$0.dLog("开始加载LiveNps");
                            NpsLoadChainLog.getInstance().startLoadClazzLiveNps();
                            NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, this.val$proxyInstallCallback);
                        } else if (i != 3 || NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.livenps") != 43 || this.this$0.getPluginInstallVersion() < 508000000) {
                            this.this$0.dLog("LiveNps安装结束~失败");
                            NpsLoadChainLog.getInstance().endInstallLiveNps(false, i);
                            if (this.val$enterPage) {
                                if (i == 34) {
                                    if (this.this$0.loadingCallback == null) {
                                        this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d1, 0);
                                    }
                                } else {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                            }
                            LiveMixShellManager.INSTANCE.enterFlowEnd();
                            if (this.this$0.isDebug()) {
                                Log.w(LiveMediaPluginManager.TAG, "install live nps plugin error=" + i);
                            }
                            LiveMediaPluginManager liveMediaPluginManager = this.this$0;
                            int pluginInstallVersion = liveMediaPluginManager.getPluginInstallVersion();
                            liveMediaPluginManager.logPluginEnd("com.baidu.searchbox.livenps", pluginInstallVersion, false, "install code" + i, "nps_install", this.val$useFrom);
                        } else {
                            NpsLoadChainLog npsLoadChainLog2 = NpsLoadChainLog.getInstance();
                            npsLoadChainLog2.setPluginVersion(this.this$0.getPluginInstallVersion() + "");
                            this.this$0.dLog("LiveNps安装结束~成功");
                            NpsLoadChainLog.getInstance().endInstallLiveNps(true, i);
                            LiveMixShellManager.INSTANCE.enterFlowEndSlot("plugin_install");
                            LiveMixShellManager.INSTANCE.enterFlowStartSlot("plugin_load", null);
                            this.this$0.dLog("开始加载LiveNps");
                            NpsLoadChainLog.getInstance().startLoadClazzLiveNps();
                            NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, this.val$proxyInstallCallback);
                        }
                    }
                }
            });
        }
    }
}
