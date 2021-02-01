package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String cWu;

    @Override // com.baidu.swan.pms.model.e
    public boolean arz() {
        return super.arz() && !TextUtils.isEmpty(this.cWu);
    }
}
