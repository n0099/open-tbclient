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
/* loaded from: classes7.dex */
public abstract class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public void aA(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "resetAccredit");
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("ma_ids", list);
            JSONObject jSONObject = new JSONObject();
            try {
                com.baidu.swan.apps.setting.oauth.g ahB = com.baidu.swan.apps.t.a.awr().ahB();
                jSONObject.put("accredit", new JSONObject(arrayMap));
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) com.baidu.swan.a.c.a.bad().postFormRequest().url(com.baidu.swan.apps.t.a.awe().agw())).addParam("data", jSONObject.toString()).cookieManager(ahB)).build().executeAsyncOnUIBack(ast());
            } catch (JSONException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "resetAccredit with JSONException: ", e);
                }
            }
        }
    }

    public void aB(List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "clearData");
            }
            Set<String> aD = d.aD(list);
            HashSet<String> hashSet = new HashSet(list);
            if (aD != null) {
                hashSet.removeAll(aD);
            }
            com.baidu.swan.apps.t.a.awR().a("aiapp_setting_", hashSet, false);
            com.baidu.swan.apps.t.a.awR().a("aiapp_", hashSet, false);
            for (String str : hashSet) {
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "clear storage files: " + str);
                }
                String tk = com.baidu.swan.apps.storage.b.tk(str);
                if (!TextUtils.isEmpty(tk)) {
                    com.baidu.swan.c.d.deleteFile(tk);
                }
                String tq = com.baidu.swan.apps.storage.b.tq(str);
                if (!TextUtils.isEmpty(tq)) {
                    com.baidu.swan.c.d.deleteFile(tq);
                }
            }
        }
    }

    public void nL(String str) {
        com.baidu.swan.pms.database.a.baA().yi(str);
        com.baidu.swan.pms.database.a.baA().b(com.baidu.swan.pms.model.f.class, str);
    }

    public void nM(String str) {
        com.baidu.swan.pms.database.a.baA().yk(str);
    }

    @NonNull
    private ResponseCallback<JSONObject> ast() {
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
