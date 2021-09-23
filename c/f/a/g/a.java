package c.f.a.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static InterfaceC1468a f32299a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.f.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1468a {
        void a(String str, String str2);

        boolean a(String str);
    }

    public static InterfaceC1468a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f32299a : (InterfaceC1468a) invokeV.objValue;
    }

    public static void b(InterfaceC1468a interfaceC1468a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, interfaceC1468a) == null) {
            f32299a = interfaceC1468a;
        }
    }
}
