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
import c.a.b0.h.a;
import c.a.b0.h0.f;
import c.a.b0.h0.t;
import c.a.b0.s.i;
import c.a.b0.s.s;
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
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AdImageView f36018e;

    /* renamed from: f  reason: collision with root package name */
    public String f36019f;

    /* renamed from: g  reason: collision with root package name */
    public String f36020g;

    /* renamed from: h  reason: collision with root package name */
    public String f36021h;

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f36022i;

    /* renamed from: j  reason: collision with root package name */
    public TextPaint f36023j;
    public ArrayList<String> k;
    public int l;
    public int m;
    public int n;
    public String o;

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
        p = f.c.a(a.b(), 3.0f);
        q = f.c.a(a.b(), 0.0f);
        r = e(R.dimen.NAD_F_M_W_X007);
        s = e(R.dimen.nad_label_source_max_width);
        t = e(R.dimen.nad_ad_label_source_max_width);
        u = e(R.dimen.nad_label_tag_max_width) - (p * 2);
        v = e(R.dimen.NAD_F_T_X033);
        w = e(R.dimen.NAD_F_T_X033);
        x = e(R.dimen.nad_tag_height);
        y = d(R.color.NAD_FC2);
        z = d(R.color.NAD_FC1);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? ContextCompat.getColor(a.b(), i2) : invokeI.intValue;
    }

    public static int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) ? a.b().getResources().getDimensionPixelSize(i2) : invokeI.intValue;
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i3 = 0;
            int measuredWidth = this.f36018e.getVisibility() != 8 ? this.f36018e.getMeasuredWidth() + q + 0 : 0;
            if (measuredWidth > this.m) {
                this.l = 0;
                return;
            }
            while (i3 < this.k.size()) {
                if (TextUtils.equals((CharSequence) c.a.b0.x.a.d(this.k, i3), this.f36020g)) {
                    measuredWidth = (int) (measuredWidth + h((String) c.a.b0.x.a.d(this.k, i3), this.f36023j) + r);
                    i2 = p * 2;
                } else {
                    if (!TextUtils.isEmpty(this.f36019f) && TextUtils.equals((CharSequence) c.a.b0.x.a.d(this.k, i3), this.o)) {
                        i2 = this.m - measuredWidth;
                        float h3 = h((String) c.a.b0.x.a.d(this.k, i3), this.f36022i) + r;
                        float f2 = i2;
                        if (f2 > h3) {
                            h2 = measuredWidth + h3;
                        } else {
                            String b2 = t.b(this.f36021h, this.f36019f, f2, this.f36022i);
                            this.o = b2;
                            c.a.b0.x.a.a(this.k, b2, i3);
                        }
                    } else {
                        h2 = measuredWidth + h((String) c.a.b0.x.a.d(this.k, i3), this.f36022i) + r;
                    }
                    measuredWidth = (int) h2;
                    if (measuredWidth <= this.m) {
                        break;
                    }
                    i3++;
                }
                measuredWidth += i2;
                if (measuredWidth <= this.m) {
                }
            }
            this.l = i3;
        }
    }

    public final void c(Canvas canvas) {
        float f2;
        float h2;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            int min = Math.min(this.l, this.k.size());
            int i4 = 0;
            for (int i5 = 0; i5 < min; i5++) {
                int measuredHeight = getMeasuredHeight();
                if (TextUtils.equals((CharSequence) c.a.b0.x.a.d(this.k, i5), this.f36020g)) {
                    canvas.drawText(this.f36020g, p + i4, ((((measuredHeight - i3) / 2.0f) + (x / 2.0f)) - ((this.f36023j.getFontMetrics().top + this.f36023j.getFontMetrics().bottom) / 2.0f)) - 1.0f, this.f36023j);
                    f2 = i4;
                    h2 = h(this.f36020g, this.f36023j) + p;
                    i2 = r;
                } else {
                    String str = (String) c.a.b0.x.a.d(this.k, i5);
                    if (!TextUtils.isEmpty(str)) {
                        f2 = i4;
                        canvas.drawText(str, f2, f(this.f36022i, measuredHeight), this.f36022i);
                        h2 = h(str, this.f36022i);
                        i2 = r;
                    }
                }
                i4 = (int) (f2 + h2 + i2);
            }
        }
    }

    public final float f(TextPaint textPaint, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, textPaint, i2)) == null) ? ((i2 - g(textPaint)) / 2.0f) - textPaint.getFontMetrics().top : invokeLI.floatValue;
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
            this.f36018e = adImageView;
            adImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.f36018e.setImageDrawable(getResources().getDrawable(R.drawable.nad_unlike_btn_icon));
            this.f36018e.setId(R.id.nad_base_delete_id);
            this.f36018e.setContentDescription("不感兴趣");
            t.a(getContext(), this.f36018e, 15.0f);
            setWillNotDraw(false);
            TextPaint textPaint = new TextPaint();
            this.f36022i = textPaint;
            textPaint.setAntiAlias(true);
            this.f36022i.setTextSize(v);
            this.f36022i.setColor(y);
            TextPaint textPaint2 = new TextPaint();
            this.f36023j = textPaint2;
            textPaint2.setAntiAlias(true);
            this.f36023j.setTextSize(w);
            this.f36023j.setColor(z);
            addView(this.f36018e);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k.clear();
            if (!TextUtils.isEmpty(this.f36020g)) {
                String a = a(this.f36020g, u, this.f36023j);
                this.f36020g = a;
                c.a.b0.x.a.b(this.k, a);
            }
            if (!TextUtils.isEmpty(this.f36019f)) {
                String b2 = t.b(this.f36021h, this.f36019f, t, this.f36022i);
                this.o = b2;
                c.a.b0.x.a.b(this.k, b2);
            } else if (TextUtils.isEmpty(this.f36021h)) {
            } else {
                String a2 = a(this.f36021h, s, this.f36022i);
                this.f36021h = a2;
                c.a.b0.x.a.b(this.k, a2);
            }
        }
    }

    public final void k(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt != null && childAt.getVisibility() != 8) {
                    measureChild(childAt, i2, i3);
                    if (childAt.getMeasuredHeight() > this.n) {
                        this.n = childAt.getMeasuredHeight();
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
            t.a(getContext(), this.f36018e, 15.0f);
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
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            b();
            int i6 = i4 - i2;
            if (this.f36018e.getVisibility() != 8) {
                int measuredHeight = this.f36018e.getMeasuredHeight();
                int measuredWidth = this.f36018e.getMeasuredWidth();
                int i7 = ((i5 - i3) - measuredHeight) / 2;
                int i8 = (i6 - q) - measuredWidth;
                this.f36018e.layout(i8, i7, measuredWidth + i8, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            this.m = View.MeasureSpec.getSize(i2);
            k(i2, i3);
            setMeasuredDimension(this.m, this.n);
        }
    }

    public void setNeedShowUnlikeIcon(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) {
            this.f36018e.setVisibility(z2 ? 0 : 4);
            this.f36018e.setClickable(z2);
        }
    }

    public void update(AdBaseModel adBaseModel) {
        s.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, adBaseModel) == null) || adBaseModel == null) {
            return;
        }
        i iVar = adBaseModel.f35661f;
        this.f36019f = iVar.f1927h;
        this.f36021h = iVar.f1924e;
        this.f36020g = iVar.f1928i;
        setNeedShowUnlikeIcon(true);
        j();
        this.n = w;
        s sVar = adBaseModel.q;
        if (sVar != null && (aVar = sVar.f1956j) != null) {
            int i2 = aVar.f1961f;
            int i3 = aVar.f1962g;
            int i4 = aVar.f1964i;
            if (i2 != 0) {
                this.f36022i.setTextSize(e(i2));
                this.n = e(i2);
            }
            if (i3 != 0) {
                this.f36022i.setColor(d(i3));
            }
            if (i4 != 0) {
                this.f36018e.setImageDrawable(getResources().getDrawable(i4));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadExpressBottomView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.k = new ArrayList<>(4);
        this.l = 0;
        this.m = 0;
        this.n = w;
        i();
    }
}
