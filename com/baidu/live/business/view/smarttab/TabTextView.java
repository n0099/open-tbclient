package com.baidu.live.business.view.smarttab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.InputDeviceCompat;
import c.a.x.c.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class TabTextView extends AppCompatTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f36008e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36009f;

    /* renamed from: g  reason: collision with root package name */
    public int f36010g;

    /* renamed from: h  reason: collision with root package name */
    public int f36011h;

    /* renamed from: i  reason: collision with root package name */
    public int f36012i;

    /* renamed from: j  reason: collision with root package name */
    public int f36013j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f36014k;
    public CharSequence l;
    public boolean m;
    public boolean n;
    public float o;
    public float p;
    public boolean q;
    public boolean r;
    public LinearGradient s;
    public boolean t;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabTextView(Context context) {
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

    private void setBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            if (z) {
                if (this.q) {
                    setTypeface(Typeface.DEFAULT_BOLD);
                } else {
                    setTypeface(Typeface.DEFAULT);
                }
            } else if (this.r) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                if (d()) {
                    if (this.s == null) {
                        if (getMeasuredWidth() == 0) {
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            measure(makeMeasureSpec, makeMeasureSpec);
                        }
                        this.s = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.f36008e, this.f36009f}, (float[]) null, Shader.TileMode.CLAMP);
                    }
                    getPaint().setShader(this.s);
                    return;
                }
                int i2 = this.f36011h;
                if (i2 == 0 || this.m || !this.n) {
                    return;
                }
                setTextColor(i2);
                int i3 = this.f36013j;
                if (i3 != 0) {
                    setBackgroundResource(i3);
                }
                if (TextUtils.isEmpty(this.l)) {
                    return;
                }
                setText(this.l);
                return;
            }
            getPaint().setShader(null);
            int i4 = this.f36010g;
            if (i4 == 0 || this.m || !this.n) {
                return;
            }
            setTextColor(i4);
            int i5 = this.f36012i;
            if (i5 != 0) {
                setBackgroundResource(i5);
            }
            if (TextUtils.isEmpty(this.f36014k)) {
                return;
            }
            setText(this.f36014k);
        }
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.t) {
            if (z) {
                float f2 = this.p;
                if (f2 != -1.0f) {
                    setTextSize(0, f2);
                    return;
                }
                return;
            }
            float f3 = this.o;
            if (f3 != -1.0f) {
                setTextSize(0, f3);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            float f2 = this.o;
            if (f2 != -1.0f) {
                setTextSize(0, f2);
            }
            int i2 = this.f36010g;
            if (i2 != 0) {
                setTextColor(i2);
            }
        }
    }

    public void changeTextSizeEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.t = z;
        }
    }

    public void clearGradientColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            getPaint().setShader(null);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.f36008e == -1 || this.f36009f == -1 || !this.m) ? false : true : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void dispatchSetSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.dispatchSetSelected(z);
            b(z);
            setBold(z);
            a(z);
        }
    }

    public boolean isChangeTextSizeEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public void setDefaultTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.o = f2;
        }
    }

    public void setGradientColorEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.m = z;
        }
    }

    public void setNormalBackground(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f36012i = i2;
        }
    }

    public void setNormalText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, charSequence) == null) {
            this.f36014k = charSequence;
        }
    }

    public void setSelectedBackground(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f36013j = i2;
        }
    }

    public void setSelectedBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.q = z;
        }
    }

    public void setSelectedColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f36011h = i2;
        }
    }

    public void setSelectedColorEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.n = z;
        }
    }

    public void setSelectedText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, charSequence) == null) {
            this.l = charSequence;
        }
    }

    public void setSelectedTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            this.p = f2;
        }
    }

    public void setUnSelectedColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f36010g = i2;
        }
    }

    public void setUnselectedBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.r = z;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabTextView(Context context, AttributeSet attributeSet) {
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
    public TabTextView(Context context, AttributeSet attributeSet, int i2) {
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
        this.m = true;
        this.n = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.LiveFeedPageTabTextView);
        this.f36008e = obtainStyledAttributes.getColor(f.LiveFeedPageTabTextView_live_feed_page_startTextColor, 0);
        this.f36009f = obtainStyledAttributes.getColor(f.LiveFeedPageTabTextView_live_feed_page_endTextColor, 0);
        this.f36011h = obtainStyledAttributes.getColor(f.LiveFeedPageTabTextView_live_feed_page_selectedTextColor, 0);
        this.f36010g = obtainStyledAttributes.getColor(f.LiveFeedPageTabTextView_live_feed_page_normalTextColor, 0);
        this.o = obtainStyledAttributes.getDimension(f.LiveFeedPageTabTextView_live_feed_page_defaultTextSize, -1.0f);
        this.p = obtainStyledAttributes.getDimension(f.LiveFeedPageTabTextView_live_feed_page_selectedTextSize, -1.0f);
        this.q = obtainStyledAttributes.getBoolean(f.LiveFeedPageTabTextView_live_feed_page_selectedBold, true);
        this.r = obtainStyledAttributes.getBoolean(f.LiveFeedPageTabTextView_live_feed_page_unselectedBold, false);
        this.t = obtainStyledAttributes.getBoolean(f.LiveFeedPageTabTextView_live_feed_page_sizeChangeEnable, false);
        obtainStyledAttributes.recycle();
        c();
    }
}
