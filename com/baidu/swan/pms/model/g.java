package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class g extends e {
    public String appId;
    public int cxj;
    public boolean independent;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean NE() {
        return super.NE() && !TextUtils.isEmpty(this.pkgName);
    }
}
