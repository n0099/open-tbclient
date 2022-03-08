package com.baidu.idl.authority;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class AuthorityState {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_ERROR_AUTHORIZED = 51;
    public static final int STATE_ERROR_BEGIN = 48;
    public static final int STATE_ERROR_EXPIRED = 50;
    public static final int STATE_ERROR_NETWORK = 240;
    public static final int STATE_ERROR_NOT_FIND_LICENSE = 49;
    public static final int STATE_INIT_ING = 272;
    public static final int STATE_NOT_INIT = 256;
    public static final int STATE_SUCCESS = 0;
    public static final int STATE_WARNING_VALIDITY_COMING = 16;
    public static HashMap<Integer, String> sStateName;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(955631061, "Lcom/baidu/idl/authority/AuthorityState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(955631061, "Lcom/baidu/idl/authority/AuthorityState;");
                return;
            }
        }
        HashMap<Integer, String> hashMap = new HashMap<>();
        sStateName = hashMap;
        hashMap.put(0, "STATE_SUCCESS");
        sStateName.put(16, "STATE_WARNING_VALIDITY_COMING");
        sStateName.put(49, "STATE_ERROR_NOT_FIND_LICENSE");
        sStateName.put(50, "STATE_ERROR_EXPIRED");
        sStateName.put(51, "STATE_ERROR_AUTHORIZED");
        sStateName.put(240, "STATE_ERROR_NETWORK");
        sStateName.put(256, "STATE_NOT_INIT");
        sStateName.put(Integer.valueOf((int) STATE_INIT_ING), "STATE_INIT_ING");
    }

    public AuthorityState() {
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

    public static String getStateName(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            HashMap<Integer, String> hashMap = sStateName;
            if (hashMap != null) {
                return hashMap.get(Integer.valueOf(i2));
            }
            return null;
        }
        return (String) invokeI.objValue;
    }
}
