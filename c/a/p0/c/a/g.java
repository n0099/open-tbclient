package c.a.p0.c.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.v2.q;
import c.a.p0.c.a.k.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile g f10319e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.c.a.i.g f10320a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentLinkedQueue<c.a.p0.c.a.i.c> f10321b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f10322c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.c.a.k.c f10323d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10324e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.c.a.k.c f10325f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f10326g;

        public a(g gVar, String str, c.a.p0.c.a.k.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10326g = gVar;
            this.f10324e = str;
            this.f10325f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.n.j.j.b.c().d();
                this.f10326g.j(this.f10324e, this.f10325f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f10327a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10327a = gVar;
        }

        @Override // c.a.p0.c.a.k.e.b
        public void a(boolean z, byte[] bArr) {
            String str;
            c.a.p0.c.a.i.e a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        boolean z2 = c.a.p0.c.a.a.f10311a;
                        if (z && bArr != null && (a2 = c.a.p0.c.a.j.b.a(bArr)) != null) {
                            byte i2 = a2.i();
                            byte[] f2 = a2.f();
                            if (f2 != null) {
                                if (c.a.p0.c.a.a.f10311a) {
                                    String str2 = "doHandShake response schemeType =" + ((int) i2);
                                }
                                if (i2 == 21) {
                                    boolean z3 = c.a.p0.c.a.a.f10311a;
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f2);
                                    if (parseFrom != null) {
                                        boolean z4 = c.a.p0.c.a.a.f10311a;
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        f.b(this.f10327a.f10320a, parseFrom);
                                    }
                                } else if (i2 == 22) {
                                    if (c.a.p0.c.a.j.a.a(this.f10327a.f10320a, f2) != null) {
                                        boolean z5 = c.a.p0.c.a.a.f10311a;
                                        this.f10327a.f10320a.s(1);
                                        f.a("serverHello");
                                        while (true) {
                                            c.a.p0.c.a.i.c cVar = (c.a.p0.c.a.i.c) this.f10327a.f10321b.poll();
                                            if (cVar == null) {
                                                return;
                                            }
                                            this.f10327a.g(cVar.b(), cVar.a());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        if (c.a.p0.c.a.a.f10311a) {
                            e2.printStackTrace();
                            String str3 = "exception=" + e2.getMessage();
                        }
                    }
                    this.f10327a.n(str);
                } finally {
                    this.f10327a.f10322c = false;
                }
            }
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10320a = new c.a.p0.c.a.i.g();
        this.f10322c = false;
        this.f10321b = new ConcurrentLinkedQueue<>();
    }

    public static g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f10319e == null) {
                synchronized (g.class) {
                    if (f10319e == null) {
                        f10319e = new g();
                    }
                }
            }
            return f10319e;
        }
        return (g) invokeV.objValue;
    }

    public final void g(String str, c.a.p0.c.a.k.c cVar) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            if (cVar == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(cVar.b(), "POST")) {
                o(-1, cVar);
            } else {
                if (c.a.p0.c.a.a.f10311a) {
                    String str2 = "BdtlsPmsRequest before bdtls encrypt requestData = " + str;
                }
                if (TextUtils.equals(cVar.b(), "GET")) {
                    b2 = e.f().b(this.f10320a, null);
                } else {
                    b2 = e.f().b(this.f10320a, str);
                }
                if (b2 != null) {
                    boolean z = c.a.p0.c.a.a.f10311a;
                    cVar.i(true);
                    this.f10323d = cVar;
                    cVar.h(b2);
                    return;
                }
                o(-1, cVar);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = c.a.p0.c.a.a.f10311a;
            if (this.f10322c) {
                boolean z2 = c.a.p0.c.a.a.f10311a;
                return;
            }
            this.f10322c = true;
            byte[] e2 = e.f().e(this.f10320a);
            if (e2 != null && e2.length > 0) {
                new c.a.p0.c.a.k.e().a(e2, new b(this));
                return;
            }
            this.f10322c = false;
            n("record data error");
        }
    }

    public final void i(String str, c.a.p0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            if (cVar != null && TextUtils.equals(cVar.b(), "GET")) {
                boolean z = c.a.p0.c.a.a.f10311a;
                cVar.i(false);
                this.f10323d = cVar;
                cVar.h(null);
            } else if (cVar != null && str != null) {
                boolean z2 = c.a.p0.c.a.a.f10311a;
                cVar.i(false);
                this.f10323d = cVar;
                cVar.h(str.getBytes());
            } else {
                o(-1, cVar);
            }
        }
    }

    public final void j(String str, c.a.p0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, cVar) == null) {
            if (this.f10320a.h() != 2) {
                if (!this.f10320a.j()) {
                    if (this.f10321b == null) {
                        this.f10321b = new ConcurrentLinkedQueue<>();
                    }
                    this.f10321b.offer(new c.a.p0.c.a.i.c(str, cVar));
                    h();
                    return;
                }
                g(str, cVar);
                return;
            }
            i(str, cVar);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.p0.c.a.k.c cVar = this.f10323d;
            if (cVar == null) {
                return false;
            }
            return cVar.c();
        }
        return invokeV.booleanValue;
    }

    public c.a.p0.c.a.i.g m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f10320a == null) {
                this.f10320a = new c.a.p0.c.a.i.g();
            }
            return this.f10320a;
        }
        return (c.a.p0.c.a.i.g) invokeV.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        boolean z = c.a.p0.c.a.a.f10311a;
        int i2 = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.f10320a.s(i2);
        while (true) {
            c.a.p0.c.a.i.c poll = this.f10321b.poll();
            if (poll == null) {
                return;
            }
            if (i2 == 2) {
                i(poll.b(), poll.a());
            } else {
                c.a.p0.c.a.k.c a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i2, c.a.p0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i2, cVar) == null) || cVar == null) {
            return;
        }
        cVar.f(i2);
    }

    public void p(String str, c.a.p0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, cVar) == null) {
            q.k(new a(this, str, cVar), "SessionController");
        }
    }
}
