package com.baidu.swan.apps.n.a;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class e extends a {
    public String bok;
    public String buv;
    public String buw;
    public String bux;
    public String buy;

    public e() {
        this.buu = "route";
    }

    @Override // com.baidu.swan.apps.n.a.a
    public String hJ(String str) {
        String str2 = (com.baidu.swan.apps.n.a.s(str, "fromId", this.buv) + com.baidu.swan.apps.n.a.s(str, "toId", this.buw)) + com.baidu.swan.apps.n.a.s(str, "toTabIndex", this.buy);
        if (!TextUtils.isEmpty(this.bok)) {
            str2 = str2 + com.baidu.swan.apps.n.a.s(str, "routeType", this.bok);
        }
        if (!TextUtils.isEmpty(this.bux)) {
            return str2 + com.baidu.swan.apps.n.a.s(str, "toPage", this.bux);
        }
        return str2;
    }
}
