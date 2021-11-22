package b.a.p0.j.b;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.o2.g.h;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f10932a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10932a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject e2 = e.e(str, this.f10932a);
                    if (e2 == null) {
                        return;
                    }
                    this.f10932a.onSuccess(g.a(e2));
                    return;
                }
                this.f10932a.onFail("response is null");
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                this.f10932a.onFail(exc.getMessage());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f10933a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10933a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject e2 = e.e(str, this.f10933a);
                    if (e2 == null) {
                        return;
                    }
                    this.f10933a.onSuccess(f.a(e2));
                    return;
                }
                this.f10933a.onFail("response is null");
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                this.f10933a.onFail(exc.getMessage());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f10934a;

        public c(b.a.p0.a.d2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10934a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                try {
                    if (new JSONObject(str).getInt("errno") != 0) {
                        b.a.p0.a.o2.g.b a2 = h.a();
                        a2.putInt("swangame_valid__" + this.f10934a.N(), 0);
                        return;
                    }
                    b.a.p0.a.o2.g.b a3 = h.a();
                    a3.putInt("swangame_valid__" + this.f10934a.N(), 1);
                    e.g("1");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onFail(String str);

        void onSuccess(Object obj);
    }

    public static void b() {
        b.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (a0 = b.a.p0.a.d2.e.a0()) == null || c() || !b.a.p0.a.c1.a.h0().e(b.a.p0.a.c1.a.c())) {
            return;
        }
        if (d()) {
            g("1");
        } else {
            b.a.p0.j.z.b.a().getRequest().cookieManager(b.a.p0.a.c1.a.q().a()).url(b.a.p0.j.u.a.b().a()).addUrlParam("appKey", a0.N()).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(new c(a0));
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                return true;
            }
            b.a.p0.a.o2.g.b a2 = h.a();
            StringBuilder sb = new StringBuilder();
            sb.append("swangame_valid__");
            sb.append(a0.N());
            return a2.getInt(sb.toString(), -1) == 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                return false;
            }
            b.a.p0.a.o2.g.b a2 = h.a();
            StringBuilder sb = new StringBuilder();
            sb.append("swangame_valid__");
            sb.append(a0.N());
            return 1 == a2.getInt(sb.toString(), -1);
        }
        return invokeV.booleanValue;
    }

    public static JSONObject e(String str, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, dVar)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("errno", -1) != 0) {
                    dVar.onFail(jSONObject.optString("errmsg"));
                    return null;
                }
                return jSONObject.optJSONObject("data");
            } catch (Exception e2) {
                dVar.onFail(e2.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void f() {
        b.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) && (a0 = b.a.p0.a.d2.e.a0()) != null && d() && b.a.p0.a.c1.a.h0().e(b.a.p0.a.c1.a.c())) {
            b.a.p0.j.z.b.a().getRequest().cookieManager(b.a.p0.a.c1.a.q().a()).url(b.a.p0.j.u.a.b().i()).addUrlParam("appKey", a0.N()).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(null);
        }
    }

    public static void g(String str) {
        b.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) && (a0 = b.a.p0.a.d2.e.a0()) != null && d() && b.a.p0.a.c1.a.h0().e(b.a.p0.a.c1.a.c())) {
            String h2 = b.a.p0.a.c1.a.h0().h(b.a.p0.a.c1.a.c());
            if (TextUtils.isEmpty(h2)) {
                return;
            }
            String d2 = b.a.p0.w.f.d(Base64.encode(h2.getBytes(), 0), false);
            String i2 = b.a.p0.a.c1.a.h0().i(b.a.p0.a.c1.a.c());
            if (!TextUtils.isEmpty(i2) && i2.length() > 32) {
                i2 = i2.substring(0, 32);
            }
            b.a.p0.j.z.b.a().getRequest().cookieManager(b.a.p0.a.c1.a.q().a()).url(b.a.p0.j.u.a.b().q()).addUrlParam("sessionId", d2).addUrlParam("deviceId", i2).addUrlParam("behaviorType", str).addUrlParam("behaviorTime", String.valueOf(System.currentTimeMillis() / 1000)).addUrlParam("appKey", a0.N()).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(null);
        }
    }

    public static void h(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, dVar) == null) || dVar == null) {
            return;
        }
        b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
        if (a0 == null) {
            dVar.onFail("swan app is null");
            return;
        }
        b.a.p0.j.z.b.a().getRequest().cookieManager(b.a.p0.a.c1.a.q().a()).url(b.a.p0.j.u.a.b().j()).addUrlParam("appkey", a0.N()).addUrlParam(IMConstants.SERVICE_TYPE_ORDER, str).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(new b(dVar));
    }

    public static void i(long j, d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(65544, null, j, dVar) == null) || dVar == null) {
            return;
        }
        b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
        if (a0 == null) {
            dVar.onFail("swan app is null");
            return;
        }
        b.a.p0.j.z.b.a().getRequest().cookieManager(b.a.p0.a.c1.a.q().a()).url(b.a.p0.j.u.a.b().h()).addUrlParam("appkey", a0.N()).addUrlParam("duration", String.valueOf(j)).requestFrom(16).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE).build().executeAsync(new a(dVar));
    }
}
