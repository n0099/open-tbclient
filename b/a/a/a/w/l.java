package b.a.a.a.w;

import b.a.a.a.r;
import b.a.a.a.u.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(h.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.a.a.w.b
    public p d(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            try {
                Field declaredField = obj.getClass().getDeclaredField("a");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 == null) {
                    return null;
                }
                Field declaredField2 = obj2.getClass().getDeclaredField("a");
                declaredField2.setAccessible(true);
                Object obj3 = declaredField2.get(obj2);
                if (obj3 == null) {
                    return null;
                }
                Field declaredField3 = obj3.getClass().getDeclaredField("b");
                declaredField3.setAccessible(true);
                Object obj4 = declaredField3.get(obj3);
                if (obj4 == null) {
                    return null;
                }
                Field declaredField4 = obj4.getClass().getDeclaredField("k");
                declaredField4.setAccessible(true);
                Object obj5 = declaredField4.get(obj4);
                if (obj5 == null) {
                    return null;
                }
                Field declaredField5 = obj5.getClass().getDeclaredField("E");
                declaredField5.setAccessible(true);
                JSONObject jSONObject = (JSONObject) declaredField5.get(obj5);
                if (jSONObject == null) {
                    return null;
                }
                return r.e(jSONObject);
            } catch (Exception e2) {
                b.a.a.a.x.d.c(e2);
                return null;
            }
        }
        return (p) invokeL.objValue;
    }
}
