package c.i.d.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
/* loaded from: classes4.dex */
public abstract class b<T, R> extends c.i.d.h.a implements GenericDeclaration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a<T> extends b<T, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final Constructor<?> f34281g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Constructor<?> constructor) {
            super(constructor);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constructor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AccessibleObject) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34281g = constructor;
        }

        public Type[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Type[] genericParameterTypes = this.f34281g.getGenericParameterTypes();
                if (genericParameterTypes.length <= 0 || !c()) {
                    return genericParameterTypes;
                }
                Class<?>[] parameterTypes = this.f34281g.getParameterTypes();
                return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
            }
            return (Type[]) invokeV.objValue;
        }

        public final boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Class<?> declaringClass = this.f34281g.getDeclaringClass();
                if (declaringClass.getEnclosingConstructor() != null) {
                    return true;
                }
                Method enclosingMethod = declaringClass.getEnclosingMethod();
                if (enclosingMethod != null) {
                    return !Modifier.isStatic(enclosingMethod.getModifiers());
                }
                return (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
                TypeVariable<Constructor<?>>[] typeParameters2 = this.f34281g.getTypeParameters();
                TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
                System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
                System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
                return typeVariableArr;
            }
            return (TypeVariable[]) invokeV.objValue;
        }
    }

    /* renamed from: c.i.d.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1512b<T> extends b<T, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final Method f34282g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1512b(Method method) {
            super(method);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {method};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AccessibleObject) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34282g = method;
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34282g.getTypeParameters() : (TypeVariable[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <M extends AccessibleObject & Member> b(M m) {
        super(m);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((AccessibleObject) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.i.d.h.a, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (Class<? super T>) super.getDeclaringClass() : (Class) invokeV.objValue;
    }
}
