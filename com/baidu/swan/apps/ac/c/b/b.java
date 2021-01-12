package com.baidu.swan.apps.ac.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public String cAw;
    public String cJc;
    public String cJd;
    public String dqi;
    public String dqj;
    public String dqk;
    public String dql;
    public com.baidu.swan.apps.api.c.b dqm;
    public JSONObject pageParams;

    public boolean aEs() {
        return (this.dqm == null || this.dqm.isSuccess()) ? false : true;
    }

    public boolean aEt() {
        return (TextUtils.isEmpty(this.dqi) || TextUtils.isEmpty(this.dqk) || TextUtils.isEmpty(this.dql) || TextUtils.isEmpty(this.cJc) || TextUtils.isEmpty(this.cJd)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.dqi + "', providerRootPath='" + this.dqk + "', providerVersion='" + this.dql + "', componentId='" + this.cJc + "', cb='" + this.cAw + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.dqm == null ? null : this.dqm.toJsonString()) + '}';
    }
}
