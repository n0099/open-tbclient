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
    public c.b.b.q.a<T> f27322e;

    /* renamed from: f  reason: collision with root package name */
    public int f27323f;

    /* renamed from: g  reason: collision with root package name */
    public int f27324g;

    /* renamed from: h  reason: collision with root package name */
    public int f27325h;

    /* renamed from: i  reason: collision with root package name */
    public int f27326i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f27327j;
    public boolean k;
    public AbstractC1618c<? extends c<T>> l;

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
        public boolean f27328b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f27329c;

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f27328b || this.f27329c) ? false : true : invokeV.booleanValue;
        }
    }

    /* renamed from: c.b.b.n.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static abstract class AbstractC1618c<U extends c<? extends c.b.b.n.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f27330b;

        /* renamed from: c  reason: collision with root package name */
        public c.b.b.q.a<b> f27331c;

        /* renamed from: d  reason: collision with root package name */
        public a f27332d;

        /* renamed from: e  reason: collision with root package name */
        public a f27333e;

        /* renamed from: f  reason: collision with root package name */
        public a f27334f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f27335g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f27336h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f27337i;
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
        this.f27322e = new c.b.b.q.a<>();
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
                sb.append(m.get(application).f27389f);
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
        if (!(interceptable == null || interceptable.invokeL(65542, null, application) == null) || c.b.b.f.f26968f == null || (aVar = m.get(application)) == null) {
            return;
        }
        for (int i2 = 0; i2 < aVar.f27389f; i2++) {
            aVar.get(i2).g();
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.b.b.n.c cVar = c.b.b.f.f26968f;
            a.b<T> it = this.f27322e.iterator();
            while (it.hasNext()) {
                k(it.next());
            }
            if (this.f27327j) {
                cVar.p(this.f27326i);
            } else {
                if (this.l.f27336h) {
                    cVar.p(this.f27324g);
                }
                if (this.l.f27335g) {
                    cVar.p(this.f27325h);
                }
            }
            cVar.r(this.f27323f);
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
            c.b.b.n.c cVar = c.b.b.f.f26968f;
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
            this.f27323f = Q;
            cVar.f(36160, Q);
            AbstractC1618c<? extends c<T>> abstractC1618c = this.l;
            int i3 = abstractC1618c.a;
            int i4 = abstractC1618c.f27330b;
            if (abstractC1618c.f27336h) {
                int P = cVar.P();
                this.f27324g = P;
                cVar.m(36161, P);
                cVar.e(36161, this.l.f27333e.a, i3, i4);
            }
            if (this.l.f27335g) {
                int P2 = cVar.P();
                this.f27325h = P2;
                cVar.m(36161, P2);
                cVar.e(36161, this.l.f27332d.a, i3, i4);
            }
            if (this.l.f27337i) {
                int P3 = cVar.P();
                this.f27326i = P3;
                cVar.m(36161, P3);
                cVar.e(36161, this.l.f27334f.a, i3, i4);
            }
            boolean z = this.l.f27331c.f27389f > 1;
            this.k = z;
            if (z) {
                a.b<b> it = this.l.f27331c.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    b next = it.next();
                    T j2 = j(next);
                    this.f27322e.a(j2);
                    if (next.a()) {
                        cVar.B(36160, i5 + 36064, 3553, j2.i(), 0);
                        i5++;
                    } else if (next.f27328b) {
                        cVar.B(36160, 36096, 3553, j2.i(), 0);
                    } else if (next.f27329c) {
                        cVar.B(36160, 36128, 3553, j2.i(), 0);
                    }
                }
                i2 = i5;
            } else {
                T j3 = j(this.l.f27331c.first());
                this.f27322e.a(j3);
                cVar.N(j3.f27113e, j3.i());
                i2 = 0;
            }
            if (this.k) {
                IntBuffer d2 = BufferUtils.d(i2);
                for (int i6 = 0; i6 < i2; i6++) {
                    d2.put(i6 + 36064);
                }
                d2.position(0);
                c.b.b.f.f26969g.c(i2, d2);
            } else {
                f(this.f27322e.first());
            }
            if (this.l.f27336h) {
                cVar.k(36160, 36096, 36161, this.f27324g);
            }
            if (this.l.f27335g) {
                cVar.k(36160, 36128, 36161, this.f27325h);
            }
            if (this.l.f27337i) {
                cVar.k(36160, 33306, 36161, this.f27326i);
            }
            cVar.m(36161, 0);
            a.b<T> it2 = this.f27322e.iterator();
            while (it2.hasNext()) {
                cVar.N(it2.next().f27113e, 0);
            }
            int t = cVar.t(36160);
            if (t == 36061) {
                AbstractC1618c<? extends c<T>> abstractC1618c2 = this.l;
                if (abstractC1618c2.f27336h && abstractC1618c2.f27335g && (c.b.b.f.f26964b.a("GL_OES_packed_depth_stencil") || c.b.b.f.f26964b.a("GL_EXT_packed_depth_stencil"))) {
                    if (this.l.f27336h) {
                        cVar.p(this.f27324g);
                        this.f27324g = 0;
                    }
                    if (this.l.f27335g) {
                        cVar.p(this.f27325h);
                        this.f27325h = 0;
                    }
                    if (this.l.f27337i) {
                        cVar.p(this.f27326i);
                        this.f27326i = 0;
                    }
                    int P4 = cVar.P();
                    this.f27326i = P4;
                    this.f27327j = true;
                    cVar.m(36161, P4);
                    cVar.e(36161, 35056, i3, i4);
                    cVar.m(36161, 0);
                    cVar.k(36160, 36096, 36161, this.f27326i);
                    cVar.k(36160, 36128, 36161, this.f27326i);
                    t = cVar.t(36160);
                }
            }
            cVar.f(36160, n);
            if (t != 36053) {
                a.b<T> it3 = this.f27322e.iterator();
                while (it3.hasNext()) {
                    k(it3.next());
                }
                if (this.f27327j) {
                    cVar.b(this.f27326i);
                } else {
                    if (this.l.f27336h) {
                        cVar.p(this.f27324g);
                    }
                    if (this.l.f27335g) {
                        cVar.p(this.f27325h);
                    }
                }
                cVar.r(this.f27323f);
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || c.b.b.f.f26964b.b()) {
            return;
        }
        AbstractC1618c<? extends c<T>> abstractC1618c = this.l;
        if (!abstractC1618c.f27337i) {
            c.b.b.q.a<b> aVar = abstractC1618c.f27331c;
            if (aVar.f27389f <= 1) {
                a.b<b> it = aVar.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (!next.f27328b) {
                        if (!next.f27329c) {
                            if (next.a && !c.b.b.f.f26964b.a("OES_texture_float")) {
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
