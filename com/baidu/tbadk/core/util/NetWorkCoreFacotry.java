package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NetWorkCoreFacotry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NetWorkCore_Type_BdHttp = 1;
    public static final int NetWorkCore_Type_Old = 0;
    public static int currentType;
    public static NetWorkCoreFacotry instance;
    public transient /* synthetic */ FieldHolder $fh;

    public NetWorkCoreFacotry() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        currentType = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized NetWorkCoreFacotry getInstance() {
        InterceptResult invokeV;
        NetWorkCoreFacotry netWorkCoreFacotry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (NetWorkCoreFacotry.class) {
                if (instance == null) {
                    instance = new NetWorkCoreFacotry();
                }
                netWorkCoreFacotry = instance;
            }
            return netWorkCoreFacotry;
        }
        return (NetWorkCoreFacotry) invokeV.objValue;
    }

    public static String getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    return null;
                }
                if (BdNetTypeUtil.isWifiNet()) {
                    return "wifi";
                }
                String curMobileProxyHost = BdNetTypeUtil.curMobileProxyHost();
                if (curMobileProxyHost != null) {
                    if (curMobileProxyHost.length() > 0) {
                        return "wap";
                    }
                }
                return "net";
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static void setNetType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            currentType = i;
        }
    }

    public INetWorkCore createINetWorkCore(HttpNetContext httpNetContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpNetContext)) == null) {
            return new NetWorkCoreByBdHttp(httpNetContext);
        }
        return (INetWorkCore) invokeL.objValue;
    }
}
