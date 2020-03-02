package com.baidu.swan.apps.n.a;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class e extends a {
    public String boj;
    public String buu;
    public String buv;
    public String buw;
    public String bux;

    public e() {
        this.but = "route";
    }

    @Override // com.baidu.swan.apps.n.a.a
    public String hJ(String str) {
        String str2 = (com.baidu.swan.apps.n.a.s(str, "fromId", this.buu) + com.baidu.swan.apps.n.a.s(str, "toId", this.buv)) + com.baidu.swan.apps.n.a.s(str, "toTabIndex", this.bux);
        if (!TextUtils.isEmpty(this.boj)) {
            str2 = str2 + com.baidu.swan.apps.n.a.s(str, "routeType", this.boj);
        }
        if (!TextUtils.isEmpty(this.buw)) {
            return str2 + com.baidu.swan.apps.n.a.s(str, "toPage", this.buw);
        }
        return str2;
    }
}
