package com.baidu.swan.apps.ag.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    public String bIK;
    public String bIL;
    public int bIM;
    public String bIN;
    public String xU;

    public a(JSONObject jSONObject, int i) {
        this.bIM = 4;
        if (jSONObject != null) {
            this.bIL = jSONObject.optString("version");
            this.xU = jSONObject.optString("provider");
            this.bIN = jSONObject.optString("path");
            this.bIM = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.xU) || TextUtils.isEmpty(this.bIL)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.bIK + "', pluginVersion='" + this.bIL + "', pluginName='" + this.xU + "', pluginCategory=" + this.bIM + ", pluginPath='" + this.bIN + "'}";
    }
}
