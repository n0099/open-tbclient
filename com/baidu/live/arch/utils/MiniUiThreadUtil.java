package com.baidu.live.arch.utils;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/baidu/live/arch/utils/MiniUiThreadUtil;", "Ljava/lang/Runnable;", "runnable", "", "runOnUiThread", "(Ljava/lang/Runnable;)V", "", "postImmediate", "(Ljava/lang/Runnable;Z)V", "Landroid/os/Handler;", "sMainHandler$delegate", "Lkotlin/Lazy;", "getSMainHandler", "()Landroid/os/Handler;", "sMainHandler", "<init>", "()V", "lib-live-mini-arch_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MiniUiThreadUtil {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static /* synthetic */ Interceptable $ic;
    public static final MiniUiThreadUtil INSTANCE;
    public static final Lazy sMainHandler$delegate;
    public transient /* synthetic */ FieldHolder $fh;

    private final Handler getSMainHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Lazy lazy = sMainHandler$delegate;
            KProperty kProperty = $$delegatedProperties[0];
            return (Handler) lazy.getValue();
        }
        return (Handler) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1969664642, "Lcom/baidu/live/arch/utils/MiniUiThreadUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1969664642, "Lcom/baidu/live/arch/utils/MiniUiThreadUtil;");
                return;
            }
        }
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MiniUiThreadUtil.class), "sMainHandler", "getSMainHandler()Landroid/os/Handler;"))};
        INSTANCE = new MiniUiThreadUtil();
        sMainHandler$delegate = LazyKt__LazyJVMKt.lazy(MiniUiThreadUtil$sMainHandler$2.INSTANCE);
    }

    public MiniUiThreadUtil() {
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

    public static /* synthetic */ void runOnUiThread$default(MiniUiThreadUtil miniUiThreadUtil, Runnable runnable, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        miniUiThreadUtil.runOnUiThread(runnable, z);
    }

    public final void runOnUiThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            runOnUiThread(runnable, false);
        }
    }

    public final void runOnUiThread(Runnable runnable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, z) == null) {
            Thread currentThread = Thread.currentThread();
            Looper mainLooper = Looper.getMainLooper();
            Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
            if (currentThread != mainLooper.getThread()) {
                if (z) {
                    getSMainHandler().postAtFrontOfQueue(runnable);
                    return;
                } else {
                    getSMainHandler().post(runnable);
                    return;
                }
            }
            runnable.run();
        }
    }
}
