package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.j;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes.dex */
public class IndicatorView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f2339e;

    /* renamed from: f  reason: collision with root package name */
    public int f2340f;

    /* renamed from: g  reason: collision with root package name */
    public float f2341g;

    /* renamed from: h  reason: collision with root package name */
    public float f2342h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f2343i;
    public Drawable j;
    public final j k;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f2344e;

        /* renamed from: f  reason: collision with root package name */
        public long f2345f;

        /* renamed from: g  reason: collision with root package name */
        public long f2346g;

        /* renamed from: h  reason: collision with root package name */
        public int f2347h;

        /* renamed from: i  reason: collision with root package name */
        public float f2348i;
        public final a j;
        public final /* synthetic */ IndicatorView k;

        /* loaded from: classes.dex */
        public class a extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f2349a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f2349a = bVar;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1000) {
                    this.f2349a.g();
                }
            }

            public /* synthetic */ a(b bVar, a aVar) {
                this(bVar);
            }
        }

        public b(IndicatorView indicatorView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {indicatorView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = indicatorView;
            this.j = new a(this, null);
            this.f2344e = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // d.a.d.k.j
        public boolean a(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // d.a.d.k.j
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                if (this.k.f2343i != null && this.k.j != null && this.k.f2340f != 0) {
                    this.k.setWillNotDraw(false);
                    this.k.setMeasuredDimension(i(i2), h(i3));
                    return;
                }
                this.k.setWillNotDraw(true);
                this.k.setMeasuredDimension(0, 0);
            }
        }

        @Override // d.a.d.k.j
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.k.f2342h <= this.k.f2341g) {
                    if (this.k.f2342h >= this.k.f2341g) {
                        return;
                    }
                    this.f2347h = -this.f2344e;
                } else {
                    this.f2347h = this.f2344e;
                }
                this.f2348i = this.k.f2341g;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f2345f = uptimeMillis;
                this.f2346g = uptimeMillis + 16;
                this.j.removeMessages(1000);
                this.j.sendEmptyMessageAtTime(1000, this.f2346g);
            }
        }

        @Override // d.a.d.k.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // d.a.d.k.j
        public void draw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
                int save = canvas.save();
                for (int i2 = 0; i2 < this.k.f2340f; i2++) {
                    if (i2 != 0) {
                        canvas.translate(this.k.f2343i.getBounds().width() + this.k.f2339e, 0.0f);
                    }
                    this.k.f2343i.draw(canvas);
                }
                if (save >= 1 && save <= canvas.getSaveCount()) {
                    canvas.restoreToCount(save);
                }
                int save2 = canvas.save();
                if (this.k.f2341g > (this.k.f2340f - 1) + 0.5d) {
                    this.k.f2341g = 0.0f;
                }
                canvas.translate((this.k.j.getBounds().width() + this.k.f2339e) * this.k.f2341g, 0.0f);
                this.k.j.draw(canvas);
                if (save2 < 1 || save2 > canvas.getSaveCount()) {
                    return;
                }
                canvas.restoreToCount(save2);
            }
        }

        @Override // d.a.d.k.j
        public boolean e(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                float f2 = this.f2348i;
                int i2 = this.f2347h;
                float f3 = f2 + (i2 * (((float) (uptimeMillis - this.f2345f)) / 1000.0f));
                this.f2348i = f3;
                this.f2345f = uptimeMillis;
                this.f2346g = uptimeMillis + 16;
                if (i2 < 0) {
                    if (f3 < this.k.f2342h) {
                        IndicatorView indicatorView = this.k;
                        indicatorView.f2341g = indicatorView.f2342h;
                    } else {
                        this.k.f2341g = this.f2348i;
                        this.j.removeMessages(1000);
                        this.j.sendEmptyMessageAtTime(1000, this.f2346g);
                    }
                } else if (f3 > this.k.f2342h) {
                    IndicatorView indicatorView2 = this.k;
                    indicatorView2.f2341g = indicatorView2.f2342h;
                } else {
                    this.k.f2341g = this.f2348i;
                    this.j.removeMessages(1000);
                    this.j.sendEmptyMessageAtTime(1000, this.f2346g);
                }
                this.k.invalidate();
            }
        }

        public final int h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                int i3 = (-1073741824) & i2;
                int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                int max = Math.max(this.k.f2343i.getIntrinsicHeight(), this.k.j.getIntrinsicHeight());
                if (i3 == Integer.MIN_VALUE) {
                    int min = Math.min(i4, max);
                    this.k.f2343i.setBounds(0, 0, this.k.f2343i.getBounds().width(), min);
                    this.k.j.setBounds(0, 0, this.k.j.getBounds().width(), min);
                    return min;
                } else if (i3 == 0) {
                    this.k.f2343i.setBounds(0, 0, this.k.f2343i.getBounds().width(), max);
                    this.k.j.setBounds(0, 0, this.k.j.getBounds().width(), max);
                    return max;
                } else if (i3 != 1073741824) {
                    return i4;
                } else {
                    this.k.f2343i.setBounds(0, 0, this.k.f2343i.getBounds().width(), i4);
                    this.k.j.setBounds(0, 0, this.k.j.getBounds().width(), i4);
                    return i4;
                }
            }
            return invokeI.intValue;
        }

        public final int i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                int i3 = (-1073741824) & i2;
                int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                int max = (this.k.f2339e * (this.k.f2340f - 1)) + (Math.max(this.k.f2343i.getIntrinsicWidth(), this.k.j.getIntrinsicWidth()) * this.k.f2340f);
                if (i3 == Integer.MIN_VALUE) {
                    int min = Math.min(i4, max);
                    this.k.f2343i.setBounds(0, 0, this.k.f2343i.getIntrinsicWidth(), this.k.f2343i.getBounds().height());
                    this.k.j.setBounds(0, 0, this.k.j.getIntrinsicWidth(), this.k.j.getBounds().height());
                    return min;
                } else if (i3 == 0) {
                    this.k.f2343i.setBounds(0, 0, this.k.f2343i.getIntrinsicWidth(), 0);
                    this.k.j.setBounds(0, 0, this.k.j.getIntrinsicWidth(), 0);
                    return max;
                } else if (i3 != 1073741824) {
                    return i4;
                } else {
                    int i5 = (int) ((i4 - (this.k.f2339e * (this.k.f2340f - 1))) / this.k.f2340f);
                    this.k.j.setBounds(0, 0, i5, this.k.j.getBounds().height());
                    this.k.f2343i.setBounds(0, 0, i5, this.k.f2343i.getBounds().height());
                    return i4;
                }
            }
            return invokeI.intValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndicatorView(Context context) {
        this(context, null, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2340f : invokeV.intValue;
    }

    public Drawable getDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2343i : (Drawable) invokeV.objValue;
    }

    public float getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2341g : invokeV.floatValue;
    }

    public Drawable getSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (Drawable) invokeV.objValue;
    }

    public int getSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2339e : invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            this.k.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            this.k.b(i2, i3);
        }
    }

    public void setAutoHide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    public void setCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f2340f = i2;
            requestLayout();
            invalidate();
        }
    }

    public void setDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            this.f2343i = drawable;
            requestLayout();
            invalidate();
        }
    }

    public void setPosition(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            this.f2341g = f2;
            invalidate();
        }
    }

    public void setSelector(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, drawable) == null) {
            this.j = drawable;
            requestLayout();
            invalidate();
        }
    }

    public void setSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f2339e = i2;
            requestLayout();
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndicatorView(Context context, AttributeSet attributeSet, int i2) {
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
        this.k = new b(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.f2339e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.f2340f = obtainStyledAttributes.getInteger(R.styleable.IndicatorView_count, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_drawable);
        this.f2343i = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f2343i.getIntrinsicHeight());
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_selector);
        this.j = drawable2;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.j.getIntrinsicHeight());
        }
        obtainStyledAttributes.getBoolean(R.styleable.IndicatorView_autoHide, false);
    }
}
