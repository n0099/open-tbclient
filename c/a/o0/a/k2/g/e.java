package c.a.o0.a.k2.g;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // c.a.o0.a.k2.g.d
    public Bundle a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            Bundle bundle = new Bundle();
            b b2 = h.b(cVar.f7120a);
            if (b2 == null) {
                if (d.f7124a) {
                    throw new IllegalArgumentException("illegal sp.");
                }
                return bundle;
            }
            int i2 = cVar.f7121b;
            if (i2 == 1) {
                bundle.putInt("result_value", b2.getInt(cVar.f7122c, Integer.parseInt(cVar.f7123d)));
            } else if (i2 == 2) {
                bundle.putLong("result_value", b2.getLong(cVar.f7122c, Long.parseLong(cVar.f7123d)));
            } else if (i2 == 3) {
                bundle.putBoolean("result_value", b2.getBoolean(cVar.f7122c, Boolean.parseBoolean(cVar.f7123d)));
            } else if (i2 == 4) {
                bundle.putString("result_value", b2.getString(cVar.f7122c, cVar.f7123d));
            } else if (i2 != 5) {
                if (d.f7124a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                bundle.putFloat("result_value", b2.getFloat(cVar.f7122c, Float.parseFloat(cVar.f7123d)));
            }
            if (d.f7124a) {
                String str = "Get: " + cVar;
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
