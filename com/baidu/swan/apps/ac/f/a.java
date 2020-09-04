package com.baidu.swan.apps.ac.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements Cloneable {
    public String Sq;
    public String cIA;
    public String cIB;
    public int cIC;
    public String cID;
    public String cIE;

    public a(JSONObject jSONObject, int i) {
        this.cIC = 4;
        if (jSONObject != null) {
            this.cIB = jSONObject.optString("version");
            this.Sq = jSONObject.optString("provider");
            this.cID = jSONObject.optString("path");
            this.cIE = jSONObject.optString("config");
            this.cIC = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.Sq) || TextUtils.isEmpty(this.cIB)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.cIA + "', pluginVersion='" + this.cIB + "', pluginName='" + this.Sq + "', pluginCategory=" + this.cIC + ", pluginPath='" + this.cID + "', pluginPagesConfigFileName='" + this.cIE + "'}";
    }
}
