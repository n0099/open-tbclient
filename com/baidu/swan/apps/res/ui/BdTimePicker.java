package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f;
import b.a.p0.a.g;
import b.a.p0.a.v2.n0;
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
/* loaded from: classes8.dex */
public class BdTimePicker extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f43953e;

    /* renamed from: f  reason: collision with root package name */
    public int f43954f;

    /* renamed from: g  reason: collision with root package name */
    public WheelView3d f43955g;

    /* renamed from: h  reason: collision with root package name */
    public WheelView3d f43956h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f43957i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Date n;
    public Date o;
    public int p;
    public int q;
    public int r;
    public Paint s;

    /* loaded from: classes8.dex */
    public class a implements b.a.p0.a.z1.a.e.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdTimePicker f43958a;

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
            this.f43958a = bdTimePicker;
        }

        @Override // b.a.p0.a.z1.a.e.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i2) == null) {
                BdTimePicker bdTimePicker = this.f43958a;
                bdTimePicker.f43953e = i2 + bdTimePicker.j;
                this.f43958a.i();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements b.a.p0.a.z1.a.e.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdTimePicker f43959a;

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
            this.f43959a = bdTimePicker;
        }

        @Override // b.a.p0.a.z1.a.e.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i2) == null) {
                BdTimePicker bdTimePicker = this.f43959a;
                bdTimePicker.f43954f = i2 + bdTimePicker.l;
            }
        }
    }

    /* loaded from: classes8.dex */
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
        this.f43953e = 0;
        this.f43954f = 0;
        this.p = 15;
        f(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
            canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.f43955g.getCenterContentOffset() * 2.0f), this.s);
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
            this.f43957i = (LinearLayout) findViewById(f.timepicker_root);
            WheelView3d wheelView3d = (WheelView3d) findViewById(f.wheel_hour);
            this.f43955g = wheelView3d;
            wheelView3d.setLineSpacingMultiplier(3.0f);
            this.f43955g.setCenterTextSize(this.q);
            this.f43955g.setOuterTextSize(this.r);
            this.f43955g.setTextColorCenter(-16777216);
            this.f43955g.setTextColorOut(-16777216);
            this.f43955g.setVisibleItem(7);
            this.f43955g.setGravityOffset(this.p);
            this.f43955g.setGravity(5);
            this.f43955g.setDividerType(WheelView3d.DividerType.FILL);
            this.f43955g.setDividerColor(0);
            this.f43955g.setOnItemSelectedListener(new a(this));
            WheelView3d wheelView3d2 = (WheelView3d) findViewById(f.wheel_minute);
            this.f43956h = wheelView3d2;
            wheelView3d2.setLineSpacingMultiplier(3.0f);
            this.f43956h.setCenterTextSize(this.q);
            this.f43956h.setOuterTextSize(this.r);
            this.f43956h.setTextColorCenter(-16777216);
            this.f43956h.setTextColorOut(-16777216);
            this.f43956h.setGravityOffset(this.p);
            this.f43956h.setGravity(3);
            this.f43956h.setDividerType(WheelView3d.DividerType.FILL);
            this.f43956h.setDividerColor(0);
            this.f43956h.setVisibleItem(7);
            this.f43956h.setOnItemSelectedListener(new b(this));
            g();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Calendar calendar = Calendar.getInstance();
            this.f43953e = calendar.get(11);
            this.f43954f = calendar.get(12);
            updateDatas();
        }
    }

    public int getHour() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f43953e : invokeV.intValue;
    }

    public int getMinute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43954f : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048581, this) != null) {
            return;
        }
        this.j = 0;
        this.k = 23;
        Date date = this.n;
        if (date != null) {
            this.j = date.getHours();
        }
        Date date2 = this.o;
        if (date2 != null) {
            this.k = date2.getHours();
        }
        ArrayList arrayList = new ArrayList((this.k - this.j) + 1);
        int i2 = this.j;
        while (true) {
            int i3 = this.k;
            if (i2 > i3) {
                this.f43955g.setAdapter(new b.a.p0.a.z1.a.e.a.b(this.j, i3));
                k(this.f43955g, this.j, this.k);
                setHour(this.f43953e);
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
        if (date != null && this.f43953e == this.j) {
            this.l = date.getMinutes();
        }
        Date date2 = this.o;
        if (date2 != null && this.f43953e == this.k) {
            this.m = date2.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.m - this.l) + 1);
        int i2 = this.l;
        while (true) {
            int i3 = this.m;
            if (i2 > i3) {
                this.f43956h.setAdapter(new b.a.p0.a.z1.a.e.a.b(this.l, i3));
                k(this.f43956h, this.l, this.m);
                setMinute(this.f43954f);
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
            this.f43955g.setIsOptions(z);
            this.f43956h.setIsOptions(z);
        }
    }

    public void setHour(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            int i3 = this.j;
            if (i2 < i3 || i2 > (i3 = this.k)) {
                i2 = i3;
            }
            this.f43953e = i2;
            this.f43955g.setCurrentItem(i2 - this.j);
        }
    }

    public void setMinute(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            int i3 = this.l;
            if (i2 < i3 || i2 > (i3 = this.m)) {
                i2 = i3;
            }
            this.f43954f = i2;
            this.f43956h.setCurrentItem(i2 - this.l);
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
            this.f43956h.setCyclic(z);
            this.f43955g.setCyclic(z);
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
        this.f43953e = 0;
        this.f43954f = 0;
        this.p = 15;
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
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
        this.f43953e = 0;
        this.f43954f = 0;
        this.p = 15;
        f(context);
    }
}
