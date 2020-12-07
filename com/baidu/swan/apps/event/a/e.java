package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes25.dex */
public class e extends a {
    public String cQf;
    public String cYB;
    public String cYC;
    public String cYD;
    public String cYE;

    public e() {
        this.cFU = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String oM(String str) {
        String str2 = (com.baidu.swan.apps.event.a.L(str, "fromId", this.cYB) + com.baidu.swan.apps.event.a.L(str, "toId", this.cYC)) + com.baidu.swan.apps.event.a.L(str, "toTabIndex", this.cYE);
        if (!TextUtils.isEmpty(this.cQf)) {
            str2 = str2 + com.baidu.swan.apps.event.a.L(str, "routeType", this.cQf);
        }
        if (!TextUtils.isEmpty(this.cYD)) {
            return str2 + com.baidu.swan.apps.event.a.L(str, "toPage", this.cYD);
        }
        return str2;
    }
}
