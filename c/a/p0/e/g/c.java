package c.a.p0.e.g;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p.c.v;
import c.a.p0.a.s.a.f;
import c.a.p0.a.v2.q0;
import c.a.p0.a.v2.w;
import c.a.p0.k.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes.dex */
public class c extends v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends ResponseCallback<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o f10393a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f10394b;

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
            this.f10394b = cVar;
            this.f10393a = oVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f10394b.r();
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
                this.f10394b.t(response, this.f10393a);
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

    @Override // c.a.p0.a.p.c.v, c.a.p0.k.b
    public void c(int i2, List<o> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, list) == null) {
            super.c(i2, list);
            if (i2 == 12 || i2 == 15 || i2 == 17 || i2 == 18) {
                o(list);
            }
        }
    }

    @Override // c.a.p0.k.b
    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // c.a.p0.a.p.c.v, c.a.p0.k.b
    public boolean h(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oVar)) == null) {
            if (oVar.c() == 45) {
                q(oVar);
                return true;
            }
            return super.h(oVar);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.k.b
    public boolean i(boolean z, int i2) {
        InterceptResult invokeCommon;
        c.a.p0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (q0.P()) {
                Context appContext = AppRuntime.getAppContext();
                if (c.a.p0.a.u.e.a.a.s(appContext) && (Q = c.a.p0.a.a2.e.Q()) != null && Q.j().e(appContext)) {
                    PMSAppInfo f0 = Q.L().f0();
                    return (Q.m0() || f0 == null || TextUtils.isEmpty(f0.paNumber)) ? false : true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final Uri m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
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

    public final void n(o oVar) {
        c.a.p0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, oVar) == null) || (Q = c.a.p0.a.a2.e.Q()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        w.f(jSONObject, "app_key", Q.getAppId());
        w.f(jSONObject, "srcAppPage", c.a.p0.a.l1.b.e(q0.n()));
        JSONObject jSONObject2 = new JSONObject();
        w.f(jSONObject2, "appKey", "pjwYb22xF6hUcKpZKsiqvnhUhsoUvLfT");
        w.f(jSONObject2, "path", "pages/conversation/index");
        w.f(jSONObject2, PrefetchEvent.EVENT_DATA_EXTRA_DATA, p(Q));
        w.f(jSONObject, "params", jSONObject2);
        String F = c.a.p0.a.c1.a.n().F();
        c.a.p0.m.d.a aVar = new c.a.p0.m.d.a(F, new Request.Builder().url(F).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString())).build().body(), new a(this, oVar));
        aVar.f11845f = true;
        aVar.f11846g = false;
        aVar.f11847h = true;
        c.a.p0.m.e.a.g().e(aVar);
    }

    public final void o(List<o> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, list) == null) && list != null && q0.P() && c.a.p0.a.u.e.a.a.s(AppRuntime.getAppContext())) {
            list.add(new o(45, c.a.p0.e.e.aiapp_menu_customer_service, c.a.p0.e.b.aiapp_menu_item_customer_service_selector, true));
        }
    }

    public final JSONObject p(c.a.p0.a.a2.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, eVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            PMSAppInfo f0 = eVar.L().f0();
            w.f(jSONObject, "appname", f0.appName);
            w.f(jSONObject, "iconUrl", f0.iconUrl);
            w.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, f0.appKey);
            w.f(jSONObject, com.alipay.sdk.cons.b.k, f0.paNumber);
            w.f(jSONObject, "isBaiduSeries", Boolean.valueOf(f.f8492d.h()));
            w.f(jSONObject, "isOpenCustomerService", Boolean.valueOf(q0.P()));
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void q(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oVar) == null) || c.a.p0.a.a2.e.Q() == null) {
            return;
        }
        n(oVar);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public final void s(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, oVar) == null) {
            c.a.p0.a.c1.a.h().d();
            c.a.p0.a.k1.a.j(oVar);
            c.a.p0.a.j1.a.q(LightappBusinessClient.MTD_CUSTOMER_SERVICE, String.valueOf(oVar.e() > 0 ? 1 : 0), PrefetchEvent.STATE_CLICK);
            c.a.p0.a.k1.a.i();
        }
    }

    public final void t(Response response, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, response, oVar) == null) {
            try {
                if (!response.isSuccessful()) {
                    r();
                    return;
                }
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    r();
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    r();
                    return;
                }
                Uri m = m(optJSONObject.optString("scheme"));
                if (m == null) {
                    r();
                } else if (SchemeRouter.invokeScheme(AppRuntime.getAppContext(), m, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    s(oVar);
                }
            } catch (Exception unused) {
                r();
            }
        }
    }
}
