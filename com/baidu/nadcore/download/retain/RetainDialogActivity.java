package com.baidu.nadcore.download.retain;

import android.content.Intent;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.lk0;
import com.baidu.tieba.ll0;
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

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

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
    public void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ll0.c().f();
            finish();
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ll0.c().g();
            finish();
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public int C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return lk0.a().b();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return getResources().getString(R.string.obfuscated_res_0x7f0f0bd7);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public String I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return getResources().getString(R.string.obfuscated_res_0x7f0f0bdb);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.a1();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.d1();
            if (ll0.c().a()) {
                finish();
            }
        }
    }

    @Override // com.baidu.nadcore.download.retain.NadDialogActivity
    public void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Intent intent = this.B;
            if (intent != null) {
                this.C = intent.getIntExtra("percent", 50);
            }
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f0bdc);
            ((TextView) findViewById(R.id.obfuscated_res_0x7f091652)).setText(String.format(string, this.C + "%"), TextView.BufferType.NORMAL);
        }
    }
}
