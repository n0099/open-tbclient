package com.baidu.nadcore.widget.txt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import c.a.a0.x.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class AlignTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public float C;
    public float D;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f27790b;

    /* renamed from: c  reason: collision with root package name */
    public int f27791c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f27792d;

    /* renamed from: e  reason: collision with root package name */
    public List<Integer> f27793e;

    /* renamed from: f  reason: collision with root package name */
    public Align f27794f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27795g;

    /* renamed from: h  reason: collision with root package name */
    public float f27796h;
    public float i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public TextPaint n;
    public String o;
    public String[] p;
    public int q;
    public StringBuilder r;
    public int s;
    public float t;
    public int u;
    public TextView v;
    public Paint.FontMetrics w;
    public float x;
    public float y;
    public String z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class Align {
        public static final /* synthetic */ Align[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Align ALIGN_CENTER;
        public static final Align ALIGN_LEFT;
        public static final Align ALIGN_RIGHT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1660970304, "Lcom/baidu/nadcore/widget/txt/AlignTextView$Align;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1660970304, "Lcom/baidu/nadcore/widget/txt/AlignTextView$Align;");
                    return;
                }
            }
            ALIGN_LEFT = new Align("ALIGN_LEFT", 0);
            ALIGN_CENTER = new Align("ALIGN_CENTER", 1);
            Align align = new Align("ALIGN_RIGHT", 2);
            ALIGN_RIGHT = align;
            $VALUES = new Align[]{ALIGN_LEFT, ALIGN_CENTER, align};
        }

        public Align(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Align valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Align) Enum.valueOf(Align.class, str) : (Align) invokeL.objValue;
        }

        public static Align[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Align[]) $VALUES.clone() : (Align[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlignTextView(Context context) {
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
        this.f27790b = 0.0f;
        this.f27792d = new ArrayList();
        this.f27793e = new ArrayList();
        this.f27794f = Align.ALIGN_LEFT;
        this.f27795g = true;
        this.f27796h = 1.0f;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = false;
        setTextIsSelectable(false);
    }

    public final void a(Paint paint, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, paint, str) == null) {
            if (str.length() == 0) {
                a.b(this.f27792d, "\n");
                return;
            }
            this.s = 0;
            float measureText = paint.measureText("中");
            this.t = measureText;
            int i = (int) (this.f27791c / measureText);
            this.u = i;
            this.r = new StringBuilder(str.substring(0, Math.min(i + 1, str.length())));
            int i2 = this.u;
            while (true) {
                i2++;
                if (i2 >= str.length()) {
                    break;
                } else if (paint.measureText(str.substring(this.s, i2 + 1)) > this.f27791c) {
                    this.s = i2;
                    a.b(this.f27792d, this.r.toString());
                    this.r = new StringBuilder();
                    int length = str.length();
                    int i3 = this.s;
                    int i4 = length - i3;
                    int i5 = this.u;
                    if (i4 > i5) {
                        this.r.append(str.substring(i3, i5 + i3));
                        i2 = (i2 + this.u) - 1;
                    } else {
                        a.b(this.f27792d, str.substring(i3));
                        break;
                    }
                } else {
                    this.r.append(str.charAt(i2));
                }
            }
            if (this.r.length() > 0) {
                a.b(this.f27792d, this.r.toString());
            }
            a.b(this.f27793e, Integer.valueOf(this.f27792d.size() - 1));
        }
    }

    public final void b(String str, float f2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Float.valueOf(f2), Integer.valueOf(i)}) == null) {
            TextView textView = new TextView(getContext());
            this.v = textView;
            textView.setText(str);
            this.v.setTextSize(0, f2);
            this.v.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.k = this.v.getLineCount();
            this.j = this.v.getMeasuredHeight();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            TextPaint paint = getPaint();
            this.n = paint;
            paint.setColor(getCurrentTextColor());
            this.n.drawableState = getDrawableState();
            this.f27791c = getMeasuredWidth();
            this.w = this.n.getFontMetrics();
            float textSize = getTextSize();
            Paint.FontMetrics fontMetrics = this.w;
            this.x = textSize - (((fontMetrics.bottom - fontMetrics.descent) + fontMetrics.ascent) - fontMetrics.top);
            if ((getGravity() & 16) == 16) {
                float f2 = this.x;
                this.x = f2 + ((this.a - f2) / 2.0f);
            }
            this.f27791c = (this.f27791c - getPaddingLeft()) - getPaddingRight();
            for (int i = 0; i < this.f27792d.size(); i++) {
                float f3 = i;
                this.y = (this.a * f3) + this.x;
                this.z = (String) a.d(this.f27792d, i);
                this.A = getPaddingLeft();
                float measureText = this.f27791c - this.n.measureText(this.z);
                this.B = measureText;
                this.C = measureText / (this.z.length() - 1);
                if (this.f27793e.contains(Integer.valueOf(i))) {
                    this.C = 0.0f;
                    Align align = this.f27794f;
                    if (align == Align.ALIGN_CENTER) {
                        this.A += this.B / 2.0f;
                    } else if (align == Align.ALIGN_RIGHT) {
                        this.A += this.B;
                    }
                }
                int i2 = 0;
                while (i2 < this.z.length()) {
                    this.D = this.n.measureText(this.z.substring(0, i2)) + (this.C * i2);
                    int i3 = i2 + 1;
                    canvas.drawText(this.z.substring(i2, i3), this.D + this.A, this.y + getPaddingTop() + (this.f27790b * f3), this.n);
                    i2 = i3;
                }
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f27795g) {
                this.f27791c = getMeasuredWidth();
                this.o = getText().toString();
                this.n = getPaint();
                this.f27792d.clear();
                this.f27793e.clear();
                String[] split = this.o.split("\\n");
                this.p = split;
                for (String str : split) {
                    a(this.n, str);
                }
                b(this.o, this.n.getTextSize(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
                float f2 = (this.j * 1.0f) / this.k;
                this.a = f2;
                float f3 = ((this.f27796h - 1.0f) * f2) + this.i;
                this.f27790b = f3;
                this.q = (int) ((f3 + f2) * (this.f27792d.size() - this.k));
                this.m = true;
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.l + this.q);
                this.f27795g = false;
            }
        }
    }

    public void setAlign(Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, align) == null) {
            this.f27794f = align;
            invalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            if (!this.m) {
                this.l = i4;
            }
            this.m = false;
            super.setPadding(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, charSequence, bufferType) == null) {
            this.f27795g = true;
            super.setText(charSequence, bufferType);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlignTextView(Context context, AttributeSet attributeSet) {
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
        this.f27790b = 0.0f;
        this.f27792d = new ArrayList();
        this.f27793e = new ArrayList();
        this.f27794f = Align.ALIGN_LEFT;
        this.f27795g = true;
        this.f27796h = 1.0f;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = false;
        setTextIsSelectable(false);
        this.f27796h = attributeSet.getAttributeFloatValue("http://schemas.android.com/apk/res/android", "mLineSpacingMultiplier", 1.0f);
        this.i = context.obtainStyledAttributes(attributeSet, new int[]{16843287}).getDimensionPixelSize(0, 0);
        this.l = getPaddingBottom();
    }
}
