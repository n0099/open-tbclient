package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String cNe;

    @Override // com.baidu.swan.pms.model.e
    public boolean aqw() {
        return super.aqw() && !TextUtils.isEmpty(this.cNe);
    }
}
