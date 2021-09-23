package c.a.p0.a.c2.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.c1.d.i;
import c.a.p0.a.e2.c.j.b;
import c.a.p0.a.v2.o0;
import c.a.p0.a.v2.q0;
import c.a.p0.a.v2.s0;
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
public class z extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5126e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f5127f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f5128g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5129h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5130i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ z f5131j;

        public a(z zVar, JSONObject jSONObject, c.a.p0.a.a2.e eVar, Context context, String str, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, jSONObject, eVar, context, str, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5131j = zVar;
            this.f5126e = jSONObject;
            this.f5127f = eVar;
            this.f5128g = context;
            this.f5129h = str;
            this.f5130i = callbackHandler;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.f fVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar == null || fVar.f5549d || fVar.f5555j != 1 || TextUtils.isEmpty(fVar.o.optString("web_url"))) {
                    str = "";
                } else {
                    String optString = fVar.o.optString("web_url");
                    String optString2 = this.f5126e.optString("path");
                    if (!TextUtils.isEmpty(optString2)) {
                        if (!optString.endsWith("/")) {
                            optString = optString + "/";
                        }
                        if (optString2.startsWith("/")) {
                            optString2 = optString2.substring(1);
                        }
                        optString = optString + optString2;
                    }
                    str = o0.a(o0.a(optString, "_swebfr", "1"), "hostname", c.a.p0.a.c1.a.m().a());
                }
                if (!q0.G() && TextUtils.isEmpty(str)) {
                    str = c.a.p0.d.g.c.e().g(this.f5127f.D(), this.f5127f.l(), this.f5126e.optString("path"));
                }
                String str2 = str;
                if (a0.f4774b) {
                    String str3 = "final share url is " + str2;
                }
                this.f5131j.p(str2, this.f5128g, this.f5129h, this.f5130i, this.f5126e, this.f5127f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f5132e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5133f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5134g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5135h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f5136i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ z f5137j;

        public b(z zVar, Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, context, callbackHandler, str, jSONObject, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5137j = zVar;
            this.f5132e = context;
            this.f5133f = callbackHandler;
            this.f5134g = str;
            this.f5135h = jSONObject;
            this.f5136i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f5137j.n(this.f5132e, this.f5133f, this.f5134g, this.f5135h, c.a.p0.a.e2.c.d.h(iVar), this.f5136i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5138a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5139b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ z f5140c;

        public c(z zVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5140c = zVar;
            this.f5138a = callbackHandler;
            this.f5139b = str;
        }

        @Override // c.a.p0.a.c1.d.i.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5140c.q(this.f5138a, this.f5139b, false);
            }
        }

        @Override // c.a.p0.a.c1.d.i.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f5140c.q(this.f5138a, this.f5139b, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(c.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/share");
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

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (context != null && eVar != null) {
                if (eVar.d0()) {
                    boolean z = a0.f4774b;
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    c.a.p0.a.e0.d.b("Share", "params invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                    return false;
                }
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.p0.a.e0.d.b("Share", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                    return false;
                }
                try {
                    a2.put("iconUrl", a2.optString("imageUrl", ""));
                } catch (JSONException e2) {
                    if (a0.f4774b) {
                        e2.toString();
                    }
                }
                eVar.T().e("mapp_i_share_update_weburl", new a(this, a2, eVar, context, optString, callbackHandler));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            c.a.p0.a.e0.d.b("Share", "context or swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "system error");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
            if (Q == null) {
                return null;
            }
            return c.a.p0.a.k2.b.M(str, Q.f4566f);
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
                if (a0.f4774b) {
                    e2.toString();
                }
            }
            r(context, callbackHandler, str, jSONObject);
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
                    jSONObject.putOpt("imageUrl", s0.a(c.a.p0.a.g1.f.V().getActivity(), new File(m2)).toString());
                } catch (JSONException e2) {
                    if (a0.f4774b) {
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
                if (m3 == null || (a3 = s0.a(c.a.p0.a.g1.f.V().getActivity(), new File(m3))) == null) {
                    return jSONObject;
                }
                try {
                    optJSONObject.putOpt("img_show", a3.toString());
                    optJSONObject2.putOpt("info", optJSONObject);
                    jSONObject.putOpt("command", optJSONObject2);
                } catch (JSONException e3) {
                    if (a0.f4774b) {
                        e3.printStackTrace();
                    }
                }
            }
            String optString3 = optJSONObject.optString("img_save");
            if (!optString3.startsWith("bdfile") || (m = m(optString3)) == null || (a2 = s0.a(c.a.p0.a.g1.f.V().getActivity(), new File(m))) == null) {
                return jSONObject;
            }
            try {
                optJSONObject.putOpt("img_save", a2.toString());
                optJSONObject2.putOpt("info", optJSONObject);
                jSONObject.putOpt("command", optJSONObject2);
            } catch (JSONException e4) {
                if (a0.f4774b) {
                    e4.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void p(String str, @NonNull Context context, @NonNull String str2, @NonNull CallbackHandler callbackHandler, @NonNull JSONObject jSONObject, @NonNull c.a.p0.a.a2.e eVar) {
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
                        if (a0.f4774b) {
                            e2.toString();
                        }
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("linkUrl", str);
                }
                if (TextUtils.isEmpty(optString)) {
                    r(context, callbackHandler, str2, jSONObject);
                    return;
                } else if (o0.q(optString)) {
                    jSONObject.put("linkUrl", optString);
                    jSONObject.put("customShareUrl", true);
                    r(context, callbackHandler, str2, jSONObject);
                    return;
                }
            }
            eVar.T().g(context, "mapp_i_share_update_linkurl", new b(this, context, callbackHandler, str2, jSONObject, str));
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
            if (a0.f4774b) {
                e2.toString();
            }
        }
        int i2 = z ? 0 : 1001;
        c.a.p0.a.e0.d.g("Share", "result=" + z);
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i2).toString());
    }

    public final void r(@NonNull Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, callbackHandler, str, jSONObject) == null) {
            jSONObject.remove("defaultPannel");
            jSONObject.remove("shareUrl");
            c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
            if (Q != null) {
                String T = Q.L().T();
                String a2 = c.a.p0.a.q0.a.a();
                JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
                if (optJSONObject != null) {
                    c.a.p0.a.v2.w.f(optJSONObject, "source", T);
                    if (!TextUtils.isEmpty(a2)) {
                        c.a.p0.a.v2.w.f(optJSONObject, "nid", a2);
                    }
                } else {
                    JSONObject f2 = c.a.p0.a.v2.w.f(null, "source", T);
                    if (!TextUtils.isEmpty(a2)) {
                        c.a.p0.a.v2.w.f(f2, "nid", a2);
                    }
                    c.a.p0.a.v2.w.f(jSONObject, "categoryInfo", f2);
                }
            }
            c.a.p0.a.c1.a.Y().a(context, o(jSONObject), new c(this, callbackHandler, str));
        }
    }
}
