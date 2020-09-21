package com.baidu.swan.apps.core.j;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String coj;

    @Override // com.baidu.swan.pms.model.e
    public boolean ajY() {
        return super.ajY() && !TextUtils.isEmpty(this.coj);
    }
}
