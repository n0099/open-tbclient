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

    public void aH(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "resetAccredit");
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("ma_ids", list);
            JSONObject jSONObject = new JSONObject();
            try {
                com.baidu.swan.apps.setting.oauth.g aia = com.baidu.swan.apps.t.a.awX().aia();
                jSONObject.put("accredit", new JSONObject(arrayMap));
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) com.baidu.swan.a.c.a.bbL().postFormRequest().url(com.baidu.swan.apps.t.a.awK().agT())).addParam("data", jSONObject.toString()).cookieManager(aia)).build().executeAsyncOnUIBack(ata());
            } catch (JSONException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "resetAccredit with JSONException: ", e);
                }
            }
        }
    }

    public void aI(List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (DEBUG) {
                Log.d("AbsDefaultPurger", "clearData");
            }
            Set<String> aK = d.aK(list);
            HashSet<String> hashSet = new HashSet(list);
            if (aK != null) {
                hashSet.removeAll(aK);
            }
            com.baidu.swan.apps.t.a.axx().a("aiapp_setting_", hashSet, false);
            com.baidu.swan.apps.t.a.axx().a("aiapp_", hashSet, false);
            for (String str : hashSet) {
                if (DEBUG) {
                    Log.d("AbsDefaultPurger", "clear storage files: " + str);
                }
                String sD = com.baidu.swan.apps.storage.b.sD(str);
                if (!TextUtils.isEmpty(sD)) {
                    com.baidu.swan.c.d.deleteFile(sD);
                }
                String sJ = com.baidu.swan.apps.storage.b.sJ(str);
                if (!TextUtils.isEmpty(sJ)) {
                    com.baidu.swan.c.d.deleteFile(sJ);
                }
            }
        }
    }

    public void na(String str) {
        com.baidu.swan.pms.database.a.bci().xD(str);
        com.baidu.swan.pms.database.a.bci().c(com.baidu.swan.pms.model.f.class, str);
    }

    public void nb(String str) {
        com.baidu.swan.pms.database.a.bci().xF(str);
    }

    @NonNull
    private ResponseCallback<JSONObject> ata() {
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
