package c.a.r0.a.f2.f.h0.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import c.a.r0.a.d2.e;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h;
import c.a.r0.a.h2.c.f;
import c.a.r0.a.n2.n;
import c.a.r0.a.z2.q0;
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
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public FloatButton f6118c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.a.f2.f.h0.a f6119d;

    /* renamed from: e  reason: collision with root package name */
    public f f6120e;

    /* renamed from: f  reason: collision with root package name */
    public String f6121f;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6122e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6123f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f6124g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f6125h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f6126i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f6127j;
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
            this.f6122e = callbackHandler;
            this.f6123f = str;
            this.f6124g = jSONObject;
            this.f6125h = context;
            this.f6126i = eVar;
            this.f6127j = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar == null || fVar.f7267d) {
                    FloatButton c2 = this.k.f6119d.c();
                    if (c2 != null) {
                        c2.setVisibility(8);
                    }
                    c.a.r0.a.h2.c.d.o(10005, this.f6122e, this.f6123f);
                    n.r(10005, fVar);
                } else if (this.k.w(fVar, this.f6124g.optString("scheme"))) {
                    this.k.f6120e = fVar;
                    SwanAppActivity swanAppActivity = (SwanAppActivity) this.f6125h;
                    this.k.f6119d = c.a.r0.a.f2.f.h0.a.d();
                    if (this.k.f6119d.c() == null) {
                        b bVar = this.k;
                        bVar.f6118c = bVar.y(this.f6125h, this.f6124g);
                        this.k.x(this.f6123f, this.f6124g, this.f6122e, swanAppActivity);
                    }
                    this.f6126i.T().h(this.f6127j, Boolean.TRUE);
                } else {
                    this.f6122e.handleSchemeDispatchCallback(this.f6123f, UnitedSchemeUtility.wrapCallbackParams(1001, "open app scheme is not allowed").toString());
                }
            }
        }
    }

    /* renamed from: c.a.r0.a.f2.f.h0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0335b implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f6128b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6129c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6130d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f6131e;

        public C0335b(b bVar, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str) {
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
            this.f6131e = bVar;
            this.a = activity;
            this.f6128b = jSONObject;
            this.f6129c = callbackHandler;
            this.f6130d = str;
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
                if (q0.F(this.a, this.f6131e.f6121f)) {
                    String optString = this.f6128b.optString("scheme");
                    b bVar = this.f6131e;
                    this.f6131e.z(this.a, optString, bVar.v(bVar.f6120e.f7272i.get(0), optString), this.f6129c, this.f6130d);
                    return;
                }
                try {
                    String optString2 = this.f6128b.optString(TTDownloadField.TT_DOWNLOAD_URL);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", optString2);
                    z = q0.e(this.a, jSONObject.toString());
                } catch (JSONException e2) {
                    if (z.f6343b) {
                        e2.printStackTrace();
                    }
                    z = false;
                }
                this.f6129c.handleSchemeDispatchCallback(this.f6130d, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "download app success" : "download app fail").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f6132e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6133f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6134g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6135h;

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
            this.f6132e = activity;
            this.f6133f = str;
            this.f6134g = callbackHandler;
            this.f6135h = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                boolean W = q0.W(this.f6132e, this.f6133f);
                this.f6134g.handleSchemeDispatchCallback(this.f6135h, UnitedSchemeUtility.wrapCallbackParams(W ? 0 : 1001, W ? "open app success" : "open app fail").toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6136e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6137f;

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
            this.f6136e = callbackHandler;
            this.f6137f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f6136e.handleSchemeDispatchCallback(this.f6137f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.r0.a.f2.e eVar) {
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
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
                this.f6121f = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "packageName is empty");
                    return false;
                }
                c.a.r0.a.f2.f.h0.a d2 = c.a.r0.a.f2.f.h0.a.d();
                this.f6119d = d2;
                d2.i(this.f6121f);
                if (this.f6119d.c() != null) {
                    this.f6118c = y(context, a2);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                    return true;
                }
                b.a X = eVar.X();
                if (X != null && !TextUtils.isEmpty(X.T())) {
                    eVar.d0().e("mapp_open_external_app", new a(this, callbackHandler, optString, a2, context, eVar, X.T()));
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
                            if (z.f6343b) {
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
                for (String str2 : fVar.f7271h) {
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
        this.f6118c.setDragImageListener(new C0335b(this, activity, jSONObject, callbackHandler, str));
    }

    public final FloatButton y(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, jSONObject)) == null) {
            this.f6119d.g((SwanAppActivity) context, jSONObject);
            return this.f6119d.f();
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
        aVar.n(new c.a.r0.a.a3.h.a());
        aVar.m(false);
        aVar.P(string, new c(this, activity, str, callbackHandler, str3));
        aVar.C(string2, new d(this, callbackHandler, str3));
        aVar.X();
    }
}
