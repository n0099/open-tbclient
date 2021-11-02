package b.a.p0.a.w1.f;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import b.a.p0.a.a2.e;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.g1.f;
import b.a.p0.a.h;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.k;
import b.a.p0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.publisher.PublishParams;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c extends a0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8752c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a implements b.a.p0.a.w1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8753a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f8754b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8755c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f8756d;

        public a(String str, c cVar, e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, cVar, eVar, unitedSchemeEntity, callbackHandler, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8753a = str;
            this.f8754b = unitedSchemeEntity;
            this.f8755c = callbackHandler;
            this.f8756d = context;
        }

        @Override // b.a.p0.a.w1.a
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject != null) {
                    UnitedSchemeUtility.safeCallback(this.f8755c, this.f8754b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f8753a);
                } else {
                    UnitedSchemeUtility.safeCallback(this.f8755c, this.f8754b, UnitedSchemeUtility.wrapCallbackParams(1, "empty post data").toString(), this.f8753a);
                }
            }
        }

        @Override // b.a.p0.a.w1.a
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                UnitedSchemeUtility.safeCallback(this.f8755c, this.f8754b, UnitedSchemeUtility.wrapCallbackParams(1001, "user cancel").toString(), this.f8753a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final b f8757e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2121958942, "Lb/a/p0/a/w1/f/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2121958942, "Lb/a/p0/a/w1/f/c$b;");
                    return;
                }
            }
            f8757e = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2053655584, "Lb/a/p0/a/w1/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2053655584, "Lb/a/p0/a/w1/f/c;");
                return;
            }
        }
        f8752c = k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b.a.p0.a.c2.e dispatcher) {
        super(dispatcher, "/swanAPI/community/openCommunityEditor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dispatcher};
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
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
    }

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, entity, callbackHandler, eVar)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(entity, "entity");
            if (eVar != null) {
                if (eVar.c0()) {
                    boolean z = f8752c;
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                f T = f.T();
                Intrinsics.checkNotNullExpressionValue(T, "SwanAppController.getInstance()");
                g U = T.U();
                if (U != null && (U.m() instanceof b.a.p0.a.w1.c)) {
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                    return true;
                }
                JSONObject d2 = w.d(entity.getParam("params"));
                Intrinsics.checkNotNullExpressionValue(d2, "SwanAppJSONUtils.parseString(params)");
                String optString = d2.optString("cb");
                if (optString == null || optString.length() == 0) {
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                if (f8752c) {
                    String str = "调起参数:" + d2;
                }
                a aVar = new a(optString, this, eVar, entity, callbackHandler, context);
                PublishParams a2 = b.a.p0.a.w1.b.a(d2);
                if (a2 != null) {
                    b.a.p0.a.w1.c cVar = new b.a.p0.a.w1.c();
                    cVar.k3(aVar);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("params", a2);
                    cVar.d1(bundle);
                    f controller = f.T();
                    Intrinsics.checkNotNullExpressionValue(controller, "controller");
                    g U2 = controller.U();
                    if (U2 != null) {
                        g.b i2 = U2.i("navigateTo");
                        i2.n(g.f5280g, g.f5282i);
                        i2.j(cVar);
                        i2.a();
                        UnitedSchemeUtility.callCallback(callbackHandler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
                        return true;
                    }
                    UnitedSchemeUtility.safeCallback(callbackHandler, entity, UnitedSchemeUtility.wrapCallbackParams(1, "can get fragment manager").toString(), optString);
                    return false;
                }
                boolean z2 = f8752c;
                j(context);
                return false;
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal app info");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(context);
            aVar.m(false);
            aVar.U(h.swanapp_publisher_error_title);
            aVar.v(h.swanapp_publisher_params_error);
            aVar.O(h.aiapps_confirm, b.f8757e);
            aVar.X();
        }
    }
}
