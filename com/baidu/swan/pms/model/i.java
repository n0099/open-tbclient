package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class i extends f {
    public String Jz;
    public String appId;
    public boolean bma;

    @Override // com.baidu.swan.pms.model.f
    public boolean RK() {
        return super.RK() && !TextUtils.isEmpty(this.Jz);
    }
}
