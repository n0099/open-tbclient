package c.a.l0.f;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.api.CallBack;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.manager.login.cucc.UiOauthManager;
import com.sdk.mobile.manager.oauth.cucc.OauthManager;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.l0.d.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean s;

    /* renamed from: c.a.l0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0201a extends c.a.l0.f.b<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3607b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3608c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f3609d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3610e;

        public C0201a(a aVar, long j, int i, int i2, int i3) {
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
            this.f3610e = aVar;
            this.f3607b = i;
            this.f3608c = i2;
            this.f3609d = i3;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i, int i2, String str, String str2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
                long currentTimeMillis = System.currentTimeMillis() - a();
                if (!this.f3610e.M(i2, this.f3607b) || (i3 = this.f3608c) != 0) {
                    this.f3610e.I(i2, str, this.f3607b);
                } else {
                    this.f3610e.x(this.f3607b, this.f3609d, i3 + 1);
                }
                c.a.l0.i.d.c(this.f3610e.a, this.f3610e.f3550c, i2, currentTimeMillis, this.f3609d, str2);
            }
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i, String str, int i2, Object obj, String str2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), obj, str2}) == null) {
                long currentTimeMillis = System.currentTimeMillis() - a();
                if (i == 0) {
                    this.f3610e.D(obj, this.f3607b);
                } else if (!this.f3610e.M(i2, this.f3607b) || (i3 = this.f3608c) != 0) {
                    this.f3610e.I(i2, str, this.f3607b);
                } else {
                    this.f3610e.x(this.f3607b, this.f3609d, i3 + 1);
                }
                c.a.l0.i.d.c(this.f3610e.a, this.f3610e.f3550c, i2, currentTimeMillis, this.f3609d, str2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements CallBack<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f3611b;

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
            this.f3611b = aVar;
            this.a = i;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
                this.f3611b.y(i2, str, this.a);
            }
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i, String str, int i2, Object obj, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), obj, str2}) == null) {
                if (i == 0) {
                    this.f3611b.L(obj, this.a);
                } else {
                    this.f3611b.y(i2, str, this.a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f3612b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3613c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f3614d;

        public c(a aVar, Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, obj, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3614d = aVar;
            this.f3612b = obj;
            this.f3613c = i;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) this.f3612b);
                    this.f3614d.f3554g = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                    this.f3614d.f3552e = jSONObject.optString(YYInnerSSOLoginActivity.o);
                    this.f3614d.f3553f = jSONObject.optLong("exp");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, this.f3614d.a(this.f3614d.f3554g));
                    this.f3614d.e(this.f3613c, 0, 0, this.f3614d.f3550c, jSONObject2.toString(), 1);
                } catch (Throwable unused) {
                    a aVar = this.f3614d;
                    aVar.e(this.f3613c, 3, 2009, aVar.f3550c, "cu on handle login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3615b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3616c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f3617d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3618e;

        public d(a aVar, int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i), Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3618e = aVar;
            this.f3615b = i;
            this.f3616c = i2;
            this.f3617d = str;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f3618e.f3550c != this.f3618e.f3551d && this.f3615b == 1101) {
                        this.f3618e.e(this.f3616c, 3, 2002, this.f3618e.f3550c, "pre login error, wrong sim operator", 1);
                    } else {
                        a aVar = this.f3618e;
                        int i = this.f3616c;
                        int i2 = this.f3615b;
                        int i3 = this.f3618e.f3550c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("cu pre login error.");
                        sb.append(this.f3617d);
                        sb.append(", status ");
                        sb.append(this.f3615b);
                        aVar.e(i, 2, i2, i3, sb.toString(), 1);
                    }
                } catch (Throwable unused) {
                    a aVar2 = this.f3618e;
                    aVar2.e(this.f3616c, 3, 2009, aVar2.f3550c, "cu on handle login unknown error.", 1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f3619b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3620c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f3621d;

        public e(a aVar, Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, obj, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3621d = aVar;
            this.f3619b = obj;
            this.f3620c = i;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) this.f3619b);
                    this.f3621d.f3555h = jSONObject.optString(YYInnerSSOLoginActivity.o);
                    this.f3621d.i = jSONObject.optLong("exp");
                    this.f3621d.e(this.f3620c, 0, 0, this.f3621d.f3550c, "preVerify success", 3);
                } catch (Throwable unused) {
                    a aVar = this.f3621d;
                    aVar.e(this.f3620c, 3, 2009, aVar.f3550c, "cu on handle preVerify unknown error.", 3);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends c.a.l0.l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3622b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3623c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f3624d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3625e;

        public f(a aVar, int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i), Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3625e = aVar;
            this.f3622b = i;
            this.f3623c = i2;
            this.f3624d = str;
        }

        @Override // c.a.l0.l.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f3625e.f3550c != this.f3625e.f3551d && this.f3622b == 1101) {
                        this.f3625e.e(this.f3623c, 3, 2002, this.f3625e.f3550c, "pre verify error, wrong sim operator", 3);
                    } else {
                        a aVar = this.f3625e;
                        int i = this.f3623c;
                        int i2 = this.f3622b;
                        int i3 = this.f3625e.f3550c;
                        StringBuilder sb = new StringBuilder();
                        sb.append("cu pre verify error.");
                        sb.append(this.f3624d);
                        sb.append(", status ");
                        sb.append(this.f3622b);
                        aVar.e(i, 2, i2, i3, sb.toString(), 3);
                    }
                } catch (Throwable unused) {
                    a aVar2 = this.f3625e;
                    aVar2.e(this.f3623c, 3, 2009, aVar2.f3550c, "cu on handle verify unknown error.", 3);
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
        this.f3550c = 2;
    }

    public final void D(Object obj, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, obj, i) == null) {
            c.a.l0.l.e.c().b(new c(this, obj, i));
        }
    }

    public final void I(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            c.a.l0.l.e.c().b(new d(this, i, i2, str));
        }
    }

    public final void L(Object obj, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, obj, i) == null) {
            c.a.l0.l.e.c().b(new e(this, obj, i));
        }
    }

    public final boolean M(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            return c.a.l0.b.a.f(this.a).b() && c.a.l0.b.a.f(this.a).m("k_retry_code_cu", i) && c.a.l0.c.a.c().h(i2);
        }
        return invokeII.booleanValue;
    }

    @Override // c.a.l0.d.d
    public void h(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, context, i) == null) {
            super.h(context, i);
            if (!c.a.l0.b.a.f(this.a).c()) {
                e(i, 3, 997, this.f3550c, "pre verify error. sdk stop run", 3);
            } else if (!r()) {
                e(i, 3, 2006, this.f3550c, "pre verify error. cu has not valid config.", 3);
            } else if (c.a.l0.b.a.f(this.a).a()) {
                if (!this.s) {
                    SDKManager.init(this.a, c.a.l0.d.d.o, c.a.l0.d.d.p);
                    SDKManager.setUseCache(false);
                    this.s = true;
                }
                OauthManager.getInstance(this.a).getAuthoriseCode(8, new b(this, i));
            } else {
                e(i, 3, 995, this.f3550c, "pre verify error. cu sdk stop run.", 3);
            }
        }
    }

    @Override // c.a.l0.d.d
    public void i(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, context, i, i2) == null) {
            super.i(context, i, i2);
            if (!c.a.l0.b.a.f(this.a).c()) {
                e(i2, 3, 997, this.f3550c, "pre login error. sdk stop run", 1);
            } else if (!r()) {
                e(i2, 3, 2006, this.f3550c, "pre login error. cu has not valid config.", 1);
            } else if (c.a.l0.b.a.f(this.a).a()) {
                if (!this.s) {
                    System.currentTimeMillis();
                    SDKManager.init(this.a, c.a.l0.d.d.o, c.a.l0.d.d.p);
                    SDKManager.setUseCache(false);
                    this.s = true;
                }
                x(i2, i, 0);
            } else {
                e(i2, 3, 995, this.f3550c, "pre login error. cu sdk stop run.", 1);
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
            UiOauthManager.getInstance(this.a).login(8, new C0201a(this, System.currentTimeMillis(), i, i3, i2));
        }
    }

    public void y(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            c.a.l0.l.e.c().b(new f(this, i, i2, str));
        }
    }
}
