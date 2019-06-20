package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class h extends e {
    public String Hi;
    public String appId;
    public boolean bsg;

    @Override // com.baidu.swan.pms.model.e
    public boolean Vv() {
        return super.Vv() && !TextUtils.isEmpty(this.Hi);
    }
}
