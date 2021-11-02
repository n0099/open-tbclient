package b.q.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class r3 implements q1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v3 f33454a;

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
        this.f33454a = v3Var;
    }

    @Override // b.q.a.q1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // b.q.a.q1
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            y3 y3Var = this.f33454a.f33539e;
            long currentTimeMillis = System.currentTimeMillis();
            y3 y3Var2 = this.f33454a.f33539e;
            y3Var.f33585c = currentTimeMillis - y3Var2.f33584b;
            y2 a2 = c3.a(y3Var2.f33583a);
            a2.a(i2, this.f33454a.f33539e.f33585c);
            a2.m();
        }
    }

    @Override // b.q.a.q1
    public void a(Object obj) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            y3 y3Var = this.f33454a.f33539e;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.f33454a.f33539e.f33584b;
            y3Var.f33585c = currentTimeMillis - j;
            this.f33454a.f33539e.e((b6) obj);
        }
    }
}
