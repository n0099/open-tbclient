package c.a.p0.a.k2.g;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.p0.a.k2.g.d
    public Bundle a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            b b2 = h.b(cVar.f7156a);
            if (b2 == null) {
                if (!d.f7160a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i2 = cVar.f7157b;
            if (i2 == 1) {
                b2.putInt(cVar.f7158c, Integer.parseInt(cVar.f7159d));
            } else if (i2 == 2) {
                b2.putLong(cVar.f7158c, Long.parseLong(cVar.f7159d));
            } else if (i2 == 3) {
                b2.putBoolean(cVar.f7158c, Boolean.parseBoolean(cVar.f7159d));
            } else if (i2 == 4) {
                b2.putString(cVar.f7158c, cVar.f7159d);
            } else if (i2 != 5) {
                if (d.f7160a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                b2.putFloat(cVar.f7158c, Float.parseFloat(cVar.f7159d));
            }
            if (d.f7160a) {
                String str = "Put: " + cVar;
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
