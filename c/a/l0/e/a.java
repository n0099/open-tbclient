package c.a.l0.e;

import android.content.Context;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.l0.d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean s;

    /* renamed from: c.a.l0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0200a extends c.a.l0.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3590b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3591c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f3592d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3593e;

        public C0200a(a aVar, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3593e = aVar;
            this.f3590b = i;
            this.f3591c = i2;
            this.f3592d = i3;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                long currentTimeMillis = System.currentTimeMillis() - a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("result", -1);
                    String optString = jSONObject.optString("reqId", "");
                    if (!this.f3593e.L(optInt, this.f3590b) || this.f3591c != 0) {
                        this.f3593e.C(str, this.f3590b, 1);
                    } else {
                        this.f3593e.x(this.f3590b, this.f3592d, this.f3591c + 1);
                    }
                    c.a.l0.i.d.c(this.f3593e.a, this.f3593e.f3550c, optInt, currentTimeMillis, this.f3592d, optString);
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements PreCodeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f3594b;

        public b(a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3594b = aVar;
            this.a = i;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f3594b.C(str, this.a, 3);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3595b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3596c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f3597d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3598e;

        public c(a aVar, String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3598e = aVar;
            this.f3595b = str;
            this.f3596c = i;
            this.f3597d = i2;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f3595b);
                    if (jSONObject.optInt("result", -1) == 0) {
                        this.f3598e.K(jSONObject, this.f3596c, this.f3597d);
                    } else {
                        this.f3598e.D(jSONObject, this.f3596c, this.f3597d);
                    }
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3599b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3600c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f3601d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3602e;

        public d(a aVar, JSONObject jSONObject, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSONObject, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3602e = aVar;
            this.f3599b = jSONObject;
            this.f3600c = i;
            this.f3601d = i2;
        }

        @Override // c.a.l0.l.c
        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject optJSONObject = this.f3599b.optJSONObject("data");
                    if (this.f3600c == 1) {
                        this.f3602e.f3552e = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f3602e.f3554g = optJSONObject.optString("number", "");
                        this.f3602e.f3553f = System.currentTimeMillis() + (optJSONObject.optInt("expiredTime", 0) * 1000);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f3602e.a(this.f3602e.f3554g));
                        str = jSONObject.toString();
                    } else {
                        this.f3602e.f3555h = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f3602e.i = System.currentTimeMillis() + (optJSONObject.optInt("expiredTime", 0) * 1000);
                        str = "preVerify success";
                    }
                    this.f3602e.e(this.f3601d, 0, 0, this.f3602e.f3550c, str, this.f3600c);
                } catch (Throwable unused) {
                    a aVar = this.f3602e;
                    aVar.e(this.f3601d, 3, 2009, aVar.f3550c, "ct on handle pre login or verify unknown error.", this.f3600c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3603b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3604c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f3605d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3606e;

        public e(a aVar, JSONObject jSONObject, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSONObject, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3606e = aVar;
            this.f3603b = jSONObject;
            this.f3604c = i;
            this.f3605d = i2;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f3603b.optInt("result", -1);
                    String optString = this.f3603b.optString("msg", "");
                    if (this.f3606e.f3550c != this.f3606e.f3551d && (optInt == -10009 || optInt == -10008)) {
                        this.f3606e.e(this.f3604c, 3, 2002, this.f3606e.f3550c, "pre login error, wrong sim operator", this.f3605d);
                    } else {
                        a aVar = this.f3606e;
                        int i = this.f3604c;
                        int i2 = this.f3606e.f3550c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("ct pre login error.");
                        sb.append(optString);
                        sb.append(", status ");
                        sb.append(optInt);
                        aVar.e(i, 2, optInt, i2, sb.toString(), this.f3605d);
                    }
                } catch (Throwable unused) {
                    a aVar2 = this.f3606e;
                    aVar2.e(this.f3604c, 3, 2009, aVar2.f3550c, "ct on handle pre login or verify unknown error.", this.f3605d);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = false;
        this.f3550c = 3;
    }

    public final void C(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, str, i, i2) == null) {
            c.a.l0.l.e.c().b(new c(this, str, i, i2));
        }
    }

    public final void D(JSONObject jSONObject, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i, i2) == null) {
            c.a.l0.l.e.c().b(new e(this, jSONObject, i, i2));
        }
    }

    public final void K(JSONObject jSONObject, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i, i2) == null) {
            c.a.l0.l.e.c().b(new d(this, jSONObject, i2, i));
        }
    }

    public final boolean L(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            return c.a.l0.b.a.f(this.a).b() && c.a.l0.b.a.f(this.a).m("k_retry_code_ct", i) && c.a.l0.c.a.c().h(i2);
        }
        return invokeII.booleanValue;
    }

    @Override // c.a.l0.d.d
    public void h(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, context, i) == null) {
            super.h(context, i);
            if (!c.a.l0.b.a.f(this.a).c()) {
                e(i, 3, 997, this.f3550c, "pre verify error. sdk stop run.", 3);
            } else if (!r()) {
                e(i, 3, 2006, this.f3550c, "pre verify error. ct has not valid config.", 3);
            } else if (c.a.l0.b.a.f(this.a).q0()) {
                if (!this.s) {
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, c.a.l0.d.d.m, c.a.l0.d.d.n, new b(this, i));
            } else {
                e(i, 3, 996, this.f3550c, "pre verify error. ct sdk stop run.", 3);
            }
        }
    }

    @Override // c.a.l0.d.d
    public void i(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, context, i, i2) == null) {
            super.i(context, i, i2);
            if (!c.a.l0.b.a.f(this.a).c()) {
                e(i2, 3, 997, this.f3550c, "pre login error. sdk stop run.", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f3550c, "pre login error. ct has not valid config.", 1);
            } else if (c.a.l0.b.a.f(this.a).q0()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                x(i2, i, 0);
            } else {
                e(i2, 3, 996, this.f3550c, "pre login error. ct sdk stop run.", 1);
            }
        }
    }

    @Override // c.a.l0.d.e, c.a.l0.d.d
    public void p(Context context, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.p(context, i, j);
        }
    }

    public final void x(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048583, this, i, i2, i3) == null) {
            CtAuth.requestPreAuthCode(this.a, c.a.l0.d.d.m, c.a.l0.d.d.n, new C0200a(this, i, i3, i2));
        }
    }
}
