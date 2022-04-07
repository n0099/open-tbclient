package com.baidu.nadcore.video.videoplayer.ui.full;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/LinearGradient;", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class BdVideoFullGradientMask$linearGradient$2 extends Lambda implements Function0<LinearGradient> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ BdVideoFullGradientMask this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdVideoFullGradientMask$linearGradient$2(BdVideoFullGradientMask bdVideoFullGradientMask) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdVideoFullGradientMask};
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
        this.this$0 = bdVideoFullGradientMask;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LinearGradient invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new LinearGradient(0.0f, 0.0f, this.this$0.getMeasuredWidth(), 0.0f, new int[]{this.this$0.getResources().getColor(R.color.obfuscated_res_0x7f0607ef), this.this$0.getResources().getColor(R.color.obfuscated_res_0x7f0607ea), this.this$0.getResources().getColor(R.color.obfuscated_res_0x7f0607ec), this.this$0.getResources().getColor(R.color.obfuscated_res_0x7f0607ed), this.this$0.getResources().getColor(R.color.obfuscated_res_0x7f0607ee)}, new float[]{0.0f, 0.17f, 0.34f, 0.5f, 1.0f}, Shader.TileMode.CLAMP) : (LinearGradient) invokeV.objValue;
    }
}
