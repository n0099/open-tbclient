package com.baidu.live.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class u {
    private String aJl;
    private String aJm;
    private String aJn;
    private String aJo;
    private List<af> aJp;
    private String action;
    private String id;
    private String userId;

    public static u z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        u uVar = new u();
        uVar.action = jSONObject.optString("action");
        uVar.id = jSONObject.optString("id");
        uVar.userId = jSONObject.optString("user_id");
        uVar.aJm = jSONObject.optString("toast_text");
        uVar.aJn = jSONObject.optString("chosen_color_start", "#7C11FF");
        uVar.aJo = jSONObject.optString("chosen_color_end", "#FF3656");
        uVar.aJl = jSONObject.optString("theme");
        JSONArray optJSONArray = jSONObject.optJSONArray("session_conf");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            uVar.aJp = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                af afVar = new af();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                afVar.imageUrl = optJSONObject.optString("img");
                afVar.aKp = optJSONObject.optString("btn_text");
                afVar.url = optJSONObject.optString("session_info");
                afVar.startColor = uVar.aJn;
                afVar.endColor = uVar.aJo;
                uVar.aJp.add(afVar);
            }
            return uVar;
        }
        return uVar;
    }

    public boolean Ek() {
        return (this.aJp == null || this.aJp.isEmpty()) ? false : true;
    }

    public List<af> El() {
        return this.aJp;
    }

    public String getAction() {
        return this.action;
    }

    public String Em() {
        return this.aJo;
    }

    public String En() {
        return this.aJn;
    }

    public String Eo() {
        return this.aJm;
    }

    public boolean gn(String str) {
        return !TextUtils.isEmpty(this.action) && this.action.equals(str);
    }

    public boolean go(String str) {
        return !TextUtils.isEmpty(this.id) && this.id.equals(str);
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "AlaLiveMultiSession{id='" + this.id + "', userId='" + this.userId + "', theme='" + this.aJl + "', action='" + this.action + "', toastText='" + this.aJm + "', choseColorStart='" + this.aJn + "', choseColorEnd='" + this.aJo + "', sessionList=" + this.aJp + '}';
    }
}
