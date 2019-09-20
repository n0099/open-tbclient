package com.baidu.swan.games.view.recommend.d;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    @NonNull
    public static d kh(String str) {
        d dVar = new d();
        try {
            JSONObject jSONObject = new JSONObject(str);
            dVar.IL = jSONObject.getInt("errno");
            dVar.errMsg = jSONObject.optString("errmsg");
            dVar.data = jSONObject.optJSONObject("data");
        } catch (JSONException e) {
            dVar.IL = -1;
            dVar.errMsg = "network error: response parse failed.";
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("RecommendModelParser", "parseResponseModel error:" + e);
            }
        }
        return dVar;
    }

    @NonNull
    public static b az(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject == null) {
            return bVar;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("game_center");
        if (optJSONObject != null) {
            bVar.bnD = aA(optJSONObject);
        }
        bVar.bnE = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("app_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                bVar.bnE.add(aA(optJSONArray.optJSONObject(i)));
            }
        }
        return bVar;
    }

    @NonNull
    private static a aA(@NonNull JSONObject jSONObject) {
        a aVar = new a();
        aVar.appName = jSONObject.optString(DpStatConstants.KEY_APP_NAME);
        aVar.appKey = jSONObject.optString("app_key");
        aVar.iconUrl = jSONObject.optString("icon_url");
        aVar.scheme = jSONObject.optString("scheme");
        aVar.desc = jSONObject.optString("desc");
        JSONObject optJSONObject = jSONObject.optJSONObject("button");
        if (optJSONObject != null) {
            aVar.buttonText = optJSONObject.optString("text");
        }
        return aVar;
    }
}
