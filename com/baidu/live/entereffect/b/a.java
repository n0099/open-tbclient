package com.baidu.live.entereffect.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static com.baidu.live.entereffect.a.a o(JSONObject jSONObject) {
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
        aVar.ade = new com.baidu.live.gift.c();
        com.baidu.live.gift.b bVar = new com.baidu.live.gift.b();
        bVar.parseJson(jSONObject);
        aVar.ade.adJ = bVar;
        return aVar;
    }

    public static com.baidu.live.entereffect.a.b cT(String str) {
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
            bVar.adg = optString;
            String optString2 = jSONObject.optString("bg_color_end");
            if (!TextUtils.isEmpty(optString2) && optString2.charAt(0) != '#') {
                optString2 = '#' + optString2;
            }
            bVar.adh = optString2;
            bVar.adi = jSONObject.optString("transparency_begin");
            bVar.adj = jSONObject.optString("transparency_end");
            bVar.aaC = jSONObject.optString("text_color");
            bVar.adk = jSONObject.optString("nickname_preix");
            bVar.adl = jSONObject.optString("nickname_suffix");
            bVar.iconUrl = jSONObject.optString("icon_url");
            bVar.adm = jSONObject.optInt("icon_width");
            bVar.adn = jSONObject.optInt("icon_height");
            return bVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
