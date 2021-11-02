package b.d.b.e0.h;

import b.d.b.d0;
import b.d.b.p;
import b.d.b.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.d.b.a f30239a;

    /* renamed from: b  reason: collision with root package name */
    public final d f30240b;

    /* renamed from: c  reason: collision with root package name */
    public final b.d.b.e f30241c;

    /* renamed from: d  reason: collision with root package name */
    public final p f30242d;

    /* renamed from: e  reason: collision with root package name */
    public List<Proxy> f30243e;

    /* renamed from: f  reason: collision with root package name */
    public int f30244f;

    /* renamed from: g  reason: collision with root package name */
    public List<InetSocketAddress> f30245g;

    /* renamed from: h  reason: collision with root package name */
    public final List<d0> f30246h;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<d0> f30247a;

        /* renamed from: b  reason: collision with root package name */
        public int f30248b;

        public a(List<d0> list) {
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
            this.f30248b = 0;
            this.f30247a = list;
        }

        public List<d0> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ArrayList(this.f30247a) : (List) invokeV.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30248b < this.f30247a.size() : invokeV.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                for (int i2 = 0; i2 < this.f30247a.size(); i2++) {
                    if (this.f30247a.get(i2).d().getAddress() instanceof Inet4Address) {
                        this.f30248b = i2;
                        return;
                    }
                }
            }
        }

        public d0 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (b()) {
                    List<d0> list = this.f30247a;
                    int i2 = this.f30248b;
                    this.f30248b = i2 + 1;
                    return list.get(i2);
                }
                throw new NoSuchElementException();
            }
            return (d0) invokeV.objValue;
        }
    }

    public e(b.d.b.a aVar, d dVar, b.d.b.e eVar, p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, dVar, eVar, pVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30243e = Collections.emptyList();
        this.f30245g = Collections.emptyList();
        this.f30246h = new ArrayList();
        this.f30239a = aVar;
        this.f30240b = dVar;
        this.f30241c = eVar;
        this.f30242d = pVar;
        h(aVar.l(), aVar.g());
    }

    public static String b(InetSocketAddress inetSocketAddress) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inetSocketAddress)) == null) {
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                return inetSocketAddress.getHostName();
            }
            return address.getHostAddress();
        }
        return (String) invokeL.objValue;
    }

    public void a(d0 d0Var, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, d0Var, iOException) == null) {
            if (d0Var.b().type() != Proxy.Type.DIRECT && this.f30239a.i() != null) {
                this.f30239a.i().connectFailed(this.f30239a.l().B(), d0Var.b().address(), iOException);
            }
            this.f30240b.b(d0Var);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d() || !this.f30246h.isEmpty() : invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30244f < this.f30243e.size() : invokeV.booleanValue;
    }

    public a e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (c()) {
                ArrayList arrayList = new ArrayList();
                while (d()) {
                    Proxy f2 = f();
                    int size = this.f30245g.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        d0 d0Var = new d0(this.f30239a, f2, this.f30245g.get(i2));
                        if (this.f30240b.c(d0Var)) {
                            this.f30246h.add(d0Var);
                        } else {
                            arrayList.add(d0Var);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        break;
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList.addAll(this.f30246h);
                    this.f30246h.clear();
                }
                return new a(arrayList);
            }
            throw new NoSuchElementException();
        }
        return (a) invokeV.objValue;
    }

    public final Proxy f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (d()) {
                List<Proxy> list = this.f30243e;
                int i2 = this.f30244f;
                this.f30244f = i2 + 1;
                Proxy proxy = list.get(i2);
                g(proxy);
                return proxy;
            }
            throw new SocketException("No route to " + this.f30239a.l().l() + "; exhausted proxy configurations: " + this.f30243e);
        }
        return (Proxy) invokeV.objValue;
    }

    public final void g(Proxy proxy) throws IOException {
        String l;
        int w;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, proxy) == null) {
            this.f30245g = new ArrayList();
            if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
                SocketAddress address = proxy.address();
                if (address instanceof InetSocketAddress) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                    l = b(inetSocketAddress);
                    w = inetSocketAddress.getPort();
                } else {
                    throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
                }
            } else {
                l = this.f30239a.l().l();
                w = this.f30239a.l().w();
            }
            if (w >= 1 && w <= 65535) {
                if (proxy.type() == Proxy.Type.SOCKS) {
                    this.f30245g.add(InetSocketAddress.createUnresolved(l, w));
                    return;
                }
                this.f30242d.dnsStart(this.f30241c, l);
                List<InetAddress> lookup = this.f30239a.c().lookup(l);
                if (!lookup.isEmpty()) {
                    this.f30242d.dnsEnd(this.f30241c, l, lookup);
                    int size = lookup.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.f30245g.add(new InetSocketAddress(lookup.get(i2), w));
                    }
                    return;
                }
                throw new UnknownHostException(this.f30239a.c() + " returned no addresses for " + l);
            }
            throw new SocketException("No route to " + l + ":" + w + "; port is out of range");
        }
    }

    public final void h(s sVar, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, sVar, proxy) == null) {
            if (proxy != null) {
                this.f30243e = Collections.singletonList(proxy);
            } else {
                List<Proxy> select = this.f30239a.i().select(sVar.B());
                this.f30243e = (select == null || select.isEmpty()) ? b.d.b.e0.e.t(Proxy.NO_PROXY) : b.d.b.e0.e.s(select);
            }
            this.f30244f = 0;
        }
    }
}
