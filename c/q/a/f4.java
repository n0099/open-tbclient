package c.q.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class f4 implements l1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v4 f28961b;

    public f4(v4 v4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28961b = v4Var;
        this.a = 0L;
    }

    @Override // c.q.a.l1
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            t2 a = x2.a(this.f28961b.a);
            b3 b3Var = new b3(null);
            b3Var.a = this.f28961b.f29153b;
            a.g(b3Var, currentTimeMillis, i2, 0);
            a.m();
            this.f28961b.f29161j.removeMessages(100101);
            this.f28961b.f29155d = false;
            this.f28961b.d(this.f28961b.a(i2));
        }
    }

    @Override // c.q.a.l1
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = System.currentTimeMillis();
            v4 v4Var = this.f28961b;
            v4Var.f29161j.sendEmptyMessageDelayed(100101, v4Var.f29157f * 1000);
        }
    }

    @Override // c.q.a.l1
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            j0 j0Var = (j0) obj;
            this.f28961b.f29161j.removeMessages(100101);
            this.f28961b.f29155d = false;
            int size = j0Var.a.size();
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            Info info = size > 0 ? (Info) j0Var.a.get(0) : null;
            t2 a = x2.a(this.f28961b.a);
            b3 b3Var = new b3(info);
            b3Var.a = this.f28961b.f29153b;
            a.g(b3Var, currentTimeMillis, 200, size);
            a.m();
            this.f28961b.c(j0Var);
            x3 x3Var = this.f28961b.f29154c;
            if (x3Var != null && !x3Var.d()) {
                v4 v4Var = this.f28961b;
                if (v4Var.f29159h) {
                    return;
                }
                Info c2 = v4Var.f29154c.c();
                if (c2 != null) {
                    this.f28961b.e(c2);
                    return;
                }
            }
            this.f28961b.d(PBError.NO_FILL);
        }
    }
}
