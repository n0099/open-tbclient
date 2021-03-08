package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class g extends e {
    public String appId;
    public int evH;
    public boolean evI;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean arC() {
        return super.arC() && !TextUtils.isEmpty(this.pkgName);
    }
}
