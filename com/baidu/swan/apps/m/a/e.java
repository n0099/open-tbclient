package com.baidu.swan.apps.m.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class e extends a {
    public String aKX;
    public String aPI;
    public String aPJ;
    public String aPK;
    public String aPL;

    public e() {
        this.aPG = "route";
    }

    @Override // com.baidu.swan.apps.m.a.a
    public String fe(String str) {
        String str2 = (com.baidu.swan.apps.m.a.r(str, "fromId", this.aPI) + com.baidu.swan.apps.m.a.r(str, "toId", this.aPJ)) + com.baidu.swan.apps.m.a.r(str, "toTabIndex", this.aPL);
        if (!TextUtils.isEmpty(this.aKX)) {
            str2 = str2 + com.baidu.swan.apps.m.a.r(str, "routeType", this.aKX);
        }
        if (!TextUtils.isEmpty(this.aPK)) {
            return str2 + com.baidu.swan.apps.m.a.r(str, "toPage", this.aPK);
        }
        return str2;
    }
}
