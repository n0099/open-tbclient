package c.a.p0.g.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f.c.z;
import c.a.p0.a.p2.q0;
import c.a.p0.a.p2.w;
import c.a.p0.n.b;
import c.a.p0.n.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidubce.AbstractBceClient;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes.dex */
public class c extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f9803b;

        public a(c cVar, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9803b = cVar;
            this.a = gVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f9803b.v();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                this.f9803b.x(response, this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

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

    @Override // c.a.p0.a.f.c.z, c.a.p0.n.b
    public void d(int i2, List<g> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, list) == null) {
            super.d(i2, list);
            if (i2 == 12 || i2 == 15 || i2 == 17 || i2 == 18) {
                r(list);
                if ("wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y".equals(c.a.p0.a.t1.d.J().getAppId()) || "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(c.a.p0.a.t1.d.J().getAppId()) || !c.a.p0.a.s0.a.L().a()) {
                    return;
                }
                o(list);
            }
        }
    }

    @Override // c.a.p0.n.b
    public void f(int i2, List<g> list, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, list, aVar) == null) {
            aVar.a(40);
        }
    }

    @Override // c.a.p0.n.b
    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
        }
    }

    @Override // c.a.p0.a.f.c.z, c.a.p0.n.b
    public boolean j(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gVar)) == null) {
            int c2 = gVar.c();
            if (c2 == 40) {
                u(gVar);
            } else if (c2 == 45) {
                t(gVar);
            }
            return super.j(gVar);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.n.b
    public boolean k(boolean z, int i2) {
        InterceptResult invokeCommon;
        c.a.p0.a.t1.e a0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (q0.Q()) {
                Context appContext = AppRuntime.getAppContext();
                if (c.a.p0.a.k.e.a.b.y(appContext) && (a0 = c.a.p0.a.t1.e.a0()) != null && a0.M().e(appContext)) {
                    PMSAppInfo f0 = a0.V().f0();
                    return (a0.v0() || f0 == null || TextUtils.isEmpty(f0.paNumber)) ? false : true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void o(List<g> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        list.add(new g(40, R.string.aiapp_menu_my_applet, R.drawable.aiapp_menu_item_my_applet_selector, true));
    }

    public final Uri p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            String schemeHead = SchemeConfig.getSchemeHead();
            if (TextUtils.isEmpty(schemeHead)) {
                schemeHead = BaseWebViewActivity.SHOUBAI_SCHEME;
            }
            buildUpon.scheme(schemeHead);
            return buildUpon.build();
        }
        return (Uri) invokeL.objValue;
    }

    public final void q(g gVar) {
        c.a.p0.a.t1.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) || (a0 = c.a.p0.a.t1.e.a0()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        w.f(jSONObject, "app_key", a0.getAppId());
        w.f(jSONObject, "srcAppPage", c.a.p0.a.c1.b.b(q0.n()));
        JSONObject jSONObject2 = new JSONObject();
        w.f(jSONObject2, "appKey", "pjwYb22xF6hUcKpZKsiqvnhUhsoUvLfT");
        w.f(jSONObject2, "path", "pages/conversation/index");
        w.f(jSONObject2, PrefetchEvent.EVENT_DATA_EXTRA_DATA, s(a0));
        w.f(jSONObject, "params", jSONObject2);
        String I = c.a.p0.a.s0.a.o().I();
        c.a.p0.p.d.a aVar = new c.a.p0.p.d.a(I, new Request.Builder().url(I).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().body(), new a(this, gVar));
        aVar.f10920f = true;
        aVar.f10921g = false;
        aVar.f10922h = true;
        c.a.p0.p.e.a.g().e(aVar);
    }

    public final void r(List<g> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) && list != null && q0.Q() && c.a.p0.a.k.e.a.b.y(AppRuntime.getAppContext())) {
            list.add(new g(45, R.string.swan_app_menu_customer_service, R.drawable.aiapp_menu_item_customer_service_selector, true));
        }
    }

    public final JSONObject s(c.a.p0.a.t1.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, eVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            PMSAppInfo f0 = eVar.V().f0();
            w.f(jSONObject, "appname", f0.appName);
            w.f(jSONObject, "iconUrl", f0.iconUrl);
            w.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0.appKey);
            w.f(jSONObject, com.alipay.sdk.cons.b.k, f0.paNumber);
            w.f(jSONObject, "isBaiduSeries", Boolean.valueOf(SwanAppAllianceLoginHelper.f37293d.h()));
            w.f(jSONObject, "isOpenCustomerService", Boolean.valueOf(q0.Q()));
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void t(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) || c.a.p0.a.t1.e.a0() == null) {
            return;
        }
        q(gVar);
    }

    public final void u(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            c.a.p0.a.a1.a.o("appletCenter");
            c.a.p0.g.h.b.a(SchemeConfig.getSchemeHead() + "://swan/wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y?_baiduboxapp={\"from\":\"1271009000000000\",\"ext\":{}}&callback=_bdbox_js_275&upgrade=0");
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public final void w(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) {
            c.a.p0.a.s0.a.i().d();
            c.a.p0.a.b1.a.j(gVar);
            c.a.p0.a.a1.a.q(LightappBusinessClient.MTD_CUSTOMER_SERVICE, String.valueOf(gVar.e() > 0 ? 1 : 0), "click");
            c.a.p0.a.b1.a.i();
        }
    }

    public final void x(Response response, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, response, gVar) == null) {
            try {
                if (!response.isSuccessful()) {
                    v();
                    return;
                }
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    v();
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    v();
                    return;
                }
                Uri p = p(optJSONObject.optString("scheme"));
                if (p == null) {
                    v();
                } else if (SchemeRouter.invokeScheme(AppRuntime.getAppContext(), p, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    w(gVar);
                }
            } catch (Exception unused) {
                v();
            }
        }
    }
}
