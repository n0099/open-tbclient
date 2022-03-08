package c.a.p0.a.d0.j;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import c.a.p0.a.d0.j.g.d;
import c.a.p0.a.d0.j.g.e;
import c.a.p0.a.d0.j.g.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static c.a.p0.a.d0.j.g.b a(@NonNull c.a.p0.a.d0.j.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            int i2 = aVar.a;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return new c.a.p0.a.d0.j.g.a(aVar);
                        }
                        return new e(aVar);
                    }
                    return new c.a.p0.a.d0.j.g.c(aVar);
                }
                return new f(aVar);
            }
            return new d(aVar);
        }
        return (c.a.p0.a.d0.j.g.b) invokeL.objValue;
    }
}
