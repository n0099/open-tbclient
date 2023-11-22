package com.baidu.tbadk.core.view.breathetip.tipview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.p55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BreatheTipView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreatheTipView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreatheTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreatheTipView(Context context, AttributeSet attributeSet, int i) {
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
            this.a = new TextView(context);
            this.b = new TextView(context);
            int dimens = BdUtilHelper.getDimens(context, R.dimen.M_W_X007);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            layoutParams.leftMargin = dimens;
            layoutParams.rightMargin = dimens;
            this.a.setMaxLines(1);
            addView(this.a, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            layoutParams2.leftMargin = dimens;
            layoutParams2.rightMargin = dimens;
            addView(this.b, layoutParams2);
            EMManager.from(this.a).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X02);
            EMManager.from(this.b).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
        }
    }

    public void setData(p55 p55Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p55Var) != null) || p55Var == null) {
            return;
        }
        int i = p55Var.g;
        int i2 = -2;
        if (i < 0) {
            i = -2;
        }
        int i3 = p55Var.h;
        if (i3 >= 0) {
            i2 = i3;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        layoutParams.setMargins(p55Var.j, p55Var.k, p55Var.i, p55Var.l);
        setLayoutParams(layoutParams);
        this.a.setText(p55Var.a);
        SkinManager.setViewTextColor(this.a, p55Var.c);
        ((FrameLayout.LayoutParams) this.a.getLayoutParams()).topMargin = p55Var.f;
        this.b.setText(p55Var.b);
        SkinManager.setViewTextColor(this.b, p55Var.d);
        ((FrameLayout.LayoutParams) this.b.getLayoutParams()).topMargin = p55Var.f + BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X002) + ((int) this.a.getTextSize());
        SkinManager.setBackgroundResource(this, p55Var.e);
    }
}
