package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.SafeService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class SapiSafeFacade {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEVICE_AUTH_TOKEN_EVENT_ID = 122;
    public static final int GET_ZID_DEFAULT_EVENT_ID = 120;
    public static SapiSafeFacade instance;
    public transient /* synthetic */ FieldHolder $fh;

    public SapiSafeFacade() {
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

    public static synchronized SapiSafeFacade getInstance() {
        InterceptResult invokeV;
        SapiSafeFacade sapiSafeFacade;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (SapiSafeFacade.class) {
                if (instance == null) {
                    instance = new SapiSafeFacade();
                }
                sapiSafeFacade = instance;
            }
            return sapiSafeFacade;
        }
        return (SapiSafeFacade) invokeV.objValue;
    }

    public String getCurrentZid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            String zidAndCheckSafe = getZidAndCheckSafe(context, currentAccount != null ? currentAccount.uid : null, 1);
            return TextUtils.isEmpty(zidAndCheckSafe) ? "NoZidYet" : zidAndCheckSafe;
        }
        return (String) invokeL.objValue;
    }

    public String getDeviceAuthToken(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, i2)) == null) ? SafeService.getInstance().getDeviceAuthToken(context, SapiAccountManager.getInstance().getSapiConfiguration().tpl, str, i2) : (String) invokeLLI.objValue;
    }

    public String getZidAndCheckSafe(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, context, str, i2)) == null) ? SafeService.getInstance().getZidAndCheckSafe(context, str, i2) : (String) invokeLLI.objValue;
    }
}
