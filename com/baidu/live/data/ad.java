package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ad {
    private boolean aLn;
    private String aLo;
    private String aLp;
    private int height;
    private int position;
    private int width;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.position = jSONObject.optInt("position");
            this.height = jSONObject.optInt("high");
            this.width = jSONObject.optInt("wide");
            this.aLn = jSONObject.optInt("is_show") == 1;
            this.aLo = jSONObject.optString("pk_url");
            this.aLp = jSONObject.optString("pk_data");
        }
    }

    public int getHeight() {
        return this.height;
    }

    public String Fr() {
        return this.aLo;
    }

    public String Fs() {
        return this.aLp;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean Ft() {
        return this.aLn;
    }

    public String toString() {
        return "AlaPkPanelInfo{position=" + this.position + ", height=" + this.height + ", width=" + this.width + ", isOpenAction=" + this.aLn + ", pkUrl='" + this.aLo + "', urlDataParams='" + this.aLp + "'}";
    }
}
