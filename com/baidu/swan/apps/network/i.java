package com.baidu.swan.apps.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.ap.ak;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
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
            String jU = com.baidu.swan.apps.api.module.network.c.jU(eVar.id);
            if (a(eVar, unitedSchemeEntity, callbackHandler, jU)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jW(jU), 0));
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
        Pair<HttpRequest, Integer> q = com.baidu.swan.apps.api.module.network.b.q(b, str);
        HttpRequest httpRequest = (HttpRequest) q.first;
        if (httpRequest == null) {
            unitedSchemeEntity.result = iL(((Integer) q.second).intValue());
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
            final int appFrameType = eVar.YI().getAppFrameType();
            if (!com.baidu.swan.apps.t.a.apx().ZT()) {
                com.baidu.swan.apps.statistic.h.a(httpUrl, appFrameType, (NetworkStatRecord) null);
            }
            final a aVar = new a(eVar, jSONObject, httpUrl, str, callbackHandler, optString);
            httpRequest.executeStat(new StatResponseCallback() { // from class: com.baidu.swan.apps.network.i.1
                @Override // com.baidu.searchbox.http.callback.StatResponseCallback
                public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
                    com.baidu.swan.apps.core.i.a.ajS().a(str, url, networkStatRecord);
                    if (com.baidu.swan.apps.t.a.apx().ZT()) {
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
                    if (com.baidu.swan.apps.t.a.apx().ZT()) {
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
                com.baidu.swan.apps.statistic.h.a(str, eVar.YI().getAppFrameType(), (NetworkStatRecord) null);
                new com.baidu.swan.games.bdtls.b.c(eVar, jSONObject, str2, new a(eVar, jSONObject, str, str2, callbackHandler, str3)).request(optString);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements Callback {
        com.baidu.swan.apps.runtime.e bYZ;
        String bZa;
        long bZc = System.currentTimeMillis();
        CallbackHandler ctP;
        String mCallback;
        JSONObject mParams;
        String mUrl;

        a(@NonNull com.baidu.swan.apps.runtime.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
            this.bYZ = eVar;
            this.mParams = jSONObject;
            this.mUrl = str;
            this.bZa = str2;
            this.ctP = callbackHandler;
            this.mCallback = str3;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (i.DEBUG) {
                Log.d("RequestAction", "onFailure: " + iOException.getMessage());
            }
            int appFrameType = this.bYZ.YI().getAppFrameType();
            String aDm = com.baidu.swan.apps.statistic.h.aDm();
            String page = ak.aFZ().getPage();
            SwanAppNetworkUtils.a(com.baidu.swan.a.c.a.aTI().getOkHttpClient(), this.bZa);
            this.ctP.handleSchemeDispatchCallback(this.mCallback, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
            com.baidu.swan.apps.statistic.h.a(0, this.mUrl, appFrameType, iOException.getMessage(), aDm, page, this.bZc, System.currentTimeMillis());
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String ay = com.baidu.swan.apps.api.module.network.b.ay(this.mParams);
            String az = com.baidu.swan.apps.api.module.network.b.az(this.mParams);
            int appFrameType = this.bYZ.YI().getAppFrameType();
            long currentTimeMillis = System.currentTimeMillis();
            String aDm = com.baidu.swan.apps.statistic.h.aDm();
            String page = ak.aFZ().getPage();
            String optString = this.mParams.optString("cb");
            try {
                long a = com.baidu.swan.apps.api.module.network.b.a(response);
                if (a <= 10485760) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, com.baidu.swan.apps.network.a.a(response.headers()));
                    com.baidu.swan.apps.api.module.network.b.a(jSONObject, response.body(), ay, az);
                    i.this.bc(jSONObject);
                    this.ctP.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } else {
                    com.baidu.swan.apps.api.module.network.b.a(this.bYZ, this.mUrl, a, currentTimeMillis);
                    this.ctP.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                }
            } catch (IOException | JSONException e) {
                if (i.DEBUG) {
                    Log.d("RequestAction", Log.getStackTraceString(e));
                }
                this.ctP.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
            }
            int code = response.code();
            String message = response.message();
            if (i.DEBUG) {
                Log.d("RequestAction", "onResponse: respCode: " + code + ", url=" + this.mUrl + ", msg=" + message);
            }
            com.baidu.swan.apps.statistic.h.a(code, this.mUrl, appFrameType, message, aDm, page, this.bZc, System.currentTimeMillis());
        }
    }

    protected void bc(@NonNull JSONObject jSONObject) throws JSONException {
    }
}
