package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.nadcore.utils.ExtensionsKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup$MarginLayoutParams;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadVideoRewardCountDownView$attachToViewGroup$1 extends Lambda implements Function0<ViewGroup.MarginLayoutParams> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ NadVideoRewardCountDownView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadVideoRewardCountDownView$attachToViewGroup$1(NadVideoRewardCountDownView nadVideoRewardCountDownView) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nadVideoRewardCountDownView};
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
        this.this$0 = nadVideoRewardCountDownView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewGroup.MarginLayoutParams invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            Context context = this.this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            marginLayoutParams.leftMargin = ExtensionsKt.d(14, context);
            Context context2 = this.this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            marginLayoutParams.topMargin = ExtensionsKt.d(6, context2);
            return marginLayoutParams;
        }
        return (ViewGroup.MarginLayoutParams) invokeV.objValue;
    }
}
