package com.baidu.swan.pms.model;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class h extends e {
    public String appId;
    public boolean bMe;
    public String ud;

    @Override // com.baidu.swan.pms.model.e
    public boolean abh() {
        return super.abh() && !TextUtils.isEmpty(this.ud);
    }
}
