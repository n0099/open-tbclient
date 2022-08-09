package com.baidu.searchbox.live.service;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.entry.ILiveYYMixEntry;
import com.baidu.searchbox.live.interfaces.mix.IMixActivityInterface;
import com.baidu.searchbox.live.interfaces.mix.PluginInvokeService;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import com.baidu.searchbox.live.interfaces.yy.YYStatInfo;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.searchbox.live.nps.LiveNpsLoadHelper;
import com.baidu.searchbox.live.nps.LiveNpsRuntime;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u00109J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJE\u0010\u0010\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0018\u0010\u000f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001f\u0010 J/\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\f2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001f\u0010\"J!\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b&\u0010'J;\u0010,\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\u001eH\u0016¢\u0006\u0004\b,\u0010-JC\u0010,\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b,\u0010/J[\u0010,\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u001e2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b,\u00100J1\u0010,\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\u001eH\u0016¢\u0006\u0004\b,\u00101J\u001f\u00103\u001a\u00020%2\u0006\u0010$\u001a\u00020#2\u0006\u00102\u001a\u00020\fH\u0016¢\u0006\u0004\b3\u0010'J\u0019\u00106\u001a\u00020%2\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/live/service/PluginInvokeServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/mix/PluginInvokeService;", "", "createYYMixLiveImpl", "()Ljava/lang/Object;", "createYYMixLiveSingletonManagerImpl", "Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "genFakeActivityImpl", "()Lcom/baidu/searchbox/live/interfaces/mix/IMixActivityInterface;", "", "getLiveNpsPluginWillLoadVersion", "()I", "", "key", "", "params", "getMediaLivePlayConfig", "(Ljava/lang/String;Ljava/util/Map;)Ljava/util/Map;", "pkgName", "Landroid/content/res/AssetManager;", "getPluginAssets", "(Ljava/lang/String;)Landroid/content/res/AssetManager;", "Ljava/lang/ClassLoader;", "getPluginClassLoader", "(Ljava/lang/String;)Ljava/lang/ClassLoader;", "Landroid/content/res/Resources;", "getPluginResource", "(Ljava/lang/String;)Landroid/content/res/Resources;", "getPluginVersionCode", "(Ljava/lang/String;)I", "", "isPluginLoaded", "(Ljava/lang/String;)Z", "loadParams", "(Ljava/lang/String;Ljava/util/Map;)Z", "Landroid/content/Context;", "context", "", "jumpToOuterWebView", "(Landroid/content/Context;Ljava/lang/String;)V", "source", "Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;", "loadCallback", "needYYLoading", "loadPlugin", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;Z)V", "showYYPage", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZLcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/mix/PluginLoadCallback;Z)V", "url", "realJumpYY", "Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;", "stat", "updateStatInfo", "(Lcom/baidu/searchbox/live/interfaces/yy/YYStatInfo;)V", "<init>", "()V", "lib-live-nps-ext_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PluginInvokeServiceImpl implements PluginInvokeService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PluginInvokeServiceImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public Object createYYMixLiveImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LiveYYPluginManager liveYYPluginManager = LiveYYPluginManager.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveYYPluginManager, "LiveYYPluginManager.getInstance()");
            ILiveYYMixEntry liveYYMixEntry = liveYYPluginManager.getLiveYYMixEntry();
            if (liveYYMixEntry != null) {
                return liveYYMixEntry.createYYMixLiveImpl();
            }
            return null;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public Object createYYMixLiveSingletonManagerImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LiveYYPluginManager liveYYPluginManager = LiveYYPluginManager.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveYYPluginManager, "LiveYYPluginManager.getInstance()");
            ILiveYYMixEntry liveYYMixEntry = liveYYPluginManager.getLiveYYMixEntry();
            if (liveYYMixEntry != null) {
                return liveYYMixEntry.createYYMixLiveSingletonManagerImpl();
            }
            return null;
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public IMixActivityInterface genFakeActivityImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LiveNPSPluginManager liveNPSPluginManager = LiveNPSPluginManager.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveNPSPluginManager, "LiveNPSPluginManager.getInstance()");
            return liveNPSPluginManager.getMixActivityImpl();
        }
        return (IMixActivityInterface) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public int getLiveNpsPluginWillLoadVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? LiveNpsLoadHelper.INSTANCE.getLiveNpsPluginWillLoadVersion() : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public Map<String, Object> getMediaLivePlayConfig(String str, Map<String, ? extends Object> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, map)) == null) ? LiveNPSPluginManager.getInstance().getMediaLivePlayConfig(str, map) : (Map) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public AssetManager getPluginAssets(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? LiveNPSPluginManager.getInstance().getPluginAssets(str) : (AssetManager) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public ClassLoader getPluginClassLoader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? LiveNPSPluginManager.getInstance().getPluginClassLoader(str) : (ClassLoader) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public Resources getPluginResource(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? LiveNPSPluginManager.getInstance().getPluginResource(str) : (Resources) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public int getPluginVersionCode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? LiveNPSPluginManager.getInstance().getPluginInstallVersion(str) : invokeL.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public boolean isPluginLoaded(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? LiveNPSPluginManager.getInstance().isLoaded(str) : invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void jumpToOuterWebView(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
            LiveNPSPluginManager liveNPSPluginManager = LiveNPSPluginManager.getInstance();
            if (str == null) {
                str = "";
            }
            liveNPSPluginManager.dispatchHostEvent(context, "startOuterWebViewActivity", MapsKt__MapsJVMKt.mapOf(new Pair("url", str)));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void loadPlugin(String str, String str2, PluginLoadCallback pluginLoadCallback, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{str, str2, pluginLoadCallback, Boolean.valueOf(z)}) == null) {
            LiveNPSPluginManager.getInstance().loadPlugin(LiveNpsRuntime.getApplication(), str, str2, z, null, pluginLoadCallback);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void realJumpYY(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, context, str) == null) {
            LiveNPSPluginManager.getInstance().realStartYYLiveActivity(context, str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void updateStatInfo(YYStatInfo yYStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, yYStatInfo) == null) {
            LiveNPSPluginManager.getInstance().updateStatInfo(yYStatInfo);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public boolean isPluginLoaded(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, map)) == null) ? LiveNPSPluginManager.getInstance().isLoaded(str) : invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void loadPlugin(Context context, String str, String str2, PluginLoadCallback pluginLoadCallback, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, str, str2, pluginLoadCallback, Boolean.valueOf(z)}) == null) {
            LiveNPSPluginManager.getInstance().loadPlugin(context, str, str2, z, null, pluginLoadCallback);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void loadPlugin(Context context, String str, String str2, boolean z, boolean z2, PluginLoadCallback pluginLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), pluginLoadCallback}) == null) {
            LiveNPSPluginManager.getInstance().loadPlugin(context, str, str2, z, null, pluginLoadCallback);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.mix.PluginInvokeService
    public void loadPlugin(Context context, String str, String str2, boolean z, boolean z2, Map<String, String> map, PluginLoadCallback pluginLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), map, pluginLoadCallback}) == null) {
            LiveNPSPluginManager.getInstance().loadPlugin(null, str, str2, z, map, pluginLoadCallback);
        }
    }
}
