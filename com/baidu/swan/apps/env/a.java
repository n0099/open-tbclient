package com.baidu.swan.apps.env;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public void aC(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "resetAccredit");
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("ma_ids", list);
            JSONObject jSONObject = new JSONObject();
            try {
                com.baidu.swan.apps.setting.oauth.g aiB = com.baidu.swan.apps.t.a.axy().aiB();
                jSONObject.put("accredit", new JSONObject(arrayMap));
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) com.baidu.swan.a.c.a.bca().postFormRequest().url(com.baidu.swan.apps.t.a.axl().ahu())).addParam("data", jSONObject.toString()).cookieManager(aiB)).build().executeAsyncOnUIBack(atB());
            } catch (JSONException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "resetAccredit with JSONException: ", e);
                }
            }
        }
    }

    public void aD(List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "clearData");
            }
            Set<String> aF = d.aF(list);
            HashSet<String> hashSet = new HashSet(list);
            if (aF != null) {
                hashSet.removeAll(aF);
            }
            com.baidu.swan.apps.t.a.axY().a("aiapp_setting_", hashSet, false);
            com.baidu.swan.apps.t.a.axY().a("aiapp_", hashSet, false);
            for (String str : hashSet) {
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "clear storage files: " + str);
                }
                String td = com.baidu.swan.apps.storage.b.td(str);
                if (!TextUtils.isEmpty(td)) {
                    com.baidu.swan.c.d.deleteFile(td);
                }
                String tj = com.baidu.swan.apps.storage.b.tj(str);
                if (!TextUtils.isEmpty(tj)) {
                    com.baidu.swan.c.d.deleteFile(tj);
                }
            }
        }
    }

    public void nz(String str) {
        com.baidu.swan.pms.database.a.bcx().yd(str);
        com.baidu.swan.pms.database.a.bcx().c(com.baidu.swan.pms.model.f.class, str);
    }

    public void nA(String str) {
        com.baidu.swan.pms.database.a.bcx().yf(str);
    }

    @NonNull
    private ResponseCallback<JSONObject> atB() {
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
