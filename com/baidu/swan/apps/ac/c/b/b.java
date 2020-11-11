package com.baidu.swan.apps.ac.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public String cDK;
    public String cDL;
    public String cvk;
    public String dkG;
    public String dkH;
    public String dkI;
    public String dkJ;
    public com.baidu.swan.apps.api.c.b dkK;
    public JSONObject pageParams;

    public boolean aEs() {
        return (this.dkK == null || this.dkK.isSuccess()) ? false : true;
    }

    public boolean aEt() {
        return (TextUtils.isEmpty(this.dkG) || TextUtils.isEmpty(this.dkI) || TextUtils.isEmpty(this.dkJ) || TextUtils.isEmpty(this.cDK) || TextUtils.isEmpty(this.cDL)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.dkG + "', providerRootPath='" + this.dkI + "', providerVersion='" + this.dkJ + "', componentId='" + this.cDK + "', cb='" + this.cvk + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.dkK == null ? null : this.dkK.toJsonString()) + '}';
    }
}
