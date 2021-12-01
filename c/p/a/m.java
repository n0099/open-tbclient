package c.p.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class m implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ u a;

    public m(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = uVar;
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
            u uVar = this.a;
            if (a2.d(uVar.f30944c, uVar.f30949h)) {
                this.a.f30949h = System.currentTimeMillis();
                u uVar2 = this.a;
                a2.a(uVar2.a, str, uVar2.f30944c, uVar2.f30948g, str2);
                y2 a = c3.a(this.a.a);
                a.h(new g3(this.a.f30944c), str);
                a.l("desc", str2);
                a.m();
                s sVar = this.a.f30947f;
                if (sVar != null) {
                    sVar.onClicked();
                }
                r0.p(this.a.f30944c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
