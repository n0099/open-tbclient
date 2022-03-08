package c.q.a;

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
    public g1 f28958b;

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
        s4 s4Var = new s4(context.getApplicationContext(), str);
        this.a = s4Var;
        s4Var.l = new g(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            s4 s4Var = this.a;
            s4Var.f29110i = false;
            s4Var.f29108g = false;
            s4Var.f29109h = false;
            v4 v4Var = s4Var.m;
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
                if (!(s4Var.f29109h && !s4Var.f29110i && s4Var.e() && !s4Var.f29111j.isShown() && s4Var.f29111j.isEffective())) {
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
            if (s4Var.e() && s4Var.f29111j.isEffective() && !s4Var.f29111j.isShown()) {
                s4Var.a(s4Var.f29111j);
                return;
            }
            if (s4Var.m == null) {
                s4Var.m = new v4(s4Var.f29107f, s4Var.f29106e, L.f59359d);
            }
            s4Var.m.f29158g = new k4(s4Var);
            s4Var.m.g();
        }
    }

    public void d(g1 g1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, g1Var) == null) {
            this.f28958b = g1Var;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            s4 s4Var = this.a;
            if (!r0.H(s4Var.f29107f)) {
                g1 g1Var = s4Var.l;
                if (g1Var != null) {
                    g1Var.d(PBError.NO_NETWORK.getMsg());
                }
            } else if (s4Var.g() && s4Var.c() && s4Var.e()) {
                s4Var.f29108g = false;
                v.b().d(v.c(s4Var.f29111j.getTraceid(), s4Var.f29111j.getId(), s4Var.f29111j.getPid()), s4Var.k);
                s4Var.f29111j.setShown(true);
                r0.l(s4Var.f29107f, s4Var.f29111j);
                m0.a().c(v.c(s4Var.f29111j.getTraceid(), s4Var.f29111j.getId(), s4Var.f29106e), s4Var.f29111j);
                H5Activity.a(s4Var.f29107f, s4Var.f29111j, s4Var.f29106e);
                q0.b(s4Var.f29111j.getId() + s4Var.f29106e, s4Var);
            }
        }
    }
}
