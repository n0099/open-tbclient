package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class e extends a {
    public String cVc;
    public String ddA;
    public String ddx;
    public String ddy;
    public String ddz;

    public e() {
        this.cKK = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String oF(String str) {
        String str2 = (com.baidu.swan.apps.event.a.O(str, "fromId", this.ddx) + com.baidu.swan.apps.event.a.O(str, "toId", this.ddy)) + com.baidu.swan.apps.event.a.O(str, "toTabIndex", this.ddA);
        if (!TextUtils.isEmpty(this.cVc)) {
            str2 = str2 + com.baidu.swan.apps.event.a.O(str, "routeType", this.cVc);
        }
        if (!TextUtils.isEmpty(this.ddz)) {
            return str2 + com.baidu.swan.apps.event.a.O(str, "toPage", this.ddz);
        }
        return str2;
    }
}
