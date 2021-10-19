package c.i.d.h;

import c.i.d.a.i;
import c.i.d.a.k;
import c.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.Typography;
/* loaded from: classes4.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f34311a;

    /* loaded from: classes4.dex */
    public static class a extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f34312b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Type f34313c;

        public a(Map map, Type type) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, type};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34312b = map;
            this.f34313c = type;
        }

        @Override // c.i.d.h.g
        public void b(Class<?> cls) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cls) == null) || (this.f34313c instanceof WildcardType)) {
                return;
            }
            throw new IllegalArgumentException("No type mapping from " + cls + " to " + this.f34313c);
        }

        @Override // c.i.d.h.g
        public void c(GenericArrayType genericArrayType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, genericArrayType) == null) {
                Type type = this.f34313c;
                if (type instanceof WildcardType) {
                    return;
                }
                Type j2 = Types.j(type);
                n.k(j2 != null, "%s is not an array type.", this.f34313c);
                f.g(this.f34312b, genericArrayType.getGenericComponentType(), j2);
            }
        }

        @Override // c.i.d.h.g
        public void d(ParameterizedType parameterizedType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parameterizedType) == null) {
                Type type = this.f34313c;
                if (type instanceof WildcardType) {
                    return;
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) f.e(ParameterizedType.class, type);
                if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                    f.g(this.f34312b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
                }
                n.l(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.f34313c);
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                n.l(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
                for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                    f.g(this.f34312b, actualTypeArguments[i2], actualTypeArguments2[i2]);
                }
            }
        }

        @Override // c.i.d.h.g
        public void e(TypeVariable<?> typeVariable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, typeVariable) == null) {
                this.f34312b.put(new d(typeVariable), this.f34313c);
            }
        }

        @Override // c.i.d.h.g
        public void f(WildcardType wildcardType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, wildcardType) == null) {
                Type type = this.f34313c;
                if (type instanceof WildcardType) {
                    WildcardType wildcardType2 = (WildcardType) type;
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    Type[] upperBounds2 = wildcardType2.getUpperBounds();
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                    n.l(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.f34313c);
                    for (int i2 = 0; i2 < upperBounds.length; i2++) {
                        f.g(this.f34312b, upperBounds[i2], upperBounds2[i2]);
                    }
                    for (int i3 = 0; i3 < lowerBounds.length; i3++) {
                        f.g(this.f34312b, lowerBounds[i3], lowerBounds2[i3]);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Map<d, Type> f34314b;

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
                    return;
                }
            }
            this.f34314b = Maps.s();
        }

        public static ImmutableMap<d, Type> g(Type type) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, type)) == null) {
                n.p(type);
                b bVar = new b();
                bVar.a(type);
                return ImmutableMap.copyOf((Map) bVar.f34314b);
            }
            return (ImmutableMap) invokeL.objValue;
        }

        @Override // c.i.d.h.g
        public void b(Class<?> cls) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cls) == null) {
                a(cls.getGenericSuperclass());
                a(cls.getGenericInterfaces());
            }
        }

        @Override // c.i.d.h.g
        public void d(ParameterizedType parameterizedType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parameterizedType) == null) {
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                n.w(typeParameters.length == actualTypeArguments.length);
                for (int i2 = 0; i2 < typeParameters.length; i2++) {
                    h(new d(typeParameters[i2]), actualTypeArguments[i2]);
                }
                a(cls);
                a(parameterizedType.getOwnerType());
            }
        }

        @Override // c.i.d.h.g
        public void e(TypeVariable<?> typeVariable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, typeVariable) == null) {
                a(typeVariable.getBounds());
            }
        }

        @Override // c.i.d.h.g
        public void f(WildcardType wildcardType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, wildcardType) == null) {
                a(wildcardType.getUpperBounds());
            }
        }

        public final void h(d dVar, Type type) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048580, this, dVar, type) == null) || this.f34314b.containsKey(dVar)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (dVar.a(type2)) {
                    while (type != null) {
                        type = this.f34314b.remove(d.c(type));
                    }
                    return;
                }
                type2 = this.f34314b.get(d.c(type2));
            }
            this.f34314b.put(dVar, type);
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final TypeVariable<?> f34318a;

        public d(TypeVariable<?> typeVariable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeVariable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(typeVariable);
            this.f34318a = typeVariable;
        }

        public static d c(Type type) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, type)) == null) {
                if (type instanceof TypeVariable) {
                    return new d((TypeVariable) type);
                }
                return null;
            }
            return (d) invokeL.objValue;
        }

        public boolean a(Type type) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, type)) == null) {
                if (type instanceof TypeVariable) {
                    return b((TypeVariable) type);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public final boolean b(TypeVariable<?> typeVariable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typeVariable)) == null) ? this.f34318a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f34318a.getName().equals(typeVariable.getName()) : invokeL.booleanValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof d) {
                    return b(((d) obj).f34318a);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? k.b(this.f34318a.getGenericDeclaration(), this.f34318a.getName()) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34318a.toString() : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static final e f34319b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f34320a;

        /* loaded from: classes4.dex */
        public class a extends e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ TypeVariable f34321c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar, AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, atomicInteger, typeVariable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((AtomicInteger) objArr2[0], (a) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34321c = typeVariable;
            }

            @Override // c.i.d.h.f.e
            public TypeVariable<?> b(Type[] typeArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, typeArr)) == null) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                    linkedHashSet.addAll(Arrays.asList(this.f34321c.getBounds()));
                    if (linkedHashSet.size() > 1) {
                        linkedHashSet.remove(Object.class);
                    }
                    return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
                }
                return (TypeVariable) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2017647324, "Lc/i/d/h/f$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2017647324, "Lc/i/d/h/f$e;");
                    return;
                }
            }
            f34319b = new e();
        }

        public /* synthetic */ e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        public final Type a(Type type) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, type)) == null) {
                n.p(type);
                if ((type instanceof Class) || (type instanceof TypeVariable)) {
                    return type;
                }
                if (type instanceof GenericArrayType) {
                    return Types.k(e().a(((GenericArrayType) type).getGenericComponentType()));
                }
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    Class cls = (Class) parameterizedType.getRawType();
                    TypeVariable<?>[] typeParameters = cls.getTypeParameters();
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                        actualTypeArguments[i2] = d(typeParameters[i2]).a(actualTypeArguments[i2]);
                    }
                    return Types.n(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
                } else if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
                } else {
                    throw new AssertionError("must have been one of the known types");
                }
            }
            return (Type) invokeL.objValue;
        }

        public TypeVariable<?> b(Type[] typeArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typeArr)) == null) {
                return Types.l(e.class, "capture#" + this.f34320a.incrementAndGet() + "-of ? extends " + i.f(Typography.amp).e(typeArr), typeArr);
            }
            return (TypeVariable) invokeL.objValue;
        }

        public final Type c(Type type) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, type)) == null) {
                if (type == null) {
                    return null;
                }
                return a(type);
            }
            return (Type) invokeL.objValue;
        }

        public final e d(TypeVariable<?> typeVariable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, typeVariable)) == null) ? new a(this, this.f34320a, typeVariable) : (e) invokeL.objValue;
        }

        public final e e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new e(this.f34320a) : (e) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public e() {
            this(new AtomicInteger());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((AtomicInteger) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public e(AtomicInteger atomicInteger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicInteger};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f34320a = atomicInteger;
        }
    }

    public /* synthetic */ f(c cVar, a aVar) {
        this(cVar);
    }

    public static f d(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, type)) == null) ? new f().o(b.g(type)) : (f) invokeL.objValue;
    }

    public static <T> T e(Class<T> cls, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, cls, obj)) == null) {
            try {
                return cls.cast(obj);
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
            }
        }
        return (T) invokeLL.objValue;
    }

    public static f f(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, type)) == null) ? new f().o(b.g(e.f34319b.a(type))) : (f) invokeL.objValue;
    }

    public static void g(Map<d, Type> map, Type type, Type type2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, map, type, type2) == null) || type.equals(type2)) {
            return;
        }
        new a(map, type2).a(type);
    }

    public final Type h(GenericArrayType genericArrayType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, genericArrayType)) == null) ? Types.k(j(genericArrayType.getGenericComponentType())) : (Type) invokeL.objValue;
    }

    public final ParameterizedType i(ParameterizedType parameterizedType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parameterizedType)) == null) {
            Type ownerType = parameterizedType.getOwnerType();
            return Types.n(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
        }
        return (ParameterizedType) invokeL.objValue;
    }

    public Type j(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, type)) == null) {
            n.p(type);
            if (type instanceof TypeVariable) {
                return this.f34311a.a((TypeVariable) type);
            }
            if (type instanceof ParameterizedType) {
                return i((ParameterizedType) type);
            }
            if (type instanceof GenericArrayType) {
                return h((GenericArrayType) type);
            }
            return type instanceof WildcardType ? m((WildcardType) type) : type;
        }
        return (Type) invokeL.objValue;
    }

    public final Type[] k(Type[] typeArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, typeArr)) == null) {
            Type[] typeArr2 = new Type[typeArr.length];
            for (int i2 = 0; i2 < typeArr.length; i2++) {
                typeArr2[i2] = j(typeArr[i2]);
            }
            return typeArr2;
        }
        return (Type[]) invokeL.objValue;
    }

    public Type[] l(Type[] typeArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, typeArr)) == null) {
            for (int i2 = 0; i2 < typeArr.length; i2++) {
                typeArr[i2] = j(typeArr[i2]);
            }
            return typeArr;
        }
        return (Type[]) invokeL.objValue;
    }

    public final WildcardType m(WildcardType wildcardType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, wildcardType)) == null) ? new Types.WildcardTypeImpl(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds())) : (WildcardType) invokeL.objValue;
    }

    public f n(Type type, Type type2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, type, type2)) == null) {
            HashMap s = Maps.s();
            n.p(type);
            n.p(type2);
            g(s, type, type2);
            return o(s);
        }
        return (f) invokeLL.objValue;
    }

    public f o(Map<d, ? extends Type> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, map)) == null) ? new f(this.f34311a.c(map)) : (f) invokeL.objValue;
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ImmutableMap<d, Type> f34315a;

        /* loaded from: classes4.dex */
        public class a extends c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ TypeVariable f34316b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f34317c;

            public a(c cVar, TypeVariable typeVariable, c cVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, typeVariable, cVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34316b = typeVariable;
                this.f34317c = cVar2;
            }

            @Override // c.i.d.h.f.c
            public Type b(TypeVariable<?> typeVariable, c cVar) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, typeVariable, cVar)) == null) ? typeVariable.getGenericDeclaration().equals(this.f34316b.getGenericDeclaration()) ? typeVariable : this.f34317c.b(typeVariable, cVar) : (Type) invokeLL.objValue;
            }
        }

        public c() {
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
            this.f34315a = ImmutableMap.of();
        }

        public final Type a(TypeVariable<?> typeVariable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, typeVariable)) == null) ? b(typeVariable, new a(this, typeVariable, this)) : (Type) invokeL.objValue;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.reflect.GenericDeclaration] */
        public Type b(TypeVariable<?> typeVariable, c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typeVariable, cVar)) == null) {
                Type type = this.f34315a.get(new d(typeVariable));
                if (type == null) {
                    Type[] bounds = typeVariable.getBounds();
                    if (bounds.length == 0) {
                        return typeVariable;
                    }
                    Type[] k = new f(cVar, null).k(bounds);
                    return (Types.c.f71205a && Arrays.equals(bounds, k)) ? typeVariable : Types.l(typeVariable.getGenericDeclaration(), typeVariable.getName(), k);
                }
                return new f(cVar, null).j(type);
            }
            return (Type) invokeLL.objValue;
        }

        public final c c(Map<d, ? extends Type> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
                ImmutableMap.b builder = ImmutableMap.builder();
                builder.f(this.f34315a);
                for (Map.Entry<d, ? extends Type> entry : map.entrySet()) {
                    d key = entry.getKey();
                    Type value = entry.getValue();
                    n.k(!key.a(value), "Type variable %s bound to itself", key);
                    builder.c(key, value);
                }
                return new c(builder.a());
            }
            return (c) invokeL.objValue;
        }

        public c(ImmutableMap<d, Type> immutableMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableMap};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f34315a = immutableMap;
        }
    }

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
                return;
            }
        }
        this.f34311a = new c();
    }

    public f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34311a = cVar;
    }
}
