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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class EMTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f40238e;

    /* loaded from: classes11.dex */
    public static class a implements LineHeightSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f40239e;

        /* renamed from: f  reason: collision with root package name */
        public WeakReference<TextView> f40240f;

        /* renamed from: g  reason: collision with root package name */
        public ViewGroup.MarginLayoutParams f40241g;

        /* renamed from: h  reason: collision with root package name */
        public int f40242h;

        /* renamed from: i  reason: collision with root package name */
        public int f40243i;

        /* renamed from: j  reason: collision with root package name */
        public int f40244j;
        public int k;

        public a(TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40242h = 0;
            this.f40243i = 0;
            this.f40244j = 0;
            this.k = 0;
            this.f40240f = new WeakReference<>(textView);
            d();
        }

        public final void a(Paint.FontMetricsInt fontMetricsInt) {
            ViewGroup.MarginLayoutParams b2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fontMetricsInt) == null) || (b2 = b()) == null) {
                return;
            }
            this.f40242h = b2.topMargin;
            this.f40243i = b2.bottomMargin;
            this.f40244j = fontMetricsInt.top - fontMetricsInt.ascent;
            int dimenPixelSize = (fontMetricsInt.descent - fontMetricsInt.bottom) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            this.k = dimenPixelSize;
            b2.topMargin += this.f40244j;
            b2.bottomMargin += dimenPixelSize;
        }

        public final ViewGroup.MarginLayoutParams b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                TextView c2 = c();
                if (c2 == null) {
                    return null;
                }
                ViewGroup.LayoutParams layoutParams = c2.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    return (ViewGroup.MarginLayoutParams) layoutParams;
                }
                return null;
            }
            return (ViewGroup.MarginLayoutParams) invokeV.objValue;
        }

        public TextView c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                WeakReference<TextView> weakReference = this.f40240f;
                if (weakReference == null || weakReference.get() == null) {
                    return null;
                }
                return this.f40240f.get();
            }
            return (TextView) invokeV.objValue;
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i2, int i3, int i4, int i5, Paint.FontMetricsInt fontMetricsInt) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), fontMetricsInt}) == null) {
                f();
                c.a.s0.s.u.e.a.a(fontMetricsInt, this.f40239e);
                TextView c2 = c();
                if (c2 == null || (c2.getGravity() & 112) != 16) {
                    a(fontMetricsInt);
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                TextView c2 = c();
                if (c2 != null) {
                    this.f40239e = (int) c2.getTextSize();
                }
                ViewGroup.MarginLayoutParams b2 = b();
                this.f40241g = b2;
                if (b2 != null) {
                    this.f40242h = b2.topMargin;
                    this.f40243i = b2.bottomMargin;
                }
                this.f40244j = 0;
                this.k = 0;
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            ViewGroup.MarginLayoutParams b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f40241g != null && (b2 = b()) != null && this.f40241g == b2) {
                    boolean z = this.f40242h + this.f40244j == b2.topMargin;
                    boolean z2 = this.f40243i + this.k == b2.bottomMargin;
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
                ViewGroup.MarginLayoutParams b2 = b();
                if (b2 == null) {
                    return;
                }
                b2.topMargin -= this.f40244j;
                b2.bottomMargin -= this.k;
                TextView c2 = c();
                if (c2 != null) {
                    this.f40239e = (int) c2.getTextSize();
                }
                this.f40244j = 0;
                this.k = 0;
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

    @Override // android.widget.TextView
    @Deprecated
    public void setLineSpacing(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            super.setLineSpacing(f2, f3);
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
            if (this.f40238e == null) {
                this.f40238e = new a(this);
            }
            spannableStringBuilder.setSpan(this.f40238e, 0, charSequence.length(), 33);
            super.setText(spannableStringBuilder, bufferType);
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
    public EMTextView(Context context, AttributeSet attributeSet, int i2) {
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
    }
}
