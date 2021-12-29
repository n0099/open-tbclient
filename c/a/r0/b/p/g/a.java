package c.a.r0.b.p.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.a.f2.e;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h2.c.d;
import c.a.r0.a.h2.c.i;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.n2.n;
import c.a.r0.a.z2.g1.c;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f10443d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f10444c;

    /* renamed from: c.a.r0.b.p.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0666a implements c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10445e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f10446f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10447g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f10448h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f10449i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f10450j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f10451k;
        public final /* synthetic */ a l;

        public C0666a(a aVar, CallbackHandler callbackHandler, Context context, String str, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, context, str, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = aVar;
            this.f10445e = callbackHandler;
            this.f10446f = context;
            this.f10447g = str;
            this.f10448h = str2;
            this.f10449i = str3;
            this.f10450j = str4;
            this.f10451k = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.h(iVar)) {
                    d.q(iVar, this.f10445e, this.l.f10444c);
                    return;
                }
                c.a.r0.a.u2.a a = c.a.r0.a.c1.a.F().a(this.f10446f, this.f10447g, this.f10448h, this.f10449i, this.f10450j, this.f10451k);
                if (a != null) {
                    if (a.h() != 0) {
                        c.a.r0.a.e0.d.c("PageTransitionAction", a.g().toString());
                        CallbackHandler callbackHandler = this.f10445e;
                        String str = this.l.f10444c;
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, a.a() + ":" + a.g().toString()).toString());
                        return;
                    }
                    c.a.r0.a.e0.d.c("PageTransitionAction", "page transition fail");
                    this.f10445e.handleSchemeDispatchCallback(this.l.f10444c, UnitedSchemeUtility.wrapCallbackParams(1001, "execute fail").toString());
                    return;
                }
                c.a.r0.a.e0.d.i("PageTransitionAction", "page transition success");
                this.f10445e.handleSchemeDispatchCallback(this.l.f10444c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2001948423, "Lc/a/r0/b/p/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2001948423, "Lc/a/r0/b/p/g/a;");
                return;
            }
        }
        HashSet hashSet = new HashSet();
        f10443d = hashSet;
        hashSet.add("easybrowse");
        f10443d.add("live");
        f10443d.add("appTab");
        f10443d.add("browser");
        f10443d.add(AccountConstants.LOGIN_TYPE_NATIVE_SRC_COMIC);
        f10443d.add(AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL);
        f10443d.add("imChatHN");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/pageTransition");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.r0.a.e0.d.c("PageTransitionAction", "runtime exception");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "null swanApp");
                return false;
            } else if (eVar.m0()) {
                boolean z = z.f6340b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                String param = unitedSchemeEntity.getParam("params");
                if (TextUtils.isEmpty(param)) {
                    c.a.r0.a.e0.d.c("PageTransitionAction", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                    return false;
                }
                JSONObject d2 = w.d(param);
                String optString = d2.optString("cb");
                this.f10444c = optString;
                if (TextUtils.isEmpty(optString)) {
                    c.a.r0.a.e0.d.c("PageTransitionAction", "callback is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString2 = d2.optString("authority");
                String optString3 = d2.optString("path");
                String optString4 = d2.optString("module");
                String optString5 = d2.optString("action");
                String optString6 = d2.optString("scheme");
                k(eVar, optString4);
                if (c.a.r0.a.c1.a.E().a(d2)) {
                    eVar.d0().g(context, "mapp_i_baiduapp_page_trans", new C0666a(this, callbackHandler, context, optString2, optString3, optString4, optString5, optString6));
                } else {
                    c.a.r0.a.u2.a a = c.a.r0.a.c1.a.F().a(context, optString2, optString3, optString4, optString5, optString6);
                    if (a != null) {
                        if (a.h() != 0) {
                            c.a.r0.a.e0.d.c("PageTransitionAction", a.g().toString());
                            String str = this.f10444c;
                            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, a.a() + ":" + a.g().toString()).toString());
                        } else {
                            c.a.r0.a.e0.d.c("PageTransitionAction", "page transition fail");
                            callbackHandler.handleSchemeDispatchCallback(this.f10444c, UnitedSchemeUtility.wrapCallbackParams(1001, "execute fail").toString());
                        }
                    } else {
                        c.a.r0.a.e0.d.i("PageTransitionAction", "page transition success");
                        callbackHandler.handleSchemeDispatchCallback(this.f10444c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    }
                }
                c.a.r0.a.e0.d.i("PageTransitionAction", "callback success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(@NonNull c.a.r0.a.d2.e eVar, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, str) == null) {
            c.a.r0.a.n2.s.e eVar2 = new c.a.r0.a.n2.s.e();
            eVar2.f8158c = eVar.V().T();
            eVar2.a = "swan";
            if (q0.G()) {
                if (f10443d.contains(str)) {
                    eVar2.f8157b = str.toLowerCase();
                } else {
                    eVar2.f8157b = "other";
                }
            } else {
                eVar2.f8157b = "other";
            }
            eVar2.a(BaseHiidoContent.HOSTID, c.a.r0.a.c1.a.n().a());
            eVar2.a("appid", eVar.getAppId());
            n.x("1895", eVar2);
        }
    }
}
