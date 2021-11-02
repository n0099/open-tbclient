package b.d.b;

import androidx.core.view.InputDeviceCompat;
import b.d.b.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final s f30122a;

    /* renamed from: b  reason: collision with root package name */
    public final o f30123b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f30124c;

    /* renamed from: d  reason: collision with root package name */
    public final b f30125d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Protocol> f30126e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k> f30127f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f30128g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f30129h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f30130i;
    @Nullable
    public final HostnameVerifier j;
    @Nullable
    public final g k;

    public a(String str, int i2, o oVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable g gVar, b bVar, @Nullable Proxy proxy, List<Protocol> list, List<k> list2, ProxySelector proxySelector) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, Integer.valueOf(i2), oVar, socketFactory, sSLSocketFactory, hostnameVerifier, gVar, bVar, proxy, list, list2, proxySelector};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        s.a aVar = new s.a();
        aVar.q(sSLSocketFactory != null ? "https" : "http");
        aVar.e(str);
        aVar.l(i2);
        this.f30122a = aVar.a();
        if (oVar != null) {
            this.f30123b = oVar;
            if (socketFactory != null) {
                this.f30124c = socketFactory;
                if (bVar != null) {
                    this.f30125d = bVar;
                    if (list != null) {
                        this.f30126e = b.d.b.e0.e.s(list);
                        if (list2 != null) {
                            this.f30127f = b.d.b.e0.e.s(list2);
                            if (proxySelector != null) {
                                this.f30128g = proxySelector;
                                this.f30129h = proxy;
                                this.f30130i = sSLSocketFactory;
                                this.j = hostnameVerifier;
                                this.k = gVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    @Nullable
    public g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (g) invokeV.objValue;
    }

    public List<k> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30127f : (List) invokeV.objValue;
    }

    public o c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30123b : (o) invokeV.objValue;
    }

    public boolean d(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? this.f30123b.equals(aVar.f30123b) && this.f30125d.equals(aVar.f30125d) && this.f30126e.equals(aVar.f30126e) && this.f30127f.equals(aVar.f30127f) && this.f30128g.equals(aVar.f30128g) && b.d.b.e0.e.p(this.f30129h, aVar.f30129h) && b.d.b.e0.e.p(this.f30130i, aVar.f30130i) && b.d.b.e0.e.p(this.j, aVar.j) && b.d.b.e0.e.p(this.k, aVar.k) && l().w() == aVar.l().w() : invokeL.booleanValue;
    }

    @Nullable
    public HostnameVerifier e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : (HostnameVerifier) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f30122a.equals(aVar.f30122a) && d(aVar)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public List<Protocol> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30126e : (List) invokeV.objValue;
    }

    @Nullable
    public Proxy g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f30129h : (Proxy) invokeV.objValue;
    }

    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f30125d : (b) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int hashCode = (((((((((((527 + this.f30122a.hashCode()) * 31) + this.f30123b.hashCode()) * 31) + this.f30125d.hashCode()) * 31) + this.f30126e.hashCode()) * 31) + this.f30127f.hashCode()) * 31) + this.f30128g.hashCode()) * 31;
            Proxy proxy = this.f30129h;
            int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
            SSLSocketFactory sSLSocketFactory = this.f30130i;
            int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
            HostnameVerifier hostnameVerifier = this.j;
            int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
            g gVar = this.k;
            return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public ProxySelector i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f30128g : (ProxySelector) invokeV.objValue;
    }

    public SocketFactory j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f30124c : (SocketFactory) invokeV.objValue;
    }

    @Nullable
    public SSLSocketFactory k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f30130i : (SSLSocketFactory) invokeV.objValue;
    }

    public s l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f30122a : (s) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Address{");
            sb.append(this.f30122a.l());
            sb.append(":");
            sb.append(this.f30122a.w());
            if (this.f30129h != null) {
                sb.append(", proxy=");
                sb.append(this.f30129h);
            } else {
                sb.append(", proxySelector=");
                sb.append(this.f30128g);
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
