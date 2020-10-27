package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes15.dex */
public class g extends e {
    public String appId;
    public int ebS;
    public boolean ebT;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean aoD() {
        return super.aoD() && !TextUtils.isEmpty(this.pkgName);
    }
}
