package com.baidu.live.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o {
    private String aDT;
    private String aDU;
    private String aDV;
    private String aDW;
    private List<x> aDX;
    private String action;
    private String id;
    private String userId;

    public static o w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        o oVar = new o();
        oVar.action = jSONObject.optString("action");
        oVar.id = jSONObject.optString("id");
        oVar.userId = jSONObject.optString("user_id");
        oVar.aDU = jSONObject.optString("toast_text");
        oVar.aDV = jSONObject.optString("chosen_color_start", "#7C11FF");
        oVar.aDW = jSONObject.optString("chosen_color_end", "#FF3656");
        oVar.aDT = jSONObject.optString("theme");
        JSONArray optJSONArray = jSONObject.optJSONArray("session_conf");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            oVar.aDX = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                x xVar = new x();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                xVar.imageUrl = optJSONObject.optString("img");
                xVar.aEz = optJSONObject.optString("btn_text");
                xVar.url = optJSONObject.optString("session_info");
                xVar.startColor = oVar.aDV;
                xVar.endColor = oVar.aDW;
                oVar.aDX.add(xVar);
            }
            return oVar;
        }
        return oVar;
    }

    public boolean Cw() {
        return (this.aDX == null || this.aDX.isEmpty()) ? false : true;
    }

    public List<x> Cx() {
        return this.aDX;
    }

    public String getAction() {
        return this.action;
    }

    public String Cy() {
        return this.aDW;
    }

    public String Cz() {
        return this.aDV;
    }

    public String CA() {
        return this.aDU;
    }

    public boolean fP(String str) {
        return !TextUtils.isEmpty(this.action) && this.action.equals(str);
    }

    public boolean fQ(String str) {
        return !TextUtils.isEmpty(this.id) && this.id.equals(str);
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "AlaLiveMultiSession{id='" + this.id + "', userId='" + this.userId + "', theme='" + this.aDT + "', action='" + this.action + "', toastText='" + this.aDU + "', choseColorStart='" + this.aDV + "', choseColorEnd='" + this.aDW + "', sessionList=" + this.aDX + '}';
    }
}
