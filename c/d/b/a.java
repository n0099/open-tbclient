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
    public final s f31488a;

    /* renamed from: b  reason: collision with root package name */
    public final o f31489b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f31490c;

    /* renamed from: d  reason: collision with root package name */
    public final b f31491d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Protocol> f31492e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k> f31493f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f31494g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f31495h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f31496i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public final HostnameVerifier f31497j;
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
        this.f31488a = aVar.a();
        if (oVar != null) {
            this.f31489b = oVar;
            if (socketFactory != null) {
                this.f31490c = socketFactory;
                if (bVar != null) {
                    this.f31491d = bVar;
                    if (list != null) {
                        this.f31492e = c.d.b.e0.e.s(list);
                        if (list2 != null) {
                            this.f31493f = c.d.b.e0.e.s(list2);
                            if (proxySelector != null) {
                                this.f31494g = proxySelector;
                                this.f31495h = proxy;
                                this.f31496i = sSLSocketFactory;
                                this.f31497j = hostnameVerifier;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31493f : (List) invokeV.objValue;
    }

    public o c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31489b : (o) invokeV.objValue;
    }

    public boolean d(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? this.f31489b.equals(aVar.f31489b) && this.f31491d.equals(aVar.f31491d) && this.f31492e.equals(aVar.f31492e) && this.f31493f.equals(aVar.f31493f) && this.f31494g.equals(aVar.f31494g) && c.d.b.e0.e.p(this.f31495h, aVar.f31495h) && c.d.b.e0.e.p(this.f31496i, aVar.f31496i) && c.d.b.e0.e.p(this.f31497j, aVar.f31497j) && c.d.b.e0.e.p(this.k, aVar.k) && l().w() == aVar.l().w() : invokeL.booleanValue;
    }

    @Nullable
    public HostnameVerifier e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31497j : (HostnameVerifier) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f31488a.equals(aVar.f31488a) && d(aVar)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31492e : (List) invokeV.objValue;
    }

    @Nullable
    public Proxy g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31495h : (Proxy) invokeV.objValue;
    }

    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31491d : (b) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int hashCode = (((((((((((527 + this.f31488a.hashCode()) * 31) + this.f31489b.hashCode()) * 31) + this.f31491d.hashCode()) * 31) + this.f31492e.hashCode()) * 31) + this.f31493f.hashCode()) * 31) + this.f31494g.hashCode()) * 31;
            Proxy proxy = this.f31495h;
            int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
            SSLSocketFactory sSLSocketFactory = this.f31496i;
            int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
            HostnameVerifier hostnameVerifier = this.f31497j;
            int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
            g gVar = this.k;
            return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public ProxySelector i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f31494g : (ProxySelector) invokeV.objValue;
    }

    public SocketFactory j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f31490c : (SocketFactory) invokeV.objValue;
    }

    @Nullable
    public SSLSocketFactory k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f31496i : (SSLSocketFactory) invokeV.objValue;
    }

    public s l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f31488a : (s) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Address{");
            sb.append(this.f31488a.l());
            sb.append(":");
            sb.append(this.f31488a.w());
            if (this.f31495h != null) {
                sb.append(", proxy=");
                sb.append(this.f31495h);
            } else {
                sb.append(", proxySelector=");
                sb.append(this.f31494g);
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
