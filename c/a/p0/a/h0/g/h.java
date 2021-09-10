package c.a.p0.a.h0.g;

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
import c.a.p0.a.v2.w;
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
        public final /* synthetic */ JSONObject f5942e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f5943f;

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
            this.f5943f = hVar;
            this.f5942e = jSONObject;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.a.g1.f.V().v(new c.a.p0.a.t1.c.c.b(this.f5943f.C0, this.f5942e.toString(), this.f5943f.D0.optString("slaveId")).a());
                this.f5943f.E0 = false;
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

    public static h J2(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            h hVar = new h();
            if (!TextUtils.isEmpty(str2)) {
                Bundle bundle = new Bundle();
                bundle.putString("plugin_fun_page_path", str);
                bundle.putString("plugin_pay_params", str2);
                hVar.h1(bundle);
            }
            return hVar;
        }
        return (h) invokeLL.objValue;
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k0 = null;
            super.C0();
        }
    }

    public final void I2(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null || this.D0 == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(c.a.p0.a.f.id_swan_app_plugin_app_name);
        c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
        if (Q != null) {
            textView.setText(Q.N().K());
        }
        JSONObject optJSONObject = this.D0.optJSONObject("args");
        if (optJSONObject == null) {
            return;
        }
        ((TextView) view.findViewById(c.a.p0.a.f.id_swan_app_plugin_money)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
        TextView textView2 = (TextView) view.findViewById(c.a.p0.a.f.id_swan_app_plugin_service_name);
        c.a.p0.n.h.h g2 = c.a.p0.a.t1.g.b.g(this.D0.optString("pluginProvider"));
        if (g2 != null) {
            textView2.setText(g2.s);
        }
        ((Button) view.findViewById(c.a.p0.a.f.id_swan_app_plugin_pay)).setOnClickListener(new a(this, optJSONObject));
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean J() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.E0 || (jSONObject = this.D0) == null) {
                return false;
            }
            c.a.p0.a.t1.c.c.a aVar = new c.a.p0.a.t1.c.c.a(jSONObject.optString("componentId"));
            aVar.f8675a = this.D0.optString("slaveId");
            aVar.b();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            P1(view);
            j2(-1);
            r2(-16777216);
            l2(U(c.a.p0.a.h.swan_app_plugin_fun_page_title));
            n2(true);
            x2(false);
        }
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.h0.g.d
    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
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
            this.C0 = o.getString("plugin_fun_page_path");
            this.D0 = w.d(o.getString("plugin_pay_params"));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            c.a.p0.a.a2.d.g().r().T().v();
        }
    }

    @Override // c.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            v2(1);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(c.a.p0.a.g.swan_app_plugin_fun_page_fragment, viewGroup, false);
            O1(inflate);
            I2(inflate);
            if (N1()) {
                inflate = Q1(inflate);
            }
            return y1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
