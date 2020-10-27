package com.baidu.swan.apps.ac.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public String cpl;
    public String cxR;
    public String cxS;
    public String deL;
    public String deM;
    public String deN;
    public String deO;
    public com.baidu.swan.apps.api.c.b deP;
    public JSONObject pageParams;

    public boolean aBS() {
        return (this.deP == null || this.deP.isSuccess()) ? false : true;
    }

    public boolean aBT() {
        return (TextUtils.isEmpty(this.deL) || TextUtils.isEmpty(this.deN) || TextUtils.isEmpty(this.deO) || TextUtils.isEmpty(this.cxR) || TextUtils.isEmpty(this.cxS)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.deL + "', providerRootPath='" + this.deN + "', providerVersion='" + this.deO + "', componentId='" + this.cxR + "', cb='" + this.cpl + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.deP == null ? null : this.deP.toJsonString()) + '}';
    }
}
