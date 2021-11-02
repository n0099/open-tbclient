package b.a.p0.a.h0.g;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String C0;
    public JSONObject D0;
    public boolean E0;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5294e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f5295f;

        public a(h hVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5295f = hVar;
            this.f5294e = jSONObject;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.p0.a.g1.f.T().u(new b.a.p0.a.t1.c.c.b(this.f5295f.C0, this.f5294e.toString(), this.f5295f.D0.optString("slaveId")).a());
                this.f5295f.E0 = false;
            }
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E0 = true;
    }

    public static h F2(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            h hVar = new h();
            if (!TextUtils.isEmpty(str2)) {
                Bundle bundle = new Bundle();
                bundle.putString("plugin_fun_page_path", str);
                bundle.putString("plugin_pay_params", str2);
                hVar.d1(bundle);
            }
            return hVar;
        }
        return (h) invokeLL.objValue;
    }

    public final void E2(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.D0 == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(b.a.p0.a.f.id_swan_app_plugin_app_name);
        b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
        if (P != null) {
            textView.setText(P.M().J());
        }
        JSONObject optJSONObject = this.D0.optJSONObject("args");
        if (optJSONObject == null) {
            return;
        }
        ((TextView) view.findViewById(b.a.p0.a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
        TextView textView2 = (TextView) view.findViewById(b.a.p0.a.f.id_swan_app_plugin_service_name);
        b.a.p0.n.h.h g2 = b.a.p0.a.t1.g.b.g(this.D0.optString("pluginProvider"));
        if (g2 != null) {
            textView2.setText(g2.s);
        }
        ((Button) view.findViewById(b.a.p0.a.f.id_swan_app_plugin_pay)).setOnClickListener(new a(this, optJSONObject));
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean I() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.E0 || (jSONObject = this.D0) == null) {
                return false;
            }
            b.a.p0.a.t1.c.c.a aVar = new b.a.p0.a.t1.c.c.a(jSONObject.optString("componentId"));
            aVar.f7949a = this.D0.optString("slaveId");
            aVar.b();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void K1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            L1(view);
            f2(-1);
            n2(-16777216);
            h2(P(b.a.p0.a.h.swan_app_plugin_fun_page_title));
            j2(true);
            t2(false);
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle n = n();
            if (n == null) {
                return;
            }
            this.C0 = n.getString("plugin_fun_page_path");
            this.D0 = w.d(n.getString("plugin_pay_params"));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            b.a.p0.a.a2.d.g().r().S().v();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            r2(1);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.p0.a.g.swan_app_plugin_fun_page_fragment, viewGroup, false);
            K1(inflate);
            E2(inflate);
            if (J1()) {
                inflate = M1(inflate);
            }
            return u1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.k0 = null;
            super.z0();
        }
    }
}
