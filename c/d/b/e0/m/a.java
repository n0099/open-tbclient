package c.d.b.e0.m;

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Class<?> cls) {
        super(cls, null, null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Class) objArr2[0], (f) objArr2[1], (f) objArr2[2], (f) objArr2[3], (f) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public static g A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (g.r()) {
                try {
                    if (b.B() >= 29) {
                        return new a(Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
                    }
                } catch (ClassNotFoundException unused) {
                }
                return null;
            }
            return null;
        }
        return (g) invokeV.objValue;
    }

    public final void D(SSLSocket sSLSocket) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, sSLSocket) == null) && SSLSockets.isSupportedSocket(sSLSocket)) {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }

    @Override // c.d.b.e0.m.b, c.d.b.e0.m.g
    @SuppressLint({"NewApi"})
    public void h(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sSLSocket, str, list) == null) {
            try {
                D(sSLSocket);
                SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                sSLParameters.setApplicationProtocols((String[]) g.b(list).toArray(new String[0]));
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalArgumentException e2) {
                throw new IOException("Android internal error", e2);
            }
        }
    }

    @Override // c.d.b.e0.m.b, c.d.b.e0.m.g
    @Nullable
    public String p(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sSLSocket)) == null) {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null || applicationProtocol.isEmpty()) {
                return null;
            }
            return applicationProtocol;
        }
        return (String) invokeL.objValue;
    }
}
