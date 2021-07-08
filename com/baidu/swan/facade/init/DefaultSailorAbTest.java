package com.baidu.swan.facade.init;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.ISailorAbTestInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DefaultSailorAbTest implements ISailorAbTestInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DefaultSailorAbTest() {
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

    @Override // com.baidu.webkit.sdk.IABTestInterface
    public JSONObject getRawSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new JSONObject() : (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.webkit.sdk.IABTestInterface
    public double getSwitch(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Double.valueOf(d2)})) == null) ? d2 : invokeCommon.doubleValue;
    }

    @Override // com.baidu.webkit.sdk.IABTestInterface
    public int getSwitch(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) ? i2 : invokeLI.intValue;
    }

    @Override // com.baidu.webkit.sdk.IABTestInterface
    public long getSwitch(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j)) == null) ? j : invokeLJ.longValue;
    }

    @Override // com.baidu.webkit.sdk.IABTestInterface
    public String getSwitch(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) ? str2 : (String) invokeLL.objValue;
    }

    @Override // com.baidu.webkit.sdk.IABTestInterface
    public boolean getSwitch(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, str, z)) == null) ? z : invokeLZ.booleanValue;
    }

    @Override // com.baidu.webkit.sdk.IABTestInterface
    public boolean has(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}
