package com.baidu.swan.apps.ag.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    public String bIJ;
    public String bIK;
    public int bIL;
    public String bIM;
    public String xU;

    public a(JSONObject jSONObject, int i) {
        this.bIL = 4;
        if (jSONObject != null) {
            this.bIK = jSONObject.optString("version");
            this.xU = jSONObject.optString("provider");
            this.bIM = jSONObject.optString("path");
            this.bIL = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.xU) || TextUtils.isEmpty(this.bIK)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.bIJ + "', pluginVersion='" + this.bIK + "', pluginName='" + this.xU + "', pluginCategory=" + this.bIL + ", pluginPath='" + this.bIM + "'}";
    }
}
