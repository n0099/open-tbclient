package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ae {
    private boolean aHc;
    private String aHd;
    private String aHe;
    private int height;
    private int position;
    private int width;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.position = jSONObject.optInt("position");
            this.height = jSONObject.optInt("high");
            this.width = jSONObject.optInt("wide");
            this.aHc = jSONObject.optInt("is_show") == 1;
            this.aHd = jSONObject.optString("pk_url");
            this.aHe = jSONObject.optString("pk_data");
        }
    }

    public int getHeight() {
        return this.height;
    }

    public String AM() {
        return this.aHd;
    }

    public String AN() {
        return this.aHe;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean AO() {
        return this.aHc;
    }

    public String toString() {
        return "AlaPkPanelInfo{position=" + this.position + ", height=" + this.height + ", width=" + this.width + ", isOpenAction=" + this.aHc + ", pkUrl='" + this.aHd + "', urlDataParams='" + this.aHe + "'}";
    }
}
