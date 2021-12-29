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
import c.a.r0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes11.dex */
public class DrawableCenterTextView extends TextView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int POSITION_BOTTOM = 3;
    public static final int POSITION_LEFT = 0;
    public static final int POSITION_RIGHT = 2;
    public static final int POSITION_TOP = 1;
    public static final int POSITION_UNKNOWN = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public GradientDrawable f40419e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f40420f;

    /* renamed from: g  reason: collision with root package name */
    public Pair<Object, Object> f40421g;

    /* renamed from: h  reason: collision with root package name */
    public Object f40422h;

    /* renamed from: i  reason: collision with root package name */
    public Object f40423i;

    /* renamed from: j  reason: collision with root package name */
    public int f40424j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f40425k;
    public boolean l;
    public boolean m;
    public boolean n;
    public float o;
    public float p;
    public boolean q;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DrawableCenterTextView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f40419e == null) {
            return;
        }
        int[] iArr = {getWidth(), getHeight()};
        if (this.q) {
            iArr[0] = (int) (getWidth() * this.p);
            iArr[1] = getHeight();
        }
        int width = getWidth() / 2;
        this.f40419e.setBounds(width - (iArr[0] / 2), 0, width + (iArr[0] / 2), getHeight());
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f40420f == null) {
            Paint paint = new Paint();
            this.f40420f = paint;
            paint.setColor(0);
            this.f40420f.setStyle(Paint.Style.STROKE);
            this.f40420f.setAntiAlias(true);
            this.f40420f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40425k && this.f40421g != null : invokeV.booleanValue;
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) && c()) {
            float f2 = this.o;
            if (f2 >= 0.0f) {
                this.f40419e.setCornerRadius(f2);
            } else {
                this.f40419e.setCornerRadius(4.0f);
            }
            if (this.l) {
                int f3 = n0.f(getContext(), 0.5f);
                Object obj = this.f40422h;
                if (obj instanceof String) {
                    this.f40419e.setStroke(f3, Color.parseColor(obj.toString()));
                } else if (obj instanceof Integer) {
                    this.f40419e.setStroke(f3, getResources().getColor(Integer.valueOf(this.f40422h.toString()).intValue()));
                }
            }
            if (this.n) {
                Object obj2 = this.f40421g.second;
                if (obj2 instanceof String) {
                    this.f40419e.setColor(Color.parseColor(obj2.toString()));
                } else if (obj2 instanceof Integer) {
                    this.f40419e.setColor(getResources().getColor(Integer.valueOf(this.f40421g.second.toString()).intValue()));
                }
            } else {
                Object obj3 = this.f40421g.first;
                if (obj3 instanceof String) {
                    this.f40419e.setColor(Color.parseColor(obj3.toString()));
                } else if (obj3 instanceof Integer) {
                    this.f40419e.setColor(getResources().getColor(Integer.valueOf(this.f40421g.first.toString()).intValue()));
                }
            }
            canvas.save();
            if (this.q) {
                a();
            } else {
                this.f40419e.setBounds(0, 0, getWidth(), getHeight());
            }
            this.f40419e.draw(canvas);
            if (this.m) {
                e(canvas);
            }
            canvas.restore();
        }
    }

    public final void e(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            float width = getWidth();
            float height = getHeight();
            Paint paint = new Paint();
            paint.setStrokeWidth(n0.f(getContext(), 0.5f));
            Object obj = this.f40423i;
            if (obj instanceof String) {
                paint.setColor(Color.parseColor(obj.toString()));
            } else if (obj instanceof Integer) {
                paint.setColor(getResources().getColor(Integer.valueOf(this.f40423i.toString()).intValue()));
            }
            int i2 = this.f40424j;
            float f5 = 0.0f;
            if (i2 == 0) {
                f2 = height;
                f3 = 0.0f;
                f4 = 0.0f;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    f4 = width;
                    f2 = height;
                    f5 = getWidth();
                } else if (i2 != 3) {
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

    public final void f(Canvas canvas) {
        Drawable drawable;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            int i9 = 0;
            if (compoundDrawables != null) {
                i2 = 0;
                while (i2 < compoundDrawables.length) {
                    if (compoundDrawables[i2] != null) {
                        drawable = compoundDrawables[i2];
                        break;
                    }
                    i2++;
                }
            }
            drawable = null;
            i2 = -1;
            int w = n0.w(this);
            int v = n0.v(this);
            int compoundDrawablePadding = getCompoundDrawablePadding();
            if (drawable != null) {
                Rect bounds = drawable.getBounds();
                i3 = bounds.right - bounds.left;
                i4 = bounds.bottom - bounds.top;
            } else {
                i3 = 0;
                i4 = 0;
            }
            if (i2 == 0 || i2 == 2) {
                i5 = i3 + w + compoundDrawablePadding;
                i6 = 0;
            } else {
                i6 = (i2 == 1 || i2 == 3) ? v + i4 + compoundDrawablePadding : 0;
                i5 = 0;
            }
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            if (i2 == 0) {
                setGravity(19);
                i7 = width - i5;
            } else {
                if (i2 == 1) {
                    setGravity(49);
                    i8 = height - i6;
                } else if (i2 == 2) {
                    setGravity(21);
                    i9 = i5 - width;
                    i8 = 0;
                } else if (i2 != 3) {
                    setGravity(19);
                    i7 = width - w;
                } else {
                    setGravity(81);
                    i8 = i6 - height;
                }
                canvas.translate(i9 / 2, i8 / 2);
            }
            i9 = i7;
            i8 = 0;
            canvas.translate(i9 / 2, i8 / 2);
        }
    }

    public void initBgColor(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, obj, obj2) == null) {
            if (n0.D(obj) && n0.D(obj2)) {
                this.f40421g = new Pair<>(obj, obj2);
                this.f40425k = true;
                return;
            }
            this.f40425k = false;
        }
    }

    public void initBorderColor(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            if (!n0.D(obj)) {
                this.l = false;
                return;
            }
            this.l = true;
            this.f40422h = obj;
        }
    }

    public void initCornerRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.o = i2;
        }
    }

    public void initDrawable(Drawable drawable, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048585, this, drawable, i2, i3, i4) == null) || drawable == null || i2 <= -1 || i2 > 3) {
            return;
        }
        if (i3 <= 0 || i4 <= 0) {
            i3 = drawable.getIntrinsicWidth();
            i4 = drawable.getIntrinsicHeight();
        }
        drawable.setBounds(0, 0, i3, i4);
        if (i2 == 0) {
            setCompoundDrawables(drawable, null, null, null);
        } else if (i2 == 1) {
            setCompoundDrawables(null, drawable, null, null);
        } else if (i2 == 2) {
            setCompoundDrawables(null, null, drawable, null);
        } else if (i2 != 3) {
        } else {
            setCompoundDrawables(null, null, null, drawable);
        }
    }

    public void initSingleBorder(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, obj, i2) == null) {
            if (!n0.D(obj)) {
                this.m = false;
            } else if (i2 >= 0 && i2 <= 3) {
                this.m = true;
                this.f40423i = obj;
                this.f40424j = i2;
            } else {
                this.m = false;
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            d(canvas);
            f(canvas);
            super.onDraw(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 3 && c()) {
                        this.n = false;
                        invalidate();
                    }
                } else if (c()) {
                    this.n = false;
                    invalidate();
                }
            } else if (c()) {
                this.n = true;
                invalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setAnimationModeActive(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.q = z;
        }
    }

    public void setAnimationPercent(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048590, this, f2) == null) || this.p == f2) {
            return;
        }
        this.p = f2;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public void setShadowLayer(float f2, float f3, float f4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2)}) == null) {
            b();
            RectF rectF = new RectF(f2, f2, f2, f2);
            rectF.offset(f3, f4);
            float f5 = rectF.left;
            int i3 = f5 < 0.0f ? 0 : (int) (f5 + 0.5f);
            float f6 = rectF.right;
            int i4 = f6 < 0.0f ? 0 : (int) (f6 + 0.5f);
            float f7 = rectF.top;
            int i5 = f7 < 0.0f ? 0 : (int) (f7 + 0.5f);
            float f8 = rectF.bottom;
            setPadding(i3, i5, i4, f8 >= 0.0f ? (int) (f8 + 0.5f) : 0);
            this.f40420f.setShadowLayer(f2, f3, f4, i2);
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
        this.f40419e = new GradientDrawable();
        this.f40420f = null;
        new Path();
        this.f40421g = null;
        this.n = false;
        this.o = -1.0f;
        this.p = 0.0f;
    }
}
