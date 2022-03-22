package com.baidu.swan.apps.res.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes4.dex */
public class BdTimePicker extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f29073b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView3d f29074c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView3d f29075d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f29076e;

    /* renamed from: f  reason: collision with root package name */
    public int f29077f;

    /* renamed from: g  reason: collision with root package name */
    public int f29078g;

    /* renamed from: h  reason: collision with root package name */
    public int f29079h;
    public int i;
    public Date j;
    public Date k;
    public int l;
    public int m;
    public int n;
    public Paint o;

    /* loaded from: classes4.dex */
    public class a implements c.a.n0.a.s1.a.e.c.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTimePicker;
        }

        @Override // c.a.n0.a.s1.a.e.c.b
        public void a(WheelView3d wheelView3d, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i) == null) {
                BdTimePicker bdTimePicker = this.a;
                bdTimePicker.a = i + bdTimePicker.f29077f;
                this.a.i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.n0.a.s1.a.e.c.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTimePicker;
        }

        @Override // c.a.n0.a.s1.a.e.c.b
        public void a(WheelView3d wheelView3d, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i) == null) {
                BdTimePicker bdTimePicker = this.a;
                bdTimePicker.f29073b = i + bdTimePicker.f29079h;
            }
        }
    }

    /* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f29073b = 0;
        this.l = 15;
        f(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
            canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.f29074c.getCenterContentOffset() * 2.0f), this.o);
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(0);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00da, this);
            this.l = n0.f(context, this.l);
            this.m = n0.f(context, 16.0f);
            this.n = n0.f(context, 14.0f);
            j();
            this.f29076e = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092001);
            WheelView3d wheelView3d = (WheelView3d) findViewById(R.id.obfuscated_res_0x7f092463);
            this.f29074c = wheelView3d;
            wheelView3d.setLineSpacingMultiplier(3.0f);
            this.f29074c.setCenterTextSize(this.m);
            this.f29074c.setOuterTextSize(this.n);
            this.f29074c.setTextColorCenter(-16777216);
            this.f29074c.setTextColorOut(-16777216);
            this.f29074c.setVisibleItem(7);
            this.f29074c.setGravityOffset(this.l);
            this.f29074c.setGravity(5);
            this.f29074c.setDividerType(WheelView3d.DividerType.FILL);
            this.f29074c.setDividerColor(0);
            this.f29074c.setOnItemSelectedListener(new a(this));
            WheelView3d wheelView3d2 = (WheelView3d) findViewById(R.id.obfuscated_res_0x7f092464);
            this.f29075d = wheelView3d2;
            wheelView3d2.setLineSpacingMultiplier(3.0f);
            this.f29075d.setCenterTextSize(this.m);
            this.f29075d.setOuterTextSize(this.n);
            this.f29075d.setTextColorCenter(-16777216);
            this.f29075d.setTextColorOut(-16777216);
            this.f29075d.setGravityOffset(this.l);
            this.f29075d.setGravity(3);
            this.f29075d.setDividerType(WheelView3d.DividerType.FILL);
            this.f29075d.setDividerColor(0);
            this.f29075d.setVisibleItem(7);
            this.f29075d.setOnItemSelectedListener(new b(this));
            g();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Calendar calendar = Calendar.getInstance();
            this.a = calendar.get(11);
            this.f29073b = calendar.get(12);
            l();
        }
    }

    public int getHour() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.intValue;
    }

    public int getMinute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29073b : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048581, this) != null) {
            return;
        }
        this.f29077f = 0;
        this.f29078g = 23;
        Date date = this.j;
        if (date != null) {
            this.f29077f = date.getHours();
        }
        Date date2 = this.k;
        if (date2 != null) {
            this.f29078g = date2.getHours();
        }
        ArrayList arrayList = new ArrayList((this.f29078g - this.f29077f) + 1);
        int i = this.f29077f;
        while (true) {
            int i2 = this.f29078g;
            if (i > i2) {
                this.f29074c.setAdapter(new c.a.n0.a.s1.a.e.a.b(this.f29077f, i2));
                k(this.f29074c, this.f29077f, this.f29078g);
                setHour(this.a);
                return;
            }
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
            i++;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048582, this) != null) {
            return;
        }
        this.f29079h = 0;
        this.i = 59;
        Date date = this.j;
        if (date != null && this.a == this.f29077f) {
            this.f29079h = date.getMinutes();
        }
        Date date2 = this.k;
        if (date2 != null && this.a == this.f29078g) {
            this.i = date2.getMinutes();
        }
        ArrayList arrayList = new ArrayList((this.i - this.f29079h) + 1);
        int i = this.f29079h;
        while (true) {
            int i2 = this.i;
            if (i > i2) {
                this.f29075d.setAdapter(new c.a.n0.a.s1.a.e.a.b(this.f29079h, i2));
                k(this.f29075d, this.f29079h, this.i);
                setMinute(this.f29073b);
                return;
            }
            arrayList.add(String.format("%02d", Integer.valueOf(i)));
            i++;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Paint paint = new Paint();
            this.o = paint;
            paint.setColor(-16777216);
            this.o.setAntiAlias(true);
            this.o.setTextSize(this.m);
        }
    }

    public final void k(WheelView3d wheelView3d, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, wheelView3d, i, i2) == null) || (i2 - i) + 1 > 3) {
            return;
        }
        wheelView3d.setCyclic(false);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            i();
        }
    }

    public void setDisabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f29074c.setIsOptions(z);
            this.f29075d.setIsOptions(z);
        }
    }

    public void setHour(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            int i2 = this.f29077f;
            if (i < i2 || i > (i2 = this.f29078g)) {
                i = i2;
            }
            this.a = i;
            this.f29074c.setCurrentItem(i - this.f29077f);
        }
    }

    public void setMinute(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            int i2 = this.f29079h;
            if (i < i2 || i > (i2 = this.i)) {
                i = i2;
            }
            this.f29073b = i;
            this.f29075d.setCurrentItem(i - this.f29079h);
        }
    }

    public void setOnTimeChangeListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
        }
    }

    public void setScrollCycle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f29075d.setCyclic(z);
            this.f29074c.setCyclic(z);
        }
    }

    public void setStartDate(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, date) == null) {
            this.j = date;
        }
    }

    public void setmEndDate(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, date) == null) {
            this.k = date;
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
        this.a = 0;
        this.f29073b = 0;
        this.l = 15;
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(11)
    public BdTimePicker(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 0;
        this.f29073b = 0;
        this.l = 15;
        f(context);
    }
}
