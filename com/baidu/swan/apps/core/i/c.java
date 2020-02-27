package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String bra;

    @Override // com.baidu.swan.pms.model.e
    public boolean PS() {
        return super.PS() && !TextUtils.isEmpty(this.bra);
    }
}
