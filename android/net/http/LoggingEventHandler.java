package android.net.http;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class LoggingEventHandler implements EventHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LoggingEventHandler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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

    @Override // android.net.http.EventHandler
    public void certificate(SslCertificate sslCertificate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sslCertificate) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // android.net.http.EventHandler
    public void data(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // android.net.http.EventHandler
    public void endData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // android.net.http.EventHandler
    public void error(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // android.net.http.EventHandler
    public boolean handleSslErrorRequest(SslError sslError) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sslError)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.booleanValue;
    }

    @Override // android.net.http.EventHandler
    public void headers(Headers headers) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, headers) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void locationChanged(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void requestSent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // android.net.http.EventHandler
    public void status(int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
