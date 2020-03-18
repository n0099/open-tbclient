package com.baidu.swan.apps.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.as.ai;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes11.dex */
public class i extends a implements f {
    public i(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/request");
    }

    public i(com.baidu.swan.apps.scheme.j jVar, String str) {
        super(jVar, str);
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (a(eVar, unitedSchemeEntity)) {
            String fH = com.baidu.swan.apps.api.module.g.c.fH(eVar.id);
            if (a(eVar, unitedSchemeEntity, callbackHandler, fH)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(fJ(fH), 0));
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(@NonNull final com.baidu.swan.apps.runtime.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull final CallbackHandler callbackHandler, @NonNull final String str) {
        JSONObject b = b(unitedSchemeEntity, "params");
        Pair<Request, Integer> j = com.baidu.swan.apps.api.module.g.b.j(b, str);
        Request request = (Request) j.first;
        if (request == null) {
            unitedSchemeEntity.result = fC(((Integer) j.second).intValue());
            return false;
        }
        final String S = com.baidu.swan.apps.api.module.g.b.S(b);
        final String T = com.baidu.swan.apps.api.module.g.b.T(b);
        final int appFrameType = eVar.GJ().getAppFrameType();
        final String httpUrl = request.url().toString();
        final long currentTimeMillis = System.currentTimeMillis();
        final String afb = com.baidu.swan.apps.statistic.f.afb();
        final String page = ai.ahn().getPage();
        final String optString = b.optString("cb");
        final long currentTimeMillis2 = System.currentTimeMillis();
        com.baidu.swan.apps.statistic.f.F(httpUrl, appFrameType);
        eVar.acU().a(request, new Callback() { // from class: com.baidu.swan.apps.network.i.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (i.DEBUG) {
                    Log.d("RequestAction", "onFailure: " + iOException.getMessage());
                }
                SwanAppNetworkUtils.a(eVar.acU().YZ(), str);
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    com.baidu.swan.apps.statistic.f.a(0, httpUrl, appFrameType, iOException.getMessage(), afb, page, currentTimeMillis2, System.currentTimeMillis());
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    long a = com.baidu.swan.apps.api.module.g.b.a(response);
                    if (a <= 10485760) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", response.code());
                        jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, a.a(response.headers()));
                        com.baidu.swan.apps.api.module.g.b.a(jSONObject, response.body(), S, T);
                        i.this.au(jSONObject);
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        com.baidu.swan.apps.api.module.g.b.a(eVar, httpUrl, a, currentTimeMillis);
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                    }
                } catch (IOException | JSONException e) {
                    if (i.DEBUG) {
                        Log.d("RequestAction", Log.getStackTraceString(e));
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                }
                int code = response.code();
                String message = response.message();
                if (i.DEBUG) {
                    Log.d("RequestAction", "onResponse: respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                }
                com.baidu.swan.apps.statistic.f.a(code, httpUrl, appFrameType, message, afb, page, currentTimeMillis2, System.currentTimeMillis());
            }
        });
        return true;
    }

    protected void au(@NonNull JSONObject jSONObject) throws JSONException {
    }
}
