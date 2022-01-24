package c.b.b.p.a.a;

import androidx.core.view.InputDeviceCompat;
import c.b.b.n.k.a;
import c.b.b.n.k.h;
import c.b.b.q.o;
import c.b.b.q.w;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class j implements c.b.b.q.h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final Class[] f27371i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public w<Class, w<String, Object>> f27372e;

    /* renamed from: f  reason: collision with root package name */
    public c.b.b.n.k.h f27373f;

    /* renamed from: g  reason: collision with root package name */
    public float f27374g;

    /* renamed from: h  reason: collision with root package name */
    public final w<String, Class> f27375h;

    /* loaded from: classes9.dex */
    public class a extends c.b.b.q.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j n;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = jVar;
        }

        @Override // c.b.b.q.o
        public boolean g(Class cls, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, str)) == null) ? str.equals("parent") : invokeLL.booleanValue;
        }

        @Override // c.b.b.q.o
        public void i(Object obj, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, jsonValue) == null) {
                if (jsonValue.t("parent")) {
                    String str = (String) l("parent", String.class, jsonValue);
                    Class<?> cls = obj.getClass();
                    do {
                        try {
                            c(this.n.h(str, cls), obj);
                        } catch (GdxRuntimeException unused) {
                            cls = cls.getSuperclass();
                            if (cls == Object.class) {
                                SerializationException serializationException = new SerializationException("Unable to find parent resource with name: " + str);
                                serializationException.addTrace(jsonValue.f31165j.R());
                                throw serializationException;
                            }
                        }
                    } while (cls == Object.class);
                    SerializationException serializationException2 = new SerializationException("Unable to find parent resource with name: " + str);
                    serializationException2.addTrace(jsonValue.f31165j.R());
                    throw serializationException2;
                }
                super.i(obj, jsonValue);
            }
        }

        @Override // c.b.b.q.o
        public <T> T k(Class<T> cls, Class cls2, JsonValue jsonValue) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, jsonValue)) == null) {
                if (jsonValue != null && jsonValue.E() && !c.b.b.q.p0.b.f(CharSequence.class, cls)) {
                    return (T) this.n.h(jsonValue.k(), cls);
                }
                return (T) super.k(cls, cls2, jsonValue);
            }
            return (T) invokeLLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends o.b<j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f27376b;

        public b(j jVar, j jVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, jVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27376b = jVar;
            this.a = jVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.b.q.o.d
        /* renamed from: b */
        public j a(c.b.b.q.o oVar, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar, jsonValue, cls)) == null) {
                for (JsonValue jsonValue2 = jsonValue.f31165j; jsonValue2 != null; jsonValue2 = jsonValue2.l) {
                    try {
                        Class e2 = oVar.e(jsonValue2.H());
                        if (e2 == null) {
                            e2 = c.b.b.q.p0.b.a(jsonValue2.H());
                        }
                        c(oVar, e2, jsonValue2);
                    } catch (ReflectionException e3) {
                        throw new SerializationException(e3);
                    }
                }
                return this.a;
            }
            return (j) invokeLLL.objValue;
        }

        public final void c(c.b.b.q.o oVar, Class cls, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, oVar, cls, jsonValue) == null) {
                Class cls2 = cls == f.class ? c.b.b.p.a.b.b.class : cls;
                for (JsonValue jsonValue2 = jsonValue.f31165j; jsonValue2 != null; jsonValue2 = jsonValue2.l) {
                    Object j2 = oVar.j(cls, jsonValue2);
                    if (j2 != null) {
                        try {
                            this.f27376b.f(jsonValue2.f31164i, j2, cls2);
                            if (cls2 != c.b.b.p.a.b.b.class && c.b.b.q.p0.b.f(c.b.b.p.a.b.b.class, cls2)) {
                                this.f27376b.f(jsonValue2.f31164i, j2, c.b.b.p.a.b.b.class);
                            }
                        } catch (Exception e2) {
                            throw new SerializationException("Error reading " + c.b.b.q.p0.b.e(cls) + ": " + jsonValue2.f31164i, e2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends o.b<c.b.b.n.k.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.b.b.m.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f27377b;

        public c(j jVar, c.b.b.m.a aVar, j jVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, aVar, jVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f27377b = jVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.b.q.o.d
        /* renamed from: b */
        public c.b.b.n.k.a a(c.b.b.q.o oVar, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            c.b.b.n.k.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar, jsonValue, cls)) == null) {
                String str = (String) oVar.l("file", String.class, jsonValue);
                int intValue = ((Integer) oVar.n("scaledSize", Integer.TYPE, -1, jsonValue)).intValue();
                Boolean bool = (Boolean) oVar.n("flip", Boolean.class, Boolean.FALSE, jsonValue);
                Boolean bool2 = (Boolean) oVar.n("markupEnabled", Boolean.class, Boolean.FALSE, jsonValue);
                c.b.b.m.a a = this.a.i().a(str);
                if (!a.c()) {
                    a = c.b.b.f.f26966d.a(str);
                }
                if (a.c()) {
                    String h2 = a.h();
                    try {
                        c.b.b.q.a<c.b.b.n.k.i> m = this.f27377b.m(h2);
                        if (m != null) {
                            aVar = new c.b.b.n.k.a(new a.C1615a(a, bool.booleanValue()), m, true);
                        } else {
                            c.b.b.n.k.i iVar = (c.b.b.n.k.i) this.f27377b.r(h2, c.b.b.n.k.i.class);
                            if (iVar != null) {
                                aVar = new c.b.b.n.k.a(a, iVar, bool.booleanValue());
                            } else {
                                c.b.b.m.a i2 = a.i();
                                c.b.b.m.a a2 = i2.a(h2 + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX);
                                if (a2.c()) {
                                    aVar = new c.b.b.n.k.a(a, a2, bool.booleanValue());
                                } else {
                                    aVar = new c.b.b.n.k.a(a, bool.booleanValue());
                                }
                            }
                        }
                        aVar.f().p = bool2.booleanValue();
                        if (intValue != -1) {
                            aVar.f().h(intValue / aVar.a());
                        }
                        return aVar;
                    } catch (RuntimeException e2) {
                        throw new SerializationException("Error loading bitmap font: " + a, e2);
                    }
                }
                throw new SerializationException("Font file not found: " + a);
            }
            return (c.b.b.n.k.a) invokeLLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d extends o.b<c.b.b.n.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public d(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.b.q.o.d
        /* renamed from: b */
        public c.b.b.n.a a(c.b.b.q.o oVar, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar, jsonValue, cls)) == null) {
                if (jsonValue.E()) {
                    return (c.b.b.n.a) this.a.h(jsonValue.k(), c.b.b.n.a.class);
                }
                String str = (String) oVar.n("hex", String.class, null, jsonValue);
                if (str != null) {
                    return c.b.b.n.a.h(str);
                }
                return new c.b.b.n.a(((Float) oVar.n("r", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) oVar.n("g", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) oVar.n("b", Float.TYPE, Float.valueOf(0.0f), jsonValue)).floatValue(), ((Float) oVar.n("a", Float.TYPE, Float.valueOf(1.0f), jsonValue)).floatValue());
            }
            return (c.b.b.n.a) invokeLLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e extends o.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public e(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // c.b.b.q.o.d
        public Object a(c.b.b.q.o oVar, JsonValue jsonValue, Class cls) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, oVar, jsonValue, cls)) == null) {
                String str = (String) oVar.l("name", String.class, jsonValue);
                c.b.b.n.a aVar = (c.b.b.n.a) oVar.l("color", c.b.b.n.a.class, jsonValue);
                if (aVar != null) {
                    c.b.b.p.a.b.b q = this.a.q(str, aVar);
                    if (q instanceof c.b.b.p.a.b.a) {
                        ((c.b.b.p.a.b.a) q).n(jsonValue.f31164i + " (" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    return q;
                }
                throw new SerializationException("TintedDrawable missing color: " + jsonValue);
            }
            return invokeLLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1514913474, "Lc/b/b/p/a/a/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1514913474, "Lc/b/b/p/a/a/j;");
                return;
            }
        }
        f27371i = new Class[]{c.b.b.n.k.a.class, c.b.b.n.a.class, f.class, c.b.b.p.a.b.c.class, c.b.b.p.a.b.d.class, c.b.b.p.a.b.e.class, c.b.b.p.a.b.f.class, c.b.b.p.a.a.a.class, c.b.b.p.a.a.b.class, c.b.b.p.a.a.c.class, c.b.b.p.a.a.d.class, c.b.b.p.a.a.e.class, c.b.b.p.a.a.f.class, g.class, h.class, i.class, k.class, l.class, m.class, n.class, o.class, p.class, q.class, r.class};
    }

    public j() {
        Class[] clsArr;
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
        this.f27372e = new w<>();
        this.f27374g = 1.0f;
        this.f27375h = new w<>(f27371i.length);
        for (Class cls : f27371i) {
            this.f27375h.i(cls.getSimpleName(), cls);
        }
    }

    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            f(str, obj, obj.getClass());
        }
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.b.b.n.k.h hVar = this.f27373f;
            if (hVar != null) {
                hVar.dispose();
            }
            w.e<w<String, Object>> n = this.f27372e.n();
            n.d();
            while (n.hasNext()) {
                w.e<Object> n2 = n.next().n();
                n2.d();
                while (n2.hasNext()) {
                    Object next = n2.next();
                    if (next instanceof c.b.b.q.h) {
                        ((c.b.b.q.h) next).dispose();
                    }
                }
            }
        }
    }

    public void f(String str, Object obj, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, cls) == null) {
            if (str == null) {
                throw new IllegalArgumentException("name cannot be null.");
            }
            if (obj != null) {
                w<String, Object> c2 = this.f27372e.c(cls);
                if (c2 == null) {
                    c2 = new w<>((cls == c.b.b.n.k.i.class || cls == c.b.b.p.a.b.b.class || cls == c.b.b.n.k.g.class) ? 256 : 64);
                    this.f27372e.i(cls, c2);
                }
                c2.i(str, obj);
                return;
            }
            throw new IllegalArgumentException("resource cannot be null.");
        }
    }

    public void g(c.b.b.n.k.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
            c.b.b.q.a<h.a> g2 = hVar.g();
            int i2 = g2.f27389f;
            for (int i3 = 0; i3 < i2; i3++) {
                h.a aVar = g2.get(i3);
                String str = aVar.f27180i;
                if (aVar.f27179h != -1) {
                    str = str + "_" + aVar.f27179h;
                }
                f(str, aVar, c.b.b.n.k.i.class);
            }
        }
    }

    public <T> T h(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    if (cls == c.b.b.p.a.b.b.class) {
                        return (T) i(str);
                    }
                    if (cls == c.b.b.n.k.i.class) {
                        return (T) l(str);
                    }
                    if (cls == c.b.b.n.k.c.class) {
                        return (T) k(str);
                    }
                    if (cls == c.b.b.n.k.g.class) {
                        return (T) n(str);
                    }
                    w<String, Object> c2 = this.f27372e.c(cls);
                    if (c2 != null) {
                        T t = (T) c2.c(str);
                        if (t != null) {
                            return t;
                        }
                        throw new GdxRuntimeException("No " + cls.getName() + " registered with name: " + str);
                    }
                    throw new GdxRuntimeException("No " + cls.getName() + " registered with name: " + str);
                }
                throw new IllegalArgumentException("type cannot be null.");
            }
            throw new IllegalArgumentException("name cannot be null.");
        }
        return (T) invokeLL.objValue;
    }

    public c.b.b.p.a.b.b i(String str) {
        InterceptResult invokeL;
        c.b.b.p.a.b.b dVar;
        c.b.b.p.a.b.b dVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            c.b.b.p.a.b.b bVar = (c.b.b.p.a.b.b) r(str, c.b.b.p.a.b.b.class);
            if (bVar != null) {
                return bVar;
            }
            try {
                c.b.b.n.k.i l = l(str);
                if (l instanceof h.a) {
                    h.a aVar = (h.a) l;
                    if (aVar.k("split") != null) {
                        dVar2 = new c.b.b.p.a.b.c(k(str));
                    } else if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        dVar2 = new c.b.b.p.a.b.d(n(str));
                    }
                    bVar = dVar2;
                }
                if (bVar == null) {
                    c.b.b.p.a.b.b eVar = new c.b.b.p.a.b.e(l);
                    try {
                        if (this.f27374g != 1.0f) {
                            s(eVar);
                        }
                    } catch (GdxRuntimeException unused) {
                    }
                    bVar = eVar;
                }
            } catch (GdxRuntimeException unused2) {
            }
            if (bVar == null) {
                c.b.b.n.k.c cVar = (c.b.b.n.k.c) r(str, c.b.b.n.k.c.class);
                if (cVar != null) {
                    dVar = new c.b.b.p.a.b.c(cVar);
                } else {
                    c.b.b.n.k.g gVar = (c.b.b.n.k.g) r(str, c.b.b.n.k.g.class);
                    if (gVar != null) {
                        dVar = new c.b.b.p.a.b.d(gVar);
                    } else {
                        throw new GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + str);
                    }
                }
                bVar = dVar;
            }
            if (bVar instanceof c.b.b.p.a.b.a) {
                ((c.b.b.p.a.b.a) bVar).n(str);
            }
            f(str, bVar, c.b.b.p.a.b.b.class);
            return bVar;
        }
        return (c.b.b.p.a.b.b) invokeL.objValue;
    }

    public c.b.b.q.o j(c.b.b.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            a aVar2 = new a(this);
            aVar2.p(null);
            aVar2.q(false);
            aVar2.o(j.class, new b(this, this));
            aVar2.o(c.b.b.n.k.a.class, new c(this, aVar, this));
            aVar2.o(c.b.b.n.a.class, new d(this));
            aVar2.o(f.class, new e(this));
            w.a<String, Class> it = this.f27375h.iterator();
            while (it.hasNext()) {
                w.b next = it.next();
                aVar2.a((String) next.a, (Class) next.f27552b);
            }
            return aVar2;
        }
        return (c.b.b.q.o) invokeL.objValue;
    }

    public c.b.b.n.k.c k(String str) {
        InterceptResult invokeL;
        int[] k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            c.b.b.n.k.c cVar = (c.b.b.n.k.c) r(str, c.b.b.n.k.c.class);
            if (cVar != null) {
                return cVar;
            }
            try {
                c.b.b.n.k.i l = l(str);
                if ((l instanceof h.a) && (k = ((h.a) l).k("split")) != null) {
                    cVar = new c.b.b.n.k.c(l, k[0], k[1], k[2], k[3]);
                    int[] k2 = ((h.a) l).k("pad");
                    if (k2 != null) {
                        cVar.n(k2[0], k2[1], k2[2], k2[3]);
                    }
                }
                if (cVar == null) {
                    cVar = new c.b.b.n.k.c(l);
                }
                if (this.f27374g != 1.0f) {
                    cVar.m(this.f27374g, this.f27374g);
                }
                f(str, cVar, c.b.b.n.k.c.class);
                return cVar;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (c.b.b.n.k.c) invokeL.objValue;
    }

    public c.b.b.n.k.i l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            c.b.b.n.k.i iVar = (c.b.b.n.k.i) r(str, c.b.b.n.k.i.class);
            if (iVar != null) {
                return iVar;
            }
            Texture texture = (Texture) r(str, Texture.class);
            if (texture != null) {
                c.b.b.n.k.i iVar2 = new c.b.b.n.k.i(texture);
                f(str, iVar2, c.b.b.n.k.i.class);
                return iVar2;
            }
            throw new GdxRuntimeException("No TextureRegion or Texture registered with name: " + str);
        }
        return (c.b.b.n.k.i) invokeL.objValue;
    }

    public c.b.b.q.a<c.b.b.n.k.i> m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            c.b.b.n.k.i iVar = (c.b.b.n.k.i) r(str + "_0", c.b.b.n.k.i.class);
            if (iVar != null) {
                c.b.b.q.a<c.b.b.n.k.i> aVar = new c.b.b.q.a<>();
                int i2 = 1;
                while (iVar != null) {
                    aVar.a(iVar);
                    iVar = (c.b.b.n.k.i) r(str + "_" + i2, c.b.b.n.k.i.class);
                    i2++;
                }
                return aVar;
            }
            return null;
        }
        return (c.b.b.q.a) invokeL.objValue;
    }

    public c.b.b.n.k.g n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            c.b.b.n.k.g gVar = (c.b.b.n.k.g) r(str, c.b.b.n.k.g.class);
            if (gVar != null) {
                return gVar;
            }
            try {
                c.b.b.n.k.i l = l(str);
                if (l instanceof h.a) {
                    h.a aVar = (h.a) l;
                    if (aVar.p || aVar.l != aVar.n || aVar.m != aVar.o) {
                        gVar = new h.b(aVar);
                    }
                }
                if (gVar == null) {
                    gVar = new c.b.b.n.k.g(l);
                }
                if (this.f27374g != 1.0f) {
                    gVar.z(gVar.n() * this.f27374g, gVar.k() * this.f27374g);
                }
                f(str, gVar, c.b.b.n.k.g.class);
                return gVar;
            } catch (GdxRuntimeException unused) {
                throw new GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
            }
        }
        return (c.b.b.n.k.g) invokeL.objValue;
    }

    public void o(c.b.b.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            try {
                j(aVar).d(j.class, aVar);
            } catch (SerializationException e2) {
                throw new SerializationException("Error reading file: " + aVar, e2);
            }
        }
    }

    public c.b.b.p.a.b.b p(c.b.b.p.a.b.b bVar, c.b.b.n.a aVar) {
        InterceptResult invokeLL;
        c.b.b.p.a.b.b p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, bVar, aVar)) == null) {
            if (bVar instanceof c.b.b.p.a.b.e) {
                p = ((c.b.b.p.a.b.e) bVar).p(aVar);
            } else if (bVar instanceof c.b.b.p.a.b.c) {
                p = ((c.b.b.p.a.b.c) bVar).q(aVar);
            } else if (bVar instanceof c.b.b.p.a.b.d) {
                p = ((c.b.b.p.a.b.d) bVar).p(aVar);
            } else {
                throw new GdxRuntimeException("Unable to copy, unknown drawable type: " + bVar.getClass());
            }
            if (p instanceof c.b.b.p.a.b.a) {
                c.b.b.p.a.b.a aVar2 = (c.b.b.p.a.b.a) p;
                if (bVar instanceof c.b.b.p.a.b.a) {
                    aVar2.n(((c.b.b.p.a.b.a) bVar).m() + " (" + aVar + SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    aVar2.n(" (" + aVar + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            return p;
        }
        return (c.b.b.p.a.b.b) invokeLL.objValue;
    }

    public c.b.b.p.a.b.b q(String str, c.b.b.n.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, aVar)) == null) ? p(i(str), aVar) : (c.b.b.p.a.b.b) invokeLL.objValue;
    }

    public <T> T r(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, cls)) == null) {
            if (str != null) {
                if (cls != null) {
                    w<String, Object> c2 = this.f27372e.c(cls);
                    if (c2 == null) {
                        return null;
                    }
                    return (T) c2.c(str);
                }
                throw new IllegalArgumentException("type cannot be null.");
            }
            throw new IllegalArgumentException("name cannot be null.");
        }
        return (T) invokeLL.objValue;
    }

    public void s(c.b.b.p.a.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            bVar.b(bVar.l() * this.f27374g);
            bVar.c(bVar.g() * this.f27374g);
            bVar.d(bVar.e() * this.f27374g);
            bVar.f(bVar.i() * this.f27374g);
            bVar.j(bVar.a() * this.f27374g);
            bVar.h(bVar.k() * this.f27374g);
        }
    }

    public j(c.b.b.n.k.h hVar) {
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f27372e = new w<>();
        this.f27374g = 1.0f;
        this.f27375h = new w<>(f27371i.length);
        for (Class cls : f27371i) {
            this.f27375h.i(cls.getSimpleName(), cls);
        }
        this.f27373f = hVar;
        g(hVar);
    }
}
