package c.d.b;

import androidx.core.view.InputDeviceCompat;
import c.d.b.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.duxiaoman.okhttp3.Protocol;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final s a;

    /* renamed from: b  reason: collision with root package name */
    public final o f28022b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f28023c;

    /* renamed from: d  reason: collision with root package name */
    public final b f28024d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Protocol> f28025e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k> f28026f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f28027g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f28028h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f28029i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public final HostnameVerifier f28030j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public final g f28031k;

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
        this.a = aVar.a();
        if (oVar != null) {
            this.f28022b = oVar;
            if (socketFactory != null) {
                this.f28023c = socketFactory;
                if (bVar != null) {
                    this.f28024d = bVar;
                    if (list != null) {
                        this.f28025e = c.d.b.e0.e.s(list);
                        if (list2 != null) {
                            this.f28026f = c.d.b.e0.e.s(list2);
                            if (proxySelector != null) {
                                this.f28027g = proxySelector;
                                this.f28028h = proxy;
                                this.f28029i = sSLSocketFactory;
                                this.f28030j = hostnameVerifier;
                                this.f28031k = gVar;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28031k : (g) invokeV.objValue;
    }

    public List<k> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28026f : (List) invokeV.objValue;
    }

    public o c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28022b : (o) invokeV.objValue;
    }

    public boolean d(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? this.f28022b.equals(aVar.f28022b) && this.f28024d.equals(aVar.f28024d) && this.f28025e.equals(aVar.f28025e) && this.f28026f.equals(aVar.f28026f) && this.f28027g.equals(aVar.f28027g) && c.d.b.e0.e.p(this.f28028h, aVar.f28028h) && c.d.b.e0.e.p(this.f28029i, aVar.f28029i) && c.d.b.e0.e.p(this.f28030j, aVar.f28030j) && c.d.b.e0.e.p(this.f28031k, aVar.f28031k) && l().w() == aVar.l().w() : invokeL.booleanValue;
    }

    @Nullable
    public HostnameVerifier e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f28030j : (HostnameVerifier) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.a.equals(aVar.a) && d(aVar)) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28025e : (List) invokeV.objValue;
    }

    @Nullable
    public Proxy g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28028h : (Proxy) invokeV.objValue;
    }

    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28024d : (b) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int hashCode = (((((((((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.a.hashCode()) * 31) + this.f28022b.hashCode()) * 31) + this.f28024d.hashCode()) * 31) + this.f28025e.hashCode()) * 31) + this.f28026f.hashCode()) * 31) + this.f28027g.hashCode()) * 31;
            Proxy proxy = this.f28028h;
            int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
            SSLSocketFactory sSLSocketFactory = this.f28029i;
            int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
            HostnameVerifier hostnameVerifier = this.f28030j;
            int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
            g gVar = this.f28031k;
            return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public ProxySelector i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f28027g : (ProxySelector) invokeV.objValue;
    }

    public SocketFactory j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f28023c : (SocketFactory) invokeV.objValue;
    }

    @Nullable
    public SSLSocketFactory k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f28029i : (SSLSocketFactory) invokeV.objValue;
    }

    public s l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : (s) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Address{");
            sb.append(this.a.l());
            sb.append(":");
            sb.append(this.a.w());
            if (this.f28028h != null) {
                sb.append(", proxy=");
                sb.append(this.f28028h);
            } else {
                sb.append(", proxySelector=");
                sb.append(this.f28027g);
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
