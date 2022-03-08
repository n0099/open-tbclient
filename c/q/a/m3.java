package c.q.a;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = q3Var;
    }

    @Override // c.q.a.l1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // c.q.a.l1
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            t3 t3Var = this.a.f29091e;
            long currentTimeMillis = System.currentTimeMillis();
            t3 t3Var2 = this.a.f29091e;
            t3Var.f29131c = currentTimeMillis - t3Var2.f29130b;
            t2 a = x2.a(t3Var2.a);
            a.a(i2, this.a.f29091e.f29131c);
            a.m();
        }
    }

    @Override // c.q.a.l1
    public void a(Object obj) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            t3 t3Var = this.a.f29091e;
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.a.f29091e.f29130b;
            t3Var.f29131c = currentTimeMillis - j2;
            this.a.f29091e.e((w5) obj);
        }
    }
}
