package com.baidu.searchbox.player.pool;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class VideoKernelPool {
    public static /* synthetic */ Interceptable $ic;
    public static final FIFOPool<AbsVideoKernel> sPool;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.player.pool.VideoKernelPool$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class InstanceHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final VideoKernelPool INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1699454699, "Lcom/baidu/searchbox/player/pool/VideoKernelPool$InstanceHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1699454699, "Lcom/baidu/searchbox/player/pool/VideoKernelPool$InstanceHolder;");
                    return;
                }
            }
            INSTANCE = new VideoKernelPool(null);
        }

        public InstanceHolder() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(698469094, "Lcom/baidu/searchbox/player/pool/VideoKernelPool;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(698469094, "Lcom/baidu/searchbox/player/pool/VideoKernelPool;");
                return;
            }
        }
        sPool = new FIFOPool<>(5);
    }

    public VideoKernelPool() {
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

    public static VideoKernelPool getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return InstanceHolder.INSTANCE;
        }
        return (VideoKernelPool) invokeV.objValue;
    }

    public /* synthetic */ VideoKernelPool(AnonymousClass1 anonymousClass1) {
        this();
    }

    public synchronized void recycle(AbsVideoKernel absVideoKernel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, absVideoKernel) == null) {
            synchronized (this) {
                sPool.release((FIFOPool<AbsVideoKernel>) absVideoKernel);
            }
        }
    }

    @NonNull
    public synchronized AbsVideoKernel obtain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                AbsVideoKernel acquire = sPool.acquire(AbsVideoKernel.NORMAL_PLAYER);
                if (acquire != null) {
                    return acquire;
                }
                sPool.add(BDPlayerConfig.getKernelFactory().create(AbsVideoKernel.NORMAL_PLAYER));
                return sPool.acquire();
            }
        }
        return (AbsVideoKernel) invokeV.objValue;
    }

    @NonNull
    public synchronized AbsVideoKernel obtain(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                AbsVideoKernel acquire = sPool.acquire(str);
                if (acquire != null) {
                    return acquire;
                }
                sPool.add(BDPlayerConfig.getKernelFactory().create(str));
                return sPool.acquire();
            }
        }
        return (AbsVideoKernel) invokeL.objValue;
    }
}
