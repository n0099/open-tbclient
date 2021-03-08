package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String cXU;

    @Override // com.baidu.swan.pms.model.e
    public boolean arC() {
        return super.arC() && !TextUtils.isEmpty(this.cXU);
    }
}
