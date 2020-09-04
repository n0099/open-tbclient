package com.baidu.swan.apps.ac.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public String bSx;
    public String cIh;
    public String cIi;
    public String cIj;
    public String cIk;
    public com.baidu.swan.apps.api.c.b cIl;
    public String caX;
    public String caY;
    public JSONObject pageParams;

    public boolean awE() {
        return (this.cIl == null || this.cIl.isSuccess()) ? false : true;
    }

    public boolean awF() {
        return (TextUtils.isEmpty(this.cIh) || TextUtils.isEmpty(this.cIj) || TextUtils.isEmpty(this.cIk) || TextUtils.isEmpty(this.caX) || TextUtils.isEmpty(this.caY)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.cIh + "', providerRootPath='" + this.cIj + "', providerVersion='" + this.cIk + "', componentId='" + this.caX + "', cb='" + this.bSx + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.cIl == null ? null : this.cIl.toJsonString()) + '}';
    }
}
