package com.baidu.swan.apps.ag.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public String bIr;
    public String bIs;
    public String bIt;
    public String bIu;
    public com.baidu.swan.apps.api.b.b bIv;
    public String bim;
    public String bin;
    public String bvc;
    public JSONObject pageParams;

    public boolean aae() {
        return (this.bIv == null || this.bIv.isSuccess()) ? false : true;
    }

    public boolean aaf() {
        return (TextUtils.isEmpty(this.bIr) || TextUtils.isEmpty(this.bIt) || TextUtils.isEmpty(this.bIu) || TextUtils.isEmpty(this.bim) || TextUtils.isEmpty(this.bin)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.bIr + "', providerRootPath='" + this.bIt + "', providerVersion='" + this.bIu + "', componentId='" + this.bim + "', cb='" + this.bvc + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.bIv == null ? null : this.bIv.toJsonString()) + '}';
    }
}
