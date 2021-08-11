package com.baidu.tbadk.core.util;

import c.a.o0.s.q.s;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class ICDNProblemUploader {
    public static /* synthetic */ Interceptable $ic;
    public static ICDNProblemUploader problemUploader;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-252039758, "Lcom/baidu/tbadk/core/util/ICDNProblemUploader;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-252039758, "Lcom/baidu/tbadk/core/util/ICDNProblemUploader;");
        }
    }

    public ICDNProblemUploader() {
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

    public static ICDNProblemUploader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (problemUploader == null) {
                synchronized (ICDNProblemUploader.class) {
                    if (problemUploader == null) {
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016101, ICDNProblemUploader.class);
                        if (runTask != null && runTask.getData() != null) {
                            problemUploader = (ICDNProblemUploader) runTask.getData();
                        }
                        return problemUploader;
                    }
                }
            }
            return problemUploader;
        }
        return (ICDNProblemUploader) invokeV.objValue;
    }

    public abstract s getmCdnLogData();

    public abstract void insertErrorData(int i2, String str);

    public abstract void insertNormalData(long j2, String str);

    public abstract void setmCdnLogData(s sVar);
}
