package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.h.a;
import c.a.a0.h0.f;
import c.a.a0.h0.t;
import c.a.a0.s.i;
import c.a.a0.s.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class NadExpressBottomView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;
    public AdImageView a;

    /* renamed from: b  reason: collision with root package name */
    public String f27812b;

    /* renamed from: c  reason: collision with root package name */
    public String f27813c;

    /* renamed from: d  reason: collision with root package name */
    public String f27814d;

    /* renamed from: e  reason: collision with root package name */
    public TextPaint f27815e;

    /* renamed from: f  reason: collision with root package name */
    public TextPaint f27816f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f27817g;

    /* renamed from: h  reason: collision with root package name */
    public int f27818h;
    public int i;
    public int j;
    public String k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1872933239, "Lcom/baidu/nadcore/widget/uitemplate/NadExpressBottomView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1872933239, "Lcom/baidu/nadcore/widget/uitemplate/NadExpressBottomView;");
                return;
            }
        }
        l = f.c.a(a.b(), 3.0f);
        m = f.c.a(a.b(), 0.0f);
        n = e(R.dimen.obfuscated_res_0x7f070046);
        o = e(R.dimen.obfuscated_res_0x7f0704f6);
        p = e(R.dimen.obfuscated_res_0x7f070479);
        q = e(R.dimen.obfuscated_res_0x7f0704f8) - (l * 2);
        r = e(R.dimen.obfuscated_res_0x7f070068);
        s = e(R.dimen.obfuscated_res_0x7f070068);
        t = e(R.dimen.obfuscated_res_0x7f07051f);
        u = d(R.color.obfuscated_res_0x7f060271);
        v = d(R.color.obfuscated_res_0x7f06024e);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressBottomView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? ContextCompat.getColor(a.b(), i) : invokeI.intValue;
    }

    public static int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) ? a.b().getResources().getDimensionPixelSize(i) : invokeI.intValue;
    }

    public final String a(String str, float f2, TextPaint textPaint) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Float.valueOf(f2), textPaint})) == null) ? TextUtils.ellipsize(str, textPaint, f2, TextUtils.TruncateAt.END).toString() : (String) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6 A[LOOP:0: B:12:0x0022->B:31:0x00b6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba A[EDGE_INSN: B:38:0x00ba->B:32:0x00ba ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        float h2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = 0;
            int measuredWidth = this.a.getVisibility() != 8 ? this.a.getMeasuredWidth() + m + 0 : 0;
            if (measuredWidth > this.i) {
                this.f27818h = 0;
                return;
            }
            while (i2 < this.f27817g.size()) {
                if (TextUtils.equals((CharSequence) c.a.a0.x.a.d(this.f27817g, i2), this.f27813c)) {
                    measuredWidth = (int) (measuredWidth + h((String) c.a.a0.x.a.d(this.f27817g, i2), this.f27816f) + n);
                    i = l * 2;
                } else {
                    if (!TextUtils.isEmpty(this.f27812b) && TextUtils.equals((CharSequence) c.a.a0.x.a.d(this.f27817g, i2), this.k)) {
                        i = this.i - measuredWidth;
                        float h3 = h((String) c.a.a0.x.a.d(this.f27817g, i2), this.f27815e) + n;
                        float f2 = i;
                        if (f2 > h3) {
                            h2 = measuredWidth + h3;
                        } else {
                            String b2 = t.b(this.f27814d, this.f27812b, f2, this.f27815e);
                            this.k = b2;
                            c.a.a0.x.a.a(this.f27817g, b2, i2);
                        }
                    } else {
                        h2 = measuredWidth + h((String) c.a.a0.x.a.d(this.f27817g, i2), this.f27815e) + n;
                    }
                    measuredWidth = (int) h2;
                    if (measuredWidth <= this.i) {
                        break;
                    }
                    i2++;
                }
                measuredWidth += i;
                if (measuredWidth <= this.i) {
                }
            }
            this.f27818h = i2;
        }
    }

    public final void c(Canvas canvas) {
        float f2;
        float h2;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            int min = Math.min(this.f27818h, this.f27817g.size());
            int i3 = 0;
            for (int i4 = 0; i4 < min; i4++) {
                int measuredHeight = getMeasuredHeight();
                if (TextUtils.equals((CharSequence) c.a.a0.x.a.d(this.f27817g, i4), this.f27813c)) {
                    canvas.drawText(this.f27813c, l + i3, ((((measuredHeight - i2) / 2.0f) + (t / 2.0f)) - ((this.f27816f.getFontMetrics().top + this.f27816f.getFontMetrics().bottom) / 2.0f)) - 1.0f, this.f27816f);
                    f2 = i3;
                    h2 = h(this.f27813c, this.f27816f) + l;
                    i = n;
                } else {
                    String str = (String) c.a.a0.x.a.d(this.f27817g, i4);
                    if (!TextUtils.isEmpty(str)) {
                        f2 = i3;
                        canvas.drawText(str, f2, f(this.f27815e, measuredHeight), this.f27815e);
                        h2 = h(str, this.f27815e);
                        i = n;
                    }
                }
                i3 = (int) (f2 + h2 + i);
            }
        }
    }

    public final float f(TextPaint textPaint, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, textPaint, i)) == null) ? ((i - g(textPaint)) / 2.0f) - textPaint.getFontMetrics().top : invokeLI.floatValue;
    }

    public final float g(TextPaint textPaint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, textPaint)) == null) ? textPaint.getFontMetrics().bottom - textPaint.getFontMetrics().top : invokeL.floatValue;
    }

    public final float h(String str, TextPaint textPaint) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, textPaint)) == null) ? textPaint.measureText(str) : invokeLL.floatValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AdImageView adImageView = new AdImageView(getContext());
            this.a = adImageView;
            adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.a.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080dd8));
            this.a.setId(R.id.obfuscated_res_0x7f0914a2);
            this.a.setContentDescription("不感兴趣");
            t.a(getContext(), this.a, 15.0f);
            setWillNotDraw(false);
            TextPaint textPaint = new TextPaint();
            this.f27815e = textPaint;
            textPaint.setAntiAlias(true);
            this.f27815e.setTextSize(r);
            this.f27815e.setColor(u);
            TextPaint textPaint2 = new TextPaint();
            this.f27816f = textPaint2;
            textPaint2.setAntiAlias(true);
            this.f27816f.setTextSize(s);
            this.f27816f.setColor(v);
            addView(this.a);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f27817g.clear();
            if (!TextUtils.isEmpty(this.f27813c)) {
                String a = a(this.f27813c, q, this.f27816f);
                this.f27813c = a;
                c.a.a0.x.a.b(this.f27817g, a);
            }
            if (!TextUtils.isEmpty(this.f27812b)) {
                String b2 = t.b(this.f27814d, this.f27812b, p, this.f27815e);
                this.k = b2;
                c.a.a0.x.a.b(this.f27817g, b2);
            } else if (TextUtils.isEmpty(this.f27814d)) {
            } else {
                String a2 = a(this.f27814d, o, this.f27815e);
                this.f27814d = a2;
                c.a.a0.x.a.b(this.f27817g, a2);
            }
        }
    }

    public final void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt != null && childAt.getVisibility() != 8) {
                    measureChild(childAt, i, i2);
                    if (childAt.getMeasuredHeight() > this.j) {
                        this.j = childAt.getMeasuredHeight();
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onAttachedToWindow();
            t.a(getContext(), this.a, 15.0f);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.save();
            c(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            b();
            int i5 = i3 - i;
            if (this.a.getVisibility() != 8) {
                int measuredHeight = this.a.getMeasuredHeight();
                int measuredWidth = this.a.getMeasuredWidth();
                int i6 = ((i4 - i2) - measuredHeight) / 2;
                int i7 = (i5 - m) - measuredWidth;
                this.a.layout(i7, i6, measuredWidth + i7, measuredHeight + i6);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            this.i = View.MeasureSpec.getSize(i);
            k(i, i2);
            setMeasuredDimension(this.i, this.j);
        }
    }

    public void setNeedShowUnlikeIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.a.setVisibility(z ? 0 : 4);
            this.a.setClickable(z);
        }
    }

    public void update(AdBaseModel adBaseModel) {
        s.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, adBaseModel) == null) || adBaseModel == null) {
            return;
        }
        i iVar = adBaseModel.f27543f;
        this.f27812b = iVar.f1553h;
        this.f27814d = iVar.f1550e;
        this.f27813c = iVar.i;
        setNeedShowUnlikeIcon(true);
        j();
        this.j = s;
        s sVar = adBaseModel.p;
        if (sVar != null && (aVar = sVar.j) != null) {
            int i = aVar.f1581f;
            int i2 = aVar.f1582g;
            int i3 = aVar.i;
            if (i != 0) {
                this.f27815e.setTextSize(e(i));
                this.j = e(i);
            }
            if (i2 != 0) {
                this.f27815e.setColor(d(i2));
            }
            if (i3 != 0) {
                this.a.setImageDrawable(getResources().getDrawable(i3));
            }
        }
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NadExpressBottomView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadExpressBottomView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f27817g = new ArrayList<>(4);
        this.f27818h = 0;
        this.i = 0;
        this.j = s;
        i();
    }
}
