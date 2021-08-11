package com.baidu.searchbox.floating.utils;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", AdvanceSetting.NETWORK_TYPE, "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
public final class FloatingViewClickUtilKt$click$1 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ Function1 $block;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ long $time;
    public final /* synthetic */ View receiver$0;

    public FloatingViewClickUtilKt$click$1(View view, long j2, Function1 function1) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Long.valueOf(j2), function1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.receiver$0 = view;
        this.$time = j2;
        this.$block = function1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - FloatingViewClickUtilKt.getLastClickTime(this.receiver$0) > this.$time) {
                FloatingViewClickUtilKt.setLastClickTime(this.receiver$0, currentTimeMillis);
                this.$block.invoke(this.receiver$0);
            }
        }
    }
}
