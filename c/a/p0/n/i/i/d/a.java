package c.a.p0.n.i.i.d;

import c.a.p0.n.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    public Integer a(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            if (map != null && !map.isEmpty() && map.containsKey("queue_priority")) {
                try {
                    int intValue = ((Integer) map.get("queue_priority")).intValue();
                    if (intValue == 200 || intValue == 300) {
                        return Integer.valueOf(intValue);
                    }
                } catch (Exception e2) {
                    if (c.f11864a) {
                        e2.toString();
                        e2.printStackTrace();
                    }
                }
            }
            return 100;
        }
        return (Integer) invokeL.objValue;
    }
}
