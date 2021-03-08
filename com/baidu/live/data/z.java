package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.mobads.AppActivityImp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class z {
    private String aJT;
    private String aJU;
    private String aJV;
    private String aJW;
    private List<an> aJX;
    private String action;
    private String id;
    private String userId;

    public static z B(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        z zVar = new z();
        zVar.action = jSONObject.optString("action");
        zVar.id = jSONObject.optString("id");
        zVar.userId = jSONObject.optString("user_id");
        zVar.aJU = jSONObject.optString("toast_text");
        zVar.aJV = jSONObject.optString("chosen_color_start", "#7C11FF");
        zVar.aJW = jSONObject.optString("chosen_color_end", "#FF3656");
        zVar.aJT = jSONObject.optString(AppActivityImp.EXTRA_LP_THEME);
        JSONArray optJSONArray = jSONObject.optJSONArray("session_conf");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            zVar.aJX = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                an anVar = new an();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                anVar.imageUrl = optJSONObject.optString("img");
                anVar.aLu = optJSONObject.optString("btn_text");
                anVar.url = optJSONObject.optString("session_info");
                anVar.startColor = zVar.aJV;
                anVar.endColor = zVar.aJW;
                zVar.aJX.add(anVar);
            }
            return zVar;
        }
        return zVar;
    }

    public boolean BX() {
        return (this.aJX == null || this.aJX.isEmpty()) ? false : true;
    }

    public List<an> BY() {
        return this.aJX;
    }

    public String getAction() {
        return this.action;
    }

    public String BZ() {
        return this.aJW;
    }

    public String Ca() {
        return this.aJV;
    }

    public String Cb() {
        return this.aJU;
    }

    public boolean fC(String str) {
        return !TextUtils.isEmpty(this.action) && this.action.equals(str);
    }

    public boolean fD(String str) {
        return !TextUtils.isEmpty(this.id) && this.id.equals(str);
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "AlaLiveMultiSession{id='" + this.id + "', userId='" + this.userId + "', theme='" + this.aJT + "', action='" + this.action + "', toastText='" + this.aJU + "', choseColorStart='" + this.aJV + "', choseColorEnd='" + this.aJW + "', sessionList=" + this.aJX + '}';
    }
}
