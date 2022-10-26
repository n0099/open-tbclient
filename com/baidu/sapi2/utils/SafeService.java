package com.baidu.sapi2.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.ac.FH;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SafeService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEVICE_AUTH_TOKEN_EVENT_ID = 122;
    public static final int GET_ZID_DEFAULT_EVENT_ID = 120;
    public static final int SOFIRE_MODULE_ID = 1;
    public static final String Tag = "SafeService";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.sapi2.utils.SafeService$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class SingletonContainer {
        public static /* synthetic */ Interceptable $ic;
        public static SafeService mSingleInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-88240679, "Lcom/baidu/sapi2/utils/SafeService$SingletonContainer;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-88240679, "Lcom/baidu/sapi2/utils/SafeService$SingletonContainer;");
                    return;
                }
            }
            mSingleInstance = new SafeService(null);
        }

        public SingletonContainer() {
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
    }

    public SafeService() {
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

    public static SafeService getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return SingletonContainer.mSingleInstance;
        }
        return (SafeService) invokeV.objValue;
    }

    public /* synthetic */ SafeService(AnonymousClass1 anonymousClass1) {
        this();
    }

    public String getDeviceAuthToken(Context context, String str, String str2, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, context, str, str2, i)) == null) {
            return FH.gt(context, str, str2, i, null);
        }
        return (String) invokeLLLI.objValue;
    }

    public boolean init(Context context, String str, String str2, int... iArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2, iArr)) == null) {
            try {
                FH.init(context, str, str2, iArr);
                return true;
            } catch (Throwable th) {
                Log.e(Tag, "init()", th.toString());
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public String getZidAndCheckSafe(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, i)) == null) {
            String gzfi = FH.gzfi(context, str, i);
            if (TextUtils.isEmpty(gzfi)) {
                return "NoZidYet";
            }
            return gzfi;
        }
        return (String) invokeLLI.objValue;
    }
}
