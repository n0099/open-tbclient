package com.baidu.adp.widget.BdSwitchView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
    public Bitmap d;
    public Bitmap e;
    public Bitmap f;
    public boolean g;
    public boolean h;
    public boolean i;
    public Paint j;
    public int k;
    public int l;
    public int m;
    public b n;
    public Runnable o;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class SwitchState {
        public static final /* synthetic */ SwitchState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SwitchState OFF;
        public static final SwitchState ON;
        public transient /* synthetic */ FieldHolder $fh;

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
            ON = new SwitchState("ON", 0);
            SwitchState switchState = new SwitchState("OFF", 1);
            OFF = switchState;
            $VALUES = new SwitchState[]{ON, switchState};
        }

        public SwitchState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
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
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class SwitchStyle {
        public static final /* synthetic */ SwitchStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SwitchStyle DAY;
        public static final SwitchStyle NIGHT;
        public static final SwitchStyle SIDE_BAR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1471673074, "Lcom/baidu/adp/widget/BdSwitchView/BdSwitchView$SwitchStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1471673074, "Lcom/baidu/adp/widget/BdSwitchView/BdSwitchView$SwitchStyle;");
                    return;
                }
            }
            DAY = new SwitchStyle("DAY", 0);
            NIGHT = new SwitchStyle("NIGHT", 1);
            SwitchStyle switchStyle = new SwitchStyle("SIDE_BAR", 2);
            SIDE_BAR = switchStyle;
            $VALUES = new SwitchStyle[]{DAY, NIGHT, switchStyle};
        }

        public SwitchStyle(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SwitchStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SwitchStyle) Enum.valueOf(SwitchStyle.class, str) : (SwitchStyle) invokeL.objValue;
        }

        public static SwitchStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SwitchStyle[]) $VALUES.clone() : (SwitchStyle[]) invokeV.objValue;
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
                this.a.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void OnSwitchStateChange(View view2, SwitchState switchState);
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
        this.j = new Paint();
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = null;
        this.o = new a(this);
        c(context);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SwitchState switchState = this.a;
            if (switchState == SwitchState.ON) {
                e(SwitchState.OFF, true);
            } else if (switchState == SwitchState.OFF) {
                e(SwitchState.ON, true);
            }
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.d = BitmapFactory.decodeResource(getResources(), R.drawable.obfuscated_res_0x7f0802e5);
            this.e = BitmapFactory.decodeResource(getResources(), R.drawable.obfuscated_res_0x7f0802e4);
            this.f = BitmapFactory.decodeResource(getResources(), R.drawable.obfuscated_res_0x7f080398);
            this.k = this.d.getWidth();
            this.l = this.d.getHeight();
            this.m = this.f.getWidth();
            setOnTouchListener(this);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a == SwitchState.ON : invokeV.booleanValue;
    }

    public final void e(SwitchState switchState, boolean z) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, switchState, z) == null) || this.i) {
            return;
        }
        this.i = true;
        if (switchState == SwitchState.ON) {
            this.c = this.k;
        } else if (switchState == SwitchState.OFF) {
            this.c = 0.0f;
        }
        if (z && switchState != this.a && (bVar = this.n) != null) {
            bVar.OnSwitchStateChange(this, switchState);
        }
        this.a = switchState;
        this.i = false;
        invalidate();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e(SwitchState.OFF, true);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.a == SwitchState.OFF) {
            return;
        }
        f();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SwitchState switchState = this.a;
            SwitchState switchState2 = SwitchState.OFF;
            if (switchState == switchState2) {
                return;
            }
            e(switchState2, false);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            e(SwitchState.ON, true);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || this.a == SwitchState.ON) {
            return;
        }
        j();
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SwitchState switchState = this.a;
            SwitchState switchState2 = SwitchState.ON;
            if (switchState == switchState2) {
                return;
            }
            e(switchState2, false);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.g) {
                if (this.c < this.k / 2.0f) {
                    canvas.drawBitmap(this.e, 0.0f, 0.0f, this.j);
                } else {
                    canvas.drawBitmap(this.d, 0.0f, 0.0f, this.j);
                }
            } else {
                SwitchState switchState = this.a;
                if (switchState == SwitchState.ON) {
                    canvas.drawBitmap(this.d, 0.0f, 0.0f, this.j);
                } else if (switchState == SwitchState.OFF) {
                    canvas.drawBitmap(this.e, 0.0f, 0.0f, this.j);
                }
            }
            if (this.g) {
                if (this.c > this.d.getWidth()) {
                    f2 = this.k;
                    i = this.m;
                } else {
                    f2 = this.c;
                    i = this.m;
                }
                f = f2 - (i / 2.0f);
            } else if (this.a == SwitchState.ON) {
                f = this.k - this.m;
            } else {
                SwitchState switchState2 = SwitchState.OFF;
                f = 0.0f;
            }
            if (f < 0.0f) {
                f = 0.0f;
            } else {
                int i2 = this.k;
                int i3 = this.m;
                if (f > i2 - i3) {
                    f = i2 - i3;
                }
            }
            canvas.drawBitmap(this.f, f, 0.0f, this.j);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            super.onMeasure(i, i2);
            setMeasuredDimension(this.k, this.l);
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, view2, motionEvent)) == null) {
            if (this.i) {
                return false;
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                if (motionEvent.getX() > this.k || motionEvent.getY() > this.l) {
                    return false;
                }
                postDelayed(this.o, 200L);
                this.g = true;
                float x = motionEvent.getX();
                this.b = x;
                this.c = x;
                return true;
            } else if (action == 1) {
                this.g = false;
                SwitchState switchState3 = this.a;
                if (Math.abs(this.c - this.b) <= this.k * 0.02d) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.o);
                this.i = true;
                if (motionEvent.getX() >= this.k / 2.0f) {
                    this.a = SwitchState.ON;
                } else {
                    this.a = SwitchState.OFF;
                }
                if (this.h && switchState3 != (switchState = this.a) && (bVar = this.n) != null) {
                    bVar.OnSwitchStateChange(this, switchState);
                }
                this.i = false;
                invalidate();
                return true;
            } else if (action == 2) {
                float x2 = motionEvent.getX();
                this.c = x2;
                if (Math.abs(x2 - this.b) > this.k * 0.05d) {
                    removeCallbacks(this.o);
                    if (Math.abs(this.c - this.b) > this.k * 0.1d) {
                        invalidate();
                    }
                }
                return true;
            } else if (action != 3) {
                return true;
            } else {
                this.g = false;
                SwitchState switchState4 = this.a;
                removeCallbacks(this.o);
                this.i = true;
                if (this.c >= this.k / 2.0f) {
                    this.a = SwitchState.ON;
                } else {
                    this.a = SwitchState.OFF;
                }
                if (this.h && switchState4 != (switchState2 = this.a) && (bVar2 = this.n) != null) {
                    bVar2.OnSwitchStateChange(this, switchState2);
                }
                this.i = false;
                invalidate();
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, bitmap, bitmap2, bitmap3) == null) {
            this.d = bitmap;
            this.e = bitmap2;
            this.f = bitmap3;
            invalidate();
        }
    }

    public void setOnSwitchStateChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
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
        this.j = new Paint();
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = null;
        this.o = new a(this);
        c(context);
    }
}
