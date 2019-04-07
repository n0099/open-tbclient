package com.baidu.swan.apps.m.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class e extends a {
    public String aqR;
    public String avo;
    public String avp;
    public String avq;
    public String avr;

    public e() {
        this.avm = "route";
    }

    @Override // com.baidu.swan.apps.m.a.a
    public String eC(String str) {
        String str2 = (com.baidu.swan.apps.m.a.n(str, "fromId", this.avo) + com.baidu.swan.apps.m.a.n(str, "toId", this.avp)) + com.baidu.swan.apps.m.a.n(str, "toTabIndex", this.avr);
        if (!TextUtils.isEmpty(this.aqR)) {
            str2 = str2 + com.baidu.swan.apps.m.a.n(str, "routeType", this.aqR);
        }
        if (!TextUtils.isEmpty(this.avq)) {
            return str2 + com.baidu.swan.apps.m.a.n(str, "toPage", this.avq);
        }
        return str2;
    }
}
