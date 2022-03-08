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
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final s a;

    /* renamed from: b  reason: collision with root package name */
    public final o f27741b;

    /* renamed from: c  reason: collision with root package name */
    public final SocketFactory f27742c;

    /* renamed from: d  reason: collision with root package name */
    public final b f27743d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Protocol> f27744e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k> f27745f;

    /* renamed from: g  reason: collision with root package name */
    public final ProxySelector f27746g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final Proxy f27747h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final SSLSocketFactory f27748i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public final HostnameVerifier f27749j;
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
        this.a = aVar.a();
        if (oVar != null) {
            this.f27741b = oVar;
            if (socketFactory != null) {
                this.f27742c = socketFactory;
                if (bVar != null) {
                    this.f27743d = bVar;
                    if (list != null) {
                        this.f27744e = c.d.b.e0.e.s(list);
                        if (list2 != null) {
                            this.f27745f = c.d.b.e0.e.s(list2);
                            if (proxySelector != null) {
                                this.f27746g = proxySelector;
                                this.f27747h = proxy;
                                this.f27748i = sSLSocketFactory;
                                this.f27749j = hostnameVerifier;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27745f : (List) invokeV.objValue;
    }

    public o c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27741b : (o) invokeV.objValue;
    }

    public boolean d(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? this.f27741b.equals(aVar.f27741b) && this.f27743d.equals(aVar.f27743d) && this.f27744e.equals(aVar.f27744e) && this.f27745f.equals(aVar.f27745f) && this.f27746g.equals(aVar.f27746g) && c.d.b.e0.e.p(this.f27747h, aVar.f27747h) && c.d.b.e0.e.p(this.f27748i, aVar.f27748i) && c.d.b.e0.e.p(this.f27749j, aVar.f27749j) && c.d.b.e0.e.p(this.k, aVar.k) && l().w() == aVar.l().w() : invokeL.booleanValue;
    }

    @Nullable
    public HostnameVerifier e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27749j : (HostnameVerifier) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27744e : (List) invokeV.objValue;
    }

    @Nullable
    public Proxy g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f27747h : (Proxy) invokeV.objValue;
    }

    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27743d : (b) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int hashCode = (((((((((((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.a.hashCode()) * 31) + this.f27741b.hashCode()) * 31) + this.f27743d.hashCode()) * 31) + this.f27744e.hashCode()) * 31) + this.f27745f.hashCode()) * 31) + this.f27746g.hashCode()) * 31;
            Proxy proxy = this.f27747h;
            int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
            SSLSocketFactory sSLSocketFactory = this.f27748i;
            int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
            HostnameVerifier hostnameVerifier = this.f27749j;
            int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
            g gVar = this.k;
            return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public ProxySelector i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f27746g : (ProxySelector) invokeV.objValue;
    }

    public SocketFactory j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f27742c : (SocketFactory) invokeV.objValue;
    }

    @Nullable
    public SSLSocketFactory k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f27748i : (SSLSocketFactory) invokeV.objValue;
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
            if (this.f27747h != null) {
                sb.append(", proxy=");
                sb.append(this.f27747h);
            } else {
                sb.append(", proxySelector=");
                sb.append(this.f27746g);
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
