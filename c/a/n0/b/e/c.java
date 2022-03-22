package c.a.n0.b.e;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
import c.a.n0.b.g.d.e;
import c.a.n0.b.g.d.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.k.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8009b;

        public a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8009b = cVar;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    this.f8009b.C(this.a);
                    return;
                }
                int b2 = iVar.b();
                c.a.n0.a.x1.c.d.f(b2);
                this.f8009b.d(this.a, new c.a.n0.a.k.h.b(b2, c.a.n0.a.x1.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.b.g.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8010b;

        /* loaded from: classes.dex */
        public class a implements e {
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // c.a.n0.b.g.d.e
            public void onResult(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    if (i == 0) {
                        b bVar = this.a;
                        bVar.f8010b.d(bVar.a, new c.a.n0.a.k.h.b(0));
                        return;
                    }
                    b bVar2 = this.a;
                    bVar2.f8010b.d(bVar2.a, new c.a.n0.a.k.h.b(10004, "user not logged in"));
                }
            }
        }

        public b(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8010b = cVar;
            this.a = str;
        }

        @Override // c.a.n0.b.g.d.c
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                if (quickLoginInfo == null) {
                    this.f8010b.d(this.a, new c.a.n0.a.k.h.b(1001));
                    return;
                }
                boolean z = quickLoginInfo.supportQuickLogin;
                int i = quickLoginInfo.loginMode;
                if (z) {
                    f.e(c.a.n0.a.t1.d.J().x(), i, new a(this));
                } else {
                    this.f8010b.d(this.a, new c.a.n0.a.k.h.b(10004, "user not logged in"));
                }
            }
        }
    }

    /* renamed from: c.a.n0.b.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0620c implements c.a.n0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8011b;

        public C0620c(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8011b = cVar;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    this.f8011b.B(this.a);
                    return;
                }
                int b2 = iVar.b();
                c.a.n0.a.x1.c.d.f(b2);
                this.f8011b.d(this.a, new c.a.n0.a.k.h.b(b2, c.a.n0.a.x1.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.n0.b.g.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8012b;

        public d(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8012b = cVar;
            this.a = str;
        }

        @Override // c.a.n0.b.g.d.c
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                if (quickLoginInfo == null) {
                    this.f8012b.D(this.a);
                } else {
                    this.f8012b.E(this.a, quickLoginInfo);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            f.b(new d(this, str));
        }
    }

    public final void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            f.b(new b(this, str));
        }
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            d(str, new c.a.n0.a.k.h.b(10001, "internal error"));
        }
    }

    public final void E(String str, QuickLoginInfo quickLoginInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, quickLoginInfo) == null) {
            if (quickLoginInfo == null) {
                d(str, new c.a.n0.a.k.h.b(1001));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("supportQuickLogin", quickLoginInfo.supportQuickLogin);
                jSONObject.put("encryptPhoneNum", quickLoginInfo.encryptPhoneNum);
                jSONObject.put("serviceAgreement", quickLoginInfo.serviceAgreement);
                jSONObject.put("hasHistory", quickLoginInfo.hasHistory);
                d(str, new c.a.n0.a.k.h.b(0, jSONObject));
            } catch (JSONException unused) {
                d(str, new c.a.n0.a.k.h.b(1001));
            }
        }
    }

    public c.a.n0.a.k.h.b F(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess() && (obj = s.second) != null) {
                String optString = ((JSONObject) obj).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.n0.a.k.h.b(1001, "cb is empty");
                }
                c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
                if (a0 == null) {
                    return new c.a.n0.a.k.h.b(1001);
                }
                a0.d0().g(getContext(), "scope_quick_login", new C0620c(this, optString));
                return new c.a.n0.a.k.h.b(0);
            }
            c.a.n0.a.u.d.c("QuickLoginApi", "parse fail");
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public c.a.n0.a.k.h.b G(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#quickLogin", false);
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (!bVar.isSuccess() || (obj = s.second) == null) {
                return bVar;
            }
            String optString = ((JSONObject) obj).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.n0.a.k.h.b(1001, "cb is empty");
            }
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                return new c.a.n0.a.k.h.b(1001);
            }
            a0.d0().g(getContext(), "scope_quick_login", new a(this, optString));
            return c.a.n0.a.k.h.b.f();
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "PrivateBusiness" : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "QuickLoginApi" : (String) invokeV.objValue;
    }
}
