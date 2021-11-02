package b.a.p0.a.k2.g;

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

    @Override // b.a.p0.a.k2.g.d
    public Bundle a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            b b2 = h.b(cVar.f6468a);
            if (b2 == null) {
                if (!d.f6472a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i2 = cVar.f6469b;
            if (i2 == 1) {
                b2.putInt(cVar.f6470c, Integer.parseInt(cVar.f6471d));
            } else if (i2 == 2) {
                b2.putLong(cVar.f6470c, Long.parseLong(cVar.f6471d));
            } else if (i2 == 3) {
                b2.putBoolean(cVar.f6470c, Boolean.parseBoolean(cVar.f6471d));
            } else if (i2 == 4) {
                b2.putString(cVar.f6470c, cVar.f6471d);
            } else if (i2 != 5) {
                if (d.f6472a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                b2.putFloat(cVar.f6470c, Float.parseFloat(cVar.f6471d));
            }
            if (d.f6472a) {
                String str = "Put: " + cVar;
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
