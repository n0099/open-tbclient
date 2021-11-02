package b.q.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.util.List;
/* loaded from: classes6.dex */
public class l5 implements q1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p5 f33393a;

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
        this.f33393a = p5Var;
    }

    @Override // b.q.a.q1
    public void a() {
        q1 q1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (q1Var = this.f33393a.f33436e.f33501d) == null) {
            return;
        }
        q1Var.a();
    }

    @Override // b.q.a.q1
    public void a(int i2, String str) {
        q1 q1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (q1Var = this.f33393a.f33436e.f33501d) == null) {
            return;
        }
        q1Var.a(i2, str);
    }

    @Override // b.q.a.q1
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            j0 a2 = x5.a(((b6) obj).f33265c, this.f33393a.f33436e.f33498a);
            t5 t5Var = this.f33393a.f33436e;
            q1 q1Var = t5Var.f33501d;
            if (q1Var != null) {
                if (a2 == null) {
                    q1Var.a(101, "");
                } else if (!TextUtils.isEmpty(t5Var.f33499b) && this.f33393a.f33436e.f33499b.equalsIgnoreCase(a2.a())) {
                    this.f33393a.f33436e.f33501d.a(a2);
                    List<Info> list = a2.f33349a;
                    if (list != null) {
                        for (Info info : list) {
                            Context context = this.f33393a.f33436e.f33498a;
                            List material = info.getMaterial();
                            if (!material.isEmpty()) {
                                p2.b(context, r0.I(context), material, new f2(context, info));
                            }
                        }
                    }
                } else {
                    this.f33393a.f33436e.f33501d.a(2003, "");
                }
            }
        }
    }
}
