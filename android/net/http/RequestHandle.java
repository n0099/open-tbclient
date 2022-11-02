package android.net.http;

import android.net.compatibility.WebAddress;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class RequestHandle {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_REDIRECT_COUNT = 16;
    public transient /* synthetic */ FieldHolder $fh;

    public RequestHandle(RequestQueue requestQueue, String str, WebAddress webAddress, String str2, Map<String, String> map, InputStream inputStream, int i, Request request) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {requestQueue, str, webAddress, str2, map, inputStream, Integer.valueOf(i), request};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public RequestHandle(RequestQueue requestQueue, String str, WebAddress webAddress, String str2, Map<String, String> map, InputStream inputStream, int i, Request request, Connection connection) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {requestQueue, str, webAddress, str2, map, inputStream, Integer.valueOf(i), request, connection};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public static String authorizationHeader(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeZ.objValue;
    }

    public void handleSslErrorResponse(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void pauseRequest(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setRedirectCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static String computeBasicAuthResponse(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeLL.objValue;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeV.objValue;
    }

    public int getRedirectCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.intValue;
    }

    public boolean isRedirectMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    public void processRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void waitUntilComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setupBasicAuthResponse(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public boolean setupRedirect(String str, int i, Map<String, String> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048586, this, str, i, map)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeLIL.booleanValue;
    }

    public void setupDigestAuthResponse(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), str, str2, str3, str4, str5, str6, str7}) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
