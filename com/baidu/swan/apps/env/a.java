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
/* loaded from: classes11.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public void X(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "resetAccredit");
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("ma_ids", list);
            JSONObject jSONObject = new JSONObject();
            try {
                com.baidu.swan.apps.setting.oauth.g SM = com.baidu.swan.apps.u.a.afo().SM();
                jSONObject.put("accredit", new JSONObject(arrayMap));
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) com.baidu.swan.c.c.a.aFx().postFormRequest().url(com.baidu.swan.apps.u.a.afd().RO())).addParam("data", jSONObject.toString()).cookieManager(SM)).build().executeAsyncOnUIBack(acp());
            } catch (JSONException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "resetAccredit with JSONException: ", e);
                }
            }
        }
    }

    public void Y(List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "clearData");
            }
            Set<String> aa = d.aa(list);
            HashSet<String> hashSet = new HashSet(list);
            if (aa != null) {
                hashSet.removeAll(aa);
            }
            com.baidu.swan.apps.u.a.afO().a("aiapp_setting_", hashSet, false);
            com.baidu.swan.apps.u.a.afO().a("aiapp_", hashSet, false);
            for (String str : hashSet) {
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "clear storage files: " + str);
                }
                String oI = com.baidu.swan.apps.storage.b.oI(str);
                if (!TextUtils.isEmpty(oI)) {
                    com.baidu.swan.e.d.deleteFile(oI);
                }
                String oO = com.baidu.swan.apps.storage.b.oO(str);
                if (!TextUtils.isEmpty(oO)) {
                    com.baidu.swan.e.d.deleteFile(oO);
                }
            }
        }
    }

    public void jZ(String str) {
        com.baidu.swan.pms.database.a.aFV().tg(str);
        com.baidu.swan.pms.database.a.aFV().b(com.baidu.swan.pms.model.f.class, str);
    }

    public void ka(String str) {
        com.baidu.swan.pms.database.a.aFV().th(str);
    }

    @NonNull
    private ResponseCallback<JSONObject> acp() {
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
