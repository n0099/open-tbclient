package com.baidu.swan.apps.ac.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements Cloneable {
    public String Tc;
    public String cWD;
    public String cWE;
    public int cWF;
    public String cWG;
    public String cWH;

    public a(JSONObject jSONObject, int i) {
        this.cWF = 4;
        if (jSONObject != null) {
            this.cWE = jSONObject.optString("version");
            this.Tc = jSONObject.optString("provider");
            this.cWG = jSONObject.optString("path");
            this.cWH = jSONObject.optString("config");
            this.cWF = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.Tc) || TextUtils.isEmpty(this.cWE)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.cWD + "', pluginVersion='" + this.cWE + "', pluginName='" + this.Tc + "', pluginCategory=" + this.cWF + ", pluginPath='" + this.cWG + "', pluginPagesConfigFileName='" + this.cWH + "'}";
    }
}
