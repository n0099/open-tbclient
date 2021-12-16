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
import com.baidu.adp.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class BdSwitchView extends View implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public SwitchState f32127e;

    /* renamed from: f  reason: collision with root package name */
    public float f32128f;

    /* renamed from: g  reason: collision with root package name */
    public float f32129g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f32130h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f32131i;

    /* renamed from: j  reason: collision with root package name */
    public Bitmap f32132j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f32133k;
    public boolean l;
    public boolean m;
    public Paint n;
    public int o;
    public int p;
    public int q;
    public b r;
    public Runnable s;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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

        public SwitchState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
    /* loaded from: classes9.dex */
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

        public SwitchStyle(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSwitchView f32134e;

        public a(BdSwitchView bdSwitchView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSwitchView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32134e = bdSwitchView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f32134e.b();
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void OnSwitchStateChange(View view, SwitchState switchState);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32127e = SwitchState.ON;
        this.f32133k = false;
        this.l = false;
        this.m = false;
        this.n = new Paint();
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = null;
        this.s = new a(this);
        d(context);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SwitchState switchState = this.f32127e;
            if (switchState == SwitchState.ON) {
                e(SwitchState.OFF, true);
            } else if (switchState == SwitchState.OFF) {
                e(SwitchState.ON, true);
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f32130h = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_open);
            this.f32131i = BitmapFactory.decodeResource(getResources(), R.drawable.bg_switch_close);
            this.f32132j = BitmapFactory.decodeResource(getResources(), R.drawable.btn_handle);
            this.o = this.f32130h.getWidth();
            this.p = this.f32130h.getHeight();
            this.q = this.f32132j.getWidth();
            setOnTouchListener(this);
        }
    }

    public final void e(SwitchState switchState, boolean z) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, switchState, z) == null) || this.m) {
            return;
        }
        this.m = true;
        if (switchState == SwitchState.ON) {
            this.f32129g = this.o;
        } else if (switchState == SwitchState.OFF) {
            this.f32129g = 0.0f;
        }
        if (z && switchState != this.f32127e && (bVar = this.r) != null) {
            bVar.OnSwitchStateChange(this, switchState);
        }
        this.f32127e = switchState;
        this.m = false;
        invalidate();
    }

    public boolean isOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32127e == SwitchState.ON : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f32133k) {
                if (this.f32129g < this.o / 2.0f) {
                    canvas.drawBitmap(this.f32131i, 0.0f, 0.0f, this.n);
                } else {
                    canvas.drawBitmap(this.f32130h, 0.0f, 0.0f, this.n);
                }
            } else {
                SwitchState switchState = this.f32127e;
                if (switchState == SwitchState.ON) {
                    canvas.drawBitmap(this.f32130h, 0.0f, 0.0f, this.n);
                } else if (switchState == SwitchState.OFF) {
                    canvas.drawBitmap(this.f32131i, 0.0f, 0.0f, this.n);
                }
            }
            if (this.f32133k) {
                if (this.f32129g > this.f32130h.getWidth()) {
                    f3 = this.o;
                    i2 = this.q;
                } else {
                    f3 = this.f32129g;
                    i2 = this.q;
                }
                f2 = f3 - (i2 / 2.0f);
            } else if (this.f32127e == SwitchState.ON) {
                f2 = this.o - this.q;
            } else {
                SwitchState switchState2 = SwitchState.OFF;
                f2 = 0.0f;
            }
            if (f2 < 0.0f) {
                f2 = 0.0f;
            } else {
                int i3 = this.o;
                int i4 = this.q;
                if (f2 > i3 - i4) {
                    f2 = i3 - i4;
                }
            }
            canvas.drawBitmap(this.f32132j, f2, 0.0f, this.n);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(this.o, this.p);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        SwitchState switchState;
        b bVar;
        SwitchState switchState2;
        b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view, motionEvent)) == null) {
            if (this.m) {
                return false;
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                if (motionEvent.getX() > this.o || motionEvent.getY() > this.p) {
                    return false;
                }
                postDelayed(this.s, 200L);
                this.f32133k = true;
                float x = motionEvent.getX();
                this.f32128f = x;
                this.f32129g = x;
                return true;
            } else if (action == 1) {
                this.f32133k = false;
                SwitchState switchState3 = this.f32127e;
                if (Math.abs(this.f32129g - this.f32128f) <= this.o * 0.02d) {
                    invalidate();
                    return true;
                }
                removeCallbacks(this.s);
                this.m = true;
                if (motionEvent.getX() >= this.o / 2.0f) {
                    this.f32127e = SwitchState.ON;
                } else {
                    this.f32127e = SwitchState.OFF;
                }
                if (this.l && switchState3 != (switchState = this.f32127e) && (bVar = this.r) != null) {
                    bVar.OnSwitchStateChange(this, switchState);
                }
                this.m = false;
                invalidate();
                return true;
            } else if (action == 2) {
                float x2 = motionEvent.getX();
                this.f32129g = x2;
                if (Math.abs(x2 - this.f32128f) > this.o * 0.05d) {
                    removeCallbacks(this.s);
                    if (Math.abs(this.f32129g - this.f32128f) > this.o * 0.1d) {
                        invalidate();
                    }
                }
                return true;
            } else if (action != 3) {
                return true;
            } else {
                this.f32133k = false;
                SwitchState switchState4 = this.f32127e;
                removeCallbacks(this.s);
                this.m = true;
                if (this.f32129g >= this.o / 2.0f) {
                    this.f32127e = SwitchState.ON;
                } else {
                    this.f32127e = SwitchState.OFF;
                }
                if (this.l && switchState4 != (switchState2 = this.f32127e) && (bVar2 = this.r) != null) {
                    bVar2.OnSwitchStateChange(this, switchState2);
                }
                this.m = false;
                invalidate();
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public void setBackgroundRes(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, bitmap, bitmap2, bitmap3) == null) {
            this.f32130h = bitmap;
            this.f32131i = bitmap2;
            this.f32132j = bitmap3;
            invalidate();
        }
    }

    public void setOnSwitchStateChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.l = true;
            this.r = bVar;
        }
    }

    public void turnOff() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            e(SwitchState.OFF, true);
        }
    }

    public void turnOffNoCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SwitchState switchState = this.f32127e;
            SwitchState switchState2 = SwitchState.OFF;
            if (switchState == switchState2) {
                return;
            }
            e(switchState2, false);
        }
    }

    public void turnOn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            e(SwitchState.ON, true);
        }
    }

    public void turnOnNoCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            SwitchState switchState = this.f32127e;
            SwitchState switchState2 = SwitchState.ON;
            if (switchState == switchState2) {
                return;
            }
            e(switchState2, false);
        }
    }

    public void turnOff(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || this.f32127e == SwitchState.OFF) {
            return;
        }
        turnOff();
    }

    public void turnOn(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.f32127e == SwitchState.ON) {
            return;
        }
        turnOn();
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
        this.f32127e = SwitchState.ON;
        this.f32133k = false;
        this.l = false;
        this.m = false;
        this.n = new Paint();
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = null;
        this.s = new a(this);
        d(context);
    }
}
