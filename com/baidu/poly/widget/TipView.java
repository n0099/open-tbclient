package com.baidu.poly.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e0.b;
import c.a.e0.d;
import c.a.e0.f;
import c.a.e0.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TipView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f44364e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f44365f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f44366g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TipView(Context context) {
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

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            setVisibility(0);
            if (this.f44366g == null) {
                this.f44366g = AnimationUtils.loadAnimation(getContext(), b.loading_rotate);
            }
            this.f44365f.setText(str);
            ViewGroup.LayoutParams layoutParams = this.f44364e.getLayoutParams();
            if (layoutParams != null) {
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.channel_loading_icon_size);
                layoutParams.width = dimensionPixelOffset;
                layoutParams.height = dimensionPixelOffset;
            }
            this.f44364e.startAnimation(this.f44366g);
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            setVisibility(0);
            this.f44364e.clearAnimation();
            ViewGroup.LayoutParams layoutParams = this.f44364e.getLayoutParams();
            if (layoutParams != null) {
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.pay_loading_icon_size);
                layoutParams.width = dimensionPixelOffset;
                layoutParams.height = dimensionPixelOffset;
            }
            c.a.e0.k.d.b.c().b(this.f44364e, str);
            this.f44365f.setText(str2);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            setOrientation(1);
            setGravity(17);
            LayoutInflater.from(context).inflate(g.view_tip, (ViewGroup) this, true);
            this.f44364e = (ImageView) findViewById(f.tip_loading_view);
            this.f44365f = (TextView) findViewById(f.tip_text_view);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(8);
            this.f44364e.clearAnimation();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TipView(Context context, AttributeSet attributeSet) {
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
    public TipView(Context context, AttributeSet attributeSet, int i2) {
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
        c(context);
    }
}
