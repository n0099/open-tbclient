package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class DrawableCenterTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GradientDrawable a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f29096b;

    /* renamed from: c  reason: collision with root package name */
    public Pair<Object, Object> f29097c;

    /* renamed from: d  reason: collision with root package name */
    public Object f29098d;

    /* renamed from: e  reason: collision with root package name */
    public Object f29099e;

    /* renamed from: f  reason: collision with root package name */
    public int f29100f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29101g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29102h;
    public boolean i;
    public boolean j;
    public float k;
    public float l;
    public boolean m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DrawableCenterTextView(Context context) {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null) {
            return;
        }
        int[] iArr = {getWidth(), getHeight()};
        if (this.m) {
            iArr[0] = (int) (getWidth() * this.l);
            iArr[1] = getHeight();
        }
        int width = getWidth() / 2;
        this.a.setBounds(width - (iArr[0] / 2), 0, width + (iArr[0] / 2), getHeight());
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.k = i;
        }
    }

    public void c(Drawable drawable, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, drawable, i, i2, i3) == null) || drawable == null || i <= -1 || i > 3) {
            return;
        }
        if (i2 <= 0 || i3 <= 0) {
            i2 = drawable.getIntrinsicWidth();
            i3 = drawable.getIntrinsicHeight();
        }
        drawable.setBounds(0, 0, i2, i3);
        if (i == 0) {
            setCompoundDrawables(drawable, null, null, null);
        } else if (i == 1) {
            setCompoundDrawables(null, drawable, null, null);
        } else if (i == 2) {
            setCompoundDrawables(null, null, drawable, null);
        } else if (i != 3) {
        } else {
            setCompoundDrawables(null, null, null, drawable);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f29096b == null) {
            Paint paint = new Paint();
            this.f29096b = paint;
            paint.setColor(0);
            this.f29096b.setStyle(Paint.Style.STROKE);
            this.f29096b.setAntiAlias(true);
            this.f29096b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29101g && this.f29097c != null : invokeV.booleanValue;
    }

    public final void f(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) && e()) {
            float f2 = this.k;
            if (f2 >= 0.0f) {
                this.a.setCornerRadius(f2);
            } else {
                this.a.setCornerRadius(4.0f);
            }
            if (this.f29102h) {
                int f3 = n0.f(getContext(), 0.5f);
                Object obj = this.f29098d;
                if (obj instanceof String) {
                    this.a.setStroke(f3, Color.parseColor(obj.toString()));
                } else if (obj instanceof Integer) {
                    this.a.setStroke(f3, getResources().getColor(Integer.valueOf(this.f29098d.toString()).intValue()));
                }
            }
            if (this.j) {
                Object obj2 = this.f29097c.second;
                if (obj2 instanceof String) {
                    this.a.setColor(Color.parseColor(obj2.toString()));
                } else if (obj2 instanceof Integer) {
                    this.a.setColor(getResources().getColor(Integer.valueOf(this.f29097c.second.toString()).intValue()));
                }
            } else {
                Object obj3 = this.f29097c.first;
                if (obj3 instanceof String) {
                    this.a.setColor(Color.parseColor(obj3.toString()));
                } else if (obj3 instanceof Integer) {
                    this.a.setColor(getResources().getColor(Integer.valueOf(this.f29097c.first.toString()).intValue()));
                }
            }
            canvas.save();
            if (this.m) {
                a();
            } else {
                this.a.setBounds(0, 0, getWidth(), getHeight());
            }
            this.a.draw(canvas);
            if (this.i) {
                g(canvas);
            }
            canvas.restore();
        }
    }

    public final void g(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            float width = getWidth();
            float height = getHeight();
            Paint paint = new Paint();
            paint.setStrokeWidth(n0.f(getContext(), 0.5f));
            Object obj = this.f29099e;
            if (obj instanceof String) {
                paint.setColor(Color.parseColor(obj.toString()));
            } else if (obj instanceof Integer) {
                paint.setColor(getResources().getColor(Integer.valueOf(this.f29099e.toString()).intValue()));
            }
            int i = this.f29100f;
            float f5 = 0.0f;
            if (i == 0) {
                f2 = height;
                f3 = 0.0f;
                f4 = 0.0f;
            } else if (i != 1) {
                if (i == 2) {
                    f4 = width;
                    f2 = height;
                    f5 = getWidth();
                } else if (i != 3) {
                    f4 = width;
                    f2 = height;
                } else {
                    f4 = width;
                    f2 = height;
                    f3 = getHeight();
                }
                f3 = 0.0f;
            } else {
                f4 = width;
                f3 = 0.0f;
                f2 = 0.0f;
            }
            canvas.drawLine(f5, f3, f4, f2, paint);
        }
    }

    public final void h(Canvas canvas) {
        Drawable drawable;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            int i8 = 0;
            if (compoundDrawables != null) {
                i = 0;
                while (i < compoundDrawables.length) {
                    if (compoundDrawables[i] != null) {
                        drawable = compoundDrawables[i];
                        break;
                    }
                    i++;
                }
            }
            drawable = null;
            i = -1;
            int w = n0.w(this);
            int v = n0.v(this);
            int compoundDrawablePadding = getCompoundDrawablePadding();
            if (drawable != null) {
                Rect bounds = drawable.getBounds();
                i2 = bounds.right - bounds.left;
                i3 = bounds.bottom - bounds.top;
            } else {
                i2 = 0;
                i3 = 0;
            }
            if (i == 0 || i == 2) {
                i4 = i2 + w + compoundDrawablePadding;
                i5 = 0;
            } else {
                i5 = (i == 1 || i == 3) ? v + i3 + compoundDrawablePadding : 0;
                i4 = 0;
            }
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            if (i == 0) {
                setGravity(19);
                i6 = width - i4;
            } else {
                if (i == 1) {
                    setGravity(49);
                    i7 = height - i5;
                } else if (i == 2) {
                    setGravity(21);
                    i8 = i4 - width;
                    i7 = 0;
                } else if (i != 3) {
                    setGravity(19);
                    i6 = width - w;
                } else {
                    setGravity(81);
                    i7 = i5 - height;
                }
                canvas.translate(i8 / 2, i7 / 2);
            }
            i8 = i6;
            i7 = 0;
            canvas.translate(i8 / 2, i7 / 2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            f(canvas);
            h(canvas);
            super.onDraw(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 3 && e()) {
                        this.j = false;
                        invalidate();
                    }
                } else if (e()) {
                    this.j = false;
                    invalidate();
                }
            } else if (e()) {
                this.j = true;
                invalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setAnimationModeActive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.m = z;
        }
    }

    public void setAnimationPercent(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048587, this, f2) == null) || this.l == f2) {
            return;
        }
        this.l = f2;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f2, float f3, float f4, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i)}) == null) {
            d();
            RectF rectF = new RectF(f2, f2, f2, f2);
            rectF.offset(f3, f4);
            float f5 = rectF.left;
            int i2 = f5 < 0.0f ? 0 : (int) (f5 + 0.5f);
            float f6 = rectF.right;
            int i3 = f6 < 0.0f ? 0 : (int) (f6 + 0.5f);
            float f7 = rectF.top;
            int i4 = f7 < 0.0f ? 0 : (int) (f7 + 0.5f);
            float f8 = rectF.bottom;
            setPadding(i2, i4, i3, f8 >= 0.0f ? (int) (f8 + 0.5f) : 0);
            this.f29096b.setShadowLayer(f2, f3, f4, i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawableCenterTextView(Context context, AttributeSet attributeSet) {
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
        this.a = new GradientDrawable();
        this.f29096b = null;
        new Path();
        this.f29097c = null;
        this.j = false;
        this.k = -1.0f;
        this.l = 0.0f;
    }
}
