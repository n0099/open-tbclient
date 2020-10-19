package com.baidu.live.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {
    private String aHT;
    private String aHU;
    private String aHV;
    private String aHW;
    private List<ac> aHX;
    private String action;
    private String id;
    private String userId;

    public static r w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        r rVar = new r();
        rVar.action = jSONObject.optString("action");
        rVar.id = jSONObject.optString("id");
        rVar.userId = jSONObject.optString("user_id");
        rVar.aHU = jSONObject.optString("toast_text");
        rVar.aHV = jSONObject.optString("chosen_color_start", "#7C11FF");
        rVar.aHW = jSONObject.optString("chosen_color_end", "#FF3656");
        rVar.aHT = jSONObject.optString("theme");
        JSONArray optJSONArray = jSONObject.optJSONArray("session_conf");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            rVar.aHX = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                ac acVar = new ac();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                acVar.imageUrl = optJSONObject.optString("img");
                acVar.aIO = optJSONObject.optString("btn_text");
                acVar.url = optJSONObject.optString("session_info");
                acVar.startColor = rVar.aHV;
                acVar.endColor = rVar.aHW;
                rVar.aHX.add(acVar);
            }
            return rVar;
        }
        return rVar;
    }

    public boolean DI() {
        return (this.aHX == null || this.aHX.isEmpty()) ? false : true;
    }

    public List<ac> DJ() {
        return this.aHX;
    }

    public String getAction() {
        return this.action;
    }

    public String DK() {
        return this.aHW;
    }

    public String DL() {
        return this.aHV;
    }

    public String DM() {
        return this.aHU;
    }

    public boolean gi(String str) {
        return !TextUtils.isEmpty(this.action) && this.action.equals(str);
    }

    public boolean gj(String str) {
        return !TextUtils.isEmpty(this.id) && this.id.equals(str);
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "AlaLiveMultiSession{id='" + this.id + "', userId='" + this.userId + "', theme='" + this.aHT + "', action='" + this.action + "', toastText='" + this.aHU + "', choseColorStart='" + this.aHV + "', choseColorEnd='" + this.aHW + "', sessionList=" + this.aHX + '}';
    }
}
