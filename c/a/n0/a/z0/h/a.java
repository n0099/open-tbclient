package c.a.n0.a.z0.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f.d.i1;
import c.a.n0.a.u.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements c.a.n0.a.z0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i1 a;

    /* renamed from: b  reason: collision with root package name */
    public String f7976b;

    /* renamed from: c  reason: collision with root package name */
    public c f7977c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7978d;

    /* renamed from: e  reason: collision with root package name */
    public Context f7979e;

    public a(Context context, @NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7979e = context;
        this.f7977c = cVar;
        this.f7976b = cVar.j;
        e();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f7976b)) {
            return;
        }
        c.a.n0.a.z0.b.a(this);
    }

    @Override // c.a.n0.a.z0.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f7977c.f6097c : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.z0.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7976b : (String) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f7977c : (c) invokeV.objValue;
    }

    public i1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                d.i("VrVideo", "create player");
                this.a = c.a.n0.a.s0.a.D0().create();
            }
            return this.a;
        }
        return (i1) invokeV.objValue;
    }

    @Override // c.a.n0.a.z0.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c cVar = this.f7977c;
            return cVar != null ? cVar.t : "";
        }
        return (String) invokeV.objValue;
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            d.i("VrVideo", "Open Player " + cVar.j);
            i1 i1Var = this.a;
            if (i1Var != null) {
                i1Var.e(cVar, this.f7979e);
            }
            this.f7977c = cVar;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            d.b("VrVideo", "update 接口");
            i1 i1Var = this.a;
            if (i1Var != null) {
                i1Var.d(cVar, true);
            }
            this.f7977c = cVar;
        }
    }

    @Override // c.a.n0.a.z0.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : invokeV.objValue;
    }

    @Override // c.a.n0.a.z0.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // c.a.n0.a.z0.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                if (this.f7978d) {
                    e().resume();
                }
                e().b();
            } else if (this.a != null) {
                this.f7978d = e().isPlaying();
                e().pause();
                e().c();
            }
        }
    }

    @Override // c.a.n0.a.z0.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d.i("VrVideo", "onBackPressed");
            i1 i1Var = this.a;
            return i1Var != null && i1Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.z0.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
            i1 i1Var = this.a;
            if (i1Var != null) {
                i1Var.stop();
                this.a = null;
            }
            c.a.n0.a.z0.b.k(this);
        }
    }
}
