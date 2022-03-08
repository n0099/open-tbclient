package c.a.p0.a.p1.f;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import c.a.p0.a.p2.w;
import c.a.p0.a.t1.e;
import c.a.p0.a.v1.f.z;
import c.a.p0.a.w0.f;
import c.a.p0.a.x.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.publisher.PublishParams;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.tieba.R;
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
public final class c extends z {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f6845c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class a implements c.a.p0.a.p1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6846b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6847c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f6848d;

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
            this.a = str;
            this.f6846b = unitedSchemeEntity;
            this.f6847c = callbackHandler;
            this.f6848d = context;
        }

        @Override // c.a.p0.a.p1.a
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject != null) {
                    UnitedSchemeUtility.safeCallback(this.f6847c, this.f6846b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.a);
                } else {
                    UnitedSchemeUtility.safeCallback(this.f6847c, this.f6846b, UnitedSchemeUtility.wrapCallbackParams(1, "empty post data").toString(), this.a);
                }
            }
        }

        @Override // c.a.p0.a.p1.a
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                UnitedSchemeUtility.safeCallback(this.f6847c, this.f6846b, UnitedSchemeUtility.wrapCallbackParams(1001, "user cancel").toString(), this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final b f6849e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(943215354, "Lc/a/p0/a/p1/f/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(943215354, "Lc/a/p0/a/p1/f/c$b;");
                    return;
                }
            }
            f6849e = new b();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-374437064, "Lc/a/p0/a/p1/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-374437064, "Lc/a/p0/a/p1/f/c;");
                return;
            }
        }
        f6845c = c.a.p0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.a.p0.a.v1.e dispatcher) {
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

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, entity, callbackHandler, eVar)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(entity, "entity");
            if (eVar != null) {
                if (eVar.m0()) {
                    boolean z = f6845c;
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                f U = f.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                g V = U.V();
                if (V != null && (V.m() instanceof c.a.p0.a.p1.c)) {
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
                if (f6845c) {
                    String str = "调起参数:" + d2;
                }
                a aVar = new a(optString, this, eVar, entity, callbackHandler, context);
                PublishParams a2 = c.a.p0.a.p1.b.a(d2);
                if (a2 != null) {
                    c.a.p0.a.p1.c cVar = new c.a.p0.a.p1.c();
                    cVar.x3(aVar);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("params", a2);
                    cVar.d1(bundle);
                    f controller = f.U();
                    Intrinsics.checkNotNullExpressionValue(controller, "controller");
                    g V2 = controller.V();
                    if (V2 != null) {
                        g.b i2 = V2.i("navigateTo");
                        i2.n(g.f8374g, g.f8376i);
                        i2.j(cVar);
                        i2.a();
                        UnitedSchemeUtility.callCallback(callbackHandler, entity, UnitedSchemeUtility.wrapCallbackParams(0));
                        return true;
                    }
                    UnitedSchemeUtility.safeCallback(callbackHandler, entity, UnitedSchemeUtility.wrapCallbackParams(1, "can get fragment manager").toString(), optString);
                    return false;
                }
                boolean z2 = f6845c;
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
            aVar.U(R.string.swanapp_publisher_error_title);
            aVar.v(R.string.swanapp_publisher_params_error);
            aVar.O(R.string.aiapps_confirm, b.f6849e);
            aVar.X();
        }
    }
}
