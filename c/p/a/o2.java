package c.p.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o2 implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ u2 a;

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
        this.a = u2Var;
    }

    @Override // c.p.a.r
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // c.p.a.r
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            u2 u2Var = this.a;
            if (a2.d(u2Var.f30959c, u2Var.f30964h)) {
                this.a.f30964h = System.currentTimeMillis();
                u2 u2Var2 = this.a;
                a2.a(u2Var2.a, str, u2Var2.f30959c, u2Var2.f30963g, str2);
                y2 a = c3.a(this.a.a);
                a.h(new g3(this.a.f30959c), str);
                a.l("desc", str2);
                a.m();
                i3 i3Var = this.a.f30962f;
                if (i3Var != null) {
                    i3Var.onClicked();
                }
                r0.p(this.a.f30959c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
