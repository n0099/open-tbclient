package c.a.r0.j.o;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.m.o;
import c.a.r0.a.p.b.a.g;
import c.a.r0.j.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@Singleton
@Service
/* loaded from: classes6.dex */
public class a implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.r0.a.p.b.a.g
    public SwanCoreVersion n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // c.a.r0.a.p.b.a.g
    public c.a.r0.a.t0.c o(SwanAppActivity swanAppActivity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppActivity, str)) == null) ? new d(swanAppActivity, str) : (c.a.r0.a.t0.c) invokeLL.objValue;
    }

    @Override // c.a.r0.a.p.b.a.g
    public o p(c.a.r0.a.z2.g1.c<Exception> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) ? new c.a.r0.j.p.b.a(cVar) : (o) invokeL.objValue;
    }

    @Override // c.a.r0.a.p.b.a.g
    public void q(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            c.m().z(intent);
        }
    }

    @Override // c.a.r0.a.p.b.a.g
    public View r(c.a.r0.a.h0.g.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dVar)) == null) {
            if (dVar instanceof c.a.r0.j.n.a) {
                return ((c.a.r0.j.n.a) dVar).p3();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // c.a.r0.a.p.b.a.g
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.C();
        }
    }

    @Override // c.a.r0.a.p.b.a.g
    public void s(V8ExceptionInfo v8ExceptionInfo) {
        DuMixGameSurfaceView r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, v8ExceptionInfo) == null) || (r = c.m().r()) == null) {
            return;
        }
        r.onJSError(v8ExceptionInfo);
    }

    @Override // c.a.r0.a.p.b.a.g
    public ExtensionCore t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.m().k() : (ExtensionCore) invokeV.objValue;
    }

    @Override // c.a.r0.a.p.b.a.g
    public c.a.r0.a.p0.d.b u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? c.a.r0.j.m.a.i() : (c.a.r0.a.p0.d.b) invokeV.objValue;
    }

    @Override // c.a.r0.a.p.b.a.g
    public int v(String str, long j2) {
        InterceptResult invokeLJ;
        c.a.r0.j.d0.a.a a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j2)) == null) {
            if (TextUtils.isEmpty(str) || (a = c.a.r0.j.d0.a.a.a(c.a.r0.w.d.E(new File(a.d.h(str, String.valueOf(j2)), "game.json")))) == null) {
                return 0;
            }
            return a.f11185b;
        }
        return invokeLJ.intValue;
    }

    @Override // c.a.r0.a.p.b.a.g
    public void w(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) {
            c.a.r0.j.m0.a.a().d(str, z);
        }
    }
}
