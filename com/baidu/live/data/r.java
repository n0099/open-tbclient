package com.baidu.live.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {
    private String aEP;
    private String aEQ;
    private String aER;
    private String aES;
    private List<ac> aET;
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
        rVar.aEQ = jSONObject.optString("toast_text");
        rVar.aER = jSONObject.optString("chosen_color_start", "#7C11FF");
        rVar.aES = jSONObject.optString("chosen_color_end", "#FF3656");
        rVar.aEP = jSONObject.optString("theme");
        JSONArray optJSONArray = jSONObject.optJSONArray("session_conf");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            rVar.aET = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                ac acVar = new ac();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                acVar.imageUrl = optJSONObject.optString("img");
                acVar.aFK = optJSONObject.optString("btn_text");
                acVar.url = optJSONObject.optString("session_info");
                acVar.startColor = rVar.aER;
                acVar.endColor = rVar.aES;
                rVar.aET.add(acVar);
            }
            return rVar;
        }
        return rVar;
    }

    public boolean CL() {
        return (this.aET == null || this.aET.isEmpty()) ? false : true;
    }

    public List<ac> CM() {
        return this.aET;
    }

    public String getAction() {
        return this.action;
    }

    public String CN() {
        return this.aES;
    }

    public String CO() {
        return this.aER;
    }

    public String CP() {
        return this.aEQ;
    }

    public boolean fU(String str) {
        return !TextUtils.isEmpty(this.action) && this.action.equals(str);
    }

    public boolean fV(String str) {
        return !TextUtils.isEmpty(this.id) && this.id.equals(str);
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "AlaLiveMultiSession{id='" + this.id + "', userId='" + this.userId + "', theme='" + this.aEP + "', action='" + this.action + "', toastText='" + this.aEQ + "', choseColorStart='" + this.aER + "', choseColorEnd='" + this.aES + "', sessionList=" + this.aET + '}';
    }
}
