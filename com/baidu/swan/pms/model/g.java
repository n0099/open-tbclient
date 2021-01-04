package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class g extends e {
    public String appId;
    public int ewM;
    public boolean ewN;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean auV() {
        return super.auV() && !TextUtils.isEmpty(this.pkgName);
    }
}
