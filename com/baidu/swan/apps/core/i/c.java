package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String bmR;

    @Override // com.baidu.swan.pms.model.e
    public boolean NE() {
        return super.NE() && !TextUtils.isEmpty(this.bmR);
    }
}
