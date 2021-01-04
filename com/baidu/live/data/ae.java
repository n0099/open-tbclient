package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ae {
    private boolean aLP;
    private String aLQ;
    private String aLR;
    private int height;
    private int position;
    private int width;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.position = jSONObject.optInt("position");
            this.height = jSONObject.optInt("high");
            this.width = jSONObject.optInt("wide");
            this.aLP = jSONObject.optInt("is_show") == 1;
            this.aLQ = jSONObject.optString("pk_url");
            this.aLR = jSONObject.optString("pk_data");
        }
    }

    public int getHeight() {
        return this.height;
    }

    public String EH() {
        return this.aLQ;
    }

    public String EI() {
        return this.aLR;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean EJ() {
        return this.aLP;
    }

    public String toString() {
        return "AlaPkPanelInfo{position=" + this.position + ", height=" + this.height + ", width=" + this.width + ", isOpenAction=" + this.aLP + ", pkUrl='" + this.aLQ + "', urlDataParams='" + this.aLR + "'}";
    }
}
