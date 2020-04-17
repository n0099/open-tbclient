package com.baidu.swan.apps.ag.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    public String QY;
    public String chF;
    public String chG;
    public int chH;
    public String chI;

    public a(JSONObject jSONObject, int i) {
        this.chH = 4;
        if (jSONObject != null) {
            this.chG = jSONObject.optString("version");
            this.QY = jSONObject.optString("provider");
            this.chI = jSONObject.optString("path");
            this.chH = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.QY) || TextUtils.isEmpty(this.chG)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.chF + "', pluginVersion='" + this.chG + "', pluginName='" + this.QY + "', pluginCategory=" + this.chH + ", pluginPath='" + this.chI + "'}";
    }
}
