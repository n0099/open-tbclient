package com.baidu.adp.widget.BdSwitchView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BdSwitchView extends View implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwitchState a;
    public float b;
    public float c;
    public GradientDrawable d;
    public GradientDrawable e;
    public GradientDrawable f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public int m;
    public b n;
    public Vibrator o;
    public Runnable p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class SwitchState {
        public static final /* synthetic */ SwitchState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SwitchState OFF;
        public static final SwitchState ON;
        public transient /* synthetic */ FieldHolder $fh;
        public int bgColorId;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1472380370, "Lcom/baidu/adp/widget/BdSwitchView/BdSwitchView$SwitchState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1472380370, "Lcom/baidu/adp/widget/BdSwitchView/BdSwitchView$SwitchState;");
                    return;
                }
            }
            ON = new SwitchState("ON", 0, R.color.CAM_X0302);
            SwitchState switchState = new SwitchState("OFF", 1, R.color.CAM_X0111);
            OFF = switchState;
            $VALUES = new SwitchState[]{ON, switchState};
        }

        public SwitchState(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.bgColorId = i2;
        }

        public static SwitchState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SwitchState) Enum.valueOf(SwitchState.class, str) : (SwitchState) invokeL.objValue;
        }

        public static SwitchState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SwitchState[]) $VALUES.clone() : (SwitchState[]) invokeV.objValue;
        }

        public int getBgColorId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bgColorId : invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSwitchView a;

        public a(BdSwitchView bdSwitchView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwitchView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSwitchView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void j0(View view2, SwitchState switchState);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdSwitchView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = SwitchState.ON;
        this.g = false;
        this.h = false;
        this.i = false;
        new Paint();
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = null;
        this.p = new a(this);
        e(context);
    }

    private GradientDrawable getBtnDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? SkinManager.createShapeDrawableFromColor((int) getResources().getDimension(R.dimen.tbds30), R.color.CAM_X0101, null, 0) : (GradientDrawable) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = d(SwitchState.ON);
            this.e = d(SwitchState.OFF);
            this.f = getBtnDrawable();
            invalidate();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setTag("TOUCH_STATE");
            SwitchState switchState = this.a;
            if (switchState == SwitchState.ON) {
                g(SwitchState.OFF, true);
            } else if (switchState == SwitchState.OFF) {
                g(SwitchState.ON, true);
            }
        }
    }

    public final GradientDrawable d(SwitchState switchState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, switchState)) == null) {
            GradientDrawable createShapeDrawableFromColor = SkinManager.createShapeDrawableFromColor((int) getResources().getDimension(R.dimen.tbds38), switchState.getBgColorId(), null, 0);
            createShapeDrawableFromColor.setBounds(0, 0, this.j, this.k);
            return createShapeDrawableFromColor;
        }
        return (GradientDrawable) invokeL.objValue;
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.j = (int) getResources().getDimension(R.dimen.tbds117);
            this.k = (int) getResources().getDimension(R.dimen.tbds75);
            this.l = (int) getResources().getDimension(R.dimen.tbds60);
            this.m = (int) getResources().getDimension(R.dimen.tbds8);
            this.d = d(SwitchState.ON);
            this.e = d(SwitchState.OFF);
            this.f = getBtnDrawable();
            setOnTouchListener(this);
            this.o = (Vibrator) getContext().getSystemService("vibrator");
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a == SwitchState.ON : invokeV.booleanValue;
    }

    public final void g(SwitchState switchState, boolean z) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, switchState, z) == null) || this.i) {
            return;
        }
        this.i = true;
        if (switchState == SwitchState.ON) {
            this.c = this.j;
        } else if (switchState == SwitchState.OFF) {
            this.c = 0.0f;
        }
        if (z && switchState != this.a && (bVar = this.n) != null) {
            bVar.j0(this, switchState);
        }
        this.a = switchState;
        this.i = false;
        invalidate();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            g(SwitchState.OFF, true);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.a == SwitchState.OFF) {
            return;
        }
        h();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SwitchState switchState = this.a;
            SwitchState switchState2 = SwitchState.OFF;
            if (switchState == switchState2) {
                return;
            }
            g(switchState2, false);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            g(SwitchState.ON, true);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || this.a == SwitchState.ON) {
            return;
        }
        k();
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SwitchState switchState = this.a;
            SwitchState switchState2 = SwitchState.ON;
            if (switchState == switchState2) {
                return;
            }
            g(switchState2, false);
        }
    }

    public final void n() {
        Vibrator vibrator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (vibrator = this.o) == null) {
            return;
        }
        vibrator.vibrate(30L);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.g) {
                if (this.c < this.j / 2.0f) {
                    this.e.draw(canvas);
                } else {
                    this.d.draw(canvas);
                }
            } else {
                SwitchState switchState = this.a;
                if (switchState == SwitchState.ON) {
                    this.d.draw(canvas);
                } else if (switchState == SwitchState.OFF) {
                    this.e.draw(canvas);
                }
            }
            if (this.g) {
                float f2 = this.c;
                int i3 = this.j;
                if (f2 > i3) {
                    f2 = i3;
                    i2 = this.l;
                } else {
                    i2 = this.l;
                }
                f = f2 - (i2 / 2.0f);
            } else {
                SwitchState switchState2 = this.a;
                if (switchState2 == SwitchState.ON) {
                    i = (this.j - this.l) - this.m;
                } else if (switchState2 == SwitchState.OFF) {
                    i = this.m;
                } else {
                    f = 0.0f;
                }
                f = i;
            }
            int i4 = this.m;
            if (f < i4) {
                f = i4;
            } else {
                int i5 = this.j;
                int i6 = this.l;
                if (f > (i5 - i6) - i4) {
                    f = (i5 - i6) - i4;
                }
            }
            GradientDrawable gradientDrawable = this.f;
            int i7 = (int) f;
            int i8 = this.m;
            int i9 = this.l;
            gradientDrawable.setBounds(i7, i8, i7 + i9, i9 + i8);
            this.f.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) {
            super.onMeasure(i, i2);
            setMeasuredDimension(this.j, this.k);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        SwitchState switchState;
        b bVar;
        SwitchState switchState2;
        b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, view2, motionEvent)) == null) {
            if (this.i) {
                return false;
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                if (motionEvent.getX() > this.j || motionEvent.getY() > this.k) {
                    return false;
                }
                postDelayed(this.p, 200L);
                this.g = true;
                float x = motionEvent.getX();
                this.b = x;
                this.c = x;
                n();
                return true;
            } else if (action == 1) {
                this.g = false;
                SwitchState switchState3 = this.a;
                if (Math.abs(this.c - this.b) <= this.j * 0.02d) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.p);
                this.i = true;
                if (motionEvent.getX() >= this.j / 2.0f) {
                    this.a = SwitchState.ON;
                } else {
                    this.a = SwitchState.OFF;
                }
                if (this.h && switchState3 != (switchState = this.a) && (bVar = this.n) != null) {
                    bVar.j0(this, switchState);
                }
                this.i = false;
                invalidate();
                return true;
            } else if (action == 2) {
                float x2 = motionEvent.getX();
                this.c = x2;
                if (Math.abs(x2 - this.b) > this.j * 0.05d) {
                    removeCallbacks(this.p);
                    if (Math.abs(this.c - this.b) > this.j * 0.1d) {
                        invalidate();
                    }
                }
                return true;
            } else if (action != 3) {
                return true;
            } else {
                this.g = false;
                SwitchState switchState4 = this.a;
                removeCallbacks(this.p);
                this.i = true;
                if (this.c >= this.j / 2.0f) {
                    this.a = SwitchState.ON;
                } else {
                    this.a = SwitchState.OFF;
                }
                if (this.h && switchState4 != (switchState2 = this.a) && (bVar2 = this.n) != null) {
                    bVar2.j0(this, switchState2);
                }
                this.i = false;
                invalidate();
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public void setOnSwitchStateChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            this.h = true;
            this.n = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdSwitchView(Context context, AttributeSet attributeSet) {
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
        this.a = SwitchState.ON;
        this.g = false;
        this.h = false;
        this.i = false;
        new Paint();
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = null;
        this.p = new a(this);
        e(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdSwitchView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = SwitchState.ON;
        this.g = false;
        this.h = false;
        this.i = false;
        new Paint();
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = null;
        this.p = new a(this);
        e(context);
    }
}
