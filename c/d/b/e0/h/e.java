package c.d.b.e0.h;

import c.d.b.d0;
import c.d.b.p;
import c.d.b.s;
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
/* loaded from: classes4.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.d.b.a f31694a;

    /* renamed from: b  reason: collision with root package name */
    public final d f31695b;

    /* renamed from: c  reason: collision with root package name */
    public final c.d.b.e f31696c;

    /* renamed from: d  reason: collision with root package name */
    public final p f31697d;

    /* renamed from: e  reason: collision with root package name */
    public List<Proxy> f31698e;

    /* renamed from: f  reason: collision with root package name */
    public int f31699f;

    /* renamed from: g  reason: collision with root package name */
    public List<InetSocketAddress> f31700g;

    /* renamed from: h  reason: collision with root package name */
    public final List<d0> f31701h;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<d0> f31702a;

        /* renamed from: b  reason: collision with root package name */
        public int f31703b;

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
            this.f31703b = 0;
            this.f31702a = list;
        }

        public List<d0> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ArrayList(this.f31702a) : (List) invokeV.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31703b < this.f31702a.size() : invokeV.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                for (int i2 = 0; i2 < this.f31702a.size(); i2++) {
                    if (this.f31702a.get(i2).d().getAddress() instanceof Inet4Address) {
                        this.f31703b = i2;
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
                    List<d0> list = this.f31702a;
                    int i2 = this.f31703b;
                    this.f31703b = i2 + 1;
                    return list.get(i2);
                }
                throw new NoSuchElementException();
            }
            return (d0) invokeV.objValue;
        }
    }

    public e(c.d.b.a aVar, d dVar, c.d.b.e eVar, p pVar) {
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
        this.f31698e = Collections.emptyList();
        this.f31700g = Collections.emptyList();
        this.f31701h = new ArrayList();
        this.f31694a = aVar;
        this.f31695b = dVar;
        this.f31696c = eVar;
        this.f31697d = pVar;
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
            if (d0Var.b().type() != Proxy.Type.DIRECT && this.f31694a.i() != null) {
                this.f31694a.i().connectFailed(this.f31694a.l().C(), d0Var.b().address(), iOException);
            }
            this.f31695b.b(d0Var);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d() || !this.f31701h.isEmpty() : invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31699f < this.f31698e.size() : invokeV.booleanValue;
    }

    public a e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (c()) {
                ArrayList arrayList = new ArrayList();
                while (d()) {
                    Proxy f2 = f();
                    int size = this.f31700g.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        d0 d0Var = new d0(this.f31694a, f2, this.f31700g.get(i2));
                        if (this.f31695b.c(d0Var)) {
                            this.f31701h.add(d0Var);
                        } else {
                            arrayList.add(d0Var);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        break;
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList.addAll(this.f31701h);
                    this.f31701h.clear();
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
                List<Proxy> list = this.f31698e;
                int i2 = this.f31699f;
                this.f31699f = i2 + 1;
                Proxy proxy = list.get(i2);
                g(proxy);
                return proxy;
            }
            throw new SocketException("No route to " + this.f31694a.l().l() + "; exhausted proxy configurations: " + this.f31698e);
        }
        return (Proxy) invokeV.objValue;
    }

    public final void g(Proxy proxy) throws IOException {
        String l;
        int w;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, proxy) == null) {
            this.f31700g = new ArrayList();
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
                l = this.f31694a.l().l();
                w = this.f31694a.l().w();
            }
            if (w >= 1 && w <= 65535) {
                if (proxy.type() == Proxy.Type.SOCKS) {
                    this.f31700g.add(InetSocketAddress.createUnresolved(l, w));
                    return;
                }
                this.f31697d.dnsStart(this.f31696c, l);
                List<InetAddress> lookup = this.f31694a.c().lookup(l);
                if (!lookup.isEmpty()) {
                    this.f31697d.dnsEnd(this.f31696c, l, lookup);
                    int size = lookup.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.f31700g.add(new InetSocketAddress(lookup.get(i2), w));
                    }
                    return;
                }
                throw new UnknownHostException(this.f31694a.c() + " returned no addresses for " + l);
            }
            throw new SocketException("No route to " + l + ":" + w + "; port is out of range");
        }
    }

    public final void h(s sVar, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, sVar, proxy) == null) {
            if (proxy != null) {
                this.f31698e = Collections.singletonList(proxy);
            } else {
                List<Proxy> select = this.f31694a.i().select(sVar.C());
                this.f31698e = (select == null || select.isEmpty()) ? c.d.b.e0.e.t(Proxy.NO_PROXY) : c.d.b.e0.e.s(select);
            }
            this.f31699f = 0;
        }
    }
}
