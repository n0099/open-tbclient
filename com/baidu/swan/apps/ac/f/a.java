package com.baidu.swan.apps.ac.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements Cloneable {
    public String Sq;
    public String cIA;
    public String cIw;
    public String cIx;
    public int cIy;
    public String cIz;

    public a(JSONObject jSONObject, int i) {
        this.cIy = 4;
        if (jSONObject != null) {
            this.cIx = jSONObject.optString("version");
            this.Sq = jSONObject.optString("provider");
            this.cIz = jSONObject.optString("path");
            this.cIA = jSONObject.optString("config");
            this.cIy = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.Sq) || TextUtils.isEmpty(this.cIx)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.cIw + "', pluginVersion='" + this.cIx + "', pluginName='" + this.Sq + "', pluginCategory=" + this.cIy + ", pluginPath='" + this.cIz + "', pluginPagesConfigFileName='" + this.cIA + "'}";
    }
}
