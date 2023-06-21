package com.baidu.tbadk.core.util.httpNet;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.yz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes4.dex */
public abstract class ICDNIPDirectConnect {
    public static /* synthetic */ Interceptable $ic;
    public static ICDNIPDirectConnect directConnect;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isAlreadyInit;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2015191969, "Lcom/baidu/tbadk/core/util/httpNet/ICDNIPDirectConnect;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2015191969, "Lcom/baidu/tbadk/core/util/httpNet/ICDNIPDirectConnect;");
        }
    }

    public abstract String getAllIPListCanUsed();

    public abstract yz4 getCDNImageTimeData();

    public abstract String getCachedCdnIp(int i);

    public abstract boolean hasImageProblem();

    public abstract HttpGet httpGetFactory(String str, int i, boolean z);

    public abstract HttpGet httpGetFactory(String str, String str2, String str3);

    public abstract void init();

    public abstract boolean isShouldCDNFallBack();

    public abstract void result(String str, String str2, boolean z, boolean z2, boolean z3);

    public abstract void setCDNImageTimeData(yz4 yz4Var);

    public abstract void setIpDisableTime(int i);

    public ICDNIPDirectConnect() {
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
        this.isAlreadyInit = false;
    }

    public static ICDNIPDirectConnect getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (directConnect == null) {
                synchronized (ICDNIPDirectConnect.class) {
                    if (directConnect == null) {
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016102, ICDNIPDirectConnect.class);
                        if (runTask != null && runTask.getData() != null) {
                            directConnect = (ICDNIPDirectConnect) runTask.getData();
                        }
                        return directConnect;
                    }
                }
            }
            return directConnect;
        }
        return (ICDNIPDirectConnect) invokeV.objValue;
    }
}
