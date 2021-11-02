package b.q.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class o2 implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u2 f33426a;

    public o2(u2 u2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33426a = u2Var;
    }

    @Override // b.q.a.r
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // b.q.a.r
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            u2 u2Var = this.f33426a;
            if (a2.d(u2Var.f33520c, u2Var.f33525h)) {
                this.f33426a.f33525h = System.currentTimeMillis();
                u2 u2Var2 = this.f33426a;
                a2.a(u2Var2.f33518a, str, u2Var2.f33520c, u2Var2.f33524g, str2);
                y2 a2 = c3.a(this.f33426a.f33518a);
                a2.h(new g3(this.f33426a.f33520c), str);
                a2.l("desc", str2);
                a2.m();
                i3 i3Var = this.f33426a.f33523f;
                if (i3Var != null) {
                    i3Var.onClicked();
                }
                r0.p(this.f33426a.f33520c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
