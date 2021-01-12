package com.baidu.live.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class v {
    private String aFX;
    private String aFY;
    private String aFZ;
    private String aGa;
    private List<aj> aGb;
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
        vVar.aFY = jSONObject.optString("toast_text");
        vVar.aFZ = jSONObject.optString("chosen_color_start", "#7C11FF");
        vVar.aGa = jSONObject.optString("chosen_color_end", "#FF3656");
        vVar.aFX = jSONObject.optString("theme");
        JSONArray optJSONArray = jSONObject.optJSONArray("session_conf");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            vVar.aGb = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                aj ajVar = new aj();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                ajVar.imageUrl = optJSONObject.optString("img");
                ajVar.aHp = optJSONObject.optString("btn_text");
                ajVar.url = optJSONObject.optString("session_info");
                ajVar.startColor = vVar.aFZ;
                ajVar.endColor = vVar.aGa;
                vVar.aGb.add(ajVar);
            }
            return vVar;
        }
        return vVar;
    }

    public boolean AH() {
        return (this.aGb == null || this.aGb.isEmpty()) ? false : true;
    }

    public List<aj> AI() {
        return this.aGb;
    }

    public String getAction() {
        return this.action;
    }

    public String AJ() {
        return this.aGa;
    }

    public String AK() {
        return this.aFZ;
    }

    public String AL() {
        return this.aFY;
    }

    public boolean fb(String str) {
        return !TextUtils.isEmpty(this.action) && this.action.equals(str);
    }

    public boolean fc(String str) {
        return !TextUtils.isEmpty(this.id) && this.id.equals(str);
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "AlaLiveMultiSession{id='" + this.id + "', userId='" + this.userId + "', theme='" + this.aFX + "', action='" + this.action + "', toastText='" + this.aFY + "', choseColorStart='" + this.aFZ + "', choseColorEnd='" + this.aGa + "', sessionList=" + this.aGb + '}';
    }
}
