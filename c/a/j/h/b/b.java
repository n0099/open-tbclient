package c.a.j.h.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.transition.Transition;
import c.a.j.h.b.b$b.i;
import c.a.j.h.b.b$b.k;
import c.a.j.h.b.b$b.l;
import c.a.j.h.b.b$b.m;
import c.a.j.h.b.b$f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdptask.bdtls.AES;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class b implements c.a.j.h.b.a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static c.a.j.h.b.a f4036b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f4037c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a implements c.a.j.h.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.j.h.b.a
        public c.a.j.h.b.g.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? m().a() : (c.a.j.h.b.g.a) invokeV.objValue;
        }

        @Override // c.a.j.h.b.a
        public c.a.j.h.b.h.a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? m().b() : (c.a.j.h.b.h.a) invokeV.objValue;
        }

        @Override // c.a.j.h.b.a
        public c.a.j.h.b.c.a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? m().c() : (c.a.j.h.b.c.a) invokeV.objValue;
        }

        @Override // c.a.j.h.b.a
        public c.a.j.h.b.i.c e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? m().e() : (c.a.j.h.b.i.c) invokeV.objValue;
        }

        @Override // c.a.j.h.b.a
        public c.a.j.h.b.e.a g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? m().g() : (c.a.j.h.b.e.a) invokeV.objValue;
        }

        @Override // c.a.j.h.b.a
        public c.a.j.h.b.d.a h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? m().h() : (c.a.j.h.b.d.a) invokeV.objValue;
        }

        @Override // c.a.j.h.b.a
        public c.a.j.h.b.f.b i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? m().i() : (c.a.j.h.b.f.b) invokeV.objValue;
        }

        public final void j(c.a.j.h.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                n(aVar);
                k(true);
            }
        }

        public final void k(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
                b.a = z;
            }
        }

        public final boolean l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? b.a : invokeV.booleanValue;
        }

        public final c.a.j.h.b.a m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? b.m() : (c.a.j.h.b.a) invokeV.objValue;
        }

        public final void n(c.a.j.h.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
                b.f4036b = aVar;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public static final byte[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(49930425, "Lc/a/j/h/b/b$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(49930425, "Lc/a/j/h/b/b$c;");
                    return;
                }
            }
            a = new byte[]{0, -98};
        }
    }

    /* loaded from: classes.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public static volatile e a;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static e a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a == null) {
                    synchronized (e.class) {
                        if (a == null) {
                            a = new e();
                        }
                    }
                }
                return a;
            }
            return (e) invokeV.objValue;
        }

        public void b(String str, c.a.j.h.b.b$f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bVar) == null) {
                h.b().g(str, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public static volatile g a;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        public static int a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
                if (bArr != null) {
                    int i2 = 0;
                    for (byte b2 : bArr) {
                        i2 = (i2 << 8) | (b2 & 255);
                    }
                    return i2;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public static g c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (a == null) {
                    synchronized (g.class) {
                        if (a == null) {
                            a = new g();
                        }
                    }
                }
                return a;
            }
            return (g) invokeV.objValue;
        }

        public static byte[] d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)} : (byte[]) invokeI.objValue;
        }

        public l b(m mVar, byte[] bArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, mVar, bArr)) == null) {
                l lVar = new l();
                try {
                    k a2 = c.a.j.h.b.b$d.b.a(bArr);
                    byte i2 = a2.i();
                    if (i2 == 21) {
                        c.a.j.h.b.b$b.a a3 = c.a.j.h.b.b$b.a.a(a2.o());
                        if (a3 != null) {
                            String b2 = a3.b();
                            DebugTrace debugTrace = DebugTrace.a;
                            debugTrace.a("bdtls ubc application alert : " + b2);
                            if (1 == a3.d()) {
                                lVar.b(-2);
                            } else if (TextUtils.equals(b2, "down grade")) {
                                lVar.b(2);
                            } else {
                                lVar.b(-1);
                            }
                            if (b.f4037c.h().d()) {
                                if (a3.b() != null) {
                                    DebugTrace debugTrace2 = DebugTrace.a;
                                    debugTrace2.a("BdtlsPostRequest response alert message=" + b2);
                                } else {
                                    DebugTrace.a.a("BdtlsPostRequest response alert messag=null");
                                }
                            }
                        } else {
                            lVar.b(-1);
                        }
                    } else if (i2 == 23) {
                        lVar.c(new String(AES.aesDecrypt(a2.p(), mVar.q())));
                        lVar.b(1);
                    }
                } catch (Exception e2) {
                    DebugTrace debugTrace3 = DebugTrace.a;
                    debugTrace3.a("exception=" + e2.getMessage());
                    lVar.b(-1);
                }
                return lVar;
            }
            return (l) invokeLL.objValue;
        }

        public byte[] e(m mVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar)) == null) {
                if (mVar == null) {
                    return null;
                }
                try {
                    byte[] b2 = c.a.j.h.b.b$d.a.b(mVar, new i());
                    if (b2 == null) {
                        return null;
                    }
                    k a2 = k.f4062i.a();
                    a2.a((byte) 22);
                    a2.c((short) b2.length);
                    a2.j(b2);
                    return c.a.j.h.b.b$d.b.b(a2);
                } catch (Exception e2) {
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("exception=" + e2.getMessage());
                    return null;
                }
            }
            return (byte[]) invokeL.objValue;
        }

        public byte[] f(m mVar, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, mVar, str)) == null) {
                if (mVar == null) {
                    return null;
                }
                try {
                    k a2 = k.f4062i.a();
                    a2.a((byte) 23);
                    byte[] r = mVar.r();
                    if (r != null && r.length > 0 && r.length <= 32767) {
                        a2.c((short) r.length);
                        a2.j(r);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        byte[] aesEncrypt = AES.aesEncrypt(str, mVar.q());
                        a2.b(aesEncrypt.length);
                        a2.l(aesEncrypt);
                    }
                    return c.a.j.h.b.b$d.b.b(a2);
                } catch (Exception e2) {
                    DebugTrace debugTrace = DebugTrace.a;
                    debugTrace.a("exception=" + e2.getMessage());
                    return null;
                }
            }
            return (byte[]) invokeLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static volatile h f4089d;
        public transient /* synthetic */ FieldHolder $fh;
        public m a;

        /* renamed from: b  reason: collision with root package name */
        public ConcurrentLinkedQueue<c.a.j.h.b.b$b.h> f4090b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f4091c;

        /* loaded from: classes.dex */
        public static class a implements Function0<Unit> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public Unit invoke() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    System.loadLibrary("bdptask");
                    return null;
                }
                return (Unit) invokeV.objValue;
            }
        }

        /* renamed from: c.a.j.h.b.b$h$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0184b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f4092e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.a.j.h.b.b$f.b f4093f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ h f4094g;

            public RunnableC0184b(h hVar, String str, c.a.j.h.b.b$f.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, str, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4094g = hVar;
                this.f4092e = str;
                this.f4093f = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f4094g.l(this.f4092e, this.f4093f);
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements c.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public c(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // c.a.j.h.b.b$f.c.b
            public void a(boolean z, byte[] bArr) {
                k a;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                    String str = "";
                    try {
                        try {
                            DebugTrace.a.a("doHandShake response");
                            if (z && bArr != null && (a = c.a.j.h.b.b$d.b.a(bArr)) != null) {
                                byte i2 = a.i();
                                byte[] o = a.o();
                                if (o != null) {
                                    DebugTrace debugTrace = DebugTrace.a;
                                    debugTrace.a("doHandShake response schemeType =" + ((int) i2));
                                    if (i2 == 21) {
                                        DebugTrace.a.a("doHandShake alert");
                                        c.a.j.h.b.b$b.a a2 = c.a.j.h.b.b$b.a.a(o);
                                        if (a2 != null) {
                                            DebugTrace.a.a("bdtls ubc handshake alert");
                                            if (a2.b() != null) {
                                                str = a2.b();
                                            }
                                        }
                                    } else if (i2 == 22) {
                                        if (c.a.j.h.b.b$d.a.a(this.a.a, o) != null) {
                                            DebugTrace.a.a("doHandShake serverHello");
                                            this.a.a.b(1);
                                            while (true) {
                                                c.a.j.h.b.b$b.h hVar = (c.a.j.h.b.b$b.h) this.a.f4090b.poll();
                                                if (hVar == null) {
                                                    return;
                                                }
                                                this.a.n(hVar.a(), hVar.b());
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            DebugTrace debugTrace2 = DebugTrace.a;
                            debugTrace2.a("exception=" + e2.getMessage());
                        }
                        this.a.f(str);
                    } finally {
                        this.a.f4091c = false;
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(49930580, "Lc/a/j/h/b/b$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(49930580, "Lc/a/j/h/b/b$h;");
                    return;
                }
            }
            c.a.j.h.d.h.a(new a());
            f4089d = new h();
        }

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = new m();
            this.f4091c = false;
            this.f4090b = new ConcurrentLinkedQueue<>();
        }

        public static h b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f4089d : (h) invokeV.objValue;
        }

        public final void c(int i2, c.a.j.h.b.b$f.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, bVar) == null) || bVar == null) {
                return;
            }
            bVar.b(i2);
        }

        public final void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) {
                return;
            }
            DebugTrace.a.a("onHandshakeError");
            int i2 = TextUtils.equals(str, "down grade") ? 2 : -1;
            this.a.b(i2);
            while (true) {
                c.a.j.h.b.b$b.h poll = this.f4090b.poll();
                if (poll == null) {
                    return;
                }
                if (i2 == 2) {
                    o(poll.a(), poll.b());
                } else {
                    c.a.j.h.b.b$f.b b2 = poll.b();
                    if (b2 != null) {
                        b2.c(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            }
        }

        public void g(String str, c.a.j.h.b.b$f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bVar) == null) {
                ExecutorUtilsExt.postOnSerial(new RunnableC0184b(this, str, bVar), "SessionController");
            }
        }

        public m i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.a == null) {
                    this.a = new m();
                }
                return this.a;
            }
            return (m) invokeV.objValue;
        }

        public final void l(String str, c.a.j.h.b.b$f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, bVar) == null) {
                if (this.a.a() != 2) {
                    if (!this.a.k()) {
                        if (this.f4090b == null) {
                            this.f4090b = new ConcurrentLinkedQueue<>();
                        }
                        this.f4090b.offer(new c.a.j.h.b.b$b.h(str, bVar));
                        m();
                        return;
                    }
                    n(str, bVar);
                    return;
                }
                o(str, bVar);
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                DebugTrace.a.a("doHandShake");
                if (this.f4091c) {
                    DebugTrace.a.a("doHandShake isHandshakeRunning");
                    return;
                }
                this.f4091c = true;
                byte[] e2 = g.c().e(this.a);
                if (e2 != null && e2.length > 0) {
                    new c.a.j.h.b.b$f.c().a(e2, new c(this));
                    return;
                }
                this.f4091c = false;
                f("record data error");
            }
        }

        public final void n(String str, c.a.j.h.b.b$f.b bVar) {
            byte[] f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, str, bVar) == null) {
                if (str != null && bVar != null) {
                    if (TextUtils.equals(bVar.a(), "GET")) {
                        f2 = g.c().f(this.a, null);
                    } else {
                        f2 = g.c().f(this.a, str);
                    }
                    if (f2 != null) {
                        DebugTrace.a.a("doBdtlsApplicationDataRequest");
                        bVar.e(true);
                        bVar.f(f2);
                        return;
                    }
                    c(-1, bVar);
                    return;
                }
                c(-1, null);
            }
        }

        public final void o(String str, c.a.j.h.b.b$f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, str, bVar) == null) {
                if (bVar != null && str != null) {
                    DebugTrace.a.a("doNormalApplicationDataRequest");
                    bVar.e(false);
                    bVar.f(str.getBytes());
                    return;
                }
                c(-1, bVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1421279448, "Lc/a/j/h/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1421279448, "Lc/a/j/h/b/b;");
                return;
            }
        }
        f4037c = new a(null);
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final /* synthetic */ c.a.j.h.b.a m() {
        c.a.j.h.b.a aVar = f4036b;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Transition.MATCH_INSTANCE_STR);
        }
        return aVar;
    }
}
