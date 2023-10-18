package com.baidu.mobads.sdk.api;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class BaiduNativeFeedSession {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> sessionHashMap;
    public static BaiduNativeFeedSession theInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1607598566, "Lcom/baidu/mobads/sdk/api/BaiduNativeFeedSession;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1607598566, "Lcom/baidu/mobads/sdk/api/BaiduNativeFeedSession;");
                return;
            }
        }
        sessionHashMap = new HashMap<>();
    }

    public BaiduNativeFeedSession() {
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

    public static synchronized BaiduNativeFeedSession getInstance() {
        InterceptResult invokeV;
        BaiduNativeFeedSession baiduNativeFeedSession;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (BaiduNativeFeedSession.class) {
                if (theInstance == null) {
                    theInstance = new BaiduNativeFeedSession();
                }
                baiduNativeFeedSession = theInstance;
            }
            return baiduNativeFeedSession;
        }
        return (BaiduNativeFeedSession) invokeV.objValue;
    }

    public int getSequenceId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int i2 = 1;
            if (i < 1) {
                return 1;
            }
            try {
                if (sessionHashMap.containsKey(i + "")) {
                    int parseInt = Integer.parseInt(sessionHashMap.get(i + "")) + 1;
                    if (parseInt >= 1) {
                        i2 = parseInt;
                    }
                    sessionHashMap.put(i + "", i2 + "");
                } else {
                    sessionHashMap.put(i + "", "1");
                }
            } catch (Exception unused) {
            }
            return i2;
        }
        return invokeI.intValue;
    }
}
