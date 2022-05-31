package com.baidu.swan.apps.view;

import android.os.Bundle;
import android.widget.TextView;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bd3;
import com.repackage.rf1;
/* loaded from: classes2.dex */
public class SwanAppErrorDialog extends BaseActivityDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "SwanAppErrorDialog";
    public transient /* synthetic */ FieldHolder $fh;
    public TextView mMessage;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1388206658, "Lcom/baidu/swan/apps/view/SwanAppErrorDialog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1388206658, "Lcom/baidu/swan/apps/view/SwanAppErrorDialog;");
                return;
            }
        }
        DEBUG = rf1.a;
    }

    public SwanAppErrorDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BaseActivityDialog.e newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new BaseActivityDialog.e(SwanAppErrorDialog.class) : (BaseActivityDialog.e) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            int c0 = bd3.c0(this);
            super.onCreate(bundle);
            bd3.g(this, c0);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090796);
            this.mMessage = textView;
            textView.setGravity(17);
        }
    }
}
