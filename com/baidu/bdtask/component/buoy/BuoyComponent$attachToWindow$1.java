package com.baidu.bdtask.component.buoy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ss;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
        ss ssVar;
        ViewParent viewParent;
        ss ssVar2;
        ss ssVar3;
        ss ssVar4;
        ss ssVar5;
        ss ssVar6;
        ViewParent viewParent2;
        ss ssVar7;
        ss ssVar8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ssVar = this.this$0.f;
            View contentView = ssVar.getContentView();
            ViewParent viewParent3 = null;
            if (contentView != null) {
                viewParent = contentView.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent != null) {
                ssVar6 = this.this$0.f;
                View contentView2 = ssVar6.getContentView();
                if (contentView2 != null) {
                    viewParent2 = contentView2.getParent();
                } else {
                    viewParent2 = null;
                }
                if (!(viewParent2 instanceof ViewGroup)) {
                    viewParent2 = null;
                }
                if (((ViewGroup) viewParent2) != null) {
                    ssVar7 = this.this$0.f;
                    View contentView3 = ssVar7.getContentView();
                    if (contentView3 != null) {
                        viewParent3 = contentView3.getParent();
                    }
                    if (viewParent3 != null) {
                        ssVar8 = this.this$0.f;
                        ((ViewGroup) viewParent3).removeView(ssVar8.getContentView());
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                }
            }
            ViewGroup viewGroup = this.$viewGroup;
            ssVar2 = this.this$0.f;
            if (viewGroup.indexOfChild(ssVar2.getContentView()) != -1) {
                ViewGroup viewGroup2 = this.$viewGroup;
                viewGroup2.removeView(viewGroup2);
            }
            View findViewWithTag = this.$viewGroup.findViewWithTag("TaskSDKBuoyViewTag");
            if (findViewWithTag != null) {
                this.$viewGroup.removeView(findViewWithTag);
            }
            ssVar3 = this.this$0.f;
            View contentView4 = ssVar3.getContentView();
            if (contentView4 != null) {
                contentView4.setTag("TaskSDKBuoyViewTag");
            }
            if (this.$layoutParams == null) {
                ViewGroup viewGroup3 = this.$viewGroup;
                ssVar5 = this.this$0.f;
                viewGroup3.addView(ssVar5.getContentView());
                return;
            }
            ViewGroup viewGroup4 = this.$viewGroup;
            ssVar4 = this.this$0.f;
            viewGroup4.addView(ssVar4.getContentView(), this.$layoutParams);
        }
    }
}
