package com.baidu.swan.apps.env;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
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

    public void O(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "resetAccredit");
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("ma_ids", list);
            JSONObject jSONObject = new JSONObject();
            try {
                com.baidu.swan.apps.setting.oauth.g Gd = com.baidu.swan.apps.w.a.Se().Gd();
                jSONObject.put("accredit", new JSONObject(arrayMap));
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(com.baidu.swan.apps.w.a.RS().FF())).addParam("data", jSONObject.toString()).cookieManager(Gd)).build().executeAsyncOnUIBack(Ph());
            } catch (JSONException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "resetAccredit with JSONException: ", e);
                }
            }
        }
    }

    public void P(List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "clearData");
            }
            Set<String> R = d.R(list);
            HashSet<String> hashSet = new HashSet(list);
            if (R != null) {
                hashSet.removeAll(R);
            }
            d.a("aiapp_setting_", hashSet, false);
            d.a("aiapp_", hashSet, false);
            for (String str : hashSet) {
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "clear storage files: " + str);
                }
                String lE = com.baidu.swan.apps.storage.b.lE(str);
                if (!TextUtils.isEmpty(lE)) {
                    com.baidu.swan.d.c.deleteFile(lE);
                }
                String lJ = com.baidu.swan.apps.storage.b.lJ(str);
                if (!TextUtils.isEmpty(lJ)) {
                    com.baidu.swan.d.c.deleteFile(lJ);
                }
            }
        }
    }

    public void hq(String str) {
        com.baidu.swan.pms.database.a.arf().qa(str);
        com.baidu.swan.pms.database.a.arf().b(com.baidu.swan.pms.model.f.class, str);
    }

    public void hr(String str) {
        com.baidu.swan.pms.database.a.arf().qb(str);
    }

    @NonNull
    private ResponseCallback<JSONObject> Ph() {
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
