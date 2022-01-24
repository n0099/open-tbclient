package c.a.r0.a.n2;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r extends c.a.r0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8112e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ r f8113f;

        public a(r rVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8113f = rVar;
            this.f8112e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8113f.z(this.f8112e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8114e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8115f;

        public b(r rVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8114e = str;
            this.f8115f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.equals(this.f8114e, "671")) {
                    c.a.r0.a.e0.d.k("ubcAndCeresStatisticEvent", "671 event=" + this.f8115f);
                }
                try {
                    c.a.r0.a.n2.b.m(this.f8114e, new JSONObject(this.f8115f));
                } catch (JSONException e2) {
                    c.a.r0.a.e0.d.k("ubcAndCeresStatisticEvent", e2.toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8117f;

        public c(r rVar, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8116e = str;
            this.f8117f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.u.e.l(this.f8116e, this.f8117f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@NonNull c.a.r0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.r0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        b.a V = c.a.r0.a.d2.d.J().r().V();
        w.f(jSONObject, "launchId", V.V());
        w.f(jSONObject, "scheme", V.W());
        w.f(jSONObject, "packageVersion", V.v1());
        m.a(jSONObject);
    }

    public c.a.r0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!c.a.r0.a.g1.f.U().N() && c.a.r0.a.u1.l.e.e()) {
                c.a.r0.a.u1.k.i.c.e().d(new a(this, str), "ubcAndCeresStatistic", false);
                return c.a.r0.a.u.h.b.f();
            }
            return z(str);
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "StatisticEvent" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "UbcAndCeresStatisticEventApi" : (String) invokeV.objValue;
    }

    public final c.a.r0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (g.b(str)) {
                return new c.a.r0.a.u.h.b(202, "the params is over max limit");
            }
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("ubcId");
                String optString2 = jSONObject.optString("bizId");
                JSONObject optJSONObject = jSONObject.optJSONObject("content");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optJSONObject != null) {
                    w.f(optJSONObject, "source", c.a.r0.a.d2.d.J().r().V().T());
                    y(optJSONObject.optJSONObject("ext"));
                    c.a.r0.a.u1.k.i.c.e().d(new b(this, optString, optJSONObject.toString()), "UbcAndCeresStatisticEventApi", true);
                    c.a.r0.a.u1.k.f.j().i().d(jSONObject);
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("content");
                    String str2 = null;
                    if (optJSONObject2 != null) {
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("ext");
                        String optString3 = optJSONObject2.optString("type");
                        optJSONObject2.remove("type");
                        optJSONObject2.remove("from");
                        y(optJSONObject3);
                        str2 = optString3;
                    }
                    jSONObject.remove("ubcId");
                    try {
                        jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
                        jSONObject.putOpt("eventType", "0");
                        jSONObject.putOpt("propagation", w.f(jSONObject.optJSONObject("propagation"), "source", c.a.r0.a.d2.d.J().r().V().T()));
                        jSONObject.put("eventName", str2);
                    } catch (JSONException unused) {
                    }
                    c.a.r0.a.e0.d.i("UbcAndCeresStatisticEventApi", "OpenStat : " + jSONObject);
                    c.a.r0.a.u1.k.i.c.e().d(new c(this, optString2, jSONObject), "OpenStatisticEvent", true);
                    return c.a.r0.a.u.h.b.f();
                }
                return new c.a.r0.a.u.h.b(202);
            }
            return bVar;
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }
}
