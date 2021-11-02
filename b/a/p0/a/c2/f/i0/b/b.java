package b.a.p0.a.c2.f.i0.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import b.a.p0.a.a2.e;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e2.c.f;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.h;
import b.a.p0.a.j2.k;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public FloatButton f4279c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.c2.f.i0.a f4280d;

    /* renamed from: e  reason: collision with root package name */
    public f f4281e;

    /* renamed from: f  reason: collision with root package name */
    public String f4282f;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4283e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4284f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4285g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f4286h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f4287i;
        public final /* synthetic */ String j;
        public final /* synthetic */ b k;

        public a(b bVar, CallbackHandler callbackHandler, String str, JSONObject jSONObject, Context context, e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, str, jSONObject, context, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = bVar;
            this.f4283e = callbackHandler;
            this.f4284f = str;
            this.f4285g = jSONObject;
            this.f4286h = context;
            this.f4287i = eVar;
            this.j = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar == null || fVar.f4907d) {
                    FloatButton c2 = this.k.f4280d.c();
                    if (c2 != null) {
                        c2.setVisibility(8);
                    }
                    b.a.p0.a.e2.c.d.n(10005, this.f4283e, this.f4284f);
                    k.p(10005, fVar);
                } else if (this.k.w(fVar, this.f4285g.optString("scheme"))) {
                    this.k.f4281e = fVar;
                    SwanAppActivity swanAppActivity = (SwanAppActivity) this.f4286h;
                    this.k.f4280d = b.a.p0.a.c2.f.i0.a.d();
                    if (this.k.f4280d.c() == null) {
                        b bVar = this.k;
                        bVar.f4279c = bVar.y(this.f4286h, this.f4285g);
                        this.k.x(this.f4284f, this.f4285g, this.f4283e, swanAppActivity);
                    }
                    this.f4287i.I().h(this.j, Boolean.TRUE);
                } else {
                    this.f4283e.handleSchemeDispatchCallback(this.f4284f, UnitedSchemeUtility.wrapCallbackParams(1001, "open app scheme is not allowed").toString());
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.c2.f.i0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0131b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f4288a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4289b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4290c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4291d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f4292e;

        public C0131b(b bVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, activity, jSONObject, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4292e = bVar;
            this.f4288a = activity;
            this.f4289b = jSONObject;
            this.f4290c = callbackHandler;
            this.f4291d = str;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (q0.F(this.f4288a, this.f4292e.f4282f)) {
                    String optString = this.f4289b.optString("scheme");
                    b bVar = this.f4292e;
                    this.f4292e.z(this.f4288a, optString, bVar.v(bVar.f4281e.f4912i.get(0), optString), this.f4290c, this.f4291d);
                    return;
                }
                try {
                    String optString2 = this.f4289b.optString("downloadUrl");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", optString2);
                    z = q0.e(this.f4288a, jSONObject.toString());
                } catch (JSONException e2) {
                    if (a0.f4160b) {
                        e2.printStackTrace();
                    }
                    z = false;
                }
                this.f4290c.handleSchemeDispatchCallback(this.f4291d, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "download app success" : "download app fail").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f4293e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4294f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4295g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4296h;

        public c(b bVar, Activity activity, String str, CallbackHandler callbackHandler, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, activity, str, callbackHandler, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4293e = activity;
            this.f4294f = str;
            this.f4295g = callbackHandler;
            this.f4296h = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                boolean T = q0.T(this.f4293e, this.f4294f);
                this.f4295g.handleSchemeDispatchCallback(this.f4296h, UnitedSchemeUtility.wrapCallbackParams(T ? 0 : 1001, T ? "open app success" : "open app fail").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4297e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4298f;

        public d(b bVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4297e = callbackHandler;
            this.f4298f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f4297e.handleSchemeDispatchCallback(this.f4298f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/showOpenAppGuide");
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty params");
                return false;
            } else if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            } else if (!(context instanceof SwanAppActivity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not instanceof SwanAppActivity");
                return false;
            } else {
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                String optString2 = a2.optString("name");
                this.f4282f = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "packageName is empty");
                    return false;
                }
                b.a.p0.a.c2.f.i0.a d2 = b.a.p0.a.c2.f.i0.a.d();
                this.f4280d = d2;
                d2.i(this.f4282f);
                if (this.f4280d.c() != null) {
                    this.f4279c = y(context, a2);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                    return true;
                }
                b.a M = eVar.M();
                if (M != null && !TextUtils.isEmpty(M.S())) {
                    eVar.S().e("mapp_open_external_app", new a(this, callbackHandler, optString, a2, context, eVar, M.S()));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "launchInfo or source is empty");
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final String v(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            String str4 = "";
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    str3 = "";
                    while (keys.hasNext()) {
                        try {
                            String next = keys.next();
                            if (next.equals("slogan_base")) {
                                str4 = jSONObject.optString(next);
                            }
                            if (str2.contains(next)) {
                                str3 = jSONObject.optString(next);
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            if (a0.f4160b) {
                                e.printStackTrace();
                            }
                            if (!TextUtils.isEmpty(str4)) {
                                return str4 + str3;
                            }
                            return null;
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str3 = "";
                }
                if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                    return str4 + str3;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final boolean w(f fVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, str)) == null) {
            if (fVar != null && !TextUtils.isEmpty(str)) {
                for (String str2 : fVar.f4911h) {
                    if (str.contains(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void x(String str, JSONObject jSONObject, CallbackHandler callbackHandler, Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, str, jSONObject, callbackHandler, activity) == null) || callbackHandler == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f4279c.setDragImageListener(new C0131b(this, activity, jSONObject, callbackHandler, str));
    }

    public final FloatButton y(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, jSONObject)) == null) {
            this.f4280d.g((SwanAppActivity) context, jSONObject);
            return this.f4280d.f();
        }
        return (FloatButton) invokeLL.objValue;
    }

    public final void z(Activity activity, String str, String str2, CallbackHandler callbackHandler, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048581, this, activity, str, str2, callbackHandler, str3) == null) || !(activity instanceof SwanAppActivity) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String string = activity.getString(h.aiapps_confirm);
        String string2 = activity.getString(h.aiapps_cancel);
        SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(activity);
        aVar.f(true);
        aVar.x(str2);
        aVar.n(new b.a.p0.a.w2.h.a());
        aVar.m(false);
        aVar.P(string, new c(this, activity, str, callbackHandler, str3));
        aVar.C(string2, new d(this, callbackHandler, str3));
        aVar.X();
    }
}
