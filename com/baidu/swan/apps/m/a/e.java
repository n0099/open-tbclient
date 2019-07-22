package com.baidu.swan.apps.m.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class e extends a {
    public String arA;
    public String awn;
    public String awo;
    public String awp;
    public String awq;

    public e() {
        this.awl = "route";
    }

    @Override // com.baidu.swan.apps.m.a.a
    public String ev(String str) {
        String str2 = (com.baidu.swan.apps.m.a.n(str, "fromId", this.awn) + com.baidu.swan.apps.m.a.n(str, "toId", this.awo)) + com.baidu.swan.apps.m.a.n(str, "toTabIndex", this.awq);
        if (!TextUtils.isEmpty(this.arA)) {
            str2 = str2 + com.baidu.swan.apps.m.a.n(str, "routeType", this.arA);
        }
        if (!TextUtils.isEmpty(this.awp)) {
            return str2 + com.baidu.swan.apps.m.a.n(str, "toPage", this.awp);
        }
        return str2;
    }
}
