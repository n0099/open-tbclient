package com.baidu.nadcore.widget.txt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wx0;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class AlignTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public float C;
    public float D;
    public float a;
    public float b;
    public int c;
    public List<String> d;
    public List<Integer> e;
    public Align f;
    public boolean g;
    public float h;
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
    /* loaded from: classes2.dex */
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
        this.b = 0.0f;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = Align.ALIGN_LEFT;
        this.g = true;
        this.h = 1.0f;
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
                wx0.b(this.d, "\n");
                return;
            }
            this.s = 0;
            float measureText = paint.measureText("中");
            this.t = measureText;
            int i = (int) (this.c / measureText);
            this.u = i;
            this.r = new StringBuilder(str.substring(0, Math.min(i + 1, str.length())));
            int i2 = this.u;
            while (true) {
                i2++;
                if (i2 >= str.length()) {
                    break;
                } else if (paint.measureText(str.substring(this.s, i2 + 1)) > this.c) {
                    this.s = i2;
                    wx0.b(this.d, this.r.toString());
                    this.r = new StringBuilder();
                    int length = str.length();
                    int i3 = this.s;
                    int i4 = length - i3;
                    int i5 = this.u;
                    if (i4 > i5) {
                        this.r.append(str.substring(i3, i5 + i3));
                        i2 = (i2 + this.u) - 1;
                    } else {
                        wx0.b(this.d, str.substring(i3));
                        break;
                    }
                } else {
                    this.r.append(str.charAt(i2));
                }
            }
            if (this.r.length() > 0) {
                wx0.b(this.d, this.r.toString());
            }
            wx0.b(this.e, Integer.valueOf(this.d.size() - 1));
        }
    }

    public final void b(String str, float f, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Float.valueOf(f), Integer.valueOf(i)}) == null) {
            TextView textView = new TextView(getContext());
            this.v = textView;
            textView.setText(str);
            this.v.setTextSize(0, f);
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
            this.c = getMeasuredWidth();
            this.w = this.n.getFontMetrics();
            float textSize = getTextSize();
            Paint.FontMetrics fontMetrics = this.w;
            this.x = textSize - (((fontMetrics.bottom - fontMetrics.descent) + fontMetrics.ascent) - fontMetrics.top);
            if ((getGravity() & 16) == 16) {
                float f = this.x;
                this.x = f + ((this.a - f) / 2.0f);
            }
            this.c = (this.c - getPaddingLeft()) - getPaddingRight();
            for (int i = 0; i < this.d.size(); i++) {
                float f2 = i;
                this.y = (this.a * f2) + this.x;
                this.z = (String) wx0.d(this.d, i);
                this.A = getPaddingLeft();
                float measureText = this.c - this.n.measureText(this.z);
                this.B = measureText;
                this.C = measureText / (this.z.length() - 1);
                if (this.e.contains(Integer.valueOf(i))) {
                    this.C = 0.0f;
                    Align align = this.f;
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
                    canvas.drawText(this.z.substring(i2, i3), this.D + this.A, this.y + getPaddingTop() + (this.b * f2), this.n);
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
            if (this.g) {
                this.c = getMeasuredWidth();
                this.o = getText().toString();
                this.n = getPaint();
                this.d.clear();
                this.e.clear();
                String[] split = this.o.split("\\n");
                this.p = split;
                for (String str : split) {
                    a(this.n, str);
                }
                b(this.o, this.n.getTextSize(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
                float f = (this.j * 1.0f) / this.k;
                this.a = f;
                float f2 = ((this.h - 1.0f) * f) + this.i;
                this.b = f2;
                this.q = (int) ((f2 + f) * (this.d.size() - this.k));
                this.m = true;
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.l + this.q);
                this.g = false;
            }
        }
    }

    public void setAlign(Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, align) == null) {
            this.f = align;
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
            this.g = true;
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
        this.b = 0.0f;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = Align.ALIGN_LEFT;
        this.g = true;
        this.h = 1.0f;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = false;
        setTextIsSelectable(false);
        this.h = attributeSet.getAttributeFloatValue("http://schemas.android.com/apk/res/android", "mLineSpacingMultiplier", 1.0f);
        this.i = context.obtainStyledAttributes(attributeSet, new int[]{16843287}).getDimensionPixelSize(0, 0);
        this.l = getPaddingBottom();
    }
}
