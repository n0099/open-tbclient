package b.a.p0.b.n;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.b.p.g.e;
import b.a.p0.b.p.g.f;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9374e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f9375f;

        public a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9375f = cVar;
            this.f9374e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    this.f9375f.v(this.f9374e);
                    return;
                }
                int b2 = iVar.b();
                String f2 = b.a.p0.a.e2.c.d.f(b2);
                if (b.a.p0.a.u.c.d.f8000c) {
                    String str = "quick login failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX;
                }
                this.f9375f.d(this.f9374e, new b.a.p0.a.u.h.b(b2, b.a.p0.a.e2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.b.p.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9376a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f9377b;

        /* loaded from: classes.dex */
        public class a implements e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f9378a;

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
                this.f9378a = bVar;
            }

            @Override // b.a.p0.b.p.g.e
            public void onResult(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    if (i2 == 0) {
                        b bVar = this.f9378a;
                        bVar.f9377b.d(bVar.f9376a, new b.a.p0.a.u.h.b(0));
                        return;
                    }
                    b bVar2 = this.f9378a;
                    bVar2.f9377b.d(bVar2.f9376a, new b.a.p0.a.u.h.b(10004, "user not logged in"));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9377b = cVar;
            this.f9376a = str;
        }

        @Override // b.a.p0.b.p.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                if (quickLoginInfo == null) {
                    this.f9377b.d(this.f9376a, new b.a.p0.a.u.h.b(1001));
                    return;
                }
                boolean z = quickLoginInfo.supportQuickLogin;
                int i2 = quickLoginInfo.loginMode;
                if (z) {
                    f.e(b.a.p0.a.a2.d.g().x(), i2, new a(this));
                } else {
                    this.f9377b.d(this.f9376a, new b.a.p0.a.u.h.b(10004, "user not logged in"));
                }
            }
        }
    }

    /* renamed from: b.a.p0.b.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0489c implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9379e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f9380f;

        public C0489c(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9380f = cVar;
            this.f9379e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    this.f9380f.u(this.f9379e);
                    return;
                }
                int b2 = iVar.b();
                String f2 = b.a.p0.a.e2.c.d.f(b2);
                if (b.a.p0.a.u.c.d.f8000c) {
                    String str = "query quick login info failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX;
                }
                this.f9380f.d(this.f9379e, new b.a.p0.a.u.h.b(b2, b.a.p0.a.e2.c.d.f(b2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.b.p.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9381a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f9382b;

        public d(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9382b = cVar;
            this.f9381a = str;
        }

        @Override // b.a.p0.b.p.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                if (quickLoginInfo == null) {
                    this.f9382b.w(this.f9381a);
                } else {
                    this.f9382b.x(this.f9381a, quickLoginInfo);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public final void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            f.b(new d(this, str));
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            f.b(new b(this, str));
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            d(str, new b.a.p0.a.u.h.b(10001, "internal error"));
        }
    }

    public final void x(String str, QuickLoginInfo quickLoginInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, quickLoginInfo) == null) {
            if (quickLoginInfo == null) {
                d(str, new b.a.p0.a.u.h.b(1001));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("supportQuickLogin", quickLoginInfo.supportQuickLogin);
                jSONObject.put("encryptPhoneNum", quickLoginInfo.encryptPhoneNum);
                jSONObject.put("serviceAgreement", quickLoginInfo.serviceAgreement);
                jSONObject.put("hasHistory", quickLoginInfo.hasHistory);
                if (b.a.p0.a.u.c.d.f8000c) {
                    String str2 = "query login info; data: " + jSONObject.toString();
                }
                d(str, new b.a.p0.a.u.h.b(0, jSONObject));
            } catch (JSONException e2) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    e2.printStackTrace();
                }
                d(str, new b.a.p0.a.u.h.b(1001));
            }
        }
    }

    public b.a.p0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-QuickLogin", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (bVar.isSuccess() && (obj = b2.second) != null) {
                String optString = ((JSONObject) obj).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(1001, "cb is empty");
                }
                b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                if (P == null) {
                    return new b.a.p0.a.u.h.b(1001);
                }
                P.S().g(getContext(), "scope_quick_login", new C0489c(this, optString));
                return new b.a.p0.a.u.h.b(0);
            }
            b.a.p0.a.e0.d.b("Api-QuickLogin", "parse fail");
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-QuickLogin", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (bVar.isSuccess() && (obj = b2.second) != null) {
                String optString = ((JSONObject) obj).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(1001, "cb is empty");
                }
                b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                if (P == null) {
                    return new b.a.p0.a.u.h.b(1001);
                }
                P.S().g(getContext(), "scope_quick_login", new a(this, optString));
                return new b.a.p0.a.u.h.b(0);
            }
            b.a.p0.a.e0.d.b("Api-QuickLogin", "parse fail");
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
