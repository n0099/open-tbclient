package com.baidu.live.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class u {
    private String aIu;
    private String aIv;
    private String aIw;
    private String aIx;
    private List<ae> aIy;
    private String action;
    private String id;
    private String userId;

    public static u w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        u uVar = new u();
        uVar.action = jSONObject.optString("action");
        uVar.id = jSONObject.optString("id");
        uVar.userId = jSONObject.optString("user_id");
        uVar.aIv = jSONObject.optString("toast_text");
        uVar.aIw = jSONObject.optString("chosen_color_start", "#7C11FF");
        uVar.aIx = jSONObject.optString("chosen_color_end", "#FF3656");
        uVar.aIu = jSONObject.optString("theme");
        JSONArray optJSONArray = jSONObject.optJSONArray("session_conf");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            uVar.aIy = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                ae aeVar = new ae();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                aeVar.imageUrl = optJSONObject.optString("img");
                aeVar.aJp = optJSONObject.optString("btn_text");
                aeVar.url = optJSONObject.optString("session_info");
                aeVar.startColor = uVar.aIw;
                aeVar.endColor = uVar.aIx;
                uVar.aIy.add(aeVar);
            }
            return uVar;
        }
        return uVar;
    }

    public boolean DR() {
        return (this.aIy == null || this.aIy.isEmpty()) ? false : true;
    }

    public List<ae> DS() {
        return this.aIy;
    }

    public String getAction() {
        return this.action;
    }

    public String DT() {
        return this.aIx;
    }

    public String DU() {
        return this.aIw;
    }

    public String DV() {
        return this.aIv;
    }

    public boolean gj(String str) {
        return !TextUtils.isEmpty(this.action) && this.action.equals(str);
    }

    public boolean gk(String str) {
        return !TextUtils.isEmpty(this.id) && this.id.equals(str);
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "AlaLiveMultiSession{id='" + this.id + "', userId='" + this.userId + "', theme='" + this.aIu + "', action='" + this.action + "', toastText='" + this.aIv + "', choseColorStart='" + this.aIw + "', choseColorEnd='" + this.aIx + "', sessionList=" + this.aIy + '}';
    }
}
