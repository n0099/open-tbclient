package b.a.p0.a.j2.p;

import android.os.Bundle;
import android.text.TextUtils;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.j2.j;
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
        j.h(this);
        j.g(this);
        j.e(this);
        j.f(this);
    }

    @Override // b.a.p0.a.j2.p.e
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                b.a.p0.a.a2.e D = b.a.p0.a.g1.f.T().D();
                String i2 = b.a.p0.a.m2.b.i(this.k, TextUtils.equals(this.f6383a, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME) ? 1 : 0);
                if (D != null && D.M() != null) {
                    b.a M = D.M();
                    if (TextUtils.isEmpty(this.l)) {
                        this.l = D.Y();
                    }
                    if (TextUtils.isEmpty(this.m)) {
                        this.m = M.t1();
                    }
                    Bundle O = M.O();
                    if (O != null) {
                        this.o = O.getString("aiapp_extra_need_download", "");
                    }
                    if (TextUtils.isEmpty(this.p)) {
                        this.p = M.V();
                    }
                    this.p = j.a(this.p);
                    if (TextUtils.isEmpty(this.f6389g) && !TextUtils.isEmpty(M.d0())) {
                        this.s = M.d0();
                    }
                    String a2 = j.a(this.s);
                    this.s = a2;
                    if (a2 == null) {
                        this.s = "";
                    }
                    if (TextUtils.isEmpty(this.u)) {
                        this.u = M.U();
                    }
                }
                this.n = SwanAppNetworkUtils.f().type;
                if (this.f6390h == null) {
                    this.f6390h = new JSONObject();
                }
                this.f6390h.put("swan", i2);
                this.f6390h.put("appversion", this.l);
                this.f6390h.put("thirdversion", this.m);
                this.f6390h.put("net", this.n);
                this.f6390h.put("needdown", this.o);
                this.f6390h.put("scheme", this.p);
                this.f6390h.put("page", this.s);
                this.f6390h.put("launchid", this.u);
                if (!TextUtils.isEmpty(this.t)) {
                    this.f6390h.put("error_code", this.t);
                }
                if (!TextUtils.isEmpty(this.q)) {
                    this.f6390h.put("canceltime", this.q);
                }
                if (!TextUtils.isEmpty(this.r)) {
                    this.f6390h.put("successtime", this.r);
                }
                if (e.j) {
                    String str = "SwanAppUBCEvent: mExt=" + this.f6390h + "\t " + Thread.currentThread().getId();
                }
            } catch (JSONException e2) {
                if (e.j) {
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

    public void h(b.a.p0.a.f1.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            if (eVar == null) {
                boolean z = e.j;
                return;
            }
            this.f6388f = eVar.G();
            this.f6385c = eVar.S();
            this.o = eVar.q0().getString("aiapp_extra_need_download", "");
            this.p = eVar.V();
            this.s = eVar.d0();
            this.u = eVar.U();
        }
    }

    public void i(b.a.p0.a.f1.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            h(eVar);
        }
    }

    public void j(b.a.p0.a.f1.e.e eVar) {
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
