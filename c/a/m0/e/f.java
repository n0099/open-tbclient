package c.a.m0.e;

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
        public final /* synthetic */ int f4148a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f4149b;

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
            this.f4149b = fVar;
            this.f4148a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f4149b.w(str, this.f4148a, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements PreCodeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f4150a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f4151b;

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
            this.f4151b = fVar;
            this.f4150a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f4151b.w(str, this.f4150a, 3);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4152f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4153g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4154h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f4155i;

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
            this.f4155i = fVar;
            this.f4152f = str;
            this.f4153g = i2;
            this.f4154h = i3;
        }

        @Override // c.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f4152f);
                    if (jSONObject.optInt("result", -1) == 0) {
                        this.f4155i.z(jSONObject, this.f4153g, this.f4154h);
                    } else {
                        this.f4155i.x(jSONObject, this.f4153g, this.f4154h);
                    }
                } catch (Throwable th) {
                    c.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4156f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4157g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4158h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f4159i;

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
            this.f4159i = fVar;
            this.f4156f = i2;
            this.f4157g = i3;
            this.f4158h = jSONObject;
        }

        @Override // c.a.m0.k.c
        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (c.a.m0.b.c.f4078c) {
                        this.f4159i.e(this.f4156f, 1, 999, this.f4159i.f4188c, "device has risk.", this.f4157g);
                        return;
                    }
                    JSONObject optJSONObject = this.f4158h.optJSONObject("data");
                    if (this.f4157g == 1) {
                        this.f4159i.f4190e = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f4159i.f4192g = optJSONObject.optString(IdCardActivity.KEY_NUMBER, "");
                        this.f4159i.f4191f = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f4159i.a(this.f4159i.f4192g));
                        str = jSONObject.toString();
                    } else {
                        this.f4159i.f4193h = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f4159i.f4194i = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                        str = "preVerify success";
                    }
                    this.f4159i.e(this.f4156f, 0, 0, this.f4159i.f4188c, str, this.f4157g);
                } catch (Throwable unused) {
                    f fVar = this.f4159i;
                    fVar.e(this.f4156f, 3, 2009, fVar.f4188c, "ct on handle pre login or verify unknown error.", this.f4157g);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4160f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4161g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f4162h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f4163i;

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
            this.f4163i = fVar;
            this.f4160f = jSONObject;
            this.f4161g = i2;
            this.f4162h = i3;
        }

        @Override // c.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f4160f.optInt("result", -1);
                    String optString = this.f4160f.optString("msg", "");
                    if (this.f4163i.f4188c != this.f4163i.f4189d && (optInt == -10009 || optInt == -10008)) {
                        this.f4163i.e(this.f4161g, 3, 2002, this.f4163i.f4188c, "pre login error, wrong sim operator", this.f4162h);
                    } else {
                        f fVar = this.f4163i;
                        int i2 = this.f4161g;
                        int i3 = this.f4163i.f4188c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("ct pre login error.");
                        sb.append(optString);
                        sb.append(", status ");
                        sb.append(optInt);
                        fVar.e(i2, 2, optInt, i3, sb.toString(), this.f4162h);
                    }
                } catch (Throwable unused) {
                    f fVar2 = this.f4163i;
                    fVar2.e(this.f4161g, 3, 2009, fVar2.f4188c, "ct on handle pre login or verify unknown error.", this.f4162h);
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
        this.f4188c = 3;
    }

    @Override // c.a.m0.e.i
    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            super.h(context, i2);
            if (!c.a.m0.b.a.h(this.f4186a).d()) {
                e(i2, 3, 997, this.f4188c, "pre login error. sdk stop run.", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f4188c, "pre login error. ct has not valid config.", 1);
            } else if (c.a.m0.b.a.h(this.f4186a).a()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, i.m, i.n, new a(this, System.currentTimeMillis(), i2));
            } else {
                e(i2, 3, 996, this.f4188c, "pre login error. ct sdk stop run.", 1);
            }
        }
    }

    @Override // c.a.m0.e.i
    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            super.o(context, i2);
            if (!c.a.m0.b.a.h(this.f4186a).d()) {
                e(i2, 3, 997, this.f4188c, "pre verify error. sdk stop run.", 3);
            } else if (!r()) {
                e(i2, 3, 2006, this.f4188c, "pre verify error. ct has not valid config.", 3);
            } else if (c.a.m0.b.a.h(this.f4186a).a()) {
                if (!this.s) {
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, i.m, i.n, new b(this, i2));
            } else {
                e(i2, 3, 996, this.f4188c, "pre verify error. ct sdk stop run.", 3);
            }
        }
    }

    @Override // c.a.m0.e.j, c.a.m0.e.i
    public void p(Context context, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.p(context, i2, j2);
        }
    }

    public final void w(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, str, i2, i3) == null) {
            c.a.m0.k.e.c().b(new c(this, str, i2, i3));
        }
    }

    public final void x(JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, jSONObject, i2, i3) == null) {
            c.a.m0.k.e.c().b(new e(this, jSONObject, i2, i3));
        }
    }

    public final void z(JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, jSONObject, i2, i3) == null) {
            c.a.m0.k.e.c().b(new d(this, i2, i3, jSONObject));
        }
    }
}
