package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class g extends e {
    public String appId;
    public int cBj;
    public boolean independent;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean PU() {
        return super.PU() && !TextUtils.isEmpty(this.pkgName);
    }
}
