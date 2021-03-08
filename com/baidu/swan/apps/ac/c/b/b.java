package com.baidu.swan.apps.ac.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public String cEs;
    public String cMQ;
    public String cMR;
    public String dtW;
    public String dtX;
    public String dtY;
    public String dtZ;
    public com.baidu.swan.apps.api.c.b dua;
    public JSONObject pageParams;

    public boolean aEQ() {
        return (this.dua == null || this.dua.isSuccess()) ? false : true;
    }

    public boolean aER() {
        return (TextUtils.isEmpty(this.dtW) || TextUtils.isEmpty(this.dtY) || TextUtils.isEmpty(this.dtZ) || TextUtils.isEmpty(this.cMQ) || TextUtils.isEmpty(this.cMR)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.dtW + "', providerRootPath='" + this.dtY + "', providerVersion='" + this.dtZ + "', componentId='" + this.cMQ + "', cb='" + this.cEs + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.dua == null ? null : this.dua.toJsonString()) + '}';
    }
}
