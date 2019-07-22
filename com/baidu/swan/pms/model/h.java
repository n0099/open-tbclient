package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class h extends e {
    public String Ht;
    public String appId;
    public boolean bsV;

    @Override // com.baidu.swan.pms.model.e
    public boolean Wo() {
        return super.Wo() && !TextUtils.isEmpty(this.Ht);
    }
}
