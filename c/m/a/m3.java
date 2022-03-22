package c.m.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class m3 implements l1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ q3 a;

    public m3(q3 q3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = q3Var;
    }

    @Override // c.m.a.l1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // c.m.a.l1
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            t3 t3Var = this.a.a;
            long currentTimeMillis = System.currentTimeMillis();
            t3 t3Var2 = this.a.a;
            t3Var.f23580c = currentTimeMillis - t3Var2.f23579b;
            t2 a = x2.a(t3Var2.a);
            a.a(i, this.a.a.f23580c);
            a.m();
        }
    }

    @Override // c.m.a.l1
    public void a(Object obj) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            t3 t3Var = this.a.a;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.a.a.f23579b;
            t3Var.f23580c = currentTimeMillis - j;
            this.a.a.e((w5) obj);
        }
    }
}
