package c.p.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class r3 implements q1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ v3 a;

    public r3(v3 v3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = v3Var;
    }

    @Override // c.p.a.q1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // c.p.a.q1
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            y3 y3Var = this.a.f31346e;
            long currentTimeMillis = System.currentTimeMillis();
            y3 y3Var2 = this.a.f31346e;
            y3Var.f31382c = currentTimeMillis - y3Var2.f31381b;
            y2 a = c3.a(y3Var2.a);
            a.a(i2, this.a.f31346e.f31382c);
            a.m();
        }
    }

    @Override // c.p.a.q1
    public void a(Object obj) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            y3 y3Var = this.a.f31346e;
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.a.f31346e.f31381b;
            y3Var.f31382c = currentTimeMillis - j2;
            this.a.f31346e.e((b6) obj);
        }
    }
}
