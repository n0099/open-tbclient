package com.baidu.swan.apps.ac.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements Cloneable {
    public String TZ;
    public String dvq;
    public String dvr;
    public int dvs;
    public String dvt;
    public String dvu;

    public a(JSONObject jSONObject, int i) {
        this.dvs = 4;
        if (jSONObject != null) {
            this.dvr = jSONObject.optString("version");
            this.TZ = jSONObject.optString("provider");
            this.dvt = jSONObject.optString("path");
            this.dvu = jSONObject.optString("config");
            this.dvs = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.TZ) || TextUtils.isEmpty(this.dvr)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.dvq + "', pluginVersion='" + this.dvr + "', pluginName='" + this.TZ + "', pluginCategory=" + this.dvs + ", pluginPath='" + this.dvt + "', pluginPagesConfigFileName='" + this.dvu + "'}";
    }
}
