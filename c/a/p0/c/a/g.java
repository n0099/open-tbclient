package c.a.p0.c.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p2.q;
import c.a.p0.c.a.i.h;
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
    public static volatile g f9697e;
    public transient /* synthetic */ FieldHolder $fh;
    public h a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentLinkedQueue<c.a.p0.c.a.i.c> f9698b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f9699c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.c.a.k.c f9700d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9701e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.c.a.k.c f9702f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f9703g;

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
            this.f9703g = gVar;
            this.f9701e = str;
            this.f9702f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.q.j.j.b.e().f();
                this.f9703g.j(this.f9701e, this.f9702f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

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
            this.a = gVar;
        }

        @Override // c.a.p0.c.a.k.e.b
        public void a(boolean z, byte[] bArr) {
            String str;
            c.a.p0.c.a.i.f a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        boolean z2 = c.a.p0.c.a.a.a;
                        if (z && bArr != null && (a = c.a.p0.c.a.j.b.a(bArr)) != null) {
                            byte i2 = a.i();
                            byte[] f2 = a.f();
                            if (f2 != null) {
                                if (c.a.p0.c.a.a.a) {
                                    String str2 = "doHandShake response schemeType =" + ((int) i2);
                                }
                                if (i2 == 21) {
                                    boolean z3 = c.a.p0.c.a.a.a;
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f2);
                                    if (parseFrom != null) {
                                        boolean z4 = c.a.p0.c.a.a.a;
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        f.b(this.a.a, parseFrom);
                                    }
                                } else if (i2 == 22) {
                                    if (c.a.p0.c.a.j.a.a(this.a.a, f2) != null) {
                                        boolean z5 = c.a.p0.c.a.a.a;
                                        this.a.a.s(1);
                                        f.a("serverHello");
                                        while (true) {
                                            c.a.p0.c.a.i.c cVar = (c.a.p0.c.a.i.c) this.a.f9698b.poll();
                                            if (cVar == null) {
                                                return;
                                            }
                                            this.a.g(cVar.b(), cVar.a());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        if (c.a.p0.c.a.a.a) {
                            e2.printStackTrace();
                            String str3 = "exception=" + e2.getMessage();
                        }
                    }
                    this.a.n(str);
                } finally {
                    this.a.f9699c = false;
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
        this.a = new h();
        this.f9699c = false;
        this.f9698b = new ConcurrentLinkedQueue<>();
    }

    public static g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f9697e == null) {
                synchronized (g.class) {
                    if (f9697e == null) {
                        f9697e = new g();
                    }
                }
            }
            return f9697e;
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
                if (c.a.p0.c.a.a.a) {
                    String str2 = "BdtlsPmsRequest before bdtls encrypt requestData = " + str;
                }
                if (TextUtils.equals(cVar.b(), "GET")) {
                    b2 = e.f().b(this.a, null);
                } else {
                    b2 = e.f().b(this.a, str);
                }
                if (b2 != null) {
                    boolean z = c.a.p0.c.a.a.a;
                    cVar.i(true);
                    this.f9700d = cVar;
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
            boolean z = c.a.p0.c.a.a.a;
            if (this.f9699c) {
                boolean z2 = c.a.p0.c.a.a.a;
                return;
            }
            this.f9699c = true;
            byte[] e2 = e.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new c.a.p0.c.a.k.e().a(e2, new b(this));
                return;
            }
            this.f9699c = false;
            n("record data error");
        }
    }

    public final void i(String str, c.a.p0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            if (cVar != null && TextUtils.equals(cVar.b(), "GET")) {
                boolean z = c.a.p0.c.a.a.a;
                cVar.i(false);
                this.f9700d = cVar;
                cVar.h(null);
            } else if (cVar != null && str != null) {
                boolean z2 = c.a.p0.c.a.a.a;
                cVar.i(false);
                this.f9700d = cVar;
                cVar.h(str.getBytes());
            } else {
                o(-1, cVar);
            }
        }
    }

    public final void j(String str, c.a.p0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, cVar) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.f9698b == null) {
                        this.f9698b = new ConcurrentLinkedQueue<>();
                    }
                    this.f9698b.offer(new c.a.p0.c.a.i.c(str, cVar));
                    if (c.a.p0.a.k1.l.b.c()) {
                        c.a.p0.c.a.i.d dVar = new c.a.p0.c.a.i.d();
                        long j2 = dVar.getLong("expireTime", 0L);
                        if (j2 > System.currentTimeMillis() / 1000) {
                            this.a.l(dVar.getString("secretKey", "").getBytes());
                            this.a.t(dVar.getString("sessionTicket", "").getBytes());
                            this.a.r(j2);
                            g(str, cVar);
                            return;
                        }
                    }
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
            c.a.p0.c.a.k.c cVar = this.f9700d;
            if (cVar == null) {
                return false;
            }
            return cVar.c();
        }
        return invokeV.booleanValue;
    }

    public h m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new h();
            }
            return this.a;
        }
        return (h) invokeV.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        boolean z = c.a.p0.c.a.a.a;
        int i2 = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.a.s(i2);
        while (true) {
            c.a.p0.c.a.i.c poll = this.f9698b.poll();
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
            q.l(new a(this, str, cVar), "SessionController");
        }
    }
}
