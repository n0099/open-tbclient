package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.cw4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
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

    public abstract cw4 getmCdnLogData();

    public abstract void insertErrorData(int i, String str);

    public abstract void insertNormalData(long j, String str);

    public abstract void setmCdnLogData(cw4 cw4Var);

    public ICDNProblemUploader() {
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
}
