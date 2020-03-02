package com.baidu.swan.apps.ag.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public String bIq;
    public String bIr;
    public String bIs;
    public String bIt;
    public com.baidu.swan.apps.api.b.b bIu;
    public String bil;
    public String bim;
    public String bvb;
    public JSONObject pageParams;

    public boolean aae() {
        return (this.bIu == null || this.bIu.isSuccess()) ? false : true;
    }

    public boolean aaf() {
        return (TextUtils.isEmpty(this.bIq) || TextUtils.isEmpty(this.bIs) || TextUtils.isEmpty(this.bIt) || TextUtils.isEmpty(this.bil) || TextUtils.isEmpty(this.bim)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.bIq + "', providerRootPath='" + this.bIs + "', providerVersion='" + this.bIt + "', componentId='" + this.bil + "', cb='" + this.bvb + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.bIu == null ? null : this.bIu.toJsonString()) + '}';
    }
}
