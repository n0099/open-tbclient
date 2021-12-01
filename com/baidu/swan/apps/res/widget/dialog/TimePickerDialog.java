package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.BdTimePicker;
import com.baidu.swan.apps.res.widget.dialog.SwanAppPickerDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes9.dex */
public class TimePickerDialog extends SwanAppPickerDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public BdTimePicker f40045g;

    /* renamed from: h  reason: collision with root package name */
    public int f40046h;

    /* renamed from: i  reason: collision with root package name */
    public int f40047i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f40048j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f40049k;
    public Date l;
    public Date m;

    /* loaded from: classes9.dex */
    public static class a extends SwanAppPickerDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Date f40050e;

        /* renamed from: f  reason: collision with root package name */
        public Date f40051f;

        /* renamed from: g  reason: collision with root package name */
        public Date f40052g;

        /* renamed from: h  reason: collision with root package name */
        public String f40053h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f40054i;

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
                timePickerDialog.setFields(this.f40053h);
                timePickerDialog.setDisabled(this.f40054i);
                Date date = this.f40052g;
                if (date != null) {
                    timePickerDialog.setHour(date.getHours());
                    timePickerDialog.setMinute(this.f40052g.getMinutes());
                }
                Date date2 = this.f40050e;
                if (date2 != null) {
                    timePickerDialog.setStartDate(date2);
                }
                Date date3 = this.f40051f;
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
                this.f40054i = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a m(Date date) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, date)) == null) {
                this.f40051f = date;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a n(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f40053h = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(Date date) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, date)) == null) {
                this.f40052g = date;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a p(Date date) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, date)) == null) {
                this.f40050e = date;
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
        this.f40048j = false;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f40045g = new BdTimePicker(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f40045g.setLayoutParams(layoutParams);
            this.f40045g.setScrollCycle(true);
            this.f40045g.setStartDate(this.l);
            this.f40045g.setmEndDate(this.m);
            this.f40045g.setHour(this.f40046h);
            this.f40045g.setMinute(this.f40047i);
            this.f40045g.updateDatas();
            this.f40045g.setDisabled(this.f40049k);
        }
    }

    public int getHour() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f40045g.getHour() : invokeV.intValue;
    }

    public int getMinute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40045g.getMinute() : invokeV.intValue;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            if (this.f40048j) {
                getWindow().addFlags(4718592);
            }
            b();
            getBuilder().j(this.f40045g);
        }
    }

    public void setDisabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f40049k = z;
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
            this.f40046h = i2;
        }
    }

    public void setMinute(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f40047i = i2;
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
            this.f40048j = z;
        }
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.BaseDialog, android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            BdTimePicker bdTimePicker = this.f40045g;
            if (bdTimePicker != null) {
                if (this.f40046h != bdTimePicker.getHour()) {
                    this.f40045g.setHour(this.f40046h);
                }
                if (this.f40047i != this.f40045g.getMinute()) {
                    this.f40045g.setMinute(this.f40047i);
                }
            }
            super.show();
        }
    }
}
