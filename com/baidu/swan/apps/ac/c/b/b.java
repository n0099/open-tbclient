package com.baidu.swan.apps.ac.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public String bUx;
    public String cKh;
    public String cKi;
    public String cKj;
    public String cKk;
    public com.baidu.swan.apps.api.c.b cKl;
    public String ccZ;
    public String cda;
    public JSONObject pageParams;

    public boolean axn() {
        return (this.cKl == null || this.cKl.isSuccess()) ? false : true;
    }

    public boolean axo() {
        return (TextUtils.isEmpty(this.cKh) || TextUtils.isEmpty(this.cKj) || TextUtils.isEmpty(this.cKk) || TextUtils.isEmpty(this.ccZ) || TextUtils.isEmpty(this.cda)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.cKh + "', providerRootPath='" + this.cKj + "', providerVersion='" + this.cKk + "', componentId='" + this.ccZ + "', cb='" + this.bUx + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.cKl == null ? null : this.cKl.toJsonString()) + '}';
    }
}
