package com.baidu.live.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class u {
    private String aKl;
    private String aKm;
    private String aKn;
    private String aKo;
    private List<ah> aKp;
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
        uVar.aKm = jSONObject.optString("toast_text");
        uVar.aKn = jSONObject.optString("chosen_color_start", "#7C11FF");
        uVar.aKo = jSONObject.optString("chosen_color_end", "#FF3656");
        uVar.aKl = jSONObject.optString("theme");
        JSONArray optJSONArray = jSONObject.optJSONArray("session_conf");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            uVar.aKp = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                ah ahVar = new ah();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                ahVar.imageUrl = optJSONObject.optString("img");
                ahVar.aLy = optJSONObject.optString("btn_text");
                ahVar.url = optJSONObject.optString("session_info");
                ahVar.startColor = uVar.aKn;
                ahVar.endColor = uVar.aKo;
                uVar.aKp.add(ahVar);
            }
            return uVar;
        }
        return uVar;
    }

    public boolean Fm() {
        return (this.aKp == null || this.aKp.isEmpty()) ? false : true;
    }

    public List<ah> Fn() {
        return this.aKp;
    }

    public String getAction() {
        return this.action;
    }

    public String Fo() {
        return this.aKo;
    }

    public String Fp() {
        return this.aKn;
    }

    public String Fq() {
        return this.aKm;
    }

    public boolean gD(String str) {
        return !TextUtils.isEmpty(this.action) && this.action.equals(str);
    }

    public boolean gE(String str) {
        return !TextUtils.isEmpty(this.id) && this.id.equals(str);
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "AlaLiveMultiSession{id='" + this.id + "', userId='" + this.userId + "', theme='" + this.aKl + "', action='" + this.action + "', toastText='" + this.aKm + "', choseColorStart='" + this.aKn + "', choseColorEnd='" + this.aKo + "', sessionList=" + this.aKp + '}';
    }
}
