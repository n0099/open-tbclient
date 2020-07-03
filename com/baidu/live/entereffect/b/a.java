package com.baidu.live.entereffect.b;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static com.baidu.live.entereffect.a.a A(JSONObject jSONObject) {
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
                aVar.aFv = optString3;
                aVar.frameCount = jSONObject.optInt("frame_count");
                if (optJSONObject != null) {
                    try {
                        optJSONObject.put("repeat_count", 1);
                        optJSONObject.put("frame_count", aVar.frameCount);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                aVar.aFw = new com.baidu.live.gift.c();
                com.baidu.live.gift.b bVar = new com.baidu.live.gift.b();
                bVar.parseJson(jSONObject);
                aVar.aFw.aGg = bVar;
            }
        }
        return aVar;
    }

    public static com.baidu.live.entereffect.a.b b(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.live.entereffect.a.b bVar = new com.baidu.live.entereffect.a.b();
            bVar.msgId = j;
            bVar.id = jSONObject.optString("enter_effect_id");
            String optString = jSONObject.optString("bg_color_begin");
            if (!TextUtils.isEmpty(optString) && optString.charAt(0) != '#') {
                optString = UgcConstant.TOPIC_PATTERN_TAG + optString;
            }
            bVar.aFx = optString;
            String optString2 = jSONObject.optString("bg_color_end");
            if (!TextUtils.isEmpty(optString2) && optString2.charAt(0) != '#') {
                optString2 = UgcConstant.TOPIC_PATTERN_TAG + optString2;
            }
            bVar.aFy = optString2;
            bVar.aFz = jSONObject.optString("transparency_begin");
            bVar.aFA = jSONObject.optString("transparency_end");
            bVar.aCB = jSONObject.optString("text_color");
            bVar.aFB = jSONObject.optString("nickname_preix");
            bVar.aFC = jSONObject.optString("nickname_suffix");
            bVar.iconUrl = jSONObject.optString("icon_url");
            bVar.aFD = jSONObject.optInt("icon_width");
            bVar.aFE = jSONObject.optInt("icon_height");
            return bVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
