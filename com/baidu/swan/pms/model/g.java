package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class g extends e {
    public String appId;
    public int ene;
    public boolean enf;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean atE() {
        return super.atE() && !TextUtils.isEmpty(this.pkgName);
    }
}
