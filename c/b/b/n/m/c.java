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
/* loaded from: classes3.dex */
public abstract class c<T extends c.b.b.n.e> implements c.b.b.q.h {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Application, c.b.b.q.a<c>> i;
    public static int j;
    public static boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public c.b.b.q.a<T> a;

    /* renamed from: b  reason: collision with root package name */
    public int f22657b;

    /* renamed from: c  reason: collision with root package name */
    public int f22658c;

    /* renamed from: d  reason: collision with root package name */
    public int f22659d;

    /* renamed from: e  reason: collision with root package name */
    public int f22660e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22661f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22662g;

    /* renamed from: h  reason: collision with root package name */
    public AbstractC1649c<? extends c<T>> f22663h;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f22664b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f22665c;

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.f22664b || this.f22665c) ? false : true : invokeV.booleanValue;
        }
    }

    /* renamed from: c.b.b.n.m.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC1649c<U extends c<? extends c.b.b.n.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f22666b;

        /* renamed from: c  reason: collision with root package name */
        public c.b.b.q.a<b> f22667c;

        /* renamed from: d  reason: collision with root package name */
        public a f22668d;

        /* renamed from: e  reason: collision with root package name */
        public a f22669e;

        /* renamed from: f  reason: collision with root package name */
        public a f22670f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f22671g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f22672h;
        public boolean i;
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
        i = new HashMap();
        k = false;
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
        this.a = new c.b.b.q.a<>();
    }

    public static void a(Application application, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, application, cVar) == null) {
            c.b.b.q.a<c> aVar = i.get(application);
            if (aVar == null) {
                aVar = new c.b.b.q.a<>();
            }
            aVar.a(cVar);
            i.put(application, aVar);
        }
    }

    public static void i(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            i.remove(application);
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
            for (Application application : i.keySet()) {
                sb.append(i.get(application).f22717b);
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
        if (!(interceptable == null || interceptable.invokeL(65542, null, application) == null) || c.b.b.f.f22335f == null || (aVar = i.get(application)) == null) {
            return;
        }
        for (int i2 = 0; i2 < aVar.f22717b; i2++) {
            aVar.get(i2).g();
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.b.b.n.c cVar = c.b.b.f.f22335f;
            a.b<T> it = this.a.iterator();
            while (it.hasNext()) {
                k(it.next());
            }
            if (this.f22661f) {
                cVar.p(this.f22660e);
            } else {
                if (this.f22663h.f22672h) {
                    cVar.p(this.f22658c);
                }
                if (this.f22663h.f22671g) {
                    cVar.p(this.f22659d);
                }
            }
            cVar.r(this.f22657b);
            if (i.get(c.b.b.f.a) != null) {
                i.get(c.b.b.f.a).j(this, true);
            }
        }
    }

    public abstract void f(T t);

    public void g() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.b.b.n.c cVar = c.b.b.f.f22335f;
            h();
            if (!k) {
                k = true;
                if (c.b.b.f.a.getType() == Application.ApplicationType.iOS) {
                    IntBuffer asIntBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
                    cVar.C(36006, asIntBuffer);
                    j = asIntBuffer.get(0);
                } else {
                    j = 0;
                }
            }
            int Q = cVar.Q();
            this.f22657b = Q;
            cVar.f(36160, Q);
            AbstractC1649c<? extends c<T>> abstractC1649c = this.f22663h;
            int i3 = abstractC1649c.a;
            int i4 = abstractC1649c.f22666b;
            if (abstractC1649c.f22672h) {
                int P = cVar.P();
                this.f22658c = P;
                cVar.m(36161, P);
                cVar.e(36161, this.f22663h.f22669e.a, i3, i4);
            }
            if (this.f22663h.f22671g) {
                int P2 = cVar.P();
                this.f22659d = P2;
                cVar.m(36161, P2);
                cVar.e(36161, this.f22663h.f22668d.a, i3, i4);
            }
            if (this.f22663h.i) {
                int P3 = cVar.P();
                this.f22660e = P3;
                cVar.m(36161, P3);
                cVar.e(36161, this.f22663h.f22670f.a, i3, i4);
            }
            boolean z = this.f22663h.f22667c.f22717b > 1;
            this.f22662g = z;
            if (z) {
                a.b<b> it = this.f22663h.f22667c.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    b next = it.next();
                    T j2 = j(next);
                    this.a.a(j2);
                    if (next.a()) {
                        cVar.B(36160, i5 + 36064, 3553, j2.i(), 0);
                        i5++;
                    } else if (next.f22664b) {
                        cVar.B(36160, 36096, 3553, j2.i(), 0);
                    } else if (next.f22665c) {
                        cVar.B(36160, 36128, 3553, j2.i(), 0);
                    }
                }
                i2 = i5;
            } else {
                T j3 = j(this.f22663h.f22667c.f());
                this.a.a(j3);
                cVar.N(j3.a, j3.i());
                i2 = 0;
            }
            if (this.f22662g) {
                IntBuffer d2 = BufferUtils.d(i2);
                for (int i6 = 0; i6 < i2; i6++) {
                    d2.put(i6 + 36064);
                }
                d2.position(0);
                c.b.b.f.f22336g.c(i2, d2);
            } else {
                f(this.a.f());
            }
            if (this.f22663h.f22672h) {
                cVar.k(36160, 36096, 36161, this.f22658c);
            }
            if (this.f22663h.f22671g) {
                cVar.k(36160, 36128, 36161, this.f22659d);
            }
            if (this.f22663h.i) {
                cVar.k(36160, 33306, 36161, this.f22660e);
            }
            cVar.m(36161, 0);
            a.b<T> it2 = this.a.iterator();
            while (it2.hasNext()) {
                cVar.N(it2.next().a, 0);
            }
            int t = cVar.t(36160);
            if (t == 36061) {
                AbstractC1649c<? extends c<T>> abstractC1649c2 = this.f22663h;
                if (abstractC1649c2.f22672h && abstractC1649c2.f22671g && (c.b.b.f.f22331b.a("GL_OES_packed_depth_stencil") || c.b.b.f.f22331b.a("GL_EXT_packed_depth_stencil"))) {
                    if (this.f22663h.f22672h) {
                        cVar.p(this.f22658c);
                        this.f22658c = 0;
                    }
                    if (this.f22663h.f22671g) {
                        cVar.p(this.f22659d);
                        this.f22659d = 0;
                    }
                    if (this.f22663h.i) {
                        cVar.p(this.f22660e);
                        this.f22660e = 0;
                    }
                    int P4 = cVar.P();
                    this.f22660e = P4;
                    this.f22661f = true;
                    cVar.m(36161, P4);
                    cVar.e(36161, 35056, i3, i4);
                    cVar.m(36161, 0);
                    cVar.k(36160, 36096, 36161, this.f22660e);
                    cVar.k(36160, 36128, 36161, this.f22660e);
                    t = cVar.t(36160);
                }
            }
            cVar.f(36160, j);
            if (t != 36053) {
                a.b<T> it3 = this.a.iterator();
                while (it3.hasNext()) {
                    k(it3.next());
                }
                if (this.f22661f) {
                    cVar.b(this.f22660e);
                } else {
                    if (this.f22663h.f22672h) {
                        cVar.p(this.f22658c);
                    }
                    if (this.f22663h.f22671g) {
                        cVar.p(this.f22659d);
                    }
                }
                cVar.r(this.f22657b);
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || c.b.b.f.f22331b.b()) {
            return;
        }
        AbstractC1649c<? extends c<T>> abstractC1649c = this.f22663h;
        if (!abstractC1649c.i) {
            c.b.b.q.a<b> aVar = abstractC1649c.f22667c;
            if (aVar.f22717b <= 1) {
                a.b<b> it = aVar.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (!next.f22664b) {
                        if (!next.f22665c) {
                            if (next.a && !c.b.b.f.f22331b.a("OES_texture_float")) {
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
