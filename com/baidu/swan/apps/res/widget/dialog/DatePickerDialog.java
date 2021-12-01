package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.BdDatePicker;
import com.baidu.swan.apps.res.widget.dialog.SwanAppPickerDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes9.dex */
public class DatePickerDialog extends SwanAppPickerDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public BdDatePicker f39969g;

    /* renamed from: h  reason: collision with root package name */
    public int f39970h;

    /* renamed from: i  reason: collision with root package name */
    public int f39971i;

    /* renamed from: j  reason: collision with root package name */
    public int f39972j;

    /* renamed from: k  reason: collision with root package name */
    public String f39973k;
    public boolean l;
    public Date m;
    public Date n;

    /* loaded from: classes9.dex */
    public static class a extends SwanAppPickerDialog.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Date f39974e;

        /* renamed from: f  reason: collision with root package name */
        public Date f39975f;

        /* renamed from: g  reason: collision with root package name */
        public Date f39976g;

        /* renamed from: h  reason: collision with root package name */
        public String f39977h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f39978i;

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
                DatePickerDialog datePickerDialog = (DatePickerDialog) super.a();
                datePickerDialog.setFields(this.f39977h);
                datePickerDialog.setDisabled(this.f39978i);
                Date date = this.f39976g;
                if (date != null) {
                    datePickerDialog.setYear(date.getYear() + 1900);
                    datePickerDialog.setMonth(this.f39976g.getMonth() + 1);
                    datePickerDialog.setDay(this.f39976g.getDate());
                }
                Date date2 = this.f39974e;
                if (date2 != null) {
                    datePickerDialog.setStartDate(date2);
                }
                Date date3 = this.f39975f;
                if (date3 != null) {
                    datePickerDialog.setEndDate(date3);
                }
                return datePickerDialog;
            }
            return (SwanAppPickerDialog) invokeV.objValue;
        }

        @Override // com.baidu.swan.apps.res.widget.dialog.SwanAppPickerDialog.a
        public SwanAppPickerDialog b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new DatePickerDialog(context) : (SwanAppPickerDialog) invokeL.objValue;
        }

        public a l(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f39978i = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a m(Date date) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, date)) == null) {
                this.f39975f = date;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a n(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f39977h = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(Date date) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, date)) == null) {
                this.f39976g = date;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a p(Date date) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, date)) == null) {
                this.f39974e = date;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerDialog(Context context) {
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
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f39969g = new BdDatePicker(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            this.f39969g.setLayoutParams(layoutParams);
            this.f39969g.setScrollCycle(true);
            this.f39969g.setStartDate(this.m);
            this.f39969g.setEndDate(this.n);
            this.f39969g.setYear(this.f39970h);
            this.f39969g.setMonth(this.f39971i);
            this.f39969g.setDay(this.f39972j);
            this.f39969g.updateDatas();
            this.f39969g.setFields(this.f39973k);
            this.f39969g.setDisabled(this.l);
        }
    }

    public final boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f39969g.isWheelViewVisible(str) : invokeL.booleanValue;
    }

    public int getDay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f39969g.getDay() : invokeV.intValue;
    }

    public int getMonth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39969g.getMonth() : invokeV.intValue;
    }

    public String getSelectedDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (c("year")) {
                sb.append(String.format("%d-", Integer.valueOf(getYear())));
            }
            if (c("month")) {
                sb.append(String.format("%02d-", Integer.valueOf(getMonth())));
            }
            if (c("day")) {
                sb.append(String.format("%02d", Integer.valueOf(getDay())));
            }
            String sb2 = sb.toString();
            return sb2.endsWith("-") ? sb2.substring(0, sb2.length() - 1) : sb2;
        }
        return (String) invokeV.objValue;
    }

    public int getYear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f39969g.getYear() : invokeV.intValue;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            b();
            getBuilder().j(this.f39969g);
        }
    }

    public void setDay(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f39972j = i2;
        }
    }

    public void setDisabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.l = z;
        }
    }

    public void setEndDate(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, date) == null) {
            this.n = date;
        }
    }

    public void setFields(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f39973k = str;
        }
    }

    public void setMonth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f39971i = i2;
        }
    }

    public void setStartDate(Date date) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, date) == null) {
            this.m = date;
        }
    }

    public void setYear(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f39970h = i2;
        }
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.BaseDialog, android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.show();
        }
    }
}
