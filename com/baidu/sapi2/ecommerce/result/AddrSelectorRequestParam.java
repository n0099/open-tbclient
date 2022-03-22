package com.baidu.sapi2.ecommerce.result;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.common.MapObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AddrSelectorRequestParam extends MapObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static String KEY_CLIENT = "client";
    public static String KEY_CLIENTFROM = "clientfrom";
    public static String KEY_ID = "id";
    public static String KEY_LEAFS = "leafs";
    public static String KEY_SORT = "sort";
    public static String KEY_TPL = "tpl";
    public static String KEY_TPLSE = "tplse";
    public static String KEY_TPLT = "tplt";
    public static String KEY_TTT = "ttt";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-765024932, "Lcom/baidu/sapi2/ecommerce/result/AddrSelectorRequestParam;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-765024932, "Lcom/baidu/sapi2/ecommerce/result/AddrSelectorRequestParam;");
        }
    }

    public AddrSelectorRequestParam() {
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

    public String getClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getStrValue(KEY_CLIENT) : (String) invokeV.objValue;
    }

    public String getClientFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getStrValue(KEY_CLIENTFROM) : (String) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getStrValue(KEY_ID) : (String) invokeV.objValue;
    }

    public String getLeafs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getStrValue(KEY_LEAFS) : (String) invokeV.objValue;
    }

    public String getSort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getStrValue(KEY_SORT) : (String) invokeV.objValue;
    }

    public String getTpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getStrValue(KEY_TPL) : (String) invokeV.objValue;
    }

    public String getTplse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getStrValue(KEY_TPLSE) : (String) invokeV.objValue;
    }

    public String getTplt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getStrValue(KEY_TPLT) : (String) invokeV.objValue;
    }

    public String getTtt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? getStrValue(KEY_TTT) : (String) invokeV.objValue;
    }

    public void setClient(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            putValue(KEY_CLIENT, str);
        }
    }

    public void setClientFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            putValue(KEY_CLIENTFROM, str);
        }
    }

    public void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            putValue(KEY_ID, str);
        }
    }

    public void setLeafs(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            putValue(KEY_LEAFS, str);
        }
    }

    public void setSort(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            putValue(KEY_SORT, str);
        }
    }

    public void setTpl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            putValue(KEY_TPL, str);
        }
    }

    public void setTplse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            putValue(KEY_TPLSE, str);
        }
    }

    public void setTplt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            putValue(KEY_TPLT, str);
        }
    }

    public void setTtt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            putValue(KEY_TTT, str);
        }
    }
}
