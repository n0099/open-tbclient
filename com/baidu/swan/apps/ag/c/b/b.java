package com.baidu.swan.apps.ag.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public String bIC;
    public String bID;
    public String bIE;
    public String bIF;
    public com.baidu.swan.apps.api.b.b bIG;
    public String biA;
    public String biB;
    public String bvo;
    public JSONObject pageParams;

    public boolean aah() {
        return (this.bIG == null || this.bIG.isSuccess()) ? false : true;
    }

    public boolean aai() {
        return (TextUtils.isEmpty(this.bIC) || TextUtils.isEmpty(this.bIE) || TextUtils.isEmpty(this.bIF) || TextUtils.isEmpty(this.biA) || TextUtils.isEmpty(this.biB)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.bIC + "', providerRootPath='" + this.bIE + "', providerVersion='" + this.bIF + "', componentId='" + this.biA + "', cb='" + this.bvo + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.bIG == null ? null : this.bIG.toJsonString()) + '}';
    }
}
