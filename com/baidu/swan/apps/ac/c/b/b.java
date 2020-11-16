package com.baidu.swan.apps.ac.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public String cCa;
    public String cCb;
    public String cty;
    public String diZ;
    public String dja;
    public String djb;
    public String djc;
    public com.baidu.swan.apps.api.c.b djd;
    public JSONObject pageParams;

    public boolean aDK() {
        return (this.djd == null || this.djd.isSuccess()) ? false : true;
    }

    public boolean aDL() {
        return (TextUtils.isEmpty(this.diZ) || TextUtils.isEmpty(this.djb) || TextUtils.isEmpty(this.djc) || TextUtils.isEmpty(this.cCa) || TextUtils.isEmpty(this.cCb)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.diZ + "', providerRootPath='" + this.djb + "', providerVersion='" + this.djc + "', componentId='" + this.cCa + "', cb='" + this.cty + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.djd == null ? null : this.djd.toJsonString()) + '}';
    }
}
