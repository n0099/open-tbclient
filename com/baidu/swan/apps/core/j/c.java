package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String cmh;

    @Override // com.baidu.swan.pms.model.e
    public boolean ajo() {
        return super.ajo() && !TextUtils.isEmpty(this.cmh);
    }
}
