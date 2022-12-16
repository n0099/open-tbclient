package com.alipay.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a implements i, j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // com.alipay.a.a.j
    public final Object a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (Object[]) obj) {
                arrayList.add(f.b(obj2));
            }
            return arrayList;
        }
        return invokeL.objValue;
    }

    @Override // com.alipay.a.a.i
    public final Object a(Object obj, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, type)) == null) {
            if (obj.getClass().equals(org.json.alipay.a.class)) {
                org.json.alipay.a aVar = (org.json.alipay.a) obj;
                if (type instanceof GenericArrayType) {
                    throw new IllegalArgumentException("Does not support generic array!");
                }
                Class<?> componentType = ((Class) type).getComponentType();
                int a = aVar.a();
                Object newInstance = Array.newInstance(componentType, a);
                for (int i = 0; i < a; i++) {
                    Array.set(newInstance, i, e.a(aVar.a(i), componentType));
                }
                return newInstance;
            }
            return null;
        }
        return invokeLL.objValue;
    }

    @Override // com.alipay.a.a.i, com.alipay.a.a.j
    public final boolean a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) ? cls.isArray() : invokeL.booleanValue;
    }
}
