package com.baidu.live.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class v {
    private String aKK;
    private String aKL;
    private String aKM;
    private String aKN;
    private List<aj> aKO;
    private String action;
    private String id;
    private String userId;

    public static v z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        v vVar = new v();
        vVar.action = jSONObject.optString("action");
        vVar.id = jSONObject.optString("id");
        vVar.userId = jSONObject.optString("user_id");
        vVar.aKL = jSONObject.optString("toast_text");
        vVar.aKM = jSONObject.optString("chosen_color_start", "#7C11FF");
        vVar.aKN = jSONObject.optString("chosen_color_end", "#FF3656");
        vVar.aKK = jSONObject.optString("theme");
        JSONArray optJSONArray = jSONObject.optJSONArray("session_conf");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            vVar.aKO = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                aj ajVar = new aj();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                ajVar.imageUrl = optJSONObject.optString("img");
                ajVar.aMc = optJSONObject.optString("btn_text");
                ajVar.url = optJSONObject.optString("session_info");
                ajVar.startColor = vVar.aKM;
                ajVar.endColor = vVar.aKN;
                vVar.aKO.add(ajVar);
            }
            return vVar;
        }
        return vVar;
    }

    public boolean EC() {
        return (this.aKO == null || this.aKO.isEmpty()) ? false : true;
    }

    public List<aj> ED() {
        return this.aKO;
    }

    public String getAction() {
        return this.action;
    }

    public String EE() {
        return this.aKN;
    }

    public String EF() {
        return this.aKM;
    }

    public String EG() {
        return this.aKL;
    }

    public boolean gm(String str) {
        return !TextUtils.isEmpty(this.action) && this.action.equals(str);
    }

    public boolean gn(String str) {
        return !TextUtils.isEmpty(this.id) && this.id.equals(str);
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "AlaLiveMultiSession{id='" + this.id + "', userId='" + this.userId + "', theme='" + this.aKK + "', action='" + this.action + "', toastText='" + this.aKL + "', choseColorStart='" + this.aKM + "', choseColorEnd='" + this.aKN + "', sessionList=" + this.aKO + '}';
    }
}
