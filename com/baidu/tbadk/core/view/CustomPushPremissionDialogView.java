package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.pa5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CustomPushPremissionDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TBLottieAnimationView b;
    public View c;
    public View d;
    public TBSpecificationBtn e;
    public TBSpecificationBtn f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomPushPremissionDialogView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomPushPremissionDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
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
            this.b = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            this.b.setFrame(0);
            SkinManager.setLottieAnimation(this.b, R.raw.lottie_push_permission_dialog_animation);
            this.b.playAnimation();
            TextView textView = (TextView) findViewById(R.id.custom_push_permission_dialog_description_view);
            this.a = textView;
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.c = findViewById(R.id.custom_push_permission_dialog_animation_floor_view);
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                this.d = findViewById(R.id.animation_layout);
                TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(BdUtilHelper.getDimens(context, R.dimen.tbds26)).setShadowSide(273).setShadowLayer(R.color.CAM_X0804, 0, 0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds22)).into(this.d);
                ViewGroup.LayoutParams layoutParams2 = this.c.getLayoutParams();
                layoutParams2.width = BdUtilHelper.getDimens(context, R.dimen.tbds774);
                this.c.setLayoutParams(layoutParams2);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TOP_BOTTOM, SkinManager.getResourceId(R.color.common_color_10262), SkinManager.getResourceId(R.color.CAM_X0205)).into(this.c);
            } else {
                TBSelector.makeDrawableSelector().setShape(0).radius(BdUtilHelper.getDimens(context, R.dimen.tbds26)).gradientLinear(DrawableSelector.TOP_BOTTOM, SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0211)).into(this.c);
            }
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_cancel_button);
            this.e = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.e.setText(context.getString(R.string.push_permission_dialog_cancel_button_text));
            pa5 pa5Var = new pa5();
            pa5Var.t(R.color.CAM_X0105);
            this.e.setConfig(pa5Var);
            this.e.k();
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) findViewById(R.id.custom_push_permission_dialog_confirm_button);
            this.f = tBSpecificationBtn2;
            tBSpecificationBtn2.setTextSize(R.dimen.tbds34);
            this.f.setText(context.getString(R.string.push_permission_dialog_confirm_button_text));
            pa5 pa5Var2 = new pa5();
            pa5Var2.r(R.color.CAM_X0302);
            this.f.setConfig(pa5Var2);
        }
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (TBSpecificationBtn) invokeV.objValue;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (TBSpecificationBtn) invokeV.objValue;
    }
}
