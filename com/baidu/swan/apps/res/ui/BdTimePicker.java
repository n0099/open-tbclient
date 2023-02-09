package com.baidu.swan.apps.res.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
import com.baidu.tieba.R;
import com.baidu.tieba.k73;
import com.baidu.tieba.nm3;
import com.baidu.tieba.o73;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes3.dex */
public class BdTimePicker extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public WheelView3d c;
    public WheelView3d d;
    public LinearLayout e;
    public int f;
    public int g;
    public int h;
    public int i;
    public Date j;
    public Date k;
    public int l;
    public int m;
    public int n;
    public Paint o;

    /* loaded from: classes3.dex */
    public interface c {
    }

    public void setOnTimeChangeListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements o73 {
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

        @Override // com.baidu.tieba.o73
        public void a(WheelView3d wheelView3d, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i) == null) {
                BdTimePicker bdTimePicker = this.a;
                bdTimePicker.a = i + bdTimePicker.f;
                this.a.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements o73 {
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

        @Override // com.baidu.tieba.o73
        public void a(WheelView3d wheelView3d, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, wheelView3d, i) == null) {
                BdTimePicker bdTimePicker = this.a;
                bdTimePicker.b = i + bdTimePicker.h;
            }
        }
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
        this.b = 0;
        this.l = 15;
        f(context);
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
        this.b = 0;
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
        this.b = 0;
        this.l = 15;
        f(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
            canvas.drawText(":", getWidth() / 2, (getHeight() / 2.0f) + (this.c.getCenterContentOffset() * 2.0f), this.o);
        }
    }

    public void setDisabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.c.setIsOptions(z);
            this.d.setIsOptions(z);
        }
    }

    public void setHour(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            int i2 = this.f;
            if (i < i2 || i > (i2 = this.g)) {
                i = i2;
            }
            this.a = i;
            this.c.setCurrentItem(i - this.f);
        }
    }

    public void setMinute(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            int i2 = this.h;
            if (i < i2 || i > (i2 = this.i)) {
                i = i2;
            }
            this.b = i;
            this.d.setCurrentItem(i - this.h);
        }
    }

    public void setScrollCycle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.d.setCyclic(z);
            this.c.setCyclic(z);
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

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            setOrientation(0);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00d6, this);
            this.l = nm3.f(context, this.l);
            this.m = nm3.f(context, 16.0f);
            this.n = nm3.f(context, 14.0f);
            j();
            this.e = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09232e);
            WheelView3d wheelView3d = (WheelView3d) findViewById(R.id.obfuscated_res_0x7f0927cd);
            this.c = wheelView3d;
            wheelView3d.setLineSpacingMultiplier(3.0f);
            this.c.setCenterTextSize(this.m);
            this.c.setOuterTextSize(this.n);
            this.c.setTextColorCenter(-16777216);
            this.c.setTextColorOut(-16777216);
            this.c.setVisibleItem(7);
            this.c.setGravityOffset(this.l);
            this.c.setGravity(5);
            this.c.setDividerType(WheelView3d.DividerType.FILL);
            this.c.setDividerColor(0);
            this.c.setOnItemSelectedListener(new a(this));
            WheelView3d wheelView3d2 = (WheelView3d) findViewById(R.id.obfuscated_res_0x7f0927ce);
            this.d = wheelView3d2;
            wheelView3d2.setLineSpacingMultiplier(3.0f);
            this.d.setCenterTextSize(this.m);
            this.d.setOuterTextSize(this.n);
            this.d.setTextColorCenter(-16777216);
            this.d.setTextColorOut(-16777216);
            this.d.setGravityOffset(this.l);
            this.d.setGravity(3);
            this.d.setDividerType(WheelView3d.DividerType.FILL);
            this.d.setDividerColor(0);
            this.d.setVisibleItem(7);
            this.d.setOnItemSelectedListener(new b(this));
            g();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Calendar calendar = Calendar.getInstance();
            this.a = calendar.get(11);
            this.b = calendar.get(12);
            l();
        }
    }

    public int getHour() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int getMinute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
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

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            i();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f = 0;
            this.g = 23;
            Date date = this.j;
            if (date != null) {
                this.f = date.getHours();
            }
            Date date2 = this.k;
            if (date2 != null) {
                this.g = date2.getHours();
            }
            ArrayList arrayList = new ArrayList((this.g - this.f) + 1);
            int i = this.f;
            while (true) {
                int i2 = this.g;
                if (i <= i2) {
                    arrayList.add(String.format("%02d", Integer.valueOf(i)));
                    i++;
                } else {
                    this.c.setAdapter(new k73(this.f, i2));
                    k(this.c, this.f, this.g);
                    setHour(this.a);
                    return;
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h = 0;
            this.i = 59;
            Date date = this.j;
            if (date != null && this.a == this.f) {
                this.h = date.getMinutes();
            }
            Date date2 = this.k;
            if (date2 != null && this.a == this.g) {
                this.i = date2.getMinutes();
            }
            ArrayList arrayList = new ArrayList((this.i - this.h) + 1);
            int i = this.h;
            while (true) {
                int i2 = this.i;
                if (i <= i2) {
                    arrayList.add(String.format("%02d", Integer.valueOf(i)));
                    i++;
                } else {
                    this.d.setAdapter(new k73(this.h, i2));
                    k(this.d, this.h, this.i);
                    setMinute(this.b);
                    return;
                }
            }
        }
    }

    public final void k(WheelView3d wheelView3d, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, wheelView3d, i, i2) == null) && (i2 - i) + 1 <= 3) {
            wheelView3d.setCyclic(false);
        }
    }
}
