package c.f.a.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static InterfaceC1640a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.f.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1640a {
        void a(String str, String str2);

        boolean a(String str);
    }

    public static InterfaceC1640a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a : (InterfaceC1640a) invokeV.objValue;
    }

    public static void b(InterfaceC1640a interfaceC1640a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, interfaceC1640a) == null) {
            a = interfaceC1640a;
        }
    }
}
