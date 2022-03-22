package c.m.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class y5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ d1 a;

    public y5(d1 d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d1Var;
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && i == 1 && i2 == 0) {
            d1 d1Var = this.a;
            e1 e1Var = d1Var.f23421e;
            if (e1Var != null && !d1Var.f23422f && !d1Var.k && !d1.x) {
                if (e1Var != null) {
                    e1Var.e();
                    return;
                }
                return;
            }
            d1 d1Var2 = this.a;
            if (d1Var2.f23421e == null || d1Var2.f23422f || !d1Var2.k || d1.x) {
                return;
            }
            u uVar = d1Var2.f23418b.a;
            if (((uVar == null || !uVar.f()) ? -1 : uVar.f23582c.getOpent()) == 1) {
                d1 d1Var3 = this.a;
                if (d1Var3.f23421e == null || !d1Var3.r.isShown()) {
                    return;
                }
                this.a.f23421e.e();
            }
        }
    }
}
