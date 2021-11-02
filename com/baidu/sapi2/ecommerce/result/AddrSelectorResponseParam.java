package com.baidu.sapi2.ecommerce.result;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AddrSelectorResponseParam {
    public static /* synthetic */ Interceptable $ic = null;
    public static int ERROR_CODE_PARSE_JSON = -101;
    public static String KEY_HAS_LEAF = "has_leaf";
    public static String KEY_HOTLIST = "hotlist";
    public static String KEY_ID = "id";
    public static String KEY_IS_HMT = "is_hmt";
    public static String KEY_LEAFS = "leafs";
    public static String KEY_LEAFTYPE = "leafType";
    public static String KEY_NAME = "name";
    public static String KEY_NAME_PY_INIT = "name_py_init";
    public static String KEY_PID = "pid";
    public static String KEY_PNAME = "pname";
    public static String KEY_PTYPE = "ptype";
    public static String KEY_TYPE = "type";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(402220080, "Lcom/baidu/sapi2/ecommerce/result/AddrSelectorResponseParam;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(402220080, "Lcom/baidu/sapi2/ecommerce/result/AddrSelectorResponseParam;");
        }
    }

    public AddrSelectorResponseParam() {
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
}
