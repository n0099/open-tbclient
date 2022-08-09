package com.baidu.searchbox.live.pluginmanager;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b'\u0010(J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0016\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001a\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0016\u0010\u001b\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0010R!\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R!\u0010#\u001a\n \u001d*\u0004\u0018\u00010\"0\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/live/pluginmanager/MiniPluginManager;", "", "isMediaPluginAvailable", "()Z", "isYYPluginAvailable", "Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;", "loadCallback", "", "loadMediaPlugin", "(Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;)V", "needYYLoading", "showYYPage", LiveYYPluginManager.USE_FROM_LOAD_YY_PLUGIN, "(Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;ZZ)V", "", "LIVE_DELAY_LOAD_MEDIA_SWITCH", "Ljava/lang/String;", "LIVE_MEDIA_KERNAL_REUSE_SWITCH", "LIVE_NPS", "", "LIVE_PLUGIN_SUPPORT_KERNAL_REUSE_MIM_VERSION", "I", "LIVE_PRE_REQUEST_ENTER_SWITCH", "MEDIA_BUSINESS_NPS", "PLAY_AB_SWITCH", "PROHIBIT_PRE_LOAD_MEDIA_SWITCH", "YY_AB_TEST_VIDEO_REUSE_SWITCH", "YY_LIVE_NPS", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "kotlin.jvm.PlatformType", "pluginMgrService", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "getPluginMgrService", "()Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "Lcom/baidu/searchbox/live/interfaces/service/ToastService;", "toastService", "Lcom/baidu/searchbox/live/interfaces/service/ToastService;", "getToastService", "()Lcom/baidu/searchbox/live/interfaces/service/ToastService;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MiniPluginManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final MiniPluginManager INSTANCE;
    public static final String LIVE_DELAY_LOAD_MEDIA_SWITCH = "live_delay_load_media_switch";
    public static final String LIVE_MEDIA_KERNAL_REUSE_SWITCH = "android_live_media_reuse_kernal_switch";
    public static final String LIVE_NPS = "com.baidu.searchbox.livenps";
    public static final int LIVE_PLUGIN_SUPPORT_KERNAL_REUSE_MIM_VERSION = 601500000;
    public static final String LIVE_PRE_REQUEST_ENTER_SWITCH = "android_live_pre_request_enter_switch";
    public static final String MEDIA_BUSINESS_NPS = "com.baidu.live.media.business";
    public static final String PLAY_AB_SWITCH = "yy_ab_player_reuse_switch";
    public static final String PROHIBIT_PRE_LOAD_MEDIA_SWITCH = "android_live_prohibit_pre_load_media_plugin";
    public static final String YY_AB_TEST_VIDEO_REUSE_SWITCH = "yy_sdk_video_reuse_player_switch";
    public static final String YY_LIVE_NPS = "com.baidu.searchbox.yylive.entrance";
    public static final PluginInvokeService pluginMgrService;
    public static final ToastService toastService;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(367903734, "Lcom/baidu/searchbox/live/pluginmanager/MiniPluginManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(367903734, "Lcom/baidu/searchbox/live/pluginmanager/MiniPluginManager;");
                return;
            }
        }
        INSTANCE = new MiniPluginManager();
        pluginMgrService = (PluginInvokeService) ServiceManager.getService(PluginInvokeService.Companion.getSERVICE_REFERENCE());
        toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
    }

    public MiniPluginManager() {
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

    public final PluginInvokeService getPluginMgrService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? pluginMgrService : (PluginInvokeService) invokeV.objValue;
    }

    public final ToastService getToastService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? toastService : (ToastService) invokeV.objValue;
    }

    public final boolean isMediaPluginAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PluginInvokeService pluginInvokeService = pluginMgrService;
            if (pluginInvokeService != null) {
                return pluginInvokeService.isPluginLoaded("com.baidu.live.media.business");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean isYYPluginAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PluginInvokeService pluginInvokeService = pluginMgrService;
            if (pluginInvokeService != null) {
                return pluginInvokeService.isPluginLoaded("com.baidu.searchbox.yylive.entrance");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void loadMediaPlugin(PluginLoadCallback pluginLoadCallback) {
        PluginInvokeService pluginInvokeService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pluginLoadCallback) == null) || (pluginInvokeService = pluginMgrService) == null) {
            return;
        }
        PluginInvokeService.DefaultImpls.loadPlugin$default(pluginInvokeService, "com.baidu.live.media.business", "", pluginLoadCallback, false, 8, null);
    }

    public final void loadYYPlugin(PluginLoadCallback pluginLoadCallback, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{pluginLoadCallback, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            final WeakReference weakReference = new WeakReference(pluginLoadCallback);
            PluginInvokeService pluginInvokeService = pluginMgrService;
            if (pluginInvokeService != null) {
                pluginInvokeService.loadPlugin(null, "com.baidu.searchbox.yylive.entrance", "", z, z2, new PluginLoadCallback(weakReference) { // from class: com.baidu.searchbox.live.pluginmanager.MiniPluginManager$loadYYPlugin$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WeakReference $weakCallback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {weakReference};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$weakCallback = weakReference;
                    }

                    @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
                    public void onResult(boolean z3, int i, String str) {
                        PluginLoadCallback pluginLoadCallback2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z3), Integer.valueOf(i), str}) == null) || (pluginLoadCallback2 = (PluginLoadCallback) this.$weakCallback.get()) == null) {
                            return;
                        }
                        pluginLoadCallback2.onResult(z3, i, str);
                    }
                });
            }
        }
    }
}
