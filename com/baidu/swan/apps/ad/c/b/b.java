package com.baidu.swan.apps.ad.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public String bVl;
    public String bVm;
    public String ckg;
    public String czU;
    public String czV;
    public String czW;
    public String czX;
    public com.baidu.swan.apps.api.c.b czY;
    public JSONObject pageParams;

    public boolean aoH() {
        return (this.czY == null || this.czY.isSuccess()) ? false : true;
    }

    public boolean aoI() {
        return (TextUtils.isEmpty(this.czU) || TextUtils.isEmpty(this.czW) || TextUtils.isEmpty(this.czX) || TextUtils.isEmpty(this.bVl) || TextUtils.isEmpty(this.bVm)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.czU + "', providerRootPath='" + this.czW + "', providerVersion='" + this.czX + "', componentId='" + this.bVl + "', cb='" + this.ckg + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.czY == null ? null : this.czY.toJsonString()) + '}';
    }
}
