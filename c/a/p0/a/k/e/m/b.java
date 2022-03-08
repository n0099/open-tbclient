package c.a.p0.a.k.e.m;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.p2.o0;
import c.a.p0.a.p2.q0;
import c.a.p0.a.t1.e;
import c.a.p0.a.x1.c.d;
import c.a.p0.a.x1.c.i;
import c.a.p0.a.x1.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a.p0.a.k.e.m.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f6194f;

    /* renamed from: g  reason: collision with root package name */
    public String f6195g;

    /* loaded from: classes.dex */
    public class a implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i2, @NonNull String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, jSONObject) == null) {
                this.a.f6194f = i2;
                this.a.f6195g = str;
            }
        }
    }

    /* renamed from: c.a.p0.a.k.e.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0363b implements c.a.p0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f6196e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6197f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6198g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SubscribeHelper f6199h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f6200i;

        /* renamed from: c.a.p0.a.k.e.m.b$b$a */
        /* loaded from: classes.dex */
        public class a implements SubscribeHelper.k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ C0363b a;

            public a(C0363b c0363b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0363b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = c0363b;
            }

            @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
            public void a(int i2, @NonNull String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, jSONObject) == null) {
                    if (jSONObject == null) {
                        C0363b c0363b = this.a;
                        c0363b.f6200i.d(c0363b.f6198g, new c.a.p0.a.k.h.b(i2, str));
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    C0363b c0363b2 = this.a;
                    c0363b2.f6200i.D(jSONObject, jSONObject2, c0363b2.f6199h);
                    C0363b c0363b3 = this.a;
                    c0363b3.f6200i.d(c0363b3.f6198g, new c.a.p0.a.k.h.b(i2, str, jSONObject2));
                }
            }
        }

        public C0363b(b bVar, e eVar, String str, String str2, SubscribeHelper subscribeHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, eVar, str, str2, subscribeHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6200i = bVar;
            this.f6196e = eVar;
            this.f6197f = str;
            this.f6198g = str2;
            this.f6199h = subscribeHelper;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.h(iVar)) {
                    this.f6200i.C(this.f6196e, this.f6197f, this.f6198g, this.f6199h);
                } else {
                    this.f6199h.o(this.f6197f, new a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SubscribeHelper f6201b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f6202c;

        public c(b bVar, String str, SubscribeHelper subscribeHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, subscribeHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6202c = bVar;
            this.a = str;
            this.f6201b = subscribeHelper;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i2, @NonNull String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, jSONObject) == null) {
                if (jSONObject == null) {
                    this.f6202c.d(this.a, new c.a.p0.a.k.h.b(i2, str));
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                this.f6202c.D(jSONObject, jSONObject2, this.f6201b);
                this.f6202c.d(this.a, new c.a.p0.a.k.h.b(i2, str, jSONObject2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.p0.a.k.c.b bVar) {
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
                super((c.a.p0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void B(e eVar, String str, String str2, SubscribeHelper subscribeHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, str, str2, subscribeHelper) == null) {
            eVar.d0().g(getContext(), "mapp_request_subscribe_message", new C0363b(this, eVar, str, str2, subscribeHelper));
        }
    }

    public final void C(e eVar, String str, String str2, SubscribeHelper subscribeHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, str, str2, subscribeHelper) == null) {
            if (TextUtils.equals(q0.n().f(), o0.g(eVar.V().e0())) && TextUtils.equals("1", eVar.V().i0())) {
                subscribeHelper.o(str, new c(this, str2, subscribeHelper));
            } else {
                d(str2, new c.a.p0.a.k.h.b(500107, "不符合使用条件"));
            }
        }
    }

    public final void D(JSONObject jSONObject, JSONObject jSONObject2, SubscribeHelper subscribeHelper) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, jSONObject2, subscribeHelper) == null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("list")) == null) {
                    return;
                }
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null && (optJSONArray2 = optJSONObject2.optJSONArray("sub_info")) != null) {
                        int length2 = optJSONArray2.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                            if (optJSONObject3 != null) {
                                jSONObject2.put(optJSONObject3.optString("template_id"), optJSONObject3.optString("formid"));
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                p("#parseDate put json data error", e2, false);
            }
        }
    }

    public c.a.p0.a.k.h.b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#requestSubscribeFormId params=" + str, false);
            e a0 = e.a0();
            if (a0 == null) {
                return new c.a.p0.a.k.h.b(202, "swan app is null");
            }
            String N = a0.N();
            if (TextUtils.isEmpty(N)) {
                return new c.a.p0.a.k.h.b(202, "appKey is empty");
            }
            Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((c.a.p0.a.k.h.b) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.p0.a.k.h.b(202, "cb is invalid");
                }
                SubscribeHelper subscribeHelper = new SubscribeHelper();
                if (!subscribeHelper.n(getContext(), a0, N, jSONObject, SubscribeHelper.invokeSubscribeFrom.REQUEST_SUBSCRIBE_FORM_ID_API, new a(this))) {
                    return new c.a.p0.a.k.h.b(this.f6194f, this.f6195g);
                }
                B(a0, N, optString, subscribeHelper);
                return c.a.p0.a.k.h.b.f();
            }
            return new c.a.p0.a.k.h.b(202);
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "RequestSubscribeFormIdApi" : (String) invokeV.objValue;
    }
}
