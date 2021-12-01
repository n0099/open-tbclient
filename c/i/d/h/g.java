package c.i.d.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<Type> a;

    public g() {
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
        this.a = Sets.f();
    }

    public final void a(Type... typeArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, typeArr) == null) {
            for (Type type : typeArr) {
                if (type != null && this.a.add(type)) {
                    try {
                        if (type instanceof TypeVariable) {
                            e((TypeVariable) type);
                        } else if (type instanceof WildcardType) {
                            f((WildcardType) type);
                        } else if (type instanceof ParameterizedType) {
                            d((ParameterizedType) type);
                        } else if (type instanceof Class) {
                            b((Class) type);
                        } else if (type instanceof GenericArrayType) {
                            c((GenericArrayType) type);
                        } else {
                            throw new AssertionError("Unknown type: " + type);
                        }
                    } catch (Throwable th) {
                        this.a.remove(type);
                        throw th;
                    }
                }
            }
        }
    }

    public void b(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls) == null) {
        }
    }

    public void c(GenericArrayType genericArrayType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, genericArrayType) == null) {
        }
    }

    public void d(ParameterizedType parameterizedType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, parameterizedType) == null) {
        }
    }

    public abstract void e(TypeVariable<?> typeVariable);

    public abstract void f(WildcardType wildcardType);
}
