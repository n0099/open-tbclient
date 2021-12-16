package com.alibaba.fastjson;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes9.dex */
public class TypeReference<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final Type LIST_STRING;
    public static ConcurrentMap<Type, Type> classTypeCache;
    public transient /* synthetic */ FieldHolder $fh;
    public final Type type;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1033573736, "Lcom/alibaba/fastjson/TypeReference;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1033573736, "Lcom/alibaba/fastjson/TypeReference;");
                return;
            }
        }
        classTypeCache = new ConcurrentHashMap(16, 0.75f, 1);
        LIST_STRING = new TypeReference<List<String>>() { // from class: com.alibaba.fastjson.TypeReference.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }.getType();
    }

    public TypeReference() {
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
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type type2 = classTypeCache.get(type);
        if (type2 == null) {
            classTypeCache.putIfAbsent(type, type);
            type2 = classTypeCache.get(type);
        }
        this.type = type2;
    }

    private Type handlerParameterizedType(ParameterizedType parameterizedType, Type[] typeArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, this, parameterizedType, typeArr, i2)) == null) {
            Class<?> cls = getClass();
            Type rawType = parameterizedType.getRawType();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i3 = 0; i3 < actualTypeArguments.length; i3++) {
                if ((actualTypeArguments[i3] instanceof TypeVariable) && i2 < typeArr.length) {
                    actualTypeArguments[i3] = typeArr[i2];
                    i2++;
                }
                if (actualTypeArguments[i3] instanceof GenericArrayType) {
                    actualTypeArguments[i3] = TypeUtils.checkPrimitiveArray((GenericArrayType) actualTypeArguments[i3]);
                }
                if (actualTypeArguments[i3] instanceof ParameterizedType) {
                    actualTypeArguments[i3] = handlerParameterizedType((ParameterizedType) actualTypeArguments[i3], typeArr, i2);
                }
            }
            return new ParameterizedTypeImpl(actualTypeArguments, cls, rawType);
        }
        return (Type) invokeLLI.objValue;
    }

    public static Type intern(ParameterizedTypeImpl parameterizedTypeImpl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parameterizedTypeImpl)) == null) {
            Type type = classTypeCache.get(parameterizedTypeImpl);
            if (type == null) {
                classTypeCache.putIfAbsent(parameterizedTypeImpl, parameterizedTypeImpl);
                return classTypeCache.get(parameterizedTypeImpl);
            }
            return type;
        }
        return (Type) invokeL.objValue;
    }

    public Type getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.type : (Type) invokeV.objValue;
    }

    public TypeReference(Type... typeArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {typeArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Class<?> cls = getClass();
        ParameterizedType parameterizedType = (ParameterizedType) ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[0];
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int i4 = 0;
        for (int i5 = 0; i5 < actualTypeArguments.length; i5++) {
            if ((actualTypeArguments[i5] instanceof TypeVariable) && i4 < typeArr.length) {
                actualTypeArguments[i5] = typeArr[i4];
                i4++;
            }
            if (actualTypeArguments[i5] instanceof GenericArrayType) {
                actualTypeArguments[i5] = TypeUtils.checkPrimitiveArray((GenericArrayType) actualTypeArguments[i5]);
            }
            if (actualTypeArguments[i5] instanceof ParameterizedType) {
                actualTypeArguments[i5] = handlerParameterizedType((ParameterizedType) actualTypeArguments[i5], typeArr, i4);
            }
        }
        ParameterizedTypeImpl parameterizedTypeImpl = new ParameterizedTypeImpl(actualTypeArguments, cls, rawType);
        Type type = classTypeCache.get(parameterizedTypeImpl);
        if (type == null) {
            classTypeCache.putIfAbsent(parameterizedTypeImpl, parameterizedTypeImpl);
            type = classTypeCache.get(parameterizedTypeImpl);
        }
        this.type = type;
    }
}
