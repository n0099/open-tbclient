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
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class MessageRedDotView extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String THREE_DOT_STR = "...";
    public static final int TYPE_PLUS = 2;
    public static final int TYPE_THREE_DOT = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public boolean D;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f40628e;

    /* renamed from: f  reason: collision with root package name */
    public int f40629f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40630g;

    /* renamed from: h  reason: collision with root package name */
    public String f40631h;

    /* renamed from: i  reason: collision with root package name */
    public int f40632i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f40633j;
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
        this.f40632i = 1;
        this.y = false;
        this.z = false;
        this.B = 3;
        this.C = 0;
        d();
    }

    private float getYOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (Build.VERSION.SDK_INT > 29) {
                return getResources().getDimension(e.tbds5);
            }
            return getResources().getDimension(e.tbds10);
        }
        return invokeV.floatValue;
    }

    public final void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || m.isEmpty(this.f40631h) || this.f40628e == null) {
            return;
        }
        Paint paint = this.f40633j;
        String str = this.f40631h;
        paint.getTextBounds(str, 0, str.length(), this.k);
        Paint.FontMetrics fontMetrics = this.f40633j.getFontMetrics();
        int intrinsicWidth = (this.f40628e.getIntrinsicWidth() / 2) + this.s + (this.C / 2);
        float yOffset = ((getYOffset() + fontMetrics.bottom) - fontMetrics.ascent) - this.C;
        if (this.y) {
            Rect bounds = this.f40628e.getBounds();
            float f2 = fontMetrics.descent;
            float height = this.A + ((bounds.height() / 2) - (f2 - (((-fontMetrics.ascent) + f2) / 2.0f)));
            intrinsicWidth = bounds.width() / 2;
            yOffset = height;
        }
        canvas.drawText(this.f40631h, intrinsicWidth, yOffset, this.f40633j);
    }

    public final void b(Canvas canvas) {
        Drawable drawable;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || (drawable = this.f40628e) == null) {
            return;
        }
        int intrinsicWidth = (drawable.getIntrinsicWidth() / 2) + this.s;
        int intrinsicHeight = (this.f40628e.getIntrinsicHeight() / 2) + this.s;
        if (this.y) {
            Rect bounds = this.f40628e.getBounds();
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
                n.f(getContext(), e.tbds2);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setLayerType(1, null);
            c();
            Paint paint = new Paint(1);
            this.f40633j = paint;
            paint.setColor(SkinManager.getColor(d.CAM_X0101));
            if (!this.y && this.z) {
                this.f40633j.setTextSize(n.f(getContext(), e.tbfontsize26));
                this.f40633j.setTypeface(Typeface.MONOSPACE);
            } else {
                this.f40633j.setTextSize(n.f(getContext(), e.tbfontsize28));
                this.f40633j.setTypeface(Typeface.DEFAULT_BOLD);
            }
            this.f40633j.setTextAlign(Paint.Align.CENTER);
            this.k = new Rect();
            this.l = n.f(getContext(), e.tbds13);
            this.m = n.f(getContext(), e.tbds42);
            Paint paint2 = new Paint();
            this.n = paint2;
            paint2.setAntiAlias(true);
            this.n.setStyle(Paint.Style.FILL);
            this.n.setColor(SkinManager.getColor(d.transparent));
            this.o = 0;
            this.q = n.f(getContext(), e.tbds8);
            int f2 = n.f(getContext(), e.tbds3);
            this.p = f2;
            this.n.setShadowLayer(this.q, this.o, f2, SkinManager.getColor(d.cp_cont_h_alpha66));
            this.r = new RectF();
            this.t = n.f(getContext(), e.tbds21);
            this.u = n.f(getContext(), e.tbds8);
            this.v = n.f(getContext(), e.tbds6);
            Paint paint3 = new Paint();
            this.w = paint3;
            paint3.setAntiAlias(true);
            this.w.setStyle(Paint.Style.FILL);
            this.w.setColor(SkinManager.getColor(d.CAM_X0101));
            this.x = new RectF();
        }
    }

    public String getRedNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40631h : (String) invokeV.objValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.B = TbadkApplication.getInst().getSkinType();
            int i2 = this.f40629f;
            if (i2 > 0) {
                this.f40628e = SkinManager.getDrawable(i2);
            } else {
                Drawable drawable = this.f40628e;
                if (drawable instanceof GradientDrawable) {
                    ((GradientDrawable) drawable).setColor(SkinManager.getColor(d.CAM_X0301));
                }
            }
            this.w.setColor(SkinManager.getColor(d.CAM_X0101));
            Paint paint = this.f40633j;
            if (paint != null) {
                paint.setColor(SkinManager.getColor(d.CAM_X0101));
            }
            this.n.setShadowLayer(this.q, this.o, this.p, SkinManager.getColor(d.cp_cont_h_alpha66));
            if (this.f40630g) {
                this.f40630g = false;
                requestLayout();
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.onDraw(canvas);
            Drawable drawable = this.f40628e;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.f40628e.getIntrinsicHeight();
                if (this.y) {
                    this.f40628e.setBounds(0, this.A, n.f(getContext(), e.tbds4) + intrinsicWidth, n.f(getContext(), e.tbds4) + intrinsicHeight + this.A);
                } else {
                    Drawable drawable2 = this.f40628e;
                    int i2 = this.s;
                    int i3 = this.C;
                    drawable2.setBounds(i2, i2 - (i3 / 2), intrinsicWidth + i2 + i3, intrinsicHeight + i2 + (i3 / 2));
                }
                this.f40628e.draw(canvas);
                if (!this.y && this.z) {
                    RectF rectF = this.r;
                    int i4 = this.s;
                    rectF.set(i4, i4, intrinsicWidth + i4, i4 + intrinsicHeight);
                    if (intrinsicWidth != intrinsicHeight) {
                        RectF rectF2 = this.r;
                        int i5 = this.t;
                        canvas.drawRoundRect(rectF2, i5, i5, this.n);
                    } else {
                        canvas.drawOval(this.r, this.n);
                    }
                }
                if (m.isEmpty(this.f40631h)) {
                    return;
                }
                if (this.f40631h.equals("...")) {
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
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            Drawable drawable = this.f40628e;
            if (drawable != null) {
                if (this.y && this.D) {
                    int intrinsicWidth = drawable.getIntrinsicWidth();
                    int intrinsicHeight = this.f40628e.getIntrinsicHeight();
                    int f2 = n.f(getContext(), e.tbds4);
                    setMeasuredDimension(intrinsicWidth + f2, intrinsicHeight + f2);
                    return;
                }
                int i4 = this.o;
                int i5 = this.p;
                this.s = i4 >= i5 ? this.q + i4 : i5 + this.q;
                setMeasuredDimension(this.f40628e.getIntrinsicWidth() + (this.s * 2), this.f40628e.getIntrinsicHeight() + (this.s * 2));
                return;
            }
            setMeasuredDimension(0, 0);
        }
    }

    @Deprecated
    public void refresh(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            if (i2 <= 0) {
                i3 = f.icon_news_red_dot;
                this.f40631h = null;
            } else if (i2 < 10) {
                this.f40631h = String.valueOf(i2);
                i3 = f.icon_news_red_dot_one_number;
            } else if (i2 < 100) {
                this.f40631h = String.valueOf(i2);
                i3 = f.icon_news_red_dot_two_number;
            } else {
                int i4 = this.f40632i;
                if (i4 == 1) {
                    this.f40631h = "...";
                    i3 = f.icon_news_red_dot_three_dot_number;
                } else if (i4 == 2) {
                    this.f40631h = "99+";
                    i3 = f.icon_news_red_dot_three_number;
                } else {
                    i3 = 0;
                }
            }
            if (i3 != this.f40629f) {
                this.f40630g = true;
            } else {
                this.f40630g = false;
            }
            this.f40629f = i3;
            onChangeSkinType();
        }
    }

    public void setEnterForumStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.y = z;
        }
    }

    public void setExtendSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.C = i2;
        }
    }

    public void setFixMeasuredWidthHeight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.D = z;
        }
    }

    public void setShadowEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.z = z;
        }
    }

    public void setTextBold(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f40633j.setFakeBoldText(z);
        }
    }

    public void setTextPaddingTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.A = i2;
        }
    }

    public void setTextSize(@IdRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.f40633j.setTextSize(n.f(getContext(), i2));
        }
    }

    public void setTextTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, typeface) == null) {
            this.f40633j.setTypeface(typeface);
        }
    }

    public void setThreeDotMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f40632i = i2;
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
        this.f40632i = 1;
        this.y = false;
        this.z = false;
        this.B = 3;
        this.C = 0;
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
        this.f40632i = 1;
        this.y = false;
        this.z = false;
        this.B = 3;
        this.C = 0;
        d();
    }

    public void refresh(String str, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) {
            if (z) {
                this.f40631h = "...";
                i2 = f.icon_news_red_dot_three_dot_number;
            } else if (m.isEmpty(str)) {
                i2 = f.icon_news_red_dot;
                this.f40631h = null;
            } else {
                int measureText = (int) this.f40633j.measureText(str);
                Drawable drawable = this.f40628e;
                if (drawable != null && drawable.getIntrinsicWidth() - (this.l * 2) == measureText) {
                    if (this.B != TbadkApplication.getInst().getSkinType()) {
                        Drawable drawable2 = this.f40628e;
                        if (drawable2 instanceof GradientDrawable) {
                            ((GradientDrawable) drawable2).setColor(SkinManager.getColor(d.CAM_X0301));
                            this.f40630g = false;
                        }
                    }
                } else {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    gradientDrawable.setCornerRadius(this.t);
                    gradientDrawable.setColor(SkinManager.getColor(d.CAM_X0301));
                    gradientDrawable.setSize(((int) this.f40633j.measureText(str)) + (this.l * 2), this.m);
                    this.f40628e = gradientDrawable;
                    this.f40630g = true;
                }
                this.f40631h = str;
                this.f40629f = 0;
                onChangeSkinType();
                return;
            }
            if (i2 != this.f40629f) {
                this.f40630g = true;
            } else {
                this.f40630g = false;
            }
            this.f40629f = i2;
            onChangeSkinType();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f40632i = 1;
        this.y = false;
        this.z = false;
        this.B = 3;
        this.C = 0;
        d();
    }
}
