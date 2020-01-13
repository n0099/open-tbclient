package com.baidu.swan.apps.n.a;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class e extends a {
    public String bjY;
    public String bqj;
    public String bqk;
    public String bql;
    public String bqm;

    public e() {
        this.bqi = "route";
    }

    @Override // com.baidu.swan.apps.n.a.a
    public String hu(String str) {
        String str2 = (com.baidu.swan.apps.n.a.r(str, "fromId", this.bqj) + com.baidu.swan.apps.n.a.r(str, "toId", this.bqk)) + com.baidu.swan.apps.n.a.r(str, "toTabIndex", this.bqm);
        if (!TextUtils.isEmpty(this.bjY)) {
            str2 = str2 + com.baidu.swan.apps.n.a.r(str, "routeType", this.bjY);
        }
        if (!TextUtils.isEmpty(this.bql)) {
            return str2 + com.baidu.swan.apps.n.a.r(str, "toPage", this.bql);
        }
        return str2;
    }
}
