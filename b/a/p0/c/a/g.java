package b.a.p0.c.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.z2.q;
import b.a.p0.c.a.i.h;
import b.a.p0.c.a.k.e;
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
    public static volatile g f10130e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f10131a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentLinkedQueue<b.a.p0.c.a.i.c> f10132b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f10133c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.c.a.k.c f10134d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10135e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.c.a.k.c f10136f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f10137g;

        public a(g gVar, String str, b.a.p0.c.a.k.c cVar) {
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
            this.f10137g = gVar;
            this.f10135e = str;
            this.f10136f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.q.k.j.b.e().f();
                this.f10137g.j(this.f10135e, this.f10136f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f10138a;

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
            this.f10138a = gVar;
        }

        @Override // b.a.p0.c.a.k.e.b
        public void a(boolean z, byte[] bArr) {
            String str;
            b.a.p0.c.a.i.f a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        boolean z2 = b.a.p0.c.a.a.f10122a;
                        if (z && bArr != null && (a2 = b.a.p0.c.a.j.b.a(bArr)) != null) {
                            byte i2 = a2.i();
                            byte[] f2 = a2.f();
                            if (f2 != null) {
                                if (b.a.p0.c.a.a.f10122a) {
                                    String str2 = "doHandShake response schemeType =" + ((int) i2);
                                }
                                if (i2 == 21) {
                                    boolean z3 = b.a.p0.c.a.a.f10122a;
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f2);
                                    if (parseFrom != null) {
                                        boolean z4 = b.a.p0.c.a.a.f10122a;
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        f.b(this.f10138a.f10131a, parseFrom);
                                    }
                                } else if (i2 == 22) {
                                    if (b.a.p0.c.a.j.a.a(this.f10138a.f10131a, f2) != null) {
                                        boolean z5 = b.a.p0.c.a.a.f10122a;
                                        this.f10138a.f10131a.s(1);
                                        f.a("serverHello");
                                        while (true) {
                                            b.a.p0.c.a.i.c cVar = (b.a.p0.c.a.i.c) this.f10138a.f10132b.poll();
                                            if (cVar == null) {
                                                return;
                                            }
                                            this.f10138a.g(cVar.b(), cVar.a());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        if (b.a.p0.c.a.a.f10122a) {
                            e2.printStackTrace();
                            String str3 = "exception=" + e2.getMessage();
                        }
                    }
                    this.f10138a.n(str);
                } finally {
                    this.f10138a.f10133c = false;
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
        this.f10131a = new h();
        this.f10133c = false;
        this.f10132b = new ConcurrentLinkedQueue<>();
    }

    public static g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f10130e == null) {
                synchronized (g.class) {
                    if (f10130e == null) {
                        f10130e = new g();
                    }
                }
            }
            return f10130e;
        }
        return (g) invokeV.objValue;
    }

    public final void g(String str, b.a.p0.c.a.k.c cVar) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            if (cVar == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(cVar.b(), "POST")) {
                o(-1, cVar);
            } else {
                if (b.a.p0.c.a.a.f10122a) {
                    String str2 = "BdtlsPmsRequest before bdtls encrypt requestData = " + str;
                }
                if (TextUtils.equals(cVar.b(), "GET")) {
                    b2 = e.f().b(this.f10131a, null);
                } else {
                    b2 = e.f().b(this.f10131a, str);
                }
                if (b2 != null) {
                    boolean z = b.a.p0.c.a.a.f10122a;
                    cVar.i(true);
                    this.f10134d = cVar;
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
            boolean z = b.a.p0.c.a.a.f10122a;
            if (this.f10133c) {
                boolean z2 = b.a.p0.c.a.a.f10122a;
                return;
            }
            this.f10133c = true;
            byte[] e2 = e.f().e(this.f10131a);
            if (e2 != null && e2.length > 0) {
                new b.a.p0.c.a.k.e().a(e2, new b(this));
                return;
            }
            this.f10133c = false;
            n("record data error");
        }
    }

    public final void i(String str, b.a.p0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            if (cVar != null && TextUtils.equals(cVar.b(), "GET")) {
                boolean z = b.a.p0.c.a.a.f10122a;
                cVar.i(false);
                this.f10134d = cVar;
                cVar.h(null);
            } else if (cVar != null && str != null) {
                boolean z2 = b.a.p0.c.a.a.f10122a;
                cVar.i(false);
                this.f10134d = cVar;
                cVar.h(str.getBytes());
            } else {
                o(-1, cVar);
            }
        }
    }

    public final void j(String str, b.a.p0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, cVar) == null) {
            if (this.f10131a.h() != 2) {
                if (!this.f10131a.j()) {
                    if (this.f10132b == null) {
                        this.f10132b = new ConcurrentLinkedQueue<>();
                    }
                    this.f10132b.offer(new b.a.p0.c.a.i.c(str, cVar));
                    if (b.a.p0.a.u1.l.b.c()) {
                        b.a.p0.c.a.i.d dVar = new b.a.p0.c.a.i.d();
                        long j = dVar.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.f10131a.l(dVar.getString("secretKey", "").getBytes());
                            this.f10131a.t(dVar.getString("sessionTicket", "").getBytes());
                            this.f10131a.r(j);
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
            b.a.p0.c.a.k.c cVar = this.f10134d;
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
            if (this.f10131a == null) {
                this.f10131a = new h();
            }
            return this.f10131a;
        }
        return (h) invokeV.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        boolean z = b.a.p0.c.a.a.f10122a;
        int i2 = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.f10131a.s(i2);
        while (true) {
            b.a.p0.c.a.i.c poll = this.f10132b.poll();
            if (poll == null) {
                return;
            }
            if (i2 == 2) {
                i(poll.b(), poll.a());
            } else {
                b.a.p0.c.a.k.c a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i2, b.a.p0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i2, cVar) == null) || cVar == null) {
            return;
        }
        cVar.f(i2);
    }

    public void p(String str, b.a.p0.c.a.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, cVar) == null) {
            q.l(new a(this, str, cVar), "SessionController");
        }
    }
}
