package b.a.e.e.b.b.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Object f1613a;

    public a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (obj == null || !obj.getClass().isArray()) {
            return;
        }
        this.f1613a = obj;
    }

    @Override // b.a.e.e.b.b.a.b.h
    public Object a(b.a.e.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            Object f2 = f(cVar);
            if (f2 != null) {
                if (f2 instanceof JSONObject) {
                    return f2.toString();
                }
                return f2 instanceof JSONArray ? f2.toString() : f2;
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // b.a.e.e.b.b.a.b.h
    public Object b(b.a.e.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) ? this.f1613a : invokeL.objValue;
    }

    @Override // b.a.e.e.b.b.a.b.h
    public Object c(b.a.e.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) ? this.f1613a : invokeL.objValue;
    }

    @Override // b.a.e.e.b.b.a.b.h
    public Object d(b.a.e.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            Object obj = this.f1613a;
            if (obj != null) {
                Class<?> componentType = obj.getClass().getComponentType();
                if (componentType == Boolean.TYPE) {
                    return this.f1613a;
                }
                if (componentType == Byte.TYPE) {
                    return this.f1613a;
                }
                if (componentType == Character.TYPE) {
                    return this.f1613a;
                }
                if (componentType == Double.TYPE) {
                    return this.f1613a;
                }
                if (componentType == Float.TYPE) {
                    return this.f1613a;
                }
                if (componentType == Integer.TYPE) {
                    return this.f1613a;
                }
                if (componentType == Long.TYPE) {
                    return this.f1613a;
                }
                if (componentType == Short.TYPE) {
                    return this.f1613a;
                }
                if (componentType == String.class) {
                    return this.f1613a;
                }
                int length = Array.getLength(this.f1613a);
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < length; i2++) {
                    Object f2 = b.a.e.e.b.b.a.e.f.a(Array.get(this.f1613a, i2)).f(new b.a.e.e.b.b.a.e.c(componentType));
                    if (f2 != null) {
                        jSONArray.put(f2);
                    }
                }
                return jSONArray.toString();
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // b.a.e.e.b.b.a.b.h
    public Object e(b.a.e.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) ? d(cVar) : invokeL.objValue;
    }

    @Override // b.a.e.e.b.b.a.b.h
    public Object f(b.a.e.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            Object obj = this.f1613a;
            if (obj != null) {
                Class<?> componentType = obj.getClass().getComponentType();
                if (componentType == Character.TYPE) {
                    return String.valueOf((char[]) this.f1613a);
                }
                if (componentType == Byte.TYPE) {
                    try {
                        b.a.e.e.p.c.k((byte[]) this.f1613a, 0);
                    } catch (Exception unused) {
                        return null;
                    }
                } else {
                    int length = Array.getLength(this.f1613a);
                    JSONArray jSONArray = new JSONArray();
                    for (int i2 = 0; i2 < length; i2++) {
                        Object f2 = b.a.e.e.b.b.a.e.f.a(Array.get(this.f1613a, i2)).f(new b.a.e.e.b.b.a.e.c(componentType));
                        if (f2 != null) {
                            jSONArray.put(f2);
                        }
                    }
                    return jSONArray;
                }
            }
            return null;
        }
        return invokeL.objValue;
    }
}
