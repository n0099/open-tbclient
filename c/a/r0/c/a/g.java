package c.a.r0.c.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.z2.q;
import c.a.r0.c.a.i.h;
import c.a.r0.c.a.k.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile g f10230e;
    public transient /* synthetic */ FieldHolder $fh;
    public h a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentLinkedQueue<c.a.r0.c.a.i.c> f10231b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f10232c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.c.a.k.c f10233d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.c.a.k.c f10235f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f10236g;

        public a(g gVar, String str, c.a.r0.c.a.k.c cVar) {
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
            this.f10236g = gVar;
            this.f10234e = str;
            this.f10235f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.q.k.j.b.e().f();
                this.f10236g.j(this.f10234e, this.f10235f);
            }
        }
    }

    /* loaded from: classes6.dex */
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

        @Override // c.a.r0.c.a.k.e.b
        public void a(boolean z, byte[] bArr) {
            String str;
            c.a.r0.c.a.i.f a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        boolean z2 = c.a.r0.c.a.a.a;
                        if (z && bArr != null && (a = c.a.r0.c.a.j.b.a(bArr)) != null) {
                            byte i2 = a.i();
                            byte[] f2 = a.f();
                            if (f2 != null) {
                                if (c.a.r0.c.a.a.a) {
                                    String str2 = "doHandShake response schemeType =" + ((int) i2);
                                }
                                if (i2 == 21) {
                                    boolean z3 = c.a.r0.c.a.a.a;
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f2);
                                    if (parseFrom != null) {
                                        boolean z4 = c.a.r0.c.a.a.a;
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        f.b(this.a.a, parseFrom);
                                    }
                                } else if (i2 == 22) {
                                    if (c.a.r0.c.a.j.a.a(this.a.a, f2) != null) {
                                        boolean z5 = c.a.r0.c.a.a.a;
                                        this.a.a.s(1);
                                        f.a("serverHello");
                                        while (true) {
                                            c.a.r0.c.a.i.c cVar = (c.a.r0.c.a.i.c) this.a.f10231b.poll();
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
                        if (c.a.r0.c.a.a.a) {
                            e2.printStackTrace();
                            String str3 = "exception=" + e2.getMessage();
                        }
                    }
                    this.a.n(str);
                } finally {
                    this.a.f10232c = false;
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
        this.f10232c = false;
        this.f10231b = new ConcurrentLinkedQueue<>();
    }

    public static g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f10230e == null) {
                synchronized (g.class) {
                    if (f10230e == null) {
                        f10230e = new g();
                    }
                }
            }
            return f10230e;
        }
        return (g) invokeV.objValue;
    }

    public final void g(String str, c.a.r0.c.a.k.c cVar) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            if (cVar == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(cVar.b(), "POST")) {
                o(-1, cVar);
            } else {
                if (c.a.r0.c.a.a.a) {
                    String str2 = "BdtlsPmsRequest before bdtls encrypt requestData = " + str;
                }
                if (TextUtils.equals(cVar.b(), "GET")) {
                    b2 = e.f().b(this.a, null);
                } else {
                    b2 = e.f().b(this.a, str);
                }
                if (b2 != null) {
                    boolean z = c.a.r0.c.a.a.a;
                    cVar.i(true);
                    this.f10233d = cVar;
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
            boolean z = c.a.r0.c.a.a.a;
            if (this.f10232c) {
                boolean z2 = c.a.r0.c.a.a.a;
                return;
            }
            this.f10232c = true;
            byte[] e2 = e.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new c.a.r0.c.a.k.e().a(e2, new b(this));
                return;
            }
            this.f10232c = false;
            n("record data error");
        }
    }

    public final void i(String str, c.a.r0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            if (cVar != null && TextUtils.equals(cVar.b(), "GET")) {
                boolean z = c.a.r0.c.a.a.a;
                cVar.i(false);
                this.f10233d = cVar;
                cVar.h(null);
            } else if (cVar != null && str != null) {
                boolean z2 = c.a.r0.c.a.a.a;
                cVar.i(false);
                this.f10233d = cVar;
                cVar.h(str.getBytes());
            } else {
                o(-1, cVar);
            }
        }
    }

    public final void j(String str, c.a.r0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, cVar) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.f10231b == null) {
                        this.f10231b = new ConcurrentLinkedQueue<>();
                    }
                    this.f10231b.offer(new c.a.r0.c.a.i.c(str, cVar));
                    if (c.a.r0.a.u1.l.b.c()) {
                        c.a.r0.c.a.i.d dVar = new c.a.r0.c.a.i.d();
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
            c.a.r0.c.a.k.c cVar = this.f10233d;
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
        boolean z = c.a.r0.c.a.a.a;
        int i2 = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.a.s(i2);
        while (true) {
            c.a.r0.c.a.i.c poll = this.f10231b.poll();
            if (poll == null) {
                return;
            }
            if (i2 == 2) {
                i(poll.b(), poll.a());
            } else {
                c.a.r0.c.a.k.c a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i2, c.a.r0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i2, cVar) == null) || cVar == null) {
            return;
        }
        cVar.f(i2);
    }

    public void p(String str, c.a.r0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, cVar) == null) {
            q.l(new a(this, str, cVar), "SessionController");
        }
    }
}
