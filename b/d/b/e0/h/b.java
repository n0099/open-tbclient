package b.d.b.e0.h;

import b.d.b.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<k> f30226a;

    /* renamed from: b  reason: collision with root package name */
    public int f30227b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30228c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30229d;

    public b(List<k> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30227b = 0;
        this.f30226a = list;
    }

    public k a(SSLSocket sSLSocket) throws IOException {
        InterceptResult invokeL;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sSLSocket)) == null) {
            int i2 = this.f30227b;
            int size = this.f30226a.size();
            while (true) {
                if (i2 >= size) {
                    kVar = null;
                    break;
                }
                kVar = this.f30226a.get(i2);
                if (kVar.c(sSLSocket)) {
                    this.f30227b = i2 + 1;
                    break;
                }
                i2++;
            }
            if (kVar != null) {
                this.f30228c = c(sSLSocket);
                b.d.b.e0.a.f30186a.c(kVar, sSLSocket, this.f30229d);
                return kVar;
            }
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f30229d + ", modes=" + this.f30226a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        return (k) invokeL.objValue;
    }

    public boolean b(IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException)) == null) {
            this.f30229d = true;
            if (!this.f30228c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
                return false;
            }
            boolean z = iOException instanceof SSLHandshakeException;
            if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
                return false;
            }
            return z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
        }
        return invokeL.booleanValue;
    }

    public final boolean c(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sSLSocket)) == null) {
            for (int i2 = this.f30227b; i2 < this.f30226a.size(); i2++) {
                if (this.f30226a.get(i2).c(sSLSocket)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
