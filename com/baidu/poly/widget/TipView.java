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
import c.a.i0.c;
import c.a.i0.e;
import c.a.i0.g;
import c.a.i0.h;
import c.a.i0.m.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class TipView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f38082e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f38083f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f38084g;

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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            setGravity(17);
            LayoutInflater.from(context).inflate(h.view_tip, (ViewGroup) this, true);
            this.f38082e = (ImageView) findViewById(g.tip_loading_view);
            this.f38083f = (TextView) findViewById(g.tip_text_view);
        }
    }

    public void hideLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(8);
            this.f38082e.clearAnimation();
        }
    }

    public void showChannelLoading(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            setVisibility(0);
            if (this.f38084g == null) {
                this.f38084g = AnimationUtils.loadAnimation(getContext(), c.loading_rotate);
            }
            this.f38083f.setText(str);
            ViewGroup.LayoutParams layoutParams = this.f38082e.getLayoutParams();
            if (layoutParams != null) {
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(e.channel_loading_icon_size);
                layoutParams.width = dimensionPixelOffset;
                layoutParams.height = dimensionPixelOffset;
            }
            this.f38082e.startAnimation(this.f38084g);
        }
    }

    public void showPayLoading(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            setVisibility(0);
            this.f38082e.clearAnimation();
            ViewGroup.LayoutParams layoutParams = this.f38082e.getLayoutParams();
            if (layoutParams != null) {
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(e.pay_loading_icon_size);
                layoutParams.width = dimensionPixelOffset;
                layoutParams.height = dimensionPixelOffset;
            }
            b.b().a(this.f38082e, str);
            this.f38083f.setText(str2);
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
        a(context);
    }
}
