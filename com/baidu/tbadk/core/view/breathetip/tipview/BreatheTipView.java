package com.baidu.tbadk.core.view.breathetip.tipview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ja5;
import com.baidu.tieba.s75;
import com.baidu.tieba.xi;
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
            int g = xi.g(context, R.dimen.M_W_X007);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            layoutParams.leftMargin = g;
            layoutParams.rightMargin = g;
            this.a.setMaxLines(1);
            addView(this.a, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            layoutParams2.leftMargin = g;
            layoutParams2.rightMargin = g;
            addView(this.b, layoutParams2);
            s75 d = s75.d(this.a);
            d.C(R.dimen.T_X08);
            d.D(R.string.F_X02);
            s75 d2 = s75.d(this.b);
            d2.C(R.dimen.T_X09);
            d2.D(R.string.F_X01);
        }
    }

    public void setData(ja5 ja5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ja5Var) != null) || ja5Var == null) {
            return;
        }
        int i = ja5Var.g;
        int i2 = -2;
        if (i < 0) {
            i = -2;
        }
        int i3 = ja5Var.h;
        if (i3 >= 0) {
            i2 = i3;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        layoutParams.setMargins(ja5Var.j, ja5Var.k, ja5Var.i, ja5Var.l);
        setLayoutParams(layoutParams);
        this.a.setText(ja5Var.a);
        SkinManager.setViewTextColor(this.a, ja5Var.c);
        ((FrameLayout.LayoutParams) this.a.getLayoutParams()).topMargin = ja5Var.f;
        this.b.setText(ja5Var.b);
        SkinManager.setViewTextColor(this.b, ja5Var.d);
        ((FrameLayout.LayoutParams) this.b.getLayoutParams()).topMargin = ja5Var.f + xi.g(getContext(), R.dimen.M_H_X002) + ((int) this.a.getTextSize());
        SkinManager.setBackgroundResource(this, ja5Var.e);
    }
}
