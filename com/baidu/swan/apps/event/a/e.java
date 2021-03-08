package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class e extends a {
    public String cUd;
    public String dcv;
    public String dcw;
    public String dcx;
    public String dcy;

    public e() {
        this.cJT = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String nR(String str) {
        String str2 = (com.baidu.swan.apps.event.a.O(str, "fromId", this.dcv) + com.baidu.swan.apps.event.a.O(str, "toId", this.dcw)) + com.baidu.swan.apps.event.a.O(str, "toTabIndex", this.dcy);
        if (!TextUtils.isEmpty(this.cUd)) {
            str2 = str2 + com.baidu.swan.apps.event.a.O(str, "routeType", this.cUd);
        }
        if (!TextUtils.isEmpty(this.dcx)) {
            return str2 + com.baidu.swan.apps.event.a.O(str, "toPage", this.dcx);
        }
        return str2;
    }
}
