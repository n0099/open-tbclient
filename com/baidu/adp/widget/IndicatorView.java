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
import c.a.d.o.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes3.dex */
public class IndicatorView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f23931b;

    /* renamed from: c  reason: collision with root package name */
    public float f23932c;

    /* renamed from: d  reason: collision with root package name */
    public float f23933d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f23934e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f23935f;

    /* renamed from: g  reason: collision with root package name */
    public final j f23936g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public long f23937b;

        /* renamed from: c  reason: collision with root package name */
        public long f23938c;

        /* renamed from: d  reason: collision with root package name */
        public int f23939d;

        /* renamed from: e  reason: collision with root package name */
        public float f23940e;

        /* renamed from: f  reason: collision with root package name */
        public final a f23941f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ IndicatorView f23942g;

        /* loaded from: classes3.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23942g = indicatorView;
            this.f23941f = new a(this, null);
            this.a = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // c.a.d.o.j
        public boolean a(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.d.o.j
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                if (this.f23942g.f23934e != null && this.f23942g.f23935f != null && this.f23942g.f23931b != 0) {
                    this.f23942g.setWillNotDraw(false);
                    this.f23942g.setMeasuredDimension(i(i), h(i2));
                    return;
                }
                this.f23942g.setWillNotDraw(true);
                this.f23942g.setMeasuredDimension(0, 0);
            }
        }

        @Override // c.a.d.o.j
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.f23942g.f23933d <= this.f23942g.f23932c) {
                    if (this.f23942g.f23933d >= this.f23942g.f23932c) {
                        return;
                    }
                    this.f23939d = -this.a;
                } else {
                    this.f23939d = this.a;
                }
                this.f23940e = this.f23942g.f23932c;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f23937b = uptimeMillis;
                this.f23938c = uptimeMillis + 16;
                this.f23941f.removeMessages(1000);
                this.f23941f.sendEmptyMessageAtTime(1000, this.f23938c);
            }
        }

        @Override // c.a.d.o.j
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.d.o.j
        public void draw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
                int save = canvas.save();
                for (int i = 0; i < this.f23942g.f23931b; i++) {
                    if (i != 0) {
                        canvas.translate(this.f23942g.f23934e.getBounds().width() + this.f23942g.a, 0.0f);
                    }
                    this.f23942g.f23934e.draw(canvas);
                }
                if (save >= 1 && save <= canvas.getSaveCount()) {
                    canvas.restoreToCount(save);
                }
                int save2 = canvas.save();
                if (this.f23942g.f23932c > (this.f23942g.f23931b - 1) + 0.5d) {
                    this.f23942g.f23932c = 0.0f;
                }
                canvas.translate((this.f23942g.f23935f.getBounds().width() + this.f23942g.a) * this.f23942g.f23932c, 0.0f);
                this.f23942g.f23935f.draw(canvas);
                if (save2 < 1 || save2 > canvas.getSaveCount()) {
                    return;
                }
                canvas.restoreToCount(save2);
            }
        }

        @Override // c.a.d.o.j
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
                float f2 = this.f23940e;
                int i = this.f23939d;
                float f3 = f2 + (i * (((float) (uptimeMillis - this.f23937b)) / 1000.0f));
                this.f23940e = f3;
                this.f23937b = uptimeMillis;
                this.f23938c = uptimeMillis + 16;
                if (i < 0) {
                    if (f3 < this.f23942g.f23933d) {
                        IndicatorView indicatorView = this.f23942g;
                        indicatorView.f23932c = indicatorView.f23933d;
                    } else {
                        this.f23942g.f23932c = this.f23940e;
                        this.f23941f.removeMessages(1000);
                        this.f23941f.sendEmptyMessageAtTime(1000, this.f23938c);
                    }
                } else if (f3 > this.f23942g.f23933d) {
                    IndicatorView indicatorView2 = this.f23942g;
                    indicatorView2.f23932c = indicatorView2.f23933d;
                } else {
                    this.f23942g.f23932c = this.f23940e;
                    this.f23941f.removeMessages(1000);
                    this.f23941f.sendEmptyMessageAtTime(1000, this.f23938c);
                }
                this.f23942g.invalidate();
            }
        }

        public final int h(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                int i2 = (-1073741824) & i;
                int i3 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                int max = Math.max(this.f23942g.f23934e.getIntrinsicHeight(), this.f23942g.f23935f.getIntrinsicHeight());
                if (i2 == Integer.MIN_VALUE) {
                    int min = Math.min(i3, max);
                    this.f23942g.f23934e.setBounds(0, 0, this.f23942g.f23934e.getBounds().width(), min);
                    this.f23942g.f23935f.setBounds(0, 0, this.f23942g.f23935f.getBounds().width(), min);
                    return min;
                } else if (i2 == 0) {
                    this.f23942g.f23934e.setBounds(0, 0, this.f23942g.f23934e.getBounds().width(), max);
                    this.f23942g.f23935f.setBounds(0, 0, this.f23942g.f23935f.getBounds().width(), max);
                    return max;
                } else if (i2 != 1073741824) {
                    return i3;
                } else {
                    this.f23942g.f23934e.setBounds(0, 0, this.f23942g.f23934e.getBounds().width(), i3);
                    this.f23942g.f23935f.setBounds(0, 0, this.f23942g.f23935f.getBounds().width(), i3);
                    return i3;
                }
            }
            return invokeI.intValue;
        }

        public final int i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                int i2 = (-1073741824) & i;
                int i3 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                int max = (this.f23942g.a * (this.f23942g.f23931b - 1)) + (Math.max(this.f23942g.f23934e.getIntrinsicWidth(), this.f23942g.f23935f.getIntrinsicWidth()) * this.f23942g.f23931b);
                if (i2 == Integer.MIN_VALUE) {
                    int min = Math.min(i3, max);
                    this.f23942g.f23934e.setBounds(0, 0, this.f23942g.f23934e.getIntrinsicWidth(), this.f23942g.f23934e.getBounds().height());
                    this.f23942g.f23935f.setBounds(0, 0, this.f23942g.f23935f.getIntrinsicWidth(), this.f23942g.f23935f.getBounds().height());
                    return min;
                } else if (i2 == 0) {
                    this.f23942g.f23934e.setBounds(0, 0, this.f23942g.f23934e.getIntrinsicWidth(), 0);
                    this.f23942g.f23935f.setBounds(0, 0, this.f23942g.f23935f.getIntrinsicWidth(), 0);
                    return max;
                } else if (i2 != 1073741824) {
                    return i3;
                } else {
                    int i4 = (int) ((i3 - (this.f23942g.a * (this.f23942g.f23931b - 1))) / this.f23942g.f23931b);
                    this.f23942g.f23935f.setBounds(0, 0, i4, this.f23942g.f23935f.getBounds().height());
                    this.f23942g.f23934e.setBounds(0, 0, i4, this.f23942g.f23934e.getBounds().height());
                    return i3;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23931b : invokeV.intValue;
    }

    public Drawable getDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23934e : (Drawable) invokeV.objValue;
    }

    public float getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23932c : invokeV.floatValue;
    }

    public Drawable getSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23935f : (Drawable) invokeV.objValue;
    }

    public int getSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            this.f23936g.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            this.f23936g.b(i, i2);
        }
    }

    public void setAutoHide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    public void setCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f23931b = i;
            requestLayout();
            invalidate();
        }
    }

    public void setDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            this.f23934e = drawable;
            requestLayout();
            invalidate();
        }
    }

    public void setPosition(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            this.f23932c = f2;
            invalidate();
        }
    }

    public void setSelector(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, drawable) == null) {
            this.f23935f = drawable;
            requestLayout();
            invalidate();
        }
    }

    public void setSpacing(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.a = i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
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
        this.f23936g = new b(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04009c, R.attr.obfuscated_res_0x7f040196, R.attr.obfuscated_res_0x7f0401be, R.attr.obfuscated_res_0x7f040542, R.attr.obfuscated_res_0x7f040570});
        this.a = obtainStyledAttributes.getDimensionPixelSize(4, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.f23931b = obtainStyledAttributes.getInteger(1, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(2);
        this.f23934e = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f23934e.getIntrinsicHeight());
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(3);
        this.f23935f = drawable2;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f23935f.getIntrinsicHeight());
        }
        obtainStyledAttributes.getBoolean(0, false);
    }
}
