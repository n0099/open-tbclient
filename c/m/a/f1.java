package c.m.a;

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
/* loaded from: classes3.dex */
public class f1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s4 a;

    /* renamed from: b  reason: collision with root package name */
    public g1 f23438b;

    public f1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        s4 s4Var = new s4(context.getApplicationContext(), str);
        this.a = s4Var;
        s4Var.f23563h = new g(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            s4 s4Var = this.a;
            s4Var.f23560e = false;
            s4Var.f23558c = false;
            s4Var.f23559d = false;
            v4 v4Var = s4Var.i;
            if (v4Var != null) {
                v4Var.b();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            s4 s4Var = this.a;
            if (!s4Var.c()) {
                if (!(s4Var.f23559d && !s4Var.f23560e && s4Var.e() && !s4Var.f23561f.isShown() && s4Var.f23561f.isEffective())) {
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
            s4 s4Var = this.a;
            if (s4Var.e() && s4Var.f23561f.isEffective() && !s4Var.f23561f.isShown()) {
                s4Var.a(s4Var.f23561f);
                return;
            }
            if (s4Var.i == null) {
                s4Var.i = new v4(s4Var.f23557b, s4Var.a, L.f43987d);
            }
            s4Var.i.f23601g = new k4(s4Var);
            s4Var.i.g();
        }
    }

    public void d(g1 g1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, g1Var) == null) {
            this.f23438b = g1Var;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            s4 s4Var = this.a;
            if (!r0.H(s4Var.f23557b)) {
                g1 g1Var = s4Var.f23563h;
                if (g1Var != null) {
                    g1Var.d(PBError.NO_NETWORK.getMsg());
                }
            } else if (s4Var.g() && s4Var.c() && s4Var.e()) {
                s4Var.f23558c = false;
                v.b().d(v.c(s4Var.f23561f.getTraceid(), s4Var.f23561f.getId(), s4Var.f23561f.getPid()), s4Var.f23562g);
                s4Var.f23561f.setShown(true);
                r0.l(s4Var.f23557b, s4Var.f23561f);
                m0.a().c(v.c(s4Var.f23561f.getTraceid(), s4Var.f23561f.getId(), s4Var.a), s4Var.f23561f);
                H5Activity.a(s4Var.f23557b, s4Var.f23561f, s4Var.a);
                q0.b(s4Var.f23561f.getId() + s4Var.a, s4Var);
            }
        }
    }
}
