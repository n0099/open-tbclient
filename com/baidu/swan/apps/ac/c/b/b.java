package com.baidu.swan.apps.ac.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public String cCS;
    public String cLq;
    public String cLr;
    public String dsu;
    public String dsv;
    public String dsw;
    public String dsx;
    public com.baidu.swan.apps.api.c.b dsy;
    public JSONObject pageParams;

    public boolean aEN() {
        return (this.dsy == null || this.dsy.isSuccess()) ? false : true;
    }

    public boolean aEO() {
        return (TextUtils.isEmpty(this.dsu) || TextUtils.isEmpty(this.dsw) || TextUtils.isEmpty(this.dsx) || TextUtils.isEmpty(this.cLq) || TextUtils.isEmpty(this.cLr)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.dsu + "', providerRootPath='" + this.dsw + "', providerVersion='" + this.dsx + "', componentId='" + this.cLq + "', cb='" + this.cCS + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.dsy == null ? null : this.dsy.toJsonString()) + '}';
    }
}
