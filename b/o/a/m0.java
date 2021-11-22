package b.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class m0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static m0 f34229b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f34230a;

    public m0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34230a = new ConcurrentHashMap();
    }

    public static m0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f34229b == null) {
                synchronized (m0.class) {
                    if (f34229b == null) {
                        f34229b = new m0();
                    }
                }
            }
            return f34229b;
        }
        return (m0) invokeV.objValue;
    }

    public Info b(String str) {
        InterceptResult invokeL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (m0.class) {
                info = (Info) this.f34230a.remove(str);
            }
            return info;
        }
        return (Info) invokeL.objValue;
    }

    public void c(String str, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, info) == null) {
            synchronized (m0.class) {
                this.f34230a.put(str, info);
            }
        }
    }
}
