package c.a.d.f.b.b.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;

    public e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jSONObject;
    }

    @Override // c.a.d.f.b.b.a.c.c
    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            try {
                this.a.putOpt(str, obj);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.a.d.f.b.b.a.c.c
    public Object b(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, type)) == null) {
            Object c2 = c(str);
            if (c2 != null) {
                c.a.d.f.b.b.a.e.c cVar = new c.a.d.f.b.b.a.e.c(type);
                c.a.d.f.b.b.a.d.h a = c.a.d.f.b.b.a.e.g.a(c2);
                return a != null ? a.a(cVar) : c2;
            }
            return c2;
        }
        return invokeLL.objValue;
    }

    public Object c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.a.opt(str) : invokeL.objValue;
    }

    @Override // c.a.d.f.b.b.a.c.c
    public Set<String> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Iterator<String> keys = this.a.keys();
            if (keys != null) {
                HashSet hashSet = new HashSet();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null) {
                        hashSet.add(next.toString());
                    }
                }
                return hashSet;
            }
            return null;
        }
        return (Set) invokeV.objValue;
    }
}
