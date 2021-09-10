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
import c.a.e.l.j;
import com.baidu.adp.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes4.dex */
public class IndicatorView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36424e;

    /* renamed from: f  reason: collision with root package name */
    public int f36425f;

    /* renamed from: g  reason: collision with root package name */
    public int f36426g;

    /* renamed from: h  reason: collision with root package name */
    public float f36427h;

    /* renamed from: i  reason: collision with root package name */
    public float f36428i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f36429j;
    public Drawable k;
    public final j l;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f36430e;

        /* renamed from: f  reason: collision with root package name */
        public long f36431f;

        /* renamed from: g  reason: collision with root package name */
        public long f36432g;

        /* renamed from: h  reason: collision with root package name */
        public int f36433h;

        /* renamed from: i  reason: collision with root package name */
        public float f36434i;

        /* renamed from: j  reason: collision with root package name */
        public final a f36435j;
        public final /* synthetic */ IndicatorView k;

        /* loaded from: classes4.dex */
        public class a extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36436a;

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
                this.f36436a = bVar;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1000) {
                    this.f36436a.g();
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
            this.f36435j = new a(this, null);
            this.f36430e = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // c.a.e.l.j
        public boolean a(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.e.l.j
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                if (this.k.f36429j != null && this.k.k != null && this.k.f36426g != 0) {
                    this.k.setWillNotDraw(false);
                    this.k.setMeasuredDimension(i(i2), h(i3));
                    return;
                }
                this.k.setWillNotDraw(true);
                this.k.setMeasuredDimension(0, 0);
            }
        }

        @Override // c.a.e.l.j
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.k.f36428i <= this.k.f36427h) {
                    if (this.k.f36428i >= this.k.f36427h) {
                        return;
                    }
                    this.f36433h = -this.f36430e;
                } else {
                    this.f36433h = this.f36430e;
                }
                this.f36434i = this.k.f36427h;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f36431f = uptimeMillis;
                this.f36432g = uptimeMillis + 16;
                this.f36435j.removeMessages(1000);
                this.f36435j.sendEmptyMessageAtTime(1000, this.f36432g);
            }
        }

        @Override // c.a.e.l.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.e.l.j
        public void draw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
                int save = canvas.save();
                for (int i2 = 0; i2 < this.k.f36426g; i2++) {
                    if (i2 != 0) {
                        canvas.translate(this.k.f36429j.getBounds().width() + this.k.f36425f, 0.0f);
                    }
                    this.k.f36429j.draw(canvas);
                }
                if (save >= 1 && save <= canvas.getSaveCount()) {
                    canvas.restoreToCount(save);
                }
                int save2 = canvas.save();
                if (this.k.f36427h > (this.k.f36426g - 1) + 0.5d) {
                    this.k.f36427h = 0.0f;
                }
                canvas.translate((this.k.k.getBounds().width() + this.k.f36425f) * this.k.f36427h, 0.0f);
                this.k.k.draw(canvas);
                if (save2 < 1 || save2 > canvas.getSaveCount()) {
                    return;
                }
                canvas.restoreToCount(save2);
            }
        }

        @Override // c.a.e.l.j
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
                float f2 = this.f36434i;
                int i2 = this.f36433h;
                float f3 = f2 + (i2 * (((float) (uptimeMillis - this.f36431f)) / 1000.0f));
                this.f36434i = f3;
                this.f36431f = uptimeMillis;
                this.f36432g = uptimeMillis + 16;
                if (i2 < 0) {
                    if (f3 < this.k.f36428i) {
                        IndicatorView indicatorView = this.k;
                        indicatorView.f36427h = indicatorView.f36428i;
                    } else {
                        this.k.f36427h = this.f36434i;
                        this.f36435j.removeMessages(1000);
                        this.f36435j.sendEmptyMessageAtTime(1000, this.f36432g);
                    }
                } else if (f3 > this.k.f36428i) {
                    IndicatorView indicatorView2 = this.k;
                    indicatorView2.f36427h = indicatorView2.f36428i;
                } else {
                    this.k.f36427h = this.f36434i;
                    this.f36435j.removeMessages(1000);
                    this.f36435j.sendEmptyMessageAtTime(1000, this.f36432g);
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
                int max = Math.max(this.k.f36429j.getIntrinsicHeight(), this.k.k.getIntrinsicHeight());
                if (i3 == Integer.MIN_VALUE) {
                    int min = Math.min(i4, max);
                    this.k.f36429j.setBounds(0, 0, this.k.f36429j.getBounds().width(), min);
                    this.k.k.setBounds(0, 0, this.k.k.getBounds().width(), min);
                    return min;
                } else if (i3 == 0) {
                    this.k.f36429j.setBounds(0, 0, this.k.f36429j.getBounds().width(), max);
                    this.k.k.setBounds(0, 0, this.k.k.getBounds().width(), max);
                    return max;
                } else if (i3 != 1073741824) {
                    return i4;
                } else {
                    this.k.f36429j.setBounds(0, 0, this.k.f36429j.getBounds().width(), i4);
                    this.k.k.setBounds(0, 0, this.k.k.getBounds().width(), i4);
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
                int max = (this.k.f36425f * (this.k.f36426g - 1)) + (Math.max(this.k.f36429j.getIntrinsicWidth(), this.k.k.getIntrinsicWidth()) * this.k.f36426g);
                if (i3 == Integer.MIN_VALUE) {
                    int min = Math.min(i4, max);
                    this.k.f36429j.setBounds(0, 0, this.k.f36429j.getIntrinsicWidth(), this.k.f36429j.getBounds().height());
                    this.k.k.setBounds(0, 0, this.k.k.getIntrinsicWidth(), this.k.k.getBounds().height());
                    return min;
                } else if (i3 == 0) {
                    this.k.f36429j.setBounds(0, 0, this.k.f36429j.getIntrinsicWidth(), 0);
                    this.k.k.setBounds(0, 0, this.k.k.getIntrinsicWidth(), 0);
                    return max;
                } else if (i3 != 1073741824) {
                    return i4;
                } else {
                    int i5 = (int) ((i4 - (this.k.f36425f * (this.k.f36426g - 1))) / this.k.f36426g);
                    this.k.k.setBounds(0, 0, i5, this.k.k.getBounds().height());
                    this.k.f36429j.setBounds(0, 0, i5, this.k.f36429j.getBounds().height());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36426g : invokeV.intValue;
    }

    public Drawable getDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f36429j : (Drawable) invokeV.objValue;
    }

    public float getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36427h : invokeV.floatValue;
    }

    public Drawable getSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (Drawable) invokeV.objValue;
    }

    public int getSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36425f : invokeV.intValue;
    }

    public boolean isAutoHide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36424e : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            this.l.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            this.l.b(i2, i3);
        }
    }

    public void setAutoHide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f36424e = z;
        }
    }

    public void setCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f36426g = i2;
            requestLayout();
            invalidate();
        }
    }

    public void setDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            this.f36429j = drawable;
            requestLayout();
            invalidate();
        }
    }

    public void setPosition(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            this.f36427h = f2;
            invalidate();
        }
    }

    public void setSelector(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, drawable) == null) {
            this.k = drawable;
            requestLayout();
            invalidate();
        }
    }

    public void setSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f36425f = i2;
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
        this.l = new b(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.f36425f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.f36426g = obtainStyledAttributes.getInteger(R.styleable.IndicatorView_count, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_drawable);
        this.f36429j = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f36429j.getIntrinsicHeight());
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_selector);
        this.k = drawable2;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.k.getIntrinsicHeight());
        }
        this.f36424e = obtainStyledAttributes.getBoolean(R.styleable.IndicatorView_autoHide, false);
    }
}
