package c.b.b.q.p0;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes3.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Field a;

    public d(Field field) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {field};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = field;
    }

    public Object a(Object obj) throws ReflectionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            try {
                return this.a.get(obj);
            } catch (IllegalAccessException e2) {
                throw new ReflectionException("Illegal access to field: " + d(), e2);
            } catch (IllegalArgumentException e3) {
                throw new ReflectionException("Object is not an instance of " + b(), e3);
            }
        }
        return invokeL.objValue;
    }

    public Class b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getDeclaringClass() : (Class) invokeV.objValue;
    }

    public Class c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Type genericType = this.a.getGenericType();
            if (genericType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                if (actualTypeArguments.length - 1 >= i2) {
                    Type type = actualTypeArguments[i2];
                    if (type instanceof Class) {
                        return (Class) type;
                    }
                    if (type instanceof ParameterizedType) {
                        return (Class) ((ParameterizedType) type).getRawType();
                    }
                    if (type instanceof GenericArrayType) {
                        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
                        if (genericComponentType instanceof Class) {
                            return a.a((Class) genericComponentType, 0).getClass();
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (Class) invokeI.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.getName() : (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.isAccessible() : invokeV.booleanValue;
    }

    public boolean f(Class<? extends Annotation> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) ? this.a.isAnnotationPresent(cls) : invokeL.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Modifier.isStatic(this.a.getModifiers()) : invokeV.booleanValue;
    }

    public Class getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.getType() : (Class) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.isSynthetic() : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Modifier.isTransient(this.a.getModifiers()) : invokeV.booleanValue;
    }

    public void j(Object obj, Object obj2) throws ReflectionException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, obj, obj2) == null) {
            try {
                this.a.set(obj, obj2);
            } catch (IllegalAccessException e2) {
                throw new ReflectionException("Illegal access to field: " + d(), e2);
            } catch (IllegalArgumentException e3) {
                throw new ReflectionException("Argument not valid for field: " + d(), e3);
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.a.setAccessible(z);
        }
    }
}
