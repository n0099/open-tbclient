package com.baidu.live.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o {
    private String aDR;
    private String aDS;
    private String aDT;
    private String aDU;
    private List<x> aDV;
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
        oVar.aDS = jSONObject.optString("toast_text");
        oVar.aDT = jSONObject.optString("chosen_color_start", "#7C11FF");
        oVar.aDU = jSONObject.optString("chosen_color_end", "#FF3656");
        oVar.aDR = jSONObject.optString("theme");
        JSONArray optJSONArray = jSONObject.optJSONArray("session_conf");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            oVar.aDV = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                x xVar = new x();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                xVar.imageUrl = optJSONObject.optString("img");
                xVar.aEx = optJSONObject.optString("btn_text");
                xVar.url = optJSONObject.optString("session_info");
                xVar.startColor = oVar.aDT;
                xVar.endColor = oVar.aDU;
                oVar.aDV.add(xVar);
            }
            return oVar;
        }
        return oVar;
    }

    public boolean Cw() {
        return (this.aDV == null || this.aDV.isEmpty()) ? false : true;
    }

    public List<x> Cx() {
        return this.aDV;
    }

    public String getAction() {
        return this.action;
    }

    public String Cy() {
        return this.aDU;
    }

    public String Cz() {
        return this.aDT;
    }

    public String CA() {
        return this.aDS;
    }

    public boolean fO(String str) {
        return !TextUtils.isEmpty(this.action) && this.action.equals(str);
    }

    public boolean fP(String str) {
        return !TextUtils.isEmpty(this.id) && this.id.equals(str);
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "AlaLiveMultiSession{id='" + this.id + "', userId='" + this.userId + "', theme='" + this.aDR + "', action='" + this.action + "', toastText='" + this.aDS + "', choseColorStart='" + this.aDT + "', choseColorEnd='" + this.aDU + "', sessionList=" + this.aDV + '}';
    }
}
