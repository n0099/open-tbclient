package com.baidu.swan.apps.ae.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    public String RP;
    public String cxO;
    public String cxP;
    public int cxQ;
    public String cxR;
    public String cxS;

    public a(JSONObject jSONObject, int i) {
        this.cxQ = 4;
        if (jSONObject != null) {
            this.cxP = jSONObject.optString("version");
            this.RP = jSONObject.optString("provider");
            this.cxR = jSONObject.optString("path");
            this.cxS = jSONObject.optString("config");
            this.cxQ = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.RP) || TextUtils.isEmpty(this.cxP)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.cxO + "', pluginVersion='" + this.cxP + "', pluginName='" + this.RP + "', pluginCategory=" + this.cxQ + ", pluginPath='" + this.cxR + "', pluginPagesConfigFileName='" + this.cxS + "'}";
    }
}
