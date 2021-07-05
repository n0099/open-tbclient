package android.net.http;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class HttpsConnection extends Connection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SslCertificate mCertificate;
    public AndroidHttpClientConnection mHttpClientConnection;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpsConnection() {
        super(null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((Context) objArr[0], (HttpHost) objArr[1], (RequestFeeder) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public static void initializeEngine(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, file) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // android.net.http.Connection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
