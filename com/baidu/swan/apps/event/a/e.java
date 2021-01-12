package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class e extends a {
    public String cQq;
    public String cYH;
    public String cYI;
    public String cYJ;
    public String cYK;

    public e() {
        this.cFY = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String ns(String str) {
        String str2 = (com.baidu.swan.apps.event.a.N(str, "fromId", this.cYH) + com.baidu.swan.apps.event.a.N(str, "toId", this.cYI)) + com.baidu.swan.apps.event.a.N(str, "toTabIndex", this.cYK);
        if (!TextUtils.isEmpty(this.cQq)) {
            str2 = str2 + com.baidu.swan.apps.event.a.N(str, "routeType", this.cQq);
        }
        if (!TextUtils.isEmpty(this.cYJ)) {
            return str2 + com.baidu.swan.apps.event.a.N(str, "toPage", this.cYJ);
        }
        return str2;
    }
}
