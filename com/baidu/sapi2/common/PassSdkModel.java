package com.baidu.sapi2.common;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes10.dex */
public class PassSdkModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "sapi_pass_sdk_model";
    public static PassSdkModel instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-841287287, "Lcom/baidu/sapi2/common/PassSdkModel;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-841287287, "Lcom/baidu/sapi2/common/PassSdkModel;");
        }
    }

    public PassSdkModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PassSdkModel getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (instance == null) {
                synchronized (PassSdkModel.class) {
                    if (instance == null) {
                        instance = new PassSdkModel();
                    }
                }
            }
            return instance;
        }
        return (PassSdkModel) invokeV.objValue;
    }

    public boolean checkPassSdkInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
            if (sapiAccountManager.getConfignation() == null) {
                SapiAccountManager.getGlobalCallback().onNeedInitPassSdk();
            }
            return sapiAccountManager.getConfignation() != null;
        }
        return invokeV.booleanValue;
    }

    public boolean checkPkgSign(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str) || ServiceManager.getInstance().getIsAccountManager() == null || ServiceManager.getInstance().getIsAccountManager().getConfignation() == null) {
                return false;
            }
            Map<String, String> authorizedPackages = SapiContext.getInstance().getAuthorizedPackages();
            String packageSign = SapiUtils.getPackageSign(context, str);
            if (!TextUtils.isEmpty(packageSign)) {
                Iterator<String> it = authorizedPackages.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (str.matches(next)) {
                        if (packageSign.equals(authorizedPackages.get(next))) {
                            String str2 = TAG;
                            Log.d(str2, "checkPkgSign pkgName=" + str + " is true, sign is true");
                            return true;
                        }
                        String str3 = TAG;
                        Log.d(str3, "checkPkgSign pkgName=" + str + " is true, sign is error, sign=" + packageSign);
                    }
                }
            }
            String str4 = TAG;
            Log.d(str4, "checkPkgSign is fail pkgName=" + str + " sign=" + packageSign);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
