package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class h extends e {
    public String Ht;
    public String appId;
    public boolean btt;

    @Override // com.baidu.swan.pms.model.e
    public boolean Ws() {
        return super.Ws() && !TextUtils.isEmpty(this.Ht);
    }
}
