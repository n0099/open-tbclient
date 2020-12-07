package com.baidu.swan.apps.ac.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class b {
    public String cAs;
    public String cIV;
    public String cIW;
    public String dpY;
    public String dpZ;
    public String dqa;
    public String dqb;
    public com.baidu.swan.apps.api.c.b dqc;
    public JSONObject pageParams;

    public boolean aGS() {
        return (this.dqc == null || this.dqc.isSuccess()) ? false : true;
    }

    public boolean aGT() {
        return (TextUtils.isEmpty(this.dpY) || TextUtils.isEmpty(this.dqa) || TextUtils.isEmpty(this.dqb) || TextUtils.isEmpty(this.cIV) || TextUtils.isEmpty(this.cIW)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.dpY + "', providerRootPath='" + this.dqa + "', providerVersion='" + this.dqb + "', componentId='" + this.cIV + "', cb='" + this.cAs + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.dqc == null ? null : this.dqc.toJsonString()) + '}';
    }
}
