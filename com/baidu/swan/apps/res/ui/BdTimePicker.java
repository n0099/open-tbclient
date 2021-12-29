package com.baidu.swan.apps.res.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f;
import c.a.r0.a.g;
import c.a.r0.a.z2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes11.dex */
public class BdTimePicker extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f40399e;

    /* renamed from: f  reason: collision with root package name */
    public int f40400f;

    /* renamed from: g  reason: collision with root package name */
    public WheelView3d f40401g;

    /* renamed from: h  reason: collision with root package name */
    public WheelView3d f40402h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f40403i;

    /* renamed from: j  reason: collision with root package name */
    public int f40404j;

    /* renamed from: k  reason: collision with root package name */
    public int f40405k;
    public int l;
    public int m;
    public Date n;
    public Date o;
    public int p;
    public int q;
    public int r;
    public Paint s;

    /* loaded from: classes11.dex */
    public class a implements c.a.r0.a.c2.a.e.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTimePicker a;

        public a(BdTimePicker bdTimePicker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTimePicker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTimePicker;
        }

        @Override // c.a.r0.a.c2.a.e.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i2) == null) {
                BdTimePicker bdTimePicker = this.a;
                bdTimePicker.f40399e = i2 + bdTimePicker.f40404j;
                this.a.i();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements c.a.r0.a.c2.a.e.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTimePicker a;

        public b(BdTimePicker bdTimePicker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTimePicker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTimePicker;
        }

        @Override // c.a.r0.a.c2.a.e.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i2) == null) {
                BdTimePicker bdTimePicker = this.a;
                bdTimePicker.f40400f = i2 + bdTimePicker.l;
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface c {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTimePicker(Context context) {
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
        this.f40399e = 0;
        this.f40400f = 0;
        this.p = 15;
        f(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
            canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.f40401g.getCenterContentOffset() * 2.0f), this.s);
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(0);
            LayoutInflater.from(context).inflate(g.aiapps_timepicker_layout, this);
            this.p = n0.f(context, this.p);
            this.q = n0.f(context, 16.0f);
            this.r = n0.f(context, 14.0f);
            j();
            this.f40403i = (LinearLayout) findViewById(f.timepicker_root);
            WheelView3d wheelView3d = (WheelView3d) findViewById(f.wheel_hour);
            this.f40401g = wheelView3d;
            wheelView3d.setLineSpacingMultiplier(3.0f);
            this.f40401g.setCenterTextSize(this.q);
            this.f40401g.setOuterTextSize(this.r);
            this.f40401g.setTextColorCenter(-16777216);
            this.f40401g.setTextColorOut(-16777216);
            this.f40401g.setVisibleItem(7);
            this.f40401g.setGravityOffset(this.p);
            this.f40401g.setGravity(5);
            this.f40401g.setDividerType(WheelView3d.DividerType.FILL);
            this.f40401g.setDividerColor(0);
            this.f40401g.setOnItemSelectedListener(new a(this));
            WheelView3d wheelView3d2 = (WheelView3d) findViewById(f.wheel_minute);
            this.f40402h = wheelView3d2;
            wheelView3d2.setLineSpacingMultiplier(3.0f);
            this.f40402h.setCenterTextSize(this.q);
            this.f40402h.setOuterTextSize(this.r);
            this.f40402h.setTextColorCenter(-16777216);
            this.f40402h.setTextColorOut(-16777216);
            this.f40402h.setGravityOffset(this.p);
            this.f40402h.setGravity(3);
            this.f40402h.setDividerType(WheelView3d.DividerType.FILL);
            this.f40402h.setDividerColor(0);
            this.f40402h.setVisibleItem(7);
            this.f40402h.setOnItemSelectedListener(new b(this));
            g();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Calendar calendar = Calendar.getInstance();
            this.f40399e = calendar.get(11);
            this.f40400f = calendar.get(12);
            updateDatas();
        }
    }

    public int getHour() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40399e : invokeV.intValue;
    }

    public int getMinute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40400f : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048581, this) != null) {
            return;
        }
        this.f40404j = 0;
        this.f40405k = 23;
        Date date = this.n;
        if (date != null) {
            this.f40404j = date.getHours();
        }
        Date date2 = this.o;
        if (date2 != null) {
            this.f40405k = date2.getHours();
        }
        ArrayList arrayList = new ArrayList((this.f40405k - this.f40404j) + 1);
        int i2 = this.f40404j;
        while (true) {
            int i3 = this.f40405k;
            if (i2 > i3) {
                this.f40401g.setAdapter(new c.a.r0.a.c2.a.e.a.b(this.f40404j, i3));
                k(this.f40401g, this.f40404j, this.f40405k);
                setHour(this.f40399e);
                return;
            }
            arrayList.add(String.format("%02d", Integer.valueOf(i2)));
            i2++;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048582, this) != null) {
            return;
        }
        this.l = 0;
        this.m = 59;
        Date date = this.n;
        if (date != null && this.f40399e == this.f40404j) {
            this.l = date.getMinutes();
        }
        Date date2 = this.o;
        if (date2 != null && this.f40399e == this.f40405k) {
            this.m = date2.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.m - this.l) + 1);
        int i2 = this.l;
        while (true) {
            int i3 = this.m;
            if (i2 > i3) {
                this.f40402h.setAdapter(new c.a.r0.a.c2.a.e.a.b(this.l, i3));
                k(this.f40402h, this.l, this.m);
                setMinute(this.f40400f);
                return;
            }
            arrayList.add(String.format("%02d", Integer.valueOf(i2)));
            i2++;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Paint paint = new Paint();
            this.s = paint;
            paint.setColor(-16777216);
            this.s.setAntiAlias(true);
            this.s.setTextSize(this.q);
        }
    }

    public final void k(WheelView3d wheelView3d, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, wheelView3d, i2, i3) == null) || (i3 - i2) + 1 > 3) {
            return;
        }
        wheelView3d.setCyclic(false);
    }

    public void setDisabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f40401g.setIsOptions(z);
            this.f40402h.setIsOptions(z);
        }
    }

    public void setHour(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            int i3 = this.f40404j;
            if (i2 < i3 || i2 > (i3 = this.f40405k)) {
                i2 = i3;
            }
            this.f40399e = i2;
            this.f40401g.setCurrentItem(i2 - this.f40404j);
        }
    }

    public void setMinute(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            int i3 = this.l;
            if (i2 < i3 || i2 > (i3 = this.m)) {
                i2 = i3;
            }
            this.f40400f = i2;
            this.f40402h.setCurrentItem(i2 - this.l);
        }
    }

    public void setOnTimeChangeListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
        }
    }

    public void setScrollCycle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f40402h.setCyclic(z);
            this.f40401g.setCyclic(z);
        }
    }

    public void setStartDate(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, date) == null) {
            this.n = date;
        }
    }

    public void setmEndDate(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, date) == null) {
            this.o = date;
        }
    }

    public void updateDatas() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            h();
            i();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTimePicker(Context context, AttributeSet attributeSet) {
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
        this.f40399e = 0;
        this.f40400f = 0;
        this.p = 15;
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i2) {
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
        this.f40399e = 0;
        this.f40400f = 0;
        this.p = 15;
        f(context);
    }
}
