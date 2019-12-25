package com.baidu.swan.apps.ag.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements Cloneable {
    public String bDT;
    public String bDU;
    public int bDV;
    public String bDW;
    public String xy;

    public a(JSONObject jSONObject, int i) {
        this.bDV = 4;
        if (jSONObject != null) {
            this.bDU = jSONObject.optString("version");
            this.xy = jSONObject.optString("provider");
            this.bDW = jSONObject.optString("path");
            this.bDV = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.xy) || TextUtils.isEmpty(this.bDU)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.bDT + "', pluginVersion='" + this.bDU + "', pluginName='" + this.xy + "', pluginCategory=" + this.bDV + ", pluginPath='" + this.bDW + "'}";
    }
}
