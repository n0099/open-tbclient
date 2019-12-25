package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String bmb;

    @Override // com.baidu.swan.pms.model.e
    public boolean Ni() {
        return super.Ni() && !TextUtils.isEmpty(this.bmb);
    }
}
