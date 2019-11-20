package com.baidu.live.entereffect.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static com.baidu.live.entereffect.a.a t(JSONObject jSONObject) {
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
        aVar.Vn = new com.baidu.live.gift.c();
        com.baidu.live.gift.b bVar = new com.baidu.live.gift.b();
        bVar.parseJson(jSONObject);
        aVar.Vn.VT = bVar;
        return aVar;
    }

    public static com.baidu.live.entereffect.a.b ca(String str) {
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
            bVar.Vp = optString;
            String optString2 = jSONObject.optString("bg_color_end");
            if (!TextUtils.isEmpty(optString2) && optString2.charAt(0) != '#') {
                optString2 = '#' + optString2;
            }
            bVar.Vq = optString2;
            bVar.Vr = jSONObject.optString("transparency_begin");
            bVar.Vs = jSONObject.optString("transparency_end");
            bVar.Tz = jSONObject.optString("text_color");
            bVar.Vt = jSONObject.optString("nickname_preix");
            bVar.Vu = jSONObject.optString("nickname_suffix");
            bVar.iconUrl = jSONObject.optString("icon_url");
            bVar.Vv = jSONObject.optInt("icon_width");
            bVar.Vw = jSONObject.optInt("icon_height");
            return bVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
