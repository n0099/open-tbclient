package b.o.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d1 f34127a;

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
        this.f34127a = d1Var;
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) && i2 == 1 && i3 == 0) {
            d1 d1Var = this.f34127a;
            e1 e1Var = d1Var.f34118e;
            if (e1Var != null && !d1Var.f34119f && !d1Var.k && !d1.x) {
                if (e1Var != null) {
                    e1Var.e();
                    return;
                }
                return;
            }
            d1 d1Var2 = this.f34127a;
            if (d1Var2.f34118e == null || d1Var2.f34119f || !d1Var2.k || d1.x) {
                return;
            }
            u uVar = d1Var2.f34115b.f34253a;
            if (((uVar == null || !uVar.f()) ? -1 : uVar.f34338c.getOpent()) == 1) {
                d1 d1Var3 = this.f34127a;
                if (d1Var3.f34118e == null || !d1Var3.r.isShown()) {
                    return;
                }
                this.f34127a.f34118e.e();
            }
        }
    }
}
