package c.f.a.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static InterfaceC1641a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.f.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1641a {
        void a(String str, String str2);

        boolean a(String str);
    }

    public static InterfaceC1641a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a : (InterfaceC1641a) invokeV.objValue;
    }

    public static void b(InterfaceC1641a interfaceC1641a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, interfaceC1641a) == null) {
            a = interfaceC1641a;
        }
    }
}
