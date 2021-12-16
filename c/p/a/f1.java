package c.p.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.L;
import com.win.opensdk.PBError;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes9.dex */
public class f1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x4 a;

    /* renamed from: b  reason: collision with root package name */
    public g1 f31152b;

    public f1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        x4 x4Var = new x4(context.getApplicationContext(), str);
        this.a = x4Var;
        x4Var.l = new g(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            x4 x4Var = this.a;
            x4Var.f31362i = false;
            x4Var.f31360g = false;
            x4Var.f31361h = false;
            a5 a5Var = x4Var.m;
            if (a5Var != null) {
                a5Var.b();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            x4 x4Var = this.a;
            if (!x4Var.c()) {
                if (!(x4Var.f31361h && !x4Var.f31362i && x4Var.e() && !x4Var.f31363j.isShown() && x4Var.f31363j.isEffective())) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            x4 x4Var = this.a;
            if (x4Var.e() && x4Var.f31363j.isEffective() && !x4Var.f31363j.isShown()) {
                x4Var.a(x4Var.f31363j);
                return;
            }
            if (x4Var.m == null) {
                x4Var.m = new a5(x4Var.f31359f, x4Var.f31358e, L.f63181d);
            }
            x4Var.m.f31108g = new p4(x4Var);
            x4Var.m.g();
        }
    }

    public void d(g1 g1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, g1Var) == null) {
            this.f31152b = g1Var;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            x4 x4Var = this.a;
            if (!r0.H(x4Var.f31359f)) {
                g1 g1Var = x4Var.l;
                if (g1Var != null) {
                    g1Var.d(PBError.NO_NETWORK.getMsg());
                }
            } else if (x4Var.g() && x4Var.c() && x4Var.e()) {
                x4Var.f31360g = false;
                v.b().d(v.c(x4Var.f31363j.getTraceid(), x4Var.f31363j.getId(), x4Var.f31363j.getPid()), x4Var.f31364k);
                x4Var.f31363j.setShown(true);
                r0.l(x4Var.f31359f, x4Var.f31363j);
                m0.a().c(v.c(x4Var.f31363j.getTraceid(), x4Var.f31363j.getId(), x4Var.f31358e), x4Var.f31363j);
                H5Activity.a(x4Var.f31359f, x4Var.f31363j, x4Var.f31358e);
                q0.b(x4Var.f31363j.getId() + x4Var.f31358e, x4Var);
            }
        }
    }
}
