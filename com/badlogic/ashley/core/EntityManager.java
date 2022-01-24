package com.badlogic.ashley.core;

import c.b.a.a.d;
import c.b.a.a.e;
import c.b.b.q.x;
import c.b.b.q.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.ActLog;
/* loaded from: classes9.dex */
public class EntityManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public c.b.b.q.a<d> f31062b;

    /* renamed from: c  reason: collision with root package name */
    public x<d> f31063c;

    /* renamed from: d  reason: collision with root package name */
    public c.b.a.c.b<d> f31064d;

    /* renamed from: e  reason: collision with root package name */
    public c.b.b.q.a<EntityOperation> f31065e;

    /* renamed from: f  reason: collision with root package name */
    public b f31066f;

    /* loaded from: classes9.dex */
    public static class EntityOperation implements z.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Type a;

        /* renamed from: b  reason: collision with root package name */
        public d f31067b;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes9.dex */
        public static final class Type {
            public static final /* synthetic */ Type[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final Type Add;
            public static final Type Remove;
            public static final Type RemoveAll;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1800928960, "Lcom/badlogic/ashley/core/EntityManager$EntityOperation$Type;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1800928960, "Lcom/badlogic/ashley/core/EntityManager$EntityOperation$Type;");
                        return;
                    }
                }
                Add = new Type(ActLog.TYPE_ADD, 0);
                Remove = new Type("Remove", 1);
                Type type = new Type("RemoveAll", 2);
                RemoveAll = type;
                $VALUES = new Type[]{Add, Remove, type};
            }

            public Type(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static Type valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
            }

            public static Type[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
            }
        }

        public EntityOperation() {
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

        @Override // c.b.b.q.z.a
        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31067b = null;
            }
        }

        public /* synthetic */ EntityOperation(a aVar) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1887692869, "Lcom/badlogic/ashley/core/EntityManager$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1887692869, "Lcom/badlogic/ashley/core/EntityManager$a;");
                    return;
                }
            }
            int[] iArr = new int[EntityOperation.Type.values().length];
            a = iArr;
            try {
                iArr[EntityOperation.Type.Add.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EntityOperation.Type.Remove.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EntityOperation.Type.RemoveAll.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends z<EntityOperation> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.b.q.z
        /* renamed from: g */
        public EntityOperation d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new EntityOperation(null) : (EntityOperation) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public EntityManager(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31062b = new c.b.b.q.a<>(false, 16);
        this.f31063c = new x<>();
        this.f31064d = new c.b.a.c.b<>(this.f31062b);
        this.f31065e = new c.b.b.q.a<>(false, 16);
        this.f31066f = new b(null);
        this.a = eVar;
    }

    public void a(d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, dVar, z) == null) {
            if (z) {
                EntityOperation e2 = this.f31066f.e();
                e2.f31067b = dVar;
                e2.a = EntityOperation.Type.Add;
                this.f31065e.a(e2);
                return;
            }
            b(dVar);
        }
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            if (!this.f31063c.contains(dVar)) {
                this.f31062b.a(dVar);
                this.f31063c.add(dVar);
                this.a.b(dVar);
                return;
            }
            throw new IllegalArgumentException("Entity is already registered " + dVar);
        }
    }

    public c.b.a.c.b<d> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31064d : (c.b.a.c.b) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            c.b.b.q.a<EntityOperation> aVar = this.f31065e;
            if (i2 < aVar.f27389f) {
                EntityOperation entityOperation = aVar.get(i2);
                int i3 = a.a[entityOperation.a.ordinal()];
                if (i3 == 1) {
                    b(entityOperation.f31067b);
                } else if (i3 == 2) {
                    f(entityOperation.f31067b);
                } else if (i3 != 3) {
                    throw new AssertionError("Unexpected EntityOperation type");
                } else {
                    while (true) {
                        c.b.b.q.a<d> aVar2 = this.f31062b;
                        if (aVar2.f27389f > 0) {
                            f(aVar2.first());
                        }
                    }
                }
                this.f31066f.c(entityOperation);
                i2++;
            } else {
                aVar.clear();
                return;
            }
        }
    }

    public void e(d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, dVar, z) == null) {
            if (z) {
                if (dVar.f26921c) {
                    return;
                }
                dVar.f26921c = true;
                EntityOperation e2 = this.f31066f.e();
                e2.f31067b = dVar;
                e2.a = EntityOperation.Type.Remove;
                this.f31065e.a(e2);
                return;
            }
            f(dVar);
        }
    }

    public void f(d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) && this.f31063c.remove(dVar)) {
            dVar.f26921c = false;
            dVar.f26922d = true;
            this.f31062b.i(dVar, true);
            this.a.a(dVar);
            dVar.f26922d = false;
        }
    }
}
