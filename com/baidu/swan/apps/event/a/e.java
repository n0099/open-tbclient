package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class e extends a {
    public String cJm;
    public String cRI;
    public String cRJ;
    public String cRK;
    public String cRL;

    public e() {
        this.czc = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String od(String str) {
        String str2 = (com.baidu.swan.apps.event.a.I(str, "fromId", this.cRI) + com.baidu.swan.apps.event.a.I(str, "toId", this.cRJ)) + com.baidu.swan.apps.event.a.I(str, "toTabIndex", this.cRL);
        if (!TextUtils.isEmpty(this.cJm)) {
            str2 = str2 + com.baidu.swan.apps.event.a.I(str, "routeType", this.cJm);
        }
        if (!TextUtils.isEmpty(this.cRK)) {
            return str2 + com.baidu.swan.apps.event.a.I(str, "toPage", this.cRK);
        }
        return str2;
    }
}
