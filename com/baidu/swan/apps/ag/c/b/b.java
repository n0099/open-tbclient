package com.baidu.swan.apps.ag.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public String bEk;
    public String bEl;
    public String bEm;
    public String bEn;
    public com.baidu.swan.apps.api.b.b bEo;
    public String bdV;
    public String bdW;
    public String bqQ;
    public JSONObject pageParams;

    public boolean XO() {
        return (this.bEo == null || this.bEo.isSuccess()) ? false : true;
    }

    public boolean XP() {
        return (TextUtils.isEmpty(this.bEk) || TextUtils.isEmpty(this.bEm) || TextUtils.isEmpty(this.bEn) || TextUtils.isEmpty(this.bdV) || TextUtils.isEmpty(this.bdW)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.bEk + "', providerRootPath='" + this.bEm + "', providerVersion='" + this.bEn + "', componentId='" + this.bdV + "', cb='" + this.bqQ + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.bEo == null ? null : this.bEo.toJsonString()) + '}';
    }
}
