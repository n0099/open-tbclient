package c.a.n0.a.e2.g;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes.dex */
public class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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
            Bundle bundle = new Bundle();
            b b2 = h.b(cVar.a);
            if (b2 == null) {
                if (d.a) {
                    throw new IllegalArgumentException("illegal sp.");
                }
                return bundle;
            }
            int i = cVar.f4282b;
            if (i == 1) {
                bundle.putInt("result_value", b2.getInt(cVar.f4283c, Integer.parseInt(cVar.f4284d)));
            } else if (i == 2) {
                bundle.putLong("result_value", b2.getLong(cVar.f4283c, Long.parseLong(cVar.f4284d)));
            } else if (i == 3) {
                bundle.putBoolean("result_value", b2.getBoolean(cVar.f4283c, Boolean.parseBoolean(cVar.f4284d)));
            } else if (i == 4) {
                bundle.putString("result_value", b2.getString(cVar.f4283c, cVar.f4284d));
            } else if (i != 5) {
                if (d.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                bundle.putFloat("result_value", b2.getFloat(cVar.f4283c, Float.parseFloat(cVar.f4284d)));
            }
            if (d.a) {
                Log.d("SwanAppSpDelegation", "Get: " + cVar);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
