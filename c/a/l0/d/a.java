package c.a.l0.d;

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
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.l0.d.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AuthnHelper s;
    public long t;
    public long u;
    public boolean v;

    /* renamed from: c.a.l0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0198a extends c.a.l0.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3529b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3530c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f3531d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3532e;

        public C0198a(a aVar, long j, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3532e = aVar;
            this.f3529b = i;
            this.f3530c = i2;
            this.f3531d = i3;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                long currentTimeMillis = System.currentTimeMillis() - a();
                int optInt = jSONObject.optInt("resultCode", -1);
                if (!this.f3532e.D(optInt, this.f3529b) || (i = this.f3530c) != 0) {
                    this.f3532e.C(jSONObject, this.f3529b);
                } else {
                    this.f3532e.v(this.f3529b, this.f3531d, i + 1);
                }
                i.c().j();
                a aVar = this.f3532e;
                c.a.l0.i.d.c(aVar.a, aVar.f3550c, optInt, currentTimeMillis, this.f3531d, "");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements TokenListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f3533b;

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
            this.f3533b = aVar;
            this.a = i;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f3533b.G(jSONObject, this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3534b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3535c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f3536d;

        public c(a aVar, JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSONObject, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3536d = aVar;
            this.f3534b = jSONObject;
            this.f3535c = i;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f3534b.optInt("resultCode", -1);
                    String optString = this.f3534b.optString("authTypeDes", "");
                    if (optInt == 103000) {
                        this.f3536d.u = System.currentTimeMillis();
                        this.f3536d.f3555h = this.f3534b.optString("token", "");
                        this.f3536d.e(this.f3535c, 0, 0, this.f3536d.f3550c, "preVerify success", 3);
                    } else if (optInt == 105312 && this.f3536d.f3550c != this.f3536d.f3551d) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("pre verify");
                        sb.append(" error, wrong sim operator");
                        this.f3536d.e(this.f3535c, 3, 2002, this.f3536d.f3550c, sb.toString(), 3);
                    } else {
                        a aVar = this.f3536d;
                        int i = this.f3535c;
                        int i2 = this.f3536d.f3550c;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("pre verify");
                        sb2.append(" error.");
                        sb2.append(optString);
                        aVar.e(i, 2, optInt, i2, sb2.toString(), 3);
                    }
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                    a aVar2 = this.f3536d;
                    int i3 = this.f3535c;
                    int i4 = aVar2.f3550c;
                    aVar2.e(i3, 3, 2009, i4, "cm on handle pre verify unknown error.", 3);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3537b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3538c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f3539d;

        public d(a aVar, JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSONObject, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3539d = aVar;
            this.f3537b = jSONObject;
            this.f3538c = i;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f3537b.optInt("resultCode", -1);
                    String optString = this.f3537b.optString("desc", "");
                    if (optInt == 103000) {
                        this.f3539d.t = System.currentTimeMillis();
                        this.f3539d.f3554g = this.f3537b.optString("securityphone", "");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f3539d.a(this.f3539d.f3554g));
                        this.f3539d.e(this.f3538c, 0, 0, this.f3539d.f3550c, jSONObject.toString(), 1);
                    } else if (optInt == 105312 && this.f3539d.f3550c != this.f3539d.f3551d) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("pre login");
                        sb.append(" error, wrong sim operator");
                        this.f3539d.e(this.f3538c, 3, 2002, this.f3539d.f3550c, sb.toString(), 1);
                    } else {
                        a aVar = this.f3539d;
                        int i = this.f3538c;
                        int i2 = this.f3539d.f3550c;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("pre login");
                        sb2.append(" error.");
                        sb2.append(optString);
                        aVar.e(i, 2, optInt, i2, sb2.toString(), 1);
                    }
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                    a aVar2 = this.f3539d;
                    int i3 = this.f3538c;
                    int i4 = aVar2.f3550c;
                    aVar2.e(i3, 3, 2009, i4, "cm on handle pre login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3540b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3541c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f3542d;

        public e(a aVar, JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSONObject, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3542d = aVar;
            this.f3540b = jSONObject;
            this.f3541c = i;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f3540b.has("resultCode") ? this.f3540b.optInt("resultCode", -1) : -1;
                    if (optInt == 103000) {
                        this.f3542d.f3552e = this.f3540b.optString("token");
                        this.f3542d.b(this.f3541c);
                        return;
                    }
                    String optString = this.f3540b.optString("resultDesc", "");
                    a aVar = this.f3542d;
                    int i = this.f3541c;
                    int i2 = this.f3542d.f3550c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("error:");
                    sb.append(optString);
                    aVar.d(i, 2, optInt, i2, sb.toString());
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                    a aVar2 = this.f3542d;
                    aVar2.d(this.f3541c, 3, 2009, aVar2.f3550c, "cm on handle login unknown error.");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3543b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f3544c;

        public f(a aVar, int i) {
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
            this.f3544c = aVar;
            this.f3543b = i;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f3544c.g(this.f3543b, this.f3544c.f3550c, this.f3544c.f3555h);
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                    a aVar = this.f3544c;
                    aVar.n(this.f3543b, 3, 2009, aVar.f3550c, "cm on handle verify unknown error.");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements TokenListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f3545b;

        public g(a aVar, int i) {
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
            this.f3545b = aVar;
            this.a = i;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f3545b.y(jSONObject, this.a);
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
        this.t = 0L;
        this.u = 0L;
        this.v = false;
        this.f3550c = 1;
    }

    public final void C(JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i) == null) {
            c.a.l0.l.e.c().b(new d(this, jSONObject, i));
        }
    }

    public final boolean D(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            return c.a.l0.b.a.f(this.a).b() && c.a.l0.b.a.f(this.a).m("k_retry_code_cm", i) && c.a.l0.c.a.c().h(i2);
        }
        return invokeII.booleanValue;
    }

    public final void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            c.a.l0.l.e.c().b(new f(this, i));
        }
    }

    public final void G(JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, jSONObject, i) == null) {
            c.a.l0.l.e.c().b(new c(this, jSONObject, i));
        }
    }

    @Override // c.a.l0.d.d
    public void h(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, context, i) == null) {
            super.h(context, i);
            if (!c.a.l0.b.a.f(this.a).c()) {
                e(i, 3, 997, this.f3550c, "pre verify error. sdk stop run.", 3);
            } else if (!r()) {
                e(i, 3, 2006, this.f3550c, "pre verify error. cm has not valid config.", 3);
            } else if (c.a.l0.b.a.f(this.a).p0()) {
                if (!this.v) {
                    AuthnHelper authnHelper = AuthnHelper.getInstance(this.a);
                    this.s = authnHelper;
                    authnHelper.setOverTime(8000L);
                    this.v = true;
                }
                this.s.mobileAuth(c.a.l0.d.d.k, c.a.l0.d.d.l, new b(this, i));
            } else {
                e(i, 3, 994, this.f3550c, "pre verify error. cm sdk stop run.", 3);
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
                e(i2, 3, 2006, this.f3550c, "pre login error. cm has not valid config.", 1);
            } else if (c.a.l0.b.a.f(this.a).p0()) {
                if (!this.v) {
                    System.currentTimeMillis();
                    AuthnHelper authnHelper = AuthnHelper.getInstance(this.a);
                    this.s = authnHelper;
                    authnHelper.setOverTime(8000L);
                    this.v = true;
                }
                v(i2, i, 0);
            } else {
                e(i2, 3, 994, this.f3550c, "pre login error. cm sdk stop run.", 1);
            }
        }
    }

    @Override // c.a.l0.d.d
    public void j(Context context, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.j(context, i, j);
            c(i, 2);
            this.s.loginAuth(c.a.l0.d.d.k, c.a.l0.d.d.l, new g(this, i));
        }
    }

    @Override // c.a.l0.d.d
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.t == 0 || System.currentTimeMillis() - this.t >= TimeUnit.HOURS.toMillis(1L) : invokeV.booleanValue;
    }

    @Override // c.a.l0.d.d
    public void p(Context context, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.p(context, i, j);
            c(i, 4);
            E(i);
        }
    }

    @Override // c.a.l0.d.d
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? System.currentTimeMillis() - this.u > 115000 : invokeV.booleanValue;
    }

    @Override // c.a.l0.d.d
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f3552e = null;
        }
    }

    @Override // c.a.l0.d.d
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f3555h = null;
            this.u = 0L;
        }
    }

    public final void v(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048588, this, i, i2, i3) == null) {
            this.s.getPhoneInfo(c.a.l0.d.d.k, c.a.l0.d.d.l, new C0198a(this, System.currentTimeMillis(), i, i3, i2));
        }
    }

    public final void y(JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, jSONObject, i) == null) {
            c.a.l0.l.e.c().b(new e(this, jSONObject, i));
        }
    }
}
