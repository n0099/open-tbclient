package c.a.r0.a.l0.o;

import android.annotation.SuppressLint;
import c.a.r0.a.c1.b;
import c.a.r0.a.h0.k.e;
import c.a.r0.a.k;
import c.a.r0.a.l0.d;
import c.a.r0.a.l0.h;
import c.a.r0.a.l0.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // c.a.r0.a.l0.d
    @SuppressLint({"BDThrowableCheck"})
    public i a(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVar)) == null) {
            int type = hVar.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!k.a) {
                            return new c.a.r0.a.m0.a();
                        }
                        throw new IllegalArgumentException("invalid model object:" + hVar);
                    }
                    return new e();
                }
                return b.b();
            }
            return new c.a.r0.a.m0.a();
        }
        return (i) invokeL.objValue;
    }
}
