package com.baidu.swan.games.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void aYK() {
        String str;
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cuid", com.baidu.swan.apps.t.a.awD().cc(com.baidu.swan.apps.t.a.awy()));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME, aIr.getAppKey());
                jSONObject2.put("type", 0);
                jSONObject2.put("upload_time", System.currentTimeMillis() / 1000);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject2);
                jSONObject.put("app_infos", jSONArray);
                str = jSONObject.toString();
            } catch (Exception e) {
                str = "";
            }
            ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) aIr.aIG().postRequest().cookieManager(com.baidu.swan.apps.t.a.awX().aia())).url(com.baidu.swan.apps.t.a.awK().ahm())).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), str)).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: S */
                public void onSuccess(String str2, int i) {
                    if (200 == i) {
                        try {
                            if (!TextUtils.isEmpty(str2)) {
                                JSONObject jSONObject3 = new JSONObject(str2);
                                if (d.DEBUG && jSONObject3.optInt(BaseJsonData.TAG_ERRNO) != 0) {
                                    Log.e("SwanGameNowUtils", "report game history error");
                                }
                            }
                        } catch (JSONException e2) {
                        }
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                }
            });
        }
    }
}
