package c.a.n0.a.v1.f.q0;

import android.content.Context;
import android.util.Log;
import c.a.n0.a.v1.f.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c.a.n0.a.f.e.e f6899c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/webviewPostMessage");
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
            if (z.f6924b) {
                Log.d("WebViewPostMsgAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            c.a.n0.a.u.d.i("webviewPostMsg", "start post webview msg");
            c.a.n0.a.f.e.e eVar2 = this.f6899c;
            if (eVar2 == null) {
                c.a.n0.a.u.d.c("webviewPostMsg", "none webview widget");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none webview widget");
                return false;
            }
            d params = eVar2.getParams();
            if (params == null) {
                c.a.n0.a.u.d.c("webviewPostMsg", "none WWWParams");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none WWWParams");
                return false;
            }
            JSONObject a = z.a(unitedSchemeEntity, "params");
            if (a == null) {
                c.a.n0.a.u.d.c("webviewPostMsg", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                return false;
            } else if (!a.has("data")) {
                c.a.n0.a.u.d.c("webviewPostMsg", "none param data");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none param data");
                return false;
            } else {
                String optString = a.optString("data");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("data", optString);
                    jSONObject.put("eventType", "message");
                    jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, params.f6097c);
                    jSONObject.put("webviewId", params.f6096b);
                } catch (JSONException e2) {
                    if (z.f6924b) {
                        e2.printStackTrace();
                    }
                    c.a.n0.a.u.d.c("webviewPostMsg", "meet json exception");
                }
                c.a.n0.a.q2.g.c.a.c(params.f6097c, params.f6096b, AlbumActivityConfig.FROM_WEB_VIEW, "message", jSONObject);
                c.a.n0.a.u.d.i("webviewPostMsg", "post webview msg success");
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public void j(c.a.n0.a.f.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            this.f6899c = eVar;
        }
    }
}
