package c.q.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
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

    @Override // c.q.a.r
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // c.q.a.r
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            u uVar = this.a;
            if (v1.d(uVar.f29133c, uVar.f29138h)) {
                this.a.f29138h = System.currentTimeMillis();
                u uVar2 = this.a;
                v1.a(uVar2.a, str, uVar2.f29133c, uVar2.f29137g, str2);
                t2 a = x2.a(this.a.a);
                a.h(new b3(this.a.f29133c), str);
                a.l("desc", str2);
                a.m();
                s sVar = this.a.f29136f;
                if (sVar != null) {
                    sVar.onClicked();
                }
                r0.p(this.a.f29133c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
