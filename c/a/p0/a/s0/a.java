package c.a.p0.a.s0;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.d2.e;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.z2.w;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public Context f7896c;

    /* renamed from: d  reason: collision with root package name */
    public e f7897d;

    /* renamed from: e  reason: collision with root package name */
    public CallbackHandler f7898e;

    /* renamed from: c.a.p0.a.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0457a implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;

        public C0457a(a aVar, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = unitedSchemeEntity;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i2, @NonNull String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, jSONObject) == null) {
                this.a.result = UnitedSchemeUtility.wrapCallbackParams(i2, str);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7899b;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7899b = aVar;
            this.a = str;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i2, @NonNull String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, jSONObject) == null) {
                if (jSONObject == null) {
                    this.f7899b.f7898e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(i2, str).toString());
                } else {
                    this.f7899b.f7898e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i2).toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.s0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7900b;

        public c(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7900b = aVar;
            this.a = str;
        }

        @Override // c.a.p0.a.a2.a
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f7900b.f7898e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (c.a.p0.a.a2.c.f4246c.c()) {
                    return;
                }
                if (c.a.p0.a.c1.a.h0().e(this.f7900b.f7896c)) {
                    c.a.p0.a.a2.c.f4246c.e();
                } else {
                    c.a.p0.a.a2.c.f4246c.f();
                }
            }
        }

        @Override // c.a.p0.a.a2.a
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f7900b.f7898e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.f2.e eVar) {
        super(eVar, "/swanAPI/getFormId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (unitedSchemeEntity == null) {
                boolean z = z.f5296b;
                return false;
            } else if (eVar != null && (context instanceof Activity) && callbackHandler != null) {
                this.f7896c = context;
                this.f7897d = eVar;
                this.f7898e = callbackHandler;
                JSONObject a = z.a(unitedSchemeEntity, "params");
                if (a != null && a.length() != 0) {
                    String optString = a.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        boolean z2 = z.f5296b;
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                        return false;
                    }
                    String N = eVar.N();
                    if (TextUtils.isEmpty(N)) {
                        boolean z3 = z.f5296b;
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "appKey is empty");
                        return false;
                    }
                    if (TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE.equals(a.optString("reportType"))) {
                        SubscribeHelper subscribeHelper = new SubscribeHelper();
                        if (!subscribeHelper.n(this.f7896c, this.f7897d, N, a, SubscribeHelper.invokeSubscribeFrom.GET_FORM_ID_BUTTON, new C0457a(this, unitedSchemeEntity))) {
                            return false;
                        }
                        subscribeHelper.o(N, new b(this, optString));
                    } else {
                        l(N, optString);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            } else {
                boolean z4 = z.f5296b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (!SubscribeHelper.l()) {
                this.f7898e.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(w.f(null, "data", w.f(null, "formid", "")), 0).toString());
                return;
            }
            c.a.p0.a.c1.a.W().c(str, new c(this, str2));
        }
    }
}
