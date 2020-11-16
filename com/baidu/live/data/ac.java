package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ac {
    private String aIA;
    private boolean aIy;
    private String aIz;
    private int height;
    private int position;
    private int width;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.position = jSONObject.optInt("position");
            this.height = jSONObject.optInt("high");
            this.width = jSONObject.optInt("wide");
            this.aIy = jSONObject.optInt("is_show") == 1;
            this.aIz = jSONObject.optString("pk_url");
            this.aIA = jSONObject.optString("pk_data");
        }
    }

    public int getHeight() {
        return this.height;
    }

    public String DG() {
        return this.aIz;
    }

    public String DH() {
        return this.aIA;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean DI() {
        return this.aIy;
    }

    public String toString() {
        return "AlaPkPanelInfo{position=" + this.position + ", height=" + this.height + ", width=" + this.width + ", isOpenAction=" + this.aIy + ", pkUrl='" + this.aIz + "', urlDataParams='" + this.aIA + "'}";
    }
}
