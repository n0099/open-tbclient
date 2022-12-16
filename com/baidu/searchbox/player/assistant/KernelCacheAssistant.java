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
/* loaded from: classes3.dex */
public class KernelCacheAssistant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_REUSE_KERNEL_ID = "videoPlayerReuseID";
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, BaseKernelLayer> mKernelCache;

    /* renamed from: com.baidu.searchbox.player.assistant.KernelCacheAssistant$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public KernelCacheAssistant() {
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
        this.mKernelCache = new HashMap<>(2);
    }

    public static KernelCacheAssistant get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return Holder.mInstance;
        }
        return (KernelCacheAssistant) invokeV.objValue;
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

    public /* synthetic */ KernelCacheAssistant(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Nullable
    public BaseKernelLayer getCache(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return this.mKernelCache.get(str);
        }
        return (BaseKernelLayer) invokeL.objValue;
    }

    public boolean isInCache(@Nullable BaseKernelLayer baseKernelLayer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseKernelLayer)) == null) {
            return this.mKernelCache.containsValue(baseKernelLayer);
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public BaseKernelLayer removeCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.mKernelCache.remove(str);
        }
        return (BaseKernelLayer) invokeL.objValue;
    }

    public void putCache(@Nullable String str, @Nullable BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, baseKernelLayer) == null) && baseKernelLayer != null && !TextUtils.isEmpty(str)) {
            this.mKernelCache.put(str, baseKernelLayer);
        }
    }
}
