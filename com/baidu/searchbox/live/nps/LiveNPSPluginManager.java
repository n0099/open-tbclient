package com.baidu.searchbox.live.nps;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveStatusDataCallback;
import com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import d.a.b0.d.a.a;
import d.a.b0.f.b;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveNPSPluginManager {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final String TAG = "LiveNPSPluginManager";
    public static final String UBC_ID_PLUGIN_END = "3185";
    public static final String UBC_ID_PLUGIN_PAGE_FLOW = "3121";
    public static final String UBC_ID_PLUGIN_START = "3186";
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
    public ILiveNPSPlugin mLiveNPSPlugin;
    public Handler mMainHandler;
    public Flow pageFlow;
    public ToastService toastService;
    public UBCManager ubcManager;

    /* loaded from: classes2.dex */
    public interface PluginLoadCallback {
        void onResult(int i2, String str, Object obj, String str2);
    }

    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static LiveNPSPluginManager instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(107219756, "Lcom/baidu/searchbox/live/nps/LiveNPSPluginManager$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(107219756, "Lcom/baidu/searchbox/live/nps/LiveNPSPluginManager$SingletonHolder;");
                    return;
                }
            }
            instance = new LiveNPSPluginManager();
        }

        public SingletonHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1502470559, "Lcom/baidu/searchbox/live/nps/LiveNPSPluginManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1502470559, "Lcom/baidu/searchbox/live/nps/LiveNPSPluginManager;");
                return;
            }
        }
        NPS_PLUGIN_SUB_PKG_GROUP = new String[]{YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_1, YYLiveNPSPluginManager.NPS_PLUGIN_PKG_NAME2_2, "com.baidu.searchbox.yylive.extlib", "com.baidu.searchbox.bjhlivenps", "com.baidu.searchbox.yylive.createlive", "com.baidu.searchbox.yylive.game", "com.baidu.searchbox.yylive.yylib", "com.baidu.searchbox.yylive.audiolive", "com.baidu.searchbox.yylive.friends"};
    }

    private void checkHandler() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65559, this) == null) && this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
    }

    private int compareVersion(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65560, this, i2, i3)) == null) ? (i2 / 1000) - (i3 / 1000) : invokeII.intValue;
    }

    public static LiveNPSPluginManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? SingletonHolder.instance : (LiveNPSPluginManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPluginInstallVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo(NPS_PLUGIN_PKG_NAME);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            AppInfoService appInfoService = this.appService;
            if (appInfoService != null) {
                return appInfoService.isDebug();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void loadNPSPluginImpl(boolean z, String str, PluginLoadCallback pluginLoadCallback) {
        Flow flow;
        Flow flow2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, this, new Object[]{Boolean.valueOf(z), str, pluginLoadCallback}) == null) {
            this.mCurrentCallback = pluginLoadCallback;
            Log.d(TAG, "NPS load from=" + str);
            IInvokeCallback iInvokeCallback = new IInvokeCallback(this, str, pluginLoadCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.28
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveNPSPluginManager this$0;
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, obj) == null) {
                        if (this.this$0.ubcManager != null && this.this$0.pageFlow != null) {
                            this.this$0.ubcManager.flowEndSlot(this.this$0.pageFlow, "plugin_load");
                        }
                        LiveNPSPluginManager liveNPSPluginManager = this.this$0;
                        int pluginInstallVersion = liveNPSPluginManager.getPluginInstallVersion();
                        boolean z2 = i2 == 14;
                        liveNPSPluginManager.logPluginEnd(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, pluginInstallVersion, z2, "load code" + i2, this.this$0.fromDownLoad ? "nps_download" : "nps_install", this.val$useFrom);
                        if (this.val$callback != null) {
                            String str3 = this.this$0.fromDownLoad ? "download" : "install";
                            if (Looper.myLooper() != Looper.getMainLooper()) {
                                this.this$0.handler.post(new Runnable(this, i2, str2, obj, str3) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.28.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass28 this$1;
                                    public final /* synthetic */ int val$i;
                                    public final /* synthetic */ String val$loadType;
                                    public final /* synthetic */ Object val$o;
                                    public final /* synthetic */ String val$s;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Integer.valueOf(i2), str2, obj, str3};
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
                                        this.val$loadType = str3;
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
                                this.this$0.mCurrentCallback.onResult(i2, str2, obj, str3);
                                this.this$0.mCurrentCallback = null;
                            }
                        }
                    }
                }
            };
            IInvokeCallback iInvokeCallback2 = new IInvokeCallback(this, str, pluginLoadCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveNPSPluginManager this$0;
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
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, obj) == null) {
                        if (this.this$0.ubcManager != null && this.this$0.pageFlow != null) {
                            this.this$0.ubcManager.flowEndSlot(this.this$0.pageFlow, "plugin_load");
                        }
                        LiveNPSPluginManager liveNPSPluginManager = this.this$0;
                        int pluginInstallVersion = liveNPSPluginManager.getPluginInstallVersion();
                        boolean z2 = i2 == 14;
                        liveNPSPluginManager.logPluginEnd(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, pluginInstallVersion, z2, "load code" + i2, "nps_load", this.val$useFrom);
                        if (this.val$callback != null) {
                            if (Looper.myLooper() != Looper.getMainLooper()) {
                                this.this$0.handler.post(new Runnable(this, i2, str2, obj) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.29.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass29 this$1;
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
                                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.this$0.mCurrentCallback == null) {
                                            return;
                                        }
                                        this.this$1.this$0.mCurrentCallback.onResult(this.val$i, this.val$s, this.val$o, "load");
                                        this.this$1.this$0.mCurrentCallback = null;
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
            logPluginLoad(NPS_PLUGIN_PKG_NAME, str);
            if (isAvailable()) {
                this.fromDownLoad = false;
                UBCManager uBCManager = this.ubcManager;
                if (uBCManager != null && (flow2 = this.pageFlow) != null) {
                    uBCManager.flowStartSlot(flow2, "plugin_load", null);
                }
                Log.d(TAG, "start load Class t=" + System.currentTimeMillis());
                NPSManager.getInstance().loadClazz(NPS_PLUGIN_PKG_NAME, NPS_PLUGIN_IMPL_CLASS_NAME, ILiveNPSPlugin.class, iInvokeCallback2);
                if (z) {
                    NPSPackageManager.getInstance().downloadUpdatePackage(NPS_PLUGIN_PKG_NAME, new a(this) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.30
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LiveNPSPluginManager this$0;

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

                        @Override // d.a.b0.d.a.a
                        public void onProgress(long j, long j2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                            }
                        }

                        @Override // d.a.b0.d.a.a
                        public void onResult(int i2, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                            }
                        }
                    }, new d.a.b0.f.a(this) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.31
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ LiveNPSPluginManager this$0;

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

                        @Override // d.a.b0.f.a
                        public void checkAuthorization(IBundleInfo iBundleInfo, int i2, b bVar) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeLIL(1048576, this, iBundleInfo, i2, bVar) == null) || bVar == null) {
                                return;
                            }
                            bVar.onResult(1);
                        }
                    }, 1);
                    return;
                }
                return;
            }
            this.isLoadingCanceled = false;
            if (z) {
                showLoading();
            }
            UBCManager uBCManager2 = this.ubcManager;
            if (uBCManager2 != null && (flow = this.pageFlow) != null) {
                uBCManager2.flowStartSlot(flow, "plugin_install", null);
            }
            this.fromDownLoad = false;
            Log.d(TAG, "start install bundle t=" + System.currentTimeMillis());
            NPSPackageManager.getInstance().installBundle(NPS_PLUGIN_PKG_NAME, new IInstallCallback(this, iInvokeCallback, z, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.32
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveNPSPluginManager this$0;
                public final /* synthetic */ boolean val$enterPage;
                public final /* synthetic */ IInvokeCallback val$proxyInstallCallback;
                public final /* synthetic */ String val$useFrom;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iInvokeCallback, Boolean.valueOf(z), str};
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
                    this.val$proxyInstallCallback = iInvokeCallback;
                    this.val$enterPage = z;
                    this.val$useFrom = str;
                }

                @Override // com.baidu.nps.main.install.IInstallCallback
                public void onProgress(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        this.this$0.fromDownLoad = true;
                        if (this.this$0.loadingCallback == null || this.this$0.isLoadingCanceled) {
                            return;
                        }
                        this.this$0.loadingCallback.onLoadingProgress(j, j2);
                    }
                }

                @Override // com.baidu.nps.main.install.IInstallCallback
                public void onResult(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        if (!this.this$0.isLoadingCanceled && i2 != 34) {
                            this.this$0.stopLoading(i2);
                        }
                        if (i2 == 13) {
                            if (this.this$0.ubcManager != null && this.this$0.pageFlow != null) {
                                this.this$0.ubcManager.flowEndSlot(this.this$0.pageFlow, "plugin_install");
                                this.this$0.ubcManager.flowStartSlot(this.this$0.pageFlow, "plugin_load", null);
                            }
                            Log.d(LiveNPSPluginManager.TAG, "start load Class t=" + System.currentTimeMillis());
                            NPSManager.getInstance().loadClazz(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, LiveNPSPluginManager.NPS_PLUGIN_IMPL_CLASS_NAME, ILiveNPSPlugin.class, this.val$proxyInstallCallback);
                        } else if (i2 == 3 && NPSPackageManager.getInstance().getBundleStatus(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME) == 43) {
                            if (this.this$0.ubcManager != null && this.this$0.pageFlow != null) {
                                this.this$0.ubcManager.flowEndSlot(this.this$0.pageFlow, "plugin_install");
                                this.this$0.ubcManager.flowStartSlot(this.this$0.pageFlow, "plugin_load", null);
                            }
                            NPSManager.getInstance().loadClazz(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, LiveNPSPluginManager.NPS_PLUGIN_IMPL_CLASS_NAME, ILiveNPSPlugin.class, this.val$proxyInstallCallback);
                        } else {
                            if (this.val$enterPage) {
                                if (i2 == 34) {
                                    if (this.this$0.loadingCallback == null) {
                                        this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_installing, 0);
                                    }
                                } else {
                                    this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                                }
                            }
                            if (this.this$0.ubcManager != null && this.this$0.pageFlow != null) {
                                this.this$0.ubcManager.flowEnd(this.this$0.pageFlow);
                                this.this$0.pageFlow = null;
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "install live nps plugin error=" + i2);
                            }
                            LiveNPSPluginManager liveNPSPluginManager = this.this$0;
                            int pluginInstallVersion = liveNPSPluginManager.getPluginInstallVersion();
                            liveNPSPluginManager.logPluginEnd(LiveNPSPluginManager.NPS_PLUGIN_PKG_NAME, pluginInstallVersion, false, "install code" + i2, "nps_install", this.val$useFrom);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logPluginEnd(String str, int i2, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65565, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), str2, str3, str4}) == null) || this.ubcManager == null) {
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
                jSONObject.put("value", com.baidu.pass.biometrics.face.liveness.b.a.g0);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pkg", str);
            jSONObject2.put("ver", i2);
            jSONObject2.put("useFrom", str4);
            jSONObject2.put("reason", str2);
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.ubcManager.onEvent(UBC_ID_PLUGIN_END, jSONObject);
    }

    private void logPluginLoad(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65566, this, str, str2) == null) || this.ubcManager == null) {
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
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.ubcManager.onEvent(UBC_ID_PLUGIN_START, jSONObject);
    }

    private void logPluginVersionCode() {
        BundleInfo bundleInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65567, this) == null) && NPSPackageManager.getInstance().getBundleStatus(NPS_PLUGIN_PKG_NAME) == 43 && (bundleInfo = NPSPackageManager.getInstance().getBundleInfo(NPS_PLUGIN_PKG_NAME)) != null) {
            Log.d("NPS", "NPS Installed live plugin version code " + bundleInfo.getVersionCode());
        }
    }

    private void showLoading() {
        LiveNpsLoadingCallback liveNpsLoadingCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65568, this) == null) || (liveNpsLoadingCallback = this.loadingCallback) == null) {
            return;
        }
        liveNpsLoadingCallback.onLoadingStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalToast(int i2, int i3) {
        ToastService toastService;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65569, this, i2, i3) == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.handler.post(new Runnable(this, i2, i3) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.37
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ int val$duration;
                    public final /* synthetic */ int val$textResId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$textResId = i2;
                        this.val$duration = i3;
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
            toastService.showNormal(appInfoService.getApplication(), this.appService.getApplication().getResources().getString(i2), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLoading(int i2) {
        LiveNpsLoadingCallback liveNpsLoadingCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65570, this, i2) == null) || (liveNpsLoadingCallback = this.loadingCallback) == null) {
            return;
        }
        liveNpsLoadingCallback.onLoadingEnd(i2);
    }

    public void cancelLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.isLoadingCanceled = true;
        }
    }

    public void checkArSdkLoadStatus(@NonNull Context context, @NonNull LiveNpsArStatusCallback liveNpsArStatusCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, liveNpsArStatusCallback) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, LIVE_SHOW_CHECK_AR, new PluginLoadCallback(this, liveNpsArStatusCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.20
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ LiveNpsArStatusCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, liveNpsArStatusCallback};
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
                        this.val$callback = liveNpsArStatusCallback;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, obj, str2}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry() == null) {
                                        return;
                                    }
                                    this.val$callback.onArSdkStatus(this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry().isArSdkLoaded());
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                liveNpsArStatusCallback.onArSdkStatus(this.mLiveNPSPlugin.getLiveShowMasterEntry().isArSdkLoaded());
            }
        }
    }

    public void clearResourceFile(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, NEW_CLEAR_RESOURCE_FILE, new PluginLoadCallback(this, context) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.35
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$packageContext;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
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
                        this.val$packageContext = context;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, obj, str2}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    this.this$0.mLiveNPSPlugin.clearLiveResourceSize(this.val$packageContext);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.clearLiveResourceSize(context);
            }
        }
    }

    public void dispatchHostEvent(@NonNull Context context, @NonNull String str, Map<String, Object> map) {
        ILiveNPSPlugin iLiveNPSPlugin;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, context, str, map) == null) || (iLiveNPSPlugin = this.mLiveNPSPlugin) == null) {
            return;
        }
        iLiveNPSPlugin.dispatchHostEvent(context, str, map);
        if (this.mLiveNPSPlugin.getLiveShowEntry() != null) {
            this.mLiveNPSPlugin.getLiveShowEntry().dispatchHostEvent(context, str, map);
        }
        if (this.mLiveNPSPlugin.getLiveMediaEntry() != null) {
            this.mLiveNPSPlugin.getLiveMediaEntry().dispatchHostEvent(context, str, map);
        }
        if (this.mLiveNPSPlugin.getYYLiveEntry() != null) {
            this.mLiveNPSPlugin.getYYLiveEntry().dispatchHostEvent(context, str, map);
        }
    }

    public void dispatchYYLiveRouter(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) {
            checkHandler();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, YY_LIVE_ROUTER, new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.27
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$url;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
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
                        this.val$url = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, i2, obj) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.27.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass27 this$1;
                                public final /* synthetic */ int val$retCode;
                                public final /* synthetic */ Object val$retObject;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i2), obj};
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
                                    this.val$retCode = i2;
                                    this.val$retObject = obj;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        Log.d(LiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                                        if (this.val$retCode != 14) {
                                            this.this$1.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                                            return;
                                        }
                                        try {
                                            this.this$1.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                            this.this$1.this$0.mLiveNPSPlugin.getYYLiveEntry().dispatchYYLiveRouter(this.this$1.val$context, this.this$1.val$url);
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                }
                            });
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.getYYLiveEntry().dispatchYYLiveRouter(context, str);
            }
        }
    }

    public BundleInfo getInstalledPluginInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? NPSPackageManager.getInstance().getBundleInfo(NPS_PLUGIN_PKG_NAME) : (BundleInfo) invokeV.objValue;
    }

    public void getLiveResourceFileSize(@NonNull Context context, @NonNull ILiveFileSizeCallback iLiveFileSizeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, iLiveFileSizeCallback) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, NEW_GET_RESOURCE_FILE_SIZE, new PluginLoadCallback(this, context, iLiveFileSizeCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.34
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ ILiveFileSizeCallback val$callback;
                    public final /* synthetic */ Context val$packageContext;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, iLiveFileSizeCallback};
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
                        this.val$packageContext = context;
                        this.val$callback = iLiveFileSizeCallback;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, obj, str2}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    this.this$0.mLiveNPSPlugin.getLiveResourceSize(this.val$packageContext, this.val$callback);
                                    return;
                                } catch (Exception e2) {
                                    this.val$callback.getFileSize(0L);
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            this.val$callback.getFileSize(0L);
                            this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
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
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, liveStatusDataCallback) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, NEW_GET_LIVE_ROOM_STATUS, new PluginLoadCallback(this, str, liveStatusDataCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ LiveStatusDataCallback val$callback;
                    public final /* synthetic */ String val$roomId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, liveStatusDataCallback};
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
                        this.val$roomId = str;
                        this.val$callback = liveStatusDataCallback;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    this.this$0.mLiveNPSPlugin.getLiveRoomStatus(this.val$roomId, this.val$callback);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
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
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, iLiveFileSizeCallback) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, NEW_GET_LIVE_SDK_FILE_SIZE, new PluginLoadCallback(this, context, iLiveFileSizeCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.33
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ ILiveFileSizeCallback val$callback;
                    public final /* synthetic */ Context val$packageContext;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, iLiveFileSizeCallback};
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
                        this.val$packageContext = context;
                        this.val$callback = iLiveFileSizeCallback;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, obj, str2}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    this.this$0.mLiveNPSPlugin.getLiveSdkSize(this.val$packageContext, this.val$callback);
                                    return;
                                } catch (Exception e2) {
                                    this.val$callback.getFileSize(0L);
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            this.val$callback.getFileSize(0L);
                            this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.getLiveSdkSize(context, iLiveFileSizeCallback);
            }
        }
    }

    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int bundleStatus = NPSPackageManager.getInstance().getBundleStatus(NPS_PLUGIN_PKG_NAME);
            if (bundleStatus != 43) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: bundle status=" + bundleStatus);
                }
                return false;
            }
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_PKG_NAME);
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
            for (int i2 = 0; i2 < length; i2++) {
                bundleInfoGroupArr[i2] = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_SUB_PKG_GROUP[i2]);
                if (bundleInfoGroupArr[i2] != null) {
                    z = false;
                }
            }
            if (z) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: sec plugin not exist");
                }
                return true;
            }
            for (int i3 = 0; i3 < length; i3++) {
                if (bundleInfoGroupArr[i3] != null) {
                    BundleInfo bundleByType3 = bundleInfoGroupArr[i3].getBundleByType(3);
                    if (bundleByType3 != null && compareVersion(bundleByType.getVersionCode(), bundleByType3.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: installed " + bundleByType3.getPackageName() + " plugin too high");
                        }
                        return false;
                    }
                    BundleInfo bundleByType4 = bundleInfoGroupArr[i3].getBundleByType(1);
                    BundleInfo bundleByType5 = bundleInfoGroupArr[i3].getBundleByType(2);
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

    public void isInHistory(@NonNull String str, @NonNull LiveStatusDataCallback<Boolean> liveStatusDataCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, liveStatusDataCallback) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, NEW_IS_HISTORY, new PluginLoadCallback(this, str, liveStatusDataCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ LiveStatusDataCallback val$callback;
                    public final /* synthetic */ String val$roomId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, liveStatusDataCallback};
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
                        this.val$roomId = str;
                        this.val$callback = liveStatusDataCallback;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    this.this$0.mLiveNPSPlugin.isInHistory(this.val$roomId, this.val$callback);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.isInHistory(str, liveStatusDataCallback);
            }
        }
    }

    public void onDiskClearCacheChange(long j, int i2, int i3, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), iLiveDiskClearCacheCallback}) == null) {
            Log.d(TAG, "start DiskClearCacheChange t=" + System.currentTimeMillis());
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, NEW_ON_DISK_CLEAR_CACHE_CHANGE, new PluginLoadCallback(this, j, i2, i3, iLiveDiskClearCacheCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.36
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ ILiveDiskClearCacheCallback val$callback;
                    public final /* synthetic */ int val$newState;
                    public final /* synthetic */ int val$oldState;
                    public final /* synthetic */ long val$quota;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), iLiveDiskClearCacheCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$quota = j;
                        this.val$oldState = i2;
                        this.val$newState = i3;
                        this.val$callback = iLiveDiskClearCacheCallback;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i4, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i4), str, obj, str2}) == null) {
                            Log.d(LiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i4 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    this.this$0.mLiveNPSPlugin.onDiskClearCacheChange(this.val$quota, this.val$oldState, this.val$newState, this.val$callback);
                                    return;
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                        }
                    }
                });
                return;
            }
            try {
                iLiveNPSPlugin.onDiskClearCacheChange(j, i2, i3, iLiveDiskClearCacheCallback);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setLoadingCallback(LiveNpsLoadingCallback liveNpsLoadingCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, liveNpsLoadingCallback) == null) {
            this.loadingCallback = liveNpsLoadingCallback;
        }
    }

    public void startAdminListActivity(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, LIVE_SHOW_ADMIN_LIST, new PluginLoadCallback(this, context) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
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
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, obj, str2}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry().openAdminListPage(this.val$context);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowMasterEntry().openAdminListPage(context);
            }
        }
    }

    public void startArSdkLoad(@NonNull Context context, @NonNull LiveNpsArLoadCallback liveNpsArLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, context, liveNpsArLoadCallback) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, LIVE_SHOW_LOAD_AR, new PluginLoadCallback(this, liveNpsArLoadCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.21
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ LiveNpsArLoadCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, liveNpsArLoadCallback};
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
                        this.val$callback = liveNpsArLoadCallback;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, obj, str2}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry().loadArSdk(new ILiveShowMasterEntry.ArSdkLoadCallback(this) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.21.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass21 this$1;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
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
                                        }

                                        @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                                        public void onProgress(int i3, int i4) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeII(1048576, this, i3, i4) == null) {
                                                this.this$1.val$callback.onProgress(i3, i4);
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
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowMasterEntry().loadArSdk(new ILiveShowMasterEntry.ArSdkLoadCallback(this, liveNpsArLoadCallback) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.22
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ LiveNpsArLoadCallback val$callback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, liveNpsArLoadCallback};
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
                        this.val$callback = liveNpsArLoadCallback;
                    }

                    @Override // com.baidu.searchbox.live.interfaces.entry.ILiveShowMasterEntry.ArSdkLoadCallback
                    public void onProgress(int i2, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) {
                            this.val$callback.onProgress(i2, i3);
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

    public void startBjhMasterActivity(@NonNull Application application, String str, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, application, str, uri) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, MEDIA_BJH_CREATE_LIVE_ROOM, new PluginLoadCallback(this, application, str, uri) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveBjhEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivity(this.val$packageContext, this.val$params, this.val$uri);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveBjhEntry() != null) {
                this.mLiveNPSPlugin.getLiveBjhEntry().startLiveMasterActivity(application, str, uri);
            }
        }
    }

    public void startFansListActivity(@NonNull Context context, @NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048592, this, context, str, i2) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, LIVE_SHOW_FANS_LIST, new PluginLoadCallback(this, context, str, i2) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ int val$sex;
                    public final /* synthetic */ String val$uid;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, Integer.valueOf(i2)};
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
                        this.val$context = context;
                        this.val$uid = str;
                        this.val$sex = i2;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i3, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), str2, obj, str3}) == null) {
                            if (i3 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().openFansListPage(this.val$context, this.val$uid, this.val$sex);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i3);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().openFansListPage(context, str, i2);
            }
        }
    }

    public void startForbiddenListActivity(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, LIVE_SHOW_FORBIDDEN_LIST, new PluginLoadCallback(this, context) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
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
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, obj, str2}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry().openForbiddenListPage(this.val$context);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowMasterEntry().openForbiddenListPage(context);
            }
        }
    }

    public void startGuardianListActivity(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, context, str, str2) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, LIVE_SHOW_GUARD_LIST, new PluginLoadCallback(this, context, str, str2) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
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
                        this.val$charmValue = str;
                        this.val$uid = str2;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str3, Object obj, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str3, obj, str4}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().openGuardianListPage(this.val$context, this.val$charmValue, this.val$uid);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().openGuardianListPage(context, str, str2);
            }
        }
    }

    public void startLiveExpActivity(@NonNull Context context, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{context, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, LIVE_SHOW_LIVE_EXP, new PluginLoadCallback(this, context, j, i2) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ long val$currentExp;
                    public final /* synthetic */ int val$currentLevel;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, Long.valueOf(j), Integer.valueOf(i2)};
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
                        this.val$context = context;
                        this.val$currentExp = j;
                        this.val$currentLevel = i2;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i3, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), str, obj, str2}) == null) {
                            if (i3 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().openLiveExpPage(this.val$context, this.val$currentExp, this.val$currentLevel);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i3);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().openLiveExpPage(context, j, i2);
            }
        }
    }

    public void startLiveMediaActivity(Context context, String str, String str2, String str3, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048596, this, context, str, str2, str3, uri) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, MEDIA_ENTER_LIVE_ROOM, new PluginLoadCallback(this, context, str, str2, str3, uri) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str4, Object obj, String str5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str4, obj, str5}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveMediaEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveMediaEntry().enterLiveRoom(this.val$packageContext, this.val$roomId, this.val$source, this.val$params, this.val$uri);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveMediaEntry() != null) {
                this.mLiveNPSPlugin.getLiveMediaEntry().enterLiveRoom(context, str, str2, str3, uri);
            }
        }
    }

    public void startLiveShowActivity(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, str) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, LIVE_SHOW_ENTER_LIVE_ROOM, new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$params;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
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
                        this.val$params = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().enterLiveShowRoom(this.val$context, this.val$params);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().enterLiveShowRoom(context, str);
            }
        }
    }

    public void startMasterActivity(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, context, str, str2) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, NEW_CREATE_LIVE_ROOM, new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$param;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
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
                        this.val$param = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str3, Object obj, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str3, obj, str4}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    this.this$0.mLiveNPSPlugin.startMasterActivity(this.val$context, this.val$param);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
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
        if (interceptable == null || interceptable.invokeLLL(1048599, this, context, str, str2) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, NEW_CREATE_LIVE_ROOM, new PluginLoadCallback(this, context, str, str2) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
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
                        this.val$param = str;
                        this.val$appVersion = str2;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str3, Object obj, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str3, obj, str4}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    this.this$0.mLiveNPSPlugin.startMasterActivity(this.val$context, this.val$param, this.val$appVersion);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else {
                iLiveNPSPlugin.startMasterActivity(context, str, str2);
            }
        }
    }

    public void startPatronageActivity(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, context) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, LIVE_SHOW_START_PATRONAGE, new PluginLoadCallback(this, context) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
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
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, obj, str2}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().enterPatronagePage(this.val$context);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().enterPatronagePage(context);
            }
        }
    }

    public void startPatronsActivity(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, context, str) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, LIVE_SHOW_START_PATRONS, new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$uid;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
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
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().enterPatrons(this.val$context, this.val$uid);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
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
        if (interceptable == null || interceptable.invokeLL(1048602, this, context, str) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, LIVE_SHOW_START_PAY, new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$params;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
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
                        this.val$params = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveShowEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveShowEntry().enterPayPage(this.val$context, this.val$params);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowEntry().enterPayPage(context, str);
            }
        }
    }

    public void startRealAuthActivity(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, context, str, str2) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, LIVE_SHOW_REAL_AUTH, new PluginLoadCallback(this, context, str, str2) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
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
                        this.val$certifyStatus = str2;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str3, Object obj, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str3, obj, str4}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry().openRealAuthPage(this.val$context, this.val$uid, this.val$certifyStatus);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowMasterEntry().openRealAuthPage(context, str, str2);
            }
        }
    }

    public void startShowMasterActivity(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, LIVE_SHOW_CREATE_ROOM, new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$params;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
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
                        this.val$params = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveShowMasterEntry().createLiveRoom(this.val$context, this.val$params);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveShowMasterEntry() != null) {
                this.mLiveNPSPlugin.getLiveShowMasterEntry().createLiveRoom(context, str);
            }
        }
    }

    public void startYYActivity(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, context) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, YY_TEST_ENTER_LIVE_ROOM, new PluginLoadCallback(this, context) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.23
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context};
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
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, obj, str2}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getYYLiveEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getYYLiveEntry().startYYActivity(this.val$context);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getYYLiveEntry() != null) {
                this.mLiveNPSPlugin.getYYLiveEntry().startYYActivity(context);
            }
        }
    }

    public void startYYCustomerServiceActivity(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) {
            Log.d(TAG, "startYYCustomerServiceActivity t=" + System.currentTimeMillis());
            checkHandler();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, YY_CUSTOMER_SERVICE, new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.26
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$url;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
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
                        this.val$url = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, i2, obj) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.26.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass26 this$1;
                                public final /* synthetic */ int val$retCode;
                                public final /* synthetic */ Object val$retObject;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i2), obj};
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
                                    this.val$retCode = i2;
                                    this.val$retObject = obj;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        Log.d(LiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                                        if (this.val$retCode != 14) {
                                            this.this$1.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                                            return;
                                        }
                                        try {
                                            this.this$1.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                            this.this$1.this$0.mLiveNPSPlugin.getYYLiveEntry().startYYCustomerServiceActivity(this.this$1.val$context, this.this$1.val$url);
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
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
        if (interceptable == null || interceptable.invokeLL(1048607, this, context, str) == null) {
            Log.d(TAG, "startYYFeedbackActivity t=" + System.currentTimeMillis());
            checkHandler();
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, YY_FEED_BACK, new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.25
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$url;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
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
                        this.val$url = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, i2, obj) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.25.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass25 this$1;
                                public final /* synthetic */ int val$retCode;
                                public final /* synthetic */ Object val$retObject;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i2), obj};
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
                                    this.val$retCode = i2;
                                    this.val$retObject = obj;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        Log.d(LiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                                        if (this.val$retCode != 14) {
                                            this.this$1.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                                            return;
                                        }
                                        try {
                                            this.this$1.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                            this.this$1.this$0.mLiveNPSPlugin.getYYLiveEntry().startYYFeedbackActivity(this.this$1.val$context, this.this$1.val$url);
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
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

    public void startYYLiveActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, context, str) == null) {
            Log.d(TAG, "startYYLiveActivity t=" + System.currentTimeMillis());
            UBCManager uBCManager = this.ubcManager;
            if (uBCManager != null) {
                this.pageFlow = uBCManager.beginFlow("3121");
            }
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, YY_ENTER_LIVE_ROOM, new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.24
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$url;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
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
                        this.val$url = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            Log.d(LiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getYYLiveEntry() == null) {
                                        return;
                                    }
                                    if (this.this$0.pageFlow != null) {
                                        YYStatInfo yYStatInfo = new YYStatInfo();
                                        yYStatInfo.flowObj = this.this$0.pageFlow;
                                        yYStatInfo.isColdLaunch = true;
                                        yYStatInfo.loadType = str3;
                                        this.this$0.mLiveNPSPlugin.getYYLiveEntry().updateStatInfo(yYStatInfo);
                                        this.this$0.pageFlow = null;
                                    }
                                    this.this$0.mLiveNPSPlugin.getYYLiveEntry().startYYLiveActivity(this.val$context, this.val$url);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getYYLiveEntry() != null) {
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
                this.mLiveNPSPlugin.getYYLiveEntry().startYYLiveActivity(context, str);
            }
        }
    }

    public void startYuYinActivity(@NonNull Context context, @NonNull String str, @NonNull String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048609, this, context, str, str2, map) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, YU_YIN_ENTER_LIVE_ROOM, new PluginLoadCallback(this, context, str, str2, map) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
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
                        this.val$scheme = str;
                        this.val$otherParams = str2;
                        this.val$params = map;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str3, Object obj, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str3, obj, str4}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveYuYinEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinLiveActivity(this.val$context, this.val$scheme, this.val$otherParams, this.val$params);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveYuYinEntry() != null) {
                this.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinLiveActivity(context, str, str2, map);
            }
        }
    }

    public void startYuYinCreateLiveRoomActivity(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, context, str) == null) {
            ILiveNPSPlugin iLiveNPSPlugin = this.mLiveNPSPlugin;
            if (iLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, YU_YIN_CREATE_LIVE_ROOM, new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$jsonParams;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str};
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
                        this.val$jsonParams = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.LiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i2, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str2, obj, str3}) == null) {
                            if (i2 == 14) {
                                try {
                                    this.this$0.mLiveNPSPlugin = (ILiveNPSPlugin) ((Class) obj).newInstance();
                                    if (this.this$0.isLoadingCanceled || this.this$0.mLiveNPSPlugin.getLiveYuYinEntry() == null) {
                                        return;
                                    }
                                    this.this$0.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinCreateLiveRoomActivity(this.val$context, this.val$jsonParams);
                                    return;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            if (!this.this$0.isLoadingCanceled) {
                                this.this$0.showNormalToast(d.a.w.c.a.liveshow_plugin_impl_load_fail, 0);
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(LiveNPSPluginManager.TAG, "load live nps plugin error=" + i2);
                            }
                        }
                    }
                });
            } else if (iLiveNPSPlugin.getLiveYuYinEntry() != null) {
                this.mLiveNPSPlugin.getLiveYuYinEntry().startYuYinCreateLiveRoomActivity(context, str);
            }
        }
    }

    public LiveNPSPluginManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
