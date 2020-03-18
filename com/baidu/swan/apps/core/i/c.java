package com.baidu.swan.apps.core.i;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.pms.model.f {
    public String bro;

    @Override // com.baidu.swan.pms.model.e
    public boolean PX() {
        return super.PX() && !TextUtils.isEmpty(this.bro);
    }
}
