package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes15.dex */
public class g extends e {
    public String appId;
    public int ehK;
    public boolean ehL;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean are() {
        return super.are() && !TextUtils.isEmpty(this.pkgName);
    }
}
