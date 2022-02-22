package c.d.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
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
/* loaded from: classes9.dex */
public final class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TlsVersion a;

    /* renamed from: b  reason: collision with root package name */
    public final h f28220b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Certificate> f28221c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Certificate> f28222d;

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
        this.a = tlsVersion;
        this.f28220b = hVar;
        this.f28221c = list;
        this.f28222d = list2;
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
                    h a = h.a(cipherSuite);
                    String protocol = sSLSession.getProtocol();
                    if (protocol != null) {
                        if (!PolyActivity.NONE_PANEL_TYPE.equals(protocol)) {
                            TlsVersion forJavaName = TlsVersion.forJavaName(protocol);
                            try {
                                certificateArr = sSLSession.getPeerCertificates();
                            } catch (SSLPeerUnverifiedException unused) {
                                certificateArr = null;
                            }
                            if (certificateArr != null) {
                                emptyList = c.d.b.e0.e.t(certificateArr);
                            } else {
                                emptyList = Collections.emptyList();
                            }
                            Certificate[] localCertificates = sSLSession.getLocalCertificates();
                            if (localCertificates != null) {
                                emptyList2 = c.d.b.e0.e.t(localCertificates);
                            } else {
                                emptyList2 = Collections.emptyList();
                            }
                            return new q(forJavaName, a, emptyList, emptyList2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28220b : (h) invokeV.objValue;
    }

    public List<Certificate> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28222d : (List) invokeV.objValue;
    }

    @Nullable
    public Principal d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f28222d.isEmpty()) {
                return null;
            }
            return ((X509Certificate) this.f28222d.get(0)).getSubjectX500Principal();
        }
        return (Principal) invokeV.objValue;
    }

    public List<Certificate> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28221c : (List) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj instanceof q) {
                q qVar = (q) obj;
                return this.a.equals(qVar.a) && this.f28220b.equals(qVar.f28220b) && this.f28221c.equals(qVar.f28221c) && this.f28222d.equals(qVar.f28222d);
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
            if (this.f28221c.isEmpty()) {
                return null;
            }
            return ((X509Certificate) this.f28221c.get(0)).getSubjectX500Principal();
        }
        return (Principal) invokeV.objValue;
    }

    public TlsVersion g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (TlsVersion) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ((((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.a.hashCode()) * 31) + this.f28220b.hashCode()) * 31) + this.f28221c.hashCode()) * 31) + this.f28222d.hashCode() : invokeV.intValue;
    }
}
