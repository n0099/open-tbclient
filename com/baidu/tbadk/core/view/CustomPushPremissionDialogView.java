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
import c.a.o0.r.l0.n.c;
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
/* loaded from: classes5.dex */
public class CustomPushPremissionDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TBLottieAnimationView f29979b;

    /* renamed from: c  reason: collision with root package name */
    public View f29980c;

    /* renamed from: d  reason: collision with root package name */
    public View f29981d;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f29982e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f29983f;

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
            LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0214, this);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f090745);
            this.f29979b = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            this.f29979b.setFrame(0);
            SkinManager.setLottieAnimation(this.f29979b, R.raw.obfuscated_res_0x7f11002f);
            this.f29979b.playAnimation();
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090748);
            this.a = textView;
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f29980c = findViewById(R.id.obfuscated_res_0x7f090744);
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                this.f29981d = findViewById(R.id.obfuscated_res_0x7f09026b);
                TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(n.f(context, R.dimen.tbds26)).setShadowSide(273).setShadowLayer(R.color.CAM_X0804, 0, 0, n.f(getContext(), R.dimen.tbds22)).into(this.f29981d);
                ViewGroup.LayoutParams layoutParams2 = this.f29980c.getLayoutParams();
                layoutParams2.width = n.f(context, R.dimen.tbds774);
                this.f29980c.setLayoutParams(layoutParams2);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TOP_BOTTOM, SkinManager.getResourceId(R.color.common_color_10262), SkinManager.getResourceId(R.color.CAM_X0205)).into(this.f29980c);
            } else {
                TBSelector.makeDrawableSelector().setShape(0).radius(n.f(context, R.dimen.tbds26)).gradientLinear(DrawableSelector.TOP_BOTTOM, SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0205), SkinManager.getResourceId(R.color.CAM_X0211)).into(this.f29980c);
            }
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f090746);
            this.f29982e = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.f29982e.setText(context.getString(R.string.obfuscated_res_0x7f0f0f0b));
            c cVar = new c();
            cVar.r(R.color.CAM_X0105);
            this.f29982e.setConfig(cVar);
            this.f29982e.k();
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) findViewById(R.id.obfuscated_res_0x7f090747);
            this.f29983f = tBSpecificationBtn2;
            tBSpecificationBtn2.setTextSize(R.dimen.tbds34);
            this.f29983f.setText(context.getString(R.string.obfuscated_res_0x7f0f0f0c));
            c cVar2 = new c();
            cVar2.p(R.color.CAM_X0302);
            this.f29983f.setConfig(cVar2);
        }
    }

    public TBSpecificationBtn getPushPermissionDialogCancelButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29982e : (TBSpecificationBtn) invokeV.objValue;
    }

    public TBSpecificationBtn getPushPermissionDialogConfirmButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29983f : (TBSpecificationBtn) invokeV.objValue;
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
}
