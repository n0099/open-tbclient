package c.q.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
/* loaded from: classes9.dex */
public class k4 implements q1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f30358b;

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
        this.f30358b = a5Var;
        this.a = 0L;
    }

    @Override // c.q.a.q1
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            y2 a = c3.a(this.f30358b.a);
            g3 g3Var = new g3(null);
            g3Var.a = this.f30358b.f30270b;
            a.g(g3Var, currentTimeMillis, i2, 0);
            a.m();
            this.f30358b.f30278j.removeMessages(100101);
            this.f30358b.f30272d = false;
            this.f30358b.d(this.f30358b.a(i2));
        }
    }

    @Override // c.q.a.q1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = System.currentTimeMillis();
            a5 a5Var = this.f30358b;
            a5Var.f30278j.sendEmptyMessageDelayed(100101, a5Var.f30274f * 1000);
        }
    }

    @Override // c.q.a.q1
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            j0 j0Var = (j0) obj;
            this.f30358b.f30278j.removeMessages(100101);
            this.f30358b.f30272d = false;
            int size = j0Var.a.size();
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            Info info = size > 0 ? (Info) j0Var.a.get(0) : null;
            y2 a = c3.a(this.f30358b.a);
            g3 g3Var = new g3(info);
            g3Var.a = this.f30358b.f30270b;
            a.g(g3Var, currentTimeMillis, 200, size);
            a.m();
            this.f30358b.c(j0Var);
            c4 c4Var = this.f30358b.f30271c;
            if (c4Var != null && !c4Var.d()) {
                a5 a5Var = this.f30358b;
                if (a5Var.f30276h) {
                    return;
                }
                Info c2 = a5Var.f30271c.c();
                if (c2 != null) {
                    this.f30358b.e(c2);
                    return;
                }
            }
            this.f30358b.d(PBError.NO_FILL);
        }
    }
}
