package c.a.w.e.d;

import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static INetWork f30587a;
    public transient /* synthetic */ FieldHolder $fh;

    public static INetWork a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f30587a : (INetWork) invokeV.objValue;
    }

    public static void b(INetWork iNetWork) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, iNetWork) == null) {
            f30587a = iNetWork;
        }
    }
}
