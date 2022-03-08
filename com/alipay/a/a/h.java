package com.alipay.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes3.dex */
public final class h implements i, j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
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

    public static Map<Object, Object> a(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, type)) == null) {
            while (type != Properties.class) {
                if (type == Hashtable.class) {
                    return new Hashtable();
                }
                if (type == IdentityHashMap.class) {
                    return new IdentityHashMap();
                }
                if (type == SortedMap.class || type == TreeMap.class) {
                    return new TreeMap();
                }
                if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
                    return new ConcurrentHashMap();
                }
                if (type == Map.class || type == HashMap.class) {
                    return new HashMap();
                }
                if (type == LinkedHashMap.class) {
                    return new LinkedHashMap();
                }
                if (!(type instanceof ParameterizedType)) {
                    Class cls = (Class) type;
                    if (cls.isInterface()) {
                        throw new IllegalArgumentException("unsupport type " + type);
                    }
                    try {
                        return (Map) cls.newInstance();
                    } catch (Exception e2) {
                        throw new IllegalArgumentException("unsupport type " + type, e2);
                    }
                }
                type = ((ParameterizedType) type).getRawType();
            }
            return new Properties();
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.alipay.a.a.j
    public final Object a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            TreeMap treeMap = new TreeMap();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                if (!(entry.getKey() instanceof String)) {
                    throw new IllegalArgumentException("Map key must be String!");
                }
                treeMap.put((String) entry.getKey(), f.b(entry.getValue()));
            }
            return treeMap;
        }
        return invokeL.objValue;
    }

    @Override // com.alipay.a.a.i
    public final Object a(Object obj, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, type)) == null) {
            if (obj.getClass().equals(org.json.alipay.b.class)) {
                org.json.alipay.b bVar = (org.json.alipay.b) obj;
                Map<Object, Object> a = a(type);
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    Type type2 = parameterizedType.getActualTypeArguments()[0];
                    Type type3 = parameterizedType.getActualTypeArguments()[1];
                    if (String.class == type2) {
                        Iterator a2 = bVar.a();
                        while (a2.hasNext()) {
                            String str = (String) a2.next();
                            a.put(str, com.alipay.a.b.a.a((Class<?>) ((Class) type3)) ? bVar.a(str) : e.a(bVar.a(str), type3));
                        }
                        return a;
                    }
                    throw new IllegalArgumentException("Deserialize Map Key must be String.class");
                }
                throw new IllegalArgumentException("Deserialize Map must be Generics!");
            }
            return null;
        }
        return invokeLL.objValue;
    }

    @Override // com.alipay.a.a.i, com.alipay.a.a.j
    public final boolean a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) ? Map.class.isAssignableFrom(cls) : invokeL.booleanValue;
    }
}
