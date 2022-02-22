package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.t0.s.l0.n.c;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.a4.i;
import c.a.u0.a4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class CustomPushPremissionDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f40580e;

    /* renamed from: f  reason: collision with root package name */
    public TBLottieAnimationView f40581f;

    /* renamed from: g  reason: collision with root package name */
    public View f40582g;

    /* renamed from: h  reason: collision with root package name */
    public View f40583h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f40584i;

    /* renamed from: j  reason: collision with root package name */
    public TBSpecificationBtn f40585j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomPushPremissionDialogView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            setOrientation(1);
            setGravity(1);
            setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(getResources().getDimension(e.tbds31));
            gradientDrawable.setColor(SkinManager.getColor(d.CAM_X0211));
            setBackgroundDrawable(gradientDrawable);
            LinearLayout.inflate(context, h.custom_push_premission_dialog_view, this);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById(g.custom_push_permission_dialog_animation_view);
            this.f40581f = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            this.f40581f.setFrame(0);
            SkinManager.setLottieAnimation(this.f40581f, i.lottie_push_permission_dialog_animation);
            this.f40581f.playAnimation();
            TextView textView = (TextView) findViewById(g.custom_push_permission_dialog_description_view);
            this.f40580e = textView;
            textView.setTextColor(SkinManager.getColor(d.CAM_X0105));
            this.f40582g = findViewById(g.custom_push_permission_dialog_animation_floor_view);
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                this.f40583h = findViewById(g.animation_layout);
                TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(n.f(context, e.tbds26)).setShadowSide(273).setShadowLayer(d.CAM_X0804, 0, 0, n.f(getContext(), e.tbds22)).into(this.f40583h);
                ViewGroup.LayoutParams layoutParams2 = this.f40582g.getLayoutParams();
                layoutParams2.width = n.f(context, e.tbds774);
                this.f40582g.setLayoutParams(layoutParams2);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TOP_BOTTOM, SkinManager.getResourceId(d.common_color_10262), SkinManager.getResourceId(d.CAM_X0205)).into(this.f40582g);
            } else {
                TBSelector.makeDrawableSelector().setShape(0).radius(n.f(context, e.tbds26)).gradientLinear(DrawableSelector.TOP_BOTTOM, SkinManager.getResourceId(d.CAM_X0205), SkinManager.getResourceId(d.CAM_X0205), SkinManager.getResourceId(d.CAM_X0205), SkinManager.getResourceId(d.CAM_X0205), SkinManager.getResourceId(d.CAM_X0211)).into(this.f40582g);
            }
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(g.custom_push_permission_dialog_cancel_button);
            this.f40584i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(e.tbds34);
            this.f40584i.setText(context.getString(j.push_permission_dialog_cancel_button_text));
            c cVar = new c();
            cVar.r(d.CAM_X0105);
            this.f40584i.setConfig(cVar);
            this.f40584i.changeSkinType();
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) findViewById(g.custom_push_permission_dialog_confirm_button);
            this.f40585j = tBSpecificationBtn2;
            tBSpecificationBtn2.setTextSize(e.tbds34);
            this.f40585j.setText(context.getString(j.push_permission_dialog_confirm_button_text));
            c cVar2 = new c();
            cVar2.p(d.CAM_X0302);
            this.f40585j.setConfig(cVar2);
        }
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f40584i : (TBSpecificationBtn) invokeV.objValue;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40585j : (TBSpecificationBtn) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }
}
