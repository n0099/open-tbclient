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
import com.baidu.tieba.zn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes.dex */
public class IndicatorView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public float c;
    public float d;
    public Drawable e;
    public Drawable f;
    public final zn g;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public void setAutoHide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements zn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public long b;
        public long c;
        public int d;
        public float e;
        public final a f;
        public final /* synthetic */ IndicatorView g;

        @Override // com.baidu.tieba.zn
        public boolean a(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.zn
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.zn
        public boolean e(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        /* loaded from: classes.dex */
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
                if ((interceptable != null && interceptable.invokeL(1048576, this, message) != null) || message.what != 1000) {
                    return;
                }
                this.a.g();
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
            this.g = indicatorView;
            this.f = new a(this, null);
            this.a = (int) ((indicatorView.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        }

        @Override // com.baidu.tieba.zn
        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.g.d > this.g.c) {
                    this.d = this.a;
                } else if (this.g.d < this.g.c) {
                    this.d = -this.a;
                } else {
                    return;
                }
                this.e = this.g.c;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.b = uptimeMillis;
                this.c = uptimeMillis + 16;
                this.f.removeMessages(1000);
                this.f.sendEmptyMessageAtTime(1000, this.c);
            }
        }

        @Override // com.baidu.tieba.zn
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                if (this.g.e != null && this.g.f != null && this.g.b != 0) {
                    this.g.setWillNotDraw(false);
                    this.g.setMeasuredDimension(i(i), h(i2));
                    return;
                }
                this.g.setWillNotDraw(true);
                this.g.setMeasuredDimension(0, 0);
            }
        }

        @Override // com.baidu.tieba.zn
        public void draw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
                int save = canvas.save();
                for (int i = 0; i < this.g.b; i++) {
                    if (i != 0) {
                        canvas.translate(this.g.e.getBounds().width() + this.g.a, 0.0f);
                    }
                    this.g.e.draw(canvas);
                }
                if (save >= 1 && save <= canvas.getSaveCount()) {
                    canvas.restoreToCount(save);
                }
                int save2 = canvas.save();
                if (this.g.c > (this.g.b - 1) + 0.5d) {
                    this.g.c = 0.0f;
                }
                canvas.translate((this.g.f.getBounds().width() + this.g.a) * this.g.c, 0.0f);
                this.g.f.draw(canvas);
                if (save2 >= 1 && save2 <= canvas.getSaveCount()) {
                    canvas.restoreToCount(save2);
                }
            }
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                float f = this.e;
                int i = this.d;
                float f2 = f + (i * (((float) (uptimeMillis - this.b)) / 1000.0f));
                this.e = f2;
                this.b = uptimeMillis;
                this.c = uptimeMillis + 16;
                if (i < 0) {
                    if (f2 < this.g.d) {
                        IndicatorView indicatorView = this.g;
                        indicatorView.c = indicatorView.d;
                    } else {
                        this.g.c = this.e;
                        this.f.removeMessages(1000);
                        this.f.sendEmptyMessageAtTime(1000, this.c);
                    }
                } else if (f2 > this.g.d) {
                    IndicatorView indicatorView2 = this.g;
                    indicatorView2.c = indicatorView2.d;
                } else {
                    this.g.c = this.e;
                    this.f.removeMessages(1000);
                    this.f.sendEmptyMessageAtTime(1000, this.c);
                }
                this.g.invalidate();
            }
        }

        public final int h(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                int i2 = (-1073741824) & i;
                int i3 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                int max = Math.max(this.g.e.getIntrinsicHeight(), this.g.f.getIntrinsicHeight());
                if (i2 != Integer.MIN_VALUE) {
                    if (i2 != 0) {
                        if (i2 != 1073741824) {
                            return i3;
                        }
                        this.g.e.setBounds(0, 0, this.g.e.getBounds().width(), i3);
                        this.g.f.setBounds(0, 0, this.g.f.getBounds().width(), i3);
                        return i3;
                    }
                    this.g.e.setBounds(0, 0, this.g.e.getBounds().width(), max);
                    this.g.f.setBounds(0, 0, this.g.f.getBounds().width(), max);
                    return max;
                }
                int min = Math.min(i3, max);
                this.g.e.setBounds(0, 0, this.g.e.getBounds().width(), min);
                this.g.f.setBounds(0, 0, this.g.f.getBounds().width(), min);
                return min;
            }
            return invokeI.intValue;
        }

        public final int i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                int i2 = (-1073741824) & i;
                int i3 = i & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
                int max = (this.g.a * (this.g.b - 1)) + (Math.max(this.g.e.getIntrinsicWidth(), this.g.f.getIntrinsicWidth()) * this.g.b);
                if (i2 != Integer.MIN_VALUE) {
                    if (i2 != 0) {
                        if (i2 != 1073741824) {
                            return i3;
                        }
                        int i4 = (int) ((i3 - (this.g.a * (this.g.b - 1))) / this.g.b);
                        this.g.f.setBounds(0, 0, i4, this.g.f.getBounds().height());
                        this.g.e.setBounds(0, 0, i4, this.g.e.getBounds().height());
                        return i3;
                    }
                    this.g.e.setBounds(0, 0, this.g.e.getIntrinsicWidth(), 0);
                    this.g.f.setBounds(0, 0, this.g.f.getIntrinsicWidth(), 0);
                    return max;
                }
                int min = Math.min(i3, max);
                this.g.e.setBounds(0, 0, this.g.e.getIntrinsicWidth(), this.g.e.getBounds().height());
                this.g.f.setBounds(0, 0, this.g.f.getIntrinsicWidth(), this.g.f.getBounds().height());
                return min;
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
        this.g = new b(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
        this.a = obtainStyledAttributes.getDimensionPixelSize(4, (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f));
        this.b = obtainStyledAttributes.getInteger(1, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(2);
        this.e = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.e.getIntrinsicHeight());
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(3);
        this.f = drawable2;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f.getIntrinsicHeight());
        }
        obtainStyledAttributes.getBoolean(0, false);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            this.g.draw(canvas);
        }
    }

    public void setCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.b = i;
            requestLayout();
            invalidate();
        }
    }

    public void setDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            this.e = drawable;
            requestLayout();
            invalidate();
        }
    }

    public void setPosition(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            this.c = f;
            invalidate();
        }
    }

    public void setSelector(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, drawable) == null) {
            this.f = drawable;
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

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            this.g.b(i, i2);
        }
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public Drawable getDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (Drawable) invokeV.objValue;
    }

    public float getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.floatValue;
    }

    public Drawable getSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (Drawable) invokeV.objValue;
    }

    public int getSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }
}
