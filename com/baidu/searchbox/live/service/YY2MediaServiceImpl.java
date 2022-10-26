package com.baidu.searchbox.live.service;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.goback.IYYGobackController;
import com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback;
import com.baidu.searchbox.live.interfaces.multiplugin.MultiPluginLoadCallback;
import com.baidu.searchbox.live.interfaces.service.YY2MediaService;
import com.baidu.searchbox.live.interfaces.smallwindow.IYYSmallWindowController;
import com.baidu.searchbox.live.interfaces.storage.IYYStorageController;
import com.baidu.searchbox.live.nps.LiveMediaPluginManager;
import com.baidu.searchbox.live.recommendmore.ILiveRecMoreController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/live/service/YY2MediaServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/YY2MediaService;", "", "pkgName", "", "getInstallPluginVersion", "(Ljava/lang/String;)I", "Landroid/content/Context;", "context", "Lcom/baidu/searchbox/live/recommendmore/ILiveRecMoreController;", "getRecMoreController", "(Landroid/content/Context;)Lcom/baidu/searchbox/live/recommendmore/ILiveRecMoreController;", "Lcom/baidu/searchbox/live/interfaces/storage/IYYStorageController;", "getStorageOptInfoHelperInterface", "()Lcom/baidu/searchbox/live/interfaces/storage/IYYStorageController;", "Lcom/baidu/searchbox/live/goback/IYYGobackController;", "getYYGobackController", "()Lcom/baidu/searchbox/live/goback/IYYGobackController;", "Lcom/baidu/searchbox/live/interfaces/smallwindow/IYYSmallWindowController;", "getYYSmallWindowController", "()Lcom/baidu/searchbox/live/interfaces/smallwindow/IYYSmallWindowController;", "", "isMediaPluginLoaded", "()Z", "Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginLoadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "", "loadMediaPlugin", "(Landroid/content/Context;Lcom/baidu/searchbox/live/interfaces/multiplugin/MultiPluginLoadCallback;)V", "data", "onYYJoinChannelSuc", "(Ljava/lang/String;)V", "<init>", "()V", "lib-live-nps-ext_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class YY2MediaServiceImpl implements YY2MediaService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public IYYSmallWindowController getYYSmallWindowController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (IYYSmallWindowController) invokeV.objValue;
    }

    public YY2MediaServiceImpl() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public IYYStorageController getStorageOptInfoHelperInterface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveMediaPluginManager, "LiveMediaPluginManager.getInstance()");
            return liveMediaPluginManager.getStorageOptInfoHelperInterface();
        }
        return (IYYStorageController) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public IYYGobackController getYYGobackController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LiveMediaPluginManager liveMediaPluginManager = LiveMediaPluginManager.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(liveMediaPluginManager, "LiveMediaPluginManager.getInstance()");
            return liveMediaPluginManager.getYYGobackController();
        }
        return (IYYGobackController) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public boolean isMediaPluginLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return LiveMediaPluginManager.getInstance().isLoaded("com.baidu.live.media.business");
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public int getInstallPluginVersion(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return LiveMediaPluginManager.getInstance().getInstallPluginVersion(str);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public ILiveRecMoreController getRecMoreController(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return LiveMediaPluginManager.getInstance().getRecMoreController(context);
        }
        return (ILiveRecMoreController) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public void onYYJoinChannelSuc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            LiveMediaPluginManager.getInstance().onYYJoinChannelSuc(str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YY2MediaService
    public void loadMediaPlugin(Context context, final MultiPluginLoadCallback multiPluginLoadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, multiPluginLoadCallback) == null) {
            LiveMediaPluginManager.getInstance().loadPlugin(context, "com.baidu.live.media.business", "", new PluginLoadCallback(multiPluginLoadCallback) { // from class: com.baidu.searchbox.live.service.YY2MediaServiceImpl$loadMediaPlugin$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ MultiPluginLoadCallback $callback;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {multiPluginLoadCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$callback = multiPluginLoadCallback;
                }

                @Override // com.baidu.searchbox.live.interfaces.mix.PluginLoadCallback
                public void onResult(boolean z, int i, String str) {
                    MultiPluginLoadCallback multiPluginLoadCallback2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str}) == null) && (multiPluginLoadCallback2 = this.$callback) != null) {
                        multiPluginLoadCallback2.onResult(z, i, str);
                    }
                }
            });
        }
    }
}
