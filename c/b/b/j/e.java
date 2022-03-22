package c.b.b.j;

import androidx.core.view.InputDeviceCompat;
import c.b.b.j.c;
import c.b.b.j.f.i;
import c.b.b.j.f.j;
import c.b.b.j.f.l;
import c.b.b.j.f.m;
import c.b.b.j.f.o;
import c.b.b.j.f.p;
import c.b.b.n.k.f;
import c.b.b.q.a;
import c.b.b.q.h;
import c.b.b.q.k;
import c.b.b.q.m0;
import c.b.b.q.n0;
import c.b.b.q.r;
import c.b.b.q.v;
import c.b.b.q.w;
import c.b.b.q.x;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.tachikoma.core.utility.FileUtil;
/* loaded from: classes3.dex */
public class e implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w<Class, w<String, a>> a;

    /* renamed from: b  reason: collision with root package name */
    public final w<String, Class> f22347b;

    /* renamed from: c  reason: collision with root package name */
    public final w<String, c.b.b.q.a<String>> f22348c;

    /* renamed from: d  reason: collision with root package name */
    public final x<String> f22349d;

    /* renamed from: e  reason: collision with root package name */
    public final w<Class, w<String, c.b.b.j.f.a>> f22350e;

    /* renamed from: f  reason: collision with root package name */
    public final c.b.b.q.a<c.b.b.j.a> f22351f;

    /* renamed from: g  reason: collision with root package name */
    public final c.b.b.q.o0.a f22352g;

    /* renamed from: h  reason: collision with root package name */
    public final c.b.b.q.a<d> f22353h;
    public b i;
    public int j;
    public int k;
    public int l;
    public r m;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;

        /* renamed from: b  reason: collision with root package name */
        public int f22354b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22354b = 1;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e() {
        this(new c.b.b.j.f.q.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((c.b.b.j.f.e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public synchronized void A(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            synchronized (this) {
                Class c2 = this.f22347b.c(str);
                if (c2 != null) {
                    this.a.c(c2).c(str).f22354b = i;
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + str);
                }
            }
        }
    }

    public void B(c.b.b.j.a aVar, RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, runtimeException) == null) {
            throw runtimeException;
        }
    }

    public synchronized void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            synchronized (this) {
                String replace = str.replace(FileUtil.WINDOWS_SEPARATOR, WebvttCueParser.CHAR_SLASH);
                if (this.f22353h.f22717b > 0) {
                    d f2 = this.f22353h.f();
                    if (f2.f22340b.a.equals(replace)) {
                        this.m.e("Unload (from tasks): " + replace);
                        f2.l = true;
                        f2.e();
                        return;
                    }
                }
                Class c2 = this.f22347b.c(replace);
                int i = 0;
                while (true) {
                    if (i >= this.f22351f.f22717b) {
                        i = -1;
                        break;
                    } else if (this.f22351f.get(i).a.equals(replace)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    this.k--;
                    c.b.b.j.a i2 = this.f22351f.i(i);
                    this.m.e("Unload (from queue): " + replace);
                    if (c2 != null && i2.f22338c != null && i2.f22338c.a != null) {
                        i2.f22338c.a.a(this, i2.a, i2.f22337b);
                    }
                } else if (c2 != null) {
                    a c3 = this.a.c(c2).c(replace);
                    int i3 = c3.f22354b - 1;
                    c3.f22354b = i3;
                    if (i3 <= 0) {
                        this.m.e("Unload (dispose): " + replace);
                        if (c3.a instanceof h) {
                            ((h) c3.a).dispose();
                        }
                        this.f22347b.k(replace);
                        this.a.c(c2).k(replace);
                    } else {
                        this.m.e("Unload (decrement): " + replace);
                    }
                    c.b.b.q.a<String> c4 = this.f22348c.c(replace);
                    if (c4 != null) {
                        a.b<String> it = c4.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (v(next)) {
                                C(next);
                            }
                        }
                    }
                    if (c3.f22354b <= 0) {
                        this.f22348c.k(replace);
                    }
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + replace);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean D() {
        InterceptResult invokeV;
        boolean z;
        c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return invokeV.booleanValue;
        }
        d peek = this.f22353h.peek();
        try {
            if (!peek.l) {
                if (!peek.update()) {
                    z = false;
                    if (z) {
                        return false;
                    }
                    if (this.f22353h.f22717b == 1) {
                        this.j++;
                        this.l = 0;
                    }
                    this.f22353h.pop();
                    if (peek.l) {
                        return true;
                    }
                    c.b.b.j.a aVar2 = peek.f22340b;
                    a(aVar2.a, aVar2.f22337b, peek.k);
                    c.b.b.j.a aVar3 = peek.f22340b;
                    c cVar = aVar3.f22338c;
                    if (cVar != null && (aVar = cVar.a) != null) {
                        aVar.a(this, aVar3.a, aVar3.f22337b);
                    }
                    long b2 = m0.b();
                    this.m.a("Loaded: " + (((float) (b2 - peek.f22343e)) / 1000000.0f) + "ms " + peek.f22340b);
                    return true;
                }
            }
            z = true;
            if (z) {
            }
        } catch (RuntimeException e2) {
            peek.l = true;
            B(peek.f22340b, e2);
            throw null;
        }
    }

    public <T> void a(String str, Class<T> cls, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, cls, t) == null) {
            this.f22347b.i(str, cls);
            w<String, a> c2 = this.a.c(cls);
            if (c2 == null) {
                c2 = new w<>();
                this.a.i(cls, c2);
            }
            a aVar = new a();
            aVar.a = t;
            c2.i(str, aVar);
        }
    }

    @Override // c.b.b.q.h
    public synchronized void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.m.a("Disposing.");
                g();
                this.f22352g.dispose();
            }
        }
    }

    public final void f(c.b.b.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            c.b.b.j.f.a o = o(aVar.f22337b, aVar.a);
            if (o != null) {
                this.f22353h.a(new d(this, aVar, o, this.f22352g));
                this.l++;
                return;
            }
            throw new GdxRuntimeException("No loader for type: " + c.b.b.q.p0.b.e(aVar.f22337b));
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.f22351f.clear();
                while (!update()) {
                }
                v vVar = new v();
                while (this.f22347b.a > 0) {
                    vVar.clear();
                    c.b.b.q.a<String> e2 = this.f22347b.f().e();
                    a.b<String> it = e2.iterator();
                    while (it.hasNext()) {
                        c.b.b.q.a<String> c2 = this.f22348c.c(it.next());
                        if (c2 != null) {
                            a.b<String> it2 = c2.iterator();
                            while (it2.hasNext()) {
                                vVar.d(it2.next(), 0, 1);
                            }
                        }
                    }
                    a.b<String> it3 = e2.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        if (vVar.c(next, 0) == 0) {
                            C(next);
                        }
                    }
                }
                this.a.clear();
                this.f22347b.clear();
                this.f22348c.clear();
                this.j = 0;
                this.k = 0;
                this.l = 0;
                this.f22351f.clear();
                this.f22353h.clear();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.a("Waiting for loading to complete...");
            while (!update()) {
                c.b.b.q.o0.d.a();
            }
            this.m.a("Loading complete.");
        }
    }

    public synchronized <T> T i(String str) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            synchronized (this) {
                t = (T) l(str, true);
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public synchronized <T> T j(String str, Class<T> cls) {
        InterceptResult invokeLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, cls)) == null) {
            synchronized (this) {
                t = (T) k(str, cls, true);
            }
            return t;
        }
        return (T) invokeLL.objValue;
    }

    public synchronized <T> T k(String str, Class<T> cls, boolean z) {
        InterceptResult invokeLLZ;
        a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, cls, z)) == null) {
            synchronized (this) {
                w<String, a> c3 = this.a.c(cls);
                if (c3 == null || (c2 = c3.c(str)) == null) {
                    if (z) {
                        throw new GdxRuntimeException("Asset not loaded: " + str);
                    }
                    return null;
                }
                return (T) c2.a;
            }
        }
        return (T) invokeLLZ.objValue;
    }

    public synchronized <T> T l(String str, boolean z) {
        InterceptResult invokeLZ;
        w<String, a> c2;
        a c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) {
            synchronized (this) {
                Class c4 = this.f22347b.c(str);
                if (c4 == null || (c2 = this.a.c(c4)) == null || (c3 = c2.c(str)) == null) {
                    if (z) {
                        throw new GdxRuntimeException("Asset not loaded: " + str);
                    }
                    return null;
                }
                return (T) c3.a;
            }
        }
        return (T) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c A[Catch: all -> 0x0049, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000e, B:8:0x0014, B:9:0x0026, B:11:0x002c, B:13:0x003a, B:15:0x0040), top: B:28:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T> String m(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, t)) == null) {
            synchronized (this) {
                w.c<Class> f2 = this.a.f();
                f2.d();
                while (f2.hasNext()) {
                    w.a<String, a> it = this.a.c(f2.next()).iterator();
                    while (it.hasNext()) {
                        w.b next = it.next();
                        Object obj = ((a) next.f22866b).a;
                        if (obj == t || t.equals(obj)) {
                            return (String) next.a;
                        }
                        while (it.hasNext()) {
                        }
                    }
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public synchronized c.b.b.q.a<String> n(String str) {
        InterceptResult invokeL;
        c.b.b.q.a<String> c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                c2 = this.f22348c.c(str);
            }
            return c2;
        }
        return (c.b.b.q.a) invokeL.objValue;
    }

    public <T> c.b.b.j.f.a o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, cls, str)) == null) {
            w<String, c.b.b.j.f.a> c2 = this.f22350e.c(cls);
            c.b.b.j.f.a aVar = null;
            if (c2 != null && c2.a >= 1) {
                if (str == null) {
                    return c2.c("");
                }
                int i = -1;
                w.a<String, c.b.b.j.f.a> b2 = c2.b();
                b2.d();
                while (b2.hasNext()) {
                    w.b next = b2.next();
                    if (((String) next.a).length() > i && str.endsWith((String) next.a)) {
                        aVar = (c.b.b.j.f.a) next.f22866b;
                        i = ((String) next.a).length();
                    }
                }
            }
            return aVar;
        }
        return (c.b.b.j.f.a) invokeLL.objValue;
    }

    public r p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.m : (r) invokeV.objValue;
    }

    public synchronized int q(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            synchronized (this) {
                Class c2 = this.f22347b.c(str);
                if (c2 != null) {
                    i = this.a.c(c2).c(str).f22354b;
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + str);
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public final void r(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, th) == null) {
            this.m.c("Error loading asset.", th);
            if (!this.f22353h.isEmpty()) {
                d pop = this.f22353h.pop();
                c.b.b.j.a aVar = pop.f22340b;
                if (pop.f22345g && pop.f22346h != null) {
                    a.b<c.b.b.j.a> it = pop.f22346h.iterator();
                    while (it.hasNext()) {
                        C(it.next().a);
                    }
                }
                this.f22353h.clear();
                b bVar = this.i;
                if (bVar != null) {
                    bVar.a(aVar, th);
                    return;
                }
                throw new GdxRuntimeException(th);
            }
            throw new GdxRuntimeException(th);
        }
    }

    public final void s(String str) {
        c.b.b.q.a<String> c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || (c2 = this.f22348c.c(str)) == null) {
            return;
        }
        a.b<String> it = c2.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.a.c(this.f22347b.c(next)).c(next).f22354b++;
            s(next);
        }
    }

    public synchronized void t(String str, c.b.b.q.a<c.b.b.j.a> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, aVar) == null) {
            synchronized (this) {
                x<String> xVar = this.f22349d;
                a.b<c.b.b.j.a> it = aVar.iterator();
                while (it.hasNext()) {
                    c.b.b.j.a next = it.next();
                    if (!xVar.contains(next.a)) {
                        xVar.add(next.a);
                        u(str, next);
                    }
                }
                xVar.b(32);
            }
        }
    }

    public final synchronized void u(String str, c.b.b.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, aVar) == null) {
            synchronized (this) {
                c.b.b.q.a<String> c2 = this.f22348c.c(str);
                if (c2 == null) {
                    c2 = new c.b.b.q.a<>();
                    this.f22348c.i(str, c2);
                }
                c2.a(aVar.a);
                if (v(aVar.a)) {
                    r rVar = this.m;
                    rVar.a("Dependency already loaded: " + aVar);
                    a c3 = this.a.c(this.f22347b.c(aVar.a)).c(aVar.a);
                    c3.f22354b = c3.f22354b + 1;
                    s(aVar.a);
                } else {
                    r rVar2 = this.m;
                    rVar2.e("Loading dependency: " + aVar);
                    f(aVar);
                }
            }
        }
    }

    public synchronized boolean update() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                boolean z = false;
                try {
                    if (this.f22353h.f22717b == 0) {
                        while (this.f22351f.f22717b != 0 && this.f22353h.f22717b == 0) {
                            x();
                        }
                        if (this.f22353h.f22717b == 0) {
                            return true;
                        }
                    }
                    if (D() && this.f22351f.f22717b == 0) {
                        if (this.f22353h.f22717b == 0) {
                            z = true;
                        }
                    }
                    return z;
                } catch (Throwable th) {
                    r(th);
                    return this.f22351f.f22717b == 0;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            synchronized (this) {
                if (str == null) {
                    return false;
                }
                return this.f22347b.a(str);
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized <T> void w(String str, Class<T> cls, c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, cls, cVar) == null) {
            synchronized (this) {
                if (o(cls, str) != null) {
                    if (this.f22351f.f22717b == 0) {
                        this.j = 0;
                        this.k = 0;
                        this.l = 0;
                    }
                    for (int i = 0; i < this.f22351f.f22717b; i++) {
                        c.b.b.j.a aVar = this.f22351f.get(i);
                        if (aVar.a.equals(str) && !aVar.f22337b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in preload queue, but has different type (expected: " + c.b.b.q.p0.b.e(cls) + ", found: " + c.b.b.q.p0.b.e(aVar.f22337b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    for (int i2 = 0; i2 < this.f22353h.f22717b; i2++) {
                        c.b.b.j.a aVar2 = this.f22353h.get(i2).f22340b;
                        if (aVar2.a.equals(str) && !aVar2.f22337b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in task list, but has different type (expected: " + c.b.b.q.p0.b.e(cls) + ", found: " + c.b.b.q.p0.b.e(aVar2.f22337b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    Class c2 = this.f22347b.c(str);
                    if (c2 != null && !c2.equals(cls)) {
                        throw new GdxRuntimeException("Asset with name '" + str + "' already loaded, but has different type (expected: " + c.b.b.q.p0.b.e(cls) + ", found: " + c.b.b.q.p0.b.e(c2) + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    this.k++;
                    c.b.b.j.a aVar3 = new c.b.b.j.a(str, cls, cVar);
                    this.f22351f.a(aVar3);
                    this.m.a("Queued: " + aVar3);
                } else {
                    throw new GdxRuntimeException("No loader for type: " + c.b.b.q.p0.b.e(cls));
                }
            }
        }
    }

    public final void x() {
        c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c.b.b.j.a i = this.f22351f.i(0);
            if (v(i.a)) {
                this.m.a("Already loaded: " + i);
                a c2 = this.a.c(this.f22347b.c(i.a)).c(i.a);
                c2.f22354b = c2.f22354b + 1;
                s(i.a);
                c cVar = i.f22338c;
                if (cVar != null && (aVar = cVar.a) != null) {
                    aVar.a(this, i.a, i.f22337b);
                }
                this.j++;
                return;
            }
            this.m.e("Loading: " + i);
            f(i);
        }
    }

    public synchronized <T, P extends c<T>> void y(Class<T> cls, c.b.b.j.f.a<T, P> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, cls, aVar) == null) {
            synchronized (this) {
                z(cls, null, aVar);
            }
        }
    }

    public synchronized <T, P extends c<T>> void z(Class<T> cls, String str, c.b.b.j.f.a<T, P> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, cls, str, aVar) == null) {
            synchronized (this) {
                if (cls == null) {
                    throw new IllegalArgumentException("type cannot be null.");
                }
                if (aVar != null) {
                    r rVar = this.m;
                    rVar.a("Loader set: " + c.b.b.q.p0.b.e(cls) + LoadErrorCode.TOKEN_NEXT + c.b.b.q.p0.b.e(aVar.getClass()));
                    w<String, c.b.b.j.f.a> c2 = this.f22350e.c(cls);
                    if (c2 == null) {
                        w<Class, w<String, c.b.b.j.f.a>> wVar = this.f22350e;
                        w<String, c.b.b.j.f.a> wVar2 = new w<>();
                        wVar.i(cls, wVar2);
                        c2 = wVar2;
                    }
                    if (str == null) {
                        str = "";
                    }
                    c2.i(str, aVar);
                } else {
                    throw new IllegalArgumentException("loader cannot be null.");
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(c.b.b.j.f.e eVar) {
        this(eVar, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c.b.b.j.f.e) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public e(c.b.b.j.f.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new w<>();
        this.f22347b = new w<>();
        this.f22348c = new w<>();
        this.f22349d = new x<>();
        this.f22350e = new w<>();
        this.f22351f = new c.b.b.q.a<>();
        this.f22353h = new c.b.b.q.a<>();
        this.m = new r("AssetManager", 0);
        if (z) {
            y(c.b.b.n.k.a.class, new c.b.b.j.f.c(eVar));
            y(c.b.b.k.a.class, new c.b.b.j.f.h(eVar));
            y(Pixmap.class, new j(eVar));
            y(c.b.b.k.b.class, new m(eVar));
            y(c.b.b.n.k.h.class, new o(eVar));
            y(Texture.class, new p(eVar));
            y(c.b.b.p.a.a.j.class, new l(eVar));
            y(c.b.b.n.k.d.class, new i(eVar));
            y(c.b.b.n.l.h.c.class, new c.b.b.n.l.h.d(eVar));
            y(c.b.b.n.k.e.class, new f(eVar));
            y(k.class, new c.b.b.j.f.f(eVar));
            z(c.b.b.n.l.d.class, ".g3dj", new c.b.b.n.l.f.a(new c.b.b.q.p(), eVar));
            z(c.b.b.n.l.d.class, ".g3db", new c.b.b.n.l.f.a(new n0(), eVar));
            z(c.b.b.n.l.d.class, ".obj", new c.b.b.n.l.f.c(eVar));
            y(c.b.b.n.m.i.class, new c.b.b.j.f.k(eVar));
            y(Cubemap.class, new c.b.b.j.f.d(eVar));
        }
        this.f22352g = new c.b.b.q.o0.a(1, "AssetManager");
    }

    public boolean update(int i) {
        InterceptResult invokeI;
        boolean update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            long a2 = m0.a() + i;
            while (true) {
                update = update();
                if (update || m0.a() > a2) {
                    break;
                }
                c.b.b.q.o0.d.a();
            }
            return update;
        }
        return invokeI.booleanValue;
    }
}
