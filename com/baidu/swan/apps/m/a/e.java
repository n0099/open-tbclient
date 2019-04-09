package com.baidu.swan.apps.m.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class e extends a {
    public String aqS;
    public String avp;
    public String avq;
    public String avr;
    public String avs;

    public e() {
        this.avn = "route";
    }

    @Override // com.baidu.swan.apps.m.a.a
    public String eC(String str) {
        String str2 = (com.baidu.swan.apps.m.a.n(str, "fromId", this.avp) + com.baidu.swan.apps.m.a.n(str, "toId", this.avq)) + com.baidu.swan.apps.m.a.n(str, "toTabIndex", this.avs);
        if (!TextUtils.isEmpty(this.aqS)) {
            str2 = str2 + com.baidu.swan.apps.m.a.n(str, "routeType", this.aqS);
        }
        if (!TextUtils.isEmpty(this.avr)) {
            return str2 + com.baidu.swan.apps.m.a.n(str, "toPage", this.avr);
        }
        return str2;
    }
}
