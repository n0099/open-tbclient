package com.baidu.swan.apps.ae.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public String bUt;
    public String bUu;
    public String cii;
    public String cxu;
    public String cxv;
    public String cxw;
    public String cxx;
    public com.baidu.swan.apps.api.c.b cxy;
    public JSONObject pageParams;

    public boolean amY() {
        return (this.cxy == null || this.cxy.isSuccess()) ? false : true;
    }

    public boolean amZ() {
        return (TextUtils.isEmpty(this.cxu) || TextUtils.isEmpty(this.cxw) || TextUtils.isEmpty(this.cxx) || TextUtils.isEmpty(this.bUt) || TextUtils.isEmpty(this.bUu)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.cxu + "', providerRootPath='" + this.cxw + "', providerVersion='" + this.cxx + "', componentId='" + this.bUt + "', cb='" + this.cii + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.cxy == null ? null : this.cxy.toJsonString()) + '}';
    }
}
