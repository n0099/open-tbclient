package com.baidu.swan.apps.api.module.j;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.runtime.e;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lZ(String str) {
        if (DEBUG) {
            Log.d("Api-Subscription", "subscribe with json string:  " + str);
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.j.a.1
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(e eVar, JSONObject jSONObject, String str2) {
                return a.this.c(eVar, jSONObject, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.api.c.b c(@NonNull e eVar, @NonNull JSONObject jSONObject, String str) {
        Pair<Request, Integer> a2 = a(eVar, jSONObject);
        Request request = (Request) a2.first;
        if (request == null) {
            return new com.baidu.swan.apps.api.c.b(((Integer) a2.second).intValue(), "params error");
        }
        a(request, str);
        return new com.baidu.swan.apps.api.c.b(0, "success");
    }

    private Pair<Request, Integer> a(@NonNull e eVar, @NonNull JSONObject jSONObject) {
        RequestBody b2 = b(eVar, jSONObject);
        if (b2 == null) {
            return new Pair<>(null, 202);
        }
        return new Pair<>(new Request.Builder().url(com.baidu.swan.apps.t.a.aAX().alm()).post(b2).build(), 0);
    }

    private void a(@NonNull Request request, final String str) {
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a(request.url().toString(), request.body(), new ResponseCallback() { // from class: com.baidu.swan.apps.api.module.j.a.2
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                a.this.a(str, a.this.c(response));
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                a.this.bm(str, exc == null ? "" : exc.getMessage());
            }
        });
        aVar.tag = request.tag();
        aVar.ewn = true;
        aVar.ewo = true;
        aVar.ewp = true;
        com.baidu.swan.a.c.a.bfF().b(aVar);
    }

    private RequestBody b(@NonNull e eVar, @NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("subscribeId");
        String appKey = eVar.getAppKey();
        String optString2 = jSONObject.optString("templateId");
        if (TextUtils.isEmpty(appKey) || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new FormBody.Builder().add("appkey", appKey).add("uniq_id", optString).add("type", jSONObject.optString("type", "query")).add("template_id", optString2).build();
    }

    public com.baidu.swan.apps.api.c.b c(Response response) {
        if (response == null || response.body() == null) {
            return new com.baidu.swan.apps.api.c.b(500106, "response body is null");
        }
        try {
            String string = response.body().string();
            if (DEBUG) {
                Log.i("Api-Subscription", string);
            }
            JSONObject jSONObject = new JSONObject(string);
            String optString = jSONObject.optString(BaseJsonData.TAG_ERRNO);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (!TextUtils.equals("0", optString) || optJSONObject == null) {
                return new com.baidu.swan.apps.api.c.b(500106, "subscribe fail");
            }
            return new com.baidu.swan.apps.api.c.b(0, optJSONObject, false);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return new com.baidu.swan.apps.api.c.b(500106, Log.getStackTraceString(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(@NonNull String str, String str2) {
        a(str, new com.baidu.swan.apps.api.c.b(500106, str2));
    }
}
