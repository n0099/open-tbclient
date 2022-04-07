package com.badlogic.ashley.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.l0;
import com.repackage.m0;
import com.repackage.v0;
import com.repackage.v7;
import com.repackage.x7;
import com.repackage.y6;
import com.yy.hiidostatis.inner.util.log.ActLog;
/* loaded from: classes.dex */
public class EntityManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m0 a;
    public y6<l0> b;
    public v7<l0> c;
    public v0<l0> d;
    public y6<EntityOperation> e;
    public b f;

    /* loaded from: classes.dex */
    public static class EntityOperation implements x7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Type a;
        public l0 b;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes.dex */
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

            public Type(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.x7.a
        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b = null;
            }
        }

        public /* synthetic */ EntityOperation(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static class b extends x7<EntityOperation> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x7
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

    public EntityManager(m0 m0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new y6<>(false, 16);
        this.c = new v7<>();
        this.d = new v0<>(this.b);
        this.e = new y6<>(false, 16);
        this.f = new b(null);
        this.a = m0Var;
    }

    public void a(l0 l0Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, l0Var, z) == null) {
            if (z) {
                EntityOperation e = this.f.e();
                e.b = l0Var;
                e.a = EntityOperation.Type.Add;
                this.e.a(e);
                return;
            }
            b(l0Var);
        }
    }

    public void b(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l0Var) == null) {
            if (!this.c.contains(l0Var)) {
                this.b.a(l0Var);
                this.c.add(l0Var);
                this.a.b(l0Var);
                return;
            }
            throw new IllegalArgumentException("Entity is already registered " + l0Var);
        }
    }

    public v0<l0> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (v0) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
            return;
        }
        int i = 0;
        while (true) {
            y6<EntityOperation> y6Var = this.e;
            if (i < y6Var.b) {
                EntityOperation entityOperation = y6Var.get(i);
                int i2 = a.a[entityOperation.a.ordinal()];
                if (i2 == 1) {
                    b(entityOperation.b);
                } else if (i2 == 2) {
                    f(entityOperation.b);
                } else if (i2 != 3) {
                    throw new AssertionError("Unexpected EntityOperation type");
                } else {
                    while (true) {
                        y6<l0> y6Var2 = this.b;
                        if (y6Var2.b > 0) {
                            f(y6Var2.f());
                        }
                    }
                }
                this.f.c(entityOperation);
                i++;
            } else {
                y6Var.clear();
                return;
            }
        }
    }

    public void e(l0 l0Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, l0Var, z) == null) {
            if (z) {
                if (l0Var.c) {
                    return;
                }
                l0Var.c = true;
                EntityOperation e = this.f.e();
                e.b = l0Var;
                e.a = EntityOperation.Type.Remove;
                this.e.a(e);
                return;
            }
            f(l0Var);
        }
    }

    public void f(l0 l0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, l0Var) == null) && this.c.remove(l0Var)) {
            l0Var.c = false;
            l0Var.d = true;
            this.b.j(l0Var, true);
            this.a.a(l0Var);
            l0Var.d = false;
        }
    }
}
