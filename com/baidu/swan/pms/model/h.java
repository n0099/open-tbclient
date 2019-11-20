package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class h extends e {
    public String appId;
    public boolean bLn;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean abf() {
        return super.abf() && !TextUtils.isEmpty(this.pkgName);
    }
}
