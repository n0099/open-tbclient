package com.baidu.swan.apps.ag.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements Cloneable {
    public String bEE;
    public String bEF;
    public int bEG;
    public String bEH;
    public String xC;

    public a(JSONObject jSONObject, int i) {
        this.bEG = 4;
        if (jSONObject != null) {
            this.bEF = jSONObject.optString("version");
            this.xC = jSONObject.optString("provider");
            this.bEH = jSONObject.optString("path");
            this.bEG = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.xC) || TextUtils.isEmpty(this.bEF)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.bEE + "', pluginVersion='" + this.bEF + "', pluginName='" + this.xC + "', pluginCategory=" + this.bEG + ", pluginPath='" + this.bEH + "'}";
    }
}
