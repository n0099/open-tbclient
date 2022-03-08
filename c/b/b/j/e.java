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

    /* renamed from: e  reason: collision with root package name */
    public final w<Class, w<String, a>> f27092e;

    /* renamed from: f  reason: collision with root package name */
    public final w<String, Class> f27093f;

    /* renamed from: g  reason: collision with root package name */
    public final w<String, c.b.b.q.a<String>> f27094g;

    /* renamed from: h  reason: collision with root package name */
    public final x<String> f27095h;

    /* renamed from: i  reason: collision with root package name */
    public final w<Class, w<String, c.b.b.j.f.a>> f27096i;

    /* renamed from: j  reason: collision with root package name */
    public final c.b.b.q.a<c.b.b.j.a> f27097j;
    public final c.b.b.q.o0.a k;
    public final c.b.b.q.a<d> l;
    public b m;
    public int n;
    public int o;
    public int p;
    public r q;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;

        /* renamed from: b  reason: collision with root package name */
        public int f27098b;

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
                    return;
                }
            }
            this.f27098b = 1;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e() {
        this(new c.b.b.j.f.q.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((c.b.b.j.f.e) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public synchronized void A(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            synchronized (this) {
                Class c2 = this.f27093f.c(str);
                if (c2 != null) {
                    this.f27092e.c(c2).c(str).f27098b = i2;
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
                if (this.l.f27499f > 0) {
                    d first = this.l.first();
                    if (first.f27083b.a.equals(replace)) {
                        this.q.e("Unload (from tasks): " + replace);
                        first.l = true;
                        first.e();
                        return;
                    }
                }
                Class c2 = this.f27093f.c(replace);
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f27097j.f27499f) {
                        i2 = -1;
                        break;
                    } else if (this.f27097j.get(i2).a.equals(replace)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 != -1) {
                    this.o--;
                    c.b.b.j.a h2 = this.f27097j.h(i2);
                    this.q.e("Unload (from queue): " + replace);
                    if (c2 != null && h2.f27081c != null && h2.f27081c.a != null) {
                        h2.f27081c.a.a(this, h2.a, h2.f27080b);
                    }
                } else if (c2 != null) {
                    a c3 = this.f27092e.c(c2).c(replace);
                    int i3 = c3.f27098b - 1;
                    c3.f27098b = i3;
                    if (i3 <= 0) {
                        this.q.e("Unload (dispose): " + replace);
                        if (c3.a instanceof h) {
                            ((h) c3.a).dispose();
                        }
                        this.f27093f.k(replace);
                        this.f27092e.c(c2).k(replace);
                    } else {
                        this.q.e("Unload (decrement): " + replace);
                    }
                    c.b.b.q.a<String> c4 = this.f27094g.c(replace);
                    if (c4 != null) {
                        a.b<String> it = c4.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (v(next)) {
                                C(next);
                            }
                        }
                    }
                    if (c3.f27098b <= 0) {
                        this.f27094g.k(replace);
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
        d peek = this.l.peek();
        try {
            if (!peek.l) {
                if (!peek.update()) {
                    z = false;
                    if (z) {
                        return false;
                    }
                    if (this.l.f27499f == 1) {
                        this.n++;
                        this.p = 0;
                    }
                    this.l.pop();
                    if (peek.l) {
                        return true;
                    }
                    c.b.b.j.a aVar2 = peek.f27083b;
                    a(aVar2.a, aVar2.f27080b, peek.k);
                    c.b.b.j.a aVar3 = peek.f27083b;
                    c cVar = aVar3.f27081c;
                    if (cVar != null && (aVar = cVar.a) != null) {
                        aVar.a(this, aVar3.a, aVar3.f27080b);
                    }
                    long b2 = m0.b();
                    this.q.a("Loaded: " + (((float) (b2 - peek.f27086e)) / 1000000.0f) + "ms " + peek.f27083b);
                    return true;
                }
            }
            z = true;
            if (z) {
            }
        } catch (RuntimeException e2) {
            peek.l = true;
            B(peek.f27083b, e2);
            throw null;
        }
    }

    public <T> void a(String str, Class<T> cls, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, cls, t) == null) {
            this.f27093f.i(str, cls);
            w<String, a> c2 = this.f27092e.c(cls);
            if (c2 == null) {
                c2 = new w<>();
                this.f27092e.i(cls, c2);
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
                this.q.a("Disposing.");
                g();
                this.k.dispose();
            }
        }
    }

    public final void f(c.b.b.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            c.b.b.j.f.a o = o(aVar.f27080b, aVar.a);
            if (o != null) {
                this.l.a(new d(this, aVar, o, this.k));
                this.p++;
                return;
            }
            throw new GdxRuntimeException("No loader for type: " + c.b.b.q.p0.b.e(aVar.f27080b));
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.f27097j.clear();
                while (!update()) {
                }
                v vVar = new v();
                while (this.f27093f.f27655e > 0) {
                    vVar.clear();
                    c.b.b.q.a<String> e2 = this.f27093f.f().e();
                    a.b<String> it = e2.iterator();
                    while (it.hasNext()) {
                        c.b.b.q.a<String> c2 = this.f27094g.c(it.next());
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
                this.f27092e.clear();
                this.f27093f.clear();
                this.f27094g.clear();
                this.n = 0;
                this.o = 0;
                this.p = 0;
                this.f27097j.clear();
                this.l.clear();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.q.a("Waiting for loading to complete...");
            while (!update()) {
                c.b.b.q.o0.d.a();
            }
            this.q.a("Loading complete.");
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
                w<String, a> c3 = this.f27092e.c(cls);
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
                Class c4 = this.f27093f.c(str);
                if (c4 == null || (c2 = this.f27092e.c(c4)) == null || (c3 = c2.c(str)) == null) {
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
                w.c<Class> f2 = this.f27092e.f();
                f2.d();
                while (f2.hasNext()) {
                    w.a<String, a> it = this.f27092e.c(f2.next()).iterator();
                    while (it.hasNext()) {
                        w.b next = it.next();
                        Object obj = ((a) next.f27662b).a;
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
                c2 = this.f27094g.c(str);
            }
            return c2;
        }
        return (c.b.b.q.a) invokeL.objValue;
    }

    public <T> c.b.b.j.f.a o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, cls, str)) == null) {
            w<String, c.b.b.j.f.a> c2 = this.f27096i.c(cls);
            c.b.b.j.f.a aVar = null;
            if (c2 != null && c2.f27655e >= 1) {
                if (str == null) {
                    return c2.c("");
                }
                int i2 = -1;
                w.a<String, c.b.b.j.f.a> b2 = c2.b();
                b2.d();
                while (b2.hasNext()) {
                    w.b next = b2.next();
                    if (((String) next.a).length() > i2 && str.endsWith((String) next.a)) {
                        aVar = (c.b.b.j.f.a) next.f27662b;
                        i2 = ((String) next.a).length();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.q : (r) invokeV.objValue;
    }

    public synchronized int q(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            synchronized (this) {
                Class c2 = this.f27093f.c(str);
                if (c2 != null) {
                    i2 = this.f27092e.c(c2).c(str).f27098b;
                } else {
                    throw new GdxRuntimeException("Asset not loaded: " + str);
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public final void r(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, th) == null) {
            this.q.c("Error loading asset.", th);
            if (!this.l.isEmpty()) {
                d pop = this.l.pop();
                c.b.b.j.a aVar = pop.f27083b;
                if (pop.f27088g && pop.f27089h != null) {
                    a.b<c.b.b.j.a> it = pop.f27089h.iterator();
                    while (it.hasNext()) {
                        C(it.next().a);
                    }
                }
                this.l.clear();
                b bVar = this.m;
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
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || (c2 = this.f27094g.c(str)) == null) {
            return;
        }
        a.b<String> it = c2.iterator();
        while (it.hasNext()) {
            String next = it.next();
            this.f27092e.c(this.f27093f.c(next)).c(next).f27098b++;
            s(next);
        }
    }

    public synchronized void t(String str, c.b.b.q.a<c.b.b.j.a> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, aVar) == null) {
            synchronized (this) {
                x<String> xVar = this.f27095h;
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
                c.b.b.q.a<String> c2 = this.f27094g.c(str);
                if (c2 == null) {
                    c2 = new c.b.b.q.a<>();
                    this.f27094g.i(str, c2);
                }
                c2.a(aVar.a);
                if (v(aVar.a)) {
                    r rVar = this.q;
                    rVar.a("Dependency already loaded: " + aVar);
                    a c3 = this.f27092e.c(this.f27093f.c(aVar.a)).c(aVar.a);
                    c3.f27098b = c3.f27098b + 1;
                    s(aVar.a);
                } else {
                    r rVar2 = this.q;
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
                    if (this.l.f27499f == 0) {
                        while (this.f27097j.f27499f != 0 && this.l.f27499f == 0) {
                            x();
                        }
                        if (this.l.f27499f == 0) {
                            return true;
                        }
                    }
                    if (D() && this.f27097j.f27499f == 0) {
                        if (this.l.f27499f == 0) {
                            z = true;
                        }
                    }
                    return z;
                } catch (Throwable th) {
                    r(th);
                    return this.f27097j.f27499f == 0;
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
                return this.f27093f.a(str);
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized <T> void w(String str, Class<T> cls, c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, cls, cVar) == null) {
            synchronized (this) {
                if (o(cls, str) != null) {
                    if (this.f27097j.f27499f == 0) {
                        this.n = 0;
                        this.o = 0;
                        this.p = 0;
                    }
                    for (int i2 = 0; i2 < this.f27097j.f27499f; i2++) {
                        c.b.b.j.a aVar = this.f27097j.get(i2);
                        if (aVar.a.equals(str) && !aVar.f27080b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in preload queue, but has different type (expected: " + c.b.b.q.p0.b.e(cls) + ", found: " + c.b.b.q.p0.b.e(aVar.f27080b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    for (int i3 = 0; i3 < this.l.f27499f; i3++) {
                        c.b.b.j.a aVar2 = this.l.get(i3).f27083b;
                        if (aVar2.a.equals(str) && !aVar2.f27080b.equals(cls)) {
                            throw new GdxRuntimeException("Asset with name '" + str + "' already in task list, but has different type (expected: " + c.b.b.q.p0.b.e(cls) + ", found: " + c.b.b.q.p0.b.e(aVar2.f27080b) + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    }
                    Class c2 = this.f27093f.c(str);
                    if (c2 != null && !c2.equals(cls)) {
                        throw new GdxRuntimeException("Asset with name '" + str + "' already loaded, but has different type (expected: " + c.b.b.q.p0.b.e(cls) + ", found: " + c.b.b.q.p0.b.e(c2) + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    this.o++;
                    c.b.b.j.a aVar3 = new c.b.b.j.a(str, cls, cVar);
                    this.f27097j.a(aVar3);
                    this.q.a("Queued: " + aVar3);
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
            c.b.b.j.a h2 = this.f27097j.h(0);
            if (v(h2.a)) {
                this.q.a("Already loaded: " + h2);
                a c2 = this.f27092e.c(this.f27093f.c(h2.a)).c(h2.a);
                c2.f27098b = c2.f27098b + 1;
                s(h2.a);
                c cVar = h2.f27081c;
                if (cVar != null && (aVar = cVar.a) != null) {
                    aVar.a(this, h2.a, h2.f27080b);
                }
                this.n++;
                return;
            }
            this.q.e("Loading: " + h2);
            f(h2);
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
                    r rVar = this.q;
                    rVar.a("Loader set: " + c.b.b.q.p0.b.e(cls) + LoadErrorCode.TOKEN_NEXT + c.b.b.q.p0.b.e(aVar.getClass()));
                    w<String, c.b.b.j.f.a> c2 = this.f27096i.c(cls);
                    if (c2 == null) {
                        w<Class, w<String, c.b.b.j.f.a>> wVar = this.f27096i;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f27092e = new w<>();
        this.f27093f = new w<>();
        this.f27094g = new w<>();
        this.f27095h = new x<>();
        this.f27096i = new w<>();
        this.f27097j = new c.b.b.q.a<>();
        this.l = new c.b.b.q.a<>();
        this.q = new r("AssetManager", 0);
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
        this.k = new c.b.b.q.o0.a(1, "AssetManager");
    }

    public boolean update(int i2) {
        InterceptResult invokeI;
        boolean update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            long a2 = m0.a() + i2;
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
