package b.f.a.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static InterfaceC1463a f30699a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.f.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1463a {
        void a(String str, String str2);

        boolean a(String str);
    }

    public static InterfaceC1463a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f30699a : (InterfaceC1463a) invokeV.objValue;
    }

    public static void b(InterfaceC1463a interfaceC1463a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, interfaceC1463a) == null) {
            f30699a = interfaceC1463a;
        }
    }
}
