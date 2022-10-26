package com.baidu.bdtask.component.buoy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.zs;
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
public final class BuoyComponent$attachToWindow$1 extends Lambda implements Function0 {
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

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        zs zsVar;
        ViewParent viewParent;
        zs zsVar2;
        zs zsVar3;
        zs zsVar4;
        zs zsVar5;
        zs zsVar6;
        ViewParent viewParent2;
        zs zsVar7;
        zs zsVar8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            zsVar = this.this$0.f;
            View contentView = zsVar.getContentView();
            ViewParent viewParent3 = null;
            if (contentView != null) {
                viewParent = contentView.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent != null) {
                zsVar6 = this.this$0.f;
                View contentView2 = zsVar6.getContentView();
                if (contentView2 != null) {
                    viewParent2 = contentView2.getParent();
                } else {
                    viewParent2 = null;
                }
                if (!(viewParent2 instanceof ViewGroup)) {
                    viewParent2 = null;
                }
                if (((ViewGroup) viewParent2) != null) {
                    zsVar7 = this.this$0.f;
                    View contentView3 = zsVar7.getContentView();
                    if (contentView3 != null) {
                        viewParent3 = contentView3.getParent();
                    }
                    if (viewParent3 != null) {
                        zsVar8 = this.this$0.f;
                        ((ViewGroup) viewParent3).removeView(zsVar8.getContentView());
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                }
            }
            ViewGroup viewGroup = this.$viewGroup;
            zsVar2 = this.this$0.f;
            if (viewGroup.indexOfChild(zsVar2.getContentView()) != -1) {
                ViewGroup viewGroup2 = this.$viewGroup;
                viewGroup2.removeView(viewGroup2);
            }
            View findViewWithTag = this.$viewGroup.findViewWithTag("TaskSDKBuoyViewTag");
            if (findViewWithTag != null) {
                this.$viewGroup.removeView(findViewWithTag);
            }
            zsVar3 = this.this$0.f;
            View contentView4 = zsVar3.getContentView();
            if (contentView4 != null) {
                contentView4.setTag("TaskSDKBuoyViewTag");
            }
            if (this.$layoutParams == null) {
                ViewGroup viewGroup3 = this.$viewGroup;
                zsVar5 = this.this$0.f;
                viewGroup3.addView(zsVar5.getContentView());
                return;
            }
            ViewGroup viewGroup4 = this.$viewGroup;
            zsVar4 = this.this$0.f;
            viewGroup4.addView(zsVar4.getContentView(), this.$layoutParams);
        }
    }
}
