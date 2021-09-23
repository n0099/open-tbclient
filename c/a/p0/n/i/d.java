package c.a.p0.n.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.n.i.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class d<T> implements g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.n.f.g f11910e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.n.i.m.g f11911f;

    /* renamed from: g  reason: collision with root package name */
    public String f11912g;

    public d(c.a.p0.n.f.g gVar, c.a.p0.n.i.m.g gVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, gVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11910e = gVar;
        this.f11911f = gVar2;
    }

    @Override // c.a.p0.n.i.g.a
    public void a(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
            c.a.p0.n.f.g gVar = this.f11910e;
            if (gVar != null) {
                gVar.H(str, str2, jSONObject);
            }
            this.f11912g = str;
        }
    }

    @Override // c.a.p0.n.i.g.a
    public void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            c.a.p0.n.f.g gVar = this.f11910e;
            if (gVar != null) {
                gVar.G(str, i2);
            }
            if (i2 != 200) {
                c.a.p0.n.h.a aVar = new c.a.p0.n.h.a(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i2);
                aVar.f11886d = i2;
                this.f11910e.B(aVar);
                c(aVar, str, String.valueOf(i2), String.valueOf(this.f11911f.b()));
                return;
            }
            c a2 = c.a(str);
            if (a2 == null) {
                JSONObject m = c.a.p0.n.o.e.m(str);
                c.a.p0.n.h.a aVar2 = new c.a.p0.n.h.a(2103, "metadata : parse response error - ,errmsg:" + m.toString());
                this.f11910e.B(aVar2);
                c(aVar2, str, String.valueOf(i2), String.valueOf(this.f11911f.b()));
                return;
            }
            int d2 = a2.d();
            if (d2 != 0) {
                c.a.p0.n.h.a aVar3 = new c.a.p0.n.h.a(d2, PMSConstants.a.a(d2, "response errorCode with errmsg:" + a2.e()), a2.g());
                this.f11910e.B(aVar3);
                if (a2.d() != 1010) {
                    d(aVar3, str, String.valueOf(i2), String.valueOf(this.f11911f.b()), a2);
                    return;
                }
                return;
            }
            T n = n(a2.c());
            if (n == null) {
                c.a.p0.n.h.a aVar4 = new c.a.p0.n.h.a(2102, "response data empty");
                this.f11910e.B(aVar4);
                d(aVar4, str, String.valueOf(i2), String.valueOf(this.f11911f.b()), a2);
            } else if (!e(n)) {
                c.a.p0.n.h.a aVar5 = new c.a.p0.n.h.a(2103, str);
                this.f11910e.B(aVar5);
                d(aVar5, str, String.valueOf(i2), String.valueOf(this.f11911f.b()), a2);
            } else {
                m(n);
            }
        }
    }

    public final void c(c.a.p0.n.h.a aVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, aVar, str, str2, str3) == null) {
            d(aVar, str, str2, str3, null);
        }
    }

    public final void d(c.a.p0.n.h.a aVar, String str, String str2, String str3, @Nullable c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, aVar, str, str2, str3, cVar) == null) {
            JSONObject jSONObject = new JSONObject();
            int i2 = 0;
            if (aVar != null) {
                try {
                    if (aVar.f11883a != 0) {
                        i2 = aVar.f11883a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.f11912g) && aVar.f11883a != 2000) {
                            jSONObject.put("request_url", this.f11912g);
                        }
                        jSONObject.put("hostName", c.a.p0.n.c.b().c());
                        jSONObject.put("network", c.a.p0.t.a.e());
                    }
                } catch (JSONException e2) {
                    if (c.a.p0.n.c.f11864a) {
                        e2.printStackTrace();
                    }
                }
            }
            if (this.f11911f instanceof c.a.p0.n.i.m.c) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((c.a.p0.n.i.m.c) this.f11911f).g());
            }
            if (cVar != null && cVar.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, cVar.f());
            }
            c.a.p0.n.a b2 = c.a.p0.n.c.b();
            if (b2 != null && b2.t() != null) {
                jSONObject.put("launchid", b2.t());
            }
            c.a.p0.n.m.a.a(this.f11911f.a(), "cs_protocol", f(), i2, jSONObject);
        }
    }

    public abstract boolean e(T t);

    public abstract String f();

    public void g(c.a.p0.n.h.b bVar, c.a.p0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, bVar, fVar) == null) || bVar == null) {
            return;
        }
        fVar.a(bVar, PMSPkgStatus.WAIT);
    }

    public void h(c.a.p0.n.h.d dVar, c.a.p0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, dVar, fVar) == null) || dVar == null) {
            return;
        }
        fVar.a(dVar, PMSPkgStatus.WAIT);
    }

    public void i(c.a.p0.n.h.f fVar, c.a.p0.n.o.f fVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, fVar2) == null) || fVar == null) {
            return;
        }
        fVar2.a(fVar, PMSPkgStatus.WAIT);
    }

    public void j(List<c.a.p0.n.h.g> list, c.a.p0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, list, fVar) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (c.a.p0.n.h.g gVar : list) {
            fVar.a(gVar, PMSPkgStatus.WAIT);
        }
    }

    public void k(c.a.p0.n.h.h hVar, c.a.p0.n.o.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, hVar, fVar) == null) || hVar == null) {
            return;
        }
        fVar.a(hVar, PMSPkgStatus.WAIT);
    }

    public void l(PMSAppInfo pMSAppInfo) {
        c.a.p0.n.f.f p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, pMSAppInfo) == null) || pMSAppInfo == null || (p = this.f11910e.p()) == null) {
            return;
        }
        p.a(pMSAppInfo);
    }

    public abstract c.a.p0.n.h.a m(T t);

    public abstract T n(JSONObject jSONObject);

    @Override // c.a.p0.n.i.g.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, exc) == null) {
            c.a.p0.n.h.a aVar = new c.a.p0.n.h.a(2101, Log.getStackTraceString(exc));
            this.f11910e.B(aVar);
            c(aVar, exc.getMessage(), null, String.valueOf(this.f11911f.b()));
        }
    }

    @Override // c.a.p0.n.i.g.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c(new c.a.p0.n.h.a(2000, "send request"), null, null, String.valueOf(this.f11911f.b()));
        }
    }
}
