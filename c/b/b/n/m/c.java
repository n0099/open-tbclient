package c.b.b.n.m;

import androidx.core.view.InputDeviceCompat;
import c.b.b.n.e;
import c.b.b.q.a;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public abstract class c<T extends c.b.b.n.e> implements c.b.b.q.h {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, c.b.b.q.a<c>> m;
    public static int n;
    public static boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.b.b.q.a<T> f28072e;

    /* renamed from: f  reason: collision with root package name */
    public int f28073f;

    /* renamed from: g  reason: collision with root package name */
    public int f28074g;

    /* renamed from: h  reason: collision with root package name */
    public int f28075h;

    /* renamed from: i  reason: collision with root package name */
    public int f28076i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f28077j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f28078k;
    public AbstractC1597c<? extends c<T>> l;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28079b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f28080c;

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f28079b || this.f28080c) ? false : true : invokeV.booleanValue;
        }
    }

    /* renamed from: c.b.b.n.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static abstract class AbstractC1597c<U extends c<? extends c.b.b.n.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f28081b;

        /* renamed from: c  reason: collision with root package name */
        public c.b.b.q.a<b> f28082c;

        /* renamed from: d  reason: collision with root package name */
        public a f28083d;

        /* renamed from: e  reason: collision with root package name */
        public a f28084e;

        /* renamed from: f  reason: collision with root package name */
        public a f28085f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f28086g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f28087h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f28088i;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(339287789, "Lc/b/b/n/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(339287789, "Lc/b/b/n/m/c;");
                return;
            }
        }
        m = new HashMap();
        o = false;
    }

    public c() {
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
        this.f28072e = new c.b.b.q.a<>();
    }

    public static void a(Application application, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, application, cVar) == null) {
            c.b.b.q.a<c> aVar = m.get(application);
            if (aVar == null) {
                aVar = new c.b.b.q.a<>();
            }
            aVar.a(cVar);
            m.put(application, aVar);
        }
    }

    public static void i(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            m.remove(application);
        }
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            m(sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static StringBuilder m(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, sb)) == null) {
            sb.append("Managed buffers/app: { ");
            for (Application application : m.keySet()) {
                sb.append(m.get(application).f28143f);
                sb.append(" ");
            }
            sb.append("}");
            return sb;
        }
        return (StringBuilder) invokeL.objValue;
    }

    public static void n(Application application) {
        c.b.b.q.a<c> aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, application) == null) || c.b.b.f.f27699f == null || (aVar = m.get(application)) == null) {
            return;
        }
        for (int i2 = 0; i2 < aVar.f28143f; i2++) {
            aVar.get(i2).g();
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.b.b.n.c cVar = c.b.b.f.f27699f;
            a.b<T> it = this.f28072e.iterator();
            while (it.hasNext()) {
                k(it.next());
            }
            if (this.f28077j) {
                cVar.p(this.f28076i);
            } else {
                if (this.l.f28087h) {
                    cVar.p(this.f28074g);
                }
                if (this.l.f28086g) {
                    cVar.p(this.f28075h);
                }
            }
            cVar.r(this.f28073f);
            if (m.get(c.b.b.f.a) != null) {
                m.get(c.b.b.f.a).i(this, true);
            }
        }
    }

    public abstract void f(T t);

    public void g() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.b.b.n.c cVar = c.b.b.f.f27699f;
            h();
            if (!o) {
                o = true;
                if (c.b.b.f.a.getType() == Application.ApplicationType.iOS) {
                    IntBuffer asIntBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
                    cVar.C(36006, asIntBuffer);
                    n = asIntBuffer.get(0);
                } else {
                    n = 0;
                }
            }
            int Q = cVar.Q();
            this.f28073f = Q;
            cVar.f(36160, Q);
            AbstractC1597c<? extends c<T>> abstractC1597c = this.l;
            int i3 = abstractC1597c.a;
            int i4 = abstractC1597c.f28081b;
            if (abstractC1597c.f28087h) {
                int P = cVar.P();
                this.f28074g = P;
                cVar.m(36161, P);
                cVar.e(36161, this.l.f28084e.a, i3, i4);
            }
            if (this.l.f28086g) {
                int P2 = cVar.P();
                this.f28075h = P2;
                cVar.m(36161, P2);
                cVar.e(36161, this.l.f28083d.a, i3, i4);
            }
            if (this.l.f28088i) {
                int P3 = cVar.P();
                this.f28076i = P3;
                cVar.m(36161, P3);
                cVar.e(36161, this.l.f28085f.a, i3, i4);
            }
            boolean z = this.l.f28082c.f28143f > 1;
            this.f28078k = z;
            if (z) {
                a.b<b> it = this.l.f28082c.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    b next = it.next();
                    T j2 = j(next);
                    this.f28072e.a(j2);
                    if (next.a()) {
                        cVar.B(36160, i5 + 36064, 3553, j2.i(), 0);
                        i5++;
                    } else if (next.f28079b) {
                        cVar.B(36160, 36096, 3553, j2.i(), 0);
                    } else if (next.f28080c) {
                        cVar.B(36160, 36128, 3553, j2.i(), 0);
                    }
                }
                i2 = i5;
            } else {
                T j3 = j(this.l.f28082c.first());
                this.f28072e.a(j3);
                cVar.N(j3.f27850e, j3.i());
                i2 = 0;
            }
            if (this.f28078k) {
                IntBuffer d2 = BufferUtils.d(i2);
                for (int i6 = 0; i6 < i2; i6++) {
                    d2.put(i6 + 36064);
                }
                d2.position(0);
                c.b.b.f.f27700g.c(i2, d2);
            } else {
                f(this.f28072e.first());
            }
            if (this.l.f28087h) {
                cVar.k(36160, 36096, 36161, this.f28074g);
            }
            if (this.l.f28086g) {
                cVar.k(36160, 36128, 36161, this.f28075h);
            }
            if (this.l.f28088i) {
                cVar.k(36160, 33306, 36161, this.f28076i);
            }
            cVar.m(36161, 0);
            a.b<T> it2 = this.f28072e.iterator();
            while (it2.hasNext()) {
                cVar.N(it2.next().f27850e, 0);
            }
            int t = cVar.t(36160);
            if (t == 36061) {
                AbstractC1597c<? extends c<T>> abstractC1597c2 = this.l;
                if (abstractC1597c2.f28087h && abstractC1597c2.f28086g && (c.b.b.f.f27695b.a("GL_OES_packed_depth_stencil") || c.b.b.f.f27695b.a("GL_EXT_packed_depth_stencil"))) {
                    if (this.l.f28087h) {
                        cVar.p(this.f28074g);
                        this.f28074g = 0;
                    }
                    if (this.l.f28086g) {
                        cVar.p(this.f28075h);
                        this.f28075h = 0;
                    }
                    if (this.l.f28088i) {
                        cVar.p(this.f28076i);
                        this.f28076i = 0;
                    }
                    int P4 = cVar.P();
                    this.f28076i = P4;
                    this.f28077j = true;
                    cVar.m(36161, P4);
                    cVar.e(36161, 35056, i3, i4);
                    cVar.m(36161, 0);
                    cVar.k(36160, 36096, 36161, this.f28076i);
                    cVar.k(36160, 36128, 36161, this.f28076i);
                    t = cVar.t(36160);
                }
            }
            cVar.f(36160, n);
            if (t != 36053) {
                a.b<T> it3 = this.f28072e.iterator();
                while (it3.hasNext()) {
                    k(it3.next());
                }
                if (this.f28077j) {
                    cVar.b(this.f28076i);
                } else {
                    if (this.l.f28087h) {
                        cVar.p(this.f28074g);
                    }
                    if (this.l.f28086g) {
                        cVar.p(this.f28075h);
                    }
                }
                cVar.r(this.f28073f);
                if (t == 36054) {
                    throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete attachment");
                }
                if (t == 36057) {
                    throw new IllegalStateException("Frame buffer couldn't be constructed: incomplete dimensions");
                }
                if (t == 36055) {
                    throw new IllegalStateException("Frame buffer couldn't be constructed: missing attachment");
                }
                if (t == 36061) {
                    throw new IllegalStateException("Frame buffer couldn't be constructed: unsupported combination of formats");
                }
                throw new IllegalStateException("Frame buffer couldn't be constructed: unknown error " + t);
            }
            a(c.b.b.f.a, this);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || c.b.b.f.f27695b.b()) {
            return;
        }
        AbstractC1597c<? extends c<T>> abstractC1597c = this.l;
        if (!abstractC1597c.f28088i) {
            c.b.b.q.a<b> aVar = abstractC1597c.f28082c;
            if (aVar.f28143f <= 1) {
                a.b<b> it = aVar.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (!next.f28079b) {
                        if (!next.f28080c) {
                            if (next.a && !c.b.b.f.f27695b.a("OES_texture_float")) {
                                throw new GdxRuntimeException("Float texture FrameBuffer Attachment not available on GLES 2.0");
                            }
                        } else {
                            throw new GdxRuntimeException("Stencil texture FrameBuffer Attachment not available on GLES 2.0");
                        }
                    } else {
                        throw new GdxRuntimeException("Depth texture FrameBuffer Attachment not available on GLES 2.0");
                    }
                }
                return;
            }
            throw new GdxRuntimeException("Multiple render targets not available on GLES 2.0");
        }
        throw new GdxRuntimeException("Packed Stencil/Render render buffers are not available on GLES 2.0");
    }

    public abstract T j(b bVar);

    public abstract void k(T t);
}
