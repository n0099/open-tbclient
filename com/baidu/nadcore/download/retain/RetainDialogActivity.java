package com.baidu.nadcore.download.retain;

import android.content.Intent;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qj0;
import com.repackage.ri0;
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

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.E0();
            if (qj0.c().a()) {
                finish();
            }
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            qj0.c().f();
            finish();
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            qj0.c().g();
            finish();
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ri0.a().b() : invokeV.intValue;
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Intent intent = this.B;
            if (intent != null) {
                this.C = intent.getIntExtra("percent", 50);
            }
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f0b91);
            ((TextView) findViewById(R.id.obfuscated_res_0x7f091558)).setText(String.format(string, this.C + "%"), TextView.BufferType.NORMAL);
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getResources().getString(R.string.obfuscated_res_0x7f0f0b8c) : (String) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getResources().getString(R.string.obfuscated_res_0x7f0f0b90) : (String) invokeV.objValue;
    }
}
