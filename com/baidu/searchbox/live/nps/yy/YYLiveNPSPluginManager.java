package com.baidu.searchbox.live.nps.yy;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.install.IInstallCallback;
import com.baidu.nps.main.invoke.IInvokeCallback;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.BundleInfoGroup;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pass.biometrics.face.liveness.b.a;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.yy.IYYLiveNPSPlugin;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes2.dex */
public class YYLiveNPSPluginManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOAD_FROM_NPS_DOWNLOAD = "nps_download";
    public static final String LOAD_FROM_NPS_INSTALL = "nps_install";
    public static final String LOAD_FROM_NPS_LOAD = "nps_load";
    public static final String NPS_PLUGIN_IMPL_CLASS_NAME = "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl";
    public static final String NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.yylive.entrance";
    public static final String NPS_PLUGIN_PKG_NAME2_1 = "com.baidu.searchbox.yylive.liveroom";
    public static final String NPS_PLUGIN_PKG_NAME2_2 = "com.baidu.searchbox.yylive.interaction";
    public static final String PAGE_SLOT_PAGE_PLUGIN_INSTALL = "plugin_install";
    public static final String PAGE_SLOT_PAGE_PLUGIN_LOAD = "plugin_load";
    public static final String TAG = "YY_PLUGIN";
    public static final String UBC_ID_PLUGIN_PAGE_FLOW = "3121";
    public transient /* synthetic */ FieldHolder $fh;
    public AppInfoService appService;
    public boolean fromDownLoad;
    public Handler handler;
    public IYYLiveNPSPlugin impl;
    public boolean isLoadingCanceled;
    public LiveYYNpsLoadingCallback loadingCallback;
    public PluginLoadCallback mCurrentCallback;
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
        public static YYLiveNPSPluginManager instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1041107147, "Lcom/baidu/searchbox/live/nps/yy/YYLiveNPSPluginManager$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1041107147, "Lcom/baidu/searchbox/live/nps/yy/YYLiveNPSPluginManager$SingletonHolder;");
                    return;
                }
            }
            instance = new YYLiveNPSPluginManager();
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

    public YYLiveNPSPluginManager() {
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
        this.impl = null;
        this.handler = new Handler(Looper.getMainLooper());
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.isLoadingCanceled = false;
        this.ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.fromDownLoad = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLoading(int i) {
        LiveYYNpsLoadingCallback liveYYNpsLoadingCallback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65573, this, i) == null) && (liveYYNpsLoadingCallback = this.loadingCallback) != null) {
            liveYYNpsLoadingCallback.onLoadingEnd(i);
        }
    }

    public void clearLiveResourceSize(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            checkHandler();
            IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
            if (iYYLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, "_clearRes", new PluginLoadCallback(this, context) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ YYLiveNPSPluginManager this$0;
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

                    @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, i, obj) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.10.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass10 this$1;
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
                                        if (this.val$retCode == 14) {
                                            try {
                                                this.this$1.this$0.impl = (IYYLiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                                this.this$1.this$0.impl.clearLiveResourceSize(this.this$1.val$packageContext);
                                                return;
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.this$1.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f0ab4, 0);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            try {
                iYYLiveNPSPlugin.clearLiveResourceSize(context);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setLoadingCallback(LiveYYNpsLoadingCallback liveYYNpsLoadingCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, liveYYNpsLoadingCallback) == null) {
            this.loadingCallback = liveYYNpsLoadingCallback;
        }
    }

    public void startYYActivity(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            checkHandler();
            IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
            if (iYYLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "_yyTest", new PluginLoadCallback(this, context) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ YYLiveNPSPluginManager this$0;
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

                    @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, i, obj) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;
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
                                        if (this.val$retCode == 14) {
                                            try {
                                                this.this$1.this$0.impl = (IYYLiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                                this.this$1.this$0.impl.startYYActivity(this.this$1.val$context);
                                                return;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.this$1.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f0ab4, 0);
                                    }
                                }
                            });
                        }
                    }
                });
            } else {
                iYYLiveNPSPlugin.startYYActivity(context);
            }
        }
    }

    private int compareVersion(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65561, this, i, i2)) == null) {
            return (i / 10000000) - (i2 / 10000000);
        }
        return invokeII.intValue;
    }

    public void dispatchYYLiveRouter(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            checkHandler();
            IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
            if (iYYLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, DI.ROUTER_NAME, new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ YYLiveNPSPluginManager this$0;
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

                    @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, i, obj) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.12.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass12 this$1;
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
                                        if (this.val$retCode == 14) {
                                            try {
                                                this.this$1.this$0.impl = (IYYLiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                                this.this$1.this$0.impl.dispatchYYLiveRouter(this.this$1.val$context, this.this$1.val$url);
                                                return;
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.this$1.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f0ab4, 0);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            try {
                iYYLiveNPSPlugin.dispatchYYLiveRouter(context, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void dispatchYYRawLiveRouter(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) {
            checkHandler();
            IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
            if (iYYLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, DI.ROUTER_NAME, new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ YYLiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$scheme;

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
                        this.val$scheme = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, i, obj) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.13.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass13 this$1;
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
                                        if (this.val$retCode == 14) {
                                            try {
                                                this.this$1.this$0.impl = (IYYLiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                                this.this$1.this$0.impl.dispatchYYRawLiveRouter(this.this$1.val$context, this.this$1.val$scheme);
                                                return;
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.this$1.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f0ab4, 0);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            try {
                iYYLiveNPSPlugin.dispatchYYRawLiveRouter(context, str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void getLiveResourceSize(@NonNull Context context, ILiveFileSizeCallback iLiveFileSizeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, iLiveFileSizeCallback) == null) {
            checkHandler();
            IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
            if (iYYLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, "_getSize", new PluginLoadCallback(this, context, iLiveFileSizeCallback) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ YYLiveNPSPluginManager this$0;
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

                    @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, obj, str2}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, i, obj) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.11.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass11 this$1;
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
                                        if (this.val$retCode == 14) {
                                            try {
                                                this.this$1.this$0.impl = (IYYLiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                                this.this$1.this$0.impl.getLiveResourceSize(this.this$1.val$packageContext, this.this$1.val$callback);
                                                return;
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.this$1.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f0ab4, 0);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            try {
                iYYLiveNPSPlugin.getLiveResourceSize(context, iLiveFileSizeCallback);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void dispatchHostEvent(@NonNull Context context, @NonNull String str, @NonNull Map<String, Object> map) {
        IYYLiveNPSPlugin iYYLiveNPSPlugin;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, map) == null) && (iYYLiveNPSPlugin = this.impl) != null) {
            try {
                iYYLiveNPSPlugin.dispatchHostEvent(context, str, map);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void checkHandler() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65560, this) == null) && this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
    }

    public static YYLiveNPSPluginManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return SingletonHolder.instance;
        }
        return (YYLiveNPSPluginManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPluginDownloadVersion() {
        InterceptResult invokeV;
        BundleInfo bundleByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
            if (bundleGroup == null || (bundleByType = bundleGroup.getBundleByType(2)) == null) {
                return 0;
            }
            return bundleByType.getVersionCode();
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPluginInstallVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo("com.baidu.searchbox.yylive.entrance");
            if (bundleInfo == null) {
                return 0;
            }
            return bundleInfo.getVersionCode();
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPluginUpdateVersion() {
        InterceptResult invokeV;
        BundleInfo bundleByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) {
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
            if (bundleGroup == null || (bundleByType = bundleGroup.getBundleByType(1)) == null) {
                return 0;
            }
            return bundleByType.getVersionCode();
        }
        return invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
            AppInfoService appInfoService = this.appService;
            if (appInfoService != null) {
                return appInfoService.isDebug();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void showLoading() {
        LiveYYNpsLoadingCallback liveYYNpsLoadingCallback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65571, this) == null) && (liveYYNpsLoadingCallback = this.loadingCallback) != null) {
            liveYYNpsLoadingCallback.onLoadingStart();
        }
    }

    public void cancelLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.isLoadingCanceled = true;
        }
    }

    private String getEntry(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, str)) == null) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("params");
            if (TextUtils.isEmpty(queryParameter)) {
                String queryParameter2 = parse.getQueryParameter("source");
                String queryParameter3 = parse.getQueryParameter("tab");
                String queryParameter4 = parse.getQueryParameter("tag");
                if (!TextUtils.isEmpty(queryParameter3) || !TextUtils.isEmpty(queryParameter4)) {
                    return queryParameter3 + "-" + queryParameter4 + "-" + queryParameter2;
                }
                return queryParameter2;
            }
            try {
                return new JSONObject(queryParameter).optString("source");
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    private void loadNPSPluginImpl(boolean z, String str, PluginLoadCallback pluginLoadCallback) {
        Flow flow;
        Flow flow2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65568, this, new Object[]{Boolean.valueOf(z), str, pluginLoadCallback}) == null) {
            this.mCurrentCallback = pluginLoadCallback;
            IInvokeCallback iInvokeCallback = new IInvokeCallback(this, str, pluginLoadCallback) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ YYLiveNPSPluginManager this$0;
                public final /* synthetic */ PluginLoadCallback val$callback;
                public final /* synthetic */ String val$entry;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, pluginLoadCallback};
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
                    this.val$entry = str;
                    this.val$callback = pluginLoadCallback;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str2, Object obj) {
                    boolean z2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, obj) == null) {
                        if (this.this$0.ubcManager != null && this.this$0.pageFlow != null) {
                            this.this$0.ubcManager.flowEndSlot(this.this$0.pageFlow, "plugin_load");
                        }
                        YYLiveNPSPluginManager yYLiveNPSPluginManager = this.this$0;
                        int pluginInstallVersion = yYLiveNPSPluginManager.getPluginInstallVersion();
                        if (i == 14) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        yYLiveNPSPluginManager.logPluginEnd("com.baidu.searchbox.yylive.entrance", pluginInstallVersion, z2, "load code" + i, "nps_load", this.val$entry);
                        if (this.val$callback != null) {
                            if (Looper.myLooper() != Looper.getMainLooper()) {
                                this.this$0.handler.post(new Runnable(this, i, str2, obj) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.5.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass5 this$1;
                                    public final /* synthetic */ int val$i;
                                    public final /* synthetic */ Object val$o;
                                    public final /* synthetic */ String val$s;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Integer.valueOf(i), str2, obj};
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
                                this.this$0.mCurrentCallback.onResult(i, str2, obj, "load");
                                this.this$0.mCurrentCallback = null;
                            }
                        }
                    }
                }
            };
            IInvokeCallback iInvokeCallback2 = new IInvokeCallback(this, str, pluginLoadCallback) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ YYLiveNPSPluginManager this$0;
                public final /* synthetic */ PluginLoadCallback val$callback;
                public final /* synthetic */ String val$entry;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, pluginLoadCallback};
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
                    this.val$entry = str;
                    this.val$callback = pluginLoadCallback;
                }

                @Override // com.baidu.nps.main.invoke.IInvokeCallback
                public void onResult(int i, String str2, Object obj) {
                    String str3;
                    boolean z2;
                    String str4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str2, obj) == null) {
                        if (this.this$0.ubcManager != null && this.this$0.pageFlow != null) {
                            this.this$0.ubcManager.flowEndSlot(this.this$0.pageFlow, "plugin_load");
                        }
                        if (this.this$0.fromDownLoad) {
                            str3 = "download";
                        } else {
                            str3 = "install";
                        }
                        String str5 = str3;
                        YYLiveNPSPluginManager yYLiveNPSPluginManager = this.this$0;
                        int pluginInstallVersion = yYLiveNPSPluginManager.getPluginInstallVersion();
                        if (i == 14) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        String str6 = "load code" + i;
                        if (this.this$0.fromDownLoad) {
                            str4 = "nps_download";
                        } else {
                            str4 = "nps_install";
                        }
                        yYLiveNPSPluginManager.logPluginEnd("com.baidu.searchbox.yylive.entrance", pluginInstallVersion, z2, str6, str4, this.val$entry);
                        if (this.val$callback != null) {
                            if (Looper.myLooper() != Looper.getMainLooper()) {
                                this.this$0.handler.post(new Runnable(this, i, str2, obj, str5) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.6.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass6 this$1;
                                    public final /* synthetic */ int val$i;
                                    public final /* synthetic */ String val$loadType;
                                    public final /* synthetic */ Object val$o;
                                    public final /* synthetic */ String val$s;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Integer.valueOf(i), str2, obj, str5};
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
                                        this.val$s = str2;
                                        this.val$o = obj;
                                        this.val$loadType = str5;
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
                                this.this$0.mCurrentCallback.onResult(i, str2, obj, str5);
                                this.this$0.mCurrentCallback = null;
                            }
                        }
                    }
                }
            };
            logPluginLoad("com.baidu.searchbox.yylive.entrance", str);
            if (isAvailable()) {
                this.fromDownLoad = false;
                UBCManager uBCManager = this.ubcManager;
                if (uBCManager != null && (flow2 = this.pageFlow) != null) {
                    uBCManager.flowStartSlot(flow2, "plugin_load", null);
                }
                NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, iInvokeCallback);
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
            Log.d(TAG, "start install bundle t=" + System.currentTimeMillis());
            this.fromDownLoad = false;
            NPSPackageManager.getInstance().installBundle("com.baidu.searchbox.yylive.entrance", new IInstallCallback(this, iInvokeCallback2, z, str) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ YYLiveNPSPluginManager this$0;
                public final /* synthetic */ String val$entry;
                public final /* synthetic */ IInvokeCallback val$installProxyCallback;
                public final /* synthetic */ boolean val$showLoading;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iInvokeCallback2, Boolean.valueOf(z), str};
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
                    this.val$installProxyCallback = iInvokeCallback2;
                    this.val$showLoading = z;
                    this.val$entry = str;
                }

                @Override // com.baidu.nps.main.install.IInstallCallback
                public void onProgress(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) != null) {
                        return;
                    }
                    this.this$0.fromDownLoad = true;
                    if (this.this$0.loadingCallback != null && !this.this$0.isLoadingCanceled) {
                        this.this$0.loadingCallback.onLoadingProgress(j, j2);
                    }
                }

                @Override // com.baidu.nps.main.install.IInstallCallback
                public void onResult(int i, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2) == null) {
                        if (!this.this$0.isLoadingCanceled && i != 34) {
                            this.this$0.stopLoading(i);
                        }
                        if (i == 13) {
                            if (this.this$0.ubcManager != null && this.this$0.pageFlow != null) {
                                this.this$0.ubcManager.flowEndSlot(this.this$0.pageFlow, "plugin_install");
                                this.this$0.ubcManager.flowStartSlot(this.this$0.pageFlow, "plugin_load", null);
                            }
                            NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, this.val$installProxyCallback);
                        } else if (i == 3 && NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.yylive.entrance") == 43) {
                            if (this.this$0.ubcManager != null && this.this$0.pageFlow != null) {
                                this.this$0.ubcManager.flowEndSlot(this.this$0.pageFlow, "plugin_install");
                                this.this$0.ubcManager.flowStartSlot(this.this$0.pageFlow, "plugin_load", null);
                            }
                            NPSManager.getInstance().loadClazz("com.baidu.searchbox.yylive.entrance", "com.baidu.searchbox.live.yy.impl.YYLiveNPSPluginImpl", IYYLiveNPSPlugin.class, this.val$installProxyCallback);
                        } else {
                            if (this.val$showLoading) {
                                if (i == 34) {
                                    if (this.this$0.loadingCallback == null) {
                                        this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f0ab5, 0);
                                    }
                                } else {
                                    this.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f0ab4, 0);
                                }
                            }
                            if (this.this$0.isDebug()) {
                                Log.w(YYLiveNPSPluginManager.TAG, "install live nps plugin error=" + i);
                            }
                            int pluginUpdateVersion = this.this$0.getPluginUpdateVersion();
                            if (pluginUpdateVersion == 0) {
                                pluginUpdateVersion = this.this$0.getPluginDownloadVersion();
                            }
                            int i2 = pluginUpdateVersion;
                            if (this.this$0.ubcManager != null && this.this$0.pageFlow != null) {
                                this.this$0.ubcManager.flowEnd(this.this$0.pageFlow);
                                this.this$0.pageFlow = null;
                            }
                            YYLiveNPSPluginManager yYLiveNPSPluginManager = this.this$0;
                            yYLiveNPSPluginManager.logPluginEnd("com.baidu.searchbox.yylive.entrance", i2, false, "install code" + i, "nps_install", this.val$entry);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logPluginEnd(String str, int i, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65569, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), str2, str3, str4}) == null) && this.ubcManager != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "yy_live");
                jSONObject.put("type", "end_load");
                if (z) {
                    jSONObject.put("value", "suc");
                } else {
                    jSONObject.put("value", a.g0);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkg", str);
                jSONObject2.put("ver", i);
                jSONObject2.put("load_from", str3);
                jSONObject2.put("entry", str4);
                jSONObject2.put("reason", str2);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.ubcManager.onEvent("3036", jSONObject);
        }
    }

    private void logPluginLoad(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65570, this, str, str2) == null) && this.ubcManager != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "yy_live");
                jSONObject.put("type", "start_load");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkg", str);
                jSONObject2.put("entry", str2);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.ubcManager.onEvent("3037", jSONObject);
        }
    }

    public void startYYLiveActivity(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, str) == null) {
            UBCManager uBCManager = this.ubcManager;
            if (uBCManager != null) {
                this.pageFlow = uBCManager.beginFlow("3121");
            }
            String entry = getEntry(str);
            checkHandler();
            if (this.impl == null) {
                loadNPSPluginImpl(true, entry, new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ YYLiveNPSPluginManager this$0;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ String val$scheme;

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
                        this.val$scheme = str;
                    }

                    @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, i, obj, str3) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;
                                public final /* synthetic */ String val$loadType;
                                public final /* synthetic */ int val$retCode;
                                public final /* synthetic */ Object val$retObject;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i), obj, str3};
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
                                    this.val$loadType = str3;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        Log.d(YYLiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                                        if (this.val$retCode == 14) {
                                            try {
                                                this.this$1.this$0.impl = (IYYLiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                                if (this.this$1.this$0.pageFlow != null) {
                                                    YYStatInfo yYStatInfo = new YYStatInfo();
                                                    yYStatInfo.flowObj = this.this$1.this$0.pageFlow;
                                                    yYStatInfo.isColdLaunch = true;
                                                    yYStatInfo.loadType = this.val$loadType;
                                                    this.this$1.this$0.impl.updateStatInfo(yYStatInfo);
                                                    this.this$1.this$0.pageFlow = null;
                                                }
                                                this.this$1.this$0.impl.startYYLiveActivity(this.this$1.val$context, this.this$1.val$scheme);
                                                return;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                return;
                                            }
                                        }
                                        if (this.this$1.this$0.ubcManager != null && this.this$1.this$0.pageFlow != null) {
                                            this.this$1.this$0.ubcManager.flowEnd(this.this$1.this$0.pageFlow);
                                            this.this$1.this$0.pageFlow = null;
                                        }
                                        this.this$1.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f0ab4, 0);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            if (this.pageFlow != null) {
                YYStatInfo yYStatInfo = new YYStatInfo();
                yYStatInfo.flowObj = this.pageFlow;
                yYStatInfo.isColdLaunch = false;
                yYStatInfo.loadType = "launch";
                try {
                    this.impl.updateStatInfo(yYStatInfo);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.pageFlow = null;
            }
            this.impl.startYYLiveActivity(context, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalToast(int i, int i2) {
        ToastService toastService;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65572, this, i, i2) == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.handler.post(new Runnable(this, i, i2) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ YYLiveNPSPluginManager this$0;
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

    public void startYYCustomerServiceActivity(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
            Log.d(TAG, "startYYFeedbackActivity t=" + System.currentTimeMillis());
            checkHandler();
            IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
            if (iYYLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "_customerService", new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ YYLiveNPSPluginManager this$0;
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

                    @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, i, obj) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass4 this$1;
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
                                        Log.d(YYLiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                                        if (this.val$retCode == 14) {
                                            try {
                                                this.this$1.this$0.impl = (IYYLiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                                this.this$1.this$0.impl.startYYCustomerServiceActivity(this.this$1.val$context, this.this$1.val$url);
                                                return;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.this$1.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f0ab4, 0);
                                    }
                                }
                            });
                        }
                    }
                });
            } else {
                iYYLiveNPSPlugin.startYYCustomerServiceActivity(context, str);
            }
        }
    }

    public void startYYFeedbackActivity(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
            Log.d(TAG, "startYYFeedbackActivity t=" + System.currentTimeMillis());
            checkHandler();
            IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
            if (iYYLiveNPSPlugin == null) {
                loadNPSPluginImpl(true, "_feedback", new PluginLoadCallback(this, context, str) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ YYLiveNPSPluginManager this$0;
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

                    @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i, String str2, Object obj, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str2, obj, str3}) == null) {
                            this.this$0.mMainHandler.post(new Runnable(this, i, obj) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass3 this$1;
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
                                        Log.d(YYLiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                                        if (this.val$retCode == 14) {
                                            try {
                                                this.this$1.this$0.impl = (IYYLiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                                this.this$1.this$0.impl.startYYFeedbackActivity(this.this$1.val$context, this.this$1.val$url);
                                                return;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.this$1.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f0ab4, 0);
                                    }
                                }
                            });
                        }
                    }
                });
            } else {
                iYYLiveNPSPlugin.startYYFeedbackActivity(context, str);
            }
        }
    }

    public boolean isAvailable() {
        InterceptResult invokeV;
        boolean z;
        BundleInfo bundleByType;
        BundleInfo bundleByType2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int bundleStatus = NPSPackageManager.getInstance().getBundleStatus("com.baidu.searchbox.yylive.entrance");
            if (bundleStatus != 43) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: bundle status=" + bundleStatus);
                }
                return false;
            }
            BundleInfoGroup bundleGroup = NPSPackageManager.getInstance().getBundleGroup("com.baidu.searchbox.yylive.entrance");
            if (bundleGroup == null) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: top plugin is null");
                }
                return false;
            }
            BundleInfo bundleByType3 = bundleGroup.getBundleByType(3);
            if (bundleGroup.getBundleByType(2) == null && bundleGroup.getBundleByType(1) == null) {
                z = false;
            } else {
                z = true;
            }
            BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo(NPS_PLUGIN_PKG_NAME2_1);
            BundleInfo bundleInfo2 = NPSPackageManager.getInstance().getBundleInfo(NPS_PLUGIN_PKG_NAME2_2);
            if (!z) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: top plugin has no update");
                }
                return true;
            } else if (bundleByType3 == null) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: top plugin not install");
                }
                return false;
            } else if (bundleInfo == null && bundleInfo2 == null) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: sec plugin not exist");
                }
                return true;
            } else if (bundleInfo != null && compareVersion(bundleByType3.getVersionCode(), bundleInfo.getVersionCode()) < 0) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: installed sec1 plugin too high");
                }
                return false;
            } else if (bundleInfo2 != null && compareVersion(bundleByType3.getVersionCode(), bundleInfo2.getVersionCode()) < 0) {
                if (isDebug()) {
                    Log.d(TAG, "isAvailable: installed sec2 plugin too high");
                }
                return false;
            } else {
                BundleInfoGroup bundleGroup2 = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_PKG_NAME2_1);
                if (bundleGroup2 != null) {
                    BundleInfo bundleByType4 = bundleGroup2.getBundleByType(1);
                    if (bundleByType4 != null && bundleByType4.needForceUpdate() && compareVersion(bundleByType3.getVersionCode(), bundleByType4.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: sec1 plugin force update1");
                        }
                        return false;
                    } else if (bundleByType4 == null && (bundleByType2 = bundleGroup2.getBundleByType(2)) != null && bundleByType2.needForceUpdate() && compareVersion(bundleByType3.getVersionCode(), bundleByType2.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: sec1 plugin force update2");
                        }
                        return false;
                    }
                }
                BundleInfoGroup bundleGroup3 = NPSPackageManager.getInstance().getBundleGroup(NPS_PLUGIN_PKG_NAME2_2);
                if (bundleGroup3 != null) {
                    BundleInfo bundleByType5 = bundleGroup3.getBundleByType(1);
                    if (bundleByType5 != null && bundleByType5.needForceUpdate() && compareVersion(bundleByType3.getVersionCode(), bundleByType5.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: sec2 plugin force update1");
                        }
                        return false;
                    } else if (bundleByType5 == null && (bundleByType = bundleGroup3.getBundleByType(2)) != null && bundleByType.needForceUpdate() && compareVersion(bundleByType3.getVersionCode(), bundleByType.getVersionCode()) < 0) {
                        if (isDebug()) {
                            Log.d(TAG, "isAvailable: sec2 plugin force update2");
                        }
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), iLiveDiskClearCacheCallback}) == null) {
            Log.d(TAG, "start DiskClearCacheChange t=" + System.currentTimeMillis());
            checkHandler();
            IYYLiveNPSPlugin iYYLiveNPSPlugin = this.impl;
            if (iYYLiveNPSPlugin == null) {
                loadNPSPluginImpl(false, "_diskCleaner", new PluginLoadCallback(this, j, i, i2, iLiveDiskClearCacheCallback) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ YYLiveNPSPluginManager this$0;
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

                    @Override // com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.PluginLoadCallback
                    public void onResult(int i3, String str, Object obj, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), str, obj, str2}) == null) {
                            Log.d(YYLiveNPSPluginManager.TAG, "finish load class t=" + System.currentTimeMillis());
                            this.this$0.mMainHandler.post(new Runnable(this, i3, obj) { // from class: com.baidu.searchbox.live.nps.yy.YYLiveNPSPluginManager.9.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass9 this$1;
                                public final /* synthetic */ int val$retCode;
                                public final /* synthetic */ Object val$retObject;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, Integer.valueOf(i3), obj};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$retCode = i3;
                                    this.val$retObject = obj;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        if (this.val$retCode == 14) {
                                            try {
                                                this.this$1.this$0.impl = (IYYLiveNPSPlugin) ((Class) this.val$retObject).newInstance();
                                                this.this$1.this$0.impl.onDiskClearCacheChange(this.this$1.val$quota, this.this$1.val$oldState, this.this$1.val$newState, this.this$1.val$callback);
                                                return;
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                                return;
                                            }
                                        }
                                        this.this$1.this$0.showNormalToast(R.string.obfuscated_res_0x7f0f0ab4, 0);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            try {
                iYYLiveNPSPlugin.onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
