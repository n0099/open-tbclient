package com.baidu.swan.apps.ac.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements Cloneable {
    public String TV;
    public String dsN;
    public String dsO;
    public int dsP;
    public String dsQ;
    public String dsR;

    public a(JSONObject jSONObject, int i) {
        this.dsP = 4;
        if (jSONObject != null) {
            this.dsO = jSONObject.optString("version");
            this.TV = jSONObject.optString("provider");
            this.dsQ = jSONObject.optString("path");
            this.dsR = jSONObject.optString("config");
            this.dsP = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.TV) || TextUtils.isEmpty(this.dsO)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.dsN + "', pluginVersion='" + this.dsO + "', pluginName='" + this.TV + "', pluginCategory=" + this.dsP + ", pluginPath='" + this.dsQ + "', pluginPagesConfigFileName='" + this.dsR + "'}";
    }
}
