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

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<TextView> f29874b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup.MarginLayoutParams f29875c;

        /* renamed from: d  reason: collision with root package name */
        public int f29876d;

        /* renamed from: e  reason: collision with root package name */
        public int f29877e;

        /* renamed from: f  reason: collision with root package name */
        public int f29878f;

        /* renamed from: g  reason: collision with root package name */
        public int f29879g;

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
            this.f29876d = 0;
            this.f29877e = 0;
            this.f29878f = 0;
            this.f29879g = 0;
            this.f29874b = new WeakReference<>(textView);
            d();
        }

        public final void a(Paint.FontMetricsInt fontMetricsInt) {
            ViewGroup.MarginLayoutParams b2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fontMetricsInt) == null) || (b2 = b()) == null) {
                return;
            }
            this.f29876d = b2.topMargin;
            this.f29877e = b2.bottomMargin;
            this.f29878f = fontMetricsInt.top - fontMetricsInt.ascent;
            int dimenPixelSize = (fontMetricsInt.descent - fontMetricsInt.bottom) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
            this.f29879g = dimenPixelSize;
            b2.topMargin += this.f29878f;
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
                WeakReference<TextView> weakReference = this.f29874b;
                if (weakReference == null || weakReference.get() == null) {
                    return null;
                }
                return this.f29874b.get();
            }
            return (TextView) invokeV.objValue;
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontMetricsInt}) == null) {
                f();
                c.a.o0.r.v.e.a.a(fontMetricsInt, this.a);
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
                    this.a = (int) c2.getTextSize();
                }
                ViewGroup.MarginLayoutParams b2 = b();
                this.f29875c = b2;
                if (b2 != null) {
                    this.f29876d = b2.topMargin;
                    this.f29877e = b2.bottomMargin;
                }
                this.f29878f = 0;
                this.f29879g = 0;
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            ViewGroup.MarginLayoutParams b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f29875c != null && (b2 = b()) != null && this.f29875c == b2) {
                    boolean z = this.f29876d + this.f29878f == b2.topMargin;
                    boolean z2 = this.f29877e + this.f29879g == b2.bottomMargin;
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
                b2.topMargin -= this.f29878f;
                b2.bottomMargin -= this.f29879g;
                TextView c2 = c();
                if (c2 != null) {
                    this.a = (int) c2.getTextSize();
                }
                this.f29878f = 0;
                this.f29879g = 0;
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
            if (this.a == null) {
                this.a = new a(this);
            }
            spannableStringBuilder.setSpan(this.a, 0, charSequence.length(), 33);
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
}
