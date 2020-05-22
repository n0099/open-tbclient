package com.baidu.swan.apps.ae.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements Cloneable {
    public String Rm;
    public String cta;
    public String ctb;
    public int ctc;
    public String ctd;
    public String cte;

    public a(JSONObject jSONObject, int i) {
        this.ctc = 4;
        if (jSONObject != null) {
            this.ctb = jSONObject.optString("version");
            this.Rm = jSONObject.optString("provider");
            this.ctd = jSONObject.optString("path");
            this.cte = jSONObject.optString("config");
            this.ctc = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.Rm) || TextUtils.isEmpty(this.ctb)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.cta + "', pluginVersion='" + this.ctb + "', pluginName='" + this.Rm + "', pluginCategory=" + this.ctc + ", pluginPath='" + this.ctd + "', pluginPagesConfigFileName='" + this.cte + "'}";
    }
}
