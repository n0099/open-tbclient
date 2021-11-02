package b.a.p0.a.k2.g;

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

    @Override // b.a.p0.a.k2.g.d
    public Bundle a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            Bundle bundle = new Bundle();
            b b2 = h.b(cVar.f6468a);
            if (b2 == null) {
                if (d.f6472a) {
                    throw new IllegalArgumentException("illegal sp.");
                }
                return bundle;
            }
            int i2 = cVar.f6469b;
            if (i2 == 1) {
                bundle.putInt("result_value", b2.getInt(cVar.f6470c, Integer.parseInt(cVar.f6471d)));
            } else if (i2 == 2) {
                bundle.putLong("result_value", b2.getLong(cVar.f6470c, Long.parseLong(cVar.f6471d)));
            } else if (i2 == 3) {
                bundle.putBoolean("result_value", b2.getBoolean(cVar.f6470c, Boolean.parseBoolean(cVar.f6471d)));
            } else if (i2 == 4) {
                bundle.putString("result_value", b2.getString(cVar.f6470c, cVar.f6471d));
            } else if (i2 != 5) {
                if (d.f6472a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                bundle.putFloat("result_value", b2.getFloat(cVar.f6470c, Float.parseFloat(cVar.f6471d)));
            }
            if (d.f6472a) {
                String str = "Get: " + cVar;
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
