package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.mobads.AppActivityImp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class z {
    private String aIt;
    private String aIu;
    private String aIv;
    private String aIw;
    private List<an> aIx;
    private String action;
    private String id;
    private String userId;

    public static z z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        z zVar = new z();
        zVar.action = jSONObject.optString("action");
        zVar.id = jSONObject.optString("id");
        zVar.userId = jSONObject.optString("user_id");
        zVar.aIu = jSONObject.optString("toast_text");
        zVar.aIv = jSONObject.optString("chosen_color_start", "#7C11FF");
        zVar.aIw = jSONObject.optString("chosen_color_end", "#FF3656");
        zVar.aIt = jSONObject.optString(AppActivityImp.EXTRA_LP_THEME);
        JSONArray optJSONArray = jSONObject.optJSONArray("session_conf");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            zVar.aIx = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                an anVar = new an();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                anVar.imageUrl = optJSONObject.optString("img");
                anVar.aJU = optJSONObject.optString("btn_text");
                anVar.url = optJSONObject.optString("session_info");
                anVar.startColor = zVar.aIv;
                anVar.endColor = zVar.aIw;
                zVar.aIx.add(anVar);
            }
            return zVar;
        }
        return zVar;
    }

    public boolean BU() {
        return (this.aIx == null || this.aIx.isEmpty()) ? false : true;
    }

    public List<an> BV() {
        return this.aIx;
    }

    public String getAction() {
        return this.action;
    }

    public String BW() {
        return this.aIw;
    }

    public String BX() {
        return this.aIv;
    }

    public String BY() {
        return this.aIu;
    }

    public boolean fw(String str) {
        return !TextUtils.isEmpty(this.action) && this.action.equals(str);
    }

    public boolean fx(String str) {
        return !TextUtils.isEmpty(this.id) && this.id.equals(str);
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "AlaLiveMultiSession{id='" + this.id + "', userId='" + this.userId + "', theme='" + this.aIt + "', action='" + this.action + "', toastText='" + this.aIu + "', choseColorStart='" + this.aIv + "', choseColorEnd='" + this.aIw + "', sessionList=" + this.aIx + '}';
    }
}
