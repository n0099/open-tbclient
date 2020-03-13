package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String brc;

    @Override // com.baidu.swan.pms.model.e
    public boolean PU() {
        return super.PU() && !TextUtils.isEmpty(this.brc);
    }
}
