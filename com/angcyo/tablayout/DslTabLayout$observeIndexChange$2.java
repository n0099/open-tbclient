package com.angcyo.tablayout;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/angcyo/tablayout/DslTabLayoutConfig;", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DslTabLayout$observeIndexChange$2 extends Lambda implements Function1<DslTabLayoutConfig, Unit> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ Function4<Integer, Integer, Boolean, Boolean, Unit> $action;
    public final /* synthetic */ Function1<DslTabLayoutConfig, Unit> $config;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DslTabLayout$observeIndexChange$2(Function1<? super DslTabLayoutConfig, Unit> function1, Function4<? super Integer, ? super Integer, ? super Boolean, ? super Boolean, Unit> function4) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {function1, function4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$config = function1;
        this.$action = function4;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DslTabLayoutConfig dslTabLayoutConfig) {
        invoke2(dslTabLayoutConfig);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DslTabLayoutConfig configTabLayoutConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, configTabLayoutConfig) == null) {
            Intrinsics.checkNotNullParameter(configTabLayoutConfig, "$this$configTabLayoutConfig");
            this.$config.invoke(configTabLayoutConfig);
            configTabLayoutConfig.h(new Function4<Integer, List<? extends Integer>, Boolean, Boolean, Unit>(this.$action) { // from class: com.angcyo.tablayout.DslTabLayout$observeIndexChange$2.1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ Function4<Integer, Integer, Boolean, Boolean, Unit> $action;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$action = r7;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, List<? extends Integer> list, Boolean bool, Boolean bool2) {
                    invoke(num.intValue(), (List<Integer>) list, bool.booleanValue(), bool2.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i, List<Integer> selectIndexList, boolean z, boolean z2) {
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), selectIndexList, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                        Intrinsics.checkNotNullParameter(selectIndexList, "selectIndexList");
                        Function4<Integer, Integer, Boolean, Boolean, Unit> function4 = this.$action;
                        Integer valueOf = Integer.valueOf(i);
                        Integer num = (Integer) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) selectIndexList);
                        if (num != null) {
                            i2 = num.intValue();
                        } else {
                            i2 = -1;
                        }
                        function4.invoke(valueOf, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
                    }
                }
            });
        }
    }
}
