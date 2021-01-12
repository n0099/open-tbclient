package com.baidu.live.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLiveMarkInfoData implements Serializable {
    public static final int BADGE_LEVEL_TYPE = 105;
    public static final int ROYAL_LEVEL_TYPE = 1;
    public int height;
    public String mark_pic;
    public String royal_level;
    public int type;
    public int weight;

    public void parseJson(JSONObject jSONObject) {
        this.type = jSONObject.optInt("type", 0);
        this.mark_pic = jSONObject.optString("mark_pic", "");
        this.height = jSONObject.optInt("height", 0);
        this.weight = jSONObject.optInt("weight", 0);
        this.royal_level = jSONObject.optString("royal_level", "");
    }
}
