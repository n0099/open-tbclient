package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String cUh;

    @Override // com.baidu.swan.pms.model.e
    public boolean arb() {
        return super.arb() && !TextUtils.isEmpty(this.cUh);
    }
}
