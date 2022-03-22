package com.baidu.sofire.core;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ErrorNote {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GZFI_ERROR_CHECK_COMPONENT = 1002;
    public static final int GZFI_ERROR_METHOD_EXCEPTION = 1005;
    public static final int GZFI_ERROR_NO_PROVIDER_AND_WRONG_PROCESS = 1003;
    public static final int GZFI_ERROR_NULL_CONTEXT = 1001;
    public static final int GZFI_ERROR_PROVIDER_REQUEST_FAIL = 1004;
    public static final int SUB_ERROR_CODE_EXCEPTION = -1002;
    public static final int SUB_ERROR_CODE_NULL_PAIR = -1001;
    public static int sErrorCode = -1;
    public static String sErrorLog = "";
    public static String sExceptionLog = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2059327746, "Lcom/baidu/sofire/core/ErrorNote;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2059327746, "Lcom/baidu/sofire/core/ErrorNote;");
        }
    }

    public ErrorNote() {
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

    public static Pair<Integer, String> buildErrorLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return new Pair<>(Integer.valueOf(sErrorCode), !TextUtils.isEmpty(sErrorLog) ? Base64.encodeToString(sErrorLog.getBytes(), 0) : "");
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return new Pair<>(Integer.valueOf(sErrorCode), "");
            }
        }
        return (Pair) invokeV.objValue;
    }

    public static void createErrorLog(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", i);
                jSONObject.put("1", Base64.encodeToString(sExceptionLog.getBytes(), 0));
                sErrorLog = jSONObject.toString();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public static void setErrorCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            sErrorCode = i;
        }
    }

    public static void setErrorLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            sErrorLog = str;
        }
    }

    public static void setExceptionLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            sExceptionLog = str;
        }
    }
}
