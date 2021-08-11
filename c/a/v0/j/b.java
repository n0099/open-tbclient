package c.a.v0.j;

import c.a.v0.t.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.lang.reflect.Type;
/* loaded from: classes4.dex */
public class b implements a {
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

    @Override // c.a.v0.j.a
    public String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            try {
                if (c.a.v0.b.d().e() != null && c.a.v0.b.d().e().d() != null) {
                    return c.a.v0.b.d().e().d().a(obj);
                }
                return new Gson().toJson(obj);
            } catch (Exception e2) {
                i.b(e2.getMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.v0.j.a
    public <T> T b(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cls)) == null) {
            try {
                if (c.a.v0.b.d().e() != null && c.a.v0.b.d().e().d() != null) {
                    return (T) c.a.v0.b.d().e().d().b(str, cls);
                }
                return (T) new Gson().fromJson(str, (Class<Object>) cls);
            } catch (Exception e2) {
                i.b(e2.getMessage());
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    @Override // c.a.v0.j.a
    public <T> T c(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            try {
                if (c.a.v0.b.d().e() != null && c.a.v0.b.d().e().d() != null) {
                    return (T) c.a.v0.b.d().e().d().c(str, type);
                }
                return (T) new Gson().fromJson(str, type);
            } catch (Exception e2) {
                i.b(e2.getMessage());
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }
}
