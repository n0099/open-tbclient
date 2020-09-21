package com.baidu.swan.apps.ac.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements Cloneable {
    public String SK;
    public String cKA;
    public String cKB;
    public int cKC;
    public String cKD;
    public String cKE;

    public a(JSONObject jSONObject, int i) {
        this.cKC = 4;
        if (jSONObject != null) {
            this.cKB = jSONObject.optString("version");
            this.SK = jSONObject.optString("provider");
            this.cKD = jSONObject.optString("path");
            this.cKE = jSONObject.optString("config");
            this.cKC = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.SK) || TextUtils.isEmpty(this.cKB)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.cKA + "', pluginVersion='" + this.cKB + "', pluginName='" + this.SK + "', pluginCategory=" + this.cKC + ", pluginPath='" + this.cKD + "', pluginPagesConfigFileName='" + this.cKE + "'}";
    }
}
