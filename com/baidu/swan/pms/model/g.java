package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes24.dex */
public class g extends e {
    public String appId;
    public int dHv;
    public boolean dHw;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean ajY() {
        return super.ajY() && !TextUtils.isEmpty(this.pkgName);
    }
}
