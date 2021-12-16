package c.a.q0.a.n2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.q0.a.f1.e.b;
import c.a.q0.a.n2.c;
import c.a.q0.a.z2.q0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p extends c.a.q0.a.y1.a.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7408f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(628094654, "Lc/a/q0/a/n2/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(628094654, "Lc/a/q0/a/n2/p;");
                return;
            }
        }
        f7408f = c.a.q0.a.k.a;
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean e(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? TextUtils.isEmpty(str) || TextUtils.equals("0", str) : invokeL.booleanValue;
    }

    public static void f(String str, String str2, @Nullable JSONObject jSONObject) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, str, str2, jSONObject) == null) && e(str2)) {
            JSONObject jSONObject2 = new JSONObject();
            String str3 = StringUtil.NULL_STRING;
            if (str2 == null) {
                str2 = StringUtil.NULL_STRING;
            }
            try {
                jSONObject2.put("version", str2);
                jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str == null ? StringUtil.NULL_STRING : str);
                c.a.q0.a.d2.e L = c.a.q0.a.d2.e.L();
                if (L != null) {
                    b.a X = L.X();
                    jSONObject2.put("launchInfo", X == null ? StringUtil.NULL_STRING : X.I1());
                    SwanAppActivity x = L.x();
                    c.a.q0.a.f1.e.b bVar = null;
                    if (x != null && (intent = x.getIntent()) != null) {
                        bVar = c.a.q0.a.f1.e.b.d1(intent);
                    }
                    if (bVar != null) {
                        str3 = bVar.I1();
                    }
                    jSONObject2.put("launchInfoIntent", str3);
                } else {
                    jSONObject2.put("swanApp", StringUtil.NULL_STRING);
                }
                jSONObject2.put("stackTrace", q0.y());
                if (jSONObject != null) {
                    jSONObject2.put("reportExtInfo", jSONObject);
                }
            } catch (JSONException e2) {
                if (f7408f) {
                    e2.printStackTrace();
                }
            }
            c.a.q0.a.y1.c.e.a z = c.a.q0.a.d2.d.J().z();
            if (z != null) {
                Bundle bundle = new Bundle();
                bundle.putString("key_swan_appid", str);
                bundle.putString("key_report_info", jSONObject2.toString());
                z.V(bundle, p.class);
            }
        }
    }

    @Override // c.a.q0.a.y1.a.a.a
    public void b(@NonNull Bundle bundle) {
        c.a.q0.a.j0.a o;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            String string = bundle.getString("key_swan_appid", "");
            String string2 = bundle.getString("key_report_info", "");
            String str = TextUtils.isEmpty(string2) ? "" : string2;
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                boolean z = f7408f;
                e2.printStackTrace();
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (!TextUtils.isEmpty(string) && (o = SwanAppDbControl.f(AppRuntime.getAppContext()).o(string)) != null) {
                try {
                    jSONObject.put("appDbInfo", o.a());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            if (f7408f) {
                String str2 = "report info: " + jSONObject.toString();
            }
            c.b bVar = new c.b(10002);
            bVar.i(jSONObject.toString());
            bVar.m();
            c();
        }
    }
}
