package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes15.dex */
public class g extends e {
    public String appId;
    public int dTw;
    public boolean dTx;
    public String pkgName;

    @Override // com.baidu.swan.pms.model.e
    public boolean amJ() {
        return super.amJ() && !TextUtils.isEmpty(this.pkgName);
    }
}
