package com.baidu.searchbox.fluency.utils;

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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\u0003R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/fluency/utils/FpsHandlerThread;", "Landroid/os/Handler;", "getDefaultHandler", "()Landroid/os/Handler;", "Landroid/os/HandlerThread;", "getDefaultHandlerThread", "()Landroid/os/HandlerThread;", "getDefaultMainHandler", "", "FPS_THREAD_NAME", "Ljava/lang/String;", "TAG", "defaultHandler", "Landroid/os/Handler;", "defaultHandlerThread", "Landroid/os/HandlerThread;", "defaultMainHandler", "<init>", "()V", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class FpsHandlerThread {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FPS_THREAD_NAME = "seachbox_fps_thread";
    public static final FpsHandlerThread INSTANCE;
    public static final String TAG = "FpsHandlerThread";
    public static Handler defaultHandler;
    public static HandlerThread defaultHandlerThread;
    public static Handler defaultMainHandler;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-873525609, "Lcom/baidu/searchbox/fluency/utils/FpsHandlerThread;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-873525609, "Lcom/baidu/searchbox/fluency/utils/FpsHandlerThread;");
                return;
            }
        }
        INSTANCE = new FpsHandlerThread();
        defaultMainHandler = new Handler(Looper.getMainLooper());
    }

    public FpsHandlerThread() {
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

    public final Handler getDefaultHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (defaultHandler == null) {
                getDefaultHandlerThread();
            }
            Handler handler = defaultHandler;
            Intrinsics.checkNotNull(handler);
            return handler;
        }
        return (Handler) invokeV.objValue;
    }

    public final HandlerThread getDefaultHandlerThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (defaultHandlerThread == null) {
                HandlerThread handlerThread = new HandlerThread(FPS_THREAD_NAME);
                defaultHandlerThread = handlerThread;
                Intrinsics.checkNotNull(handlerThread);
                handlerThread.start();
                HandlerThread handlerThread2 = defaultHandlerThread;
                Intrinsics.checkNotNull(handlerThread2);
                defaultHandler = new Handler(handlerThread2.getLooper());
            }
            HandlerThread handlerThread3 = defaultHandlerThread;
            Intrinsics.checkNotNull(handlerThread3);
            return handlerThread3;
        }
        return (HandlerThread) invokeV.objValue;
    }

    public final Handler getDefaultMainHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? defaultMainHandler : (Handler) invokeV.objValue;
    }
}
