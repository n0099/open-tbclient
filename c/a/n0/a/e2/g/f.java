package c.a.n0.a.e2.g;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.n0.a.e2.g.d
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
            int i = cVar.f4282b;
            if (i == 1) {
                b2.putInt(cVar.f4283c, Integer.parseInt(cVar.f4284d));
            } else if (i == 2) {
                b2.putLong(cVar.f4283c, Long.parseLong(cVar.f4284d));
            } else if (i == 3) {
                b2.putBoolean(cVar.f4283c, Boolean.parseBoolean(cVar.f4284d));
            } else if (i == 4) {
                b2.putString(cVar.f4283c, cVar.f4284d);
            } else if (i != 5) {
                if (d.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                b2.putFloat(cVar.f4283c, Float.parseFloat(cVar.f4284d));
            }
            if (d.a) {
                Log.d("SwanAppSpDelegation", "Put: " + cVar);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
