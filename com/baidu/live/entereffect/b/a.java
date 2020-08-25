package com.baidu.live.entereffect.b;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static com.baidu.live.entereffect.a.a C(JSONObject jSONObject) {
        com.baidu.live.entereffect.a.a aVar = null;
        if (jSONObject != null) {
            String optString = jSONObject.optString("id");
            String optString2 = jSONObject.optString("mp4_file_url");
            String optString3 = jSONObject.optString(FuFaceItem.JK_SO_URL);
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (!TextUtils.isEmpty(optString) && (!TextUtils.isEmpty(optString2) || !TextUtils.isEmpty(optString3))) {
                aVar = new com.baidu.live.entereffect.a.a();
                aVar.id = optString;
                aVar.priority = jSONObject.optInt("priority_over_gift");
                aVar.videoUrl = optString2;
                aVar.videoMd5 = jSONObject.optString("video_md5");
                aVar.aMa = optString3;
                aVar.frameCount = jSONObject.optInt("frame_count");
                if (optJSONObject != null) {
                    try {
                        optJSONObject.put("repeat_count", 1);
                        optJSONObject.put("frame_count", aVar.frameCount);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                aVar.aMb = new com.baidu.live.gift.c();
                com.baidu.live.gift.b bVar = new com.baidu.live.gift.b();
                bVar.parseJson(jSONObject);
                aVar.aMb.aML = bVar;
            }
        }
        return aVar;
    }

    public static com.baidu.live.entereffect.a.b c(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.live.entereffect.a.b bVar = new com.baidu.live.entereffect.a.b();
            bVar.msgId = j;
            bVar.id = jSONObject.optString("enter_effect_id");
            String trim = jSONObject.optString("bg_color_begin").trim();
            if (!TextUtils.isEmpty(trim) && trim.charAt(0) != '#') {
                trim = UgcConstant.TOPIC_PATTERN_TAG + trim;
            }
            bVar.aMc = trim;
            String trim2 = jSONObject.optString("bg_color_end").trim();
            if (!TextUtils.isEmpty(trim2) && trim2.charAt(0) != '#') {
                trim2 = UgcConstant.TOPIC_PATTERN_TAG + trim2;
            }
            bVar.aMd = trim2;
            bVar.aMe = jSONObject.optString("transparency_begin").trim();
            bVar.aMf = jSONObject.optString("transparency_end").trim();
            bVar.aJg = jSONObject.optString("text_color").trim();
            bVar.aMg = jSONObject.optString("nickname_preix");
            bVar.aMh = jSONObject.optString("nickname_suffix");
            bVar.iconUrl = jSONObject.optString("icon_url");
            bVar.aMi = jSONObject.optInt("icon_width");
            bVar.aMj = jSONObject.optInt("icon_height");
            return bVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
