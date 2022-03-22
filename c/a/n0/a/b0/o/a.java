package c.a.n0.a.b0.o;

import android.annotation.SuppressLint;
import c.a.n0.a.b0.d;
import c.a.n0.a.b0.h;
import c.a.n0.a.b0.i;
import c.a.n0.a.s0.b;
import c.a.n0.a.x.k.e;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.n0.a.b0.d
    @SuppressLint({"BDThrowableCheck"})
    public i a(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hVar)) == null) {
            int type = hVar.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!c.a.n0.a.a.a) {
                            return new c.a.n0.a.c0.a();
                        }
                        throw new IllegalArgumentException("invalid model object:" + hVar);
                    }
                    return new e();
                }
                return b.b();
            }
            return new c.a.n0.a.c0.a();
        }
        return (i) invokeL.objValue;
    }
}
