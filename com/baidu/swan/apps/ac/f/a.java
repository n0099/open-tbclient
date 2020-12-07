package com.baidu.swan.apps.ac.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a implements Cloneable {
    public String TX;
    public String dqr;
    public String dqs;
    public int dqt;
    public String dqu;
    public String dqv;

    public a(JSONObject jSONObject, int i) {
        this.dqt = 4;
        if (jSONObject != null) {
            this.dqs = jSONObject.optString("version");
            this.TX = jSONObject.optString("provider");
            this.dqu = jSONObject.optString("path");
            this.dqv = jSONObject.optString("config");
            this.dqt = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.TX) || TextUtils.isEmpty(this.dqs)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.dqr + "', pluginVersion='" + this.dqs + "', pluginName='" + this.TX + "', pluginCategory=" + this.dqt + ", pluginPath='" + this.dqu + "', pluginPagesConfigFileName='" + this.dqv + "'}";
    }
}
