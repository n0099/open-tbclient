package com.baidu.swan.apps.ae.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public String bPF;
    public String bPG;
    public String cdu;
    public String csG;
    public String csH;
    public String csI;
    public String csJ;
    public com.baidu.swan.apps.api.c.b csK;
    public JSONObject pageParams;

    public boolean alS() {
        return (this.csK == null || this.csK.isSuccess()) ? false : true;
    }

    public boolean alT() {
        return (TextUtils.isEmpty(this.csG) || TextUtils.isEmpty(this.csI) || TextUtils.isEmpty(this.csJ) || TextUtils.isEmpty(this.bPF) || TextUtils.isEmpty(this.bPG)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.csG + "', providerRootPath='" + this.csI + "', providerVersion='" + this.csJ + "', componentId='" + this.bPF + "', cb='" + this.cdu + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.csK == null ? null : this.csK.toJsonString()) + '}';
    }
}
