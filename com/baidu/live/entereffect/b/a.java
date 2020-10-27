package com.baidu.live.entereffect.b;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
                aVar.aRU = optString3;
                aVar.frameCount = jSONObject.optInt("frame_count");
                aVar.aRV = jSONObject.optLong("last_accessed");
                if (optJSONObject != null) {
                    try {
                        optJSONObject.put("repeat_count", 1);
                        optJSONObject.put("frame_count", aVar.frameCount);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                aVar.aRW = new com.baidu.live.gift.c();
                com.baidu.live.gift.b bVar = new com.baidu.live.gift.b();
                bVar.parseJson(jSONObject);
                aVar.aRW.aSL = bVar;
            }
        }
        return aVar;
    }

    public static com.baidu.live.entereffect.a.c d(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.live.entereffect.a.c cVar = new com.baidu.live.entereffect.a.c();
            cVar.msgId = j;
            cVar.id = jSONObject.optString("enter_effect_id");
            String trim = jSONObject.optString("bg_color_begin").trim();
            if (!TextUtils.isEmpty(trim) && trim.charAt(0) != '#') {
                trim = UgcConstant.TOPIC_PATTERN_TAG + trim;
            }
            cVar.aRY = trim;
            String trim2 = jSONObject.optString("bg_color_end").trim();
            if (!TextUtils.isEmpty(trim2) && trim2.charAt(0) != '#') {
                trim2 = UgcConstant.TOPIC_PATTERN_TAG + trim2;
            }
            cVar.aRZ = trim2;
            cVar.aSa = jSONObject.optString("transparency_begin").trim();
            cVar.aSb = jSONObject.optString("transparency_end").trim();
            cVar.aOi = jSONObject.optString("text_color").trim();
            cVar.aSc = jSONObject.optString("nickname_preix");
            cVar.aSd = jSONObject.optString("nickname_suffix");
            cVar.iconUrl = jSONObject.optString("icon_url");
            cVar.aSe = jSONObject.optInt("icon_width");
            cVar.aSf = jSONObject.optInt("icon_height");
            cVar.aSg = jSONObject.optInt("need_effect_file") == 1;
            return cVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
