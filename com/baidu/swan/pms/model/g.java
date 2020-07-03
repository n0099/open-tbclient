package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class g extends e {
    public String appId;
    public int dqs;
    public boolean dqt;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean abL() {
        return super.abL() && !TextUtils.isEmpty(this.pkgName);
    }
}
