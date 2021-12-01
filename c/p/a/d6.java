package c.p.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ d1 a;

    public d6(d1 d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d1Var;
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) && i2 == 1 && i3 == 0) {
            d1 d1Var = this.a;
            e1 e1Var = d1Var.f30768e;
            if (e1Var != null && !d1Var.f30769f && !d1Var.f30774k && !d1.x) {
                if (e1Var != null) {
                    e1Var.e();
                    return;
                }
                return;
            }
            d1 d1Var2 = this.a;
            if (d1Var2.f30768e == null || d1Var2.f30769f || !d1Var2.f30774k || d1.x) {
                return;
            }
            u uVar = d1Var2.f30765b.a;
            if (((uVar == null || !uVar.f()) ? -1 : uVar.f30944c.getOpent()) == 1) {
                d1 d1Var3 = this.a;
                if (d1Var3.f30768e == null || !d1Var3.r.isShown()) {
                    return;
                }
                this.a.f30768e.e();
            }
        }
    }
}
