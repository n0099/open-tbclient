package android.net.http;

import android.content.Context;
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
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class RequestQueue implements RequestFeeder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RequestQueue(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public RequestQueue(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
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

    public synchronized void disablePlatformNotifications() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public synchronized void enablePlatformNotifications() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }

    public HttpHost getProxyHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpHost) invokeV.objValue;
    }

    @Override // android.net.http.RequestFeeder
    public synchronized Request getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (Request) invokeV.objValue;
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void startTiming() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void stopTiming() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // android.net.http.RequestFeeder
    public synchronized Request getRequest(HttpHost httpHost) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, httpHost)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return (Request) invokeL.objValue;
    }

    @Override // android.net.http.RequestFeeder
    public synchronized boolean haveRequest(HttpHost httpHost) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, httpHost)) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.net.http.RequestFeeder
    public void requeueRequest(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, request) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public RequestHandle queueRequest(String str, WebAddress webAddress, String str2, Map map, EventHandler eventHandler, InputStream inputStream, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, webAddress, str2, map, eventHandler, inputStream, Integer.valueOf(i)})) == null) {
            throw new RuntimeException("Stub!");
        }
        return (RequestHandle) invokeCommon.objValue;
    }

    public RequestHandle queueSynchronousRequest(String str, WebAddress webAddress, String str2, Map map, EventHandler eventHandler, InputStream inputStream, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, webAddress, str2, map, eventHandler, inputStream, Integer.valueOf(i)})) == null) {
            throw new RuntimeException("Stub!");
        }
        return (RequestHandle) invokeCommon.objValue;
    }

    public RequestHandle queueRequest(String str, String str2, Map map, EventHandler eventHandler, InputStream inputStream, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, str2, map, eventHandler, inputStream, Integer.valueOf(i)})) == null) {
            throw new RuntimeException("Stub!");
        }
        return (RequestHandle) invokeCommon.objValue;
    }

    public synchronized void queueRequest(Request request, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, request, z) == null) {
            synchronized (this) {
                throw new RuntimeException("Stub!");
            }
        }
    }
}
