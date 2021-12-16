package com.alibaba.fastjson.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
/* loaded from: classes9.dex */
public class ParameterizedTypeImpl implements ParameterizedType {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Type[] actualTypeArguments;
    public final Type ownerType;
    public final Type rawType;

    public ParameterizedTypeImpl(Type[] typeArr, Type type, Type type2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {typeArr, type, type2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actualTypeArguments = typeArr;
        this.ownerType = type;
        this.rawType = type2;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ParameterizedTypeImpl.class != obj.getClass()) {
                return false;
            }
            ParameterizedTypeImpl parameterizedTypeImpl = (ParameterizedTypeImpl) obj;
            if (Arrays.equals(this.actualTypeArguments, parameterizedTypeImpl.actualTypeArguments)) {
                Type type = this.ownerType;
                if (type == null ? parameterizedTypeImpl.ownerType == null : type.equals(parameterizedTypeImpl.ownerType)) {
                    Type type2 = this.rawType;
                    Type type3 = parameterizedTypeImpl.rawType;
                    return type2 != null ? type2.equals(type3) : type3 == null;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.actualTypeArguments : (Type[]) invokeV.objValue;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ownerType : (Type) invokeV.objValue;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.rawType : (Type) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Type[] typeArr = this.actualTypeArguments;
            int hashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
            Type type = this.ownerType;
            int hashCode2 = (hashCode + (type != null ? type.hashCode() : 0)) * 31;
            Type type2 = this.rawType;
            return hashCode2 + (type2 != null ? type2.hashCode() : 0);
        }
        return invokeV.intValue;
    }
}
