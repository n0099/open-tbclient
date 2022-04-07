package com.baidu.searchbox.live.interfaces.pay;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class YYPayActMainProxy extends ProcessDelegateBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_RESULT = "yy_pay_result";
    public static final int REQUEST_CODE = 100;
    public transient /* synthetic */ FieldHolder $fh;

    public YYPayActMainProxy() {
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

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 100) {
                if (this.mDelegation != null && intent != null && !TextUtils.isEmpty(intent.getStringExtra(EXTRA_RESULT))) {
                    this.mDelegation.mResult.putString(EXTRA_RESULT, intent.getStringExtra(EXTRA_RESULT));
                }
                exit();
            }
        }
    }
}
