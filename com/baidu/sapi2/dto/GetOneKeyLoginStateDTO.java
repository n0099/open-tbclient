package com.baidu.sapi2.dto;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class GetOneKeyLoginStateDTO {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_CONNECT_TIMEOUT = 15000;
    public static long beginTime;
    public transient /* synthetic */ FieldHolder $fh;
    public int connectTimeout;

    public GetOneKeyLoginStateDTO() {
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
        this.connectTimeout = 15000;
        beginTime = System.currentTimeMillis();
    }

    public static int getAfterConnTimeOut(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            try {
                i2 = (int) (i - (System.currentTimeMillis() - beginTime));
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 < 0) {
                return 0;
            }
            return i2;
        }
        return invokeI.intValue;
    }
}
