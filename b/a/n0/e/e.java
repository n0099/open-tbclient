package b.a.n0.e;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AuthnHelper s;
    public long t;
    public long u;
    public boolean v;

    /* loaded from: classes.dex */
    public class a implements TokenListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3564a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f3565b;

        public a(e eVar, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3565b = eVar;
            this.f3564a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f3565b.z(jSONObject, this.f3564a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements TokenListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3566a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f3567b;

        public b(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3567b = eVar;
            this.f3566a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f3567b.C(jSONObject, this.f3566a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3568f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3569g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f3570h;

        public c(e eVar, JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3570h = eVar;
            this.f3568f = jSONObject;
            this.f3569g = i2;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f3568f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                    String optString = this.f3568f.optString("authTypeDes", "");
                    if (optInt == 103000) {
                        if (!b.a.n0.b.c.f3511c) {
                            this.f3570h.u = System.currentTimeMillis();
                            this.f3570h.f3626h = this.f3568f.optString("token", "");
                            this.f3570h.e(this.f3569g, 0, 0, this.f3570h.f3621c, "preVerify success", 3);
                            return;
                        }
                        this.f3570h.e(this.f3569g, 1, 999, this.f3570h.f3621c, "device has risk.", 3);
                    } else if (optInt == 105312 && this.f3570h.f3621c != this.f3570h.f3622d) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("pre verify");
                        sb.append(" error, wrong sim operator");
                        this.f3570h.e(this.f3569g, 3, 2002, this.f3570h.f3621c, sb.toString(), 3);
                    } else {
                        e eVar = this.f3570h;
                        int i2 = this.f3569g;
                        int i3 = this.f3570h.f3621c;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("pre verify");
                        sb2.append(" error.");
                        sb2.append(optString);
                        eVar.e(i2, 2, optInt, i3, sb2.toString(), 3);
                    }
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                    e eVar2 = this.f3570h;
                    int i4 = this.f3569g;
                    int i5 = eVar2.f3621c;
                    eVar2.e(i4, 3, 2009, i5, "cm on handle pre verify unknown error.", 3);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3571f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3572g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f3573h;

        public d(e eVar, JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3573h = eVar;
            this.f3571f = jSONObject;
            this.f3572g = i2;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f3571f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                    String optString = this.f3571f.optString("desc", "");
                    if (optInt == 103000) {
                        if (!b.a.n0.b.c.f3511c) {
                            this.f3573h.t = System.currentTimeMillis();
                            this.f3573h.f3625g = this.f3571f.optString("securityphone", "");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f3573h.a(this.f3573h.f3625g));
                            this.f3573h.e(this.f3572g, 0, 0, this.f3573h.f3621c, jSONObject.toString(), 1);
                            return;
                        }
                        this.f3573h.e(this.f3572g, 1, 999, this.f3573h.f3621c, "device has risk.", 1);
                    } else if (optInt == 105312 && this.f3573h.f3621c != this.f3573h.f3622d) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("pre login");
                        sb.append(" error, wrong sim operator");
                        this.f3573h.e(this.f3572g, 3, 2002, this.f3573h.f3621c, sb.toString(), 1);
                    } else {
                        e eVar = this.f3573h;
                        int i2 = this.f3572g;
                        int i3 = this.f3573h.f3621c;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("pre login");
                        sb2.append(" error.");
                        sb2.append(optString);
                        eVar.e(i2, 2, optInt, i3, sb2.toString(), 1);
                    }
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                    e eVar2 = this.f3573h;
                    int i4 = this.f3572g;
                    int i5 = eVar2.f3621c;
                    eVar2.e(i4, 3, 2009, i5, "cm on handle pre login unknown error.", 1);
                }
            }
        }
    }

    /* renamed from: b.a.n0.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0101e extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3574f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3575g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f3576h;

        public C0101e(e eVar, JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, jSONObject, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3576h = eVar;
            this.f3574f = jSONObject;
            this.f3575g = i2;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f3574f.has(MiPushCommandMessage.KEY_RESULT_CODE) ? this.f3574f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1) : -1;
                    if (optInt == 103000) {
                        this.f3576h.f3623e = this.f3574f.optString("token");
                        this.f3576h.b(this.f3575g);
                        return;
                    }
                    String optString = this.f3574f.optString("resultDesc", "");
                    e eVar = this.f3576h;
                    int i2 = this.f3575g;
                    int i3 = this.f3576h.f3621c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("error:");
                    sb.append(optString);
                    eVar.d(i2, 2, optInt, i3, sb.toString());
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                    e eVar2 = this.f3576h;
                    eVar2.d(this.f3575g, 3, 2009, eVar2.f3621c, "cm on handle login unknown error.");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3577f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f3578g;

        public f(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3578g = eVar;
            this.f3577f = i2;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f3578g.g(this.f3577f, this.f3578g.f3621c, this.f3578g.f3626h);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                    e eVar = this.f3578g;
                    eVar.m(this.f3577f, 3, 2009, eVar.f3621c, "cm on handle verify unknown error.");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements TokenListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3579a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f3580b;

        public g(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3580b = eVar;
            this.f3579a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f3580b.w(jSONObject, this.f3579a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = 0L;
        this.u = 0L;
        this.v = false;
        this.f3621c = 1;
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            b.a.n0.k.e.c().b(new f(this, i2));
        }
    }

    public final void C(JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i2) == null) {
            b.a.n0.k.e.c().b(new c(this, jSONObject, i2));
        }
    }

    @Override // b.a.n0.e.i
    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i2) == null) {
            super.h(context, i2);
            if (!b.a.n0.b.a.h(this.f3619a).d()) {
                e(i2, 3, 997, this.f3621c, "pre login error. sdk stop run.", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f3621c, "pre login error. cm has not valid config.", 1);
            } else if (b.a.n0.b.a.h(this.f3619a).p0()) {
                if (!this.v) {
                    System.currentTimeMillis();
                    AuthnHelper authnHelper = AuthnHelper.getInstance(this.f3619a);
                    this.s = authnHelper;
                    authnHelper.setOverTime(8000L);
                    this.v = true;
                }
                this.s.getPhoneInfo(i.k, i.l, new a(this, System.currentTimeMillis(), i2));
            } else {
                e(i2, 3, 994, this.f3621c, "pre login error. cm sdk stop run.", 1);
            }
        }
    }

    @Override // b.a.n0.e.i
    public void i(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.i(context, i2, j);
            c(i2, 2);
            this.s.loginAuth(i.k, i.l, new g(this, i2));
        }
    }

    @Override // b.a.n0.e.i
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t == 0 || System.currentTimeMillis() - this.t >= TimeUnit.HOURS.toMillis(1L) : invokeV.booleanValue;
    }

    @Override // b.a.n0.e.i
    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, context, i2) == null) {
            super.o(context, i2);
            if (!b.a.n0.b.a.h(this.f3619a).d()) {
                e(i2, 3, 997, this.f3621c, "pre verify error. sdk stop run.", 3);
            } else if (!r()) {
                e(i2, 3, 2006, this.f3621c, "pre verify error. cm has not valid config.", 3);
            } else if (b.a.n0.b.a.h(this.f3619a).p0()) {
                if (!this.v) {
                    AuthnHelper authnHelper = AuthnHelper.getInstance(this.f3619a);
                    this.s = authnHelper;
                    authnHelper.setOverTime(8000L);
                    this.v = true;
                }
                this.s.mobileAuth(i.k, i.l, new b(this, i2));
            } else {
                e(i2, 3, 994, this.f3621c, "pre verify error. cm sdk stop run.", 3);
            }
        }
    }

    @Override // b.a.n0.e.i
    public void p(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.p(context, i2, j);
            c(i2, 4);
            A(i2);
        }
    }

    @Override // b.a.n0.e.i
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? System.currentTimeMillis() - this.u > 115000 : invokeV.booleanValue;
    }

    @Override // b.a.n0.e.i
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f3623e = null;
        }
    }

    @Override // b.a.n0.e.i
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f3626h = null;
            this.u = 0L;
        }
    }

    public final void w(JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, jSONObject, i2) == null) {
            b.a.n0.k.e.c().b(new C0101e(this, jSONObject, i2));
        }
    }

    public final void z(JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, jSONObject, i2) == null) {
            b.a.n0.k.e.c().b(new d(this, jSONObject, i2));
        }
    }
}
