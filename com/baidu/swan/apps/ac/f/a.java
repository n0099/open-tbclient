package com.baidu.swan.apps.ac.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements Cloneable {
    public String Te;
    public String djs;
    public String djt;
    public int dju;
    public String djv;
    public String djw;

    public a(JSONObject jSONObject, int i) {
        this.dju = 4;
        if (jSONObject != null) {
            this.djt = jSONObject.optString("version");
            this.Te = jSONObject.optString("provider");
            this.djv = jSONObject.optString("path");
            this.djw = jSONObject.optString("config");
            this.dju = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.Te) || TextUtils.isEmpty(this.djt)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.djs + "', pluginVersion='" + this.djt + "', pluginName='" + this.Te + "', pluginCategory=" + this.dju + ", pluginPath='" + this.djv + "', pluginPagesConfigFileName='" + this.djw + "'}";
    }
}
