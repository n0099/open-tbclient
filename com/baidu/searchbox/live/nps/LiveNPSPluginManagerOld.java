package com.baidu.searchbox.live.nps;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleConfig;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pass.biometrics.face.liveness.b.a;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.live.chainlog.NpsLoadChainLog;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveLoadStatusCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveStatusDataCallback;
import com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.interfaces.yy.YYStaticConfig;
import com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.w91;
import com.baidu.tieba.y91;
import com.baidu.tieba.z91;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveNPSPluginManagerOld {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUDIO_CREATE_LIVE_ROOM_H5 = "AUDIO_CREATE_LIVE_ROOM_H5";
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
    public static final String MEDIA_ENTER_LIVE_ROOM = "MEDIA_ENTER_LIVE_ROOM";
    public static final String MEDIA_MASTER_ROUTER = "MEDIA_MASTER_ROUTER";
    public static final int MIX_ENTRANCE_INNER_VERSION = 507500003;
    public static final int MIX_NEW_ARCH_PLUGIN_VERSION = 508000000;
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
    public static final String TAG = "LiveNPSPluginManagerOld";
    public static final String UBC_ID_CANCEL_JOIN_LIVE = "4417";
    public static final String UBC_ID_PLUGIN_END = "3185";
    public static final String UBC_ID_PLUGIN_PAGE_FLOW = "3121";
    public static final String UBC_ID_PLUGIN_START = "3186";
    public static final String YU_YIN_CREATE_LIVE_ROOM = "YU_YIN_CREATE_LIVE_ROOM";
    public static final String YU_YIN_ENTER_LIVE_ROOM = "YU_YIN_ENTER_LIVE_ROOM";
    public static final String YY_CUSTOMER_SERVICE = "YY_CUSTOMER_SERVICE";
    public static final String YY_ENTER_LIVE_ROOM = "YY_ENTER_LIVE_ROOM";
    public static final String YY_FEED_BACK = "YY_FEED_BACK";
    public static final String YY_LIVE_ROUTER = "YY_LIVE_ROUTER";
    public static final String YY_NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.yylive.entrance";
    public static final String YY_TEST_ENTER_LIVE_ROOM = "YY_TEST_ENTER_LIVE_ROOM";
    public transient /* synthetic */ FieldHolder $fh;
    public AppInfoService appService;
    public boolean fromDownLoad;
    public Handler handler;
    public boolean isLoadingCanceled;
    public LiveNpsLoadingCallback loadingCallback;
    public PluginLoadCallback mCurrentCallback;
    public ILiveNPSPlugin mLiveNPSPlugin;
    public Handler mMainHandler;
    public Flow pageFlow;
    public ToastService toastService;
    public UBCManager ubcManager;

    /* loaded from: classes2.dex */
    public interface PluginLoadCallback {
        void onResult(int i, String str, Object obj, String str2);
    }

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static LiveNPSPluginManagerOld instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1914726077, "Lcom/baidu/searchbox/live/nps/LiveNPSPluginManagerOld$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1914726077, "Lcom/baidu/searchbox/live/nps/LiveNPSPluginManagerOld$SingletonHolder;");
                    return;
                }
            }
            instance = new LiveNPSPluginManagerOld();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2048032976, "Lcom/baidu/searchbox/live/nps/LiveNPSPluginManagerOld;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2048032976, "Lcom/baidu/searchbox/live/nps/LiveNPSPluginManagerOld;");
                return;
            }
        }
        NPS_PLUGIN_SUB_PKG_GROUP = new String[]{YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_1, YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_2, "com.baidu.searchbox.yylive.extlib", LiveMediaPluginManager.BJH_PLUGIN_PKG_NAME, "com.baidu.searchbox.yylive.createlive", "com.baidu.searchbox.yylive.game", LiveYYPluginManager.YY_NPS_YYLIB_PKG_NAME, "com.baidu.searchbox.yylive.audiolive", "com.baidu.searchbox.yylive.friends"};
    }

    private void logPluginVersionCode() {
        BundleInfo bundleInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65579, this) == null) && NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.livenps") == 43 && (bundleInfo = NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.livenps")) != null) {
            Log.d("NPS", "NPS Installed live plugin version code " + bundleInfo.getVersionCode());
        }
    }

    private void npsLoadChainInitMedia() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog.getInstance().setEntry("YY-Media");
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        }
    }

    private void npsLoadChainInitOther() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog.getInstance().setEntry("YY-Other");
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        }
    }

    private void npsLoadChainInitStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog.getInstance().setEntry("YY-StartLive");
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
        }
    }

    public LiveNPSPluginManagerOld() {
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
        this.handler = new Handler(Looper.getMainLooper());
        this.fromDownLoad = false;
        this.ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.isLoadingCanceled = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, this, str) == null) {
            NpsLoadChainLog.getInstance().dLog(str);
        }
    }

    public static String getParamsStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int indexOf = str.indexOf("?");
            if (indexOf <= 0) {
                return null;
            }
            return str.substring(indexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    private void stopLoading(int i) {
        LiveNpsLoadingCallback liveNpsLoadingCallback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65591, this, i) == null) && (liveNpsLoadingCallback = this.loadingCallback) != null) {
            liveNpsLoadingCallback.onLoadingEnd(i);
        }
    }

    public void clearResourceFile(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, "NEW_CLEAR_RESOURCE_FILE", new PluginLoadCallback(this, context) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.40
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ Context val$packageContext;

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
                        this.val$packageContext = context;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            if (i != 14) {
                                this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                this.this$0.mLiveNPSPlugin.clearLiveResourceSize(this.val$packageContext);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.clearLiveResourceSize(context);
            }
        }
    }

    public void setLoadingCallback(LiveNpsLoadingCallback liveNpsLoadingCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, liveNpsLoadingCallback) == null) {
            this.loadingCallback = liveNpsLoadingCallback;
        }
    }

    public void startAdminListActivity(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "LIVE_SHOW_ADMIN_LIST", new PluginLoadCallback(this, context) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry().openAdminListPage(this.val$context);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowMasterEntry().openAdminListPage(context);
            }
        }
    }

    public void startForbiddenListActivity(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, context) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "LIVE_SHOW_FORBIDDEN_LIST", new PluginLoadCallback(this, context) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry().openForbiddenListPage(this.val$context);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowMasterEntry().openForbiddenListPage(context);
            }
        }
    }

    public void startPatronageActivity(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, context) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "LIVE_SHOW_START_PATRONAGE", new PluginLoadCallback(this, context) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().enterPatronagePage(this.val$context);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().enterPatronagePage(context);
            }
        }
    }

    public void startYYActivity(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, context) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "YY_TEST_ENTER_LIVE_ROOM", new PluginLoadCallback(this, context) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.26
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getYYLiveEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getYYLiveEntry().startYYActivity(this.val$context);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getYYLiveEntry() != null) {
                this.mLiveNPSPlugin.getYYLiveEntry().startYYActivity(context);
            }
        }
    }

    public void dispatchLiveMasterRouter(@NonNull Application application, String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, application, str, map) == null) {
            npsLoadChainInitStart();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "MEDIA_MASTER_ROUTER", new PluginLoadCallback(this, application, str, map) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveBjhEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveBjhEntry().dispatchLiveMasterRouter(this.val$packageContext, this.val$path, this.val$params);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveBjhEntry() != null) {
                this.mLiveNPSPlugin.getLiveBjhEntry().dispatchLiveMasterRouter(application, str, map);
            }
        }
    }

    public void startBjhMasterActivity(@NonNull Application application, String str, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, application, str, uri) == null) {
            npsLoadChainInitStart();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "MEDIA_BJH_CREATE_LIVE_ROOM", new PluginLoadCallback(this, application, str, uri) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveBjhEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivity(this.val$packageContext, this.val$params, this.val$uri);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveBjhEntry() != null) {
                this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivity(application, str, uri);
            }
        }
    }

    public void startFansListActivity(@NonNull Context context, @NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048596, this, context, str, i) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "LIVE_SHOW_FANS_LIST", new PluginLoadCallback(this, context, str, i) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ int val$sex;
                    public final /* synthetic */ String val$uid;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, Integer.valueOf(i)};
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
                        this.val$context = context;
                        this.val$uid = str;
                        this.val$sex = i;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            if (i2 != 14) {
                                this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i2);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().openFansListPage(this.val$context, this.val$uid, this.val$sex);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().openFansListPage(context, str, i);
            }
        }
    }

    public void startGuardianListActivity(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, context, str, str2) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "LIVE_SHOW_GUARD_LIST", new PluginLoadCallback(this, context, str, str2) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ String val$charmValue;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$uid;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, str2};
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
                        this.val$charmValue = str;
                        this.val$uid = str2;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str3, Object obj, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str3, obj, str4}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().openGuardianListPage(this.val$context, this.val$charmValue, this.val$uid);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().openGuardianListPage(context, str, str2);
            }
        }
    }

    public void startMasterActivity(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048602, this, context, str, str2) == null) {
            npsLoadChainInitStart();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "NEW_CREATE_LIVE_ROOM", new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$param;

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
                        this.val$param = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str3, Object obj, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str3, obj, str4}) == null) {
                            if (i != 14) {
                                this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                this.this$0.mLiveNPSPlugin.startMasterActivity(this.val$context, this.val$param);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.startMasterActivity(context, str);
            }
        }
    }

    public void startMasterActivityV2(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, context, str, str2) == null) {
            npsLoadChainInitStart();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "NEW_CREATE_LIVE_ROOM", new PluginLoadCallback(this, context, str, str2) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ String val$appVersion;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$param;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, str2};
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
                        this.val$param = str;
                        this.val$appVersion = str2;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str3, Object obj, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str3, obj, str4}) == null) {
                            if (i != 14) {
                                this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                this.this$0.mLiveNPSPlugin.startMasterActivity(this.val$context, this.val$param, this.val$appVersion);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.startMasterActivity(context, str, str2);
            }
        }
    }

    public void startRealAuthActivity(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048607, this, context, str, str2) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "LIVE_SHOW_REAL_AUTH", new PluginLoadCallback(this, context, str, str2) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.20
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ String val$certifyStatus;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$uid;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, str2};
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
                        this.val$uid = str;
                        this.val$certifyStatus = str2;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str3, Object obj, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str3, obj, str4}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry().openRealAuthPage(this.val$context, this.val$uid, this.val$certifyStatus);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowMasterEntry().openRealAuthPage(context, str, str2);
            }
        }
    }

    private int compareVersion(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65568, this, i, i2)) == null) {
            return (i / 1000) - (i2 / 1000);
        }
        return invokeII.intValue;
    }

    public void getLiveResourceFileSize(@NonNull Context context, @NonNull ILiveFileSizeCallback iLiveFileSizeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, iLiveFileSizeCallback) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, "NEW_GET_RESOURCE_FILE_SIZE", new PluginLoadCallback(this, context, iLiveFileSizeCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.39
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ ILiveFileSizeCallback val$callback;
                    public final /* synthetic */ Context val$packageContext;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, iLiveFileSizeCallback};
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
                        this.val$callback = iLiveFileSizeCallback;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            if (i != 14) {
                                this.val$callback.getFileSize(0L);
                                this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                this.this$0.mLiveNPSPlugin.getLiveResourceSize(this.val$packageContext, this.val$callback);
                            } catch (Exception e) {
                                this.val$callback.getFileSize(0L);
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.getLiveResourceSize(context, iLiveFileSizeCallback);
            }
        }
    }

    public void getLiveRoomStatus(@NonNull String str, @NonNull LiveStatusDataCallback<String> liveStatusDataCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, liveStatusDataCallback) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, "NEW_GET_LIVE_ROOM_STATUS", new PluginLoadCallback(this, str, liveStatusDataCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i != 14) {
                                this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                this.this$0.mLiveNPSPlugin.getLiveRoomStatus(this.val$roomId, this.val$callback);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.getLiveRoomStatus(str, liveStatusDataCallback);
            }
        }
    }

    public void getLiveSdkFileSize(@NonNull Context context, @NonNull ILiveFileSizeCallback iLiveFileSizeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, iLiveFileSizeCallback) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, "NEW_GET_LIVE_SDK_FILE_SIZE", new PluginLoadCallback(this, context, iLiveFileSizeCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.38
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ ILiveFileSizeCallback val$callback;
                    public final /* synthetic */ Context val$packageContext;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, iLiveFileSizeCallback};
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
                        this.val$callback = iLiveFileSizeCallback;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            if (i != 14) {
                                this.val$callback.getFileSize(0L);
                                this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                this.this$0.mLiveNPSPlugin.getLiveSdkSize(this.val$packageContext, this.val$callback);
                            } catch (Exception e) {
                                this.val$callback.getFileSize(0L);
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.getLiveSdkSize(context, iLiveFileSizeCallback);
            }
        }
    }

    public void isInHistory(@NonNull String str, @NonNull LiveStatusDataCallback<Boolean> liveStatusDataCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, liveStatusDataCallback) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, "NEW_IS_HISTORY", new PluginLoadCallback(this, str, liveStatusDataCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i != 14) {
                                this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                this.this$0.mLiveNPSPlugin.isInHistory(this.val$roomId, this.val$callback);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.isInHistory(str, liveStatusDataCallback);
            }
        }
    }

    public void startLiveShowActivity(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, context, str) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "LIVE_SHOW_ENTER_LIVE_ROOM", new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$params;

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
                        this.val$params = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().enterLiveShowRoom(this.val$context, this.val$params);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().enterLiveShowRoom(context, str);
            }
        }
    }

    public void startPatronsActivity(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, context, str) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "LIVE_SHOW_START_PATRONS", new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$uid;

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
                        this.val$uid = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().enterPatrons(this.val$context, this.val$uid);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().enterPatrons(context, str);
            }
        }
    }

    public void startPayActivity(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "LIVE_SHOW_START_PAY", new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$params;

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
                        this.val$params = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().enterPayPage(this.val$context, this.val$params);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().enterPayPage(context, str);
            }
        }
    }

    public void startShowMasterActivity(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, context, str) == null) {
            npsLoadChainInitStart();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "LIVE_SHOW_CREATE_ROOM", new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$params;

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
                        this.val$params = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry().createLiveRoom(this.val$context, this.val$params);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowMasterEntry().createLiveRoom(context, str);
            }
        }
    }

    public void startYuYinCreateLiveRoomActivity(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, context, str) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "YU_YIN_CREATE_LIVE_ROOM", new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.22
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$jsonParams;

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
                        this.val$jsonParams = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveYuYinEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinCreateLiveRoomActivity(this.val$context, this.val$jsonParams);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveYuYinEntry() != null) {
                this.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinCreateLiveRoomActivity(context, str);
            }
        }
    }

    public static String bundleToJsonStr(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, map)) == null) {
            if (map != null && !map.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (String str : map.keySet()) {
                    try {
                        jSONObject.put(str, map.get(str));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return jSONObject.toString();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static HashMap<String, String> stringToMap(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            for (String str3 : str.split("&")) {
                String[] split = str3.split("=");
                try {
                    String decode = URLDecoder.decode(split[0], "UTF-8");
                    if (split.length > 1) {
                        str2 = URLDecoder.decode(split[1], "UTF-8");
                    } else {
                        str2 = "";
                    }
                    hashMap.put(decode, str2);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkEntranceUpdate() {
        BundleInfoGroup bundleGroup;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65565, this) == null) && (bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance")) != null) {
            BundleInfo bundleByType = bundleGroup.getBundleByType(3);
            BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
            boolean z2 = false;
            if (bundleByType == null) {
                if (bundleByType2 == null) {
                    z = false;
                } else {
                    z = bundleByType2.getVersionCode() < 508000000 ? true : true;
                }
                z2 = true;
                if (bundleByType != null && bundleByType.getVersionCode() < 508000000) {
                    z = true;
                    z2 = true;
                }
                if (!z2) {
                    if (z) {
                        NPSPackageManager.getInstance().downloadUpdatePackage("com.baidu.searchbox.yylive.entrance", new w91(this) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.43
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ LiveNPSPluginManagerOld this$0;

                            @Override // com.baidu.tieba.w91
                            public void onProgress(long j, long j2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                                }
                            }

                            @Override // com.baidu.tieba.w91
                            public void onResult(int i, String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                                }
                            }

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
                        }, new y91(this) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.44
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ LiveNPSPluginManagerOld this$0;

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

                            @Override // com.baidu.tieba.y91
                            public void checkAuthorization(IBundleInfo iBundleInfo, int i, z91 z91Var) {
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeLIL(1048576, this, iBundleInfo, i, z91Var) == null) && z91Var != null) {
                                    z91Var.onResult(1);
                                }
                            }
                        }, 1);
                        return;
                    } else {
                        NPSPackageManager.getInstance().downloadBundle("com.baidu.searchbox.yylive.entrance", new w91(this) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.45
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ LiveNPSPluginManagerOld this$0;

                            @Override // com.baidu.tieba.w91
                            public void onProgress(long j, long j2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                                }
                            }

                            @Override // com.baidu.tieba.w91
                            public void onResult(int i, String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                                }
                            }

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
                        });
                        return;
                    }
                }
                return;
            }
            z = false;
            if (bundleByType != null) {
                z = true;
                z2 = true;
            }
            if (!z2) {
            }
        }
    }

    private void checkHandler() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65566, this) == null) && this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadUpdatePackage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            NPSPackageManager.getInstance().downloadUpdatePackage("com.baidu.searchbox.livenps", new w91(this) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.32
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveNPSPluginManagerOld this$0;

                @Override // com.baidu.tieba.w91
                public void onProgress(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    }
                }

                @Override // com.baidu.tieba.w91
                public void onResult(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                    }
                }

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
            }, new y91(this) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.33
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveNPSPluginManagerOld this$0;

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

                @Override // com.baidu.tieba.y91
                public void checkAuthorization(IBundleInfo iBundleInfo, int i, z91 z91Var) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLIL(1048576, this, iBundleInfo, i, z91Var) == null) && z91Var != null) {
                        z91Var.onResult(1);
                    }
                }
            }, 1);
        }
    }

    public static LiveNPSPluginManagerOld getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            return SingletonHolder.instance;
        }
        return (LiveNPSPluginManagerOld) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPluginInstallVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) {
            BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.livenps");
            if (bundleInfo == null) {
                return 0;
            }
            return bundleInfo.getVersionCode();
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, this)) == null) {
            AppInfoService appInfoService = this.appService;
            if (appInfoService != null) {
                return appInfoService.isDebug();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void showLoading() {
        LiveNpsLoadingCallback liveNpsLoadingCallback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65588, this) == null) && (liveNpsLoadingCallback = this.loadingCallback) != null) {
            liveNpsLoadingCallback.onLoadingStart();
        }
    }

    public void cancelLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.isLoadingCanceled = true;
            if (this.mLiveNPSPlugin != null) {
                try {
                    if (getPluginInstallVersion() >= 500000000) {
                        this.mLiveNPSPlugin.getYYLiveEntry().cancelLoad();
                    }
                } catch (AbstractMethodError e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void cancelStartYYLiveActivity() {
        ILiveNPSPlugin iLiveNPSPlugin;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (iLiveNPSPlugin = this.mLiveNPSPlugin) != null) {
            try {
                iLiveNPSPlugin.getYYLiveEntry().cancelStartYYLiveActivity();
            } catch (AbstractMethodError e) {
                e.printStackTrace();
            }
        }
    }

    public BundleInfo getInstalledPluginInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.livenps");
        }
        return (BundleInfo) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkYYEntranceIsLoaded(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, this, context, str) == null) {
            if (getPluginInstallVersion() >= 500500000) {
                boolean isLoaded = this.mLiveNPSPlugin.getYYLiveEntry().isLoaded();
                dLog("checkYYEntranceIsLoaded，url = " + str + ",  isLoaded = " + isLoaded);
                if (!isLoaded) {
                    this.mLiveNPSPlugin.getYYLiveEntry().loadPlugin(context, new LiveLoadStatusCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.28
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                        @Override // com.baidu.searchbox.live.interfaces.callback.LiveLoadStatusCallback
                        public void onResult(boolean z) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                                LiveNPSPluginManagerOld liveNPSPluginManagerOld = this.this$0;
                                liveNPSPluginManagerOld.dLog("checkYYEntranceIsLoaded loadPlugin，是否成功 = " + z);
                                this.this$0.realJumpToYYLiveActivity(this.val$context, this.val$url);
                            }
                        }
                    });
                    return;
                } else {
                    realJumpToYYLiveActivity(context, str);
                    return;
                }
            }
            this.mLiveNPSPlugin.getYYLiveEntry().startYYLiveActivity(context, str);
        }
    }

    private void logPluginLoad(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65578, this, str, str2) == null) && this.ubcManager != null) {
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
    }

    private void loadNPSPluginImpl(boolean z, String str, PluginLoadCallback pluginLoadCallback) {
        int i;
        BundleInfo bundleByType;
        Flow flow;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65575, this, new Object[]{Boolean.valueOf(z), str, pluginLoadCallback}) == null) {
            boolean z2 = false;
            ExecutorUtilsExt.postOnElastic(new Runnable(this) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.34
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveNPSPluginManagerOld this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
                        if (bundleGroup == null) {
                            NPSPackageManager.getInstance().prepareBundle("com.baidu.searchbox.yylive.entrance");
                            return;
                        }
                        BundleInfo bundleByType2 = bundleGroup.getBundleByType(3);
                        if (bundleByType2 == null || bundleByType2.getVersionCode() < 507500003) {
                            BundleConfig bundleConfig = new BundleConfig();
                            bundleConfig.skipDownloadedBundle = true;
                            NPSPackageManager.getInstance().prepareBundle("com.baidu.searchbox.yylive.entrance", 0, false, bundleConfig);
                        }
                    }
                }
            }, "nps-preparebundle", 0);
            this.mCurrentCallback = pluginLoadCallback;
            Log.d(TAG, "NPS load from=" + str);
            new IInvokeCallback(this, str, pluginLoadCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.35
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                public final /* synthetic */ PluginLoadCallback val$callback;
                public final /* synthetic */ String val$useFrom;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, pluginLoadCallback};
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
                    this.val$useFrom = str;
                    this.val$callback = pluginLoadCallback;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i2, String str2, Object obj) {
                    boolean z3;
                    String str3;
                    String str4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, obj) == null) {
                        if (this.this$0.ubcManager != null && this.this$0.pageFlow != null) {
                            this.this$0.ubcManager.flowEndSlot(this.this$0.pageFlow, "plugin_load");
                        }
                        LiveNPSPluginManagerOld liveNPSPluginManagerOld = this.this$0;
                        int pluginInstallVersion = liveNPSPluginManagerOld.getPluginInstallVersion();
                        boolean z4 = true;
                        if (i2 == 14) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        String str5 = "load code" + i2;
                        if (this.this$0.fromDownLoad) {
                            str3 = "nps_download";
                        } else {
                            str3 = "nps_install";
                        }
                        liveNPSPluginManagerOld.logPluginEnd("com.baidu.searchbox.livenps", pluginInstallVersion, z3, str5, str3, this.val$useFrom);
                        if (i2 != 14) {
                            z4 = false;
                        }
                        this.this$0.dLog("LiveNps加载结束~ invokeSucc = " + z4);
                        NpsLoadChainLog.getInstance().endLoadClazzLiveNps(z4, i2);
                        if (this.val$callback != null) {
                            if (this.this$0.fromDownLoad) {
                                str4 = "download";
                            } else {
                                str4 = "install";
                            }
                            String str6 = str4;
                            if (Looper.myLooper() != Looper.getMainLooper()) {
                                this.this$0.handler.post(new Runnable(this, i2, str2, obj, str6) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.35.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass35 this$1;
                                    public final /* synthetic */ int val$i;
                                    public final /* synthetic */ String val$loadType;
                                    public final /* synthetic */ Object val$o;
                                    public final /* synthetic */ String val$s;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Integer.valueOf(i2), str2, obj, str6};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$i = i2;
                                        this.val$s = str2;
                                        this.val$o = obj;
                                        this.val$loadType = str6;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && this.this$1.this$0.mCurrentCallback != null) {
                                            this.this$1.this$0.mCurrentCallback.onResult(this.val$i, this.val$s, this.val$o, this.val$loadType);
                                            this.this$1.this$0.mCurrentCallback = null;
                                        }
                                    }
                                });
                            } else if (this.this$0.mCurrentCallback != null) {
                                this.this$0.mCurrentCallback.onResult(i2, str2, obj, str6);
                                this.this$0.mCurrentCallback = null;
                            }
                        }
                    }
                }
            };
            IInvokeCallback iInvokeCallback = new IInvokeCallback(this, str, pluginLoadCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.36
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                public final /* synthetic */ PluginLoadCallback val$callback;
                public final /* synthetic */ String val$useFrom;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, pluginLoadCallback};
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
                    this.val$useFrom = str;
                    this.val$callback = pluginLoadCallback;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i2, String str2, Object obj) {
                    boolean z3;
                    boolean z4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, obj) == null) {
                        if (i2 == 14) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        LiveNPSPluginManagerOld liveNPSPluginManagerOld = this.this$0;
                        liveNPSPluginManagerOld.dLog("LiveNps加载结束~ invokeSucc = " + z3);
                        NpsLoadChainLog.getInstance().endLoadClazzLiveNps(z3, i2);
                        if (this.this$0.ubcManager != null && this.this$0.pageFlow != null) {
                            this.this$0.ubcManager.flowEndSlot(this.this$0.pageFlow, "plugin_load");
                        }
                        LiveNPSPluginManagerOld liveNPSPluginManagerOld2 = this.this$0;
                        int pluginInstallVersion = liveNPSPluginManagerOld2.getPluginInstallVersion();
                        if (i2 == 14) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        liveNPSPluginManagerOld2.logPluginEnd("com.baidu.searchbox.livenps", pluginInstallVersion, z4, "load code" + i2, "nps_load", this.val$useFrom);
                        if (this.val$callback != null) {
                            if (Looper.myLooper() != Looper.getMainLooper()) {
                                this.this$0.handler.post(new Runnable(this, i2, str2, obj) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.36.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass36 this$1;
                                    public final /* synthetic */ int val$i;
                                    public final /* synthetic */ Object val$o;
                                    public final /* synthetic */ String val$s;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Integer.valueOf(i2), str2, obj};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$i = i2;
                                        this.val$s = str2;
                                        this.val$o = obj;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && this.this$1.this$0.mCurrentCallback != null) {
                                            this.this$1.this$0.mCurrentCallback.onResult(this.val$i, this.val$s, this.val$o, "load");
                                            this.this$1.this$0.mCurrentCallback = null;
                                        }
                                    }
                                });
                            } else if (this.this$0.mCurrentCallback != null) {
                                this.this$0.mCurrentCallback.onResult(i2, str2, obj, "load");
                                this.this$0.mCurrentCallback = null;
                            }
                        }
                    }
                }
            };
            this.fromDownLoad = false;
            this.isLoadingCanceled = false;
            logPluginLoad("com.baidu.searchbox.livenps", str);
            if (isAvailable()) {
                this.fromDownLoad = false;
                UBCManager uBCManager = this.ubcManager;
                if (uBCManager != null && (flow = this.pageFlow) != null) {
                    uBCManager.flowStartSlot(flow, "plugin_load", null);
                }
                BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps");
                if (bundleGroup != null && (bundleByType = bundleGroup.getBundleByType(2)) != null) {
                    i = bundleByType.getVersionCode();
                } else {
                    i = 0;
                }
                Log.d(TAG, "start load Class t=" + System.currentTimeMillis());
                if (NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps").getBundleByType(2) != null) {
                    ExecutorUtilsExt.postOnElastic(new Runnable(this, i, iInvokeCallback, z) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.37
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                        public final /* synthetic */ boolean val$enterPage;
                        public final /* synthetic */ int val$finalDownloadVersion;
                        public final /* synthetic */ IInvokeCallback val$proxyLoadCallback;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i), iInvokeCallback, Boolean.valueOf(z)};
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
                            this.val$finalDownloadVersion = i;
                            this.val$proxyLoadCallback = iInvokeCallback;
                            this.val$enterPage = z;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z3;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                                return;
                            }
                            this.this$0.dLog("开始安装LiveNps");
                            NpsLoadChainLog.getInstance().startInstallLiveNps();
                            BundleConfig bundleConfig = new BundleConfig();
                            if (this.val$finalDownloadVersion >= 508000000) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            bundleConfig.skipDownloadedBundle = z3;
                            bundleConfig.skipPresetBundle = true;
                            int prepareBundle = NPSPackageManager.getInstance().prepareBundle("com.baidu.searchbox.livenps", 0, false, bundleConfig);
                            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
                            npsLoadChainLog.setPluginVersion(this.this$0.getPluginInstallVersion() + "");
                            this.this$0.dLog("LiveNps安装结束~成功");
                            NpsLoadChainLog.getInstance().endInstallLiveNps(true, prepareBundle);
                            this.this$0.dLog("开始加载LiveNps");
                            NpsLoadChainLog.getInstance().startLoadClazzLiveNps();
                            NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, 0, this.val$proxyLoadCallback, false, bundleConfig);
                            this.this$0.handler.post(new Runnable(this) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.37.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass37 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
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
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        AnonymousClass37 anonymousClass37 = this.this$1;
                                        if (!anonymousClass37.val$enterPage) {
                                            return;
                                        }
                                        anonymousClass37.this$0.downloadUpdatePackage();
                                        this.this$1.this$0.checkEntranceUpdate();
                                    }
                                }
                            });
                        }
                    }, "nps-preparebundle", 0);
                    return;
                }
                dLog("开始加载LiveNps");
                NpsLoadChainLog.getInstance().startLoadClazzLiveNps();
                BundleConfig bundleConfig = new BundleConfig();
                if (i >= 508000000) {
                    z2 = true;
                }
                bundleConfig.skipDownloadedBundle = z2;
                bundleConfig.skipPresetBundle = true;
                NPSManager.getInstance().loadClazz("com.baidu.searchbox.livenps", "com.baidu.searchbox.live.LiveNPSPluginImpl", ILiveNPSPlugin.class, 0, iInvokeCallback, false, bundleConfig);
                if (z) {
                    downloadUpdatePackage();
                    checkEntranceUpdate();
                    return;
                }
                return;
            }
            PluginLoadCallback pluginLoadCallback2 = this.mCurrentCallback;
            if (pluginLoadCallback2 != null) {
                pluginLoadCallback2.onResult(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CONNECTION_TIMEOUT, "old arch can not install", null, "download");
                this.mCurrentCallback = null;
            }
            showNormalToast(R.string.obfuscated_res_0x7f0f0ab2, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logCancelJoinLive(String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65576, this, str, z) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "live");
                if ("download".equals(str)) {
                    str2 = "entrance_download";
                } else if ("install".equals(str)) {
                    str2 = "entrance_install";
                } else if ("load".equals(str)) {
                    str2 = "entrance_load";
                } else {
                    str2 = "";
                }
                jSONObject.put("type", str2);
                jSONObject.put("value", "suc");
                if (z) {
                    jSONObject.put("page", "yyshow");
                } else {
                    jSONObject.put("page", "media");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UBCManager uBCManager = this.ubcManager;
            if (uBCManager != null) {
                uBCManager.onEvent("4417", jSONObject);
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r0v11. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void realJumpToYYLiveActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65587, this, context, str) == null) {
            if (str.contains("&isMix=")) {
                HashMap<String, String> stringToMap = stringToMap(getParamsStr(str));
                boolean containsKey = stringToMap.containsKey("params");
                Map map = stringToMap;
                if (containsKey) {
                    try {
                        map = paramsJsonToMap(new JSONObject(stringToMap.get("params")));
                    } catch (Exception unused) {
                        map = null;
                    }
                }
                if (map != null) {
                    String str2 = map.get("roomId");
                    String str3 = map.get("source");
                    if (!map.containsKey("roomType")) {
                        map.put("roomType", "3");
                    }
                    startLiveMediaActivity(context, str2, str3, bundleToJsonStr(map), Uri.parse(str), true);
                    return;
                }
                this.mLiveNPSPlugin.getYYLiveEntry().startYYLiveActivity(context, str);
                return;
            }
            this.mLiveNPSPlugin.getYYLiveEntry().startYYLiveActivity(context, str);
        }
    }

    public void startAudioMasterActivity(@NonNull Application application, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, application, str) == null) {
            npsLoadChainInitStart();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("enter_outlive_commonwebview", "1");
                jSONObject.put("enter_outlive_weburl", "https://live.baidu.com/m/media/multipage/cb_start_broad/index.html?app_type=tieba&params=" + str);
                jSONObject.put("navigationBar", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "AUDIO_CREATE_LIVE_ROOM_H5", new PluginLoadCallback(this, application, jSONObject) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled) {
                                    if (this.this$0.mLiveNPSPlugin.getLiveMediaEntry() != null) {
                                        this.this$0.mLiveNPSPlugin.getLiveMediaEntry().enterLiveRoom(this.val$packageContext, null, null, this.val$jsonObject.toString(), null);
                                    }
                                } else {
                                    this.this$0.logCancelJoinLive(str3, false);
                                    if (this.this$0.isDebug()) {
                                        Log.w(LiveNPSPluginManagerOld.TAG, "cancel startLiveMediaActivity");
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveMediaEntry() != null) {
                this.mLiveNPSPlugin.getLiveMediaEntry().enterLiveRoom(application, null, null, jSONObject.toString(), null);
            }
        }
    }

    public void startYYCustomerServiceActivity(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, context, str) == null) {
            Log.d(TAG, "startYYCustomerServiceActivity t=" + System.currentTimeMillis());
            checkHandler();
            dLog("startYYCustomerServiceActivity--进入YY客服页面，初始化NpsLoadChainLog，设置Entry，插件版本号 = " + getPluginInstallVersion());
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog.getInstance().setEntry("YY-CustomerService");
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "YY_CUSTOMER_SERVICE", new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.30
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, i, obj) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.30.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass30 this$1;
                                public final /* synthetic */ int val$retCode;
                                public final /* synthetic */ Object val$retObject;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i), obj};
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
                                    this.val$retCode = i;
                                    this.val$retObject = obj;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        Log.d(LiveNPSPluginManagerOld.TAG, "finish load class t=" + System.currentTimeMillis());
                                        if (this.val$retCode == 14) {
                                            try {
                                                this.this$1.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                                this.this$1.this$0.mLiveNPSPlugin.getYYLiveEntry().startYYCustomerServiceActivity(this.this$1.val$context, this.this$1.val$url);
                                                return;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.this$1.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                    }
                                }
                            });
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.getYYLiveEntry().startYYCustomerServiceActivity(context, str);
            }
        }
    }

    public void startYYFeedbackActivity(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, context, str) == null) {
            Log.d(TAG, "startYYFeedbackActivity t=" + System.currentTimeMillis());
            checkHandler();
            dLog("startYYFeedbackActivity--进入YY反馈页面，初始化NpsLoadChainLog，设置Entry，插件版本号 = " + getPluginInstallVersion());
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog.getInstance().setEntry("YY-Feedback");
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "YY_FEED_BACK", new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.29
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, i, obj) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.29.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass29 this$1;
                                public final /* synthetic */ int val$retCode;
                                public final /* synthetic */ Object val$retObject;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i), obj};
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
                                    this.val$retCode = i;
                                    this.val$retObject = obj;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        Log.d(LiveNPSPluginManagerOld.TAG, "finish load class t=" + System.currentTimeMillis());
                                        if (this.val$retCode == 14) {
                                            try {
                                                this.this$1.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                                this.this$1.this$0.mLiveNPSPlugin.getYYLiveEntry().startYYFeedbackActivity(this.this$1.val$context, this.this$1.val$url);
                                                return;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.this$1.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                    }
                                }
                            });
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.getYYLiveEntry().startYYFeedbackActivity(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logPluginEnd(String str, int i, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65577, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), str2, str3, str4}) == null) && this.ubcManager != null) {
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
    }

    private void startLiveMediaActivity(Context context, String str, String str2, String str3, Uri uri, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65590, this, new Object[]{context, str, str2, str3, uri, Boolean.valueOf(z)}) == null) {
            if (!z) {
                npsLoadChainInitMedia();
            }
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "MEDIA_ENTER_LIVE_ROOM", new PluginLoadCallback(this, context, str, str2, str3, uri) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ Context val$packageContext;
                    public final /* synthetic */ String val$params;
                    public final /* synthetic */ String val$roomId;
                    public final /* synthetic */ String val$source;
                    public final /* synthetic */ Uri val$uri;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, str2, str3, uri};
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
                        this.val$roomId = str;
                        this.val$source = str2;
                        this.val$params = str3;
                        this.val$uri = uri;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str4, Object obj, String str5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str4, obj, str5}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled) {
                                    if (this.this$0.mLiveNPSPlugin.getLiveMediaEntry() != null) {
                                        this.this$0.mLiveNPSPlugin.getLiveMediaEntry().enterLiveRoom(this.val$packageContext, this.val$roomId, this.val$source, this.val$params, this.val$uri);
                                    }
                                } else {
                                    this.this$0.logCancelJoinLive(str5, false);
                                    if (this.this$0.isDebug()) {
                                        Log.w(LiveNPSPluginManagerOld.TAG, "cancel startLiveMediaActivity");
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveMediaEntry() != null) {
                this.mLiveNPSPlugin.getLiveMediaEntry().enterLiveRoom(context, str, str2, str3, uri);
            }
            if (isDebug()) {
                logPluginVersionCode();
            }
        }
    }

    public static Map<String, String> paramsJsonToMap(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt instanceof String) {
                    hashMap.put(next, (String) opt);
                } else {
                    hashMap.put(next, opt.toString());
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r5v6. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public String parserYYSchemaUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, this, str)) == null) {
            HashMap<String, String> stringToMap = stringToMap(getParamsStr(str));
            boolean containsKey = stringToMap.containsKey("params");
            Map map = stringToMap;
            if (containsKey) {
                try {
                    map = paramsJsonToMap(new JSONObject(stringToMap.get("params")));
                } catch (Exception unused) {
                    map = null;
                }
            }
            if (map != null) {
                return map.get("url");
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r5v6. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    private String parseEntry(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, this, str)) == null) {
            HashMap<String, String> stringToMap = stringToMap(getParamsStr(str));
            boolean containsKey = stringToMap.containsKey("params");
            Map map = stringToMap;
            if (containsKey) {
                try {
                    map = paramsJsonToMap(new JSONObject(stringToMap.get("params")));
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
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r1v7. Raw type applied. Possible types: java.util.Map<java.lang.String, java.lang.String> */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public Map<String, String> parseYYLiveParamMap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, this, str)) == null) {
            HashMap hashMap = new HashMap();
            HashMap<String, String> stringToMap = stringToMap(getParamsStr(str));
            boolean containsKey = stringToMap.containsKey("params");
            Map map = stringToMap;
            if (containsKey) {
                try {
                    map = paramsJsonToMap(new JSONObject(stringToMap.get("params")));
                } catch (Exception unused) {
                    map = null;
                }
            }
            if (map != null) {
                String str2 = map.get("sid");
                String str3 = map.get(YyLiveRoomConfig.KEY_SSID);
                String str4 = map.get("anchorUid");
                String str5 = map.get("templateId");
                String str6 = map.get(YyLiveRoomConfig.KEY_STREAMINFO);
                if (str.contains("isMix=1")) {
                    hashMap.put("PreJoinChannelType", "mix");
                } else {
                    hashMap.put("PreJoinChannelType", "startYYLive");
                }
                hashMap.put("PreJoinChannelSid", str2);
                hashMap.put("PreJoinChannelSsid", str3);
                hashMap.put("PreJoinChannelTemplateId", str5);
                hashMap.put("PreJoinChannelAnchorId", str4);
                hashMap.put("PreJoinChannelStreamInfo", str6);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalToast(int i, int i2) {
        ToastService toastService;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65589, this, i, i2) == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.handler.post(new Runnable(this, i, i2) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.42
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.appService != null && this.this$0.toastService != null) {
                            this.this$0.toastService.showNormal(this.this$0.appService.getApplication(), this.this$0.appService.getApplication().getResources().getString(this.val$textResId), this.val$duration);
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
    }

    public void checkArSdkLoadStatus(@NonNull Context context, @NonNull LiveNpsArStatusCallback liveNpsArStatusCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, liveNpsArStatusCallback) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "LIVE_SHOW_CHECK_AR", new PluginLoadCallback(this, liveNpsArStatusCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.23
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ LiveNpsArStatusCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, liveNpsArStatusCallback};
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
                        this.val$callback = liveNpsArStatusCallback;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                                    this.val$callback.onArSdkStatus(this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry().isArSdkLoaded());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                liveNpsArStatusCallback.onArSdkStatus(this.mLiveNPSPlugin.getLiveShowMasterEntry().isArSdkLoaded());
            }
        }
    }

    public void startArSdkLoad(@NonNull Context context, @NonNull LiveNpsArLoadCallback liveNpsArLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, context, liveNpsArLoadCallback) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, "LIVE_SHOW_LOAD_AR", new PluginLoadCallback(this, liveNpsArLoadCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.24
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ LiveNpsArLoadCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, liveNpsArLoadCallback};
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
                        this.val$callback = liveNpsArLoadCallback;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry().loadArSdk(new ILiveShowMasterEntry.ArSdkLoadCallback(this) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.24.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass24 this$1;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
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
                                        }

                                        @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                                        public void onProgress(int i2, int i3) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeII(1048576, this, i2, i3) == null) {
                                                this.this$1.val$callback.onProgress(i2, i3);
                                            }
                                        }

                                        @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                                        public void onResult(boolean z, String str3) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str3) == null) {
                                                this.this$1.val$callback.onResult(z, str3);
                                            }
                                        }
                                    });
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowMasterEntry().loadArSdk(new ILiveShowMasterEntry.ArSdkLoadCallback(this, liveNpsArLoadCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.25
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ LiveNpsArLoadCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, liveNpsArLoadCallback};
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
                        this.val$callback = liveNpsArLoadCallback;
                    }

                    @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                    public void onProgress(int i, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeII(1048576, this, i, i2) == null) {
                            this.val$callback.onProgress(i, i2);
                        }
                    }

                    @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                    public void onResult(boolean z, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                            this.val$callback.onResult(z, str);
                        }
                    }
                });
            }
        }
    }

    public void dispatchHostEvent(@NonNull Context context, @NonNull String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, context, str, map) == null) && this.mLiveNPSPlugin != null) {
            if (map != null && !TextUtils.isEmpty(str) && context != null) {
                this.mLiveNPSPlugin.dispatchHostEvent(context, str, map);
            }
            if (this.mLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().dispatchHostEvent(context, str, map);
            }
            if (this.mLiveNPSPlugin.getLiveMediaEntry() != null) {
                this.mLiveNPSPlugin.getLiveMediaEntry().dispatchHostEvent(context, str, map);
            }
            if (this.mLiveNPSPlugin.getYYLiveEntry() != null) {
                this.mLiveNPSPlugin.getYYLiveEntry().dispatchHostEvent(context, str, map);
            }
            if (getPluginInstallVersion() >= 503500000 && this.mLiveNPSPlugin.getLiveBjhEntry() != null) {
                this.mLiveNPSPlugin.getLiveBjhEntry().dispatchHostEvent(context, str, map);
            }
        }
    }

    public void dispatchYYLiveRouter(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) {
            if (YYStaticConfig.conf == null) {
                YYStaticConfig.conf = new HashMap<>();
            }
            YYStaticConfig.conf.put("hostSchemeParseBegin", Long.valueOf(System.currentTimeMillis()));
            checkHandler();
            dLog("dispatchYYLiveRouter--YY万能路由，初始化NpsLoadChainLog，设置Entry，插件版本号 = " + getPluginInstallVersion());
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog.getInstance().setEntry("YY-Router");
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
            if (this.mLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "YY_LIVE_ROUTER", new PluginLoadCallback(this, str, context) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.31
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, str3, i, obj) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.31.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass31 this$1;
                                public final /* synthetic */ String val$loadType;
                                public final /* synthetic */ int val$retCode;
                                public final /* synthetic */ Object val$retObject;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, str3, Integer.valueOf(i), obj};
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
                                    this.val$loadType = str3;
                                    this.val$retCode = i;
                                    this.val$retObject = obj;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        Log.d(LiveNPSPluginManagerOld.TAG, "finish load class t=" + System.currentTimeMillis());
                                        if (YYStaticConfig.conf == null) {
                                            YYStaticConfig.conf = new HashMap<>();
                                        }
                                        if ("download".equals(this.val$loadType)) {
                                            YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "download");
                                        } else if ("install".equals(this.val$loadType)) {
                                            YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "install");
                                        } else if ("load".equals(this.val$loadType)) {
                                            YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "load");
                                        }
                                        AnonymousClass31 anonymousClass31 = this.this$1;
                                        String parserYYSchemaUrl = anonymousClass31.this$0.parserYYSchemaUrl(anonymousClass31.val$url);
                                        YYStaticConfig.conf.put("PreJoinChannelType", "Schema");
                                        YYStaticConfig.conf.put("PreJoinChannelSchemaUrl", parserYYSchemaUrl);
                                        LiveNPSPluginManagerOld liveNPSPluginManagerOld = this.this$1.this$0;
                                        liveNPSPluginManagerOld.dLog("schemaUrl = " + parserYYSchemaUrl);
                                        if (this.val$retCode == 14) {
                                            try {
                                                this.this$1.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                                this.this$1.this$0.mLiveNPSPlugin.getYYLiveEntry().dispatchYYLiveRouter(this.this$1.val$context, this.this$1.val$url);
                                                return;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.this$1.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            if (YYStaticConfig.conf == null) {
                YYStaticConfig.conf = new HashMap<>();
            }
            YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "direct");
            if (this.mLiveNPSPlugin.getYYLiveEntry() != null && !this.mLiveNPSPlugin.getYYLiveEntry().isLoaded()) {
                String parserYYSchemaUrl = parserYYSchemaUrl(str);
                YYStaticConfig.conf.put("PreJoinChannelType", "Schema");
                YYStaticConfig.conf.put("PreJoinChannelSchemaUrl", parserYYSchemaUrl);
                dLog("not load, schemaUrl = " + parserYYSchemaUrl);
            }
            this.mLiveNPSPlugin.getYYLiveEntry().dispatchYYLiveRouter(context, str);
        }
    }

    public void startYYLiveActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, context, str) == null) {
            Log.d(TAG, "startYYLiveActivity t=" + System.currentTimeMillis());
            if (YYStaticConfig.conf == null) {
                YYStaticConfig.conf = new HashMap<>();
            }
            YYStaticConfig.conf.put("hostJoinLiveBegin", Long.valueOf(System.currentTimeMillis()));
            UBCManager uBCManager = this.ubcManager;
            if (uBCManager != null) {
                this.pageFlow = uBCManager.beginFlow("3121");
            }
            dLog("startYYLiveActivity--进入YY直播间，初始化NpsLoadChainLog，设置Entry，插件版本号 = " + getPluginInstallVersion());
            NpsLoadChainLog.getInstance().initAndStart();
            NpsLoadChainLog.getInstance().setEntry(parseEntry(str));
            NpsLoadChainLog npsLoadChainLog = NpsLoadChainLog.getInstance();
            npsLoadChainLog.setPluginVersion(getPluginInstallVersion() + "");
            if (this.mLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "YY_ENTER_LIVE_ROOM", new PluginLoadCallback(this, str, context) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.27
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            Log.d(LiveNPSPluginManagerOld.TAG, "finish load class t=" + System.currentTimeMillis());
                            LiveNPSPluginManagerOld liveNPSPluginManagerOld = this.this$0;
                            liveNPSPluginManagerOld.dLog("startYYLiveActivity.PluginLoadCallback.onResult()，retCode = " + i + ", retMsg = " + str2 + ", retObject = " + obj + ", loadType = " + str3);
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
                                    Map<? extends String, ? extends Object> parseYYLiveParamMap = this.this$0.parseYYLiveParamMap(this.val$url);
                                    LiveNPSPluginManagerOld liveNPSPluginManagerOld2 = this.this$0;
                                    liveNPSPluginManagerOld2.dLog("parseYYLiveParamMap " + parseYYLiveParamMap);
                                    YYStaticConfig.conf.putAll(parseYYLiveParamMap);
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (!this.this$0.isLoadingCanceled) {
                                        if (this.this$0.mLiveNPSPlugin.getYYLiveEntry() != null) {
                                            if (this.this$0.pageFlow != null) {
                                                YYStatInfo yYStatInfo = new YYStatInfo();
                                                yYStatInfo.flowObj = this.this$0.pageFlow;
                                                yYStatInfo.isColdLaunch = true;
                                                yYStatInfo.loadType = str3;
                                                this.this$0.mLiveNPSPlugin.getYYLiveEntry().updateStatInfo(yYStatInfo);
                                                this.this$0.pageFlow = null;
                                            }
                                            this.this$0.checkYYEntranceIsLoaded(this.val$context, this.val$url);
                                            return;
                                        }
                                        return;
                                    }
                                    this.this$0.logCancelJoinLive(str3, true);
                                    if (this.this$0.isDebug()) {
                                        Log.w(LiveNPSPluginManagerOld.TAG, "cancel startYYLiveActivity");
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
                                Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                            }
                        }
                    }
                });
                return;
            }
            if (YYStaticConfig.conf == null) {
                YYStaticConfig.conf = new HashMap<>();
            }
            YYStaticConfig.conf.put("hostJoinLivePluginFromStatus", "direct");
            if (this.mLiveNPSPlugin.getYYLiveEntry() != null) {
                if (this.pageFlow != null) {
                    YYStatInfo yYStatInfo = new YYStatInfo();
                    yYStatInfo.flowObj = this.pageFlow;
                    yYStatInfo.isColdLaunch = false;
                    yYStatInfo.loadType = "launch";
                    try {
                        this.mLiveNPSPlugin.getYYLiveEntry().updateStatInfo(yYStatInfo);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    this.pageFlow = null;
                }
                if (!this.mLiveNPSPlugin.getYYLiveEntry().isLoaded()) {
                    Map<String, String> parseYYLiveParamMap = parseYYLiveParamMap(str);
                    dLog("not load parseYYLiveParamMap " + parseYYLiveParamMap);
                    YYStaticConfig.conf.putAll(parseYYLiveParamMap);
                }
                checkYYEntranceIsLoaded(context, str);
            }
        }
    }

    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int bundleStatus = NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.livenps");
            if (bundleStatus != 43) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: bundle status=" + bundleStatus);
                }
                return false;
            }
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.livenps");
            if (bundleGroup == null) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: top plugin is null");
                }
                return false;
            }
            BundleInfo bundleByType = bundleGroup.getBundleByType(3);
            BundleInfo bundleByType2 = bundleGroup.getBundleByType(2);
            if (bundleByType2 != null) {
                bundleByType = bundleByType2;
            }
            if (bundleByType == null) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: top plugin has no update");
                }
                return true;
            }
            int length = NPS_PLUGIN_SUB_PKG_GROUP.length;
            BundleInfoGroup[] bundleInfoGroupArr = new BundleInfoGroup[length];
            boolean z = true;
            for (int i = 0; i < length; i++) {
                bundleInfoGroupArr[i] = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_SUB_PKG_GROUP[i]);
                if (bundleInfoGroupArr[i] != null) {
                    z = false;
                }
            }
            if (z) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: sec plugin not exist");
                }
                return true;
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (bundleInfoGroupArr[i2] != null) {
                    BundleInfo bundleByType3 = bundleInfoGroupArr[i2].getBundleByType(3);
                    if (bundleByType3 != null && compareVersion(bundleByType.getVersionCode(), bundleByType3.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: installed " + bundleByType3.getPackageName() + " plugin too high");
                        }
                        return false;
                    }
                    BundleInfo bundleByType4 = bundleInfoGroupArr[i2].getBundleByType(1);
                    BundleInfo bundleByType5 = bundleInfoGroupArr[i2].getBundleByType(2);
                    if (bundleByType4 != null && bundleByType4.needForceUpdate() && compareVersion(bundleByType.getVersionCode(), bundleByType4.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: sec " + bundleByType4.getPackageName() + " plugin force update1");
                        }
                        return false;
                    } else if (bundleByType4 == null && bundleByType5 != null && bundleByType5.needForceUpdate() && compareVersion(bundleByType.getVersionCode(), bundleByType5.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: sec " + bundleByType5.getPackageName() + " plugin force update2");
                        }
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), iLiveDiskClearCacheCallback}) == null) {
            Log.d(TAG, "start DiskClearCacheChange t=" + System.currentTimeMillis());
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, "NEW_ON_DISK_CLEAR_CACHE_CHANGE", new PluginLoadCallback(this, j, i, i2, iLiveDiskClearCacheCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.41
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i3, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), str, obj, str2}) == null) {
                            Log.d(LiveNPSPluginManagerOld.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i3 != 14) {
                                this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                this.this$0.mLiveNPSPlugin.onDiskClearCacheChange(this.val$quota, this.val$oldState, this.val$newState, this.val$callback);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                });
                return;
            }
            try {
                iLiveNPSPlugin.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void startBjhMasterActivityNew(@NonNull Context context, String str, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, context, str, uri) == null) {
            if (getPluginInstallVersion() >= 506000000) {
                npsLoadChainInitStart();
                ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
                if (iLiveNPSPlugin == null) {
                    loadNPSPluginImpl(true, "MEDIA_BJH_CREATE_LIVE_ROOM", new PluginLoadCallback(this, context, str, uri) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LiveNPSPluginManagerOld this$0;
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

                        @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                        public void onResult(int i, String str2, Object obj, String str3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                                if (i != 14) {
                                    if (!this.this$0.isLoadingCanceled) {
                                        this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                    }
                                    if (this.this$0.isDebug()) {
                                        Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                        return;
                                    }
                                    return;
                                }
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveBjhEntry() != null) {
                                        this.this$0.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivityNew(this.val$packageContext, this.val$params, this.val$uri);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
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

    public void startLiveExpActivity(@NonNull Context context, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{context, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "LIVE_SHOW_LIVE_EXP", new PluginLoadCallback(this, context, j, i) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ long val$currentExp;
                    public final /* synthetic */ int val$currentLevel;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, Long.valueOf(j), Integer.valueOf(i)};
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
                        this.val$context = context;
                        this.val$currentExp = j;
                        this.val$currentLevel = i;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i2, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, obj, str2}) == null) {
                            if (i2 != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i2);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveShowEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().openLiveExpPage(this.val$context, this.val$currentExp, this.val$currentLevel);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().openLiveExpPage(context, j, i);
            }
        }
    }

    public void startLiveMediaActivity(Context context, String str, String str2, String str3, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048600, this, context, str, str2, str3, uri) == null) {
            startLiveMediaActivity(context, str, str2, str3, uri, false);
        }
    }

    public void startYuYinActivity(@NonNull Context context, @NonNull String str, @NonNull String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048613, this, context, str, str2, map) == null) {
            npsLoadChainInitOther();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "YU_YIN_ENTER_LIVE_ROOM", new PluginLoadCallback(this, context, str, str2, map) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.21
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManagerOld this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$otherParams;
                    public final /* synthetic */ Map val$params;
                    public final /* synthetic */ String val$scheme;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, str2, map};
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
                        this.val$scheme = str;
                        this.val$otherParams = str2;
                        this.val$params = map;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManagerOld.PluginLoadCallback
                    public void onResult(int i, String str3, Object obj, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str3, obj, str4}) == null) {
                            if (i != 14) {
                                if (!this.this$0.isLoadingCanceled) {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f09d0, 0);
                                }
                                if (this.this$0.isDebug()) {
                                    Log.w(LiveNPSPluginManagerOld.TAG, "load live nps plugin error=" + i);
                                    return;
                                }
                                return;
                            }
                            try {
                                this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                if (!this.this$0.isLoadingCanceled && this.this$0.mLiveNPSPlugin.getLiveYuYinEntry() != null) {
                                    this.this$0.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinLiveActivity(this.val$context, this.val$scheme, this.val$otherParams, this.val$params);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveYuYinEntry() != null) {
                this.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinLiveActivity(context, str, str2, map);
            }
        }
    }
}
