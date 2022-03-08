package com.baidu.adp.lib.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class AsyncService {
    public static final /* synthetic */ AsyncService[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AsyncService INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public Looper mLooper;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1723278734, "Lcom/baidu/adp/lib/service/AsyncService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1723278734, "Lcom/baidu/adp/lib/service/AsyncService;");
                return;
            }
        }
        AsyncService asyncService = new AsyncService("INSTANCE", 0);
        INSTANCE = asyncService;
        $VALUES = new AsyncService[]{asyncService};
    }

    public AsyncService(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("BdAsyncService");
        handlerThread.start();
        this.mLooper = handlerThread.getLooper();
        this.mHandler = new Handler(this.mLooper);
    }

    public static AsyncService valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AsyncService) Enum.valueOf(AsyncService.class, str) : (AsyncService) invokeL.objValue;
    }

    public static AsyncService[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AsyncService[]) $VALUES.clone() : (AsyncService[]) invokeV.objValue;
    }

    public void release() {
        Looper looper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (looper = this.mLooper) == null) {
            return;
        }
        looper.quit();
    }

    public void removeRunnable(Runnable runnable) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) || (handler = this.mHandler) == null || runnable == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public void sendRunnable(Runnable runnable) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) || (handler = this.mHandler) == null || runnable == null) {
            return;
        }
        handler.post(runnable);
    }
}
