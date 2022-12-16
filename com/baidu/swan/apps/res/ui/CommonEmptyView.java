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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.ln2;
import com.baidu.tieba.s93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CommonEmptyView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public FrameLayout f;
    public TextView g;

    /* loaded from: classes3.dex */
    public class a implements s93 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonEmptyView a;

        public a(CommonEmptyView commonEmptyView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEmptyView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonEmptyView;
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
    public CommonEmptyView(Context context, AttributeSet attributeSet) {
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
    public CommonEmptyView(Context context, AttributeSet attributeSet, int i) {
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d009d, (ViewGroup) this, true);
            setBackground(context.getResources().getDrawable(R.color.obfuscated_res_0x7f0603b5));
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f090923);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090927);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090926);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090924);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090922);
            this.f = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090921);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f090925);
            setPageResources();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            ln2.M().f(this, new a(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            ln2.M().g(this);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            FrameLayout frameLayout = this.f;
            if (frameLayout != null && frameLayout.getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
                int i = configuration.orientation;
                if (i == 1) {
                    layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07013c);
                } else if (i == 2) {
                    layoutParams.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07013b);
                }
                this.f.setLayoutParams(layoutParams);
            }
        }
    }

    public void setButtonText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.e.setText(i);
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, colorStateList) == null) {
            this.e.setTextColor(colorStateList);
        }
    }

    public void setIcon(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a.setImageDrawable(getResources().getDrawable(i));
        }
    }

    public void setLinkClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.d.setVisibility(0);
            this.d.setOnClickListener(onClickListener);
        }
    }

    public void setSubTitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.c.setVisibility(0);
            this.c.setText(i);
            this.c.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0603b8));
        }
    }

    public void setTextButtonClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            this.e.setVisibility(0);
            this.e.setOnClickListener(onClickListener);
        }
    }

    public void setTitle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.b.setText(i);
        }
    }

    public void setTitleColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.b.setTextColor(i);
        }
    }

    public void setButtonText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.e.setText(str);
        }
    }

    public void setIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable) == null) {
            this.a.setImageDrawable(drawable);
        }
    }

    public void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.c.setVisibility(0);
            this.c.setText(str);
            this.c.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0603b8));
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.b.setText(str);
        }
    }

    public void setPageResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            setBackgroundColor(-1);
            TextView textView = this.b;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0603ba));
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0603b8));
            }
            TextView textView3 = this.e;
            if (textView3 != null) {
                textView3.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08014d));
                this.e.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f060a78));
            }
            TextView textView4 = this.c;
            if (textView4 != null) {
                textView4.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0603b8));
            }
        }
    }
}
