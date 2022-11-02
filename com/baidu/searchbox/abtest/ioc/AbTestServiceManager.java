package com.baidu.searchbox.abtest.ioc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.tieba.a9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AbTestServiceManager implements AbTestService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AbTestServiceManager() {
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

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public String getExpInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return AbTestManager.getInstance().getExpInfos();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public ArrayList<a9> getExperimentInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return AbTestManager.getInstance().getExperimentInfoList();
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public double getSwitch(String str, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Double.valueOf(d)})) == null) {
            return AbTestManager.getInstance().getSwitch(str, d);
        }
        return invokeCommon.doubleValue;
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public int getSwitch(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) {
            return AbTestManager.getInstance().getSwitch(str, i);
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public long getSwitch(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, str, j)) == null) {
            return AbTestManager.getInstance().getSwitch(str, j);
        }
        return invokeLJ.longValue;
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public Object getSwitch(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return AbTestManager.getInstance().getSwitch(str);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public String getSwitch(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            return AbTestManager.getInstance().getSwitch(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.abtest.ioc.AbTestService
    public boolean getSwitch(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) {
            return AbTestManager.getInstance().getSwitch(str, z);
        }
        return invokeLZ.booleanValue;
    }
}
