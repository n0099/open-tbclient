package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class NetWorkCoreFacotry {
    public static /* synthetic */ Interceptable $ic = null;
    public static int INTERVAL_TIME = 300000;
    public static int MAX_ERROR_COUNT = 10;
    public static final int NetWorkCore_Type_BdHttp = 1;
    public static final int NetWorkCore_Type_Old = 0;
    public static int currentType;
    public static volatile int errorTime;
    public static NetWorkCoreFacotry instance;
    public static long lastTime;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(382952468, "Lcom/baidu/tbadk/core/util/NetWorkCoreFacotry;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(382952468, "Lcom/baidu/tbadk/core/util/NetWorkCoreFacotry;");
        }
    }

    public NetWorkCoreFacotry() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        currentType = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized void addError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (NetWorkCoreFacotry.class) {
                if (currentType == 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - lastTime < INTERVAL_TIME) {
                        errorTime++;
                        if (errorTime > MAX_ERROR_COUNT) {
                            currentType = 0;
                            BdLog.e("切换会老的网络内核");
                            TbadkCoreApplication.getInst().setNetWorkCoreType(currentType);
                            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp().getApplicationContext(), "network_core", "current Net：" + l.J() + ", TelType:" + l.f() + ", wap:" + getNetType(), 1, new Object[0]);
                        }
                    } else {
                        errorTime = 0;
                        lastTime = currentTimeMillis;
                    }
                }
            }
        }
    }

    public static synchronized NetWorkCoreFacotry getInstance() {
        InterceptResult invokeV;
        NetWorkCoreFacotry netWorkCoreFacotry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                if (l.z()) {
                    if (l.H()) {
                        return "wifi";
                    }
                    String c2 = l.c();
                    if (c2 != null) {
                        if (c2.length() > 0) {
                            return "wap";
                        }
                    }
                    return "net";
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static void setNetType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, null, i) == null) {
            currentType = i;
        }
    }

    public INetWorkCore createINetWorkCore(HttpNetContext httpNetContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpNetContext)) == null) ? new NetWorkCoreByBdHttp(httpNetContext) : (INetWorkCore) invokeL.objValue;
    }
}
