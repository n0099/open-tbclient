package com.baidu.swan.apps.ac.c.b;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public String cFi;
    public String cNO;
    public String cNP;
    public String duX;
    public String duY;
    public String duZ;
    public String dva;
    public com.baidu.swan.apps.api.c.b dvb;
    public JSONObject pageParams;

    public boolean aIl() {
        return (this.dvb == null || this.dvb.isSuccess()) ? false : true;
    }

    public boolean aIm() {
        return (TextUtils.isEmpty(this.duX) || TextUtils.isEmpty(this.duZ) || TextUtils.isEmpty(this.dva) || TextUtils.isEmpty(this.cNO) || TextUtils.isEmpty(this.cNP)) ? false : true;
    }

    public String toString() {
        return "SwanPluginFunPageModel{providerAppKey='" + this.duX + "', providerRootPath='" + this.duZ + "', providerVersion='" + this.dva + "', componentId='" + this.cNO + "', cb='" + this.cFi + "', pageParams=" + this.pageParams + ", swanApiResult=" + (this.dvb == null ? null : this.dvb.toJsonString()) + '}';
    }
}
