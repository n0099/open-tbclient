package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String cec;

    @Override // com.baidu.swan.pms.model.e
    public boolean abL() {
        return super.abL() && !TextUtils.isEmpty(this.cec);
    }
}
