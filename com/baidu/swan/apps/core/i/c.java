package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String bPv;

    @Override // com.baidu.swan.pms.model.e
    public boolean XM() {
        return super.XM() && !TextUtils.isEmpty(this.bPv);
    }
}
