package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import c.b.b.q.w;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter$OutputType;
import com.badlogic.gdx.utils.SerializationException;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27688b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27689c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27690d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f27691e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27692f;

    /* renamed from: g  reason: collision with root package name */
    public d f27693g;

    /* renamed from: h  reason: collision with root package name */
    public final w<Class, y<String, a>> f27694h;

    /* renamed from: i  reason: collision with root package name */
    public final w<String, Class> f27695i;

    /* renamed from: j  reason: collision with root package name */
    public final w<Class, String> f27696j;
    public final w<Class, d> k;
    public final Object[] l;
    public final Object[] m;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.b.b.q.p0.d a;

        /* renamed from: b  reason: collision with root package name */
        public Class f27697b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f27698c;

        public a(c.b.b.q.p0.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.f27697b = dVar.c((c.b.b.q.p0.b.f(w.class, dVar.getType()) || c.b.b.q.p0.b.f(Map.class, dVar.getType())) ? 1 : 0);
            this.f27698c = dVar.f(Deprecated.class);
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class b<T> implements d<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

    /* loaded from: classes9.dex */
    public interface c {
        void a(o oVar, JsonValue jsonValue);
    }

    /* loaded from: classes9.dex */
    public interface d<T> {
        T a(o oVar, JsonValue jsonValue, Class cls);
    }

    public o() {
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
        this.a = DealIntentService.KEY_CLASS;
        this.f27691e = true;
        this.f27694h = new w<>();
        this.f27695i = new w<>();
        this.f27696j = new w<>();
        this.k = new w<>();
        new w();
        this.l = new Object[]{null};
        this.m = new Object[]{null};
        JsonWriter$OutputType jsonWriter$OutputType = JsonWriter$OutputType.minimal;
    }

    public void a(String str, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cls) == null) {
            this.f27695i.i(str, cls);
            this.f27696j.i(cls, str);
        }
    }

    public final String b(Enum r5) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r5)) == null) ? this.f27691e ? r5.name() : r5.toString() : (String) invokeL.objValue;
    }

    public void c(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, obj2) == null) {
            y<String, a> f2 = f(obj2.getClass());
            w.a<String, a> it = f(obj.getClass()).iterator();
            while (it.hasNext()) {
                w.b next = it.next();
                a c2 = f2.c(next.a);
                c.b.b.q.p0.d dVar = ((a) next.f27758b).a;
                if (c2 != null) {
                    try {
                        c2.a.j(obj2, dVar.a(obj));
                    } catch (ReflectionException e2) {
                        throw new SerializationException("Error copying field: " + dVar.d(), e2);
                    }
                } else {
                    throw new SerializationException("To object is missing field: " + ((String) next.a));
                }
            }
        }
    }

    public <T> T d(Class<T> cls, c.b.b.m.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, aVar)) == null) {
            try {
                return (T) k(cls, null, new p().a(aVar));
            } catch (Exception e2) {
                throw new SerializationException("Error reading file: " + aVar, e2);
            }
        }
        return (T) invokeLL.objValue;
    }

    public Class e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f27695i.c(str) : (Class) invokeL.objValue;
    }

    public final y<String, a> f(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            y<String, a> c2 = this.f27694h.c(cls);
            if (c2 != null) {
                return c2;
            }
            c.b.b.q.a aVar = new c.b.b.q.a();
            for (Class cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                aVar.a(cls2);
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = aVar.f27595f - 1; i2 >= 0; i2--) {
                Collections.addAll(arrayList, c.b.b.q.p0.b.d((Class) aVar.get(i2)));
            }
            y<String, a> yVar = new y<>(arrayList.size());
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                c.b.b.q.p0.d dVar = (c.b.b.q.p0.d) arrayList.get(i3);
                if (!dVar.i() && !dVar.g() && !dVar.h()) {
                    if (!dVar.e()) {
                        try {
                            dVar.k(true);
                        } catch (AccessControlException unused) {
                        }
                    }
                    yVar.i(dVar.d(), new a(dVar));
                }
            }
            if (this.f27692f) {
                yVar.s.l();
            }
            this.f27694h.i(cls, yVar);
            return yVar;
        }
        return (y) invokeL.objValue;
    }

    public boolean g(Class cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, cls, str)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public Object h(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            try {
                return c.b.b.q.p0.b.i(cls);
            } catch (Exception e2) {
                e = e2;
                try {
                    c.b.b.q.p0.c c2 = c.b.b.q.p0.b.c(cls, new Class[0]);
                    c2.c(true);
                    return c2.b(new Object[0]);
                } catch (ReflectionException unused) {
                    if (c.b.b.q.p0.b.f(Enum.class, cls)) {
                        if (cls.getEnumConstants() == null) {
                            cls = cls.getSuperclass();
                        }
                        return cls.getEnumConstants()[0];
                    } else if (!cls.isArray()) {
                        if (c.b.b.q.p0.b.g(cls) && !c.b.b.q.p0.b.h(cls)) {
                            throw new SerializationException("Class cannot be created (non-static member class): " + cls.getName(), e);
                        }
                        throw new SerializationException("Class cannot be created (missing no-arg constructor): " + cls.getName(), e);
                    } else {
                        throw new SerializationException("Encountered JSON object when expected array of type: " + cls.getName(), e);
                    }
                } catch (SecurityException unused2) {
                    throw new SerializationException("Error constructing instance of class: " + cls.getName(), e);
                } catch (Exception e3) {
                    e = e3;
                    throw new SerializationException("Error constructing instance of class: " + cls.getName(), e);
                }
            }
        }
        return invokeL.objValue;
    }

    public void i(Object obj, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, jsonValue) == null) {
            Class<?> cls = obj.getClass();
            y<String, a> f2 = f(cls);
            for (JsonValue jsonValue2 = jsonValue.f31371j; jsonValue2 != null; jsonValue2 = jsonValue2.l) {
                a c2 = f2.c(jsonValue2.H().replace(" ", "_"));
                if (c2 == null) {
                    if (!jsonValue2.f31370i.equals(this.a) && !this.f27688b && !g(cls, jsonValue2.f31370i)) {
                        SerializationException serializationException = new SerializationException("Field not found: " + jsonValue2.f31370i + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
                        serializationException.addTrace(jsonValue2.R());
                        throw serializationException;
                    }
                } else if (!this.f27689c || this.f27690d || !c2.f27698c) {
                    c.b.b.q.p0.d dVar = c2.a;
                    try {
                        dVar.j(obj, k(dVar.getType(), c2.f27697b, jsonValue2));
                    } catch (SerializationException e2) {
                        e2.addTrace(dVar.d() + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
                        throw e2;
                    } catch (ReflectionException e3) {
                        throw new SerializationException("Error accessing field: " + dVar.d() + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX, e3);
                    } catch (RuntimeException e4) {
                        SerializationException serializationException2 = new SerializationException(e4);
                        serializationException2.addTrace(jsonValue2.R());
                        serializationException2.addTrace(dVar.d() + " (" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
                        throw serializationException2;
                    }
                }
            }
        }
    }

    public <T> T j(Class<T> cls, JsonValue jsonValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, cls, jsonValue)) == null) ? (T) k(cls, null, jsonValue) : (T) invokeLL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r13v3. Raw type applied. Possible types: java.lang.Class<c.b.b.q.a> */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0208, code lost:
        if (r13 == java.lang.Object.class) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0354, code lost:
        if (r13 == r0) goto L138;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0431 A[RETURN] */
    /* JADX WARN: Type inference failed for: r0v68, types: [c.b.b.q.o$c] */
    /* JADX WARN: Type inference failed for: r0v71, types: [c.b.b.q.o$d] */
    /* JADX WARN: Type inference failed for: r12v14, types: [c.b.b.q.o$d] */
    /* JADX WARN: Type inference failed for: r12v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r21v0, types: [c.b.b.q.o, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.badlogic.gdx.utils.JsonValue, T] */
    /* JADX WARN: Type inference failed for: r2v45, types: [com.badlogic.gdx.utils.JsonValue, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v24, types: [T, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v25, types: [T, c.b.b.q.b] */
    /* JADX WARN: Type inference failed for: r3v26, types: [c.b.b.q.n, T] */
    /* JADX WARN: Type inference failed for: r3v27, types: [T, c.b.b.q.s] */
    /* JADX WARN: Type inference failed for: r3v28, types: [T, c.b.b.q.m] */
    /* JADX WARN: Type inference failed for: r3v29, types: [c.b.b.q.x, T] */
    /* JADX WARN: Type inference failed for: r3v30, types: [T, c.b.b.q.u] */
    /* JADX WARN: Type inference failed for: r3v31, types: [T, c.b.b.q.v] */
    /* JADX WARN: Type inference failed for: r3v32, types: [T, c.b.b.q.w] */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v41, types: [c.b.b.q.c0] */
    /* JADX WARN: Type inference failed for: r3v45, types: [c.b.b.q.a] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T k(Class<T> cls, Class cls2, JsonValue jsonValue) {
        InterceptResult invokeLLL;
        Class cls3;
        JsonValue jsonValue2;
        Class cls4;
        JsonValue jsonValue3;
        Class cls5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, cls, cls2, jsonValue)) == null) {
            Class cls6 = cls2;
            ?? r2 = (T) jsonValue;
            if (r2 == 0) {
                return null;
            }
            if (jsonValue.D()) {
                String str = this.a;
                String s = str == null ? null : r2.s(str, null);
                if (s != null) {
                    Class e2 = e(s);
                    if (e2 == null) {
                        try {
                            cls5 = c.b.b.q.p0.b.a(s);
                        } catch (ReflectionException e3) {
                            throw new SerializationException(e3);
                        }
                    } else {
                        cls5 = e2;
                    }
                } else {
                    cls5 = cls;
                }
                if (cls5 == null) {
                    ?? r0 = this.f27693g;
                    return r0 != 0 ? (T) r0.a(this, r2, cls5) : r2;
                } else if (this.a != null && c.b.b.q.p0.b.f(Collection.class, cls5)) {
                    ?? r22 = (T) r2.m("items");
                    jsonValue2 = r22;
                    cls3 = cls5;
                    if (r22 == 0) {
                        throw new SerializationException("Unable to convert object to collection: " + r22 + " (" + cls5.getName() + SmallTailInfo.EMOTION_SUFFIX);
                    }
                } else {
                    d c2 = this.k.c(cls5);
                    if (c2 == 0) {
                        if (cls5 != String.class && cls5 != Integer.class && cls5 != Boolean.class && cls5 != Float.class && cls5 != Long.class && cls5 != Double.class && cls5 != Short.class && cls5 != Byte.class && cls5 != Character.class && !c.b.b.q.p0.b.f(Enum.class, cls5)) {
                            T t = (T) h(cls5);
                            if (t instanceof c) {
                                ((c) t).a(this, r2);
                                return t;
                            } else if (t instanceof w) {
                                ?? r3 = (T) ((w) t);
                                for (JsonValue jsonValue4 = r2.f31371j; jsonValue4 != null; jsonValue4 = jsonValue4.l) {
                                    r3.i(jsonValue4.f31370i, k(cls6, null, jsonValue4));
                                }
                                return r3;
                            } else if (t instanceof v) {
                                ?? r32 = (T) ((v) t);
                                for (JsonValue jsonValue5 = r2.f31371j; jsonValue5 != null; jsonValue5 = jsonValue5.l) {
                                    r32.h(jsonValue5.f31370i, ((Integer) k(Integer.class, null, jsonValue5)).intValue());
                                }
                                return r32;
                            } else if (t instanceof u) {
                                ?? r33 = (T) ((u) t);
                                for (JsonValue jsonValue6 = r2.f31371j; jsonValue6 != null; jsonValue6 = jsonValue6.l) {
                                    r33.g(jsonValue6.f31370i, ((Float) k(Float.class, null, jsonValue6)).floatValue());
                                }
                                return r33;
                            } else if (t instanceof x) {
                                ?? r34 = (T) ((x) t);
                                for (JsonValue n = r2.n(SavedStateHandle.VALUES); n != null; n = n.l) {
                                    r34.add(k(cls6, null, n));
                                }
                                return r34;
                            } else if (t instanceof m) {
                                ?? r35 = (T) ((m) t);
                                for (JsonValue jsonValue7 = r2.f31371j; jsonValue7 != null; jsonValue7 = jsonValue7.l) {
                                    r35.f(Integer.parseInt(jsonValue7.f31370i), k(cls6, null, jsonValue7));
                                }
                                return r35;
                            } else if (t instanceof s) {
                                ?? r36 = (T) ((s) t);
                                for (JsonValue jsonValue8 = r2.f31371j; jsonValue8 != null; jsonValue8 = jsonValue8.l) {
                                    r36.g(Long.parseLong(jsonValue8.f31370i), k(cls6, null, jsonValue8));
                                }
                                return r36;
                            } else if (t instanceof n) {
                                ?? r37 = (T) ((n) t);
                                for (JsonValue n2 = r2.n(SavedStateHandle.VALUES); n2 != null; n2 = n2.l) {
                                    r37.a(n2.g());
                                }
                                return r37;
                            } else if (t instanceof c.b.b.q.b) {
                                ?? r38 = (T) ((c.b.b.q.b) t);
                                for (JsonValue jsonValue9 = r2.f31371j; jsonValue9 != null; jsonValue9 = jsonValue9.l) {
                                    r38.f(jsonValue9.f31370i, k(cls6, null, jsonValue9));
                                }
                                return r38;
                            } else if (t instanceof Map) {
                                ?? r39 = (T) ((Map) t);
                                for (JsonValue jsonValue10 = r2.f31371j; jsonValue10 != null; jsonValue10 = jsonValue10.l) {
                                    if (!jsonValue10.f31370i.equals(this.a)) {
                                        r39.put(jsonValue10.f31370i, k(cls6, null, jsonValue10));
                                    }
                                }
                                return r39;
                            } else {
                                i(t, r2);
                                return t;
                            }
                        }
                        return (T) l("value", cls5, r2);
                    }
                    return (T) c2.a(this, r2, cls5);
                }
            } else {
                cls3 = cls;
                jsonValue2 = r2;
            }
            if (cls3 != null) {
                d c3 = this.k.c(cls3);
                if (c3 != null) {
                    return (T) c3.a(this, jsonValue2, cls3);
                }
                if (c.b.b.q.p0.b.f(c.class, cls3)) {
                    T t2 = (T) h(cls3);
                    ((c) t2).a(this, jsonValue2);
                    return t2;
                }
            }
            int i2 = 0;
            if (jsonValue2.v()) {
                Class cls7 = cls3 != null ? cls3 : c.b.b.q.a.class;
                if (c.b.b.q.p0.b.f(c.b.b.q.a.class, cls7)) {
                    T t3 = cls7 == c.b.b.q.a.class ? (T) new c.b.b.q.a() : (T) ((c.b.b.q.a) h(cls7));
                    for (JsonValue jsonValue11 = jsonValue2.f31371j; jsonValue11 != null; jsonValue11 = jsonValue11.l) {
                        ((c.b.b.q.a) t3).a(k(cls6, null, jsonValue11));
                    }
                    return t3;
                } else if (c.b.b.q.p0.b.f(c0.class, cls7)) {
                    T t4 = cls7 == c0.class ? (T) new c0() : (T) ((c0) h(cls7));
                    for (JsonValue jsonValue12 = jsonValue2.f31371j; jsonValue12 != null; jsonValue12 = jsonValue12.l) {
                        ((c0) t4).addLast(k(cls6, null, jsonValue12));
                    }
                    return t4;
                } else if (c.b.b.q.p0.b.f(Collection.class, cls7)) {
                    T t5 = cls7.isInterface() ? (T) new ArrayList() : (T) ((Collection) h(cls7));
                    for (JsonValue jsonValue13 = jsonValue2.f31371j; jsonValue13 != null; jsonValue13 = jsonValue13.l) {
                        ((Collection) t5).add(k(cls6, null, jsonValue13));
                    }
                    return t5;
                } else if (cls7.isArray()) {
                    Class<?> componentType = cls7.getComponentType();
                    Class<?> cls8 = cls6;
                    if (cls6 == null) {
                        cls8 = componentType;
                    }
                    T t6 = (T) c.b.b.q.p0.a.a(componentType, jsonValue2.n);
                    JsonValue jsonValue14 = jsonValue2.f31371j;
                    while (jsonValue14 != null) {
                        c.b.b.q.p0.a.b(t6, i2, k(cls8, null, jsonValue14));
                        jsonValue14 = jsonValue14.l;
                        i2++;
                    }
                    return t6;
                } else {
                    throw new SerializationException("Unable to convert value to required type: " + jsonValue2 + " (" + cls7.getName() + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
            boolean B = jsonValue2.B();
            JsonValue jsonValue15 = jsonValue2;
            if (B) {
                if (cls3 != null) {
                    if (cls3 != Float.TYPE && cls3 != Float.class) {
                        if (cls3 != Integer.TYPE && cls3 != Integer.class) {
                            if (cls3 != Long.TYPE && cls3 != Long.class) {
                                if (cls3 != Double.TYPE && cls3 != Double.class) {
                                    if (cls3 == String.class) {
                                        return (T) jsonValue2.k();
                                    }
                                    if (cls3 != Short.TYPE && cls3 != Short.class) {
                                        if (cls3 == Byte.TYPE || cls3 == Byte.class) {
                                            return (T) Byte.valueOf(jsonValue2.c());
                                        }
                                        jsonValue15 = new JsonValue(jsonValue2.k());
                                    }
                                    return (T) Short.valueOf(jsonValue2.i());
                                }
                                return (T) Double.valueOf(jsonValue2.d());
                            }
                            return (T) Long.valueOf(jsonValue2.h());
                        }
                        return (T) Integer.valueOf(jsonValue2.g());
                    }
                }
                return (T) Float.valueOf(jsonValue2.e());
            }
            if (jsonValue15.w()) {
                if (cls3 != null) {
                    try {
                        if (cls3 != Boolean.TYPE) {
                            cls4 = Boolean.class;
                        }
                    } catch (NumberFormatException unused) {
                        cls4 = Boolean.class;
                    }
                }
                cls4 = Boolean.class;
                try {
                    return (T) Boolean.valueOf(jsonValue15.b());
                } catch (NumberFormatException unused2) {
                    jsonValue3 = new JsonValue(jsonValue15.k());
                    if (jsonValue3.E()) {
                    }
                }
            } else {
                cls4 = Boolean.class;
                jsonValue3 = jsonValue15;
            }
            if (jsonValue3.E()) {
                return null;
            }
            ?? r12 = (T) jsonValue3.k();
            if (cls3 == null || cls3 == String.class) {
                return r12;
            }
            if (cls3 != Integer.TYPE && cls3 != Integer.class) {
                if (cls3 != Float.TYPE && cls3 != Float.class) {
                    if (cls3 != Long.TYPE && cls3 != Long.class) {
                        if (cls3 != Double.TYPE && cls3 != Double.class) {
                            if (cls3 != Short.TYPE && cls3 != Short.class) {
                                if (cls3 == Byte.TYPE || cls3 == Byte.class) {
                                    return (T) Byte.valueOf((String) r12);
                                }
                                if (cls3 != Boolean.TYPE && cls3 != cls4) {
                                    if (cls3 != Character.TYPE && cls3 != Character.class) {
                                        if (c.b.b.q.p0.b.f(Enum.class, cls3)) {
                                            Enum[] enumArr = (Enum[]) cls3.getEnumConstants();
                                            int length = enumArr.length;
                                            while (i2 < length) {
                                                ?? r5 = (T) enumArr[i2];
                                                if (r12.equals(b(r5))) {
                                                    return r5;
                                                }
                                                i2++;
                                            }
                                        }
                                        if (cls3 == CharSequence.class) {
                                            return r12;
                                        }
                                        throw new SerializationException("Unable to convert value to required type: " + jsonValue3 + " (" + cls3.getName() + SmallTailInfo.EMOTION_SUFFIX);
                                    }
                                    return (T) Character.valueOf(r12.charAt(0));
                                }
                                return (T) Boolean.valueOf((String) r12);
                            }
                            return (T) Short.valueOf((String) r12);
                        }
                        return (T) Double.valueOf((String) r12);
                    }
                    return (T) Long.valueOf((String) r12);
                }
                return (T) Float.valueOf((String) r12);
            }
            return (T) Integer.valueOf((String) r12);
        }
        return (T) invokeLLL.objValue;
    }

    public <T> T l(String str, Class<T> cls, JsonValue jsonValue) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, cls, jsonValue)) == null) ? (T) k(cls, null, jsonValue.m(str)) : (T) invokeLLL.objValue;
    }

    public <T> T m(String str, Class<T> cls, Class cls2, JsonValue jsonValue) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, str, cls, cls2, jsonValue)) == null) ? (T) k(cls, cls2, jsonValue.m(str)) : (T) invokeLLLL.objValue;
    }

    public <T> T n(String str, Class<T> cls, T t, JsonValue jsonValue) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, str, cls, t, jsonValue)) == null) {
            JsonValue m = jsonValue.m(str);
            return m == null ? t : (T) k(cls, null, m);
        }
        return (T) invokeLLLL.objValue;
    }

    public <T> void o(Class<T> cls, d<T> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, cls, dVar) == null) {
            this.k.i(cls, dVar);
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.a = str;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }
}
