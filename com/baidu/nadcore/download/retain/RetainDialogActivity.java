package com.baidu.nadcore.download.retain;

import android.content.Intent;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.oi0;
import com.baidu.tieba.oj0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class RetainDialogActivity extends NadDialogActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int C;

    public RetainDialogActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getResources().getString(R.string.obfuscated_res_0x7f0f0ba1) : (String) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getResources().getString(R.string.obfuscated_res_0x7f0f0ba5) : (String) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.S0();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.U0();
            if (oj0.c().a()) {
                finish();
            }
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            oj0.c().f();
            finish();
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            oj0.c().g();
            finish();
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public int v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? oi0.a().b() : invokeV.intValue;
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Intent intent = this.B;
            if (intent != null) {
                this.C = intent.getIntExtra("percent", 50);
            }
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f0ba6);
            ((TextView) findViewById(R.id.obfuscated_res_0x7f0915f1)).setText(String.format(string, this.C + "%"), TextView.BufferType.NORMAL);
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
