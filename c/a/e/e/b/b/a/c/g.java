package c.a.e.e.b.b.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Message f2097a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f2098b;

    public g(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {message};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2097a = message;
        List<Field> b2 = c.a.e.e.b.a.a.b(message.getClass());
        this.f2098b = new HashSet();
        if (b2 == null || b2.size() <= 0) {
            return;
        }
        for (Field field : b2) {
            if (field != null) {
                this.f2098b.add(field.getName());
            }
        }
    }

    @Override // c.a.e.e.b.b.a.c.c
    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2098b : (Set) invokeV.objValue;
    }

    @Override // c.a.e.e.b.b.a.c.c
    public void b(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            c.a.e.e.b.a.a.h(this.f2097a, str, obj);
        }
    }

    @Override // c.a.e.e.b.b.a.c.c
    public Object c(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            Object d2 = d(str);
            if (d2 != null) {
                c.a.e.e.b.b.a.e.c cVar = new c.a.e.e.b.b.a.e.c(type);
                c.a.e.e.b.b.a.d.h a2 = c.a.e.e.b.b.a.e.g.a(d2);
                return a2 != null ? a2.a(cVar) : d2;
            }
            return d2;
        }
        return invokeLL.objValue;
    }

    public Object d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? c.a.e.e.b.a.a.d(this.f2097a, str) : invokeL.objValue;
    }
}
