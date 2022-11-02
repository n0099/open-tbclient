package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.wi;
import com.baidu.tieba.xi;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MessageRedDotView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable a;
    public int b;
    public boolean c;
    public String d;
    public int e;
    public Paint f;
    public Rect g;
    public int h;
    public int i;
    public Paint j;
    public int k;
    public int l;
    public int m;
    public RectF n;
    public int o;
    public int p;
    public int q;
    public int r;
    public Paint s;
    public RectF t;
    public boolean u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRedDotView(@NonNull Context context) {
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
        this.e = 1;
        this.u = false;
        this.v = false;
        this.x = 3;
        this.y = 0;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.e = 1;
        this.u = false;
        this.v = false;
        this.x = 3;
        this.y = 0;
        d();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            Drawable drawable = this.a;
            if (drawable != null) {
                if (this.u && this.z) {
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.a.getIntrinsicHeight();
                    int g = xi.g(getContext(), R.dimen.tbds4);
                    setMeasuredDimension(intrinsicWidth + g, intrinsicHeight + g);
                    return;
                }
                int i4 = this.k;
                int i5 = this.l;
                if (i4 >= i5) {
                    i3 = this.m + i4;
                } else {
                    i3 = i5 + this.m;
                }
                this.o = i3;
                setMeasuredDimension(this.a.getIntrinsicWidth() + (this.o * 2), this.a.getIntrinsicHeight() + (this.o * 2));
                return;
            }
            setMeasuredDimension(0, 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.e = 1;
        this.u = false;
        this.v = false;
        this.x = 3;
        this.y = 0;
        d();
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) && !wi.isEmpty(this.d) && this.a != null) {
            Paint paint = this.f;
            String str = this.d;
            paint.getTextBounds(str, 0, str.length(), this.g);
            Paint.FontMetrics fontMetrics = this.f.getFontMetrics();
            int intrinsicWidth = (this.a.getIntrinsicWidth() / 2) + this.o + (this.y / 2);
            float height = (((getHeight() - getPaddingBottom()) + getPaddingTop()) / 2.0f) - this.g.centerY();
            if (this.u) {
                Rect bounds = this.a.getBounds();
                float f = fontMetrics.descent;
                float height2 = this.w + ((bounds.height() / 2) - (f - (((-fontMetrics.ascent) + f) / 2.0f)));
                intrinsicWidth = bounds.width() / 2;
                height = height2;
            }
            canvas.drawText(this.d, intrinsicWidth, height, this.f);
        }
    }

    public final void b(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) != null) || (drawable = this.a) == null) {
            return;
        }
        int intrinsicWidth = (drawable.getIntrinsicWidth() / 2) + this.o;
        int intrinsicHeight = (this.a.getIntrinsicHeight() / 2) + this.o;
        if (this.u) {
            Rect bounds = this.a.getBounds();
            int width = bounds.width() / 2;
            intrinsicHeight = bounds.height() / 2;
            intrinsicWidth = width;
        }
        int i3 = this.q;
        float f = intrinsicHeight - (i3 / 2);
        float f2 = intrinsicHeight + (i3 / 2);
        this.t.set(intrinsicWidth - (i3 / 2), f, intrinsicWidth + (i3 / 2), f2);
        canvas.drawOval(this.t, this.s);
        RectF rectF = this.t;
        int i4 = this.r;
        rectF.set((i - i4) - this.q, f, i - i4, f2);
        canvas.drawOval(this.t, this.s);
        RectF rectF2 = this.t;
        int i5 = this.r;
        rectF2.set(i2 + i5, f, i2 + i5 + this.q, f2);
        canvas.drawOval(this.t, this.s);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String g = zi.g();
            if (g.contains("vivo") && g.contains("X20")) {
                xi.g(getContext(), R.dimen.tbds2);
            }
        }
    }

    public String getRedNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setLayerType(1, null);
            c();
            Paint paint = new Paint(1);
            this.f = paint;
            paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
            if (!this.u && this.v) {
                this.f.setTextSize(xi.g(getContext(), R.dimen.tbfontsize26));
                this.f.setTypeface(Typeface.MONOSPACE);
            } else {
                this.f.setTextSize(xi.g(getContext(), R.dimen.tbfontsize28));
                this.f.setTypeface(Typeface.DEFAULT_BOLD);
            }
            this.f.setTextAlign(Paint.Align.CENTER);
            this.g = new Rect();
            this.h = xi.g(getContext(), R.dimen.tbds13);
            this.i = xi.g(getContext(), R.dimen.tbds42);
            Paint paint2 = new Paint();
            this.j = paint2;
            paint2.setAntiAlias(true);
            this.j.setStyle(Paint.Style.FILL);
            this.j.setColor(SkinManager.getColor(R.color.transparent));
            this.k = 0;
            this.m = xi.g(getContext(), R.dimen.tbds8);
            int g = xi.g(getContext(), R.dimen.tbds3);
            this.l = g;
            this.j.setShadowLayer(this.m, this.k, g, SkinManager.getColor(R.color.cp_cont_h_alpha66));
            this.n = new RectF();
            this.p = xi.g(getContext(), R.dimen.tbds21);
            this.q = xi.g(getContext(), R.dimen.tbds8);
            this.r = xi.g(getContext(), R.dimen.tbds6);
            Paint paint3 = new Paint();
            this.s = paint3;
            paint3.setAntiAlias(true);
            this.s.setStyle(Paint.Style.FILL);
            this.s.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.t = new RectF();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.x = TbadkApplication.getInst().getSkinType();
            int i = this.b;
            if (i > 0) {
                this.a = SkinManager.getDrawable(i);
            } else {
                Drawable drawable = this.a;
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setColor(SkinManager.getColor(R.color.CAM_X0301));
                }
            }
            this.s.setColor(SkinManager.getColor(R.color.CAM_X0101));
            Paint paint = this.f;
            if (paint != null) {
                paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
            }
            this.j.setShadowLayer(this.m, this.k, this.l, SkinManager.getColor(R.color.cp_cont_h_alpha66));
            if (this.c) {
                this.c = false;
                requestLayout();
            }
            invalidate();
        }
    }

    @Deprecated
    public void f(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i <= 0) {
                i2 = R.drawable.icon_news_red_dot;
                this.d = null;
            } else if (i < 10) {
                this.d = String.valueOf(i);
                i2 = R.drawable.icon_news_red_dot_one_number;
            } else if (i < 100) {
                this.d = String.valueOf(i);
                i2 = R.drawable.icon_news_red_dot_two_number;
            } else {
                int i3 = this.e;
                if (i3 == 1) {
                    this.d = StringHelper.STRING_MORE;
                    i2 = R.drawable.icon_news_red_dot_three_dot_number;
                } else if (i3 == 2) {
                    this.d = "99+";
                    i2 = R.drawable.icon_news_red_dot_three_number;
                } else {
                    i2 = 0;
                }
            }
            if (i2 != this.b) {
                this.c = true;
            } else {
                this.c = false;
            }
            this.b = i2;
            e();
        }
    }

    public void g(String str, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) {
            if (z) {
                this.d = StringHelper.STRING_MORE;
                i = R.drawable.icon_news_red_dot_three_dot_number;
            } else if (wi.isEmpty(str)) {
                i = R.drawable.icon_news_red_dot;
                this.d = null;
            } else {
                int measureText = (int) this.f.measureText(str);
                Drawable drawable = this.a;
                if (drawable != null && drawable.getIntrinsicWidth() - (this.h * 2) == measureText) {
                    if (this.x != TbadkApplication.getInst().getSkinType()) {
                        Drawable drawable2 = this.a;
                        if (drawable2 instanceof GradientDrawable) {
                            ((GradientDrawable) drawable2).setColor(SkinManager.getColor(R.color.CAM_X0301));
                            this.c = false;
                        }
                    }
                } else {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    gradientDrawable.setCornerRadius(this.p);
                    gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0301));
                    gradientDrawable.setSize(((int) this.f.measureText(str)) + (this.h * 2), this.i);
                    this.a = gradientDrawable;
                    this.c = true;
                }
                this.d = str;
                this.b = 0;
                e();
                return;
            }
            if (i != this.b) {
                this.c = true;
            } else {
                this.c = false;
            }
            this.b = i;
            e();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            Drawable drawable = this.a;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.a.getIntrinsicHeight();
                if (this.u) {
                    this.a.setBounds(0, this.w, xi.g(getContext(), R.dimen.tbds4) + intrinsicWidth, xi.g(getContext(), R.dimen.tbds4) + intrinsicHeight + this.w);
                } else {
                    Drawable drawable2 = this.a;
                    int i = this.o;
                    int i2 = this.y;
                    drawable2.setBounds(i, i - (i2 / 2), intrinsicWidth + i + i2, intrinsicHeight + i + (i2 / 2));
                }
                this.a.draw(canvas);
                if (!this.u && this.v) {
                    RectF rectF = this.n;
                    int i3 = this.o;
                    rectF.set(i3, i3, intrinsicWidth + i3, i3 + intrinsicHeight);
                    if (intrinsicWidth != intrinsicHeight) {
                        RectF rectF2 = this.n;
                        int i4 = this.p;
                        canvas.drawRoundRect(rectF2, i4, i4, this.j);
                    } else {
                        canvas.drawOval(this.n, this.j);
                    }
                }
                if (!wi.isEmpty(this.d)) {
                    if (this.d.equals(StringHelper.STRING_MORE)) {
                        b(canvas);
                    } else {
                        a(canvas);
                    }
                }
            }
        }
    }

    public void setEnterForumStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.u = z;
        }
    }

    public void setExtendSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.y = i;
        }
    }

    public void setFixMeasuredWidthHeight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.z = z;
        }
    }

    public void setShadowEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.v = z;
        }
    }

    public void setTextBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f.setFakeBoldText(z);
        }
    }

    public void setTextPaddingTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.w = i;
        }
    }

    public void setTextSize(@IdRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f.setTextSize(xi.g(getContext(), i));
        }
    }

    public void setTextTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, typeface) == null) {
            this.f.setTypeface(typeface);
        }
    }

    public void setThreeDotMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.e = i;
        }
    }
}
