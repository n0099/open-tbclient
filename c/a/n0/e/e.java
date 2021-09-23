package c.a.n0.e;

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
        public final /* synthetic */ int f4158a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f4159b;

        public a(e eVar, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Long.valueOf(j2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4159b = eVar;
            this.f4158a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f4159b.z(jSONObject, this.f4158a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements TokenListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f4160a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f4161b;

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
            this.f4161b = eVar;
            this.f4160a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f4161b.C(jSONObject, this.f4160a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4162f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4163g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f4164h;

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
            this.f4164h = eVar;
            this.f4162f = jSONObject;
            this.f4163g = i2;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f4162f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                    String optString = this.f4162f.optString("authTypeDes", "");
                    if (optInt == 103000) {
                        if (!c.a.n0.b.c.f4105c) {
                            this.f4164h.u = System.currentTimeMillis();
                            this.f4164h.f4220h = this.f4162f.optString("token", "");
                            this.f4164h.e(this.f4163g, 0, 0, this.f4164h.f4215c, "preVerify success", 3);
                            return;
                        }
                        this.f4164h.e(this.f4163g, 1, 999, this.f4164h.f4215c, "device has risk.", 3);
                    } else if (optInt == 105312 && this.f4164h.f4215c != this.f4164h.f4216d) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("pre verify");
                        sb.append(" error, wrong sim operator");
                        this.f4164h.e(this.f4163g, 3, 2002, this.f4164h.f4215c, sb.toString(), 3);
                    } else {
                        e eVar = this.f4164h;
                        int i2 = this.f4163g;
                        int i3 = this.f4164h.f4215c;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("pre verify");
                        sb2.append(" error.");
                        sb2.append(optString);
                        eVar.e(i2, 2, optInt, i3, sb2.toString(), 3);
                    }
                } catch (Throwable th) {
                    c.a.n0.l.c.d(th);
                    e eVar2 = this.f4164h;
                    int i4 = this.f4163g;
                    int i5 = eVar2.f4215c;
                    eVar2.e(i4, 3, 2009, i5, "cm on handle pre verify unknown error.", 3);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4165f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4166g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f4167h;

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
            this.f4167h = eVar;
            this.f4165f = jSONObject;
            this.f4166g = i2;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f4165f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                    String optString = this.f4165f.optString("desc", "");
                    if (optInt == 103000) {
                        if (!c.a.n0.b.c.f4105c) {
                            this.f4167h.t = System.currentTimeMillis();
                            this.f4167h.f4219g = this.f4165f.optString("securityphone", "");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f4167h.a(this.f4167h.f4219g));
                            this.f4167h.e(this.f4166g, 0, 0, this.f4167h.f4215c, jSONObject.toString(), 1);
                            return;
                        }
                        this.f4167h.e(this.f4166g, 1, 999, this.f4167h.f4215c, "device has risk.", 1);
                    } else if (optInt == 105312 && this.f4167h.f4215c != this.f4167h.f4216d) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("pre login");
                        sb.append(" error, wrong sim operator");
                        this.f4167h.e(this.f4166g, 3, 2002, this.f4167h.f4215c, sb.toString(), 1);
                    } else {
                        e eVar = this.f4167h;
                        int i2 = this.f4166g;
                        int i3 = this.f4167h.f4215c;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("pre login");
                        sb2.append(" error.");
                        sb2.append(optString);
                        eVar.e(i2, 2, optInt, i3, sb2.toString(), 1);
                    }
                } catch (Throwable th) {
                    c.a.n0.l.c.d(th);
                    e eVar2 = this.f4167h;
                    int i4 = this.f4166g;
                    int i5 = eVar2.f4215c;
                    eVar2.e(i4, 3, 2009, i5, "cm on handle pre login unknown error.", 1);
                }
            }
        }
    }

    /* renamed from: c.a.n0.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0106e extends c.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4168f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4169g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f4170h;

        public C0106e(e eVar, JSONObject jSONObject, int i2) {
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
            this.f4170h = eVar;
            this.f4168f = jSONObject;
            this.f4169g = i2;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f4168f.has(MiPushCommandMessage.KEY_RESULT_CODE) ? this.f4168f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1) : -1;
                    if (optInt == 103000) {
                        this.f4170h.f4217e = this.f4168f.optString("token");
                        this.f4170h.b(this.f4169g);
                        return;
                    }
                    String optString = this.f4168f.optString("resultDesc", "");
                    e eVar = this.f4170h;
                    int i2 = this.f4169g;
                    int i3 = this.f4170h.f4215c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("error:");
                    sb.append(optString);
                    eVar.d(i2, 2, optInt, i3, sb.toString());
                } catch (Throwable th) {
                    c.a.n0.l.c.d(th);
                    e eVar2 = this.f4170h;
                    eVar2.d(this.f4169g, 3, 2009, eVar2.f4215c, "cm on handle login unknown error.");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends c.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4171f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f4172g;

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
            this.f4172g = eVar;
            this.f4171f = i2;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f4172g.g(this.f4171f, this.f4172g.f4215c, this.f4172g.f4220h);
                } catch (Throwable th) {
                    c.a.n0.l.c.d(th);
                    e eVar = this.f4172g;
                    eVar.m(this.f4171f, 3, 2009, eVar.f4215c, "cm on handle verify unknown error.");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements TokenListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f4173a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f4174b;

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
            this.f4174b = eVar;
            this.f4173a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f4174b.w(jSONObject, this.f4173a);
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
        this.f4215c = 1;
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            c.a.n0.k.e.c().b(new f(this, i2));
        }
    }

    public final void C(JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, i2) == null) {
            c.a.n0.k.e.c().b(new c(this, jSONObject, i2));
        }
    }

    @Override // c.a.n0.e.i
    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i2) == null) {
            super.h(context, i2);
            if (!c.a.n0.b.a.h(this.f4213a).d()) {
                e(i2, 3, 997, this.f4215c, "pre login error. sdk stop run.", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f4215c, "pre login error. cm has not valid config.", 1);
            } else if (c.a.n0.b.a.h(this.f4213a).p0()) {
                if (!this.v) {
                    System.currentTimeMillis();
                    AuthnHelper authnHelper = AuthnHelper.getInstance(this.f4213a);
                    this.s = authnHelper;
                    authnHelper.setOverTime(8000L);
                    this.v = true;
                }
                this.s.getPhoneInfo(i.k, i.l, new a(this, System.currentTimeMillis(), i2));
            } else {
                e(i2, 3, 994, this.f4215c, "pre login error. cm sdk stop run.", 1);
            }
        }
    }

    @Override // c.a.n0.e.i
    public void i(Context context, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.i(context, i2, j2);
            c(i2, 2);
            this.s.loginAuth(i.k, i.l, new g(this, i2));
        }
    }

    @Override // c.a.n0.e.i
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t == 0 || System.currentTimeMillis() - this.t >= TimeUnit.HOURS.toMillis(1L) : invokeV.booleanValue;
    }

    @Override // c.a.n0.e.i
    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, context, i2) == null) {
            super.o(context, i2);
            if (!c.a.n0.b.a.h(this.f4213a).d()) {
                e(i2, 3, 997, this.f4215c, "pre verify error. sdk stop run.", 3);
            } else if (!r()) {
                e(i2, 3, 2006, this.f4215c, "pre verify error. cm has not valid config.", 3);
            } else if (c.a.n0.b.a.h(this.f4213a).p0()) {
                if (!this.v) {
                    AuthnHelper authnHelper = AuthnHelper.getInstance(this.f4213a);
                    this.s = authnHelper;
                    authnHelper.setOverTime(8000L);
                    this.v = true;
                }
                this.s.mobileAuth(i.k, i.l, new b(this, i2));
            } else {
                e(i2, 3, 994, this.f4215c, "pre verify error. cm sdk stop run.", 3);
            }
        }
    }

    @Override // c.a.n0.e.i
    public void p(Context context, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.p(context, i2, j2);
            c(i2, 4);
            A(i2);
        }
    }

    @Override // c.a.n0.e.i
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? System.currentTimeMillis() - this.u > 115000 : invokeV.booleanValue;
    }

    @Override // c.a.n0.e.i
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f4217e = null;
        }
    }

    @Override // c.a.n0.e.i
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f4220h = null;
            this.u = 0L;
        }
    }

    public final void w(JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, jSONObject, i2) == null) {
            c.a.n0.k.e.c().b(new C0106e(this, jSONObject, i2));
        }
    }

    public final void z(JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, jSONObject, i2) == null) {
            c.a.n0.k.e.c().b(new d(this, jSONObject, i2));
        }
    }
}
