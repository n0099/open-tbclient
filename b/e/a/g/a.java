package b.e.a.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static InterfaceC1505a f31557a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.e.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1505a {
        void a(String str, String str2);

        boolean a(String str);
    }

    public static InterfaceC1505a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f31557a : (InterfaceC1505a) invokeV.objValue;
    }

    public static void b(InterfaceC1505a interfaceC1505a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, interfaceC1505a) == null) {
            f31557a = interfaceC1505a;
        }
    }
}
