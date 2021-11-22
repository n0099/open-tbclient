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
import b.a.p0.a.z2.w;
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
    public String I0;
    public JSONObject J0;
    public boolean K0;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5492e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f5493f;

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
            this.f5493f = hVar;
            this.f5492e = jSONObject;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.p0.a.g1.f.U().u(new b.a.p0.a.w1.d.c.b(this.f5493f.I0, this.f5492e.toString(), this.f5493f.J0.optString("slaveId")).a());
                this.f5493f.K0 = false;
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
        this.K0 = true;
    }

    public static h V2(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            h hVar = new h();
            if (!TextUtils.isEmpty(str2)) {
                Bundle bundle = new Bundle();
                bundle.putString("plugin_fun_page_path", str);
                bundle.putString("plugin_pay_params", str2);
                hVar.g1(bundle);
            }
            return hVar;
        }
        return (h) invokeLL.objValue;
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l0 = null;
            super.C0();
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.K0 || (jSONObject = this.J0) == null) {
                return false;
            }
            b.a.p0.a.w1.d.c.a aVar = new b.a.p0.a.w1.d.c.a(jSONObject.optString("componentId"));
            aVar.f9220a = this.J0.optString("slaveId");
            aVar.b();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void R1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            S1(view);
            q2(-1);
            z2(-16777216);
            s2(P(b.a.p0.a.h.swan_app_plugin_fun_page_title));
            u2(true);
            G2(false);
        }
    }

    public final void U2(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view == null || this.J0 == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(b.a.p0.a.f.id_swan_app_plugin_app_name);
        b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
        if (a0 != null) {
            textView.setText(a0.X().K());
        }
        JSONObject optJSONObject = this.J0.optJSONObject("args");
        if (optJSONObject == null) {
            return;
        }
        ((TextView) view.findViewById(b.a.p0.a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
        TextView textView2 = (TextView) view.findViewById(b.a.p0.a.f.id_swan_app_plugin_service_name);
        b.a.p0.q.i.i g2 = b.a.p0.a.w1.h.b.g(this.J0.optString("pluginProvider"));
        if (g2 != null) {
            textView2.setText(g2.s);
        }
        ((Button) view.findViewById(b.a.p0.a.f.id_swan_app_plugin_pay)).setOnClickListener(new a(this, optJSONObject));
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle o = o();
            if (o == null) {
                return;
            }
            this.I0 = o.getString("plugin_fun_page_path");
            this.J0 = w.d(o.getString("plugin_pay_params"));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            b.a.p0.a.d2.d.J().r().d0().v();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            E2(1);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.p0.a.g.swan_app_plugin_fun_page_fragment, viewGroup, false);
            R1(inflate);
            U2(inflate);
            if (Q1()) {
                inflate = T1(inflate);
            }
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
