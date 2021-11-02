package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.SwanAppPickerDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes8.dex */
public class TimePickerDialog extends SwanAppPickerDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public BdTimePicker f44216g;

    /* renamed from: h  reason: collision with root package name */
    public int f44217h;

    /* renamed from: i  reason: collision with root package name */
    public int f44218i;
    public boolean j;
    public boolean k;
    public Date l;
    public Date m;

    /* loaded from: classes8.dex */
    public static class a extends SwanAppPickerDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Date f44219e;

        /* renamed from: f  reason: collision with root package name */
        public Date f44220f;

        /* renamed from: g  reason: collision with root package name */
        public Date f44221g;

        /* renamed from: h  reason: collision with root package name */
        public String f44222h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f44223i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
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
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppPickerDialog.a
        public SwanAppPickerDialog a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TimePickerDialog timePickerDialog = (TimePickerDialog) super.a();
                timePickerDialog.setFields(this.f44222h);
                timePickerDialog.setDisabled(this.f44223i);
                Date date = this.f44221g;
                if (date != null) {
                    timePickerDialog.setHour(date.getHours());
                    timePickerDialog.setMinute(this.f44221g.getMinutes());
                }
                Date date2 = this.f44219e;
                if (date2 != null) {
                    timePickerDialog.setStartDate(date2);
                }
                Date date3 = this.f44220f;
                if (date3 != null) {
                    timePickerDialog.setEndDate(date3);
                }
                return timePickerDialog;
            }
            return (SwanAppPickerDialog) invokeV.objValue;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppPickerDialog.a
        public SwanAppPickerDialog b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new TimePickerDialog(context) : (SwanAppPickerDialog) invokeL.objValue;
        }

        public a l(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f44223i = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a m(Date date) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, date)) == null) {
                this.f44220f = date;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a n(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f44222h = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(Date date) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, date)) == null) {
                this.f44221g = date;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a p(Date date) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, date)) == null) {
                this.f44219e = date;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerDialog(Context context) {
        super(context, i.SwanAppNoTitleDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = false;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f44216g = new BdTimePicker(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f44216g.setLayoutParams(layoutParams);
            this.f44216g.setScrollCycle(true);
            this.f44216g.setStartDate(this.l);
            this.f44216g.setmEndDate(this.m);
            this.f44216g.setHour(this.f44217h);
            this.f44216g.setMinute(this.f44218i);
            this.f44216g.updateDatas();
            this.f44216g.setDisabled(this.k);
        }
    }

    public int getHour() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f44216g.getHour() : invokeV.intValue;
    }

    public int getMinute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44216g.getMinute() : invokeV.intValue;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            if (this.j) {
                getWindow().addFlags(4718592);
            }
            b();
            getBuilder().j(this.f44216g);
        }
    }

    public void setDisabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.k = z;
        }
    }

    public void setEndDate(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, date) == null) {
            this.m = date;
        }
    }

    public void setFields(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    public void setHour(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f44217h = i2;
        }
    }

    public void setMinute(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f44218i = i2;
        }
    }

    public void setStartDate(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, date) == null) {
            this.l = date;
        }
    }

    public void setViewShowFrontLockView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.j = z;
        }
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.BaseDialog, android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            BdTimePicker bdTimePicker = this.f44216g;
            if (bdTimePicker != null) {
                if (this.f44217h != bdTimePicker.getHour()) {
                    this.f44216g.setHour(this.f44217h);
                }
                if (this.f44218i != this.f44216g.getMinute()) {
                    this.f44216g.setMinute(this.f44218i);
                }
            }
            super.show();
        }
    }
}
