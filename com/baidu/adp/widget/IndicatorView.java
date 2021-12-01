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
import c.a.d.m.j;
import com.baidu.adp.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes8.dex */
public class IndicatorView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31802e;

    /* renamed from: f  reason: collision with root package name */
    public int f31803f;

    /* renamed from: g  reason: collision with root package name */
    public int f31804g;

    /* renamed from: h  reason: collision with root package name */
    public float f31805h;

    /* renamed from: i  reason: collision with root package name */
    public float f31806i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f31807j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f31808k;
    public final j l;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f31809e;

        /* renamed from: f  reason: collision with root package name */
        public long f31810f;

        /* renamed from: g  reason: collision with root package name */
        public long f31811g;

        /* renamed from: h  reason: collision with root package name */
        public int f31812h;

        /* renamed from: i  reason: collision with root package name */
        public float f31813i;

        /* renamed from: j  reason: collision with root package name */
        public final a f31814j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ IndicatorView f31815k;

        /* loaded from: classes8.dex */
        public class a extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = bVar;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1000) {
                    this.a.g();
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
            this.f31815k = indicatorView;
            this.f31814j = new a(this, null);
            this.f31809e = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // c.a.d.m.j
        public boolean a(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.d.m.j
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                if (this.f31815k.f31807j != null && this.f31815k.f31808k != null && this.f31815k.f31804g != 0) {
                    this.f31815k.setWillNotDraw(false);
                    this.f31815k.setMeasuredDimension(i(i2), h(i3));
                    return;
                }
                this.f31815k.setWillNotDraw(true);
                this.f31815k.setMeasuredDimension(0, 0);
            }
        }

        @Override // c.a.d.m.j
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.f31815k.f31806i <= this.f31815k.f31805h) {
                    if (this.f31815k.f31806i >= this.f31815k.f31805h) {
                        return;
                    }
                    this.f31812h = -this.f31809e;
                } else {
                    this.f31812h = this.f31809e;
                }
                this.f31813i = this.f31815k.f31805h;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f31810f = uptimeMillis;
                this.f31811g = uptimeMillis + 16;
                this.f31814j.removeMessages(1000);
                this.f31814j.sendEmptyMessageAtTime(1000, this.f31811g);
            }
        }

        @Override // c.a.d.m.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.d.m.j
        public void draw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
                int save = canvas.save();
                for (int i2 = 0; i2 < this.f31815k.f31804g; i2++) {
                    if (i2 != 0) {
                        canvas.translate(this.f31815k.f31807j.getBounds().width() + this.f31815k.f31803f, 0.0f);
                    }
                    this.f31815k.f31807j.draw(canvas);
                }
                if (save >= 1 && save <= canvas.getSaveCount()) {
                    canvas.restoreToCount(save);
                }
                int save2 = canvas.save();
                if (this.f31815k.f31805h > (this.f31815k.f31804g - 1) + 0.5d) {
                    this.f31815k.f31805h = 0.0f;
                }
                canvas.translate((this.f31815k.f31808k.getBounds().width() + this.f31815k.f31803f) * this.f31815k.f31805h, 0.0f);
                this.f31815k.f31808k.draw(canvas);
                if (save2 < 1 || save2 > canvas.getSaveCount()) {
                    return;
                }
                canvas.restoreToCount(save2);
            }
        }

        @Override // c.a.d.m.j
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
                float f2 = this.f31813i;
                int i2 = this.f31812h;
                float f3 = f2 + (i2 * (((float) (uptimeMillis - this.f31810f)) / 1000.0f));
                this.f31813i = f3;
                this.f31810f = uptimeMillis;
                this.f31811g = uptimeMillis + 16;
                if (i2 < 0) {
                    if (f3 < this.f31815k.f31806i) {
                        IndicatorView indicatorView = this.f31815k;
                        indicatorView.f31805h = indicatorView.f31806i;
                    } else {
                        this.f31815k.f31805h = this.f31813i;
                        this.f31814j.removeMessages(1000);
                        this.f31814j.sendEmptyMessageAtTime(1000, this.f31811g);
                    }
                } else if (f3 > this.f31815k.f31806i) {
                    IndicatorView indicatorView2 = this.f31815k;
                    indicatorView2.f31805h = indicatorView2.f31806i;
                } else {
                    this.f31815k.f31805h = this.f31813i;
                    this.f31814j.removeMessages(1000);
                    this.f31814j.sendEmptyMessageAtTime(1000, this.f31811g);
                }
                this.f31815k.invalidate();
            }
        }

        public final int h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                int i3 = (-1073741824) & i2;
                int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                int max = Math.max(this.f31815k.f31807j.getIntrinsicHeight(), this.f31815k.f31808k.getIntrinsicHeight());
                if (i3 == Integer.MIN_VALUE) {
                    int min = Math.min(i4, max);
                    this.f31815k.f31807j.setBounds(0, 0, this.f31815k.f31807j.getBounds().width(), min);
                    this.f31815k.f31808k.setBounds(0, 0, this.f31815k.f31808k.getBounds().width(), min);
                    return min;
                } else if (i3 == 0) {
                    this.f31815k.f31807j.setBounds(0, 0, this.f31815k.f31807j.getBounds().width(), max);
                    this.f31815k.f31808k.setBounds(0, 0, this.f31815k.f31808k.getBounds().width(), max);
                    return max;
                } else if (i3 != 1073741824) {
                    return i4;
                } else {
                    this.f31815k.f31807j.setBounds(0, 0, this.f31815k.f31807j.getBounds().width(), i4);
                    this.f31815k.f31808k.setBounds(0, 0, this.f31815k.f31808k.getBounds().width(), i4);
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
                int max = (this.f31815k.f31803f * (this.f31815k.f31804g - 1)) + (Math.max(this.f31815k.f31807j.getIntrinsicWidth(), this.f31815k.f31808k.getIntrinsicWidth()) * this.f31815k.f31804g);
                if (i3 == Integer.MIN_VALUE) {
                    int min = Math.min(i4, max);
                    this.f31815k.f31807j.setBounds(0, 0, this.f31815k.f31807j.getIntrinsicWidth(), this.f31815k.f31807j.getBounds().height());
                    this.f31815k.f31808k.setBounds(0, 0, this.f31815k.f31808k.getIntrinsicWidth(), this.f31815k.f31808k.getBounds().height());
                    return min;
                } else if (i3 == 0) {
                    this.f31815k.f31807j.setBounds(0, 0, this.f31815k.f31807j.getIntrinsicWidth(), 0);
                    this.f31815k.f31808k.setBounds(0, 0, this.f31815k.f31808k.getIntrinsicWidth(), 0);
                    return max;
                } else if (i3 != 1073741824) {
                    return i4;
                } else {
                    int i5 = (int) ((i4 - (this.f31815k.f31803f * (this.f31815k.f31804g - 1))) / this.f31815k.f31804g);
                    this.f31815k.f31808k.setBounds(0, 0, i5, this.f31815k.f31808k.getBounds().height());
                    this.f31815k.f31807j.setBounds(0, 0, i5, this.f31815k.f31807j.getBounds().height());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31804g : invokeV.intValue;
    }

    public Drawable getDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31807j : (Drawable) invokeV.objValue;
    }

    public float getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31805h : invokeV.floatValue;
    }

    public Drawable getSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31808k : (Drawable) invokeV.objValue;
    }

    public int getSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31803f : invokeV.intValue;
    }

    public boolean isAutoHide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31802e : invokeV.booleanValue;
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
            this.f31802e = z;
        }
    }

    public void setCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f31804g = i2;
            requestLayout();
            invalidate();
        }
    }

    public void setDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            this.f31807j = drawable;
            requestLayout();
            invalidate();
        }
    }

    public void setPosition(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            this.f31805h = f2;
            invalidate();
        }
    }

    public void setSelector(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, drawable) == null) {
            this.f31808k = drawable;
            requestLayout();
            invalidate();
        }
    }

    public void setSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f31803f = i2;
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
        this.f31803f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.f31804g = obtainStyledAttributes.getInteger(R.styleable.IndicatorView_count, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_drawable);
        this.f31807j = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f31807j.getIntrinsicHeight());
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_selector);
        this.f31808k = drawable2;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f31808k.getIntrinsicHeight());
        }
        this.f31802e = obtainStyledAttributes.getBoolean(R.styleable.IndicatorView_autoHide, false);
    }
}
