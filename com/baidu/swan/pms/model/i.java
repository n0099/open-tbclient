package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class i extends f {
    public String Jz;
    public String appId;
    public boolean bme;

    @Override // com.baidu.swan.pms.model.f
    public boolean RI() {
        return super.RI() && !TextUtils.isEmpty(this.Jz);
    }
}
