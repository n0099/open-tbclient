package c.p.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.util.List;
/* loaded from: classes7.dex */
public class l5 implements q1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ p5 a;

    public l5(p5 p5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = p5Var;
    }

    @Override // c.p.a.q1
    public void a() {
        q1 q1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (q1Var = this.a.f30878e.f30942d) == null) {
            return;
        }
        q1Var.a();
    }

    @Override // c.p.a.q1
    public void a(int i2, String str) {
        q1 q1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (q1Var = this.a.f30878e.f30942d) == null) {
            return;
        }
        q1Var.a(i2, str);
    }

    @Override // c.p.a.q1
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            j0 a = x5.a(((b6) obj).f30758c, this.a.f30878e.a);
            t5 t5Var = this.a.f30878e;
            q1 q1Var = t5Var.f30942d;
            if (q1Var != null) {
                if (a == null) {
                    q1Var.a(101, "");
                } else if (!TextUtils.isEmpty(t5Var.f30940b) && this.a.f30878e.f30940b.equalsIgnoreCase(a.a())) {
                    this.a.f30878e.f30942d.a(a);
                    List<Info> list = a.a;
                    if (list != null) {
                        for (Info info : list) {
                            Context context = this.a.f30878e.a;
                            List material = info.getMaterial();
                            if (!material.isEmpty()) {
                                p2.b(context, r0.I(context), material, new f2(context, info));
                            }
                        }
                    }
                } else {
                    this.a.f30878e.f30942d.a(2003, "");
                }
            }
        }
    }
}
