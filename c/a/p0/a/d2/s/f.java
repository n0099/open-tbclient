package c.a.p0.a.d2.s;

import android.os.Bundle;
import android.text.TextUtils;
import c.a.p0.a.d2.m;
import c.a.p0.a.v0.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanCoreVersion k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;

    public f() {
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
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        m.i(this);
        m.h(this);
        m.f(this);
        m.g(this);
    }

    @Override // c.a.p0.a.d2.s.e
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                c.a.p0.a.t1.e D = c.a.p0.a.w0.f.U().D();
                String i2 = c.a.p0.a.g2.b.i(this.k, TextUtils.equals(this.a, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME) ? 1 : 0);
                if (D != null && D.X() != null) {
                    b.a X = D.X();
                    if (TextUtils.isEmpty(this.l)) {
                        this.l = D.j0();
                    }
                    if (TextUtils.isEmpty(this.m)) {
                        this.m = X.w1();
                    }
                    Bundle P = X.P();
                    if (P != null) {
                        this.o = P.getString("aiapp_extra_need_download", "");
                    }
                    if (TextUtils.isEmpty(this.p)) {
                        this.p = X.W();
                    }
                    this.p = m.b(this.p);
                    if (TextUtils.isEmpty(this.f4952g) && !TextUtils.isEmpty(X.e0())) {
                        this.s = X.e0();
                    }
                    String b2 = m.b(this.s);
                    this.s = b2;
                    if (b2 == null) {
                        this.s = "";
                    }
                    if (TextUtils.isEmpty(this.u)) {
                        this.u = X.V();
                    }
                }
                this.n = SwanAppNetworkUtils.f().type;
                if (this.f4953h == null) {
                    this.f4953h = new JSONObject();
                }
                this.f4953h.put("swan", i2);
                this.f4953h.put("appversion", this.l);
                this.f4953h.put("thirdversion", this.m);
                this.f4953h.put("net", this.n);
                this.f4953h.put("needdown", this.o);
                this.f4953h.put("scheme", this.p);
                this.f4953h.put("page", this.s);
                this.f4953h.put("launchid", this.u);
                if (!TextUtils.isEmpty(this.t)) {
                    this.f4953h.put("error_code", this.t);
                }
                if (!TextUtils.isEmpty(this.q)) {
                    this.f4953h.put("canceltime", this.q);
                }
                if (!TextUtils.isEmpty(this.r)) {
                    this.f4953h.put("successtime", this.r);
                }
                if (e.f4946j) {
                    String str = "SwanAppUBCEvent: mExt=" + this.f4953h + "\t " + Thread.currentThread().getId();
                }
            } catch (JSONException e2) {
                if (e.f4946j) {
                    e2.printStackTrace();
                }
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public void h(c.a.p0.a.v0.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            if (eVar == null) {
                boolean z = e.f4946j;
                return;
            }
            this.f4951f = eVar.H();
            this.f4948c = eVar.T();
            this.o = eVar.s0().getString("aiapp_extra_need_download", "");
            this.p = eVar.W();
            this.s = eVar.e0();
            this.u = eVar.V();
        }
    }

    public void i(c.a.p0.a.v0.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            h(eVar);
        }
    }

    public void j(c.a.p0.a.v0.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            h(eVar);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.u = str;
        }
    }
}
