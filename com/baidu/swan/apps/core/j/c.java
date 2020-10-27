package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String cIV;

    @Override // com.baidu.swan.pms.model.e
    public boolean aoD() {
        return super.aoD() && !TextUtils.isEmpty(this.cIV);
    }
}
