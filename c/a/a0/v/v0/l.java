package c.a.a0.v.v0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmName;
@JvmName(name = "LayerUtils")
/* loaded from: classes.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(942380017, "Lc/a/a0/v/v0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(942380017, "Lc/a/a0/v/v0/l;");
                return;
            }
        }
        c.a.a0.i0.a.d.b.a(253.0f);
        c.a.a0.i0.a.d.b.a(9.0f);
    }

    public static final c.a.a0.v.j0.f a(ArrayList<c.a.a0.v.j0.b> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<c.a.a0.v.j0.b> it = arrayList.iterator();
                while (it.hasNext()) {
                    c.a.a0.v.j0.b next = it.next();
                    if (next instanceof c.a.a0.v.j0.f) {
                        return (c.a.a0.v.j0.f) next;
                    }
                }
                return null;
            }
            return null;
        }
        return (c.a.a0.v.j0.f) invokeL.objValue;
    }
}
