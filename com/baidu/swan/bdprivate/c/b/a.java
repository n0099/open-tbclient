package com.baidu.swan.bdprivate.c.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.network.i;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.j;
import com.baidu.webkit.internal.ETAG;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends i {
    public a(j jVar) {
        super(jVar, "/swanAPI/adRequest");
    }

    @Override // com.baidu.swan.apps.network.i
    protected boolean a(@NonNull final e eVar, @NonNull final UnitedSchemeEntity unitedSchemeEntity, @NonNull final CallbackHandler callbackHandler, @NonNull final String str) {
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.bdprivate.c.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.b(eVar, unitedSchemeEntity, callbackHandler, str);
            }
        }, "execRequest");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        JSONObject b = b(unitedSchemeEntity, "params");
        String optString = b.optString("cb");
        try {
            String optString2 = b.optString("url");
            a(b, optString2, ag.isBaiduDomain(optString2));
            unitedSchemeEntity.putParams("params", b.toString());
            if (!super.a(eVar, unitedSchemeEntity, callbackHandler, str)) {
                c.e("AdRequest", "request fail");
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        } catch (JSONException e) {
            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
        }
    }

    private void a(JSONObject jSONObject, String str, boolean z) throws JSONException {
        HttpUrl parse;
        JSONObject optJSONObject;
        String str2;
        String str3;
        if (jSONObject != null && !TextUtils.isEmpty(str) && (parse = HttpUrl.parse(str)) != null && (optJSONObject = jSONObject.optJSONObject("extParams")) != null) {
            if (!z) {
                str2 = "";
            } else {
                str2 = Wi();
                JSONObject optJSONObject2 = jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER);
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                }
                l(optJSONObject2, str2);
                jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, optJSONObject2);
            }
            if (DEBUG) {
                Log.d("AdRequestAction", "appendUrlQueryAndHeader: isBaiduDomain=" + z + ", cookie=" + str2);
            }
            HttpUrl.Builder newBuilder = parse.newBuilder();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = optJSONObject.optString(next);
                if (TextUtils.equals(optString, "cuid")) {
                    str3 = com.baidu.swan.apps.w.a.Rp().bn(com.baidu.swan.apps.w.a.Rk());
                } else if (TextUtils.equals(optString, ETAG.KEY_BAIDU_ID) && z) {
                    str3 = ag.getCookieValue(str2, "BAIDUID");
                } else {
                    str3 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                c.i("AdRequest", "key=" + next + ", value=" + str3);
                newBuilder.addQueryParameter(next, str3);
            }
            jSONObject.put("url", newBuilder.build().toString());
        }
    }
}
