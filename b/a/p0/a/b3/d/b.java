package b.a.p0.a.b3.d;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static d f4170a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (f4170a == null) {
                f4170a = new d("0");
            }
            return f4170a;
        }
        return (d) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            d dVar = f4170a;
            if (dVar == null) {
                f4170a = new d(str);
            } else {
                dVar.n(str);
            }
        }
    }
}
