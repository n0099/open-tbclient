package b.o.a;

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
    public final /* synthetic */ u2 f34260a;

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
        this.f34260a = u2Var;
    }

    @Override // b.o.a.r
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // b.o.a.r
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            u2 u2Var = this.f34260a;
            if (a2.d(u2Var.f34354c, u2Var.f34359h)) {
                this.f34260a.f34359h = System.currentTimeMillis();
                u2 u2Var2 = this.f34260a;
                a2.a(u2Var2.f34352a, str, u2Var2.f34354c, u2Var2.f34358g, str2);
                y2 a2 = c3.a(this.f34260a.f34352a);
                a2.h(new g3(this.f34260a.f34354c), str);
                a2.l("desc", str2);
                a2.m();
                i3 i3Var = this.f34260a.f34357f;
                if (i3Var != null) {
                    i3Var.onClicked();
                }
                r0.p(this.f34260a.f34354c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
