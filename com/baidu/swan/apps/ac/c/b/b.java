package com.baidu.swan.apps.ac.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public String cWk;
    public String cWl;
    public String cWm;
    public String cWn;
    public com.baidu.swan.apps.api.c.b cWo;
    public String cgL;
    public String cpp;
    public String cpq;
    public JSONObject pageParams;

    public boolean azY() {
        return (this.cWo == null || this.cWo.isSuccess()) ? false : true;
    }

    public boolean azZ() {
        return (TextUtils.isEmpty(this.cWk) || TextUtils.isEmpty(this.cWm) || TextUtils.isEmpty(this.cWn) || TextUtils.isEmpty(this.cpp) || TextUtils.isEmpty(this.cpq)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.cWk + "', providerRootPath='" + this.cWm + "', providerVersion='" + this.cWn + "', componentId='" + this.cpp + "', cb='" + this.cgL + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.cWo == null ? null : this.cWo.toJsonString()) + '}';
    }
}
