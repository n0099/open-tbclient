package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.e.e.p.l;
import c.a.q0.s.f0.n.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class CustomPushPremissionDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f47650e;

    /* renamed from: f  reason: collision with root package name */
    public TBLottieAnimationView f47651f;

    /* renamed from: g  reason: collision with root package name */
    public View f47652g;

    /* renamed from: h  reason: collision with root package name */
    public View f47653h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f47654i;

    /* renamed from: j  reason: collision with root package name */
    public TBSpecificationBtn f47655j;

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
            gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0211));
            setBackgroundDrawable(gradientDrawable);
            LinearLayout.inflate(context, R.layout.custom_push_premission_dialog_view, this);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById(R.id.custom_push_permission_dialog_animation_view);
            this.f47651f = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            this.f47651f.setFrame(0);
            SkinManager.setLottieAnimation(this.f47651f, R.raw.lottie_push_permission_dialog_animation);
            this.f47651f.playAnimation();
            TextView textView = (TextView) findViewById(R.id.custom_push_permission_dialog_description_view);
            this.f47650e = textView;
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f47652g = findViewById(R.id.custom_push_permission_dialog_animation_floor_view);
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                this.f47653h = findViewById(R.id.animation_layout);
                TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(l.g(context, R.dimen.tbds26)).setShadowSide(273).setShadowLayer(R.color.CAM_X0804, 0, 0, l.g(getContext(), R.dimen.tbds22)).into(this.f47653h);
                ViewGroup.LayoutParams layoutParams2 = this.f47652g.getLayoutParams();
                layoutParams2.width = l.g(context, R.dimen.tbds774);
                this.f47652g.setLayoutParams(layoutParams2);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TOP_BOTTOM, SkinManager.getResourceId(R.color.common_color_10262), SkinManager.getResourceId(R.color.CAM_X0205)).into(this.f47652g);
            } else {
                TBSelector.makeDrawableSelector().setShape(0).radius(l.g(context, R.dimen.tbds26)).gradientLinear(DrawableSelector.TOP_BOTTOM, SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0211)).into(this.f47652g);
            }
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_cancel_button);
            this.f47654i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.f47654i.setText(context.getString(R.string.push_permission_dialog_cancel_button_text));
            c cVar = new c();
            cVar.r(R.color.CAM_X0105);
            this.f47654i.setConfig(cVar);
            this.f47654i.changeSkinType();
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_confirm_button);
            this.f47655j = tBSpecificationBtn2;
            tBSpecificationBtn2.setTextSize(R.dimen.tbds34);
            this.f47655j.setText(context.getString(R.string.push_permission_dialog_confirm_button_text));
            c cVar2 = new c();
            cVar2.p(R.color.CAM_X0302);
            this.f47655j.setConfig(cVar2);
        }
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47654i : (TBSpecificationBtn) invokeV.objValue;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f47655j : (TBSpecificationBtn) invokeV.objValue;
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
