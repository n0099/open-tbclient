package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
/* loaded from: classes25.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String cTX;

    @Override // com.baidu.swan.pms.model.e
    public boolean atE() {
        return super.atE() && !TextUtils.isEmpty(this.cTX);
    }
}
