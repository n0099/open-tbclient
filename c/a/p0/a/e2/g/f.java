package c.a.p0.a.e2.g;

import android.annotation.SuppressLint;
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

    @Override // c.a.p0.a.e2.g.d
    @SuppressLint({"BDThrowableCheck"})
    public Bundle a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            b b2 = h.b(cVar.a);
            if (b2 == null) {
                if (!d.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i2 = cVar.f5060b;
            if (i2 == 1) {
                b2.putInt(cVar.f5061c, Integer.parseInt(cVar.f5062d));
            } else if (i2 == 2) {
                b2.putLong(cVar.f5061c, Long.parseLong(cVar.f5062d));
            } else if (i2 == 3) {
                b2.putBoolean(cVar.f5061c, Boolean.parseBoolean(cVar.f5062d));
            } else if (i2 == 4) {
                b2.putString(cVar.f5061c, cVar.f5062d);
            } else if (i2 != 5) {
                if (d.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                b2.putFloat(cVar.f5061c, Float.parseFloat(cVar.f5062d));
            }
            if (d.a) {
                String str = "Put: " + cVar;
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
