package c.a.n0.a.c2.f;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.a.e2.c.j.b;
import c.a.n0.a.v2.q0;
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
/* loaded from: classes.dex */
public class s extends a0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f4819d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f4820c;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.v2.e1.b<c.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4821e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f4822f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4823g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4824h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4825i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4826j;
        public final /* synthetic */ String k;
        public final /* synthetic */ s l;

        public a(s sVar, CallbackHandler callbackHandler, Context context, String str, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, callbackHandler, context, str, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = sVar;
            this.f4821e = callbackHandler;
            this.f4822f = context;
            this.f4823g = str;
            this.f4824h = str2;
            this.f4825i = str3;
            this.f4826j = str4;
            this.k = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.n0.a.e2.c.d.h(iVar)) {
                    c.a.n0.a.e2.c.d.p(iVar, this.f4821e, this.l.f4820c);
                    return;
                }
                c.a.n0.a.q2.a a2 = c.a.n0.a.c1.a.B().a(this.f4822f, this.f4823g, this.f4824h, this.f4825i, this.f4826j, this.k);
                if (a2 != null) {
                    if (a2.g() != 0) {
                        c.a.n0.a.e0.d.b("PageTransitionAction", a2.f().toString());
                        CallbackHandler callbackHandler = this.f4821e;
                        String str = this.l.f4820c;
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, a2.a() + ":" + a2.f().toString()).toString());
                        return;
                    }
                    c.a.n0.a.e0.d.b("PageTransitionAction", "page transition fail");
                    this.f4821e.handleSchemeDispatchCallback(this.l.f4820c, UnitedSchemeUtility.wrapCallbackParams(1001, "execute fail").toString());
                    return;
                }
                c.a.n0.a.e0.d.g("PageTransitionAction", "page transition success");
                this.f4821e.handleSchemeDispatchCallback(this.l.f4820c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(743381180, "Lc/a/n0/a/c2/f/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(743381180, "Lc/a/n0/a/c2/f/s;");
                return;
            }
        }
        HashSet hashSet = new HashSet();
        f4819d = hashSet;
        hashSet.add("easybrowse");
        f4819d.add("live");
        f4819d.add("appTab");
        f4819d.add("browser");
        f4819d.add(AccountConstants.LOGIN_TYPE_NATIVE_SRC_COMIC);
        f4819d.add(AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(c.a.n0.a.c2.e eVar) {
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

    @Override // c.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.n0.a.e0.d.b("PageTransitionAction", "runtime exception");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "null swanApp");
                return false;
            } else if (eVar.d0()) {
                boolean z = a0.f4492b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                String param = unitedSchemeEntity.getParam("params");
                if (TextUtils.isEmpty(param)) {
                    c.a.n0.a.e0.d.b("PageTransitionAction", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                    return false;
                }
                JSONObject d2 = c.a.n0.a.v2.w.d(param);
                String optString = d2.optString("cb");
                this.f4820c = optString;
                if (TextUtils.isEmpty(optString)) {
                    c.a.n0.a.e0.d.b("PageTransitionAction", "callback is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString2 = d2.optString("authority");
                String optString3 = d2.optString("path");
                String optString4 = d2.optString("module");
                String optString5 = d2.optString("action");
                String optString6 = d2.optString("scheme");
                k(eVar, optString4);
                if (c.a.n0.a.c1.a.A().a(d2)) {
                    eVar.T().g(context, "mapp_i_baiduapp_page_trans", new a(this, callbackHandler, context, optString2, optString3, optString4, optString5, optString6));
                } else {
                    c.a.n0.a.q2.a a2 = c.a.n0.a.c1.a.B().a(context, optString2, optString3, optString4, optString5, optString6);
                    if (a2 != null) {
                        if (a2.g() != 0) {
                            c.a.n0.a.e0.d.b("PageTransitionAction", a2.f().toString());
                            String str = this.f4820c;
                            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, a2.a() + ":" + a2.f().toString()).toString());
                        } else {
                            c.a.n0.a.e0.d.b("PageTransitionAction", "page transition fail");
                            callbackHandler.handleSchemeDispatchCallback(this.f4820c, UnitedSchemeUtility.wrapCallbackParams(1001, "execute fail").toString());
                        }
                    } else {
                        c.a.n0.a.e0.d.g("PageTransitionAction", "page transition success");
                        callbackHandler.handleSchemeDispatchCallback(this.f4820c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    }
                }
                c.a.n0.a.e0.d.g("PageTransitionAction", "callback success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(@NonNull c.a.n0.a.a2.e eVar, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, str) == null) {
            c.a.n0.a.j2.p.e eVar2 = new c.a.n0.a.j2.p.e();
            eVar2.f6791c = eVar.L().T();
            eVar2.f6789a = "swan";
            if (q0.G()) {
                if (f4819d.contains(str)) {
                    eVar2.f6790b = str.toLowerCase();
                } else {
                    eVar2.f6790b = "other";
                }
            } else {
                eVar2.f6790b = "other";
            }
            eVar2.a(BaseHiidoContent.HOSTID, c.a.n0.a.c1.a.m().a());
            eVar2.a("appid", eVar.getAppId());
            c.a.n0.a.j2.k.u("1895", eVar2);
        }
    }
}
