package com.baidu.searchbox.player.helper;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.assistant.KernelCacheAssistant;
import com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public abstract class AbsKernelReuseHelper implements IKernelLayerReuseHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AbsKernelReuseHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper
    public boolean attachCache(@NonNull BDVideoPlayer bDVideoPlayer, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bDVideoPlayer, str)) == null) {
            BaseKernelLayer validCache = getValidCache(bDVideoPlayer, str);
            if (validCache == null) {
                return false;
            }
            BdVideoLog.d("ReuseHelper:  attach,cache is " + validCache + ",cacheKey is " + str);
            validCache.resume();
            bDVideoPlayer.setKLayerCacheKey(str);
            bDVideoPlayer.restoreVideoTask(validCache);
            bDVideoPlayer.attachKernelLayer(validCache);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper
    public boolean detachCache(@NonNull BDVideoPlayer bDVideoPlayer, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bDVideoPlayer, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            BaseKernelLayer detachKernelLayer = bDVideoPlayer.detachKernelLayer();
            BdVideoLog.d("ReuseHelper: detach,cache is " + detachKernelLayer + ",cacheKey is " + str);
            if (detachKernelLayer != null) {
                detachKernelLayer.pause();
                KernelCacheAssistant.get().putCache(str, detachKernelLayer);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper
    @Nullable
    public BaseKernelLayer getValidCache(@NonNull BDVideoPlayer bDVideoPlayer, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bDVideoPlayer, str)) == null) ? KernelCacheAssistant.get().removeCache(str) : (BaseKernelLayer) invokeLL.objValue;
    }

    public abstract boolean performAutoDetachCache(@NonNull BDVideoPlayer bDVideoPlayer, @Nullable String str);
}
