package com.baidu.tbadk.core.elementsMaven.view;

import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.f85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class EMTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes4.dex */
    public static class a implements LineHeightSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public WeakReference<TextView> b;
        public ViewGroup.MarginLayoutParams c;
        public int d;
        public int e;
        public int f;
        public int g;

        public a(TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.b = new WeakReference<>(textView);
            d();
        }

        public final void a(Paint.FontMetricsInt fontMetricsInt) {
            ViewGroup.MarginLayoutParams b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, fontMetricsInt) == null) && (b = b()) != null) {
                this.d = b.topMargin;
                this.e = b.bottomMargin;
                this.f = fontMetricsInt.top - fontMetricsInt.ascent;
                int dimenPixelSize = (fontMetricsInt.descent - fontMetricsInt.bottom) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
                this.g = dimenPixelSize;
                b.topMargin += this.f;
                b.bottomMargin += dimenPixelSize;
            }
        }

        public final ViewGroup.MarginLayoutParams b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                TextView c = c();
                if (c == null) {
                    return null;
                }
                ViewGroup.LayoutParams layoutParams = c.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    return null;
                }
                return (ViewGroup.MarginLayoutParams) layoutParams;
            }
            return (ViewGroup.MarginLayoutParams) invokeV.objValue;
        }

        public TextView c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                WeakReference<TextView> weakReference = this.b;
                if (weakReference != null && weakReference.get() != null) {
                    return this.b.get();
                }
                return null;
            }
            return (TextView) invokeV.objValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                TextView c = c();
                if (c != null) {
                    this.a = (int) c.getTextSize();
                }
                ViewGroup.MarginLayoutParams b = b();
                this.c = b;
                if (b != null) {
                    this.d = b.topMargin;
                    this.e = b.bottomMargin;
                }
                this.f = 0;
                this.g = 0;
            }
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontMetricsInt}) == null) {
                f();
                f85.a(fontMetricsInt, this.a);
                TextView c = c();
                if (c == null || (c.getGravity() & 112) != 16) {
                    a(fontMetricsInt);
                }
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            ViewGroup.MarginLayoutParams b;
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.c != null && (b = b()) != null && this.c == b) {
                    if (this.d + this.f == b.topMargin) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.e + this.g == b.bottomMargin) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && z2) {
                        return false;
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (e()) {
                    d();
                    return;
                }
                ViewGroup.MarginLayoutParams b = b();
                if (b == null) {
                    return;
                }
                b.topMargin -= this.f;
                b.bottomMargin -= this.g;
                TextView c = c();
                if (c != null) {
                    this.a = (int) c.getTextSize();
                }
                this.f = 0;
                this.g = 0;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EMTextView(Context context) {
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
    public EMTextView(Context context, AttributeSet attributeSet) {
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
    public EMTextView(Context context, AttributeSet attributeSet, int i) {
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
    }

    @Override // android.widget.TextView
    @Deprecated
    public void setLineSpacing(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            super.setLineSpacing(f, f2);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        SpannableStringBuilder spannableStringBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, bufferType) == null) {
            super.setText(charSequence, bufferType);
            if (charSequence == null) {
                return;
            }
            if (charSequence instanceof SpannableStringBuilder) {
                spannableStringBuilder = (SpannableStringBuilder) charSequence;
            } else {
                spannableStringBuilder = new SpannableStringBuilder(charSequence);
            }
            if (this.a == null) {
                this.a = new a(this);
            }
            spannableStringBuilder.setSpan(this.a, 0, charSequence.length(), 33);
            super.setText(spannableStringBuilder, bufferType);
        }
    }
}
