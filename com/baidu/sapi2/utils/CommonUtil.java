package com.baidu.sapi2.utils;

import android.widget.Toast;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CommonUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CommonUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void showErrorNotice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (!SapiUtils.isDebug(confignation.context) && !confignation.debug) {
                Log.e(str, new Object[0]);
            } else {
                Toast.makeText(confignation.context, str, 1).show();
            }
        }
    }

    public static void throwException(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (!SapiUtils.isDebug(confignation.context) && !confignation.debug) {
                Log.e(str, new Object[0]);
                return;
            }
            throw new RuntimeException(str);
        }
    }
}
