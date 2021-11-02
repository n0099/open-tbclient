package b.a.n0.e;

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
        public final /* synthetic */ int f3581a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f3582b;

        public a(f fVar, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3582b = fVar;
            this.f3581a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f3582b.w(str, this.f3581a, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements PreCodeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3583a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f3584b;

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
            this.f3584b = fVar;
            this.f3583a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f3584b.w(str, this.f3583a, 3);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f3585f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3586g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f3587h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f3588i;

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
            this.f3588i = fVar;
            this.f3585f = str;
            this.f3586g = i2;
            this.f3587h = i3;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.f3585f);
                    if (jSONObject.optInt("result", -1) == 0) {
                        this.f3588i.z(jSONObject, this.f3586g, this.f3587h);
                    } else {
                        this.f3588i.x(jSONObject, this.f3586g, this.f3587h);
                    }
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3589f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3590g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3591h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f3592i;

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
            this.f3592i = fVar;
            this.f3589f = i2;
            this.f3590g = i3;
            this.f3591h = jSONObject;
        }

        @Override // b.a.n0.k.c
        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (b.a.n0.b.c.f3511c) {
                        this.f3592i.e(this.f3589f, 1, 999, this.f3592i.f3621c, "device has risk.", this.f3590g);
                        return;
                    }
                    JSONObject optJSONObject = this.f3591h.optJSONObject("data");
                    if (this.f3590g == 1) {
                        this.f3592i.f3623e = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f3592i.f3625g = optJSONObject.optString("number", "");
                        this.f3592i.f3624f = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f3592i.a(this.f3592i.f3625g));
                        str = jSONObject.toString();
                    } else {
                        this.f3592i.f3626h = optJSONObject.optString(YYInnerSSOLoginActivity.o, "");
                        this.f3592i.f3627i = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                        str = "preVerify success";
                    }
                    this.f3592i.e(this.f3589f, 0, 0, this.f3592i.f3621c, str, this.f3590g);
                } catch (Throwable unused) {
                    f fVar = this.f3592i;
                    fVar.e(this.f3589f, 3, 2009, fVar.f3621c, "ct on handle pre login or verify unknown error.", this.f3590g);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f3593f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3594g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f3595h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ f f3596i;

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
            this.f3596i = fVar;
            this.f3593f = jSONObject;
            this.f3594g = i2;
            this.f3595h = i3;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int optInt = this.f3593f.optInt("result", -1);
                    String optString = this.f3593f.optString("msg", "");
                    if (this.f3596i.f3621c != this.f3596i.f3622d && (optInt == -10009 || optInt == -10008)) {
                        this.f3596i.e(this.f3594g, 3, 2002, this.f3596i.f3621c, "pre login error, wrong sim operator", this.f3595h);
                    } else {
                        f fVar = this.f3596i;
                        int i2 = this.f3594g;
                        int i3 = this.f3596i.f3621c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("ct pre login error.");
                        sb.append(optString);
                        sb.append(", status ");
                        sb.append(optInt);
                        fVar.e(i2, 2, optInt, i3, sb.toString(), this.f3595h);
                    }
                } catch (Throwable unused) {
                    f fVar2 = this.f3596i;
                    fVar2.e(this.f3594g, 3, 2009, fVar2.f3621c, "ct on handle pre login or verify unknown error.", this.f3595h);
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
        this.f3621c = 3;
    }

    @Override // b.a.n0.e.i
    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            super.h(context, i2);
            if (!b.a.n0.b.a.h(this.f3619a).d()) {
                e(i2, 3, 997, this.f3621c, "pre login error. sdk stop run.", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f3621c, "pre login error. ct has not valid config.", 1);
            } else if (b.a.n0.b.a.h(this.f3619a).a()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, i.m, i.n, new a(this, System.currentTimeMillis(), i2));
            } else {
                e(i2, 3, 996, this.f3621c, "pre login error. ct sdk stop run.", 1);
            }
        }
    }

    @Override // b.a.n0.e.i
    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            super.o(context, i2);
            if (!b.a.n0.b.a.h(this.f3619a).d()) {
                e(i2, 3, 997, this.f3621c, "pre verify error. sdk stop run.", 3);
            } else if (!r()) {
                e(i2, 3, 2006, this.f3621c, "pre verify error. ct has not valid config.", 3);
            } else if (b.a.n0.b.a.h(this.f3619a).a()) {
                if (!this.s) {
                    CtAuth.init(0, 0, 8000, null);
                    this.s = true;
                }
                CtAuth.requestPreAuthCode(context, i.m, i.n, new b(this, i2));
            } else {
                e(i2, 3, 996, this.f3621c, "pre verify error. ct sdk stop run.", 3);
            }
        }
    }

    @Override // b.a.n0.e.j, b.a.n0.e.i
    public void p(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.p(context, i2, j);
        }
    }

    public final void w(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, str, i2, i3) == null) {
            b.a.n0.k.e.c().b(new c(this, str, i2, i3));
        }
    }

    public final void x(JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, jSONObject, i2, i3) == null) {
            b.a.n0.k.e.c().b(new e(this, jSONObject, i2, i3));
        }
    }

    public final void z(JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, jSONObject, i2, i3) == null) {
            b.a.n0.k.e.c().b(new d(this, i2, i3, jSONObject));
        }
    }
}
