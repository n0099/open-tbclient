package b.o.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static v f34366b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f34367a;

    public v() {
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
        this.f34367a = new ConcurrentHashMap();
    }

    public static v b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f34366b == null) {
                synchronized (v.class) {
                    if (f34366b == null) {
                        f34366b = new v();
                    }
                }
            }
            return f34366b;
        }
        return (v) invokeV.objValue;
    }

    public static String c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (str.length() > 16) {
                str = str.substring(0, 16);
            }
            return str + str2 + str3;
        }
        return (String) invokeLLL.objValue;
    }

    public n a(String str) {
        InterceptResult invokeL;
        n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (v.class) {
                nVar = (n) this.f34367a.remove(str);
            }
            return nVar;
        }
        return (n) invokeL.objValue;
    }

    public void d(String str, n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, nVar) == null) {
            synchronized (v.class) {
                this.f34367a.put(str, nVar);
            }
        }
    }
}
