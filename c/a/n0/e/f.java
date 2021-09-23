package c.a.n0.e;

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
        public final /* synthetic */ int f4175a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f4176b;

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
            this.f4176b = fVar;
            this.f4175a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f4176b.w(str, this.f4175a, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements PreCodeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f4177a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f4178b;

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
            this.f4178b = fVar;
            this.f4177a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f4178b.w(str, this.f4177a, 3);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4179f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4180g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4181h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f4182i;

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
            this.f4182i = fVar;
            this.f4179f = str;
            this.f4180g = i2;
            this.f4181h = i3;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f4179f);
                    if (jSONObject.optInt("result", -1) == 0) {
                        this.f4182i.z(jSONObject, this.f4180g, this.f4181h);
                    } else {
                        this.f4182i.x(jSONObject, this.f4180g, this.f4181h);
                    }
                } catch (Throwable th) {
                    c.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4183f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4184g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4185h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f4186i;

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
            this.f4186i = fVar;
            this.f4183f = i2;
            this.f4184g = i3;
            this.f4185h = jSONObject;
        }

        @Override // c.a.n0.k.c
        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (c.a.n0.b.c.f4105c) {
                        this.f4186i.e(this.f4183f, 1, 999, this.f4186i.f4215c, "device has risk.", this.f4184g);
                        return;
                    }
                    JSONObject optJSONObject = this.f4185h.optJSONObject("data");
                    if (this.f4184g == 1) {
                        this.f4186i.f4217e = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f4186i.f4219g = optJSONObject.optString(IdCardActivity.KEY_NUMBER, "");
                        this.f4186i.f4218f = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f4186i.a(this.f4186i.f4219g));
                        str = jSONObject.toString();
                    } else {
                        this.f4186i.f4220h = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f4186i.f4221i = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                        str = "preVerify success";
                    }
                    this.f4186i.e(this.f4183f, 0, 0, this.f4186i.f4215c, str, this.f4184g);
                } catch (Throwable unused) {
                    f fVar = this.f4186i;
                    fVar.e(this.f4183f, 3, 2009, fVar.f4215c, "ct on handle pre login or verify unknown error.", this.f4184g);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4187f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4188g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4189h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f4190i;

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
            this.f4190i = fVar;
            this.f4187f = jSONObject;
            this.f4188g = i2;
            this.f4189h = i3;
        }

        @Override // c.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f4187f.optInt("result", -1);
                    String optString = this.f4187f.optString("msg", "");
                    if (this.f4190i.f4215c != this.f4190i.f4216d && (optInt == -10009 || optInt == -10008)) {
                        this.f4190i.e(this.f4188g, 3, 2002, this.f4190i.f4215c, "pre login error, wrong sim operator", this.f4189h);
                    } else {
                        f fVar = this.f4190i;
                        int i2 = this.f4188g;
                        int i3 = this.f4190i.f4215c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("ct pre login error.");
                        sb.append(optString);
                        sb.append(", status ");
                        sb.append(optInt);
                        fVar.e(i2, 2, optInt, i3, sb.toString(), this.f4189h);
                    }
                } catch (Throwable unused) {
                    f fVar2 = this.f4190i;
                    fVar2.e(this.f4188g, 3, 2009, fVar2.f4215c, "ct on handle pre login or verify unknown error.", this.f4189h);
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
        this.f4215c = 3;
    }

    @Override // c.a.n0.e.i
    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            super.h(context, i2);
            if (!c.a.n0.b.a.h(this.f4213a).d()) {
                e(i2, 3, 997, this.f4215c, "pre login error. sdk stop run.", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f4215c, "pre login error. ct has not valid config.", 1);
            } else if (c.a.n0.b.a.h(this.f4213a).a()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, i.m, i.n, new a(this, System.currentTimeMillis(), i2));
            } else {
                e(i2, 3, 996, this.f4215c, "pre login error. ct sdk stop run.", 1);
            }
        }
    }

    @Override // c.a.n0.e.i
    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            super.o(context, i2);
            if (!c.a.n0.b.a.h(this.f4213a).d()) {
                e(i2, 3, 997, this.f4215c, "pre verify error. sdk stop run.", 3);
            } else if (!r()) {
                e(i2, 3, 2006, this.f4215c, "pre verify error. ct has not valid config.", 3);
            } else if (c.a.n0.b.a.h(this.f4213a).a()) {
                if (!this.s) {
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, i.m, i.n, new b(this, i2));
            } else {
                e(i2, 3, 996, this.f4215c, "pre verify error. ct sdk stop run.", 3);
            }
        }
    }

    @Override // c.a.n0.e.j, c.a.n0.e.i
    public void p(Context context, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.p(context, i2, j2);
        }
    }

    public final void w(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, str, i2, i3) == null) {
            c.a.n0.k.e.c().b(new c(this, str, i2, i3));
        }
    }

    public final void x(JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, jSONObject, i2, i3) == null) {
            c.a.n0.k.e.c().b(new e(this, jSONObject, i2, i3));
        }
    }

    public final void z(JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, jSONObject, i2, i3) == null) {
            c.a.n0.k.e.c().b(new d(this, i2, i3, jSONObject));
        }
    }
}
