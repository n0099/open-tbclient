package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ac {
    private boolean aKj;
    private String aKk;
    private String aKl;
    private int height;
    private int position;
    private int width;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.position = jSONObject.optInt("position");
            this.height = jSONObject.optInt("high");
            this.width = jSONObject.optInt("wide");
            this.aKj = jSONObject.optInt("is_show") == 1;
            this.aKk = jSONObject.optString("pk_url");
            this.aKl = jSONObject.optString("pk_data");
        }
    }

    public int getHeight() {
        return this.height;
    }

    public String Ep() {
        return this.aKk;
    }

    public String Eq() {
        return this.aKl;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean Er() {
        return this.aKj;
    }

    public String toString() {
        return "AlaPkPanelInfo{position=" + this.position + ", height=" + this.height + ", width=" + this.width + ", isOpenAction=" + this.aKj + ", pkUrl='" + this.aKk + "', urlDataParams='" + this.aKl + "'}";
    }
}
