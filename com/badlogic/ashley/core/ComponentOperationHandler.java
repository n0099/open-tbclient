package com.badlogic.ashley.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i0;
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
public class ComponentOperationHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public c b;
    public u6<ComponentOperation> c;

    /* loaded from: classes.dex */
    public interface b {
        boolean value();
    }

    /* loaded from: classes.dex */
    public static class ComponentOperation implements t7.a {
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
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-693699950, "Lcom/badlogic/ashley/core/ComponentOperationHandler$ComponentOperation$Type;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-693699950, "Lcom/badlogic/ashley/core/ComponentOperationHandler$ComponentOperation$Type;");
                        return;
                    }
                }
                Add = new Type(ActLog.TYPE_ADD, 0);
                Type type = new Type("Remove", 1);
                Remove = type;
                $VALUES = new Type[]{Add, type};
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

        public ComponentOperation() {
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
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b = null;
            }
        }

        public /* synthetic */ ComponentOperation(a aVar) {
            this();
        }

        public void a(i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, i0Var) == null) {
                this.a = Type.Add;
                this.b = i0Var;
            }
        }

        public void b(i0 i0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i0Var) == null) {
                this.a = Type.Remove;
                this.b = i0Var;
            }
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1742155973, "Lcom/badlogic/ashley/core/ComponentOperationHandler$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1742155973, "Lcom/badlogic/ashley/core/ComponentOperationHandler$a;");
                    return;
                }
            }
            int[] iArr = new int[ComponentOperation.Type.values().length];
            a = iArr;
            try {
                iArr[ComponentOperation.Type.Add.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ComponentOperation.Type.Remove.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends t7<ComponentOperation> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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
        public ComponentOperation d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new ComponentOperation(null);
            }
            return (ComponentOperation) invokeV.objValue;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public ComponentOperationHandler(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new c(null);
        this.c = new u6<>();
        this.a = bVar;
    }

    public void a(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, i0Var) == null) {
            if (this.a.value()) {
                ComponentOperation e = this.b.e();
                e.a(i0Var);
                this.c.a(e);
                return;
            }
            i0Var.g();
        }
    }

    public void c(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i0Var) == null) {
            if (this.a.value()) {
                ComponentOperation e = this.b.e();
                e.b(i0Var);
                this.c.a(e);
                return;
            }
            i0Var.h();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = 0;
            while (true) {
                u6<ComponentOperation> u6Var = this.c;
                if (i < u6Var.b) {
                    ComponentOperation componentOperation = u6Var.get(i);
                    int i2 = a.a[componentOperation.a.ordinal()];
                    if (i2 != 1) {
                        if (i2 == 2) {
                            componentOperation.b.h();
                        }
                    } else {
                        componentOperation.b.g();
                    }
                    this.b.c(componentOperation);
                    i++;
                } else {
                    u6Var.clear();
                    return;
                }
            }
        }
    }
}
