package com.baidu.live.business.test;

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
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R#\u0010\u0007\u001a\u00020\u00048F@\u0007X\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR#\u0010\f\u001a\u00020\u00048F@\u0007X\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u0012\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR#\u0010\u000f\u001a\u00020\u00048F@\u0007X\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/baidu/live/business/test/LiveFeedAbTest;", "", "KEY_PLAY_TEST", "Ljava/lang/String;", "", "isPlayTest0$delegate", "Lkotlin/Lazy;", "isPlayTest0", "()Z", "isPlayTest0$annotations", "()V", "isPlayTest1$delegate", "isPlayTest1", "isPlayTest1$annotations", "isPlayTest2$delegate", "isPlayTest2", "isPlayTest2$annotations", "<init>", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveFeedAbTest {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ KProperty[] a;
    public static final Lazy b;
    public static final Lazy c;
    public static final LiveFeedAbTest d;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Lazy lazy = b;
            KProperty kProperty = a[1];
            return ((Boolean) lazy.getValue()).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Lazy lazy = c;
            KProperty kProperty = a[2];
            return ((Boolean) lazy.getValue()).booleanValue();
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-310215877, "Lcom/baidu/live/business/test/LiveFeedAbTest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-310215877, "Lcom/baidu/live/business/test/LiveFeedAbTest;");
                return;
            }
        }
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveFeedAbTest.class), "isPlayTest0", "isPlayTest0()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveFeedAbTest.class), "isPlayTest1", "isPlayTest1()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveFeedAbTest.class), "isPlayTest2", "isPlayTest2()Z"))};
        d = new LiveFeedAbTest();
        LazyKt__LazyJVMKt.lazy(LiveFeedAbTest$isPlayTest0$2.INSTANCE);
        b = LazyKt__LazyJVMKt.lazy(LiveFeedAbTest$isPlayTest1$2.INSTANCE);
        c = LazyKt__LazyJVMKt.lazy(LiveFeedAbTest$isPlayTest2$2.INSTANCE);
    }

    public LiveFeedAbTest() {
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
