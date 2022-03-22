package com.baidu.searchbox.floating.utils;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", AdvanceSetting.NETWORK_TYPE, "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class FloatingViewClickUtilKt$click$1 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ Function1 $block;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ View $this_click;
    public final /* synthetic */ long $time;

    public FloatingViewClickUtilKt$click$1(View view, long j, Function1 function1) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Long.valueOf(j), function1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$this_click = view;
        this.$time = j;
        this.$block = function1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - FloatingViewClickUtilKt.getLastClickTime(this.$this_click) > this.$time) {
                FloatingViewClickUtilKt.setLastClickTime(this.$this_click, currentTimeMillis);
                this.$block.invoke(this.$this_click);
            }
        }
    }
}
