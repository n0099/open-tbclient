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
import c.a.d.n.j;
import com.baidu.adp.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes9.dex */
public class IndicatorView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32314e;

    /* renamed from: f  reason: collision with root package name */
    public int f32315f;

    /* renamed from: g  reason: collision with root package name */
    public int f32316g;

    /* renamed from: h  reason: collision with root package name */
    public float f32317h;

    /* renamed from: i  reason: collision with root package name */
    public float f32318i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f32319j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f32320k;
    public final j l;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f32321e;

        /* renamed from: f  reason: collision with root package name */
        public long f32322f;

        /* renamed from: g  reason: collision with root package name */
        public long f32323g;

        /* renamed from: h  reason: collision with root package name */
        public int f32324h;

        /* renamed from: i  reason: collision with root package name */
        public float f32325i;

        /* renamed from: j  reason: collision with root package name */
        public final a f32326j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ IndicatorView f32327k;

        /* loaded from: classes9.dex */
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
            this.f32327k = indicatorView;
            this.f32326j = new a(this, null);
            this.f32321e = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // c.a.d.n.j
        public boolean a(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.d.n.j
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                if (this.f32327k.f32319j != null && this.f32327k.f32320k != null && this.f32327k.f32316g != 0) {
                    this.f32327k.setWillNotDraw(false);
                    this.f32327k.setMeasuredDimension(i(i2), h(i3));
                    return;
                }
                this.f32327k.setWillNotDraw(true);
                this.f32327k.setMeasuredDimension(0, 0);
            }
        }

        @Override // c.a.d.n.j
        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.f32327k.f32318i <= this.f32327k.f32317h) {
                    if (this.f32327k.f32318i >= this.f32327k.f32317h) {
                        return;
                    }
                    this.f32324h = -this.f32321e;
                } else {
                    this.f32324h = this.f32321e;
                }
                this.f32325i = this.f32327k.f32317h;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f32322f = uptimeMillis;
                this.f32323g = uptimeMillis + 16;
                this.f32326j.removeMessages(1000);
                this.f32326j.sendEmptyMessageAtTime(1000, this.f32323g);
            }
        }

        @Override // c.a.d.n.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.d.n.j
        public void draw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
                int save = canvas.save();
                for (int i2 = 0; i2 < this.f32327k.f32316g; i2++) {
                    if (i2 != 0) {
                        canvas.translate(this.f32327k.f32319j.getBounds().width() + this.f32327k.f32315f, 0.0f);
                    }
                    this.f32327k.f32319j.draw(canvas);
                }
                if (save >= 1 && save <= canvas.getSaveCount()) {
                    canvas.restoreToCount(save);
                }
                int save2 = canvas.save();
                if (this.f32327k.f32317h > (this.f32327k.f32316g - 1) + 0.5d) {
                    this.f32327k.f32317h = 0.0f;
                }
                canvas.translate((this.f32327k.f32320k.getBounds().width() + this.f32327k.f32315f) * this.f32327k.f32317h, 0.0f);
                this.f32327k.f32320k.draw(canvas);
                if (save2 < 1 || save2 > canvas.getSaveCount()) {
                    return;
                }
                canvas.restoreToCount(save2);
            }
        }

        @Override // c.a.d.n.j
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
                float f2 = this.f32325i;
                int i2 = this.f32324h;
                float f3 = f2 + (i2 * (((float) (uptimeMillis - this.f32322f)) / 1000.0f));
                this.f32325i = f3;
                this.f32322f = uptimeMillis;
                this.f32323g = uptimeMillis + 16;
                if (i2 < 0) {
                    if (f3 < this.f32327k.f32318i) {
                        IndicatorView indicatorView = this.f32327k;
                        indicatorView.f32317h = indicatorView.f32318i;
                    } else {
                        this.f32327k.f32317h = this.f32325i;
                        this.f32326j.removeMessages(1000);
                        this.f32326j.sendEmptyMessageAtTime(1000, this.f32323g);
                    }
                } else if (f3 > this.f32327k.f32318i) {
                    IndicatorView indicatorView2 = this.f32327k;
                    indicatorView2.f32317h = indicatorView2.f32318i;
                } else {
                    this.f32327k.f32317h = this.f32325i;
                    this.f32326j.removeMessages(1000);
                    this.f32326j.sendEmptyMessageAtTime(1000, this.f32323g);
                }
                this.f32327k.invalidate();
            }
        }

        public final int h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                int i3 = (-1073741824) & i2;
                int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                int max = Math.max(this.f32327k.f32319j.getIntrinsicHeight(), this.f32327k.f32320k.getIntrinsicHeight());
                if (i3 == Integer.MIN_VALUE) {
                    int min = Math.min(i4, max);
                    this.f32327k.f32319j.setBounds(0, 0, this.f32327k.f32319j.getBounds().width(), min);
                    this.f32327k.f32320k.setBounds(0, 0, this.f32327k.f32320k.getBounds().width(), min);
                    return min;
                } else if (i3 == 0) {
                    this.f32327k.f32319j.setBounds(0, 0, this.f32327k.f32319j.getBounds().width(), max);
                    this.f32327k.f32320k.setBounds(0, 0, this.f32327k.f32320k.getBounds().width(), max);
                    return max;
                } else if (i3 != 1073741824) {
                    return i4;
                } else {
                    this.f32327k.f32319j.setBounds(0, 0, this.f32327k.f32319j.getBounds().width(), i4);
                    this.f32327k.f32320k.setBounds(0, 0, this.f32327k.f32320k.getBounds().width(), i4);
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
                int max = (this.f32327k.f32315f * (this.f32327k.f32316g - 1)) + (Math.max(this.f32327k.f32319j.getIntrinsicWidth(), this.f32327k.f32320k.getIntrinsicWidth()) * this.f32327k.f32316g);
                if (i3 == Integer.MIN_VALUE) {
                    int min = Math.min(i4, max);
                    this.f32327k.f32319j.setBounds(0, 0, this.f32327k.f32319j.getIntrinsicWidth(), this.f32327k.f32319j.getBounds().height());
                    this.f32327k.f32320k.setBounds(0, 0, this.f32327k.f32320k.getIntrinsicWidth(), this.f32327k.f32320k.getBounds().height());
                    return min;
                } else if (i3 == 0) {
                    this.f32327k.f32319j.setBounds(0, 0, this.f32327k.f32319j.getIntrinsicWidth(), 0);
                    this.f32327k.f32320k.setBounds(0, 0, this.f32327k.f32320k.getIntrinsicWidth(), 0);
                    return max;
                } else if (i3 != 1073741824) {
                    return i4;
                } else {
                    int i5 = (int) ((i4 - (this.f32327k.f32315f * (this.f32327k.f32316g - 1))) / this.f32327k.f32316g);
                    this.f32327k.f32320k.setBounds(0, 0, i5, this.f32327k.f32320k.getBounds().height());
                    this.f32327k.f32319j.setBounds(0, 0, i5, this.f32327k.f32319j.getBounds().height());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32316g : invokeV.intValue;
    }

    public Drawable getDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32319j : (Drawable) invokeV.objValue;
    }

    public float getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32317h : invokeV.floatValue;
    }

    public Drawable getSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32320k : (Drawable) invokeV.objValue;
    }

    public int getSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32315f : invokeV.intValue;
    }

    public boolean isAutoHide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f32314e : invokeV.booleanValue;
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
            this.f32314e = z;
        }
    }

    public void setCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f32316g = i2;
            requestLayout();
            invalidate();
        }
    }

    public void setDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            this.f32319j = drawable;
            requestLayout();
            invalidate();
        }
    }

    public void setPosition(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            this.f32317h = f2;
            invalidate();
        }
    }

    public void setSelector(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, drawable) == null) {
            this.f32320k = drawable;
            requestLayout();
            invalidate();
        }
    }

    public void setSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f32315f = i2;
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
        this.f32315f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorView_spacing, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.f32316g = obtainStyledAttributes.getInteger(R.styleable.IndicatorView_count, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_drawable);
        this.f32319j = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f32319j.getIntrinsicHeight());
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.IndicatorView_selector);
        this.f32320k = drawable2;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f32320k.getIntrinsicHeight());
        }
        this.f32314e = obtainStyledAttributes.getBoolean(R.styleable.IndicatorView_autoHide, false);
    }
}
