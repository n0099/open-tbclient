package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class g extends e {
    public String appId;
    public int egc;
    public boolean egd;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean aqw() {
        return super.aqw() && !TextUtils.isEmpty(this.pkgName);
    }
}
