package c.m.a;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = k5Var;
    }

    @Override // c.m.a.l1
    public void a() {
        l1 l1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (l1Var = this.a.a.f23525d) == null) {
            return;
        }
        l1Var.a();
    }

    @Override // c.m.a.l1
    public void a(int i, String str) {
        l1 l1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (l1Var = this.a.a.f23525d) == null) {
            return;
        }
        l1Var.a(i, str);
    }

    @Override // c.m.a.l1
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            j0 a = s5.a(((w5) obj).f23605c, this.a.a.a);
            o5 o5Var = this.a.a;
            l1 l1Var = o5Var.f23525d;
            if (l1Var != null) {
                if (a == null) {
                    l1Var.a(101, "");
                } else if (!TextUtils.isEmpty(o5Var.f23523b) && this.a.a.f23523b.equalsIgnoreCase(a.a())) {
                    this.a.a.f23525d.a(a);
                    List<Info> list = a.a;
                    if (list != null) {
                        for (Info info : list) {
                            Context context = this.a.a.a;
                            List material = info.getMaterial();
                            if (!material.isEmpty()) {
                                k2.b(context, r0.I(context), material, new a2(context, info));
                            }
                        }
                    }
                } else {
                    this.a.a.f23525d.a(2003, "");
                }
            }
        }
    }
}
