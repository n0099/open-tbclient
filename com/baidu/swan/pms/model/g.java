package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes19.dex */
public class g extends e {
    public String appId;
    public int dwk;
    public boolean dwl;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean acP() {
        return super.acP() && !TextUtils.isEmpty(this.pkgName);
    }
}
