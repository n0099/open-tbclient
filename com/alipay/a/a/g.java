package com.alipay.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public final class g implements i, j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0058 A[SYNTHETIC] */
    @Override // com.alipay.a.a.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Object obj) {
        InterceptResult invokeL;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, obj)) != null) {
            return invokeL.objValue;
        }
        TreeMap treeMap = new TreeMap();
        Class<?> cls = obj.getClass();
        while (true) {
            Field[] declaredFields = cls.getDeclaredFields();
            if (cls.equals(Object.class)) {
                return treeMap;
            }
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (field != null && obj != null && !"this$0".equals(field.getName())) {
                        boolean isAccessible = field.isAccessible();
                        field.setAccessible(true);
                        Object obj3 = field.get(obj);
                        if (obj3 != null) {
                            field.setAccessible(isAccessible);
                            obj2 = f.b(obj3);
                            if (obj2 == null) {
                                treeMap.put(field.getName(), obj2);
                            }
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                    }
                }
            }
            cls = cls.getSuperclass();
        }
    }

    @Override // com.alipay.a.a.i
    public final Object a(Object obj, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, type)) == null) {
            if (obj.getClass().equals(org.json.alipay.b.class)) {
                org.json.alipay.b bVar = (org.json.alipay.b) obj;
                Class cls = (Class) type;
                Object newInstance = cls.newInstance();
                while (!cls.equals(Object.class)) {
                    Field[] declaredFields = cls.getDeclaredFields();
                    if (declaredFields != null && declaredFields.length > 0) {
                        for (Field field : declaredFields) {
                            String name = field.getName();
                            Type genericType = field.getGenericType();
                            if (bVar.b(name)) {
                                field.setAccessible(true);
                                field.set(newInstance, e.a(bVar.a(name), genericType));
                            }
                        }
                    }
                    cls = cls.getSuperclass();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }
}
