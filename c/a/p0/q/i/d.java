package c.a.p0.q.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.q.e.i;
import c.a.p0.q.i.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class d<T> implements g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public i f10972e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.q.i.m.h f10973f;

    /* renamed from: g  reason: collision with root package name */
    public String f10974g;

    public d(i iVar, c.a.p0.q.i.m.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10972e = iVar;
        this.f10973f = hVar;
    }

    @Override // c.a.p0.q.i.g.a
    public void a(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
            i iVar = this.f10972e;
            if (iVar != null) {
                iVar.J(str, str2, jSONObject);
            }
            this.f10974g = str;
        }
    }

    @Override // c.a.p0.q.i.g.a
    public void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            i iVar = this.f10972e;
            if (iVar != null) {
                iVar.I(str, i2);
            }
            if (i2 != 200) {
                c.a.p0.q.h.b bVar = new c.a.p0.q.h.b(2104, ErrorConstant.ErrorMsg.META_ERROR_CONNECTION + i2);
                bVar.f10955f = i2;
                i iVar2 = this.f10972e;
                if (iVar2 != null) {
                    iVar2.D(bVar);
                }
                c(bVar, str, String.valueOf(i2), String.valueOf(this.f10973f.b()));
                return;
            }
            c a = c.a(str);
            if (a == null) {
                JSONObject p = c.a.p0.q.o.f.p(str);
                c.a.p0.q.h.b bVar2 = new c.a.p0.q.h.b(2103, "metadata : parse response error - ,errmsg:" + p.toString());
                i iVar3 = this.f10972e;
                if (iVar3 != null) {
                    iVar3.D(bVar2);
                }
                c(bVar2, str, String.valueOf(i2), String.valueOf(this.f10973f.b()));
                return;
            }
            T u = u(a.c());
            if (s(u, i2)) {
                return;
            }
            int d2 = a.d();
            if (d2 != 0) {
                c.a.p0.q.h.b bVar3 = new c.a.p0.q.h.b(d2, a.e(), a.g(), i(a));
                i iVar4 = this.f10972e;
                if (iVar4 != null) {
                    iVar4.D(bVar3);
                }
                if (a.d() != 1010) {
                    d(bVar3, str, String.valueOf(i2), String.valueOf(this.f10973f.b()), a);
                }
            } else if (u == null) {
                c.a.p0.q.h.b bVar4 = new c.a.p0.q.h.b(2102, "response data empty");
                i iVar5 = this.f10972e;
                if (iVar5 != null) {
                    iVar5.D(bVar4);
                }
                d(bVar4, str, String.valueOf(i2), String.valueOf(this.f10973f.b()), a);
            } else {
                c.a.p0.q.h.b e2 = e(str, u);
                if (e2 != null) {
                    i iVar6 = this.f10972e;
                    if (iVar6 != null) {
                        iVar6.D(e2);
                    }
                    d(e2, str, String.valueOf(i2), String.valueOf(this.f10973f.b()), a);
                    return;
                }
                t(u);
            }
        }
    }

    public void c(c.a.p0.q.h.b bVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, bVar, str, str2, str3) == null) {
            d(bVar, str, str2, str3, null);
        }
    }

    public void d(c.a.p0.q.h.b bVar, String str, String str2, String str3, @Nullable c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, bVar, str, str2, str3, cVar) == null) {
            JSONObject jSONObject = new JSONObject();
            int i2 = 0;
            if (bVar != null) {
                try {
                    if (bVar.a != 0) {
                        i2 = bVar.a;
                        jSONObject.put("response", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, str2);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject.put("downloadType", str3);
                        }
                        if (!TextUtils.isEmpty(this.f10974g) && bVar.a != 2000) {
                            jSONObject.put("request_url", this.f10974g);
                        }
                        jSONObject.put("hostName", c.a.p0.q.c.b().c());
                        jSONObject.put("network", c.a.p0.w.a.e());
                    }
                } catch (JSONException unused) {
                }
            }
            if (this.f10973f instanceof c.a.p0.q.i.m.d) {
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, ((c.a.p0.q.i.m.d) this.f10973f).g());
            }
            if (cVar != null && cVar.f() != 0) {
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, cVar.f());
            }
            c.a.p0.q.a b2 = c.a.p0.q.c.b();
            if (b2 != null && b2.u() != null) {
                jSONObject.put("launchid", b2.u());
            }
            c.a.p0.q.m.a.a(this.f10973f.a(), "cs_protocol", h(), i2, jSONObject);
        }
    }

    @CallSuper
    public c.a.p0.q.h.b e(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, t)) == null) {
            if (f(t)) {
                return null;
            }
            return new c.a.p0.q.h.b(2103, str);
        }
        return (c.a.p0.q.h.b) invokeLL.objValue;
    }

    public abstract boolean f(T t);

    @Nullable
    public List<c.a.p0.q.h.i> g(@Nullable List<c.a.p0.q.h.i> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (c.a.p0.q.h.i iVar : list) {
                if (iVar != null && !arrayList.contains(iVar)) {
                    c.a.p0.q.f.a i2 = c.a.p0.q.f.a.i();
                    String str = iVar.f10961g;
                    long j2 = iVar.f10963i;
                    if (!c.a.p0.q.c.b().r(i2.q(str, j2, j2))) {
                        arrayList.add(iVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public abstract String h();

    @Nullable
    public final String i(c cVar) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar)) == null) {
            if (cVar == null || cVar.c() == null || (optJSONObject = cVar.c().optJSONObject("app_info")) == null) {
                return null;
            }
            return optJSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public c.a.p0.q.h.b j(Exception exc, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, exc, jSONObject)) == null) {
            if (jSONObject != null) {
                return new c.a.p0.q.h.b(jSONObject.optInt("errno"), jSONObject.toString());
            }
            return new c.a.p0.q.h.b(2101, Log.getStackTraceString(exc));
        }
        return (c.a.p0.q.h.b) invokeLL.objValue;
    }

    public JSONObject k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String[] split = str.split("request fail : ");
                if (split.length > 1) {
                    return new JSONObject(split[1]);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void l(c.a.p0.q.h.c cVar, c.a.p0.q.o.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, cVar, gVar) == null) || cVar == null) {
            return;
        }
        gVar.a(cVar, PMSPkgStatus.WAIT);
    }

    public void m(c.a.p0.q.h.e eVar, c.a.p0.q.o.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, eVar, gVar) == null) || eVar == null) {
            return;
        }
        gVar.a(eVar, PMSPkgStatus.WAIT);
    }

    public void n(List<c.a.p0.q.h.i> list, c.a.p0.q.o.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, gVar) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (c.a.p0.q.h.i iVar : list) {
            gVar.a(iVar, PMSPkgStatus.WAIT);
        }
    }

    public void o(c.a.p0.q.h.g gVar, c.a.p0.q.o.g gVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, gVar, gVar2) == null) || gVar == null) {
            return;
        }
        gVar2.a(gVar, PMSPkgStatus.WAIT);
    }

    @Override // c.a.p0.q.i.g.a
    public void onFail(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, exc) == null) {
            c.a.p0.q.h.b j2 = j(exc, k(exc.getMessage()));
            this.f10972e.D(j2);
            c(j2, exc.getMessage(), null, String.valueOf(this.f10973f.b()));
        }
    }

    @Override // c.a.p0.q.i.g.a
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c(new c.a.p0.q.h.b(2000, "send request"), null, null, String.valueOf(this.f10973f.b()));
        }
    }

    public void p(List<c.a.p0.q.h.h> list, c.a.p0.q.o.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, list, gVar) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (c.a.p0.q.h.h hVar : list) {
            gVar.a(hVar, PMSPkgStatus.WAIT);
        }
    }

    public void q(c.a.p0.q.h.i iVar, c.a.p0.q.o.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, iVar, gVar) == null) || iVar == null) {
            return;
        }
        gVar.a(iVar, PMSPkgStatus.WAIT);
    }

    public void r(PMSAppInfo pMSAppInfo) {
        c.a.p0.q.e.h q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) || pMSAppInfo == null || (q = this.f10972e.q()) == null) {
            return;
        }
        q.a(pMSAppInfo);
    }

    public boolean s(T t, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, t, i2)) == null) {
            return false;
        }
        return invokeLI.booleanValue;
    }

    public abstract c.a.p0.q.h.b t(T t);

    public abstract T u(JSONObject jSONObject);
}
