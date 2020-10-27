package com.baidu.swan.apps.ac.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements Cloneable {
    public String Td;
    public String dfe;
    public String dff;
    public int dfg;
    public String dfh;
    public String dfi;

    public a(JSONObject jSONObject, int i) {
        this.dfg = 4;
        if (jSONObject != null) {
            this.dff = jSONObject.optString("version");
            this.Td = jSONObject.optString("provider");
            this.dfh = jSONObject.optString("path");
            this.dfi = jSONObject.optString("config");
            this.dfg = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.Td) || TextUtils.isEmpty(this.dff)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.dfe + "', pluginVersion='" + this.dff + "', pluginName='" + this.Td + "', pluginCategory=" + this.dfg + ", pluginPath='" + this.dfh + "', pluginPagesConfigFileName='" + this.dfi + "'}";
    }
}
