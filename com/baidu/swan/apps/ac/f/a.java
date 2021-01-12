package com.baidu.swan.apps.ac.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements Cloneable {
    public String TX;
    public String dqB;
    public String dqC;
    public int dqD;
    public String dqE;
    public String dqF;

    public a(JSONObject jSONObject, int i) {
        this.dqD = 4;
        if (jSONObject != null) {
            this.dqC = jSONObject.optString("version");
            this.TX = jSONObject.optString("provider");
            this.dqE = jSONObject.optString("path");
            this.dqF = jSONObject.optString("config");
            this.dqD = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.TX) || TextUtils.isEmpty(this.dqC)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.dqB + "', pluginVersion='" + this.dqC + "', pluginName='" + this.TX + "', pluginCategory=" + this.dqD + ", pluginPath='" + this.dqE + "', pluginPagesConfigFileName='" + this.dqF + "'}";
    }
}
