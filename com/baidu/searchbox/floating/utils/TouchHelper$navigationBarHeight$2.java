package com.baidu.searchbox.floating.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public final class TouchHelper$navigationBarHeight$2 extends Lambda implements Function0<Integer> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ TouchHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchHelper$navigationBarHeight$2(TouchHelper touchHelper) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {touchHelper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = touchHelper;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Integer invoke2() {
        return Integer.valueOf(invoke());
    }

    /* JADX DEBUG: Return type fixed from 'int' to match base method */
    /* JADX WARN: Type inference failed for: r0v4, types: [int, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int, java.lang.Integer] */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? UtilsKt.getNavBarHeight(this.this$0.getContext()) : invokeV.intValue;
    }
}
