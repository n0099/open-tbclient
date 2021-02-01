package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class g extends e {
    public String appId;
    public int eug;
    public boolean euh;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean arz() {
        return super.arz() && !TextUtils.isEmpty(this.pkgName);
    }
}
