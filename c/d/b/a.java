package c.d.b;

import androidx.core.view.InputDeviceCompat;
import c.d.b.s;
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
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final s f31724a;

    /* renamed from: b  reason: collision with root package name */
    public final o f31725b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f31726c;

    /* renamed from: d  reason: collision with root package name */
    public final b f31727d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Protocol> f31728e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k> f31729f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f31730g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f31731h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f31732i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public final HostnameVerifier f31733j;
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
        this.f31724a = aVar.a();
        if (oVar != null) {
            this.f31725b = oVar;
            if (socketFactory != null) {
                this.f31726c = socketFactory;
                if (bVar != null) {
                    this.f31727d = bVar;
                    if (list != null) {
                        this.f31728e = c.d.b.e0.e.s(list);
                        if (list2 != null) {
                            this.f31729f = c.d.b.e0.e.s(list2);
                            if (proxySelector != null) {
                                this.f31730g = proxySelector;
                                this.f31731h = proxy;
                                this.f31732i = sSLSocketFactory;
                                this.f31733j = hostnameVerifier;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31729f : (List) invokeV.objValue;
    }

    public o c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31725b : (o) invokeV.objValue;
    }

    public boolean d(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? this.f31725b.equals(aVar.f31725b) && this.f31727d.equals(aVar.f31727d) && this.f31728e.equals(aVar.f31728e) && this.f31729f.equals(aVar.f31729f) && this.f31730g.equals(aVar.f31730g) && c.d.b.e0.e.p(this.f31731h, aVar.f31731h) && c.d.b.e0.e.p(this.f31732i, aVar.f31732i) && c.d.b.e0.e.p(this.f31733j, aVar.f31733j) && c.d.b.e0.e.p(this.k, aVar.k) && l().w() == aVar.l().w() : invokeL.booleanValue;
    }

    @Nullable
    public HostnameVerifier e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31733j : (HostnameVerifier) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f31724a.equals(aVar.f31724a) && d(aVar)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31728e : (List) invokeV.objValue;
    }

    @Nullable
    public Proxy g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31731h : (Proxy) invokeV.objValue;
    }

    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31727d : (b) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int hashCode = (((((((((((527 + this.f31724a.hashCode()) * 31) + this.f31725b.hashCode()) * 31) + this.f31727d.hashCode()) * 31) + this.f31728e.hashCode()) * 31) + this.f31729f.hashCode()) * 31) + this.f31730g.hashCode()) * 31;
            Proxy proxy = this.f31731h;
            int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
            SSLSocketFactory sSLSocketFactory = this.f31732i;
            int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
            HostnameVerifier hostnameVerifier = this.f31733j;
            int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
            g gVar = this.k;
            return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public ProxySelector i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f31730g : (ProxySelector) invokeV.objValue;
    }

    public SocketFactory j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f31726c : (SocketFactory) invokeV.objValue;
    }

    @Nullable
    public SSLSocketFactory k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f31732i : (SSLSocketFactory) invokeV.objValue;
    }

    public s l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f31724a : (s) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Address{");
            sb.append(this.f31724a.l());
            sb.append(":");
            sb.append(this.f31724a.w());
            if (this.f31731h != null) {
                sb.append(", proxy=");
                sb.append(this.f31731h);
            } else {
                sb.append(", proxySelector=");
                sb.append(this.f31730g);
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
