package c.a.l0.e;

import android.content.Context;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveFileData;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean s;

    /* loaded from: classes.dex */
    public class a implements PreCodeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3746a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f3747b;

        public a(f fVar, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Long.valueOf(j2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3747b = fVar;
            this.f3746a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f3747b.w(str, this.f3746a, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements PreCodeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3748a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f3749b;

        public b(f fVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3749b = fVar;
            this.f3748a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f3749b.w(str, this.f3748a, 3);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.l0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f3750f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3751g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f3752h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f3753i;

        public c(f fVar, String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3753i = fVar;
            this.f3750f = str;
            this.f3751g = i2;
            this.f3752h = i3;
        }

        @Override // c.a.l0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f3750f);
                    if (jSONObject.optInt("result", -1) == 0) {
                        this.f3753i.z(jSONObject, this.f3751g, this.f3752h);
                    } else {
                        this.f3753i.x(jSONObject, this.f3751g, this.f3752h);
                    }
                } catch (Throwable th) {
                    c.a.l0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.l0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3754f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3755g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3756h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f3757i;

        public d(f fVar, int i2, int i3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2), Integer.valueOf(i3), jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3757i = fVar;
            this.f3754f = i2;
            this.f3755g = i3;
            this.f3756h = jSONObject;
        }

        @Override // c.a.l0.k.c
        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (c.a.l0.b.c.f3676c) {
                        this.f3757i.e(this.f3754f, 1, 999, this.f3757i.f3786c, "device has risk.", this.f3755g);
                        return;
                    }
                    JSONObject optJSONObject = this.f3756h.optJSONObject("data");
                    if (this.f3755g == 1) {
                        this.f3757i.f3788e = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f3757i.f3790g = optJSONObject.optString(IdCardActivity.KEY_NUMBER, "");
                        this.f3757i.f3789f = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f3757i.a(this.f3757i.f3790g));
                        str = jSONObject.toString();
                    } else {
                        this.f3757i.f3791h = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f3757i.f3792i = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                        str = "preVerify success";
                    }
                    this.f3757i.e(this.f3754f, 0, 0, this.f3757i.f3786c, str, this.f3755g);
                } catch (Throwable unused) {
                    f fVar = this.f3757i;
                    fVar.e(this.f3754f, 3, 2009, fVar.f3786c, "ct on handle pre login or verify unknown error.", this.f3755g);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.l0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3758f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3759g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f3760h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f3761i;

        public e(f fVar, JSONObject jSONObject, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, jSONObject, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3761i = fVar;
            this.f3758f = jSONObject;
            this.f3759g = i2;
            this.f3760h = i3;
        }

        @Override // c.a.l0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f3758f.optInt("result", -1);
                    String optString = this.f3758f.optString("msg", "");
                    if (this.f3761i.f3786c != this.f3761i.f3787d && (optInt == -10009 || optInt == -10008)) {
                        this.f3761i.e(this.f3759g, 3, 2002, this.f3761i.f3786c, "pre login error, wrong sim operator", this.f3760h);
                    } else {
                        f fVar = this.f3761i;
                        int i2 = this.f3759g;
                        int i3 = this.f3761i.f3786c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("ct pre login error.");
                        sb.append(optString);
                        sb.append(", status ");
                        sb.append(optInt);
                        fVar.e(i2, 2, optInt, i3, sb.toString(), this.f3760h);
                    }
                } catch (Throwable unused) {
                    f fVar2 = this.f3761i;
                    fVar2.e(this.f3759g, 3, 2009, fVar2.f3786c, "ct on handle pre login or verify unknown error.", this.f3760h);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
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
        this.s = false;
        this.f3786c = 3;
    }

    @Override // c.a.l0.e.i
    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            super.h(context, i2);
            if (!c.a.l0.b.a.h(this.f3784a).d()) {
                e(i2, 3, 997, this.f3786c, "pre login error. sdk stop run.", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f3786c, "pre login error. ct has not valid config.", 1);
            } else if (c.a.l0.b.a.h(this.f3784a).a()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, i.m, i.n, new a(this, System.currentTimeMillis(), i2));
            } else {
                e(i2, 3, 996, this.f3786c, "pre login error. ct sdk stop run.", 1);
            }
        }
    }

    @Override // c.a.l0.e.i
    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            super.o(context, i2);
            if (!c.a.l0.b.a.h(this.f3784a).d()) {
                e(i2, 3, 997, this.f3786c, "pre verify error. sdk stop run.", 3);
            } else if (!r()) {
                e(i2, 3, 2006, this.f3786c, "pre verify error. ct has not valid config.", 3);
            } else if (c.a.l0.b.a.h(this.f3784a).a()) {
                if (!this.s) {
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, i.m, i.n, new b(this, i2));
            } else {
                e(i2, 3, 996, this.f3786c, "pre verify error. ct sdk stop run.", 3);
            }
        }
    }

    @Override // c.a.l0.e.j, c.a.l0.e.i
    public void p(Context context, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.p(context, i2, j2);
        }
    }

    public final void w(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, str, i2, i3) == null) {
            c.a.l0.k.e.c().b(new c(this, str, i2, i3));
        }
    }

    public final void x(JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, jSONObject, i2, i3) == null) {
            c.a.l0.k.e.c().b(new e(this, jSONObject, i2, i3));
        }
    }

    public final void z(JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, jSONObject, i2, i3) == null) {
            c.a.l0.k.e.c().b(new d(this, i2, i3, jSONObject));
        }
    }
}
