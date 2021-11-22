package b.a.n0.e;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.api.CallBack;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.manager.login.cucc.UiOauthManager;
import com.sdk.mobile.manager.oauth.cucc.OauthManager;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean s;

    /* loaded from: classes.dex */
    public class a implements CallBack<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3687a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f3688b;

        public a(g gVar, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3688b = gVar;
            this.f3687a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
                this.f3688b.y(i3, str, this.f3687a);
            }
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), obj, str2}) == null) {
                if (i2 == 0) {
                    this.f3688b.x(obj, this.f3687a);
                } else {
                    this.f3688b.y(i3, str, this.f3687a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements CallBack<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3689a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f3690b;

        public b(g gVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3690b = gVar;
            this.f3689a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
                this.f3690b.u(i3, str, this.f3689a);
            }
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), obj, str2}) == null) {
                if (i2 == 0) {
                    this.f3690b.A(obj, this.f3689a);
                } else {
                    this.f3690b.u(i3, str, this.f3689a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3691f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f3692g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f3693h;

        public c(g gVar, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3693h = gVar;
            this.f3691f = i2;
            this.f3692g = obj;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (b.a.n0.b.c.f3601c) {
                        this.f3693h.e(this.f3691f, 1, 999, this.f3693h.f3711c, "device has risk.", 1);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject((String) this.f3692g);
                    this.f3693h.f3715g = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                    this.f3693h.f3713e = jSONObject.optString(YYInnerSSOLoginActivity.o);
                    this.f3693h.f3714f = jSONObject.optLong("exp");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f3693h.a(this.f3693h.f3715g));
                    this.f3693h.e(this.f3691f, 0, 0, this.f3693h.f3711c, jSONObject2.toString(), 1);
                } catch (Throwable unused) {
                    g gVar = this.f3693h;
                    gVar.e(this.f3691f, 3, 2009, gVar.f3711c, "cu on handle login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3694f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3695g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f3696h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f3697i;

        public d(g gVar, int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3697i = gVar;
            this.f3694f = i2;
            this.f3695g = i3;
            this.f3696h = str;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f3697i.f3711c != this.f3697i.f3712d && this.f3694f == 1101) {
                        this.f3697i.e(this.f3695g, 3, 2002, this.f3697i.f3711c, "pre login error, wrong sim operator", 1);
                    } else {
                        g gVar = this.f3697i;
                        int i2 = this.f3695g;
                        int i3 = this.f3694f;
                        int i4 = this.f3697i.f3711c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("cu pre login error.");
                        sb.append(this.f3696h);
                        sb.append(", status ");
                        sb.append(this.f3694f);
                        gVar.e(i2, 2, i3, i4, sb.toString(), 1);
                    }
                } catch (Throwable unused) {
                    g gVar2 = this.f3697i;
                    gVar2.e(this.f3695g, 3, 2009, gVar2.f3711c, "cu on handle login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3698f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f3699g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f3700h;

        public e(g gVar, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3700h = gVar;
            this.f3698f = i2;
            this.f3699g = obj;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (b.a.n0.b.c.f3601c) {
                        this.f3700h.e(this.f3698f, 1, 999, this.f3700h.f3711c, "device has risk.", 3);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject((String) this.f3699g);
                    this.f3700h.f3716h = jSONObject.optString(YYInnerSSOLoginActivity.o);
                    this.f3700h.f3717i = jSONObject.optLong("exp");
                    this.f3700h.e(this.f3698f, 0, 0, this.f3700h.f3711c, "preVerify success", 3);
                } catch (Throwable unused) {
                    g gVar = this.f3700h;
                    gVar.e(this.f3698f, 3, 2009, gVar.f3711c, "cu on handle preVerify unknown error.", 3);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends b.a.n0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f3701f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3702g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f3703h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f3704i;

        public f(g gVar, int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3704i = gVar;
            this.f3701f = i2;
            this.f3702g = i3;
            this.f3703h = str;
        }

        @Override // b.a.n0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f3704i.f3711c != this.f3704i.f3712d && this.f3701f == 1101) {
                        this.f3704i.e(this.f3702g, 3, 2002, this.f3704i.f3711c, "pre verify error, wrong sim operator", 3);
                    } else {
                        g gVar = this.f3704i;
                        int i2 = this.f3702g;
                        int i3 = this.f3701f;
                        int i4 = this.f3704i.f3711c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("cu pre verify error.");
                        sb.append(this.f3703h);
                        sb.append(", status ");
                        sb.append(this.f3701f);
                        gVar.e(i2, 2, i3, i4, sb.toString(), 3);
                    }
                } catch (Throwable unused) {
                    g gVar2 = this.f3704i;
                    gVar2.e(this.f3702g, 3, 2009, gVar2.f3711c, "cu on handle verify unknown error.", 3);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context) {
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
        this.f3711c = 2;
    }

    public final void A(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, obj, i2) == null) {
            b.a.n0.k.e.c().b(new e(this, i2, obj));
        }
    }

    @Override // b.a.n0.e.i
    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            super.h(context, i2);
            if (!b.a.n0.b.a.h(this.f3709a).d()) {
                e(i2, 3, 997, this.f3711c, "pre login error. sdk stop run", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f3711c, "pre login error. cu has not valid config.", 1);
            } else if (b.a.n0.b.a.h(this.f3709a).b()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    SDKManager.init(this.f3709a, i.o, i.p);
                    SDKManager.setUseCache(false);
                    this.s = true;
                }
                UiOauthManager.getInstance(context).login(8, new a(this, System.currentTimeMillis(), i2));
            } else {
                e(i2, 3, 995, this.f3711c, "pre login error. cu sdk stop run.", 1);
            }
        }
    }

    @Override // b.a.n0.e.i
    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i2) == null) {
            super.o(context, i2);
            if (!b.a.n0.b.a.h(this.f3709a).d()) {
                e(i2, 3, 997, this.f3711c, "pre verify error. sdk stop run", 3);
            } else if (!r()) {
                e(i2, 3, 2006, this.f3711c, "pre verify error. cu has not valid config.", 3);
            } else if (b.a.n0.b.a.h(this.f3709a).b()) {
                if (!this.s) {
                    SDKManager.init(this.f3709a, i.o, i.p);
                    SDKManager.setUseCache(false);
                    this.s = true;
                }
                OauthManager.getInstance(this.f3709a).getAuthoriseCode(8, new b(this, i2));
            } else {
                e(i2, 3, 995, this.f3711c, "pre verify error. cu sdk stop run.", 3);
            }
        }
    }

    @Override // b.a.n0.e.j, b.a.n0.e.i
    public void p(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.p(context, i2, j);
        }
    }

    public void u(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            b.a.n0.k.e.c().b(new f(this, i2, i3, str));
        }
    }

    public final void x(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, obj, i2) == null) {
            b.a.n0.k.e.c().b(new c(this, i2, obj));
        }
    }

    public final void y(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            b.a.n0.k.e.c().b(new d(this, i2, i3, str));
        }
    }
}
