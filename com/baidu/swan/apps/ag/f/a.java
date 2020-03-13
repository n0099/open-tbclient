package com.baidu.swan.apps.ag.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    public String bIL;
    public String bIM;
    public int bIN;
    public String bIO;
    public String xU;

    public a(JSONObject jSONObject, int i) {
        this.bIN = 4;
        if (jSONObject != null) {
            this.bIM = jSONObject.optString("version");
            this.xU = jSONObject.optString("provider");
            this.bIO = jSONObject.optString("path");
            this.bIN = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.xU) || TextUtils.isEmpty(this.bIM)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.bIL + "', pluginVersion='" + this.bIM + "', pluginName='" + this.xU + "', pluginCategory=" + this.bIN + ", pluginPath='" + this.bIO + "'}";
    }
}
