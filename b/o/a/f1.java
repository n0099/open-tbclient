package b.o.a;

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
/* loaded from: classes6.dex */
public class f1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public x4 f34139a;

    /* renamed from: b  reason: collision with root package name */
    public g1 f34140b;

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
        this.f34139a = x4Var;
        x4Var.l = new g(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            x4 x4Var = this.f34139a;
            x4Var.f34397i = false;
            x4Var.f34395g = false;
            x4Var.f34396h = false;
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
            x4 x4Var = this.f34139a;
            if (!x4Var.c()) {
                if (!(x4Var.f34396h && !x4Var.f34397i && x4Var.e() && !x4Var.j.isShown() && x4Var.j.isEffective())) {
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
            x4 x4Var = this.f34139a;
            if (x4Var.e() && x4Var.j.isEffective() && !x4Var.j.isShown()) {
                x4Var.a(x4Var.j);
                return;
            }
            if (x4Var.m == null) {
                x4Var.m = new a5(x4Var.f34394f, x4Var.f34393e, L.f71374d);
            }
            x4Var.m.f34078g = new p4(x4Var);
            x4Var.m.g();
        }
    }

    public void d(g1 g1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, g1Var) == null) {
            this.f34140b = g1Var;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            x4 x4Var = this.f34139a;
            if (!r0.H(x4Var.f34394f)) {
                g1 g1Var = x4Var.l;
                if (g1Var != null) {
                    g1Var.d(PBError.NO_NETWORK.getMsg());
                }
            } else if (x4Var.g() && x4Var.c() && x4Var.e()) {
                x4Var.f34395g = false;
                v.b().d(v.c(x4Var.j.getTraceid(), x4Var.j.getId(), x4Var.j.getPid()), x4Var.k);
                x4Var.j.setShown(true);
                r0.l(x4Var.f34394f, x4Var.j);
                m0.a().c(v.c(x4Var.j.getTraceid(), x4Var.j.getId(), x4Var.f34393e), x4Var.j);
                H5Activity.a(x4Var.f34394f, x4Var.j, x4Var.f34393e);
                q0.b(x4Var.j.getId() + x4Var.f34393e, x4Var);
            }
        }
    }
}
