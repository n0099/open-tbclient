package com.baidu.swan.apps.env;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public void aj(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "resetAccredit");
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("ma_ids", list);
            JSONObject jSONObject = new JSONObject();
            try {
                com.baidu.swan.apps.setting.oauth.g adP = com.baidu.swan.apps.t.a.asF().adP();
                jSONObject.put("accredit", new JSONObject(arrayMap));
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) com.baidu.swan.a.c.a.aWr().postFormRequest().url(com.baidu.swan.apps.t.a.ass().acK())).addParam("data", jSONObject.toString()).cookieManager(adP)).build().executeAsyncOnUIBack(aoF());
            } catch (JSONException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "resetAccredit with JSONException: ", e);
                }
            }
        }
    }

    public void ak(List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "clearData");
            }
            Set<String> am = d.am(list);
            HashSet<String> hashSet = new HashSet(list);
            if (am != null) {
                hashSet.removeAll(am);
            }
            com.baidu.swan.apps.t.a.atf().a("aiapp_setting_", hashSet, false);
            com.baidu.swan.apps.t.a.atf().a("aiapp_", hashSet, false);
            for (String str : hashSet) {
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "clear storage files: " + str);
                }
                String sI = com.baidu.swan.apps.storage.b.sI(str);
                if (!TextUtils.isEmpty(sI)) {
                    com.baidu.swan.c.d.deleteFile(sI);
                }
                String sO = com.baidu.swan.apps.storage.b.sO(str);
                if (!TextUtils.isEmpty(sO)) {
                    com.baidu.swan.c.d.deleteFile(sO);
                }
            }
        }
    }

    public void nk(String str) {
        com.baidu.swan.pms.database.a.aWO().xG(str);
        com.baidu.swan.pms.database.a.aWO().b(com.baidu.swan.pms.model.f.class, str);
    }

    public void nl(String str) {
        com.baidu.swan.pms.database.a.aWO().xI(str);
    }

    @NonNull
    private ResponseCallback<JSONObject> aoF() {
        return new ResponseCallback<JSONObject>() { // from class: com.baidu.swan.apps.env.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public JSONObject parseResponse(Response response, int i) throws Exception {
                if (a.DEBUG) {
                    Log.d("AbsDefaultPurger", "parseResponse");
                }
                if (response == null || response.body() == null) {
                    return null;
                }
                String string = response.body().string();
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                return new JSONObject(string);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public void onSuccess(JSONObject jSONObject, int i) {
                if (a.DEBUG) {
                    Log.e("AbsDefaultPurger", "onSuccess: ");
                }
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (a.DEBUG) {
                    Log.e("AbsDefaultPurger", "onFail: " + exc);
                }
            }
        };
    }
}
