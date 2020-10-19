package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String cAz;

    @Override // com.baidu.swan.pms.model.e
    public boolean amJ() {
        return super.amJ() && !TextUtils.isEmpty(this.cAz);
    }
}
