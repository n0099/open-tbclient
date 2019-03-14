package com.baidu.swan.apps.m.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class e extends a {
    public String aqN;
    public String avl;
    public String avm;
    public String avn;
    public String avo;

    public e() {
        this.avj = "route";
    }

    @Override // com.baidu.swan.apps.m.a.a
    public String eB(String str) {
        String str2 = (com.baidu.swan.apps.m.a.n(str, "fromId", this.avl) + com.baidu.swan.apps.m.a.n(str, "toId", this.avm)) + com.baidu.swan.apps.m.a.n(str, "toTabIndex", this.avo);
        if (!TextUtils.isEmpty(this.aqN)) {
            str2 = str2 + com.baidu.swan.apps.m.a.n(str, "routeType", this.aqN);
        }
        if (!TextUtils.isEmpty(this.avn)) {
            return str2 + com.baidu.swan.apps.m.a.n(str, "toPage", this.avn);
        }
        return str2;
    }
}
