package c.a.n0.a.v1.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.o0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.t0;
import c.a.n0.a.s0.d.j;
import c.a.n0.a.x1.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f6912b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6913c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6914d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f6915e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ y f6916f;

        public a(y yVar, JSONObject jSONObject, Context context, String str, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, jSONObject, context, str, callbackHandler, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6916f = yVar;
            this.a = jSONObject;
            this.f6912b = context;
            this.f6913c = str;
            this.f6914d = callbackHandler;
            this.f6915e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (c.a.n0.a.r2.c.f(this.a)) {
                    this.f6916f.p(this.f6916f.s(c.a.n0.a.v1.f.o0.c.e(), this.a.optString("path")), this.f6912b, this.f6913c, this.f6914d, this.a, this.f6915e);
                    return;
                }
                String r = this.f6916f.r(fVar, this.a);
                if (!q0.G() && TextUtils.isEmpty(r)) {
                    r = c.a.n0.d.g.c.e().g(this.f6915e.N(), this.f6915e.l(), this.a.optString("path"));
                }
                String str = r;
                if (z.f6924b) {
                    Log.d("ShareAction", "final share url is " + str);
                }
                this.f6916f.p(str, this.f6912b, this.f6913c, this.f6914d, this.a, this.f6915e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6917b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6918c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JSONObject f6919d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6920e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ y f6921f;

        public b(y yVar, Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, context, callbackHandler, str, jSONObject, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6921f = yVar;
            this.a = context;
            this.f6917b = callbackHandler;
            this.f6918c = str;
            this.f6919d = jSONObject;
            this.f6920e = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f6921f.n(this.a, this.f6917b, this.f6918c, this.f6919d, c.a.n0.a.x1.c.d.h(iVar), this.f6920e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6922b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ y f6923c;

        public c(y yVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6923c = yVar;
            this.a = callbackHandler;
            this.f6922b = str;
        }

        @Override // c.a.n0.a.s0.d.j.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6923c.q(this.a, this.f6922b, false);
            }
        }

        @Override // c.a.n0.a.s0.d.j.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f6923c.q(this.a, this.f6922b, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/share");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (context != null && eVar != null) {
                if (eVar.m0()) {
                    if (z.f6924b) {
                        Log.d("ShareAction", "ShareAction does not supported when app is invisible.");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject a2 = z.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    c.a.n0.a.u.d.c("Share", "params invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                    return false;
                }
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.n0.a.u.d.c("Share", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                    return false;
                }
                try {
                    a2.put("iconUrl", a2.optString("imageUrl", ""));
                } catch (JSONException e2) {
                    if (z.f6924b) {
                        Log.d("ShareAction", e2.toString());
                    }
                }
                eVar.d0().e("mapp_i_share_update_weburl", new a(this, a2, context, optString, callbackHandler, eVar));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            c.a.n0.a.u.d.c("Share", "context or swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "system error");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                return null;
            }
            return c.a.n0.a.e2.b.M(str, a0.f6344b);
        }
        return (String) invokeL.objValue;
    }

    public final void n(@NonNull Context context, CallbackHandler callbackHandler, String str, @NonNull JSONObject jSONObject, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, callbackHandler, str, jSONObject, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("shareUrl");
            JSONArray optJSONArray = jSONObject.optJSONArray("defaultPannel");
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("linkUrl", str2);
                }
                if (!TextUtils.isEmpty(optString) && (o0.q(optString) || z)) {
                    jSONObject.put("customShareUrl", true);
                    jSONObject.put("linkUrl", optString);
                }
                if (optJSONArray != null && optJSONArray.length() > 0 && !z) {
                    jSONObject.put("pannel", optJSONArray);
                }
            } catch (JSONException e2) {
                if (z.f6924b) {
                    Log.d("ShareAction", e2.toString());
                }
            }
            t(context, callbackHandler, str, jSONObject);
        }
    }

    public final JSONObject o(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        String m;
        Uri a2;
        Uri a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("imageUrl");
            if (optString.startsWith("bdfile")) {
                String m2 = m(optString);
                if (m2 == null) {
                    return jSONObject;
                }
                try {
                    jSONObject.putOpt("imageUrl", t0.a(c.a.n0.a.w0.f.U().getActivity(), new File(m2)).toString());
                } catch (JSONException e2) {
                    if (z.f6924b) {
                        e2.printStackTrace();
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
            if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("info")) == null) {
                return jSONObject;
            }
            String optString2 = optJSONObject.optString("img_show");
            if (optString2.startsWith("bdfile")) {
                String m3 = m(optString2);
                if (m3 == null || (a3 = t0.a(c.a.n0.a.w0.f.U().getActivity(), new File(m3))) == null) {
                    return jSONObject;
                }
                try {
                    optJSONObject.putOpt("img_show", a3.toString());
                    optJSONObject2.putOpt("info", optJSONObject);
                    jSONObject.putOpt("command", optJSONObject2);
                } catch (JSONException e3) {
                    if (z.f6924b) {
                        e3.printStackTrace();
                    }
                }
            }
            String optString3 = optJSONObject.optString("img_save");
            if (!optString3.startsWith("bdfile") || (m = m(optString3)) == null || (a2 = t0.a(c.a.n0.a.w0.f.U().getActivity(), new File(m))) == null) {
                return jSONObject;
            }
            try {
                optJSONObject.putOpt("img_save", a2.toString());
                optJSONObject2.putOpt("info", optJSONObject);
                jSONObject.putOpt("command", optJSONObject2);
            } catch (JSONException e4) {
                if (z.f6924b) {
                    e4.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void p(String str, @NonNull Context context, @NonNull String str2, @NonNull CallbackHandler callbackHandler, @NonNull JSONObject jSONObject, @NonNull c.a.n0.a.t1.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, context, str2, callbackHandler, jSONObject, eVar}) == null) {
            String optString = jSONObject.optString("shareUrl");
            JSONArray optJSONArray = jSONObject.optJSONArray("pannel");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("defaultPannel");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                if (optJSONArray2 != null) {
                    try {
                        if (optJSONArray2.length() > 0) {
                            jSONObject.put("pannel", optJSONArray2);
                        }
                    } catch (JSONException e2) {
                        if (z.f6924b) {
                            Log.d("ShareAction", e2.toString());
                        }
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("linkUrl", str);
                }
                if (TextUtils.isEmpty(optString)) {
                    t(context, callbackHandler, str2, jSONObject);
                    return;
                } else if (o0.q(optString)) {
                    jSONObject.put("linkUrl", optString);
                    jSONObject.put("customShareUrl", true);
                    t(context, callbackHandler, str2, jSONObject);
                    return;
                }
            }
            if (c.a.n0.a.r2.c.f(jSONObject)) {
                n(context, callbackHandler, str2, jSONObject, true, str);
            } else {
                eVar.d0().g(context, "mapp_i_share_update_linkurl", new b(this, context, callbackHandler, str2, jSONObject, str));
            }
        }
    }

    public final void q(CallbackHandler callbackHandler, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048581, this, callbackHandler, str, z) == null) || callbackHandler == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", z);
        } catch (JSONException e2) {
            if (z.f6924b) {
                Log.d("ShareAction", e2.toString());
            }
        }
        int i = z ? 0 : 1001;
        c.a.n0.a.u.d.i("Share", "result=" + z);
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i).toString());
    }

    public String r(c.a.n0.a.x1.c.f fVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, fVar, jSONObject)) == null) ? (fVar == null || fVar.f7640d || fVar.j != 1 || TextUtils.isEmpty(fVar.o.optString("web_url"))) ? "" : s(fVar.o.optString("web_url"), jSONObject.optString("path")) : (String) invokeLL.objValue;
    }

    public String s(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (!TextUtils.isEmpty(str2)) {
                if (!str.endsWith("/")) {
                    str = str + "/";
                }
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
                str = str + str2;
            }
            return o0.a(o0.a(str, "_swebfr", "1"), "_swebFromHost", c.a.n0.a.s0.a.n().a());
        }
        return (String) invokeLL.objValue;
    }

    public final void t(@NonNull Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, callbackHandler, str, jSONObject) == null) {
            jSONObject.remove("defaultPannel");
            jSONObject.remove("shareUrl");
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 != null) {
                String T = a0.V().T();
                String a2 = c.a.n0.a.g0.a.a();
                JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
                if (optJSONObject != null) {
                    c.a.n0.a.p2.w.f(optJSONObject, "source", T);
                    if (!TextUtils.isEmpty(a2)) {
                        c.a.n0.a.p2.w.f(optJSONObject, "nid", a2);
                    }
                } else {
                    JSONObject f2 = c.a.n0.a.p2.w.f(null, "source", T);
                    if (!TextUtils.isEmpty(a2)) {
                        c.a.n0.a.p2.w.f(f2, "nid", a2);
                    }
                    c.a.n0.a.p2.w.f(jSONObject, "categoryInfo", f2);
                }
            }
            c.a.n0.a.s0.a.f0().a(context, o(jSONObject), new c(this, callbackHandler, str));
        }
    }
}
