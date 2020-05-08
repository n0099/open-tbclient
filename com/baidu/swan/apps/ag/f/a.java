package com.baidu.swan.apps.ag.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    public String Rb;
    public String chL;
    public String chM;
    public int chN;
    public String chO;

    public a(JSONObject jSONObject, int i) {
        this.chN = 4;
        if (jSONObject != null) {
            this.chM = jSONObject.optString("version");
            this.Rb = jSONObject.optString("provider");
            this.chO = jSONObject.optString("path");
            this.chN = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.Rb) || TextUtils.isEmpty(this.chM)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.chL + "', pluginVersion='" + this.chM + "', pluginName='" + this.Rb + "', pluginCategory=" + this.chN + ", pluginPath='" + this.chO + "'}";
    }
}
