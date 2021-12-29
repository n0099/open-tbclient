package c.a.r0.g.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.p.c.z;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.w;
import c.a.r0.n.b;
import c.a.r0.n.o;
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
/* loaded from: classes6.dex */
public class c extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f10564b;

        public a(c cVar, o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10564b = cVar;
            this.a = oVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f10564b.v();
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
                this.f10564b.x(response, this.a);
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

    @Override // c.a.r0.a.p.c.z, c.a.r0.n.b
    public void d(int i2, List<o> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, list) == null) {
            super.d(i2, list);
            if (i2 == 12 || i2 == 15 || i2 == 17 || i2 == 18) {
                r(list);
                if ("wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y".equals(c.a.r0.a.d2.d.J().getAppId()) || "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(c.a.r0.a.d2.d.J().getAppId()) || !c.a.r0.a.c1.a.L().a()) {
                    return;
                }
                o(list);
            }
        }
    }

    @Override // c.a.r0.n.b
    public void f(int i2, List<o> list, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, list, aVar) == null) {
            aVar.a(40);
        }
    }

    @Override // c.a.r0.n.b
    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
        }
    }

    @Override // c.a.r0.a.p.c.z, c.a.r0.n.b
    public boolean j(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, oVar)) == null) {
            int c2 = oVar.c();
            if (c2 == 40) {
                u(oVar);
            } else if (c2 == 45) {
                t(oVar);
            }
            return super.j(oVar);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.n.b
    public boolean k(boolean z, int i2) {
        InterceptResult invokeCommon;
        c.a.r0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (q0.Q()) {
                Context appContext = AppRuntime.getAppContext();
                if (c.a.r0.a.u.e.a.b.y(appContext) && (a0 = c.a.r0.a.d2.e.a0()) != null && a0.M().e(appContext)) {
                    PMSAppInfo f0 = a0.V().f0();
                    return (a0.v0() || f0 == null || TextUtils.isEmpty(f0.paNumber)) ? false : true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void o(List<o> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        list.add(new o(40, c.a.r0.g.e.aiapp_menu_my_applet, c.a.r0.g.b.aiapp_menu_item_my_applet_selector, true));
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

    public final void q(o oVar) {
        c.a.r0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, oVar) == null) || (a0 = c.a.r0.a.d2.e.a0()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        w.f(jSONObject, "app_key", a0.getAppId());
        w.f(jSONObject, "srcAppPage", c.a.r0.a.m1.b.b(q0.n()));
        JSONObject jSONObject2 = new JSONObject();
        w.f(jSONObject2, "appKey", "pjwYb22xF6hUcKpZKsiqvnhUhsoUvLfT");
        w.f(jSONObject2, "path", "pages/conversation/index");
        w.f(jSONObject2, PrefetchEvent.EVENT_DATA_EXTRA_DATA, s(a0));
        w.f(jSONObject, "params", jSONObject2);
        String I = c.a.r0.a.c1.a.o().I();
        c.a.r0.p.d.a aVar = new c.a.r0.p.d.a(I, new Request.Builder().url(I).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().body(), new a(this, oVar));
        aVar.f11718f = true;
        aVar.f11719g = false;
        aVar.f11720h = true;
        c.a.r0.p.e.a.g().e(aVar);
    }

    public final void r(List<o> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) && list != null && q0.Q() && c.a.r0.a.u.e.a.b.y(AppRuntime.getAppContext())) {
            list.add(new o(45, c.a.r0.g.e.swan_app_menu_customer_service, c.a.r0.g.b.aiapp_menu_item_customer_service_selector, true));
        }
    }

    public final JSONObject s(c.a.r0.a.d2.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, eVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            PMSAppInfo f0 = eVar.V().f0();
            w.f(jSONObject, "appname", f0.appName);
            w.f(jSONObject, "iconUrl", f0.iconUrl);
            w.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0.appKey);
            w.f(jSONObject, com.alipay.sdk.cons.b.f31824k, f0.paNumber);
            w.f(jSONObject, "isBaiduSeries", Boolean.valueOf(SwanAppAllianceLoginHelper.f39956d.h()));
            w.f(jSONObject, "isOpenCustomerService", Boolean.valueOf(q0.Q()));
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void t(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, oVar) == null) || c.a.r0.a.d2.e.a0() == null) {
            return;
        }
        q(oVar);
    }

    public final void u(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, oVar) == null) {
            c.a.r0.a.k1.a.o("appletCenter");
            c.a.r0.g.m.b.a(SchemeConfig.getSchemeHead() + "://swan/wYub6F7RD2tEngaTnOQPBEbYXx5s4Y3y?_baiduboxapp={\"from\":\"1271009000000000\",\"ext\":{}}&callback=_bdbox_js_275&upgrade=0");
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public final void w(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, oVar) == null) {
            c.a.r0.a.c1.a.i().d();
            c.a.r0.a.l1.a.j(oVar);
            c.a.r0.a.k1.a.q(LightappBusinessClient.MTD_CUSTOMER_SERVICE, String.valueOf(oVar.e() > 0 ? 1 : 0), "click");
            c.a.r0.a.l1.a.i();
        }
    }

    public final void x(Response response, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, response, oVar) == null) {
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
                    w(oVar);
                }
            } catch (Exception unused) {
                v();
            }
        }
    }
}
