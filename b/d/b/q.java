package b.d.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.TlsVersion;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
/* loaded from: classes6.dex */
public final class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TlsVersion f30551a;

    /* renamed from: b  reason: collision with root package name */
    public final h f30552b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Certificate> f30553c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Certificate> f30554d;

    public q(TlsVersion tlsVersion, h hVar, List<Certificate> list, List<Certificate> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tlsVersion, hVar, list, list2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30551a = tlsVersion;
        this.f30552b = hVar;
        this.f30553c = list;
        this.f30554d = list2;
    }

    public static q b(SSLSession sSLSession) throws IOException {
        InterceptResult invokeL;
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sSLSession)) == null) {
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite != null) {
                if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
                    h a2 = h.a(cipherSuite);
                    String protocol = sSLSession.getProtocol();
                    if (protocol != null) {
                        if (!"NONE".equals(protocol)) {
                            TlsVersion forJavaName = TlsVersion.forJavaName(protocol);
                            try {
                                certificateArr = sSLSession.getPeerCertificates();
                            } catch (SSLPeerUnverifiedException unused) {
                                certificateArr = null;
                            }
                            if (certificateArr != null) {
                                emptyList = b.d.b.e0.e.t(certificateArr);
                            } else {
                                emptyList = Collections.emptyList();
                            }
                            Certificate[] localCertificates = sSLSession.getLocalCertificates();
                            if (localCertificates != null) {
                                emptyList2 = b.d.b.e0.e.t(localCertificates);
                            } else {
                                emptyList2 = Collections.emptyList();
                            }
                            return new q(forJavaName, a2, emptyList, emptyList2);
                        }
                        throw new IOException("tlsVersion == NONE");
                    }
                    throw new IllegalStateException("tlsVersion == null");
                }
                throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
            }
            throw new IllegalStateException("cipherSuite == null");
        }
        return (q) invokeL.objValue;
    }

    public h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30552b : (h) invokeV.objValue;
    }

    public List<Certificate> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30554d : (List) invokeV.objValue;
    }

    @Nullable
    public Principal d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f30554d.isEmpty()) {
                return null;
            }
            return ((X509Certificate) this.f30554d.get(0)).getSubjectX500Principal();
        }
        return (Principal) invokeV.objValue;
    }

    public List<Certificate> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f30553c : (List) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj instanceof q) {
                q qVar = (q) obj;
                return this.f30551a.equals(qVar.f30551a) && this.f30552b.equals(qVar.f30552b) && this.f30553c.equals(qVar.f30553c) && this.f30554d.equals(qVar.f30554d);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public Principal f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f30553c.isEmpty()) {
                return null;
            }
            return ((X509Certificate) this.f30553c.get(0)).getSubjectX500Principal();
        }
        return (Principal) invokeV.objValue;
    }

    public TlsVersion g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30551a : (TlsVersion) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ((((((527 + this.f30551a.hashCode()) * 31) + this.f30552b.hashCode()) * 31) + this.f30553c.hashCode()) * 31) + this.f30554d.hashCode() : invokeV.intValue;
    }
}
