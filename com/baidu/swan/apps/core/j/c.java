package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String cfL;

    @Override // com.baidu.swan.pms.model.e
    public boolean acP() {
        return super.acP() && !TextUtils.isEmpty(this.cfL);
    }
}
