package c.a.r0.a.c1.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.z2.f0;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.t0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes.dex */
public class c implements c.a.r0.h.i.n.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // c.a.r0.h.i.n.b.b
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.r0.a.c1.a.n().a() : (String) invokeV.objValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public boolean b(Context context, Intent intent, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, intent, str, str2, str3)) == null) {
            if (c.a.r0.a.c1.a.a().d()) {
                return c.a.r0.a.c1.a.a().b(context, intent, str, str2, str3);
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.r0.a.c1.a.y0().c() : (String) invokeV.objValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public boolean d(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull c.a.r0.h.i.k.f.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, jSONObject, swanAppDownloadType, aVar)) == null) ? c.a.r0.a.c1.a.d().d(context, jSONObject, swanAppDownloadType, aVar) : invokeLLLL.booleanValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String i2 = c.a.r0.a.c1.a.h0().i(c.a.r0.a.c1.a.c());
            return TextUtils.isEmpty(i2) ? q0.r() : i2;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
            return L != null ? L.f5660f : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
            return L != null ? L.N() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.r0.a.l.a() : (String) invokeV.objValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public String k() {
        InterceptResult invokeV;
        b.a V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            return (a0 == null || (V = a0.V()) == null) ? "" : V.T();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? c.a.r0.a.c1.a.q().a().getCookie(str) : (String) invokeL.objValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            return a0 != null ? a0.V().j1().optString("eqid", "") : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (c.a.r0.a.g1.f.U().getActivity() != null) {
                return f0.e(c.a.r0.a.g1.f.U().getActivity());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? c.a.r0.a.w2.a.b(str) : (String) invokeL.objValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? ((Integer) c.a.r0.a.g1.f.U().x().second).intValue() : invokeV.intValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? ((Integer) c.a.r0.a.g1.f.U().x().first).intValue() : invokeV.intValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public Uri r(@NonNull Context context, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, context, file)) == null) ? t0.a(context, file) : (Uri) invokeLL.objValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? q0.r() : (String) invokeV.objValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public JSONObject t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            return a0 != null ? a0.V().M() : new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // c.a.r0.h.i.n.b.b
    public boolean u(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view)) == null) {
            if (c.a.r0.a.g1.f.U().getActivity() != null) {
                return f0.q(c.a.r0.a.g1.f.U().getActivity(), view);
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
