package com.baidu.swan.apps.ad.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements Cloneable {
    public String RK;
    public String cAn;
    public String cAo;
    public int cAp;
    public String cAq;
    public String cAr;

    public a(JSONObject jSONObject, int i) {
        this.cAp = 4;
        if (jSONObject != null) {
            this.cAo = jSONObject.optString("version");
            this.RK = jSONObject.optString("provider");
            this.cAq = jSONObject.optString("path");
            this.cAr = jSONObject.optString("config");
            this.cAp = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.RK) || TextUtils.isEmpty(this.cAo)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.cAn + "', pluginVersion='" + this.cAo + "', pluginName='" + this.RK + "', pluginCategory=" + this.cAp + ", pluginPath='" + this.cAq + "', pluginPagesConfigFileName='" + this.cAr + "'}";
    }
}
