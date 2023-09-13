package com.badlogic.ashley.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i0;
import com.baidu.tieba.j0;
import com.baidu.tieba.r7;
import com.baidu.tieba.s0;
import com.baidu.tieba.t7;
import com.baidu.tieba.u6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.ActLog;
/* loaded from: classes.dex */
public class EntityManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j0 a;
    public u6<i0> b;
    public r7<i0> c;
    public s0<i0> d;
    public u6<EntityOperation> e;
    public b f;

    /* loaded from: classes.dex */
    public static class EntityOperation implements t7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Type a;
        public i0 b;

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
                if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                    return (Type) Enum.valueOf(Type.class, str);
                }
                return (Type) invokeL.objValue;
            }

            public static Type[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                    return (Type[]) $VALUES.clone();
                }
                return (Type[]) invokeV.objValue;
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

        @Override // com.baidu.tieba.t7.a
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
    public static class b extends t7<EntityOperation> {
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
        @Override // com.baidu.tieba.t7
        /* renamed from: g */
        public EntityOperation d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new EntityOperation(null);
            }
            return (EntityOperation) invokeV.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public EntityManager(j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new u6<>(false, 16);
        this.c = new r7<>();
        this.d = new s0<>(this.b);
        this.e = new u6<>(false, 16);
        this.f = new b(null);
        this.a = j0Var;
    }

    public void a(i0 i0Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, i0Var, z) == null) {
            if (z) {
                EntityOperation e = this.f.e();
                e.b = i0Var;
                e.a = EntityOperation.Type.Add;
                this.e.a(e);
                return;
            }
            b(i0Var);
        }
    }

    public void e(i0 i0Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, i0Var, z) == null) {
            if (z) {
                if (i0Var.c) {
                    return;
                }
                i0Var.c = true;
                EntityOperation e = this.f.e();
                e.b = i0Var;
                e.a = EntityOperation.Type.Remove;
                this.e.a(e);
                return;
            }
            f(i0Var);
        }
    }

    public void b(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i0Var) == null) {
            if (!this.c.contains(i0Var)) {
                this.b.a(i0Var);
                this.c.add(i0Var);
                this.a.b(i0Var);
                return;
            }
            throw new IllegalArgumentException("Entity is already registered " + i0Var);
        }
    }

    public s0<i0> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (s0) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i = 0;
            while (true) {
                u6<EntityOperation> u6Var = this.e;
                if (i < u6Var.b) {
                    EntityOperation entityOperation = u6Var.get(i);
                    int i2 = a.a[entityOperation.a.ordinal()];
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                throw new AssertionError("Unexpected EntityOperation type");
                            }
                            while (true) {
                                u6<i0> u6Var2 = this.b;
                                if (u6Var2.b > 0) {
                                    f(u6Var2.first());
                                }
                            }
                        } else {
                            f(entityOperation.b);
                        }
                    } else {
                        b(entityOperation.b);
                    }
                    this.f.c(entityOperation);
                    i++;
                } else {
                    u6Var.clear();
                    return;
                }
            }
        }
    }

    public void f(i0 i0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, i0Var) == null) && this.c.remove(i0Var)) {
            i0Var.c = false;
            i0Var.d = true;
            this.b.i(i0Var, true);
            this.a.a(i0Var);
            i0Var.d = false;
        }
    }
}
