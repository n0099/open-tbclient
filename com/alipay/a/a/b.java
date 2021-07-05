package com.alipay.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
/* loaded from: classes.dex */
public final class b implements i, j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    public static Collection<Object> a(Class<?> cls, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, type)) == null) {
            if (cls == AbstractCollection.class) {
                return new ArrayList();
            }
            if (cls.isAssignableFrom(HashSet.class)) {
                return new HashSet();
            }
            if (cls.isAssignableFrom(LinkedHashSet.class)) {
                return new LinkedHashSet();
            }
            if (cls.isAssignableFrom(TreeSet.class)) {
                return new TreeSet();
            }
            if (cls.isAssignableFrom(ArrayList.class)) {
                return new ArrayList();
            }
            if (cls.isAssignableFrom(EnumSet.class)) {
                return EnumSet.noneOf(type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class);
            }
            try {
                return (Collection) cls.newInstance();
            } catch (Exception unused) {
                throw new IllegalArgumentException("create instane error, class " + cls.getName());
            }
        }
        return (Collection) invokeLL.objValue;
    }

    @Override // com.alipay.a.a.j
    public final Object a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (Iterable) obj) {
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
                Collection<Object> a2 = a(com.alipay.a.b.a.a(type), type);
                if (type instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    for (int i2 = 0; i2 < aVar.a(); i2++) {
                        a2.add(e.a(aVar.a(i2), type2));
                    }
                    return a2;
                }
                throw new IllegalArgumentException("Does not support the implement for generics.");
            }
            return null;
        }
        return invokeLL.objValue;
    }

    @Override // com.alipay.a.a.i, com.alipay.a.a.j
    public final boolean a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) ? Collection.class.isAssignableFrom(cls) : invokeL.booleanValue;
    }
}
