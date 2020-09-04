package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes14.dex */
public class g extends e {
    public String appId;
    public int dFr;
    public boolean dFs;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean ajo() {
        return super.ajo() && !TextUtils.isEmpty(this.pkgName);
    }
}
