package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class g extends e {
    public String appId;
    public int cBu;
    public boolean independent;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean PX() {
        return super.PX() && !TextUtils.isEmpty(this.pkgName);
    }
}
