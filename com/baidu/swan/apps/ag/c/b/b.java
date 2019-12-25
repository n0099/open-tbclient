package com.baidu.swan.apps.ag.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public String bDA;
    public String bDB;
    public String bDC;
    public com.baidu.swan.apps.api.b.b bDD;
    public String bDz;
    public String bdh;
    public String bdi;
    public String bqc;
    public JSONObject pageParams;

    public boolean Xr() {
        return (this.bDD == null || this.bDD.isSuccess()) ? false : true;
    }

    public boolean Xs() {
        return (TextUtils.isEmpty(this.bDz) || TextUtils.isEmpty(this.bDB) || TextUtils.isEmpty(this.bDC) || TextUtils.isEmpty(this.bdh) || TextUtils.isEmpty(this.bdi)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.bDz + "', providerRootPath='" + this.bDB + "', providerVersion='" + this.bDC + "', componentId='" + this.bdh + "', cb='" + this.bqc + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.bDD == null ? null : this.bDD.toJsonString()) + '}';
    }
}
