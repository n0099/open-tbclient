package com.baidu.swan.apps.n.a;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class e extends a {
    public String boi;
    public String but;
    public String buu;
    public String buv;
    public String buw;

    public e() {
        this.bus = "route";
    }

    @Override // com.baidu.swan.apps.n.a.a
    public String hJ(String str) {
        String str2 = (com.baidu.swan.apps.n.a.s(str, "fromId", this.but) + com.baidu.swan.apps.n.a.s(str, "toId", this.buu)) + com.baidu.swan.apps.n.a.s(str, "toTabIndex", this.buw);
        if (!TextUtils.isEmpty(this.boi)) {
            str2 = str2 + com.baidu.swan.apps.n.a.s(str, "routeType", this.boi);
        }
        if (!TextUtils.isEmpty(this.buv)) {
            return str2 + com.baidu.swan.apps.n.a.s(str, "toPage", this.buv);
        }
        return str2;
    }
}
