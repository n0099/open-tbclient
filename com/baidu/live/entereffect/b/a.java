package com.baidu.live.entereffect.b;

import android.text.TextUtils;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static com.baidu.live.entereffect.a.a G(JSONObject jSONObject) {
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
                aVar.aRi = optString3;
                aVar.frameCount = jSONObject.optInt("frame_count");
                aVar.aRj = jSONObject.optLong("last_accessed");
                if (optJSONObject != null) {
                    try {
                        optJSONObject.put("repeat_count", 1);
                        optJSONObject.put("frame_count", aVar.frameCount);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                aVar.aRk = new com.baidu.live.gift.c();
                com.baidu.live.gift.b bVar = new com.baidu.live.gift.b();
                bVar.parseJson(jSONObject);
                aVar.aRk.aSo = bVar;
            }
        }
        return aVar;
    }

    public static com.baidu.live.entereffect.a.c d(long j, String str, String str2) {
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
                trim = '#' + trim;
            }
            cVar.aRm = trim;
            String trim2 = jSONObject.optString("bg_color_end").trim();
            if (!TextUtils.isEmpty(trim2) && trim2.charAt(0) != '#') {
                trim2 = '#' + trim2;
            }
            cVar.aRn = trim2;
            cVar.aRo = jSONObject.optString("transparency_begin").trim();
            cVar.aRp = jSONObject.optString("transparency_end").trim();
            cVar.aRq = jSONObject.optString("text_color").trim();
            cVar.aRr = jSONObject.optString("nickname_preix");
            cVar.aRs = jSONObject.optString("nickname_suffix");
            cVar.iconUrl = jSONObject.optString("icon_url");
            cVar.aRt = jSONObject.optInt("icon_width");
            cVar.aRu = jSONObject.optInt("icon_height");
            cVar.aRv = jSONObject.optInt("need_effect_file") == 1;
            cVar.portrait = str2;
            String optString = jSONObject.optString("level_icon_url");
            if (!TextUtils.isEmpty(optString)) {
                cVar.iconUrl = optString;
                int optInt = jSONObject.optInt("level_icon_width");
                int optInt2 = jSONObject.optInt("level_icon_height");
                if (optInt > 0 && optInt2 > 0) {
                    cVar.aRt = optInt;
                    cVar.aRu = optInt2;
                }
            }
            return cVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
