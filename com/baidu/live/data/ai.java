package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ai {
    private boolean aJG;
    private String aJH;
    private String aJI;
    private int height;
    private int position;
    private int width;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.position = jSONObject.optInt("position");
            this.height = jSONObject.optInt("high");
            this.width = jSONObject.optInt("wide");
            this.aJG = jSONObject.optInt("is_show") == 1;
            this.aJH = jSONObject.optString("pk_url");
            this.aJI = jSONObject.optString("pk_data");
        }
    }

    public int getHeight() {
        return this.height;
    }

    public String BZ() {
        return this.aJH;
    }

    public String Ca() {
        return this.aJI;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean Cb() {
        return this.aJG;
    }

    public String toString() {
        return "AlaPkPanelInfo{position=" + this.position + ", height=" + this.height + ", width=" + this.width + ", isOpenAction=" + this.aJG + ", pkUrl='" + this.aJH + "', urlDataParams='" + this.aJI + "'}";
    }
}
