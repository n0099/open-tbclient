package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
/* loaded from: classes3.dex */
public class MessageRedDotView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f12493e;

    /* renamed from: f  reason: collision with root package name */
    public int f12494f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12495g;

    /* renamed from: h  reason: collision with root package name */
    public String f12496h;

    /* renamed from: i  reason: collision with root package name */
    public int f12497i;
    public Paint j;
    public Rect k;
    public int l;
    public int m;
    public Paint n;
    public int o;
    public int p;
    public int q;
    public RectF r;
    public int s;
    public int t;
    public int u;
    public int v;
    public Paint w;
    public RectF x;
    public boolean y;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12497i = 1;
        this.y = false;
        this.z = false;
        this.B = 3;
        d();
    }

    private float getYOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (Build.VERSION.SDK_INT > 29) {
                return getResources().getDimension(R.dimen.tbds5);
            }
            return getResources().getDimension(R.dimen.tbds10);
        }
        return invokeV.floatValue;
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || k.isEmpty(this.f12496h) || this.f12493e == null) {
            return;
        }
        Paint paint = this.j;
        String str = this.f12496h;
        paint.getTextBounds(str, 0, str.length(), this.k);
        Paint.FontMetrics fontMetrics = this.j.getFontMetrics();
        int intrinsicWidth = (this.f12493e.getIntrinsicWidth() / 2) + this.s;
        float yOffset = (getYOffset() + fontMetrics.bottom) - fontMetrics.ascent;
        if (this.y) {
            Rect bounds = this.f12493e.getBounds();
            float f2 = fontMetrics.descent;
            float height = this.A + ((bounds.height() / 2) - (f2 - (((-fontMetrics.ascent) + f2) / 2.0f)));
            intrinsicWidth = bounds.width() / 2;
            yOffset = height;
        }
        canvas.drawText(this.f12496h, intrinsicWidth, yOffset, this.j);
    }

    public final void b(Canvas canvas) {
        Drawable drawable;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || (drawable = this.f12493e) == null) {
            return;
        }
        int intrinsicWidth = (drawable.getIntrinsicWidth() / 2) + this.s;
        int intrinsicHeight = (this.f12493e.getIntrinsicHeight() / 2) + this.s;
        if (this.y) {
            Rect bounds = this.f12493e.getBounds();
            int width = bounds.width() / 2;
            intrinsicHeight = bounds.height() / 2;
            intrinsicWidth = width;
        }
        int i4 = this.u;
        float f2 = intrinsicHeight - (i4 / 2);
        float f3 = intrinsicHeight + (i4 / 2);
        this.x.set(intrinsicWidth - (i4 / 2), f2, intrinsicWidth + (i4 / 2), f3);
        canvas.drawOval(this.x, this.w);
        RectF rectF = this.x;
        int i5 = this.v;
        rectF.set((i2 - i5) - this.u, f2, i2 - i5, f3);
        canvas.drawOval(this.x, this.w);
        RectF rectF2 = this.x;
        int i6 = this.v;
        rectF2.set(i3 + i6, f2, i3 + i6 + this.u, f3);
        canvas.drawOval(this.x, this.w);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String str = Build.MODEL;
            if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
                l.g(getContext(), R.dimen.tbds2);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setLayerType(1, null);
            c();
            Paint paint = new Paint(1);
            this.j = paint;
            paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
            if (!this.y && this.z) {
                this.j.setTextSize(l.g(getContext(), R.dimen.tbfontsize26));
                this.j.setTypeface(Typeface.MONOSPACE);
            } else {
                this.j.setTextSize(l.g(getContext(), R.dimen.tbfontsize28));
                this.j.setTypeface(Typeface.DEFAULT_BOLD);
            }
            this.j.setTextAlign(Paint.Align.CENTER);
            this.k = new Rect();
            this.l = l.g(getContext(), R.dimen.tbds13);
            this.m = l.g(getContext(), R.dimen.tbds42);
            Paint paint2 = new Paint();
            this.n = paint2;
            paint2.setAntiAlias(true);
            this.n.setStyle(Paint.Style.FILL);
            this.n.setColor(SkinManager.getColor(R.color.transparent));
            this.o = 0;
            this.q = l.g(getContext(), R.dimen.tbds8);
            int g2 = l.g(getContext(), R.dimen.tbds3);
            this.p = g2;
            this.n.setShadowLayer(this.q, this.o, g2, SkinManager.getColor(R.color.cp_cont_h_alpha66));
            this.r = new RectF();
            this.t = l.g(getContext(), R.dimen.tbds21);
            this.u = l.g(getContext(), R.dimen.tbds8);
            this.v = l.g(getContext(), R.dimen.tbds6);
            Paint paint3 = new Paint();
            this.w = paint3;
            paint3.setAntiAlias(true);
            this.w.setStyle(Paint.Style.FILL);
            this.w.setColor(SkinManager.getColor(R.color.CAM_X0101));
            this.x = new RectF();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.B = TbadkApplication.getInst().getSkinType();
            int i2 = this.f12494f;
            if (i2 > 0) {
                this.f12493e = SkinManager.getDrawable(i2);
            } else {
                Drawable drawable = this.f12493e;
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setColor(SkinManager.getColor(R.color.CAM_X0301));
                }
            }
            this.w.setColor(SkinManager.getColor(R.color.CAM_X0101));
            Paint paint = this.j;
            if (paint != null) {
                paint.setColor(SkinManager.getColor(R.color.CAM_X0101));
            }
            this.n.setShadowLayer(this.q, this.o, this.p, SkinManager.getColor(R.color.cp_cont_h_alpha66));
            if (this.f12495g) {
                this.f12495g = false;
                requestLayout();
            }
            invalidate();
        }
    }

    @Deprecated
    public void f(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 <= 0) {
                i3 = R.drawable.icon_news_red_dot;
                this.f12496h = null;
            } else if (i2 < 10) {
                this.f12496h = String.valueOf(i2);
                i3 = R.drawable.icon_news_red_dot_one_number;
            } else if (i2 < 100) {
                this.f12496h = String.valueOf(i2);
                i3 = R.drawable.icon_news_red_dot_two_number;
            } else {
                int i4 = this.f12497i;
                if (i4 == 1) {
                    this.f12496h = StringHelper.STRING_MORE;
                    i3 = R.drawable.icon_news_red_dot_three_dot_number;
                } else if (i4 == 2) {
                    this.f12496h = "99+";
                    i3 = R.drawable.icon_news_red_dot_three_number;
                } else {
                    i3 = 0;
                }
            }
            if (i3 != this.f12494f) {
                this.f12495g = true;
            } else {
                this.f12495g = false;
            }
            this.f12494f = i3;
            e();
        }
    }

    public void g(String str, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) {
            if (z) {
                this.f12496h = StringHelper.STRING_MORE;
                i2 = R.drawable.icon_news_red_dot_three_dot_number;
            } else if (k.isEmpty(str)) {
                i2 = R.drawable.icon_news_red_dot;
                this.f12496h = null;
            } else {
                int measureText = (int) this.j.measureText(str);
                Drawable drawable = this.f12493e;
                if (drawable != null && drawable.getIntrinsicWidth() - (this.l * 2) == measureText) {
                    if (this.B != TbadkApplication.getInst().getSkinType()) {
                        Drawable drawable2 = this.f12493e;
                        if (drawable2 instanceof GradientDrawable) {
                            ((GradientDrawable) drawable2).setColor(SkinManager.getColor(R.color.CAM_X0301));
                            this.f12495g = false;
                        }
                    }
                } else {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    gradientDrawable.setCornerRadius(this.t);
                    gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0301));
                    gradientDrawable.setSize(((int) this.j.measureText(str)) + (this.l * 2), this.m);
                    this.f12493e = gradientDrawable;
                    this.f12495g = true;
                }
                this.f12496h = str;
                this.f12494f = 0;
                e();
                return;
            }
            if (i2 != this.f12494f) {
                this.f12495g = true;
            } else {
                this.f12495g = false;
            }
            this.f12494f = i2;
            e();
        }
    }

    public String getRedNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12496h : (String) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            Drawable drawable = this.f12493e;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.f12493e.getIntrinsicHeight();
                if (this.y) {
                    this.f12493e.setBounds(0, this.A, l.g(getContext(), R.dimen.tbds4) + intrinsicWidth, l.g(getContext(), R.dimen.tbds4) + intrinsicHeight + this.A);
                } else {
                    Drawable drawable2 = this.f12493e;
                    int i2 = this.s;
                    drawable2.setBounds(i2, i2, intrinsicWidth + i2, intrinsicHeight + i2);
                }
                this.f12493e.draw(canvas);
                if (!this.y && this.z) {
                    RectF rectF = this.r;
                    int i3 = this.s;
                    rectF.set(i3, i3, intrinsicWidth + i3, i3 + intrinsicHeight);
                    if (intrinsicWidth != intrinsicHeight) {
                        RectF rectF2 = this.r;
                        int i4 = this.t;
                        canvas.drawRoundRect(rectF2, i4, i4, this.n);
                    } else {
                        canvas.drawOval(this.r, this.n);
                    }
                }
                if (k.isEmpty(this.f12496h)) {
                    return;
                }
                if (this.f12496h.equals(StringHelper.STRING_MORE)) {
                    b(canvas);
                } else {
                    a(canvas);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            if (this.f12493e != null) {
                int i4 = this.o;
                int i5 = this.p;
                this.s = i4 >= i5 ? this.q + i4 : i5 + this.q;
                setMeasuredDimension(this.f12493e.getIntrinsicWidth() + (this.s * 2), this.f12493e.getIntrinsicHeight() + (this.s * 2));
                return;
            }
            setMeasuredDimension(0, 0);
        }
    }

    public void setEnterForumStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.y = z;
        }
    }

    public void setShadowEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.z = z;
        }
    }

    public void setTextPaddingTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.A = i2;
        }
    }

    public void setTextTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, typeface) == null) {
            this.j.setTypeface(typeface);
        }
    }

    public void setThreeDotMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f12497i = i2;
        }
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
        this.f12497i = 1;
        this.y = false;
        this.z = false;
        this.B = 3;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f12497i = 1;
        this.y = false;
        this.z = false;
        this.B = 3;
        d();
    }
}
