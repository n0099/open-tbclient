package c.b.a;

import android.content.Context;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class w0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static v0 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (b.d()) {
                return new a1(new a0());
            }
            if (a0.b()) {
                return new a0();
            }
            if (z0.c()) {
                return new z0(context);
            }
            if (b.c(context)) {
                return new q0();
            }
            if (b.f()) {
                return new a1();
            }
            if (b.e()) {
                return new s0();
            }
            if (Build.VERSION.SDK_INT > 28) {
                if (b.g()) {
                    return new b1();
                }
                if (b.i()) {
                    return new t0();
                }
                if (b.h()) {
                    return new r0();
                }
                if (b.j()) {
                    return new d0();
                }
                return new m0();
            } else if (b.b() || !q0.c(context)) {
                return null;
            } else {
                return new q0();
            }
        }
        return (v0) invokeL.objValue;
    }
}
