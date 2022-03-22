package c.m.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class j2 implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ p2 a;

    public j2(p2 p2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = p2Var;
    }

    @Override // c.m.a.r
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // c.m.a.r
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            p2 p2Var = this.a;
            if (v1.d(p2Var.f23529c, p2Var.f23534h)) {
                this.a.f23534h = System.currentTimeMillis();
                p2 p2Var2 = this.a;
                v1.a(p2Var2.a, str, p2Var2.f23529c, p2Var2.f23533g, str2);
                t2 a = x2.a(this.a.a);
                a.h(new b3(this.a.f23529c), str);
                a.l("desc", str2);
                a.m();
                d3 d3Var = this.a.f23532f;
                if (d3Var != null) {
                    d3Var.onClicked();
                }
                r0.p(this.a.f23529c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
