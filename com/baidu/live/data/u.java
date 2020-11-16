package com.baidu.live.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class u {
    private String aHA;
    private String aHB;
    private String aHC;
    private String aHD;
    private List<af> aHE;
    private String action;
    private String id;
    private String userId;

    public static u t(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        u uVar = new u();
        uVar.action = jSONObject.optString("action");
        uVar.id = jSONObject.optString("id");
        uVar.userId = jSONObject.optString("user_id");
        uVar.aHB = jSONObject.optString("toast_text");
        uVar.aHC = jSONObject.optString("chosen_color_start", "#7C11FF");
        uVar.aHD = jSONObject.optString("chosen_color_end", "#FF3656");
        uVar.aHA = jSONObject.optString("theme");
        JSONArray optJSONArray = jSONObject.optJSONArray("session_conf");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            uVar.aHE = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                af afVar = new af();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                afVar.imageUrl = optJSONObject.optString("img");
                afVar.aIE = optJSONObject.optString("btn_text");
                afVar.url = optJSONObject.optString("session_info");
                afVar.startColor = uVar.aHC;
                afVar.endColor = uVar.aHD;
                uVar.aHE.add(afVar);
            }
            return uVar;
        }
        return uVar;
    }

    public boolean DB() {
        return (this.aHE == null || this.aHE.isEmpty()) ? false : true;
    }

    public List<af> DC() {
        return this.aHE;
    }

    public String getAction() {
        return this.action;
    }

    public String DD() {
        return this.aHD;
    }

    public String DE() {
        return this.aHC;
    }

    public String DF() {
        return this.aHB;
    }

    public boolean gh(String str) {
        return !TextUtils.isEmpty(this.action) && this.action.equals(str);
    }

    public boolean gi(String str) {
        return !TextUtils.isEmpty(this.id) && this.id.equals(str);
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "AlaLiveMultiSession{id='" + this.id + "', userId='" + this.userId + "', theme='" + this.aHA + "', action='" + this.action + "', toastText='" + this.aHB + "', choseColorStart='" + this.aHC + "', choseColorEnd='" + this.aHD + "', sessionList=" + this.aHE + '}';
    }
}
