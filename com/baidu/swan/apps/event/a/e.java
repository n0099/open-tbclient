package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class e extends a {
    public String cFd;
    public String cNA;
    public String cNB;
    public String cNC;
    public String cNz;

    public e() {
        this.cuT = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String nV(String str) {
        String str2 = (com.baidu.swan.apps.event.a.I(str, "fromId", this.cNz) + com.baidu.swan.apps.event.a.I(str, "toId", this.cNA)) + com.baidu.swan.apps.event.a.I(str, "toTabIndex", this.cNC);
        if (!TextUtils.isEmpty(this.cFd)) {
            str2 = str2 + com.baidu.swan.apps.event.a.I(str, "routeType", this.cFd);
        }
        if (!TextUtils.isEmpty(this.cNB)) {
            return str2 + com.baidu.swan.apps.event.a.I(str, "toPage", this.cNB);
        }
        return str2;
    }
}
