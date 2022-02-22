package com.baidu.nadcore.video.videoplayer.ui;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import c.a.d0.l0.j;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/LinearGradient;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class BdVideoGradientMask$linearGradient$2 extends Lambda implements Function0<LinearGradient> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ BdVideoGradientMask this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdVideoGradientMask$linearGradient$2(BdVideoGradientMask bdVideoGradientMask) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdVideoGradientMask};
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
        this.this$0 = bdVideoGradientMask;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LinearGradient invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new LinearGradient(0.0f, 0.0f, this.this$0.getMeasuredWidth(), 0.0f, new int[]{this.this$0.getResources().getColor(j.nad_bd_full_more_left_mask_start_color), this.this$0.getResources().getColor(j.nad_bd_full_more_left_mask_50percent_color), this.this$0.getResources().getColor(j.nad_bd_full_more_left_mask_75percent_color), this.this$0.getResources().getColor(j.nad_bd_full_more_left_mask_95percent_color)}, new float[]{0.0f, 0.5f, 0.75f, 1.0f}, Shader.TileMode.CLAMP) : (LinearGradient) invokeV.objValue;
    }
}
