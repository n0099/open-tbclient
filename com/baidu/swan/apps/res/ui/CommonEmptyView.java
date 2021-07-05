package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c;
import d.a.q0.a.d;
import d.a.q0.a.e;
import d.a.q0.a.f;
import d.a.q0.a.g;
/* loaded from: classes4.dex */
public class CommonEmptyView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f11285e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11286f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f11287g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f11288h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f11289i;
    public FrameLayout j;
    public TextView k;

    /* loaded from: classes4.dex */
    public class a implements d.a.q0.a.g2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonEmptyView f11290a;

        public a(CommonEmptyView commonEmptyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmptyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11290a = commonEmptyView;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonEmptyView(Context context) {
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
            LayoutInflater.from(context).inflate(g.aiapps_common_empty_view, (ViewGroup) this, true);
            setBackground(context.getResources().getDrawable(c.aiapps_empty_layout_backgroud));
            this.f11285e = (ImageView) findViewById(f.emptyview_image);
            this.f11286f = (TextView) findViewById(f.emptyview_title);
            this.f11287g = (TextView) findViewById(f.emptyview_subtitle);
            this.f11288h = (TextView) findViewById(f.emptyview_link);
            this.f11289i = (TextView) findViewById(f.emptyview_btn);
            this.j = (FrameLayout) findViewById(f.emptyview_bottom_layout);
            this.k = (TextView) findViewById(f.emptyview_problem_feedback);
            setPageResources();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            d.a.q0.a.c1.a.H().f(this, new a(this));
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            FrameLayout frameLayout = this.j;
            if (frameLayout == null || frameLayout.getLayoutParams() == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            int i2 = configuration.orientation;
            if (i2 == 1) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.aiapps_empty_view_bottom_margin_portrait);
            } else if (i2 == 2) {
                layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.aiapps_empty_view_bottom_margin_landscape);
            }
            this.j.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            d.a.q0.a.c1.a.H().g(this);
        }
    }

    public void setButtonText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f11289i.setText(str);
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, colorStateList) == null) {
            this.f11289i.setTextColor(colorStateList);
        }
    }

    public void setIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable) == null) {
            this.f11285e.setImageDrawable(drawable);
        }
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.f11288h.setVisibility(0);
            this.f11288h.setOnClickListener(onClickListener);
        }
    }

    public void setPageResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            setBackgroundColor(-1);
            TextView textView = this.f11286f;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(c.aiapps_emptyview_title_text_color));
            }
            TextView textView2 = this.f11288h;
            if (textView2 != null) {
                textView2.setTextColor(getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
            }
            TextView textView3 = this.f11289i;
            if (textView3 != null) {
                textView3.setBackground(getResources().getDrawable(e.aiapps_emptyview_btn_bg));
                this.f11289i.setTextColor(getResources().getColorStateList(c.swan_app_emptyview_btn_text_color));
            }
            TextView textView4 = this.f11287g;
            if (textView4 != null) {
                textView4.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
            }
        }
    }

    public void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f11287g.setVisibility(0);
            this.f11287g.setText(str);
            this.f11287g.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
        }
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.f11289i.setVisibility(0);
            this.f11289i.setOnClickListener(onClickListener);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f11286f.setText(str);
        }
    }

    public void setTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f11286f.setTextColor(i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonEmptyView(Context context, AttributeSet attributeSet) {
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

    public void setButtonText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f11289i.setText(i2);
        }
    }

    public void setIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f11285e.setImageDrawable(getResources().getDrawable(i2));
        }
    }

    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f11286f.setText(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonEmptyView(Context context, AttributeSet attributeSet, int i2) {
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

    public void setSubTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f11287g.setVisibility(0);
            this.f11287g.setText(i2);
            this.f11287g.setTextColor(getContext().getResources().getColor(c.aiapps_emptyview_subtitle_text_color));
        }
    }
}
