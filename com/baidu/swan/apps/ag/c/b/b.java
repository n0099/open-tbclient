package com.baidu.swan.apps.ag.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public String bGI;
    public String bGJ;
    public String bTu;
    public String chl;
    public String chm;
    public String chn;
    public String cho;
    public com.baidu.swan.apps.api.b.b chp;
    public JSONObject pageParams;

    public boolean aim() {
        return (this.chp == null || this.chp.isSuccess()) ? false : true;
    }

    public boolean ain() {
        return (TextUtils.isEmpty(this.chl) || TextUtils.isEmpty(this.chn) || TextUtils.isEmpty(this.cho) || TextUtils.isEmpty(this.bGI) || TextUtils.isEmpty(this.bGJ)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.chl + "', providerRootPath='" + this.chn + "', providerVersion='" + this.cho + "', componentId='" + this.bGI + "', cb='" + this.bTu + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.chp == null ? null : this.chp.toJsonString()) + '}';
    }
}
