package android.net.http;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import javax.net.ssl.SSLSocket;
/* loaded from: classes.dex */
public class CertificateChainValidator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CertificateChainValidator() {
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
        throw new RuntimeException("Stub!");
    }

    public static CertificateChainValidator getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (CertificateChainValidator) invokeV.objValue;
    }

    public static void handleTrustStorageUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public static SslError verifyServerCertificates(byte[][] bArr, String str, String str2) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, bArr, str, str2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (SslError) invokeLLL.objValue;
    }

    public SslError doHandshakeAndValidateServerCertificates(HttpsConnection httpsConnection, SSLSocket sSLSocket, String str) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, httpsConnection, sSLSocket, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (SslError) invokeLLL.objValue;
    }
}
