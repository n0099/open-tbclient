package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class g extends e {
    public String appId;
    public int cwY;
    public boolean independent;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean Ni() {
        return super.Ni() && !TextUtils.isEmpty(this.pkgName);
    }
}
