package com.baidu.swan.games.view.recommend.model;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    @NonNull
    public static c sL(String str) {
        c cVar = new c();
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.Rn = jSONObject.getInt(BaseJsonData.TAG_ERRNO);
            cVar.errMsg = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
            cVar.data = jSONObject.optJSONObject("data");
        } catch (JSONException e) {
            cVar.Rn = -1;
            cVar.errMsg = "network error: response parse failed.";
            if (com.baidu.swan.apps.b.DEBUG) {
                Log.e("RecommendModelParser", "parseResponseModel error:" + e);
            }
        }
        return cVar;
    }

    @NonNull
    public static a bU(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject == null) {
            return aVar;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("game_center");
        if (optJSONObject != null) {
            aVar.deL = bV(optJSONObject);
        }
        aVar.deM = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("app_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.deM.add(bV(optJSONArray.optJSONObject(i)));
            }
        }
        return aVar;
    }

    @NonNull
    private static RecommendItemModel bV(@NonNull JSONObject jSONObject) {
        RecommendItemModel recommendItemModel = new RecommendItemModel();
        recommendItemModel.appName = jSONObject.optString("app_name");
        recommendItemModel.appKey = jSONObject.optString("app_key");
        recommendItemModel.iconUrl = jSONObject.optString("icon_url");
        recommendItemModel.scheme = jSONObject.optString(SuspensionBallEntity.KEY_SCHEME);
        recommendItemModel.desc = jSONObject.optString("desc");
        JSONObject optJSONObject = jSONObject.optJSONObject("button");
        if (optJSONObject != null) {
            recommendItemModel.buttonText = optJSONObject.optString("text");
        }
        return recommendItemModel;
    }
}
