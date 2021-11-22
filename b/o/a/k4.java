package b.o.a;

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
    public long f34207a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f34208b;

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
        this.f34208b = a5Var;
        this.f34207a = 0L;
    }

    @Override // b.o.a.q1
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f34207a;
            y2 a2 = c3.a(this.f34208b.f34072a);
            g3 g3Var = new g3(null);
            g3Var.f34158a = this.f34208b.f34073b;
            a2.g(g3Var, currentTimeMillis, i2, 0);
            a2.m();
            this.f34208b.j.removeMessages(100101);
            this.f34208b.f34075d = false;
            this.f34208b.d(this.f34208b.a(i2));
        }
    }

    @Override // b.o.a.q1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f34207a = System.currentTimeMillis();
            a5 a5Var = this.f34208b;
            a5Var.j.sendEmptyMessageDelayed(100101, a5Var.f34077f * 1000);
        }
    }

    @Override // b.o.a.q1
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            j0 j0Var = (j0) obj;
            this.f34208b.j.removeMessages(100101);
            this.f34208b.f34075d = false;
            int size = j0Var.f34183a.size();
            long currentTimeMillis = System.currentTimeMillis() - this.f34207a;
            Info info = size > 0 ? (Info) j0Var.f34183a.get(0) : null;
            y2 a2 = c3.a(this.f34208b.f34072a);
            g3 g3Var = new g3(info);
            g3Var.f34158a = this.f34208b.f34073b;
            a2.g(g3Var, currentTimeMillis, 200, size);
            a2.m();
            this.f34208b.c(j0Var);
            c4 c4Var = this.f34208b.f34074c;
            if (c4Var != null && !c4Var.d()) {
                a5 a5Var = this.f34208b;
                if (a5Var.f34079h) {
                    return;
                }
                Info c2 = a5Var.f34074c.c();
                if (c2 != null) {
                    this.f34208b.e(c2);
                    return;
                }
            }
            this.f34208b.d(PBError.NO_FILL);
        }
    }
}
