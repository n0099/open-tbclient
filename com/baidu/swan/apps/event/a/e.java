package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class e extends a {
    public String cFd;
    public String cFe;
    public String cFf;
    public String cFg;
    public String cwH;

    public e() {
        this.cmp = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String nC(String str) {
        String str2 = (com.baidu.swan.apps.event.a.B(str, "fromId", this.cFd) + com.baidu.swan.apps.event.a.B(str, "toId", this.cFe)) + com.baidu.swan.apps.event.a.B(str, "toTabIndex", this.cFg);
        if (!TextUtils.isEmpty(this.cwH)) {
            str2 = str2 + com.baidu.swan.apps.event.a.B(str, "routeType", this.cwH);
        }
        if (!TextUtils.isEmpty(this.cFf)) {
            return str2 + com.baidu.swan.apps.event.a.B(str, "toPage", this.cFf);
        }
        return str2;
    }
}
