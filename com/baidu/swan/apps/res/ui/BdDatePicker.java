package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f;
import c.a.p0.a.g;
import c.a.p0.a.k;
import c.a.p0.a.v2.n0;
import c.a.p0.a.z1.b.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes6.dex */
public class BdDatePicker extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int START_YEAR = 1900;
    public static final String WHEEL_VIEW_DAY_TYPE = "day";
    public static final String WHEEL_VIEW_MONTH_TYPE = "month";
    public static final String WHEEL_VIEW_YEAR_TYPE = "year";
    public static final boolean w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f46336e;

    /* renamed from: f  reason: collision with root package name */
    public int f46337f;

    /* renamed from: g  reason: collision with root package name */
    public int f46338g;

    /* renamed from: h  reason: collision with root package name */
    public WheelView3d f46339h;

    /* renamed from: i  reason: collision with root package name */
    public WheelView3d f46340i;

    /* renamed from: j  reason: collision with root package name */
    public WheelView3d f46341j;
    public Date k;
    public Date l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;

    /* loaded from: classes6.dex */
    public class a implements c.a.p0.a.z1.a.e.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdDatePicker f46342a;

        public a(BdDatePicker bdDatePicker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdDatePicker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46342a = bdDatePicker;
        }

        @Override // c.a.p0.a.z1.a.e.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i2) == null) {
                BdDatePicker bdDatePicker = this.f46342a;
                bdDatePicker.f46336e = i2 + bdDatePicker.m;
                this.f46342a.initMonths();
                this.f46342a.initDays();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.p0.a.z1.a.e.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdDatePicker f46343a;

        public b(BdDatePicker bdDatePicker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdDatePicker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46343a = bdDatePicker;
        }

        @Override // c.a.p0.a.z1.a.e.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i2) == null) {
                BdDatePicker bdDatePicker = this.f46343a;
                bdDatePicker.f46337f = i2 + bdDatePicker.o;
                this.f46343a.initDays();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements c.a.p0.a.z1.a.e.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdDatePicker f46344a;

        public c(BdDatePicker bdDatePicker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdDatePicker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46344a = bdDatePicker;
        }

        @Override // c.a.p0.a.z1.a.e.c.b
        public void a(WheelView3d wheelView3d, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i2) == null) {
                BdDatePicker bdDatePicker = this.f46344a;
                bdDatePicker.f46338g = i2 + bdDatePicker.r;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2026993538, "Lcom/baidu/swan/apps/res/ui/BdDatePicker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2026993538, "Lcom/baidu/swan/apps/res/ui/BdDatePicker;");
                return;
            }
        }
        w = k.f7085a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdDatePicker(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46336e = 1900;
        this.f46337f = 1;
        this.f46338g = 1;
        this.m = 1900;
        this.n = 2100;
        this.o = 1;
        this.p = 12;
        this.q = 31;
        this.r = 1;
        this.s = 31;
        this.t = 12;
        g(context);
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(0);
            LayoutInflater.from(context).inflate(g.aiapps_datepicker_layout, this);
            this.t = n0.g(this.t);
            this.u = n0.g(16.0f);
            this.v = n0.g(14.0f);
            WheelView3d wheelView3d = (WheelView3d) findViewById(f.wheel_year);
            this.f46339h = wheelView3d;
            wheelView3d.setCenterTextSize(this.u);
            this.f46339h.setOuterTextSize(this.v);
            this.f46339h.setLineSpacingMultiplier(3.0f);
            this.f46339h.setTextColorCenter(-16777216);
            this.f46339h.setTextColorOut(-16777216);
            this.f46339h.setDividerType(WheelView3d.DividerType.FILL);
            this.f46339h.setVisibleItem(7);
            this.f46339h.setOnItemSelectedListener(new a(this));
            WheelView3d wheelView3d2 = (WheelView3d) findViewById(f.wheel_month);
            this.f46340i = wheelView3d2;
            wheelView3d2.setCenterTextSize(this.u);
            this.f46340i.setOuterTextSize(this.v);
            this.f46340i.setTextColorCenter(-16777216);
            this.f46340i.setTextColorOut(-16777216);
            this.f46340i.setLineSpacingMultiplier(3.0f);
            this.f46340i.setDividerType(WheelView3d.DividerType.FILL);
            this.f46340i.setVisibleItem(7);
            this.f46340i.setOnItemSelectedListener(new b(this));
            WheelView3d wheelView3d3 = (WheelView3d) findViewById(f.wheel_day);
            this.f46341j = wheelView3d3;
            wheelView3d3.setCenterTextSize(this.u);
            this.f46341j.setOuterTextSize(this.v);
            this.f46341j.setTextColorCenter(-16777216);
            this.f46341j.setTextColorOut(-16777216);
            this.f46341j.setLineSpacingMultiplier(3.0f);
            this.f46341j.setDividerType(WheelView3d.DividerType.FILL);
            this.f46341j.setVisibleItem(7);
            this.f46341j.setOnItemSelectedListener(new c(this));
            h();
        }
    }

    public int getDay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f46338g : invokeV.intValue;
    }

    public int getMonth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46337f : invokeV.intValue;
    }

    public int getYear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f46336e : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Calendar calendar = Calendar.getInstance();
            this.f46336e = calendar.get(1);
            this.f46337f = calendar.get(2) + 1;
            this.f46338g = calendar.get(5);
            updateDatas();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.f46336e;
            if (i2 < this.m || i2 > this.n) {
                this.f46336e = this.m;
            }
            this.f46339h.setAdapter(new c.a.p0.a.z1.a.e.a.b(this.m, this.n));
            j(this.f46339h, this.m, this.n);
        }
    }

    public void initDays() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int[] iArr = {4, 6, 9, 11};
            if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.f46337f) >= 0) {
                this.q = 31;
            } else if (Arrays.binarySearch(iArr, this.f46337f) >= 0) {
                this.q = 30;
            } else {
                int i2 = this.f46336e;
                if ((i2 % 4 == 0 && i2 % 100 != 0) || this.f46336e % 400 == 0) {
                    this.q = 29;
                } else {
                    this.q = 28;
                }
            }
            this.r = 1;
            this.s = this.q;
            Date date = this.k;
            if (date != null && this.f46336e == this.m && this.f46337f == date.getMonth() + 1) {
                this.r = this.k.getDate();
            }
            Date date2 = this.l;
            if (date2 != null && this.f46336e == this.n && this.f46337f == date2.getMonth() + 1) {
                this.s = this.l.getDate();
            }
            this.f46341j.setAdapter(new c.a.p0.a.z1.a.e.a.b(this.r, this.s));
            j(this.f46341j, this.r, this.s);
            setDay(this.f46338g);
        }
    }

    public void initMonths() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.o = 1;
            this.p = 12;
            Date date = this.k;
            if (date != null && this.f46336e == this.m) {
                this.o = date.getMonth() + 1;
            }
            Date date2 = this.l;
            if (date2 != null && this.f46336e == this.n) {
                this.p = date2.getMonth() + 1;
            }
            this.f46340i.setAdapter(new c.a.p0.a.z1.a.e.a.b(this.o, this.p));
            j(this.f46340i, this.o, this.p);
            setMonth(this.f46337f);
        }
    }

    public boolean isWheelViewVisible(String str) {
        InterceptResult invokeL;
        char c2;
        WheelView3d wheelView3d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == 99228) {
                if (str.equals("day")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != 3704893) {
                if (hashCode == 104080000 && str.equals("month")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals("year")) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                wheelView3d = this.f46339h;
            } else if (c2 != 1) {
                wheelView3d = c2 != 2 ? null : this.f46341j;
            } else {
                wheelView3d = this.f46340i;
            }
            return wheelView3d != null && wheelView3d.getVisibility() == 0;
        }
        return invokeL.booleanValue;
    }

    public final void j(WheelView3d wheelView3d, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048585, this, wheelView3d, i2, i3) == null) || (i3 - i2) + 1 > 3) {
            return;
        }
        wheelView3d.setCyclic(false);
    }

    public void setDay(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (i2 < this.r || i2 > (i3 = this.s)) {
                i2 = this.r;
                if (w) {
                    Context appContext = AppRuntime.getAppContext();
                    e.g(appContext, "The day must be between " + this.r + " and " + this.s).F();
                }
            } else if (i2 > i3) {
                if (w) {
                    Context appContext2 = AppRuntime.getAppContext();
                    e.g(appContext2, "The day must be between " + this.r + " and " + this.s).H();
                }
                i2 = i3;
            }
            this.f46338g = i2;
            this.f46341j.setCurrentItem(i2 - this.r);
        }
    }

    public void setDisabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f46339h.setIsOptions(z);
            this.f46340i.setIsOptions(z);
            this.f46341j.setIsOptions(z);
        }
    }

    public void setEndDate(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, date) == null) {
            if (date != null) {
                this.l = date;
                this.n = date.getYear() + 1900;
                return;
            }
            this.n = 2100;
        }
    }

    public void setFields(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 3704893) {
            if (hashCode == 104080000 && str.equals("month")) {
                c2 = 1;
            }
        } else if (str.equals("year")) {
            c2 = 0;
        }
        if (c2 == 0) {
            this.f46339h.setGravity(17);
            this.f46340i.setVisibility(8);
            this.f46341j.setVisibility(8);
        } else if (c2 != 1) {
            this.f46339h.setGravity(5);
            this.f46339h.setGravityOffset(this.t);
            this.f46341j.setGravity(3);
            this.f46341j.setGravityOffset(this.t);
            this.f46340i.setVisibility(0);
            this.f46341j.setVisibility(0);
        } else {
            this.f46339h.setGravity(5);
            this.f46339h.setGravityOffset(this.t);
            this.f46340i.setGravity(3);
            this.f46340i.setGravityOffset(this.t);
            this.f46340i.setVisibility(0);
            this.f46341j.setVisibility(8);
        }
    }

    public void setMonth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            int i3 = this.o;
            if (i2 < i3) {
                if (w) {
                    Context appContext = AppRuntime.getAppContext();
                    e.g(appContext, "The month must be between " + this.o + " and " + this.p).H();
                }
            } else {
                i3 = this.p;
                if (i2 > i3) {
                    if (w) {
                        Context appContext2 = AppRuntime.getAppContext();
                        e.g(appContext2, "The month must be between " + this.o + " and " + this.p).F();
                    }
                }
                this.f46337f = i2;
                this.f46340i.setCurrentItem(i2 - this.o);
            }
            i2 = i3;
            this.f46337f = i2;
            this.f46340i.setCurrentItem(i2 - this.o);
        }
    }

    public void setOnTimeChangeListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) {
        }
    }

    public void setScrollCycle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f46340i.setCyclic(z);
            this.f46339h.setCyclic(z);
            this.f46341j.setCyclic(z);
        }
    }

    public void setStartDate(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, date) == null) {
            if (date != null) {
                this.k = date;
                this.m = date.getYear() + 1900;
                return;
            }
            this.m = 1900;
        }
    }

    public void setYear(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            int i3 = this.m;
            if (i2 < i3) {
                if (w) {
                    Context appContext = AppRuntime.getAppContext();
                    e.g(appContext, "The year must be between " + this.m + " and " + this.n).H();
                }
            } else {
                i3 = this.n;
                if (i2 > i3) {
                    if (w) {
                        Context appContext2 = AppRuntime.getAppContext();
                        e.g(appContext2, "The year must be between " + this.m + " and " + this.n).F();
                    }
                }
                this.f46336e = i2;
                this.f46339h.setCurrentItem(i2 - this.m);
            }
            i2 = i3;
            this.f46336e = i2;
            this.f46339h.setCurrentItem(i2 - this.m);
        }
    }

    public void updateDatas() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            i();
            initMonths();
            initDays();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f46336e = 1900;
        this.f46337f = 1;
        this.f46338g = 1;
        this.m = 1900;
        this.n = 2100;
        this.o = 1;
        this.p = 12;
        this.q = 31;
        this.r = 1;
        this.s = 31;
        this.t = 12;
        g(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdDatePicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f46336e = 1900;
        this.f46337f = 1;
        this.f46338g = 1;
        this.m = 1900;
        this.n = 2100;
        this.o = 1;
        this.p = 12;
        this.q = 31;
        this.r = 1;
        this.s = 31;
        this.t = 12;
        g(context);
    }
}
