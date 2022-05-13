package com.baidu.bdtask.component.buoy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class BuoyComponent$attachToWindow$1 extends Lambda implements Function0<Unit> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ViewGroup.LayoutParams $layoutParams;
    public final /* synthetic */ ViewGroup $viewGroup;
    public final /* synthetic */ BuoyComponent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuoyComponent$attachToWindow$1(BuoyComponent buoyComponent, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buoyComponent, viewGroup, layoutParams};
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
        this.this$0 = buoyComponent;
        this.$viewGroup = viewGroup;
        this.$layoutParams = layoutParams;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        rt rtVar;
        rt rtVar2;
        rt rtVar3;
        rt rtVar4;
        rt rtVar5;
        rt rtVar6;
        rt rtVar7;
        rt rtVar8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            rtVar = this.this$0.f;
            View contentView = rtVar.getContentView();
            if ((contentView != null ? contentView.getParent() : null) != null) {
                rtVar6 = this.this$0.f;
                View contentView2 = rtVar6.getContentView();
                ViewParent parent = contentView2 != null ? contentView2.getParent() : null;
                if (!(parent instanceof ViewGroup)) {
                    parent = null;
                }
                if (((ViewGroup) parent) != null) {
                    rtVar7 = this.this$0.f;
                    View contentView3 = rtVar7.getContentView();
                    ViewParent parent2 = contentView3 != null ? contentView3.getParent() : null;
                    if (parent2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                    rtVar8 = this.this$0.f;
                    ((ViewGroup) parent2).removeView(rtVar8.getContentView());
                }
            }
            ViewGroup viewGroup = this.$viewGroup;
            rtVar2 = this.this$0.f;
            if (viewGroup.indexOfChild(rtVar2.getContentView()) != -1) {
                ViewGroup viewGroup2 = this.$viewGroup;
                viewGroup2.removeView(viewGroup2);
            }
            View findViewWithTag = this.$viewGroup.findViewWithTag("TaskSDKBuoyViewTag");
            if (findViewWithTag != null) {
                this.$viewGroup.removeView(findViewWithTag);
            }
            rtVar3 = this.this$0.f;
            View contentView4 = rtVar3.getContentView();
            if (contentView4 != null) {
                contentView4.setTag("TaskSDKBuoyViewTag");
            }
            if (this.$layoutParams == null) {
                ViewGroup viewGroup3 = this.$viewGroup;
                rtVar5 = this.this$0.f;
                viewGroup3.addView(rtVar5.getContentView());
                return;
            }
            ViewGroup viewGroup4 = this.$viewGroup;
            rtVar4 = this.this$0.f;
            viewGroup4.addView(rtVar4.getContentView(), this.$layoutParams);
        }
    }
}
