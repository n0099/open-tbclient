package c.a.s0.a.u.e.m;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.s0.a.d2.e;
import c.a.s0.a.h2.c.d;
import c.a.s0.a.h2.c.i;
import c.a.s0.a.h2.c.j.b;
import c.a.s0.a.z2.o0;
import c.a.s0.a.z2.q0;
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
public class b extends c.a.s0.a.u.e.m.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f9466f;

    /* renamed from: g  reason: collision with root package name */
    public String f9467g;

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
                this.a.f9466f = i2;
                this.a.f9467g = str;
            }
        }
    }

    /* renamed from: c.a.s0.a.u.e.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0606b implements c.a.s0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f9468e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9469f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9470g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SubscribeHelper f9471h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f9472i;

        /* renamed from: c.a.s0.a.u.e.m.b$b$a */
        /* loaded from: classes.dex */
        public class a implements SubscribeHelper.k {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ C0606b a;

            public a(C0606b c0606b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0606b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = c0606b;
            }

            @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
            public void a(int i2, @NonNull String str, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, jSONObject) == null) {
                    if (jSONObject == null) {
                        C0606b c0606b = this.a;
                        c0606b.f9472i.d(c0606b.f9470g, new c.a.s0.a.u.h.b(i2, str));
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    C0606b c0606b2 = this.a;
                    c0606b2.f9472i.D(jSONObject, jSONObject2, c0606b2.f9471h);
                    C0606b c0606b3 = this.a;
                    c0606b3.f9472i.d(c0606b3.f9470g, new c.a.s0.a.u.h.b(i2, str, jSONObject2));
                }
            }
        }

        public C0606b(b bVar, e eVar, String str, String str2, SubscribeHelper subscribeHelper) {
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
            this.f9472i = bVar;
            this.f9468e = eVar;
            this.f9469f = str;
            this.f9470g = str2;
            this.f9471h = subscribeHelper;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.h(iVar)) {
                    this.f9472i.C(this.f9468e, this.f9469f, this.f9470g, this.f9471h);
                } else {
                    this.f9471h.o(this.f9469f, new a(this));
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
        public final /* synthetic */ SubscribeHelper f9473b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f9474c;

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
            this.f9474c = bVar;
            this.a = str;
            this.f9473b = subscribeHelper;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i2, @NonNull String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, jSONObject) == null) {
                if (jSONObject == null) {
                    this.f9474c.d(this.a, new c.a.s0.a.u.h.b(i2, str));
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                this.f9474c.D(jSONObject, jSONObject2, this.f9473b);
                this.f9474c.d(this.a, new c.a.s0.a.u.h.b(i2, str, jSONObject2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.s0.a.u.c.b bVar) {
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
                super((c.a.s0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void B(e eVar, String str, String str2, SubscribeHelper subscribeHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, str, str2, subscribeHelper) == null) {
            eVar.d0().g(getContext(), "mapp_request_subscribe_message", new C0606b(this, eVar, str, str2, subscribeHelper));
        }
    }

    public final void C(e eVar, String str, String str2, SubscribeHelper subscribeHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, str, str2, subscribeHelper) == null) {
            if (TextUtils.equals(q0.n().f(), o0.g(eVar.V().e0())) && TextUtils.equals("1", eVar.V().i0())) {
                subscribeHelper.o(str, new c(this, str2, subscribeHelper));
            } else {
                d(str2, new c.a.s0.a.u.h.b(500107, "不符合使用条件"));
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

    public c.a.s0.a.u.h.b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#requestSubscribeFormId params=" + str, false);
            e a0 = e.a0();
            if (a0 == null) {
                return new c.a.s0.a.u.h.b(202, "swan app is null");
            }
            String N = a0.N();
            if (TextUtils.isEmpty(N)) {
                return new c.a.s0.a.u.h.b(202, "appKey is empty");
            }
            Pair<c.a.s0.a.u.h.b, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((c.a.s0.a.u.h.b) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.s0.a.u.h.b(202, "cb is invalid");
                }
                SubscribeHelper subscribeHelper = new SubscribeHelper();
                if (!subscribeHelper.n(getContext(), a0, N, jSONObject, SubscribeHelper.invokeSubscribeFrom.REQUEST_SUBSCRIBE_FORM_ID_API, new a(this))) {
                    return new c.a.s0.a.u.h.b(this.f9466f, this.f9467g);
                }
                B(a0, N, optString, subscribeHelper);
                return c.a.s0.a.u.h.b.f();
            }
            return new c.a.s0.a.u.h.b(202);
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.s0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "RequestSubscribeFormIdApi" : (String) invokeV.objValue;
    }
}
