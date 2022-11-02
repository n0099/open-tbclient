package com.baidu.searchbox.live.nps;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.pm.manager.NPSPackageManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.chainlog.NpsLoadChainLog;
import com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback;
import com.baidu.searchbox.live.interfaces.callback.ILiveFileSizeCallback;
import com.baidu.searchbox.live.interfaces.callback.LiveStatusDataCallback;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.LiveYalogService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.yalog.LiveYalogApi;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.mix.proxy.LiveMixShellManager;
import com.baidu.searchbox.live.nps.util.SchemeParamsParseUtils;
import com.baidu.searchbox.live.ubc.FlowInfoHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveNPSPluginManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MEDIA_BUSINESS_PKG_NAME = "com.baidu.live.media.business";
    public static final String MULTI_PLUGIN_YALOG_SPACE = "multi_plugin";
    public static final String NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.livenps";
    public static final String TAG = "LiveNPSPluginManager";
    public static final String YY_FIRST_NPS_PLUGIN_PKG_NAME = "com.baidu.searchbox.yylive.entrance";
    public transient /* synthetic */ FieldHolder $fh;
    public AppInfoService appService;
    public int pluginArchLaunchType;
    public ToastService toastService;
    public LiveYalogApi yalogApi;
    public LiveYalogService yalogService;

    @Deprecated
    public void checkArSdkLoadStatus(@NonNull Context context, @NonNull LiveNpsArStatusCallback liveNpsArStatusCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, liveNpsArStatusCallback) == null) {
        }
    }

    @Deprecated
    public void clearResourceFile(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
        }
    }

    @Deprecated
    public void startAdminListActivity(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, context) == null) {
        }
    }

    @Deprecated
    public void startArSdkLoad(@NonNull Context context, @NonNull LiveNpsArLoadCallback liveNpsArLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, context, liveNpsArLoadCallback) == null) {
        }
    }

    @Deprecated
    public void startFansListActivity(@NonNull Context context, @NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048606, this, context, str, i) == null) {
        }
    }

    @Deprecated
    public void startForbiddenListActivity(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, context) == null) {
        }
    }

    @Deprecated
    public void startGuardianListActivity(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048608, this, context, str, str2) == null) {
        }
    }

    @Deprecated
    public void startLiveExpActivity(@NonNull Context context, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{context, Long.valueOf(j), Integer.valueOf(i)}) == null) {
        }
    }

    @Deprecated
    public void startLiveShowActivity(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, context, str) == null) {
        }
    }

    @Deprecated
    public void startMasterActivity(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, context, str, str2) == null) {
        }
    }

    @Deprecated
    public void startMasterActivityV2(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048613, this, context, str, str2) == null) {
        }
    }

    @Deprecated
    public void startPatronageActivity(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, context) == null) {
        }
    }

    @Deprecated
    public void startPatronsActivity(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, context, str) == null) {
        }
    }

    @Deprecated
    public void startPayActivity(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, context, str) == null) {
        }
    }

    @Deprecated
    public void startRealAuthActivity(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048617, this, context, str, str2) == null) {
        }
    }

    @Deprecated
    public void startShowMasterActivity(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, context, str) == null) {
        }
    }

    @Deprecated
    public void startYuYinActivity(@NonNull Context context, @NonNull String str, @NonNull String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048623, this, context, str, str2, map) == null) {
        }
    }

    @Deprecated
    public void startYuYinCreateLiveRoomActivity(@NonNull Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, context, str) == null) {
        }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public LiveNPSPluginManager() {
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
        this.yalogService = (LiveYalogService) ServiceManager.getService(LiveYalogService.Companion.getSERVICE_REFERENCE());
        this.yalogApi = null;
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.toastService = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        LiveYalogService liveYalogService = this.yalogService;
        if (liveYalogService != null) {
            this.yalogApi = liveYalogService.buildYalogApi("multi_plugin");
        }
    }

    private void dLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            NpsLoadChainLog.getInstance().dLog(str);
        }
    }

    private boolean isYYFirstPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            return "com.baidu.searchbox.yylive.entrance".equals(str);
        }
        return invokeL.booleanValue;
    }

    public void log(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            LiveYalogApi liveYalogApi = this.yalogApi;
            if (liveYalogApi != null) {
                liveYalogApi.d("", "", str);
            }
            NpsLoadChainLog.getInstance().dLog(str);
        }
    }

    public void setLoadingCallback(LiveNpsLoadingCallback liveNpsLoadingCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, liveNpsLoadingCallback) == null) {
            LiveMediaPluginManager.getInstance().setLoadingCallback(liveNpsLoadingCallback);
            LiveYYPluginManager.getInstance().setLoadingCallback(liveNpsLoadingCallback);
            LiveNPSPluginManagerOld.getInstance().setLoadingCallback(liveNpsLoadingCallback);
        }
    }

    public void startYYActivity(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, context) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveYYPluginManager.getInstance().startYYActivity(context);
            } else {
                LiveNPSPluginManagerOld.getInstance().startYYActivity(context);
            }
        }
    }

    public void updateStatInfo(YYStatInfo yYStatInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, yYStatInfo) == null) && isSupportMixInHostPlugin()) {
            LiveMediaPluginManager.getInstance().updateStatInfo(yYStatInfo);
        }
    }

    public static LiveNPSPluginManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return SingletonHolder.instance;
        }
        return (LiveNPSPluginManager) invokeV.objValue;
    }

    public void cancelLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveYYPluginManager.getInstance().cancelLoading();
                LiveMediaPluginManager.getInstance().cancelLoading();
                return;
            }
            LiveNPSPluginManagerOld.getInstance().cancelLoading();
        }
    }

    public void cancelStartYYLiveActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveYYPluginManager.getInstance().cancelStartYYLiveActivity();
            } else {
                LiveNPSPluginManagerOld.getInstance().cancelStartYYLiveActivity();
            }
        }
    }

    public IMixActivityInterface getMixActivityImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return LiveMediaPluginManager.getInstance().getMixActivityImpl();
        }
        return (IMixActivityInterface) invokeV.objValue;
    }

    public boolean isSupportMixInHostPlugin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return isSupportMixInHostPlugin(false);
        }
        return invokeV.booleanValue;
    }

    private void startLiveMediaActivity(Context context, String str, String str2, String str3, Uri uri, boolean z) {
        String uri2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{context, str, str2, str3, uri, Boolean.valueOf(z)}) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("LiveNPSPluginManager startLiveMediaActivity roomId: ");
            sb.append(str);
            sb.append(" source: ");
            sb.append(str2);
            sb.append(" params: ");
            sb.append(str3);
            sb.append(" uri: ");
            if (uri == null) {
                uri2 = " ";
            } else {
                uri2 = uri.toString();
            }
            sb.append(uri2);
            log(sb.toString());
            String str4 = null;
            try {
                str4 = new JSONObject(str3).optString("playUrl");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            HashMap<String, Object> startNewFlow = FlowInfoHelper.startNewFlow(str, true);
            FlowInfoHelper.startSigleLineSlot(startNewFlow, "uscheme_patc", false);
            FlowInfoHelper.put(startNewFlow, "contains_url", Integer.valueOf(!TextUtils.isEmpty(str4) ? 1 : 0));
            FlowInfoHelper.put(startNewFlow, "scheme_url", str4);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("clickTime", String.valueOf(System.currentTimeMillis())));
            arrayList.add(new Pair("clickFrom", "uscheme_patc"));
            Uri uriParam = SchemeParamsParseUtils.setUriParam(uri, arrayList, true);
            if (isSupportMixInHostPlugin(!NPSPackageManager.getInstance().isBundleRunning("com.baidu.searchbox.yylive.entrance"))) {
                LiveMixShellManager.INSTANCE.enterLiveRoom(context, str, str2, str3, uriParam);
            } else {
                LiveNPSPluginManagerOld.getInstance().startLiveMediaActivity(context, str, str2, str3, uriParam);
            }
        }
    }

    public void dispatchHostEvent(@NonNull Context context, @NonNull String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, str, map) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveMediaPluginManager.getInstance().dispatchHostEvent(context, str, map);
                LiveYYPluginManager.getInstance().dispatchHostEvent(context, str, map);
                return;
            }
            LiveNPSPluginManagerOld.getInstance().dispatchHostEvent(context, str, map);
        }
    }

    public void dispatchLiveMasterRouter(@NonNull Application application, String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, application, str, map) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveMediaPluginManager.getInstance().dispatchLiveMasterRouter(application, str, map);
            } else {
                LiveNPSPluginManagerOld.getInstance().dispatchLiveMasterRouter(application, str, map);
            }
        }
    }

    public void startBjhMasterActivity(@NonNull Application application, String str, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, application, str, uri) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveMediaPluginManager.getInstance().startBjhMasterActivity(application, str, uri);
            } else {
                LiveNPSPluginManagerOld.getInstance().startBjhMasterActivity(application, str, uri);
            }
        }
    }

    public void startBjhMasterActivityNew(@NonNull Context context, String str, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, context, str, uri) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveMediaPluginManager.getInstance().startBjhMasterActivityNew(context, str, uri);
            } else {
                LiveNPSPluginManagerOld.getInstance().startBjhMasterActivityNew(context, str, uri);
            }
        }
    }

    public void dispatchYYLiveRouter(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveYYPluginManager.getInstance().dispatchYYLiveRouter(context, str);
            } else {
                LiveNPSPluginManagerOld.getInstance().dispatchYYLiveRouter(context, str);
            }
        }
    }

    @Deprecated
    public void getLiveResourceFileSize(@NonNull Context context, @NonNull ILiveFileSizeCallback iLiveFileSizeCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, context, iLiveFileSizeCallback) == null) && iLiveFileSizeCallback != null) {
            iLiveFileSizeCallback.getFileSize(0L);
        }
    }

    public void getLiveRoomStatus(@NonNull String str, @NonNull LiveStatusDataCallback<String> liveStatusDataCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, liveStatusDataCallback) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveMediaPluginManager.getInstance().getLiveRoomStatus(str, liveStatusDataCallback);
            } else {
                LiveNPSPluginManagerOld.getInstance().getLiveRoomStatus(str, liveStatusDataCallback);
            }
        }
    }

    @Deprecated
    public void getLiveSdkFileSize(@NonNull Context context, @NonNull ILiveFileSizeCallback iLiveFileSizeCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, context, iLiveFileSizeCallback) == null) && iLiveFileSizeCallback != null) {
            iLiveFileSizeCallback.getFileSize(0L);
        }
    }

    @Nullable
    public Map<String, Object> getMediaLivePlayConfig(@Nullable String str, @Nullable Map<String, Object> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, map)) == null) {
            return LiveMediaPluginManager.getInstance().getMediaLivePlayConfig(str, map);
        }
        return (Map) invokeLL.objValue;
    }

    public void isInHistory(@NonNull String str, @NonNull LiveStatusDataCallback<Boolean> liveStatusDataCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, liveStatusDataCallback) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveMediaPluginManager.getInstance().isInHistory(str, liveStatusDataCallback);
            } else {
                LiveNPSPluginManagerOld.getInstance().isInHistory(str, liveStatusDataCallback);
            }
        }
    }

    public void realStartYYLiveActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, context, str) == null) {
            log("LiveNPSPluginManager realStartYYLiveActivity " + str);
            LiveYYPluginManager.getInstance().startYYLiveActivity(context, str);
        }
    }

    public void startAudioMasterActivity(@NonNull Application application, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, application, str) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveMediaPluginManager.getInstance().startAudioMasterActivity(application, str);
            } else {
                LiveNPSPluginManagerOld.getInstance().startAudioMasterActivity(application, str);
            }
        }
    }

    public void startYYCustomerServiceActivity(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, context, str) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveYYPluginManager.getInstance().startYYCustomerServiceActivity(context, str);
            } else {
                LiveNPSPluginManagerOld.getInstance().startYYCustomerServiceActivity(context, str);
            }
        }
    }

    public void startYYFeedbackActivity(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, context, str) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveYYPluginManager.getInstance().startYYFeedbackActivity(context, str);
            } else {
                LiveNPSPluginManagerOld.getInstance().startYYFeedbackActivity(context, str);
            }
        }
    }

    public void startYYLiveActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, context, str) == null) {
            if (isSupportMixInHostPlugin()) {
                LiveMixShellManager.INSTANCE.startYYLiveActivity(context, str);
            } else {
                LiveNPSPluginManagerOld.getInstance().startYYLiveActivity(context, str);
            }
        }
    }

    public AssetManager getPluginAssets(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            AppInfoService appInfoService = this.appService;
            if (appInfoService != null && appInfoService.getApplication() != null && this.appService.getApplication().getResources() != null && NPSManager.getInstance().getBundle(str) != null && NPSManager.getInstance().getBundle(str).getResources(this.appService.getApplication().getResources()) != null) {
                return NPSManager.getInstance().getBundle(str).getResources(this.appService.getApplication().getResources()).getAssets();
            }
            return null;
        }
        return (AssetManager) invokeL.objValue;
    }

    public boolean isLoaded(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            log("LiveNPSPluginManager isLoaded " + str);
            if (!"com.baidu.searchbox.livenps".equals(str) && !"com.baidu.live.media.business".equals(str)) {
                if (isYYFirstPlugin(str)) {
                    log("LiveNPSPluginManager isLoaded " + LiveYYPluginManager.getInstance().isLoaded());
                    return LiveYYPluginManager.getInstance().isLoaded();
                }
                return false;
            }
            log("LiveNPSPluginManager isLoaded " + LiveMediaPluginManager.getInstance().isLoaded(str));
            return LiveMediaPluginManager.getInstance().isLoaded(str);
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public ClassLoader getPluginClassLoader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (NPSManager.getInstance().getBundle(str) != null) {
                return NPSManager.getInstance().getBundle(str).getClassloader();
            }
            NpsLoadChainLog.getInstance().dLog("LiveNPSPluginManager getPluginClassLoader null");
            return null;
        }
        return (ClassLoader) invokeL.objValue;
    }

    public int getPluginInstallVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            BundleInfo bundleInfo = NPSPackageManager.getInstance().getBundleInfo(str);
            if (bundleInfo == null) {
                log("LiveNPSPluginManager getPluginInstallVersion 0");
                return 0;
            }
            log("LiveNPSPluginManager getPluginInstallVersion " + bundleInfo.getVersionCode());
            return bundleInfo.getVersionCode();
        }
        return invokeL.intValue;
    }

    @Nullable
    public Resources getPluginResource(String str) {
        InterceptResult invokeL;
        AppInfoService appInfoService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (NPSManager.getInstance().getBundle(str) != null && (appInfoService = this.appService) != null && appInfoService.getApplication() != null) {
                return NPSManager.getInstance().getBundle(str).getResources(this.appService.getApplication().getResources());
            }
            NpsLoadChainLog.getInstance().dLog("LiveNPSPluginManager getPluginResource null");
            return null;
        }
        return (Resources) invokeL.objValue;
    }

    public boolean isSupportMixInHostPlugin(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            log("LiveNPSPluginManager isSupportMixInHostPlugin pluginArchLaunchType " + this.pluginArchLaunchType);
            boolean z2 = true;
            if (this.pluginArchLaunchType == 0) {
                int pluginArchLaunchType = MultiPluginHelper.getPluginArchLaunchType(z);
                this.pluginArchLaunchType = pluginArchLaunchType;
                if (pluginArchLaunchType != 3) {
                    z2 = false;
                }
                log("LiveNPSPluginManager isSupportMixInHostPlugin " + z2);
                return z2;
            } else if (!NPSPackageManager.getInstance().isBundleRunning("com.baidu.searchbox.livenps") && !NPSPackageManager.getInstance().isBundleRunning("com.baidu.searchbox.yylive.entrance")) {
                int pluginArchLaunchType2 = MultiPluginHelper.getPluginArchLaunchType(z);
                this.pluginArchLaunchType = pluginArchLaunchType2;
                if (pluginArchLaunchType2 != 3) {
                    z2 = false;
                }
                log("LiveNPSPluginManager isSupportMixInHostPlugin " + z2);
                return z2;
            } else {
                log("LiveNPSPluginManager isSupportMixInHostPlugin " + NPSPackageManager.getInstance().isBundleRunning("com.baidu.searchbox.livenps") + "   " + NPSPackageManager.getInstance().isBundleRunning("com.baidu.searchbox.yylive.entrance"));
                if (this.pluginArchLaunchType == 3) {
                    return true;
                }
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public void loadPlugin(Context context, String str, String str2, boolean z, Map<String, String> map, PluginLoadCallback pluginLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{context, str, str2, Boolean.valueOf(z), map, pluginLoadCallback}) == null) {
            log("LiveNPSPluginManager loadPlugin " + str + GlideException.IndentedAppendable.INDENT + str2);
            if (!"com.baidu.searchbox.livenps".equals(str) && !"com.baidu.live.media.business".equals(str)) {
                if (isYYFirstPlugin(str)) {
                    LiveYYPluginManager.getInstance().loadPlugin(context, str, str2, z, pluginLoadCallback, null);
                    return;
                }
                return;
            }
            LiveMediaPluginManager.getInstance().loadPlugin(context, str, str2, pluginLoadCallback);
        }
    }

    public void onDiskClearCacheChange(long j, int i, int i2, ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), iLiveDiskClearCacheCallback}) == null) {
            iLiveDiskClearCacheCallback.notifyCompletion(0L);
            ILiveDiskClearCacheCallback iLiveDiskClearCacheCallback2 = new ILiveDiskClearCacheCallback(this) { // from class: com.baidu.searchbox.live.nps.LiveNPSPluginManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveNPSPluginManager this$0;

                @Override // com.baidu.searchbox.live.interfaces.callback.ILiveDiskClearCacheCallback
                public void notifyCompletion(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j2) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }
            };
            if (isSupportMixInHostPlugin()) {
                LiveMediaPluginManager.getInstance().onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback2);
                LiveYYPluginManager.getInstance().onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback2);
                return;
            }
            LiveNPSPluginManagerOld.getInstance().onDiskClearCacheChange(j, i, i2, iLiveDiskClearCacheCallback2);
        }
    }

    public void startLiveMediaActivity(Context context, String str, String str2, String str3, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048610, this, context, str, str2, str3, uri) == null) {
            startLiveMediaActivity(context, str, str2, str3, uri, false);
        }
    }
}
