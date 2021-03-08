package com.baidu.swan.apps.ac.f;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements Cloneable {
    public String Vr;
    public String dup;
    public String duq;
    public int dur;
    public String dus;
    public String dut;

    public a(JSONObject jSONObject, int i) {
        this.dur = 4;
        if (jSONObject != null) {
            this.duq = jSONObject.optString("version");
            this.Vr = jSONObject.optString("provider");
            this.dus = jSONObject.optString("path");
            this.dut = jSONObject.optString("config");
            this.dur = i;
        }
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.Vr) || TextUtils.isEmpty(this.duq)) ? false : true;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "SwanPluginModel{pluginAlias='" + this.dup + "', pluginVersion='" + this.duq + "', pluginName='" + this.Vr + "', pluginCategory=" + this.dur + ", pluginPath='" + this.dus + "', pluginPagesConfigFileName='" + this.dut + "'}";
    }
}
