package c.q.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.util.List;
/* loaded from: classes3.dex */
public class g5 implements l1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ k5 a;

    public g5(k5 k5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = k5Var;
    }

    @Override // c.q.a.l1
    public void a() {
        l1 l1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (l1Var = this.a.f29007e.f29066d) == null) {
            return;
        }
        l1Var.a();
    }

    @Override // c.q.a.l1
    public void a(int i2, String str) {
        l1 l1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (l1Var = this.a.f29007e.f29066d) == null) {
            return;
        }
        l1Var.a(i2, str);
    }

    @Override // c.q.a.l1
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            j0 a = s5.a(((w5) obj).f29167c, this.a.f29007e.a);
            o5 o5Var = this.a.f29007e;
            l1 l1Var = o5Var.f29066d;
            if (l1Var != null) {
                if (a == null) {
                    l1Var.a(101, "");
                } else if (!TextUtils.isEmpty(o5Var.f29064b) && this.a.f29007e.f29064b.equalsIgnoreCase(a.a())) {
                    this.a.f29007e.f29066d.a(a);
                    List<Info> list = a.a;
                    if (list != null) {
                        for (Info info : list) {
                            Context context = this.a.f29007e.a;
                            List material = info.getMaterial();
                            if (!material.isEmpty()) {
                                k2.b(context, r0.I(context), material, new a2(context, info));
                            }
                        }
                    }
                } else {
                    this.a.f29007e.f29066d.a(2003, "");
                }
            }
        }
    }
}
