package b.q.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class k4 implements q1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f33373a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f33374b;

    public k4(a5 a5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33374b = a5Var;
        this.f33373a = 0L;
    }

    @Override // b.q.a.q1
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f33373a;
            y2 a2 = c3.a(this.f33374b.f33238a);
            g3 g3Var = new g3(null);
            g3Var.f33324a = this.f33374b.f33239b;
            a2.g(g3Var, currentTimeMillis, i2, 0);
            a2.m();
            this.f33374b.j.removeMessages(100101);
            this.f33374b.f33241d = false;
            this.f33374b.d(this.f33374b.a(i2));
        }
    }

    @Override // b.q.a.q1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f33373a = System.currentTimeMillis();
            a5 a5Var = this.f33374b;
            a5Var.j.sendEmptyMessageDelayed(100101, a5Var.f33243f * 1000);
        }
    }

    @Override // b.q.a.q1
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            j0 j0Var = (j0) obj;
            this.f33374b.j.removeMessages(100101);
            this.f33374b.f33241d = false;
            int size = j0Var.f33349a.size();
            long currentTimeMillis = System.currentTimeMillis() - this.f33373a;
            Info info = size > 0 ? (Info) j0Var.f33349a.get(0) : null;
            y2 a2 = c3.a(this.f33374b.f33238a);
            g3 g3Var = new g3(info);
            g3Var.f33324a = this.f33374b.f33239b;
            a2.g(g3Var, currentTimeMillis, 200, size);
            a2.m();
            this.f33374b.c(j0Var);
            c4 c4Var = this.f33374b.f33240c;
            if (c4Var != null && !c4Var.d()) {
                a5 a5Var = this.f33374b;
                if (a5Var.f33245h) {
                    return;
                }
                Info c2 = a5Var.f33240c.c();
                if (c2 != null) {
                    this.f33374b.e(c2);
                    return;
                }
            }
            this.f33374b.d(PBError.NO_FILL);
        }
    }
}
