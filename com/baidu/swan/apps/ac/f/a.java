package com.baidu.swan.apps.ac.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements Cloneable {
    public String Td;
    public String dkZ;
    public String dla;
    public int dlb;
    public String dlc;
    public String dld;

    public a(JSONObject jSONObject, int i) {
        this.dlb = 4;
        if (jSONObject != null) {
            this.dla = jSONObject.optString("version");
            this.Td = jSONObject.optString("provider");
            this.dlc = jSONObject.optString("path");
            this.dld = jSONObject.optString("config");
            this.dlb = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.Td) || TextUtils.isEmpty(this.dla)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.dkZ + "', pluginVersion='" + this.dla + "', pluginName='" + this.Td + "', pluginCategory=" + this.dlb + ", pluginPath='" + this.dlc + "', pluginPagesConfigFileName='" + this.dld + "'}";
    }
}
