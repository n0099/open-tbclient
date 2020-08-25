package com.baidu.swan.apps.ac.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public String bSt;
    public String cId;
    public String cIe;
    public String cIf;
    public String cIg;
    public com.baidu.swan.apps.api.c.b cIh;
    public String caT;
    public String caU;
    public JSONObject pageParams;

    public boolean awE() {
        return (this.cIh == null || this.cIh.isSuccess()) ? false : true;
    }

    public boolean awF() {
        return (TextUtils.isEmpty(this.cId) || TextUtils.isEmpty(this.cIf) || TextUtils.isEmpty(this.cIg) || TextUtils.isEmpty(this.caT) || TextUtils.isEmpty(this.caU)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.cId + "', providerRootPath='" + this.cIf + "', providerVersion='" + this.cIg + "', componentId='" + this.caT + "', cb='" + this.bSt + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.cIh == null ? null : this.cIh.toJsonString()) + '}';
    }
}
