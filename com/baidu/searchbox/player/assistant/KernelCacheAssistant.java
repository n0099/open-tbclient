package com.baidu.searchbox.player.assistant;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class KernelCacheAssistant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_REUSE_KERNEL_ID = "videoPlayerReuseID";
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, BaseKernelLayer> mKernelCache;

    /* renamed from: com.baidu.searchbox.player.assistant.KernelCacheAssistant$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static final class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final KernelCacheAssistant mInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1223402825, "Lcom/baidu/searchbox/player/assistant/KernelCacheAssistant$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1223402825, "Lcom/baidu/searchbox/player/assistant/KernelCacheAssistant$Holder;");
                    return;
                }
            }
            mInstance = new KernelCacheAssistant(null);
        }

        public Holder() {
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

    public /* synthetic */ KernelCacheAssistant(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static KernelCacheAssistant get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Holder.mInstance : (KernelCacheAssistant) invokeV.objValue;
    }

    @Nullable
    public BaseKernelLayer getCache(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.mKernelCache.get(str) : (BaseKernelLayer) invokeL.objValue;
    }

    public boolean isInCache(@Nullable BaseKernelLayer baseKernelLayer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseKernelLayer)) == null) ? this.mKernelCache.containsValue(baseKernelLayer) : invokeL.booleanValue;
    }

    public void putCache(@Nullable String str, @Nullable BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, baseKernelLayer) == null) || baseKernelLayer == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mKernelCache.put(str, baseKernelLayer);
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (BaseKernelLayer baseKernelLayer : this.mKernelCache.values()) {
                if (baseKernelLayer != null) {
                    baseKernelLayer.release();
                }
            }
            this.mKernelCache.clear();
        }
    }

    @Nullable
    public BaseKernelLayer removeCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.mKernelCache.remove(str) : (BaseKernelLayer) invokeL.objValue;
    }

    public KernelCacheAssistant() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mKernelCache = new HashMap<>(2);
    }
}
