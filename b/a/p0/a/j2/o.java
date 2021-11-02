package b.a.p0.a.j2;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.v2.w;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6379e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6380f;

        public a(o oVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6379e = str;
            this.f6380f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.equals(this.f6379e, "671")) {
                    b.a.p0.a.e0.d.h("ubcAndCeresStatisticEvent", "671 event=" + this.f6380f);
                }
                try {
                    b.a.p0.a.j2.b.m(this.f6379e, new JSONObject(this.f6380f));
                } catch (JSONException e2) {
                    b.a.p0.a.e0.d.h("ubcAndCeresStatisticEvent", e2.toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6381e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f6382f;

        public b(o oVar, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6381e = str;
            this.f6382f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.r.e.l(this.f6381e, this.f6382f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void q(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        b.a K = b.a.p0.a.a2.d.g().r().K();
        w.f(jSONObject, "launchId", K.U());
        w.f(jSONObject, "scheme", K.V());
        w.f(jSONObject, "appid", K.G());
        w.f(jSONObject, "swan", b.a.p0.a.m2.b.i(K.h0(), K.F()));
        w.f(jSONObject, "packageVersion", K.s1());
        w.f(jSONObject, "thirdversion", K.t1());
    }

    public b.a.p0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (b.a.p0.a.u.c.d.f8000c) {
                r0 = "data - " + str;
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-ubcAndCeresStatisticEvent", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) b2.second;
                String optString = jSONObject.optString("ubcId");
                String optString2 = jSONObject.optString("bizId");
                JSONObject optJSONObject = jSONObject.optJSONObject("content");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optJSONObject != null) {
                    w.f(optJSONObject, "source", b.a.p0.a.a2.d.g().r().K().S());
                    q(optJSONObject.optJSONObject("ext"));
                    b.a.p0.a.r1.k.i.c.f().e(new a(this, optString, optJSONObject.toString()), "Api-ubcAndCeresStatisticEvent");
                    b.a.p0.a.r1.k.f.j().i().d(jSONObject);
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("content");
                    String str2 = null;
                    if (optJSONObject2 != null) {
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("ext");
                        String optString3 = optJSONObject2.optString("type");
                        optJSONObject2.remove("type");
                        optJSONObject2.remove("from");
                        q(optJSONObject3);
                        str2 = optString3;
                    }
                    jSONObject.remove("ubcId");
                    try {
                        jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
                        jSONObject.putOpt("eventType", "0");
                        jSONObject.putOpt("propagation", w.f(jSONObject.optJSONObject("propagation"), "source", b.a.p0.a.a2.d.g().r().K().S()));
                        jSONObject.put("eventName", str2);
                    } catch (JSONException e2) {
                        if (b.a.p0.a.u.c.d.f8000c) {
                            e2.printStackTrace();
                        }
                    }
                    b.a.p0.a.e0.d.g("Api-ubcAndCeresStatisticEvent", "OpenStat : " + jSONObject);
                    b.a.p0.a.r1.k.i.c.f().e(new b(this, optString2, jSONObject), "OpenStatisticEvent");
                    return new b.a.p0.a.u.h.b(0);
                }
                return new b.a.p0.a.u.h.b(202);
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
