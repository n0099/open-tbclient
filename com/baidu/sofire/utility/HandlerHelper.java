package com.baidu.sofire.utility;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class HandlerHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final HandlerHelper INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler mHandler;
    public HandlerThread mHandlerThread;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(61873813, "Lcom/baidu/sofire/utility/HandlerHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(61873813, "Lcom/baidu/sofire/utility/HandlerHelper;");
                return;
            }
        }
        INSTANCE = new HandlerHelper();
    }

    public HandlerHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("rp_th", 10);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    public static Looper getLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? INSTANCE.mHandler.getLooper() : (Looper) invokeV.objValue;
    }

    public static synchronized boolean post(Runnable runnable) {
        InterceptResult invokeL;
        boolean post;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, runnable)) == null) {
            synchronized (HandlerHelper.class) {
                post = INSTANCE.mHandler.post(runnable);
            }
            return post;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean postDelayed(Runnable runnable, long j) {
        InterceptResult invokeLJ;
        boolean postDelayed;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable, j)) == null) {
            synchronized (HandlerHelper.class) {
                postDelayed = INSTANCE.mHandler.postDelayed(runnable, j);
            }
            return postDelayed;
        }
        return invokeLJ.booleanValue;
    }

    public static synchronized void quit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (HandlerHelper.class) {
                INSTANCE.mHandler.getLooper().quit();
            }
        }
    }
}
