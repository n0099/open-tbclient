package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class e extends a {
    public String cik;
    public String cqL;
    public String cqM;
    public String cqN;
    public String cqO;

    public e() {
        this.bXU = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String mw(String str) {
        String str2 = (com.baidu.swan.apps.event.a.A(str, "fromId", this.cqL) + com.baidu.swan.apps.event.a.A(str, "toId", this.cqM)) + com.baidu.swan.apps.event.a.A(str, "toTabIndex", this.cqO);
        if (!TextUtils.isEmpty(this.cik)) {
            str2 = str2 + com.baidu.swan.apps.event.a.A(str, "routeType", this.cik);
        }
        if (!TextUtils.isEmpty(this.cqN)) {
            return str2 + com.baidu.swan.apps.event.a.A(str, "toPage", this.cqN);
        }
        return str2;
    }
}
