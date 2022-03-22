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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TabTextView extends AppCompatTextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f25796b;

    /* renamed from: c  reason: collision with root package name */
    public int f25797c;

    /* renamed from: d  reason: collision with root package name */
    public int f25798d;

    /* renamed from: e  reason: collision with root package name */
    public int f25799e;

    /* renamed from: f  reason: collision with root package name */
    public int f25800f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f25801g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f25802h;
    public boolean i;
    public boolean j;
    public float k;
    public float l;
    public boolean m;
    public boolean n;
    public LinearGradient o;
    public boolean p;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabTextView(Context context) {
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

    private void setBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            if (z) {
                if (this.m) {
                    setTypeface(Typeface.DEFAULT_BOLD);
                } else {
                    setTypeface(Typeface.DEFAULT);
                }
            } else if (this.n) {
                setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                setTypeface(Typeface.DEFAULT);
            }
        }
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                if (h()) {
                    if (this.o == null) {
                        if (getMeasuredWidth() == 0) {
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            measure(makeMeasureSpec, makeMeasureSpec);
                        }
                        this.o = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), new int[]{this.a, this.f25796b}, (float[]) null, Shader.TileMode.CLAMP);
                    }
                    getPaint().setShader(this.o);
                    return;
                }
                int i = this.f25798d;
                if (i == 0 || this.i || !this.j) {
                    return;
                }
                setTextColor(i);
                int i2 = this.f25800f;
                if (i2 != 0) {
                    setBackgroundResource(i2);
                }
                if (TextUtils.isEmpty(this.f25802h)) {
                    return;
                }
                setText(this.f25802h);
                return;
            }
            getPaint().setShader(null);
            int i3 = this.f25797c;
            if (i3 == 0 || this.i || !this.j) {
                return;
            }
            setTextColor(i3);
            int i4 = this.f25799e;
            if (i4 != 0) {
                setBackgroundResource(i4);
            }
            if (TextUtils.isEmpty(this.f25801g)) {
                return;
            }
            setText(this.f25801g);
        }
    }

    @Override // android.view.View
    public void dispatchSetSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.dispatchSetSelected(z);
            e(z);
            setBold(z);
            d(z);
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.p) {
            if (z) {
                float f2 = this.l;
                if (f2 != -1.0f) {
                    setTextSize(0, f2);
                    return;
                }
                return;
            }
            float f3 = this.k;
            if (f3 != -1.0f) {
                setTextSize(0, f3);
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            getPaint().setShader(null);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            float f2 = this.k;
            if (f2 != -1.0f) {
                setTextSize(0, f2);
            }
            int i = this.f25797c;
            if (i != 0) {
                setTextColor(i);
            }
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.a == -1 || this.f25796b == -1 || !this.i) ? false : true : invokeV.booleanValue;
    }

    public void setDefaultTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
            this.k = f2;
        }
    }

    public void setGradientColorEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.i = z;
        }
    }

    public void setNormalBackground(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f25799e = i;
        }
    }

    public void setNormalText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, charSequence) == null) {
            this.f25801g = charSequence;
        }
    }

    public void setSelectedBackground(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.f25800f = i;
        }
    }

    public void setSelectedBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.m = z;
        }
    }

    public void setSelectedColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f25798d = i;
        }
    }

    public void setSelectedColorEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.j = z;
        }
    }

    public void setSelectedText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, charSequence) == null) {
            this.f25802h = charSequence;
        }
    }

    public void setSelectedTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f2) == null) {
            this.l = f2;
        }
    }

    public void setUnSelectedColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f25797c = i;
        }
    }

    public void setUnselectedBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.n = z;
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
    public TabTextView(Context context, AttributeSet attributeSet, int i) {
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
        this.i = true;
        this.j = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0403cd, R.attr.obfuscated_res_0x7f0403d3, R.attr.obfuscated_res_0x7f0403e0, R.attr.obfuscated_res_0x7f0403e3, R.attr.obfuscated_res_0x7f0403e5, R.attr.obfuscated_res_0x7f0403e6, R.attr.obfuscated_res_0x7f0403e7, R.attr.obfuscated_res_0x7f0403e8, R.attr.obfuscated_res_0x7f0403ef});
        this.a = obtainStyledAttributes.getColor(7, 0);
        this.f25796b = obtainStyledAttributes.getColor(1, 0);
        this.f25798d = obtainStyledAttributes.getColor(4, 0);
        this.f25797c = obtainStyledAttributes.getColor(2, 0);
        this.k = obtainStyledAttributes.getDimension(0, -1.0f);
        this.l = obtainStyledAttributes.getDimension(5, -1.0f);
        this.m = obtainStyledAttributes.getBoolean(3, true);
        this.n = obtainStyledAttributes.getBoolean(8, false);
        this.p = obtainStyledAttributes.getBoolean(6, false);
        obtainStyledAttributes.recycle();
        g();
    }
}
