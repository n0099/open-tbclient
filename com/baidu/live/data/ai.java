package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ai {
    private boolean aLg;
    private String aLh;
    private String aLi;
    private int height;
    private int position;
    private int width;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.position = jSONObject.optInt("position");
            this.height = jSONObject.optInt("high");
            this.width = jSONObject.optInt("wide");
            this.aLg = jSONObject.optInt("is_show") == 1;
            this.aLh = jSONObject.optString("pk_url");
            this.aLi = jSONObject.optString("pk_data");
        }
    }

    public int getHeight() {
        return this.height;
    }

    public String Cc() {
        return this.aLh;
    }

    public String Cd() {
        return this.aLi;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean Ce() {
        return this.aLg;
    }

    public String toString() {
        return "AlaPkPanelInfo{position=" + this.position + ", height=" + this.height + ", width=" + this.width + ", isOpenAction=" + this.aLg + ", pkUrl='" + this.aLh + "', urlDataParams='" + this.aLi + "'}";
    }
}
