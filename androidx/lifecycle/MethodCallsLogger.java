package androidx.lifecycle;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class MethodCallsLogger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Integer> mCalledMethods;

    public MethodCallsLogger() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCalledMethods = new HashMap();
    }

    public boolean approveCall(String str, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            Integer num = this.mCalledMethods.get(str);
            boolean z = false;
            if (num != null) {
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            if ((i2 & i) != 0) {
                z = true;
            }
            this.mCalledMethods.put(str, Integer.valueOf(i | i2));
            return !z;
        }
        return invokeLI.booleanValue;
    }
}
