package c.a.m0.e;

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
        public final /* synthetic */ int f4164a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f4165b;

        public a(g gVar, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Long.valueOf(j2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4165b = gVar;
            this.f4164a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
                this.f4165b.y(i3, str, this.f4164a);
            }
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), obj, str2}) == null) {
                if (i2 == 0) {
                    this.f4165b.x(obj, this.f4164a);
                } else {
                    this.f4165b.y(i3, str, this.f4164a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements CallBack<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f4166a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f4167b;

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
            this.f4167b = gVar;
            this.f4166a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
                this.f4167b.u(i3, str, this.f4166a);
            }
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), obj, str2}) == null) {
                if (i2 == 0) {
                    this.f4167b.A(obj, this.f4166a);
                } else {
                    this.f4167b.u(i3, str, this.f4166a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4168f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f4169g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f4170h;

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
            this.f4170h = gVar;
            this.f4168f = i2;
            this.f4169g = obj;
        }

        @Override // c.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (c.a.m0.b.c.f4078c) {
                        this.f4170h.e(this.f4168f, 1, 999, this.f4170h.f4188c, "device has risk.", 1);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject((String) this.f4169g);
                    this.f4170h.f4192g = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                    this.f4170h.f4190e = jSONObject.optString(YYInnerSSOLoginActivity.o);
                    this.f4170h.f4191f = jSONObject.optLong("exp");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f4170h.a(this.f4170h.f4192g));
                    this.f4170h.e(this.f4168f, 0, 0, this.f4170h.f4188c, jSONObject2.toString(), 1);
                } catch (Throwable unused) {
                    g gVar = this.f4170h;
                    gVar.e(this.f4168f, 3, 2009, gVar.f4188c, "cu on handle login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4171f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4172g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4173h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f4174i;

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
            this.f4174i = gVar;
            this.f4171f = i2;
            this.f4172g = i3;
            this.f4173h = str;
        }

        @Override // c.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f4174i.f4188c != this.f4174i.f4189d && this.f4171f == 1101) {
                        this.f4174i.e(this.f4172g, 3, 2002, this.f4174i.f4188c, "pre login error, wrong sim operator", 1);
                    } else {
                        g gVar = this.f4174i;
                        int i2 = this.f4172g;
                        int i3 = this.f4171f;
                        int i4 = this.f4174i.f4188c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("cu pre login error.");
                        sb.append(this.f4173h);
                        sb.append(", status ");
                        sb.append(this.f4171f);
                        gVar.e(i2, 2, i3, i4, sb.toString(), 1);
                    }
                } catch (Throwable unused) {
                    g gVar2 = this.f4174i;
                    gVar2.e(this.f4172g, 3, 2009, gVar2.f4188c, "cu on handle login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4175f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f4176g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f4177h;

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
            this.f4177h = gVar;
            this.f4175f = i2;
            this.f4176g = obj;
        }

        @Override // c.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (c.a.m0.b.c.f4078c) {
                        this.f4177h.e(this.f4175f, 1, 999, this.f4177h.f4188c, "device has risk.", 3);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject((String) this.f4176g);
                    this.f4177h.f4193h = jSONObject.optString(YYInnerSSOLoginActivity.o);
                    this.f4177h.f4194i = jSONObject.optLong("exp");
                    this.f4177h.e(this.f4175f, 0, 0, this.f4177h.f4188c, "preVerify success", 3);
                } catch (Throwable unused) {
                    g gVar = this.f4177h;
                    gVar.e(this.f4175f, 3, 2009, gVar.f4188c, "cu on handle preVerify unknown error.", 3);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends c.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f4178f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4179g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4180h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f4181i;

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
            this.f4181i = gVar;
            this.f4178f = i2;
            this.f4179g = i3;
            this.f4180h = str;
        }

        @Override // c.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f4181i.f4188c != this.f4181i.f4189d && this.f4178f == 1101) {
                        this.f4181i.e(this.f4179g, 3, 2002, this.f4181i.f4188c, "pre verify error, wrong sim operator", 3);
                    } else {
                        g gVar = this.f4181i;
                        int i2 = this.f4179g;
                        int i3 = this.f4178f;
                        int i4 = this.f4181i.f4188c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("cu pre verify error.");
                        sb.append(this.f4180h);
                        sb.append(", status ");
                        sb.append(this.f4178f);
                        gVar.e(i2, 2, i3, i4, sb.toString(), 3);
                    }
                } catch (Throwable unused) {
                    g gVar2 = this.f4181i;
                    gVar2.e(this.f4179g, 3, 2009, gVar2.f4188c, "cu on handle verify unknown error.", 3);
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
        this.f4188c = 2;
    }

    public final void A(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, obj, i2) == null) {
            c.a.m0.k.e.c().b(new e(this, i2, obj));
        }
    }

    @Override // c.a.m0.e.i
    public void h(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            super.h(context, i2);
            if (!c.a.m0.b.a.h(this.f4186a).d()) {
                e(i2, 3, 997, this.f4188c, "pre login error. sdk stop run", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f4188c, "pre login error. cu has not valid config.", 1);
            } else if (c.a.m0.b.a.h(this.f4186a).b()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    SDKManager.init(this.f4186a, i.o, i.p);
                    SDKManager.setUseCache(false);
                    this.s = true;
                }
                UiOauthManager.getInstance(context).login(8, new a(this, System.currentTimeMillis(), i2));
            } else {
                e(i2, 3, 995, this.f4188c, "pre login error. cu sdk stop run.", 1);
            }
        }
    }

    @Override // c.a.m0.e.i
    public void o(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i2) == null) {
            super.o(context, i2);
            if (!c.a.m0.b.a.h(this.f4186a).d()) {
                e(i2, 3, 997, this.f4188c, "pre verify error. sdk stop run", 3);
            } else if (!r()) {
                e(i2, 3, 2006, this.f4188c, "pre verify error. cu has not valid config.", 3);
            } else if (c.a.m0.b.a.h(this.f4186a).b()) {
                if (!this.s) {
                    SDKManager.init(this.f4186a, i.o, i.p);
                    SDKManager.setUseCache(false);
                    this.s = true;
                }
                OauthManager.getInstance(this.f4186a).getAuthoriseCode(8, new b(this, i2));
            } else {
                e(i2, 3, 995, this.f4188c, "pre verify error. cu sdk stop run.", 3);
            }
        }
    }

    @Override // c.a.m0.e.j, c.a.m0.e.i
    public void p(Context context, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.p(context, i2, j2);
        }
    }

    public void u(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            c.a.m0.k.e.c().b(new f(this, i2, i3, str));
        }
    }

    public final void x(Object obj, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, obj, i2) == null) {
            c.a.m0.k.e.c().b(new c(this, i2, obj));
        }
    }

    public final void y(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            c.a.m0.k.e.c().b(new d(this, i2, i3, str));
        }
    }
}
