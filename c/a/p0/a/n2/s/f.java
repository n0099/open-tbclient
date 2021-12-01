package c.a.p0.a.n2.s;

import android.os.Bundle;
import android.text.TextUtils;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.n2.m;
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

    /* renamed from: k  reason: collision with root package name */
    public SwanCoreVersion f7121k;
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

    @Override // c.a.p0.a.n2.s.e
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                c.a.p0.a.d2.e D = c.a.p0.a.g1.f.U().D();
                String i2 = c.a.p0.a.q2.b.i(this.f7121k, TextUtils.equals(this.a, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME) ? 1 : 0);
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
                    if (TextUtils.isEmpty(this.f7118g) && !TextUtils.isEmpty(X.e0())) {
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
                if (this.f7119h == null) {
                    this.f7119h = new JSONObject();
                }
                this.f7119h.put("swan", i2);
                this.f7119h.put("appversion", this.l);
                this.f7119h.put("thirdversion", this.m);
                this.f7119h.put("net", this.n);
                this.f7119h.put("needdown", this.o);
                this.f7119h.put("scheme", this.p);
                this.f7119h.put("page", this.s);
                this.f7119h.put("launchid", this.u);
                if (!TextUtils.isEmpty(this.t)) {
                    this.f7119h.put("error_code", this.t);
                }
                if (!TextUtils.isEmpty(this.q)) {
                    this.f7119h.put("canceltime", this.q);
                }
                if (!TextUtils.isEmpty(this.r)) {
                    this.f7119h.put("successtime", this.r);
                }
                if (e.f7112j) {
                    String str = "SwanAppUBCEvent: mExt=" + this.f7119h + "\t " + Thread.currentThread().getId();
                }
            } catch (JSONException e2) {
                if (e.f7112j) {
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

    public void h(c.a.p0.a.f1.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            if (eVar == null) {
                boolean z = e.f7112j;
                return;
            }
            this.f7117f = eVar.H();
            this.f7114c = eVar.T();
            this.o = eVar.s0().getString("aiapp_extra_need_download", "");
            this.p = eVar.W();
            this.s = eVar.e0();
            this.u = eVar.V();
        }
    }

    public void i(c.a.p0.a.f1.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            h(eVar);
        }
    }

    public void j(c.a.p0.a.f1.e.e eVar) {
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
