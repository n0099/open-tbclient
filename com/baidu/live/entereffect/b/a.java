package com.baidu.live.entereffect.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static com.baidu.live.entereffect.a.a p(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.live.entereffect.a.a aVar = new com.baidu.live.entereffect.a.a(jSONObject);
        String optString = jSONObject.optString("id");
        String optString2 = jSONObject.optString("file_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || optJSONObject == null) {
            return null;
        }
        aVar.id = optString;
        aVar.url = optString2;
        aVar.priority = jSONObject.optInt("priority_over_gift");
        aVar.frameCount = jSONObject.optInt("frame_count");
        try {
            optJSONObject.put("repeat_count", 1);
            optJSONObject.put("frame_count", aVar.frameCount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aVar.acO = new com.baidu.live.gift.c();
        com.baidu.live.gift.b bVar = new com.baidu.live.gift.b();
        bVar.parseJson(jSONObject);
        aVar.acO.adu = bVar;
        return aVar;
    }

    public static com.baidu.live.entereffect.a.b cR(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.live.entereffect.a.b bVar = new com.baidu.live.entereffect.a.b();
            bVar.id = jSONObject.optString("enter_effect_id");
            String optString = jSONObject.optString("bg_color_begin");
            if (!TextUtils.isEmpty(optString) && optString.charAt(0) != '#') {
                optString = '#' + optString;
            }
            bVar.acQ = optString;
            String optString2 = jSONObject.optString("bg_color_end");
            if (!TextUtils.isEmpty(optString2) && optString2.charAt(0) != '#') {
                optString2 = '#' + optString2;
            }
            bVar.acR = optString2;
            bVar.acS = jSONObject.optString("transparency_begin");
            bVar.acT = jSONObject.optString("transparency_end");
            bVar.aaq = jSONObject.optString("text_color");
            bVar.acU = jSONObject.optString("nickname_preix");
            bVar.acV = jSONObject.optString("nickname_suffix");
            bVar.iconUrl = jSONObject.optString("icon_url");
            bVar.acW = jSONObject.optInt("icon_width");
            bVar.acX = jSONObject.optInt("icon_height");
            return bVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
