package com.baidu.swan.apps.ag.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    public String bIW;
    public String bIX;
    public int bIY;
    public String bIZ;
    public String xU;

    public a(JSONObject jSONObject, int i) {
        this.bIY = 4;
        if (jSONObject != null) {
            this.bIX = jSONObject.optString("version");
            this.xU = jSONObject.optString("provider");
            this.bIZ = jSONObject.optString("path");
            this.bIY = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.xU) || TextUtils.isEmpty(this.bIX)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.bIW + "', pluginVersion='" + this.bIX + "', pluginName='" + this.xU + "', pluginCategory=" + this.bIY + ", pluginPath='" + this.bIZ + "'}";
    }
}
