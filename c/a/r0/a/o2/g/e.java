package c.a.r0.a.o2.g;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.r0.a.o2.g.d
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
            int i2 = cVar.f8090b;
            if (i2 == 1) {
                bundle.putInt("result_value", b2.getInt(cVar.f8091c, Integer.parseInt(cVar.f8092d)));
            } else if (i2 == 2) {
                bundle.putLong("result_value", b2.getLong(cVar.f8091c, Long.parseLong(cVar.f8092d)));
            } else if (i2 == 3) {
                bundle.putBoolean("result_value", b2.getBoolean(cVar.f8091c, Boolean.parseBoolean(cVar.f8092d)));
            } else if (i2 == 4) {
                bundle.putString("result_value", b2.getString(cVar.f8091c, cVar.f8092d));
            } else if (i2 != 5) {
                if (d.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                bundle.putFloat("result_value", b2.getFloat(cVar.f8091c, Float.parseFloat(cVar.f8092d)));
            }
            if (d.a) {
                String str = "Get: " + cVar;
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
