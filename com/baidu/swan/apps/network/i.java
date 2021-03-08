package com.baidu.swan.apps.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.ao.ak;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes8.dex */
public class i extends com.baidu.swan.apps.network.a implements f {
    public i(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/request");
    }

    public i(com.baidu.swan.apps.scheme.j jVar, String str) {
        super(jVar, str);
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            Log.d("Api-Request", "request with scheme : " + unitedSchemeEntity.getParam("params"));
        }
        if (a(eVar, unitedSchemeEntity)) {
            String kW = com.baidu.swan.apps.api.module.network.c.kW(eVar.id);
            if (a(eVar, unitedSchemeEntity, callbackHandler, kW)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(kY(kW), 0));
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            return false;
        }
        Pair<HttpRequest, Integer> m = com.baidu.swan.apps.api.module.network.b.m(b, str);
        HttpRequest httpRequest = (HttpRequest) m.first;
        if (httpRequest == null) {
            unitedSchemeEntity.result = iq(((Integer) m.second).intValue());
            return false;
        }
        a(eVar, b, httpRequest, str, callbackHandler);
        return true;
    }

    private void a(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull final String str, @NonNull CallbackHandler callbackHandler) {
        final HttpUrl url = httpRequest.getOkRequest().url();
        final String httpUrl = url.toString();
        String optString = jSONObject.optString("cb");
        if (!a(eVar, jSONObject, httpUrl, str, callbackHandler, optString)) {
            final int appFrameType = eVar.agc().getAppFrameType();
            if (!com.baidu.swan.apps.t.a.axc().ahp()) {
                com.baidu.swan.apps.statistic.h.a(httpUrl, appFrameType, (NetworkStatRecord) null);
            }
            final a aVar = new a(eVar, jSONObject, httpUrl, str, callbackHandler, optString);
            httpRequest.executeStat(new StatResponseCallback() { // from class: com.baidu.swan.apps.network.i.1
                @Override // com.baidu.searchbox.http.callback.StatResponseCallback
                public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
                    com.baidu.swan.apps.core.i.a.arw().a(str, url, networkStatRecord);
                    if (com.baidu.swan.apps.t.a.axc().ahp()) {
                        com.baidu.swan.apps.statistic.h.a(httpUrl, appFrameType, networkStatRecord);
                    }
                    aVar.onResponse(null, response);
                    return response;
                }

                @Override // com.baidu.searchbox.http.callback.StatResponseCallback
                public void onSuccess(Object obj, int i) {
                }

                @Override // com.baidu.searchbox.http.callback.StatResponseCallback
                public void onFail(Exception exc) {
                    if (com.baidu.swan.apps.t.a.axc().ahp()) {
                        com.baidu.swan.apps.statistic.h.a(httpUrl, appFrameType, (NetworkStatRecord) null);
                    }
                    if (exc instanceof IOException) {
                        aVar.onFailure(null, (IOException) exc);
                    } else {
                        aVar.onFailure(null, new IOException(exc));
                    }
                }
            });
        }
    }

    private boolean a(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        if (optJSONObject != null && optJSONObject.optBoolean("enableBdtls", false)) {
            String optString = optJSONObject.optString("serviceId");
            if (TextUtils.isEmpty(optString)) {
                callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParams(1001, "serviceId is invalid").toString());
            } else {
                com.baidu.swan.apps.statistic.h.a(str, eVar.agc().getAppFrameType(), (NetworkStatRecord) null);
                new com.baidu.swan.games.bdtls.b.c(eVar, jSONObject, str2, new a(eVar, jSONObject, str, str2, callbackHandler, str3)).request(optString);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Callback {
        com.baidu.swan.apps.runtime.e cIT;
        String cIU;
        long cIW = System.currentTimeMillis();
        CallbackHandler ddq;
        String mCallback;
        JSONObject mParams;
        String mUrl;

        a(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
            this.cIT = eVar;
            this.mParams = jSONObject;
            this.mUrl = str;
            this.cIU = str2;
            this.ddq = callbackHandler;
            this.mCallback = str3;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (i.DEBUG) {
                Log.d("RequestAction", "onFailure: " + iOException.getMessage());
            }
            int appFrameType = this.cIT.agc().getAppFrameType();
            String aLH = com.baidu.swan.apps.statistic.h.aLH();
            String page = ak.aOu().getPage();
            SwanAppNetworkUtils.a(com.baidu.swan.a.c.a.bca().getOkHttpClient(), this.cIU);
            this.ddq.handleSchemeDispatchCallback(this.mCallback, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
            com.baidu.swan.apps.statistic.h.a(0, this.mUrl, appFrameType, iOException.getMessage(), aLH, page, this.cIW, System.currentTimeMillis());
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String aR = com.baidu.swan.apps.api.module.network.b.aR(this.mParams);
            String aS = com.baidu.swan.apps.api.module.network.b.aS(this.mParams);
            int appFrameType = this.cIT.agc().getAppFrameType();
            long currentTimeMillis = System.currentTimeMillis();
            String aLH = com.baidu.swan.apps.statistic.h.aLH();
            String page = ak.aOu().getPage();
            String optString = this.mParams.optString("cb");
            try {
                long b = com.baidu.swan.apps.api.module.network.b.b(response);
                if (b <= 10485760) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, com.baidu.swan.apps.network.a.a(response.headers()));
                    com.baidu.swan.apps.api.module.network.b.a(jSONObject, response.body(), aR, aS);
                    i.this.bv(jSONObject);
                    this.ddq.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } else {
                    com.baidu.swan.apps.api.module.network.b.a(this.cIT, this.mUrl, b, currentTimeMillis);
                    this.ddq.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                }
            } catch (IOException | JSONException e) {
                if (i.DEBUG) {
                    Log.d("RequestAction", Log.getStackTraceString(e));
                }
                this.ddq.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
            }
            int code = response.code();
            String message = response.message();
            if (i.DEBUG) {
                Log.d("RequestAction", "onResponse: respCode: " + code + ", url=" + this.mUrl + ", msg=" + message);
            }
            com.baidu.swan.apps.statistic.h.a(code, this.mUrl, appFrameType, message, aLH, page, this.cIW, System.currentTimeMillis());
        }
    }

    protected void bv(@NonNull JSONObject jSONObject) throws JSONException {
    }
}
