package com.baidu.nadcore.widget.txt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import c.a.b0.x.a;
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
import org.apache.commons.lang3.StringUtils;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class AlignTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint.FontMetrics A;
    public float B;
    public float C;
    public String D;
    public float E;
    public float F;
    public float G;
    public float H;

    /* renamed from: e  reason: collision with root package name */
    public float f35982e;

    /* renamed from: f  reason: collision with root package name */
    public float f35983f;

    /* renamed from: g  reason: collision with root package name */
    public int f35984g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f35985h;

    /* renamed from: i  reason: collision with root package name */
    public List<Integer> f35986i;

    /* renamed from: j  reason: collision with root package name */
    public Align f35987j;
    public boolean k;
    public float l;
    public float m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public TextPaint r;
    public String s;
    public String[] t;
    public int u;
    public StringBuilder v;
    public int w;
    public float x;
    public int y;
    public TextView z;

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

        public Align(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35983f = 0.0f;
        this.f35985h = new ArrayList();
        this.f35986i = new ArrayList();
        this.f35987j = Align.ALIGN_LEFT;
        this.k = true;
        this.l = 1.0f;
        this.m = 0.0f;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = false;
        setTextIsSelectable(false);
    }

    public final void a(Paint paint, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, paint, str) == null) {
            if (str.length() == 0) {
                a.b(this.f35985h, StringUtils.LF);
                return;
            }
            this.w = 0;
            float measureText = paint.measureText("中");
            this.x = measureText;
            int i2 = (int) (this.f35984g / measureText);
            this.y = i2;
            this.v = new StringBuilder(str.substring(0, Math.min(i2 + 1, str.length())));
            int i3 = this.y;
            while (true) {
                i3++;
                if (i3 >= str.length()) {
                    break;
                } else if (paint.measureText(str.substring(this.w, i3 + 1)) > this.f35984g) {
                    this.w = i3;
                    a.b(this.f35985h, this.v.toString());
                    this.v = new StringBuilder();
                    int length = str.length();
                    int i4 = this.w;
                    int i5 = length - i4;
                    int i6 = this.y;
                    if (i5 > i6) {
                        this.v.append(str.substring(i4, i6 + i4));
                        i3 = (i3 + this.y) - 1;
                    } else {
                        a.b(this.f35985h, str.substring(i4));
                        break;
                    }
                } else {
                    this.v.append(str.charAt(i3));
                }
            }
            if (this.v.length() > 0) {
                a.b(this.f35985h, this.v.toString());
            }
            a.b(this.f35986i, Integer.valueOf(this.f35985h.size() - 1));
        }
    }

    public final void b(String str, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            TextView textView = new TextView(getContext());
            this.z = textView;
            textView.setText(str);
            this.z.setTextSize(0, f2);
            this.z.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.o = this.z.getLineCount();
            this.n = this.z.getMeasuredHeight();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            TextPaint paint = getPaint();
            this.r = paint;
            paint.setColor(getCurrentTextColor());
            this.r.drawableState = getDrawableState();
            this.f35984g = getMeasuredWidth();
            this.A = this.r.getFontMetrics();
            float textSize = getTextSize();
            Paint.FontMetrics fontMetrics = this.A;
            this.B = textSize - (((fontMetrics.bottom - fontMetrics.descent) + fontMetrics.ascent) - fontMetrics.top);
            if ((getGravity() & 16) == 16) {
                float f2 = this.B;
                this.B = f2 + ((this.f35982e - f2) / 2.0f);
            }
            this.f35984g = (this.f35984g - getPaddingLeft()) - getPaddingRight();
            for (int i2 = 0; i2 < this.f35985h.size(); i2++) {
                float f3 = i2;
                this.C = (this.f35982e * f3) + this.B;
                this.D = (String) a.d(this.f35985h, i2);
                this.E = getPaddingLeft();
                float measureText = this.f35984g - this.r.measureText(this.D);
                this.F = measureText;
                this.G = measureText / (this.D.length() - 1);
                if (this.f35986i.contains(Integer.valueOf(i2))) {
                    this.G = 0.0f;
                    Align align = this.f35987j;
                    if (align == Align.ALIGN_CENTER) {
                        this.E += this.F / 2.0f;
                    } else if (align == Align.ALIGN_RIGHT) {
                        this.E += this.F;
                    }
                }
                int i3 = 0;
                while (i3 < this.D.length()) {
                    this.H = this.r.measureText(this.D.substring(0, i3)) + (this.G * i3);
                    int i4 = i3 + 1;
                    canvas.drawText(this.D.substring(i3, i4), this.H + this.E, this.C + getPaddingTop() + (this.f35983f * f3), this.r);
                    i3 = i4;
                }
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.k) {
                this.f35984g = getMeasuredWidth();
                this.s = getText().toString();
                this.r = getPaint();
                this.f35985h.clear();
                this.f35986i.clear();
                String[] split = this.s.split("\\n");
                this.t = split;
                for (String str : split) {
                    a(this.r, str);
                }
                b(this.s, this.r.getTextSize(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
                float f2 = (this.n * 1.0f) / this.o;
                this.f35982e = f2;
                float f3 = ((this.l - 1.0f) * f2) + this.m;
                this.f35983f = f3;
                this.u = (int) ((f3 + f2) * (this.f35985h.size() - this.o));
                this.q = true;
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.p + this.u);
                this.k = false;
            }
        }
    }

    public void setAlign(Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, align) == null) {
            this.f35987j = align;
            invalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            if (!this.q) {
                this.p = i5;
            }
            this.q = false;
            super.setPadding(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, charSequence, bufferType) == null) {
            this.k = true;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35983f = 0.0f;
        this.f35985h = new ArrayList();
        this.f35986i = new ArrayList();
        this.f35987j = Align.ALIGN_LEFT;
        this.k = true;
        this.l = 1.0f;
        this.m = 0.0f;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = false;
        setTextIsSelectable(false);
        this.l = attributeSet.getAttributeFloatValue("http://schemas.android.com/apk/res/android", "mLineSpacingMultiplier", 1.0f);
        this.m = context.obtainStyledAttributes(attributeSet, new int[]{16843287}).getDimensionPixelSize(0, 0);
        this.p = getPaddingBottom();
    }
}
