package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.bind.TypeAdapters;
import com.repackage.ae3;
import com.repackage.b03;
import com.repackage.bz2;
import com.repackage.tg1;
import com.repackage.xy2;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes2.dex */
public class BdDatePicker extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean s;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public WheelView3d d;
    public WheelView3d e;
    public WheelView3d f;
    public Date g;
    public Date h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;

    /* loaded from: classes2.dex */
    public class a implements bz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdDatePicker a;

        public a(BdDatePicker bdDatePicker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdDatePicker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdDatePicker;
        }

        @Override // com.repackage.bz2
        public void a(WheelView3d wheelView3d, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i) == null) {
                BdDatePicker bdDatePicker = this.a;
                bdDatePicker.a = i + bdDatePicker.i;
                this.a.j();
                this.a.i();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements bz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdDatePicker a;

        public b(BdDatePicker bdDatePicker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdDatePicker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdDatePicker;
        }

        @Override // com.repackage.bz2
        public void a(WheelView3d wheelView3d, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i) == null) {
                BdDatePicker bdDatePicker = this.a;
                bdDatePicker.b = i + bdDatePicker.k;
                this.a.i();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements bz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdDatePicker a;

        public c(BdDatePicker bdDatePicker) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdDatePicker};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdDatePicker;
        }

        @Override // com.repackage.bz2
        public void a(WheelView3d wheelView3d, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i) == null) {
                BdDatePicker bdDatePicker = this.a;
                bdDatePicker.c = i + bdDatePicker.n;
            }
        }
    }

    /* loaded from: classes2.dex */
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
        s = tg1.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = FeatureCodes.SKY_SEG;
        this.b = 1;
        this.c = 1;
        this.i = FeatureCodes.SKY_SEG;
        this.j = 2100;
        this.k = 1;
        this.l = 12;
        this.m = 31;
        this.n = 1;
        this.o = 31;
        this.p = 12;
        g(context);
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(0);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00a5, this);
            this.p = ae3.g(this.p);
            this.q = ae3.g(16.0f);
            this.r = ae3.g(14.0f);
            WheelView3d wheelView3d = (WheelView3d) findViewById(R.id.obfuscated_res_0x7f092443);
            this.d = wheelView3d;
            wheelView3d.setCenterTextSize(this.q);
            this.d.setOuterTextSize(this.r);
            this.d.setLineSpacingMultiplier(3.0f);
            this.d.setTextColorCenter(-16777216);
            this.d.setTextColorOut(-16777216);
            this.d.setDividerType(WheelView3d.DividerType.FILL);
            this.d.setVisibleItem(7);
            this.d.setOnItemSelectedListener(new a(this));
            WheelView3d wheelView3d2 = (WheelView3d) findViewById(R.id.obfuscated_res_0x7f092442);
            this.e = wheelView3d2;
            wheelView3d2.setCenterTextSize(this.q);
            this.e.setOuterTextSize(this.r);
            this.e.setTextColorCenter(-16777216);
            this.e.setTextColorOut(-16777216);
            this.e.setLineSpacingMultiplier(3.0f);
            this.e.setDividerType(WheelView3d.DividerType.FILL);
            this.e.setVisibleItem(7);
            this.e.setOnItemSelectedListener(new b(this));
            WheelView3d wheelView3d3 = (WheelView3d) findViewById(R.id.obfuscated_res_0x7f09243f);
            this.f = wheelView3d3;
            wheelView3d3.setCenterTextSize(this.q);
            this.f.setOuterTextSize(this.r);
            this.f.setTextColorCenter(-16777216);
            this.f.setTextColorOut(-16777216);
            this.f.setLineSpacingMultiplier(3.0f);
            this.f.setDividerType(WheelView3d.DividerType.FILL);
            this.f.setVisibleItem(7);
            this.f.setOnItemSelectedListener(new c(this));
            h();
        }
    }

    public int getDay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.intValue;
    }

    public int getMonth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : invokeV.intValue;
    }

    public int getYear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Calendar calendar = Calendar.getInstance();
            this.a = calendar.get(1);
            this.b = calendar.get(2) + 1;
            this.c = calendar.get(5);
            n();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int[] iArr = {4, 6, 9, 11};
            if (Arrays.binarySearch(new int[]{1, 3, 5, 7, 8, 10, 12}, this.b) >= 0) {
                this.m = 31;
            } else if (Arrays.binarySearch(iArr, this.b) >= 0) {
                this.m = 30;
            } else {
                int i = this.a;
                if ((i % 4 == 0 && i % 100 != 0) || this.a % 400 == 0) {
                    this.m = 29;
                } else {
                    this.m = 28;
                }
            }
            this.n = 1;
            this.o = this.m;
            Date date = this.g;
            if (date != null && this.a == this.i && this.b == date.getMonth() + 1) {
                this.n = this.g.getDate();
            }
            Date date2 = this.h;
            if (date2 != null && this.a == this.j && this.b == date2.getMonth() + 1) {
                this.o = this.h.getDate();
            }
            this.f.setAdapter(new xy2(this.n, this.o));
            m(this.f, this.n, this.o);
            setDay(this.c);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.k = 1;
            this.l = 12;
            Date date = this.g;
            if (date != null && this.a == this.i) {
                this.k = date.getMonth() + 1;
            }
            Date date2 = this.h;
            if (date2 != null && this.a == this.j) {
                this.l = date2.getMonth() + 1;
            }
            this.e.setAdapter(new xy2(this.k, this.l));
            m(this.e, this.k, this.l);
            setMonth(this.b);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.a;
            if (i < this.i || i > this.j) {
                this.a = this.i;
            }
            this.d.setAdapter(new xy2(this.i, this.j));
            m(this.d, this.i, this.j);
        }
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        char c2;
        WheelView3d wheelView3d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == 99228) {
                if (str.equals(Config.TRACE_VISIT_RECENT_DAY)) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != 3704893) {
                if (hashCode == 104080000 && str.equals(TypeAdapters.AnonymousClass27.MONTH)) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals(TypeAdapters.AnonymousClass27.YEAR)) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                wheelView3d = this.d;
            } else if (c2 != 1) {
                wheelView3d = c2 != 2 ? null : this.f;
            } else {
                wheelView3d = this.e;
            }
            return wheelView3d != null && wheelView3d.getVisibility() == 0;
        }
        return invokeL.booleanValue;
    }

    public final void m(WheelView3d wheelView3d, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048585, this, wheelView3d, i, i2) == null) || (i2 - i) + 1 > 3) {
            return;
        }
        wheelView3d.setCyclic(false);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            k();
            j();
            i();
        }
    }

    public void setDay(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i < this.n || i > (i2 = this.o)) {
                i = this.n;
                if (s) {
                    Context appContext = AppRuntime.getAppContext();
                    b03.g(appContext, "The day must be between " + this.n + " and " + this.o).G();
                }
            } else if (i > i2) {
                if (s) {
                    Context appContext2 = AppRuntime.getAppContext();
                    b03.g(appContext2, "The day must be between " + this.n + " and " + this.o).I();
                }
                i = i2;
            }
            this.c = i;
            this.f.setCurrentItem(i - this.n);
        }
    }

    public void setDisabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.d.setIsOptions(z);
            this.e.setIsOptions(z);
            this.f.setIsOptions(z);
        }
    }

    public void setEndDate(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, date) == null) {
            if (date != null) {
                this.h = date;
                this.j = date.getYear() + FeatureCodes.SKY_SEG;
                return;
            }
            this.j = 2100;
        }
    }

    public void setFields(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 3704893) {
            if (hashCode == 104080000 && str.equals(TypeAdapters.AnonymousClass27.MONTH)) {
                c2 = 1;
            }
        } else if (str.equals(TypeAdapters.AnonymousClass27.YEAR)) {
            c2 = 0;
        }
        if (c2 == 0) {
            this.d.setGravity(17);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        } else if (c2 != 1) {
            this.d.setGravity(5);
            this.d.setGravityOffset(this.p);
            this.f.setGravity(3);
            this.f.setGravityOffset(this.p);
            this.e.setVisibility(0);
            this.f.setVisibility(0);
        } else {
            this.d.setGravity(5);
            this.d.setGravityOffset(this.p);
            this.e.setGravity(3);
            this.e.setGravityOffset(this.p);
            this.e.setVisibility(0);
            this.f.setVisibility(8);
        }
    }

    public void setMonth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            int i2 = this.k;
            if (i < i2) {
                if (s) {
                    Context appContext = AppRuntime.getAppContext();
                    b03.g(appContext, "The month must be between " + this.k + " and " + this.l).I();
                }
            } else {
                i2 = this.l;
                if (i > i2) {
                    if (s) {
                        Context appContext2 = AppRuntime.getAppContext();
                        b03.g(appContext2, "The month must be between " + this.k + " and " + this.l).G();
                    }
                }
                this.b = i;
                this.e.setCurrentItem(i - this.k);
            }
            i = i2;
            this.b = i;
            this.e.setCurrentItem(i - this.k);
        }
    }

    public void setOnTimeChangeListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dVar) == null) {
        }
    }

    public void setScrollCycle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.e.setCyclic(z);
            this.d.setCyclic(z);
            this.f.setCyclic(z);
        }
    }

    public void setStartDate(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, date) == null) {
            if (date != null) {
                this.g = date;
                this.i = date.getYear() + FeatureCodes.SKY_SEG;
                return;
            }
            this.i = FeatureCodes.SKY_SEG;
        }
    }

    public void setYear(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            int i2 = this.i;
            if (i < i2) {
                if (s) {
                    Context appContext = AppRuntime.getAppContext();
                    b03.g(appContext, "The year must be between " + this.i + " and " + this.j).I();
                }
            } else {
                i2 = this.j;
                if (i > i2) {
                    if (s) {
                        Context appContext2 = AppRuntime.getAppContext();
                        b03.g(appContext2, "The year must be between " + this.i + " and " + this.j).G();
                    }
                }
                this.a = i;
                this.d.setCurrentItem(i - this.i);
            }
            i = i2;
            this.a = i;
            this.d.setCurrentItem(i - this.i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = FeatureCodes.SKY_SEG;
        this.b = 1;
        this.c = 1;
        this.i = FeatureCodes.SKY_SEG;
        this.j = 2100;
        this.k = 1;
        this.l = 12;
        this.m = 31;
        this.n = 1;
        this.o = 31;
        this.p = 12;
        g(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = FeatureCodes.SKY_SEG;
        this.b = 1;
        this.c = 1;
        this.i = FeatureCodes.SKY_SEG;
        this.j = 2100;
        this.k = 1;
        this.l = 12;
        this.m = 31;
        this.n = 1;
        this.o = 31;
        this.p = 12;
        g(context);
    }
}
