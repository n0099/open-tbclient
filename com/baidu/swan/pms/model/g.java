package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class g extends e {
    public String appId;
    public int erZ;
    public boolean esa;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean arb() {
        return super.arb() && !TextUtils.isEmpty(this.pkgName);
    }
}
