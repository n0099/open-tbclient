package c.a.e.e.b.b.a.b;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<?> f2146a;

    public q(SparseArray<?> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sparseArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2146a = sparseArray;
    }

    @Override // c.a.e.e.b.b.a.b.h
    public Object a(c.a.e.e.b.b.a.e.c cVar) {
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

    @Override // c.a.e.e.b.b.a.b.h
    public Object b(c.a.e.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) ? this.f2146a : invokeL.objValue;
    }

    @Override // c.a.e.e.b.b.a.b.h
    public Object c(c.a.e.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) ? this.f2146a : invokeL.objValue;
    }

    @Override // c.a.e.e.b.b.a.b.h
    public Object d(c.a.e.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            Object f2 = f(cVar);
            if (f2 == null || !(f2 instanceof JSONObject)) {
                return null;
            }
            return f2.toString();
        }
        return invokeL.objValue;
    }

    @Override // c.a.e.e.b.b.a.b.h
    public Object e(c.a.e.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) ? d(cVar) : invokeL.objValue;
    }

    @Override // c.a.e.e.b.b.a.b.h
    public Object f(c.a.e.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            Type[] b2 = cVar.b();
            JSONObject jSONObject = new JSONObject();
            int size = this.f2146a.size();
            for (int i2 = 0; i2 < size; i2++) {
                int keyAt = this.f2146a.keyAt(i2);
                Object obj = this.f2146a.get(keyAt);
                if (obj != null) {
                    if (b2 != null && b2.length >= 1) {
                        Object f2 = c.a.e.e.b.b.a.e.f.a(obj).f(new c.a.e.e.b.b.a.e.c(b2[0]));
                        if (f2 != null) {
                            try {
                                jSONObject.put(String.valueOf(keyAt), f2);
                            } catch (JSONException unused) {
                            }
                        }
                    } else {
                        Object f3 = c.a.e.e.b.b.a.e.f.a(obj).f(new c.a.e.e.b.b.a.e.c(cVar.a()));
                        if (f3 != null) {
                            jSONObject.put(String.valueOf(keyAt), f3);
                        }
                    }
                }
            }
            return jSONObject;
        }
        return invokeL.objValue;
    }
}
