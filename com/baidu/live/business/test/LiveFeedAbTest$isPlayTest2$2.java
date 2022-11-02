package com.baidu.live.business.test;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AbConfigService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveFeedAbTest$isPlayTest2$2 extends Lambda implements Function0<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public static final LiveFeedAbTest$isPlayTest2$2 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1789358769, "Lcom/baidu/live/business/test/LiveFeedAbTest$isPlayTest2$2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1789358769, "Lcom/baidu/live/business/test/LiveFeedAbTest$isPlayTest2$2;");
                return;
            }
        }
        INSTANCE = new LiveFeedAbTest$isPlayTest2$2();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFeedAbTest$isPlayTest2$2() {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX DEBUG: Return type fixed from 'boolean' to match base method */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, boolean] */
    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                AbConfigService abConfigService = (AbConfigService) ServiceManager.getService(AbConfigService.Companion.getSERVICE_REFERENCE());
                if (abConfigService == null) {
                    return null;
                }
                if (((Number) abConfigService.getSwitch("android_live_feed_page_autoplay_type_ab")).intValue() != 2) {
                    return null;
                }
                return 1;
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeV.booleanValue;
    }
}
