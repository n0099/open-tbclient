package com.baidu.swan.apps.ag.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public String bIp;
    public String bIq;
    public String bIr;
    public String bIs;
    public com.baidu.swan.apps.api.b.b bIt;
    public String bik;
    public String bil;
    public String bva;
    public JSONObject pageParams;

    public boolean aac() {
        return (this.bIt == null || this.bIt.isSuccess()) ? false : true;
    }

    public boolean aad() {
        return (TextUtils.isEmpty(this.bIp) || TextUtils.isEmpty(this.bIr) || TextUtils.isEmpty(this.bIs) || TextUtils.isEmpty(this.bik) || TextUtils.isEmpty(this.bil)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.bIp + "', providerRootPath='" + this.bIr + "', providerVersion='" + this.bIs + "', componentId='" + this.bik + "', cb='" + this.bva + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.bIt == null ? null : this.bIt.toJsonString()) + '}';
    }
}
