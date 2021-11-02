package b.a.p0.a.i1.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e0.d;
import b.a.p0.a.p.d.c1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements b.a.p0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c1 f6203a;

    /* renamed from: b  reason: collision with root package name */
    public String f6204b;

    /* renamed from: c  reason: collision with root package name */
    public c f6205c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6206d;

    /* renamed from: e  reason: collision with root package name */
    public Context f6207e;

    public a(Context context, @NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6207e = context;
        this.f6205c = cVar;
        this.f6204b = cVar.n;
        e();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f6204b)) {
            return;
        }
        b.a.p0.a.i1.b.a(this);
    }

    @Override // b.a.p0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6205c.f4057g : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6204b : (String) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6205c : (c) invokeV.objValue;
    }

    public c1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f6203a == null) {
                d.g("VrVideo", "create player");
                this.f6203a = b.a.p0.a.c1.a.s0().create();
            }
            return this.f6203a;
        }
        return (c1) invokeV.objValue;
    }

    @Override // b.a.p0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.f6205c;
            return cVar != null ? cVar.x : "";
        }
        return (String) invokeV.objValue;
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            d.g("VrVideo", "Open Player " + cVar.n);
            c1 c1Var = this.f6203a;
            if (c1Var != null) {
                c1Var.e(cVar, this.f6207e);
            }
            this.f6205c = cVar;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            d.a("VrVideo", "update 接口");
            c1 c1Var = this.f6203a;
            if (c1Var != null) {
                c1Var.d(cVar, true);
            }
            this.f6205c = cVar;
        }
    }

    @Override // b.a.p0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : invokeV.objValue;
    }

    @Override // b.a.p0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // b.a.p0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                if (this.f6206d) {
                    e().resume();
                }
                e().b();
            } else if (this.f6203a != null) {
                this.f6206d = e().isPlaying();
                e().pause();
                e().c();
            }
        }
    }

    @Override // b.a.p0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d.g("VrVideo", "onBackPressed");
            c1 c1Var = this.f6203a;
            return c1Var != null && c1Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.g("VrVideo", MissionEvent.MESSAGE_DESTROY);
            c1 c1Var = this.f6203a;
            if (c1Var != null) {
                c1Var.stop();
                this.f6203a = null;
            }
            b.a.p0.a.i1.b.j(this);
        }
    }
}
