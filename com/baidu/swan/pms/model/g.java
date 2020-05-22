package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class g extends e {
    public String appId;
    public int dlH;
    public boolean dlI;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean aaF() {
        return super.aaF() && !TextUtils.isEmpty(this.pkgName);
    }
}
