package com.baidu.swan.apps.ag.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public String bGN;
    public String bGO;
    public String bTA;
    public String chr;
    public String chs;
    public String cht;
    public String chu;
    public com.baidu.swan.apps.api.b.b chv;
    public JSONObject pageParams;

    public boolean ail() {
        return (this.chv == null || this.chv.isSuccess()) ? false : true;
    }

    public boolean aim() {
        return (TextUtils.isEmpty(this.chr) || TextUtils.isEmpty(this.cht) || TextUtils.isEmpty(this.chu) || TextUtils.isEmpty(this.bGN) || TextUtils.isEmpty(this.bGO)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.chr + "', providerRootPath='" + this.cht + "', providerVersion='" + this.chu + "', componentId='" + this.bGN + "', cb='" + this.bTA + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.chv == null ? null : this.chv.toJsonString()) + '}';
    }
}
